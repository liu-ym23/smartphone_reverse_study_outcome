package com.zte.miboard.cards.travel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import c.k0;
import c.m;
import c.s0;
import c.x;
import cn.nubia.neopush.commons.AppUtil;
import cn.nubia.neopush.commons.Constant;
import com.google.gson.Gson;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.common.MiddleJumpAty;
import com.zte.miboard.cards.travel.data.FlightData;
import com.zte.miboard.cards.travel.data.MatchData;
import com.zte.miboard.cards.travel.data.TrainData;
import com.zte.miboard.cards.travel.data.TravelData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f16438a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Boolean f16439b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f16440c = false;
    private static Boolean d;
    private static final List<EnumC0027a> e = null;
    private static final List<EnumC0027a> f = null;

    /* JADX INFO: renamed from: com.zte.miboard.cards.travel.a$a, reason: collision with other inner class name */
    public static final enum EnumC0027a extends Enum<EnumC0027a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0027a f16441a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0027a f16442b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0027a f16443c = null;
        public static final EnumC0027a d = null;
        public static final EnumC0027a e = null;
        public static final EnumC0027a f = null;
        public static final EnumC0027a g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0027a f16444h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0027a f16445i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final EnumC0027a f16446j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final EnumC0027a f16447k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final EnumC0027a f16448l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final EnumC0027a f16449m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final EnumC0027a f16450n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final EnumC0027a f16451o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final /* synthetic */ EnumC0027a[] f16452p = null;

        static {
            f16441a = new EnumC0027a("FLIGHT_CREATE", 0);
            f16442b = new EnumC0027a("FLIGHT_BEFORE_24H", 1);
            f16443c = new EnumC0027a("FLIGHT_BEFORE_3H", 2);
            d = new EnumC0027a("TRAIN_CREATE", 3);
            e = new EnumC0027a("TRAIN_BEFORE_24H", 4);
            f = new EnumC0027a("TRAIN_BEFORE_3H", 5);
            g = new EnumC0027a("TRAIN_BEFORE_30MIN_JIAN_PIAO_KOU", 6);
            f16444h = new EnumC0027a("TRAIN_CHANGED_CANCELED", 7);
            f16445i = new EnumC0027a("FLIGHT_BEFORE_1H_DENG_JI_KOU", 8);
            f16446j = new EnumC0027a("FLIGHT_ARRIVE_XINGLI_ZHUANPAN", 9);
            f16447k = new EnumC0027a("FLIGHT_CHANGED_PLAN_TIME_DELAYED", 10);
            f16448l = new EnumC0027a("FLIGHT_CHANGED_BOARDING_GATE", 11);
            f16449m = new EnumC0027a("FLIGHT_CHANGED_START_BOARDING", 12);
            f16450n = new EnumC0027a("FLIGHT_CHANGED_CANCELED", 13);
            f16451o = new EnumC0027a("MATCH_BEFORE_6H", 14);
            f16452p = a();
        }

        private EnumC0027a(String r5, int r10) {
            super(r5, r10);
        }

        private static /* synthetic */ EnumC0027a[] a() {
            return new EnumC0027a[]{f16441a, f16442b, f16443c, d, e, f, g, f16444h, f16445i, f16446j, f16447k, f16448l, f16449m, f16450n, f16451o};
        }

        public static EnumC0027a valueOf(String r5) {
            return (EnumC0027a) Enum.valueOf(EnumC0027a.class, r5);
        }

        public static EnumC0027a[] values() {
            return (EnumC0027a[]) f16452p.clone();
        }
    }

    static {
        e = Arrays.asList(new EnumC0027a[]{EnumC0027a.f16443c, EnumC0027a.f16447k, EnumC0027a.f16448l, EnumC0027a.f16449m, EnumC0027a.f16446j, EnumC0027a.f16450n, EnumC0027a.f, EnumC0027a.f16444h});
        f = Arrays.asList(new EnumC0027a[]{EnumC0027a.f16441a, EnumC0027a.d, EnumC0027a.f16442b, EnumC0027a.e});
    }

    public static void a(Context r5) {
        ((NotificationManager) r5.getSystemService(Constant.NOTIFICATION)).cancel(1101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        m.j("TravelNotificationUtils", "cancelNotificationChannel error", th);
    }

    private static void b(@NonNull Context r5) {
        if (a(r5, false) == true) goto L7;
        m.i("TravelNotificationUtils", "createTravelNotificationChannelIfNeed return not isEnableTravelNotification");
        return;
    L7:
        if (f16440c == false) goto L9;
        return;
    L9:
        m.i("TravelNotificationUtils", "createTravelNotificationChannel");
        ((NotificationManager) r5.getSystemService(Constant.NOTIFICATION)).createNotificationChannel(new NotificationChannel("miboard_travel_notification", r5.getString(R.string.travel_notification_description_info), 4));     // Catch: Throwable -> L12
        f16440c = true;     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        m.j("TravelNotificationUtils", "createTravelNotificationChannel error", th);
    }

    private static boolean c(Context r5) {
        if (d != null) goto L6;
        d = Boolean.TRUE;
    L6:
        return d.booleanValue();
    }

    public static void d(Context r5) {
        f16438a = Boolean.valueOf(b(r5, false));
        f16439b = Boolean.valueOf(b(r5, true));
    }

    @Nullable
    private static RemoteViews a(Context r17, EnumC0027a r18, TravelData r19) {
        String r5 = null;
        if (r18 != null) goto L5;
    L143:
        return null;
    L5:
        if (a(r18.name()) == false) goto L143;
        if ((r19 instanceof FlightData) == true) goto L13;
        if ((r19 instanceof TrainData) == true) goto L13;
        return null;
    L13:
        if (c(r17) == true) goto L15;
        return null;
    L15:
        boolean r10 = r19 instanceof TrainData;
        RemoteViews r11 = new RemoteViews(r17.getPackageName(), R.layout.travel_notification_remote_view_layout);
        if (r10 == false) goto L18;
        int r12 = R.drawable.icon_travel_train;
    L19:
        int r13 = 0;
        if (r18 != EnumC0027a.f16450n) goto L22;
    L25:
        boolean r14 = true;
    L26:
        int r15 = R.id.travel_notification_remote_view_info_layout;
        if (r14 == false) goto L29;
        int r16 = 8;
    L30:
        r11.setViewVisibility(r15, r16);
        int r110 = R.id.travel_notification_remote_view_status_layout;
        if (r14 == false) goto L33;
        int r111 = 0;
    L34:
        r11.setViewVisibility(r110, r111);
        String r112 = "";
        if (r14 == false) goto L41;
        if (r10 == false) goto L38;
        int r20 = R.string.travel_notification_train_canceled;
    L39:
        String r21 = r17.getString(r20);
        String r22 = null;
    L115:
        r11.setInt(R.id.travel_notification_remote_view_header_icon, "setImageResource", r12);
        r11.setTextViewText(R.id.travel_notification_remote_view_header_travel_number, r19.travelNumber);
        int r23 = R.color.oui_basic_text_3_light;
        int r24 = R.color.oui_basic_text_3_dark;
        if (r18 != EnumC0027a.f16446j) goto L119;
        r23 = R.color.oui_functional_green_7_light;
        r24 = R.color.oui_functional_green_7_dark;
    L124:
        if (TextUtils.isEmpty(r5) == true) goto L127;
    L130:
        int r25 = R.id.travel_notification_remote_view_header_right_info;
        if (TextUtils.isEmpty(r5) == false) goto L134;
        r13 = 8;
    L134:
        r11.setViewVisibility(r25, r13);
        int r26 = R.id.travel_notification_remote_view_header_right_info;
        if (TextUtils.isEmpty(r5) == false) goto L138;
        r5 = "";
    L138:
        r11.setTextViewText(r26, r5);
        r11.setColorInt(R.id.travel_notification_remote_view_header_right_info, "setTextColor", r17.getColor(r23), r17.getColor(r24));
        int r27 = R.id.travel_notification_remote_view_status_layout_text;
        if (TextUtils.isEmpty(r21) == true) goto L141;
        r112 = r21;
    L141:
        r11.setTextViewText(r27, r112);
        r11.setColorInt(R.id.travel_notification_remote_view_status_layout_text, "setTextColor", r17.getColor(R.color.oui_functional_red_7_light), r17.getColor(R.color.oui_functional_red_7_dark));
        return r11;
    L127:
        if (TextUtils.isEmpty(r22) == true) goto L129;
        r5 = r22;
        goto L130
    L129:
        r5 = "";
        goto L130
    L119:
        if (r18 != EnumC0027a.f16448l) goto L121;
    L122:
        r23 = R.color.oui_functional_orange_7_light;
        r24 = R.color.oui_functional_orange_7_dark;
        goto L124
    L121:
        if (r18 != EnumC0027a.f16447k) goto L124;
    L38:
        r20 = R.string.travel_notification_flight_canceled;
        goto L39
    L41:
        if (r18 != EnumC0027a.f16443c) goto L43;
    L76:
        String r28 = r19.getFromStation();
        Pair r29 = new Pair(b.e().format(Long.valueOf(r19.getCurAvailableFromTimeLong())), r17.getString(R.string.travel_flight_plan_from_time_str));
        if ((r19 instanceof FlightData) == false) goto L83;
        FlightData r113 = (FlightData) r19;
        if (TextUtils.isEmpty(r113.getCheckInTable()) == true) goto L87;
        Pair r114 = new Pair(r113.getCheckInTable(), r17.getString(R.string.travel_flight_check_in_table));
    L81:
        String r115 = null;
        boolean r116 = true;
        r22 = r28;
        Pair r30 = r29;
    L88:
        if (r116 == false) goto L90;
        r11.setViewVisibility(R.id.travel_notification_remote_view_btn_taxi, 0);
        r11.setOnClickPendingIntent(R.id.travel_notification_remote_view_btn_taxi, (PendingIntent) a(r17, r19, true).second);
    L91:
        int r31 = R.id.travel_notification_remote_view_info_0;
        if (r114 == null) goto L102;
        r11.setViewVisibility(r31, 0);
        int r32 = R.id.travel_notification_remote_view_info_title_0;
        if (TextUtils.isEmpty((CharSequence) r114.first) == true) goto L96;
        CharSequence r117 = (CharSequence) r114.first;
    L97:
        r11.setTextViewText(r32, r117);
        int r33 = R.id.travel_notification_remote_view_info_summary_0;
        if (TextUtils.isEmpty((CharSequence) r114.second) == true) goto L100;
        CharSequence r118 = (CharSequence) r114.second;
    L101:
        r11.setTextViewText(r33, r118);
    L103:
        if (r30 == null) goto L113;
        r11.setViewVisibility(R.id.travel_notification_remote_view_info_1, 0);
        int r34 = R.id.travel_notification_remote_view_info_title_1;
        if (TextUtils.isEmpty((CharSequence) r30.first) == true) goto L107;
        CharSequence r119 = (CharSequence) r30.first;
    L108:
        r11.setTextViewText(r34, r119);
        int r35 = R.id.travel_notification_remote_view_info_summary_1;
        if (TextUtils.isEmpty((CharSequence) r30.second) == true) goto L111;
        CharSequence r36 = (CharSequence) r30.second;
    L112:
        r11.setTextViewText(r35, r36);
    L114:
        r21 = null;
        r5 = r115;
        goto L115
    L111:
        r36 = "";
        goto L112
    L107:
        r119 = "";
        goto L108
    L113:
        r11.setViewVisibility(R.id.travel_notification_remote_view_info_1, 8);
        goto L114
    L100:
        r118 = "";
        goto L101
    L96:
        r117 = "";
        goto L97
    L102:
        r11.setViewVisibility(r31, 8);
        goto L103
    L90:
        r11.setViewVisibility(R.id.travel_notification_remote_view_btn_taxi, 8);
    L87:
        r115 = null;
        r114 = r29;
        r116 = true;
        r22 = r28;
        r30 = null;
        goto L88
    L83:
        if ((r19 instanceof TrainData) == false) goto L87;
        TrainData r120 = (TrainData) r19;
        if (TextUtils.isEmpty(r120.getTrainTicketCheck()) == true) goto L87;
        r114 = new Pair(r120.getTrainTicketCheck(), r17.getString(R.string.travel_train_check_ticket));
        goto L81
    L43:
        if (r18 == EnumC0027a.f) goto L76;
        if (r18 != EnumC0027a.f16446j) goto L51;
        String r37 = String.format(r17.getString(R.string.travel_notification_flight_arrived_to_station), new Object[]{r19.getToStation()});
        if ((r19 instanceof FlightData) == false) goto L50;
        r115 = r37;
        r114 = new Pair(((FlightData) r19).getBaggageID(), r17.getString(R.string.travel_flight_baggage_id));
        r116 = false;
        r30 = null;
        r22 = null;
        goto L88
    L50:
        r22 = null;
        r114 = null;
        r115 = r37;
        r116 = false;
        r30 = null;
        goto L88
    L51:
        r30 = new Pair(b.e().format(Long.valueOf(r19.getCurAvailableFromTimeLong())), r17.getString(R.string.travel_flight_plan_from_time_str));
        if ((r19 instanceof FlightData) == false) goto L59;
        FlightData r38 = (FlightData) r19;
        if (TextUtils.isEmpty(r38.getBoardGate()) == true) goto L59;
        if (r18 != EnumC0027a.f16447k) goto L58;
        Pair r121 = new Pair(r38.getBoardGate(), r17.getString(R.string.travel_flight_board_gate));
        Pair r39 = r30;
        r30 = r121;
    L61:
        if (r18 != EnumC0027a.f16448l) goto L66;
        int r122 = R.string.travel_notification_flight_boarding_gate_changed_str;
    L63:
        r115 = r17.getString(r122);
    L64:
        r114 = r39;
        r116 = false;
        r22 = null;
        goto L88
    L66:
        if (r18 != EnumC0027a.f16449m) goto L69;
        r122 = R.string.travel_notification_flight_start_boarding_str;
        goto L63
    L69:
        if (r18 == EnumC0027a.f16447k) goto L71;
        r115 = null;
        r114 = r39;
        r116 = false;
        r22 = null;
        goto L88
    L71:
        if (r19.getFromTimeDelayTimeLong() <= 0) goto L73;
        String r123 = a(r17, r19.getFromTimeDelayTimeLong());
    L74:
        r115 = String.format(r17.getString(R.string.travel_notification_flight_delayed), new Object[]{r123});
        goto L64
    L73:
        r123 = "";
        goto L74
    L58:
        r39 = new Pair(r38.getBoardGate(), r17.getString(R.string.travel_flight_board_gate));
    L59:
        r39 = r30;
        r30 = null;
        goto L61
    L33:
        r111 = 8;
        goto L34
    L29:
        r16 = 0;
        goto L30
    L22:
        if (r18 == EnumC0027a.f16444h) goto L25;
        r14 = false;
        goto L26
    L18:
        r12 = R.drawable.icon_travel_flight;
        goto L19
    }

    public static boolean b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (a(r5, f) == true) goto L8;
        return false;
    }

    private static Pair<String, PendingIntent> a(Context r10, TravelData r11, boolean r12) {
        b.f r5 = b.a(r11);
        if (r5 == null) goto L5;
        String r13 = r5.name();
    L6:
        String r14 = new Gson().toJson(r11);
        int r15 = R.string.travel_card_btn_navigation;
        int r16 = R.string.travel_card_btn_taxi;
        String r17 = r10.getResources().getResourceEntryName(r15);
        String r18 = r10.getResources().getResourceEntryName(r16);
        String r19 = r10.getString(r15);
        String r20 = r10.getString(r16);
        Intent r21 = new Intent(r10, MiddleJumpAty.class);
        r21.putExtra("to_where", "where_to_map_navigation");
        r21.putExtra("map_navigation_btn_text", r17);
        r21.putExtra("map_navigation_data_key_str", r13);
        r21.putExtra("map_navigation_travel_data_str", r14);
        r21.putExtra("map_navigation_need_cancel", true);
        Intent r22 = new Intent(r21);
        r22.putExtra("map_navigation_btn_text", r18);
        PendingIntent r23 = PendingIntent.getActivity(r10, 1, r21, 201326592);
        PendingIntent r24 = PendingIntent.getActivity(r10, 2, r22, 201326592);
        if (r12 == false) goto L9;
        Pair<String, PendingIntent> r25 = new Pair(r20, r24);
    L10:
        return r25;
    L9:
        r25 = new Pair(r19, r23);
        goto L10
    L5:
        r13 = "";
        goto L6
    }

    private static boolean b(Context r5, boolean r10) {
        if (r10 == false) goto L5;
    L9:
        boolean r11 = false;
    L10:
        m.i("TravelNotificationUtils", "readTravelNotificationSwitchState result=" + r11);
        return r11;
    L5:
        if (x.c(r5, "travel_card") == false) goto L9;
        if (x.c(r5, "travel_notification") == false) goto L9;
        r11 = true;
        goto L10
    }

    private static String a(Context r5, long r10) {
        int r11 = (int) (r10 / 3600000);
        int r12 = (int) ((r10 / 60000) % 60);
        int r13 = r11 / 24;
        int r14 = r11 % 24;
        if (r12 > 0) goto L5;
    L7:
        StringBuilder r15 = new StringBuilder();
        if (r13 <= 0) goto L10;
        r15.append(String.format(r5.getString(R.string.time_description_day), new Object[]{Integer.valueOf(r13)}));
    L10:
        if (r14 <= 0) goto L12;
        r15.append(String.format(r5.getString(R.string.time_description_hour), new Object[]{Integer.valueOf(r14)}));
    L12:
        r15.append(String.format(r5.getString(R.string.time_description_minutes), new Object[]{Integer.valueOf(r12)}));
        return r15.toString();
    L5:
        if (r12 >= 59) goto L7;
        r12 = r12 + 1;
        goto L7
    }

    public static boolean a(String r5) {
        return a(r5, e);
    }

    private static boolean a(Context r5, boolean r10) {
        if (r10 == false) goto L10;
        if (f16439b != null) goto L6;
        f16439b = Boolean.valueOf(b(r5, true));
    L6:
        Boolean r11 = f16439b;
    L8:
        return r11.booleanValue();
    L10:
        if (f16438a != null) goto L12;
        f16438a = Boolean.valueOf(b(r5, false));
    L12:
        r11 = f16438a;
        goto L8
    }

    public static boolean a(String r5, List<EnumC0027a> r10) {
        if (TextUtils.isEmpty(r5) == true) goto L16;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.isEmpty() == true) goto L24;
        ArrayList r11 = new ArrayList();
        Iterator<EnumC0027a> r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        EnumC0027a r13 = r12.next();
        if (r13 == null) goto L10;
        r11.add(r13.name().toLowerCase(Locale.ROOT));
        goto L10
    L15:
        return r11.contains(r5.toLowerCase(Locale.ROOT));
    L24:
        return false;
    L16:
        return false;
    }

    public static boolean a(Context r10, FlightData r11, FlightData r12) {
        boolean r5 = false;
        if (r11 != null) goto L5;
    L71:
        return false;
    L5:
        if (r11.isAvailable() == false) goto L71;
        if (r12 == null) goto L71;
        if (r12.isAvailable() == false) goto L71;
        long r13 = System.currentTimeMillis();
        if (r12.getPlanFromTimeLong() <= 0) goto L15;
        if (r13 <= r12.getPlanFromTimeLong()) goto L15;
    L18:
        boolean r14 = true;
    L20:
        m.i("TravelNotificationUtils", "onFlightDataUpdated hasFrom=" + r14 + ",    oldFlightData=" + r12);
        m.i("TravelNotificationUtils", "onFlightDataUpdated hasFrom=" + r14 + ", updateFlightData=" + r12);
        int r15 = r12.flightStatusCode;
        if (103 != r15) goto L23;
    L64:
        EnumC0027a r16 = EnumC0027a.f16449m;
        if (r12.hasSendNotificationType(r16.name()) == true) goto L71;
        m.i("TravelNotificationUtils", "onFlightDataUpdated FLIGHT_CHANGED_START_BOARDING, travelNumber=" + r12.travelNumber + " boardingGate=" + r12.getBoardGate());
        r12.saveSendNotificationType(r16.name());
        if (r14 == true) goto L69;
        a(r10, r16, r12, String.format(r10.getString(R.string.travel_notification_flight_start_boarding_title), new Object[]{r12.travelNumber}), String.format(r10.getString(R.string.travel_notification_flight_start_boarding_summary), new Object[]{r12.getBoardGate()}));
    L69:
        b.c(r10, r12);
        return true;
    L23:
        if (104 == r15) goto L64;
        if (TextUtils.isEmpty(r11.getBoardGate()) == false) goto L28;
    L38:
        int r17 = r12.flightStatusCode;
        if (2 != r17) goto L53;
        EnumC0027a r18 = EnumC0027a.f16446j;
        if (r12.hasSendNotificationType(r18.name()) == true) goto L71;
        if (r12.getRealToTimeLong() > 0) goto L45;
    L47:
        m.i("TravelNotificationUtils", "onFlightDataUpdated FLIGHT_ARRIVE_XINGLI_ZHUANPAN, travelNumber=" + r12.travelNumber + " isInArrive30Minutes=" + r5 + " getRealToTimeStr=" + r12.getRealToTimeStr() + " getBaggageID=" + r12.getBaggageID());
        r12.saveSendNotificationType(r18.name());
        if (r5 == false) goto L50;
        String r19 = r12.travelNumber + String.format(r10.getString(R.string.travel_notification_flight_arrived_to_station), new Object[]{r12.getToStation()});
        a(r10, r18, r12, r19, r19);
    L50:
        b.c(r10, r12);
        return true;
    L45:
        if ((r12.getRealToTimeLong() + 1800000) < System.currentTimeMillis()) goto L47;
        r5 = true;
        goto L47
    L53:
        if (4 != r17) goto L60;
        EnumC0027a r110 = EnumC0027a.f16447k;
        if (r12.hasSendNotificationType(r110.name()) == true) goto L71;
        m.i("TravelNotificationUtils", "onFlightDataUpdated FLIGHT_CHANGED_PLAN_TIME_DELAYED, travelNumber=" + r12.travelNumber + " old=" + b.i().format(Long.valueOf(r12.getToTimeLong())) + " fromTime=" + r12.getPlanOrRealFromTimeInfo(r10) + " boardingGate=" + r12.getBoardGate());
        r12.saveSendNotificationType(r110.name());
        String r20 = String.format(r10.getString(R.string.travel_notification_flight_delayed), new Object[]{r12.travelNumber});
    L57:
        a(r10, r110, r12, r20, r20);
        b.c(r10, r12);
        return true;
    L60:
        if (3 != r17) goto L71;
        r110 = EnumC0027a.f16450n;
        if (r12.hasSendNotificationType(r110.name()) == true) goto L71;
        m.i("TravelNotificationUtils", "onFlightDataUpdated FLIGHT_CHANGED_CANCELED, travelNumber=" + r12.travelNumber + " travelDate=" + r12.travelDate);
        r12.saveSendNotificationType(r110.name());
        r20 = String.format(r10.getString(R.string.travel_notification_flight_canceled_info), new Object[]{r12.travelNumber});
        goto L57
    L28:
        if (TextUtils.isEmpty(r12.getBoardGate()) == true) goto L38;
        if (r11.getBoardGate().equalsIgnoreCase(r12.getBoardGate()) == true) goto L38;
        EnumC0027a r111 = EnumC0027a.f16448l;
        if (r12.hasSendNotificationType(r111.name()) == true) goto L71;
        m.i("TravelNotificationUtils", "onFlightDataUpdated FLIGHT_CHANGED_BOARDING_GATE, travelNumber=" + r12.travelNumber + " boardingGate=" + r12.getBoardGate());
        r12.saveSendNotificationType(r111.name());
        if (r14 == true) goto L36;
        a(r10, r111, r12, String.format(r10.getString(R.string.travel_notification_flight_boarding_gate_changed_title), new Object[]{r12.travelNumber}), String.format(r10.getString(R.string.travel_notification_flight_boarding_gate_changed_summary), new Object[]{r12.getBoardGate()}));
    L36:
        b.c(r10, r12);
        return true;
    L15:
        if (r12.getRealFromTimeLong() > 0) goto L17;
    L19:
        r14 = false;
        goto L20
    L17:
        if (r13 <= r12.getRealFromTimeLong()) goto L19;
        goto L18
    }

    public static void a(Context r14, ArrayList<TravelData> r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        if (r15.isEmpty() == true) goto L106;
        Iterator<TravelData> r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L107;
        TravelData r5 = r16.next();
        if (r5 == null) goto L8;
        if (r5.isAvailable() == false) goto L8;
        if (r5.isIgnored() == true) goto L8;
        boolean r10 = r5 instanceof FlightData;
        if (r10 == true) goto L21;
        if ((r5 instanceof TrainData) == false) goto L8;
    L21:
        long r11 = System.currentTimeMillis();
        long r12 = r5.getCurAvailableFromTimeLong();
        boolean r13 = false;
        if (r12 <= 0) goto L34;
        boolean r17 = true;
        if (r11 < r12) goto L26;
    L28:
        if (r11 >= r12) goto L34;
        if ((AppUtil.MILLIS_IN_DAYS + r11) <= r12) goto L34;
        if (b.a(r14, r11, r12) != 1) goto L34;
    L35:
        if (r10 == false) goto L37;
        EnumC0027a r18 = EnumC0027a.f16443c;
    L38:
        if (r10 == false) goto L40;
        EnumC0027a r19 = EnumC0027a.f16442b;
    L41:
        boolean r20 = r5.hasSendNotificationType(r18.name());
        boolean r110 = r5.hasSendNotificationType(r19.name());
        m.i("TravelNotificationUtils", "onTimeChanged alreadySend3h=" + r20 + " needSendNotification3h=" + r13 + " alreadySend24h=" + r110 + " needSendNotification24h=" + r17 + " travelData=" + r5);
        if (r20 == true) goto L59;
        if (r13 == false) goto L59;
        r5.saveSendNotificationType(r19.name());
        r5.saveSendNotificationType(r18.name());
        if (r10 == false) goto L47;
        int r21 = R.string.travel_notification_flight_before_3h_title;
    L48:
        String r22 = r14.getString(r21);
        if (r10 == false) goto L51;
        int r23 = R.string.travel_notification_flight_before_3h_summary;
    L52:
        String r24 = String.format(r14.getString(r23), new Object[]{r5.travelNumber});
        if (r10 == false) goto L58;
        if (r10 == false) goto L58;
        FlightData r25 = (FlightData) r5;
        if (TextUtils.isEmpty(r25.getBoardGate()) == true) goto L58;
        r24 = String.format(r14.getString(R.string.travel_notification_flight_before_3h_summary_with_boarding_gate), new Object[]{r5.travelNumber, r25.getBoardGate()});
    L58:
        a(r14, r18, r5, r22, r24);
    L82:
        b.c(r14, r5);
        goto L8
    L51:
        r23 = R.string.travel_notification_train_before_3h_summary;
        goto L52
    L47:
        r21 = R.string.travel_notification_train_before_3h_title;
    L59:
        if (r110 == true) goto L8;
        if (r17 == false) goto L8;
        r5.saveSendNotificationType(r19.name());
        String r26 = "";
        if (r12 > 0) goto L85;
    L68:
        if (r10 == false) goto L70;
        int r27 = R.string.travel_notification_flight_before_24h_title;
    L71:
        String r28 = r14.getString(r27);
        if (r10 == false) goto L74;
        int r29 = R.string.travel_notification_flight_before_24h_summary;
    L75:
        String r30 = String.format(r14.getString(r29), new Object[]{r5.travelNumber, r26});
        if (r10 == false) goto L81;
        if (r10 == false) goto L81;
        FlightData r31 = (FlightData) r5;
        if (TextUtils.isEmpty(r31.getBoardGate()) == true) goto L81;
        r30 = String.format(r14.getString(R.string.travel_notification_flight_before_24h_summary_with_boarding_gate), new Object[]{r5.travelNumber, r26, r31.getBoardGate()});
    L81:
        a(r14, r19, r5, r28, r30);
        goto L82
    L74:
        r29 = R.string.travel_notification_train_before_24h_summary;
        goto L75
    L70:
        r27 = R.string.travel_notification_train_before_24h_title;
        goto L71
    L85:
        String r32 = r14.getString(R.string.travel_notification_time_format);     // Catch: Throwable -> L66
        r26 = s0.f(r32).format(Long.valueOf(r12));     // Catch: Throwable -> L84
    L67:
        m.l("TravelNotificationUtils", "onTimeChanged timeFormatStr format error, timeFormatStr=" + r32);
    L66:
        r32 = "";
        goto L67
    L40:
        r19 = EnumC0027a.e;
        goto L41
    L37:
        r18 = EnumC0027a.f;
        goto L38
    L26:
        if ((10800000 + r11) <= r12) goto L28;
        r17 = false;
        r13 = true;
    L34:
        r17 = false;
        goto L35
    L107:
        return;
    }

    public static void a(Context r10, TravelData r11) {
        if (b(EnumC0027a.f16441a.name()) == true) goto L5;
    L8:
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.isAvailable() == true) goto L12;
        return;
    L12:
        if (r11.isIgnored() == true) goto L56;
        boolean r5 = r11 instanceof FlightData;
        if (r5 == false) goto L17;
    L19:
        long r12 = System.currentTimeMillis();
        long r13 = r11.getCurAvailableFromTimeLong();
        if (r13 > 0) goto L22;
    L24:
        boolean r14 = false;
    L25:
        if (r5 == false) goto L27;
        int r15 = R.string.travel_notification_flight_create_title;
    L28:
        String r16 = r10.getString(r15);
        String r17 = "";
        if (r13 > 0) goto L49;
    L35:
        if (r5 == false) goto L37;
        int r18 = R.string.travel_notification_flight_create_summary;
    L38:
        String r19 = String.format(r10.getString(r18), new Object[]{r11.travelNumber, r17});
        if (r5 == false) goto L41;
        EnumC0027a r20 = EnumC0027a.f16441a;
    L42:
        boolean r21 = r11.hasSendNotificationType(r20.name());
        m.i("TravelNotificationUtils", "onTravelDataAdded alreadySend=" + r21 + " needSendNotification=" + r14 + " travelData=" + r11);
        if (r21 == true) goto L55;
        if (r14 == false) goto L46;
        a(r10, r20, r11, r16, r19);
    L46:
        r11.saveSendNotificationType(r20.name());
        b.c(r10, r11);
        return;
    L55:
        return;
    L41:
        r20 = EnumC0027a.d;
        goto L42
    L37:
        r18 = R.string.travel_notification_train_create_summary;
        goto L38
    L49:
        String r22 = r10.getString(R.string.travel_notification_time_format);     // Catch: Throwable -> L33
        r17 = s0.f(r22).format(Long.valueOf(r13));     // Catch: Throwable -> L48
    L34:
        m.l("TravelNotificationUtils", "onTravelDataAdded timeFormatStr format error, timeFormatStr=" + r22);
    L33:
        r22 = "";
        goto L34
    L27:
        r15 = R.string.travel_notification_train_create_title;
        goto L28
    L22:
        if (r12 >= r13) goto L24;
        r14 = true;
        goto L25
    L17:
        if ((r11 instanceof TrainData) == true) goto L19;
        return;
    L56:
        return;
    L5:
        if (b(EnumC0027a.d.name()) == false) goto L8;
        m.i("TravelNotificationUtils", "onTravelDataAdded return, isIgnoreNotificationType");
    }

    private static void a(@NonNull Context r5, EnumC0027a r10, TravelData r11, String r12, String r13) {
        if (r10 != null) goto L5;
    L36:
        m.l("TravelNotificationUtils", "sendTravelNotification input error, notificationType=" + r10 + ", title=" + r12);
        return;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L36;
        String r14 = k0.f1060a;
        if (r11 != null) goto L10;
    L34:
        m.l("TravelNotificationUtils", "sendTravelNotification data error, nubiaPushNotificationData=" + r11);
        return;
    L10:
        if (r11.isAvailable() == false) goto L34;
        int r15 = 0;
        if (a(r5, false) == true) goto L16;
        m.i("TravelNotificationUtils", "sendTravelNotification return not isEnableNubiaNotificationPush");
        return;
    L16:
        m.i("TravelNotificationUtils", "sendTravelNotification notificationType=" + r10 + " title=" + r12 + " travelData=" + r11);
        b(r5);
        PendingIntent r16 = PendingIntent.getActivity(r5, 0, new Intent(r5, TravelListAty.class), 201326592);     // Catch: Exception -> L20
        if ((r11 instanceof FlightData) == false) goto L23;
        r15 = R.drawable.icon_travel_flight;     // Catch: Exception -> L20
    L26:
        RemoteViews r17 = a(r5, r10, r11);     // Catch: Exception -> L20
        NotificationCompat.Builder r18 = new NotificationCompat.Builder(r5, "miboard_travel_notification").setContentIntent(r16).setAutoCancel(true).setSmallIcon(r15);     // Catch: Exception -> L20
        if (r17 == null) goto L29;
        r18.setCustomContentView(r17).addExtras(new Bundle());     // Catch: Exception -> L20
    L30:
        ((NotificationManager) r5.getSystemService(Constant.NOTIFICATION)).notify(1101, r18.build());     // Catch: Exception -> L20
        return;
    L29:
        r18.setContentTitle(r12).setContentText(r13);     // Catch: Exception -> L20
        goto L30
    L23:
        if ((r11 instanceof TrainData) == false) goto L25;
        r15 = R.drawable.icon_travel_train;     // Catch: Exception -> L20
        goto L26
    L25:
        boolean r19 = r11 instanceof MatchData;     // Catch: Exception -> L20
    L20:
        e = move-exception;
        m.j("TravelNotificationUtils", "sendTravelNotification error", e);
    }
}
