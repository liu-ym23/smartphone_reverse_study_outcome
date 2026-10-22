package g4;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.OnPermissionCallback;
import com.bytedance.ai.bridge.service.PermissionState;
import com.bytedance.ai.bridge.system.permission.AbsRequestPermissionMethodIDL;
import f3.h;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements OnPermissionCallback {
    public final /* synthetic */ h<AbsRequestPermissionMethodIDL.b> a;

    public d(h<AbsRequestPermissionMethodIDL.b> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionCallback
    public final void onResult(boolean r10, Map<String, ? extends PermissionState> r11) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        h<AbsRequestPermissionMethodIDL.b> r1 = this.a;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.b.class, "<this>");
        BaseModel r12 = k3.c.a(AbsRequestPermissionMethodIDL.b.class);
        AbsRequestPermissionMethodIDL.b r13 = (AbsRequestPermissionMethodIDL.b) r12;
        if (r10 == false) goto L5;
        AbsRequestPermissionMethodIDL.PermissionStatus r14 = AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED;
    L15:
        r13.setStatus(r14);
        h.a.b(r1, (ResultModel) r12);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        Iterator<T> r15 = r11.values().iterator();
    L7:
        if (r15.hasNext() == false) goto L11;
        if (((PermissionState) r15.next()) != PermissionState.REJECTED) goto L7;
        boolean r16 = true;
    L12:
        if (r16 == true) goto L14;
        r14 = AbsRequestPermissionMethodIDL.PermissionStatus.UNDETERMINED;
        goto L15
    L14:
        r14 = AbsRequestPermissionMethodIDL.PermissionStatus.DENIED;
        goto L15
    L11:
        r16 = false;
        goto L12
    }
}
