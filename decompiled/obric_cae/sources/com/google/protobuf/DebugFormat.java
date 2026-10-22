package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class DebugFormat {
    private final boolean isSingleLine;

    public static class LazyDebugOutput {
        private final UnknownFieldSet fields;
        private final DebugFormat format;
        private final MessageOrBuilder message;

        public LazyDebugOutput(MessageOrBuilder r8, DebugFormat r10) {
            this.message = r8;
            this.fields = null;
            this.format = r10;
        }

        public String toString() {
            MessageOrBuilder r8 = this.message;
            if (r8 == null) goto L7;
            return this.format.toString(r8);
        L7:
            return this.format.toString(this.fields);
        }

        public LazyDebugOutput(UnknownFieldSet r8, DebugFormat r10) {
            this.message = null;
            this.fields = r8;
            this.format = r10;
        }
    }

    private DebugFormat(boolean r8) {
        this.isSingleLine = r8;
    }

    private TextFormat.Printer getPrinter() {
        TextFormat.Printer r8 = TextFormat.debugFormatPrinter();
        if (this.isSingleLine == true) goto L5;
        return r8;
    L5:
        return r8.emittingSingleLine(true);
    }

    public static DebugFormat multiline() {
        return new DebugFormat(false);
    }

    public static DebugFormat singleLine() {
        return new DebugFormat(true);
    }

    public Object lazyToString(MessageOrBuilder r8) {
        return new LazyDebugOutput(r8, this);
    }

    public String toString(Descriptors.FieldDescriptor r8, Object r10) {
        return getPrinter().printFieldToString(r8, r10);
    }

    public Object lazyToString(UnknownFieldSet r8) {
        return new LazyDebugOutput(r8, this);
    }

    public String toString(MessageOrBuilder r8) {
        if (this.isSingleLine == false) goto L5;
        TextFormat.Printer.FieldReporterLevel r10 = TextFormat.Printer.FieldReporterLevel.DEBUG_SINGLE_LINE;
    L7:
        return getPrinter().printToString(r8, r10);
    L5:
        r10 = TextFormat.Printer.FieldReporterLevel.DEBUG_MULTILINE;
        goto L7
    }

    public String toString(UnknownFieldSet r8) {
        return getPrinter().printToString(r8);
    }
}
