package com.bytedance.android.annie.bridge.method.permission;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.bridge.method.abs.RequestPermissionResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements q9.c {
    public final /* synthetic */ RequestPermissionMethod a;
    public final /* synthetic */ CallContext b;

    public e(RequestPermissionMethod r1, CallContext r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // q9.c
    public final void onResult(boolean r10, Map<String, ? extends PermissionStatus> r11) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        if (r10 == false) goto L5;
        RequestPermissionMethod r12 = this.a;
        RequestPermissionResultModel r13 = new RequestPermissionResultModel();
        r13.a(RequestPermissionResultModel.Code.Success);
        r13.c(RequestPermissionResultModel.Status.Permitted.toString());
        r13.b("permission is allGranted");
        r12.finishWithResult(r13);
        return;
    L5:
        FragmentActivity r14 = this.b;
        if ((r14 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r15 = r14;
    L9:
        if (r15 != null) goto L11;
    L15:
        RequestPermissionMethod r16 = this.a;
        RequestPermissionResultModel r17 = new RequestPermissionResultModel();
        r17.a(RequestPermissionResultModel.Code.Success);
        r17.c(RequestPermissionResultModel.Status.Undetermined.toString());
        r17.b("permission is UNDETERMINED");
        r16.finishWithResult(r17);
        return;
    L11:
        if (ActivityCompat.shouldShowRequestPermissionRationale(r15, "android.permission.ACCESS_COARSE_LOCATION") == true) goto L13;
    L14:
        RequestPermissionMethod r18 = this.a;
        RequestPermissionResultModel r19 = new RequestPermissionResultModel();
        r19.a(RequestPermissionResultModel.Code.Success);
        r19.c(RequestPermissionResultModel.Status.Denied.toString());
        r19.b("permission is DENIED");
        r18.finishWithResult(r19);
        return;
    L13:
        if (ActivityCompat.shouldShowRequestPermissionRationale(r15, "android.permission.ACCESS_FINE_LOCATION") == true) goto L15;
    L8:
        r15 = null;
        goto L9
    }
}
