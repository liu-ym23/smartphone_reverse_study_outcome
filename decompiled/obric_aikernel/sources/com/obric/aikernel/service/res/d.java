package com.obric.aikernel.service.res;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5520a = null;

    static {
        f5520a = new d();
    }

    private d() {
    }

    private final b b(List<String> r12) {
        boolean r11 = true;
        String r10 = (String) CollectionsKt.getOrNull(r12, 1);
        if (r10 == null) goto L28;
        int r13 = r10.hashCode();
        if (r13 == 3569038) goto L19;
        if (r13 == 94746189) goto L15;
        if (r13 != 97196323) goto L28;
        if (r10.equals("false") == false) goto L28;
    L21:
        boolean r14 = StringsKt.toBooleanStrict(r12.get(1));
        String r15 = CollectionsKt.joinToString$default(CollectionsKt.drop(r12, 2), " ", null, null, 0, null, null, 62, null);
        if (r15.length() == 0) goto L25;
        r11 = false;
    L25:
        if (r11 == false) goto L31;
        r15 = "debug override";
    L31:
        return new b.C0121b(new e(r14, r15));
    L15:
        if (r10.equals("clear") == false) goto L28;
        return b.a.f5517a;
    L19:
        if (r10.equals("true") == true) goto L21;
    L28:
        return null;
    }

    public final b a(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        String r11 = (String) CollectionsKt.firstOrNull(r10);
        if (Intrinsics.areEqual(r11, "background_override") == false) goto L6;
        return b(r10);
    L6:
        if (Intrinsics.areEqual(r11, "trigger_auto_update") == false) goto L14;
        boolean r12 = true;
        String r13 = CollectionsKt.joinToString$default(CollectionsKt.drop(r10, 1), " ", null, null, 0, null, null, 62, null);
        if (r13.length() == 0) goto L11;
        r12 = false;
    L11:
        if (r12 == false) goto L17;
        r13 = "debug trigger";
    L17:
        return new b.c(r13);
    L14:
        return null;
    }
}
