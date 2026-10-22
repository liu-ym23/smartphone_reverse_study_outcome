package zf;

import cf.o;
import cf.p;
import com.bytedance.android.ec.common.api.IPageStateService;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements p {
    public final Map<String, Object> a;
    public final o b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Integer g;

    /* JADX INFO: renamed from: zf.a$a, reason: collision with other inner class name */
    public static final class C0218a {
    }

    static {
    }

    @Override // cf.p
    public final void onCreate() {
        o r0 = this.b;
        if (r0 == null) goto L6;
        r0.onCreate();
        return;
    }

    @Override // cf.p
    public final void onDestroy() {
        o r0 = this.b;
        if (r0 == null) goto L6;
        r0.onDestroy();
    L6:
        if (this.d == true) goto L11;
        this.d = true;
        o r1 = this.b;
        if (r1 == null) goto L12;
        r1.g();
        return;
    L12:
        return;
    }

    @Override // cf.p
    public final void onPause() {
        o r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPause();
        return;
    }

    @Override // cf.p
    public final void onResume() {
        o r0 = this.b;
        if (r0 == null) goto L6;
        r0.onResume();
    L6:
        if (this.c == true) goto L11;
        this.c = true;
        o r1 = this.b;
        if (r1 == null) goto L12;
        r1.f();
        return;
    L12:
        return;
    }

    @Override // cf.p
    public final void onStart() {
        o r0 = this.b;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    @Override // cf.p
    public final void onStop() {
        o r0 = this.b;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    @Override // cf.p
    public final void a(boolean r10) {
        o r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r10);
        return;
    }

    @Override // cf.p
    public final void b(int r1) {
        o r10 = this.b;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    public a(String r10, String r11) {
        this.a = MapsKt.mapOf(TuplesKt.to("page_state_listener_extra", r11));
        if (r10 == null) goto L7;
        int r12 = ECSdk.a;
        IPageStateService r13 = (IPageStateService) ECSdk.a(IPageStateService.class);
        if (r13 == null) goto L7;
        o r14 = r13.getPageStateListener(r10);
    L8:
        this.b = r14;
        return;
    L7:
        r14 = null;
        goto L8
    }

    @Override // cf.p
    public final void d(int r10, int r11, float r12) {
        Integer r0 = this.g;
        if (r0 != null) goto L6;
    L7:
        o r1 = this.b;
        if (r1 == null) goto L10;
        r1.d(r10, r11, r12);
    L10:
        this.g = Integer.valueOf(r10);
        if (r12 != 0.0f) goto L20;
        if (this.c == false) goto L20;
        if (this.e == true) goto L20;
        this.e = true;
        o r13 = this.b;
        if (r13 == null) goto L29;
        r13.c();
        return;
    L29:
        return;
    L20:
        if (r12 == (-1.0f)) goto L22;
        return;
    L22:
        if (this.d == true) goto L24;
        return;
    L24:
        if (this.f == true) goto L33;
        this.f = true;
        o r14 = this.b;
        if (r14 == null) goto L34;
        r14.b();
        return;
    L34:
        return;
    L33:
        return;
    L6:
        if (r0.intValue() == r10) goto L10;
        goto L7
    }
}
