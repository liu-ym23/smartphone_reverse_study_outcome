package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g extends jc8.a implements gb8.g {
    public final String g() {
        return "DeepThinkBlockBizModel";
    }

    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.A;
    }

    public final boolean b(boolean r2) {
        if (com.larus.im.bean.message.a.f0(j()) == true) goto L5;
    L9:
        return false;
    L5:
        if (((jc8.a) this).a.isFinish() == true) goto L9;
        if (j().getMessageStatusLocal() == 23) goto L9;
        return true;
    }

    public final boolean e(jc8.a r7) {
        if ((r7 instanceof g) == true) goto L5;
        return false;
    L5:
        Map r0 = j().getExt();
        if (r0 == null) goto L8;
        String r1 = (String) r0.get("need_lazy_load");
    L9:
        g r8 = (g) r7;
        Map r4 = r8.j().getExt();
        if (r4 == null) goto L12;
        String r2 = (String) r4.get("need_lazy_load");
    L14:
        if (Intrinsics.areEqual(r1, r2) == true) goto L17;
        return false;
    L17:
        if (((jc8.a) this).a.isFinish() == true) goto L19;
        return false;
    L19:
        List r3 = i();
        List r9 = r8.i();
        if (r3.size() == r9.size()) goto L22;
        return false;
    L22:
        int r5 = CollectionsKt.getLastIndex(r3);
    L23:
        boolean r6 = true;
        if ((-1) >= r5) goto L47;
        jc8.a r10 = (jc8.a) CollectionsKt.getOrNull(r9, r5);
        if (r10 == null) goto L32;
        Block r11 = r10.a;
        if (r11 == null) goto L32;
        if (r11.isFinish() == true) goto L32;
    L33:
        if (r6 == true) goto L46;
        jc8.a r12 = (jc8.a) CollectionsKt.getOrNull(r3, r5);
        if (r12 == null) goto L37;
        Integer r13 = Integer.valueOf(r12.hashCode());
    L38:
        jc8.a r14 = (jc8.a) CollectionsKt.getOrNull(r9, r5);
        if (r14 == null) goto L41;
        Integer r15 = Integer.valueOf(r14.hashCode());
    L43:
        if (Intrinsics.areEqual(r13, r15) == false) goto L46;
        r5 = r5 - 1;
        goto L23
    L41:
        r15 = null;
        goto L43
    L37:
        r13 = null;
    L46:
        return false;
    L32:
        r6 = false;
        goto L33
    L47:
        return true;
    L12:
        r2 = null;
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    public g(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
