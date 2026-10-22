package ngb;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.ShareCalendarEventContent;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.bytedance.lark.pb.calendar.v1.CalendarEvent;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeCalendarContent;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements gya.a<LarkDowngradeCalendarContent> {
    public b() {
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final MessageType a() {
        return MessageType.SHARE_CALENDAR_EVENT;
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

    public final LarkDowngradeCalendarContent j(Message r3, com.bytedance.lark.pb.basic.v1.Content r4) {
        Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "pbContent");
        ShareCalendarEventContent r5 = r4.share_calendar_event_content;
        CalendarEvent.Status r6 = null;
        if (r5 == null) goto L5;
        CalendarEvent r7 = r5.calendar_event;
    L6:
        LarkDowngradeCalendarContent r0 = new LarkDowngradeCalendarContent();
        if (r7 == null) goto L10;
        String r1 = r7.summary;
        if (r1 == null) goto L10;
    L11:
        r0.setTitle(r1);
        if (r7 == null) goto L14;
        r6 = r7.status;
    L14:
        r0.setStatusEnum(r6);
        if (r7 == null) goto L19;
        Long r8 = r7.end_time;
        if (r8 == null) goto L19;
        long r9 = r8.longValue();
    L20:
        r0.setEndTime(r9);
        return r0;
    L19:
        r9 = -1;
    L10:
        r1 = "";
        goto L11
    L5:
        r7 = null;
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
