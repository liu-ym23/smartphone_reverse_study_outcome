package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public com.bytedance.android.live.liveinteract.hamlet.model.l b;
    public Boolean c;
    public Boolean d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.b = null;
        this.c = null;
        this.d = null;
        c();
    }

    public g() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r11) {
        Intrinsics.checkNotNullParameter(r11, "oldMergeDataList");
        List<ch0.e> r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
        ch0.e r2 = null;
    L4:
        if (r13.hasNext() == false) goto L21;
        ch0.e r3 = (ch0.e) r13.next();
        HashMap r8 = new HashMap(r3.d);
        IBaseUser r4 = r3.a.getUser();
        if (r4 == null) goto L8;
        String r5 = r4.getIdString();
    L9:
        if (r5 == null) goto L11;
        InteractiveSongContext.Companion.a(r5);
    L11:
        r8.put("EXT_KEY_UPDATE_HAMLET_AVATAR_POSITION", this.b);
        r8.put("EXT_KEY_UPDATE_HAMLET_AVATAR_RENDING", this.c);
        r8.put("EXT_KEY_UPDATE_REQUEST_SONG_OPEN", this.d);
        ch0.e r6 = ch0.e.a(r3, null, null, null, r8, 7);
        IBaseUser r7 = r6.a.getUser();
        if (r7 == null) goto L14;
        String r9 = r7.getIdString();
    L16:
        if (Intrinsics.areEqual(r9, gh0.a.c()) == false) goto L19;
        if (r6 == r3) goto L19;
        r2 = r6;
    L19:
        r0.add(r6);
        goto L4
    L14:
        r9 = null;
        goto L16
    L8:
        r5 = null;
        goto L9
    L21:
        return new h.a(true, r0, r2);
    }
}
