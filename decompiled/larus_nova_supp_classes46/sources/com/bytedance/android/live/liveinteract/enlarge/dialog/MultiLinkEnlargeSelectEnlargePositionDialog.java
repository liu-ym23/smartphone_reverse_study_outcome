package com.bytedance.android.live.liveinteract.enlarge.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.enlarge.widget.MultiEnlargeSelectView;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/MultiLinkEnlargeSelectEnlargePositionDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkEnlargeSelectEnlargePositionDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int E = 0;
    public long B;
    public String C;
    public final CompositeDisposable D;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565649;
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
        this.D.clear();
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

    public MultiLinkEnlargeSelectEnlargePositionDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.C = "";
        this.D = new CompositeDisposable();
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        ((TextView) findViewById(2131385922)).setOnClickListener(x0.a(new MultiLinkEnlargeSelectEnlargePositionDialog$initView$1(this)));
        ((MultiEnlargeSelectView) findViewById(2131372585)).setOnClickListener(x0.a(new MultiLinkEnlargeSelectEnlargePositionDialog$initView$2(this)));
        ((MultiEnlargeSelectView) findViewById(2131385673)).setOnClickListener(x0.a(new MultiLinkEnlargeSelectEnlargePositionDialog$initView$3(this)));
        i<ILinkPlayerInfoBridge> r1 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r1 == null) goto L14;
        Iterable r2 = r1.getOnlineUserList();
        if (r2 == null) goto L14;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        if (((ILinkPlayerInfoBridge) r5).isEnlarged() == false) goto L8;
        r3.add(r5);
        goto L8
    L12:
        List r7 = CollectionsKt.sortedWith(r3, new b());
        if (r7 == null) goto L14;
    L16:
        if (r7.size() < 2) goto L18;
        ((MultiEnlargeSelectView) findViewById(2131372585)).R5((ILinkPlayerInfoBridge) ListProtector.get(r7, 0));
        ((MultiEnlargeSelectView) findViewById(2131372585)).S5(false);
        ((MultiEnlargeSelectView) findViewById(2131385673)).R5((ILinkPlayerInfoBridge) ListProtector.get(r7, 1));
        ((MultiEnlargeSelectView) findViewById(2131385673)).S5(false);
        ((MultiEnlargeSelectView) findViewById(2131372585)).S5(true);
    L18:
        CPositionContext r8 = CPositionContext.Companion.getContext();
        if (r8 == null) goto L33;
        m<EnlargeGuestInfo> r9 = r8.getEnlargeGuestInfo();
        if (r9 == null) goto L34;
        Observable r10 = r9.a();
        if (r10 == null) goto L35;
        Disposable r11 = r10.subscribe(new c(this));
        if (r11 == null) goto L36;
        this.D.add(r11);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L14:
        r7 = new ArrayList();
        goto L16
    }
}
