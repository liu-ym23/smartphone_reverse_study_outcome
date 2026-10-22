package vt8;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements d {
    public e() {
    }

    @Override // vt8.d
    public final int b() {
        return 3;
    }

    @Override // vt8.d
    public final Pair<Integer, Integer> a(String r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "txt");
        int r0 = r13;
    L4:
        if (r0 <= 0) goto L9;
        int r2 = r0 - 1;
        if (r12.charAt(r2) == '\n') goto L9;
        r0 = r2;
    L9:
        if (r13 >= r12.length()) goto L13;
        if (r12.charAt(r13) == '\n') goto L13;
        r13 = r13 + 1;
    L13:
        String r3 = r12.substring(r0, r13);
        boolean r4 = false;
        int r5 = 0;
    L14:
        boolean r6 = true;
        if (r5 >= r3.length()) goto L25;
        char r7 = r3.charAt(r5);
        if (CharsKt.isWhitespace(r7) == false) goto L19;
    L22:
        if (r6 == false) goto L26;
        r5 = r5 + 1;
    L26:
        if (r4 == false) goto L35;
        if (r0 <= 0) goto L35;
        int r14 = r0 - 1;
    L29:
        if (r14 <= 0) goto L33;
        int r8 = r14 - 1;
        if (r12.charAt(r8) == '\n') goto L33;
        r14 = r8;
    L33:
        int r10 = r0;
        r0 = r14;
        r13 = r10;
    L35:
        return TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r13));
    L19:
        if (CollectionsKt.listOf(new Character[]{(char) 8203, (char) 8204, (char) 8205}).contains(Character.valueOf(r7)) == true) goto L22;
        r6 = false;
        goto L22
    L25:
        r4 = true;
        goto L26
    }
}
