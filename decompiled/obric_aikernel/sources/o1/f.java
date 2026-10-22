package o1;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.compress.CompressManager;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.applog.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g1.b f11377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CompressManager f11378b;

    class a implements y0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.applog.c f11379a;

        a(f r10, com.bytedance.applog.c r11) {
            this.f11379a = r11;
        }

        @Override // y0.b
        public void a(String r10, JSONObject r11) {
            this.f11379a.a(r10, r11);
        }
    }

    public f(com.bytedance.applog.c r10, g1.b r11) {
        this.f11377a = r11;
        this.f11378b = new CompressManager(r10.w(), com.bytedance.applog.b.b(r10, CompressManager.DEFAULT_SP_NAME), new a(this, r10), r10.P());
    }

    @Override // com.bytedance.applog.l
    public com.bytedance.applog.e a(byte[] r10) {
        com.bytedance.applog.e r11 = new com.bytedance.applog.e();
        y0.a r12 = new y0.a();
        r11.d(this.f11378b.compress(r10, this.f11377a.m(), r12));
        r11.e(r12.f13628c);
        HashMap r13 = new HashMap(4);
        int r14 = r12.f13628c;
        String r15 = "log-encode-type";
        if (r14 != 0) goto L7;
        String r16 = NetConst.GZIP;
    L5:
        r13.put(r15, r16);
    L11:
        r11.f(r13);
        return r11;
    L7:
        if (r14 != 1) goto L9;
    L10:
        r13.put("log-encode-type", NetConst.TYPE_ZSTD);
        r16 = String.valueOf(0);
        r15 = "log-encode-token";
        goto L5
    L9:
        if (r14 != 2) goto L11;
        goto L10
    }
}
