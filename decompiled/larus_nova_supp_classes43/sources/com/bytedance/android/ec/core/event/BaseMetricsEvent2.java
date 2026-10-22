package com.bytedance.android.ec.core.event;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.eventdumper.ECEventDumper;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventKey;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventParam;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.g;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u000f\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J%\u0010\u0011\u001a\u00020\u00002\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\"\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0013j\b\u0012\u0004\u0012\u00020\u000f`\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015RB\u0010\u0019\u001a.\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00170\u0016j\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0017`\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "Lcom/bytedance/android/ec/core/event/a;", "Ltg/a;", "Ljava/io/Serializable;", "", "buildParams", "addReflectionParams$ec_core_saasRelease", "()V", "addReflectionParams", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "", "btmId", "post", "", "Lcom/bytedance/android/ec/core/event/BaseEventContext;", "eventContexts", "with", "([Lcom/bytedance/android/ec/core/event/BaseEventContext;)Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "contextMap", "Ljava/util/HashMap;", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventKey;", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventParam;", "getDumpedDumpedEventParams", "()Ljava/util/Map;", "dumpedDumpedEventParams", "", "getEventClassVersion", "()I", "eventClassVersion", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseMetricsEvent2 extends com.bytedance.android.ec.core.event.a implements Serializable {
    public static final a Companion = null;
    public static final HashMap<Class<?>, HashMap<String, Field>> a = null;
    public static final HashMap<Class<?>, ArrayList<String>> b = null;
    private HashMap<String, Class<? extends BaseEventContext>> contextMap;
    private ArrayList<BaseEventContext> eventContexts;
    private final String eventName;

    public static final class a {
        public a() {
        }
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ BaseMetricsEvent2 a;
        public final /* synthetic */ PageFinder b;
        public final /* synthetic */ String c;

        public b(BaseMetricsEvent2 r1, PageFinder r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            Map r1 = null;
            if (this.b != null) goto L5;
        L13:
            g r0 = g.a;     // Catch: Throwable -> L21
            String r10 = this.a.getEventName();     // Catch: Throwable -> L21
            HashMap<String, String> r11 = this.a.getParams();     // Catch: Throwable -> L21
            if ((r11 instanceof Map) == false) goto L17;
            r1 = r11;
        L17:
            if (r1 != null) goto L19;
            r1 = MapsKt.emptyMap();     // Catch: Throwable -> L21
        L19:
            r0.logV3(r10, new JSONObject(r1));     // Catch: Throwable -> L21
            return;
        L5:
            if (this.c == null) goto L13;
            g r12 = g.a;     // Catch: Throwable -> L21
            String r13 = this.a.getEventName();     // Catch: Throwable -> L21
            HashMap<String, String> r14 = this.a.getParams();     // Catch: Throwable -> L21
            if ((r14 instanceof Map) == false) goto L10;
            r1 = r14;
        L10:
            if (r1 != null) goto L12;
            r1 = MapsKt.emptyMap();     // Catch: Throwable -> L21
        L12:
            r12.g(r13, new JSONObject(r1), this.c, this.b);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            ECExceptionMonitor.e(th);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.ec.core.event.a
    public void buildParams() {
    }

    @Override // com.bytedance.android.ec.core.event.a, tg.a
    public int getEventClassVersion() {
        return 2;
    }

    static {
        Companion = new a();
        a = new HashMap();
        b = new HashMap();
    }

    public final void addReflectionParams$ec_core_saasRelease() {
        this.contextMap.clear();
        HashMap<Class<?>, HashMap<String, Field>> r0 = a;
        HashMap<String, Field> r1 = r0.get(getClass());
        if (r1 != null) goto L5;
        r1 = new HashMap();
        r0.put(getClass(), r1);
        ArrayList<String> r10 = new ArrayList();
        b.put(getClass(), r10);
        a(r1, r10, getClass());
    L5:
        Iterator<Map.Entry<String, Field>> r11 = r1.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L27;
        Map.Entry<String, Field> r12 = r11.next();
        String r13 = r12.getKey();
        Object r14 = r12.getValue().get(this);
        if (r14 == null) goto L11;
        String r15 = r14.toString();
    L12:
        if (r15 == null) goto L13;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam(r13, r15, com.bytedance.android.ec.core.event.a.b.C0129a.a);
        goto L7
    L13:
        Iterator<BaseEventContext> r16 = this.eventContexts.iterator();
        String r17 = null;
    L15:
        if (r16.hasNext() == false) goto L25;
        BaseEventContext r18 = r16.next();
        BaseEventContext.b r19 = r18.getParamsMap().get(r13);
        if (r19 == null) goto L21;
        Object r20 = r19.getValue();
        if (r20 == null) goto L21;
        String r21 = r20.toString();
    L22:
        if (r21 != null) goto L23;
        r17 = r21;
        goto L15
    L23:
        this.contextMap.put(r13, (Class<? extends BaseEventContext>) r18.getClass());
        r17 = r21;
    L21:
        r21 = null;
    L25:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam(r13, r17, com.bytedance.android.ec.core.event.a.b.C0129a.a);
        goto L7
    L11:
        r15 = null;
        goto L12
    }

    @Override // com.bytedance.android.ec.core.event.a, tg.a
    public Map<DumpedEventKey, DumpedEventParam> getDumpedDumpedEventParams() {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, String>> r1 = m1176getParams().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, String> r10 = r1.next();
        String r11 = r10.getKey();
        String r12 = r10.getValue();
        ArrayList<String> r13 = b.get(getClass());
        if (r13 == null) goto L8;
        boolean r14 = r13.contains(r11);
    L10:
        if (this.contextMap.get(r11) == null) goto L12;
        boolean r15 = true;
    L13:
        r0.put(new DumpedEventKey(r11, r14), new DumpedEventParam(r12, r15, null, 4, null));
        goto L4
    L12:
        r15 = false;
        goto L13
    L8:
        r14 = false;
        goto L10
    L14:
        return r0;
    }

    @Override // com.bytedance.android.ec.core.event.a, tg.a
    public String getEventName() {
        return this.eventName;
    }

    public BaseMetricsEvent2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        super(r10);
        this.eventName = r10;
        this.eventContexts = new ArrayList();
        this.contextMap = new HashMap();
    }

    public final BaseMetricsEvent2 with(BaseEventContext... r10) {
        Intrinsics.checkNotNullParameter(r10, "eventContexts");
        int r0 = r10.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        BaseEventContext r11 = r10[r1];
        if (r11 == null) goto L7;
        this.eventContexts.add(r11);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return this;
    }

    @Override // com.bytedance.android.ec.core.event.a, com.bytedance.android.ec.core.event.d
    public void post(PageFinder r10, String r11) {
        addReflectionParams$ec_core_saasRelease();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0129a.C0130a r0 = com.bytedance.android.ec.core.event.a.b.C0129a.a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_DATA_TYPE, com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE, r0);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r0);
        buildParams();
        Iterator<T> r1 = this.eventContexts.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        appendParam(((BaseEventContext) r1.next()).getExtraParams());
        goto L4
    L6:
        getParams().putAll(getExtraParams());
        Single.fromCallable(new b(this, r10, r11)).subscribeOn(Schedulers.io()).subscribe();
        ECEventDumper.h.getClass();
        ECEventDumper.a.c(this);
        this.eventContexts.clear();
    }

    public static void a(HashMap r10, ArrayList r11, Class r12) {
        if ((!Intrinsics.areEqual(r12, BaseMetricsEvent2.class)) == false) goto L23;
        Field[] r0 = r12.getDeclaredFields();
        int r13 = r0.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L13;
        Field r15 = r0[r14];
        Iterator r16 = ArrayIteratorKt.iterator(r15.getDeclaredAnnotations());
    L8:
        if (r16.hasNext() == false) goto L12;
        Annotation r17 = (Annotation) r16.next();
        if ((r17 instanceof EventKey) == false) goto L8;
        r15.setAccessible(true);
        EventKey r18 = (EventKey) r17;
        r10.put(r18.value(), r15);
        r11.add(r18.value());
        goto L8
    L12:
        r14 = r14 + 1;
        goto L5
    L13:
        Class r19 = r12.getSuperclass();
        if (r19 == null) goto L24;
        a(r10, r11, r19);
        return;
    L24:
        return;
    }
}
