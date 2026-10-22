package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class LegacyUnredactedTextFormat {
    private LegacyUnredactedTextFormat() {
    }

    static /* synthetic */ void lambda$legacyUnredactedToString$0(String[] r1, Object r2) {
        r1[0] = r2.toString();
    }

    public static String legacyUnredactedMultilineString(MessageOrBuilder r2) {
        MessageOrBuilder r3 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r2, MessageOrBuilder.class, "com.obric.memorydata.plugin");
        return TextFormat.printer().printToString(r3, TextFormat.Printer.FieldReporterLevel.LEGACY_MULTILINE);
    }

    public static String legacyUnredactedMultilineString(UnknownFieldSet r1) {
        return TextFormat.printer().printToString(r1);
    }

    public static String legacyUnredactedSingleLineString(MessageOrBuilder r2) {
        MessageOrBuilder r3 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r2, MessageOrBuilder.class, "com.obric.memorydata.plugin");
        return TextFormat.printer().emittingSingleLine(true).printToString(r3, TextFormat.Printer.FieldReporterLevel.LEGACY_SINGLE_LINE);
    }

    public static String legacyUnredactedSingleLineString(UnknownFieldSet r2) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r2);
    }

    public static String legacyUnredactedStringValueOf(Object r0) {
        if (r0 != null) goto L5;
        return String.valueOf(r0);
    L5:
        return legacyUnredactedToString(r0);
    }

    public static String legacyUnredactedToString(final Object r2) {
        final String[] r0 = new String[1];
        ProtobufToStringOutput.callWithTextFormat(new $$Lambda$LegacyUnredactedTextFormat$_s53T40EVaJfk828AXByMLPZuZY(r0, r2));
        return r0[0];
    }
}
