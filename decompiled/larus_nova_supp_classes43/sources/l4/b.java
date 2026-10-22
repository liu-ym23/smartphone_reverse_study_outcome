package l4;

import com.bytedance.ai.bridge.service.OnPermissionCallback;
import com.bytedance.ai.bridge.service.PermissionState;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements OnPermissionCallback {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionCallback
    public final void onResult(boolean r10, Map<String, ? extends PermissionState> r11) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        this.a.invoke(Boolean.valueOf(r10));
    }
}
