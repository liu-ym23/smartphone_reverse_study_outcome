package com.zte.miboard.cards.express;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.k0;
import c.m;
import c.s;
import c.s0;
import c.v;
import c.x;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zte.miboard.cards.CardParentCallback;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.data.ExpressNode;
import com.zte.miboard.cards.express.data.LimitedResultBean;
import com.zte.miboard.cards.express.data.MoreResultData;
import com.zte.miboard.cards.express.login.LoginActivity;
import com.zte.miboard.cards.express.more.ExpressMoreActivty;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressCard extends c.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile int f16272h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f16273i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected static long f16274j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f16275k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Boolean f16276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static ArrayList<e> f16277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static ArrayList<ExpressNode> f16278n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f16279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f16280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f16281c;
    private ArrayList<ExpressNode> d;
    private HashMap<String, ArrayList<String>> e;
    private boolean f;
    private e g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExpressCard f16282a;

        public a(ExpressCard r5) {
            this.f16282a = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16282a.o();
        }
    }

    public class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f16283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExpressCard f16284b;

        public b(ExpressCard r5, long r10) {
            this.f16284b = r5;
            this.f16283a = r10;
        }

        public void a(LimitedResultBean r10) {
            ExpressCard.a(false);
            m.i("ExpressCard", "getLimitedExpressDatas hao=" + (System.currentTimeMillis() - this.f16283a) + "ms limitResult=" + r10);
            if (r10 != null) goto L5;
        L40:
            m.l("ExpressCard", "getLimitedExpressDatas result error, result=" + r10);
            return;
        L5:
            if (r10.isAvailable() == false) goto L40;
            if (ExpressCard.a().booleanValue() == false) goto L11;
            m.i("ExpressCard", "getLimitedExpressDatas sFirstRequestExpressLimit sfSubscribeResult=" + r10.sfSubscribeResult + " sfSubscribeMessage=" + r10.sfSubscribeMessage);
            if (r10.isSFSubscribeResultOk() == false) goto L11;
            ExpressCard.f(this.f16284b.getContext());
        L11:
            ExpressCard.f16274j = System.currentTimeMillis();
            ArrayList r5 = new ArrayList();
            HashMap r11 = new HashMap();
            if (r10.getStatusMap() == null) goto L31;
            Iterator<String> r12 = r10.getStatusMap().keySet().iterator();
        L15:
            if (r12.hasNext() == false) goto L31;
            String r13 = r12.next();
            if (TextUtils.isEmpty(r13) == true) goto L15;
            if (r10.getStatusMap().get(r13) == null) goto L15;
            if (r10.getStatusMap().get(r13).isEmpty() == true) goto L15;
            ArrayList r14 = new ArrayList();
            Iterator<String> r15 = r10.getStatusMap().get(r13).iterator();
        L24:
            if (r15.hasNext() == false) goto L30;
            String r16 = r15.next();
            if (TextUtils.isEmpty(r16) == true) goto L24;
            if (r14.contains(r16) == true) goto L24;
            r14.add(r16);
            goto L24
        L30:
            r11.put(r13, r14);
        L31:
            Iterator<ExpressNode> r17 = r10.getData().iterator();
        L33:
            if (r17.hasNext() == false) goto L39;
            ExpressNode r18 = r17.next();
            if (r18 == null) goto L33;
            if (r18.isAvailable() == false) goto L33;
            r5.add(r18);
            goto L33
        L39:
            ExpressCard.a(this.f16284b, r11);
            ExpressCard.a(this.f16284b, r5);
            m.i("ExpressCard", "getLimitedExpressDatas mStatusMap=" + ExpressCard.a(this.f16284b).size());
            m.i("ExpressCard", "getLimitedExpressDatas mShowExpressDataList=" + ExpressCard.b(this.f16284b).size());
            ExpressCard.c(this.f16284b);
        }

        @Override // mt.u
        public void onComplete() {
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            ExpressCard.a(false);
            m.j("ExpressCard", "getLimitedExpressDatas onError", r5);
        }

        @Override // mt.u
        public /* bridge */ /* synthetic */ void onNext(Object r5) {
            a((LimitedResultBean) r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
        }
    }

    public class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExpressCard f16285a;

        public c(ExpressCard r5) {
            this.f16285a = r5;
        }

        @Override // com.zte.miboard.cards.express.ExpressCard.e
        public void a(ExpressNode r5) {
            ExpressCard.c(this.f16285a);
        }

        @Override // com.zte.miboard.cards.express.ExpressCard.e
        public void b() {
            this.f16285a.onRefresh();
        }

        @Override // com.zte.miboard.cards.express.ExpressCard.e
        public void a() {
            ExpressCard.c(this.f16285a);
        }
    }

    public class d extends TypeToken<ArrayList<ExpressNode>> {
        public d() {
        }
    }

    public interface e {
        void a();

        void a(ExpressNode r5);

        void b();
    }

    static {
        f16277m = new ArrayList();
        f16278n = new ArrayList();
    }

    public ExpressCard(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(ExpressCard r5, View r10) {
        r5.a(r10);
    }

    public static /* synthetic */ ArrayList b(ExpressCard r5) {
        return r5.d;
    }

    public static /* synthetic */ void c(ExpressCard r5) {
        r5.r();
    }

    public static void d() {
        f16273i = true;
        q();
    }

    public static boolean e() {
        if (f16272h <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean f() {
        long r5 = f16274j;
        if (r5 != 0) goto L5;
    L10:
        return true;
    L5:
        if (r5 > System.currentTimeMillis()) goto L10;
        if ((System.currentTimeMillis() - f16274j) > 60000) goto L10;
        return false;
    }

    private void g() {
        Intent r5 = new Intent(getContext(), ExpressMoreActivty.class);
        r5.addFlags(268435456);
        s0.g(getContext(), r5);
    }

    public static ArrayList<ExpressNode> getAllNeedDeleteList() {
        return f16278n;
    }

    private void getLimitedExpressDatas() {
        if (f() == true) goto L7;
        m.n("ExpressCard", "getLimitedExpressDatas return, no need refresh");
        return;
    L7:
        if (e() == true) goto L11;
        m.n("ExpressCard", "getLimitedExpressDatas return, not login");
        return;
    L11:
        if (v.b(getContext()) == true) goto L14;
        m.n("ExpressCard", "getLimitedExpressDatas return, net error");
        return;
    L14:
        long r5 = System.currentTimeMillis();
        if (f16276l != null) goto L18;
        f16276l = Boolean.valueOf(c(getContext()));
    L18:
        if (f16276l.booleanValue() == true) goto L20;
    L22:
        m.g(getContext(), f16276l.booleanValue(), new b(this, r5));
        return;
    L20:
        if (f16275k == true) goto L22;
        f16275k = true;
        goto L22
    }

    public static int getLoginUserCount() {
        return f16272h;
    }

    public static void h() {
        Iterator<e> r5 = f16277m.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        e r10 = r5.next();
        if (r10 == null) goto L4;
        r10.a();
        goto L4
    }

    public static void i() {
        Iterator<e> r5 = f16277m.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        e r10 = r5.next();
        if (r10 == null) goto L4;
        r10.b();
        goto L4
    }

    private void m() {
        this.f16280b.postDelayed(this.f16281c, 120000);
    }

    private void p() {
        this.f16280b.removeCallbacks(this.f16281c);
    }

    public static void q() {
        f16274j = 0;
        ExpressMoreActivty.j();
    }

    private void r() {
        ViewGroup r5 = this.f16279a;
        if (r5 != null) goto L6;
        m.l("ExpressCard", "refreshViewStatus mExpressView null return");
        return;
    L6:
        TextView r10 = (TextView) r5.findViewById(R.id.card_header_title);
        ViewGroup r11 = (ViewGroup) this.f16279a.findViewById(R.id.express_card_no_data_layout);
        TextView r12 = (TextView) r11.findViewById(R.id.express_card_no_data_layout_title);
        ExpressCardListContainer r13 = (ExpressCardListContainer) this.f16279a.findViewById(R.id.express_card_list_container);
        a(this.d, f16278n);
        boolean r14 = true;
        int r15 = 0;
        if (e() == true) goto L11;
        r10.setText(R.string.express_bind_phone);
        int r16 = R.string.express_login_tips_incard;
    L9:
        r12.setText(r16);
    L37:
        if (r14 == false) goto L39;
        int r17 = 0;
    L40:
        r11.setVisibility(r17);
        if (r14 == false) goto L43;
        r15 = 8;
    L43:
        r13.setVisibility(r15);
        r13.a(this.d);
        return;
    L39:
        r17 = 8;
        goto L40
    L11:
        if (this.d.isEmpty() == false) goto L13;
        r10.setText(R.string.express_see_more_express);
        r16 = R.string.express_no_data_info;
        goto L9
    L13:
        ArrayList r18 = new ArrayList();
        Iterator<String> r19 = this.e.keySet().iterator();
        int r20 = 0;
    L15:
        if (r19.hasNext() == false) goto L26;
        String r21 = r19.next();
        if (TextUtils.isEmpty(r21) == true) goto L15;
        if (this.e.get(r21) == null) goto L15;
        if (this.e.get(r21).isEmpty() == true) goto L15;
        r20 = r20 + this.e.get(r21).size();
        if (r18.contains(r21) == true) goto L15;
        r18.add(r21);
        goto L15
    L26:
        if (r18.isEmpty() == false) goto L29;
        String r22 = getResources().getString(R.string.express_see_more_express);
    L35:
        r10.setText(r22);
        r14 = false;
        goto L37
    L29:
        if (r18.size() != 1) goto L34;
        String r23 = (String) r18.get(0);
        HashMap<String, Integer> r24 = MoreResultData.STATUS_MAP_KEY_WORDING_MAP;
        if (r24.containsKey(r23) == false) goto L33;
        r23 = getResources().getString(r24.get(r23).intValue());
    L33:
        r22 = String.format(getResources().getString(R.string.express_some_express_detail_status), new Object[]{Integer.valueOf(r20), r23});
        goto L35
    L34:
        r22 = String.format(getResources().getString(R.string.express_some_express_status), new Object[]{Integer.valueOf(r20)});
        goto L35
    }

    @Override // com.zte.miboard.cards.CardCallback
    public boolean isContentReady() {
        return true;
    }

    public void j() {
        a(this.g);
    }

    public void k() {
        m.i("ExpressCard", "onCardRemoved");
        p();
        b(this.g);
        q();
        s.e(true);
    }

    public void l() {
        m.i("ExpressCard", "onClickLogin");
    }

    public void n() {
        m.i("ExpressCard", "refreshIfNeed");
        getLimitedExpressDatas();
    }

    public void o() {
        m.i("ExpressCard", "removeDataAfterDelay");
        s.e(true);
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onDestroy() {
        m.i("ExpressCard", "onDestroy");
        k();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f16279a = this;
        findViewById(R.id.card_header_option).setVisibility(0);
        this.f16279a.findViewById(R.id.card_header_icon).setVisibility(8);
        this.f16279a.findViewById(R.id.card_header_title_right_indicator).setVisibility(0);
        final int r5 = 0;
        this.f16279a.findViewById(R.id.card_header_title_layout).setOnClickListener(new com.zte.miboard.cards.express.a(this, r5));
        this.f16279a.findViewById(R.id.express_card_no_data_layout).setOnClickListener(new com.zte.miboard.cards.express.a(this, r5));
        final int r10 = 1;
        this.f16279a.findViewById(R.id.card_header_option_bg_img).setOnClickListener(new com.zte.miboard.cards.express.a(this, r10));
        j();
        b();
        r();
        getLimitedExpressDatas();
    }

    @Override // com.zte.miboard.cards.CardCallback
    public Bundle onParentPopupMenuItemClick(View r5, Bundle r10) {
        return null;
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onPause(boolean r5) {
        m.i("ExpressCard", "onPause isInMiBoard=" + r5);
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onRefresh() {
        m.i("ExpressCard", "onRefresh");
        q();
        if (e() == false) goto L6;
        getLimitedExpressDatas();
        return;
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onResume(boolean r5) {
        m.i("ExpressCard", "onResume isInMiBoard=" + r5);
        if (f16273i == false) goto L6;
        m.i("ExpressCard", "onResume sForceRefresh");
        f16273i = false;
        n();
        return;
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onSlideIn() {
        String r5 = k0.f1060a;
        m.i("ExpressCard", "onSlideIn getVersionName=16.0.000.000.2606301031-964f71b");
        p();
        if (e() == false) goto L6;
        e(getContext());
        getLimitedExpressDatas();
        return;
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void onSlideOut() {
        m.i("ExpressCard", "onSlideOut");
        m();
    }

    @Override // com.zte.miboard.cards.CardCallback
    public void setCardParentCallback(CardParentCallback r5) {
    }

    public ExpressCard(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public static /* synthetic */ boolean a(boolean r5) {
        f16275k = r5;
        return r5;
    }

    private void b() {
        b(getContext());
        m.i("ExpressCard", "checkHasLogin: isLogin=" + e());
        if (this.f == e()) goto L5;
        a(e(), this.f);
    L5:
        this.f = e();
    }

    private void c() {
        Intent r5 = new Intent(getContext(), LoginActivity.class);
        r5.addFlags(268435456);
        s0.g(getContext(), r5);
        l();
    }

    private static void d(Context r5) {
        String r10 = x.a(r5).getString("express_local_delete_but_net_not", null);
        f16278n.clear();
        if (r10 == null) goto L6;
        f16278n.addAll((Collection) new Gson().fromJson(r10, new d().getType()));
        m.i("ExpressCard", "readLocalDeleteButNetNot sNeedDeleteList.size= " + f16278n.size());
        return;
    }

    private static void e(Context r5) {
        if (f16278n.isEmpty() == false) goto L5;
        return;
    L5:
        if (v.b(r5) == false) goto L9;
        m.i("ExpressCard", "reportNeedDeleteIfNeed sNeedDeleteList.size= " + f16278n.size());
        ExpressMoreActivty.b(r5, f16278n.get(0));
        return;
    }

    public static void f(Context r5) {
        m.i("ExpressCard", "saveFirstRequestExpressLimit false");
        f16276l = Boolean.FALSE;
        x.a(r5).edit().putBoolean("first_request_express_limit", false).apply();
    }

    public ExpressCard(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f16280b = new Handler(Looper.getMainLooper());
        this.f16281c = new a(this);
        this.d = new ArrayList();
        this.e = new HashMap();
        this.f = e();
        this.g = new c(this);
        String r12 = k0.f1060a;
        m.i("ExpressCard", "init getVersionName=16.0.000.000.2606301031-964f71b");
        d(r5);
        q();
    }

    public static /* synthetic */ Boolean a() {
        return f16276l;
    }

    public static void b(Context r5) {
        f16272h = s.b(r5).size();
        h();
    }

    private static boolean c(Context r5) {
        return x.a(r5).getBoolean("first_request_express_limit", true);
    }

    public static /* synthetic */ HashMap a(ExpressCard r5) {
        return r5.e;
    }

    public static void c(ExpressNode r5) {
        ExpressNode r10 = a(f16278n, r5);
        if (r10 == null) goto L6;
        f16278n.remove(r10);
        return;
    }

    public static /* synthetic */ HashMap a(ExpressCard r5, HashMap r10) {
        r5.e = r10;
        return r10;
    }

    public static boolean b(List<ExpressNode> r5, ExpressNode r10) {
        ExpressNode r11 = a(r5, r10);
        if (r11 == null) goto L6;
        r5.remove(r11);
        return true;
    L6:
        return false;
    }

    public static /* synthetic */ ArrayList a(ExpressCard r5, ArrayList r10) {
        r5.d = r10;
        return r10;
    }

    public static void b(ExpressNode r5) {
        a(r5);
        Iterator<e> r10 = f16277m.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        e r11 = r10.next();
        if (r11 == null) goto L4;
        r11.a(r5);
        goto L4
    }

    private static void a(e r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (f16277m.contains(r5) == true) goto L8;
        f16277m.add(r5);
        return;
    }

    public void b(View r5) {
        TextView r10 = (TextView) findViewById(R.id.card_header_title);
        if (r10 != null) goto L5;
        m.l("ExpressCard", "onExpressCardTitleOrInfoLayoutClick view error, view=" + r5);
        return;
    L5:
        if (getResources().getString(R.string.express_bind_phone).equals(r10.getText()) == false) goto L7;
        m.i("ExpressCard", "onExpressCardTitleOrInfoLayoutClick clickLogin");
        c();
        return;
    L7:
        m.i("ExpressCard", "onExpressCardTitleOrInfoLayoutClick startMoreExpressInfo");
        g();
    }

    private static void a(ExpressNode r5) {
        if (a(f16278n, r5) != null) goto L6;
        f16278n.add(r5);
        return;
    }

    private static void b(e r5) {
        f16277m.remove(r5);
    }

    public static void a(Context r5) {
        m.i("ExpressCard", "callCustomContentCardRefresh size=" + f16277m.size());
        i();
    }

    public static ExpressNode a(List<ExpressNode> r5, ExpressNode r10) {
        if (r5 == null) goto L14;
        if (r10 == null) goto L14;
        if (TextUtils.isEmpty(r10.getMailNo()) == true) goto L14;
        Iterator<ExpressNode> r11 = r5.iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        ExpressNode r12 = r11.next();
        if (r10.getMailNo().equals(r12.getMailNo()) == false) goto L10;
        return r12;
    L14:
        return null;
    }

    private /* synthetic */ void a(View r5) {
        s.g(getContext());
    }

    public static boolean a(List<ExpressNode> r5, List<ExpressNode> r10) {
        if (r5 != null) goto L5;
    L17:
        return false;
    L5:
        if (r5.isEmpty() == true) goto L17;
        if (r10 == null) goto L17;
        if (r10.isEmpty() == true) goto L17;
        Iterator<ExpressNode> r11 = r10.iterator();
        boolean r12 = true;
    L12:
        if (r11.hasNext() == false) goto L16;
        if (b(r5, r11.next()) == true) goto L12;
        r12 = false;
        goto L12
    L16:
        return r12;
    }

    public void a(boolean r5, boolean r10) {
        m.i("ExpressCard", "onLoginStateChanged hasLogin=" + r5 + " hasLoginOld=" + r10);
    }

    public static void a(Context r5, ExpressNode r10, boolean r11) {
        if (r10 == null) goto L6;
        if (r11 == false) goto L5;
        a(r10);
        goto L6
    L5:
        c(r10);
    L6:
        String r12 = new Gson().toJson(f16278n);
        x.a(r5).edit().putString("express_local_delete_but_net_not", r12).apply();
    }
}
