package q4;

import c4.e;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import i4.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f10147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f10150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f10151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f10152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a f10153g;

    public b(a r8, HashMap r10, String r11, String r12, JSONObject r13, int r14, long r15) {
        this.f10153g = r8;
        this.f10147a = r10;
        this.f10148b = r11;
        this.f10149c = r12;
        this.f10150d = r13;
        this.f10151e = r14;
        this.f10152f = r15;
    }

    @Override // c4.e.b
    public final JSONObject a() {
        JSONObject r8 = new JSONObject();
        JSONObject r10 = new JSONObject();
        a r11 = this.f10153g;
        Map r12 = this.f10147a;
        if (r12 == null) goto L16;
        Iterator r13 = r12.entrySet().iterator();     // Catch: Throwable -> L9
    L6:
        if (r13.hasNext() == false) goto L16;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L9
        r10.put((String) r14.getKey(), r14.getValue());     // Catch: Throwable -> L9
    L9:
        r11.f10135b.f11417y.b(k.X, 1);
    L16:
        r8.put("appId", r11.f10135b.f11401i);     // Catch: Throwable -> L12
        r8.put("nid", this.f10148b);     // Catch: Throwable -> L12
        r8.put(WsConstants.KEY_CONNECTION_URL, this.f10149c);     // Catch: Throwable -> L12
        r8.put("data", this.f10150d);     // Catch: Throwable -> L12
        r8.put(CloudServiceConstants.OCloud.HEADER, r10);     // Catch: Throwable -> L12
        r8.put(BdimCategoryConstants.INTENT_KEY_METHOD, this.f10151e);     // Catch: Throwable -> L12
        r8.put("time", this.f10152f);     // Catch: Throwable -> L12
    L13:
        return r8;
    L12:
        r11.f10135b.f11417y.b(k.X, 1);
        goto L13
    }
}
