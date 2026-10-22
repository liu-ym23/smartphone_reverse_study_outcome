package com.google.protobuf;

import androidx.appcompat.app.r;
import androidx.room.l;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/* JADX INFO: loaded from: classes.dex */
public final class LegacyUnredactedTextFormat {
    private LegacyUnredactedTextFormat() {
    }

    public static /* synthetic */ void a(String[] r8, Object r10) {
        lambda$legacyUnredactedToString$0(r8, r10);
    }

    public static /* synthetic */ void b(String[] r8, String r10, Object[] r11) {
        lambda$legacyUnredactedStringFormat$2(r8, r10, r11);
    }

    public static /* synthetic */ String[] c(int r8) {
        return lambda$legacyUnredactedToStringArray$1(r8);
    }

    private static /* synthetic */ void lambda$legacyUnredactedStringFormat$2(String[] r8, String r10, Object[] r11) {
        r8[0] = String.format(r10, r11);
    }

    private static /* synthetic */ void lambda$legacyUnredactedToString$0(String[] r8, Object r10) {
        r8[0] = r10.toString();
    }

    private static /* synthetic */ String[] lambda$legacyUnredactedToStringArray$1(int r8) {
        return new String[r8];
    }

    public static String legacyUnredactedMultilineString(MessageOrBuilder r8) {
        return TextFormat.printer().printToString(r8, TextFormat.Printer.FieldReporterLevel.LEGACY_MULTILINE);
    }

    public static String legacyUnredactedSingleLineString(MessageOrBuilder r8) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r8, TextFormat.Printer.FieldReporterLevel.LEGACY_SINGLE_LINE);
    }

    public static String legacyUnredactedStringFormat(String r8, Object... r10) {
        String[] r11 = new String[1];
        ProtobufToStringOutput.callWithTextFormat(new l(r11, r8, r10, 2));
        return r11[0];
    }

    public static String legacyUnredactedStringValueOf(Object r8) {
        if (r8 != null) goto L5;
        return String.valueOf(r8);
    L5:
        return legacyUnredactedToString(r8);
    }

    public static String legacyUnredactedToString(Object r8) {
        String[] r10 = new String[1];
        ProtobufToStringOutput.callWithTextFormat(new r(9, r10, r8));
        return r10[0];
    }

    @Deprecated
    public static String[] legacyUnredactedToStringArray(Object[] r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        int r10 = 0;
        return (String[]) Arrays.stream(r8).map(new d(r10)).toArray(new e(r10));
    }

    @Deprecated
    public static Iterable<String> legacyUnredactedToStringList(Iterable<?> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        return (Iterable) StreamSupport.stream(r8.spliterator(), false).map(new c(0)).collect(Collectors.toList());
    }

    public static String legacyUnredactedMultilineString(UnknownFieldSet r8) {
        return TextFormat.printer().printToString(r8);
    }

    public static String legacyUnredactedSingleLineString(UnknownFieldSet r8) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r8);
    }
}
