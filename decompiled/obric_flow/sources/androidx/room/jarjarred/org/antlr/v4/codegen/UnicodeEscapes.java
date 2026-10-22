package androidx.room.jarjarred.org.antlr.v4.codegen;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnicodeEscapes {
    public UnicodeEscapes() {
    }

    public static void appendJavaStyleEscapedCodePoint(int r5, StringBuilder r10) {
        if (Character.isSupplementaryCodePoint(r5) == false) goto L5;
        r10.append(String.format("\\u%04X", new Object[]{Integer.valueOf(Character.highSurrogate(r5))}));
        r10.append(String.format("\\u%04X", new Object[]{Integer.valueOf(Character.lowSurrogate(r5))}));
        return;
    L5:
        r10.append(String.format("\\u%04X", new Object[]{Integer.valueOf(r5)}));
    }

    public static void appendPythonStyleEscapedCodePoint(int r5, StringBuilder r10) {
        if (Character.isSupplementaryCodePoint(r5) == false) goto L5;
        r10.append(String.format("\\U%08X", new Object[]{Integer.valueOf(r5)}));
        return;
    L5:
        r10.append(String.format("\\u%04X", new Object[]{Integer.valueOf(r5)}));
    }

    public static void appendSwiftStyleEscapedCodePoint(int r5, StringBuilder r10) {
        r10.append(String.format("\\u{%04X}", new Object[]{Integer.valueOf(r5)}));
    }
}
