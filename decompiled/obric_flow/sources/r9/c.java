package r9;

import android.app.Application;
import android.util.Log;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import bi.f;
import com.bytedance.ies.bullet.service.schema.SchemaMonitorEvent;
import com.bytedance.keva.Keva;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.TTNetInit;
import com.lynx.tasm.utils.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.ProtoBuf$MemberKind;
import kotlinx.metadata.internal.protobuf.r;
import kotlinx.metadata.internal.protobuf.s;
import org.threeten.bp.Year;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements s, ee.a, rd.d, com.bytedance.sdk.xbridge.cn.utils.a, k0.c, m2.b, okhttp3.b, i, bi.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f21704b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile d f21705c;
    public static volatile c d;
    public static int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21706a;

    public /* synthetic */ c(int r5) {
        this.f21706a = r5;
    }

    public static c h() {
        if (d != null) goto L19;
        monitor-enter(c.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L14;
        c r5 = new c(0);     // Catch: Throwable -> L12
        if (f21705c != null) goto L11;
        d r10 = new d();     // Catch: Throwable -> L12
        r10.f21707a = 8;     // Catch: Throwable -> L12
        r10.f21709c = 8;     // Catch: Throwable -> L12
        r10.f21708b = 8;     // Catch: Throwable -> L12
        r10.d = 8;     // Catch: Throwable -> L12
        r10.e = 30;     // Catch: Throwable -> L12
        r10.g = 10;     // Catch: Throwable -> L12
        r10.f = 10;     // Catch: Throwable -> L12
        r10.f21710h = true;     // Catch: Throwable -> L12
        f21705c = r10.a();     // Catch: Throwable -> L12
    L11:
        d = r5;     // Catch: Throwable -> L12
    L14:
        monitor-exit(c.class);     // Catch: Throwable -> L12
    L19:
        return d;
    }

    public static synchronized d i() {
        monitor-enter(c.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f21705c != null) goto L9;
        d r5 = new d();     // Catch: Throwable -> L7
        r5.f21707a = 8;     // Catch: Throwable -> L7
        r5.f21709c = 8;     // Catch: Throwable -> L7
        r5.f21708b = 8;     // Catch: Throwable -> L7
        r5.d = 8;     // Catch: Throwable -> L7
        r5.e = 30;     // Catch: Throwable -> L7
        r5.g = 10;     // Catch: Throwable -> L7
        r5.f = 10;     // Catch: Throwable -> L7
        r5.f21710h = true;     // Catch: Throwable -> L7
        f21705c = r5.a();     // Catch: Throwable -> L7
    L9:
        d r10 = f21705c;     // Catch: Throwable -> L7
        monitor-exit(c.class);
        return r10;
    }

    @Override // m2.b
    public String a(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "storage");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        return Keva.getRepo(r5).getString(r10, r11);
    }

    @Override // bi.b
    public f b(Request r5) {
        r5.getUrl();
        e.h();
        TTNetInit.getTTNetDepend();
        throw null;
    }

    @Override // k0.c
    public void c(k0.d r5) {
        r5.onStart();
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        return Year.from(r5);
    }

    @Override // k0.c
    public void e(k0.d r5) {
    }

    @Override // m2.b
    public void f(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "storage");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Keva.getRepo(r5).storeString(r10, r11);
    }

    @Override // kotlinx.metadata.internal.protobuf.s
    public r findValueByNumber(int r5) {
        return ProtoBuf$MemberKind.valueOf(r5);
    }

    @Override // rd.d
    public void g(SchemaMonitorEvent r5, com.bytedance.ies.bullet.service.sdk.b r10, Map r11, Map r12, LinkedHashMap r13) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        Intrinsics.checkNotNullParameter(r11, "info");
    }

    public c() {
        this.f21706a = 9;
        if (e != 0) goto L22;
        ps.a.a("SDK_INIT", "BUILD_NO: [20260716-20:31:00|release|2.0.1|07fcfa28|20260716-18:05:51_feature: OToast add api setWindowType to support be added in Application_Overlay type Window]");
        sq.a r10 = sq.a.f21991a;
    L17:
        e = move-exception;
        ps.a.b(e, "OUISdk", "init failed");
        goto L22
    L6:
        if (sq.a.f21992b == true) goto L19;
        long r5 = System.currentTimeMillis();     // Catch: Exception -> L17
        Application r11 = null;
        r11 = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);     // Catch: Exception -> L11
    L13:
        if (r11 == null) goto L16;
        r11.registerComponentCallbacks(r10);     // Catch: Exception -> L17
    L16:
        rp.b.f21793a = rp.b.f21794b;     // Catch: Exception -> L17
        sq.a.f21992b = true;     // Catch: Exception -> L17
        ps.a.a("OUISdk", "init success, cost: " + (System.currentTimeMillis() - r5) + " ms");     // Catch: Exception -> L17
        goto L22
    L11:
        e = move-exception;
        ps.a.b(e, "OUISdk", "getApplicationReflect failed");     // Catch: Exception -> L17
        goto L13
    L19:
        ps.a.a("OUISdk", "init already");     // Catch: Exception -> L17
    L22:
        e++;
    }

    @Override // rd.d, com.bytedance.sdk.xbridge.cn.utils.a
    public void a(String r5) {
        switch(this.f21706a) {
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.i("BulletLog", r5);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "message");
    }

    @Override // m2.b
    public void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "storage");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Keva.getRepo(r5).erase(r10);
    }
}
