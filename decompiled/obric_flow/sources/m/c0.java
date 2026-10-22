package m;

import android.util.Log;
import com.google.gson.Gson;
import com.zte.miboard.recommend.agent.HandleService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f19866c = null;

    static {
        f19866c = "Mi_R_".concat(c0.class.getSimpleName());
    }

    public final void a(String r58) {
        HashMap r5 = (HashMap) new Gson().fromJson(r58, HashMap.class);     // Catch: Exception -> L4
    L6:
        if (r5 != null) goto L9;
        Log.d(f19866c, "test debug agent parseData map null");
        return;
    L9:
        String r10 = (String) r5.get("dataType");
        boolean r11 = "BOOKING_FLIGHT".equals(r10);
        HandleService r12 = this.f19868a;
        String r18 = "";
        if (r11 == false) goto L27;
        String r13 = (String) r5.get("bookingType");
        if ("BOOKING_FIRST".equals(r13) == false) goto L19;
        String r20 = (String) r5.get("bookPerson");
        String r21 = (String) r5.get("dateStart");
        String r22 = (String) r5.get("dateEnd");
        String r23 = (String) r5.get("fromPos");
        String r24 = (String) r5.get("toPos");
        String r25 = (String) r5.get("travelNumber");
        if (i.f19880a == false) goto L16;
        r18 = (String) r5.get("orderNumber");
    L16:
        Boolean r19 = Boolean.FALSE;
        r12.a("LocalTravelBookingTool", "extractTicketSuccessInfo", new Object[]{r19, r20, r21, r22, r23, r24, r25, r18, null, null, null});
        return;
    L19:
        if ("BOOKING_MODIFY".equals(r13) == false) goto L23;
        String r29 = (String) r5.get("bookPerson");
        String r30 = (String) r5.get("dateStartOld");
        String r31 = (String) r5.get("dateEndOld");
        String r32 = (String) r5.get("fromPosOld");
        String r33 = (String) r5.get("toPosOld");
        String r34 = (String) r5.get("travelNumberOld");
        String r38 = (String) r5.get("dateStartNew");
        String r39 = (String) r5.get("dateEndNew");
        String r40 = (String) r5.get("fromPosNew");
        String r41 = (String) r5.get("toPosNew");
        String r42 = (String) r5.get("travelNumberNew");
        r12.a("LocalTravelBookingTool", "extractTicketModifyInfo", new Object[]{Boolean.FALSE, r29, r30, r31, r32, r33, r34, null, null, null, r38, r39, r40, r41, r42, null, null, null});
        return;
    L23:
        if ("BOOKING_CANCEL".equals(r13) == false) goto L64;
        String r17 = (String) r5.get("bookPerson");
        String r110 = (String) r5.get("dateStart");
        String r111 = (String) r5.get("dateEnd");
        String r26 = (String) r5.get("fromPos");
        String r27 = (String) r5.get("toPos");
        String r28 = (String) r5.get("travelNumber");
        r12.a("LocalTravelBookingTool", "extractTicketCancelInfo", new Object[]{Boolean.FALSE, r17, r110, r111, r26, r27, r28, null, null, null});
        return;
    L64:
        return;
    L27:
        if ("BOOKING_TRAIN".equals(r10) == false) goto L44;
        String r14 = (String) r5.get("bookingType");
        if ("BOOKING_FIRST".equals(r14) == false) goto L36;
        String r210 = (String) r5.get("bookPerson");
        String r211 = (String) r5.get("dateStart");
        String r212 = (String) r5.get("dateEnd");
        String r213 = (String) r5.get("fromPos");
        String r214 = (String) r5.get("toPos");
        String r215 = (String) r5.get("travelNumber");
        String r216 = (String) r5.get("trainCarriageNumber");
        String r217 = (String) r5.get("trainSeatNumber");
        String r218 = (String) r5.get("ticketCheck");
        if (i.f19880a == false) goto L33;
        r18 = (String) r5.get("orderNumber");
    L33:
        Boolean r112 = Boolean.TRUE;
        r12.a("LocalTravelBookingTool", "extractTicketSuccessInfo", new Object[]{r112, r210, r211, r212, r213, r214, r215, r18, r216, r217, r218});
        return;
    L36:
        if ("BOOKING_MODIFY".equals(r14) == false) goto L40;
        String r219 = (String) r5.get("bookPerson");
        String r35 = (String) r5.get("dateStartOld");
        String r36 = (String) r5.get("dateEndOld");
        String r37 = (String) r5.get("fromPosOld");
        String r310 = (String) r5.get("toPosOld");
        String r311 = (String) r5.get("travelNumberOld");
        String r312 = (String) r5.get("trainCarriageNumberOld");
        String r313 = (String) r5.get("trainSeatNumberOld");
        String r314 = (String) r5.get("ticketCheckOld");
        String r315 = (String) r5.get("dateStartNew");
        String r316 = (String) r5.get("dateEndNew");
        String r43 = (String) r5.get("fromPosNew");
        String r44 = (String) r5.get("toPosNew");
        String r45 = (String) r5.get("travelNumberNew");
        String r46 = (String) r5.get("trainCarriageNumberNew");
        String r47 = (String) r5.get("trainSeatNumberNew");
        String r48 = (String) r5.get("ticketCheckNew");
        r12.a("LocalTravelBookingTool", "extractTicketModifyInfo", new Object[]{Boolean.TRUE, r219, r35, r36, r37, r310, r311, r312, r313, r314, r315, r316, r43, r44, r45, r46, r47, r48});
        return;
    L40:
        if ("BOOKING_CANCEL".equals(r14) == false) goto L65;
        String r113 = (String) r5.get("bookPerson");
        String r114 = (String) r5.get("dateStart");
        String r115 = (String) r5.get("dateEnd");
        String r220 = (String) r5.get("fromPos");
        String r221 = (String) r5.get("toPos");
        String r222 = (String) r5.get("travelNumber");
        String r223 = (String) r5.get("trainCarriageNumber");
        String r224 = (String) r5.get("trainSeatNumber");
        String r225 = (String) r5.get("ticketCheck");
        r12.a("LocalTravelBookingTool", "extractTicketCancelInfo", new Object[]{Boolean.TRUE, r113, r114, r115, r220, r221, r222, r223, r224, r225});
        return;
    L65:
        return;
    L44:
        if ("BOOKING_HOTEL".equals(r10) == false) goto L60;
        String r15 = (String) r5.get("bookingType");
        if ("BOOKING_FIRST".equals(r15) == false) goto L53;
        String r116 = (String) r5.get("bookPerson");
        String r226 = (String) r5.get("dateStart");
        String r227 = (String) r5.get("dateEnd");
        String r228 = (String) r5.get("hotel");
        String r229 = (String) r5.get("roomType");
        if (i.f19880a == false) goto L50;
        r18 = (String) r5.get("orderNumber");
    L50:
        r12.a("LocalHotelBookingTool", "extractHotelSuccessInfo", new Object[]{r116, r226, r227, r228, r229, r18});
        return;
    L53:
        if ("BOOKING_MODIFY".equals(r15) == false) goto L57;
        r12.a("LocalHotelBookingTool", "extractHotelModifyInfo", new Object[]{(String) r5.get("bookPerson"), (String) r5.get("dateStartOld"), (String) r5.get("dateEndOld"), (String) r5.get("hotelOld"), (String) r5.get("roomTypeOld"), (String) r5.get("dateStartNew"), (String) r5.get("dateEndNew"), (String) r5.get("hotelNew"), (String) r5.get("roomTypeNew")});
        return;
    L57:
        if ("BOOKING_CANCEL".equals(r15) == false) goto L66;
        r12.a("LocalHotelBookingTool", "extractHotelCancelInfo", new Object[]{(String) r5.get("bookPerson"), (String) r5.get("dateStart"), (String) r5.get("dateEnd"), (String) r5.get("hotel"), (String) r5.get("roomType")});
        return;
    L66:
        return;
    L60:
        "BOOKING_MIGU_VIDEO".equals(r10);
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        r5 = null;
        goto L6
    }
}
