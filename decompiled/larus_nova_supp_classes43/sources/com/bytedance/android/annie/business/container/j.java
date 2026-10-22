package com.bytedance.android.annie.business.container;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends com.bytedance.android.anniex.base.lifecycle.a {
    public final /* synthetic */ i a;

    public j(i r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void e(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.e(r10, r11);
        i r12 = this.a;
        if (r12.n != null) goto L5;
        HybridLogger r0 = HybridLogger.a;
        k7.a.a("AnnieXLivePopAndPageComm", "===onKitViewCreate AnnieXLiveComponent is null===", r12.c);
        Unit r13 = Unit.INSTANCE;
    L5:
        AnnieXLiveHybridComponent r14 = this.a.n;
        if (r14 == null) goto L9;
        r14.f(r10);
        return;
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void h(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.h(r10, r11);
        ViewGroup r12 = this.a.p;
        if (r12 == null) goto L5;
        FrameLayout r13 = (FrameLayout) r12.findViewById(2131363000);
    L6:
        if (r13 == null) goto L10;
        r13.setVisibility(0);
        return;
    L10:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void i(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.i(r10, r11);
        i r12 = this.a;
        AnnieXLiveHybridComponent r13 = r12.n;
        ia.c.a.a(r12.b, true);
        w8.d r14 = r12.d;
        if (r14 == null) goto L6;
        r14.a(true);
        return;
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void c(String r10, AnnieXContainer r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        super.c(r10, r11, r12);
        AnnieXLiveContext r13 = this.a.c;
        if (r13 == null) goto L10;
        b7.b r14 = r13.getCommonLifecycle();
        if (r14 == null) goto L10;
        String r15 = r12.getMessage();
        if (r15 != null) goto L9;
        r15 = "unknow message";
    L9:
        boolean r16 = r14.onFallback(500, r15);
    L11:
        if (r16 == false) goto L13;
        return;
    L13:
        if (AnnieConfigSettingKeys.TRY_FIX_BG_COLOR_ON_RELOAD.a().booleanValue() == false) goto L15;
    L19:
        r11.hideLoading();
        ViewGroup r17 = this.a.p;
        if (r17 == null) goto L22;
        FrameLayout r18 = (FrameLayout) r17.findViewById(2131363000);
    L23:
        if (r18 == null) goto L28;
        r18.setVisibility(8);
        return;
    L28:
        return;
    L22:
        r18 = null;
        goto L23
    L15:
        if (Intrinsics.areEqual(r11.getViewType(), AIStateLogRequest.SOURCE_PAGE) == false) goto L19;
        ViewGroup r19 = this.a.p;
        if (r19 == null) goto L19;
        r19.setBackgroundColor(ColorProtector.parseColor(IHostContextDepend.SKIN_TYPE_WHITE));
    L10:
        r16 = false;
        goto L11
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void g(String r10, ia.c r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        super.g(r10, r11, r12);
        i r13 = this.a;
        r13.j = true;
        if (r13.k.booleanValue() == false) goto L10;
        i r14 = this.a;
        if (Intrinsics.areEqual(r14.b.getViewType(), AIStateLogRequest.SOURCE_PAGE) == false) goto L11;
        ViewGroup r15 = r14.p;
        if (r15 == null) goto L12;
        r15.setBackgroundColor(ColorProtector.parseColor(IHostContextDepend.SKIN_TYPE_WHITE));
        return;
    L12:
        return;
    L11:
        return;
    }
}
