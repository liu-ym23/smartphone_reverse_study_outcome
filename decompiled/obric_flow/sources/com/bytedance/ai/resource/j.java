package com.bytedance.ai.resource;

import android.app.Application;
import android.util.LruCache;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f2734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList f2735b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f2736c = null;
    public static final ConcurrentHashMap d = null;
    public static final Lazy e = null;
    public static final kotlinx.coroutines.s f = null;
    public static final kotlinx.coroutines.s g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final kotlinx.coroutines.s f2737h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f2738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f2739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set f2740k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set f2741l = null;

    static {
        f2734a = new j();
        new ConcurrentHashMap();
        f2735b = new CopyOnWriteArrayList();
        f2736c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = LazyKt.lazy(new a3.f(11));
        f = j0.a();
        g = j0.a();
        f2737h = j0.a();
        f2740k = Collections.newSetFromMap(new ConcurrentHashMap());
        f2741l = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static final u a(ul.d r5) {
        u r10 = new u(r5.getHost());
        Iterator r11 = r5.getAppConfigs().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ul.c r12 = (ul.c) r11.next();
        String r13 = r12.getAccessKey(zm.p.a());
        r10.f2759a.add(new t(r13, r12.getDirName()));
        goto L4
    L6:
        return r10;
    }

    public static void i(Application r10, boolean r11, ul.d r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AIManager$init$1(r12, r11, r10, null), 3, null);
    }

    public static void j(AIPackage r13, int r14, String r15, long r16, Map r18) {
        String r5 = r13.f2259b;
        String r10 = r13.c();
        AIPackage.AIPackageType r11 = r13.e();
        String r12 = r13.B;
        z2.d.e("applet_resource_load_end", new i(r5, r10, r13.f2260c, r11, r14, r15, r16, r12, r18));
    }

    public static void k(AIPackage r10, boolean r11) {
        String r5 = "<initApplet> add AIPackage in temp list. packageName: " + r10.f2259b + ", appId: " + r10.c() + ", type: " + r10.e().name() + ", version: " + r10.f2260c;
        Intrinsics.checkNotNullParameter("applet_lifecycle", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L5;
        r12.i("applet_lifecycle", r5);
    L5:
        String r13 = "add AIPackage into temp list. packageName: " + r10.f2259b + ", appId: " + r10.c() + ", type: " + r10.e().name() + ", version: " + r10.f2260c;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L8;
        r14.i("AIManager", r13);
    L8:
        f0 r15 = o(r10.f2259b);
        if (r15.f2721i != 0) goto L14;
        String r16 = "update packageInfo version. packageName: " + r10.f2259b + ", appId: " + r10.c() + ", type: " + r10.e().name() + ", version: " + r10.f2260c;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L13;
        r17.i("AIManager", r16);
    L13:
        r15.f2721i = r10.f2260c;
        r15.f2722j = r10.d;
    L14:
        AIPackage r18 = null;
        if (r10.e() != AIPackage.AIPackageType.f2279a) goto L25;
        if ((r10 instanceof Applet) == false) goto L19;
        r18 = (Applet) r10;
    L19:
        if (r18 == null) goto L32;
        String r19 = r18.f2276x;
        if (r19 == null) goto L23;
        r15.d(r19);
    L23:
        Intrinsics.checkNotNullParameter(r18, "applet");
        r15.b(r18);
    L32:
        if (r11 == true) goto L34;
        return;
    L34:
        if (r10.A == false) goto L38;
        r15.f2718b = true;
        return;
    L38:
        return;
    L25:
        if ((r10 instanceof Widget) == false) goto L27;
        r18 = (Widget) r10;
    L27:
        if (r18 == null) goto L32;
        String r20 = r18.f2276x;
        if (r20 == null) goto L31;
        r15.d(r20);
    L31:
        Intrinsics.checkNotNullParameter(r18, "widget");
        r15.b(r18);
        goto L32
    }

    public static void l(String r5) {
        Intrinsics.checkNotNullParameter(r5, Constant.APPID);
        com.bytedance.ai.multiprocess.a r10 = com.bytedance.ai.multiprocess.d.f2406a;
        boolean r11 = true;
        if (r10 != null) goto L5;
    L7:
        com.bytedance.ai.multiprocess.a r12 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r12 != null) goto L10;
    L20:
        r11 = false;
    L21:
        if (r11 == true) goto L24;
        f2740k.add(r5);
        return;
    L24:
        return;
    L10:
        if (r12.f2402c == false) goto L12;
        boolean r13 = true;
    L18:
        if (r13 != true) goto L20;
    L12:
        if (r5 != null) goto L14;
    L17:
        r13 = false;
        goto L18
    L14:
        if (r5.length() == 0) goto L17;
        r13 = r12.d.contains(r5);
        goto L18
    L5:
        if (r10.f2402c != true) goto L7;
    }

    public static boolean n(String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        if (f2738i == true) goto L5;
    L22:
        return false;
    L5:
        if (f2740k.contains(r5) == true) goto L22;
        com.bytedance.ai.multiprocess.a r10 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r10 != null) goto L9;
    L19:
        boolean r11 = false;
    L20:
        if (r11 == true) goto L22;
        return true;
    L9:
        if (r10.f2402c == false) goto L11;
        boolean r12 = true;
    L17:
        if (r12 != true) goto L19;
        r11 = true;
        goto L20
    L11:
        if (r5 != null) goto L13;
    L16:
        r12 = false;
        goto L17
    L13:
        if (r5.length() == 0) goto L16;
        r12 = r10.d.contains(r5);
        goto L17
    }

    public static f0 o(String r10) {
        ConcurrentHashMap r5 = d;
        Object r11 = r5.get(r10);
        Object r12 = r11;
        if (r11 != null) goto L22;
        com.bytedance.ai.multiprocess.a r13 = com.bytedance.ai.multiprocess.d.f2406a;
        boolean r14 = false;
        if (r13 != null) goto L7;
    L17:
        f0 r15 = new f0(2, r10, r14);
        d r16 = (d) e.getValue();
        Intrinsics.checkNotNullParameter(r16, "listener");
        r15.g = new WeakReference(r16);
        Object r17 = r5.putIfAbsent(r10, r15);
        r12 = r15;
        if (r17 == null) goto L22;
        r12 = r17;
        goto L22
    L7:
        if (r13.f2402c == false) goto L9;
        boolean r18 = true;
    L15:
        if (r18 != true) goto L17;
        r14 = true;
        goto L17
    L9:
        if (r10 != null) goto L11;
    L14:
        r18 = false;
        goto L15
    L11:
        if (r10.length() == 0) goto L14;
        r18 = r13.d.contains(r10);
    L22:
        return (f0) r12;
    }

    public static void q(String r5) {
        String r10 = com.lynx.tasm.behavior.utils.d.c("remove AIPackage from temp list. packageName: ", r5, "applet_lifecycle");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.i("applet_lifecycle", r10);
    L5:
        String r12 = com.lynx.tasm.behavior.utils.d.c("remove AIPackage from temp list. packageName: ", r5, "AIManager");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L8;
        r13.i("AIManager", r12);
    L8:
        d.remove(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    public final Object b(String r15, String r16, AIPackage.AIPackageType r17, Map r18, ContinuationImpl r19) {
        j r5 = this;
        if ((r19 instanceof AIManager$loadAIPackageFromGecko$1) == false) goto L7;
        AIManager$loadAIPackageFromGecko$1 r10 = (AIManager$loadAIPackageFromGecko$1) r19;
        int r11 = r10.f2484k;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.f2484k = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f2482i;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.f2484k;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        long r20 = r10.f2481h;
        Ref.ObjectRef r21 = r10.g;
        Ref.ObjectRef r22 = r10.f;
        Map r23 = r10.e;
        AIPackage.AIPackageType r24 = r10.d;
        String r25 = r10.f2480c;
        String r26 = r10.f2479b;
        j r27 = r10.f2478a;
        ResultKt.throwOnFailure(r12);
        long r110 = r20;
        Ref.ObjectRef r111 = r22;
        Map r112 = r23;
        r5 = r27;
        AIPackage.AIPackageType r28 = r24;
        String r29 = r25;
        Ref.ObjectRef r30 = r21;
        String r31 = r26;
    L18:
        Pair r32 = (Pair) r12;
        r111.element = r32.getFirst();
        r30.element = r32.getSecond();
        long r33 = System.currentTimeMillis() - r110;
        T r34 = r111.element;
        if (r34 != 0) goto L22;
        int r35 = 1000;
    L21:
        int r36 = r35;
        AIPackage r37 = (AIPackage) r34;
        if (r37 == null) goto L26;
        long r38 = r37.f2260c;
    L27:
        String r39 = (String) r30.element;
        if (r37 == null) goto L31;
        String r40 = r37.B;
    L30:
        String r113 = r40;
        r5.getClass();
        z2.d.e("applet_resource_load_end", new i(r31, r29, r38, r28, r36, r39, r33, r113, r112));
        return r111.element;
    L31:
        r40 = null;
        goto L30
    L26:
        r38 = -1;
        goto L27
    L22:
        r35 = 0;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        z2.d.e("applet_resource_load_begin", new h(r15, r16, r17, r18));
        Ref.ObjectRef r41 = new Ref.ObjectRef();
        r30 = new Ref.ObjectRef();
        r110 = System.currentTimeMillis();
        j r114 = f2734a;
        r10.f2478a = r5;
        r10.f2479b = r15;
        r10.f2480c = r16;
        r10.d = r17;
        r10.e = r18;
        r10.f = r41;
        r10.g = r30;
        r10.f2481h = r110;
        r10.f2484k = 1;
        Object r42 = r114.p(r15, r16, r17, r10);
        if (r42 != r13) goto L17;
        return r13;
    L17:
        r112 = r18;
        r111 = r41;
        r12 = r42;
        r28 = r17;
        r29 = r16;
        r31 = r15;
    L7:
        r10 = new AIManager$loadAIPackageFromGecko$1(this, r19);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ai.resource.j] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.util.Set] */
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
    public final Object c(String r10, String r11, AIPackage.AIPackageType r12, ContinuationImpl r13) {
        if ((r13 instanceof AIManager$getPackageFromCache$1) == false) goto L7;
        AIManager$getPackageFromCache$1 r5 = (AIManager$getPackageFromCache$1) r13;
        int r14 = r5.g;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r5.g = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.e;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.g;
        boolean r18 = true;
        if (r17 == 0) goto L24;
        if (r17 == 1) goto L23;
        if (r17 == 2) goto L20;
        if (r17 != 3) goto L19;
        kotlinx.coroutines.sync.a r19 = (kotlinx.coroutines.sync.a) r5.f2462a;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L16
        kotlinx.coroutines.sync.a r110 = r19;
    L56:
        AIPackage r20 = (AIPackage) r15;     // Catch: Throwable -> L16
        kotlinx.coroutines.sync.a r111 = r110;
        if (r20 == null) goto L61;
        r20.B = "aisdk_db";     // Catch: Throwable -> L16
        r111 = r110;
    L61:
        ((kotlinx.coroutines.sync.d) r111).d(null);
        return r20;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        kotlinx.coroutines.sync.a r112 = r5.d;
        AIPackage.AIPackageType r113 = r5.f2464c;
        String r114 = r5.f2463b;
        String r21 = (String) r5.f2462a;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L16
        ?? r22 = r21;
        kotlinx.coroutines.sync.a r115 = r112;
    L31:
        r20 = (AIPackage) r15;     // Catch: Throwable -> L16
        if (r20 != null) goto L34;
        com.bytedance.ai.multiprocess.a r23 = com.bytedance.ai.multiprocess.d.f2406a;     // Catch: Throwable -> L16
        if (r23 != null) goto L41;
    L51:
        r18 = false;
    L52:
        if (r18 == true) goto L60;
        r5.f2462a = r115;     // Catch: Throwable -> L16
        r5.f2463b = null;     // Catch: Throwable -> L16
        r5.f2464c = null;     // Catch: Throwable -> L16
        r5.d = null;     // Catch: Throwable -> L16
        r5.g = 3;     // Catch: Throwable -> L16
        r15 = BuildersKt.withContext(t2.b.f22089a, new AIManager$queryOrActiveAIPackage$2(r22, r114, r113, null), r5);     // Catch: Throwable -> L16
        r110 = r115;
        if (r15 != r16) goto L56;
    L55:
        return r16;
    L60:
        r20 = null;
        r111 = r115;
        goto L61
    L41:
        if (r23.f2402c == false) goto L43;
        boolean r24 = true;
    L49:
        if (r24 != true) goto L51;
    L43:
        if (r22 != 0) goto L45;
    L48:
        r24 = false;
        goto L49
    L45:
        if (r22.length() == 0) goto L48;
        r24 = r23.d.contains(r22);     // Catch: Throwable -> L16
        goto L49
    L34:
        if (r20.A == false) goto L36;
        String r116 = "aisdk_debug";
    L37:
        r20.B = r116;     // Catch: Throwable -> L16
        r111 = r115;
        goto L61
    L36:
        r116 = "aisdk_memory";
        goto L37
    L23:
        kotlinx.coroutines.sync.a r117 = r5.d;
        r12 = r5.f2464c;
        r11 = r5.f2463b;
        String r25 = (String) r5.f2462a;
        ResultKt.throwOnFailure(r15);
        kotlinx.coroutines.sync.a r26 = r117;
        ?? r118 = r25;
    L68:
        ?? r27 = f2734a;     // Catch: Throwable -> L63
        r5.f2462a = r118;     // Catch: Throwable -> L63
        r5.f2463b = r11;     // Catch: Throwable -> L63
        r5.f2464c = r12;     // Catch: Throwable -> L63
        r5.d = r26;     // Catch: Throwable -> L63
        r5.g = 2;     // Catch: Throwable -> L63
        Object r28 = r27.m(r118, r11, r12, r5);     // Catch: Throwable -> L63
        if (r28 == r16) goto L55;
        ?? r29 = r118;
        r115 = r26;
        r15 = r28;
        r22 = r29;
        AIPackage.AIPackageType r30 = r12;
        r114 = r11;
        r113 = r30;
    L63:
        th = move-exception;
        r10 = r26;
        th = th;
    L65:
        ((kotlinx.coroutines.sync.d) r10).d(null);
        throw th;
    L24:
        ResultKt.throwOnFailure(r15);
        kotlinx.coroutines.sync.d r31 = o(r10).f2723k;
        r5.f2462a = r10;
        r5.f2463b = r11;
        r5.f2464c = r12;
        r5.d = r31;
        r5.g = 1;
        Object r32 = r31.c(r5);
        r26 = r31;
        r118 = r10;
        if (r32 != r16) goto L68;
    L16:
        th = th;
    L7:
        r5 = new AIManager$getPackageFromCache$1(this, r13);
        goto L8
    }

    public final Object d(String r10, String r11, Map r12, ContinuationImpl r13) {
        if ((r13 instanceof AIManager$loadWidget$1) == false) goto L8;
        AIManager$loadWidget$1 r5 = (AIManager$loadWidget$1) r13;
        int r14 = r5.g;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L8;
        r5.g = r14 - Integer.MIN_VALUE;
    L7:
        AIManager$loadWidget$1 r15 = r5;
        Object r16 = r15.e;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r15.g;
        if (r18 == 0) goto L20;
        if (r18 == 1) goto L18;
        if (r18 == 2) goto L17;
        if (r18 != 3) goto L16;
        ResultKt.throwOnFailure(r16);
    L37:
        if ((r16 instanceof Widget) == true) goto L39;
        return null;
    L39:
        return (Widget) r16;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r16);
    L29:
        if ((r16 instanceof Widget) == true) goto L31;
        return null;
    L31:
        return (Widget) r16;
    L18:
        r12 = r15.d;
        r11 = r15.f2495c;
        r10 = r15.f2494b;
        j this = r15.f2493a;
        ResultKt.throwOnFailure(r16);
    L19:
        j r19 = this;
        Map r20 = r12;
        r19.getClass();
        if (n(r10) == false) goto L33;
        AIPackage.AIPackageType r21 = AIPackage.AIPackageType.f2280b;
        r15.f2493a = null;
        r15.f2494b = null;
        r15.f2495c = null;
        r15.d = null;
        r15.g = 2;
        r16 = r19.b(r10, r11, r21, r20, r15);
        if (r16 != r17) goto L29;
    L35:
        return r17;
    L33:
        AIPackage.AIPackageType r22 = AIPackage.AIPackageType.f2280b;
        r15.f2493a = null;
        r15.f2494b = null;
        r15.f2495c = null;
        r15.d = null;
        r15.g = 3;
        r16 = r19.e(r10, r11, true, r22, r20, r15);
        if (r16 != r17) goto L37;
    L20:
        ResultKt.throwOnFailure(r16);
        r15.f2493a = this;
        r15.f2494b = r10;
        r15.f2495c = r11;
        r15.d = r12;
        r15.g = 1;
        if (h(r15) != r17) goto L19;
    L8:
        r5 = new AIManager$loadWidget$1(this, r13);
        goto L7
    }

    public final Object e(String r38, String r39, boolean r40, AIPackage.AIPackageType r41, Map r42, ContinuationImpl r43) {
        if ((r43 instanceof AIManager$loadAIPackage$1) == false) goto L7;
        AIManager$loadAIPackage$1 r5 = (AIManager$loadAIPackage$1) r43;
        int r10 = r5.f2474k;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f2474k = r10 - Integer.MIN_VALUE;
    L8:
        Object r11 = r5.f2472i;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r5.f2474k;
        String r14 = ", versionCode: ";
        String r15 = ", packageType: ";
        if (r13 == 0) goto L25;
        if (r13 == 1) goto L24;
        if (r13 == 2) goto L23;
        if (r13 != 3) goto L14;
        long r16 = r5.g;
        Map r17 = r5.e;
        AIPackage.AIPackageType r18 = r5.d;
        String r19 = (String) r5.f2470c;
        String r20 = r5.f2469b;
        j r21 = (j) r5.f2468a;
        ResultKt.throwOnFailure(r11);
        Map r28 = r17;
        AIPackage.AIPackageType r22 = r18;
        String r110 = r19;
        String r37 = "applet_resource_load_end";
        String r111 = r20;
    L68:
        AIPackage r23 = (AIPackage) r11;
        if (r23 == null) goto L72;
        long r24 = System.currentTimeMillis() - r16;
        r21.getClass();
        j(r23, 0, null, r24, r28);
        AIPackage.PackageStatus r25 = AIPackage.PackageStatus.f2282a;
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r23.f2277y = r25;
        k(r23, true);
        return r23;
    L72:
        long r26 = System.currentTimeMillis() - r16;
        r21.getClass();
        z2.d.e(r37, new i(r111, r110, -1, r22, 13, "failed to get packageInfo from remote", r26, "aisdk_install", r28));
        return null;
    L14:
        if (r13 != 4) goto L16;
        long r27 = r5.f2471h;
        long r112 = r5.g;
        Map r29 = r5.e;
        AIPackage.AIPackageType r30 = r5.d;
        String r113 = (String) r5.f2470c;
        String r31 = r5.f2469b;
        j r32 = (j) r5.f2468a;
        ResultKt.throwOnFailure(r11);
        r14 = ", versionCode: ";
        String r33 = r113;
        r15 = ", packageType: ";
        Map r114 = r29;
    L83:
        AIPackage r34 = (AIPackage) r11;
        if (r34 == null) goto L90;
        StringBuilder r35 = com.lynx.tasm.base.a.e("load default package as fallback. packageName: ", r31, ", appId:", r33, r15);
        r35.append(r30.name());
        r35.append(r14);
        r35.append(r34.f2260c);
        String r36 = r35.toString();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r44 = com.bytedance.ai.utils.c.f2846a;
        if (r44 == null) goto L88;
        r44.w("AIManager", r36);
    L88:
        r34.B = "aisdk_fallback";
        long r45 = System.currentTimeMillis() - r112;
        r32.getClass();
        j(r34, 0, null, r45, r114);
        return r34;
    L90:
        String r115 = r15;
        long r46 = r27;
        String r47 = r14;
        AIPackage.AIPackageType r48 = r30;
        long r310 = r112;
        String r116 = r31;
        long r49 = r310;
    L92:
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r117 = com.bytedance.ai.utils.c.f2846a;
        if (r117 == null) goto L95;
        r117.d("AIManager", "===fail to load AIPackage. try to install it");
    L95:
        StringBuilder r50 = com.lynx.tasm.base.a.e("<initApplet> install AIPackage with packageName: ", r116, ", appId: ", r33, r115);
        r50.append(r48.name());
        r50.append(r47);
        r50.append(r46);
        String r51 = r50.toString();
        Intrinsics.checkNotNullParameter("applet_lifecycle", "tag");
        t0.d r52 = com.bytedance.ai.utils.c.f2846a;
        if (r52 == null) goto L98;
        r52.i("applet_lifecycle", r51);
    L98:
        r5.f2468a = r116;
        r5.f2469b = r33;
        r5.f2470c = r114;
        r5.d = null;
        r5.e = null;
        r5.g = r49;
        r5.f2471h = r46;
        r5.f2474k = 5;
        kotlinx.coroutines.l r53 = new kotlinx.coroutines.l(1, IntrinsicsKt.intercepted(r5));
        r53.w();
        AtomicReference r54 = new AtomicReference(r53);
        r53.y(new e(r54));
        BuildersKt.launch$default(h0.a(r53.e), t2.b.f22089a, null, new AIManager$loadAIPackage$3$2(r33, r116, r46, r49, r114, r54, null), 2, null);
        Object r55 = r53.v();
        if (r55 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L102;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L102:
        if (r55 == r12) goto L115;
        return r55;
    L115:
        return r12;
    L16:
        if (r13 != 5) goto L20;
        Map r56 = (Map) r5.f2470c;
        String r57 = (String) r5.f2468a;
        ResultKt.throwOnFailure(r11);
        return r11;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        r49 = r5.g;
        boolean r58 = r5.f;
        r114 = r5.e;
        AIPackage.AIPackageType r118 = r5.d;
        String r119 = (String) r5.f2470c;
        String r59 = r5.f2469b;
        j r60 = (j) r5.f2468a;
        ResultKt.throwOnFailure(r11);
        r33 = r119;
        r116 = r59;
        boolean r61 = r58;
        r37 = "applet_resource_load_end";
        r48 = r118;
        j r120 = r60;
    L36:
        AIPackage r62 = (AIPackage) r11;
        if (r62 == null) goto L45;
        StringBuilder r63 = com.lynx.tasm.base.a.e("===load AIPackage with packageName: ", r116, ", appId: ", r33, " success. current status is ");
        r63.append(r62.f2277y.name());
        r63.append(" resFrom ");
        String r64 = androidx.room.jarjarred.org.antlr.runtime.a.v(r63, r62.B, "AIManager", "tag");
        t0.d r121 = com.bytedance.ai.utils.c.f2846a;
        if (r121 == null) goto L42;
        r121.i("AIManager", r64);
    L42:
        if (r62.f2277y != AIPackage.PackageStatus.f2282a) goto L45;
        j(r62, 0, null, System.currentTimeMillis() - r49, r114);
        return r62;
    L45:
        com.bytedance.ai.multiprocess.a r65 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r65 != null) goto L48;
    L59:
        boolean r66 = false;
    L60:
        if (r66 == false) goto L74;
        r5.f2468a = r120;
        r5.f2469b = r116;
        r5.f2470c = r33;
        r5.d = r48;
        r5.e = r114;
        r5.g = r49;
        r5.f2474k = 3;
        if (com.bytedance.ai.multiprocess.d.f2406a == null) goto L64;
        r11 = com.bytedance.ai.process.resource.d.a(r116, r33, r48, r114, r5);
    L65:
        if (r11 == r12) goto L103;
        r16 = r49;
        r110 = r33;
        r22 = r48;
        r28 = r114;
        r111 = r116;
        r21 = r120;
    L103:
        return r12;
    L64:
        r11 = null;
        goto L65
    L74:
        String r67 = r37;
        if (r62 != null) goto L105;
        if (r61 == false) goto L105;
        r120.getClass();
        r46 = o(r116).f2721i;
        if (r46 == 0) goto L91;
        r5.f2468a = r120;
        r5.f2469b = r116;
        r5.f2470c = r33;
        r5.d = r48;
        r5.e = r114;
        r5.g = r49;
        r5.f2471h = r46;
        r5.f2474k = 4;
        Object r68 = com.bytedance.ai.multiprocess.d.b(r116, r33, r48, r5);
        if (r68 == r12) goto L103;
        long r311 = r49;
        r30 = r48;
        r31 = r116;
        r11 = r68;
        r27 = r46;
        r32 = r120;
        r112 = r311;
        goto L83
    L91:
        r47 = r14;
        r115 = r15;
    L105:
        StringBuilder r69 = new StringBuilder("return targetPackage with error state ");
        if (r62 == null) goto L108;
        AIPackage.PackageStatus r70 = r62.f2277y;
    L109:
        r69.append(r70);
        String r210 = r69.toString();
        long r211 = System.currentTimeMillis() - r49;
        if (r62 == null) goto L112;
        String r312 = r62.B;
    L113:
        r120.getClass();
        z2.d.e(r67, new i(r116, r33, -1, r48, 1000, r210, r211, r312, r114));
        return r62;
    L112:
        r312 = null;
        goto L113
    L108:
        r70 = null;
        goto L109
    L48:
        if (r65.f2402c == false) goto L51;
        boolean r71 = true;
    L57:
        if (r71 != true) goto L59;
        r66 = true;
        goto L60
    L51:
        if (r116 != null) goto L53;
    L56:
        r71 = false;
        goto L57
    L53:
        if (r116.length() == 0) goto L56;
        r71 = r65.d.contains(r116);
        goto L57
    L24:
        r61 = r5.f;
        Map r72 = r5.e;
        AIPackage.AIPackageType r73 = r5.d;
        String r122 = (String) r5.f2470c;
        r116 = r5.f2469b;
        r120 = (j) r5.f2468a;
        ResultKt.throwOnFailure(r11);
    L29:
        r120.getClass();
        z2.d.e("applet_resource_load_begin", new h(r116, r122, r73, r72));
        long r74 = System.currentTimeMillis();
        r37 = "applet_resource_load_end";
        StringBuilder r75 = com.lynx.tasm.base.a.e("===load AIPackage with packageName: ", r116, ", appId: ", r122, ", packageType: ");
        r75.append(r73.name());
        String r76 = r75.toString();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r123 = com.bytedance.ai.utils.c.f2846a;
        if (r123 == null) goto L32;
        r123.d("AIManager", r76);
    L32:
        r5.f2468a = r120;
        r5.f2469b = r116;
        r5.f2470c = r122;
        r5.d = r73;
        r5.e = r72;
        r5.f = r61;
        r5.g = r74;
        r5.f2474k = 2;
        r11 = r120.c(r116, r122, r73, r5);
        if (r11 == r12) goto L103;
        String r313 = r122;
        r114 = r72;
        r48 = r73;
        r49 = r74;
        r33 = r313;
        goto L36
    L25:
        ResultKt.throwOnFailure(r11);
        y r77 = y.f2766a;
        r5.f2468a = this;
        r5.f2469b = r38;
        r5.f2470c = r39;
        r5.d = r41;
        r5.e = r42;
        r5.f = r40;
        r5.f2474k = 1;
        if (r77.a(r5) == r12) goto L103;
        r61 = r40;
        r120 = this;
        r116 = r38;
        r72 = r42;
        r122 = r39;
        r73 = r41;
    L7:
        r5 = new AIManager$loadAIPackage$1(this, r43);
        goto L8
    }

    public final Object f(String r10, Map r11, ContinuationImpl r12) {
        if ((r12 instanceof AIManager$loadApplet$1) == false) goto L8;
        AIManager$loadApplet$1 r5 = (AIManager$loadApplet$1) r12;
        int r13 = r5.f;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L8;
        r5.f = r13 - Integer.MIN_VALUE;
    L7:
        AIManager$loadApplet$1 r14 = r5;
        Object r15 = r14.d;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r14.f;
        if (r17 == 0) goto L20;
        if (r17 == 1) goto L18;
        if (r17 == 2) goto L17;
        if (r17 != 3) goto L16;
        ResultKt.throwOnFailure(r15);
    L37:
        if ((r15 instanceof Applet) == true) goto L39;
        return null;
    L39:
        return (Applet) r15;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r15);
    L29:
        if ((r15 instanceof Applet) == true) goto L31;
        return null;
    L31:
        return (Applet) r15;
    L18:
        r11 = r14.f2490c;
        r10 = r14.f2489b;
        j this = r14.f2488a;
        ResultKt.throwOnFailure(r15);
    L19:
        j r18 = this;
        Map r19 = r11;
        r18.getClass();
        if (n(r10) == false) goto L33;
        AIPackage.AIPackageType r20 = AIPackage.AIPackageType.f2279a;
        r14.f2488a = null;
        r14.f2489b = null;
        r14.f2490c = null;
        r14.f = 2;
        r15 = r18.b(r10, r10, r20, r19, r14);
        if (r15 != r16) goto L29;
    L35:
        return r16;
    L33:
        AIPackage.AIPackageType r21 = AIPackage.AIPackageType.f2279a;
        r14.f2488a = null;
        r14.f2489b = null;
        r14.f2490c = null;
        r14.f = 3;
        r15 = r18.e(r10, r10, true, r21, r19, r14);
        if (r15 != r16) goto L37;
    L20:
        ResultKt.throwOnFailure(r15);
        r14.f2488a = this;
        r14.f2489b = r10;
        r14.f2490c = r11;
        r14.f = 1;
        if (h(r14) != r16) goto L19;
    L8:
        r5 = new AIManager$loadApplet$1(this, r12);
        goto L7
    }

    public final Object g(String r10, ContinuationImpl r11) {
        if ((r11 instanceof AIManager$updatePackages$1) == false) goto L7;
        AIManager$updatePackages$1 r5 = (AIManager$updatePackages$1) r11;
        int r12 = r5.e;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.f2504c;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.e;
        if (r15 == 0) goto L20;
        if (r15 == 1) goto L19;
        if (r15 == 2) goto L17;
        if (r15 != 3) goto L16;
        ResultKt.throwOnFailure(r13);
        return r13;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);
        return r13;
    L19:
        r10 = r5.f2503b;
        j this = r5.f2502a;
        ResultKt.throwOnFailure(r13);
    L23:
        this.getClass();
        if (n(r10) == false) goto L29;
        r r16 = r.f2752a;
        r5.f2502a = null;
        r5.f2503b = null;
        r5.e = 2;
        Object r17 = BuildersKt.withContext(t2.b.f22089a, new AIPackageManager$updateAIPackageFromGecko$2(r10, null), r5);
        if (r17 == r14) goto L31;
        return r17;
    L31:
        return r14;
    L29:
        r r18 = r.f2752a;
        r5.f2502a = null;
        r5.f2503b = null;
        r5.e = 3;
        Object r19 = BuildersKt.withContext(t2.b.f22089a, new AIPackageManager$updateAIPackages$4(r10, null), r5);
        if (r19 == r14) goto L31;
        return r19;
    L20:
        ResultKt.throwOnFailure(r13);
        r5.f2502a = this;
        r5.f2503b = r10;
        r5.e = 1;
        if (h(r5) != r14) goto L23;
    L7:
        r5 = new AIManager$updatePackages$1(this, r11);
        goto L8
    }

    public final Object h(ContinuationImpl r10) {
        if ((r10 instanceof AIManager$ensureInitialize$1) == false) goto L7;
        AIManager$ensureInitialize$1 r5 = (AIManager$ensureInitialize$1) r10;
        int r11 = r5.f2461c;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f2461c = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.f2459a;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.f2461c;
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L20;
        if (r14 == 2) goto L19;
        if (r14 != 3) goto L18;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L15
    L36:
        ((Boolean) r12).getClass();     // Catch: Exception -> L15
    L42:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L15
    L32:
        if (((Boolean) r12).booleanValue() == false) goto L42;
        kotlinx.coroutines.s r15 = f2737h;     // Catch: Exception -> L15
        r5.f2461c = 3;     // Catch: Exception -> L15
        r12 = r15.d(r5);     // Catch: Exception -> L15
        if (r12 != r13) goto L36;
    L35:
        return r13;
    L20:
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L15
    L27:
        if (((Boolean) r12).booleanValue() == false) goto L42;
        kotlinx.coroutines.s r16 = f;     // Catch: Exception -> L15
        r5.f2461c = 2;     // Catch: Exception -> L15
        r12 = r16.d(r5);     // Catch: Exception -> L15
        if (r12 != r13) goto L32;
    L22:
        ResultKt.throwOnFailure(r12);
        kotlinx.coroutines.s r17 = g;     // Catch: Exception -> L15
        r5.f2461c = 1;     // Catch: Exception -> L15
        r12 = r17.d(r5);     // Catch: Exception -> L15
        if (r12 != r13) goto L27;
    L15:
        e = move-exception;
        String r18 = "ensureInitialize exception: " + e;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L42;
        r19.e("AIManager", r18);
    L7:
        r5 = new AIManager$ensureInitialize$1(this, r10);
        goto L8
    }

    public final Object m(String r10, String r11, AIPackage.AIPackageType r12, ContinuationImpl r13) {
        if ((r13 instanceof AIManager$loadAIPackageFromMemory$1) == false) goto L7;
        AIManager$loadAIPackageFromMemory$1 r5 = (AIManager$loadAIPackageFromMemory$1) r13;
        int r14 = r5.g;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r5.g = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.e;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.g;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        r12 = r5.d;
        r11 = r5.f2487c;
        r10 = r5.f2486b;
        j this = r5.f2485a;
        ResultKt.throwOnFailure(r15);
    L27:
        AIPackage r18 = (AIPackage) r15;
    L28:
        if (r18 == null) goto L30;
        return r18;
    L30:
        this.getClass();
        f0 r19 = o(r10);
        if (r12 != AIPackage.AIPackageType.f2279a) goto L35;
        return r19.a(r11);
    L35:
        return r19.c(r11);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = r5.d;
        r11 = r5.f2487c;
        r10 = r5.f2486b;
        this = r5.f2485a;
        ResultKt.throwOnFailure(r15);
    L22:
        r18 = (AIPackage) r15;
        goto L28
    L16:
        ResultKt.throwOnFailure(r15);
        if (r12 != AIPackage.AIPackageType.f2279a) goto L23;
        r5.f2485a = this;
        r5.f2486b = r10;
        r5.f2487c = r11;
        r5.d = r12;
        r5.g = 1;
        if (r16 == null) goto L25;
        r15 = null;
    L25:
        return r16;
    L23:
        r5.f2485a = this;
        r5.f2486b = r10;
        r5.f2487c = r11;
        r5.d = r12;
        r5.g = 2;
        if (r16 == null) goto L25;
        r15 = null;
    L7:
        r5 = new AIManager$loadAIPackageFromMemory$1(this, r13);
        goto L8
    }

    public final Object p(String r19, String r20, AIPackage.AIPackageType r21, ContinuationImpl r22) {
        j r5 = this;
        String r10 = r19;
        String r11 = r20;
        AIPackage.AIPackageType r12 = r21;
        if ((r22 instanceof AIManager$realLoadAIPackageFromGecko$1) == false) goto L7;
        AIManager$realLoadAIPackageFromGecko$1 r13 = (AIManager$realLoadAIPackageFromGecko$1) r22;
        int r14 = r13.g;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.g = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.e;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.g;
        Object r18 = null;
        if (r17 == 0) goto L18;
        if (r17 == 1) goto L17;
        if (r17 == 2) goto L16;
        if (r17 != 3) goto L15;
        AIPackage.AIPackageType r23 = r13.d;
        String r24 = r13.f2501c;
        String r25 = r13.f2500b;
        j r26 = r13.f2499a;
        ResultKt.throwOnFailure(r15);
    L55:
        Pair r27 = (Pair) r15;
        f0 r28 = (f0) r27.getFirst();
        String r29 = (String) r27.getSecond();
        if (r28 == null) goto L75;
        StringBuilder r30 = com.lynx.tasm.base.a.e("===load AIPackage from Gecko in gecko mode success. PackageName: ", r25, ", appId: ", r24, ",  packageType: ");
        r30.append(r23);
        String r31 = r30.toString();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r32 = com.bytedance.ai.utils.c.f2846a;
        if (r32 == null) goto L60;
        r32.i("AIManager", r31);
    L60:
        ConcurrentHashMap r33 = f2736c;
        f0 r34 = (f0) r33.putIfAbsent(r25, r28);
        if (r34 != null) goto L63;
        r26.getClass();
        d r35 = (d) e.getValue();
        Intrinsics.checkNotNullParameter(r35, "listener");
        r28.g = new WeakReference(r35);
    L72:
        if (r23 != AIPackage.AIPackageType.f2279a) goto L74;
        r18 = r28.a(r24);
    L81:
        return TuplesKt.to(r18, r29);
    L74:
        r18 = r28.c(r24);
        goto L81
    L63:
        if (r28.f2718b == true) goto L69;
        r28.f2720h = false;
        LruCache r36 = e0.f2711a;
        e0.j(r28.e);
        WeakReference r37 = r28.g;
        if (r37 == null) goto L69;
        if (((d) r37.get()) == null) goto L69;
        String r38 = r28.f2717a;
        Intrinsics.checkNotNullParameter(r38, "packageName");
        r33.remove(r38);
        q(r38);
    L69:
        r28 = r34;
        goto L72
    L75:
        StringBuilder r39 = com.lynx.tasm.base.a.e("Failed to load AIPackage from Gecko in gecko mode. PackageName: ", r25, ", appId: ", r24, ",  packageType: ");
        r39.append(r23);
        r39.append(" errorMsg: ");
        r39.append(r29);
        String r40 = r39.toString();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r41 = com.bytedance.ai.utils.c.f2846a;
        if (r41 == null) goto L78;
        r41.e("AIManager", r40);
    L78:
        if (r29 != null) goto L81;
        r29 = "Failed to load AIPackage from Gecko in gecko mode, without exception";
        goto L81
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        AIPackage.AIPackageType r42 = r13.d;
        String r43 = r13.f2501c;
        String r44 = r13.f2500b;
        j r45 = r13.f2499a;
        ResultKt.throwOnFailure(r15);
        r12 = r42;
        r5 = r45;
        r11 = r43;
        r10 = r44;
    L33:
        AIPackage r46 = (AIPackage) r15;
    L28:
        AIPackage.AIPackageType r110 = r12;
        r26 = r5;
        r23 = r110;
        String r111 = r11;
        r25 = r10;
        r24 = r111;
        if (r46 == null) goto L40;
        StringBuilder r47 = com.lynx.tasm.base.a.e("===load AIPackage from debug in gecko mode success. PackageName: ", r25, ", appId: ", r24, ",  packageType: ");
        r47.append(r23);
        String r48 = r47.toString();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r49 = com.bytedance.ai.utils.c.f2846a;
        if (r49 == null) goto L38;
        r49.i("AIManager", r48);
    L38:
        r46.B = "aisdk_debug";
        return TuplesKt.to(r46, null);
    L40:
        f0 r50 = (f0) f2736c.get(r25);
        if (r50 != null) goto L43;
    L52:
        r r51 = r.f2752a;
        r13.f2499a = r26;
        r13.f2500b = r25;
        r13.f2501c = r24;
        r13.d = r23;
        r13.g = 3;
        r15 = r51.f(r25, r13);
        if (r15 != r16) goto L55;
    L54:
        return r16;
    L43:
        if (r23 != AIPackage.AIPackageType.f2279a) goto L45;
        AIPackage r52 = r50.a(r24);
    L46:
        if (r52 == null) goto L52;
        r52.B = "aisdk_memory";
        StringBuilder r53 = com.lynx.tasm.base.a.e("===load AIPackage from memory in gecko mode success. PackageName: ", r25, ", appId: ", r24, ",  packageType: ");
        r53.append(r23);
        String r54 = r53.toString();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r55 = com.bytedance.ai.utils.c.f2846a;
        if (r55 == null) goto L51;
        r55.i("AIManager", r54);
    L51:
        return TuplesKt.to(r52, null);
    L45:
        r52 = r50.c(r24);
        goto L46
    L17:
        AIPackage.AIPackageType r56 = r13.d;
        String r57 = r13.f2501c;
        String r58 = r13.f2500b;
        j r59 = r13.f2499a;
        ResultKt.throwOnFailure(r15);
        r12 = r56;
        r5 = r59;
        r11 = r57;
        r10 = r58;
    L27:
        r46 = (AIPackage) r15;
        goto L28
    L18:
        ResultKt.throwOnFailure(r15);
        String r60 = "===load AIPackage in gecko mode. packageName: " + r10 + ", appId: " + r11 + ",  packageType: " + r12;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r61 = com.bytedance.ai.utils.c.f2846a;
        if (r61 == null) goto L22;
        r61.d("AIManager", r60);
    L22:
        if (r12 != AIPackage.AIPackageType.f2279a) goto L29;
        r13.f2499a = r5;
        r13.f2500b = r10;
        r13.f2501c = r11;
        r13.d = r12;
        r13.g = 1;
        if (r16 == null) goto L54;
        r15 = null;
        goto L27
    L29:
        r13.f2499a = r5;
        r13.f2500b = r10;
        r13.f2501c = r11;
        r13.d = r12;
        r13.g = 2;
        if (r16 == null) goto L54;
        r15 = null;
    L7:
        r13 = new AIManager$realLoadAIPackageFromGecko$1(r5, r22);
        goto L8
    }
}
