package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/LiveHighlightRecordGuideDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/d;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHighlightRecordGuideDialog extends CommonStandardBottomDialog implements d {
    public static final /* synthetic */ int L = 0;
    public final CompositeDisposable B;
    public View C;
    public View D;
    public View E;
    public HSImageView F;
    public View G;
    public View H;
    public View I;
    public Animator J;
    public RecordGuideContext K;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565487;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.d
    public final RecordGuideContext B() {
        RecordGuideContext r0 = this.K;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("guideContext");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        B().onDialogClose();
        this.B.clear();
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        B().onDialogCreate();
        Window r4 = getWindow();
        if (r4 == null) goto L7;
        WindowManager.LayoutParams r5 = r4.getAttributes();
        if (r5 == null) goto L7;
        r5.dimAmount = 0.0f;
    L7:
        this.C = findViewById(2131390006);
        this.D = findViewById(2131390072);
        this.E = findViewById(2131372646);
        this.F = findViewById(2131375907);
        this.G = findViewById(2131378591);
        this.H = findViewById(2131375936);
        this.I = findViewById(2131378576);
        ImageUtil.loadImage(this.F, B().getHighlightData().c(), 0);
        setOnCancelListener(new h(this));
        View r6 = this.C;
        if (r6 == null) goto L10;
        r6.setOnClickListener(new i(this));
    L10:
        View r7 = this.D;
        if (r7 == null) goto L13;
        r7.setOnClickListener(new j(this));
    L13:
        View r8 = this.E;
        if (r8 == null) goto L16;
        r8.setOnClickListener(new k(this));
    L16:
        View r9 = this.G;
        if (r9 == null) goto L19;
        r9.setOnClickListener(new l(this));
    L19:
        View r10 = this.I;
        if (r10 == null) goto L22;
        r10.setOnClickListener(new m(this));
    L22:
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(B().getCloseGuideDialog()).subscribe(new f(this)), this.B);
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(B().getPublishLoadingShow()).subscribe(new g(this)), this.B);
    }

    public LiveHighlightRecordGuideDialog(Context r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "info");
        super(r2, false);
        this.B = new CompositeDisposable();
    }
}
