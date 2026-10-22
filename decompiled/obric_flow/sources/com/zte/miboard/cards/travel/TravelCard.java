package com.zte.miboard.cards.travel;

import ai.j0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c.k0;
import c.m;
import c.o;
import c.s0;
import c.v;
import cn.nubia.neopush.commons.AppUtil;
import com.google.gson.Gson;
import com.zte.miboard.cards.CardParentCallback;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.common.views.CardPagerLayout;
import com.zte.miboard.cards.travel.data.FlightData;
import com.zte.miboard.cards.travel.data.HotelData;
import com.zte.miboard.cards.travel.data.TravelData;
import com.zte.miboard.cards.travel.net.data.FlightNetInfoResult;
import com.zte.miboard.cards.travel.net.data.FlightReq;
import com.zte.miboard.cards.travel.net.data.FlightResult;
import com.zte.miboard.recommend.RecommendManager;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public class TravelCard extends c.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static long f16339o = 1800000;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Comparator<TravelData> f16340p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static long f16341q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static ArrayList<FlightReq> f16342r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CardPagerLayout f16343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CardParentCallback f16344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.zte.miboard.cards.travel.b.h f16345c;
    private ArrayList<TravelData> d;
    private ArrayList<com.zte.miboard.cards.travel.b.f> e;
    private BroadcastReceiver f;
    private boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f16346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BroadcastReceiver f16348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f16349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Handler f16350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Runnable f16351m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CardPagerLayout.a f16352n;

    public class a implements com.zte.miboard.cards.travel.b.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelCard f16353a;

        public a(TravelCard r5) {
            this.f16353a = r5;
        }

        @Override // com.zte.miboard.cards.travel.b.h
        public void a(@NonNull com.zte.miboard.cards.travel.b.f r5, @NonNull ArrayList<? extends TravelData> r10) {
            m.i("TravelCard", "onTravelDataChanged dataKey=" + r5 + " travelDataList=" + r10);
            if (TravelCard.a(this.f16353a).contains(r5) == true) goto L5;
            return;
        L5:
            TravelCard.a(this.f16353a, false);
        }
    }

    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelCard f16354a;

        public b(TravelCard r5) {
            this.f16354a = r5;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r5, Intent r10) {
            if (r10 != null) goto L5;
        L7:
            if (r10 != null) goto L9;
            return;
        L9:
            if ("android.intent.action.SCREEN_OFF".equals(r10.getAction()) == false) goto L14;
            m.i("TravelCard", "mScreenOnReceiver ACTION_SCREEN_OFF");
            TravelCard.d(this.f16354a);
            return;
        L14:
            return;
        L5:
            if ("android.intent.action.SCREEN_ON".equals(r10.getAction()) == false) goto L7;
            m.i("TravelCard", "mScreenOnReceiver ACTION_SCREEN_ON");
            TravelCard.b(this.f16354a);
            TravelCard.c(this.f16354a);
        }
    }

    public class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelCard f16355a;

        public c(TravelCard r5) {
            this.f16355a = r5;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r5, Intent r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if ("android.intent.action.TIME_TICK".equals(r10.getAction()) == false) goto L7;
        L10:
            TravelCard.a(this.f16355a, true, "android.intent.action.TIME_TICK".equals(r10.getAction()));
            return;
        L7:
            if ("android.intent.action.TIME_SET".equals(r10.getAction()) == true) goto L10;
            if ("android.intent.action.TIMEZONE_CHANGED".equals(r10.getAction()) == true) goto L10;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelCard f16356a;

        public d(TravelCard r5) {
            this.f16356a = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.i("TravelCard", "onCardInited runnable run");
            TravelCard.e(this.f16356a);
            LocalBroadcastManager.getInstance(this.f16356a.getContext()).registerReceiver(TravelCard.f(this.f16356a), new IntentFilter(com.zte.miboard.cards.travel.b.f16453a));
            TravelCard.a(this.f16356a, false);
        }
    }

    public class e extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelCard f16357a;

        public e(TravelCard r5) {
            this.f16357a = r5;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r5, Intent r10) {
            m.i("TravelCard", "mSwitchesChangedReceiver onReceive, intent=" + r10);
            TravelCard.e(this.f16357a);
            TravelCard.a(this.f16357a, false);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelCard f16358a;

        public f(TravelCard r5) {
            this.f16358a = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16358a.i();
        }
    }

    public class g implements Comparator<TravelData> {
        public g() {
        }

        public int a(TravelData r5, TravelData r10) {
            if (r5 == null) goto L27;
            if (r10 != null) goto L5;
            return 0;
        L5:
            if (r5.isAvailable() == true) goto L7;
            return 0;
        L7:
            if (r10.isAvailable() == true) goto L10;
            return 0;
        L10:
            if (r5.travelDate.equals(r10.travelDate) == false) goto L12;
            boolean r11 = r5 instanceof HotelData;
            if (r11 == true) goto L19;
            if ((r10 instanceof HotelData) == false) goto L19;
            return -1;
        L19:
            if (r11 == false) goto L24;
            if ((r10 instanceof HotelData) == true) goto L24;
            return 1;
        L24:
            if ((r5.getCurAvailableFromTimeLong() - r10.getCurAvailableFromTimeLong()) > 0) goto L26;
            return -1;
        L26:
            return 1;
        L12:
            return r5.travelDate.compareTo(r10.travelDate);
        L27:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(TravelData r5, TravelData r10) {
            return a(r5, r10);
        }
    }

    public class h implements CardPagerLayout.a<TravelData, com.zte.miboard.cards.travel.b.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelCard f16359a;

        public h(TravelCard r5) {
            this.f16359a = r5;
        }

        public static /* synthetic */ boolean a(h r5, View r10) {
            return r5.b(r10);
        }

        @NonNull
        public com.zte.miboard.cards.travel.b.f b(int r5) {
            TravelData r10 = (TravelData) TravelCard.g(this.f16359a).get(r5);
            com.zte.miboard.cards.travel.b.f r11 = com.zte.miboard.cards.travel.b.a(r10);
            if (r11 != null) goto L6;
            m.l("TravelCard", "getItemViewType dataKey error, travelData=" + r10);
            return com.zte.miboard.cards.travel.b.f.d;
        L6:
            return r11;
        }

        private /* synthetic */ boolean b(View r10) {
            StringBuilder r5 = new StringBuilder("onCreateChildView travel OnLongClickListener mCardParentCallback=");
            if (TravelCard.h(this.f16359a) == null) goto L5;
            boolean r11 = true;
        L6:
            r5.append(r11);
            r5.append(" tag=");
            r5.append(r10.getTag());
            m.i("TravelCard", r5.toString());
            if ((r10.getTag() instanceof TravelData) == false) goto L11;
            TravelData r12 = (TravelData) r10.getTag();
            String r13 = new Gson().toJson(r12);
            Bundle r14 = new Bundle();
            r14.putString("event_type", "type_travel_card_item_long_click");
            r14.putSerializable("travel_data_class", r12.getClass());
            r14.putString("travel_data", r13);
            if (TravelCard.h(this.f16359a) == null) goto L11;
            TravelCard.h(this.f16359a).onCardContentViewLongClick(r10, r14);
        L11:
            return true;
        L5:
            r11 = false;
            goto L6
        }

        @Override // com.zte.miboard.cards.common.views.CardPagerLayout.a
        @NonNull
        public /* bridge */ /* synthetic */ com.zte.miboard.cards.travel.b.f a(int r5) {
            return b(r5);
        }

        @Override // com.zte.miboard.cards.common.views.CardPagerLayout.a
        @NonNull
        public ArrayList<TravelData> a() {
            return TravelCard.g(this.f16359a);
        }

        @Override // com.zte.miboard.cards.common.views.CardPagerLayout.a
        public void a(@NonNull View r5, int r10) {
            if ((r5 instanceof TravelItemLayout) == false) goto L6;
            ((TravelItemLayout) r5).a(a().get(r10), 1);
            return;
        }

        @Override // com.zte.miboard.cards.common.views.CardPagerLayout.a
        public void a(@NonNull View r5) {
            if ((r5 instanceof TravelItemLayout) == false) goto L6;
            ((TravelItemLayout) r5).g();
            return;
        }

        @NonNull
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public View a2(@NonNull ViewGroup r5, @NonNull com.zte.miboard.cards.travel.b.f r10) {
            TravelItemLayout r11 = (TravelItemLayout) LayoutInflater.from(this.f16359a.getContext()).inflate(R.layout.travel_card_item_layout, r5, false);
            r11.setDataKey(r10);
            r11.setOnLongClickListener(new com.zte.miboard.cards.travel.c(this));
            return r11;
        }

        @Override // com.zte.miboard.cards.common.views.CardPagerLayout.a
        @NonNull
        public /* bridge */ /* synthetic */ View a(@NonNull ViewGroup r5, @NonNull com.zte.miboard.cards.travel.b.f r10) {
            return a2(r5, r10);
        }
    }

    public class i implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f16361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f16362c;
        final /* synthetic */ TravelCard d;

        public i(TravelCard r5, Context r10, ArrayList r11, ArrayList r12) {
            this.d = r5;
            this.f16360a = r10;
            this.f16361b = r11;
            this.f16362c = r12;
        }

        @Override // mt.u
        public void onComplete() {
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            m.j("TravelCard", "requestFlightNetInfoIfNeed onError, flightReqs=" + this.f16361b, r5);
        }

        @Override // mt.u
        public void onNext(Object r5) {
            TravelCard.a(this.f16360a, this.f16361b, this.f16362c, r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
        }
    }

    static {
        f16340p = new g();
        f16342r = new ArrayList();
    }

    public TravelCard(Context r5) {
        this(r5, null);
    }

    private static /* synthetic */ boolean a(FlightReq r5) {
        if (r5 != null) goto L4;
        return true;
    L4:
        return false;
    }

    public static /* synthetic */ boolean b(TravelData r5) {
        return a(r5);
    }

    public static /* synthetic */ boolean c(FlightReq r5) {
        return b(r5);
    }

    public static /* synthetic */ boolean d(FlightReq r5) {
        return a(r5);
    }

    public static /* synthetic */ void e(TravelCard r5) {
        r5.f();
    }

    public static /* synthetic */ BroadcastReceiver f(TravelCard r5) {
        return r5.f16348j;
    }

    public static /* synthetic */ ArrayList g(TravelCard r5) {
        return r5.d;
    }

    private static List<com.zte.miboard.cards.travel.b.f> getAllConfigDataKeyList() {
        return com.zte.miboard.cards.travel.b.f16454b;
    }

    private ArrayList<TravelItemLayout> getAllTravelItemLayout() {
        ArrayList<TravelItemLayout> r5 = new ArrayList();
        CardPagerLayout r10 = this.f16343a;
        if (r10 == null) goto L10;
        Iterator<View> r11 = r10.getAllPageViewList().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        View r12 = r11.next();
        if ((r12 instanceof TravelItemLayout) == false) goto L6;
        r5.add((TravelItemLayout) r12);
    L10:
        return r5;
    }

    private List<com.zte.miboard.cards.travel.b.f> getDataKeyList() {
        return this.e;
    }

    private static SimpleDateFormat getHourMinutesFormat() {
        return s0.f("yyyy-MM-dd HH:mm");
    }

    public static /* synthetic */ CardParentCallback h(TravelCard r5) {
        return r5.f16344b;
    }

    private void j() {
        this.f16350l.removeCallbacks(this.f16351m);
    }

    private void k() {
    L7:
        th = move-exception;
        m.j("TravelCard", "unregisterScreenOnReceiver error", th);
        return;
    L4:
        if (this.g == false) goto L12;
        m.i("TravelCard", "unregisterScreenOnReceiver");     // Catch: Throwable -> L7
        getContext().unregisterReceiver(this.f);     // Catch: Throwable -> L7
        this.g = false;     // Catch: Throwable -> L7
        l();     // Catch: Throwable -> L7
        return;
    }

    private void l() {
    L7:
        th = move-exception;
        m.j("TravelCard", "unregisterTimeTickerReceiver error", th);
        return;
    L4:
        if (this.f16347i == false) goto L12;
        m.i("TravelCard", "unregisterTimeTickerReceiver");     // Catch: Throwable -> L7
        getContext().unregisterReceiver(this.f16346h);     // Catch: Throwable -> L7
        this.f16347i = false;     // Catch: Throwable -> L7
        return;
    }

    public void i() {
        m.i("TravelCard", "removeDataAfterDelay");
        if (this.f16343a.getShowItemListSize() <= 0) goto L6;
        this.f16343a.b();
        return;
    }

    @Override // com.zte.miboard.cards.CardCallback
    public boolean isContentReady() {
        return !this.d.isEmpty();
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onDestroy() {
        m.i("TravelCard", "onDestroy");
        b();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        CardPagerLayout r5 = (CardPagerLayout) findViewById(R.id.card_pager_layout);
        this.f16343a = r5;
        r5.setCardPagerCallback(this.f16352n);
        a();
    }

    @Override // com.zte.miboard.cards.CardCallback
    public Bundle onParentPopupMenuItemClick(View r10, Bundle r11) {
        if (r11 != null) goto L6;
        m.l("TravelCard", "onParentPopupMenuItemClick bundle null return");
        return null;
    L6:
        String r5 = r11.getString("event_type");
        Class r12 = (Class) androidx.activity.e.n(r11);
        String r13 = r11.getString("travel_data");
        m.i("TravelCard", "onParentPopupMenuItemClick eventType=" + r5 + " travelDataCls=" + r12 + " travelDataStr=" + r13);
        if ("type_travel_card_item_long_click".equals(r5) == false) goto L13;
        com.zte.miboard.cards.travel.b.b(getContext(), (TravelData) new Gson().fromJson(r13, r12));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        m.j("TravelCard", "onParentPopupMenuItemClick error eventType=" + r5 + " travelDataCls=" + r12 + " travelDataStr=" + r13, th);
    L13:
        return new Bundle();
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onPause(boolean r5) {
        m.i("TravelCard", "onPause isInMiBoard=" + r5);
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onRefresh() {
        m.i("TravelCard", "onRefresh");
        Iterator<TravelItemLayout> r5 = getAllTravelItemLayout().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().d();
        goto L4
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onResume(boolean r5) {
        m.i("TravelCard", "onResume isInMiBoard=" + r5);
        if (r5 == true) goto L6;
        c();
        return;
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onSlideIn() {
        String r5 = k0.f1060a;
        m.i("TravelCard", "onSlideIn getVersionName=16.0.000.000.2606301031-964f71b");
        j();
        a(true, false);
        Iterator<TravelItemLayout> r10 = getAllTravelItemLayout().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().e();
        goto L4
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onSlideOut() {
        m.i("TravelCard", "onSlideOut");
        e();
        Iterator<TravelItemLayout> r5 = getAllTravelItemLayout().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().f();
        goto L4
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void setCardParentCallback(CardParentCallback r5) {
        this.f16344b = r5;
    }

    public TravelCard(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    public static /* synthetic */ List a(TravelCard r5) {
        return r5.getDataKeyList();
    }

    private static /* synthetic */ boolean b(FlightReq r5) {
        if (r5 != null) goto L4;
        return true;
    L4:
        return false;
    }

    public static /* synthetic */ void c(TravelCard r5) {
        r5.h();
    }

    public static /* synthetic */ void d(TravelCard r5) {
        r5.l();
    }

    private void e() {
        this.f16350l.postDelayed(this.f16351m, 120000);
    }

    private void f() {
        this.e.clear();
        this.e.addAll(com.zte.miboard.cards.travel.b.a(getContext(), false));
        Iterator<com.zte.miboard.cards.travel.b.f> r5 = getAllConfigDataKeyList().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        com.zte.miboard.cards.travel.b.b(r5.next(), this.f16345c);
        goto L4
    L6:
        Iterator<com.zte.miboard.cards.travel.b.f> r10 = getDataKeyList().iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        com.zte.miboard.cards.travel.b.f r11 = r10.next();
        com.zte.miboard.cards.travel.b.a(getContext(), r11);
        com.zte.miboard.cards.travel.b.a(r11, this.f16345c);
        goto L8
    L10:
        m.i("TravelCard", "refreshDataKeyList mDataKeyList=" + this.e);
    }

    private void g() {
    L7:
        th = move-exception;
        m.j("TravelCard", "registerScreenOnReceiver error", th);
        return;
    L4:
        if (this.g == true) goto L12;
        m.i("TravelCard", "registerScreenOnReceiver");     // Catch: Throwable -> L7
        IntentFilter r5 = new IntentFilter();     // Catch: Throwable -> L7
        r5.addAction("android.intent.action.SCREEN_ON");     // Catch: Throwable -> L7
        r5.addAction("android.intent.action.SCREEN_OFF");     // Catch: Throwable -> L7
        getContext().registerReceiver(this.f, r5, 4);     // Catch: Throwable -> L7
        this.g = true;     // Catch: Throwable -> L7
        h();     // Catch: Throwable -> L7
        return;
    }

    private void h() {
    L7:
        th = move-exception;
        m.j("TravelCard", "registerTimeTickerReceiver error", th);
        return;
    L4:
        if (this.f16347i == true) goto L12;
        m.i("TravelCard", "registerTimeTickerReceiver");     // Catch: Throwable -> L7
        IntentFilter r5 = new IntentFilter();     // Catch: Throwable -> L7
        r5.addAction("android.intent.action.TIME_TICK");     // Catch: Throwable -> L7
        r5.addAction("android.intent.action.DATE_CHANGED");     // Catch: Throwable -> L7
        r5.addAction("android.intent.action.TIMEZONE_CHANGED");     // Catch: Throwable -> L7
        r5.addAction("android.intent.action.TIME_SET");     // Catch: Throwable -> L7
        getContext().registerReceiver(this.f16346h, r5, 4);     // Catch: Throwable -> L7
        this.f16347i = true;     // Catch: Throwable -> L7
        return;
    }

    public TravelCard(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f16345c = new a(this);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new b(this);
        this.g = false;
        this.f16346h = new c(this);
        this.f16347i = false;
        this.f16348j = new e(this);
        this.f16350l = new Handler(Looper.getMainLooper());
        this.f16351m = new f(this);
        this.f16352n = new h(this);
        String r12 = k0.f1060a;
        m.i("TravelCard", "init getVersionName=16.0.000.000.2606301031-964f71b");
    }

    public static /* synthetic */ boolean a(TravelCard r5, boolean r10) {
        return r5.a(r10);
    }

    public static /* synthetic */ void b(TravelCard r5) {
        r5.d();
    }

    private void d() {
        a(false, false);
        Iterator<TravelItemLayout> r5 = getAllTravelItemLayout().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().c();
        goto L4
    }

    public void c() {
        a(false, false);
        Iterator<TravelItemLayout> r5 = getAllTravelItemLayout().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().b();
        goto L4
    }

    public static /* synthetic */ void a(TravelCard r5, boolean r10, boolean r11) {
        r5.a(r10, r11);
    }

    public void b() {
        m.i("TravelCard", "onCardRemoved");
        j();
        Iterator<com.zte.miboard.cards.travel.b.f> r5 = getAllConfigDataKeyList().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        com.zte.miboard.cards.travel.b.b(r5.next(), this.f16345c);
        goto L4
    L6:
        k();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f16348j);
        Iterator<TravelItemLayout> r10 = getAllTravelItemLayout().iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().a();
        goto L8
    L10:
        TravelFlightUtils.h(getContext());
        RecommendManager.destroy();
    }

    private static boolean a(ArrayList<FlightReq> r5, ArrayList<FlightReq> r10) {
        if (r5 == null) goto L17;
        if (r10 == null) goto L17;
        r5.removeIf(new o(2));
        r10.removeIf(new o(3));
        if (r5.size() == r10.size()) goto L9;
        return false;
    L9:
        Iterator<FlightReq> r11 = r5.iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        if (r10.contains(r11.next()) == true) goto L11;
        return false;
    L15:
        return true;
    L17:
        return false;
    }

    private static /* synthetic */ boolean a(TravelData r12) {
        if (r12 != null) goto L5;
    L12:
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        m.n("TravelCard", "removeNoNeedTravelDataInList removed. null or not isAvailable, travelData=" + r12);
    L16:
        if (r5 == true) goto L29;
        long r10 = r12.getCurAvailableFromTimeLong();
        long r11 = r12.getCurAvailableToTimeLong();
        long r13 = System.currentTimeMillis();
        if (r10 > 0) goto L20;
        m.n("TravelCard", "onTravelDataListChanged removed. fromTime not right, travelData=" + r12);
        return true;
    L20:
        if (r11 > 0) goto L23;
        r11 = 60000 + r10;
    L23:
        if (r13 >= (r10 - 259200000)) goto L25;
    L26:
        m.i("TravelCard", "onTravelDataListChanged time not right not show data=" + r12);
        return true;
    L25:
        if (r13 > (r11 + 1800000)) goto L26;
    L29:
        return r5;
    L5:
        if (r12.isAvailable() == false) goto L12;
        if (r12.isIgnored() == true) goto L12;
        if (r12.isUserCancel() == true) goto L12;
        r5 = false;
        goto L14
    }

    public void a() {
        m.i("TravelCard", "onCardInited");
        RecommendManager.init(getContext());
        d r5 = new d(this);
        TravelFlightUtils.a(getContext(), r5);
    }

    public static void a(Context r18, ArrayList<FlightReq> r19, ArrayList<FlightData> r20, Object r21) {
        if (r21 != null) goto L102;
        return;
    L102:
        FlightNetInfoResult r5 = (FlightNetInfoResult) new Gson().fromJson(new Gson().toJson(r21), FlightNetInfoResult.class);     // Catch: Throwable -> L8
    L10:
        if (r5 != null) goto L12;
    L100:
        m.l("TravelCard", "onRequestFlightNetInfoResult error flightReqs=" + r19);
        m.l("TravelCard", "onRequestFlightNetInfoResult error result=" + r5);
        return;
    L12:
        if (r5.isAvailable() == false) goto L100;
        ArrayList r10 = new ArrayList();
        Iterator<FlightNetInfoResult.FlightReqAndResult> r11 = r5.flights.iterator();
    L16:
        if (r11.hasNext() == false) goto L34;
        FlightNetInfoResult.FlightReqAndResult r12 = r11.next();
        if (r12 == null) goto L19;
        FlightReq r13 = r12.req;
        if (r13 == null) goto L33;
        if (r13.isAvailable() == false) goto L33;
        FlightResult r14 = r12.result;
        if (r14 == null) goto L33;
        if (r14.isAvailable() == false) goto L33;
        if (r12.req.travelDate.equalsIgnoreCase(r12.result.getTravelDate()) == false) goto L33;
        if (r12.req.travelNumber.equalsIgnoreCase(r12.result.getTravelNumber()) == false) goto L33;
        r10.add(r12);
    L33:
        m.l("TravelCard", "onRequestFlightNetInfoResult req or result error, req=" + r12.req + " result=" + r12.result);
        goto L16
    L19:
        return;
    L34:
        m.i("TravelCard", "onRequestFlightNetInfoResult flightReqs=" + r19 + " flightReqAndResultList=" + r10.size());
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        int r17 = 0;
    L36:
        if (r17 >= r10.size()) goto L89;
        FlightResult r110 = ((FlightNetInfoResult.FlightReqAndResult) r10.get(r17)).result;
        FlightReq r111 = ((FlightNetInfoResult.FlightReqAndResult) r10.get(r17)).req;
        m.i("TravelCard", "onRequestFlightNetInfoResult i=" + r17 + " flightResult=" + r110);
        int r112 = 0;
        FlightData r113 = null;
    L39:
        if (r112 >= r20.size()) goto L78;
        FlightData r22 = r20.get(r112);
        if (r22 != null) goto L43;
    L75:
        if (r113 != null) goto L78;
        r112 = r112 + 1;
        goto L39
    L43:
        if (r22.isAvailable() == false) goto L75;
        if (r110 == null) goto L75;
        if (r110.isAvailable() == false) goto L75;
        if (r22.travelDate.equalsIgnoreCase(r110.getTravelDate()) == false) goto L75;
        if (r22.travelNumber.equalsIgnoreCase(r110.getTravelNumber()) == false) goto L75;
        if (r19.size() != r20.size()) goto L74;
        FlightReq r23 = r19.get(r112);
        if (r23 == null) goto L74;
        if (r22.travelDate.equalsIgnoreCase(r23.travelDate) == false) goto L74;
        if (r22.travelNumber.equalsIgnoreCase(r23.travelNumber) == false) goto L74;
        String r24 = r23.fromStation;
        String r114 = r111.fromStation;
        boolean r115 = s0.f1083a;
        if (r24 != null) goto L64;
        if (r24 != r114) goto L63;
        boolean r25 = true;
    L65:
        if (r25 == false) goto L73;
        String r26 = r23.toStation;
        String r116 = r111.toStation;
        if (r26 != null) goto L71;
        if (r26 != r116) goto L70;
        boolean r27 = true;
    L72:
        if (r27 == true) goto L74;
    L70:
        r27 = false;
        goto L72
    L71:
        r27 = r26.equals(r116);
    L73:
        m.l("TravelCard", "onRequestFlightNetInfoResult findFlightData set null, flightReq=" + r23);
        m.l("TravelCard", "onRequestFlightNetInfoResult findFlightData set null, flightResultReq=" + r111);
        m.l("TravelCard", "onRequestFlightNetInfoResult findFlightData set null, findFlightData=null");
        m.l("TravelCard", "onRequestFlightNetInfoResult findFlightData set null, flightResult=" + r110);
        r113 = null;
        goto L75
    L63:
        r25 = false;
        goto L65
    L64:
        r25 = r24.equals(r114);
    L74:
        r113 = r22;
    L78:
        if (r113 == null) goto L83;
        FlightData r28 = (FlightData) com.zte.miboard.cards.travel.b.a(r18, FlightData.class, r113, r110);
        r28.setNetUpdateTimeLong(System.currentTimeMillis());
        m.i("TravelCard", "onRequestFlightNetInfoResult i=" + r17 + " updatedFightData=" + r28);
        if (r28.isAvailable() == false) goto L88;
        r16.add(new Pair(r113, r28));
    L88:
        r17 = r17 + 1;
        goto L36
    L83:
        if (r110 != null) goto L85;
    L87:
        m.l("TravelCard", "onRequestFlightNetInfoResult i=" + r17 + " flightResultReq error, flightResultReq=" + r111 + " flightResult=" + r110);
        goto L88
    L85:
        if (r110.isRegistered() == false) goto L87;
        r110.setUserRegistered();
        m.i("TravelCard", "onRequestFlightNetInfoResult i=" + r17 + " isRegistered add, flightResult=" + r110);
        r15.add(r110);
        goto L88
    L89:
        m.i("TravelCard", "onRequestFlightNetInfoResult needUpdateFlightDataList=" + r16.size() + " needAddFlightDataList=" + r15.size());
        Iterator r29 = r16.iterator();
    L91:
        if (r29.hasNext() == false) goto L95;
        Pair r30 = (Pair) r29.next();
        if (com.zte.miboard.cards.travel.a.a(r18, (FlightData) r30.first, (FlightData) r30.second) == true) goto L91;
        com.zte.miboard.cards.travel.b.c(r18, (TravelData) r30.second);
        goto L91
    L95:
        Iterator r31 = r15.iterator();
    L97:
        if (r31.hasNext() == false) goto L99;
        com.zte.miboard.cards.travel.b.a(r18, (FlightData) r31.next());
        goto L97
    L99:
        return;
    L8:
        th = move-exception;
        m.j("TravelCard", "onRequestFlightNetInfoResult fromJson error", th);
        r5 = null;
        goto L10
    }

    private boolean a(boolean r10) {
        ArrayList r5 = new ArrayList();
        Iterator<com.zte.miboard.cards.travel.b.f> r11 = getDataKeyList().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r5.addAll(com.zte.miboard.cards.travel.b.a(r11.next()));
        goto L4
    L6:
        r5.removeIf(new o(4));
        r5.sort(f16340p);
        int r12 = 0;
        if (r5.isEmpty() == false) goto L13;
        if (this.d.isEmpty() == false) goto L13;
        m.n("TravelCard", "onTravelDataListChanged before and after all empty return");
        return false;
    L13:
        if (r10 == false) goto L15;
    L18:
        boolean r13 = true;
    L19:
        this.d.clear();
        this.d.addAll(r5);
        StringBuilder r14 = new StringBuilder("onTravelDataListChanged dataList.size=");
        r14.append(r5);
        r14.append(" mCardParentCallback=");
        if (this.f16344b == null) goto L22;
        boolean r15 = true;
    L23:
        r14.append(r15);
        m.i("TravelCard", r14.toString());
    L25:
        if (r12 >= r5.size()) goto L27;
        StringBuilder r16 = j0.s(r12, "onTravelDataListChanged i=", " data=");
        r16.append(r5.get(r12));
        m.i("TravelCard", r16.toString());
        r12 = r12 + 1;
        goto L25
    L27:
        CardPagerLayout r17 = this.f16343a;
        if (r17 == null) goto L30;
        r17.a();
    L30:
        CardParentCallback r18 = this.f16344b;
        if (r18 == null) goto L34;
        r18.onContentStateChanged();
    L34:
        if (this.d.isEmpty() == true) goto L36;
        g();
    L37:
        a(r13, this.d);
        return true;
    L36:
        k();
        goto L37
    L22:
        r15 = false;
        goto L23
    L15:
        if (r5.size() != this.d.size()) goto L18;
        r13 = false;
        goto L19
    }

    private void a(boolean r10, boolean r11) {
        long r5 = System.currentTimeMillis();
        boolean r12 = true;
        if (r10 == false) goto L5;
    L7:
        if (r10 == true) goto L9;
    L11:
        boolean r13 = false;
    L12:
        if (r10 == false) goto L15;
        if (r11 == true) goto L15;
    L16:
        if (r13 == true) goto L23;
        this.f16349k = r5;
        Iterator<com.zte.miboard.cards.travel.b.f> r14 = getDataKeyList().iterator();
    L19:
        if (r14.hasNext() == false) goto L21;
        com.zte.miboard.cards.travel.b.a(getContext(), r14.next());
        goto L19
    L21:
        boolean r15 = a(r12);
        com.zte.miboard.cards.travel.a.a(getContext(), new ArrayList(this.d));
        m.i("TravelCard", "refreshWhenTimeChanged hao=" + (System.currentTimeMillis() - r5) + "ms");
        if (r15 == false) goto L23;
        return;
    L23:
        a(r12, this.d);
        return;
    L15:
        r12 = false;
        goto L16
    L9:
        if (getHourMinutesFormat().format(Long.valueOf(r5)).equals(getHourMinutesFormat().format(Long.valueOf(this.f16349k))) == false) goto L11;
    L10:
        r13 = true;
        goto L12
    L5:
        if (Math.abs(r5 - this.f16349k) >= f16339o) goto L7;
        goto L7
    }

    private void a(boolean r20, ArrayList<TravelData> r21) {
        if (r21 != null) goto L4;
        return;
    L4:
        boolean r5 = TravelFlightUtils.g(getContext());
        if (r21.isEmpty() == false) goto L8;
        if (r5 == true) goto L8;
        return;
    L8:
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        long r12 = System.currentTimeMillis();
        Iterator<TravelData> r13 = r21.iterator();
        long r14 = 3600000;
    L10:
        if (r13.hasNext() == false) goto L36;
        TravelData r15 = r13.next();
        if ((r15 instanceof FlightData) == false) goto L10;
        FlightData r16 = (FlightData) r15;
        FlightReq r17 = new FlightReq(r16);
        if (r11.contains(r17) == true) goto L10;
        long r18 = r15.getCurAvailableFromTimeLong();
        if (r15.getNetUpdateTimeLong() <= 0) goto L23;
        if (r18 <= 0) goto L23;
        if (r12 < (r18 - AppUtil.MILLIS_IN_DAYS)) goto L10;
    L23:
        if (r18 > 0) goto L25;
    L29:
        if (r18 > 0) goto L31;
    L33:
        long r19 = 3600000;
    L34:
        r14 = Math.min(r19, r14);
        r11.add(r17);
        r10.add(r16);
        goto L10
    L31:
        if (r12 <= (r18 - 3600000)) goto L33;
        r19 = 300000;
        goto L34
    L25:
        if (r12 <= (r18 - 10800000)) goto L29;
        if (r12 >= (r18 - 3600000)) goto L29;
        r19 = 600000;
        goto L34
    L36:
        if (r5 == false) goto L38;
    L41:
        Context r22 = getContext().getApplicationContext();
        if (v.b(r22) == true) goto L46;
        m.i("TravelCard", "requestFlightNetInfoIfNeed return, net error, registered=" + r5 + " flightReqs=" + r11);
        return;
    L46:
        if (a(r11, f16342r) == true) goto L48;
        boolean r23 = true;
    L49:
        long r110 = System.currentTimeMillis();
        if (r23 == false) goto L53;
        r14 = 60000;
    L53:
        if (Math.abs(r110 - f16341q) >= r14) goto L56;
        StringBuilder r24 = j0.t(r14, "requestFlightNetInfoIfNeed return, time no need, duration=", " sLastRequestFlightReqTime=");
        r24.append(com.zte.miboard.cards.travel.b.d().format(Long.valueOf(f16341q)));
        m.i("TravelCard", r24.toString());
        return;
    L56:
        f16341q = r110;
        f16342r = new ArrayList(r11);
        m.i("TravelCard", "requestFlightNetInfoIfNeed force=" + r23 + " registered=" + r5 + " flightReqs=" + r11);
        v.a(r22, r11, new i(this, r22, r11, r10));
        return;
    L48:
        r23 = r20;
        goto L49
    L38:
        if (r11.isEmpty() == false) goto L41;
        m.i("TravelCard", "requestFlightNetInfoIfNeed return, ignore registered=" + r5 + " flightReqs=" + r11);
    }
}
