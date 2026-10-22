package com.bytedance.android.ec.common.impl.hybrid.bridges;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import of.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/ECLeavePageMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLeavePageMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECLeavePageMethod() {
        this.e = "ecLeavePage";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r12 = r10.optString(a.KEY_PAGE_ID, "");
        boolean r13 = r10.optBoolean("can_show_pendant", false);
        FragmentActivity r14 = getContext();
        if (r14 == null) goto L24;
        DialogFragment r0 = null;
        if ((r14 instanceof FragmentActivity) == true) goto L7;
        FragmentActivity r15 = null;
    L8:
        FragmentActivity r16 = r15;
        if (r16 == null) goto L20;
        FragmentManager r17 = r16.getSupportFragmentManager();
        if (r17 == null) goto L20;
        List r18 = r17.getFragments();
        if (r18 == null) goto L20;
        Iterator r19 = r18.iterator();
    L16:
        if (r19.hasNext() == false) goto L20;
        Fragment r1 = (Fragment) r19.next();
        if ((r1 instanceof DialogFragment) == false) goto L16;
        r0 = (DialogFragment) r1;
    L20:
        DialogFragment r20 = r0;
        int r21 = ECSdk.a;
        IECUserTrackerService r22 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r22 == null) goto L23;
        r22.leavePage(new b(r14, r12, r13, r20, 16));
    L23:
        r11.onSuccess(new JSONObject());
        return;
    L7:
        r15 = r14;
        goto L8
    L24:
        r11.onFailed(0, "get context fail");
    }
}
