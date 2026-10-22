package com.bytedance.android.livesdk.interactivity.medialink.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.interactivity.api.medialink.BaseMediaLinkControlWidget;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLinkAudienceWindowManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/RevMediaLinkControlWidget;", "Lcom/bytedance/android/livesdk/interactivity/api/medialink/BaseMediaLinkControlWidget;", "Lcom/bytedance/android/livesdk/interactivity/medialink/contract/a;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RevMediaLinkControlWidget extends BaseMediaLinkControlWidget implements com.bytedance.android.livesdk.interactivity.medialink.contract.a {
    public final CompositeDisposable b;
    public boolean c;
    public int d;
    public MediaMultiLinkAnchorWidget e;
    public MediaMultiLinkAudienceWidget f;
    public final BaseMediaLinkControlWidget.a g;
    public final ViewGroup h;

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void Zh() {
    }

    public final boolean qa(Runnable r1, boolean r2) {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final DialogFragment rg() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.BaseMediaLinkControlWidget
    public final String tag() {
        return "RevMediaLinkControlWidget";
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final LiveWidget Yf() {
        if (this.c == false) goto L6;
        return this.e;
    L6:
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void m() {
        k.n(ILinkServiceExternal.class).getControlServiceExternal().m();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void onClickLinkIcon() {
        MediaMultiLinkAnchorWidget r0 = this.e;
        if (r0 == null) goto L6;
        r0.Bq();
        return;
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        RoomContext r0 = ((RoomWidget) this).a;
        if (r0 == null) goto L9;
        i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
    L10:
        this.c = r2;
        Pair r3 = com.bytedance.live.datacontext.d.a(RevMediaLinkControlWidget$onCreate$pair$1.INSTANCE);
        ((RevMediaLinkInternalServiceContext) r3.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r3.getFirst(), RevMediaLinkInternalServiceContext.TAG);
        RxUtilKt.c((Disposable) r3.getSecond(), this.b);
        boolean r4 = k60.b.a();
        enableSubWidgetManager();
        if (this.c == false) goto L13;
        MediaMultiLinkAnchorControlWidget r5 = new MediaMultiLinkAnchorControlWidget();
        ((Widget) this).subWidgetManager.load(r5, r4, r4);
    L15:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L18;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), x32.a.class, this);
        return;
    L18:
        return;
    L13:
        MediaMultiLinkAudienceControlWidget r6 = new MediaMultiLinkAudienceControlWidget();
        ((Widget) this).subWidgetManager.load(r6, r4, r4);
    L9:
        r2 = false;
        goto L10
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), x32.a.class);
        CompositeDisposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final int getCurrentMode() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void K4(int r3) {
        if (v.a(this.d, 256) == true) goto L5;
        return;
    L5:
        int r4 = v.b(this.d, 256);
        this.d = r4;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L9;
        r0.put("data_link_state", Integer.valueOf(r4));
    L9:
        if (this.c == false) goto L11;
        this.g.a(this.e);
        this.e = null;
    L12:
        RoomContext r5 = ((RoomWidget) this).a;
        if (r5 == null) goto L17;
        m r6 = r5.isMultiAnchorLinkOn();
        if (r6 == null) goto L17;
        r6.setValue(Boolean.FALSE);
    L17:
        onMultiAnchorStateChange(0);
        k.n(ILinkServiceExternal.class).onMultiAnchorStateChange(0);
        return;
    L11:
        this.g.a(this.f);
        this.f = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void gq(com.bytedance.android.livesdk.interactivity.medialink.contract.e r4) {
        if (v.a(this.d, 256) == false) goto L5;
        return;
    L5:
        int r0 = this.d | 256;
        this.d = r0;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L9;
        r1.put("data_link_state", Integer.valueOf(r0));
    L9:
        if (this.c == false) goto L11;
        this.e = this.g.b(r4);
    L12:
        RoomContext r5 = ((RoomWidget) this).a;
        if (r5 == null) goto L17;
        m r6 = r5.isMultiAnchorLinkOn();
        if (r6 == null) goto L17;
        r6.setValue(Boolean.TRUE);
    L17:
        int r7 = MediaLinkControlWidget.r;
        MediaLinkControlWidget.a.a(this.c);
        k.n(ILinkServiceExternal.class).onMultiAnchorStateChange(2);
        return;
    L11:
        this.f = this.g.b(r4);
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final boolean k0(int r2) {
        return v.a(this.d, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.a
    public final void onMultiAnchorStateChange(int r2) {
        k.n(ILinkServiceExternal.class).onMultiAnchorStateChange(r2);
    }

    @Override // x32.a
    public final void onSei(String r4) {
        MediaMultiLinkAudienceWidget r0 = this.f;
        if (r0 == null) goto L8;
        r0.h = r4;
        MediaMultiLinkAudienceWindowManager r1 = r0.g;
        if (r1 == null) goto L9;
        MediaMultiLinkAudienceWindowManager.r(r1, r4, false, false, 6);
        return;
    L9:
        return;
    }

    public RevMediaLinkControlWidget(BaseMediaLinkControlWidget.a r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "mCallback");
        this.g = r2;
        this.h = r3;
        this.b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.BaseMediaLinkControlWidget, x32.a
    public final void a(View r2, MotionEvent r3) {
        MediaMultiLinkAnchorWidget r0 = this.e;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
