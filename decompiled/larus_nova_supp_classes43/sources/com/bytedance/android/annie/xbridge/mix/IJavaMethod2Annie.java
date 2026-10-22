package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/IJavaMethod2Annie;", "Lcom/bytedance/android/annie/xbridge/mix/BaseBridgeMethod;", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class IJavaMethod2Annie extends BaseBridgeMethod {
    public n56.c c;
    public boolean d;

    public abstract n56.c c(m16.b r1);

    public final boolean i90() {
        return this.d;
    }

    public IJavaMethod2Annie(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        super(r10);
        this.d = true;
    }

    @Override // com.bytedance.android.annie.xbridge.mix.BaseBridgeMethod
    public final void b(JSONObject r10, BaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        JSONObject r12 = new JSONObject();
        n56.f r13 = new n56.f();
        r13.d = r10;
        r13.c = getName();
        if (this.c != null) goto L19;
        this.c = c(((com.bytedance.ies.bullet.core.kit.bridge.c) this).a);
    L19:
        n56.c r14 = this.c;     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L16
        r14.call(r13, r12);     // Catch: Exception -> L16
        this.d = r13.j;     // Catch: Exception -> L16
        h16.e r15 = (h16.e) ((com.bytedance.ies.bullet.core.kit.bridge.c) this).a.c(h16.e.class);     // Catch: Exception -> L16
        if (r15 == null) goto L10;
        com.bytedance.ies.bullet.service.base.o r16 = r15.getKitView();     // Catch: Exception -> L16
        if (r16 == null) goto L10;
        KitType r17 = r16.getKitType();     // Catch: Exception -> L16
    L12:
        if (r17 != KitType.LYNX) goto L14;
        Object r18 = r12.remove("code");     // Catch: Exception -> L16
        r12.remove("__data");     // Catch: Exception -> L16
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L16
        r19.put("data", r12);     // Catch: Exception -> L16
        r19.put("__msg_type", "callback");     // Catch: Exception -> L16
        r19.put("eventId", CastLongProtector.parseLong(r12.optString("__callback_id", "0")));     // Catch: Exception -> L16
        r19.put("__callback_id", "0");     // Catch: Exception -> L16
        r19.put("code", r18);     // Catch: Exception -> L16
        r11.b(r19);     // Catch: Exception -> L16
        return;
    L14:
        r11.b(r12);     // Catch: Exception -> L16
        return;
    L10:
        r17 = null;
    L16:
        e = move-exception;
        r11.a("[IJavaMethod2Annie]： " + e.getMessage());
    }
}
