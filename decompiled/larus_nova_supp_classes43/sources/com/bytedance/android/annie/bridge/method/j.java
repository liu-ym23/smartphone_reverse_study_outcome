package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = com.bytedance.android.ec.core.event.a.VALUE_CLOSE)
public final class j extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final WeakReference<Activity> a;
    public final DialogFragment b;
    public final String c;

    public final void onTerminate() {
    }

    public j(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        DialogFragment r0 = (DialogFragment) r10.c(DialogFragment.class);
        if (r0 == null) goto L5;
        this.b = r0;
    L5:
        Activity r11 = (Activity) r10.c(Activity.class);
        if (r11 == null) goto L9;
        this.a = new WeakReference(r11);
        return;
    }

    public j(WeakReference r10) {
        Intrinsics.checkNotNullParameter(r10, "activityRef");
        this.a = r10;
        this.c = null;
    }

    public j(HybridDialog r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        this.b = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r13 = r12.optString("containerID");
        if (r13 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == false) goto L11;
        r13 = this.c;
    L11:
        JSONArray r15 = r12.optJSONArray("containerIDs");
        if (r13 != null) goto L14;
    L17:
        boolean r16 = true;
    L19:
        if (r16 == false) goto L37;
        if (r15 != null) goto L22;
    L23:
        DialogFragment r17 = this.b;
        if (r17 != null) goto L66;
        WeakReference<Activity> r18 = this.a;
        if (r18 == null) goto L37;
        Activity r19 = r18.get();
        if (r19 == null) goto L37;
        r19.finish();
        CloseResModel r110 = new CloseResModel();
        r110.a(CloseResModel.Code.Success);
        r110.b("Success");
        finishWithResult(r110);
        return;
    L66:
        r17.dismissAllowingStateLoss();     // Catch: Exception -> L27
    L31:
        CloseResModel r111 = new CloseResModel();
        r111.a(CloseResModel.Code.Success);
        r111.b("Success");
        finishWithResult(r111);
        return;
    L27:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r112 = DialogFragmentLancet.sLastShowStack;
        if (r112 == null) goto L31;
        com.bytedance.crash.d.d(r112, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L31
    L22:
        if (r15.length() == 0) goto L23;
    L37:
        ArrayList r20 = new ArrayList();
        if (r15 == null) goto L62;
        if (r15.length() <= 0) goto L62;
        int r113 = r15.length();
        int r21 = 0;
    L42:
        if (r21 >= r113) goto L64;
        String r22 = JSONArrayProtectorUtils.getString(r15, r21);
        if (AnnieFragmentManager.a(r22, false, 6) == true) goto L46;
        r20.add(r22);
    L58:
        if ((!r20.isEmpty()) == true) goto L59;
        r21 = r21 + 1;
        goto L42
    L59:
        CloseResModel r114 = new CloseResModel();
        r114.a(CloseResModel.Code.Failed);
        r114.b("multi ContainerId " + r20 + " is not matched");
        finishWithResult(r114);
        return;
    L46:
        WeakReference<HybridFragment> r23 = AnnieFragmentManager.b(r22);
        if (r23 == null) goto L49;
        HybridFragment r24 = r23.get();
    L50:
        if (r24 == null) goto L54;
        FragmentActivity r25 = r24.getActivity();
        if (r25 == null) goto L54;
        r25.finish();
    L54:
        com.bytedance.android.anniex.assemble.a r26 = com.bytedance.android.anniex.assemble.a.a;
        Intrinsics.checkNotNullParameter(r22, "containerId");
        ia.c r27 = AnnieXContainerManager.INSTANCE.getContainerById(r22);
        if (r27 == null) goto L58;
        r27.close();
        goto L58
    L49:
        r24 = null;
    L64:
        CloseResModel r115 = new CloseResModel();
        r115.a(CloseResModel.Code.Success);
        r115.b("Success");
        finishWithResult(r115);
        return;
    L62:
        if (AnnieFragmentManager.a(r13, false, 6) == true) goto L64;
        CloseResModel r116 = new CloseResModel();
        r116.a(CloseResModel.Code.Failed);
        r116.b("single ContainerId " + r13 + " is not matched");
        finishWithResult(r116);
        return;
    L14:
        if (StringsKt.isBlank(r13) == true) goto L17;
        r16 = false;
        goto L19
    L5:
        if (StringsKt.isBlank(r13) == true) goto L8;
        r14 = false;
        goto L9
    }
}
