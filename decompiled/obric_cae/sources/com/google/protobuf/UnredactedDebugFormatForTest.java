package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class UnredactedDebugFormatForTest {
    private UnredactedDebugFormatForTest() {
    }

    public static String unredactedMultilineString(MessageOrBuilder r8) {
        return TextFormat.printer().printToString(r8, TextFormat.Printer.FieldReporterLevel.TEXT_GENERATOR);
    }

    public static String unredactedSingleLineString(MessageOrBuilder r8) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r8, TextFormat.Printer.FieldReporterLevel.TEXT_GENERATOR);
    }

    public static String unredactedStringValueOf(Object r8) {
        return LegacyUnredactedTextFormat.legacyUnredactedStringValueOf(r8);
    }

    public static String unredactedToString(Object r8) {
        return LegacyUnredactedTextFormat.legacyUnredactedToString(r8);
    }

    public static String[] unredactedToStringArray(Object[] r8) {
        return LegacyUnredactedTextFormat.legacyUnredactedToStringArray(r8);
    }

    public static Iterable<String> unredactedToStringList(Iterable<?> r8) {
        return LegacyUnredactedTextFormat.legacyUnredactedToStringList(r8);
    }

    public static String unredactedMultilineString(UnknownFieldSet r8) {
        return TextFormat.printer().printToString(r8);
    }

    public static String unredactedSingleLineString(UnknownFieldSet r8) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r8);
    }
}
