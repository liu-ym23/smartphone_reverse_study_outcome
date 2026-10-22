package com.bytedance.applog.params;

import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.log.q;
import com.bytedance.applog.params.lifecycle.LifecycleValueObserver;
import com.bytedance.applog.priority.PriorityWrapper;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000*\u0001\r\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0017J\u0019\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0082 J#\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082 J!\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082 J)\u0010!\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0082 J!\u0010$\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010%\u001a\u00020 H\u0082 J!\u0010&\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0082 J\u0011\u0010(\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0004H\u0082 J!\u0010)\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0082 J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/applog/params/CommonParamsWrapper;", "Lcom/bytedance/applog/params/CommonParamsApi;", "Lcom/bytedance/applog/params/CommonParamsHelper;", "applogHashCode", "", "(Ljava/lang/String;)V", "bizCommonParamsApiMap", "Ljava/util/HashMap;", "Lcom/bytedance/applog/params/BizCommonParamsApi;", "Lkotlin/collections/HashMap;", "empty", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lazySoLoader", "com/bytedance/applog/params/CommonParamsWrapper$lazySoLoader$1", "Lcom/bytedance/applog/params/CommonParamsWrapper$lazySoLoader$1;", "loggerTag", "", "valueLifecycleObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/applog/params/lifecycle/LifecycleValueObserver;", "destroy", "", "getBiz", "biz", "handleEvent", "event", "paramsJsonString", "nativeBizClear", "istHashCode", "nativeBizGet", "key", "nativeBizRemove", "", "nativeBizSet", "keyValueJsonString", "contextJsonString", "nativeBizSetCacheCapability", "capability", "nativeHandleEvent", TrackerImpl.PARAMS, "nativeInit", "nativeSetRuleConfig", "configJson", "setLogEnable", "enabled", "", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonParamsWrapper implements com.bytedance.applog.params.b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f1763b;
    private final AtomicBoolean c;
    private final HashMap<String, com.bytedance.applog.params.a> d;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, LifecycleValueObserver>> e;
    private final b f;

    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J,\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\tH\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J4\u0010\u0018\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"com/bytedance/applog/params/CommonParamsWrapper$getBiz$1$1", "Lcom/bytedance/applog/params/BizCommonParamsApi;", "lifecycleEnabled", "", "clear", "", "get", "", "key", "", "invokeNativeSetRuleConfig", "configJsonString", "remove", "set", EventBody.KEY_VALUE, "context", "", "setCacheCapability", "capability", "", "setLifecycleEnable", "enable", "setRuleConfig", "configJsonArray", "setWithLifecycle", "valueLifecycle", "Landroidx/lifecycle/LifecycleOwner;", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.bytedance.applog.params.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonParamsWrapper f1764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1765b;

        public static final /* synthetic */ void a(a r0, String r1) {
            r0.b(r1);
        }

        private final void b(String r7) {
            CommonParamsWrapper.a(this.f1764a).c(new Object[0]);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            q.a().d(CommonParamsWrapper.d(this.f1764a), "biz:{} setRuleConfig json empty!", new Object[]{this.f1765b});
            return;
        L10:
            if (StringsKt.startsWith$default(r7, "[", false, 2, null) == true) goto L12;
        L16:
            q.a().d(CommonParamsWrapper.d(this.f1764a), "biz:{} setRuleConfig json: {} is invalid (not a json array)!", new Object[]{this.f1765b, r7});
            return;
        L12:
            if (StringsKt.endsWith$default(r7, "]", false, 2, null) == false) goto L16;
            CommonParamsWrapper r1 = this.f1764a;
            CommonParamsWrapper.b(r1, CommonParamsWrapper.b(r1), this.f1765b, r7);
            CommonParamsWrapper.c(this.f1764a).set(false);
            q.a().b(CommonParamsWrapper.d(this.f1764a), "biz:{} setRuleConfig: {} success!", new Object[]{this.f1765b, r7});
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.bytedance.applog.params.a
        public void a() {
            CommonParamsWrapper.a(this.f1764a).c(new Object[0]);
            CommonParamsWrapper r0 = this.f1764a;
            CommonParamsWrapper.a(r0, CommonParamsWrapper.b(r0), this.f1765b);
            q.a().b(CommonParamsWrapper.d(this.f1764a), "biz:{} clear params success!", new Object[]{this.f1765b});
        }

        public void a(String r6) {
            Intrinsics.checkNotNullParameter(r6, "key");
            if (CommonParamsWrapper.c(this.f1764a).get() == false) goto L5;
            return;
        L5:
            CommonParamsWrapper.a(this.f1764a).c(new Object[0]);
            CommonParamsWrapper r0 = this.f1764a;
            CommonParamsWrapper.a(r0, CommonParamsWrapper.b(r0), this.f1765b, r6);
            ConcurrentHashMap r1 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(CommonParamsWrapper.e(this.f1764a).get(this.f1765b), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L11;
            LifecycleValueObserver r2 = (LifecycleValueObserver) ZeusTransformUtils.preCheckCast(r1.get(r6), LifecycleValueObserver.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L10;
            r2.destroy();
        L10:
            LifecycleValueObserver r3 = (LifecycleValueObserver) ZeusTransformUtils.preCheckCast(r1.remove(r6), LifecycleValueObserver.class, "com.obric.memorydata.plugin");
        L11:
            q.a().b(CommonParamsWrapper.d(this.f1764a), "biz:{} removed param:{} success!", new Object[]{this.f1765b, r6});
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J%\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"com/bytedance/applog/params/CommonParamsWrapper$lazySoLoader$1", "Lcom/bytedance/applog/log/AbsSingleton;", "", "create", TrackerImpl.PARAMS, "", "", "([Ljava/lang/Object;)Ljava/lang/Boolean;", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends com.bytedance.applog.log.b<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonParamsWrapper f1766a;

        b(CommonParamsWrapper r1) {
            this.f1766a = r1;
        }

        public Boolean a(Object... r2) {
            Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
            PriorityWrapper.f1778b.c(new Object[0]);
            CommonParamsWrapper r1 = this.f1766a;
            CommonParamsWrapper.a(r1, CommonParamsWrapper.b(r1));
            return true;
        }

        @Override // com.bytedance.applog.log.b
        public /* synthetic */ Boolean b(Object[] r1) {
            return a(r1);
        }
    }

    public CommonParamsWrapper(String r2) {
        Intrinsics.checkNotNullParameter(r2, "applogHashCode");
        this.f1762a = r2;
        this.f1763b = CollectionsKt.listOf("CommonParamsWrapper");
        this.c = new AtomicBoolean(true);
        this.d = new HashMap();
        this.e = new ConcurrentHashMap();
        this.f = new b(this);
    }

    public static final /* synthetic */ int a(CommonParamsWrapper r0, String r1) {
        return r0.nativeInit(r1);
    }

    public static final /* synthetic */ int a(CommonParamsWrapper r0, String r1, String r2, String r3) {
        return r0.nativeBizRemove(r1, r2, r3);
    }

    public static final /* synthetic */ b a(CommonParamsWrapper r0) {
        return r0.f;
    }

    public static final /* synthetic */ void a(CommonParamsWrapper r0, String r1, String r2) {
        r0.nativeBizClear(r1, r2);
    }

    public static final /* synthetic */ int b(CommonParamsWrapper r0, String r1, String r2, String r3) {
        return r0.nativeSetRuleConfig(r1, r2, r3);
    }

    public static final /* synthetic */ String b(CommonParamsWrapper r0) {
        return r0.f1762a;
    }

    public static final /* synthetic */ AtomicBoolean c(CommonParamsWrapper r0) {
        return r0.c;
    }

    public static final /* synthetic */ List d(CommonParamsWrapper r0) {
        return r0.f1763b;
    }

    public static final /* synthetic */ ConcurrentHashMap e(CommonParamsWrapper r0) {
        return r0.e;
    }

    private final native void nativeBizClear(String r1, String r2);

    private final native String nativeBizGet(String r1, String r2, String r3);

    private final native int nativeBizRemove(String r1, String r2, String r3);

    private final native void nativeBizSet(String r1, String r2, String r3, String r4);

    private final native void nativeBizSetCacheCapability(String r1, String r2, int r3);

    private final native String nativeHandleEvent(String r1, String r2, String r3);

    private final native int nativeInit(String r1);

    private final native int nativeSetRuleConfig(String r1, String r2, String r3);

    @Override // com.bytedance.applog.params.c
    public String a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.c.get() == false) goto L5;
        return "";
    L5:
        String r0 = this.f1762a;
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        String r6 = nativeHandleEvent(r0, r4, r5);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        q.a().b(this.f1763b, "event:{} had append some params!!", new Object[]{r4});
    L14:
        return r6;
    L11:
        r1 = false;
        goto L12
    }

    public synchronized void a() {
        monitor-enter(this);
        q.a().b(this.f1763b, "start to destroy common params wrapper...", new Object[0]);     // Catch: Throwable -> L22
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
        int r0 = this.e.size();     // Catch: Throwable -> L22
        Collection<ConcurrentHashMap<String, LifecycleValueObserver>> r2 = this.e.values();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r2, "valueLifecycleObservers.values");     // Catch: Throwable -> L22
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L22
    L7:
        if (r3.hasNext() == false) goto L12;
        Collection r4 = ((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r3.next(), ConcurrentHashMap.class, "com.obric.memorydata.plugin")).values();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r4, "it.values");     // Catch: Throwable -> L22
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L22
    L10:
        if (r5.hasNext() == false) goto L7;
        ((LifecycleValueObserver) ZeusTransformUtils.preCheckCast(r5.next(), LifecycleValueObserver.class, "com.obric.memorydata.plugin")).destroy();     // Catch: Throwable -> L22
        goto L10
    L12:
        this.e.clear();     // Catch: Throwable -> L22
        q.a().b(this.f1763b, "{} lifecycle observers has been destroyed...", new Object[]{Integer.valueOf(r0)});     // Catch: Throwable -> L22
    L14:
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        int r1 = this.d.size();     // Catch: Throwable -> L22
        Iterator r6 = ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Throwable -> L22
    L17:
        if (r6.hasNext() == false) goto L19;
        ((com.bytedance.applog.params.a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), com.bytedance.applog.params.a.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L22
        goto L17
    L19:
        this.d.clear();     // Catch: Throwable -> L22
        q.a().b(this.f1763b, "{} biz params object has been cleared...", new Object[]{Integer.valueOf(r1)});     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.applog.params.c
    public void a(boolean r2) {
        this.f.c(new Object[0]);
        NativeLogWrapper.a(r2);
    }
}
