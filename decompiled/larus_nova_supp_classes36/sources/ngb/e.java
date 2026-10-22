package ngb;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.bytedance.lark.pb.basic.v1.VideoChatContent;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeVideoChatContent;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements gya.a<LarkDowngradeVideoChatContent> {
    public e() {
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final MessageType a() {
        return MessageType.VIDEO_CHAT;
    }

    public static LarkDowngradeVideoChatContent j(Message r6, Content r7) {
        Intrinsics.checkNotNullParameter(r6, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r7, "pbContent");
        VideoChatContent r8 = r7.videochat_content;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.lark.pb.basic.v1.VideoChatContent");
        VideoChatContent.MeetingCard r9 = r8.meeting_card;
        if (r9 == null) goto L6;
        String r0 = r9.topic;
        if (r0 == null) goto L6;
    L7:
        if (r9 == null) goto L10;
        VideoChatContent.MeetingCard.Status r10 = r9.status;
        if (r10 == null) goto L10;
    L11:
        LarkDowngradeVideoChatContent r1 = new LarkDowngradeVideoChatContent();
        r1.setTitle(r0);
        r1.setStatus(r10);
        VideoChatContent.MeetingCard r11 = r8.meeting_card;
        long r2 = 0;
        if (r11 == null) goto L16;
        Long r12 = r11.start_time_ms;
        if (r12 == null) goto L16;
        long r4 = r12.longValue();
    L17:
        r1.setStartTimeMs(r4);
        VideoChatContent.MeetingCard r13 = r8.meeting_card;
        if (r13 == null) goto L22;
        Long r14 = r13.end_time_ms;
        if (r14 == null) goto L22;
        r2 = r14.longValue();
    L22:
        r1.setEndTimeMs(r2);
        return r1;
    L16:
        r4 = 0;
    L10:
        r10 = VideoChatContent.MeetingCard.Status.UNKNOWN;
    L6:
        r0 = "";
        goto L7
    }

    public final String d(Context r2, com.ss.android.lark.chat.export.entity.message.Content r3) {
        LarkDowngradeVideoChatContent r4 = (LarkDowngradeVideoChatContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        return r4.getTitle();
    }

    public final String f(Context r2, com.ss.android.lark.chat.export.entity.message.Content r3) {
        LarkDowngradeVideoChatContent r4 = (LarkDowngradeVideoChatContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        return r4.getTitle();
    }

    public final String h(Context r1, f5b.b r2) {
        gya.a.a.a(r1, r2);
        return null;
    }

    public final /* bridge */ /* synthetic */ com.ss.android.lark.chat.export.entity.message.Content g(Entity r1, Message r2, Content r3) {
        return j(r2, r3);
    }

    public final com.ss.android.lark.chat.export.entity.message.Content e(Entity r1, Message r2, Content r3, TranslateInfo r4) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, "pbContent");
        return j(r2, r3);
    }

    public final void i(Content r1, BaseTextContent<?> r2, String r3, Entity r4) {
        gya.a.a.b(r1, r2, r3);
    }
}
