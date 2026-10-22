package com.bytedance.android.live.liveinteract.interact.audience.fragment.v2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.base.LinkInternalServiceContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.v0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/v2/InteractAudienceInviteListFragmentV2;", "Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/v2/BaseTalkInviteListFragmentV2;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceInviteListFragmentV2 extends BaseTalkInviteListFragmentV2 {
    public static final /* synthetic */ int v = 0;
    public DataCenter t;
    public final Lazy u;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractAudienceInviteListFragmentV2 a;

        public b(InteractAudienceInviteListFragmentV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.liveinteract.api.data.a r3 = (com.bytedance.android.live.liveinteract.api.data.a) r2;
            if (vm2.d.p0() == false) goto L10;
            int r4 = v0.a;
            if (v0.a(this.a.t) == false) goto L10;
            TextView r5 = this.a.i;
            if (r5 == null) goto L20;
            r5.setText(s1.B(2131921185));
            return;
        L20:
            return;
        L10:
            if (this.a.m == true) goto L12;
        L16:
            TextView r6 = this.a.i;
            if (r6 == null) goto L24;
            r6.setText(s1.B(2131914776));
            return;
        L24:
            return;
        L12:
            if (fj0.e.i() == false) goto L16;
            TextView r7 = this.a.i;
            if (r7 == null) goto L22;
            r7.setText(s1.B(2131914773));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.BaseTalkInviteListFragmentV2
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> da0() {
        return (com.bytedance.android.live.liveinteract.plantform.base.i) this.u.getValue();
    }

    public InteractAudienceInviteListFragmentV2() {
        this.u = LazyKt.lazy(InteractAudienceInviteListFragmentV2$userCenter$2.INSTANCE);
    }

    public final void onDestroy() {
        super.onDestroy();
        yf0.b r0 = (yf0.b) this.f;
        if (r0 == null) goto L6;
        ((com.bytedance.android.livesdk.common.c) r0).a = null;
        return;
    }

    public final void onResume() {
        super.onResume();
        if (this.m == false) goto L5;
    L7:
        boolean r0 = tb1.d.a;
        yf0.b r1 = (yf0.b) this.f;
        if (this.m == false) goto L10;
    L13:
        boolean r2 = true;
    L14:
        r1.d(r2);
        return;
    L10:
        if (je0.d.Y() == true) goto L13;
        r2 = false;
        goto L14
    L5:
        if (je0.d.Y() == true) goto L7;
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.BaseTalkInviteListFragmentV2
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        com.bytedance.android.live.liveinteract.linkpanel.presenter.i r3 = new com.bytedance.android.live.liveinteract.linkpanel.presenter.i(this.l, this);
        this.f = r3;
        ((com.bytedance.android.livesdk.common.c) r3).a = this;
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.BaseTalkInviteListFragmentV2
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        if (vm2.d.p0() == false) goto L10;
        int r4 = v0.a;
        if (v0.a(this.t) == false) goto L10;
        TextView r5 = this.i;
        if (r5 == null) goto L16;
        r5.setText(s1.B(2131921185));
    L16:
        LinkInternalServiceContext r6 = LinkInternalServiceContext.Companion.getContext();
        if (r6 == null) goto L28;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.api.data.a> r7 = r6.getPaidInteractAudienceConfig();
        if (r7 == null) goto L29;
        Observable r8 = r7.a();
        if (r8 == null) goto L30;
        Observable r9 = r8.observeOn(AndroidSchedulers.mainThread());
        if (r9 == null) goto L31;
        ObservableSubscribeProxy r10 = (ObservableSubscribeProxy) r9.as(AutoDispose.bind(this));
        if (r10 == null) goto L32;
        r10.subscribe(new b(this));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L10:
        if (fj0.e.i() == false) goto L16;
        if (this.m == false) goto L16;
        TextView r11 = this.i;
        if (r11 == null) goto L16;
        r11.setText(s1.B(2131914773));
        goto L16
    }
}
