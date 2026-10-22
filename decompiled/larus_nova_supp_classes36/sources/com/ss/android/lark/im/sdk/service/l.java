package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.basic.v1.OpenApp;
import com.bytedance.lark.pb.im.v1.GetChatChattersByIdsResponse;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l<T, R> implements Function {
    public final /* synthetic */ String a;

    public l(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        com.bytedance.lark.rustclient.api.x r8 = (com.bytedance.lark.rustclient.api.x) r7;
        Intrinsics.checkNotNullParameter(r8, "it");
        Collection r0 = ((HashMap) com.ss.android.lark.parser.internal.j.b(((GetChatChattersByIdsResponse) r8.c).entity, this.a).c()).values();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        ChatChatter r3 = (ChatChatter) r2.next();
        String r4 = r3.getOpenAppId();
        OpenApp r5 = (OpenApp) ((GetChatChattersByIdsResponse) r8.c).entity.open_apps.get(r4);
        if (r5 == null) goto L8;
        com.ss.android.lark.biz.im.api.OpenApp r6 = com.ss.android.lark.parser.internal.h.c(r5);
    L9:
        r1.add(TuplesKt.to(r3, r6));
        goto L4
    L8:
        r6 = null;
        goto L9
    L10:
        LinkedHashMap r9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r10 = r1.iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        Object r11 = r10.next();
        r9.put(((ChatChatter) ((Pair) r11).getFirst()).getId(), r11);
        goto L12
    L14:
        return r9;
    }
}
