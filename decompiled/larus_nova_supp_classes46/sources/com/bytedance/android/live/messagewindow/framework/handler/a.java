package com.bytedance.android.live.messagewindow.framework.handler;

import android.content.Context;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.m1;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a<T> implements a71.a<T> {
    public Map<Integer, Pair<v61.a, g71.b>> a;

    public String c() {
        return "AbsCommonCardHandler";
    }

    public abstract /* synthetic */ WeakReference<Context> getContext();

    public a() {
        this.a = new LinkedHashMap();
    }

    public void g() {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L7;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(c());
        r1.c("onHandlerDestroy");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
        return;
    }

    public void h() {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L7;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(c());
        r1.c("onInit");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
        return;
    }

    public void a(z61.a r4) {
        Intrinsics.checkNotNullParameter(r4, "commonCardEvent");
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L12;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(c());
        r1.c("combineTypeCardRefresh");
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r5 = r4.b;
        if (r5 == null) goto L10;
        String r6 = r5.g;
        if (r6 == null) goto L10;
        r1.a("card data info", r6);
    L10:
        Unit r7 = Unit.INSTANCE;
        r0.d(r1.b());
        return;
    }

    public void b(T r3) {
        i r4 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r4 == null) goto L7;
        CardAlogParamsBuilder r0 = new CardAlogParamsBuilder();
        r0.d(c());
        r0.c("destroyCard");
        Unit r1 = Unit.INSTANCE;
        r4.d(r0.b());
        return;
    }

    public final void f(Integer r5) {
        if (r5 == null) goto L16;
        r5.intValue();
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L10;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(c());
        r1.c("onCardShow");
        String r2 = String.valueOf(r5.intValue());
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        r1.a("cardType", r2);
        Unit r3 = Unit.INSTANCE;
        r0.d(r1.b());
    L10:
        Pair<v61.a, g71.b> r6 = this.a.get(r5);
        if (r6 == null) goto L17;
        v61.a r7 = (v61.a) r6.getFirst();
        if (r7 == null) goto L18;
        r7.show();
        return;
    L18:
        return;
    L17:
        return;
    }

    public void i(h r3) {
        i r4 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r4 == null) goto L7;
        CardAlogParamsBuilder r0 = new CardAlogParamsBuilder();
        r0.d(c());
        r0.c("recreateCard");
        Unit r1 = Unit.INSTANCE;
        r4.d(r0.b());
        return;
    }

    public final void d(T r7, CommonCardInitScene r8) {
        Intrinsics.checkNotNullParameter(r8, "initScene");
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(c());
        r1.c("initCommonCard");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r3 == null) goto L42;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_init");
        boolean r5 = r7 instanceof m1;
        Integer r6 = null;
        if (r5 == true) goto L12;
        T r9 = null;
    L14:
        if (((m1) r9) == null) goto L16;
        Integer r10 = Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue());
    L24:
        r4.b("position", r10);
        if (r5 == true) goto L27;
        T r11 = null;
    L28:
        m1 r12 = (m1) r11;
        if (r12 == null) goto L35;
        Integer r13 = r12.type;
        if (r13 == null) goto L35;
        r6 = r13;
    L40:
        r4.b("type", r6);
        r4.b("init_scene", r8);
        Unit r14 = Unit.INSTANCE;
        r3.b(r4.a());
        return;
    L35:
        if ((r7 instanceof i3) == true) goto L37;
        r7 = null;
    L37:
        i3 r15 = (i3) r7;
        if (r15 == null) goto L40;
        r6 = r15.type;
        goto L40
    L27:
        r11 = r7;
        goto L28
    L16:
        if ((r7 instanceof i3) == true) goto L18;
        T r16 = null;
    L19:
        i3 r17 = (i3) r16;
        if (r17 == null) goto L22;
        r10 = r17.domain;
        goto L24
    L22:
        r10 = null;
        goto L24
    L18:
        r16 = r7;
        goto L19
    L12:
        r9 = r7;
        goto L14
    }

    public void e(T r2, CommonCardInitScene r3) {
        Intrinsics.checkNotNullParameter(r3, "initScene");
        i r4 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r4 == null) goto L7;
        CardAlogParamsBuilder r5 = new CardAlogParamsBuilder();
        r5.d(c());
        r5.c("initOrRefreshCard");
        Unit r0 = Unit.INSTANCE;
        r4.d(r5.b());
        return;
    }

    public final void j(com.bytedance.android.live.room.api.messagewindow.builder.card.b r4, CompositeDisposable r5) {
        Intrinsics.checkNotNullParameter(r4, "commonCard");
        Intrinsics.checkNotNullParameter(r5, "cd");
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(c());
        r1.c("combineCardRelease");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        y61.a r3 = getCommonCardContext();
        if (r3 == null) goto L10;
        r3.unRegisterCardCallback(r4, r5);
        return;
    }
}
