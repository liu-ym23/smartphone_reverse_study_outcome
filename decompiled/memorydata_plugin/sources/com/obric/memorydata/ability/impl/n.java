package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.DeadObjectException;
import android.os.TransactionTooLargeException;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.ability.data.PackageEventStandardData;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u001e\u0010\u001e\u001a\u00020\u001b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u001c\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u000e\u0010%\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u00150\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/memorydata/ability/impl/PackageEventAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "isInitPackageListDone", "Ljava/util/concurrent/atomic/AtomicBoolean;", "installedPackages", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/ability/data/PackageEventStandardData;", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "subscriberCount", "", "packageEventScope", "Lkotlinx/coroutines/CoroutineScope;", "initInstalledPackagesJob", "Lkotlinx/coroutines/Job;", "key2Mode", "mode2keys", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "modeList", "", "isPackageMonitorStarted", "onCreate", "", "iAbilityContext", "onDestroy", "publishToMode", "packageEventStandardData", "onReceive", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "initInstalledPackageList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRetryablePackageManagerException", "throwable", "", "startMonitorPackage", "stopMonitorPackage", "onSubscribe", "key", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8402a = null;
    private static final long[] l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f8403b;
    private ConcurrentHashMap<String, PackageEventStandardData> c;
    private com.obric.memorydata.ability.j d;
    private int e;
    private final al f;
    private bx g;
    private final ConcurrentHashMap<String, String> h;
    private final ConcurrentHashMap<String, ConcurrentHashMap.KeySetView<String, Boolean>> i;
    private final List<String> j;
    private boolean k;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/ability/impl/PackageEventAbility$Companion;", "", "<init>", "()V", "TAG", "", "MODE_KEY", "MODE_ADD_PACKAGE", "MODE_REMOVE_PACKAGE", "MODE_UPDATE_PACKAGE", "MODE_ALL_EVENT", "INIT_PACKAGE_LIST_RETRY_DELAYS_MS", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.a r3) {
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r2, Throwable r3) {
            CoroutineContext r1 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.error("PackageEventAbility", "Package event coroutine failed.", r3);
        }
    }

    static {
        f8402a = new a(null);
        l = new long[]{200, 500, 1000};
    }

    public n() {
        this.f8403b = new AtomicBoolean(false);
        this.c = new ConcurrentHashMap();
        this.f = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new b(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin"), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = CollectionsKt.listOf(new String[]{"add", "remove", BuildConfig.CHANNEL, LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL});
    }

    public static final /* synthetic */ Object a(n r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x016c -> B:38:0x016f). Please report as a decompilation issue!!! */
    private final Object a(Continuation<? super Unit> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, PackageEventAbility$initInstalledPackageList$1.class) == false) goto L7;
        PackageEventAbility$initInstalledPackageList$1 r0 = (PackageEventAbility$initInstalledPackageList$1) ZeusTransformUtils.preCheckCast(r15, PackageEventAbility$initInstalledPackageList$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r13 = r0.I$1;
        int r4 = r0.I$0;
        n r6 = (n) ZeusTransformUtils.preCheckCast(r0.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
        n r17 = r6;
    L38:
        r13 = r13 + 1;
    L19:
        if (r13 >= r4) goto L41;
        List<PackageInfo> r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getInstalledPackages(0);     // Catch: Exception -> L28
        Intrinsics.checkNotNullExpressionValue(r7, "getInstalledPackages(...)");     // Catch: Exception -> L28
        HashMap r8 = new HashMap(r7.size());     // Catch: Exception -> L28
        Iterator<PackageInfo> r9 = r7.iterator();     // Catch: Exception -> L28
    L22:
        if (r9.hasNext() == false) goto L26;
        PackageInfo r10 = (PackageInfo) ZeusTransformUtils.preCheckCast(r9.next(), PackageInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
        if (r10 == null) goto L22;
        ((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin")).put(r10.packageName, PackageEventStandardData.f8316a.a(r10));     // Catch: Exception -> L28
        goto L22
    L26:
        ca.a(r0.getContext());     // Catch: Exception -> L28
        r17.c.clear();     // Catch: Exception -> L28
        r17.c.putAll((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L28
        r17.f8403b.set(true);     // Catch: Exception -> L28
        return Unit.INSTANCE;
    L28:
        e = move-exception;
        if (r17.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")) == true) goto L32;
        throw e;
    L32:
        if (r13 != (r4 - 1)) goto L35;
        RunLog.INSTANCE.error("PackageEventAbility", "initInstalledPackageList failed after " + r4 + " attempts.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L35:
        long r11 = l[r13];
        RunLog.INSTANCE.warn("PackageEventAbility", "initInstalledPackageList binder failure, attempt=" + (r13 + 1) + '/' + r4 + ", retry in " + r11 + "ms.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r0.L$0 = r17;
        r0.I$0 = r4;
        r0.I$1 = r13;
        r0.label = 1;
        if (au.a(r11, r0) != r2) goto L38;
        return r2;
    L41:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        if (this.f8403b.get() == true) goto L17;
        r4 = l.length + 1;
        r17 = this;
        r13 = 0;
        goto L19
    L17:
        return Unit.INSTANCE;
    L7:
        r0 = new PackageEventAbility$initInstalledPackageList$1(this, r15);
        goto L8
    }

    private static final void a(Intent r9, n r10) {
        String r0 = r9.getAction();
        Uri r1 = r9.getData();
        Intrinsics.checkNotNull(r1);
        String r2 = r1.getSchemeSpecificPart();
        com.obric.memorydata.utils.c r3 = com.obric.memorydata.utils.c.f13193a;
        Intrinsics.checkNotNull(r2);
        r3.b(r2);
        if (r0 == null) goto L51;
        int r4 = r0.hashCode();
        if (r4 == 525384130) goto L38;
        if (r4 == 1544582882) goto L15;
        if (r4 == 1580442797) goto L12;
        return;
    L12:
        if (r0.equals("android.intent.action.PACKAGE_FULLY_REMOVED") == true) goto L41;
        return;
    L41:
        if (r9.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L43;
        return;
    L43:
        PackageEventStandardData r11 = (PackageEventStandardData) ZeusTransformUtils.preCheckCast(r10.c.get(r2), PackageEventStandardData.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L47;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PackageEventAbility", "onReceive " + r0 + " installedPackages don't contain packageName(" + r2 + ").", null, 4, null);
        return;
    L47:
        RunLog.INSTANCE.debug("PackageEventAbility", "Package remove event -- package name:" + r2);
        r11.a(PackageEventStandardData.Type.REMOVE);
        r10.a(CollectionsKt.listOf(new String[]{"remove", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL}), r11);
        r10.c.remove(r2);
        return;
    L15:
        if (r0.equals("android.intent.action.PACKAGE_ADDED") == false) goto L55;
        PackageManager r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        if (r5 != null) goto L49;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PackageEventAbility", "AppContext.getContext().packageManager is null.", null, 4, null);
        return;
    L49:
        PackageInfo r6 = r5.getPackageInfo(r2, 128);     // Catch: PackageManager.NameNotFoundException -> L34
        if (r6 != null) goto L26;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PackageEventAbility", "ACTION_PACKAGE_ADDED packageInfo is null.", null, 4, null);
        return;
    L26:
        PackageEventStandardData r7 = PackageEventStandardData.f8316a.a(r6);
        if (r7.a() == true) goto L30;
        ((Map) ZeusTransformUtils.preCheckCast(r10.c, Map.class, "com.obric.memorydata.plugin")).put(r2, r7);
    L30:
        if (r9.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L32;
        RunLog.INSTANCE.debug("PackageEventAbility", "Package update event -- package name:" + r2);
        r7.a(PackageEventStandardData.Type.UPDATE);
        List<String> r12 = CollectionsKt.listOf(new String[]{BuildConfig.CHANNEL, LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL});
    L33:
        r10.a(r12, r7);
        return;
    L32:
        RunLog.INSTANCE.debug("PackageEventAbility", "Package add event -- package name:" + r2);
        r7.a(PackageEventStandardData.Type.ADD);
        r12 = CollectionsKt.listOf(new String[]{"add", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL});
    L34:
        e = move-exception;
        RunLog.INSTANCE.error("PackageEventAbility", "getPackageInfo error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L55:
        return;
    L38:
        if (r0.equals("android.intent.action.PACKAGE_REMOVED") == true) goto L41;
        return;
    }

    private final void a(List<String> r6, PackageEventStandardData r7) {
        Iterator r8 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap.KeySetView r1 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.i.get(r0), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        Iterator r2 = r1.iterator();
        Intrinsics.checkNotNullExpressionValue(r2, "iterator(...)");
    L9:
        if (r2.hasNext() == false) goto L4;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.ability.j r4 = this.d;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r3);
        r4.a(r3, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L9
    }

    private final boolean a(Throwable r1) {
    L2:
        if (r1 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r1, BadParcelableException.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r1, DeadObjectException.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(r1, TransactionTooLargeException.class) == true) goto L23;
        Throwable r0 = r1.getCause();
        if (r0 == r1) goto L24;
        r1 = r0;
        goto L2
    L24:
        return false;
    L23:
        return true;
    L22:
        return true;
    L13:
        return true;
    L15:
        return false;
    }

    private final void b() {
        if (this.k == false) goto L5;
        return;
    L5:
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.PACKAGE_ADDED");
        r0.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        r0.addAction("android.intent.action.PACKAGE_REMOVED");
        r0.addDataScheme("package");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
        this.k = true;
    }

    private final void c() {
        if (this.k == true) goto L5;
        return;
    L5:
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.k = false;
    }

    public static /* synthetic */ void lambda$xB6gfQYCQ3ZbB5o6rlsdJ99yX2Q(Intent r0, n r1) {
        a(r0, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        bx r0 = this.g;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.g = null;
        ca.b(this.f.getCoroutineContext(), null, 1, null);
        this.d = null;
        this.f8403b.set(false);
        this.c.clear();
        this.h.clear();
        Iterator<String> r1 = this.j.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap.KeySetView r3 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.i.get(r2), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        r3.clear();
        goto L7
    L11:
        this.i.clear();
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r5) {
        com.obric.memorydata.ability.j r6 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "iAbilityContext");
        this.d = r6;
        Iterator<String> r7 = this.j.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin")).put(r0, ConcurrentHashMap.newKeySet());
        goto L4
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r11, com.obric.memorydata.ability.f r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, TrackerImpl.PARAMS);
        Object r13 = r12.b().getOrDefault("mode", "");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r6 = null;
        int r7 = 4;
        Object r8 = null;
        String r4 = "PackageEventAbility";
        String r5 = "onSubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r3, r4, r5, r6, r7, r8);
        return false;
    L11:
        if (this.h.containsKey(r11) == false) goto L14;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "PackageEventAbility";
        r5 = "onSubscribe: this key has not unsubscribe.";
        goto L8
    L14:
        if (this.j.contains(r14) == true) goto L16;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "PackageEventAbility";
        r5 = "onSubscribe: mode error.";
        goto L8
    L16:
        ((Map) ZeusTransformUtils.preCheckCast(this.h, Map.class, "com.obric.memorydata.plugin")).put(r11, r14);
        ConcurrentHashMap.KeySetView<String, Boolean> r15 = this.i.get(r14);
        Intrinsics.checkNotNull(r15);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r15, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).add(r11);
        int r16 = this.e + 1;
        this.e = r16;
        if (r16 != 1) goto L22;
        b();
        bx r17 = this.g;
        if (r17 == null) goto L21;
        bx.a.a(r17, null, 1, null);
    L21:
        this.g = kotlinx.coroutines.i.a(this.f, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PackageEventAbility$onSubscribe$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L22:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r11, com.obric.memorydata.ability.f r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, TrackerImpl.PARAMS);
        Object r13 = r12.b().getOrDefault("mode", "");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r7 = null;
        int r8 = 4;
        Object r9 = null;
        String r5 = "PackageEventAbility";
        String r6 = "onUnsubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r4, r5, r6, r7, r8, r9);
        return false;
    L11:
        if (this.h.containsKey(r11) == true) goto L14;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "PackageEventAbility";
        r6 = "onUnsubscribe: this key has not subscribe";
        goto L8
    L14:
        if (this.j.contains(r14) == true) goto L16;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "PackageEventAbility";
        r6 = "onUnsubscribe: mode error.";
        goto L8
    L16:
        this.h.remove(r11);
        ConcurrentHashMap.KeySetView<String, Boolean> r15 = this.i.get(r14);
        Intrinsics.checkNotNull(r15);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r15, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).remove(r11);
        int r16 = this.e - 1;
        this.e = r16;
        if (r16 != 0) goto L22;
        bx r17 = this.g;
        if (r17 == null) goto L21;
        bx.a.a(r17, null, 1, null);
    L21:
        this.g = null;
        c();
        this.f8403b.set(false);
        this.c.clear();
    L22:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r1, com.obric.memorydata.ability.f r2) {
        return i.a.a(this, r1, r2);
    }

    public void onReceive(Context r7, final Intent r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PackageEventAbility", "onReceive intent == null || intent.data == null || intent.data!!.schemeSpecificPart == null", null, 4, null);
        return;
    L5:
        if (r8.getData() == null) goto L11;
        Uri r10 = r8.getData();
        Intrinsics.checkNotNull(r10);
        if (r10.getSchemeSpecificPart() == null) goto L11;
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$n$xB6gfQYCQ3ZbB5o6rlsdJ99yX2Q(r8, this));
    }
}
