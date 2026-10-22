package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.config.od;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 implements View.OnClickListener {
    public final /* synthetic */ XiaoAnSettingDialog a;

    public c0(XiaoAnSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        this.a.dismiss();     // Catch: Exception -> L5
    L9:
        XiaoAnSettingDialog r7 = this.a;
        Integer r0 = r7.i;
        if (r0 == null) goto L36;
        int r1 = r0.intValue();
        if (r1 != 1) goto L14;
        f2.b(2131915873, 0);
    L21:
        DataCenter r8 = r7.f;
        if (r8 == null) goto L26;
        Room r9 = com.bytedance.android.live.core.utils.z.o(r8);
        if (r9 == null) goto L26;
        long r2 = r9.id;
    L28:
        if (((Boolean) od.a.getValue()).booleanValue() == false) goto L32;
        Observable r10 = AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), r2, 46, r1).compose(RxUtil.rxSchedulerHelper());
        if (r10 == null) goto L37;
        r10.subscribe(new d0(r1));
        return;
    L37:
        return;
    L32:
        AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), r2, 46, r1).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L26:
        r2 = 0;
        goto L28
    L14:
        if (r1 != 3) goto L16;
        f2.b(2131915882, 0);
        goto L21
    L16:
        if (r1 != 5) goto L21;
        f2.b(2131915883, 0);
        goto L21
    L36:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L9;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
