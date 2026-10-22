package com.bytedance.android.live.liveinteract.linkpanel.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.GetInfoBeforeAddPriceResponse;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.CoinConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/dialog/IncreasePriceApplyDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IncreasePriceApplyDialog extends CommonBottomDialog {
    public static final /* synthetic */ int g = 0;
    public final CompositeDisposable a;
    public IRoom b;
    public int c;
    public boolean d;
    public final int e;
    public final GuestApplyViewModel f;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565491;
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
    L18:
        if (getWindow() == null) goto L25;
        Window r1 = getWindow();
        if (r1 == null) goto L22;
        r1.addFlags(2);
    L22:
        Window r2 = getWindow();
        if (r2 == null) goto L25;
        r2.setDimAmount(1.0f);
    L25:
        GuestApplyViewModel r3 = this.f;
        if (r3 == null) goto L28;
        r3.clearAddPriceData();
    L28:
        this.d = false;
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r4 == null) goto L16;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (getWindow() == null) goto L19;
        Window r0 = getWindow();
        if (r0 == null) goto L12;
        r0.addFlags(2);
    L12:
        Window r1 = getWindow();
        if (r1 == null) goto L20;
        r1.setDimAmount(0.6f);
        return;
    L20:
        return;
    L19:
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    public static final int M0(IncreasePriceApplyDialog r0) {
        GuestApplyViewModel r1 = r0.f;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getPaidCount();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        if (Intrinsics.areEqual(m.i().isPortraitInteraction(), Boolean.FALSE) == false) goto L10;
        Window r6 = getWindow();
        if (r6 == null) goto L7;
        r6.setGravity(5);
    L7:
        Window r7 = getWindow();
        if (r7 == null) goto L10;
        r7.setLayout(s1.f(375.0f), -1);
    L10:
        com.bytedance.live.datacontext.m r8 = m.i().getRoom();
        if (r8 == null) goto L13;
        IRoom r9 = (IRoom) r8.getValue();
    L14:
        this.b = r9;
        GuestApplyViewModel r10 = this.f;
        if (r10 == null) goto L17;
        r10.getInfoBeforeAddPrice(this.e, 0, new AnonymousClass1(this));
    L17:
        b r11 = new b(this);
        GuestApplyViewModel r0 = this.f;
        if (r0 == null) goto L22;
        LiveData<GetInfoBeforeAddPriceResponse> r1 = r0.getAfterIncreasePriceData();
        if (r1 == null) goto L22;
        r1.observeForever(r11);
    L22:
        c r2 = new c(this);
        GuestApplyViewModel r3 = this.f;
        if (r3 == null) goto L27;
        MutableLiveData<Boolean> r4 = r3.getAddPriceState();
        if (r4 == null) goto L27;
        r4.observeForever(r2);
    L27:
        setOnDismissListener(new com.bytedance.android.live.liveinteract.linkpanel.dialog.a(this, r11, r2));
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        ((Button) findViewById(2131364742)).setOnClickListener(x0.a(new AnonymousClass2(this)));
        o.z();
        o.z();
        ((ImageView) findViewById(2131380160)).setVisibility(8);
        ((ImageView) findViewById(2131382496)).setVisibility(8);
        int r12 = r3.a;
        ImageLoader.load(((CoinConfig) j40.m.a.getValue()).getIcCoin()).a(findViewById(2131376297));
        ((TextView) findViewById(2131391058)).setText(r3.b());
        return;
    L13:
        r9 = null;
        goto L14
    }

    public IncreasePriceApplyDialog(Context r2, int r3, GuestApplyViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.a = new CompositeDisposable();
        this.c = 1;
    }
}
