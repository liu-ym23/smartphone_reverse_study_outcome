package com.obric.aikernel.service.res;

import com.bytedance.apm6.util.constant.NetConst;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.log.ILog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.obric.aikernel.runtime.utils.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5516a;

    public a(boolean r10) {
        this.f5516a = r10;
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void a(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        switch(r12) {
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L8;
        };
    L5:
        AIKLog.INSTANCE.e(r10, r11);
        return;
    L6:
        AIKLog.INSTANCE.w(r10, r11);
        return;
    L7:
        AIKLog.INSTANCE.i(r10, r11);
        return;
    L8:
        AIKLog.INSTANCE.d(r10, r11);
        return;
    L9:
        AIKLog.INSTANCE.v(r10, r11);
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void aeeLog(int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "content");
        if (this.f5516a == false) goto L7;
        ILog r13 = AIKLog.INSTANCE.getLogInterceptor();
        if (r13 == null) goto L9;
        r13.aeeLog(r10, r11, r12);
        return;
    L9:
        return;
    L7:
        AIKLog.INSTANCE.aeeLog(r10, r11, r12);
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void b(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "data");
        if (Intrinsics.areEqual(r11.optString("slardar"), NetConst.ENCRYPT_VERISON_CODE) == false) goto L5;
        JSONObject r12 = new JSONObject();
        r12.put("fromVm", 1);
        u7.d.a(r10, r11, r12, null);
    L5:
        u7.d.b(r10, r11);
    }
}
