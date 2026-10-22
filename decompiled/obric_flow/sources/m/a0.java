package m;

import ai.j0;
import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.motion.widget.a;
import cn.nubia.neopush.commons.Constant;
import com.zte.miboard.recommend.agent.data.FlightData;
import com.zte.miboard.recommend.agent.data.IntelligentAgentData;
import com.zte.miboard.recommend.agent.data.TrainData;
import com.zte.miboard.recommend.agent.data.TravelData;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f19857b = null;

    static {
        f19857b = "Mi_R_".concat(a0.class.getSimpleName());
    }

    public static String c(Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.toString();
    }

    @Override // m.y
    public final boolean a(String r35, String r36, Object... r37) {
        if (r37 == null) goto L8;
        int r5 = 0;
        String r10 = "";
    L6:
        if (r5 >= r37.length) goto L9;
        r10 = r10 + " p" + r5 + ": " + r37[r5];
        r5 = r5 + 1;
    L9:
        StringBuilder r11 = a.y("test debug agent onLocalCallback in travel toolName:", r35, ",funcName:", r36, ",param=");
        r11.append(r10);
        String r12 = r11.toString();
        String r13 = f19857b;
        Log.d(r13, r12);
        if ("LocalTravelBookingTool".equals(r35) == true) goto L12;
        return false;
    L12:
        if (r37 != null) goto L15;
        return false;
    L15:
        if ("extractTicketSuccessInfo".equals(r36) == true) goto L17;
        boolean r14 = "extractTicketModifyInfo".equals(r36);
        Context r15 = this.f19940a;
        if (r14 == false) goto L93;
        if (r37.length != 18) goto L129;
        Object r16 = r37[0];
        if (r16 != null) goto L32;
        Boolean r17 = null;
    L33:
        boolean r18 = r17.booleanValue();
        String r19 = c(r37[1]);
        String r20 = c(r37[2]);
        String r110 = c(r37[3]);
        String r111 = c(r37[4]);
        String r112 = c(r37[5]);
        String r113 = c(r37[6]);
        String r114 = c(r37[7]);
        String r21 = c(r37[8]);
        String r22 = c(r37[9]);
        String r23 = c(r37[10]);
        String r24 = c(r37[11]);
        String r25 = c(r37[12]);
        String r26 = c(r37[13]);
        String r27 = c(r37[14]);
        String r28 = c(r37[15]);
        String r29 = c(r37[16]);
        String r30 = c(r37[17]);
        StringBuilder r31 = a.y("bookPerson:", r19, ",dateStartOld:", r20, ",dateEndOld:");
        a.C(r31, r110, ",fromPosOld:", r111, ",toPosOld:");
        a.C(r31, r112, ",travelNumberOld:", r113, ",carriageNumberOld:");
        a.C(r31, r114, ",seatNumberOld:", r21, ",ticketCheckOld:");
        a.C(r31, r22, ",dateStartNew:", r23, ",dateEndNew=");
        a.C(r31, r24, ",fromPosNew:", r25, ",toPosNew:");
        String r32 = r26;
        a.C(r31, r32, ",travelNumberNew:", r27, ",carriageNumberNew:");
        a.C(r31, r28, ",seatNumberNew:", r29, ",ticketCheckNew:");
        r31.append(r30);
        String r33 = r31.toString();
        if (r111 != null) goto L36;
    L39:
        String r115 = "";
        String r34 = "机场|国际";
    L38:
        String r210 = r111;
        if (r112 != null) goto L42;
    L44:
        String r211 = r112;
        if (r25 != null) goto L47;
    L49:
        if (r32 != null) goto L51;
    L53:
        a.A("test debug agent LocalTravelBookingTool extractTicketModifyInfo,param:", r33, r13);
        if (r20 == null) goto L89;
        if (r20.isEmpty() == true) goto L89;
        if (r113 == null) goto L89;
        if (r113.isEmpty() == true) goto L89;
        if (r210 == null) goto L89;
        if (r210.isEmpty() == true) goto L89;
        if (r18 == false) goto L66;
        TravelData r38 = TrainData.parseToTrainData(r19, r20, r110, r210, r211, r113, r114, r21);
    L67:
        if (r22 != null) goto L69;
    L71:
        if (r18 == false) goto L73;
        TravelData r39 = TrainData.parseToTrainData(r19, r23, r24, r25, r32, r27, r28, r29);
    L74:
        if (r4 != 0) goto L76;
    L78:
        Log.d(r13, "travelDataOld = " + r38);
        Log.d(r13, "travelDataNew = " + r39);
        Log.d(r13, "update negative screen");
        if (r39.travelDate.equals(r38.travelDate) == true) goto L81;
    L83:
        String r40 = "change";
        TravelData r41 = r38;
    L85:
        if (r18 == false) goto L87;
        String r42 = "train";
    L88:
        b0.b(r15, new IntelligentAgentData(r42, r40, r39, r41));
    L90:
        return false;
    L87:
        r42 = "flight";
        goto L88
    L81:
        if (r39.travelNumber.equals(r38.travelNumber) == false) goto L83;
        r40 = "update";
        r41 = null;
        goto L85
    L76:
        if (r4.isEmpty() == true) goto L78;
        r39.trainTicketCheck = r30;
        goto L78
    L73:
        r39 = FlightData.parseToFlightData(r19, r23, r24, r25, r32, r27);
        goto L74
    L69:
        if (r22.isEmpty() == true) goto L71;
        r38.trainTicketCheck = r22;
        goto L71
    L66:
        r38 = FlightData.parseToFlightData(r19, r20, r110, r210, r211, r113);
    L89:
        Log.d(r13, "old travel data is incomplete, add only new travel data, don't update");
        b(r18, r19, r23, r24, r25, r32, r27, "", r28, r29, r4);
        goto L90
    L51:
        if (r32.isEmpty() == true) goto L53;
        r32 = r32.replaceAll(r34, r115);
        goto L53
    L47:
        if (r25.isEmpty() == true) goto L49;
        r25 = r25.replaceAll(r34, r115);
        goto L49
    L42:
        if (r112.isEmpty() == true) goto L44;
        r112 = r112.replaceAll(r34, r115);
        goto L44
    L36:
        if (r111.isEmpty() == true) goto L39;
        r115 = "";
        r34 = "机场|国际";
        r111 = r111.replaceAll(r34, r115);
        goto L38
    L32:
        r17 = (Boolean) r16;
        goto L33
    L129:
        return false;
    L93:
        if ("extractTicketCancelInfo".equals(r36) == false) goto L90;
        if (r37.length != 10) goto L125;
        Object r43 = r37[0];
        if (r43 != null) goto L99;
        Boolean r44 = null;
    L100:
        boolean r45 = r44.booleanValue();
        String r46 = c(r37[1]);
        String r47 = c(r37[2]);
        String r48 = c(r37[3]);
        String r116 = c(r37[4]);
        String r117 = c(r37[5]);
        String r118 = c(r37[6]);
        String r119 = c(r37[7]);
        String r120 = c(r37[8]);
        String r49 = c(r37[9]);
        StringBuilder r50 = a.y("bookPerson:", r46, ",dateStart:", r47, ",dateEnd:");
        a.C(r50, r48, ",fromPos:", r116, ",toPos:");
        a.C(r50, r117, ",travelNumber:", r118, ",carriageNumber:");
        a.C(r50, r119, ",seatNumber:", r120, ",ticketCheck:");
        r50.append(r49);
        String r51 = r50.toString();
        if (r116 != null) goto L103;
    L105:
        String r212 = r116;
    L106:
        if (r117 != null) goto L108;
    L110:
        String r213 = r117;
    L111:
        a.A("test debug agent LocalTravelBookingTool extractTicketCancelInfo,param:", r51, r13);
        if (r45 == false) goto L114;
        TravelData r52 = TrainData.parseToTrainData(r46, r47, r48, r212, r213, r118, r119, r120);
    L115:
        if (r49 != null) goto L117;
    L119:
        Log.d(r13, "travelData = " + r52);
        if (r45 == false) goto L122;
        String r53 = "train";
    L123:
        b0.b(r15, new IntelligentAgentData(r53, Constant.ClientMessageType.DELETE, r52, null));
        return true;
    L122:
        r53 = "flight";
        goto L123
    L117:
        if (r49.isEmpty() == true) goto L119;
        r52.trainTicketCheck = r49;
        goto L119
    L114:
        r52 = FlightData.parseToFlightData(r46, r47, r48, r212, r213, r118);
        goto L115
    L108:
        if (r117.isEmpty() == true) goto L110;
        r213 = r117.replaceAll("机场|国际", "");
        goto L111
    L103:
        if (r116.isEmpty() == true) goto L105;
        r212 = r116.replaceAll("机场|国际", "");
        goto L106
    L99:
        r44 = (Boolean) r43;
        goto L100
    L125:
        return false;
    L17:
        if (r37.length != 11) goto L24;
        Object r54 = r37[0];
        if (r54 != null) goto L21;
        Boolean r55 = null;
    L22:
        b(r55.booleanValue(), c(r37[1]), c(r37[2]), c(r37[3]), c(r37[4]), c(r37[5]), c(r37[6]), c(r37[7]), c(r37[8]), c(r37[9]), c(r37[10]));
        return true;
    L21:
        r55 = (Boolean) r54;
        goto L22
    L24:
        return false;
    L8:
        r10 = "";
        goto L9
    }

    public final void b(boolean r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26) {
        String r5 = r20;
        StringBuilder r10 = a.y("bookPerson:", r17, ",dateStart:", r18, ",dateEnd:");
        a.C(r10, r19, ",fromPos:", r5, ",toPos:");
        a.C(r10, r21, ",travelNumber:", r22, ",carriageNumber:");
        a.C(r10, r24, ",seatNumber:", r25, ",orderNumber");
        String r11 = a.t(r10, r23, ",ticketCheck", r26);
        if (r5 != null) goto L5;
    L7:
        String r12 = r5;
        if (r21 != null) goto L10;
    L12:
        String r13 = r21;
    L13:
        String r14 = j0.C("test debug agent LocalTravelBookingTool extractTicketSuccessInfo,param:", r11);
        String r15 = f19857b;
        Log.d(r15, r14);
        if (r16 == false) goto L16;
        TravelData r27 = TrainData.parseToTrainData(r17, r18, r19, r12, r13, r22, r24, r25);
    L17:
        if (r26 == null) goto L22;
        if (r26.isEmpty() == true) goto L22;
        r27.trainTicketCheck = r26;
    L22:
        if (i.f19880a == false) goto L31;
        if (r23 == null) goto L31;
        if (r23.isEmpty() == true) goto L31;
        r27.cardDetailsPagePkg = "com.gm.cloud.travel";
        StringBuilder r28 = new StringBuilder("gmcloud://aitravel?pageRoute=");
        if (r16 == false) goto L29;
        String r29 = "trainOrderDetail";
    L30:
        r27.cardDetailsPageDeepLink = a.u(r28, r29, "&params=%7B%22orderId%22%3A%22", r23, "%22%7D");
        StringBuilder r30 = new StringBuilder("packagename = ");
        r30.append(r27.cardDetailsPagePkg);
        r30.append(" deeplink = ");
        a.B(r30, r27.cardDetailsPageDeepLink, r15);
        goto L31
    L29:
        r29 = "airSingleOrderDetail";
    L31:
        Log.d(r15, "travelData = " + r27);
        if (r16 == false) goto L34;
        String r31 = "train";
    L35:
        b0.b(this.f19940a, new IntelligentAgentData(r31, "add", r27, null));
        return;
    L34:
        r31 = "flight";
        goto L35
    L16:
        r27 = FlightData.parseToFlightData(r17, r18, r19, r12, r13, r22);
        goto L17
    L10:
        if (r21.isEmpty() == true) goto L12;
        r13 = r21.replaceAll("机场|国际", "");
        goto L13
    L5:
        if (r20.isEmpty() == true) goto L7;
        r5 = r5.replaceAll("机场|国际", "");
        goto L7
    }
}
