package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyUnredactedTextFormat {
    private LegacyUnredactedTextFormat() {
    }

    public static /* synthetic */ void a(String[] r10, Object r11) {
        lambda$legacyUnredactedToString$0(r10, r11);
    }

    private static /* synthetic */ void lambda$legacyUnredactedToString$0(String[] r10, Object r11) {
        r10[0] = r11.toString();
    }

    public static String legacyUnredactedMultilineString(MessageOrBuilder r10) {
        return TextFormat.printer().printToString(r10, TextFormat.Printer.FieldReporterLevel.LEGACY_MULTILINE);
    }

    public static String legacyUnredactedMultilineString(UnknownFieldSet r10) {
        return TextFormat.printer().printToString(r10);
    }

    public static String legacyUnredactedSingleLineString(MessageOrBuilder r10) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r10, TextFormat.Printer.FieldReporterLevel.LEGACY_SINGLE_LINE);
    }

    public static String legacyUnredactedSingleLineString(UnknownFieldSet r10) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r10);
    }

    public static String legacyUnredactedStringValueOf(Object r10) {
        if (r10 != null) goto L5;
        return String.valueOf(r10);
    L5:
        return legacyUnredactedToString(r10);
    }

    public static String legacyUnredactedToString(final Object r10) {
        final String[] r11 = new String[1];
        ProtobufToStringOutput.callWithTextFormat(new a(r11, r10));
        return r11[0];
    }
}
