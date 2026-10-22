package h4;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.ShowActionSheetListener;
import com.bytedance.ai.bridge.system.ui.AbsShowActionSheetMethodIDL;
import com.bytedance.ai.utils.g;
import f3.h;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements ShowActionSheetListener {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ h<AbsShowActionSheetMethodIDL.b> b;

    @Override // com.bytedance.ai.bridge.service.ShowActionSheetListener
    public final void onDismiss() {
        if (this.a.compareAndSet(false, true) == false) goto L6;
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call failed, errNo=");
        f3.a r10 = f3.a.o;
        r1.append(r10.a);
        r1.append(", msg=cancel");
        r0.e("AISDK_JSB_ShowActionSheetMethod", r1.toString());
        h.a.a(this.b, "cancel", r10, null, 10);
        return;
    }

    @Override // com.bytedance.ai.bridge.service.ShowActionSheetListener
    public final void onSelect(int r10) {
        if (this.a.compareAndSet(false, true) == false) goto L6;
        g.a.i("AISDK_JSB_ShowActionSheetMethod", "call success, tapIndex=" + r10);
        h<AbsShowActionSheetMethodIDL.b> r0 = this.b;
        Intrinsics.checkNotNullParameter(AbsShowActionSheetMethodIDL.b.class, "<this>");
        BaseModel r1 = k3.c.a(AbsShowActionSheetMethodIDL.b.class);
        ((AbsShowActionSheetMethodIDL.b) r1).setTapIndex(r10);
        h.a.b(r0, (ResultModel) r1);
        return;
    }

    public a(AtomicBoolean r1, h<AbsShowActionSheetMethodIDL.b> r10) {
        this.a = r1;
        this.b = r10;
    }
}
