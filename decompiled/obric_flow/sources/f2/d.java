package f2;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.OnPermissionGrantCallback;
import com.bytedance.ai.bridge.system.permission.AbsRequestPermissionMethodIDL;
import com.lynx.tasm.behavior.ui.utils.e;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements OnPermissionGrantCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f16874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f16875b;

    public d(Activity r5, f r10) {
        this.f16874a = r10;
        this.f16875b = r5;
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onAllGranted() {
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.PermissionResultModel.class, "<this>");
        BaseModel r5 = e.c(AbsRequestPermissionMethodIDL.PermissionResultModel.class);
        ((AbsRequestPermissionMethodIDL.PermissionResultModel) r5).setStatus(AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED);
        f r10 = this.f16874a;
        r10.b((ResultModel) r5, "");
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onNotGranted() {
        Activity r5 = this.f16875b;
        if ((r5 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r10 = (FragmentActivity) r5;
    L6:
        f r11 = this.f16874a;
        if (r10 != null) goto L9;
    L14:
        KClass r12 = Reflection.getOrCreateKotlinClass(AbsRequestPermissionMethodIDL.PermissionResultModel.class);
        Intrinsics.checkNotNullParameter(r12, "<this>");
        BaseModel r13 = e.c(JvmClassMappingKt.getJavaClass(r12));
        ((AbsRequestPermissionMethodIDL.PermissionResultModel) r13).setStatus(AbsRequestPermissionMethodIDL.PermissionStatus.UNDETERMINED);
        r11.b((ResultModel) r13, "");
        return;
    L9:
        if (ActivityCompat.shouldShowRequestPermissionRationale(r10, "android.permission.ACCESS_COARSE_LOCATION") == true) goto L11;
    L12:
        KClass r14 = Reflection.getOrCreateKotlinClass(AbsRequestPermissionMethodIDL.PermissionResultModel.class);
        Intrinsics.checkNotNullParameter(r14, "<this>");
        BaseModel r15 = e.c(JvmClassMappingKt.getJavaClass(r14));
        ((AbsRequestPermissionMethodIDL.PermissionResultModel) r15).setStatus(AbsRequestPermissionMethodIDL.PermissionStatus.DENIED);
        r11.b((ResultModel) r15, "");
        return;
    L11:
        if (ActivityCompat.shouldShowRequestPermissionRationale(r10, "android.permission.ACCESS_FINE_LOCATION") == true) goto L14;
    L5:
        r10 = null;
        goto L6
    }
}
