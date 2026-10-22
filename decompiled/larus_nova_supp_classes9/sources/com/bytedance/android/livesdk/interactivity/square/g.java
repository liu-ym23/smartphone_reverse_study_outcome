package com.bytedance.android.livesdk.interactivity.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c {
    public final PublicScreenAreaPageType a;
    public FrameLayout b;
    public WidgetElement c;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e d;
    public final CompositeDisposable e;
    public final String f;
    public final DataCenter g;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void l2() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e r0 = this.d;
        if (r0 == null) goto L6;
        r0.l2();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void z5() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e r0 = this.d;
        if (r0 == null) goto L6;
        r0.z5();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final String D5() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final PublicScreenAreaPageType getPageType() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void A5(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r8) {
        Intrinsics.checkNotNullParameter(r8, "bridge");
        FrameLayout r3 = this.b;
        if (r3 == null) goto L10;
        IPublicScreenService r1 = (IPublicScreenService) jc1.k.f(IPublicScreenService.class);
        if (r1 == null) goto L7;
        Class<? extends LiveRecyclableWidget> r2 = r1.getSquareWidget();
    L8:
        if (r2 == null) goto L10;
        WidgetElement r9 = r8.b().P(r2, r3, false, null, true);
        this.c = r9;
        this.d = (com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e) r9.f(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e.class);
        goto L10
    L7:
        r2 = null;
    L10:
        com.bytedance.android.livesdk.interactivity.api.h r10 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r10 == null) goto L24;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> r11 = r10.getPublicScreenAreaStateManager();
        if (r11 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r13 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a) r11.getValue();
        if (r13 == null) goto L26;
        m<com.bytedance.android.livesdk.interactivity.api.base.d> r14 = r13.getState();
        if (r14 == null) goto L27;
        Observable r15 = r14.a();
        if (r15 == null) goto L28;
        Disposable r16 = r15.subscribe(new f(this));
        if (r16 == null) goto L29;
        RxUtilKt.c(r16, this.e);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final View B5(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r4) {
        Intrinsics.checkNotNullParameter(r4, "bridge");
        View r5 = LayoutInflater.from(r4.getActivity()).inflate(2131567506, null, false);
        this.b = (FrameLayout) r5.findViewById(2131387132);
        return r5;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void C5(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r2) {
        Intrinsics.checkNotNullParameter(r2, "bridge");
        WidgetElement r0 = this.c;
        if (r0 == null) goto L5;
        r2.b().S(r0);
    L5:
        this.c = null;
        this.d = null;
        this.e.dispose();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void setHeight(int r3) {
        FrameLayout r0 = this.b;
        if (r0 == null) goto L6;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = r3;
        r0.setLayoutParams(r1);
        return;
    }

    public g(MiddlewareRoomContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.g = r3;
        this.a = PublicScreenAreaPageType.Square;
        this.e = new CompositeDisposable();
        this.f = "广场";
    }
}
