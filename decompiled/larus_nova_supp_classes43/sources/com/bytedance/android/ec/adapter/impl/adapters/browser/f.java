package com.bytedance.android.ec.adapter.impl.adapters.browser;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends qe.a<JSONObject, Object> {
    public final /* synthetic */ IECBridgeMethod a;

    public final PermissionGroup getPermissionGroup() {
        IECBridgeMethod.Access r0 = this.a.getAccess();
        int r1 = qe.c.a[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L10;
        return PermissionGroup.PRIVATE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return PermissionGroup.PROTECTED;
    L13:
        return PermissionGroup.PUBLIC;
    }

    public final void onTerminate() {
        this.a.release();
    }

    public f(IECBridgeMethod r1) {
        this.a = r1;
    }

    public final void setFragment(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        IECBridgeMethod r0 = this.a;
        if ((r0 instanceof pd.a) == true) goto L5;
        r0 = null;
    L5:
        pd.a r1 = (pd.a) r0;
        if (r1 == null) goto L9;
        r1.setFragment(r10);
        return;
    }

    public final void invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        IECBridgeMethod.a.a(this.a, r11.getContext(), r12, new d(this), new e(r11));
    }

    public final void onActivityResult(int r10, int r11, Intent r12) {
        IECBridgeMethod r0 = this.a;
        if ((r0 instanceof pd.a) == true) goto L5;
        r0 = null;
    L5:
        pd.a r1 = (pd.a) r0;
        if (r1 == null) goto L9;
        r1.onActivityResult(r10, r11, r12);
        return;
    }
}
