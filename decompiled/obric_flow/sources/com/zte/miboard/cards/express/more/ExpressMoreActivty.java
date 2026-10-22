package com.zte.miboard.cards.express.more;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.s;
import c.v;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.a0;
import com.obric.oui.orecyclerview.widget.x0;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.ExpressCard;
import com.zte.miboard.cards.express.ExpressListItem;
import com.zte.miboard.cards.express.data.ExpressNode;
import com.zte.miboard.cards.express.data.MoreResultBean;
import com.zte.miboard.cards.express.data.MoreResultData;
import com.zte.miboard.cards.express.data.SimpleResultBean;
import com.zte.miboard.cards.express.login.LoginActivity;
import com.zte.miboard.cards.express.login.LoginNumberActivity;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressMoreActivty extends c.n {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static MoreResultData f16313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static long f16314o;
    private RecyclerView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OCardListItem f16315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList<Object> f16318k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a0 f16319l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ExpressListItem.a f16320m;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExpressMoreActivty f16321a;

        public a(ExpressMoreActivty r5) {
            this.f16321a = r5;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r5) {
            c.m.i("ExpressMoreActivty", "express_more_search_bar_layout onClick");
            s.g(r5.getContext());
        }
    }

    public class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExpressMoreActivty f16322a;

        public b(ExpressMoreActivty r5) {
            this.f16322a = r5;
        }

        public void a(MoreResultBean r5) {
            c.m.i("ExpressMoreActivty", "getMoreExpressDatas result=" + r5);
            if (r5 != null) goto L5;
        L7:
            if (r5 != null) goto L9;
            return;
        L9:
            if (r5.getResult() != 0) goto L11;
            return;
        L11:
            if ("system_time_error".equalsIgnoreCase(r5.message) == false) goto L17;
            Toast.makeText(this.f16322a.getApplicationContext(), R.string.express_check_system_time_try_again, 0).show();
            return;
        L17:
            return;
        L5:
            if (r5.getResult() != 0) goto L7;
            ExpressMoreActivty.a(this.f16322a, r5.getMoreResultData());
            ExpressMoreActivty.a(System.currentTimeMillis());
        }

        @Override // mt.u
        public void onComplete() {
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            c.m.j("ExpressMoreActivty", "getMoreExpressDatas onError", r5);
        }

        @Override // mt.u
        public /* bridge */ /* synthetic */ void onNext(Object r5) {
            a((MoreResultBean) r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
        }
    }

    public class c extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExpressMoreActivty f16323a;

        public c(ExpressMoreActivty r5) {
            this.f16323a = r5;
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        public int getItemCount() {
            return ExpressMoreActivty.a(this.f16323a).size();
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        public int getItemViewType(int r5) {
            Object r10 = ExpressMoreActivty.a(this.f16323a).get(r5);
            if ((r10 instanceof ExpressNode) == false) goto L7;
            return 1;
        L7:
            if ((r10 instanceof k) == false) goto L11;
            return 4;
        L11:
            if ((r10 instanceof Integer) == true) goto L13;
            return 0;
        L13:
            return ((Integer) r10).intValue();
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull x0 r5, int r10) {
            onBindViewHolder((n) r5, r10);
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        @NonNull
        public /* bridge */ /* synthetic */ x0 onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
            return onCreateViewHolder(r5, r10);
        }

        public void onBindViewHolder(@NonNull n r5, int r10) {
            Object r11 = ExpressMoreActivty.a(this.f16323a).get(r10);
            r5.itemView.setTag(r11);
            r5.a(ExpressMoreActivty.c(this.f16323a), r10);
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        @NonNull
        public n onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
            if (r10 != 1) goto L10;
            View r11 = LayoutInflater.from(r5.getContext()).inflate(R.layout.express_list_item, r5, false);
            if ((r11 instanceof ExpressListItem) == false) goto L8;
            ((ExpressListItem) r11).setItemCallback(ExpressMoreActivty.b(this.f16323a));
        L8:
            return new i(r11);
        L10:
            if (r10 != 2) goto L14;
            return new j(LayoutInflater.from(r5.getContext()).inflate(R.layout.express_item_footer, r5, false));
        L14:
            if (r10 == 4) goto L16;
            c.m.l("ExpressMoreActivty", "onCreateViewHolder error viewType=" + r10);
            return new l(LayoutInflater.from(r5.getContext()).inflate(R.layout.group_divider, r5, false));
        L16:
            return new m(LayoutInflater.from(r5.getContext()).inflate(R.layout.express_item_header, r5, false));
        }
    }

    public class d implements ExpressListItem.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExpressMoreActivty f16324a;

        public d(ExpressMoreActivty r5) {
            this.f16324a = r5;
        }

        @Override // com.zte.miboard.cards.express.ExpressListItem.a
        public void a(ExpressNode r5) {
            this.f16324a.b(r5);
        }
    }

    public class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExpressNode f16326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExpressMoreActivty f16327c;

        public e(ExpressMoreActivty r5, Context r10, ExpressNode r11) {
            this.f16327c = r5;
            this.f16325a = r10;
            this.f16326b = r11;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r5, int r10) {
            this.f16327c.a(this.f16325a, this.f16326b);
        }
    }

    public class f implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExpressMoreActivty f16328a;

        public f(ExpressMoreActivty r5) {
            this.f16328a = r5;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r5, int r10) {
        }
    }

    public class g implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f16329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f16330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExpressNode f16331c;

        public g(long r5, Context r10, ExpressNode r11) {
            this.f16329a = r5;
            this.f16330b = r10;
            this.f16331c = r11;
        }

        public void a(SimpleResultBean r10) {
            c.m.i("ExpressMoreActivty", "deleteExpressInfoInNet isMark onNext result=" + r10.getResult() + " hao=" + (System.currentTimeMillis() - this.f16329a) + "ms");
            if (r10.getResult() != 0) goto L5;
            boolean r11 = true;
        L6:
            ExpressMoreActivty.a(this.f16330b, this.f16331c, r11);
            return;
        L5:
            r11 = false;
            goto L6
        }

        @Override // mt.u
        public void onComplete() {
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            c.m.j("ExpressMoreActivty", "deleteExpressInfoInNet isMark onError: ", r5);
            ExpressMoreActivty.a(this.f16330b, this.f16331c, false);
        }

        @Override // mt.u
        public /* bridge */ /* synthetic */ void onNext(Object r5) {
            a((SimpleResultBean) r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
        }
    }

    public class h implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f16332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f16333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExpressNode f16334c;

        public h(long r5, Context r10, ExpressNode r11) {
            this.f16332a = r5;
            this.f16333b = r10;
            this.f16334c = r11;
        }

        public void a(SimpleResultBean r10) {
            c.m.i("ExpressMoreActivty", "deleteExpressInfoInNet not isMark onNext result=" + r10.getResult() + " hao=" + (System.currentTimeMillis() - this.f16332a) + "ms");
            if (r10.getResult() != 0) goto L5;
            boolean r11 = true;
        L6:
            ExpressMoreActivty.a(this.f16333b, this.f16334c, r11);
            return;
        L5:
            r11 = false;
            goto L6
        }

        @Override // mt.u
        public void onComplete() {
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            c.m.j("ExpressMoreActivty", "deleteExpressInfoInNet not isMark onError", r5);
            ExpressMoreActivty.a(this.f16333b, this.f16334c, false);
        }

        @Override // mt.u
        public /* bridge */ /* synthetic */ void onNext(Object r5) {
            a((SimpleResultBean) r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
        }
    }

    public static class i extends n {
        public i(@NonNull View r5) {
            super(r5);
        }

        @Override // com.zte.miboard.cards.express.more.ExpressMoreActivty.n
        public void a(boolean r5, int r10) {
            super.a(r5, r10);
            Object r11 = this.itemView.getTag();
            if ((r11 instanceof ExpressNode) == true) goto L5;
            return;
        L5:
            ExpressNode r12 = (ExpressNode) r11;
            View r13 = this.itemView;
            if ((r13 instanceof ExpressListItem) == false) goto L9;
            ((ExpressListItem) r13).a(r12, r5);
            return;
        }
    }

    public static class j extends n {
        public j(@NonNull View r5) {
            super(r5);
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16336b;

        private k(int r5, int r10) {
            this.f16335a = r5;
            this.f16336b = r10;
        }

        public static /* synthetic */ int a(k r5) {
            return r5.f16335a;
        }

        public static /* synthetic */ int b(k r5) {
            return r5.f16336b;
        }

        public /* synthetic */ k(int r5, int r10, a r11) {
            this(r5, r10);
        }
    }

    public static class l extends n {
        public l(@NonNull View r5) {
            super(r5);
            int r10 = r5.getResources().getDimensionPixelSize(R.dimen.express_more_aty_left_right_padding);
            r5.setPadding(r10, r5.getPaddingTop(), r10, r5.getPaddingBottom());
        }
    }

    public static class m extends n {
        public m(@NonNull View r5) {
            super(r5);
        }

        @Override // com.zte.miboard.cards.express.more.ExpressMoreActivty.n
        public void a(boolean r5, int r10) {
            super.a(r5, r10);
            Object r11 = this.itemView.getTag();
            if ((r11 instanceof k) == true) goto L5;
            return;
        L5:
            k r12 = (k) r11;
            OSectionTitleBar r13 = (OSectionTitleBar) this.itemView.findViewById(R.id.express_item_header_title);
            if (r13 == null) goto L8;
            r13.setTitleText(this.itemView.getResources().getString(k.a(r12)) + "(" + k.b(r12) + ")");
        L8:
            if (r10 != 0) goto L10;
            int r14 = 0;
        L11:
            View r15 = this.itemView;
            r15.setPadding(r15.getPaddingLeft(), r14, this.itemView.getPaddingRight(), this.itemView.getPaddingBottom());
            return;
        L10:
            r14 = this.itemView.getResources().getDimensionPixelSize(R.dimen.express_more_group_item_padding_top);
            goto L11
        }
    }

    public static class n extends x0 {
        public n(@NonNull View r5) {
            super(r5);
        }

        public void a(boolean r5, int r10) {
        }
    }

    public ExpressMoreActivty() {
        this.f16316i = false;
        this.f16317j = false;
        this.f16318k = new ArrayList();
        this.f16319l = new c(this);
        this.f16320m = new d(this);
    }

    public static /* synthetic */ void a(ExpressMoreActivty r5, MoreResultData r10) {
        r5.a(r10);
    }

    public static /* synthetic */ ExpressListItem.a b(ExpressMoreActivty r5) {
        return r5.f16320m;
    }

    public static /* synthetic */ boolean c(ExpressMoreActivty r5) {
        return r5.f16316i;
    }

    private /* synthetic */ void d(View r5) {
        a(false, false);
    }

    private boolean h() {
        long r5 = f16314o;
        if (r5 != 0) goto L5;
    L10:
        return true;
    L5:
        if (r5 > System.currentTimeMillis()) goto L10;
        if ((System.currentTimeMillis() - f16314o) > 60000) goto L10;
        return false;
    }

    public static /* synthetic */ void i(ExpressMoreActivty r5, View r10) {
        r5.b(r10);
    }

    public static /* synthetic */ void j(ExpressMoreActivty r5, View r10) {
        r5.d(r10);
    }

    public static /* synthetic */ void k(ExpressMoreActivty r5, View r10) {
        r5.c(r10);
    }

    private void l() {
        Intent r5 = new Intent(getApplicationContext(), LoginActivity.class);
        if (getIntent() != null) goto L5;
    L7:
        r5.addFlags(268435456);
        startActivity(r5);
        return;
    L5:
        if (getIntent().getBooleanExtra("check_statement", false) == false) goto L7;
        r5.putExtra("check_statement", true);
        goto L7
    }

    private void m() {
        Intent r5 = new Intent(this, LoginNumberActivity.class);
        r5.addFlags(268435456);
        startActivity(r5);
    }

    public void g() {
        c.m.i("ExpressMoreActivty", "getMoreExpressDatas isNeedRefresh=" + h());
        if (v.b(getApplicationContext()) == true) goto L7;
        Toast.makeText(getApplicationContext(), R.string.net_connected_error, 1).show();
        return;
    L7:
        if (h() == true) goto L9;
        return;
    L9:
        c.m.f(getApplicationContext(), new b(this));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        c.m.i("ExpressMoreActivty", "onBackPressed mIsDeleteMode=" + this.f16316i);
        if (this.f16316i == false) goto L6;
        a(false, false);
        return;
    L6:
        super.onBackPressed();
    }

    @Override // c.n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        c.m.i("ExpressMoreActivty", "onCreate");
        setContentView(R.layout.express_more_aty);
        k();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        c.m.i("ExpressMoreActivty", "onDestroy");
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ExpressCard.a(this);
        c.m.i("ExpressMoreActivty", "onResume " + ExpressCard.e());
        if (ExpressCard.e() == true) goto L6;
        l();
        finish();
        return;
    L6:
        this.f16315h.setSubTitle(String.format(getResources().getString(R.string.express_bind_phone_real_number), new Object[]{Integer.valueOf(s.b(this).size())}));
        g();
    }

    public static /* synthetic */ long a(long r5) {
        f16314o = r5;
        return r5;
    }

    public static void b(Context r5, ExpressNode r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        c.m.i("ExpressMoreActivty", "deleteExpressInfoInNet");
        long r11 = System.currentTimeMillis();
        if (r10.getMark() != 1) goto L7;
        c.m.k(r5, r10.getMailNo(), r10.getExpressCode(), new g(r11, r5, r10));
        return;
    L7:
        c.m.e(r5, r10.getMailNo(), new h(r11, r5, r10));
    }

    private /* synthetic */ void c(View r5) {
        a(true, false);
    }

    private void i() {
        OButtonGroup r5 = c().getEndButtonGroup();
        LinearLayout r10 = r5.A;
        if (r10 != null) goto L5;
        ps.a.c("OButtonGroup", "itemContainer is null");
        return;
    L5:
        Intrinsics.checkNotNull(r10);
        r10.removeAllViews();
        r5.x();
        if (r5.getItemCount() != 0) goto L8;
        r5.setVisibility(8);
        return;
    L8:
        r5.setVisibility(0);
    }

    public static void j() {
        f16314o = 0;
    }

    private void k() {
        findViewById(R.id.express_more_search_layout).setOnClickListener(new a(this));
        OCardListItem r5 = (OCardListItem) findViewById(R.id.express_more_aty_bind_phone_number_ocard_list_item);
        this.f16315h = r5;
        r5.setOnContentClickListener(new com.zte.miboard.cards.express.more.a(this, 0));
        RecyclerView r10 = (RecyclerView) findViewById(R.id.express_more_aty_recycler_view);
        this.g = r10;
        r10.getContext();
        r10.setLayoutManager(new com.obric.oui.orecyclerview.widget.s());
        this.g.setAdapter(this.f16319l);
        a(f16313n);
        this.f16319l.notifyDataSetChanged();
    }

    public static /* synthetic */ ArrayList a(ExpressMoreActivty r5) {
        return r5.f16318k;
    }

    private /* synthetic */ void b(View r5) {
        m();
    }

    public static /* synthetic */ void a(Context r5, ExpressNode r10, boolean r11) {
        b(r5, r10, r11);
    }

    private static void b(Context r5, ExpressNode r10, boolean r11) {
        ExpressCard.a(r5, r10, !r11);
        if (r11 == false) goto L8;
        ExpressCard.q();
        ExpressCard.a(r5);
        if ((r5 instanceof ExpressMoreActivty) == false) goto L9;
        ((ExpressMoreActivty) r5).g();
        return;
    L9:
        return;
    }

    public void a(Context r5, ExpressNode r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isAvailable() == false) goto L9;
        c.m.i("ExpressMoreActivty", "deleteExpressInfo");
        ExpressCard.b(r10);
        a(r10);
        b(r5, r10);
        return;
    }

    public void b(ExpressNode r5) {
        com.obric.oui.dialog.v2.alert.e r10 = new com.obric.oui.dialog.v2.alert.e(this);
        int r11 = R.string.express_delete_info;
        CharSequence r12 = r10.f.getText(r11);
        r10.f13159i = false;
        r10.g = r12;
        r10.f13158h = getResources().getString(R.string.express_delete_info_tips);
        r10.e(getResources().getString(R.string.dialog_button_cancel), new f(this));
        r10.g(getResources().getString(R.string.express_delete_info), new e(this, this, r5));
        com.obric.oui.dialog.v2.alert.b r13 = r10.a();
        ((OButton) r13.rootView.findViewById(R.id.actionPositive)).setTextColor(getColor(R.color.oui_functional_red_6));     // Catch: Throwable -> L5
    L7:
        r13.show();
        return;
    L5:
        th = move-exception;
        c.m.j("ExpressMoreActivty", "showDeleteExpressConfirmDialog error", th);
        goto L7
    }

    public void a(ExpressNode r5) {
        MoreResultData r10 = f16313n;
        if (r10 == null) goto L5;
        r10.removeExpressNode(r5);
    L5:
        a(f16313n);
    }

    private void a(boolean r5, boolean r10) {
        if (this.f16317j == true) goto L5;
    L6:
        this.f16317j = true;
        this.f16316i = r5;
        OButtonGroup r11 = c().getEndButtonGroup();
        LinearLayout r12 = r11.A;
        if (r12 != null) goto L9;
        ps.a.c("OButtonGroup", "itemContainer is null");
    L13:
        if (r5 == true) goto L16;
        c().setEndButtonGroupStyle(R.style.TitleBarEndBtnDeleteStyle);
        OFloatingTitleBar r13 = c();
        int r14 = R.drawable.oui_icon_oic_trashcan;
        com.zte.miboard.cards.express.more.a r15 = new com.zte.miboard.cards.express.more.a(this, 1);
    L15:
        r13.c(r14, 0, r15);
        if (r10 == true) goto L21;
        this.f16319l.notifyDataSetChanged();
        return;
    L21:
        return;
    L16:
        c().setEndButtonGroupStyle(R.style.TitleBarEndBtnDeleteDoneStyle);
        r13 = c();
        r14 = R.drawable.oui_icon_oic_checkmark_thick;
        r15 = new com.zte.miboard.cards.express.more.a(this, 2);
        goto L15
    L9:
        Intrinsics.checkNotNull(r12);
        r12.removeAllViews();
        r11.x();
        if (r11.getItemCount() != 0) goto L12;
        r11.setVisibility(8);
        goto L13
    L12:
        r11.setVisibility(0);
        goto L13
    L5:
        if (this.f16316i != r5) goto L6;
    }

    private void a(MoreResultData r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        f16313n = r10;
        Iterator<ExpressNode> r5 = ExpressCard.getAllNeedDeleteList().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ExpressNode r11 = r5.next();
        if (r11 == null) goto L6;
        ExpressCard.b(r10.getToTake(), r11);
        ExpressCard.b(r10.getUnsign(), r11);
        ExpressCard.b(r10.getSign(), r11);
        goto L6
    L10:
        ArrayList r12 = new ArrayList();
        a r13 = null;
        if (r10.getToTake() == null) goto L16;
        if (r10.getToTake().isEmpty() == true) goto L16;
        r12.add(new k(R.string.express_status_totake, r10.getToTake().size(), r13));
        r12.addAll(r10.getToTake());
    L16:
        if (r10.getUnsign() == null) goto L21;
        if (r10.getUnsign().isEmpty() == true) goto L21;
        r12.isEmpty();
        r12.add(new k(R.string.express_status_unsign, r10.getUnsign().size(), r13));
        r12.addAll(r10.getUnsign());
    L21:
        if (r10.getRecentSign() == null) goto L26;
        if (r10.getRecentSign().isEmpty() == true) goto L26;
        r12.isEmpty();
        r12.add(new k(R.string.express_status_recent_sign, r10.getRecentSign().size(), r13));
        r12.addAll(r10.getRecentSign());
    L26:
        if (r10.getSign() != null) goto L28;
    L30:
        boolean r14 = r12.isEmpty();
        if (r14 == true) goto L33;
        r12.add(2);
    L33:
        this.f16318k.clear();
        this.f16318k.addAll(r12);
        this.f16319l.notifyDataSetChanged();
        if (r14 == false) goto L36;
        i();
        return;
    L36:
        a(this.f16316i, true);
        return;
    L28:
        if (r10.getSign().isEmpty() == true) goto L30;
        r12.isEmpty();
        r12.add(new k(R.string.express_status_sign, r10.getSign().size(), r13));
        r12.addAll(r10.getSign());
        goto L30
    }
}
