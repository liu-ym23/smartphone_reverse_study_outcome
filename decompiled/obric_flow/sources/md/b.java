package md;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.core.f;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.pool.g;
import com.bytedance.ies.bullet.service.base.j;
import com.bytedance.ies.bullet.service.popup.NonFragmentActivityException;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ug.d;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends tc.a implements j {
    public static final ArrayList f = null;
    public static final ArrayList g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.anniex.container.popup.a f20062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f20063c;
    public volatile c d;
    public volatile d e;

    static {
        f = new ArrayList();
        g = new ArrayList();
    }

    public static boolean d(Context r10, Uri r11, d r12, c r13) {
        com.bytedance.ies.bullet.base.utils.logger.b r5 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r14 = (String) r12.f22358c;
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        ArrayList r15 = r5.f5260a;
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r14, r15);
        String r16 = (String) r12.d;
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r16, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("callId", r16, r15);
        int r17 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r18 = MapsKt.mapOf(TuplesKt.to("schema", r11.toString()));
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("PopUpService showInner", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "PopUpService showInner", r18, r5);
        if ((r10 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r19 = (FragmentActivity) r10;
    L6:
        if (r19 != null) goto L21;
        Map r20 = MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "fragmentActivity is null"), TuplesKt.to("schema", r11.toString())});
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("create popup container failed", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "create popup container failed", r20, r5);
        if (((t9.a) r12.g) == null) goto L11;
        Intrinsics.checkNotNullParameter(new NonFragmentActivityException(), "throwable");
    L11:
        if (h.g.f5315a == false) goto L23;
        new Handler(Looper.getMainLooper()).post(new com.bytedance.android.anniex.container.popup.c(r10, 2));
        return false;
    L23:
        return false;
    L21:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L17
        AbsPopupFragment r22 = z5.a.a(r13, (t9.a) r12.g);     // Catch: Throwable -> L17
        r22.show(r19.getSupportFragmentManager(), "BulletPopUp");     // Catch: Throwable -> L17
        Map r23 = MapsKt.mapOf(TuplesKt.to("schema", r11.toString()));     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter("create popup container successfully", "msg");     // Catch: Throwable -> L17
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "create popup container successfully", r23, r5);     // Catch: Throwable -> L17
        Object r24 = Result.m124constructorimpl(r22);     // Catch: Throwable -> L17
    L20:
        return Result.m131isSuccessimpl(r24);
    L17:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L20
    L5:
        r19 = null;
        goto L6
    }

    @Override // rc.d
    public final boolean b(Context r17, Uri r18, d r19) {
        Uri r5 = r18;
        int r10 = 1;
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r5, "schemaOrigin");
        Intrinsics.checkNotNullParameter(r19, "config");
        String r11 = (String) r19.f22358c;
        Lazy r12 = f.f5312b;
        e r13 = td.b.b().a(r11);
        if (r13 != null) goto L5;
    L9:
        Uri r14 = r5;
        c r15 = new c(this.f22117a, r14, (Bundle) r19.e, r17);
        com.bytedance.ies.bullet.base.utils.logger.b r16 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r20 = (String) r19.f22358c;
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r20, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r20, r16.f5260a);
        String r21 = (String) r19.d;
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r21, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("callId", r21, r16.f5260a);
        int r22 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Pair r23 = TuplesKt.to("isScanOpen", Boolean.valueOf(r15.c()));
        Pair r24 = TuplesKt.to("isDelayOpen", Boolean.valueOf(r15.b()));
        boolean r25 = r17 instanceof Activity;
        Application r110 = null;
        g r111 = null;
        if (r25 == false) goto L12;
        Activity r112 = (Activity) r17;
    L14:
        if (r112 != null) goto L16;
    L18:
        boolean r113 = false;
    L19:
        Map r26 = MapsKt.mapOf(new Pair[]{r23, r24, TuplesKt.to("isActivityFinish", Boolean.valueOf(r113)), TuplesKt.to("isShowOnSuccess", Boolean.valueOf(r15.d()))});
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("popup service show", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "popup service show", r26, r16);
        if (r15.c() == false) goto L22;
    L46:
        boolean r27 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "lazy show " + r14, "XPopup");
        Context r28 = r17.getApplicationContext();
        if ((r28 instanceof Application) == false) goto L49;
        r110 = (Application) r28;
    L49:
        if (r110 != null) goto L52;
        Map r29 = MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "application is null"), TuplesKt.to("schema", r14.toString())});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("create popup container failed", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "XRouter", "create popup container failed", r29, r16);
        return false;
    L52:
        this.f20063c = true;
        this.d = r15;
        this.e = r19;
        if (this.f20062b != null) goto L55;
        com.bytedance.android.anniex.container.popup.a r30 = new com.bytedance.android.anniex.container.popup.a(this, r14, r10);
        this.f20062b = r30;
        r110.registerActivityLifecycleCallbacks(r30);
    L55:
        Map r31 = MapsKt.mapOf(TuplesKt.to("schema", r14.toString()));
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("create popup container successfully", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "create popup container successfully", r31, r16);
        return true;
    L22:
        if (r15.b() == true) goto L46;
        if (r25 == false) goto L25;
        Activity r32 = (Activity) r17;
    L26:
        if (r32 == null) goto L31;
        if (r32.isFinishing() == true) goto L46;
    L31:
        if (r15.d() == false) goto L45;
        ConcurrentHashMap r33 = yc.a.f23246a;
        g r34 = (g) yc.a.a(g.class, this.f22117a);
        if (r34 == null) goto L45;
        if ((r34 instanceof g) == false) goto L37;
        r111 = r34;
    L37:
        if (r111 == null) goto L39;
        Map r35 = MapsKt.mapOf(TuplesKt.to("schema", r14.toString()));
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("popup with show_on_success, start preRender", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "popup with show_on_success, start preRender", r35, r16);
        r111.c(r14, (Bundle) r19.e, r17, new a(r14, r16, r17, r19, r15, this));
        return true;
    L39:
        if (((t9.a) r19.g) == null) goto L41;
        Intrinsics.checkNotNullParameter(new RuntimeException("invalid IPreRenderServiceWithBundle"), "throwable");
    L41:
        return false;
    L45:
        return d(r17, r14, r19, r15);
    L25:
        r32 = null;
        goto L26
    L16:
        if (r112.isFinishing() != true) goto L18;
        r113 = true;
        goto L19
    L12:
        r112 = null;
        goto L14
    L5:
        if (Intrinsics.areEqual(new vd.a(r13.g.f21723a, "show_on_success", Boolean.FALSE).f22372b, Boolean.TRUE) == false) goto L9;
        if (m.f(r5, "view_cache_key") != null) goto L9;
        r5 = r18.buildUpon().appendQueryParameter("view_cache_key", UUID.randomUUID().toString()).build();
        goto L9
    }
}
