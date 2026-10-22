package com.bytedance.android.live.broadcast;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.BubblePosition;
import com.bytedance.android.live.broadcast.api.model.z0;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.broadcast.BubbleDotListData;
import com.bytedance.android.livesdkapi.depend.model.broadcast.BubbleDotPanelInfo;
import com.bytedance.android.livesdkapi.depend.model.broadcast.CommonBubble;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemBubbleInfo;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements nz.h {
    public static final g a = null;

    public g() {
    }

    static {
        a = new g();
    }

    public static boolean c(CommonBubble r3) {
        return !Intrinsics.areEqual((Boolean) ((HashMap) com.bytedance.android.livesdk.sharedpref.b.Y1.getValue()).get(String.valueOf(r3.getId())), Boolean.TRUE);
    }

    @Override // nz.h
    public final CompositeDisposable b(Context r7, View r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter("room_toolbar_anchor", "showPath");
        Intrinsics.checkNotNullParameter(r8, "itemView");
        Intrinsics.checkNotNullParameter(r9, "key");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getPreviewParameters();
        if (r1 == null) goto L9;
        z0 r2 = (z0) r1.getValue();
        if (r2 == null) goto L9;
        BubbleDotListData r3 = r2.b;
    L10:
        if (r3 == null) goto L20;
        Map r4 = r3.getListData();
        if (r4 == null) goto L20;
        BubbleDotPanelInfo r5 = (BubbleDotPanelInfo) r4.get("room_toolbar_anchor");
        if (r5 == null) goto L20;
        Map r6 = r5.getItemBubbles();
        if (r6 == null) goto L20;
        ItemBubbleInfo r11 = (ItemBubbleInfo) r6.get(r9);
        if (r11 == null) goto L20;
        List r12 = r11.getBubble();
    L21:
        if (r12 == null) goto L29;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L24:
        if (r14.hasNext() == false) goto L28;
        Object r15 = r14.next();
        if (c((CommonBubble) r15) == false) goto L24;
        r13.add(r15);
        goto L24
    L28:
        List r16 = CollectionsKt.sortedWith(r13, new d());
    L30:
        List r17 = r16;
        if (r17 != null) goto L33;
    L36:
        boolean r18 = true;
    L37:
        if (r18 == false) goto L39;
        return null;
    L39:
        CompositeDisposable r19 = new CompositeDisposable();
        Iterator r21 = r16.iterator();
    L41:
        if (r21.hasNext() == false) goto L45;
        Disposable r22 = d(r7, r8, (CommonBubble) r21.next(), BubblePosition.Top);
        if (r22 == null) goto L41;
        r19.add(r22);
        goto L41
    L45:
        return r19;
    L33:
        if (r17.isEmpty() == true) goto L36;
        r18 = false;
        goto L37
    L29:
        r16 = null;
    L20:
        r12 = null;
    L9:
        r3 = null;
        goto L10
    }

    public static Disposable d(Context r3, View r4, CommonBubble r5, BubblePosition r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "bubbleInfo");
        Intrinsics.checkNotNullParameter("room_toolbar_anchor", "showPath");
        Intrinsics.checkNotNullParameter(r6, "position");
        if (c(r5) == true) goto L7;
        return null;
    L7:
        return ((SingleSubscribeProxy) Single.timer(r5.getDuration(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) r3))).subscribe(new f(r3, r4, r5, r6));
    }

    @Override // nz.h
    public final CompositeDisposable a(Context r5, View r6, ItemBubbleInfo r7, BubblePosition r8) {
        Intrinsics.checkNotNullParameter(r6, "itemView");
        Intrinsics.checkNotNullParameter("room_toolbar_anchor", "showPath");
        Intrinsics.checkNotNullParameter(r8, "position");
        if (r5 != null) goto L5;
        return null;
    L5:
        List r9 = r7.getBubble();
        if (r9 == null) goto L14;
        ArrayList r1 = new ArrayList();
        Iterator r11 = r9.iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        Object r2 = r11.next();
        if (c((CommonBubble) r2) == false) goto L9;
        r1.add(r2);
        goto L9
    L13:
        List r12 = CollectionsKt.sortedWith(r1, new e());
    L15:
        List r3 = r12;
        if (r3 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
        return null;
    L24:
        CompositeDisposable r0 = new CompositeDisposable();
        Iterator r13 = r12.iterator();
    L26:
        if (r13.hasNext() == false) goto L30;
        Disposable r14 = d(r5, r6, (CommonBubble) r13.next(), r8);
        if (r14 == null) goto L26;
        r0.add(r14);
        goto L26
    L30:
        return r0;
    L18:
        if (r3.isEmpty() == true) goto L21;
        r4 = false;
        goto L22
    L14:
        r12 = null;
        goto L15
    }
}
