package u3;

import c4.l;
import org.json.JSONObject;
import x4.x;

/* JADX INFO: loaded from: classes.dex */
public final class d implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f12427a;

    public class a implements c4.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f12431d;

        public a(d r8, String r10, String r11, String r12) {
            this.f12431d = r8;
            this.f12428a = r10;
            this.f12429b = r11;
            this.f12430c = r12;
        }

        @Override // c4.e.b
        public final JSONObject a() {
            JSONObject r8 = new JSONObject();
            r8.put("appId", this.f12431d.f12427a.f12439d.f11401i);     // Catch: Throwable -> L5
            r8.put("did", this.f12428a);     // Catch: Throwable -> L5
            r8.put("ssid", this.f12429b);     // Catch: Throwable -> L5
            r8.put("installId", this.f12430c);     // Catch: Throwable -> L5
        L4:
            return r8;
        }
    }

    public class b implements c4.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f12435d;

        public b(d r8, String r10, String r11, String r12) {
            this.f12435d = r8;
            this.f12432a = r10;
            this.f12433b = r11;
            this.f12434c = r12;
        }

        @Override // c4.e.b
        public final JSONObject a() {
            JSONObject r8 = new JSONObject();
            r8.put("appId", this.f12435d.f12427a.f12439d.f11401i);     // Catch: Throwable -> L5
            r8.put("did", this.f12432a);     // Catch: Throwable -> L5
            r8.put("installId", this.f12433b);     // Catch: Throwable -> L5
            r8.put("ssid", this.f12434c);     // Catch: Throwable -> L5
        L4:
            return r8;
        }
    }

    public d(e r8) {
        this.f12427a = r8;
    }

    @Override // x4.x
    public final void onIdLoaded(String r8, String r10, String r11) {
        e r12 = this.f12427a;
        r12.f12443h = r8;
        r12.f12444i = r10;
        r3.c r13 = r12.f12439d;
        v4.a r14 = r13.f11408p;
        if (r14 == null) goto L5;
        r14.onIdLoaded(r8, r10, r11);
    L5:
        r13.f11417y.i(r8);
        if (l.b() == true) goto L9;
        l.c("local_did_load", new a(this, r8, r11, r10));
        return;
    }

    @Override // x4.x
    public final void onRemoteIdGet(boolean r13, String r14, String r15, String r16, String r17, String r18, String r19) {
        e r8 = this.f12427a;
        r8.f12443h = r15;
        r8.f12444i = r17;
        r3.c r11 = r8.f12439d;
        v4.a r10 = r11.f11408p;
        if (r10 == null) goto L5;
        r10.onRemoteIdGet(r13, r14, r15, r16, r17, r18, r19);
    L5:
        r11.f11417y.i(r15);
        if (l.b() == true) goto L9;
        l.c("device_register_end", new b(this, r15, r17, r19));
        return;
    }
}
