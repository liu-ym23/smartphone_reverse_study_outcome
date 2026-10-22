package com.obric.aikernel.runtime;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f5371a = null;

    static {
        f5371a = new f();
    }

    private f() {
    }

    private final e.c b(List<String> r10) {
        String r11 = (String) CollectionsKt.getOrNull(r10, 1);
        if (r11 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r11)) == true) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L25;
        int r12 = r10.size();
        if (r12 != 3) goto L13;
        e.c r13 = new e.c(r11, "", r10.get(2));
    L17:
        if (r13 != null) goto L19;
        return null;
    L19:
        if ((true ^ StringsKt.isBlank(r13.a())) == true) goto L21;
        return null;
    L21:
        return r13;
    L13:
        if (r12 == 4) goto L15;
        r13 = null;
        goto L17
    L15:
        r13 = new e.c(r11, r10.get(2), r10.get(3));
        goto L17
    L25:
        return null;
    }

    public final e a(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        String r11 = (String) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L38;
        int r12 = r11.hashCode();
        if (r12 == (-632373700)) goto L27;
        if (r12 == 546429833) goto L16;
        if (r12 == 1898063526) goto L12;
        return null;
    L12:
        if (r11.equals("update_target_background") == true) goto L39;
        return null;
    L39:
        return b(r10);
    L16:
        if (r11.equals("download_status") == false) goto L45;
        String r13 = (String) CollectionsKt.getOrNull(r10, 1);
        String r14 = "";
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        String r15 = (String) CollectionsKt.getOrNull(r10, 2);
        if (r15 == null) goto L40;
        r14 = r15;
    L40:
        return new e.a(r13, r14);
    L45:
        return null;
    L27:
        if (r11.equals("request_all_background") == false) goto L46;
        String r16 = (String) CollectionsKt.getOrNull(r10, 1);
        if (r16 != null) goto L32;
        return null;
    L32:
        if ((!StringsKt.isBlank(r16)) == true) goto L35;
        r16 = null;
    L35:
        if (r16 != null) goto L37;
        return null;
    L37:
        return new e.b(r16);
    L46:
        return null;
    L38:
        return null;
    }
}
