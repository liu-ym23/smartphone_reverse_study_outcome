package com.bytedance.android.anniex.container.popup;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.lite.base.IAnnieXHostActivityService;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.c0;
import com.bytedance.ies.bullet.service.base.y;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q26.k;
import y36.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXPopUpService extends s26.a implements q26.f {
    public static final /* synthetic */ int e = 0;
    public b b;
    public volatile boolean c;
    public volatile k d;

    public static final class a {
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ AnnieXPopUpService a;
        public final /* synthetic */ Uri b;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r10) {
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r11, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            if (this.a.c == false) goto L9;
            k r0 = this.a.d;
            if (r0 == null) goto L7;
            this.a.G0(r10, this.b, r0);
        L7:
            this.a.c = false;
            this.a.d = null;
            return;
        }

        public b(AnnieXPopUpService r1, Uri r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class c implements y {
        public final /* synthetic */ Uri a;
        public final /* synthetic */ com.bytedance.ies.bullet.base.utils.logger.a b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ k d;
        public final /* synthetic */ m36.c e;
        public final /* synthetic */ AnnieXPopUpService f;

        public static final class a implements JsEventSubscriber {
            public final /* synthetic */ Uri a;
            public final /* synthetic */ com.bytedance.ies.bullet.base.utils.logger.a b;
            public final /* synthetic */ m36.c c;
            public final /* synthetic */ AnnieXPopUpService d;
            public final /* synthetic */ Context e;
            public final /* synthetic */ k f;

            public final void onReceiveJsEvent(Js2NativeEvent r10) {
                Intrinsics.checkNotNullParameter(r10, "jsEvent");
                XReadableMap r11 = r10.getParams();
                if (r11 == null) goto L6;
                String r12 = r11.getString("code");
                if (r12 == null) goto L6;
            L7:
                HybridLogger r1 = HybridLogger.a;
                HybridLogger.k("XRouter", "popup with show_on_success, receive pageReady event", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, this.a.toString()), TuplesKt.to("code", r12)}), this.b);
                if (Intrinsics.areEqual("1", r12) == false) goto L10;
                this.c.d.putString("prerender", "1");
                AnnieXPopUpService r13 = this.d;
                Context r0 = this.e;
                Uri r14 = this.a;
                k r15 = this.f;
                int r16 = AnnieXPopUpService.e;
                r13.G0(r0, r14, r15);
            L10:
                EventCenter.unregisterJsEventSubscriber("pageReady", this);
                return;
            L6:
                r12 = "0";
                goto L7
            }

            public a(Uri r1, com.bytedance.ies.bullet.base.utils.logger.a r10, m36.c r11, AnnieXPopUpService r12, Context r13, k r14) {
                this.a = r1;
                this.b = r10;
                this.c = r11;
                this.d = r12;
                this.e = r13;
                this.f = r14;
            }
        }

        public final void onSuccess(String r10) {
            Intrinsics.checkNotNullParameter(r10, "sessinId");
            HybridLogger r0 = HybridLogger.a;
            HybridLogger.k("XRouter", "popup with show_on_success, preRender success", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, this.a.toString())), this.b);
            Context r1 = this.c;
            if ((r1 instanceof Activity) == false) goto L5;
            Activity r11 = (Activity) r1;
        L6:
            if (r11 == null) goto L10;
            boolean r12 = true;
            if (r11.isFinishing() != true) goto L10;
        L11:
            if (r12 == false) goto L16;
            q26.e r13 = this.d.g;
            if (r13 == null) goto L18;
            r13.b(new ActivityFinishedException());
            return;
        L18:
            return;
        L16:
            EventCenter.registerJsEventSubscriber("pageReady", new a(this.a, this.b, this.e, this.f, this.c, this.d), r10);
            return;
        L10:
            r12 = false;
            goto L11
        L5:
            r11 = null;
            goto L6
        }

        public final void a(PoolResult r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
            HybridLogger r12 = HybridLogger.a;
            Pair[] r13 = new Pair[2];
            if (r11 != null) goto L5;
            String r0 = "";
        L6:
            r13[0] = TuplesKt.to("errorMsg", r0);
            r13[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, this.a.toString());
            HybridLogger.k("XRouter", "popup with show_on_success, preRender failed", MapsKt.mapOf(r13), this.b);
            q26.e r14 = this.d.g;
            if (r14 == null) goto L10;
            r14.b(new PreRenderFailedException(r11));
            return;
        L10:
            return;
        L5:
            r0 = r11;
            goto L6
        }

        public c(Uri r1, com.bytedance.ies.bullet.base.utils.logger.a r10, Context r11, k r12, m36.c r13, AnnieXPopUpService r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Context a;

        public d(Context r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(this.a, "popup show with non-act", 0).show();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public AnnieXPopUpService() {
    }

    public final boolean G0(final Context r10, Uri r11, k r12) {
        final String r13 = r11.toString();
        com.bytedance.ies.bullet.base.utils.logger.a r0 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r0.a(com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, r12.b);
        r0.a("callId", r12.c);
        HybridLogger r1 = HybridLogger.a;
        HybridLogger.k("XPopup", "PopUpService showInner", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r13)), r0);
        if ((r10 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r14 = (FragmentActivity) r10;
    L7:
        if (r14 != null) goto L25;
        HybridLogger.k("XPopup", "create popup container failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "fragmentActivity is null"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r13)}), r0);
        q26.e r15 = r12.g;
        if (r15 == null) goto L12;
        r15.b(new NonFragmentActivityException());
    L12:
        if (h.h.a == false) goto L14;
        new Handler(Looper.getMainLooper()).post(new d(r10));
    L14:
        return false;
    L25:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L21
        com.bytedance.android.anniex.assemble.a r17 = com.bytedance.android.anniex.assemble.a.a;     // Catch: Throwable -> L21
        Function1<com.bytedance.android.anniex.base.builder.c, Unit> r18 = new AnnieXPopUpService$showInner$3$dialogHolder$1(r10, this, r13);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r18, "block");     // Catch: Throwable -> L21
        com.bytedance.android.anniex.base.builder.c r19 = new com.bytedance.android.anniex.base.builder.c();     // Catch: Throwable -> L21
        r18.invoke(r19);     // Catch: Throwable -> L21
        if (r19.c.getBoolean("bundle_annie_x_salamander", false) == false) goto L18;
        ja.a r110 = new com.bytedance.android.anniex.container.holder.c(r19);     // Catch: Throwable -> L21
    L19:
        r110.loadSchema(r13);     // Catch: Throwable -> L21
        r110.show("annie_x_dialog");     // Catch: Throwable -> L21
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L24:
        return Result.isSuccess-impl(r20);
    L18:
        r110 = new com.bytedance.android.anniex.container.holder.a(r19);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L5:
        r14 = null;
        goto L7
    }

    public final boolean u0(Context r12, Uri r13, k r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "schemaOrigin");
        Intrinsics.checkNotNullParameter(r14, "config");
        String r0 = r14.b;
        Lazy r1 = BulletContextManager.b;
        BulletContext r10 = BulletContextManager.a.a().getContext(r0);
        if (r10 != null) goto L5;
    L9:
        m36.c r11 = new m36.c(((s26.a) this).a, r13, r14.d, r12);
        com.bytedance.ies.bullet.base.utils.logger.a r15 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r15.a(com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, r14.b);
        r15.a("callId", r14.c);
        HybridLogger r16 = HybridLogger.a;
        Pair[] r17 = new Pair[4];
        r17[0] = TuplesKt.to("isScanOpen", Boolean.valueOf(r11.e()));
        r17[1] = TuplesKt.to("isDelayOpen", Boolean.valueOf(r11.d()));
        boolean r18 = r12 instanceof Activity;
        c0 r19 = null;
        if (r18 == false) goto L12;
        Activity r20 = (Activity) r12;
    L13:
        if (r20 != null) goto L15;
    L17:
        boolean r21 = false;
    L18:
        r17[2] = TuplesKt.to("isActivityFinish", Boolean.valueOf(r21));
        r17[3] = TuplesKt.to("isShowOnSuccess", Boolean.valueOf(r11.f()));
        HybridLogger.k("XPopup", "popup service show", MapsKt.mapOf(r17), r15);
        if (r11.e() == false) goto L21;
    L58:
        ExecutorService r22 = BulletLogger.a;
        BulletLogger.k("lazy show " + r13, null, "XPopup", 2);
        c0 r110 = r12.getApplicationContext();
        if ((r110 instanceof Application) == false) goto L61;
        r19 = (Application) r110;
    L61:
        if (r19 != null) goto L64;
        HybridLogger.g("XRouter", "create popup container failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "application is null"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r13.toString())}), r15);
        return false;
    L64:
        this.c = true;
        this.d = r14;
        if (this.b != null) goto L67;
        b r111 = new b(this, r13);
        this.b = r111;
        r19.registerActivityLifecycleCallbacks(r111);
    L67:
        HybridLogger.k("XRouter", "create popup container successfully", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r13.toString())), r15);
        return true;
    L21:
        if (r11.d() == true) goto L58;
        if (r18 == false) goto L24;
        Activity r23 = (Activity) r12;
    L25:
        if (r23 != null) goto L27;
    L29:
        boolean r24 = false;
    L30:
        if (r24 == true) goto L58;
        if (Intrinsics.areEqual(((i) new y36.a(r11.b.g.a, "show_on_top_page", Boolean.FALSE)).b, Boolean.TRUE) == false) goto L42;
        com.bytedance.android.anniex.assemble.a r112 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXHostActivityService r113 = (IAnnieXHostActivityService) com.bytedance.android.anniex.assemble.a.g(((s26.a) this).a, IAnnieXHostActivityService.class);
        if (r113 == null) goto L37;
        r19 = r113.Q();
    L37:
        if (r19 != null) goto L39;
        return false;
    L39:
        G0(r19, r13, r14);
        return true;
    L42:
        if (r11.f() == false) goto L57;
        Map r25 = x26.a.a;
        c0 r26 = (a0) x26.a.b(((s26.a) this).a, a0.class);
        if (r26 == null) goto L57;
        if ((r26 instanceof c0) == false) goto L48;
        r19 = r26;
    L48:
        c0 r27 = r19;
        if (r27 != null) goto L54;
        q26.e r114 = r14.g;
        if (r114 == null) goto L53;
        r114.b(new RuntimeException("invalid IPreRenderServiceWithBundle"));
    L53:
        return false;
    L54:
        HybridLogger.k("XRouter", "popup with show_on_success, start preRender", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r13.toString())), r15);
        r27.a(r13, r14.d, r12, new c(r13, r15, r12, r14, r11, this));
        return true;
    L57:
        return G0(r12, r13, r14);
    L27:
        if (r23.isFinishing() != true) goto L29;
        r24 = true;
        goto L30
    L24:
        r23 = null;
        goto L25
    L15:
        if (r20.isFinishing() != true) goto L17;
        r21 = true;
        goto L18
    L12:
        r20 = null;
        goto L13
    L5:
        if (Intrinsics.areEqual(((i) new y36.a(r10.g.a, "show_on_success", Boolean.FALSE)).b, Boolean.TRUE) == false) goto L9;
        if (w36.a.a(r13, "view_cache_key") != null) goto L9;
        r13 = r13.buildUpon().appendQueryParameter("view_cache_key", UUID.randomUUID().toString()).build();
        goto L9
    }
}
