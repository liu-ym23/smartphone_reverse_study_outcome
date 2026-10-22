package com.bytedance.android.annie.container.dialog;

import android.app.Dialog;
import android.view.View;
import com.bytedance.android.livesdk.pannel.CloseType;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ BaseDialogFragment a;

    public d(BaseDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        if (this.a.isCancelable() == false) goto L16;
        BaseDialogFragment r11 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Dialog r12 = r11.getDialog();     // Catch: Throwable -> L11
        if (r12 == null) goto L8;
        r12.cancel();     // Catch: Throwable -> L11
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L11
    L13:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L20;
        HybridLogger r16 = HybridLogger.a;
        HybridLogger.i("BaseDialogFragment", "error===>" + r15.getMessage(), null, 12);
        return;
    L20:
        return;
    L8:
        r13 = null;
    L11:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L16:
        this.a.sendJsEvent("H5_tapWebMaskView", new JSONObject());
        BaseDialogFragment r18 = this.a;
        CloseType r0 = CloseType.MaskClick;
        r18.getClass();
        JSONObject r19 = new JSONObject();
        r19.put("type", r0.getTag());
        Unit r20 = Unit.INSTANCE;
        r18.sendJsEvent("containerShouldClose", r19);
    }
}
