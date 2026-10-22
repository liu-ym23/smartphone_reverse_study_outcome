package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/GetCurrentGCJLocationMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "Lpd/a;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetCurrentGCJLocationMethod extends ECBaseBridgeMethod implements pd.a {
    public final String e;
    public final wi.c f;

    public static final class a {
    }

    static {
    }

    @Override // pd.a
    public final void setFragment(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
    }

    public final void release() {
        wi.c r0 = this.f;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public GetCurrentGCJLocationMethod() {
        this.e = "ecGetCurrentGCJLocation";
        this.f = com.bytedance.android.ec.sdk.helper.d.b.getLocationService();
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        wi.c r0 = this.f;
        if (r0 != null) goto L18;
        return;
    L18:
        r0.f();     // Catch: Exception -> L15
        if (r10.optInt("silent") != 1) goto L8;
        boolean r1 = true;
    L9:
        r10.optInt("forceLocate");     // Catch: Exception -> L15
        if (r1 == true) goto L13;
        wi.c r12 = this.f;     // Catch: Exception -> L15
        Context r13 = getContext();     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L15
        r12.c(r13, r11);     // Catch: Exception -> L15
        return;
    L13:
        wi.c r14 = this.f;     // Catch: Exception -> L15
        Context r15 = getContext();     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r15);     // Catch: Exception -> L15
        r14.b(r15, r11);     // Catch: Exception -> L15
        return;
    L8:
        r1 = false;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // pd.a
    public final void onActivityResult(int r1, int r10, Intent r11) {
        wi.c r12 = this.f;
        if (r12 == null) goto L6;
        r12.onActivityResult();
        return;
    }
}
