package ngb;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.EventCardTemplate;
import com.bytedance.lark.pb.basic.v1.GeneralCalendarContent;
import com.bytedance.lark.pb.basic.v1.RSVPCardInfo;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.bytedance.lark.pb.calendar.v1.AppointmentMessageNotify;
import com.bytedance.lark.pb.calendar.v1.AppointmentMessageRoundRobin;
import com.bytedance.lark.pb.calendar.v1.CalendarEvent;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeCalendarContent;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements gya.a<LarkDowngradeCalendarContent> {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RSVPCardInfo.EventRSVPCardStatus.values().length];
            r0[RSVPCardInfo.EventRSVPCardStatus.INVALID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public c() {
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final MessageType a() {
        return MessageType.GENERAL_CALENDAR;
    }

    public final String d(Context r2, Content r3) {
        LarkDowngradeCalendarContent r4 = (LarkDowngradeCalendarContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        return r4.getTitle();
    }

    public final String f(Context r2, Content r3) {
        LarkDowngradeCalendarContent r4 = (LarkDowngradeCalendarContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        return r4.getTitle();
    }

    public final String h(Context r1, f5b.b r2) {
        gya.a.a.a(r1, r2);
        return null;
    }

    public final LarkDowngradeCalendarContent j(Message r4, com.bytedance.lark.pb.basic.v1.Content r5) {
        Intrinsics.checkNotNullParameter(r4, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r5, "pbContent");
        GeneralCalendarContent r6 = r5.general_calendar_content;
        RSVPCardInfo.EventRSVPCardStatus r7 = null;
        if (r6 == null) goto L5;
        RSVPCardInfo r0 = r6.rsvp_card_info;
    L6:
        LarkDowngradeCalendarContent r1 = new LarkDowngradeCalendarContent();
        if (r0 == null) goto L12;
        EventCardTemplate r2 = r0.basic_event_info;
        if (r2 == null) goto L12;
        String r3 = r2.summary;
        if (r3 == null) goto L12;
    L31:
        r1.setTitle(r3);
        if (r0 == null) goto L34;
        r7 = r0.card_status;
    L34:
        if (r7 != null) goto L36;
        int r8 = -1;
    L38:
        if (r8 != 1) goto L40;
        CalendarEvent.Status r9 = CalendarEvent.Status.CANCELED;
    L41:
        r1.setStatusEnum(r9);
        if (r0 == null) goto L48;
        EventCardTemplate r10 = r0.basic_event_info;
        if (r10 == null) goto L48;
        Long r11 = r10.end_time;
        if (r11 == null) goto L48;
        long r12 = r11.longValue();
    L49:
        r1.setEndTime(r12);
        return r1;
    L48:
        r12 = -1;
        goto L49
    L40:
        r9 = CalendarEvent.Status.TENTATIVE;
        goto L41
    L36:
        r8 = a.a[r7.ordinal()];
    L12:
        if (r6 == null) goto L16;
        EventCardTemplate r13 = r6.event_card;
        if (r13 == null) goto L16;
        r3 = r13.summary;
    L17:
        if (r3 != null) goto L31;
        if (r6 == null) goto L22;
        AppointmentMessageNotify r14 = r6.appointment_message_notify_data;
        if (r14 == null) goto L22;
        r3 = r14.scheduler_name;
    L23:
        if (r3 != null) goto L31;
        if (r6 == null) goto L28;
        AppointmentMessageRoundRobin r15 = r6.appointment_message_round_robin_data;
        if (r15 == null) goto L28;
        r3 = r15.scheduler_name;
    L29:
        if (r3 != null) goto L31;
        r3 = "";
    L28:
        r3 = null;
    L22:
        r3 = null;
    L16:
        r3 = null;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ Content g(Entity r1, Message r2, com.bytedance.lark.pb.basic.v1.Content r3) {
        return j(r2, r3);
    }

    public final Content e(Entity r1, Message r2, com.bytedance.lark.pb.basic.v1.Content r3, TranslateInfo r4) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, "pbContent");
        return j(r2, r3);
    }

    public final void i(com.bytedance.lark.pb.basic.v1.Content r1, BaseTextContent<?> r2, String r3, Entity r4) {
        gya.a.a.b(r1, r2, r3);
    }
}
