package com.obric.aee;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.aee.impl.EngineBridge;
import com.obric.aee.impl.EngineConfig;
import com.obric.aee.impl.HostExtension;
import com.obric.aee.impl.InvokeUtils;
import com.obric.aee.utils.d;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002>?B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0019\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010#\u001a\u00020\u0004J.\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00012\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007J(\u0010+\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00042\u0018\u0010%\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010-\u0012\u0004\u0012\u00020\u00010,JP\u0010+\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2(\u0010%\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010/\u0012\u0006\u0012\u0004\u0018\u00010\u00010.ø\u0001\u0000¢\u0006\u0002\u00100J\u0011\u00101\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J5\u00102\u001a\u0002032\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0002\u00107JO\u00108\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u00104\u001a\u0002032\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0.2\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0002\u00109J0\u0010:\u001a\b\u0012\u0004\u0012\u0002030;2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u000203J\u0019\u0010<\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0019\u0010=\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Lcom/obric/aee/ExecutionEngine;", "", "()V", "TAG", "", "_cfg", "Lcom/obric/aee/impl/EngineConfig;", "dumpNativeThreads", "", "dumpThreadSync", "enableCheckSo", "", "enable", "", "getAliveServices", "Lcom/obric/aee/res/PackageInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMemoryAllocationInfo", "Lcom/obric/aee/ExecutionEngine$MemoryAllocationInfo;", "domain", "", "getMemoryAllocationSnapshot", "Lcom/obric/aee/ExecutionEngine$MemoryAllocationSnapshot;", CommonConsts.APM_INNER_EVENT_COST_INIT, "callback", "Lcom/obric/aee/EngineCallback;", "(Lcom/obric/aee/EngineCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initRes", "isServiceAlive", "pack", "(Lcom/obric/aee/res/PackageInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseLogLevel", EventBody.KEY_VALUE, "registerInstanceMethod", "inst", "prefix", "registerKMethod", "method", "key", "runIn", "Lcom/obric/aee/utils/AsyncContext;", LocationMonitorConst.TIMEOUT, "", "registerMethod", "Lkotlin/Function1;", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Lcom/obric/aee/utils/AsyncContext;JLkotlin/jvm/functions/Function2;)V", "requestGc", "runPackage", "Landroid/os/Bundle;", "args", "event", "context", "(Lcom/obric/aee/res/PackageInfo;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runPackageStreaming", "(Lcom/obric/aee/res/PackageInfo;Landroid/os/Bundle;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runPackageStreamingAsFlow", "Lkotlinx/coroutines/flow/Flow;", "startService", "stopService", "MemoryAllocationInfo", "MemoryAllocationSnapshot", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile EngineConfig f5870b;
    private static String c;

    static {
        f5869a = new b();
        c = "ExecutionEngine";
    }

    private b() {
    }

    private final int a(String r3) {
        if (r3 == null) goto L6;
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r2 == null) goto L6;
        String r4 = r2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
    L8:
        if (r4 != null) goto L10;
        return 4;
    L10:
        switch(r4.hashCode()) {
            case -1408208058: goto L69;
            case -902327211: goto L65;
            case 0: goto L62;
            case 97: goto L59;
            case 100: goto L55;
            case 101: goto L51;
            case 105: goto L48;
            case 118: goto L44;
            case 119: goto L40;
            case 109935: goto L37;
            case 3237038: goto L34;
            case 3387192: goto L31;
            case 3641990: goto L28;
            case 95458899: goto L25;
            case 96784904: goto L22;
            case 97203460: goto L19;
            case 351107458: goto L16;
            case 1124446108: goto L13;
            default: goto L72;
        };
    L72:
        Integer r5 = StringsKt.toIntOrNull(r3);
        if (r5 != null) goto L75;
        return 4;
    L75:
        return r5.intValue();
    L13:
        if (r4.equals("warning") == false) goto L72;
    L42:
        return 5;
    L16:
        if (r4.equals("verbose") == false) goto L72;
    L46:
        return 2;
    L19:
        if (r4.equals("fatal") == false) goto L72;
    L71:
        return 7;
    L22:
        if (r4.equals("error") == false) goto L72;
    L53:
        return 6;
    L25:
        if (r4.equals("debug") == false) goto L72;
    L57:
        return 3;
    L28:
        if (r4.equals("warn") == true) goto L42;
    L31:
        if (r4.equals("none") == false) goto L72;
    L67:
        return Integer.MAX_VALUE;
    L34:
        if (r4.equals("info") == false) goto L72;
        return 4;
    L37:
        if (r4.equals(f.g) == true) goto L67;
    L40:
        if (r4.equals("w") == true) goto L42;
    L44:
        if (r4.equals(BaseSwitches.V) == true) goto L46;
    L48:
        if (r4.equals("i") == false) goto L72;
        return 4;
    L51:
        if (r4.equals("e") == true) goto L53;
    L55:
        if (r4.equals("d") == true) goto L57;
    L59:
        if (r4.equals("a") == true) goto L71;
    L62:
        if (r4.equals("") == false) goto L72;
        return 4;
    L65:
        if (r4.equals(NotificationCompat.GROUP_KEY_SILENT) == true) goto L67;
    L69:
        if (r4.equals("assert") == true) goto L71;
    L6:
        r4 = null;
        goto L8
    }

    public static final /* synthetic */ String b() {
        return c;
    }

    public final Object a(a r18, Continuation<? super Unit> r19) {
        b r1 = this;
        final a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r18, a.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, ExecutionEngine$init$1.class) == false) goto L7;
        ExecutionEngine$init$1 r2 = (ExecutionEngine$init$1) ZeusTransformUtils.preCheckCast(r0, ExecutionEngine$init$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        ExecutionEngine$init$1 r3 = r2;
        Object r4 = r3.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        File r6 = (File) ZeusTransformUtils.preCheckCast(r3.L$2, File.class, "com.obric.memorydata.plugin");
        EngineConfig r7 = (EngineConfig) ZeusTransformUtils.preCheckCast(r3.L$1, EngineConfig.class, "com.obric.memorydata.plugin");
        b r8 = (b) ZeusTransformUtils.preCheckCast(r3.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L14
    L53:
        return Unit.INSTANCE;
    L14:
        th = th;
        final File r15 = r6;
        r1 = r8;
    L56:
        monitor-enter(r1);
    L64:
        th = move-exception;
        throw th;
    L58:
        if (f5870b != r7) goto L60;
        f5870b = null;     // Catch: Throwable -> L64
    L60:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L64
        monitor-exit(r1);
        com.obric.aee.utils.b.f5897a.a(r7, r15, th);
        throw new KotlinNothingValueException();
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r4);
        monitor-enter(this);
    L69:
        th = move-exception;
        throw th;
    L21:
        if (f5870b != null) goto L68;
        f5870b = new EngineConfig(r10, (Function2) ZeusTransformUtils.preCheckCast(new ExecutionEngine$init$2$1(EngineBridge.INSTANCE), Function2.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L69
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L69
        monitor-exit(this);
        final long r13 = System.currentTimeMillis();
        final EngineConfig r14 = f5870b;
        if (r14 == null) goto L27;
        final Map r16 = MapsKt.toMutableMap(r14.getGlobalConfig());
        if (r16.get("tracing_memory") == null) goto L31;
        boolean r17 = true;
    L32:
        String r20 = (String) ZeusTransformUtils.preCheckCast(r16.get("disable_log_dispatcher"), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r20, "1") == true) goto L42;
        if (r20 != null) goto L36;
    L38:
        boolean r21 = false;
    L39:
        if (r21 == true) goto L42;
        final boolean r22 = false;
    L43:
        final int r23 = r1.a((String) ZeusTransformUtils.preCheckCast(r16.get("log_level"), String.class, "com.obric.memorydata.plugin"));
        r16.putIfAbsent("log_level", String.valueOf(r23));
        r14.setLogDispatcherEnabled(!r22);
        r14.setMinLogPriority(r23);
        r15 = new File(r10.a(), "APHOME");
        HostExtension r24 = HostExtension.INSTANCE;     // Catch: Throwable -> L54
        if (r17 == false) goto L47;
        boolean r110 = true;
    L48:
        final boolean r25 = r110;
        Function0 r26 = (Function0) ZeusTransformUtils.preCheckCast(new ExecutionEngine$init$3(r14, r22, r23, r13, r15, r25, r10, r16), Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        r3.L$0 = r1;     // Catch: Throwable -> L54
        r3.L$1 = r14;     // Catch: Throwable -> L54
        r3.L$2 = r15;     // Catch: Throwable -> L54
        r3.label = 1;     // Catch: Throwable -> L54
        if (r24.a(r26, r3) != r12) goto L53;
        return r12;
    L47:
        r110 = false;
    L54:
        th = th;
        r7 = r14;
        goto L56
    L36:
        if (StringsKt.equals(r20, "true", true) != true) goto L38;
        r21 = true;
    L42:
        r22 = true;
        goto L43
    L31:
        r17 = false;
        goto L32
    L27:
        return Unit.INSTANCE;
    L68:
        throw new IllegalStateException("Engine has been initialized.");     // Catch: Throwable -> L69
    L7:
        r2 = new ExecutionEngine$init$1(r1, r0);
        goto L8
    }

    public final Object a(com.obric.aee.res.b r8, Bundle r9, String r10, Bundle r11, Continuation<? super Bundle> r12) {
        Continuation<? super Bundle> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), '_', false, 2, null) == true) goto L7;
        return EngineBridge.INSTANCE.runPackage(r8, r9, r10, r11, r6);
    L7:
        throw new IllegalArgumentException("event start with _ is reserved.");
    }

    public final Object a(com.obric.aee.res.b r9, Bundle r10, Function2<? super Bundle, ? super Boolean, Unit> r11, String r12, Bundle r13, Continuation<? super Unit> r14) {
        Function2<? super Bundle, ? super Boolean, Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), '_', false, 2, null) == true) goto L10;
        Object r8 = EngineBridge.INSTANCE.runPackageSteaming(r9, r10, r12, r13, r6, r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r8;
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalArgumentException("event start with _ is reserved.");
    }

    public final List<String> a() {
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(Thread.getAllStackTraces().entrySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L5:
        if (r8.hasNext() == false) goto L9;
        Object r2 = r8.next();
        Thread r4 = (Thread) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Thread.class, "com.obric.memorydata.plugin");
        d r5 = d.f5900a;
        Intrinsics.checkNotNullExpressionValue(r4, "thread");
        if (r5.a(r4) == false) goto L5;
        r0.add(r2);
        goto L5
    L9:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{(Function1) ZeusTransformUtils.preCheckCast(ExecutionEngine$dumpNativeThreads$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(ExecutionEngine$dumpNativeThreads$3.INSTANCE, Function1.class, "com.obric.memorydata.plugin")})), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Thread r6 = (Thread) ZeusTransformUtils.preCheckCast(r3.getKey(), Thread.class, "com.obric.memorydata.plugin");
        StackTraceElement[] r11 = (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r3.getValue(), StackTraceElement[].class, "com.obric.memorydata.plugin");
        d r12 = d.f5900a;
        Intrinsics.checkNotNullExpressionValue(r6, "thread");
        Intrinsics.checkNotNullExpressionValue(r11, "stackTrace");
        r1.add(r12.a(r6, r11));
        goto L11
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L18:
        return CollectionsKt.emptyList();
    L16:
        return CollectionsKt.emptyList();
    }

    public final void a(a r7) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "callback");
        File r8 = new File(r6.a(), "APHOME");
        EngineConfig r1 = new EngineConfig(r6, (Function2) ZeusTransformUtils.preCheckCast(ExecutionEngine$initRes$cfg$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
        r1.logI(c, "Engine=> init Res in single step.");
        int r9 = 0;
    L4:
        if (r9 >= 2) goto L17;
        com.obric.aee.utils.b.f5897a.a(r1, r8);     // Catch: Throwable -> L9
        if (r9 <= 0) goto L8;
        r1.logI(c, "Engine=> init Res retry succeeded on attempt " + (r9 + 1) + '.');     // Catch: Throwable -> L9
        return;
    L8:
        return;
    L9:
        th = move-exception;
        if (r9 != 0) goto L15;
        com.obric.pap.base.b.f14920a.a(r8, (com.obric.pap.base.a) ZeusTransformUtils.preCheckCast(r1, com.obric.pap.base.a.class, "com.obric.memorydata.plugin"));
        String r3 = c;
        StringBuilder r4 = new StringBuilder().append("Engine=> init Res failed on attempt 1, retry once: ");
        String r5 = th.getMessage();
        if (r5 != null) goto L14;
        r5 = th.getClass().getSimpleName();
    L14:
        r1.logW(r3, r4.append(r5).toString());
        r9 = r9 + 1;
        goto L4
    L15:
        com.obric.aee.utils.b.f5897a.a(r1, r8, th);
        throw new KotlinNothingValueException();
    }

    public final void a(Object r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "inst");
        Intrinsics.checkNotNullParameter(r15, "prefix");
        Method[] r13 = r14.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r13, "inst::class.java.declaredMethods");
        Object[] r16 = (Object[]) ZeusTransformUtils.preCheckCast(r13, Object[].class, "com.obric.memorydata.plugin");
        int r0 = r16.length;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L37;
        Method r7 = (Method) ZeusTransformUtils.preCheckCast(r16[r3], Method.class, "com.obric.memorydata.plugin");
        Annotation[] r4 = r7.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(r4, "method.annotations");
        Object[] r5 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r8 = r5.length;
        int r9 = 0;
    L5:
        if (r9 >= r8) goto L10;
        Object r10 = r5[r9];
        if (ZeusTransformUtils.instanceOf(r10, com.obric.aee.utils.a.class) == false) goto L9;
        r6.add(r10);
    L9:
        r9 = r9 + 1;
        goto L5
    L10:
        com.obric.aee.utils.a r11 = (com.obric.aee.utils.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin")), com.obric.aee.utils.a.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L36;
        boolean r12 = true;
        r7.setAccessible(true);
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r17.length() != 0) goto L15;
        boolean r18 = true;
    L16:
        if (r18 == false) goto L18;
        r17 = r7.getName();
    L18:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L21;
        boolean r20 = true;
    L22:
        if (r20 == false) goto L24;
        r19 = r15 + '.' + r19;
    L24:
        Parameter[] r21 = r7.getParameters();
        Intrinsics.checkNotNullExpressionValue(r21, "method.parameters");
        if (((Object[]) ZeusTransformUtils.preCheckCast(r21, Object[].class, "com.obric.memorydata.plugin")).length == 0) goto L29;
        r12 = false;
    L29:
        if (r12 == true) goto L34;
        Parameter[] r22 = r7.getParameters();
        Intrinsics.checkNotNullExpressionValue(r22, "method.parameters");
        if (Intrinsics.areEqual(((Parameter) ZeusTransformUtils.preCheckCast(ArraysKt.last((Object[]) ZeusTransformUtils.preCheckCast(r22, Object[].class, "com.obric.memorydata.plugin")), Parameter.class, "com.obric.memorydata.plugin")).getType(), Continuation.class) == false) goto L34;
        InvokeUtils r23 = InvokeUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r19, "key");
        Intrinsics.checkNotNullExpressionValue(r7, "method");
        CoroutineContext r24 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r11.b().asDispatcher(), CoroutineContext.class, "com.obric.memorydata.plugin");
    L35:
        r23.a(r19, r7, r14, r24, r11.c(), true);
    L34:
        r23 = InvokeUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r19, "key");
        Intrinsics.checkNotNullExpressionValue(r7, "method");
        r24 = null;
        goto L35
    L21:
        r20 = false;
        goto L22
    L15:
        r18 = false;
    L36:
        r3 = r3 + 1;
        goto L3
    }

    public final Object startService(com.obric.aee.res.b r7, Continuation<? super Unit> r8) {
        Continuation<? super Bundle> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        Object r6 = EngineBridge.INSTANCE.runPackage(r7, new Bundle(), "_INIT", new Bundle(), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final Object stopService(com.obric.aee.res.b r2, Continuation<? super Unit> r3) {
        Continuation<? super Unit> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        Object r4 = EngineBridge.INSTANCE.stopService(r2, r1);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }
}
