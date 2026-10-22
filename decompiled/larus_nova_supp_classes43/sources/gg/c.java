package gg;

import android.text.TextUtils;
import cf.l;
import cf.w;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.common.impl.usertracker.ecmarketing.model.RecordActionResponse;
import com.bytedance.android.ec.common.impl.usertracker.repository.api.TrackerMarketingApi;
import com.bytedance.android.ec.model.ECMActionConditionData;
import com.bytedance.android.ec.sdk.ECSdk;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements IECUserTrackerService, of.a {
    public static final ConcurrentHashMap<String, Map<String, hg.a>> a = null;
    public static final ConcurrentHashMap<String, Map<String, Map<String, hg.a>>> b = null;
    public static final ConcurrentHashMap<String, hg.a> c = null;
    public static final ConcurrentHashMap<hg.b, hg.b> d = null;
    public static Disposable e;
    public static final c f = null;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r10) {
            RecordActionResponse r11 = (RecordActionResponse) r10;
            if (r11.getStatusCode() != 0) goto L10;
            List<hg.b> r12 = r11.getSwitchList();
            if (r12 == null) goto L12;
            Iterator<T> r13 = r12.iterator();
        L8:
            if (r13.hasNext() == false) goto L13;
            hg.b r0 = (hg.b) r13.next();
            r0.a = System.currentTimeMillis();
            c.d.put(r0, r0);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
        }
    }

    public c() {
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void enterPage(of.b r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    static {
        f = new c();
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final of.a getMarketingService() {
        return new gg.a();
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void leavePage(of.b r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        c.clear();
    }

    @Override // of.a
    public final void a(String r11, PostActionType r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "action");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "scene");
        int r1 = ig.a.a;
        Intrinsics.checkNotNullParameter(r13, "scene");
        if (TextUtils.equals(r13, "live") == false) goto L11;
        int r10 = ECSdk.a;
        l r14 = (l) ECSdk.a(l.class);
        if (r14 == null) goto L11;
        w r15 = r14.getRoomInfo();
        if (r15 == null) goto L11;
        Boolean r16 = r15.c;
        if (r16 == null) goto L11;
        boolean r17 = r16.booleanValue();
    L12:
        if (r17 == true) goto L14;
        return;
    L14:
        Intrinsics.checkNotNullParameter(r13, "scene");
        if (TextUtils.equals("live", r13) == false) goto L21;
        int r0 = ECSdk.a;
        l r18 = (l) ECSdk.a(l.class);
        if (r18 == null) goto L21;
        w r19 = r18.getRoomInfo();
        if (r19 == null) goto L21;
        String r20 = r19.a;
    L23:
        if (TextUtils.isEmpty(r20) == true) goto L84;
        if (r20 == null) goto L90;
        ConcurrentHashMap<String, Map<String, hg.a>> r21 = a;
        Map<String, hg.a> r22 = r21.get(r13);
        if (r22 == null) goto L29;
        hg.a r23 = r22.get(r11);
    L30:
        if (r23 != null) goto L37;
        Map<String, Map<String, hg.a>> r24 = b.get(r13);
        if (r24 == null) goto L36;
        Map<String, hg.a> r25 = r24.get(r20);
        if (r25 == null) goto L36;
        r23 = r25.get(r11);
    L36:
        r23 = null;
    L37:
        if (r23 != null) goto L39;
        r23 = c.get(r11);
    L39:
        ECMActionConditionData.a r26 = ig.a.a(r11);
        if (r26 != null) goto L43;
        return;
    L43:
        if (r23 != null) goto L65;
        r23 = new hg.a(r11);
        Integer r27 = r26.b();
        if (r27 != null) goto L48;
    L53:
        if (r27 != null) goto L56;
    L64:
        c.put(r11, r23);
        goto L65
    L56:
        if (r27.intValue() != 2) goto L64;
        ConcurrentHashMap<String, Map<String, Map<String, hg.a>>> r28 = b;
        Map<String, Map<String, hg.a>> r29 = r28.get(r13);
        if (r29 != null) goto L60;
        LinkedHashMap r30 = new LinkedHashMap();
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put(r11, r23);
        Unit r32 = Unit.INSTANCE;
        r30.put(r20, r31);
        r28.put(r13, r30);
        goto L65
    L60:
        Map<String, hg.a> r33 = r29.get(r20);
        if (r33 != null) goto L63;
        r33 = new LinkedHashMap();
        r29.put(r20, r33);
    L63:
        r33.put(r11, r23);
        goto L65
    L48:
        if (r27.intValue() != 1) goto L53;
        Map<String, hg.a> r34 = r21.get(r13);
        if (r34 != null) goto L52;
        r34 = new LinkedHashMap();
        r21.put(r13, r34);
    L52:
        r34.put(r11, r23);
    L65:
        List r35 = r26.c();
        int r110 = gg.b.a[r12.ordinal()];
        if (r110 == 1) goto L82;
        if (r110 != 2) goto L69;
        ArrayList r36 = new ArrayList();
        if (e != null) goto L88;
        e = com.bytedance.android.ec.core.rxjava.a.a(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new d(r23, r35, r13, r20, r11, r36), e.a);
        return;
    L88:
        return;
    L69:
        if (r110 != 3) goto L91;
        Disposable r111 = e;
        if (r111 != null) goto L74;
        return;
    L74:
        if (r111.isDisposed() == true) goto L86;
        Disposable r112 = e;
        if (r112 == null) goto L78;
        r112.dispose();
    L78:
        e = null;
        return;
    L86:
        return;
    L91:
        return;
    L82:
        b(r23, r35, r13, r20, r11, new ArrayList());
        return;
    L29:
        r23 = null;
        goto L30
    L90:
        return;
    L84:
        return;
    L21:
        r20 = null;
    L11:
        r17 = false;
        goto L12
    }

    public static void b(hg.a r10, List r11, String r12, String r13, String r14, List r15) {
        r10.a++;
        if (r11 == null) goto L46;
        Iterator r16 = r11.iterator();
        int r0 = 1;
    L6:
        if (r16.hasNext() == false) goto L47;
        ECMActionConditionData.a.a r17 = (ECMActionConditionData.a.a) r16.next();
        if (r17 == null) goto L6;
        if (r10.a < r17.a()) goto L14;
        if (CollectionsKt.contains(r10.b, r17.c()) == true) goto L14;
    L19:
        String r18 = r17.c();
        Iterator<T> r19 = d.values().iterator();
    L21:
        if (r19.hasNext() == false) goto L38;
        hg.b r20 = (hg.b) r19.next();
        if (Intrinsics.areEqual(r20.c(), r18) == false) goto L21;
        if (Intrinsics.areEqual(r20.d(), r12) == true) goto L31;
        if (Intrinsics.areEqual(r20.e(), r13) == true) goto L31;
        if (Intrinsics.areEqual(r20.a(), r14) == false) goto L21;
    L31:
        if (r20.f() == true) goto L21;
        if (r20.b() > 0) goto L35;
    L37:
        boolean r21 = false;
    L39:
        if (r21 == false) goto L6;
        String r22 = r17.c();
        if (r22 != null) goto L43;
        r22 = "";
    L43:
        r15.add(r22);
        if (r17.b() <= r0) goto L6;
        r0 = r17.b();
        goto L6
    L35:
        if (((System.currentTimeMillis() - r20.a) / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR)) <= r20.b()) goto L37;
    L38:
        r21 = true;
    L14:
        if (CollectionsKt.contains(r10.b, r17.c()) == false) goto L6;
        if (r17.d() == false) goto L6;
        if ((r10.a % r17.a()) != 0) goto L6;
    L47:
        List r23 = r15;
        if ((true ^ r23.isEmpty()) == true) goto L50;
        return;
    L50:
        if (Random.Default.nextInt(2, 100) > r0) goto L114;
        ((ArrayList) r10.b).addAll(r23);
        Iterator r24 = r15.iterator();
        String r25 = null;
        String r1 = null;
    L53:
        if (r24.hasNext() == false) goto L59;
        String r26 = (String) r24.next();
        if (TextUtils.isEmpty(r1) == true) goto L58;
        r26 = r1 + ',' + r26;
    L58:
        r1 = r26;
        goto L53
    L59:
        r15.clear();
        ECMActionConditionData.a r27 = ig.a.a(r14);
        if (r27 == null) goto L62;
        Integer r28 = r27.d();
    L63:
        TrackerMarketingApi.a.getClass();
        TrackerMarketingApi r29 = TrackerMarketingApi.a.a;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r12, "scene");
        if (TextUtils.equals("live", r12) == false) goto L77;
        JSONObject r110 = new JSONObject();
        int r30 = ECSdk.a;
        l r31 = (l) ECSdk.a(l.class);
        if (r31 == null) goto L70;
        w r32 = r31.getRoomInfo();
        if (r32 == null) goto L70;
        String r33 = r32.a;
    L71:
        r110.putOpt(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r33);
        l r34 = (l) ECSdk.a(l.class);
        if (r34 == null) goto L76;
        w r35 = r34.getRoomInfo();
        if (r35 == null) goto L76;
        r25 = r35.b;
    L76:
        r110.putOpt("kol_uid", r25);
        r25 = r110.toString();
    L70:
        r33 = null;
    L77:
        Observable<RecordActionResponse> r36 = r29.recordAction(r1, r12, r13, r14, r25);
        if (r28 == null) goto L82;
        int r37 = ECSdk.a;
        g r38 = (g) ECSdk.a(g.class);
        if (r38 == null) goto L82;
        r38.J();
    L82:
        r36.subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(a.a, b.a);
        return;
    L62:
        r28 = null;
        goto L63
    L114:
        return;
    L46:
        r0 = 1;
        goto L47
    }
}
