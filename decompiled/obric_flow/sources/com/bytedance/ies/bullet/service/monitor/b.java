package com.bytedance.ies.bullet.service.monitor;

import android.util.Log;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.core.o;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ies.bullet.core.e f6036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6037b;

    public b() {
        this.f6037b = new a();
    }

    public void A() {
    }

    public void B() {
    }

    public void C() {
    }

    public void D() {
    }

    public void E() {
    }

    public void F() {
    }

    public void G() {
    }

    public void H() {
        Intrinsics.checkNotNullParameter("kit_load_start", STGroup.DICT_KEY);
    }

    public void I() {
    }

    public void J() {
    }

    public long a(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return 0;
    }

    public LinkedHashMap b() {
        return new LinkedHashMap();
    }

    public void c(long r5, boolean r10) {
    }

    public void d(com.bytedance.ies.bullet.core.e r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (this.f6036a == null) goto L6;
        Log.e("BulletMonitor-Callback", "redundancy onBulletContextCreated");
        return;
    L6:
        this.f6036a = r5;
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r11 == null) goto L9;
        xc.f r12 = (xc.f) r11.a(xc.f.class);
    L10:
        if (r12 != null) goto L12;
        return;
    L12:
        if (r12.e() == true) goto L16;
        b r13 = new b();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r5.f5293c = r13;
        return;
    L16:
        return;
    L9:
        r12 = null;
        goto L10
    }

    public void e(com.bytedance.ies.bullet.core.e r5, Integer r10, Float r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
    }

    public void f(AbsBulletMonitorCallback$ErrStage r5, String r10) {
        Intrinsics.checkNotNullParameter(AbsBulletMonitorCallback$ErrStage.f6029b, "errStage");
        Intrinsics.checkNotNullParameter(r10, "errMessage");
    }

    public void g(BulletCardView r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorContainer");
    }

    public void i(Long r5) {
    }

    public void j(String r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "block");
        r10.invoke();
    }

    public void k(String r5, JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
    }

    public o l() {
        return this.f6037b;
    }

    public void m(BulletCardView r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorContainer");
    }

    public void n(String r5) {
    }

    public final com.bytedance.ies.bullet.core.e o() {
        com.bytedance.ies.bullet.core.e r5 = this.f6036a;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mBulletContext");
        return null;
    L6:
        return r5;
    }

    public void p(String r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
    }

    public final String q() {
        com.bytedance.ies.bullet.core.e r5 = this.f6036a;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mBulletContext");
        r5 = null;
    L6:
        return r5.getSessionId();
    }

    public void r() {
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
    }

    public void x() {
    }

    public void y() {
    }

    public void z() {
    }
}
