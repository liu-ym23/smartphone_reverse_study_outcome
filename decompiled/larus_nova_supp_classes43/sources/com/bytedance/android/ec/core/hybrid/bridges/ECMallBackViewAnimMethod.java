package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECMallBackViewAnimMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallBackViewAnimMethod extends ECBaseBridgeMethod {
    public static WeakReference<Function1<Boolean, Unit>> e;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "ec.mallBackViewAnim";
    }

    public ECMallBackViewAnimMethod() {
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        boolean r12 = r10.optBoolean("isExpand", false);
        WeakReference<Function1<Boolean, Unit>> r13 = e;
        if (r13 == null) goto L8;
        Function1<Boolean, Unit> r14 = r13.get();
        if (r14 == null) goto L9;
        Unit r15 = (Unit) r14.invoke(Boolean.valueOf(r12));
        return;
    L9:
        return;
    }
}
