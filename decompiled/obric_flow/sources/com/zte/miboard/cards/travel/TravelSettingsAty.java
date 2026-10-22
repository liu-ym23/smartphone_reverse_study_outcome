package com.zte.miboard.cards.travel;

import ai.j0;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c.l0;
import c.m;
import c.m0;
import c.n;
import c.q0;
import c.x;
import com.google.gson.Gson;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.zte.miboard.cards.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class TravelSettingsAty extends n {
    private ArrayList<Pair<Integer, ArrayList<m0>>> g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<Pair<Integer, ArrayList<m0>>> f16421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected ViewGroup f16423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private HashMap<String, Boolean> f16424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TravelFlightUtils.j f16425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private l0 f16426m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f16427n;

    public class a extends ArrayList<Pair<Integer, ArrayList<m0>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelSettingsAty f16428a;

        /* JADX INFO: renamed from: com.zte.miboard.cards.travel.TravelSettingsAty$a$a, reason: collision with other inner class name */
        public class C0026a extends ArrayList<m0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f16429a;

            public C0026a(a r10) {
                this.f16429a = r10;
                add(new m0(com.zte.miboard.cards.travel.b.f.d.f16465a, R.string.travel_flight, R.string.travel_flight_summary, 1));
                add(new m0(com.zte.miboard.cards.travel.b.f.e.f16465a, R.string.travel_train, R.string.travel_train_summary, 1));
                add(new m0(com.zte.miboard.cards.travel.b.f.f.f16465a, R.string.travel_hotel, R.string.travel_hotel_summary, 1));
                add(new m0("travel_card_all_travel", R.string.travel_card_all_travel, 0, 2));
                add(new m0("travel_notification", R.string.travel_notification, 0, 1));
            }
        }

        public class b extends ArrayList<m0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f16430a;

            public b(a r5) {
                this.f16430a = r5;
                int r10 = R.string.travel_third_title_very_zhun;
                int r11 = R.string.travel_third_summary_very_zhun;
                m0 r12 = new m0();
                r12.f1066c = "travel_register_very_zhun";
                r12.f1064a = r10;
                r12.f1065b = r11;
                r12.d = 3;
                add(r12);
            }
        }

        public a(TravelSettingsAty r5) {
            this.f16428a = r5;
            add(new Pair(0, new C0026a(this)));
            if (TravelFlightUtils.c() == false) goto L6;
            add(new Pair(0, new b(this)));
            return;
        }
    }

    public class b extends ArrayList<Pair<Integer, ArrayList<m0>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelSettingsAty f16431a;

        public class a extends ArrayList<m0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f16432a;

            public a(b r10) {
                this.f16432a = r10;
                add(new m0(com.zte.miboard.cards.travel.b.f.g.f16465a, R.string.travel_match, R.string.travel_match_summary, 1));
                add(new m0("travel_match_all_travel", R.string.travel_match_all_travel, 0, 2));
                add(new m0("travel_match_notification", R.string.travel_notification, 0, 1));
            }
        }

        public b(TravelSettingsAty r5) {
            this.f16431a = r5;
            add(new Pair(0, new a(this)));
        }
    }

    public class c implements TravelFlightUtils.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelSettingsAty f16433a;

        public c(TravelSettingsAty r5) {
            this.f16433a = r5;
        }

        @Override // com.zte.miboard.cards.travel.TravelFlightUtils.j
        public void a(boolean r5) {
            m.i("TravelSettingsAty", "mVeryZhunRegisterCallback onRegisterStateChanged registered=" + r5);
            TravelSettingsAty.a(this.f16433a);
        }
    }

    public class d implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f16434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TravelSettingsAty f16435b;

        public d(TravelSettingsAty r5) {
            this.f16435b = r5;
        }

        @Override // c.l0
        public void a(String r11, OButton r12) {
            TravelSettingsAty r5 = this.f16435b;
            if (r12 == null) goto L5;
            String r13 = r12.getText() + "";
        L6:
            m.i("TravelSettingsAty", "onItemButtonClick key=" + r11 + " text=" + r13);
            if ("travel_register_very_zhun".equalsIgnoreCase(r11) == false) goto L14;
            long r10 = System.currentTimeMillis();
            if (Math.abs(r10 - this.f16434a) >= 1000) goto L12;
            m.i("TravelSettingsAty", "onItemButtonClick too quick return, key=" + r11);
            return;
        L12:
            StringBuilder r14 = j0.x("onItemButtonClick key=", r11, " registered=");
            r14.append(TravelFlightUtils.g(r5));
            m.i("TravelSettingsAty", r14.toString());
            this.f16434a = r10;
            TravelFlightUtils.b(r5, r5.getString(R.string.travel_third_register_very_zhun).equals(r13));
            return;
        L14:
            return;
        L5:
            r13 = null;
            goto L6
        }

        @Override // c.l0
        public void a(String r5) {
            m.i("TravelSettingsAty", "onItemClick key=" + r5);
            if ("travel_card_all_travel".equals(r5) == false) goto L5;
        L6:
            TravelListAty.a(this.f16435b, "travel_match_all_travel".equals(r5), false);
            return;
        L5:
            if ("travel_match_all_travel".equals(r5) == true) goto L6;
        }

        @Override // c.l0
        public void a(OCardListItem r5) {
            if ((r5.getTag() instanceof m0) == true) goto L6;
            return;
        L6:
            if ("travel_register_very_zhun".equalsIgnoreCase(((m0) r5.getTag()).f1066c) == true) goto L8;
            return;
        L8:
            if (TravelFlightUtils.c() == true) goto L10;
            m.l("TravelSettingsAty", "onItemViewInited not isSupportRegisterVeryZhun");
            r5.setVisibility(8);
            return;
        L10:
            r5.setVisibility(0);
            boolean r10 = TravelFlightUtils.g(r5.getContext());
            Button r11 = (Button) r5.findViewById(R.id.settings_item_small_btn);
            if (r11 == null) goto L19;
            if (r10 == false) goto L14;
            int r12 = R.string.travel_third_unregister_very_zhun;
        L15:
            r11.setText(r12);
            return;
        L14:
            r12 = R.string.travel_third_register_very_zhun;
            goto L15
        }
    }

    public class e implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TravelSettingsAty f16437b;

        public e(TravelSettingsAty r5, Context r10) {
            this.f16437b = r5;
            this.f16436a = r10;
        }

        public void a(TravelFlightUtils.i r10) {
            if (r10 != null) goto L5;
        L7:
            boolean r5 = false;
        L8:
            String r11 = r10.f16380b;
            int r12 = 0;
        L10:
            if (r12 >= this.f16437b.f16423j.getChildCount()) goto L16;
            View r13 = this.f16437b.f16423j.getChildAt(r12);
            r13.setEnabled(r5);
            if (r5 == false) goto L14;
            float r14 = 1.0f;
        L15:
            r13.setAlpha(r14);
            r12 = r12 + 1;
            goto L10
        L14:
            r14 = 0.26f;
            goto L15
        L16:
            m.i("TravelSettingsAty", "checkTripRecommendStatusAndShowOpenDialogIfNeed status=" + r5 + " name=" + r11 + " mWaiting=" + TravelSettingsAty.b(this.f16437b));
            if (TravelSettingsAty.b(this.f16437b) == false) goto L20;
            TravelSettingsAty.a(this.f16437b, false);
            return;
        L20:
            if (r5 == false) goto L22;
            return;
        L22:
            TravelSettingsAty.a(this.f16437b, true);
            TravelFlightUtils.a(this.f16436a, r11);
            return;
        L5:
            if (r10.f16379a == false) goto L7;
            r5 = true;
            goto L8
        }

        public TravelFlightUtils.i b() {
            return TravelFlightUtils.k(this.f16436a);
        }

        @Override // c.q0
        public void onError(Throwable r5) {
            m.j("TravelSettingsAty", "checkTripRecommendStatusAndShowOpenDialogIfNeed error", r5);
        }

        @Override // c.q0
        public /* bridge */ /* synthetic */ void a(Object r5) {
            a((TravelFlightUtils.i) r5);
        }

        @Override // c.q0
        public /* bridge */ /* synthetic */ Object a() {
            return b();
        }
    }

    public TravelSettingsAty() {
        this.g = new a(this);
        this.f16421h = new b(this);
        this.f16422i = false;
        this.f16425l = new c(this);
        this.f16426m = new d(this);
        this.f16427n = false;
    }

    public static /* synthetic */ void a(TravelSettingsAty r5) {
        r5.j();
    }

    public static /* synthetic */ boolean b(TravelSettingsAty r5) {
        return r5.f16427n;
    }

    private void g() {
        m.h(new e(this, this));
    }

    public static /* synthetic */ void i(m0 r5, Context r10, CompoundButton r11, boolean r12) {
        a(r5, r10, r11, r12);
    }

    public static /* synthetic */ void j(TravelSettingsAty r5, m0 r10, View r11) {
        r5.a(r10, r11);
    }

    public static /* synthetic */ void k(TravelSettingsAty r5, m0 r10, OButton r11, View r12) {
        r5.a(r10, r11, r12);
    }

    @Override // c.n
    public boolean f() {
        return true;
    }

    public ArrayList<Pair<Integer, ArrayList<m0>>> h() {
        if (this.f16422i == true) goto L6;
        return this.g;
    L6:
        return this.f16421h;
    }

    @Override // c.n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        this.f16422i = false;
        setContentView(R.layout.travel_settings_aty_layout);
        ViewGroup r10 = (ViewGroup) findViewById(R.id.travel_settings_main_container);
        this.f16423j = r10;
        a(this.f16426m, r10);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HashMap<String, Boolean> r5 = i();
        boolean r10 = r5.equals(this.f16424k);
        StringBuilder r11 = new StringBuilder("onPause settingChanged= ");
        r11.append(!r10);
        m.i("TravelSettingsAty", r11.toString());
        if (r10 == true) goto L5;
        this.f16424k = r5;
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(com.zte.miboard.cards.travel.b.f16453a));
        com.zte.miboard.cards.travel.a.d(this);
    L5:
        TravelFlightUtils.a(this, this.f16425l);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r5, @NonNull String[] r10, @NonNull int[] r11) {
        super.onRequestPermissionsResult(r5, r10, r11);
        StringBuilder r12 = j0.s(r5, "onRequestPermissionsResult requestCode=", " permissions=");
        r12.append(new Gson().toJson(r10));
        r12.append(" grantResults=");
        r12.append(new Gson().toJson(r11));
        m.i("TravelSettingsAty", r12.toString());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f16424k = i();
        m.i("TravelSettingsAty", "onResume map= " + this.f16424k);
        g();
        j();
        TravelFlightUtils.a(this, this.f16425l, false);
    }

    public static /* synthetic */ boolean a(TravelSettingsAty r5, boolean r10) {
        r5.f16427n = r10;
        return r10;
    }

    private HashMap<String, Boolean> i() {
        HashMap<String, Boolean> r5 = new HashMap();
        Iterator<Pair<Integer, ArrayList<m0>>> r10 = h().iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Iterator r11 = ((ArrayList) r10.next().second).iterator();
    L7:
        if (r11.hasNext() == false) goto L4;
        m0 r12 = (m0) r11.next();
        if (r12.d != 1) goto L7;
        String r13 = r12.f1066c;
        r5.put(r13, Boolean.valueOf(x.c(this, r13)));
        goto L7
    L11:
        return r5;
    }

    private void j() {
        int r5 = 0;
    L4:
        if (r5 >= this.f16423j.getChildCount()) goto L13;
        View r10 = this.f16423j.getChildAt(r5);
        Object r11 = r10.getTag();
        if ((r11 instanceof m0) == false) goto L12;
        if ("travel_register_very_zhun".equals(((m0) r11).f1066c) == false) goto L12;
        if ((r10 instanceof OCardListItem) == false) goto L12;
        this.f16426m.a((OCardListItem) r10);
    L12:
        r5 = r5 + 1;
        goto L4
    }

    @Override // c.n
    public int b() {
        return getResources().getDimensionPixelSize(R.dimen.aty_first_item_padding_top_16dp);
    }

    private void a(l0 r14, ViewGroup r15) {
        final Context r16 = r15.getContext();
        ArrayList<Pair<Integer, ArrayList<m0>>> r5 = h();
        LayoutInflater r10 = getLayoutInflater();
        int r11 = 0;
    L4:
        if (r11 >= r5.size()) goto L57;
        Pair<Integer, ArrayList<m0>> r12 = r5.get(r11);
        ((Integer) r12.first).getClass();
        ArrayList r13 = (ArrayList) r12.second;
        if (r11 <= 0) goto L8;
        View r17 = new View(r16);
        r17.setLayoutParams(new ViewGroup.LayoutParams(-1, r16.getResources().getDimensionPixelSize(R.dimen.miboard_card_margin_next)));
        r15.addView(r17);
    L8:
        int r18 = 0;
    L10:
        if (r18 >= r13.size()) goto L56;
        final m0 r19 = (m0) r13.get(r18);
        int r20 = r19.f1064a;
        String r21 = "";
        if (r20 == 0) goto L14;
        String r22 = r16.getResources().getString(r20);
    L15:
        r19.e = r22;
        int r23 = r19.f1065b;
        if (r23 == 0) goto L18;
        r21 = r16.getResources().getString(r23);
    L18:
        r19.f = r21;
        int r24 = r19.d;
        if (r24 != 2) goto L21;
        boolean r110 = true;
    L23:
        if (r110 == true) goto L25;
        com.google.android.material.snackbar.a r111 = null;
    L26:
        String r112 = r19.e;
        if (r24 == 2) goto L30;
        r111 = null;
    L30:
        OCardListItem r25 = a(r112, r111, r10, r15);
        r25.setTag(r19);
        if (r13.size() != 1) goto L33;
        r25.setCardPosition(0);
    L39:
        int r26 = r19.d;
        if (r26 != 1) goto L44;
        r25.l(false);
        r25.j(true);
        r25.setDefaultCustomEndView(1);
        OSwitch r27 = r25.getEndSwitch();
        if (r27 == null) goto L47;
        r27.setChecked(x.c(r16, r19.f1066c));
        r27.setOnCheckedChangeListener(new f(r19, r16));
    L47:
        if (TextUtils.isEmpty(r19.f) == true) goto L55;
        r25.setSubTitle(r19.f);
        CharSequence r28 = r25.getSubTitle();
        OTextView r29 = r25.f13553q;
        if (r28 != null) goto L51;
    L54:
        r29.setVisibility(8);
        goto L55
    L51:
        if (r28.length() == 0) goto L54;
        r29.setVisibility(0);
    L55:
        this.f16426m.a(r25);
        r15.addView(r25);
        r18 = r18 + 1;
        goto L10
    L44:
        if (r26 != 3) goto L47;
        r25.l(false);
        r25.j(true);
        final OButton r30 = (OButton) LayoutInflater.from(r16).inflate(R.layout.settings_item_small_btn_layout, null);
        r30.setOnClickListener(new g(this, r19, r30));
        r25.setCustomEndView(r30);
        goto L47
    L33:
        if (r18 != 0) goto L36;
        r25.setCardPosition(1);
        goto L39
    L36:
        if (r18 != (r13.size() - 1)) goto L38;
        r25.setCardPosition(3);
        goto L39
    L38:
        r25.setCardPosition(2);
        goto L39
    L25:
        r111 = new com.google.android.material.snackbar.a(5, this, r19);
        goto L26
    L21:
        r110 = false;
        goto L23
    L14:
        r22 = "";
        goto L15
    L56:
        r11 = r11 + 1;
        goto L4
    }

    public static boolean a(Context r5) {
        m.i("TravelSettingsAty", "jumpToTravelSettingsAty");
        Intent r10 = new Intent(r5, TravelSettingsAty.class);     // Catch: Throwable -> L6
        if ((r5 instanceof Activity) == true) goto L8;
        r10.addFlags(268435456);     // Catch: Throwable -> L6
    L8:
        r5.startActivity(r10);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        m.l("TravelSettingsAty", "jumpToTravelSettingsAty error. " + th);
        return false;
    }

    private /* synthetic */ void a(m0 r5, View r10) {
        m.i("TravelSettingsAty", "onClick itemData=" + r5);
        this.f16426m.a(r5.f1066c);
    }

    private static void a(m0 r5, Context r10, CompoundButton r11, boolean r12) {
        m.i("TravelSettingsAty", "onCheckedChanged itemData=" + r5 + " isChecked=" + r12);
        String r13 = r5.f1066c;
        if (TextUtils.isEmpty(r13) == true) goto L7;
        x.a(r10).edit().putBoolean(r13, r12).commit();
        return;
    }

    private /* synthetic */ void a(m0 r5, OButton r10, View r11) {
        this.f16426m.a(r5.f1066c, r10);
    }
}
