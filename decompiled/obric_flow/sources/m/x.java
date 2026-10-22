package m;

import ai.j0;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.util.Log;
import androidx.constraintlayout.motion.widget.a;
import cn.nubia.neopush.commons.AppUtil;
import cn.nubia.neopush.commons.Constant;
import com.zte.miboard.recommend.agent.data.HotelData;
import com.zte.miboard.recommend.agent.data.IntelligentAgentData;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f19939b = null;

    static {
        f19939b = "Mi_R_".concat(x.class.getSimpleName());
    }

    public static String b(Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.toString();
    }

    @Override // m.y
    public final boolean a(String r43, String r44, Object... r45) {
        if (r45 == null) goto L8;
        int r10 = 0;
        String r11 = "";
    L6:
        if (r10 >= r45.length) goto L9;
        r11 = r11 + " p" + r10 + ": " + r45[r10];
        r10 = r10 + 1;
    L9:
        StringBuilder r12 = a.y("test debug agent onLocalCallback in hotel toolName:", r43, ",funcName:", r44, ",param=");
        r12.append(r11);
        String r13 = r12.toString();
        String r14 = f19939b;
        Log.d(r14, r13);
        if ("LocalHotelBookingTool".equals(r43) == true) goto L12;
        return false;
    L12:
        if (r45 != null) goto L14;
        return false;
    L14:
        boolean r5 = "extractHotelSuccessInfo".equals(r44);
        Context r15 = this.f19940a;
        if (r5 == false) goto L28;
        if (r45.length != 6) goto L26;
        String r16 = b(r45[0]);
        String r17 = b(r45[1]);
        String r18 = b(r45[2]);
        String r19 = b(r45[3]);
        String r20 = b(r45[4]);
        String r21 = b(r45[5]);
        StringBuilder r110 = a.y("bookPerson:", r16, ",dateStart:", r17, ",dateEnd:");
        a.C(r110, r18, ",hotel:", r19, ",roomType:");
        a.A("test debug agent LocalHotelBookingTool extractHotelSuccessInfo,param:", a.t(r110, r20, ",orderNumber", r21), r14);
        HotelData r22 = HotelData.parseToHotelData(r16, r17, r18, r19, r20);
        if (i.f19880a == false) goto L24;
        if (r21 == null) goto L24;
        if (r21.isEmpty() == true) goto L24;
        r22.cardDetailsPagePkg = "com.gm.cloud.travel";
        r22.cardDetailsPageDeepLink = j0.k("gmcloud://aitravel?pageRoute=hotelOrderDetail&params=%7B%22orderId%22%3A%22", r21, "%22%7D");
        StringBuilder r23 = new StringBuilder("packagename = ");
        r23.append(r22.cardDetailsPagePkg);
        r23.append(" deeplink = ");
        a.B(r23, r22.cardDetailsPageDeepLink, r14);
    L24:
        b0.b(r15, new IntelligentAgentData("hotel", "add", r22, null));
        return true;
    L26:
        return false;
    L28:
        if ("extractHotelModifyInfo".equals(r44) == false) goto L164;
        if (r45.length != 9) goto L206;
        String r24 = b(r45[0]);
        String r25 = b(r45[1]);
        String r111 = b(r45[2]);
        String r112 = b(r45[3]);
        String r113 = b(r45[4]);
        String r114 = b(r45[5]);
        String r26 = b(r45[6]);
        String r115 = b(r45[7]);
        String r27 = b(r45[8]);
        StringBuilder r28 = a.y("test debug agent TicketParseTool extractHotelModifyInfo 000 in run，bookPerson=", r24, ",dateStartOld=", r25, ",dateEndOld=");
        a.C(r28, r111, ",hotelOld=", r112, ",roomTypeOld=");
        a.C(r28, r113, ",dateStartNew=", r114, ",dateEndNew=");
        a.C(r28, r26, ",hotelNew=", r115, ",roomTypeNew=");
        a.B(r28, r27, r14);
        if (r115 != null) goto L34;
    L161:
        return false;
    L34:
        if (r115.isEmpty() == true) goto L161;
        if (r25 != null) goto L38;
    L49:
        String r46 = "hotel";
        String r47 = r27;
        long r29 = 0;
        if (r111 != null) goto L52;
    L105:
        Context r33 = r15;
        if (r25 != null) goto L108;
    L160:
        Log.e(r14, "test debug agent extractHotelModifyInfo message is not integrated, return");
        goto L161
    L108:
        if (r25.isEmpty() == true) goto L160;
        if (r114 == null) goto L160;
        if (r114.isEmpty() == true) goto L160;
        Log.d(r14, "test debug agent extractHotelModifyInfo only modify start time");
        int r116 = r.f19905c;
        String r117 = d.f19867b;
        Log.d(r117, "enter searchStartDate");
        String r118 = g.d(r25);
        if (r118 != null) goto L115;
    L117:
        String r119 = "";
    L191:
        DateTimeFormatter r30 = DateTimeFormatter.ofPattern("yyyy-MM-dd");     // Catch: Exception -> L128
        String r31 = r14;
        String r32 = "Error search calendar events";
        String r34 = LocalDate.parse(r118, r30).plusDays(1).format(r30) + " 00:00";     // Catch: Exception -> L173
        long r35 = g.a(r119);     // Catch: Exception -> L173
        r29 = g.a(r34);     // Catch: Exception -> L127
        long r36 = r35 + ((long) TimeZone.getTimeZone("Asia/Shanghai").getOffset(r35));
        long r210 = (r29 + ((long) TimeZone.getTimeZone("Asia/Shanghai").getOffset(r36))) + AppUtil.MILLIS_IN_DAYS;
    L197:
        Cursor r37 = r33.getContentResolver().query(CalendarContract.Events.CONTENT_URI, null, "dtstart>=? AND dtstart<=? AND eventType=? AND deleted=0 AND description LIKE ?", new String[]{String.valueOf(r36), String.valueOf(r210), String.valueOf(200), j0.k("%", r115, "%")}, null);     // Catch: Exception -> L139
        if (r37 != null) goto L177;
    L143:
        Log.e(r117, "don't find data!");     // Catch: Throwable -> L141
        if (r37 == null) goto L146;
        r37.close();     // Catch: Exception -> L139
    L146:
        String r38 = "";
    L156:
        if (r38.isEmpty() == false) goto L158;
        Log.e(r31, "test debug agent Error: don't find calendar");
        goto L161
    L158:
        r26 = r38;
        r111 = r26;
        r24 = r24;
        String r39 = r112;
        String r40 = r113;
        r114 = r114;
        r25 = r25;
    L159:
        HotelData r41 = HotelData.parseToHotelData(r24, r25, r111, r39, r40);
        HotelData r42 = HotelData.parseToHotelData(r24, r114, r26, r115, r47);
        r42.travelDate = r41.travelDate;
        b0.b(r33, new IntelligentAgentData(r46, "update", r42, null));
        goto L161
    L177:
    L141:
        th = move-exception;
        if (r37 == null) goto L203;
        r37.close();     // Catch: Throwable -> L150
    L204:
        throw th;     // Catch: Exception -> L139
    L150:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L139
        throw th;     // Catch: Exception -> L139
    L203:
        throw th;     // Catch: Exception -> L139
    L135:
        if (r37.moveToFirst() == false) goto L143;
        long r48 = r37.getLong(r37.getColumnIndex("dtend"));     // Catch: Throwable -> L141
        long r49 = (r48 - 1) - ((long) TimeZone.getTimeZone("Asia/Shanghai").getOffset(r48));     // Catch: Throwable -> L141
        String r50 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(r49));     // Catch: Throwable -> L141
        Log.d(r117, "searchMillis: " + r49 + "formattedDate = " + r50);     // Catch: Throwable -> L141
        r37.close();     // Catch: Exception -> L139
        r38 = r50;
    L139:
        e = move-exception;
        Log.e(r117, r32, e);
    L125:
        long r410 = r36;
    L126:
        long r51 = r29;
        r29 = r410;
    L130:
        Log.e("HotelData", "error: parse data failed, please check data");
        long r411 = r51;
        r36 = r29;
        r210 = r411;
    L127:
        r410 = r35;
    L129:
        r51 = 0;
    L128:
        r31 = r14;
        r32 = "Error search calendar events";
        goto L129
    L115:
        if (r118.isEmpty() == true) goto L117;
        r119 = r118.concat(" 00:00");
        goto L191
    L52:
        if (r111.isEmpty() == true) goto L105;
        if (r26 == null) goto L105;
        if (r26.isEmpty() == true) goto L105;
        Log.d(r14, "test debug agent extractHotelModifyInfo only modify end time");
        int r52 = r.f19905c;
        String r53 = d.f19867b;
        Log.d(r53, "enter searchEndDate");
        String r54 = g.d(r111);
        if (r54 != null) goto L59;
    L61:
        String r120 = "";
    L198:
        DateTimeFormatter r121 = DateTimeFormatter.ofPattern("yyyy-MM-dd");     // Catch: Exception -> L74
        String r310 = "formattedDate = ";
        r33 = r15;
        String r55 = LocalDate.parse(r54, r121).minusDays(1).format(r121) + " 00:00";     // Catch: Exception -> L172
        Log.d(r53, "searchEndDate fromTime = " + r55 + " toTime = " + r120);     // Catch: Exception -> L172
        long r56 = g.a(r55);     // Catch: Exception -> L172
        long r57 = g.a(r120);     // Catch: Exception -> L72
        String r122 = "searchMillis: ";
        r56 = r56 + ((long) TimeZone.getTimeZone("Asia/Shanghai").getOffset(r56));
        r57 = (r57 + ((long) TimeZone.getTimeZone("Asia/Shanghai").getOffset(r57))) + AppUtil.MILLIS_IN_DAYS;     // Catch: Exception -> L171
        Log.d(r53, "searchEndDate startMillis = " + r56 + " endMillis = " + r57);     // Catch: Exception -> L171
    L77:
        ContentResolver r211 = r33.getContentResolver();
        String[] r212 = {String.valueOf(r56), String.valueOf(r57), String.valueOf(200), j0.k("%", r115, "%")};
        a.B(new StringBuilder("search condition = dtend>=? AND dtend<=? AND eventType=? AND deleted=0 AND description LIKE ? selectionargs = "), Arrays.toString(r212), r53);
        Cursor r58 = r211.query(CalendarContract.Events.CONTENT_URI, null, "dtend>=? AND dtend<=? AND eventType=? AND deleted=0 AND description LIKE ?", r212, null);     // Catch: Exception -> L85
        if (r58 != null) goto L174;
    L89:
        Log.e(r53, "don't find data!");     // Catch: Throwable -> L87
        if (r58 == null) goto L92;
        r58.close();     // Catch: Exception -> L85
    L92:
        String r59 = "";
    L102:
        if (r59.isEmpty() == false) goto L104;
        Log.e(r14, "test debug agent Error: don't find calendar");
        goto L161
    L104:
        r25 = r59;
        r114 = r25;
        r24 = r24;
        r39 = r112;
        r40 = r113;
        r26 = r26;
        r111 = r111;
        goto L159
    L174:
    L87:
        th = move-exception;
        if (r58 == null) goto L201;
        r58.close();     // Catch: Throwable -> L96
    L202:
        throw th;     // Catch: Exception -> L85
    L96:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L85
        throw th;     // Catch: Exception -> L85
    L201:
        throw th;     // Catch: Exception -> L85
    L81:
        if (r58.moveToFirst() == false) goto L89;
        long r60 = r58.getLong(r58.getColumnIndex("dtstart"));     // Catch: Throwable -> L87
        String r61 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(r60));     // Catch: Throwable -> L87
        Log.d(r53, r122 + r60 + r310 + r61);     // Catch: Throwable -> L87
        r58.close();     // Catch: Exception -> L85
        r59 = r61;
    L85:
        e = move-exception;
        Log.e(r53, "Error search calendar events", e);
    L70:
        r29 = r56;
    L76:
        Log.e("HotelData", "error: parse data failed, please check data");
        r56 = r29;
    L71:
        r122 = "searchMillis: ";
    L72:
        r122 = "searchMillis: ";
        r57 = 0;
    L73:
        r122 = "searchMillis: ";
        r57 = 0;
    L74:
        r310 = "formattedDate = ";
        r33 = r15;
        goto L73
    L59:
        if (r54.isEmpty() == true) goto L61;
        r120 = r54.concat(" 00:00");
        goto L198
    L38:
        if (r25.isEmpty() == true) goto L49;
        if (r114 == null) goto L49;
        if (r114.isEmpty() == true) goto L49;
        if (r111 == null) goto L49;
        if (r111.isEmpty() == true) goto L49;
        if (r26 == null) goto L49;
        if (r26.isEmpty() == true) goto L49;
        Log.d(r14, "test debug agent extractHotelModifyInfo the time message is integrated");
        r47 = r27;
        r33 = r15;
        r46 = "hotel";
        r40 = r113;
        r39 = r112;
        goto L159
    L206:
        return false;
    L164:
        if ("extractHotelCancelInfo".equals(r44) == false) goto L161;
        if (r45.length != 5) goto L169;
        String r62 = b(r45[0]);
        String r63 = b(r45[1]);
        String r64 = b(r45[2]);
        String r65 = b(r45[3]);
        String r66 = b(r45[4]);
        StringBuilder r67 = a.y("test debug agent TicketParseTool extractHotelCancelInfo 000 in run，bookPerson=", r62, ",dateStart=", r63, ",dateEnd=");
        a.C(r67, r64, ",hotel=", r65, ",roomType=");
        a.B(r67, r66, r14);
        b0.b(r15, new IntelligentAgentData("hotel", Constant.ClientMessageType.DELETE, HotelData.parseToHotelData(r62, r63, r64, r65, r66), null));
        return true;
    L169:
        return false;
    L8:
        r11 = "";
        goto L9
    }
}
