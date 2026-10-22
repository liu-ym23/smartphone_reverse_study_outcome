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
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements h, f {
    public static final GiftPluginType a = null;
    public static final k b = null;

    public k() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, boolean r7, n r8, com.bytedance.android.livesdk.gift.platform.core.model.k r9, com.bytedance.android.livesdk.gift.platform.core.model.k r10, l1 r11, com.bytedance.android.livesdk.gift.model.n r13, String r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r8, "showInfo");
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i<?> E() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void d(AbsPanel r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public final AbsPanel<?> f(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "gift");
        return null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public final void g(w1 r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void h() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void i(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "gift");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void j(long r1, Integer r3) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public final void k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void n() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean o(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, n r7, com.bytedance.android.livesdk.gift.platform.core.model.k r8, com.bytedance.android.livesdk.gift.platform.core.model.k r9, l1 r10, com.bytedance.android.livesdk.gift.model.n r11, String r13, int r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r7, "showInfo");
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void q() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void s() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h
    public final void w() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r1, SelectedStatus r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedStatus");
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.f
    public final void y(p2 r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
    }

    static {
        b = new k();
        a = GiftPluginType.DEFAULT;
    }
}
