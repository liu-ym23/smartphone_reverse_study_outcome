package com.bytedance.android.monitorV2.event;

import android.util.Log;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import ko.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import x4.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f3558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3559c;
    public final r d;
    public final LinkedHashMap e;
    public h f;
    public JSONObject g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x4.a f3560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f3562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinkedHashMap f3563k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.monitorV2.listener.a f3564l;

    public d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "eventType");
        this.f3557a = r5;
        this.f3558b = LazyKt.lazy(HybridEvent$eventId$2.f3544a);
        this.d = new r(3, false);
        this.e = new LinkedHashMap();
        this.f = new h();
        this.f3561i = "__hybrid_default";
        this.f3562j = "default_bid";
        CopyOnWriteArrayList r10 = u4.e.f22249a;
        this.f3564l = new com.bytedance.android.monitorV2.listener.a(1);
    }

    public final UUID a() {
        return (UUID) this.f3558b.getValue();
    }

    public final void b(HybridEvent$TerminateType r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        this.d.f18729c = r5;
        if (Switches.f3595n.f3600a == true) goto L5;
        return;
    L5:
        Lazy r10 = com.bytedance.android.monitorV2.executor.d.f3576a;
        com.bytedance.android.monitorV2.executor.d.a(new HybridEvent$onEventTerminated$1(this));
    }

    public final void c(String r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        if (this.f3563k != null) goto L8;
        this.f3563k = new LinkedHashMap();     // Catch: Throwable -> L6
    L8:
        LinkedHashMap r12 = this.f3563k;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L6
        r12.put(r5, r10);     // Catch: Throwable -> L6
        Object r13 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L11:
        Throwable r14 = Result.m127exceptionOrNullimpl(r13);
        if (r14 == null) goto L17;
        mn.h.g("default_handle", r14);
        return;
    L17:
        return;
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void d(boolean r10, HybridEvent$TerminateType r11) {
        Intrinsics.checkNotNullParameter(r11, "reason");
        if (r10 == false) goto L23;
        String r12 = "Event terminated, type = " + r11.name();
        String r5 = d5.b.b("HBMonitorSDK_V2");
        d5.b.f16595c.getClass();
    L6:
        if (r12.length() <= 3000) goto L14;
        if (d5.c.f16596a == false) goto L10;
    L11:
        Log.w(td.d.b("NA_", r5), r12.substring(0, PathInterpolatorCompat.MAX_NUM_POINTS));
    L12:
        r12 = r12.substring(PathInterpolatorCompat.MAX_NUM_POINTS);
        goto L6
    L10:
        if (d5.a.b(d5.a.a("w"), r5, r12.substring(0, PathInterpolatorCompat.MAX_NUM_POINTS)) == true) goto L12;
    L14:
        if (d5.c.f16596a == false) goto L16;
    L17:
        Log.i("NA_" + r5, r12);
    L18:
        b(r11);
        return;
    L16:
        if (d5.a.b(d5.a.a("w"), r5, r12) == true) goto L18;
    }

    public final void e() {
        if (Switches.f3595n.f3600a == true) goto L5;
        return;
    L5:
        Lazy r5 = com.bytedance.android.monitorV2.executor.d.f3576a;
        com.bytedance.android.monitorV2.executor.d.a(new HybridEvent$onEventCreated$1(this));
    }

    public final void f() {
        if (Switches.f3595n.f3600a == true) goto L5;
        return;
    L5:
        Lazy r5 = com.bytedance.android.monitorV2.executor.d.f3576a;
        com.bytedance.android.monitorV2.executor.d.a(new HybridEvent$onEventSampled$1(this));
    }

    public final void g() {
        if (Switches.f3595n.f3600a == true) goto L5;
        return;
    L5:
        Lazy r5 = com.bytedance.android.monitorV2.executor.d.f3576a;
        com.bytedance.android.monitorV2.executor.d.a(new HybridEvent$onEventUpdated$1(this));
    }

    public final void h() {
        if (Switches.f3595n.f3600a == true) goto L5;
        return;
    L5:
        Lazy r5 = com.bytedance.android.monitorV2.executor.d.f3576a;
        com.bytedance.android.monitorV2.executor.d.a(new HybridEvent$onEventUploaded$1(this));
    }

    public final String toString() {
        return "HybridEvent(eventType='" + this.f3557a + "', eventId=" + a() + ", state=" + this.d + ')';
    }
}
