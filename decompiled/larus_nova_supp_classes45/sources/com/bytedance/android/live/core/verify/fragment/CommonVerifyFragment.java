package com.bytedance.android.live.core.verify.fragment;

import am2.x;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widget.e1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import u80.a;
import u80.b;
import u80.h;
import u80.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class CommonVerifyFragment extends BaseFragment {
    public static final /* synthetic */ int k = 0;
    public EditText d;
    public EditText e;
    public View f;
    public e1 g;
    public String h;
    public String i;
    public String j;

    public final void U90() {
        e1 r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L27;
        e1 r1 = this.g;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r1);
        return;
    L16:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L9:
        if (Looper.myLooper() == r2.getLooper()) goto L11;
        r2.post(DialogLancet.createDismissRunnable(r1));
        return;
    }

    public CommonVerifyFragment() {
    }

    public static void T90(CommonVerifyFragment r2) {
        View r0 = r2.f;
        if (TextUtils.isEmpty(r2.e.getText().toString()) == false) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r0.setEnabled(r3);
        return;
    L5:
        if (TextUtils.isEmpty(r2.d.getText().toString()) == true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (getArguments() == null) goto L6;
        this.h = getArguments().getString("KEY_REQUEST_PAGE");
        this.i = getArguments().getString("popup_source");
        this.j = getArguments().getString("enter_from");
        return;
    }

    public static void S90(CommonVerifyFragment r9, Throwable r11) {
        r9.U90();
        HashMap r0 = new HashMap();
        r0.put("request_page", r9.h);
        r0.put("popup_source", r9.i);
        if ((r11 instanceof ApiServerException) == false) goto L13;
        int r1 = ((ApiServerException) r11).getErrorCode();
        if (r1 != 20072) goto L8;
        r0.put("fail_reason", "already certified");
        goto L13
    L8:
        if (r1 != 20087) goto L11;
        r0.put("fail_reason", "invalid id card");
        goto L13
    L11:
        if (r1 != 20088) goto L13;
        r0.put("fail_reason", "mismatching");
    L13:
        u.l().sendLog("livesdk_live_name_certification_fail_show", r0, new Object[]{x.class, Room.class});
        if ((r11 instanceof ApiException) == true) goto L16;
        return;
    L16:
        if (((ApiException) r11).getErrorCode() != 20048) goto L20;
        HashMap r12 = new HashMap();
        r12.put("request_page", r9.h);
        r12.put("popup_source", r9.i);
        r12.put("result", "juveniles");
        u.l().sendLog("livesdk_user_identification_result", r12, new Object[]{x.class, Room.class});
        if (r9.getActivity() == null) goto L23;
        Intent r13 = new Intent();
        r13.putExtra("key_verify_result", 2);
        r9.getActivity().setResult(0, r13);
        r9.getActivity().finish();
        return;
    L23:
        return;
    L20:
        ExceptionUtils.handleException(r9.getContext(), r11);
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        View r7 = r4.inflate(2131566042, r5, false);
        r7.findViewById(2131363770).setOnClickListener(new a(this));
        this.d = (EditText) r7.findViewById(2131367032);
        this.e = (EditText) r7.findViewById(2131367026);
        this.d.addTextChangedListener(new h(this));
        this.e.addTextChangedListener(new i(this));
        View r8 = r7.findViewById(2131367036);
        this.f = r8;
        r8.setOnClickListener(new b(this));
        HashMap r9 = new HashMap();
        r9.put("request_page", this.h);
        u.l().sendLog("livesdk_live_name_certification_page_show", r9, new Object[]{x.class, Room.class});
        return r7;
    }
}
