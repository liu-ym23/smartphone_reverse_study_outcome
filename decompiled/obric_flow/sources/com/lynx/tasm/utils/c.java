package com.lynx.tasm.utils;

import ai.j0;
import android.util.Log;
import android.widget.AbsListView;
import com.bytedance.crash.ICommonParams;
import com.obric.oui.bouncelayout.OListView;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneId;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements bi.a, com.bytedance.ies.argus.strategy.e, mi.b, c7.g, c7.f, pt.d, ICommonParams, org.threeten.bp.temporal.i, com.obric.android.alog.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f11163b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11164a;

    public /* synthetic */ c(int r5) {
        this.f11164a = r5;
    }

    public static void e() {
        if (f11163b != null) goto L6;
        f11163b = new c(0);
        return;
    }

    public static com.obric.oui.bouncelayout.e f() {
        Field r5 = g(AbsListView.class, "mEdgeGlowTop");     // Catch: Throwable -> L6
        if (r5 != null) goto L8;
        r5 = g(AbsListView.class, "mTopGlow");     // Catch: Throwable -> L6
    L8:
        Field r10 = g(AbsListView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L6
        if (r10 != null) goto L11;
        r10 = g(AbsListView.class, "mBottomGlow");     // Catch: Throwable -> L6
    L11:
        Field r11 = g(AbsListView.class, "mScroller");     // Catch: Throwable -> L6
        Field r12 = g(AbsListView.class, "mFlingRunnable");     // Catch: Throwable -> L6
        if (r12 != null) goto L14;
    L13:
        Field r13 = null;
    L18:
        return new com.obric.oui.bouncelayout.e(r5, r10, r11, r12, r13);
    L14:
        Class<?> r14 = r12.getType();     // Catch: Throwable -> L6
        if (r14 == null) goto L13;
        c r15 = OListView.f12049v;     // Catch: Throwable -> L6
        r13 = g(r14, "mScroller");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Log.w("OListView", "Failed to reflect edge effect fields", th);
        return new com.obric.oui.bouncelayout.e(null, null, null, null, null);
    }

    public static Field g(Class r5, String r10) {
        Field r11 = r5.getDeclaredField(r10);     // Catch: Throwable -> L4
        r11.setAccessible(true);     // Catch: Throwable -> L4
        return r11;
    L4:
        th = move-exception;
        StringBuilder r12 = j0.x("Failed to reflect field ", r10, " from ");
        r12.append(r5.getName());
        Log.w("OListView", r12.toString(), th);
        return null;
    }

    @Override // com.bytedance.ies.argus.strategy.e
    public List a() {
        return CollectionsKt.listOf(new fb.a[]{new com.bytedance.ies.argus.strategy.provider.client.f(), new com.bytedance.ies.argus.strategy.provider.client.a(0), new com.bytedance.ies.argus.strategy.provider.client.a(4)});
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        switch(this.f11164a) {
            case 14: goto L10;
            default: goto L4;
        };
    L4:
        ZoneId r10 = (ZoneId) r5.query(org.threeten.bp.temporal.h.f21286a);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return (ZoneId) r5.query(org.threeten.bp.temporal.h.e);
    L10:
        return Month.from(r5);
    }

    @Override // com.bytedance.crash.ICommonParams
    public Map getCommonParams() {
        return new HashMap();
    }

    @Override // com.bytedance.crash.ICommonParams
    public String getDeviceId() {
        return null;
    }

    @Override // com.bytedance.crash.ICommonParams
    public List getPatchInfo() {
        return null;
    }

    @Override // com.bytedance.crash.ICommonParams
    public Map getPluginInfo() {
        return null;
    }

    @Override // com.bytedance.crash.ICommonParams
    public String getSessionId() {
        return null;
    }

    @Override // com.bytedance.crash.ICommonParams
    public long getUserId() {
        return 0;
    }

    @Override // mi.b
    public void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        ki.a.a(r5 + ": " + r10);
    }
}
