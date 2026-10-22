package obric.flow.miniappwidget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import com.obric.widget.host.CreateOptions;
import com.obric.widget.host.HostedWidget;
import com.obric.widget.host.WidgetConfig;
import com.obric.widget.host.WidgetDefinition;
import com.obric.widget.host.WidgetHost;
import com.obric.widget.host.WidgetHostRuntime;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f20492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ug.e f20493c;
    public final Context d;
    public final Context e;
    public final ConcurrentHashMap f;
    public final ConcurrentHashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f20494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap f20495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f20496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Messenger f20497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final kotlinx.coroutines.internal.c f20498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final kotlinx.coroutines.internal.c f20499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile Function2 f20500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k f20501o;

    public l(Context r5, kotlinx.coroutines.internal.c r10, ug.e r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter("minus-one", "hostId");
        this.f20491a = "minus-one";
        this.f20492b = r10;
        this.f20493c = r11;
        this.d = r5;
        this.e = r5.getApplicationContext();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.f20494h = ConcurrentHashMap.newKeySet();
        this.f20495i = new ConcurrentHashMap();
        this.f20496j = new AtomicBoolean(false);
        this.f20497k = new Messenger(new Handler(Looper.getMainLooper(), new i(this)));
        this.f20498l = h0.a(CoroutineContext.Element.DefaultImpls.plus(j0.b(), Dispatchers.getIO()));
        this.f20499m = h0.a(CoroutineContext.Element.DefaultImpls.plus(j0.b(), Dispatchers.getIO()));
        this.f20501o = new k(this);
    }

    public static final WidgetRuntimeServices a(l r10) {
        kotlinx.coroutines.internal.c r5 = r10.f20499m;
        return WidgetHostRuntime.runtimeServices$default(r10.e, r10.f20491a, r5, null, false, 24, null);
    }

    public static CreateOptions i(c r10) {
        String r5 = r10.f20468c.f20479i;
        e r11 = r10.d;
        boolean r12 = r11.f20472a;
        Map r13 = r11.f;
        if (r5 != null) goto L5;
    L11:
        Map r14 = r13;
    L12:
        WidgetConfig r15 = new WidgetConfig(r12, r11.f20473b, r11.f20474c, r11.d, r11.e, r14);
        Object r16 = r10.e;
        return new CreateOptions(r10.f20467b, r15, r16);
    L5:
        if (StringsKt.isBlank(r5) == true) goto L11;
        if (r13.containsKey("definitionId") == true) goto L11;
        r14 = MapsKt.plus(r13, TuplesKt.to("definitionId", r5));
        goto L12
    }

    public static WidgetDefinition j(f r11) {
        String r5 = r11.f20475a;
        Map r10 = r11.f20482l;
        String r12 = r11.f20479i;
        if (r12 != null) goto L5;
    L11:
        int r13 = r11.g;
        Long r14 = r11.f20478h;
        String r15 = r11.f20476b;
        String r16 = r11.f20477c;
        int r17 = r11.d;
        int r18 = r11.e;
        int r19 = r11.f;
        return new WidgetDefinition(r5, r15, r16, r17, r18, r19, r13, r14, r10);
    L5:
        if (StringsKt.isBlank(r12) == true) goto L11;
        if (r10.containsKey("definitionId") == true) goto L11;
        r10 = MapsKt.plus(r10, TuplesKt.to("definitionId", r12));
        goto L11
    }

    public final Object b(n r14, ContinuationImpl r15) {
        if ((r15 instanceof MiniAppWidgetHost$checkWidgetValidity$1) == false) goto L7;
        MiniAppWidgetHost$checkWidgetValidity$1 r5 = (MiniAppWidgetHost$checkWidgetValidity$1) r15;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r16 = r5.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r5.label;
        if (r12 == 0) goto L18;
        if (r12 != 1) goto L17;
        r14 = (n) r5.L$1;
        l this = (l) r5.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
    L26:
        return (o) r16;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r16);
        boolean r17 = StringsKt.isBlank(r14.f20505a);
        String r13 = r14.f20506b;
        if (r17 == false) goto L21;
    L34:
        StringBuilder r18 = new StringBuilder("checkWidgetValidity invalid identity hostId=");
        r18.append(this.f20491a);
        r18.append(" appletId=");
        androidx.constraintlayout.motion.widget.a.C(r18, r14.f20505a, " widgetId=", r13, " definitionId=");
        String r19 = androidx.room.jarjarred.org.antlr.runtime.a.w(r18, r14.d, "MiniAppWidgetHost", "tag", "msg");
        org.koin.core.a r110 = su.a.f22013b;
        if (r110 == null) goto L39;
        ((ju.b) r110.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("MiniAppWidgetHost", r19);
        return ib.d.f("missing_identity");
    L39:
        throw new IllegalStateException("KoinApplication has not been started");
    L21:
        if (StringsKt.isBlank(r13) == true) goto L34;
        z r111 = Dispatchers.getIO();     // Catch: Throwable -> L14
        MiniAppWidgetHost$checkWidgetValidity$2 r20 = new MiniAppWidgetHost$checkWidgetValidity$2(this, r14, null);     // Catch: Throwable -> L14
        r5.L$0 = this;     // Catch: Throwable -> L14
        r5.L$1 = r14;     // Catch: Throwable -> L14
        r5.label = 1;     // Catch: Throwable -> L14
        r16 = BuildersKt.withContext(r111, r20, r5);     // Catch: Throwable -> L14
        if (r16 != r11) goto L26;
        return r11;
    L14:
        th = move-exception;
        StringBuilder r112 = androidx.constraintlayout.motion.widget.a.y("checkWidgetValidity failed hostId=", this.f20491a, " appletId=", r14.f20505a, " widgetId=");
        r112.append(r14.f20506b);
        r112.append(" definitionId=");
        String r113 = androidx.room.jarjarred.org.antlr.runtime.a.w(r112, r14.d, "MiniAppWidgetHost", "tag", "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r114 = su.a.f22013b;
        if (r114 == null) goto L33;
        ((ju.b) r114.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetHost", r113, th);
        String r21 = th.getMessage();
        return new o(MiniAppWidgetRuntimeValidity.UNKNOWN, null, null, r21, true);
    L33:
        throw new IllegalStateException("KoinApplication has not been started");
    L7:
        r5 = new MiniAppWidgetHost$checkWidgetValidity$1(this, r15);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v27, types: [java.lang.Object, obric.flow.miniappwidget.c] */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29, types: [obric.flow.miniappwidget.c] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r12v42 */
    /* JADX WARN: Type inference failed for: r12v43 */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v46 */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v49 */
    /* JADX WARN: Type inference failed for: r12v5, types: [obric.flow.miniappwidget.c] */
    /* JADX WARN: Type inference failed for: r12v50 */
    /* JADX WARN: Type inference failed for: r12v51 */
    /* JADX WARN: Type inference failed for: r12v52 */
    /* JADX WARN: Type inference failed for: r12v53 */
    /* JADX WARN: Type inference failed for: r12v54 */
    /* JADX WARN: Type inference failed for: r12v55 */
    /* JADX WARN: Type inference failed for: r12v56 */
    /* JADX WARN: Type inference failed for: r12v57 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [obric.flow.miniappwidget.c] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v31, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v32, types: [com.obric.widget.host.WidgetHost] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v43, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [obric.flow.miniappwidget.l] */
    /* JADX WARN: Type inference failed for: r21v3, types: [kotlin.coroutines.Continuation, obric.flow.miniappwidget.MiniAppWidgetHost$createOrRestoreWidget$1] */
    /* JADX WARN: Type inference failed for: r24v2, types: [obric.flow.miniappwidget.c] */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v10 */
    /* JADX WARN: Type inference failed for: r26v11 */
    /* JADX WARN: Type inference failed for: r26v12 */
    /* JADX WARN: Type inference failed for: r26v13 */
    /* JADX WARN: Type inference failed for: r26v14 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r26v6 */
    /* JADX WARN: Type inference failed for: r26v7 */
    /* JADX WARN: Type inference failed for: r26v8 */
    /* JADX WARN: Type inference failed for: r26v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, obric.flow.miniappwidget.c] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [obric.flow.miniappwidget.c] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r37v1 */
    /* JADX WARN: Type inference failed for: r37v2 */
    /* JADX WARN: Type inference failed for: r37v3 */
    /* JADX WARN: Type inference failed for: r37v4 */
    /* JADX WARN: Type inference failed for: r37v5 */
    /* JADX WARN: Type inference failed for: r37v6 */
    /* JADX WARN: Type inference failed for: r37v7 */
    /* JADX WARN: Type inference failed for: r37v8 */
    /* JADX WARN: Type inference failed for: r37v9 */
    /* JADX WARN: Type inference failed for: r38v1 */
    /* JADX WARN: Type inference failed for: r38v10 */
    /* JADX WARN: Type inference failed for: r38v11 */
    /* JADX WARN: Type inference failed for: r38v12 */
    /* JADX WARN: Type inference failed for: r38v13 */
    /* JADX WARN: Type inference failed for: r38v14 */
    /* JADX WARN: Type inference failed for: r38v15 */
    /* JADX WARN: Type inference failed for: r38v16 */
    /* JADX WARN: Type inference failed for: r38v2 */
    /* JADX WARN: Type inference failed for: r38v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r38v4 */
    /* JADX WARN: Type inference failed for: r38v5 */
    /* JADX WARN: Type inference failed for: r38v6 */
    /* JADX WARN: Type inference failed for: r38v7 */
    /* JADX WARN: Type inference failed for: r38v8 */
    /* JADX WARN: Type inference failed for: r38v9 */
    /* JADX WARN: Type inference failed for: r39v2 */
    /* JADX WARN: Type inference failed for: r39v3 */
    /* JADX WARN: Type inference failed for: r39v4 */
    /* JADX WARN: Type inference failed for: r39v5 */
    /* JADX WARN: Type inference failed for: r39v6 */
    /* JADX WARN: Type inference failed for: r39v7 */
    /* JADX WARN: Type inference failed for: r39v8 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlin.coroutines.jvm.internal.ContinuationImpl, obric.flow.miniappwidget.MiniAppWidgetHost$createOrRestoreWidget$1] */
    /* JADX WARN: Type inference failed for: r6v24, types: [java.lang.Object, obric.flow.miniappwidget.l] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object, obric.flow.miniappwidget.j] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2, types: [obric.flow.miniappwidget.j] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v44 */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [obric.flow.miniappwidget.j] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3, types: [obric.flow.miniappwidget.l] */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v42 */
    /* JADX WARN: Type inference failed for: r9v43 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object, kotlinx.coroutines.sync.d] */
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
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    public final Object c(c r38, boolean r39, ContinuationImpl r40) {
        l r5 = this;
        ?? r10 = r38;
        if ((r40 instanceof MiniAppWidgetHost$createOrRestoreWidget$1) == false) goto L7;
        MiniAppWidgetHost$createOrRestoreWidget$1 r11 = (MiniAppWidgetHost$createOrRestoreWidget$1) r40;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
        final ?? r13 = r11;
    L8:
        Object r14 = r13.result;
        ?? r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final ?? r16 = r13.label;
        final ?? r17 = " appletId=";
        Object r18 = "KoinApplication has not been started";
        String r19 = "tag";
        r19 = "createOrRestoreWidget start restore=";
        String r20 = "MiniAppWidgetHost";
        r20 = " widgetId=";
        if (r16 == 0) goto L30;
        if (r16 != 1) goto L271;
        boolean r21 = r13.Z$0;
        kotlinx.coroutines.sync.a r22 = (kotlinx.coroutines.sync.a) r13.L$4;
        j r23 = (j) r13.L$3;
        Integer r110 = (Integer) r13.L$2;
        c r111 = (c) r13.L$1;
        l r24 = (l) r13.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L28
        boolean r112 = r21;
        l r25 = r24;
        ?? r26 = r22;
        ?? r27 = r23;
        ?? r113 = r111;
    L247:
        ConcurrentHashMap r28 = r25.f;     // Catch: Throwable -> L221
        String r29 = r113.f20467b;     // Catch: Throwable -> L223
        f r30 = r113.f20468c;
        a r31 = (a) r28.get(r29);     // Catch: Throwable -> L221
        String r32 = r25.f20491a;
        ?? r37 = r26;
        String r33 = r113.f20467b;
        ?? r310 = r27;
        String r34 = r113.f20466a;
        if (r31 != null) goto L289;
        String r35 = " appletId=";
        ?? r210 = r18;
        Integer r211 = r110;
        String r114 = r10;
        if (r112 == false) goto L63;
        String r212 = "restoreWidget";
    L62:
        String r213 = r212;
        ?? r214 = r13;
        ?? r215 = r113;
        l r216 = r25;
        String r36 = r19 + r112 + " hostId=" + r32 + " cardId=" + r34 + " instanceId=" + r33 + r35 + r30.f20475a + r20 + r30.f20476b + " definitionId=" + r30.f20479i;     // Catch: Throwable -> L195
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");     // Catch: Throwable -> L193
        String r217 = r114;
        Intrinsics.checkNotNullParameter(r36, r217);     // Catch: Throwable -> L186
        org.koin.core.a r41 = su.a.f22013b;     // Catch: Throwable -> L186
        if (r41 == null) goto L188;
        ((ju.b) r41.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r36);     // Catch: Throwable -> L186
        ?? r42 = r216.e();     // Catch: Throwable -> L182
        if (r112 == true) goto L283;
        r19 = "tag";
        Integer r115 = r211;
        ?? r116 = r215;
        l r43 = r216;
        ?? r44 = r37;
        String r218 = r20;
        r217 = r217;
        r20 = "MiniAppWidgetHost";
        r213 = r213;
        WidgetDefinition r45 = j(r30);     // Catch: Throwable -> L180
        CreateOptions r46 = i(r116);     // Catch: Throwable -> L180
        r214.L$0 = r43;     // Catch: Throwable -> L178
        r214.L$1 = r116;     // Catch: Throwable -> L178
        r214.L$2 = r115;     // Catch: Throwable -> L178
        r214.L$3 = r310;     // Catch: Throwable -> L178
        r214.L$4 = r44;     // Catch: Throwable -> L178
        r214.L$5 = r43;     // Catch: Throwable -> L178
        r214.L$6 = r213;     // Catch: Throwable -> L178
        r214.Z$0 = r112;     // Catch: Throwable -> L178
        r310 = r310;
        r214.label = 3;     // Catch: Throwable -> L175
        r14 = r42.createWidget(r45, r46, r214);     // Catch: Throwable -> L175
        if (r14 != r15) goto L122;
        return r15;
    L122:
        ?? r47 = r310;
        ?? r48 = r44;
        String r49 = r213;
        l r50 = r43;
        boolean r51 = r112;
        l r52 = r43;
        ?? r117 = r116;
        ?? r219 = r210;
    L123:
        HostedWidget r53 = (HostedWidget) r14;     // Catch: Throwable -> L98
        r10 = r49;
        r13 = r50;
        r15 = r48;
        r16 = r47;
        r18 = r52;
        r17 = r117;
        r210 = r219;
    L261:
        b.a(r13.f20499m, new MiniAppWidgetHost$createOrRestoreWidget$2$2$1(r13, r17, r115, null));     // Catch: Throwable -> L173
        String r54 = r13.f20491a;     // Catch: Throwable -> L173
        String r118 = r17.f20467b;     // Catch: Throwable -> L171
        ?? r311 = r10;
        f r55 = r17.f20468c;
        ?? r312 = r15;
        String r56 = r17.f20466a;     // Catch: Throwable -> L169
        ?? r313 = r16;
        String r57 = r55.f20475a;     // Catch: Throwable -> L167
        Object r410 = r18;
        String r58 = r55.f20476b;     // Catch: Throwable -> L162
        String r119 = r35;
        CoroutineScope r59 = r13.f20492b;     // Catch: Throwable -> L165
        if (r59 != null) goto L137;
        r59 = r13.f20498l;     // Catch: Throwable -> L165
    L137:
        a r60 = new a(r54, r118, r56, r57, r58, r53, r59, new MiniAppWidgetHost$createOrRestoreWidget$2$2$2(r13, r17), new MiniAppWidgetHost$createOrRestoreWidget$2$2$3(r13));     // Catch: Throwable -> L162
        r13.f.put(r17.f20467b, r60);     // Catch: Throwable -> L162
        String r61 = r13.f20491a;     // Catch: Throwable -> L162
        String r62 = r17.f20466a;     // Catch: Throwable -> L162
        String r63 = "createOrRestoreWidget success restore=" + r51 + " hostId=" + r61 + " cardId=" + r62 + " instanceId=" + r115 + r119 + r55.f20475a + r218 + r55.f20476b;     // Catch: Throwable -> L162
        r19 = r19;
        r20 = r20;
        Intrinsics.checkNotNullParameter(r20, r19);     // Catch: Throwable -> L159
        r114 = r217;
        Intrinsics.checkNotNullParameter(r63, r114);     // Catch: Throwable -> L157
        org.koin.core.a r64 = su.a.f22013b;     // Catch: Throwable -> L157
        if (r64 == null) goto L152;
        ((ju.b) r64.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i(r20, r63);     // Catch: Throwable -> L157
    L148:
        th = th;
        ?? r65 = r311;
        ?? r66 = r312;
        ?? r67 = r313;
        Object r68 = r410;
        ?? r69 = r13;
        ?? r120 = r17;
        ?? r220 = r210;
    L100:
        ?? r70 = r220;
        ?? r71 = r65;
        ?? r72 = r69;
        ?? r73 = r66;
        ?? r74 = r67;
        ?? r75 = r68;
        ?? r121 = r120;
    L296:
        String r76 = r71 + " failed hostId=" + r75.f20491a;     // Catch: Throwable -> L217
        Intrinsics.checkNotNullParameter(r20, r19);     // Catch: Throwable -> L217
        Intrinsics.checkNotNullParameter(r76, r114);     // Catch: Throwable -> L217
        Intrinsics.checkNotNullParameter(th, "t");     // Catch: Throwable -> L217
        org.koin.core.a r77 = su.a.f22013b;     // Catch: Throwable -> L217
        if (r77 == null) goto L215;
        Object r78 = null;
        ((ju.b) r77.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e(r20, r76, th);     // Catch: Throwable -> L217
        a r221 = null;
        ?? r79 = r73;
        ?? r80 = r72;
        ?? r81 = r74;
        ?? r122 = r121;
    L210:
        ?? r82 = r80;
        r31 = r221;
        ?? r83 = r79;
        final ?? r84 = r81;
        ?? r123 = r122;
    L211:
        ((kotlinx.coroutines.sync.d) r83).d(r78);     // Catch: Throwable -> L28
        String r85 = r123.f20467b;
        ConcurrentHashMap r86 = r82.g;
        final Function2<String, j, j> r87 = new MiniAppWidgetHost$releaseCreationLock$1(r84);
        final int r88 = 1;
        r86.computeIfPresent(r85, new h(r87, r88));
        return r31;
    L215:
        throw new IllegalStateException(r70);     // Catch: Throwable -> L217
    L217:
        Throwable th2 = th;
        ?? r89 = r73;
    L225:
        ((kotlinx.coroutines.sync.d) r89).d(null);     // Catch: Throwable -> L28
        throw th2;     // Catch: Throwable -> L28
    L145:
        if (r13.f20496j.get() == false) goto L150;
        r60.c();     // Catch: Throwable -> L148
        r53.getView().postDelayed(new com.obric.oui.lisitem.a(r60, 22), 250);     // Catch: Throwable -> L148
    L150:
        r79 = r312;
        r81 = r313;
        r221 = r60;
        r78 = null;
        r80 = r13;
        r122 = r17;
        goto L210
    L152:
        ?? r90 = r210;
    L155:
        th = th;
    L161:
        r71 = r311;
        r73 = r312;
        r74 = r313;
        r75 = r410;
        r70 = r90;
        r72 = r13;
        r121 = r17;
        goto L296
    L154:
        throw new IllegalStateException(r90);     // Catch: Throwable -> L155
    L157:
        th = th;
    L164:
        r90 = r210;
    L159:
        th = th;
        r114 = r217;
    L165:
        th = th;
    L163:
        r19 = r19;
        r20 = r20;
        r114 = r217;
    L162:
        th = th;
    L167:
        th = th;
    L168:
        r410 = r18;
    L169:
        th = th;
    L170:
        r313 = r16;
    L171:
        th = th;
        r311 = r10;
        r312 = r15;
        goto L170
    L173:
        th = th;
    L99:
        r19 = r19;
        r20 = r20;
        r114 = r217;
        r65 = r10;
        r69 = r13;
        r66 = r15;
        r67 = r16;
        r68 = r18;
        r120 = r17;
        r220 = r210;
    L175:
        th = th;
    L176:
        r19 = r19;
        r20 = r20;
        r114 = r217;
        r210 = r210;
    L177:
        r74 = r310;
        r73 = r44;
        r71 = r213;
        r72 = r43;
        r70 = r210;
        r75 = r43;
        r121 = r116;
    L178:
        th = th;
        r310 = r310;
    L180:
        th = th;
        r310 = r310;
        goto L176
    L283:
        WidgetDefinition r91 = j(r30);     // Catch: Throwable -> L113
        CreateOptions r92 = i(r215);     // Catch: Throwable -> L113
        r18 = r216;
        r214.L$0 = r18;     // Catch: Throwable -> L111
        r17 = r215;
        r214.L$1 = r17;     // Catch: Throwable -> L107
        r115 = r211;
        r214.L$2 = r115;     // Catch: Throwable -> L107
        r217 = r217;
        ?? r93 = r310;
        r214.L$3 = r93;     // Catch: Throwable -> L105
        r19 = "tag";
        r37 = r37;
        r214.L$4 = r37;     // Catch: Throwable -> L103
        r214.L$5 = r18;     // Catch: Throwable -> L103
        r20 = "MiniAppWidgetHost";
        r213 = r213;
        r214.L$6 = r213;     // Catch: Throwable -> L101
        r214.Z$0 = r112;     // Catch: Throwable -> L101
        r218 = r20;
        r214.label = 2;     // Catch: Throwable -> L101
        r14 = r42.restoreWidget(r91, r92, r214);     // Catch: Throwable -> L101
        if (r14 != r15) goto L95;
        return r15;
    L95:
        ?? r94 = r93;
        ?? r95 = r37;
        String r96 = r213;
        Object r97 = r18;
        r51 = r112;
        Object r98 = r18;
        ?? r124 = r17;
        ?? r222 = r210;
    L96:
        r53 = (HostedWidget) r14;     // Catch: Throwable -> L98
        r10 = r96;
        r13 = r97;
        r15 = r95;
        r16 = r94;
        r18 = r98;
        r17 = r124;
        r210 = r222;
    L101:
        th = th;
    L102:
        r16 = r93;
        r15 = r37;
        r10 = r213;
        r13 = r18;
    L103:
        th = th;
        r20 = "MiniAppWidgetHost";
        r213 = r213;
    L105:
        th = th;
        r19 = "tag";
        r20 = "MiniAppWidgetHost";
        r213 = r213;
        r37 = r37;
    L107:
        th = th;
        ?? r125 = r17;
    L109:
        r18 = r18;
        r17 = r125;
    L110:
        r93 = r310;
    L111:
        th = th;
        r125 = r215;
    L113:
        th = th;
        r19 = "tag";
        r20 = "MiniAppWidgetHost";
        r17 = r215;
        r18 = r216;
        r217 = r217;
    L182:
        th = th;
        r114 = r217;
    L184:
        r19 = "tag";
        r20 = "MiniAppWidgetHost";
        r116 = r215;
        r43 = r216;
    L185:
        r44 = r37;
        goto L177
    L188:
        r114 = r217;
        r19 = "tag";
        r20 = "MiniAppWidgetHost";
        r116 = r215;
        r43 = r216;
        r210 = r210;
        r213 = r213;
        r44 = r37;
    L191:
        th = th;
        goto L177
    L190:
        throw new IllegalStateException(r210);     // Catch: Throwable -> L191
    L186:
        th = th;
        r114 = r217;
        r19 = "tag";
        r20 = "MiniAppWidgetHost";
        r116 = r215;
        r43 = r216;
    L193:
        th = th;
        r19 = "tag";
        r20 = "MiniAppWidgetHost";
        r116 = r215;
        r43 = r216;
        r114 = r114;
    L195:
        th = th;
        r19 = "tag";
        r20 = "MiniAppWidgetHost";
        r116 = r215;
        r43 = r216;
        r114 = r114;
    L197:
        th = th;
    L199:
        th = th;
        ?? r126 = r215;
        l r99 = r216;
    L201:
        r43 = r99;
        r116 = r126;
    L202:
        th = th;
        r99 = r25;
        r126 = r215;
    L204:
        th = th;
        r99 = r25;
        r126 = r113;
        goto L201
    L63:
        r212 = "createWidget";
        goto L62
    L289:
        String r100 = "createOrRestoreWidget reuse restore=" + r112 + " hostId=" + r32 + " cardId=" + r34 + " instanceId=" + r33 + " appletId=" + r31.d + r20 + r31.e;     // Catch: Throwable -> L57
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");     // Catch: Throwable -> L57
        Intrinsics.checkNotNullParameter(r100, "msg");     // Catch: Throwable -> L57
        org.koin.core.a r101 = su.a.f22013b;     // Catch: Throwable -> L57
        if (r101 == null) goto L55;
        ((ju.b) r101.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r100);     // Catch: Throwable -> L57
        r83 = r37;
        r84 = r310;
        r78 = null;
        r82 = r25;
        r123 = r113;
        goto L211
    L55:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L57
    L57:
        th2 = th;
        r89 = r37;
    L223:
        th2 = th;
        r89 = r26;
    L221:
        th2 = th;
        r89 = r26;
        goto L225
    L271:
        if (r16 != 2) goto L14;
        r51 = r13.Z$0;
        String r102 = (String) r13.L$6;
        l r103 = (l) r13.L$5;
        kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) r13.L$4;
        j r105 = (j) r13.L$3;
        r115 = (Integer) r13.L$2;
        c r127 = (c) r13.L$1;
        l r106 = (l) r13.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L18
        r19 = "tag";
        r222 = "KoinApplication has not been started";
        r217 = "msg";
        r98 = r103;
        r35 = " appletId=";
        r218 = r20;
        r20 = "MiniAppWidgetHost";
        r96 = r102;
        r97 = r106;
        r95 = r104;
        r94 = r105;
        r124 = r127;
        goto L96
    L14:
        if (r16 != 3) goto L21;
        r51 = r13.Z$0;
        String r107 = (String) r13.L$6;
        l r108 = (l) r13.L$5;
        kotlinx.coroutines.sync.a r109 = (kotlinx.coroutines.sync.a) r13.L$4;
        j r128 = (j) r13.L$3;
        r115 = (Integer) r13.L$2;
        c r129 = (c) r13.L$1;
        l r130 = (l) r13.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L18
        r19 = "tag";
        r219 = "KoinApplication has not been started";
        r217 = "msg";
        r52 = r108;
        r35 = " appletId=";
        r218 = r20;
        r20 = "MiniAppWidgetHost";
        r49 = r107;
        r50 = r130;
        r48 = r109;
        r47 = r128;
        r117 = r129;
        goto L123
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        th = th;
        r70 = "KoinApplication has not been started";
        r114 = "msg";
        r20 = "MiniAppWidgetHost";
        r75 = "createOrRestoreWidget reuse restore=";
        r19 = "tag";
        r71 = r10;
        r72 = r13;
        r73 = r15;
        r74 = r16;
        r121 = r17;
        goto L296
    L30:
        ResultKt.throwOnFailure(r14);
        Integer r131 = StringsKt.toIntOrNull(r10.f20467b);
        String r132 = r10.f20467b;
        if (r131 != null) goto L38;
        String r133 = androidx.room.jarjarred.org.antlr.runtime.a.w(ai.j0.x("createOrRestoreWidget failed: instanceId must be numeric, instanceId=", r132, ", cardId="), r10.f20466a, "MiniAppWidgetHost", "tag", "msg");
        org.koin.core.a r134 = su.a.f22013b;
        if (r134 == null) goto L37;
        ((ju.b) r134.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetHost", r133);
        return null;
    L37:
        throw new IllegalStateException("KoinApplication has not been started");
    L38:
        ConcurrentHashMap r135 = r5.g;
        final MiniAppWidgetHost$acquireCreationLock$1 r136 = MiniAppWidgetHost$acquireCreationLock$1.INSTANCE;
        final int r137 = 0;
        Object r138 = r135.compute(r132, new h(r136, r137));
        if (r138 == null) goto L231;
        r16 = (j) r138;
        ?? r139 = r16.f20486a;     // Catch: Throwable -> L227
        r13.L$0 = r5;     // Catch: Throwable -> L227
        r13.L$1 = r10;     // Catch: Throwable -> L227
        r13.L$2 = r131;     // Catch: Throwable -> L227
        r13.L$3 = r16;     // Catch: Throwable -> L227
        r13.L$4 = r139;     // Catch: Throwable -> L227
        r112 = r39;
        r13.Z$0 = r112;     // Catch: Throwable -> L227
        r13.label = 1;     // Catch: Throwable -> L227
        if (r139.c(r13) != r15) goto L44;
        return r15;
    L44:
        r110 = r131;
        r113 = r10;
        r26 = r139;
        r25 = r5;
        r27 = r16;
    L227:
        th = th;
    L228:
        String r140 = r10.f20467b;
        ConcurrentHashMap r141 = r5.g;
        final Function2<String, j, j> r142 = new MiniAppWidgetHost$releaseCreationLock$1(r16);
        final int r143 = 1;
        r141.computeIfPresent(r140, new h(r142, r143));
        throw th;
    L231:
        throw new IllegalStateException("Required value was null.");
    L28:
        th = th;
        r10 = " appletId=";
    L98:
        th = th;
    L7:
        r13 = new MiniAppWidgetHost$createOrRestoreWidget$1(r5, r40);
        goto L8
    }

    public final boolean d(String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r16, "instanceId");
        this.f20495i.remove(r16);
        Integer r5 = StringsKt.toIntOrNull(r16);
        String r11 = this.f20491a;
        if (r5 != null) goto L10;
        String r10 = androidx.constraintlayout.motion.widget.a.t(androidx.constraintlayout.motion.widget.a.y("destroyWidget skipped: widget not active and instanceId is not numeric hostId=", r11, " instanceId=", r16, " appletId="), r17, " widgetId=", r18);
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L9;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("MiniAppWidgetHost", r10);
        return false;
    L9:
        throw new IllegalStateException("KoinApplication has not been started");
    L10:
        ju.a r13 = ju.a.f18481a;
        r13.w("MiniAppWidgetHost", androidx.constraintlayout.motion.widget.a.t(androidx.constraintlayout.motion.widget.a.y("destroyWidget inactive cleanup hostId=", r11, " instanceId=", r16, " appletId="), r17, " widgetId=", r18));
        MiniAppWidgetHost$destroyWidget$1 r14 = new MiniAppWidgetHost$destroyWidget$1(this, r5, r17, r18, null);
        b.a(this.f20499m, r14);
        a r15 = (a) this.f.remove(r16);
        if (r15 == null) goto L14;
        StringBuilder r19 = androidx.constraintlayout.motion.widget.a.y("destroyWidget hostId=", r11, " instanceId=", r16, " cardId=");
        r19.append(r15.f20458c);
        r19.append(" appletId=");
        r19.append(r15.d);
        r19.append(" widgetId=");
        r19.append(r15.e);
        r13.i("MiniAppWidgetHost", r19.toString());
        return r15.a();
    L14:
        return true;
    }

    public final WidgetHost e() {
        String r5 = this.f20491a;
        WidgetHost r10 = WidgetHostRuntime.getHost(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return WidgetHostRuntime.createHost(r5, this.e, this.f20501o);
    }

    public final void f() {
        String r5 = this.f20491a;
        e();     // Catch: Throwable -> L8
        String r10 = "initHost success hostId=" + r5;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r10, "msg");     // Catch: Throwable -> L8
        org.koin.core.a r11 = su.a.f22013b;     // Catch: Throwable -> L8
        if (r11 == null) goto L7;
        ((ju.b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r10);     // Catch: Throwable -> L8
        return;
    L7:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        String r12 = "initHost failed hostId=" + r5;
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L14;
        ((ju.b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetHost", r12, th);
        return;
    L14:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final Object g(ContinuationImpl r10) {
        if ((r10 instanceof MiniAppWidgetHost$refreshWidgetCatalog$1) == false) goto L7;
        MiniAppWidgetHost$refreshWidgetCatalog$1 r5 = (MiniAppWidgetHost$refreshWidgetCatalog$1) r10;
        int r11 = r5.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.label;
        if (r14 == 0) goto L18;
        if (r14 != 1) goto L17;
        l r15 = (l) r5.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L22:
        boolean r16 = ((Boolean) r12).booleanValue();     // Catch: Throwable -> L14
    L28:
        return Boxing.boxBoolean(r16);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        z r17 = Dispatchers.getIO();     // Catch: Throwable -> L14
        MiniAppWidgetHost$refreshWidgetCatalog$2 r18 = new MiniAppWidgetHost$refreshWidgetCatalog$2(this, null);     // Catch: Throwable -> L14
        r5.L$0 = this;     // Catch: Throwable -> L14
        r5.label = 1;     // Catch: Throwable -> L14
        r12 = BuildersKt.withContext(r17, r18, r5);     // Catch: Throwable -> L14
        if (r12 != r13) goto L22;
        return r13;
    L14:
        th = move-exception;
        String r19 = "refreshWidgetCatalog failed hostId=" + this.f20491a;
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r19, "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r20 = su.a.f22013b;
        if (r20 == null) goto L30;
        ((ju.b) r20.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetHost", r19, th);
        r16 = false;
        goto L28
    L30:
        throw new IllegalStateException("KoinApplication has not been started");
    L7:
        r5 = new MiniAppWidgetHost$refreshWidgetCatalog$1(this, r10);
        goto L8
    }

    public final void h() {
        String r5 = this.f20491a;
        List r10 = CollectionsKt.toList(this.f.values());     // Catch: Throwable -> L15
        String r11 = "registerAllMessengers hostId=" + r5 + " activeCount=" + r10.size();     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r11, "msg");     // Catch: Throwable -> L15
        org.koin.core.a r12 = su.a.f22013b;     // Catch: Throwable -> L15
        if (r12 == null) goto L19;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r11);     // Catch: Throwable -> L15
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L15
    L7:
        if (r13.hasNext() == false) goto L34;
        a r14 = (a) r13.next();     // Catch: Throwable -> L15
        Integer r15 = StringsKt.toIntOrNull(r14.f20457b);     // Catch: Throwable -> L15
        if (r15 == null) goto L10;
        b.a(this.f20499m, new MiniAppWidgetHost$registerAllMessengers$1$1$1(this, r14, r15, null));     // Catch: Throwable -> L15
        goto L7
    L10:
        String r16 = "registerWidgetMessenger skipped: instanceId is not numeric hostId=" + r5 + " instanceId=" + r14.f20457b + " appletId=" + r14.d + " widgetId=" + r14.e;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r16, "msg");     // Catch: Throwable -> L15
        org.koin.core.a r17 = su.a.f22013b;     // Catch: Throwable -> L15
        if (r17 == null) goto L14;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("MiniAppWidgetHost", r16);     // Catch: Throwable -> L15
        goto L7
    L14:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L15
    L34:
        return;
    L19:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        String r18 = "registerAllMessengers failed hostId=" + r5;
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r18, "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r19 = su.a.f22013b;
        if (r19 == null) goto L25;
        ((ju.b) r19.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetHost", r18, th);
        return;
    L25:
        throw new IllegalStateException("KoinApplication has not been started");
    }
}
