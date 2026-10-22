package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class UnredactedDebugFormatForTest {
    private UnredactedDebugFormatForTest() {
    }

    public static String unredactedMultilineString(MessageOrBuilder r10) {
        return TextFormat.printer().printToString(r10, TextFormat.Printer.FieldReporterLevel.TEXT_GENERATOR);
    }

    public static String unredactedMultilineString(UnknownFieldSet r10) {
        return TextFormat.printer().printToString(r10);
    }

    public static String unredactedSingleLineString(MessageOrBuilder r10) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r10, TextFormat.Printer.FieldReporterLevel.TEXT_GENERATOR);
    }

    public static String unredactedSingleLineString(UnknownFieldSet r10) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r10);
    }

    public static String unredactedStringValueOf(Object r10) {
        return LegacyUnredactedTextFormat.legacyUnredactedStringValueOf(r10);
    }

    public static String unredactedToString(Object r10) {
        return LegacyUnredactedTextFormat.legacyUnredactedToString(r10);
    }
}
