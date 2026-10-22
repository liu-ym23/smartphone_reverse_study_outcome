package i5;

import a5.d;
import ai.h0;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.JsonObject;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.obric.flow.cardlistpage.mvi.c {
    public static void l() {
        ArrayList r5 = new ArrayList();
        Pair r10 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new b());     // Catch: Throwable -> L9
        if (r10 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty((CharSequence) r10.first) == true) goto L14;
        r5.add(new bi.c((String) r10.first, (String) r10.second));     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        d5.b.e("ISettingRequestService", "host app has not add the tag lib as dependency");
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final d a() {
        k();     // Catch: Throwable -> L25
        String r5 = ((a5.c) this.f11531a).f99b;     // Catch: Throwable -> L25
        CopyOnWriteArrayList r10 = com.bytedance.ttnet.utils.d.f7541a;     // Catch: Throwable -> L25
        monitor-enter(com.bytedance.ttnet.utils.d.class);     // Catch: Throwable -> L25
        h0 r11 = com.bytedance.ttnet.utils.d.d(r5);     // Catch: Throwable -> L29
        monitor-enter(com.bytedance.ttnet.utils.d.class);     // Catch: Throwable -> L29
        if (r11 != null) goto L34;
        monitor-exit(com.bytedance.ttnet.utils.d.class);     // Catch: Throwable -> L29
        Object r12 = null;
    L16:
        monitor-exit(com.bytedance.ttnet.utils.d.class);     // Catch: Throwable -> L25
        if (r12 != null) goto L28;
        l();     // Catch: Throwable -> L25
        throw null;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        h.g("default_handle", th);     // Catch: Throwable -> L23
    L33:
        return null;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L28:
        throw new ClassCastException();     // Catch: Throwable -> L25
    L34:
        r12 = r11.b(a.class);     // Catch: Throwable -> L11
        monitor-exit(com.bytedance.ttnet.utils.d.class);     // Catch: Throwable -> L29
        goto L16
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        h.g("default_handle", th);
        goto L33
    }

    public final void k() {
        a5.c r5 = (a5.c) this.f11531a;
        if (r5.f98a != null) goto L5;
        d5.b.e("ISettingRequestService", "monitor setting aid should not be null");
    L5:
        JsonObject r10 = new JsonObject();
        String r11 = r5.f98a;
        if (r11 == null) goto L8;
        r10.addProperty(WsConstants.KEY_APP_ID, r11);
    L8:
        String r12 = r5.f100c;
        if (r12 == null) goto L11;
        r10.addProperty("os", r12);
    L11:
        String r13 = r5.d;
        if (r13 == null) goto L14;
        r10.addProperty("os_version", r13);
    L14:
        r5.getClass();
        String r14 = r5.e;
        if (r14 == null) goto L17;
        r10.addProperty(WsConstants.KEY_DEVICE_ID, r14);
    L17:
        String r15 = r5.f;
        if (r15 == null) goto L20;
        r10.addProperty(LynxMonitorService.KEY_CHANNEL, r15);
    L20:
        String r16 = r5.g;
        if (r16 == null) goto L23;
        r10.addProperty("version_code", r16);
    L23:
        String r17 = r5.f101h;
        if (r17 == null) goto L26;
        r10.addProperty("update_version_code", r17);
    L26:
        String r18 = r5.f102i;
        if (r18 == null) goto L29;
        r10.addProperty("region", r18);
    L29:
        String r19 = r5.f103j;
        if (r19 == null) goto L32;
        r10.addProperty("language", r19);
    L32:
        r10.addProperty("device_model", Build.MODEL);
        r10.addProperty(WsConstants.KEY_SDK_VERSION, "9.0.0");
        r10.addProperty("device_brand", Build.BRAND);
    }
}
