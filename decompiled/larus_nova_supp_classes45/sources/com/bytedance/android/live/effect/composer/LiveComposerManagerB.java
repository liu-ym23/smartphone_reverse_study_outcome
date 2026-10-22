package com.bytedance.android.live.effect.composer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.view.SurfaceView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.u;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.beauty.presets.LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1;
import com.bytedance.android.live.effect.common.LiveCommonStickerUIViewModel;
import com.bytedance.android.live.effect.s;
import com.bytedance.android.live.effect.sticker.presenter.r;
import com.bytedance.android.live.effect.sticker.presenter.z;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdk.config.pb;
import com.bytedance.android.livesdk.config.rb;
import com.bytedance.android.livesdk.config.ul;
import com.bytedance.android.livesdk.config.w1;
import com.bytedance.android.livesdk.config.yg;
import com.bytedance.android.livesdk.widget.BroadcastKtvEffectMusicWidget;
import com.bytedance.android.livesdk.widget.u2;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveComposerManagerB implements ILiveEffectComposerManager {
    public static final /* synthetic */ int H = 0;
    public final List<String> A;
    public final List<ILiveEffectComposerManager.a> B;
    public final Lazy C;
    public final List<Object> D;
    public final List<String> E;
    public final Map<String, List<ILiveEffectComposerManager.i>> F;
    public final LiveEffectContextFactoryDelegate$Type G;
    public final Lazy a;
    public final k b;
    public final List<ILiveEffectComposerManager.d> c;
    public final List<ILiveEffectComposerManager.b> d;
    public final List<n> e;
    public final List<n> f;
    public final ArrayList<n> g;
    public final Map<String, List<n>> h;
    public final ArrayList<String> i;
    public final CopyOnWriteArrayList<n> j;
    public final Map<String, List<n>> k;
    public final CopyOnWriteArrayList<Pair<n, List<String>>> l;
    public final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> m;
    public final Map<String, List<Sticker>> n;
    public final Lazy o;
    public final Lazy p;
    public final CompositeDisposable q;
    public long r;
    public String s;
    public final List<com.bytedance.android.live.effect.composer.a> t;
    public q u;
    public final CompositeDisposable v;
    public final List<ILiveEffectComposerManager.j> w;
    public long x;
    public final Map<String, Long> y;
    public volatile boolean z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LiveComposerManagerB a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Sticker c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ILiveEffectComposerManager.EffectInstanceType e;
        public final /* synthetic */ HashMap f;
        public final /* synthetic */ com.bytedance.android.live.effect.base.e g;

        public b(LiveComposerManagerB r1, String r2, Sticker r3, String r4, ILiveEffectComposerManager.EffectInstanceType r5, HashMap r6, com.bytedance.android.live.effect.base.e r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b0(this.b, this.c, true, true, null, this.d, this.e, this.f, this.g);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((n) r1).b, ((n) r2).b);
        }
    }

    public static final class d<T> implements Comparator<T> {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((n) r1).b, ((n) r2).b);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ LiveComposerManagerB a;
        public final /* synthetic */ ILiveEffectComposerManager.h b;
        public final /* synthetic */ String c;

        public static final class a implements Runnable {
            public final /* synthetic */ e a;

            public a(e r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e r0 = this.a;     // Catch: Throwable -> L8
                ILiveEffectComposerManager.h r1 = r0.b;     // Catch: Throwable -> L8
                List<String> r2 = (CopyOnWriteArrayList) r0.a.m.get(r0.c);     // Catch: Throwable -> L8
                if (r2 != null) goto L6;
                r2 = CollectionsKt.emptyList();     // Catch: Throwable -> L8
            L6:
                r1.a(r2);     // Catch: Throwable -> L8
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        public e(LiveComposerManagerB r1, ILiveEffectComposerManager.h r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AndroidSchedulers.mainThread().scheduleDirect(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ LiveComposerManagerB$restoreSaveNode$2 a;
        public final /* synthetic */ LiveComposerManagerB$restoreSaveNode$1 b;

        public f(LiveComposerManagerB$restoreSaveNode$2 r1, LiveComposerManagerB$restoreSaveNode$1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m741invoke();     // Catch: Throwable -> L4
            this.b.m740invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LiveComposerManagerB$showSticker$2 a;

        public g(LiveComposerManagerB$showSticker$2 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.m742invoke();
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void D() {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void M() {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void i(SurfaceView r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void j(String r2, ILiveEffectComposerManager.h r3) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "listener");
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void n(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "path");
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final boolean p() {
        return false;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void q() {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void u() {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final int z(String[] r1, int[] r2, String r3) {
        return 0;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final Pair<Boolean, Boolean> H() {
        List<Sticker> r0 = o(d0.b);
        if (r0.isEmpty() == false) goto L6;
        Boolean r1 = Boolean.FALSE;
        return new Pair(r1, r1);
    L6:
        Iterator<T> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        if (((Sticker) r2.next()).isDoubleHandGesture() == true) goto L8;
        return new Pair(Boolean.TRUE, Boolean.FALSE);
    L13:
        Boolean r3 = Boolean.TRUE;
        return new Pair(r3, r3);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final List<n> R() {
        List<n> r0 = CollectionsKt.sortedWith(this.e, new c());
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L25;
        n r2 = (n) r1.next();
        if (r2.k.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        Map<String, List<Sticker>> r4 = this.n;
        HashMap r5 = (HashMap) r4;
        List r6 = (List) r5.get(r2.a);
        if (r6 == null) goto L23;
        Iterator r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L18;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(r2.b, String.valueOf(((Sticker) r8).getId())) == false) goto L14;
    L19:
        Sticker r9 = (Sticker) r8;
        if (r9 == null) goto L23;
        String r11 = r9.getExtra();
        if (r11 == null) goto L23;
    L24:
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r2.k = r11;
        goto L4
    L18:
        r8 = null;
    L23:
        r11 = "";
        goto L24
    L8:
        r3 = false;
        goto L9
    L25:
        return r0;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final Map<String, Map<String, Sticker>> c() {
        HashMap r0 = new HashMap();
        List<n> r1 = this.e;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        n r5 = (n) r4;
        Map<String, List<Sticker>> r6 = this.n;
        HashMap r7 = (HashMap) r6;
        if (r7.containsKey(r5.a) == true) goto L8;
    L10:
        boolean r8 = false;
    L11:
        if (r8 == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        if (r5.j == false) goto L10;
        r8 = true;
        goto L11
    L13:
        Iterator r9 = r2.iterator();
    L15:
        if (r9.hasNext() == false) goto L33;
        n r11 = (n) r9.next();
        if (r0.containsKey(r11.a) == true) goto L19;
        r0.put(r11.a, new HashMap());
    L19:
        Object r12 = r0.get(r11.a);
        Intrinsics.checkNotNull(r12);
        Map r13 = (Map) r12;
        if (r13.containsKey(r11.b) == true) goto L15;
        Map<String, List<Sticker>> r14 = this.n;
        HashMap r15 = (HashMap) r14;
        List r16 = (List) r15.get(r11.a);
        if (r16 == null) goto L15;
        Iterator r17 = r16.iterator();
    L25:
        if (r17.hasNext() == false) goto L29;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((Sticker) r18).getEffectId(), r11.b) == false) goto L25;
    L30:
        Sticker r19 = (Sticker) r18;
        if (r19 == null) goto L15;
        String r21 = r19.getEffectId();
        Intrinsics.checkNotNull(r21);
        r13.put(r21, r19);
        goto L15
    L29:
        r18 = null;
        goto L30
    L33:
        return r0;
    }

    public final boolean d0() {
        ALogger.e("ttlive_anchor_effect_LiveComposerManagerB", "config is null");
        return false;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final List<n> e() {
        List<n> r0 = CollectionsKt.sortedWith(this.f, new d());
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L25;
        n r2 = (n) r1.next();
        if (r2.k.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        Map<String, List<Sticker>> r4 = this.n;
        HashMap r5 = (HashMap) r4;
        List r6 = (List) r5.get(r2.a);
        if (r6 == null) goto L23;
        Iterator r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L18;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(r2.b, String.valueOf(((Sticker) r8).getId())) == false) goto L14;
    L19:
        Sticker r9 = (Sticker) r8;
        if (r9 == null) goto L23;
        String r11 = r9.getExtra();
        if (r11 == null) goto L23;
    L24:
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r2.k = r11;
        goto L4
    L18:
        r8 = null;
    L23:
        r11 = "";
        goto L24
    L8:
        r3 = false;
        goto L9
    L25:
        return r0;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final List<n> P() {
        List<n> r0 = R();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (this.i.contains(((n) r3).b) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final boolean W() {
        return this.z;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.G;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public LiveComposerManagerB(LiveEffectContextFactoryDelegate$Type r41) {
        Intrinsics.checkNotNullParameter(r41, "type");
        this.G = r41;
        this.a = LazyKt.lazy(new LiveComposerManagerB$composerDataProcess$2(this));
        this.b = new k(r41);
        this.c = new CopyOnWriteArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new LinkedHashMap();
        this.i = new ArrayList();
        CopyOnWriteArrayList<n> r2 = new CopyOnWriteArrayList();
        this.j = r2;
        this.k = new LinkedHashMap();
        this.l = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.m = new ConcurrentHashMap();
        this.n = new HashMap();
        Lazy r0 = LazyKt.lazy(new LiveComposerManagerB$composerSQLHelper$2(this));
        this.o = r0;
        this.p = LazyKt.lazy(LiveComposerManagerB$composerModeSQLHelper$2.INSTANCE);
        this.q = new CompositeDisposable();
        this.s = "";
        this.t = new ArrayList();
        this.v = new CompositeDisposable();
        this.w = new ArrayList();
        this.y = new LinkedHashMap();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = LazyKt.lazy(LiveComposerManagerB$effectMsgListenerList$2.INSTANCE);
        this.D = new ArrayList();
        this.E = CollectionsKt.listOf(new String[]{d0.i, d0.a, d0.k, "livebody", "live_adjustment"});
        this.F = new LinkedHashMap();
        String r4 = "value";
        String r5 = "tag";
        String r8 = "is_high_cost";
        String r9 = "use";
        String r11 = "update_time";
        String r15 = "id";
        o r1 = (o) r0.getValue();
        r1.getClass();
        System.currentTimeMillis();
        ArrayList r7 = new ArrayList();
        SQLiteDatabase r24 = r1.getReadableDatabase();
        Cursor r25 = null;
        Cursor r3 = r24.query("live_composer_node", null, null, null, null, null, "update_time asc");     // Catch: Throwable -> L71
    L213:
    L68:
        th = th;
        Cursor r38 = r3;
        String r17 = r4;
        String r37 = r9;
        String r27 = r15;
    L70:
        r3 = r38;
    L215:
        ALogger.e("LiveComposerSQLiteHelper", th);     // Catch: Throwable -> L184
        if (r3 == null) goto L79;
    L78:
        r3.close();
    L79:
        r24.close();
        r2.addAll(r7);
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_START_LIVE_RESTORE_OPTIMIZE.getValue().booleanValue() == false) goto L90;
        Map<String, String> r6 = m90.b.G.c(this.G);
        Iterator<n> r12 = this.j.iterator();
    L83:
        if (r12.hasNext() == false) goto L90;
        n r13 = r12.next();
        if (r6 == null) goto L88;
        String r14 = r6.get(r13.b);
        if (r14 == null) goto L88;
    L89:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.k = r14;
    L88:
        r14 = "";
    L90:
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r16 = u.a;
        if (u.b(this.G).e().c() == false) goto L183;
        j r18 = (j) this.p.getValue();
        r18.getClass();
        System.currentTimeMillis();
        LinkedHashMap r19 = new LinkedHashMap();
        SQLiteDatabase r21 = r18.getReadableDatabase();
        Cursor r22 = r21.query("live_composer_node_by_mode", null, null, null, null, null, "update_time asc");     // Catch: Throwable -> L170
    L199:
    L168:
        th = th;
        r25 = r22;
    L191:
        ALogger.e("LiveComposerModeSQLiteHelper", th);     // Catch: Throwable -> L178
        if (r25 == null) goto L174;
        r25.close();
    L174:
        r21.close();
        Iterator r23 = r19.entrySet().iterator();
    L176:
        if (r23.hasNext() == false) goto L263;
        Map.Entry r26 = (Map.Entry) r23.next();
        Map<String, List<n>> r28 = this.k;
        Object r29 = r26.getKey();
        ArrayList r31 = new ArrayList();
        r31.addAll((Collection) r26.getValue());
        Unit r32 = Unit.INSTANCE;
        r28.put((String) r29, r31);
        goto L176
    L263:
        return;
    L178:
        th = move-exception;
        if (r25 == null) goto L262;
        r25.close();
        throw th;
    L262:
        throw th;
    L95:
        if (r22.moveToNext() == false) goto L167;
        String r33 = r27;
        String r34 = r22.getString(r22.getColumnIndex(r33));     // Catch: Throwable -> L168
        String r210 = r22.getString(r22.getColumnIndex("panel"));     // Catch: Throwable -> L168
        String r211 = r22.getString(r22.getColumnIndex("effect_id"));     // Catch: Throwable -> L168
        String r212 = r22.getString(r22.getColumnIndex("resource_id"));     // Catch: Throwable -> L168
        String r35 = r22.getString(r22.getColumnIndex("path"));     // Catch: Throwable -> L168
        long r36 = r22.getLong(r22.getColumnIndex(r11));     // Catch: Throwable -> L168
        String r39 = r37;
        if (r22.getInt(r22.getColumnIndex(r39)) != 1) goto L99;
        boolean r110 = true;
    L100:
        String r111 = r8;
        if (r22.getInt(r22.getColumnIndex(r8)) != 1) goto L103;
        boolean r310 = true;
    L104:
        n r42 = new n(r210, r211, r212, r35, false, r310, r36);     // Catch: Throwable -> L168
        r42.j = r110;     // Catch: Throwable -> L168
        String r43 = r22.getString(r22.getColumnIndex("mode"));     // Catch: Throwable -> L168
        r37 = r39;
        Cursor r44 = r21.query("live_composer_tag_node_by_mode", null, "node_id=?", new String[]{r34}, null, null, null);     // Catch: Throwable -> L153
    L209:
        if (r44.moveToNext() == false) goto L134;
        String r45 = r44.getString(r44.getColumnIndex(r5));     // Catch: Throwable -> L132
        String r112 = r17;
        String r113 = r5;
        float r46 = r44.getFloat(r44.getColumnIndex(r112));     // Catch: Throwable -> L130
        Cursor r114 = r44;
        Iterator r47 = ((ArrayList) r42.i).iterator();     // Catch: Throwable -> L128
    L116:
        if (r47.hasNext() == false) goto L121;
        Object r213 = r47.next();     // Catch: Throwable -> L128
        Iterator r214 = r47;
        if (Intrinsics.areEqual(((p) r213).b, r45) == true) goto L122;
        r47 = r214;
    L122:
        if (r213 != null) goto L126;
        List<p> r48 = r42.i;     // Catch: Throwable -> L128
        String r215 = r11;
        p r115 = new p(r45);     // Catch: Throwable -> L149
        r115.a = Float.valueOf(r46);     // Catch: Throwable -> L149
        Unit r49 = Unit.INSTANCE;     // Catch: Throwable -> L149
        ((ArrayList) r48).add(r115);     // Catch: Throwable -> L149
    L127:
        r5 = r113;
        r44 = r114;
        r11 = r215;
        r17 = r112;
    L149:
        th = th;
    L233:
        ALogger.e("LiveComposerModeSQLiteHelper", th);     // Catch: Throwable -> L162
        if (r114 == null) goto L161;
    L160:
        r114.close();     // Catch: Throwable -> L168
    L161:
        r27 = r33;
        r5 = r113;
        r8 = r111;
        r11 = r215;
        r17 = r112;
        goto L199
    L162:
        th = move-exception;
        if (r114 == null) goto L261;
        r114.close();     // Catch: Throwable -> L168
        throw th;     // Catch: Throwable -> L168
    L261:
        throw th;     // Catch: Throwable -> L168
    L126:
        r215 = r11;
        goto L127
    L121:
        r213 = null;
    L128:
        th = th;
    L129:
        r215 = r11;
    L130:
        th = th;
        r114 = r44;
    L132:
        th = th;
        r114 = r44;
        r215 = r11;
        r112 = r17;
        r113 = r5;
        goto L233
    L134:
        r114 = r44;
        r215 = r11;
        r112 = r17;
        r113 = r5;
        if (r19.containsKey(r43) == false) goto L193;
        List r51 = (List) r19.get(r43);     // Catch: Throwable -> L149
        if (r51 == null) goto L160;
        r51.add(r42);     // Catch: Throwable -> L149
        goto L160
    L193:
        n[] r52 = new n[1];     // Catch: Throwable -> L147
        r52[0] = r42;     // Catch: Throwable -> L145
        r19.put(r43, CollectionsKt.mutableListOf(r52));     // Catch: Throwable -> L145
    L145:
        th = th;
    L147:
        th = th;
    L151:
        th = th;
        r114 = r44;
        r215 = r11;
        r112 = r17;
        r113 = r5;
    L153:
        th = th;
        r215 = r11;
        r112 = r17;
        r113 = r5;
        r114 = null;
        goto L233
    L103:
        r310 = false;
        goto L104
    L99:
        r110 = false;
        goto L100
    L167:
        r22.close();
    L170:
        th = th;
        goto L191
    L183:
        return;
    L184:
        th = move-exception;
        if (r3 == null) goto L264;
        r3.close();
        throw th;
    L264:
        throw th;
    L7:
        if (r3.moveToNext() == false) goto L67;
        String r53 = r3.getString(r3.getColumnIndex(r15));     // Catch: Throwable -> L68
        r27 = r15;
        String r216 = r3.getString(r3.getColumnIndex("panel"));     // Catch: Throwable -> L65
        String r311 = r3.getString(r3.getColumnIndex("effect_id"));     // Catch: Throwable -> L65
        String r312 = r3.getString(r3.getColumnIndex("resource_id"));     // Catch: Throwable -> L65
        String r313 = r3.getString(r3.getColumnIndex("path"));     // Catch: Throwable -> L65
        long r314 = r3.getLong(r3.getColumnIndex("update_time"));     // Catch: Throwable -> L65
        r37 = r9;
        if (r3.getInt(r3.getColumnIndex(r9)) != 1) goto L14;
        boolean r116 = true;
    L223:
        r38 = r3;
        if (r3.getInt(r3.getColumnIndex("is_high_cost")) != 1) goto L19;
        boolean r315 = true;
    L221:
        n r54 = new n(r216, r311, r312, r313, false, r315, r314);     // Catch: Throwable -> L61
        r54.j = r116;     // Catch: Throwable -> L61
        Cursor r55 = r24.query("live_composer_tag_node", null, "node_id=?", new String[]{r53}, null, null, null);     // Catch: Throwable -> L48
    L203:
    L45:
        th = th;
        r17 = r4;
        r55 = r55;
    L47:
        Cursor r56 = r55;
    L205:
        ALogger.e("LiveComposerSQLiteHelper", th);     // Catch: Throwable -> L56
        if (r56 == null) goto L55;
    L235:
        r56.close();     // Catch: Throwable -> L53
    L55:
        r4 = r17;
        r15 = r27;
        r9 = r37;
        r3 = r38;
        goto L213
    L56:
        th = move-exception;
        if (r56 == null) goto L260;
        r56.close();     // Catch: Throwable -> L53
        throw th;     // Catch: Throwable -> L53
    L260:
        throw th;     // Catch: Throwable -> L53
    L53:
        th = th;
        goto L70
    L23:
        if (r55.moveToNext() == false) goto L41;
        String r57 = r55.getString(r55.getColumnIndex("tag"));     // Catch: Throwable -> L45
        float r117 = r55.getFloat(r55.getColumnIndex(r4));     // Catch: Throwable -> L45
        r55 = r55;
        Iterator r58 = ((ArrayList) r54.i).iterator();     // Catch: Throwable -> L39
    L28:
        if (r58.hasNext() == false) goto L33;
        Object r118 = r58.next();     // Catch: Throwable -> L39
        Iterator r119 = r58;
        if (Intrinsics.areEqual(((p) r118).b, r57) == true) goto L34;
        r58 = r119;
    L34:
        if (r118 != null) goto L203;
        List<p> r59 = r54.i;     // Catch: Throwable -> L39
        r17 = r4;
        p r61 = new p(r57);     // Catch: Throwable -> L43
        r61.a = Float.valueOf(r117);     // Catch: Throwable -> L43
        Unit r62 = Unit.INSTANCE;     // Catch: Throwable -> L43
        ((ArrayList) r59).add(r61);     // Catch: Throwable -> L43
        r4 = r17;
    L43:
        th = th;
        goto L47
    L33:
        r118 = null;
    L39:
        th = th;
        r17 = r4;
        goto L47
    L41:
        r17 = r4;
        Cursor r120 = r55;
        r7.add(r54);     // Catch: Throwable -> L43
        r56 = r120;
    L48:
        th = th;
        r17 = r4;
        r56 = null;
    L61:
        th = th;
    L62:
        r17 = r4;
        goto L70
    L19:
        r315 = false;
    L63:
        th = th;
        r38 = r3;
        goto L62
    L14:
        r116 = false;
    L65:
        th = th;
        r38 = r3;
        r17 = r4;
        r37 = r9;
        goto L70
    L67:
        r17 = r4;
        r37 = r9;
        r27 = r15;
    L71:
        th = th;
        r17 = "value";
        r37 = "use";
        r27 = "id";
        r3 = null;
        goto L215
    }

    public static boolean k0(com.bytedance.android.live.effect.base.e r1) {
        if (LiveEffectSettings.LIVE_EFFECT_REPORT_FIRST_FRAME_RENDER_LOG.getValue().booleanValue() == false) goto L8;
        if (r1 == null) goto L8;
        if (Intrinsics.areEqual(r1.c, d0.c) == false) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void A(LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.w).remove(r2);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final boolean B(Sticker r8) {
        Intrinsics.checkNotNullParameter(r8, "sticker");
        Effect r0 = r8.getEffect();
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L20;
        List r9 = r8.getSubStickers();
        if (r9 != null) goto L14;
        r9 = CollectionsKt.emptyList();
    L14:
        Iterator r11 = r9.iterator();
    L16:
        if (r11.hasNext() == false) goto L45;
        if (B((Sticker) r11.next()) == false) goto L16;
        return true;
    L45:
        return false;
    L20:
        List r2 = r8.getComposerConfigList();
        Iterator<T> r3 = this.e.iterator();
    L22:
        if (r3.hasNext() == false) goto L26;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((n) r4).b, r8.getEffectId()) == false) goto L22;
    L27:
        n r5 = (n) r4;
        if (r5 == null) goto L45;
        if (r5.j != true) goto L45;
        if (r2.isEmpty() == false) goto L35;
        return true;
    L35:
        Iterator r6 = r2.iterator();
    L37:
        if (r6.hasNext() == false) goto L45;
        Sticker.ComposerConfig r7 = (Sticker.ComposerConfig) r6.next();
        Float r12 = G(r8.getEffectId(), r7.getTag());
        if (r12 == null) goto L41;
        float r13 = r12.floatValue();
    L43:
        if (r13 == 0.0f) goto L37;
        return true;
    L41:
        r13 = 0.0f;
        goto L43
    L26:
        r4 = null;
        goto L27
    L5:
        if (r0.getEffectType() != 1) goto L9;
        if (CollectionUtils.isEmpty(r8.getSubStickers()) == true) goto L9;
        r1 = true;
        goto L10
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final boolean E(Sticker r8) {
        Intrinsics.checkNotNullParameter(r8, "sticker");
        Effect r0 = r8.getEffect();
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L20;
        List r9 = r8.getSubStickers();
        if (r9 != null) goto L14;
        r9 = CollectionsKt.emptyList();
    L14:
        Iterator r11 = r9.iterator();
    L16:
        if (r11.hasNext() == false) goto L45;
        if (E((Sticker) r11.next()) == false) goto L16;
        return true;
    L45:
        return false;
    L20:
        List r2 = r8.getComposerConfigList();
        Iterator<T> r3 = this.f.iterator();
    L22:
        if (r3.hasNext() == false) goto L26;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((n) r4).b, r8.getEffectId()) == false) goto L22;
    L27:
        n r5 = (n) r4;
        if (r5 == null) goto L45;
        if (r5.j != true) goto L45;
        if (r2.isEmpty() == false) goto L35;
        return true;
    L35:
        Iterator r6 = r2.iterator();
    L37:
        if (r6.hasNext() == false) goto L45;
        Sticker.ComposerConfig r7 = (Sticker.ComposerConfig) r6.next();
        Float r12 = G(r8.getEffectId(), r7.getTag());
        if (r12 == null) goto L41;
        float r13 = r12.floatValue();
    L43:
        if (r13 == 0.0f) goto L37;
        return true;
    L41:
        r13 = 0.0f;
        goto L43
    L26:
        r4 = null;
        goto L27
    L5:
        if (r0.getEffectType() != 1) goto L9;
        if (CollectionUtils.isEmpty(r8.getSubStickers()) == true) goto L9;
        r1 = true;
        goto L10
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void F(boolean r4) {
        ALogger.i("ttlive_anchor_effect_LiveComposerManagerB", "setNoCameraRender " + r4 + " null");
        StringBuilder r0 = new StringBuilder("setNoCameraRender useBlack = ");
        r0.append(r4);
        r0.append(", composeHandler is not init");
        ALogger.i("ttlive_anchor_effect_LiveComposerManagerB", r0.toString());
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void K(ILiveEffectComposerManager.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.d).remove(r2);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void L(String r5) {
        Intrinsics.checkNotNullParameter(r5, "newModeKey");
        m90.c<android.util.Pair<String, String>> r0 = m90.b.F;
        if (Intrinsics.areEqual((String) r0.c(this.G).first, r5) == false) goto L5;
        return;
    L5:
        Map<String, List<n>> r1 = this.k;
        String r2 = (String) r0.c(this.G).first;
        ArrayList r3 = new ArrayList();
        r3.addAll(this.e);
        Unit r4 = Unit.INSTANCE;
        r1.put(r2, r3);
        this.j.clear();
        List r6 = (List) ((LinkedHashMap) this.k).get(r5);
        if (r6 == null) goto L9;
        this.j.addAll(r6);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final Map<Long, String> N(String r3) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        k r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "panel");
        Map<Long, String> r4 = (Map) ((HashMap) r1.c).get(r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final int U(String r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        return this.b.a(r2);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void V(ILiveEffectComposerManager.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((CopyOnWriteArrayList) this.c).contains(r2) == true) goto L6;
        ((CopyOnWriteArrayList) this.c).add(r2);
        return;
    }

    public final void Y(List<Sticker> r5) {
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Sticker r0 = (Sticker) r6.next();
        Map<String, List<Sticker>> r1 = this.n;
        String r2 = d0.j;
        if (((HashMap) r1).containsKey(r2) == true) goto L8;
        Map<String, List<Sticker>> r3 = this.n;
        HashMap r4 = (HashMap) r3;
        r4.put(r2, new ArrayList());
    L8:
        List r7 = (List) ((HashMap) this.n).get(r2);
        if (r7 == null) goto L4;
        if (r7.contains(r0) == true) goto L4;
        r7.add(r0);
        goto L4
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void f(LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        long r0 = this.x;
        if (r0 == 0) goto L6;
        r6.a(r0, this.y);
    L6:
        if (((ArrayList) this.w).contains(r6) == true) goto L9;
        ((ArrayList) this.w).add(r6);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void g(ILiveEffectComposerManager.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((CopyOnWriteArrayList) this.c).remove(r2);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void l(ILiveEffectComposerManager.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.d).contains(r2) == true) goto L6;
        ((ArrayList) this.d).add(r2);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final List<Sticker> o(String r8) {
        Intrinsics.checkNotNullParameter(r8, "panel");
        HashMap r0 = new HashMap();
        if (((HashMap) this.n).containsKey(r8) == false) goto L5;
        List<n> r1 = this.e;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        Object r4 = r3.next();
        n r5 = (n) r4;
        if (Intrinsics.areEqual(r5.a, r8) == false) goto L16;
        Map<String, List<Sticker>> r6 = this.n;
        HashMap r7 = (HashMap) r6;
        if (r7.containsKey(r5.a) == false) goto L16;
        if (r5.j == false) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L8;
        r2.add(r4);
    L16:
        r9 = false;
        goto L17
    L19:
        Iterator r11 = r2.iterator();
    L21:
        if (r11.hasNext() == false) goto L37;
        n r12 = (n) r11.next();
        if (r0.containsKey(r12.b) == true) goto L21;
        List r13 = (List) ((HashMap) this.n).get(r8);
        if (r13 == null) goto L21;
        Iterator r14 = r13.iterator();
    L28:
        if (r14.hasNext() == false) goto L32;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((Sticker) r15).getEffectId(), r12.b) == false) goto L28;
    L33:
        Sticker r16 = (Sticker) r15;
        if (r16 == null) goto L21;
        r0.put(r16.getEffectId(), r16);
        goto L21
    L32:
        r15 = null;
        goto L33
    L37:
        return CollectionsKt.toList(r0.values());
    L5:
        return CollectionsKt.toList(r0.values());
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void r(BroadcastKtvEffectMusicWidget.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((List) this.C.getValue()).contains(r2) == true) goto L6;
        ((List) this.C.getValue()).add(r2);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void x(String r4) {
        Intrinsics.checkNotNullParameter(r4, "trace");
        l0(true, "refresh_area", r4, null);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void y(com.bytedance.android.live.effect.sticker.presenter.q.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.B).add(r2);
    }

    public static ArrayList e0(Sticker r12, List r13) {
        ArrayList r0 = new ArrayList();
        r0.addAll(r13);
        List r14 = r12.getComposerConfigList();
        ArrayList r1 = new ArrayList();
        Iterator r15 = r14.iterator();
    L3:
        boolean r3 = false;
        Object r5 = null;
        if (r15.hasNext() == false) goto L20;
        Object r2 = r15.next();
        Sticker.ComposerConfig r6 = (Sticker.ComposerConfig) r2;
        Iterator r7 = r0.iterator();
    L7:
        if (r7.hasNext() == false) goto L16;
        Object r8 = r7.next();
        p r9 = (p) r8;
        if (Intrinsics.areEqual(r9.b, r6.getTag()) == true) goto L11;
    L13:
        boolean r11 = false;
    L14:
        if (r11 == false) goto L7;
        r5 = r8;
        goto L16
    L11:
        if (r9.a == null) goto L13;
        r11 = true;
    L16:
        if (r5 != null) goto L18;
        r3 = true;
    L18:
        if (r3 == false) goto L3;
        r1.add(r2);
        goto L3
    L20:
        Iterator r16 = r1.iterator();
    L22:
        if (r16.hasNext() == false) goto L30;
        Sticker.ComposerConfig r4 = (Sticker.ComposerConfig) r16.next();
        Iterator r17 = r0.iterator();
    L25:
        if (r17.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((p) r17.next()).b, r4.getTag()) == false) goto L25;
        r17.remove();
        goto L25
    L29:
        p r18 = new p(r4.getTag());
        r18.a = Float.valueOf(com.bytedance.android.live.effect.q.c(r4, r4.getDefaultValue()));
        Unit r19 = Unit.INSTANCE;
        r0.add(r18);
        goto L22
    L30:
        ArrayList r110 = r12.getUpdateKeys();
        ArrayList r111 = new ArrayList();
        Iterator r112 = r110.iterator();
    L32:
        if (r112.hasNext() == false) goto L45;
        Object r21 = r112.next();
        String r22 = (String) r21;
        Iterator r23 = r0.iterator();
    L35:
        if (r23.hasNext() == false) goto L39;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((p) r24).b, r22) == false) goto L35;
    L40:
        if (r24 != null) goto L42;
        boolean r25 = true;
    L43:
        if (r25 == false) goto L32;
        r111.add(r21);
        goto L32
    L42:
        r25 = false;
        goto L43
    L39:
        r24 = null;
        goto L40
    L45:
        Iterator r113 = r111.iterator();
    L47:
        if (r113.hasNext() == false) goto L49;
        r0.add(new p((String) r113.next()));
        goto L47
    L49:
        return r0;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final Float G(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "effectId");
        Intrinsics.checkNotNullParameter(r6, "tag");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((n) r1).b, r5) == false) goto L4;
    L9:
        n r2 = (n) r1;
        if (r2 != null) goto L19;
        Iterator<T> r3 = this.j.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((n) r4).b, r5) == false) goto L13;
    L18:
        r2 = (n) r4;
        goto L19
    L17:
        r4 = null;
    L19:
        if (r2 != null) goto L21;
        return null;
    L21:
        Iterator<T> r7 = r2.i.iterator();
    L23:
        if (r7.hasNext() == false) goto L27;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((p) r8).b, r6) == false) goto L23;
    L28:
        p r9 = (p) r8;
        if (r9 != null) goto L32;
        return null;
    L32:
        return r9.a;
    L27:
        r8 = null;
        goto L28
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void T(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "trace");
        l0(false, "refresh", r4, null);
        if (r5 == false) goto L6;
        MainThreadPostUtils.b(new h(this));
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "trace");
        t(r2, r3, null);
    }

    public final void f0(Map<String, ? extends List<String>> r12, Map<String, ? extends List<String>> r13) {
        if (r12.isEmpty() == true) goto L5;
    L7:
        Iterator r0 = ((LinkedHashMap) this.F).entrySet().iterator();
    L9:
        if (r0.hasNext() == false) goto L60;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        List r3 = (List) r1.getValue();
        List r4 = (List) ((LinkedHashMap) r12).get(r2);
        if (r4 != null) goto L13;
        r4 = CollectionsKt.emptyList();
    L13:
        List r5 = (List) ((LinkedHashMap) r13).get(r2);
        if (r5 != null) goto L17;
        r5 = CollectionsKt.emptyList();
    L17:
        if (r4.isEmpty() == false) goto L21;
        if (r5.isEmpty() == true) goto L9;
    L21:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r4.iterator();
    L22:
        Object r8 = null;
        if (r7.hasNext() == false) goto L35;
        String r9 = (String) r7.next();
        List r11 = (List) ((HashMap) this.n).get(r2);
        if (r11 == null) goto L33;
        Iterator r14 = r11.iterator();
    L28:
        if (r14.hasNext() == false) goto L32;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((Sticker) r15).getEffectId(), r9) == false) goto L28;
        r8 = r15;
    L32:
        r8 = (Sticker) r8;
    L33:
        if (r8 == null) goto L22;
        r6.add(r8);
        goto L22
    L35:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r5.iterator();
    L37:
        if (r17.hasNext() == false) goto L51;
        String r18 = (String) r17.next();
        List r19 = (List) ((HashMap) this.n).get(r2);
        if (r19 == null) goto L48;
        Iterator r21 = r19.iterator();
    L42:
        if (r21.hasNext() == false) goto L46;
        Object r22 = r21.next();
        if (Intrinsics.areEqual(((Sticker) r22).getEffectId(), r18) == false) goto L42;
    L47:
        Sticker r23 = (Sticker) r22;
    L49:
        if (r23 == null) goto L37;
        r16.add(r23);
        goto L37
    L46:
        r22 = null;
        goto L47
    L48:
        r23 = null;
        goto L49
    L51:
        Iterator r24 = r3.iterator();
    L53:
        if (r24.hasNext() == false) goto L9;
        ILiveEffectComposerManager.i r25 = (ILiveEffectComposerManager.i) r24.next();
        if ((!r6.isEmpty()) == false) goto L58;
        r25.a(false, r2, r6);
    L58:
        if ((!r16.isEmpty()) == false) goto L53;
        r25.a(true, r2, r16);
        goto L53
    L60:
        return;
    L5:
        if (r13.isEmpty() == false) goto L7;
    }

    public final int g0(List<n> r7, StringBuilder r8) {
        if ((!r7.isEmpty()) == false) goto L5;
        System.currentTimeMillis();
    L5:
        ((ms1.b) yg.a.getValue()).getClass();
        Map<ILiveEffectComposerManager.EffectInstanceType, String[]> r9 = com.bytedance.android.live.effect.q.e(r7, true).a;
        r8.append(" addComposerNodes [");
        Iterator<Map.Entry<ILiveEffectComposerManager.EffectInstanceType, String[]>> r11 = r9.entrySet().iterator();
        int r0 = 0;
    L7:
        if (r11.hasNext() == false) goto L15;
        Map.Entry<ILiveEffectComposerManager.EffectInstanceType, String[]> r2 = r11.next();
        ILiveEffectComposerManager.EffectInstanceType r3 = r2.getKey();
        String[] r4 = r2.getValue();
        if (r4.length != 0) goto L11;
        boolean r5 = true;
    L13:
        if ((!r5) == false) goto L7;
        r0 = r0 - 1;
        r8.append(", " + r3 + ": size_" + r4.length + " result_-1 ,");
        goto L7
    L11:
        r5 = false;
        goto L13
    L15:
        r8.append(" ];");
        return r0;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void h(String r3, LiveCommonStickerUIViewModel.b r4) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (((LinkedHashMap) this.F).get(r3) != null) goto L5;
        this.F.put(r3, new ArrayList());
    L5:
        List<ILiveEffectComposerManager.i> r0 = (List) ((LinkedHashMap) this.F).get(r3);
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.contains(r4) == true) goto L11;
        r0.add(r4);
    L11:
        this.F.put(r3, r0);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void m(String r2, LiveCommonStickerUIViewModel.b r3) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "listener");
        List r4 = (List) ((LinkedHashMap) this.F).get(r2);
        if (r4 == null) goto L6;
        r4.remove(r3);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void w(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "panel");
        Intrinsics.checkNotNullParameter(r6, "effectId");
        Intrinsics.checkNotNullParameter("WishFinishGestureWidget_removeGesture", "trace");
        Intrinsics.checkNotNullParameter(r5, "panel");
        Intrinsics.checkNotNullParameter(r6, "effectId");
        Intrinsics.checkNotNullParameter("WishFinishGestureWidget_removeGesture", "trace");
        Iterator<T> r0 = o(r5).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Sticker r1 = (Sticker) r0.next();
        if (Intrinsics.areEqual(r1.getEffectId(), r6) == false) goto L4;
        j0(r5, r1, "WishFinishGestureWidget_removeGesture");
        goto L4
    }

    public static /* synthetic */ int a0(LiveComposerManagerB r1, List r2, StringBuilder r3) {
        return r1.Z(r2, r3, false);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void O(String r2, Sticker r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "sticker");
        Intrinsics.checkNotNullParameter(r4, "trace");
        j0(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void S(String r8, Sticker r9, Sticker r11) {
        Intrinsics.checkNotNullParameter(r8, "panel");
        Intrinsics.checkNotNullParameter("EffectLiveBroadcastActivityProxy_changeSelectSticker_select", "trace");
        ILiveEffectComposerManager.f.c(this, r8, r9, r11, "EffectLiveBroadcastActivityProxy_changeSelectSticker_select", null, null);
    }

    public final int Z(List<n> r21, StringBuilder r22, boolean r23) {
        ((ms1.b) yg.a.getValue()).getClass();
        Map<ILiveEffectComposerManager.EffectInstanceType, String[]> r4 = com.bytedance.android.live.effect.q.e(r21, false).a;
        r22.append(" addComposerNodes [");
        Iterator<Map.Entry<ILiveEffectComposerManager.EffectInstanceType, String[]>> r5 = r4.entrySet().iterator();
        int r6 = 0;
    L3:
        boolean r8 = true;
        if (r5.hasNext() == false) goto L57;
        Map.Entry<ILiveEffectComposerManager.EffectInstanceType, String[]> r7 = r5.next();
        ILiveEffectComposerManager.EffectInstanceType r9 = r7.getKey();
        String[] r11 = r7.getValue();
        if (r11.length != 0) goto L8;
        boolean r12 = true;
    L10:
        if ((true ^ r12) == true) goto L12;
        Iterator<Map.Entry<ILiveEffectComposerManager.EffectInstanceType, String[]>> r19 = r5;
    L56:
        r5 = r19;
        goto L3
    L12:
        if (r23 == true) goto L14;
    L24:
        int r13 = com.bytedance.android.live.effect.q.a;
        Map<String, List<Sticker>> r14 = this.n;
        Intrinsics.checkNotNullParameter(r14, "allSticker");
        Intrinsics.checkNotNullParameter(r11, "pathList");
        ArrayList r15 = new ArrayList(r11.length);
        int r16 = r11.length;
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L49;
        String r18 = r11[r17];
        Iterator r110 = ((HashMap) r14).values().iterator();
    L28:
        if (r110.hasNext() == false) goto L46;
        List r111 = (List) r110.next();
        if (r111 == null) goto L40;
        Iterator r112 = r111.iterator();
    L33:
        if (r112.hasNext() == false) goto L38;
        Object r113 = r112.next();
        Iterator<Map.Entry<ILiveEffectComposerManager.EffectInstanceType, String[]>> r114 = r5;
        Map<String, List<Sticker>> r115 = r14;
        if (StringsKt.startsWith$default(r18, ((Sticker) r113).getUnzipPath(), false, 2, null) == true) goto L39;
        r14 = r115;
        r5 = r114;
    L39:
        Sticker r116 = (Sticker) r113;
    L41:
        if (r116 != null) goto L42;
        r14 = r115;
        r5 = r114;
        goto L28
    L42:
        String r24 = r116.getExtra();
        if (r24 != null) goto L48;
    L47:
        r24 = "";
    L48:
        r15.add(r24);
        r17 = r17 + 1;
        r14 = r115;
        r5 = r114;
        goto L25
    L38:
        r114 = r5;
        r115 = r14;
        r113 = null;
        goto L39
    L40:
        r114 = r5;
        r115 = r14;
        r116 = null;
        goto L41
    L46:
        r114 = r5;
        r115 = r14;
        goto L47
    L49:
        r19 = r5;
        Object[] r25 = r15.toArray(new String[0]);
        if (r25 == null) goto L54;
        ALogger.d("LiveComposerUtils", new s((String[]) r25));
    L52:
        r6 = r6 - 1;
        r22.append(r9 + ": size_" + r11.length + " result_-1 ,");
        goto L56
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L14:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_START_LIVE_RESTORE_OPTIMIZE.getValue().booleanValue() == false) goto L24;
        List<n> r26 = r21;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r27 = r26.iterator();
    L17:
        if (r27.hasNext() == false) goto L19;
        r117.add(((n) r27.next()).k);
        goto L17
    L19:
        Object[] r28 = r117.toArray(new String[0]);
        if (r28 == null) goto L23;
        String[] r29 = (String[]) r28;
        r19 = r5;
        goto L52
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L8:
        r12 = false;
        goto L10
    L57:
        r22.append(" ];");
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r2 = u.a;
        r r3 = u.b(this.G).c();
        r3.getClass();
        String r31 = String.valueOf(null);
        String r32 = r3.c;
        Iterator<n> r33 = r21.iterator();
    L59:
        if (r33.hasNext() == false) goto L69;
        if (Intrinsics.areEqual(r33.next().b, r31) == false) goto L59;
        if (r32.length() <= 0) goto L65;
        boolean r34 = true;
    L66:
        if (r34 == false) goto L59;
        v(new ILiveEffectComposerManager.g(40, OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH, 1000000, r32), ILiveEffectComposerManager.EffectInstanceType.DEFAULT, "EffectLiveBroadcastActivityProxy_initEffect_restart");
        goto L69
    L65:
        r34 = false;
    L69:
        if ((!r21.isEmpty()) == false) goto L78;
        Iterator<T> r1 = r21.iterator();
    L72:
        if (r1.hasNext() == false) goto L76;
        if (((n) r1.next()).a.equals("effect_gift") == true) goto L72;
        r8 = false;
        goto L72
    L76:
        if (r8 == false) goto L78;
        System.currentTimeMillis();
    L78:
        return r6;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void a(String r9, Sticker r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "panel");
        Intrinsics.checkNotNullParameter(r11, "sticker");
        Intrinsics.checkNotNullParameter(r12, "trace");
        I(r9, r11, r12, null, null, ILiveEffectComposerManager.EffectInstanceType.DEFAULT);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void d(String r4, List<? extends Effect> r5, Function1<? super Effect, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r4, "originpanel");
        Intrinsics.checkNotNullParameter(r5, "allSticker");
        Intrinsics.checkNotNullParameter(r6, "isDownload");
        if (Intrinsics.areEqual(r4, d0.e) == false) goto L5;
    L10:
        r4 = d0.c;
    L11:
        LiveComposerManagerB$restoreSaveNode$1 r0 = new LiveComposerManagerB$restoreSaveNode$1(this, r4);
        Logger.w("LiveComposerManagerB", r4 + " start restore");
        if (d0() == true) goto L16;
        Logger.w("LiveComposerManagerB", r4 + " restoring, config is null, return");
        return;
    L16:
        if (new ArrayList().contains(r4) == true) goto L20;
        Logger.w("LiveComposerManagerB", r4 + " restoring, not in savePanelList, return");
        return;
    L20:
        if (this.j.isEmpty() == false) goto L23;
        r0.m740invoke();
        Logger.w("LiveComposerManagerB", r4 + " restoring, saveCurrentComposerNodeList is empty, return");
        return;
    L23:
        new LiveComposerManagerB$restoreSaveNode$2(this, r5, r4, r6);
        Logger.w("LiveComposerManagerB", r4 + " restoring, handler is null, return");
        return;
    L5:
        if (Intrinsics.areEqual(r4, d0.f) == true) goto L10;
        if (Intrinsics.areEqual(r4, d0.l) == false) goto L11;
        r4 = d0.a;
        goto L11
    }

    public final void j0(String r8, Sticker r9, String r11) {
        Intrinsics.checkNotNullParameter(r8, "panel");
        Intrinsics.checkNotNullParameter(r9, "sticker");
        Intrinsics.checkNotNullParameter(r11, "trace");
        i0(r8, r9, true, r11, null, false);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final Disposable s(String r3, String r4, u2.a r5) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        Intrinsics.checkNotNullParameter(r4, "effectId");
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = u.a;
        z r1 = u.b(this.G).b();
        return Observable.create(new com.bytedance.android.live.effect.composer.c(r1, r4, r5)).flatMap(new com.bytedance.android.live.effect.composer.e(this, r1, r5)).observeOn(Schedulers.io()).subscribe(new com.bytedance.android.live.effect.composer.f(this, r3, r5), com.bytedance.android.live.effect.composer.g.a);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void t(String r2, String r3, HashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "trace");
        h0(r2, r3, r4, false);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void v(ILiveEffectComposerManager.g r6, ILiveEffectComposerManager.EffectInstanceType r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        Intrinsics.checkNotNullParameter(r7, "effectInstanceType");
        Intrinsics.checkNotNullParameter(r8, "trace");
        PthreadHandlerThreadV2 r3 = LiveEffectMonitor.a;
        Intrinsics.checkNotNullParameter(r6, "msg");
        Intrinsics.checkNotNullParameter(r7, "effectInstanceType");
        Intrinsics.checkNotNullParameter(r8, "trace");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_SEND_EFFECT_MSG, null, null, 14);
        r0.l(1000);
        r0.i("effectInstanceType", r7.name());
        r0.i("msgType", Integer.valueOf(r6.a));
        r0.i("arg1", Integer.valueOf(r6.b));
        r0.i("arg2", Integer.valueOf(r6.c));
        r0.i("arg3", r6.d);
        r0.i("trace", r8);
        r0.a().report();
    }

    public final void h0(String r11, String r12, HashMap r13, boolean r14) {
        List<n> r0 = this.e;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ArrayList) r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((n) r3).a, r11) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L21;
        n r6 = (n) r5.next();
        Map<String, List<Sticker>> r7 = this.n;
        HashMap r8 = (HashMap) r7;
        List r9 = (List) r8.get(r6.a);
        Object r15 = null;
        if (r9 == null) goto L20;
        Iterator r16 = r9.iterator();
    L15:
        if (r16.hasNext() == false) goto L19;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((Sticker) r17).getEffectId(), r6.b) == false) goto L15;
        r15 = r17;
    L19:
        r15 = (Sticker) r15;
    L20:
        r4.add(r15);
        goto L10
    L21:
        Iterator r18 = r4.iterator();
    L23:
        if (r18.hasNext() == false) goto L27;
        Sticker r19 = (Sticker) r18.next();
        if (r19 == null) goto L23;
        i0(r11, r19, true, r12, r13, r14);
        goto L23
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void k(String r2, String r3, HashMap<String, String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "trace");
        h0(r2, r3, r4, r5);
    }

    public final synchronized void l0(boolean r23, String r24, String r25, com.bytedance.android.live.effect.base.e r26) {
        monitor-enter(this);
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L202
        ALogger.d("ttlive_anchor_effect_LiveComposerManagerB", "show sticker: " + ThreadMethodProxy.currentThread());     // Catch: Throwable -> L202
        if (k0(r26) == false) goto L25;
        if (r26 != null) goto L8;
    L17:
        q r0 = this.u;     // Catch: Throwable -> L202
        if (r0 == null) goto L23;
        Disposable r2 = r0.a;     // Catch: Throwable -> L202
        if (r2 == null) goto L22;
        r2.dispose();     // Catch: Throwable -> L202
    L22:
        r0.b = true;     // Catch: Throwable -> L202
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L202
    L23:
        this.u = null;     // Catch: Throwable -> L202
        goto L25
    L8:
        if (r26.a() != true) goto L17;
        q r3 = this.u;     // Catch: Throwable -> L202
        if (r3 != null) goto L12;
    L16:
        this.u = new q(this.v, r26, r24, r25, r8.toString(), "live_take_detail");     // Catch: Throwable -> L202
        goto L25
    L12:
        if (r3.a() != true) goto L16;
        q r4 = this.u;     // Catch: Throwable -> L202
        if (r4 == null) goto L16;
        r4.c(System.currentTimeMillis());     // Catch: Throwable -> L202
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L202
    L25:
        if (d0() == true) goto L38;
        PthreadHandlerThreadV2 r6 = LiveEffectMonitor.a;     // Catch: Throwable -> L202
        if ((!((Boolean) pb.a.getValue()).booleanValue()) == true) goto L31;
        GsonProtectorUtils.toJson(GsonHelper.get(), this.f);     // Catch: Throwable -> L202
    L31:
        if (k0(r26) == false) goto L35;
        q r7 = this.u;     // Catch: Throwable -> L202
        if (r7 == null) goto L36;
        r7.d();     // Catch: Throwable -> L202
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L202
    L36:
        monitor-exit(this);
        return;
    L35:
        LiveEffectMonitor.n(r24, r25, 100, "[]", "[]", "[]", "config_not_initialized", r8.toString());     // Catch: Throwable -> L202
        goto L36
    L38:
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L202
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L202
        new ArrayList();     // Catch: Throwable -> L202
        ILiveEffectComposerManager.EffectInstanceType r13 = ILiveEffectComposerManager.EffectInstanceType.DEFAULT;     // Catch: Throwable -> L202
        Boolean r14 = Boolean.FALSE;     // Catch: Throwable -> L202
        Map r15 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r13, r14), TuplesKt.to(ILiveEffectComposerManager.EffectInstanceType.RENDER_FILTER, r14)});     // Catch: Throwable -> L202
        Map<String, ? extends List<String>> r16 = new LinkedHashMap();     // Catch: Throwable -> L202
        Map<String, ? extends List<String>> r17 = new LinkedHashMap();     // Catch: Throwable -> L202
        Boolean r18 = LiveEffectSettings.LIVE_ANCHOR_REPEL_NO_CAMERA_OPT.getValue();     // Catch: Throwable -> L202
        r8.append("panel coexist compute start;");     // Catch: Throwable -> L202
        r8.append("panel coexist compute finish, showStickerList: " + GsonProtectorUtils.toJson(GsonHelper.get(), r12) + ';');     // Catch: Throwable -> L202
        if (r23 == false) goto L41;
    L49:
        ArrayList<n> r19 = this.g;     // Catch: Throwable -> L202
        if ((r19 instanceof Collection) == true) goto L52;
    L54:
        Iterator<n> r21 = r19.iterator();     // Catch: Throwable -> L202
    L56:
        if (r21.hasNext() == false) goto L59;
        if (Intrinsics.areEqual(r21.next().b(), d0.c) == false) goto L56;
    L59:
        ((ArrayList) this.f).clear();     // Catch: Throwable -> L202
        ((ArrayList) this.f).addAll(r11);     // Catch: Throwable -> L202
        Iterator r22 = r15.entrySet().iterator();     // Catch: Throwable -> L202
    L61:
        if (r22.hasNext() == false) goto L63;
        Map.Entry r27 = (Map.Entry) r22.next();     // Catch: Throwable -> L202
        ILiveEffectComposerManager.EffectInstanceType r28 = (ILiveEffectComposerManager.EffectInstanceType) r27.getKey();     // Catch: Throwable -> L202
        ((Boolean) r27.getValue()).booleanValue();     // Catch: Throwable -> L202
        goto L61
    L63:
        int r29 = com.bytedance.android.live.effect.q.a;     // Catch: Throwable -> L202
        if (Intrinsics.areEqual(((w1) ul.a.getValue()).b(), Boolean.TRUE) == true) goto L66;
    L68:
        List<n> r31 = this.f;     // Catch: Throwable -> L202
    L69:
        List<n> r32 = com.bytedance.android.live.effect.q.f(r31);     // Catch: Throwable -> L202
        Iterator r33 = ((CopyOnWriteArrayList) this.c).iterator();     // Catch: Throwable -> L202
    L71:
        if (r33.hasNext() == false) goto L75;
        ILiveEffectComposerManager.d r34 = (ILiveEffectComposerManager.d) r33.next();     // Catch: Throwable -> L202
        if ((r34 instanceof ILiveEffectComposerManager.k) == false) goto L71;
        ((ILiveEffectComposerManager.k) r34).c(r32, this.n);     // Catch: Throwable -> L202
        goto L71
    L75:
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L202
        ArrayList r35 = (ArrayList) r32;     // Catch: Throwable -> L202
        Iterator r36 = r35.iterator();     // Catch: Throwable -> L202
    L77:
        if (r36.hasNext() == false) goto L114;
        Object r37 = r36.next();     // Catch: Throwable -> L202
        n r111 = (n) r37;     // Catch: Throwable -> L202
        Iterator<n> r112 = this.g.iterator();     // Catch: Throwable -> L202
    L80:
        if (r112.hasNext() == false) goto L90;
        n r113 = r112.next();     // Catch: Throwable -> L202
        n r114 = r113;     // Catch: Throwable -> L202
        if (Intrinsics.areEqual(r114.a(), r111.a()) == true) goto L84;
    L86:
        boolean r38 = false;
    L87:
        if (r38 == false) goto L80;
    L91:
        if (r113 != null) goto L93;
        boolean r39 = true;
    L95:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_ZERO_VALUE_RESOURCE_OPTIMIZE.getValue().booleanValue() == false) goto L111;
        if (r39 == true) goto L98;
    L110:
        r39 = false;
        goto L111
    L98:
        if (this.E.contains(r111.b()) == true) goto L100;
    L109:
        r39 = true;
        goto L111
    L100:
        if (r111.c().isEmpty() == true) goto L109;
        Iterator<T> r41 = r111.c().iterator();     // Catch: Throwable -> L202
    L103:
        if (r41.hasNext() == false) goto L107;
        Object r115 = r41.next();     // Catch: Throwable -> L202
        if ((!Intrinsics.areEqual(((p) r115).a(), 0.0f)) == false) goto L103;
    L108:
        if (r115 == null) goto L110;
    L107:
        r115 = null;
    L111:
        if (r39 == false) goto L77;
        r110.add(r37);     // Catch: Throwable -> L202
        goto L77
    L93:
        r39 = false;
        goto L95
    L84:
        if (r114.d() != r111.d()) goto L86;
        r38 = true;
        goto L87
    L90:
        r113 = null;
        goto L91
    L114:
        Ref.IntRef r42 = new Ref.IntRef();     // Catch: Throwable -> L202
        r42.element = 0;     // Catch: Throwable -> L202
        int r43 = a0(this, r110, r8);     // Catch: Throwable -> L202
        r42.element += r43;     // Catch: Throwable -> L202
        r8.append("all addComposerNodes result: " + r43 + ';');     // Catch: Throwable -> L202
        if (k0(r26) == false) goto L122;
        if (r26 == null) goto L122;
        if (r26.a() != true) goto L122;
        q r44 = this.u;     // Catch: Throwable -> L202
        if (r44 == null) goto L122;
        r44.b();     // Catch: Throwable -> L202
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L202
    L122:
        ArrayList<n> r46 = this.g;     // Catch: Throwable -> L202
        ArrayList r116 = new ArrayList();     // Catch: Throwable -> L202
        Iterator<n> r47 = r46.iterator();     // Catch: Throwable -> L202
    L124:
        if (r47.hasNext() == false) goto L181;
        n r48 = r47.next();     // Catch: Throwable -> L202
        n r49 = r48;     // Catch: Throwable -> L202
        Iterator r117 = r35.iterator();     // Catch: Throwable -> L202
    L127:
        if (r117.hasNext() == false) goto L131;
        Object r118 = r117.next();     // Catch: Throwable -> L202
        if (Intrinsics.areEqual(r49.a(), ((n) r118).a()) == false) goto L127;
    L132:
        if (r118 != null) goto L134;
        boolean r119 = true;
    L135:
        Iterator r120 = r35.iterator();     // Catch: Throwable -> L202
    L137:
        if (r120.hasNext() == false) goto L163;
        Object r121 = r120.next();     // Catch: Throwable -> L202
        n r122 = (n) r121;     // Catch: Throwable -> L202
        ArrayList r210 = r35;
        Iterator<n> r123 = r47;
        if (Intrinsics.areEqual(r49.a(), r122.a()) == false) goto L159;
        Iterator r51 = r122.c().iterator();     // Catch: Throwable -> L202
    L142:
        if (r51.hasNext() == false) goto L147;
        Object r52 = r51.next();     // Catch: Throwable -> L202
        Iterator r124 = r51;
        if ((!Intrinsics.areEqual(((p) r52).a(), 0.0f)) == true) goto L148;
        r51 = r124;
    L148:
        if (r52 != null) goto L159;
        Iterator r53 = r49.c().iterator();     // Catch: Throwable -> L202
    L151:
        if (r53.hasNext() == false) goto L156;
        Object r54 = r53.next();     // Catch: Throwable -> L202
        Iterator r125 = r53;
        if ((!Intrinsics.areEqual(((p) r54).a(), 0.0f)) == true) goto L157;
        r53 = r125;
    L157:
        if (r54 == null) goto L159;
        boolean r55 = true;
    L160:
        if (r55 == true) goto L164;
        r35 = r210;
        r47 = r123;
    L164:
        if (r121 != null) goto L166;
    L170:
        boolean r56 = false;
    L172:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_ZERO_VALUE_RESOURCE_OPTIMIZE.getValue().booleanValue() == false) goto L178;
        if (r119 == true) goto L177;
        if (r56 == true) goto L177;
        r119 = false;
    L177:
        r119 = true;
    L178:
        if (r119 == false) goto L180;
        r116.add(r48);     // Catch: Throwable -> L202
    L180:
        r35 = r210;
        r47 = r123;
        goto L124
    L166:
        if (this.E.contains(r49.b()) == false) goto L170;
        if ((!r49.c().isEmpty()) == false) goto L170;
        r56 = true;
        goto L172
    L156:
        r54 = null;
        goto L157
    L147:
        r52 = null;
    L159:
        r55 = false;
        goto L160
    L163:
        r210 = r35;
        r123 = r47;
        r121 = null;
        goto L164
    L134:
        r119 = false;
        goto L135
    L131:
        r118 = null;
        goto L132
    L181:
        r42.element += g0(r116, r8);     // Catch: Throwable -> L202
        this.g.clear();     // Catch: Throwable -> L202
        Iterator r57 = ((ArrayList) r32).iterator();     // Catch: Throwable -> L202
    L183:
        if (r57.hasNext() == false) goto L186;
        this.g.add(new n((n) r57.next()));     // Catch: Throwable -> L202
        goto L183
    L186:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_REPEL_STATUS_CHANGE_NOTIFY.getValue().booleanValue() == false) goto L188;
        f0(r16, r17);     // Catch: Throwable -> L202
    L188:
        LiveComposerManagerB$showSticker$2 r58 = new LiveComposerManagerB$showSticker$2(this, r24, r25, r42, r110, r116, r8);     // Catch: Throwable -> L202
        if (Intrinsics.areEqual(r24, "update_sticker_value") == false) goto L194;
        if ((!r110.isEmpty()) == false) goto L194;
        this.q.add(Observable.timer(LiveEffectSettings.LIVE_ANCHOR_UPDATE_TAG_VALUE_CLUSTER_TIME.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r58)));     // Catch: Throwable -> L202
    L200:
        monitor-exit(this);
        return;
    L194:
        if (k0(r26) == true) goto L200;
        if ((!r110.isEmpty()) == false) goto L198;
    L199:
        r58.m742invoke();     // Catch: Throwable -> L202
        goto L200
    L198:
        if ((!r116.isEmpty()) == false) goto L200;
    L66:
        if (m90.b.D.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).booleanValue() == false) goto L68;
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r59 = u.a;     // Catch: Throwable -> L202
        Y(u.b(this.G).d().d());     // Catch: Throwable -> L202
        r31 = u.b(this.G).d().c(this.f);     // Catch: Throwable -> L202
        goto L69
    L52:
        if (r19.isEmpty() == false) goto L54;
    L41:
        if (this.f.containsAll(r11) == false) goto L49;
        if (r11.containsAll(this.f) == false) goto L49;
        PthreadHandlerThreadV2 r61 = LiveEffectMonitor.a;     // Catch: Throwable -> L202
        if ((!((Boolean) pb.a.getValue()).booleanValue()) == true) goto L47;
        LiveEffectMonitor.n(r24, r25, 0, "[]", "[]", "[]", "show_list_not_change", r8.toString());     // Catch: Throwable -> L202
    L47:
        monitor-exit(this);
        return;
    L202:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void J(String r11, Sticker r12, String r13, float r14, ILiveEffectComposerManager.EffectInstanceType r15) {
        Intrinsics.checkNotNullParameter(r11, "panel");
        Intrinsics.checkNotNullParameter(r12, "sticker");
        Intrinsics.checkNotNullParameter(r13, "tag");
        Intrinsics.checkNotNullParameter(r15, "effectInstanceType");
        m0(this, r11, r12, r13, r14, r15, null, null, 128);
    }

    public static final void X(LiveComposerManagerB r5, String r6, Effect r7, String r8, List r9, Function1 r11) {
        r5.getClass();
        LiveComposerManagerB$restoreEffect$1 r0 = new LiveComposerManagerB$restoreEffect$1(r5, r8, r6);
        Iterator<n> r12 = r5.j.iterator();
    L4:
        if (r12.hasNext() == false) goto L26;
        n r1 = r12.next();
        n r2 = r1;
        if (((Boolean) r11.invoke(r7)).booleanValue() == true) goto L18;
        if (Intrinsics.areEqual(r2.c, r7.getResourceId()) == false) goto L10;
    L11:
        r5.l.add(new Pair(r2, r9));
        if (r2.j == false) goto L23;
        CopyOnWriteArrayList<String> r3 = r5.m.get(r6);
        if (r3 != null) goto L16;
        r3 = new CopyOnWriteArrayList();
    L16:
        r3.add(r2.c);
        r5.m.put(r6, r3);
    L23:
        boolean r4 = false;
    L24:
        if (r4 == false) goto L4;
    L27:
        n r13 = r1;
        if (r13 == null) goto L36;
        Sticker r14 = com.bytedance.android.live.effect.sticker.d.b(r7);
        AndroidSchedulers.mainThread().scheduleDirect(new i(r14, r13, r0));
        return;
    L36:
        return;
    L10:
        if (r9.contains(r2.b) == false) goto L23;
    L18:
        if (Intrinsics.areEqual(r2.c, r7.getResourceId()) == false) goto L21;
    L22:
        r4 = true;
        goto L24
    L21:
        if (r9.contains(r2.b) == false) goto L23;
    L26:
        r1 = null;
        goto L27
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void C(String r11, Sticker r12, String r13, float r14, ILiveEffectComposerManager.EffectInstanceType r15, HashMap<String, String> r16) {
        Intrinsics.checkNotNullParameter(r11, "panel");
        Intrinsics.checkNotNullParameter(r12, "sticker");
        Intrinsics.checkNotNullParameter(r13, "tag");
        Intrinsics.checkNotNullParameter(r15, "effectInstanceType");
        m0(this, r11, r12, r13, r14, r15, null, r16, 64);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void I(String r12, Sticker r13, String r14, HashMap<String, String> r15, com.bytedance.android.live.effect.base.e r16, ILiveEffectComposerManager.EffectInstanceType r17) {
        Intrinsics.checkNotNullParameter(r12, "panel");
        Intrinsics.checkNotNullParameter(r13, "sticker");
        Intrinsics.checkNotNullParameter(r14, "trace");
        Intrinsics.checkNotNullParameter(r17, "effectInstanceType");
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L6;
        AndroidSchedulers.mainThread().scheduleDirect(new b(this, r12, r13, r14, r17, r15, r16));
        return;
    L6:
        b0(r12, r13, true, true, null, r14, r17, r15, r16);
    }

    public final void i0(String r6, Sticker r7, boolean r8, String r9, HashMap<String, String> r11, boolean r12) {
        if (d0() == true) goto L5;
        return;
    L5:
        Intrinsics.areEqual(r6, d0.c);
        Iterator r0 = ((ArrayList) this.e).iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((n) r1).b, r7.getEffectId()) == false) goto L7;
    L12:
        n r2 = (n) r1;
        if (r2 != null) goto L15;
        return;
    L15:
        ((ArrayList) this.e).remove(r2);
        if (r12 == false) goto L18;
    L20:
        this.b.d(false, r6, r7);
        if (r8 == false) goto L23;
        l0(false, "remove_sticker", r9 + '_' + r7.getEffectId(), null);
        int r13 = com.bytedance.android.live.effect.q.a;
        Intrinsics.checkNotNullParameter(r6, "panel");
        Intrinsics.areEqual(r6, d0.c);
    L23:
        Iterator r14 = ((CopyOnWriteArrayList) this.c).iterator();
    L25:
        if (r14.hasNext() == false) goto L30;
        ILiveEffectComposerManager.d r15 = (ILiveEffectComposerManager.d) r14.next();
        if ((r15 instanceof ILiveEffectComposerManager.e) == true) goto L28;
        r15.b(false, r6, r7);
        goto L25
    L28:
        ((ILiveEffectComposerManager.e) r15).d(false, r6, r7, r11);
        goto L25
    L30:
        return;
    L18:
        if (new ArrayList().contains(r2.a) == false) goto L20;
        r2.j = false;
        ((ArrayList) this.e).add(r2);
        goto L20
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager
    public final void Q(String r14, Sticker r15, Sticker r16, String r17, HashMap<String, String> r18, com.bytedance.android.live.effect.base.e r19, ILiveEffectComposerManager.EffectInstanceType r21) {
        Intrinsics.checkNotNullParameter(r14, "panel");
        Intrinsics.checkNotNullParameter(r17, "trace");
        Intrinsics.checkNotNullParameter(r21, "effectInstanceType");
        if (d0() == true) goto L5;
        return;
    L5:
        if (r15 == null) goto L7;
        i0(r14, r15, false, r17, r18, false);
    L7:
        if (r16 == null) goto L9;
        c0(this, r14, r16, false, true, null, r17, r21, r18, 256);
    L9:
        if (r16 != null) goto L14;
        if (r15 != null) goto L14;
        return;
    L14:
        if (r19 == null) goto L19;
        if (r16 == null) goto L17;
        boolean r1 = true;
    L18:
        r19.a = r1;
        goto L19
    L17:
        r1 = false;
    L19:
        StringBuilder r2 = new StringBuilder();
        Long r3 = null;
        if (r15 == null) goto L22;
        Long r4 = Long.valueOf(r15.getId());
    L23:
        r2.append(r4);
        r2.append("_to_");
        if (r16 == null) goto L26;
        r3 = Long.valueOf(r16.getId());
    L26:
        r2.append(r3);
        l0(false, "replace_sticker", r2.toString(), r19);
        int r0 = com.bytedance.android.live.effect.q.a;
        Intrinsics.checkNotNullParameter(r14, "panel");
        Intrinsics.areEqual(r14, d0.c);
        return;
    L22:
        r4 = null;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m0(LiveComposerManagerB r21, String r22, Sticker r23, String r24, float r25, ILiveEffectComposerManager.EffectInstanceType r26, Long r27, HashMap r28, int r29) {
        if ((r29 & 32) == 0) goto L5;
        Long r14 = null;
    L7:
        if ((r29 & 64) == 0) goto L9;
        boolean r1 = true;
    L11:
        if ((r29 & 128) == 0) goto L13;
        HashMap r9 = null;
    L15:
        if (r21.d0() == false) goto L77;
        Iterator r0 = ((ArrayList) r21.e).iterator();
    L19:
        if (r0.hasNext() == false) goto L23;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((n) r2).b, r23.getEffectId()) == false) goto L19;
    L24:
        n r8 = (n) r2;
        if (r8 != null) goto L28;
        c0(r21, r22, r23, false, false, null, "_updateTagValue", r26, null, 384);
        r1 = false;
    L28:
        Iterator r3 = ((ArrayList) r21.e).iterator();
    L30:
        if (r3.hasNext() == false) goto L52;
        n r4 = (n) r3.next();
        if ((!Intrinsics.areEqual(r4.b, r23.getEffectId())) == true) goto L30;
        Iterator r5 = ((ArrayList) r4.i).iterator();
    L36:
        if (r5.hasNext() == false) goto L40;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((p) r6).b, r24) == false) goto L36;
    L41:
        p r7 = (p) r6;
        if (r7 == null) goto L30;
        if (Intrinsics.areEqual(r7.a, r25) == false) goto L47;
        if (r14 != null) goto L47;
        return;
    L47:
        ((ArrayList) r4.i).remove(r7);
        r7.a = Float.valueOf(r25);
        ((ArrayList) r4.i).add(r7);
        ((ArrayList) r21.e).remove(r4);
        if (r14 == null) goto L50;
        long r11 = r14.longValue();
    L51:
        r4.g = r11;
        ((ArrayList) r21.e).add(r4);
        goto L52
    L50:
        r11 = System.currentTimeMillis();
        goto L51
    L40:
        r6 = null;
    L52:
        ALogger.d("ttlive_anchor_effect_LiveComposerManagerB", "update tag value tag:" + r24 + " value:" + r25);
        if (r1 == false) goto L62;
        if (r21.r == r23.getId()) goto L57;
    L59:
        r21.s = r24;
        r21.r = r23.getId();
    L60:
        r21.l0(r1, "update_sticker_value", r23.getEffectId(), null);
        goto L62
    L57:
        if (Intrinsics.areEqual(r21.s, r24) == false) goto L59;
        r21.q.clear();
    L62:
        if (r8 != null) goto L64;
    L67:
        HashMap r13 = r9;
        if (r13 == null) goto L70;
        r13.put("is_not_in_use", "");
    L70:
        Iterator r12 = ((ArrayList) r21.d).iterator();
    L72:
        if (r12.hasNext() == false) goto L97;
        ILiveEffectComposerManager.b r15 = (ILiveEffectComposerManager.b) r12.next();
        if ((r15 instanceof ILiveEffectComposerManager.c) == true) goto L75;
        r15.F(r22, r23, r24, r25);
        goto L72
    L75:
        ((ILiveEffectComposerManager.c) r15).u2(r22, r23, r24, r25, r13);
        goto L72
    L97:
        return;
    L64:
        if (r8.j != true) goto L67;
        r13 = r9;
        goto L70
    L23:
        r2 = null;
        goto L24
    L77:
        return;
    L13:
        r9 = r28;
        goto L15
    L9:
        r1 = false;
        goto L11
    L5:
        r14 = r27;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.bytedance.android.live.effect.composer.LiveComposerManagerB] */
    public final void b0(String r21, Sticker r22, boolean r23, boolean r24, Long r25, String r26, ILiveEffectComposerManager.EffectInstanceType r27, HashMap<String, String> r28, com.bytedance.android.live.effect.base.e r29) {
        if (d0() == false) goto L5;
        if (r28 != null) goto L12;
        HashMap<String, String> r14 = new HashMap();
    L14:
        if (Intrinsics.areEqual(r21, d0.c) == false) goto L16;
        LiveEffectSettings.LIVE_ENABLE_STICKER_DATA_PRE_LOAD_OPTIMIZE.getValue().booleanValue();
    L16:
        Iterator r0 = ((CopyOnWriteArrayList) this.c).iterator();
    L18:
        if (r0.hasNext() == false) goto L27;
        ILiveEffectComposerManager.d r1 = (ILiveEffectComposerManager.d) r0.next();
        if ((r1 instanceof ILiveEffectComposerManager.e) == true) goto L21;
        r1.a(r21, r22);
        goto L18
    L21:
        ILiveEffectComposerManager.e r2 = (ILiveEffectComposerManager.e) r1;
        HashMap r3 = new HashMap();
        if (r24 == false) goto L24;
        r3.put("add_sticker_use", "");
    L24:
        r3.put("add_sticker_event_page", "");
        Unit r4 = Unit.INSTANCE;
        r2.e(r21, r22);
        goto L18
    L27:
        if (d0() == false) goto L38;
        r22.getCoexistGroup().isEmpty();
        if (r22.isWithoutFace() != null) goto L33;
        r22.setWithoutFace(false);
    L33:
        if (((HashMap) this.n).containsKey(r21) == true) goto L35;
        ((HashMap) this.n).put(r21, new ArrayList());
    L35:
        List r5 = (List) ((HashMap) this.n).get(r21);
        if (r5 == null) goto L38;
        r5.add(r22);
    L38:
        Iterator r6 = ((ArrayList) this.e).iterator();
    L40:
        if (r6.hasNext() == false) goto L44;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((n) r7).b, r22.getEffectId()) == false) goto L40;
    L45:
        n r8 = (n) r7;
        if (r8 == null) goto L59;
        boolean r9 = r8.j;
        if (r9 != r24) goto L51;
        if (r25 != null) goto L51;
        return;
    L51:
        ((ArrayList) this.e).remove(r8);
        ArrayList r11 = e0(r22, r8.i);
        ((ArrayList) r8.i).clear();
        ((ArrayList) r8.i).addAll(r11);
        if (r25 == null) goto L54;
        long r12 = r25.longValue();
    L55:
        r8.g = r12;
        r8.j = r24;
        ((ArrayList) this.e).add(r8);
        if (r9 != r24) goto L67;
        return;
    L67:
        Iterator<Pair<n, List<String>>> r13 = this.l.iterator();
    L69:
        if (r13.hasNext() == false) goto L79;
        Pair<n, List<String>> r15 = r13.next();
        Pair<n, List<String>> r16 = r15;
        if (Intrinsics.areEqual(((n) r16.getFirst()).c, r22.getResourceId()) == false) goto L74;
    L75:
        boolean r17 = true;
    L77:
        if (r17 == false) goto L69;
    L80:
        Pair<n, List<String>> r18 = r15;
        if (r18 == null) goto L108;
        n r19 = (n) r18.getFirst();
        Iterator r110 = ((ArrayList) r19.i).iterator();
    L84:
        if (r110.hasNext() == false) goto L104;
        p r31 = (p) r110.next();
        if (r31.a == null) goto L84;
        Iterator r32 = r22.getComposerConfigList().iterator();
    L90:
        if (r32.hasNext() == false) goto L94;
        Object r33 = r32.next();
        if (Intrinsics.areEqual(((Sticker.ComposerConfig) r33).getTag(), r31.b) == false) goto L90;
    L96:
        if (((Sticker.ComposerConfig) r33) == null) goto L103;
        Float r34 = r31.a;
        if (r34 == null) goto L100;
        float r35 = r34.floatValue();
    L101:
        m0(this, r21, r22, r31.b, r35, r19.l, Long.valueOf(r19.g), null, 192);
        goto L103
    L100:
        r35 = 0.0f;
    L103:
        r19 = r19;
        goto L84
    L94:
        r33 = null;
        goto L96
    L104:
        this.l.remove(r18);
        CopyOnWriteArrayList<String> r36 = this.m.get(r21);
        if (r36 == null) goto L108;
        r36.remove(r22.getResourceId());
    L108:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_START_LIVE_RESTORE_OPTIMIZE.getValue().booleanValue() == false) goto L124;
        List r37 = (List) ((LinkedHashMap) this.h).get(r21);
        if (r37 == null) goto L117;
        ?? r38 = new ArrayList();
        Iterator r39 = r37.iterator();
    L113:
        if (r39.hasNext() == false) goto L118;
        Object r41 = r39.next();
        if (Intrinsics.areEqual(((n) r41).c, r22.getResourceId()) == false) goto L113;
        r38.add(r41);
    L118:
        Collection<?> r42 = (Collection) r38;
        if ((!r42.isEmpty()) == false) goto L121;
        g0(r38, new StringBuilder());
    L121:
        List r43 = (List) ((LinkedHashMap) this.h).get(r21);
        if (r43 == null) goto L124;
        r43.removeAll(r42);
        goto L124
    L117:
        r38 = CollectionsKt.emptyList();
    L124:
        if (r24 == false) goto L126;
        this.b.d(true, r21, r22);
    L126:
        if (r23 == false) goto L128;
        l0(false, "add_sticker", r26 + '_' + r22.getEffectId() + '_' + r27.name(), r29);
        int r44 = com.bytedance.android.live.effect.q.a;
        Intrinsics.checkNotNullParameter(r21, "panel");
        Intrinsics.areEqual(r21, d0.c);
    L128:
        if (r24 == true) goto L130;
        HashMap<String, String> r45 = r14;
        r45.put("is_not_in_use", "");
    L131:
        Iterator r46 = ((CopyOnWriteArrayList) this.c).iterator();
    L133:
        if (r46.hasNext() == false) goto L138;
        ILiveEffectComposerManager.d r47 = (ILiveEffectComposerManager.d) r46.next();
        if ((r47 instanceof ILiveEffectComposerManager.e) == true) goto L136;
        r47.b(true, r21, r22);
        goto L133
    L136:
        ((ILiveEffectComposerManager.e) r47).d(true, r21, r22, r45);
        goto L133
    L138:
        return;
    L130:
        r45 = r14;
        goto L131
    L74:
        if (((List) r16.getSecond()).contains(r22.getEffectId()) == true) goto L75;
        r17 = false;
        goto L77
    L79:
        r15 = null;
        goto L80
    L54:
        r12 = System.currentTimeMillis();
        goto L55
    L59:
        String r48 = r22.getEffectId();
        String r49 = r22.getResourceId();
        String r51 = r22.getUnzipPath();
        Boolean r52 = r22.isWithoutFace();
        Intrinsics.checkNotNull(r52);
        boolean r53 = r52.booleanValue();
        boolean r54 = r22.isHighCost();
        if (r25 == null) goto L62;
        long r55 = r25.longValue();
    L63:
        n r56 = new n(r21, r48, r49, r51, r53, r54, r55);
        r56.j = r24;
        ((ArrayList) r56.h).addAll(r22.getCoexistGroup());
        ArrayList r57 = e0(r22, r56.i);
        ((ArrayList) r56.i).clear();
        ((ArrayList) r56.i).addAll(r57);
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r56.l = r27;
        Effect r58 = r22.getEffect();
        if (r58 == null) goto L66;
        r58.getEffect_type();
    L66:
        r22.getTransferType();
        ((ArrayList) this.e).add(r56);
        goto L67
    L62:
        r55 = System.currentTimeMillis();
        goto L63
    L44:
        r7 = null;
        goto L45
    L12:
        r14 = r28;
        goto L14
    L5:
        if (((Boolean) rb.a.getValue()).booleanValue() == true) goto L7;
        return;
    L7:
        if (v.a() == false) goto L173;
        ((ArrayList) this.t).add(new com.bytedance.android.live.effect.composer.a(r21, r22, r23, r24, r25, r26));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c0(LiveComposerManagerB r12, String r13, Sticker r14, boolean r15, boolean r16, Long r17, String r18, ILiveEffectComposerManager.EffectInstanceType r19, HashMap r21, int r22) {
        if ((r22 & 8) == 0) goto L5;
        boolean r6 = true;
    L7:
        if ((r22 & 16) == 0) goto L9;
        Long r7 = null;
    L11:
        if ((r22 & 128) == 0) goto L13;
        HashMap r11 = null;
    L14:
        r12.b0(r13, r14, r15, r6, r7, r18, r19, r11, null);
        return;
    L13:
        r11 = r21;
        goto L14
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }
}
