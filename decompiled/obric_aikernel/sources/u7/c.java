package u7;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13139a = null;

    static {
        f13139a = new c();
    }

    private c() {
    }

    public static /* synthetic */ void b(c r10, String r11, String r12, String r13, String r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r13 = null;
    L6:
        if ((r15 & 8) == 0) goto L8;
        r14 = null;
    L8:
        r10.a(r11, r12, r13, r14);
    }

    public final void a(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, "info");
        TrackerApi r14 = TrackerApi.INSTANCE;
        JSONObject r15 = new JSONObject();
        r15.put(WsConstants.KEY_CONNECTION_TYPE, r10);
        AppContext r16 = AppContext.INSTANCE;
        r15.put("isAdminMode", r16.isAdminMode());
        r15.put("isDebug", r16.isDebug());
        if (r12 == null) goto L5;
        r15.put("extraCategory1", r12);
    L5:
        if (r13 == null) goto L7;
        r15.put("extraCategory2", r13);
    L7:
        Unit r17 = Unit.INSTANCE;
        JSONObject r18 = new JSONObject();
        r18.put("info", r11);
        r14.monitorEvent("app_error", r15, null, r18);
    }
}
