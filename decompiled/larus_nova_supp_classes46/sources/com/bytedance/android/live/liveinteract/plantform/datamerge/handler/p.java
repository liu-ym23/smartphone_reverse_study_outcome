package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p extends eh0.a {
    public boolean b;
    public Boolean c;

    @Override // eh0.c
    public final void attach() {
        this.b = true;
    }

    @Override // eh0.c
    public final void detach() {
        this.b = false;
    }

    public p() {
    }

    @Override // eh0.a, eh0.c
    public final h.a a(List<ch0.e> r11) {
        Intrinsics.checkNotNullParameter(r11, "oldMergeDataList");
        List<ch0.e> r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
        ch0.e r2 = null;
    L4:
        if (r13.hasNext() == false) goto L18;
        ch0.e r3 = (ch0.e) r13.next();
        HashMap r8 = new HashMap(r3.d);
        Boolean r4 = this.c;
        if (r4 == null) goto L8;
        r8.put("EXT_KEY_UPDATE_INTERACT_SONG_SHOW_GOLDEN_MIC", Boolean.valueOf(r4.booleanValue()));
    L8:
        ch0.e r5 = ch0.e.a(r3, null, null, null, r8, 7);
        IBaseUser r6 = r5.a.getUser();
        if (r6 == null) goto L11;
        String r7 = r6.getIdString();
    L13:
        if (Intrinsics.areEqual(r7, gh0.a.c()) == false) goto L16;
        if (r5 == r3) goto L16;
        r2 = r5;
    L16:
        r0.add(r5);
        goto L4
    L11:
        r7 = null;
        goto L13
    L18:
        return new h.a(true, r0, r2);
    }
}
