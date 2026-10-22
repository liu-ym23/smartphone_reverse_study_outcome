package com.bytedance.android.live.recharge.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/NoPasswordCjComponentWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroid/view/View$OnClickListener;", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NoPasswordCjComponentWidget extends LiveRecyclableWidget implements View.OnClickListener {
    public boolean a;
    public View b;
    public final RechargeDialogContext c;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567259;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        if (this.a == false) goto L6;
        com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).a("recharge_panel");
        return;
    }

    public NoPasswordCjComponentWidget(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogContext");
        this.c = r2;
    }

    public final void onLoad(Object[] r5) {
        int r6 = com.bytedance.android.live.player.utils.c.a;
        if (com.bytedance.android.live.player.utils.c.a(((com.bytedance.android.live.recharge.platform.model.f) this.c.getRepository().Q.a).b()) == false) goto L6;
        return;
    L6:
        if (this.b != null) goto L30;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L23
        ITTCJPayComponent r8 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).L(new c(this.c), new d(this.c, ((Widget) this).context));     // Catch: Throwable -> L23
        if (r8 == null) goto L10;
        com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).s1("recharge_panel", r8);     // Catch: Throwable -> L23
        View r9 = r8.getPayView(new JSONObject(((com.bytedance.android.live.recharge.platform.model.f) this.c.getRepository().Q.a).b()));     // Catch: Throwable -> L23
    L11:
        this.b = r9;     // Catch: Throwable -> L23
        if (r9 == null) goto L14;
        this.a = true;     // Catch: Throwable -> L23
    L14:
        if (r9 == null) goto L20;
        ConstraintLayout r0 = ((Widget) this).contentView;     // Catch: Throwable -> L23
        if (r0 == null) goto L19;
        r0.addView(r9);     // Catch: Throwable -> L23
    L21:
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r12 = Result.exceptionOrNull-impl(r10);
        if (r12 == null) goto L31;
        this.c.getPkLoadCjComponentFailed().onNext(Unit.INSTANCE);
        ALogger.e("cjComponent", "财经组件初始化异常" + r12.getMessage());
        return;
    L31:
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");     // Catch: Throwable -> L23
    L20:
        this.c.getPkLoadCjComponentFailed().onNext(Unit.INSTANCE);     // Catch: Throwable -> L23
        goto L21
    L10:
        r9 = null;
    L23:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }
}
