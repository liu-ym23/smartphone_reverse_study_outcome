package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionStatus;
import com.bytedance.android.livesdk.chatroom.model.interact.n1;
import com.bytedance.android.livesdk.message.model.fa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0 extends a {
    public boolean b;
    public boolean c;
    public fa d;
    public Map<String, n1> e;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        this.b = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.b = false;
    }

    public i0() {
        ThemedCompetitionStatus.UNKNOWN.getValue();
        this.e = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r14) {
        Intrinsics.checkNotNullParameter(r14, "oldMergeDataList");
        List<ch0.e> r15 = r14;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
        ch0.e r4 = null;
        boolean r3 = false;
    L4:
        if (r16.hasNext() == false) goto L57;
        ch0.e r5 = (ch0.e) r16.next();
        IBaseUser r6 = r5.a.getUser();
        if (r6 == null) goto L8;
        String r7 = r6.getIdString();
    L9:
        fa r8 = this.d;
        if (r8 == null) goto L12;
        String r9 = r8.getScoreChangeUserIdStr();
    L13:
        boolean r12 = true;
        if (Intrinsics.areEqual(r7, r9) == false) goto L30;
        HashMap r10 = new HashMap();
        r10.putAll(r5.d);
        r10.put("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_CONTENT", this.d);
        Map<String, n1> r11 = this.e;
        IBaseUser r13 = r5.a.getUser();
        if (r13 == null) goto L18;
        String r17 = r13.getIdString();
    L19:
        if (r11 == null) goto L29;
        if (r11.containsKey(r17) == false) goto L27;
        Map<String, n1> r18 = this.e;
        IBaseUser r19 = r5.a.getUser();
        if (r19 == null) goto L25;
        String r20 = r19.getIdString();
    L26:
        r10.put("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_WIN_TYPE", ((LinkedHashMap) r18).get(r20));
        goto L27
    L25:
        r20 = null;
    L27:
        r10.remove("EXT_KEY_UPDATE_THEME_COMPETITION_OPEN_STATUS_CHANGE");
        ch0.e r21 = ch0.e.a(r5, null, null, null, r10, 7);
    L46:
        IBaseUser r22 = r21.a.getUser();
        if (r22 == null) goto L49;
        String r23 = r22.getIdString();
    L51:
        if (Intrinsics.areEqual(r23, gh0.a.c()) == false) goto L54;
        if (r21 == r5) goto L54;
        r4 = r21;
    L54:
        r0.add(r21);
        r3 = r12;
        goto L4
    L49:
        r23 = null;
        goto L51
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L18:
        r17 = null;
        goto L19
    L30:
        Map<String, n1> r24 = this.e;
        IBaseUser r110 = r5.a.getUser();
        if (r110 == null) goto L33;
        String r111 = r110.getIdString();
    L34:
        if (r24 == null) goto L56;
        if (r24.containsKey(r111) == false) goto L43;
        HashMap r25 = new HashMap();
        r25.putAll(r5.d);
        Map<String, n1> r26 = this.e;
        IBaseUser r27 = r5.a.getUser();
        if (r27 == null) goto L40;
        String r28 = r27.getIdString();
    L41:
        r25.put("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_WIN_TYPE", ((LinkedHashMap) r26).get(r28));
        r25.remove("EXT_KEY_UPDATE_THEME_COMPETITION_OPEN_STATUS_CHANGE");
        r21 = ch0.e.a(r5, null, null, null, r25, 7);
        goto L46
    L40:
        r28 = null;
        goto L41
    L43:
        if (this.c == false) goto L45;
        HashMap r29 = new HashMap();
        r29.putAll(r5.d);
        r29.put("EXT_KEY_UPDATE_THEME_COMPETITION_OPEN_STATUS_CHANGE", Boolean.valueOf(this.c));
        r29.put("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_CONTENT", null);
        r29.put("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_WIN_TYPE", null);
        r21 = ch0.e.a(r5, null, null, null, r29, 7);
        goto L46
    L45:
        r12 = r3;
        r21 = r5;
        goto L46
    L56:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L33:
        r111 = null;
        goto L34
    L12:
        r9 = null;
        goto L13
    L8:
        r7 = null;
        goto L9
    L57:
        this.c = false;
        return new h.a(r3, r0, r4);
    }
}
