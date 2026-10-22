package com.bytedance.android.live.liveinteract.voicechat.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {
    public TextView b;
    public TextView c;
    public View d;
    public TextView e;
    public final DataCenter f;
    public final IRoom g;
    public final CompositeDisposable h;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.h.dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(g r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        int r4 = r3.getId();
        if (r4 != 2131365120) goto L9;
        DataCenter r5 = this.f;
        if (r5 == null) goto L7;
        r5.put("cmd_interact_state_change", new a1(9));
    L7:
        a(this);
        return;
    L9:
        if (r4 != 2131365114) goto L13;
        a(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        super/*android.app.Dialog*/.onCreate(r8);
        setContentView(LayoutInflater.from(getContext()).inflate(2131565522, null));
        Window r9 = getWindow();
        if (r9 == null) goto L5;
        r9.setGravity(80);
        r9.setLayout(-1, -2);
    L5:
        this.b = (TextView) findViewById(2131365120);
        this.c = (TextView) findViewById(2131365114);
        this.d = findViewById(2131377420);
        this.e = (TextView) findViewById(2131391713);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        IRoom r10 = this.g;
        if (r10 == null) goto L14;
        long r3 = r10.getId();
        int r11 = je0.d.f();
        if (r11 != 0) goto L11;
        int r5 = 5;
    L12:
        Disposable r12 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).getUserWaitingRankPosition(r3, r3, r5, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this), new f());
        this.h.add(r12);
        return;
    L11:
        r5 = r11;
        goto L12
    }

    public g(Context r2, DataCenter r3, IRoom r4) {
        super(r2, true);
        this.h = new CompositeDisposable();
        this.f = r3;
        this.g = r4;
    }
}
