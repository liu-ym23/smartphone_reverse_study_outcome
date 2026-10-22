package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nutfEncoding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utfEncoding.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/UtfEncodingKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n37#2,2:74\n1#3:76\n*S KotlinDebug\n*F\n+ 1 utfEncoding.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/UtfEncodingKt\n*L\n55#1:74,2\n*E\n"})
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "strings");
        int r5 = r10.length;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r5) goto L5;
        r12 = r12 + r10[r11].length();
        r11 = r11 + 1;
        goto L3
    L5:
        byte[] r13 = new byte[r12];
        int r14 = r10.length;
        int r15 = 0;
        int r16 = 0;
    L6:
        if (r15 >= r14) goto L11;
        String r17 = r10[r15];
        int r18 = r17.length();
        int r19 = 0;
    L8:
        if (r19 >= r18) goto L10;
        r13[r16] = (byte) r17.charAt(r19);
        r19 = r19 + 1;
        r16 = r16 + 1;
        goto L8
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r13;
    }
}
