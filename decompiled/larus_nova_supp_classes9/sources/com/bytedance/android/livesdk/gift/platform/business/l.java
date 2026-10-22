package com.bytedance.android.livesdk.gift.platform.business;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class l implements h, f {
    public WeakReference<Context> a;
    public final DataCenter b;
    public final /* synthetic */ k c;
    public final /* synthetic */ k d;

    public boolean A(AbsPanel<?> r18, int r19, int r20, IBaseUser r21, boolean r23, List<? extends IBaseUser> r24, boolean r25, n r26, com.bytedance.android.livesdk.gift.platform.core.model.k r27, com.bytedance.android.livesdk.gift.platform.core.model.k r28, l1 r29, com.bytedance.android.livesdk.gift.model.n r210, String r30, String r31, com.bytedance.android.livesdk.gift.platform.core.model.a r33) {
        Intrinsics.checkNotNullParameter(r21, "toUser");
        Intrinsics.checkNotNullParameter(r26, "showInfo");
        this.d.A(r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r210, r30, r31, r33);
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i<?> E() {
        this.c.getClass();
        return null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public final void a() {
        this.c.getClass();
    }

    public void c() {
        this.d.getClass();
    }

    public void d(AbsPanel r1) {
        this.d.getClass();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void h() {
        this.d.getClass();
    }

    public void j(long r1, Integer r3) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void n() {
        this.d.getClass();
    }

    public boolean o(AbsPanel<?> r18, int r19, int r20, IBaseUser r21, boolean r23, List<? extends IBaseUser> r24, n r25, com.bytedance.android.livesdk.gift.platform.core.model.k r26, com.bytedance.android.livesdk.gift.platform.core.model.k r27, l1 r28, com.bytedance.android.livesdk.gift.model.n r29, String r210, int r30, String r31, com.bytedance.android.livesdk.gift.platform.core.model.a r33) {
        Intrinsics.checkNotNullParameter(r21, "toUser");
        Intrinsics.checkNotNullParameter(r25, "showInfo");
        this.d.o(r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r210, r30, r31, r33);
        return false;
    }

    public void q() {
        this.d.getClass();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public void s() {
        this.d.getClass();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public void w() {
        this.c.getClass();
    }

    public boolean x(AbsPanel<?> r1, SelectedStatus r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedStatus");
        return false;
    }

    public GiftPluginType F() {
        this.c.getClass();
        return k.a;
    }

    public final Context getContext() {
        return this.a.get();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public void onDestroy() {
        this.a.clear();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public AbsPanel<?> f(h1 r3) {
        Intrinsics.checkNotNullParameter(r3, "gift");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(r3, "gift");
        return null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public void g(w1 r3) {
        Intrinsics.checkNotNullParameter(r3, "page");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(r3, "page");
    }

    public void i(h1 r3) {
        Intrinsics.checkNotNullParameter(r3, "gift");
        this.d.getClass();
        Intrinsics.checkNotNullParameter(r3, "gift");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public void k(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(r3, "context");
    }

    public void y(p2 r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        this.d.getClass();
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    public l(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        k r0 = k.b;
        this.c = r0;
        this.d = r0;
        this.b = r2;
        this.a = new WeakReference(r3);
    }
}
