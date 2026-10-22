package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;

    public s(MultiLinkVoiceChatFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        MultiLinkVoiceChatFeedView r0 = this.a;
        int r1 = MultiLinkVoiceChatFeedView.P1;
        r0.getClass();
        List r12 = (List) r11;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r3 = r12.iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        ch0.e r4 = (ch0.e) r3.next();
        if (r4 == null) goto L12;
        ILinkPlayerInfoBridge r5 = r4.a;
        if (r5 == null) goto L12;
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L12;
        String r7 = r6.getIdString();
    L13:
        r2.add(r7);
    L12:
        r7 = null;
        goto L13
    L14:
        ArrayList r8 = new ArrayList();
        Iterator<Map.Entry<String, Boolean>> r9 = r0.b1.entrySet().iterator();
    L16:
        if (r9.hasNext() == false) goto L20;
        Map.Entry<String, Boolean> r10 = r9.next();
        if (r2.contains(r10.getKey()) == true) goto L16;
        r8.add(r10.getKey());
        goto L16
    L20:
        Iterator r13 = r8.iterator();
    L22:
        if (r13.hasNext() == false) goto L24;
        r0.b1.remove((String) r13.next());
        goto L22
    L24:
        JsonArray r14 = new JsonArray();
        Iterator<T> r15 = r12.iterator();
        boolean r16 = false;
    L26:
        if (r15.hasNext() == false) goto L33;
        ch0.e r17 = (ch0.e) r15.next();
        String r18 = r17.a.getMInteractIdStr();
        if (r18 != null) goto L30;
        r18 = "";
    L30:
        Boolean r19 = r0.b1.get(r18);
        boolean r20 = ch0.f.a(r17);
        JsonObject r21 = new JsonObject();
        r21.addProperty("linkmic_id_str", r17.a.getMInteractIdStr());
        r21.addProperty("is_speaking", Boolean.valueOf(r20));
        r14.add(r21);
        if ((!Intrinsics.areEqual(r19, Boolean.valueOf(r20))) == false) goto L26;
        r0.b1.put(r18, Boolean.valueOf(r20));
        r16 = true;
        goto L26
    L33:
        if (r16 == false) goto L53;
        JsonObject r110 = new JsonObject();
        r110.add("sei_infos", r14);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r22 = r0.x1;
        if (r22 == null) goto L37;
        r22.Dk("seat", "seat_frequent", r110, false);
    L37:
        System.currentTimeMillis();
        return;
    }
}
