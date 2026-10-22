package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class DebugFormat {
    private final boolean isSingleLine;

    private static class LazyDebugOutput {
        private final UnknownFieldSet fields;
        private final DebugFormat format;
        private final MessageOrBuilder message;

        LazyDebugOutput(MessageOrBuilder r10, DebugFormat r11) {
            this.message = r10;
            this.fields = null;
            this.format = r11;
        }

        LazyDebugOutput(UnknownFieldSet r10, DebugFormat r11) {
            this.message = null;
            this.fields = r10;
            this.format = r11;
        }

        public String toString() {
            MessageOrBuilder r10 = this.message;
            if (r10 == null) goto L7;
            return this.format.toString(r10);
        L7:
            return this.format.toString(this.fields);
        }
    }

    private DebugFormat(boolean r10) {
        this.isSingleLine = r10;
    }

    public static DebugFormat multiline() {
        return new DebugFormat(false);
    }

    public static DebugFormat singleLine() {
        return new DebugFormat(true);
    }

    public Object lazyToString(MessageOrBuilder r10) {
        return new LazyDebugOutput(r10, this);
    }

    public Object lazyToString(UnknownFieldSet r10) {
        return new LazyDebugOutput(r10, this);
    }

    public String toString(Descriptors.FieldDescriptor r10, Object r11) {
        if (this.isSingleLine == true) goto L7;
        TextFormat.Printer r12 = TextFormat.debugFormatPrinter();
    L6:
        return r12.printFieldToString(r10, r11);
    L7:
        r12 = TextFormat.debugFormatPrinter().emittingSingleLine(this.isSingleLine);
        goto L6
    }

    public String toString(MessageOrBuilder r10) {
        if (this.isSingleLine == true) goto L7;
        TextFormat.Printer r11 = TextFormat.debugFormatPrinter();
        TextFormat.Printer.FieldReporterLevel r12 = TextFormat.Printer.FieldReporterLevel.DEBUG_MULTILINE;
    L6:
        return r11.printToString(r10, r12);
    L7:
        r11 = TextFormat.debugFormatPrinter().emittingSingleLine(this.isSingleLine);
        r12 = TextFormat.Printer.FieldReporterLevel.DEBUG_SINGLE_LINE;
        goto L6
    }

    public String toString(UnknownFieldSet r10) {
        if (this.isSingleLine == true) goto L7;
        TextFormat.Printer r11 = TextFormat.debugFormatPrinter();
    L6:
        return r11.printToString(r10);
    L7:
        r11 = TextFormat.debugFormatPrinter().emittingSingleLine(this.isSingleLine);
        goto L6
    }
}
