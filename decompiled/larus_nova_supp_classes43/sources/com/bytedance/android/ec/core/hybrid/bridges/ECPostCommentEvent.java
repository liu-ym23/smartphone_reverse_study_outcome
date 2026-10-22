package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECPostCommentEvent;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPostCommentEvent extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECPostCommentEvent() {
        this.e = "postCommentSuccess";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r12 = r10.optString(com.bytedance.android.ec.core.event.a.KEY_ORDER_ID);
        if (r12.length() <= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L11;
        int r14 = ECSdk.a;
        IECHostService r15 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r15 == null) goto L12;
        r15.postCommentEvent(r12);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r13 = false;
        goto L6
    }
}
