package com.bytedance.android.anniex.container.popup;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.pool.g;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends tc.a implements rc.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f3177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f3178c;
    public volatile ug.d d;

    @Override // rc.d
    public final boolean b(Context r17, Uri r18, ug.d r19) {
        Uri r5 = r18;
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r5, "schemaOrigin");
        Intrinsics.checkNotNullParameter(r19, "config");
        String r10 = (String) r19.f22358c;
        Lazy r11 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.e r12 = td.b.b().a(r10);
        if (r12 != null) goto L5;
    L9:
        Uri r13 = r5;
        md.c r14 = new md.c(this.f22117a, r13, (Bundle) r19.e, r17);
        com.bytedance.ies.bullet.base.utils.logger.b r15 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r16 = (String) r19.f22358c;
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r16, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r16, r15.f5260a);
        String r20 = (String) r19.d;
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r20, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("callId", r20, r15.f5260a);
        int r21 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Pair r22 = TuplesKt.to("isScanOpen", Boolean.valueOf(r14.c()));
        Pair r23 = TuplesKt.to("isDelayOpen", Boolean.valueOf(r14.b()));
        boolean r24 = r17 instanceof Activity;
        Application r110 = null;
        g r111 = null;
        if (r24 == false) goto L12;
        Activity r112 = (Activity) r17;
    L14:
        if (r112 != null) goto L16;
    L18:
        boolean r113 = false;
    L19:
        Map r25 = MapsKt.mapOf(new Pair[]{r22, r23, TuplesKt.to("isActivityFinish", Boolean.valueOf(r113)), TuplesKt.to("isShowOnSuccess", Boolean.valueOf(r14.d()))});
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("popup service show", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "popup service show", r25, r15);
        if (r14.c() == false) goto L22;
    L46:
        boolean r26 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "lazy show " + r13, "XPopup");
        Context r27 = r17.getApplicationContext();
        if ((r27 instanceof Application) == false) goto L49;
        r110 = (Application) r27;
    L49:
        if (r110 != null) goto L52;
        Map r28 = MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "application is null"), TuplesKt.to("schema", r13.toString())});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("create popup container failed", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "XRouter", "create popup container failed", r28, r15);
        return false;
    L52:
        this.f3178c = true;
        this.d = r19;
        if (this.f3177b != null) goto L55;
        a r29 = new a(this, r13, 0);
        this.f3177b = r29;
        r110.registerActivityLifecycleCallbacks(r29);
    L55:
        Map r30 = MapsKt.mapOf(TuplesKt.to("schema", r13.toString()));
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("create popup container successfully", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "create popup container successfully", r30, r15);
        return true;
    L22:
        if (r14.b() == true) goto L46;
        if (r24 == false) goto L25;
        Activity r31 = (Activity) r17;
    L26:
        if (r31 == null) goto L31;
        if (r31.isFinishing() == true) goto L46;
    L31:
        if (r14.d() == false) goto L45;
        ConcurrentHashMap r32 = yc.a.f23246a;
        g r33 = (g) yc.a.a(g.class, this.f22117a);
        if (r33 == null) goto L45;
        if ((r33 instanceof g) == false) goto L37;
        r111 = r33;
    L37:
        if (r111 == null) goto L39;
        Map r34 = MapsKt.mapOf(TuplesKt.to("schema", r13.toString()));
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("popup with show_on_success, start preRender", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "popup with show_on_success, start preRender", r34, r15);
        r111.c(r13, (Bundle) r19.e, r17, new b(r13, r15, r17, r19, r14, this));
        return true;
    L39:
        if (((t9.a) r19.g) == null) goto L41;
        Intrinsics.checkNotNullParameter(new RuntimeException("invalid IPreRenderServiceWithBundle"), "throwable");
    L41:
        return false;
    L45:
        return d(r17, r13, r19);
    L25:
        r31 = null;
        goto L26
    L16:
        if (r112.isFinishing() != true) goto L18;
        r113 = true;
        goto L19
    L12:
        r112 = null;
        goto L14
    L5:
        if (Intrinsics.areEqual(new vd.a(r12.g.f21723a, "show_on_success", Boolean.FALSE).f22372b, Boolean.TRUE) == false) goto L9;
        if (m.f(r5, "view_cache_key") != null) goto L9;
        r5 = r18.buildUpon().appendQueryParameter("view_cache_key", UUID.randomUUID().toString()).build();
        goto L9
    }

    public final boolean d(final Context r10, Uri r11, ug.d r12) {
        com.bytedance.ies.bullet.base.utils.logger.b r5 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r13 = (String) r12.f22358c;
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        ArrayList r14 = r5.f5260a;
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r13, r14);
        String r15 = (String) r12.d;
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r15, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("callId", r15, r14);
        int r16 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r17 = MapsKt.mapOf(TuplesKt.to("schema", r11.toString()));
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("PopUpService showInner", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "PopUpService showInner", r17, r5);
        if ((r10 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r18 = (FragmentActivity) r10;
    L6:
        if (r18 != null) goto L20;
        Map r19 = MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "fragmentActivity is null"), TuplesKt.to("schema", r11.toString())});
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("create popup container failed", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "create popup container failed", r19, r5);
        if (((t9.a) r12.g) == null) goto L11;
        Intrinsics.checkNotNullParameter(new NonFragmentActivityException(), "throwable");
    L11:
        if (h.g.f5315a == false) goto L13;
        new Handler(Looper.getMainLooper()).post(new c(r10, 0));
    L13:
        return false;
    L20:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L16
        Function1<r3.c, Unit> r111 = new AnnieXPopUpService$showInner$3$dialogHolder$1(r10, this);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r111, "block");     // Catch: Throwable -> L16
        r3.c r20 = new r3.c();     // Catch: Throwable -> L16
        r111.invoke(r20);     // Catch: Throwable -> L16
        w3.a r112 = new w3.a(r20);     // Catch: Throwable -> L16
        String r21 = r11.toString();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r21, "schema");     // Catch: Throwable -> L16
        ((com.bytedance.android.anniex.container.m) r112.d).loadSchema(r21, null);     // Catch: Throwable -> L16
        qo.a.n(r112);     // Catch: Throwable -> L16
        Object r22 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        return Result.m131isSuccessimpl(r22);
    L16:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    L5:
        r18 = null;
        goto L6
    }
}
