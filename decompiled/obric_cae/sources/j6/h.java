package j6;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8737a;

    public h(Context r8) {
        this.f8737a = r8;
    }

    public static boolean a(IWsApp r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.k() > 0) goto L9;
        return false;
    L9:
        if (r8.getAppId() > 0) goto L12;
        return false;
    L12:
        if (r5.f.b(r8.n()) == false) goto L15;
        return false;
    L15:
        if (r8.o() > 0) goto L18;
        return false;
    L18:
        if (r8.s().isEmpty() == false) goto L21;
        return false;
    L21:
        if (r5.f.b(r8.getDeviceId()) == false) goto L24;
        return false;
    L24:
        if (r8.q() > 0) goto L27;
        return false;
    L27:
        if (r5.f.b(r8.j()) == false) goto L30;
        return false;
    L30:
        if (r8.m() == 0) goto L32;
        return false;
    L32:
        return true;
    }

    public final LinkedHashMap b() {
        LinkedHashMap r8 = new LinkedHashMap();
        String r10 = "";
        WsChannelMultiProcessSharedProvider.b r11 = com.bytedance.common.wschannel.a.a(this.f8737a).f3869a;     // Catch: Exception -> L31
        Context r12 = r11.f3865a;     // Catch: Exception -> L31
        int r13 = 0;
        if (r11.f3866b == false) goto L9;
        String r14 = r11.f3867c.getString(WsConstants.KEY_WS_APPS, "");     // Catch: Throwable -> L36
    L20:
        Logger.d("h", "load from sp : " + r14);     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r14) == false) goto L23;
        return r8;
    L23:
        JSONArray r15 = new JSONArray(r14);     // Catch: Exception -> L31
        int r16 = r15.length();     // Catch: Exception -> L31
        if (r16 > 0) goto L26;
        return r8;
    L26:
        if (r13 >= r16) goto L33;
        SsWsApp r17 = SsWsApp.b.a(r15.optJSONObject(r13));     // Catch: Exception -> L31
        if (a(r17) == false) goto L30;
        int r18 = WsChannelService.f3926m;     // Catch: Exception -> L31
        r8.put(Integer.valueOf(r17.k()), r17);     // Catch: Exception -> L31
    L30:
        r13 = r13 + 1;
    L33:
        return r8;
    L9:
        Cursor r19 = r12.getContentResolver().query(WsChannelMultiProcessSharedProvider.a(r12, WsConstants.KEY_WS_APPS, "string"), null, null, null, null);     // Catch: Throwable -> L36
        if (r19 == null) goto L19;
        if (r19.moveToFirst() == false) goto L16;
        String r20 = r19.getString(0);     // Catch: Throwable -> L35
    L42:
        r19.close();     // Catch: Exception -> L34 Throwable -> L36
    L18:
        r10 = r20;
    L16:
        r20 = "";
    L19:
        r14 = r10;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    public final void c(ConcurrentHashMap r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        JSONArray r10 = new JSONArray();
        monitor-enter(WsChannelService.class);
        Iterator r11 = r8.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r11.hasNext() == false) goto L16;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L22
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L8
    L11:
        if (a((IWsApp) r12.getValue()) == false) goto L8;
        r10.put(((IWsApp) r12.getValue()).l());     // Catch: Exception -> L14 Throwable -> L22
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        Logger.d("h", "save to sp : " + r10.toString());     // Catch: Exception -> L19
        com.bytedance.common.wschannel.a.a(this.f8737a).b(r10.toString());     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
