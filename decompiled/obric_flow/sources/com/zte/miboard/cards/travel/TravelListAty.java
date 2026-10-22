package com.zte.miboard.cards.travel;

import ai.j0;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.m;
import c.n;
import c.o;
import c.s0;
import cn.nubia.neopush.commons.AppUtil;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.a0;
import com.obric.oui.orecyclerview.widget.x0;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.k;
import com.obric.oui.swipeaction.l;
import com.obric.oui.text.OTextView;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.travel.data.FlightData;
import com.zte.miboard.cards.travel.data.HotelData;
import com.zte.miboard.cards.travel.data.MatchData;
import com.zte.miboard.cards.travel.data.TrainData;
import com.zte.miboard.cards.travel.data.TravelData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class TravelListAty extends n {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Comparator<String> f16398m = null;
    private boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RecyclerView f16399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<TravelData> f16401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList<Object> f16402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a0 f16403l;

    public class a extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelListAty f16404a;

        public a(TravelListAty r5) {
            this.f16404a = r5;
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        public int getItemCount() {
            return TravelListAty.a(this.f16404a).size();
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        public int getItemViewType(int r5) {
            Object r10 = TravelListAty.a(this.f16404a).get(r5);
            if ((r10 instanceof TravelData) == false) goto L7;
            return 3;
        L7:
            if ((r10 instanceof Long) == false) goto L11;
            return 2;
        L11:
            if ((r10 instanceof Integer) == true) goto L13;
            return 1;
        L13:
            if (((Integer) r10).intValue() != 4) goto L17;
            return 4;
        L17:
            return 1;
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull x0 r5, int r10) {
            onBindViewHolder((g) r5, r10);
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        @NonNull
        public /* bridge */ /* synthetic */ x0 onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
            return onCreateViewHolder(r5, r10);
        }

        public void onBindViewHolder(@NonNull g r5, int r10) {
            r5.itemView.setTag(TravelListAty.a(this.f16404a).get(r10));
            View r11 = r5.itemView;
            if ((r11 instanceof OCardListItem) == false) goto L15;
            OUICardConstraintLayout r12 = ((OCardListItem) r11).getContentContainer();
            if (r12 == null) goto L7;
            r12.setTag(TravelListAty.a(this.f16404a).get(r10));
        L7:
            if (r10 > 0) goto L9;
        L11:
            int r13 = 0;
        L13:
            if ((r5.itemView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
            ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r5.itemView.getLayoutParams();
            r14.topMargin = r13;
            r5.itemView.setLayoutParams(r14);
            goto L15
        L9:
            if (getItemViewType(r10 - 1) != 3) goto L11;
            r13 = r5.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.miboard_card_margin_next);
        L15:
            r5.a(TravelListAty.a(this.f16404a).get(r10));
        }

        @Override // com.obric.oui.orecyclerview.widget.a0
        @NonNull
        public g onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
            if (r10 != 2) goto L7;
            return new d(LayoutInflater.from(r5.getContext()).inflate(R.layout.travel_list_aty_item_date, r5, false));
        L7:
            if (r10 != 3) goto L11;
            return new h((OCardListItem) LayoutInflater.from(r5.getContext()).inflate(R.layout.base_card_list_item, r5, false));
        L11:
            if (r10 != 4) goto L15;
            return new e(LayoutInflater.from(r5.getContext()).inflate(R.layout.info_layout, r5, false));
        L15:
            return new f(LayoutInflater.from(r5.getContext()).inflate(R.layout.travel_list_aty_item_info, r5, false));
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelData f16405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TravelListAty f16406b;

        public b(TravelListAty r5, TravelData r10) {
            this.f16406b = r5;
            this.f16405a = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r5, int r10) {
            m.i("TravelListAty", "showDeleteConfirmDialog onClick");
            com.zte.miboard.cards.travel.b.a(this.f16406b, this.f16405a);
            TravelListAty.b(this.f16406b);
        }
    }

    public class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelListAty f16407a;

        public c(TravelListAty r5) {
            this.f16407a = r5;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r5, int r10) {
        }
    }

    public static class d extends g {
        public d(@NonNull View r5) {
            super(r5);
        }

        @Override // com.zte.miboard.cards.travel.TravelListAty.g
        public void a(Object r5) {
            if ((r5 instanceof Long) == false) goto L7;
            Long r10 = (Long) r5;
            long r11 = r10.longValue();
            String r12 = s0.f(this.itemView.getResources().getString(R.string.travel_card_header_date_format)).format(r10);
            if (s0.c(r11) == false) goto L8;
            r12 = this.itemView.getResources().getString(R.string.todo_today);
        L8:
            ((OSectionTitleBar) this.itemView.findViewById(R.id.travel_list_aty_item_info_date)).setTitleText(r12);
            return;
        L7:
            r12 = "";
            goto L8
        }
    }

    public static class e extends g {
        public e(@NonNull View r5) {
            super(r5);
            ((TextView) r5.findViewById(R.id.info_title)).setText(R.string.travel_list_aty_empty_title);
            ((TextView) r5.findViewById(R.id.info_summary)).setText(R.string.travel_list_aty_empty_text);
        }

        @Override // com.zte.miboard.cards.travel.TravelListAty.g
        public void a(Object r5) {
        }
    }

    public static class f extends g {
        public f(@NonNull View r5) {
            super(r5);
        }

        @Override // com.zte.miboard.cards.travel.TravelListAty.g
        public void a(Object r5) {
            if ((r5 instanceof String) == false) goto L5;
            String r10 = (String) r5;
        L6:
            ((OSectionSupportiveText) this.itemView.findViewById(R.id.travel_list_aty_item_info_title)).setSectionDes(r10);
            return;
        L5:
            r10 = "";
            goto L6
        }
    }

    public static abstract class g extends x0 {
        public g(@NonNull View r5) {
            super(r5);
        }

        public abstract void a(Object r5);
    }

    public static class h extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImageView f16408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f16409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f16410c;
        private TextView d;
        private TextView e;
        private OCardListItem f;

        public class a implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OCardListItem f16411a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OSwipeLayout f16412b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ h f16413c;

            public a(h r5, OCardListItem r10, OSwipeLayout r11) {
                this.f16413c = r5;
                this.f16411a = r10;
                this.f16412b = r11;
            }

            @Override // com.obric.oui.swipeaction.k
            public void onQuickDelete() {
                m.i("TravelListAty", "onQuickDelete");
                h.a(this.f16413c, this.f16411a, this.f16412b, true);
            }
        }

        public class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OCardListItem f16414a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OSwipeLayout f16415b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ h f16416c;

            public b(h r5, OCardListItem r10, OSwipeLayout r11) {
                this.f16416c = r5;
                this.f16414a = r10;
                this.f16415b = r11;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r5) {
                m.i("TravelListAty", "swipeBtnDelete onClick");
                h.a(this.f16416c, this.f16414a, this.f16415b, false);
            }
        }

        public class c implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OSwipeLayout f16417a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ h f16418b;

            public c(h r5, OSwipeLayout r10) {
                this.f16418b = r5;
                this.f16417a = r10;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r5) {
                m.i("TravelListAty", "TravelDataViewHolder onClick getTag=" + r5.getTag());
                if (TravelItemLayout.a(r5.getContext(), r5) == false) goto L5;
            L6:
                this.f16417a.q(true);
                return;
            L5:
                if ((r5.getTag() instanceof TrainData) == true) goto L6;
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OSwipeLayout f16419a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ h f16420b;

            public d(h r5, OSwipeLayout r10) {
                this.f16420b = r5;
                this.f16419a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16419a.q(true);
            }
        }

        public h(@NonNull OCardListItem r5) {
            super(r5);
            a(r5);
            this.f = r5;
            this.f16408a = (ImageView) r5.findViewById(R.id.travel_list_aty_item_travel_data_icon);
            this.f16409b = (TextView) r5.findViewById(R.id.travel_list_aty_item_travel_data_title);
            this.f16410c = (TextView) r5.findViewById(R.id.travel_list_aty_item_travel_data_summary_1);
            this.d = (TextView) r5.findViewById(R.id.travel_list_aty_item_travel_data_summary_2);
            this.e = (TextView) r5.findViewById(R.id.travel_list_aty_item_travel_data_source_and_update_time);
            if ((r5.getContext() instanceof Activity) == false) goto L6;
            ((Activity) r5.getContext()).registerForContextMenu(r5);
            return;
        }

        public static /* synthetic */ void a(h r5, View r10, OSwipeLayout r11, boolean r12) {
            r5.a(r10, r11, r12);
        }

        private void a(View r5, OSwipeLayout r10, boolean r11) {
            if ((r5.getContext() instanceof TravelListAty) == true) goto L5;
        L7:
            m.l("TravelListAty", "deleteItem onClick error, isQuickDelete=" + r11 + " context=" + r5.getContext() + " tag=" + this.f.getTag());
            return;
        L5:
            if ((this.f.getTag() instanceof TravelData) == false) goto L7;
            m.i("TravelListAty", "deleteItem onClick isQuickDelete=" + r11 + " tag=" + this.f.getTag());
            TravelListAty.a((TravelListAty) r5.getContext(), r5.getContext(), (TravelData) this.f.getTag(), new d(this, r10));
        }

        private void a(@NonNull OCardListItem r5) {
            View r10 = LayoutInflater.from(r5.getContext()).inflate(R.layout.travel_list_aty_item_travel_data, r5.getTitleContainer(), false);
            if (r10 == null) goto L5;
            r5.f13550n.addView(r10, 0);
        L5:
            CharSequence r11 = r5.getTitle();
            OTextView r12 = r5.f13551o;
            if (r11 != null) goto L8;
        L11:
            r12.setVisibility(8);
        L12:
            r5.l(false);
            r5.setSwipeView(R.layout.layout_card_list_item_swip);
            r5.setEnableSwipe(true);
            int r13 = r5.getResources().getDimensionPixelSize(R.dimen.oui_padding_8dp);
            r5.getTitleContainer().setPadding(r13, r13, r13, r13);
            OSwipeLayout r14 = r5.getSwipeLayout();
            View r15 = r5.getSwipeView();
            if (r15 == null) goto L15;
            l r16 = new l(r14, (ViewGroup) r15);
            r16.f14625c = new a(this, r5, r14);
        L15:
            View r17 = r5.getSwipeView();
            if (r17 == null) goto L18;
            View r18 = r17.findViewById(R.id.btn_swipe_delete);
        L19:
            if (r18 == null) goto L21;
            r18.setOnClickListener(new b(this, r5, r14));
        L21:
            r5.setOnContentClickListener(new c(this, r14));
            return;
        L18:
            r18 = null;
            goto L19
        L8:
            if (r11.length() == 0) goto L11;
            r12.setVisibility(8);
            goto L12
        }

        @Override // com.zte.miboard.cards.travel.TravelListAty.g
        public void a(Object r12) {
            this.f16408a.setImageResource(0);
            this.f16409b.setText("");
            this.f16410c.setText("");
            this.d.setText("");
            this.e.setText("");
            if ((r12 instanceof TravelData) == false) goto L58;
            TravelData r5 = (TravelData) r12;
            long r10 = r5.getFromTimeLong();
            long r11 = r5.getToTimeLong();
            if (TextUtils.isEmpty(r5.getSource()) == false) goto L7;
        L15:
            String r13 = this.itemView.getContext().getString(R.string.travel_card_item_layout_empty_info_str);
            String r14 = this.itemView.getContext().getString(R.string.travel_list_aty_item_gap_info_str);
            boolean r15 = r12 instanceof FlightData;
            if (r15 == false) goto L18;
        L36:
            ImageView r16 = this.f16408a;
            if (r15 == false) goto L39;
            int r17 = R.drawable.icon_travel_flight;
        L40:
            r16.setImageResource(r17);
            if (TextUtils.isEmpty(r5.getToStation()) == true) goto L44;
            TextView r18 = this.f16409b;
            String r19 = r5.getFromStation() + r14 + r5.getToStation();
        L43:
            r18.setText(r19);
            if (r10 <= 0) goto L48;
            String r110 = com.zte.miboard.cards.travel.b.e().format(Long.valueOf(r10));
        L50:
            if (r11 <= 0) goto L52;
            r13 = com.zte.miboard.cards.travel.b.e().format(Long.valueOf(r11));
        L52:
            if (r11 <= 0) goto L54;
            r110 = j0.D(r110, r14, r13);
        L54:
            this.f16410c.setText(r110);
            boolean r111 = r5 instanceof FlightData;
            TextView r112 = this.d;
            if (r111 == false) goto L57;
            String r113 = ((FlightData) r5).getFlightCompany() + r5.travelNumber;
        L32:
            r112.setText(r113);
            return;
        L57:
            r113 = r5.travelNumber;
            goto L32
        L48:
            r110 = r13;
            goto L50
        L44:
            r18 = this.f16409b;
            r19 = r5.getFromStation();
            goto L43
        L39:
            r17 = R.drawable.icon_travel_train;
            goto L40
        L18:
            if ((r12 instanceof TrainData) == true) goto L36;
            if ((r12 instanceof HotelData) == false) goto L34;
            HotelData r114 = (HotelData) r12;
            this.f16408a.setImageResource(R.drawable.icon_travel_hotel);
            this.f16409b.setText(r114.travelNumber);
            if (r10 <= 0) goto L25;
            String r20 = com.zte.miboard.cards.travel.b.f().format(Long.valueOf(r10));
        L27:
            if (r11 <= 0) goto L29;
            r13 = com.zte.miboard.cards.travel.b.f().format(Long.valueOf(r11));
        L29:
            if (r11 <= 0) goto L31;
            r20 = j0.D(r20, r14, r13);
        L31:
            this.f16410c.setText(r20);
            r112 = this.d;
            r113 = r114.getHotelRoomType();
            goto L32
        L25:
            r20 = r13;
            goto L27
        L34:
            if ((r12 instanceof MatchData) == false) goto L60;
            MatchData r115 = (MatchData) r12;
            this.f16409b.setText(r115.getMatchTeamA() + r14 + r115.getMatchTeamB());
            this.f16410c.setText(r115.getMatchModifiedTitle());
            r112 = this.d;
            r113 = com.zte.miboard.cards.travel.b.e().format(Long.valueOf(r115.getFromTimeLong()));
            goto L32
        L60:
            return;
        L7:
            if (r5.getUpdateTimeLong() > 0) goto L9;
            this.e.setText(String.format(this.itemView.getContext().getString(R.string.travel_list_aty_source), new Object[]{r5.getSource()}));
            goto L15
        L9:
            if (s0.c(r5.getUpdateTimeLong()) == false) goto L12;
            SimpleDateFormat r21 = com.zte.miboard.cards.travel.b.e();
        L13:
            this.e.setText(String.format(this.itemView.getContext().getString(R.string.travel_list_aty_source_and_update_time), new Object[]{r5.getSource(), r21.format(Long.valueOf(r5.getUpdateTimeLong()))}));
            goto L15
        L12:
            r21 = com.zte.miboard.cards.travel.b.g();
            goto L13
        }
    }

    static {
        f16398m = new androidx.room.vo.a(2);
    }

    public TravelListAty() {
        this.g = false;
        this.f16400i = false;
        this.f16401j = new ArrayList();
        this.f16402k = new ArrayList();
        this.f16403l = new a(this);
    }

    public static /* synthetic */ ArrayList a(TravelListAty r5) {
        return r5.f16402k;
    }

    public static /* synthetic */ void b(TravelListAty r5) {
        r5.g();
    }

    private void g() {
        ArrayList r5 = new ArrayList(com.zte.miboard.cards.travel.b.a(this, this.g));
        ArrayList r10 = new ArrayList();
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.addAll(com.zte.miboard.cards.travel.b.a((com.zte.miboard.cards.travel.b.f) r11.next()));
        goto L4
    L6:
        r10.removeIf(new o(5));
        this.f16401j.clear();
        this.f16402k.clear();
        if (r10.isEmpty() == true) goto L25;
        this.f16401j.addAll(r10);
        this.f16401j.sort(TravelCard.f16340p);
        HashMap r12 = new HashMap();
        Iterator<TravelData> r13 = this.f16401j.iterator();
    L10:
        if (r13.hasNext() == false) goto L17;
        TravelData r14 = r13.next();
        long r15 = r14.getFromTimeLong();
        if (r15 <= 0) goto L10;
        String r16 = com.zte.miboard.cards.travel.b.h().format(Long.valueOf(r15));
        if (r12.containsKey(r16) == true) goto L16;
        r12.put(r16, new ArrayList());
    L16:
        ((ArrayList) r12.get(r16)).add(r14);
        goto L10
    L17:
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList(r12.keySet());
        r18.sort(f16398m);
        if (this.g == true) goto L20;
        r17.add(getResources().getString(R.string.travel_list_aty_notice_info));
    L20:
        Iterator r19 = r18.iterator();
    L22:
        if (r19.hasNext() == false) goto L24;
        String r20 = (String) r19.next();
        r17.add(Long.valueOf(com.zte.miboard.cards.travel.b.a(r20, true)));
        r17.addAll((Collection) r12.get(r20));
        goto L22
    L24:
        this.f16402k.addAll(r17);
    L26:
        this.f16399h.getAdapter().notifyDataSetChanged();
        return;
    L25:
        this.f16402k.add(4);
        goto L26
    }

    public static /* synthetic */ boolean i(TravelData r5) {
        return a(r5);
    }

    public static /* synthetic */ int j(String r5, String r10) {
        return a(r5, r10);
    }

    public static /* synthetic */ void k(Runnable r5, DialogInterface r10) {
        a(r5, r10);
    }

    @Override // c.n
    public String d() {
        Resources r5 = getResources();
        if (this.g == false) goto L5;
        int r10 = R.string.travel_match_all_travel;
    L7:
        return r5.getString(r10);
    L5:
        r10 = R.string.travel_card_all_travel;
        goto L7
    }

    @Override // c.n
    public boolean f() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r5, int r10, @Nullable Intent r11) {
        super.onActivityResult(r5, r10, r11);
        m.i("TravelListAty", "onActivityResult requestCode=" + r5 + " resultCode=" + r10);
        if (1100 == r5) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        finish();
        return;
    }

    @Override // c.n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        boolean r10 = false;
        if (getIntent() == null) goto L5;
        boolean r11 = getIntent().getBooleanExtra("check_statement", false);
    L6:
        this.f16400i = r11;
        if (getIntent() != null) goto L9;
    L11:
        this.g = r10;
        this.f16399h = a();
        a(this.f16403l);
        return;
    L9:
        if (getIntent().getBooleanExtra("is_travel_match_list", false) == false) goto L11;
        r10 = true;
        goto L11
    L5:
        r11 = false;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        g();
    }

    public static /* synthetic */ void a(TravelListAty r5, Context r10, TravelData r11, Runnable r12) {
        r5.a(r10, r11, r12);
    }

    @Override // c.n
    public int b() {
        return getResources().getDimensionPixelSize(R.dimen.aty_first_item_padding_top_8dp);
    }

    public static void a(Context r5, boolean r10, boolean r11) {
        m.i("TravelListAty", "jumpToTravelListAty isTravelMatchList=" + r10);
        Intent r12 = new Intent(r5, TravelListAty.class);
        r12.putExtra("is_travel_match_list", r10);
        if (r11 == false) goto L5;
        r12.putExtra("check_statement", true);
    L5:
        s0.b(r5, r12);
        if ((r5 instanceof Activity) == true) goto L8;
        r12.addFlags(268435456);
    L8:
        r5.startActivity(r12);
    }

    private static /* synthetic */ boolean a(TravelData r12) {
        if (r12 != null) goto L5;
    L10:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        m.n("TravelListAty", "refreshDatasAndViews removed. null or not isAvailable, travelData=" + r12);
    L14:
        if (r5 == true) goto L27;
        long r10 = r12.getCurAvailableFromTimeLong();
        long r11 = r12.getCurAvailableToTimeLong();
        long r13 = System.currentTimeMillis();
        if (r10 > 0) goto L18;
        m.n("TravelListAty", "refreshDatasAndViews removed. fromTime not right, travelData=" + r12);
        return true;
    L18:
        if (r11 > 0) goto L21;
        r11 = 60000 + r10;
    L21:
        if (r13 >= (r10 - 31536000000L)) goto L23;
    L24:
        m.i("TravelListAty", "refreshDatasAndViews time not right, travelData=" + r12);
        return true;
    L23:
        if (r13 > (r11 + AppUtil.MILLIS_IN_DAYS)) goto L24;
    L27:
        return r5;
    L5:
        if (r12.isAvailable() == false) goto L10;
        if (r12.isUserCancel() == true) goto L10;
        r5 = false;
        goto L12
    }

    private static /* synthetic */ void a(Runnable r5, DialogInterface r10) {
        if (r5 == null) goto L5;
        r5.run();
        return;
    }

    private static /* synthetic */ int a(String r5, String r10) {
        if (r5 != null) goto L4;
        return 0;
    L4:
        return r5.compareTo(r10);
    }

    private void a(Context r5, TravelData r10, final Runnable r11) {
        com.obric.oui.dialog.v2.alert.e r12 = new com.obric.oui.dialog.v2.alert.e(r5);
        int r13 = R.string.express_delete_info;
        CharSequence r14 = r12.f.getText(r13);
        r12.f13159i = false;
        r12.g = r14;
        Resources r15 = r5.getResources();
        if (this.g == false) goto L5;
        int r16 = R.string.travel_list_aty_delete_confirm_match;
    L6:
        r12.f13158h = r15.getString(r16);
        r12.e(r5.getResources().getString(R.string.dialog_button_cancel), new c(this));
        r12.g(r5.getResources().getString(R.string.express_delete_info), new b(this, r10));
        DialogInterface.OnDismissListener r17 = new com.zte.miboard.cards.travel.e(r11);
        Intrinsics.checkNotNullParameter(r17, "onDismissListener");
        r12.f13116a = r17;
        com.obric.oui.dialog.v2.alert.b r18 = r12.a();
        ((OButton) r18.rootView.findViewById(R.id.actionPositive)).setTextColor(r5.getColor(R.color.oui_functional_red_6));     // Catch: Throwable -> L9
    L11:
        r18.show();
        return;
    L9:
        th = move-exception;
        m.j("TravelListAty", "showDeleteExpressConfirmDialog error", th);
        goto L11
    L5:
        r16 = R.string.travel_list_aty_delete_confirm;
        goto L6
    }
}
