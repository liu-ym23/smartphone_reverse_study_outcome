package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.k5;
import com.bytedance.android.livesdk.message.model.dm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0 {
    public static final s a(dm r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$convert2Model");
        s r0 = new s();
        r0.a = r7.getComponentType();
        String r2 = "";
        if (TextUtils.isEmpty(r7.getText()) == true) goto L9;
        String r1 = r7.getText();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
    L9:
        if (TextUtils.isEmpty(r7.getSchema()) == true) goto L14;
        String r3 = r7.getSchema();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.e = r3;
    L14:
        r0.c = r7.getIcon();
        String r4 = r7.getExtraData();
        if (r4 == null) goto L18;
        r2 = r4;
    L18:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.d = r2;
        r0.f = r7.getGroupId();
        r0.l.b = true;
        r0.g = (int) r7.getShowType();
        List r5 = r7.getLowList();
        ArrayList r6 = null;
        if (r5 == null) goto L24;
        List r8 = r5;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L22:
        if (r10.hasNext() == false) goto L25;
        k5 r11 = (k5) r10.next();
        e0 r12 = new e0();
        r11.getId();
        r11.getAnchorOpType();
        r11.getAudienceOpType();
        r9.add(r12);
    L25:
        r0.k = r9;
        List r13 = r7.getHighList();
        if (r13 == null) goto L31;
        List r14 = r13;
        r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L29:
        if (r15.hasNext() == false) goto L31;
        k5 r16 = (k5) r15.next();
        e0 r17 = new e0();
        r16.getId();
        r16.getAnchorOpType();
        r16.getAudienceOpType();
        r6.add(r17);
    L31:
        r0.j = r6;
        return r0;
    L24:
        r9 = null;
        goto L25
    }
}
