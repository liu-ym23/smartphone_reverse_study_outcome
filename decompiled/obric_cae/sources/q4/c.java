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
import v4.i;

/* JADX INFO: loaded from: classes.dex */
public final class c implements e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f10154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ byte[] f10155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f10158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f10159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a f10160g;

    public c(a r8, HashMap r10, byte[] r11, String r12, String r13, long r14) {
        this.f10160g = r8;
        this.f10154a = r10;
        this.f10155b = r11;
        this.f10156c = r12;
        this.f10157d = r13;
        this.f10158e = 1;
        this.f10159f = r14;
    }

    @Override // c4.e.b
    public final JSONObject a() {
        JSONObject r8 = new JSONObject();
        JSONObject r10 = new JSONObject();
        Map r11 = this.f10154a;
        if (r11 != null) goto L36;
    L9:
        byte[] r12 = this.f10155b;
        a r13 = this.f10160g;
        if (r12 != null) goto L12;
    L30:
        JSONObject r14 = null;
    L40:
        r8.put("appId", r13.f10135b.f11401i);     // Catch: Throwable -> L33
        r8.put("nid", this.f10156c);     // Catch: Throwable -> L33
        r8.put(WsConstants.KEY_CONNECTION_URL, this.f10157d);     // Catch: Throwable -> L33
        r8.put("data", r14);     // Catch: Throwable -> L33
        r8.put(CloudServiceConstants.OCloud.HEADER, r10);     // Catch: Throwable -> L33
        r8.put(BdimCategoryConstants.INTENT_KEY_METHOD, this.f10158e);     // Catch: Throwable -> L33
        r8.put("time", this.f10159f);     // Catch: Throwable -> L33
    L34:
        return r8;
    L33:
        r13.f10135b.f11417y.b(k.X, 1);
        goto L34
    L12:
        if (r12.length <= 0) goto L30;
        String r15 = new String(r12);
        if (i.g(r15) == false) goto L17;
    L25:
        boolean r16 = false;
    L26:
        if (r16 == false) goto L30;
        r14 = new JSONObject(r15);     // Catch: Throwable -> L29
    L29:
        r13.f10135b.f11417y.b(k.X, 1);
        goto L30
    L17:
        if (r15.startsWith("{") == false) goto L21;
        if (r15.startsWith("}") == false) goto L21;
    L24:
        r16 = true;
    L21:
        if (r15.startsWith("[") == false) goto L25;
        if (r15.endsWith("]") == false) goto L25;
    L36:
        Iterator r17 = r11.entrySet().iterator();     // Catch: Throwable -> L35
    L6:
        if (r17.hasNext() == false) goto L9;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L35
        r10.put((String) r18.getKey(), r18.getValue());     // Catch: Throwable -> L35
        goto L6
    }
}
