package com.bytedance.ai.resource;

import android.content.Context;
import com.byted.cast.sink.api.IServerListener;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$DebugMode;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.clienttool.ClientToolRunner;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.Plugin;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.monitor.timeline.CallFrom;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.AIPackageOperationGroup;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIManager {
    public static final AIManager a = null;
    public static final ConcurrentHashMap<Pair<String, String>, String> b = null;
    public static final ConcurrentHashMap<String, Deferred<a>> c = null;
    public static final CopyOnWriteArrayList<c> d = null;
    public static boolean e;
    public static final ConcurrentHashMap<String, d0> f = null;
    public static final ConcurrentHashMap<String, d0> g = null;
    public static final Lazy h = null;
    public static final CompletableDeferred<Boolean> i = null;
    public static final CompletableDeferred<Boolean> j = null;
    public static final CompletableDeferred<Boolean> k = null;
    public static boolean l;
    public static boolean m;
    public static final Set<String> n = null;
    public static final Set<String> o = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ai.resource.AIManager$a$a, reason: collision with other inner class name */
        public static final class C0046a extends a {
            public final int a;
            public final String b;
            public final boolean c;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof C0046a) == true) goto L8;
                return false;
            L8:
                C0046a r11 = (C0046a) r10;
                if (this.a == r11.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
                return false;
            L15:
                if (this.c == r11.c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a * 31;
                String r1 = this.b;
                if (r1 != null) goto L5;
                int r10 = 0;
            L6:
                int r11 = (r0 + r10) * 31;
                if (this.c == false) goto L9;
                int r12 = 1231;
            L11:
                return r11 + r12;
            L9:
                r12 = 1237;
                goto L11
            L5:
                r10 = r1.hashCode();
                goto L6
            }

            public final String toString() {
                return "Failed(errorCode=" + this.a + ", errorMsg=" + this.b + ", canRetry=" + this.c + ')';
            }

            public C0046a(int r1, String r10) {
                this.a = r1;
                this.b = r10;
                this.c = true;
            }
        }

        public static final class b extends a {
            public final Applet a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Success(applet=" + this.a + ')';
            }

            public b(Applet r10) {
                Intrinsics.checkNotNullParameter(r10, "applet");
                this.a = r10;
            }
        }

        public a() {
        }
    }

    public static final class b {
        public final AIPackage a;
        public final String b;
        public final String c;
        public final AIPackage.AIPackageType d;
        public final int e;
        public final String f;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            AIPackage r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = ((((((((r10 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
            String r12 = this.f;
            if (r12 == null) goto L11;
            r1 = r12.hashCode();
        L11:
            return r11 + r1;
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "InstallAIPackageResult(info=" + this.a + ", packageName=" + this.b + ", appId=" + this.c + ", packageType=" + this.d + ", errorCode=" + this.e + ", errorMsg=" + this.f + ')';
        }

        public b(AIPackage r10, String r11, String r12, AIPackage.AIPackageType r13, int r14, String r15) {
            Intrinsics.checkNotNullParameter(r11, "packageName");
            Intrinsics.checkNotNullParameter(r12, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r13, "packageType");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
        }
    }

    public interface c {
        void a(String r1, String r10);

        void b(String r1, String r10);

        void c(String r1, String r10);
    }

    public static final class d implements AIPackageManager.b {
        public final /* synthetic */ List<String> a;
        public final /* synthetic */ d0 b;

        public d(List<String> r1, d0 r10) {
            this.a = r1;
            this.b = r10;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.ai.resource.AIPackageManager.b
        public final void a(AIPackage r10, String r11, String r12, AIPackage.AIPackageType r13, int r14, String r15) {
            Intrinsics.checkNotNullParameter(r11, "packageName");
            Intrinsics.checkNotNullParameter(r12, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r13, "packageType");
            boolean r0 = true;
            if (r14 == 0) goto L11;
            com.bytedance.ai.utils.g.a.e("AIManager", "failed to install AIPackage in memory. packageName: " + r11 + ", appId: " + r12);
            if (r12.length() > 0) goto L8;
            r0 = false;
        L8:
            if (r0 == false) goto L10;
            this.a.add(r12);
        L10:
            Unit r16 = Unit.INSTANCE;
            return;
        L11:
            if (r10 == null) goto L31;
            d0 r17 = this.b;
            if (r17.i != 0) goto L15;
            com.bytedance.ai.utils.g.a.i("AIManager", "update packageInfo version. packageName: " + r10.b + ", appId: " + r10.a() + ", type: " + r10.c().name() + ", version: " + r10.c);
            r17.i = r10.c;
            r17.j = r10.d;
        L15:
            Applet r18 = null;
            r18 = null;
            if (r13 != AIPackage.AIPackageType.APPLET) goto L25;
            if ((r10 instanceof Applet) == false) goto L20;
            Applet r19 = (Applet) r10;
        L21:
            if (r19 == null) goto L30;
            r19.A = true;
            r17.d(r19);
            Applet r20 = r19;
        L23:
            r18 = r20;
        L30:
            if (r18 == null) goto L31;
            return;
        L20:
            r19 = null;
            goto L21
        L25:
            if ((r10 instanceof Widget) == false) goto L27;
            Widget r21 = (Widget) r10;
        L28:
            if (r21 == null) goto L30;
            r21.A = true;
            r17.e(r21);
            r20 = r21;
            goto L23
        L27:
            r21 = null;
        L31:
            com.bytedance.ai.utils.g.a.e("AIManager", "AIPackage is NULL");
            Unit r22 = Unit.INSTANCE;
        }
    }

    public static final class e implements d0.a {
        public e() {
        }

        @Override // com.bytedance.ai.resource.d0.a
        public final void a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            AIManager.f.remove(r10);
            AIManager.d(r10);
            AppletAppManagerService.INSTANCE.getClass();
            OnlineAppletApplication r0 = AppletAppManagerService.b(r10);
            if (r0 == null) goto L5;
            r0.J().b();
        L5:
            ClientToolRunner.a.getClass();
            ClientToolRunner.d(r10);
        }
    }

    public static final class f implements k5.j {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AIPackage.AIPackageType c;
        public final /* synthetic */ Map<String, Object> d;

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.f = this.a;
            r10.g = this.b;
            r10.f("resourceType", this.c.name());
            AIManager r0 = AIManager.a;
            r10.d("load_type", !AIManager.g(this.a) ? 1 : 0);
            n5.a.a.getClass();
            r10.d("isClient", 0);
            Map<String, ? extends Object> r1 = this.d;
            if (r1 == null) goto L6;
            r10.h(r1);
            return;
        }

        public f(String r1, String r10, AIPackage.AIPackageType r11, Map<String, ? extends Object> r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    public static final class g implements k5.j {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ AIPackage.AIPackageType d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ long g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Map<String, Object> i;

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.f = this.a;
            r10.g = this.b;
            r10.e("versionCode", this.c);
            r10.f("resourceType", this.d.name());
            AIManager r0 = AIManager.a;
            r10.d("load_type", !AIManager.g(this.a) ? 1 : 0);
            r10.d(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, this.e);
            String r1 = this.f;
            String r11 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r10.f(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r1);
            r10.e("cost", this.g);
            String r12 = this.h;
            if (r12 != null) goto L8;
        L11:
            String r13 = r11;
        L12:
            r10.f("res_from", r13);
            n5.a.a.getClass();
            r10.d("isClient", 0);
            Map<String, ? extends Object> r14 = this.i;
            if (r14 == null) goto L16;
            r10.h(r14);
            return;
        L16:
            return;
        L8:
            if (Intrinsics.areEqual(r12, "cdnCache") == false) goto L10;
            r13 = "cdn_cache";
            goto L12
        L10:
            r11 = r12;
            goto L11
        }

        public g(String r1, String r10, long r11, AIPackage.AIPackageType r12, int r13, String r14, long r15, String r16, Map<String, ? extends Object> r17) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
            this.h = r16;
            this.i = r17;
        }
    }

    public static final class h implements AIPackageManager.b {
        public final /* synthetic */ Continuation<Boolean> a;

        public h(SafeContinuation r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ai.resource.AIPackageManager.b
        public final void a(AIPackage r1, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r12, "packageType");
            if (r13 != 0) goto L5;
            AIManager.d(r10);
            Continuation<Boolean> r15 = this.a;
            Result.Companion r16 = Result.Companion;
            r15.resumeWith(Result.constructor-impl(Boolean.TRUE));
            return;
        L5:
            Continuation<Boolean> r17 = this.a;
            Result.Companion r18 = Result.Companion;
            r17.resumeWith(Result.constructor-impl(Boolean.FALSE));
        }
    }

    public AIManager() {
    }

    static {
        a = new AIManager();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new CopyOnWriteArrayList();
        f = new ConcurrentHashMap();
        g = new ConcurrentHashMap();
        h = LazyKt.lazy(new com.bytedance.ai.resource.e());
        i = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        j = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        k = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        n = Collections.newSetFromMap(new ConcurrentHashMap());
        o = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void M() {
        AIPackageManager.a.getClass();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AIPackageManager$updateAllAIPackages$1(null), 3, null);
    }

    public static boolean w() {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        Boolean r1 = null;
        if (r0 == null) goto L7;
        Map<String, Object> r10 = r0.getSettings();
        if (r10 == null) goto L7;
        Object r11 = r10.get("appsMusicEnable");
    L9:
        if ((r11 instanceof Boolean) == false) goto L12;
        r1 = (Boolean) r11;
    L12:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L7:
        r11 = null;
        goto L9
    }

    public static boolean x() {
        h2.a r0 = f2.b.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.j != true) goto L7;
        return true;
    }

    public static final void d(String r10) {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("applet_lifecycle", "remove AIPackage from temp list. packageName: " + r10);
        r0.i("AIManager", "remove AIPackage from temp list. packageName: " + r10);
        g.remove(r10);
    }

    public static void f(String r1) {
        Intrinsics.checkNotNullParameter(r1, BdpAwemeConstant.KEY_APP_ID);
        n5.a.a.getClass();
        if (Intrinsics.areEqual(r1, "com.flow.music.auth") == true) goto L5;
        n.add(r1);
        return;
    L5:
        if (w() == false) goto L9;
        n.add(r1);
        return;
    }

    public static boolean g(String r1) {
        Intrinsics.checkNotNullParameter(r1, "packageName");
        if (l == true) goto L5;
    L7:
        return false;
    L5:
        if (n.contains(r1) == true) goto L7;
        n5.a.a.getClass();
        return true;
    }

    public static d0 l(String r10) {
        ConcurrentHashMap<String, d0> r0 = g;
        d0 r1 = r0.get(r10);
        if (r1 != null) goto L9;
        n5.a.a.getClass();
        r1 = new d0(r10, false, 2);
        e r11 = (e) h.getValue();
        Intrinsics.checkNotNullParameter(r11, "listener");
        r1.g = new WeakReference(r11);
        d0 r12 = r0.putIfAbsent(r10, r1);
        if (r12 == null) goto L9;
        r1 = r12;
    L9:
        return r1;
    }

    public static d0 m(String r1) {
        Intrinsics.checkNotNullParameter(r1, "packageId");
        d0 r0 = IAISDKDebugService.a.v(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (g(r1) == false) goto L8;
        return f.get(r1);
    L8:
        return g.get(r1);
    }

    public static String q(Map r1) {
        if (r1 == null) goto L10;
        Object r10 = r1.get("version_tag");
        if (r10 == null) goto L10;
        String r11 = r10.toString();
        if (r11 == null) goto L10;
        if ((!StringsKt.isBlank(r11)) == false) goto L10;
        return r11;
    L10:
        return null;
    }

    public final Object i(Continuation<? super Unit> r10) {
        if ((r10 instanceof AIManager$ensureInitialize$1) == false) goto L7;
        AIManager$ensureInitialize$1 r0 = (AIManager$ensureInitialize$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L22;
        if (r13 == 1) goto L18;
        if (r13 == 2) goto L17;
        if (r13 != 3) goto L16;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L20
    L36:
        ((Boolean) r11).booleanValue();     // Catch: Exception -> L20
    L40:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L20
    L32:
        if (((Boolean) r11).booleanValue() == false) goto L40;
        CompletableDeferred<Boolean> r14 = k;     // Catch: Exception -> L20
        r0.label = 3;     // Catch: Exception -> L20
        r11 = r14.await(r0);     // Catch: Exception -> L20
        if (r11 != r12) goto L36;
        return r12;
    L18:
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L20
    L27:
        if (((Boolean) r11).booleanValue() == false) goto L40;
        CompletableDeferred<Boolean> r15 = i;     // Catch: Exception -> L20
        r0.label = 2;     // Catch: Exception -> L20
        r11 = r15.await(r0);     // Catch: Exception -> L20
        if (r11 != r12) goto L32;
        return r12;
    L22:
        ResultKt.throwOnFailure(r11);
        CompletableDeferred<Boolean> r16 = j;     // Catch: Exception -> L20
        r0.label = 1;     // Catch: Exception -> L20
        r11 = r16.await(r0);     // Catch: Exception -> L20
        if (r11 != r12) goto L27;
        return r12;
    L20:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AIManager", "ensureInitialize exception: " + e);
    L7:
        r0 = new AIManager$ensureInitialize$1(this, r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.util.ArrayList] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x015f -> B:61:0x0163). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x019d -> B:73:0x01a1). Please report as a decompilation issue!!! */
    public static final Object a(AIManager r11, Continuation r12) {
        r11.getClass();
        if ((r12 instanceof AIManager$getInstalledApplets$1) == false) goto L7;
        AIManager$getInstalledApplets$1 r0 = (AIManager$getInstalledApplets$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = r0.label;
        if (r10 == 0) goto L20;
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L18;
        if (r10 == 3) goto L17;
        if (r10 != 4) goto L16;
        String r15 = (String) r0.L$2;
        Iterator r16 = (Iterator) r0.L$1;
        Map r17 = (Map) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L73:
        Applet r18 = (Applet) r13;
        if (r18 == null) goto L69;
        r17.put(r15, r18);
    L69:
        if (r16.hasNext() == false) goto L76;
        r15 = (String) r16.next();
        IAISDKDebugService.Companion r19 = IAISDKDebugService.a;
        r0.L$0 = r17;
        r0.L$1 = r16;
        r0.L$2 = r15;
        r0.L$3 = null;
        r0.label = 4;
        r13 = r19.e(r15, r0);
        if (r13 != r14) goto L73;
    L99:
        return r14;
    L76:
        Map r20 = r17;
    L77:
        r14 = new ArrayList(r20.size());
        Iterator r110 = r20.entrySet().iterator();
    L79:
        if (r110.hasNext() == false) goto L99;
        Map.Entry r21 = (Map.Entry) r110.next();
        HashMap r22 = new HashMap();
        Applet r23 = (Applet) r21.getValue();
        r22.put("appletPackage", r23.K);
        r22.put("appletName", r23.a);
        Icons r24 = r23.g;
        String r25 = "";
        if (r24 == null) goto L84;
        String r26 = r24.get3x();
        if (r26 == null) goto L84;
    L85:
        r22.put("appletIcon", r26);
        r22.put("appletDescription", r23.f);
        r22.put("appletVersion", Boxing.boxLong(r23.c));
        String r27 = r23.d;
        if (r27 == null) goto L89;
        r25 = r27;
    L89:
        r22.put("appletSCMVersion", r25);
        List<Page> r28 = r23.L;
        if (r28 == null) goto L92;
        r22.put("appletPages", r28);
    L92:
        ArrayList<Widget> r29 = r23.S;
        if (r29 == null) goto L95;
        r22.put("appletWidgets", r29);
    L95:
        List<Plugin> r30 = r23.M;
        if (r30 == null) goto L98;
        r22.put("appletPlugins", r30);
    L98:
        r22.put("installedApplet", r23);
        r22.put("defaultPage", r23.O);
        r22.put("debugHost", IAISDKDebugService.a.G(r23.o()));
        r22.put("debugBotInfo", f2.k.c);
        r22.put("debugBackupAppletBotIdMap", b);
        r22.put("debugBotId", r23.N);
        r14.add(r22);
    L84:
        r26 = "";
        goto L85
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r31 = (String) r0.L$3;
        Iterator r32 = (Iterator) r0.L$2;
        r20 = (Map) r0.L$1;
        Set r33 = (Set) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L61:
        Applet r111 = (Applet) r13;
        if (r111 == null) goto L64;
        r20.put(r31, r111);
    L64:
        r33.remove(r31);
    L55:
        if (r32.hasNext() == false) goto L66;
        r31 = (String) r32.next();
        if (r33.contains(r31) == false) goto L55;
        IAISDKDebugService.Companion r112 = IAISDKDebugService.a;
        r0.L$0 = r33;
        r0.L$1 = r20;
        r0.L$2 = r32;
        r0.L$3 = r31;
        r0.label = 3;
        r13 = r112.e(r31, r0);
        if (r13 != r14) goto L61;
    L66:
        if ((!r33.isEmpty()) == false) goto L77;
        r16 = r33.iterator();
        r17 = r20;
        goto L69
    L18:
        List r34 = (List) r0.L$2;
        Map r35 = (Map) r0.L$1;
        Set r36 = (Set) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L28:
        List r113 = (List) r13;
        Iterator r37 = r34.iterator();
    L30:
        if (r37.hasNext() == false) goto L37;
        AIPackage r38 = (AIPackage) r37.next();
        if ((r38 instanceof Applet) == false) goto L34;
        Applet r39 = (Applet) r38;
    L35:
        if (r39 == null) goto L30;
        r35.put(r38.b, r39);
        goto L30
    L34:
        r39 = null;
        goto L35
    L37:
        Iterator r114 = r113.iterator();
    L39:
        if (r114.hasNext() == false) goto L53;
        AIPackage r40 = (AIPackage) r114.next();
        if ((r40 instanceof Widget) == false) goto L43;
        Widget r41 = (Widget) r40;
    L44:
        if (r41 == null) goto L39;
        Applet r42 = (Applet) r35.get(r41.b);
        if (r42 == null) goto L39;
        if (r42.S != null) goto L50;
        r42.S = new ArrayList();
    L50:
        ArrayList<Widget> r43 = r42.S;
        if (r43 == null) goto L39;
        Boxing.boxBoolean(r43.add(r41));
        goto L39
    L43:
        r41 = null;
        goto L44
    L53:
        r33 = r36;
        r20 = r35;
        r32 = r35.keySet().iterator();
        goto L55
    L19:
        Map r44 = (Map) r0.L$1;
        r36 = (Set) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L24:
        List r115 = (List) r13;
        AIPackageManager r45 = AIPackageManager.a;
        AIPackage.AIPackageType r46 = AIPackage.AIPackageType.WIDGET;
        r0.L$0 = r36;
        r0.L$1 = r44;
        r0.L$2 = r115;
        r0.label = 2;
        r45.getClass();
        Object r47 = AIPackageStorage.a.o(r46, r0);
        if (r47 == r14) goto L99;
        Map r116 = r44;
        r34 = r115;
        r13 = r47;
        r35 = r116;
        goto L28
    L20:
        ResultKt.throwOnFailure(r13);
        LinkedHashSet r117 = new LinkedHashSet();
        r117.addAll(IAISDKDebugService.a.A());
        r44 = new LinkedHashMap();
        AIPackageManager r48 = AIPackageManager.a;
        AIPackage.AIPackageType r49 = AIPackage.AIPackageType.APPLET;
        r0.L$0 = r117;
        r0.L$1 = r44;
        r0.label = 1;
        r48.getClass();
        Object r50 = AIPackageStorage.a.o(r49, r0);
        if (r50 == r14) goto L99;
        r36 = r117;
        r13 = r50;
    L7:
        r0 = new AIManager$getInstalledApplets$1(r11, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.ArrayList] */
    public static final Object b(AIManager r10, Continuation r11) {
        r10.getClass();
        if ((r11 instanceof AIManager$getInstalledAppletsFromGecko$1) == false) goto L7;
        AIManager$getInstalledAppletsFromGecko$1 r0 = (AIManager$getInstalledAppletsFromGecko$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        Set r15 = (Set) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L18:
        ArrayList r16 = new ArrayList();
        Iterator r17 = ((List) r12).iterator();
    L20:
        if (r17.hasNext() == false) goto L33;
        d0 r18 = (d0) r17.next();
        String r19 = r18.a;
        if (r15.contains(r19) == true) goto L23;
        if (l == false) goto L20;
        if (n.contains(r19) == true) goto L20;
        r16.add(r18);
        goto L20
    L23:
        d0 r20 = IAISDKDebugService.a.v(r19);
        if (r20 == null) goto L26;
        r16.add(r20);
    L26:
        r15.remove(r19);
        goto L20
    L33:
        if ((!r15.isEmpty()) == false) goto L40;
        Iterator r21 = r15.iterator();
    L36:
        if (r21.hasNext() == false) goto L40;
        d0 r22 = IAISDKDebugService.a.v((String) r21.next());
        if (r22 == null) goto L36;
        r16.add(r22);
    L40:
        r13 = new ArrayList();
        Iterator r23 = r16.iterator();
    L42:
        if (r23.hasNext() == false) goto L66;
        d0 r24 = (d0) r23.next();
        HashMap r25 = new HashMap();
        Applet r26 = r24.g(r24.a);
        if (r26 == null) goto L65;
        r25.put("appletPackage", r26.K);
        r25.put("appletName", r26.a);
        Icons r27 = r26.g;
        String r28 = "";
        if (r27 == null) goto L49;
        String r29 = r27.get3x();
        if (r29 == null) goto L49;
    L50:
        r25.put("appletIcon", r29);
        r25.put("appletDescription", r26.f);
        r25.put("appletVersion", Boxing.boxLong(r26.c));
        String r30 = r26.d;
        if (r30 == null) goto L54;
        r28 = r30;
    L54:
        r25.put("appletSCMVersion", r28);
        List<Page> r31 = r26.L;
        if (r31 == null) goto L57;
        r25.put("appletPages", r31);
    L57:
        List<Plugin> r32 = r26.M;
        if (r32 == null) goto L60;
        r25.put("appletPlugins", r32);
    L60:
        r25.put("installedApplet", r26);
        r25.put("appletWidgets", r24.f());
        r25.put("defaultPage", r26.O);
        r25.put("debugHost", IAISDKDebugService.a.G(r26.o()));
        r25.put("debugBotInfo", f2.k.c);
        ConcurrentHashMap<Pair<String, String>, String> r33 = b;
        LinkedHashMap r34 = new LinkedHashMap(MapsKt.mapCapacity(r33.size()));
        Iterator<T> r35 = r33.entrySet().iterator();
    L62:
        if (r35.hasNext() == false) goto L64;
        Map.Entry r36 = (Map.Entry) r35.next();
        int r37 = AIPackage.J;
        r34.put(AIPackage.a.a((String) ((Pair) r36.getKey()).getFirst(), (String) ((Pair) r36.getKey()).getSecond()), r36.getValue());
        goto L62
    L64:
        r25.put("debugBackupAppletBotIdMap", r34);
        r25.put("debugBotId", r26.N);
    L49:
        r29 = "";
    L65:
        r13.add(r25);
    L66:
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        LinkedHashSet r38 = new LinkedHashSet();
        r38.addAll(IAISDKDebugService.a.A());
        AIPackageManager r39 = AIPackageManager.a;
        r0.L$0 = r38;
        r0.label = 1;
        Object r40 = r39.e(r0);
        if (r40 == r13) goto L66;
        r15 = r38;
        r12 = r40;
    L7:
        r0 = new AIManager$getInstalledAppletsFromGecko$1(r10, r11);
        goto L8
    }

    public static AIPackage e(AIPackage r11, boolean r12) {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("applet_lifecycle", "<initApplet> add AIPackage in temp list. packageName: " + r11.b + ", appId: " + r11.a() + ", type: " + r11.c().name() + ", version: " + r11.c);
        r0.i("AIManager", "add AIPackage into temp list. packageName: " + r11.b + ", appId: " + r11.a() + ", type: " + r11.c().name() + ", version: " + r11.c);
        d0 r1 = l(r11.b);
        if (r1.i != 0) goto L5;
        r0.i("AIManager", "update packageInfo version. packageName: " + r11.b + ", appId: " + r11.a() + ", type: " + r11.c().name() + ", version: " + r11.c);
        r1.i = r11.c;
        r1.j = r11.d;
    L5:
        AIPackage r10 = null;
        if (r11.c() != AIPackage.AIPackageType.APPLET) goto L17;
        if ((r11 instanceof Applet) == false) goto L10;
        Applet r13 = (Applet) r11;
    L11:
        if (r13 == null) goto L25;
        String r14 = r13.x;
        if (r14 == null) goto L15;
        r1.j(r14);
    L15:
        r10 = r1.d(r13);
    L25:
        if (r12 == true) goto L27;
    L29:
        return r10;
    L27:
        if (r11.A == false) goto L29;
        r1.b = true;
        goto L29
    L10:
        r13 = null;
        goto L11
    L17:
        if ((r11 instanceof Widget) == false) goto L19;
        Widget r15 = (Widget) r11;
    L20:
        if (r15 == null) goto L25;
        String r16 = r15.x;
        if (r16 == null) goto L24;
        r1.j(r16);
    L24:
        r10 = r1.e(r15);
        goto L25
    L19:
        r15 = null;
        goto L20
    }

    public static Object j(String r10, Continuation r11) {
        AIPackageManager.a.getClass();
        return BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageManager$getDebugSchema$2(r10, null), r11);
    }

    public final Object N(String r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof AIManager$updatePackages$1) == false) goto L7;
        AIManager$updatePackages$1 r0 = (AIManager$updatePackages$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L18;
        if (r14 == 1) goto L17;
        if (r14 == 2) goto L16;
        if (r14 != 3) goto L15;
        ResultKt.throwOnFailure(r12);
    L30:
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
    L26:
        return r12;
    L17:
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L22:
        if (g(r10) == false) goto L27;
        AIPackageManager r15 = AIPackageManager.a;
        r0.L$0 = null;
        r0.label = 2;
        r15.getClass();
        r12 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageManager$updateAIPackageFromGecko$2(r10, null), r0);
        if (r12 != r13) goto L26;
        return r13;
    L27:
        AIPackageManager r16 = AIPackageManager.a;
        r0.L$0 = null;
        r0.label = 3;
        r16.getClass();
        r12 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageManager$updateAIPackages$4(r10, null), r0);
        if (r12 != r13) goto L30;
        return r13;
    L18:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r10;
        r0.label = 1;
        if (i(r0) != r13) goto L22;
        return r13;
    L7:
        r0 = new AIManager$updatePackages$1(this, r11);
        goto L8
    }

    public final Object p(String r10, Continuation<? super Integer> r11) {
        if ((r11 instanceof AIManager$getUseCount$1) == false) goto L7;
        AIManager$getUseCount$1 r0 = (AIManager$getUseCount$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L18:
        if (g(r10) == true) goto L27;
        d0 r15 = g.get(r10);
        if (r15 == null) goto L27;
        if (r15.h == false) goto L25;
        int r16 = r15.d.get();
    L29:
        return Boxing.boxInt(r16);
    L25:
        r16 = 0;
    L27:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r10;
        r0.label = 1;
        if (i(r0) != r13) goto L18;
        return r13;
    L7:
        r0 = new AIManager$getUseCount$1(this, r11);
        goto L8
    }

    public static Deferred J(String r12, String r13, long r14) {
        final String r0 = r12 + '-' + r13 + '-' + r14;
        ConcurrentHashMap<String, Deferred<a>> r1 = c;
        Deferred<a> r10 = r1.get(r0);
        if (r10 == null) goto L5;
        return r10;
    L5:
        final Deferred<a> r15 = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, CoroutineStart.LAZY, new AIManager$startAppletFullInstallForWorker$task$1(r12, r13, r14, null), 1, null);
        r15.invokeOnCompletion(new com.bytedance.ai.resource.d(r0, r15));
        Deferred<a> r16 = r1.putIfAbsent(r0, r15);
        if (r16 == null) goto L8;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
        return r16;
    L8:
        r15.start();
        return r15;
    }

    public static Object h(String r10, long r11, Continuation r12) {
        return BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIManager$ensureAppletFullReady$2(r10, r11, null, null), r12);
    }

    public static void s(Context r10, boolean r11, pg9.b r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AIManager$init$1(r11, r10, null, r12, null), 3, null);
    }

    public final Object C(String r11, Map<String, Object> r12, Continuation<? super Applet> r13) {
        if ((r13 instanceof AIManager$loadApplet$1) == false) goto L7;
        AIManager$loadApplet$1 r0 = (AIManager$loadApplet$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AIManager$loadApplet$1 r10 = r0;
        Object r14 = r10.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r10.label;
        if (r16 == 0) goto L18;
        if (r16 == 1) goto L17;
        if (r16 == 2) goto L16;
        if (r16 != 3) goto L15;
        ResultKt.throwOnFailure(r14);
    L33:
        if ((r14 instanceof Applet) == true) goto L35;
        return null;
    L35:
        return (Applet) r14;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r14);
    L27:
        if ((r14 instanceof Applet) == true) goto L37;
        return null;
    L37:
        return (Applet) r14;
    L17:
        r12 = (Map) r10.L$1;
        r11 = (String) r10.L$0;
        ResultKt.throwOnFailure(r14);
    L21:
        Map<String, Object> r17 = r12;
        String r18 = q(r17);
        if (g(r11) == false) goto L29;
        AIPackage.AIPackageType r19 = AIPackage.AIPackageType.APPLET;
        r10.L$0 = null;
        r10.L$1 = null;
        r10.label = 2;
        r14 = z(r11, r11, r19, r17, r18, r10);
        if (r14 != r15) goto L27;
        return r15;
    L29:
        AIPackage.AIPackageType r20 = AIPackage.AIPackageType.APPLET;
        r10.L$0 = null;
        r10.L$1 = null;
        r10.label = 3;
        r14 = y(r11, r11, true, r20, r17, r18, r10);
        if (r14 != r15) goto L33;
        return r15;
    L18:
        ResultKt.throwOnFailure(r14);
        r10.L$0 = r11;
        r10.L$1 = r12;
        r10.label = 1;
        if (i(r10) != r15) goto L21;
        return r15;
    L7:
        r0 = new AIManager$loadApplet$1(this, r13);
        goto L8
    }

    public final Object D(String r31, Map<String, Object> r32, Continuation<? super Applet> r33) {
        if ((r33 instanceof AIManager$loadAppletForWorkerBootstrap$1) == false) goto L7;
        AIManager$loadAppletForWorkerBootstrap$1 r1 = (AIManager$loadAppletForWorkerBootstrap$1) r33;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        AIManager$loadAppletForWorkerBootstrap$1 r11 = r1;
        Object r0 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r11.label;
        if (r13 == 0) goto L22;
        if (r13 == 1) goto L21;
        if (r13 == 2) goto L20;
        if (r13 == 3) goto L19;
        if (r13 == 4) goto L18;
        if (r13 != 5) goto L17;
        ResultKt.throwOnFailure(r0);
    L75:
        return r0;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        long r14 = r11.J$0;
        AIPackage.AIPackageType r15 = (AIPackage.AIPackageType) r11.L$2;
        Map<String, Object> r16 = (Map) r11.L$1;
        String r17 = (String) r11.L$0;
        ResultKt.throwOnFailure(r0);
        AIPackage.AIPackageType r20 = r15;
    L63:
        AbsAIPackageOperation.a r18 = (AbsAIPackageOperation.a) r0;
        AIPackage r19 = r18.a;
        if ((r19 instanceof Applet) == false) goto L66;
        Applet r21 = (Applet) r19;
    L68:
        if (r18.e != 0) goto L72;
        if (r21 == null) goto L72;
        com.bytedance.ai.utils.g.a.i("AIManager", "loadAppletForWorkerBootstrap base ready. appletId: " + r17 + ", version: " + r21.c);
        r21.B = "aisdk_install";
        AIPackage.PackageStatus r22 = AIPackage.PackageStatus.BASE_READY;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r21.y = r22;
        r16.put("packageStatus", "BASE_READY");
        H(r21, r18.e, r18.f, System.currentTimeMillis() - r14, r16);
        e(r21, false);
        return r21;
    L72:
        com.bytedance.ai.utils.g r23 = com.bytedance.ai.utils.g.a;
        r23.e("AIManager", "loadAppletForWorkerBootstrap failed. appletId: " + r17 + ", errorCode: " + r18.e + ", errorMsg: " + r18.f);
        I(r17, r17, -1, r20, r18.e, r18.f, System.currentTimeMillis() - r14, "aisdk_install", r16);
        StringBuilder r24 = new StringBuilder("loadAppletForWorkerBootstrap fallback to full loadApplet. appletId: ");
        r24.append(r17);
        r23.w("AIManager", r24.toString());
        r16.put("callFrom", Boxing.boxInt(CallFrom.FROM_WORKER_FALLBACK.getStatus()));
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 5;
        r0 = C(r17, r16, r11);
        if (r0 != r12) goto L75;
        return r12;
    L66:
        r21 = null;
        goto L68
    L19:
        long r25 = r11.J$0;
        AIPackage.AIPackageType r26 = (AIPackage.AIPackageType) r11.L$3;
        Map<String, Object> r27 = (Map) r11.L$2;
        String r28 = (String) r11.L$1;
        String r110 = (String) r11.L$0;
        ResultKt.throwOnFailure(r0);
    L37:
        AIPackage r29 = (AIPackage) r0;
        if (r29 == null) goto L40;
        AIPackage.PackageStatus r30 = r29.y;
    L42:
        if (r30 == AIPackage.PackageStatus.READY) goto L76;
        if (r29 == null) goto L45;
        AIPackage.PackageStatus r34 = r29.y;
    L47:
        if (r34 == AIPackage.PackageStatus.BASE_READY) goto L76;
        if (IAISDKDebugService.a.getDebugMode() != IAISDKDebugService$DebugMode.SCAN_PREVIEW) goto L53;
        com.bytedance.ai.utils.g.a.i("AIManager", "skip worker bootstrap package load in SCAN_PREVIEW. appletId: " + r110 + ", versionTag: " + r28);
        I(r110, r110, -1, r26, 7, "skip worker bootstrap package load in SCAN_PREVIEW", System.currentTimeMillis() - r25, null, r27);
        return null;
    L53:
        long r35 = r25;
        long r36 = l(r110).i;
        J(r110, r110, r36);
        AIPackageManager r37 = AIPackageManager.a;
        AIPackageManager.a r38 = new AIPackageManager.a(r110, r110);
        r11.L$0 = r110;
        r11.L$1 = r27;
        r11.L$2 = r26;
        r11.L$3 = null;
        AIPackage.AIPackageType r111 = r26;
        Map<String, Object> r210 = r27;
        r11.J$0 = r35;
        r11.label = 4;
        r37.getClass();
        String r39 = r38.getPackageName();
        com.bytedance.ai.utils.g.a.i("AIPackageManager", "packageName: " + r38.getPackageName() + ", appId: " + r38.getAppId() + " ===> loadAppletBasePackage start");
        AIPackageDeployment.AIPackageDeploymentItem r40 = new AIPackageDeployment.AIPackageDeploymentItem(r38.getAppId(), r38.getPackageName(), r36, null, null, null, false, null, null, 504, null);
        ConcurrentHashMap<String, AIPackageOperationGroup> r41 = AIPackageManager.c;
        AIPackageOperationGroup r42 = r41.get(r39);
        if (r42 != null) goto L59;
        r42 = new AIPackageOperationGroup();
        AIPackageOperationGroup r43 = r41.putIfAbsent(r39, r42);
        if (r43 == null) goto L59;
        r42 = r43;
    L59:
        r0 = r42.i(r40, r11);
        if (r0 != r12) goto L62;
        return r12;
    L62:
        r20 = r111;
        r14 = r35;
        r17 = r110;
        r16 = r210;
        goto L63
    L45:
        r34 = null;
    L76:
        Map<String, Object> r211 = r27;
        long r44 = r25;
        com.bytedance.ai.utils.g.a.i("AIManager", "loadAppletForWorkerBootstrap hit cache. appletId: " + r110 + ", status: " + r29.y);
        r211.put("packageStatus", r29.y.name());
        H(r29, 0, null, System.currentTimeMillis() - r44, r211);
        if (r29.y != AIPackage.PackageStatus.BASE_READY) goto L80;
        J(r110, r110, r29.c);
    L80:
        if ((r29 instanceof Applet) == true) goto L88;
        return null;
    L88:
        return (Applet) r29;
    L40:
        r30 = null;
        goto L42
    L20:
        ResultKt.throwOnFailure(r0);
    L87:
        return r0;
    L21:
        Map<String, Object> r45 = (Map) r11.L$1;
        String r46 = (String) r11.L$0;
        ResultKt.throwOnFailure(r0);
        r110 = r46;
    L26:
        String r47 = q(r45);
        if (g(r110) == true) goto L84;
        n5.a.a.getClass();
        if (com.bytedance.ai.settings.b.r.a().intValue() == 0) goto L84;
        if (r45 != null) goto L33;
        r45 = new LinkedHashMap();
    L33:
        Map<String, Object> r48 = r45;
        r48.put("callFrom", Boxing.boxInt(CallFrom.FROM_WORKER.getStatus()));
        G(r110, r110, AIPackage.AIPackageType.APPLET, r48);
        long r49 = System.currentTimeMillis();
        AIPackage.AIPackageType r50 = AIPackage.AIPackageType.APPLET;
        com.bytedance.ai.utils.g.a.i("AIManager", "loadAppletForWorkerBootstrap start. appletId: " + r110 + ", versionTag: " + r47);
        r11.L$0 = r110;
        r11.L$1 = r47;
        r11.L$2 = r48;
        r11.L$3 = r50;
        r11.J$0 = r49;
        r11.label = 3;
        r0 = k(r110, r110, r50, r47, r11);
        if (r0 != r12) goto L36;
        return r12;
    L36:
        r26 = r50;
        r28 = r47;
        r27 = r48;
        r25 = r49;
    L84:
        com.bytedance.ai.utils.g.a.i("AIManager", "loadAppletForWorkerBootstrap use full loadApplet for gecko or remote package or disabling worker_optimized. " + com.bytedance.ai.settings.b.r.a().intValue() + ". appletId: " + r110 + ", versionTag: " + r47);
        r11.L$0 = null;
        r11.L$1 = null;
        r11.label = 2;
        r0 = C(r110, r45, r11);
        if (r0 != r12) goto L87;
        return r12;
    L22:
        ResultKt.throwOnFailure(r0);
        r11.L$0 = r31;
        r45 = r32;
        r11.L$1 = r45;
        r11.label = 1;
        if (i(r11) != r12) goto L25;
        return r12;
    L25:
        r110 = r31;
    L7:
        r1 = new AIManager$loadAppletForWorkerBootstrap$1(this, r33);
        goto L8
    }

    public final Object L(List r10, com.bytedance.ai.debugscene.a0 r11, Continuation r12) {
        if ((r12 instanceof AIManager$uninstallAIPackagesWithVersionCodeInMemory$1) == false) goto L7;
        AIManager$uninstallAIPackagesWithVersionCodeInMemory$1 r0 = (AIManager$uninstallAIPackagesWithVersionCodeInMemory$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Function1 r16 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r13);
        Function1 r17 = r16;
    L17:
        boolean r18 = ((Boolean) r13).booleanValue();
        if (r17 == null) goto L21;
        r17.invoke(Boxing.boxBoolean(r18));
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        AIPackageManager r19 = AIPackageManager.a;
        r0.L$0 = r11;
        r0.label = 1;
        r13 = r19.n(r10, r0);
        r17 = r11;
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r0 = new AIManager$uninstallAIPackagesWithVersionCodeInMemory$1(this, r12);
        goto L8
    }

    public final Object r(String r10, AIPackage.AIPackageType r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof AIManager$hasNewVersion$1) == false) goto L7;
        AIManager$hasNewVersion$1 r0 = (AIManager$hasNewVersion$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L26:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (AIPackage.AIPackageType) r0.L$1;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L20:
        if (g(r10) == true) goto L22;
        AIPackageStorage r16 = AIPackageStorage.a;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r13 = r16.j(r10, r11, r0);
        if (r13 != r14) goto L26;
        return r14;
    L22:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r13);
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 1;
        if (i(r0) != r14) goto L20;
        return r14;
    L7:
        r0 = new AIManager$hasNewVersion$1(this, r12);
        goto L8
    }

    public static void G(String r1, String r10, AIPackage.AIPackageType r11, Map r12) {
        if (r12 == null) goto L4;
        Map r13 = MapsKt.toMap(r12);
    L5:
        com.bytedance.ai.monitor.b.d("applet_resource_load_begin", new f(r1, r10, r11, r13));
        return;
    L4:
        r13 = null;
        goto L5
    }

    public static Object t(String r12, String r13, long r14, ContinuationImpl r16) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r16), 1);
        r0.C();
        AtomicReference r10 = new AtomicReference(r0);
        r0.i(new com.bytedance.ai.resource.f(r10));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AIManager$installAIPackageAwait$2$2(r13, r12, r14, r10, null), 3, null);
        Object r1 = r0.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r16);
    L5:
        return r1;
    }

    public final Object E(String r11, String r12, Map<String, Object> r13, Continuation<? super Widget> r14) {
        if ((r14 instanceof AIManager$loadWidget$1) == false) goto L7;
        AIManager$loadWidget$1 r0 = (AIManager$loadWidget$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AIManager$loadWidget$1 r10 = r0;
        Object r15 = r10.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        if (r17 == 0) goto L18;
        if (r17 == 1) goto L17;
        if (r17 == 2) goto L16;
        if (r17 != 3) goto L15;
        ResultKt.throwOnFailure(r15);
    L33:
        if ((r15 instanceof Widget) == true) goto L35;
        return null;
    L35:
        return (Widget) r15;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r15);
    L27:
        if ((r15 instanceof Widget) == true) goto L37;
        return null;
    L37:
        return (Widget) r15;
    L17:
        r13 = (Map) r10.L$2;
        r12 = (String) r10.L$1;
        r11 = (String) r10.L$0;
        ResultKt.throwOnFailure(r15);
    L21:
        Map<String, Object> r18 = r13;
        String r19 = q(r18);
        if (g(r11) == false) goto L29;
        AIPackage.AIPackageType r20 = AIPackage.AIPackageType.WIDGET;
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.label = 2;
        r15 = z(r11, r12, r20, r18, r19, r10);
        if (r15 != r16) goto L27;
        return r16;
    L29:
        AIPackage.AIPackageType r21 = AIPackage.AIPackageType.WIDGET;
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.label = 3;
        r15 = y(r11, r12, true, r21, r18, r19, r10);
        if (r15 != r16) goto L33;
        return r16;
    L18:
        ResultKt.throwOnFailure(r15);
        r10.L$0 = r11;
        r10.L$1 = r12;
        r10.L$2 = r13;
        r10.label = 1;
        if (i(r10) != r16) goto L21;
        return r16;
    L7:
        r0 = new AIManager$loadWidget$1(this, r14);
        goto L8
    }

    public final Object K(String r17, String r18, AIPackage.AIPackageType r19, Continuation<? super Boolean> r20) {
        if ((r20 instanceof AIManager$uninstallAIPackage$1) == false) goto L7;
        AIManager$uninstallAIPackage$1 r1 = (AIManager$uninstallAIPackage$1) r20;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        boolean r13 = true;
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L15;
        if (r12 != 2) goto L14;
        AIPackage.AIPackageType r14 = (AIPackage.AIPackageType) r1.L$2;
        String r15 = (String) r1.L$1;
        String r16 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L38:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIPackage.AIPackageType r21 = (AIPackage.AIPackageType) r1.L$2;
        String r22 = (String) r1.L$1;
        String r23 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        String r110 = r22;
        Object r24 = r0;
        String r25 = r23;
    L24:
        AIPackage r26 = (AIPackage) r24;
        if (r26 != null) goto L27;
    L33:
        r1.L$0 = r25;
        r1.L$1 = r110;
        r1.L$2 = r21;
        r1.label = 2;
        SafeContinuation r27 = new SafeContinuation(IntrinsicsKt.intercepted(r1));
        AIPackageManager r28 = AIPackageManager.a;
        AIPackageManager.a r29 = new AIPackageManager.a(r110, r25);
        h r30 = new h(r27);
        r28.getClass();
        Intrinsics.checkNotNullParameter(r29, "item");
        Intrinsics.checkNotNullParameter(r21, "packageType");
        Intrinsics.checkNotNullParameter(r30, "listener");
        r0 = r27.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L36:
        if (r0 != r11) goto L38;
        return r11;
    L27:
        if (r26.H.get() != 0) goto L30;
        r13 = false;
    L30:
        if (r13 == false) goto L33;
        com.bytedance.ai.utils.g.a.w("AIManager", "AIPackage packageName: " + r25 + ", appId: " + r110 + " is running. Uninstallation is NOT allowed");
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r0);
        if (g(r17) == true) goto L19;
        r25 = r17;
        r1.L$0 = r25;
        r110 = r18;
        r1.L$1 = r110;
        r1.L$2 = r19;
        r1.label = 1;
        Object r31 = B(this, r17, r18, r19, true, null, r1, 16);
        if (r31 != r11) goto L23;
        return r11;
    L23:
        r24 = r31;
        r21 = r19;
        goto L24
    L19:
        return Boxing.boxBoolean(false);
    L7:
        r1 = new AIManager$uninstallAIPackage$1(this, r20);
        goto L8
    }

    public static void H(AIPackage r11, int r12, String r13, long r14, Map r16) {
        I(r11.b, r11.a(), r11.c, r11.c(), r12, r13, r14, r11.B, r16);
    }

    public static final Object c(AIManager r10, String r11, String r12, long r13, Continuation r15) {
        r10.getClass();
        if ((r15 instanceof AIManager$installAppletForFullReady$1) == false) goto L7;
        AIManager$installAppletForFullReady$1 r0 = (AIManager$installAppletForFullReady$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r0.label;
        Applet r18 = null;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        b r19 = (b) r0.L$2;
        r12 = (String) r0.L$1;
        String r110 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L41:
        if ((r14 instanceof Applet) == false) goto L43;
        Applet r111 = (Applet) r14;
    L45:
        if (r111 == null) goto L53;
        com.bytedance.ai.utils.g.a.w("AIManager", "installAppletForFullReady use fallback. packageName: " + r110 + ", appId: " + r12 + ", versionCode: " + r111.c + ", errorCode: " + r19.e);
        r111.B = "aisdk_fallback";
        AIPackage.PackageStatus r112 = AIPackage.PackageStatus.READY;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r111.y = r112;
        AIPackage r113 = e(r111, false);
        if ((r113 instanceof Applet) == false) goto L49;
        r18 = (Applet) r113;
    L49:
        if (r18 == null) goto L56;
        r111 = r18;
    L56:
        return new a.b(r111);
    L53:
        com.bytedance.ai.utils.g.a.e("AIManager", "installAppletForFullReady failed. packageName: " + r110 + ", appId: " + r12 + ", errorCode: " + r19.e + ", errorMsg: " + r19.f);
        return new a.C0046a(r19.e, r19.f);
    L43:
        r111 = null;
        goto L45
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = r0.J$0;
        r12 = (String) r0.L$1;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        b r114 = (b) r14;
        AIPackage r20 = r114.a;
        if ((r20 instanceof Applet) == false) goto L22;
        Applet r21 = (Applet) r20;
    L24:
        if (r114.e != 0) goto L33;
        if (r21 == null) goto L33;
        com.bytedance.ai.utils.g.a.i("AIManager", "installAppletForFullReady success. packageName: " + r11 + ", appId: " + r12 + ", versionCode: " + r21.c);
        r21.B = "aisdk_install";
        AIPackage.PackageStatus r115 = AIPackage.PackageStatus.READY;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r21.y = r115;
        AIPackage r116 = e(r21, false);
        if ((r116 instanceof Applet) == false) goto L29;
        r18 = (Applet) r116;
    L29:
        if (r18 == null) goto L55;
        r21 = r18;
    L55:
        return new a.b(r21);
    L33:
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.L$2 = r114;
        r0.label = 2;
        if (r13 == 0) goto L37;
        n5.a.a.getClass();
    L37:
        if (r16 == null) goto L58;
        r110 = r11;
        r19 = r114;
        r14 = null;
        goto L41
    L58:
        return r16;
    L22:
        r21 = null;
        goto L24
    L16:
        ResultKt.throwOnFailure(r14);
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.J$0 = r13;
        r0.label = 1;
        r14 = t(r11, r12, r13, r0);
        if (r14 != r16) goto L19;
        return r16;
    L7:
        r0 = new AIManager$installAppletForFullReady$1(r10, r15);
        goto L8
    }

    public final Object F(String r19, String r20, AIPackage.AIPackageType r21, String r22, Continuation<? super Pair<? extends AIPackage, String>> r23) {
        String r0 = r19;
        String r1 = r20;
        AIPackage.AIPackageType r10 = r21;
        String r11 = r22;
        if ((r23 instanceof AIManager$realLoadAIPackageFromGecko$1) == false) goto L7;
        AIManager$realLoadAIPackageFromGecko$1 r12 = (AIManager$realLoadAIPackageFromGecko$1) r23;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        Object r17 = null;
        if (r16 == 0) goto L18;
        if (r16 == 1) goto L17;
        if (r16 == 2) goto L16;
        if (r16 != 3) goto L15;
        AIPackage.AIPackageType r18 = (AIPackage.AIPackageType) r12.L$2;
        r1 = (String) r12.L$1;
        String r24 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L52:
        Pair r25 = (Pair) r14;
        d0 r26 = (d0) r25.getFirst();
        String r27 = (String) r25.getSecond();
        if (r26 == null) goto L62;
        com.bytedance.ai.utils.g.a.i("AIManager", "===load AIPackage from Gecko in gecko mode success. PackageName: " + r24 + ", appId: " + r1 + ",  packageType: " + r18);
        d0 r28 = f.putIfAbsent(r24, r26);
        if (r28 == null) goto L57;
        r26.i();
        r26 = r28;
    L59:
        if (r18 != AIPackage.AIPackageType.APPLET) goto L61;
        r17 = r26.g(r1);
    L66:
        return TuplesKt.to(r17, r27);
    L61:
        r17 = r26.h(r1);
        goto L66
    L57:
        e r29 = (e) h.getValue();
        Intrinsics.checkNotNullParameter(r29, "listener");
        r26.g = new WeakReference(r29);
        goto L59
    L62:
        com.bytedance.ai.utils.g.a.e("AIManager", "Failed to load AIPackage from Gecko in gecko mode. PackageName: " + r24 + ", appId: " + r1 + ",  packageType: " + r18 + " errorMsg: " + r27);
        if (r27 != null) goto L66;
        r27 = "Failed to load AIPackage from Gecko in gecko mode, without exception";
        goto L66
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r30 = (String) r12.L$3;
        AIPackage.AIPackageType r31 = (AIPackage.AIPackageType) r12.L$2;
        String r32 = (String) r12.L$1;
        String r33 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
        r11 = r30;
        r0 = r33;
        r10 = r31;
        r1 = r32;
    L27:
        AIPackage r34 = (AIPackage) r14;
    L28:
        AIPackage.AIPackageType r110 = r10;
        r24 = r0;
        r18 = r110;
        if (r34 == null) goto L33;
        com.bytedance.ai.utils.g.a.i("AIManager", "===load AIPackage from debug in gecko mode success. PackageName: " + r24 + ", appId: " + r1 + ",  packageType: " + r18);
        r34.B = "aisdk_debug";
        return TuplesKt.to(r34, null);
    L33:
        if (IAISDKDebugService.a.getDebugMode() != IAISDKDebugService$DebugMode.SCAN_PREVIEW) goto L36;
        com.bytedance.ai.utils.g.a.i("AIManager", "skip Gecko package load in SCAN_PREVIEW. packageName: " + r24 + ", appId: " + r1 + ", packageType: " + r18.name() + ", versionTag: " + r11);
        return TuplesKt.to(null, "skip Gecko package load in SCAN_PREVIEW");
    L36:
        d0 r35 = f.get(r24);
        if (r35 == null) goto L46;
        if (r18 != AIPackage.AIPackageType.APPLET) goto L41;
        AIPackage r36 = r35.g(r1);
    L42:
        if (r36 == null) goto L46;
        r36.B = "aisdk_memory";
        com.bytedance.ai.utils.g.a.i("AIManager", "===load AIPackage from memory in gecko mode success. PackageName: " + r24 + ", appId: " + r1 + ",  packageType: " + r18);
        return TuplesKt.to(r36, null);
    L41:
        r36 = r35.h(r1);
    L46:
        if (x() == false) goto L49;
        com.bytedance.ai.utils.g.a.i("AIManager", "skip loading absent AIPackage from Gecko for oversea host. packageName: " + r24 + ", appId: " + r1 + ", packageType: " + r18.name());
        return TuplesKt.to(null, "skip loading absent AIPackage from Gecko for oversea host");
    L49:
        AIPackageManager r37 = AIPackageManager.a;
        r12.L$0 = r24;
        r12.L$1 = r1;
        r12.L$2 = r18;
        r12.L$3 = null;
        r12.label = 3;
        r14 = r37.l(r24, r12);
        if (r14 != r15) goto L52;
        return r15;
    L17:
        String r38 = (String) r12.L$3;
        AIPackage.AIPackageType r39 = (AIPackage.AIPackageType) r12.L$2;
        String r40 = (String) r12.L$1;
        String r41 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
        r11 = r38;
        r0 = r41;
        r10 = r39;
        r1 = r40;
    L23:
        r34 = (AIPackage) r14;
        goto L28
    L18:
        ResultKt.throwOnFailure(r14);
        com.bytedance.ai.utils.g.a.d("AIManager", "===load AIPackage in gecko mode. packageName: " + r0 + ", appId: " + r1 + ",  packageType: " + r10);
        if (r10 != AIPackage.AIPackageType.APPLET) goto L24;
        IAISDKDebugService.Companion r42 = IAISDKDebugService.a;
        r12.L$0 = r0;
        r12.L$1 = r1;
        r12.L$2 = r10;
        r12.L$3 = r11;
        r12.label = 1;
        r14 = r42.y(r1, r11, r12);
        if (r14 != r15) goto L23;
        return r15;
    L24:
        IAISDKDebugService.Companion r43 = IAISDKDebugService.a;
        r12.L$0 = r0;
        r12.L$1 = r1;
        r12.L$2 = r10;
        r12.L$3 = r11;
        r12.label = 2;
        r14 = r43.x(r0, r1, r11, r12);
        if (r14 != r15) goto L27;
        return r15;
    L7:
        r12 = new AIManager$realLoadAIPackageFromGecko$1(this, r23);
        goto L8
    }

    public final Object k(String r19, String r20, AIPackage.AIPackageType r21, String r22, Continuation<? super AIPackage> r23) {
        if ((r23 instanceof AIManager$getPackageFromCache$1) == false) goto L7;
        AIManager$getPackageFromCache$1 r1 = (AIManager$getPackageFromCache$1) r23;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        if (r12 == 0) goto L26;
        if (r12 == 1) goto L25;
        if (r12 == 2) goto L20;
        if (r12 != 3) goto L19;
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L16
    L50:
        AIPackage r14 = (AIPackage) r0;     // Catch: Throwable -> L16
        if (r14 == null) goto L53;
        r14.B = "aisdk_db";     // Catch: Throwable -> L16
    L53:
        kotlinx.coroutines.sync.a r15 = r13;
    L54:
        r15.unlock(null);
        return r14;
    L16:
        th = th;
        kotlinx.coroutines.sync.a r16 = r13;
    L63:
        r16.unlock(null);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r15 = (kotlinx.coroutines.sync.a) r1.L$3;
        AIPackage.AIPackageType r17 = (AIPackage.AIPackageType) r1.L$2;
        String r18 = (String) r1.L$1;
        String r24 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L23
    L36:
        r14 = (AIPackage) r0;     // Catch: Throwable -> L23
        if (r14 == null) goto L44;
        if (r14.A == false) goto L41;
        String r25 = "aisdk_debug";
    L42:
        r14.B = r25;     // Catch: Throwable -> L23
        goto L54
    L41:
        r25 = "aisdk_op_memory";
        goto L42
    L44:
        if (IAISDKDebugService.a.getDebugMode() != IAISDKDebugService$DebugMode.SCAN_PREVIEW) goto L46;
        r14 = null;
        goto L54
    L46:
        n5.a.a.getClass();     // Catch: Throwable -> L23
        r1.L$0 = r15;     // Catch: Throwable -> L23
        r1.L$1 = null;     // Catch: Throwable -> L23
        r1.L$2 = null;     // Catch: Throwable -> L23
        r1.L$3 = null;     // Catch: Throwable -> L23
        r1.label = 3;     // Catch: Throwable -> L23
        r0 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIManager$queryOrActiveAIPackage$2(r24, r18, r17, null), r1);     // Catch: Throwable -> L23
        if (r0 != r11) goto L49;
        return r11;
    L49:
        r13 = r15;
    L23:
        th = th;
        r16 = r15;
        goto L63
    L25:
        kotlinx.coroutines.sync.a r26 = (kotlinx.coroutines.sync.a) r1.L$4;
        String r27 = (String) r1.L$3;
        AIPackage.AIPackageType r28 = (AIPackage.AIPackageType) r1.L$2;
        String r29 = (String) r1.L$1;
        String r30 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        kotlinx.coroutines.sync.a r110 = r26;
        AIPackage.AIPackageType r111 = r28;
        String r112 = r29;
        String r31 = r30;
        String r32 = r27;
    L67:
        AIManager r33 = a;     // Catch: Throwable -> L60
        r1.L$0 = r31;     // Catch: Throwable -> L60
        r1.L$1 = r112;     // Catch: Throwable -> L60
        r1.L$2 = r111;     // Catch: Throwable -> L60
        r1.L$3 = r110;     // Catch: Throwable -> L60
        r1.L$4 = null;     // Catch: Throwable -> L60
        r1.label = 2;     // Catch: Throwable -> L60
        kotlinx.coroutines.sync.a r113 = r110;
        Object r34 = B(r33, r31, r112, r111, false, r32, r1, 8);     // Catch: Throwable -> L58
        if (r34 != r11) goto L35;
        return r11;
    L35:
        r24 = r31;
        r0 = r34;
        r18 = r112;
        r17 = r111;
        r15 = r113;
    L58:
        th = th;
    L62:
        r16 = r113;
    L60:
        th = th;
        r113 = r110;
        goto L62
    L26:
        ResultKt.throwOnFailure(r0);
        kotlinx.coroutines.sync.a r35 = l(r19).k;
        r1.L$0 = r19;
        r1.L$1 = r20;
        r1.L$2 = r21;
        r32 = r22;
        r1.L$3 = r32;
        r1.L$4 = r35;
        r1.label = 1;
        if (r35.a(null, r1) != r11) goto L29;
        return r11;
    L29:
        r110 = r35;
        r31 = r19;
        r112 = r20;
        r111 = r21;
    L7:
        r1 = new AIManager$getPackageFromCache$1(this, r23);
        goto L8
    }

    public final Object A(String r10, String r11, AIPackage.AIPackageType r12, boolean r13, String r14, Continuation<? super AIPackage> r15) {
        if ((r15 instanceof AIManager$loadAIPackageFromMemory$1) == false) goto L7;
        AIManager$loadAIPackageFromMemory$1 r0 = (AIManager$loadAIPackageFromMemory$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r0.label;
        if (r18 == 0) goto L16;
        if (r18 == 1) goto L15;
        if (r18 != 2) goto L14;
        boolean r19 = r0.Z$0;
        r14 = (String) r0.L$3;
        r12 = (AIPackage.AIPackageType) r0.L$2;
        r11 = (String) r0.L$1;
        String r110 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
        r13 = r19;
        r10 = r110;
    L27:
        AIPackage r111 = (AIPackage) r16;
    L29:
        if (r111 == null) goto L31;
        return r111;
    L31:
        if (r13 == false) goto L33;
    L36:
        d0 r20 = l(r10);
        if (r12 != AIPackage.AIPackageType.APPLET) goto L40;
        return r20.g(r11);
    L40:
        return r20.h(r11);
    L33:
        if (IAISDKDebugService.a.getDebugMode() != IAISDKDebugService$DebugMode.SCAN_PREVIEW) goto L36;
        com.bytedance.ai.utils.g.a.i("AIManager", "skip normal memory load in SCAN_PREVIEW. packageName: " + r10 + ", appId: " + r11 + ", packageType: " + r12.name() + ", versionTag: " + r14);
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r21 = r0.Z$0;
        r14 = (String) r0.L$3;
        r12 = (AIPackage.AIPackageType) r0.L$2;
        r11 = (String) r0.L$1;
        String r112 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
        r13 = r21;
        r10 = r112;
    L23:
        r111 = (AIPackage) r16;
        goto L29
    L16:
        ResultKt.throwOnFailure(r16);
        if (r13 == false) goto L19;
        r111 = null;
        goto L29
    L19:
        if (r12 != AIPackage.AIPackageType.APPLET) goto L24;
        IAISDKDebugService.Companion r113 = IAISDKDebugService.a;
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r12;
        r0.L$3 = r14;
        r0.Z$0 = r13;
        r0.label = 1;
        r16 = r113.y(r11, r14, r0);
        if (r16 != r17) goto L23;
        return r17;
    L24:
        IAISDKDebugService.Companion r114 = IAISDKDebugService.a;
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r12;
        r0.L$3 = r14;
        r0.Z$0 = r13;
        r0.label = 2;
        r16 = r114.x(r10, r11, r14, r0);
        if (r16 != r17) goto L27;
        return r17;
    L7:
        r0 = new AIManager$loadAIPackageFromMemory$1(this, r15);
        goto L8
    }

    public final Object z(String r24, String r25, AIPackage.AIPackageType r26, Map<String, Object> r27, String r28, Continuation<? super AIPackage> r29) {
        if ((r29 instanceof AIManager$loadAIPackageFromGecko$1) == false) goto L7;
        AIManager$loadAIPackageFromGecko$1 r1 = (AIManager$loadAIPackageFromGecko$1) r29;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        AIManager$loadAIPackageFromGecko$1 r11 = r1;
        Object r0 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r11.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        long r14 = r11.J$0;
        Ref.ObjectRef r15 = (Ref.ObjectRef) r11.L$5;
        Ref.ObjectRef r16 = (Ref.ObjectRef) r11.L$4;
        Map<String, Object> r17 = (Map) r11.L$3;
        AIPackage.AIPackageType r18 = (AIPackage.AIPackageType) r11.L$2;
        String r19 = (String) r11.L$1;
        String r20 = (String) r11.L$0;
        ResultKt.throwOnFailure(r0);
        Map<String, Object> r22 = r17;
        AIPackage.AIPackageType r110 = r18;
        String r111 = r20;
        String r112 = r19;
    L18:
        Pair r21 = (Pair) r0;
        r16.element = r21.getFirst();
        r15.element = r21.getSecond();
        long r113 = System.currentTimeMillis() - r14;
        Object r23 = r16.element;
        if (r23 != null) goto L21;
        int r114 = IServerListener.WHAT_BYTELINK_SINK_ERROR;
    L22:
        AIPackage r30 = (AIPackage) r23;
        if (r30 == null) goto L25;
        long r31 = r30.c;
    L26:
        long r115 = r31;
        String r116 = (String) r15.element;
        if (r30 == null) goto L29;
        String r32 = r30.B;
    L30:
        I(r111, r112, r115, r110, r114, r116, r113, r32, r22);
        return r16.element;
    L29:
        r32 = null;
        goto L30
    L25:
        r31 = -1;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        G(r24, r25, r26, r27);
        Ref.ObjectRef r33 = new Ref.ObjectRef();
        Ref.ObjectRef r34 = new Ref.ObjectRef();
        long r117 = System.currentTimeMillis();
        AIManager r35 = a;
        r111 = r24;
        r11.L$0 = r111;
        r112 = r25;
        r11.L$1 = r112;
        r11.L$2 = r26;
        r11.L$3 = r27;
        r11.L$4 = r33;
        r11.L$5 = r34;
        r11.J$0 = r117;
        r11.label = 1;
        Object r36 = r35.F(r24, r25, r26, r28, r11);
        if (r36 != r12) goto L17;
        return r12;
    L17:
        r16 = r33;
        r0 = r36;
        r15 = r34;
        r14 = r117;
        r110 = r26;
        r22 = r27;
    L7:
        r1 = new AIManager$loadAIPackageFromGecko$1(this, r29);
        goto L8
    }

    public static Object n(int r10, String r11, String r12, String r13, int r14, List r15, Continuation r16) {
        AIPackageManager.a.getClass();
        return BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageManager$getPreviewAppInfoList$2(r10, r15, r12, r11, r13, r14, null), r16);
    }

    public static Object o(int r10, String r11, String r12, String r13, String r14, int r15, Continuation r16) {
        AIPackageManager.a.getClass();
        return BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageManager$getPreviewAppVersionList$2(r10, r11, r12, r13, r14, r15, null), r16);
    }

    public final Object v(int r15, String r16, String r17, String r18, String r19, Function4<? super Boolean, ? super Boolean, ? super d0, ? super String, Unit> r20, Continuation<? super Unit> r21) {
        com.bytedance.ai.utils.g.a.i("AIManager", "install AIPackage in memory with packageName: " + r16 + ", versionTag: " + r17);
        Object r0 = u(r15, r16, 0, r18, "", r19, r17, r20, r21);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }

    public final Object y(String r39, String r40, boolean r41, AIPackage.AIPackageType r42, Map<String, Object> r43, String r44, Continuation<? super AIPackage> r45) {
        if ((r45 instanceof AIManager$loadAIPackage$1) == false) goto L7;
        AIManager$loadAIPackage$1 r10 = (AIManager$loadAIPackage$1) r45;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r1 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r13 = ", appId:";
        String r14 = ", versionCode: ";
        String r15 = "applet_lifecycle";
        switch(r10.label) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r16 = r10.J$0;
        b r17 = (b) r10.L$4;
        Map<String, Object> r18 = (Map) r10.L$3;
        AIPackage.AIPackageType r19 = (AIPackage.AIPackageType) r10.L$2;
        String r110 = (String) r10.L$1;
        String r20 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
        String r21 = "aisdk_fallback";
        String r22 = ", appId:";
        String r23 = ", versionCode: ";
        String r111 = ", packageType: ";
        String r112 = "AIManager";
    L95:
        AIPackage r24 = (AIPackage) r1;
        Map<String, Object> r33 = r18;
        AIPackage.AIPackageType r27 = r19;
        long r25 = r16;
    L97:
        if (r24 == null) goto L100;
        com.bytedance.ai.utils.g.a.w(r112, "load default package as fallback after BASE_READY full install failed. packageName: " + r20 + r22 + r110 + r111 + r27.name() + r23 + r24.c);
        r24.B = r21;
        H(r24, 0, null, System.currentTimeMillis() - r25, r33);
        return r24;
    L100:
        I(r20, r110, -1, r27, r17.e, r17.f, System.currentTimeMillis() - r25, "aisdk_install", r33);
        return null;
    L13:
        long r26 = r10.J$1;
        long r28 = r10.J$0;
        AIPackage r29 = (AIPackage) r10.L$4;
        Map<String, Object> r113 = (Map) r10.L$3;
        AIPackage.AIPackageType r30 = (AIPackage.AIPackageType) r10.L$2;
        String r31 = (String) r10.L$1;
        String r32 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
        String r114 = "<set-?>";
        String r34 = r31;
        r21 = "aisdk_fallback";
        r22 = ", appId:";
        Map<String, Object> r0 = r113;
        String r115 = "applet_lifecycle";
        String r35 = ", appId: ";
        String r210 = ", packageType: ";
        long r116 = r26;
        AIPackage.AIPackageType r36 = r30;
        AIPackage r37 = r29;
        String r38 = ", versionCode: ";
        long r117 = r28;
    L74:
        b r46 = (b) r1;
        r23 = r38;
        AIManager$loadAIPackage$1 r211 = r10;
        if (r46.e == 0) goto L77;
    L80:
        long r310 = r117;
        r112 = r5;
        r111 = r210;
        com.bytedance.ai.utils.g r118 = com.bytedance.ai.utils.g.a;
        Map<String, Object> r47 = r0;
        long r48 = r116;
        r118.e(r112, "===Failed to install AIPackage. packageName: " + r32 + r35 + r34 + r111 + r36.name() + " errorCode: " + r46.e);
        StringBuilder r49 = new StringBuilder("<initApplet><");
        r49.append(r32);
        r49.append(", ");
        r49.append(r34);
        r49.append("> ");
        r49.append(r36.name());
        r49.append(" install fail");
        r118.i(r115, r49.toString());
        if (r37 == null) goto L83;
        AIPackage.PackageStatus r50 = r37.y;
    L85:
        if (r50 == AIPackage.PackageStatus.BASE_READY) goto L87;
    L96:
        r25 = r310;
        r110 = r34;
        r20 = r32;
        r27 = r36;
        r33 = r47;
        r17 = r46;
        r24 = null;
        goto L97
    L87:
        if (r48 == 0) goto L96;
        r211.L$0 = r32;
        r211.L$1 = r34;
        r211.L$2 = r36;
        r211.L$3 = r47;
        r211.L$4 = r46;
        r211.J$0 = r310;
        r211.label = 6;
        if (r48 == 0) goto L92;
        n5.a.a.getClass();
    L92:
        if (r12 != null) goto L94;
        return r12;
    L94:
        r110 = r34;
        r20 = r32;
        r16 = r310;
        r18 = r47;
        r19 = r36;
        r17 = r46;
        r1 = null;
        goto L95
    L83:
        r50 = null;
        goto L85
    L77:
        if (r46.a == null) goto L80;
        AIPackage r51 = r46.a;
        com.bytedance.ai.utils.g r52 = com.bytedance.ai.utils.g.a;
        r52.d("AIManager", "===install AIPackage succeed. packageName: " + r51.b + r35 + r51.a() + r210 + r51.c().name() + ", version: " + r51.c);
        StringBuilder r53 = new StringBuilder("<initApplet><");
        r53.append(r32);
        r53.append(", ");
        r53.append(r51.a());
        r53.append("> ");
        r53.append(r36.name());
        r53.append(" install success");
        r52.i(r115, r53.toString());
        H(r51, r46.e, r46.f, System.currentTimeMillis() - r117, r0);
        r51.B = "aisdk_install";
        AIPackage.PackageStatus r54 = AIPackage.PackageStatus.READY;
        Intrinsics.checkNotNullParameter(r54, r114);
        r51.y = r54;
        e(r51, false);
        return r51;
    L14:
        long r55 = r10.J$1;
        long r56 = r10.J$0;
        AIPackage r57 = (AIPackage) r10.L$4;
        Map<String, Object> r119 = (Map) r10.L$3;
        AIPackage.AIPackageType r58 = (AIPackage.AIPackageType) r10.L$2;
        String r59 = (String) r10.L$1;
        String r60 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
        r114 = "<set-?>";
        String r61 = r60;
        r21 = "aisdk_fallback";
        r13 = ", appId:";
        Map<String, Object> r212 = r119;
        r14 = ", versionCode: ";
        r15 = "applet_lifecycle";
        String r120 = ", packageType: ";
        r117 = r56;
        AIPackage.AIPackageType r62 = r58;
        r37 = r57;
        String r63 = r59;
        long r64 = r55;
        String r311 = ", appId: ";
    L64:
        AIPackage r65 = (AIPackage) r1;
        if (r65 == null) goto L68;
        com.bytedance.ai.utils.g.a.w("AIManager", "load default package as fallback. packageName: " + r61 + r13 + r63 + r120 + r62.name() + r14 + r65.c);
        r65.B = r21;
        H(r65, 0, null, System.currentTimeMillis() - r117, r212);
        return r65;
    L68:
        String r121 = r13;
        r116 = r64;
        Map<String, Object> r66 = r212;
        r32 = r61;
        r36 = r62;
        String r67 = r63;
        r38 = r14;
    L70:
        com.bytedance.ai.utils.g r68 = com.bytedance.ai.utils.g.a;
        r22 = r121;
        r68.d("AIManager", "===fail to load AIPackage. try to install it");
        StringBuilder r122 = new StringBuilder("<initApplet> install AIPackage with packageName: ");
        r122.append(r32);
        r35 = r311;
        r122.append(r35);
        r122.append(r67);
        r122.append(r120);
        r210 = r120;
        r122.append(r36.name());
        r122.append(r38);
        r122.append(r116);
        String r123 = r122.toString();
        r115 = r15;
        r68.i(r115, r123);
        r10.L$0 = r32;
        r10.L$1 = r67;
        r10.L$2 = r36;
        r10.L$3 = r66;
        r10.L$4 = r37;
        r10.J$0 = r117;
        r10.J$1 = r116;
        r10.label = 5;
        Object r69 = t(r32, r67, r116, r10);
        if (r69 != r12) goto L73;
        return r12;
    L73:
        r34 = r67;
        r0 = r66;
        r1 = r69;
        goto L74
    L15:
        long r70 = r10.J$0;
        Map r124 = (Map) r10.L$3;
        AIPackage.AIPackageType r125 = (AIPackage.AIPackageType) r10.L$2;
        String r126 = (String) r10.L$1;
        String r71 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
        AIPackage r72 = (AIPackage) r1;
        if (r72 == null) goto L19;
        H(r72, 0, null, System.currentTimeMillis() - r70, r124);
        AIPackage.PackageStatus r73 = AIPackage.PackageStatus.READY;
        Intrinsics.checkNotNullParameter(r73, "<set-?>");
        r72.y = r73;
        e(r72, true);
        return r72;
    L19:
        I(r71, r126, -1, r125, 13, "failed to get packageInfo from remote", System.currentTimeMillis() - r70, "aisdk_install", r124);
        return null;
    L21:
        long r74 = r10.J$0;
        boolean r75 = r10.Z$0;
        String r76 = (String) r10.L$4;
        Map<String, Object> r77 = (Map) r10.L$3;
        AIPackage.AIPackageType r78 = (AIPackage.AIPackageType) r10.L$2;
        String r79 = (String) r10.L$1;
        r32 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
        r67 = r79;
        Map<String, Object> r80 = r77;
        r36 = r78;
        String r81 = r76;
        r114 = "<set-?>";
        r117 = r74;
    L31:
        AIPackage r82 = (AIPackage) r1;
        if (r82 == null) goto L37;
        com.bytedance.ai.utils.g.a.i("AIManager", "===load AIPackage with packageName: " + r32 + ", appId: " + r67 + " success. current status is " + r82.y.name() + " resFrom " + r82.B);
        if (r82.y != AIPackage.PackageStatus.READY) goto L37;
        H(r82, 0, null, System.currentTimeMillis() - r117, r80);
        return r82;
    L37:
        if (r82 == null) goto L39;
    L43:
        r120 = r15;
        if (r82 == null) goto L46;
    L48:
        n5.a.C0181a r83 = n5.a.a;
        r83.getClass();
        if (r82 != null) goto L51;
    L52:
        if (r75 == false) goto L102;
        r116 = l(r32).i;
        if (r82 == null) goto L56;
    L69:
        r311 = ", appId: ";
        r38 = r14;
        r121 = r13;
        r21 = "aisdk_fallback";
        Map<String, Object> r312 = r80;
        r37 = r82;
        r66 = r312;
        goto L70
    L56:
        if (r116 == 0) goto L69;
        r10.L$0 = r32;
        r10.L$1 = r67;
        r10.L$2 = r36;
        r10.L$3 = r80;
        r10.L$4 = r82;
        r10.J$0 = r117;
        r10.J$1 = r116;
        r311 = ", appId: ";
        r10.label = 4;
        if (r116 == 0) goto L61;
        r83.getClass();
    L61:
        if (r12 != null) goto L63;
        return r12;
    L63:
        r63 = r67;
        r61 = r32;
        r62 = r36;
        r212 = r80;
        r64 = r116;
        r37 = r82;
        r1 = null;
    L102:
        String r84 = null;
        StringBuilder r85 = new StringBuilder("return targetPackage with error state ");
        if (r82 == null) goto L105;
        AIPackage.PackageStatus r86 = r82.y;
    L106:
        r85.append(r86);
        String r313 = r85.toString();
        long r314 = System.currentTimeMillis() - r117;
        if (r82 == null) goto L109;
        r84 = r82.B;
    L109:
        I(r32, r67, -1, r36, IServerListener.WHAT_BYTELINK_SINK_ERROR, r313, r314, r84, r80);
        return r82;
    L105:
        r86 = null;
        goto L106
    L51:
        if (r82.y != AIPackage.PackageStatus.BASE_READY) goto L102;
    L46:
        if (IAISDKDebugService.a.getDebugMode() != IAISDKDebugService$DebugMode.SCAN_PREVIEW) goto L48;
        com.bytedance.ai.utils.g.a.i("AIManager", "skip normal package load in SCAN_PREVIEW. packageName: " + r32 + ", appId: " + r67 + r120 + r36.name() + ", versionTag: " + r81);
        I(r32, r67, -1, r36, 7, "skip normal package load in SCAN_PREVIEW", System.currentTimeMillis() - r117, null, r80);
        return null;
    L39:
        if (x() == false) goto L43;
        com.bytedance.ai.utils.g.a.i("AIManager", "skip loading absent AIPackage for oversea host. packageName: " + r32 + ", appId: " + r67 + ", packageType: " + r36.name());
        I(r32, r67, -1, r36, 7, "skip loading absent AIPackage for oversea host", System.currentTimeMillis() - r117, null, r80);
        return null;
    L22:
        boolean r87 = r10.Z$0;
        String r88 = (String) r10.L$4;
        Map<String, Object> r89 = (Map) r10.L$3;
        AIPackage.AIPackageType r90 = (AIPackage.AIPackageType) r10.L$2;
        String r91 = (String) r10.L$1;
        r32 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
        String r92 = r91;
        Map<String, Object> r93 = r89;
        AIPackage.AIPackageType r94 = r90;
        r114 = "<set-?>";
        r81 = r88;
        boolean r95 = r87;
    L27:
        G(r32, r92, r94, r93);
        r117 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AIManager", "===load AIPackage with packageName: " + r32 + ", appId: " + r92 + ", packageType: " + r94.name());
        r10.L$0 = r32;
        r10.L$1 = r92;
        r10.L$2 = r94;
        r10.L$3 = r93;
        r10.L$4 = r81;
        r10.Z$0 = r95;
        r10.J$0 = r117;
        r10.label = 2;
        Object r96 = k(r32, r92, r94, r81, r10);
        if (r96 != r12) goto L30;
        return r12;
    L30:
        r80 = r93;
        r67 = r92;
        r1 = r96;
        AIPackage.AIPackageType r315 = r94;
        r75 = r95;
        r36 = r315;
        goto L31
    L23:
        ResultKt.throwOnFailure(r1);
        r10.L$0 = r39;
        r10.L$1 = r40;
        r10.L$2 = r42;
        r10.L$3 = r43;
        r10.L$4 = r44;
        r10.Z$0 = r41;
        r10.label = 1;
        if (i(r10) != r12) goto L26;
        return r12;
    L26:
        r114 = "<set-?>";
        r92 = r40;
        r93 = r43;
        r32 = r39;
        r81 = r44;
        r94 = r42;
        r95 = r41;
        goto L27
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r10 = new AIManager$loadAIPackage$1(this, r45);
        goto L8
    }

    public static /* synthetic */ Object B(AIManager r10, String r11, String r12, AIPackage.AIPackageType r13, boolean r14, String r15, ContinuationImpl r16, int r17) {
        if ((r17 & 8) == 0) goto L5;
        boolean r18 = false;
    L7:
        if ((r17 & 16) == 0) goto L10;
        r15 = null;
    L10:
        return r10.A(r11, r12, r13, r18, r15, r16);
    L5:
        r18 = r14;
        goto L7
    }

    public static void I(String r13, String r14, long r15, AIPackage.AIPackageType r17, int r18, String r19, long r20, String r22, Map r23) {
        if (r23 == null) goto L4;
        Map r0 = MapsKt.toMap(r23);
    L5:
        com.bytedance.ai.monitor.b.d("applet_resource_load_end", new g(r13, r14, r15, r17, r18, r19, r20, r22, r0));
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final Object u(int r22, String r23, long r24, String r26, String r27, String r28, String r29, Function4<? super Boolean, ? super Boolean, ? super d0, ? super String, Unit> r30, Continuation<? super Unit> r31) {
        long r11 = r24;
        if ((r31 instanceof AIManager$installAIPackagesWithVersionCodeInMemory$1) == false) goto L7;
        AIManager$installAIPackagesWithVersionCodeInMemory$1 r10 = (AIManager$installAIPackagesWithVersionCodeInMemory$1) r31;
        int r12 = r10.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r12 - Integer.MIN_VALUE;
    L8:
        AIManager$installAIPackagesWithVersionCodeInMemory$1 r14 = r10;
        Object r0 = r14.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r14.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        long r1 = r14.J$0;
        d0 r16 = (d0) r14.L$2;
        List r17 = (List) r14.L$1;
        Function4<? super Boolean, ? super Boolean, ? super d0, ? super String, Unit> r18 = (Function4) r14.L$0;
        ResultKt.throwOnFailure(r0);
        r11 = r1;
    L18:
        Pair r19 = (Pair) r0;
        if (((Boolean) r19.getFirst()).booleanValue() == true) goto L21;
    L24:
        String r20 = "failed to install " + CollectionsKt.joinToString$default(r17, null, null, null, 0, null, null, 63, null) + " with version " + r11 + ", isAllowed: " + ((Boolean) r19.getFirst()).booleanValue() + ", isSucceed:" + ((Boolean) r19.getSecond()).booleanValue();
    L26:
        if (((Boolean) r19.getFirst()).booleanValue() == true) goto L28;
    L30:
        r16 = null;
    L31:
        if (r18 == null) goto L34;
        r18.invoke(r19.getSecond(), r19.getFirst(), r16, r20);
    L34:
        return Unit.INSTANCE;
    L28:
        if (((Boolean) r19.getSecond()).booleanValue() == false) goto L30;
    L21:
        if (((Boolean) r19.getSecond()).booleanValue() == false) goto L24;
        r20 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        com.bytedance.ai.utils.g.a.i("AIManager", "install AIPackage in memory with packageName: " + r23 + ", versionCode: " + r11 + ", versionTag: " + r29);
        ArrayList r110 = new ArrayList();
        d0 r21 = new d0(r23, true, 4);
        AIPackageManager r25 = AIPackageManager.a;
        d r32 = new d(r110, r21);
        r14.L$0 = r30;
        r14.L$1 = r110;
        r14.L$2 = r21;
        r14.J$0 = r11;
        r14.label = 1;
        r25.getClass();
        r0 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageManager$installAIPackagesWithVersionCodeInMemory$2(r23, r24, r29, r22, r26, r27, r28, r32, null), r14);
        if (r0 != r15) goto L17;
        return r15;
    L17:
        r18 = r30;
        r17 = r110;
        r16 = r21;
    L7:
        r10 = new AIManager$installAIPackagesWithVersionCodeInMemory$1(this, r31);
        goto L8
    }
}
