package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class DebugFormat {
    private final boolean isSingleLine;

    private static class LazyDebugOutput {
        private final UnknownFieldSet fields;
        private final DebugFormat format;
        private final MessageOrBuilder message;

        LazyDebugOutput(MessageOrBuilder r3, DebugFormat r4) {
            this.message = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.memorydata.plugin");
            this.fields = null;
            this.format = r4;
        }

        LazyDebugOutput(UnknownFieldSet r2, DebugFormat r3) {
            this.message = null;
            this.fields = r2;
            this.format = r3;
        }

        public String toString() {
            MessageOrBuilder r0 = this.message;
            if (r0 == null) goto L7;
            return this.format.toString(r0);
        L7:
            return this.format.toString(this.fields);
        }
    }

    private DebugFormat(boolean r1) {
        this.isSingleLine = r1;
    }

    public static DebugFormat multiline() {
        return new DebugFormat(false);
    }

    public static DebugFormat singleLine() {
        return new DebugFormat(true);
    }

    public Object lazyToString(MessageOrBuilder r3) {
        return new LazyDebugOutput((MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.memorydata.plugin"), this);
    }

    public Object lazyToString(UnknownFieldSet r2) {
        return new LazyDebugOutput(r2, this);
    }

    public String toString(Descriptors.FieldDescriptor r2, Object r3) {
        if (this.isSingleLine == true) goto L7;
        TextFormat.Printer r1 = TextFormat.debugFormatPrinter();
    L6:
        return r1.printFieldToString(r2, r3);
    L7:
        r1 = TextFormat.debugFormatPrinter().emittingSingleLine(this.isSingleLine);
        goto L6
    }

    public String toString(MessageOrBuilder r3) {
        MessageOrBuilder r4 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.memorydata.plugin");
        if (this.isSingleLine == true) goto L7;
        TextFormat.Printer r2 = TextFormat.debugFormatPrinter();
        TextFormat.Printer.FieldReporterLevel r0 = TextFormat.Printer.FieldReporterLevel.DEBUG_MULTILINE;
    L6:
        return r2.printToString(r4, r0);
    L7:
        r2 = TextFormat.debugFormatPrinter().emittingSingleLine(this.isSingleLine);
        r0 = TextFormat.Printer.FieldReporterLevel.DEBUG_SINGLE_LINE;
        goto L6
    }

    public String toString(UnknownFieldSet r2) {
        if (this.isSingleLine == true) goto L7;
        TextFormat.Printer r1 = TextFormat.debugFormatPrinter();
    L6:
        return r1.printToString(r2);
    L7:
        r1 = TextFormat.debugFormatPrinter().emittingSingleLine(this.isSingleLine);
        goto L6
    }
}
