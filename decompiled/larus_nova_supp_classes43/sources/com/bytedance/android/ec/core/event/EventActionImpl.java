package com.bytedance.android.ec.core.event;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.eventdumper.ECEventDumper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class EventActionImpl implements com.bytedance.android.ec.core.event.c {
    public final Lazy a;
    public final xi.a b;

    public static final class a implements Action {
        public final /* synthetic */ EventActionImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Ref.ObjectRef c;

        public a(EventActionImpl r1, String r10, Ref.ObjectRef r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void run() {
            this.a.b.logV3(this.b, new JSONObject((Map) this.c.element));
        }
    }

    public static final class b implements Action {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void run() {
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ String a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ String c;
        public final /* synthetic */ PageFinder d;

        public d(String r1, Ref.ObjectRef r10, String r11, PageFinder r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        public final void run() {
            com.bytedance.android.ec.sdk.helper.g.a.g(this.a, new JSONObject((Map) this.b.element), this.c, this.d);
        }
    }

    public static final class e implements Action {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void run() {
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
        }
    }

    public static final class g<T> implements Consumer {
        public g(String r1) {
        }

        public final void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
        }
    }

    public static final class h implements Action {
        public final /* synthetic */ EventActionImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;

        public h(EventActionImpl r1, String r10, Map r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void run() {
            this.a.b.logV3(this.b, new JSONObject(this.c));
            EventActionImpl.m(this.a, this.b, this.c);
        }
    }

    public static final class i implements Action {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final void run() {
        }
    }

    public static final class j<T> implements Consumer {
        public j(String r1) {
        }

        public final void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
        }
    }

    public static final class k implements Action {
        public final /* synthetic */ EventActionImpl a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ String c;
        public final /* synthetic */ PageFinder d;
        public final /* synthetic */ String e;

        public k(EventActionImpl r1, Map r10, String r11, PageFinder r12, String r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }

        public final void run() {
            JSONObject r0 = new JSONObject(this.b);
            String r1 = this.c;
            if (r1 == null) goto L10;
            PageFinder r10 = this.d;
            if (r10 == null) goto L10;
            Iterator r11 = BtmSDK.INSTANCE.createReportParams(r1, r10).entrySet().iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            Map.Entry r12 = (Map.Entry) r11.next();
            r0.putOpt((String) r12.getKey(), r12.getValue());
        L10:
            this.a.b.logV3(this.e, r0);
            EventActionImpl.m(this.a, this.e, this.b);
        }
    }

    public static final class l implements Action {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final void run() {
        }
    }

    public static final class m<T> implements Consumer {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
        }
    }

    public static final class n implements Action {
        public final /* synthetic */ EventActionImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Ref.ObjectRef c;

        public n(EventActionImpl r1, String r10, Ref.ObjectRef r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void run() {
            this.a.b.logV3(this.b, new JSONObject((Map) this.c.element));
            EventActionImpl.m(this.a, this.b, (Map) this.c.element);
        }
    }

    public static final class o implements Action {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final void run() {
        }
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void bindMonitorId(Long r1) {
    }

    public final Map<String, String> n() {
        return (Map) this.a.getValue();
    }

    public EventActionImpl() {
        int r0 = dh.a.a;
        com.bytedance.android.ec.sdk.helper.g r1 = com.bytedance.android.ec.sdk.helper.g.a;
        Intrinsics.checkNotNullParameter(r1, "hostLogService");
        this.b = r1;
        this.a = LazyKt.lazy(EventActionImpl$contextParams$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final String getBaseParamsJson() {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r1 = n().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<String, String> r10 = r1.next();
        r0.put(r10.getKey(), r10.getValue());
        goto L4
    L7:
        return r0.toString();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void clearEventParams() {
        n().clear();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final Map<String, String> getBaseParams() {
        return n();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r10, "paramsMap");
        Map<String, String> r0 = n();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L15;
        Map.Entry<String, String> r12 = r11.next();
        String r13 = r12.getValue();
        boolean r14 = false;
        if (r13 != null) goto L8;
    L13:
        if (r14 == false) goto L4;
        r1.put(r12.getKey(), r12.getValue());
        goto L4
    L8:
        if (r13.length() <= 0) goto L10;
        boolean r15 = true;
    L11:
        if (r15 != true) goto L13;
        r14 = true;
        goto L13
    L10:
        r15 = false;
        goto L11
    L15:
        r0.putAll(r1);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r10, "paramsMap");
        Map<String, String> r0 = n();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L15;
        Map.Entry<String, String> r12 = r11.next();
        String r13 = r12.getValue();
        boolean r14 = false;
        if (r13 != null) goto L8;
    L13:
        if (r14 == false) goto L4;
        r1.put(r12.getKey(), r12.getValue());
        goto L4
    L8:
        if (r13.length() <= 0) goto L10;
        boolean r15 = true;
    L11:
        if (r15 != true) goto L13;
        r14 = true;
        goto L13
    L10:
        r15 = false;
        goto L11
    L15:
        r0.putAll(r1);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Pair<String, String>... r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        MapsKt.putAll(n(), SequencesKt.filter(ArraysKt.asSequence(r10), AnonymousClass1.INSTANCE));
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Pair<String, String>... r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        MapsKt.putAll(n(), SequencesKt.filter(ArraysKt.asSequence(r10), C02411.INSTANCE));
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r10, Pair<String, String>... r11) {
        Intrinsics.checkNotNullParameter(r10, "actionName");
        Intrinsics.checkNotNullParameter(r11, "params");
        Map r12 = MapsKt.plus(n(), r11);
        com.bytedance.android.ec.core.async.a.b(bg4.b.a(Completable.fromAction(new h(this, r10, r12))).subscribe(i.a, new j(r10)));
        ECEventDumper.h.getClass();
        ECEventDumper.a.b(r10, r12);
    }

    public static final void m(EventActionImpl r10, String r11, Map r12) {
        r10.getClass();
        if (ECAppInfoService.e.isDebug() == false) goto L11;
        new StringBuilder("<<<=========" + r11 + " start =========>>>\n");
        Iterator r13 = r12.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        String r16 = (String) r14.getValue();
        goto L6
    L9:
        return;
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventAction(String r10, Map<String, ? extends Object> r11, Pair<String, ? extends Object>... r12) {
        Intrinsics.checkNotNullParameter(r10, "actionName");
        Intrinsics.checkNotNullParameter(r12, "params");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        Map r13 = MapsKt.plus(n(), r12);
        r0.element = r13;
        if (r11 == null) goto L5;
        r0.element = MapsKt.plus(r13, r11);
    L5:
        com.bytedance.android.ec.core.async.a.b(bg4.b.a(Completable.fromAction(new a(this, r10, r0))).subscribe(b.a, c.a));
        ECEventDumper.a r14 = ECEventDumper.h;
        Map r15 = (Map) r0.element;
        r14.getClass();
        ECEventDumper.a.b(r10, r15);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r10, Map<String, String> r11, Pair<String, String>... r12) {
        Intrinsics.checkNotNullParameter(r10, "actionName");
        Intrinsics.checkNotNullParameter(r12, "params");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        Map r13 = MapsKt.plus(n(), r12);
        r0.element = r13;
        if (r11 == null) goto L5;
        r0.element = MapsKt.plus(r13, r11);
    L5:
        com.bytedance.android.ec.core.async.a.b(bg4.b.a(Completable.fromAction(new n(this, r10, r0))).subscribe(o.a, new g(r10)));
        ECEventDumper.a r14 = ECEventDumper.h;
        Map r15 = (Map) r0.element;
        r14.getClass();
        ECEventDumper.a.b(r10, r15);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r10, String r11, PageFinder r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r10, "actionName");
        Intrinsics.checkNotNullParameter(r13, "paramMap");
        Map r14 = MapsKt.plus(n(), r13);
        com.bytedance.android.ec.core.async.a.b(bg4.b.a(Completable.fromAction(new k(this, r14, r11, r12, r10))).subscribe(l.a, m.a));
        ECEventDumper.h.getClass();
        ECEventDumper.a.b(r10, r14);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r10, String r11, PageFinder r12, Pair<String, String>... r13) {
        Intrinsics.checkNotNullParameter(r10, "actionName");
        Intrinsics.checkNotNullParameter(r13, "params");
        doEventAction(r10, r11, r12, MapsKt.plus(new LinkedHashMap(), r13));
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventActionWithBtm(String r10, PageFinder r11, String r12, Map<String, ? extends Object> r13, Pair<String, ? extends Object>... r14) {
        Intrinsics.checkNotNullParameter(r10, "btm");
        Intrinsics.checkNotNullParameter(r11, "pageFinder");
        Intrinsics.checkNotNullParameter(r12, "actionName");
        Intrinsics.checkNotNullParameter(r14, "params");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        Map r15 = MapsKt.plus(n(), r14);
        r0.element = r15;
        if (r13 == null) goto L5;
        r0.element = MapsKt.plus(r15, r13);
    L5:
        com.bytedance.android.ec.core.async.a.b(bg4.b.a(Completable.fromAction(new d(r12, r0, r10, r11))).subscribe(e.a, f.a));
        ECEventDumper.a r16 = ECEventDumper.h;
        Map r17 = (Map) r0.element;
        r16.getClass();
        ECEventDumper.a.b(r12, r17);
    }
}
