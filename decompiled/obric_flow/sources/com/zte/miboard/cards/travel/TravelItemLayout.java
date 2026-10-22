package com.zte.miboard.cards.travel;

import ai.j0;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.m;
import c.s0;
import c.v;
import com.google.android.material.timepicker.TimeModel;
import com.zte.miboard.cards.AppCallbackUtils;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.common.views.CardFooter;
import com.zte.miboard.cards.travel.data.FlightData;
import com.zte.miboard.cards.travel.data.HotelData;
import com.zte.miboard.cards.travel.data.MatchData;
import com.zte.miboard.cards.travel.data.TrainData;
import com.zte.miboard.cards.travel.data.TravelData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TravelItemLayout extends LinearLayout implements CardFooter.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f16386k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f16387l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f16388m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f16389n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f16390o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f16391p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f16392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CardFooter f16393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TravelItemBottomBindLayout f16394c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private b.f g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TravelData f16395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f16397j;

    static {
        f16386k = new int[0];
        f16387l = new int[]{R.string.travel_card_btn_route_plan};
        f16388m = new int[]{R.string.travel_card_btn_navigation, R.string.travel_card_btn_taxi};
        int r5 = R.string.travel_match_btn_watch;
        f16389n = new int[]{r5};
        int r10 = R.string.travel_match_btn_more_match;
        f16390o = new int[]{r10};
        f16391p = new int[]{r5, r10};
    }

    public TravelItemLayout(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(TravelItemLayout r5, View r10) {
        r5.b(r10);
    }

    private void h() {
        if (this.f16395h != null) goto L5;
        return;
    L5:
        long r5 = System.currentTimeMillis();
        long r10 = this.f16395h.getCurAvailableFromTimeLong();
        long r11 = this.f16395h.getCurAvailableToTimeLong();
        int[] r12 = f16386k;
        TravelData r13 = this.f16395h;
        if ((r13 instanceof HotelData) == false) goto L19;
        if (r5 >= r10) goto L11;
    L53:
        r12 = f16387l;
    L58:
        a(r12);
        return;
    L11:
        if (r11 <= 0) goto L58;
        if (r5 <= r10) goto L58;
        if (r5 < r11) goto L57;
        SimpleDateFormat r14 = s0.f("yyyyMMdd");
        if (r14.format(Long.valueOf(r5)).equals(r14.format(Long.valueOf(r11))) == false) goto L58;
    L57:
        r12 = f16388m;
        goto L58
    L19:
        if ((r13 instanceof FlightData) == true) goto L48;
        if ((r13 instanceof TrainData) == true) goto L48;
        if ((r13 instanceof MatchData) == false) goto L58;
        boolean r15 = false;
        if (TextUtils.isEmpty(r13.cardDetailsPagePkg) == false) goto L28;
    L36:
        boolean r16 = false;
    L38:
        if (this.f16396i <= 1) goto L40;
        r15 = true;
    L40:
        if (r16 == false) goto L43;
        if (r15 == false) goto L43;
        r12 = f16391p;
    L43:
        if (r16 == false) goto L45;
        r12 = f16389n;
        goto L58
    L45:
        if (r15 == false) goto L58;
        r12 = f16390o;
        goto L58
    L28:
        if (r10 <= 0) goto L36;
        if (r11 <= 0) goto L36;
        if (r5 <= (r10 - 14400000)) goto L36;
        if (r5 >= r11) goto L36;
        r16 = true;
    L48:
        if (r10 <= 0) goto L58;
        long r17 = r10 - r5;
        if (r17 <= 10800000) goto L55;
        if (r17 < 259200000) goto L53;
    L55:
        if (r17 <= 0) goto L58;
        if (r17 >= 10800000) goto L58;
        goto L57
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
        this.f16394c.a();
    }

    @Override // com.zte.miboard.cards.common.views.CardFooter.a
    @Nullable
    public ArrayList<String> getCardFooterMoreTexts() {
        return null;
    }

    @Override // com.zte.miboard.cards.common.views.CardFooter.a
    @Nullable
    public int[] getMoreBtnTextIds() {
        return this.f16397j;
    }

    public void i() {
        View r5 = findViewById(R.id.travel_card_item_bottom_layout);
        boolean r10 = true;
        int r11 = 0;
        if (r5 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        CardFooter r13 = this.f16393b;
        if (r13 != null) goto L11;
    L13:
        boolean r14 = false;
    L14:
        getResources().getDimensionPixelSize(R.dimen.travel_card_item_layout_normal_height);
        if (r12 == false) goto L19;
        if (r14 == false) goto L19;
        Resources r15 = getResources();
        int r16 = R.dimen.travel_card_item_layout_big_height;
    L18:
        r15.getDimensionPixelSize(r16);
    L22:
        b.f r17 = this.g;
        if (r17 != b.f.g) goto L30;
        Resources r18 = getResources();
        if (r14 == false) goto L27;
        int r19 = R.dimen.travel_card_item_match_layout_normal_height;
    L28:
        r18.getDimensionPixelSize(r19);
    L36:
        r10 = false;
    L37:
        if (r10 == false) goto L39;
        getResources().getDimensionPixelSize(R.dimen.travel_card_item_bottom_bind_layout_height);
    L39:
        int r20 = getResources().getDimensionPixelSize(R.dimen.travel_card_item_padding_bottom_when_no_card_footer);
        int r21 = getPaddingStart();
        int r22 = getPaddingTop();
        int r23 = getPaddingRight();
        if (r14 == true) goto L43;
        if (r10 == true) goto L43;
        int r24 = r20;
    L44:
        setPadding(r21, r22, r23, r24);
        View r25 = findViewById(R.id.travel_card_item_info_layout);
        int r26 = r25.getPaddingLeft();
        int r27 = r25.getPaddingTop();
        int r28 = r25.getPaddingRight();
        if (r14 == true) goto L48;
        if (r10 == false) goto L48;
        r11 = r20;
    L48:
        r25.setPadding(r26, r27, r28, r11);
        b.f r29 = this.g;
        if (r29 == b.f.d) goto L53;
        if (r29 == b.f.e) goto L53;
        return;
    L53:
        if ((r25.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L61;
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r25.getLayoutParams();
        Resources r31 = getResources();
        if (r12 == false) goto L57;
        int r32 = R.dimen.travel_card_item_info_layout_margin_top;
    L58:
        r30.topMargin = r31.getDimensionPixelSize(r32);
        return;
    L57:
        r32 = R.dimen.travel_card_item_info_layout_margin_top_one_line;
        goto L58
    L61:
        return;
    L43:
        r24 = 0;
        goto L44
    L27:
        r19 = R.dimen.travel_card_item_match_layout_small_height;
        goto L28
    L30:
        if (r17 != b.f.d) goto L36;
        TravelItemBottomBindLayout r33 = this.f16394c;
        if (r33 == null) goto L36;
        if (r33.getVisibility() != 0) goto L36;
    L19:
        if (r12 == true) goto L22;
        if (r14 == true) goto L22;
        r15 = getResources();
        r16 = R.dimen.travel_card_item_layout_small_height;
        goto L18
    L11:
        if (r13.getVisibility() == 8) goto L13;
        r14 = true;
        goto L14
    L5:
        if (r5.getVisibility() == 8) goto L7;
        r12 = true;
        goto L8
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = (ImageView) findViewById(R.id.travel_card_item_header_icon);
        this.e = (TextView) findViewById(R.id.travel_card_item_header_title);
        this.f = (TextView) findViewById(R.id.travel_card_item_header_time);
        this.f16392a = (ViewGroup) findViewById(R.id.travel_card_item_layout_container);
        CardFooter r5 = (CardFooter) findViewById(R.id.card_footer);
        this.f16393b = r5;
        r5.setCallback(this);
        setOnClickListener(new d(this));
        this.f16394c = (TravelItemBottomBindLayout) findViewById(R.id.travel_card_item_bottom_bind_layout);
    }

    public void setDataKey(b.f r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.g = r5;
        if (r5 != b.f.g) goto L7;
        boolean r10 = true;
    L8:
        Context r11 = getContext();
        if (r10 == false) goto L11;
        int r12 = R.color.transparent;
    L12:
        setBackgroundColor(r11.getColor(r12));
        LayoutInflater.from(getContext()).inflate(this.g.f16467c, this.f16392a);
        a(f16386k);
        this.f16394c.setDataKey(r5);
        return;
    L11:
        r12 = R.color.miboard_card_bg_color;
        goto L12
    L7:
        r10 = false;
        goto L8
    }

    public TravelItemLayout(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    private /* synthetic */ void b(View r5) {
        a(getContext(), r5);
    }

    public void a() {
    }

    public TravelItemLayout(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }

    public void a(TravelData r23, int r24) {
        if (this.g == null) goto L160;
        if (r23 == null) goto L160;
        if (r23.isAvailable() == false) goto L160;
        this.f16395h = r23;
        this.f16396i = r24;
        setTag(r23);
        this.f16394c.a(this.f16395h);
        boolean r5 = r23 instanceof MatchData;
        String r10 = r23.travelNumber;
        boolean r11 = r23 instanceof FlightData;
        if (r11 == false) goto L13;
        FlightData r12 = (FlightData) r23;
        if (TextUtils.isEmpty(r12.getFlightCompany()) == true) goto L13;
        r10 = r23.travelNumber + " · " + r12.getFlightCompany();
    L13:
        if (r5 == false) goto L17;
        MatchData r13 = (MatchData) r23;
        if (TextUtils.isEmpty(r13.getMatchModifiedTitle()) == true) goto L17;
        r10 = r13.getMatchModifiedTitle();
    L17:
        this.e.setText(r10);
        b.f r14 = this.g;
        String r15 = "";
        if (r14 != b.f.d) goto L22;
        this.d.setImageResource(R.drawable.icon_travel_flight);
        Resources r16 = getResources();
        int r17 = R.string.travel_info_type_flight;
    L20:
        String r18 = r16.getString(r17);
    L31:
        View r19 = findViewById(R.id.travel_card_item_bottom_layout);
        if ((r23 instanceof TrainData) == false) goto L40;
        TrainData r20 = (TrainData) r23;
        if (TextUtils.isEmpty(r20.getTrainCarriageNumber()) == true) goto L36;
    L49:
        boolean r21 = true;
    L50:
        if (r19 == null) goto L55;
        if (r21 == false) goto L53;
        int r22 = 0;
    L54:
        r19.setVisibility(r22);
        goto L55
    L53:
        r22 = 8;
    L55:
        h();
        String r25 = getResources().getString(R.string.travel_card_item_layout_empty_info_str);
        long r26 = System.currentTimeMillis();
        long r110 = r23.getFromTimeLong();
        long r111 = r23.getToTimeLong();
        if (r110 <= 0) goto L58;
        String r27 = b.e().format(Long.valueOf(r110));
    L60:
        if (r111 <= 0) goto L63;
        r25 = b.e().format(Long.valueOf(r111));
    L63:
        int r112 = b.a(getContext(), r110, r111);
        if (r112 <= 0) goto L66;
        String r28 = j0.g(r112, "+");
    L67:
        TextView r113 = this.f;
        String r114 = r28;
        Resources r29 = getResources();
        if (r5 == false) goto L70;
        int r30 = R.string.travel_card_match_header_time_format;
    L71:
        r113.setText(s0.f(r29.getString(r30)).format(Long.valueOf(r110)));
        ImageView r31 = (ImageView) findViewById(R.id.travel_card_item_info_icon);
        if ("飞常准".equals(this.f16395h.getSource()) == false) goto L74;
        int r32 = 0;
    L75:
        r31.setVisibility(r32);
        TextView r33 = (TextView) findViewById(R.id.travel_card_item_info_source_and_update_time);
        if (TextUtils.isEmpty(r23.getSource()) == false) goto L78;
        r25 = r25;
        r33.setText("");
        int r34 = 4;
    L87:
        r33.setVisibility(r34);
        TravelData r35 = this.f16395h;
        if ((r35 instanceof FlightData) == false) goto L92;
    L112:
        ((TextView) findViewById(R.id.travel_card_item_from_time)).setText(r27);
        ((TextView) findViewById(R.id.travel_card_item_to_time)).setText(r25);
        ((TextView) findViewById(R.id.travel_card_item_to_time_offset_date)).setText(r114);
        ((TextView) findViewById(R.id.travel_card_item_from_station)).setText(r23.getFromStation());
        TextView r36 = (TextView) findViewById(R.id.travel_card_item_to_station);
        if (TextUtils.isEmpty(r23.getToStation()) == true) goto L115;
        String r37 = r23.getToStation();
    L116:
        r36.setText(r37);
        TravelData r38 = this.f16395h;
        if ((r38 instanceof FlightData) == false) goto L138;
        FlightData r39 = (FlightData) r38;
        TextView r40 = (TextView) findViewById(R.id.travel_card_item_company);
        if (TextUtils.isEmpty("") == false) goto L121;
        int r41 = 4;
    L122:
        r40.setVisibility(r41);
        if (TextUtils.isEmpty("") == false) goto L125;
        r15 = getResources().getString(R.string.travel_flight_company);
    L125:
        ((TextView) findViewById(R.id.travel_card_item_state)).setText(r39.getFlightStatusDesc(getContext()));
        ((TextView) findViewById(R.id.travel_card_item_company)).setText(r15);
        ((ImageView) findViewById(R.id.travel_card_item_travel_line_img)).setImageResource(r39.getStatusKeyLineResId());
        ((ImageView) findViewById(R.id.travel_card_item_travel_line_icon)).setImageResource(r39.getStatusKeyIconResId());
        ((TextView) findViewById(R.id.travel_card_item_state)).setTextColor(r39.getStatusKeyTextColor(getContext()));
        ((TextView) findViewById(R.id.travel_card_item_state)).setVisibility(0);
        ((TextView) findViewById(R.id.travel_card_item_plan_or_real_from_time_info)).setText(r39.getPlanOrRealFromTimeInfo(getContext()));
        ((TextView) findViewById(R.id.travel_card_item_plan_or_real_to_time_info)).setText(r39.getPlanOrRealToTimeInfo(getContext()));
        ((TextView) findViewById(R.id.travel_card_item_plan_or_real_from_time_info)).setVisibility(0);
        ((TextView) findViewById(R.id.travel_card_item_plan_or_real_to_time_info)).setVisibility(0);
        ((TextView) findViewById(R.id.travel_card_item_bottom_layout_left_summary)).setText(getResources().getString(R.string.travel_flight_check_in_table));
        TextView r42 = (TextView) findViewById(R.id.travel_card_item_bottom_layout_left_title);
        if (TextUtils.isEmpty(r39.getCheckInTable()) == true) goto L128;
        String r43 = r39.getCheckInTable();
    L129:
        r42.setText(r43);
        ((TextView) findViewById(R.id.travel_card_item_bottom_layout_middle_summary)).setText(getResources().getString(R.string.travel_flight_board_gate));
        TextView r44 = (TextView) findViewById(R.id.travel_card_item_bottom_layout_middle_title);
        if (TextUtils.isEmpty(r39.getBoardGate()) == true) goto L132;
        String r45 = r39.getBoardGate();
    L133:
        r44.setText(r45);
        ((TextView) findViewById(R.id.travel_card_item_bottom_layout_right_summary)).setText(getResources().getString(R.string.travel_flight_baggage_id));
        TextView r46 = (TextView) findViewById(R.id.travel_card_item_bottom_layout_right_title);
        if (TextUtils.isEmpty(r39.getBaggageID()) == true) goto L136;
        String r47 = r39.getBaggageID();
    L137:
        r46.setText(r47);
        return;
    L136:
        r47 = r25;
        goto L137
    L132:
        r45 = r25;
        goto L133
    L128:
        r43 = r25;
        goto L129
    L121:
        r41 = 0;
        goto L122
    L138:
        TrainData r48 = (TrainData) r38;
        ((TextView) findViewById(R.id.travel_card_item_company)).setVisibility(4);
        ((TextView) findViewById(R.id.travel_card_item_state)).setVisibility(8);
        ((ImageView) findViewById(R.id.travel_card_item_travel_line_img)).setImageResource(R.drawable.travel_card_item_line_train);
        ((ImageView) findViewById(R.id.travel_card_item_travel_line_icon)).setImageResource(R.drawable.travel_card_item_line_train_icon);
        ((TextView) findViewById(R.id.travel_card_item_plan_or_real_from_time_info)).setVisibility(8);
        ((TextView) findViewById(R.id.travel_card_item_plan_or_real_to_time_info)).setVisibility(8);
        ((TextView) findViewById(R.id.travel_card_item_bottom_layout_left_summary)).setText(getResources().getString(R.string.travel_train_carriage_number));
        TextView r49 = (TextView) findViewById(R.id.travel_card_item_bottom_layout_left_title);
        if (TextUtils.isEmpty(r48.getTrainCarriageNumber()) == true) goto L141;
        String r50 = r48.getTrainCarriageNumber();
    L142:
        r49.setText(r50);
        ((TextView) findViewById(R.id.travel_card_item_bottom_layout_middle_summary)).setText(getResources().getString(R.string.travel_train_seat_number));
        TextView r51 = (TextView) findViewById(R.id.travel_card_item_bottom_layout_middle_title);
        if (TextUtils.isEmpty(r48.getTrainSeatNumber()) == true) goto L145;
        String r52 = r48.getTrainSeatNumber();
    L146:
        r51.setText(r52);
        ((TextView) findViewById(R.id.travel_card_item_bottom_layout_right_summary)).setText(getResources().getString(R.string.travel_train_check_ticket));
        TextView r53 = (TextView) findViewById(R.id.travel_card_item_bottom_layout_right_title);
        if (TextUtils.isEmpty(r48.getTrainTicketCheck()) == true) goto L149;
        String r54 = r48.getTrainTicketCheck();
    L150:
        r53.setText(r54);
        boolean r55 = TextUtils.isEmpty(r48.getTrainTicketCheck());
        TextView r56 = (TextView) findViewById(R.id.travel_card_item_bottom_layout_right_title);
        if (r55 == true) goto L153;
        int r57 = 0;
    L154:
        r56.setVisibility(r57);
        TextView r58 = (TextView) findViewById(R.id.travel_card_item_bottom_layout_right_summary);
        if (r55 == true) goto L157;
        int r59 = 0;
    L158:
        r58.setVisibility(r59);
        return;
    L157:
        r59 = 4;
        goto L158
    L153:
        r57 = 4;
        goto L154
    L149:
        r54 = r25;
        goto L150
    L145:
        r52 = r25;
        goto L146
    L141:
        r50 = r25;
        goto L142
    L115:
        r37 = r25;
        goto L116
    L92:
        if ((r35 instanceof TrainData) == true) goto L112;
        if ((r35 instanceof HotelData) == false) goto L101;
        this.f.setVisibility(8);
        ((TextView) findViewById(R.id.travel_card_item_hotel_from_date)).setText(b.f().format(Long.valueOf(r110)));
        ((TextView) findViewById(R.id.travel_card_item_hotel_to_date)).setText(b.f().format(Long.valueOf(r111)));
        ((TextView) findViewById(R.id.travel_card_item_hotel_room_type)).setText(((HotelData) this.f16395h).getHotelRoomType());
        int r60 = b.a(getContext(), r110, r111);
        if (r60 <= 0) goto L99;
        r15 = String.format(getResources().getString(R.string.travel_hotel_night_count), new Object[]{Integer.valueOf(r60)});
    L99:
        ((TextView) findViewById(R.id.travel_card_item_hotel_travel_line_text)).setText(r15);
        return;
    L101:
        if ((r35 instanceof MatchData) == false) goto L163;
        MatchData r61 = (MatchData) r35;
        ((TextView) findViewById(R.id.travel_card_item_match_team_a)).setText(r61.getMatchTeamA());
        ((TextView) findViewById(R.id.travel_card_item_match_team_b)).setText(r61.getMatchTeamB());
        if (r110 <= 0) goto L111;
        if (r111 <= 0) goto L111;
        if (r26 <= r110) goto L111;
        if (r26 >= r111) goto L111;
        int r62 = (int) (((r26 - r110) / 1000) / 60);
        this.f.setText(String.format(getResources().getString(R.string.travel_match_header_already_show), new Object[]{String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r62 / 60)}) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r62 % 60)})}));
        ImageView r63 = (ImageView) findViewById(R.id.travel_card_item_match_vs_icon);
        int r64 = R.drawable.travel_card_item_match_vs_icon_showing;
    L110:
        r63.setImageResource(r64);
        return;
    L111:
        r63 = (ImageView) findViewById(R.id.travel_card_item_match_vs_icon);
        r64 = R.drawable.travel_card_item_match_vs_icon_not_showing;
        goto L110
    L163:
        return;
    L78:
        if (r23.getUpdateTimeLong() > 0) goto L80;
        String r65 = String.format(getResources().getString(R.string.travel_info_source), new Object[]{r18, r23.getSource()});
    L85:
        r33.setText(r65);
        r34 = 0;
        goto L87
    L80:
        if (s0.c(r23.getUpdateTimeLong()) == false) goto L83;
        SimpleDateFormat r66 = b.e();
    L84:
        r65 = String.format(getResources().getString(R.string.travel_info_source_and_update_time), new Object[]{r18, r23.getSource(), r66.format(Long.valueOf(r23.getUpdateTimeLong()))});
        goto L85
    L83:
        r66 = b.g();
        goto L84
    L74:
        r32 = 8;
        goto L75
    L70:
        r30 = R.string.travel_card_header_date_format;
        goto L71
    L66:
        r28 = "";
        goto L67
    L58:
        r27 = r25;
        goto L60
    L36:
        if (TextUtils.isEmpty(r20.getTrainSeatNumber()) == false) goto L49;
        if (TextUtils.isEmpty(r20.getTrainTicketCheck()) == false) goto L49;
    L48:
        r21 = false;
        goto L50
    L40:
        if (r11 == false) goto L48;
        FlightData r67 = (FlightData) r23;
        if (TextUtils.isEmpty(r67.getBoardGate()) == false) goto L49;
        if (TextUtils.isEmpty(r67.getCheckInTable()) == false) goto L49;
        if (TextUtils.isEmpty(r67.getBaggageID()) == true) goto L48;
    L22:
        if (r14 != b.f.e) goto L25;
        this.d.setImageResource(R.drawable.icon_travel_train);
        r16 = getResources();
        r17 = R.string.travel_info_type_train;
        goto L20
    L25:
        if (r14 != b.f.f) goto L28;
        this.d.setImageResource(R.drawable.icon_travel_hotel);
        r16 = getResources();
        r17 = R.string.travel_info_type_hotel;
        goto L20
    L28:
        if (r14 != b.f.g) goto L30;
        r16 = getResources();
        r17 = R.string.travel_info_type_match;
        goto L20
    L30:
        this.d.setImageResource(0);
        this.e.setTextColor(0);
        r18 = "";
    L160:
        m.l("TravelItemLayout", "onBindView error return, mDataKey=" + this.g + " travelData=" + r23);
    }

    @Override // com.zte.miboard.cards.common.views.CardFooter.a
    public void a(@NonNull View r5) {
        if ((r5 instanceof TextView) == true) goto L6;
        return;
    L6:
        if (this.f16395h != null) goto L9;
        m.l("TravelItemLayout", "onCardFooterBtnClick mTravelData null error, return");
        return;
    L9:
        String r10 = ((TextView) r5).getText() + "";
        StringBuilder r11 = j0.x("onTravelCardItemOnClick btnText=", r10, " mTravelData=");
        r11.append(this.f16395h);
        m.i("TravelItemLayout", r11.toString());
        if ((this.f16395h instanceof MatchData) == true) goto L12;
        b.a(getContext(), "card", r10, this.f16395h);
        return;
    L12:
        if (getResources().getString(R.string.travel_match_btn_more_match).equals(r10) == false) goto L15;
        TravelListAty.a(getContext(), true, false);
        return;
    L15:
        if (getResources().getString(R.string.travel_match_btn_watch).equals(r10) == false) goto L20;
        callOnClick();
        return;
    }

    public static boolean a(Context r5, View r10) {
        if (r5 == null) goto L9;
        if (r10 != null) goto L5;
        return false;
    L5:
        if ((r10.getTag() instanceof TravelData) == true) goto L8;
        return false;
    L8:
        return a(r5, (TravelData) r10.getTag());
    L9:
        return false;
    }

    public static boolean a(Context r10, TravelData r11) {
        boolean r5 = true;
        if ((r11 instanceof FlightData) == false) goto L30;
        FlightData r12 = (FlightData) r11;
        FlightData.JumpUrl r13 = r12.jumpUrl;
        if (r13 == null) goto L30;
        if (TextUtils.isEmpty(r13.appUrl) == false) goto L9;
    L11:
        boolean r14 = false;
    L12:
        if (r14 == false) goto L14;
    L23:
        if (r14 == true) goto L31;
        String r15 = r12.jumpUrl.webURL;
        boolean r16 = s0.f1083a;
        if (TextUtils.isEmpty(r15) == false) goto L27;
        boolean r17 = false;
    L28:
        if (r17 == false) goto L31;
        AppCallbackUtils.callAppJumpToWebView(r10, r12.jumpUrl.webURL);
        m.i("TravelItemLayout", "onTravelCardItemOnClick jump to webURL, jumped=true");
        r14 = true;
        goto L31
    L27:
        r17 = URLUtil.isNetworkUrl(r15);
    L31:
        m.i("TravelItemLayout", "onTravelCardItemOnClick cardDetailsPagePkg=" + r11.cardDetailsPagePkg + ", travelData=" + r11);
        if (TextUtils.isEmpty(r11.cardDetailsPagePkg) == false) goto L34;
        return r14;
    L34:
        if (r14 == true) goto L36;
        r14 = s0.d(r10, r11.cardDetailsPagePkg, r11.cardDetailsPageDeepLink);
    L36:
        if (r14 == true) goto L48;
        m.l("TravelItemLayout", "onTravelCardItemOnClick cardDetailsPageDeepLink not jumped, to main, cardDetailsPageDeepLink=" + r11.cardDetailsPageDeepLink);
        String r18 = r11.cardDetailsPagePkg;
        boolean r19 = s0.f1083a;
        if (TextUtils.isEmpty(r18) == false) goto L40;
    L39:
        r14 = false;
        goto L48
    L40:
        Intent r20 = r10.getPackageManager().getLaunchIntentForPackage(r18);
        if (r20 == null) goto L39;
        r10.startActivity(r20);     // Catch: Exception -> L45
    L47:
        r14 = r5;
    L45:
        e = move-exception;
        m.j("Utils", "jumpToThirdAppMainAty error", e);
        r5 = false;
    L48:
        if (r14 == true) goto L53;
        m.l("TravelItemLayout", "onTravelCardItemOnClick jumpAppStore");
        r14 = AppCallbackUtils.showDownloadAppDialog(r10, r11.cardDetailsPagePkg, null, "");
        m.i("TravelItemLayout", "onTravelCardItemOnClick showDownloadAppDialog jumped=" + r14);
        if (r14 == true) goto L53;
        r14 = s0.i(r10, r11.cardDetailsPagePkg);
    L53:
        if (v.b(r10) == true) goto L55;
        Toast.makeText(r10, R.string.net_connected_error, 0).show();
    L55:
        return r14;
    L14:
        if (TextUtils.isEmpty(r12.jumpUrl.wxappURL) == true) goto L23;
        if (s0.h(r10, "com.tencent.mm") == false) goto L23;
        String r21 = r12.jumpUrl.wxappURL;
        m.i("Utils", "jumpToWxMiniProgramWithAty");
        Intent r22 = new Intent();     // Catch: Throwable -> L20
        r22.setClassName("com.zte.fingerflashpay", "com.zte.fingerflashpay.FingerFlashPayActivity");     // Catch: Throwable -> L20
        r22.setFlags(268468224);     // Catch: Throwable -> L20
        r22.setAction("com.zte.fingerflashpay.WECHAT_TASK");     // Catch: Throwable -> L20
        r22.putExtra("miniProgramOriginId", "gh_63bebc919103");     // Catch: Throwable -> L20
        r22.putExtra("miniProgramPath", r21);     // Catch: Throwable -> L20
        r22.setPackage("com.zte.fingerflashpay");     // Catch: Throwable -> L20
        r10.startActivity(r22);     // Catch: Throwable -> L20
        r14 = true;
    L22:
        m.i("TravelItemLayout", "onTravelCardItemOnClick jump to WX_PROGRAM_ID_VERY_ZHUN, jumped=" + r14);
    L20:
        th = move-exception;
        m.j("Utils", "jumpToWxMiniProgramWithAty error", th);
        r14 = false;
        goto L22
    L9:
        if (s0.h(r10, "vz.com") == false) goto L11;
        r14 = s0.d(r10, "vz.com", r12.jumpUrl.appUrl);
        m.i("TravelItemLayout", "onTravelCardItemOnClick jump to PKG_VERY_ZHUN, jumped=" + r14);
    L30:
        r14 = false;
        goto L31
    }

    public void a(int[] r5) {
        this.f16397j = r5;
        this.f16393b.a();
        i();
    }
}
