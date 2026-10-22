package g4;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.OnPermissionGrantCallback;
import com.bytedance.ai.bridge.system.permission.AbsRequestPermissionMethodIDL;
import f3.h;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements OnPermissionGrantCallback {
    public final /* synthetic */ h<AbsRequestPermissionMethodIDL.b> a;
    public final /* synthetic */ Activity b;

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onAllGranted() {
        h<AbsRequestPermissionMethodIDL.b> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.b.class, "<this>");
        BaseModel r1 = k3.c.a(AbsRequestPermissionMethodIDL.b.class);
        ((AbsRequestPermissionMethodIDL.b) r1).setStatus(AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED);
        h.a.b(r0, (ResultModel) r1);
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onNotGranted() {
        FragmentActivity r0 = this.b;
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 != null) goto L8;
    L12:
        h<AbsRequestPermissionMethodIDL.b> r10 = this.a;
        BaseModel r11 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsRequestPermissionMethodIDL.b.class));
        ((AbsRequestPermissionMethodIDL.b) r11).setStatus(AbsRequestPermissionMethodIDL.PermissionStatus.UNDETERMINED);
        h.a.b(r10, (ResultModel) r11);
        return;
    L8:
        if (ActivityCompat.shouldShowRequestPermissionRationale(r1, "android.permission.ACCESS_COARSE_LOCATION") == true) goto L10;
    L11:
        h<AbsRequestPermissionMethodIDL.b> r12 = this.a;
        BaseModel r13 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsRequestPermissionMethodIDL.b.class));
        ((AbsRequestPermissionMethodIDL.b) r13).setStatus(AbsRequestPermissionMethodIDL.PermissionStatus.DENIED);
        h.a.b(r12, (ResultModel) r13);
        return;
    L10:
        if (ActivityCompat.shouldShowRequestPermissionRationale(r1, "android.permission.ACCESS_FINE_LOCATION") == true) goto L12;
    L5:
        r1 = null;
        goto L6
    }

    public e(h<AbsRequestPermissionMethodIDL.b> r1, Activity r10) {
        this.a = r1;
        this.b = r10;
    }
}
