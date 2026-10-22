package com.larus.video.impl.douyin;

import com.larus.platform.uimodel.MediaEntity;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n {
    public final DouYinVideoDataManager a;
    public final Lazy b;

    public final String a() {
        JSONObject r0 = new JSONObject();
        ArrayList<MediaEntity> r1 = this.a.L;
        ArrayList r3 = null;
        if (r1 == null) goto L12;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        MediaEntity r5 = (MediaEntity) r2.next();
        if (r5 == null) goto L10;
        String r6 = r5.getItem_id();
    L11:
        r4.add(r6);
        goto L6
    L10:
        r6 = null;
    L13:
        r0.put("item_id", r4);
        ArrayList<MediaEntity> r7 = this.a.L;
        if (r7 == null) goto L24;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L17:
        if (r9.hasNext() == false) goto L23;
        MediaEntity r10 = (MediaEntity) r9.next();
        if (r10 == null) goto L21;
        String r11 = r10.getMedia_url();
    L22:
        r8.add(r11);
        goto L17
    L21:
        r11 = null;
        goto L22
    L23:
        r3 = r8;
    L24:
        r0.put("media_url", r3);
        return r0.toString();
    L12:
        r4 = null;
        goto L13
    }

    public n(DouYinVideoDataManager r2) {
        Intrinsics.checkNotNullParameter(r2, "douYinVideoDataManager");
        this.a = r2;
        this.b = LazyKt.lazy(new m());
    }

    public final void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "status");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        String r2 = this.a.D;
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
        if (r2 != null) goto L5;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r1.put("bot_id", r2);
        String r4 = this.a.E;
        if (r4 != null) goto L8;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r1.put("message_id", r4);
        String r5 = this.a.A;
        if (r5 == null) goto L12;
        r3 = r5;
    L12:
        r1.put("conversation_id", r3);
        r1.put("to_status", r6);
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("click_video_player", r1);
    }
}
