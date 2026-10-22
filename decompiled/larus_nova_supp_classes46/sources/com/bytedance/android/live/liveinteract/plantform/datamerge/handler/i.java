package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public boolean b;
    public boolean c;
    public Boolean d;
    public pf0.a e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        this.c = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.c = false;
        this.b = true;
        this.d = null;
        this.e = null;
        c();
    }

    public i() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r11) {
        Intrinsics.checkNotNullParameter(r11, "oldMergeDataList");
        List<ch0.e> r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
        ch0.e r2 = null;
    L4:
        if (r13.hasNext() == false) goto L65;
        ch0.e r3 = (ch0.e) r13.next();
        HashMap r8 = new HashMap(r3.d);
        IBaseUser r4 = r3.a.getUser();
        if (r4 == null) goto L8;
        String r5 = r4.getIdString();
    L9:
        if (r5 == null) goto L11;
        InteractiveSongContext.Companion.a(r5);
    L11:
        Boolean r6 = this.d;
        if (r6 == null) goto L14;
        r8.put("EXT_KEY_UPDATE_INTERACT_SONG_SHOW_GOLDEN_MIC", Boolean.valueOf(r6.booleanValue()));
    L14:
        Object r7 = r8.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO_LIST");
        if (TypeIntrinsics.isMutableList(r7) == true) goto L17;
        r7 = null;
    L17:
        List r9 = (List) r7;
        StringBuilder r10 = new StringBuilder("micInfo = ");
        r10.append(this.e);
        r10.append(", currentUserId == micInfo?.userId = ");
        pf0.a r14 = this.e;
        if (r14 == null) goto L20;
        String r15 = r14.a;
    L21:
        r10.append(Intrinsics.areEqual(r5, r15));
        r10.append(" micInfo?.action: ");
        pf0.a r16 = this.e;
        if (r16 == null) goto L24;
        Integer r17 = r16.c;
    L25:
        r10.append(r17);
        r10.append("  update list size: ");
        if (r9 == null) goto L28;
        Integer r18 = Integer.valueOf(r9.size());
    L29:
        r10.append(r18);
        ALogger.d("InteractiveSongDataHandler", r10.toString());
        pf0.a r19 = this.e;
        if (r19 != null) goto L32;
    L33:
        pf0.a r20 = this.e;
        if (r20 == null) goto L36;
        Integer r21 = r20.c;
    L37:
        if (r21 != null) goto L40;
    L41:
        r8.put("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO", this.e);
        if (r9 == null) goto L44;
    L46:
        pf0.a r22 = this.e;
        if (r22 == null) goto L51;
        if (r9 == null) goto L51;
        r9.add(r22);
    L51:
        if (this.b == false) goto L55;
        if (r9 == null) goto L54;
        r9.clear();
    L54:
        r8.put("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO_LIST", null);
    L55:
        ch0.e r23 = ch0.e.a(r3, null, null, null, r8, 7);
        IBaseUser r24 = r23.a.getUser();
        if (r24 == null) goto L58;
        String r25 = r24.getIdString();
    L60:
        if (Intrinsics.areEqual(r25, gh0.a.c()) == false) goto L63;
        if (r23 == r3) goto L63;
        r2 = r23;
    L63:
        r0.add(r23);
        goto L4
    L58:
        r25 = null;
        goto L60
    L44:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 28) goto L46;
        r9 = new ArrayList();
        r8.put("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO_LIST", r9);
        goto L46
    L40:
        if (r21.intValue() == 0) goto L51;
    L36:
        r21 = null;
        goto L37
    L32:
        if (Intrinsics.areEqual(r5, r19.a) == true) goto L41;
    L28:
        r18 = null;
        goto L29
    L24:
        r17 = null;
        goto L25
    L20:
        r15 = null;
        goto L21
    L8:
        r5 = null;
        goto L9
    L65:
        return new h.a(true, r0, r2);
    }

    public final void d(boolean r5) {
        wg0.a r0 = (wg0.a) a().b().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        wg0.a r6 = wg0.a.a(r0, false, null, r5, 3);
        a().c(r6);
    }
}
