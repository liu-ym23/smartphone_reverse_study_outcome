package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/RewardMsgCenterDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RewardMsgCenterDialog extends CommonBottomDialog {
    public MultiTypeAdapter a;
    public final h b;
    public final PanelType c;
    public final boolean d;
    public final /* synthetic */ i20.a e;

    public final int getLayoutId() {
        return 2131565733;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.e.b();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void show() {
        Disposable r0 = com.bytedance.android.live.broadcastgame.opengame.utils.i.b(RxUtilKt.h(xs2.b.a().b(q10.a.class)), new C03081(this));
        Intrinsics.checkNotNullParameter(r0, "$this$autoDispose");
        this.e.a(r0);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        super.onCreate(r12);
        PanelType r13 = this.c;
        Intrinsics.checkNotNullParameter(r13, "type");
        ((RelativeLayout) findViewById(2131384494)).setLayoutParams(new FrameLayout.LayoutParams(-1, r13.getHeight()));
        findViewById(2131383669).setLayoutManager(new SSLinearLayoutManager(getContext()));
        MultiTypeAdapter r1 = new MultiTypeAdapter();
        this.a = r1;
        r1.z2(m0.class, new RewardItemViewBinder(new AnonymousClass1(this)));
        RecyclerView r2 = findViewById(2131383669);
        MultiTypeAdapter r3 = this.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r2.setAdapter(r3);
        if (this.d == false) goto L25;
        Window r4 = getWindow();
        if (r4 == null) goto L12;
        WindowManager.LayoutParams r5 = r4.getAttributes();
        if (r5 == null) goto L12;
        r5.width = s1.f(395.0f);
    L12:
        Window r6 = getWindow();
        if (r6 == null) goto L15;
        r6.setGravity(5);
    L15:
        View r0 = findViewById(2131384494);
        if (r0 == null) goto L24;
        Drawable r7 = r0.getBackground();
        if ((r7 instanceof GradientDrawable) == true) goto L20;
        r7 = null;
    L20:
        GradientDrawable r8 = (GradientDrawable) r7;
        float r9 = s1.e(12.0f);
        if (r8 == null) goto L23;
        r8.setCornerRadii(new float[]{r9, r9, 0.0f, 0.0f, 0.0f, 0.0f, r9, r9});
    L23:
        a1.k(r0, s1.q(getContext()).heightPixels);
    L24:
        t8.d(getWindow());
    L25:
        findViewById(2131387318).setBuilder(new LoadingStatusView.Builder(getContext()).setLoadingView(new DouyinLoadingLayout(getContext())).setEmptyView(LayoutInflater.from(getContext()).inflate(2131565448, null)).setErrorView(LayoutInflater.from(getContext()).inflate(2131565449, null)));
        if (this.b != null) goto L28;
        findViewById(2131383669).setVisibility(8);
        findViewById(2131387318).setVisibility(0);
        findViewById(2131387318).showEmpty();
        return;
    L28:
        ArrayList r11 = new ArrayList();
        r11.addAll(this.b.getAll());
        MultiTypeAdapter r14 = this.a;
        if (r14 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L31:
        r14.A2(r11);
        MultiTypeAdapter r15 = this.a;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L34:
        r15.notifyDataSetChanged();
        findViewById(2131383669).setVisibility(0);
        findViewById(2131387318).setVisibility(8);
    }

    public RewardMsgCenterDialog(Context r2, c0 r3, PanelType r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "panelType");
        super(r2, r5, false);
        this.e = new i20.a();
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
