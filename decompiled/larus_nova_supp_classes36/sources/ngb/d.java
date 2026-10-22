package ngb;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.TodoDailyRemind;
import com.bytedance.lark.pb.basic.v1.TodoDetail;
import com.bytedance.lark.pb.basic.v1.TodoOperationContent;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeTodoContent;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements gya.a<LarkDowngradeTodoContent> {
    public d() {
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final MessageType a() {
        return MessageType.TODO;
    }

    public static LarkDowngradeTodoContent j(Message r9, Content r10) {
        Intrinsics.checkNotNullParameter(r9, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r10, "pbContent");
        TodoOperationContent r11 = r10.todo_operation_content;
        List r12 = null;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.operation_type != TodoOperationContent.Type.UNKNOWN) goto L8;
        return null;
    L8:
        TodoDetail r0 = r11.todo_detail;
        if (r0 != null) goto L16;
        TodoDailyRemind r1 = r11.daily_remind;
        if (r1 == null) goto L15;
        List r2 = r1.todos;
        if (r2 == null) goto L15;
        r0 = (TodoDetail) CollectionsKt.firstOrNull(r2);
    L15:
        r0 = null;
    L16:
        LarkDowngradeTodoContent r3 = new LarkDowngradeTodoContent();
        r3.setOperationType(r11.operation_type);
        if (r0 == null) goto L19;
        String r13 = r0.summary;
    L20:
        String r4 = "";
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        r3.setTitle(r13);
        long r5 = 0;
        if (r0 == null) goto L28;
        Long r14 = r0.completed_milli_time;
        if (r14 == null) goto L28;
        long r6 = r14.longValue();
    L29:
        boolean r7 = false;
        if (r6 <= 0) goto L32;
        boolean r8 = true;
    L33:
        r3.setCompleted(r8);
        if (r0 == null) goto L61;
        List r15 = r0.assignees;
        if (r15 == null) goto L61;
        Iterator r16 = r15.iterator();
    L39:
        if (r16.hasNext() == false) goto L53;
        Object r17 = r16.next();
        TodoUser r18 = ((TodoAssignee) r17).user.user;
        if (r18 == null) goto L43;
        String r19 = r18.name;
    L44:
        if (r19 != null) goto L46;
    L49:
        boolean r20 = true;
    L51:
        if ((!r20) == false) goto L39;
    L54:
        TodoAssignee r21 = (TodoAssignee) r17;
        if (r21 == null) goto L61;
        TodoAssignee.User r22 = r21.user;
        if (r22 == null) goto L61;
        TodoUser r23 = r22.user;
        if (r23 == null) goto L61;
        String r24 = r23.name;
    L62:
        if (r24 == null) goto L65;
        r4 = r24;
    L65:
        r3.setAssigneeName(r4);
        if (r0 == null) goto L70;
        Long r25 = r0.due_time;
        if (r25 == null) goto L70;
        r5 = r25.longValue();
    L70:
        r3.setDueTimeSeconds(r5);
        if (r0 == null) goto L75;
        Boolean r26 = r0.is_all_day;
        if (r26 == null) goto L75;
        boolean r27 = r26.booleanValue();
    L76:
        r3.setAllDay(r27);
        if (r0 == null) goto L79;
        r12 = r0.reminders;
    L79:
        List r110 = r12;
        if (r110 != null) goto L82;
    L85:
        boolean r111 = true;
    L86:
        r3.setHasReminder(true ^ r111);
        if (r0 == null) goto L91;
        Boolean r28 = r0.can_follow;
        if (r28 == null) goto L91;
        r7 = r28.booleanValue();
    L91:
        r3.setCanFollow(r7);
        return r3;
    L82:
        if (r110.isEmpty() == true) goto L85;
        r111 = false;
    L75:
        r27 = false;
        goto L76
    L46:
        if (StringsKt.isBlank(r19) == true) goto L49;
        r20 = false;
        goto L51
    L43:
        r19 = null;
        goto L44
    L53:
        r17 = null;
    L61:
        r24 = null;
        goto L62
    L32:
        r8 = false;
    L28:
        r6 = 0;
        goto L29
    L19:
        r13 = null;
        goto L20
    }

    public final String d(Context r2, com.ss.android.lark.chat.export.entity.message.Content r3) {
        LarkDowngradeTodoContent r4 = (LarkDowngradeTodoContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        return r4.getTitle();
    }

    public final String f(Context r2, com.ss.android.lark.chat.export.entity.message.Content r3) {
        LarkDowngradeTodoContent r4 = (LarkDowngradeTodoContent) r3;
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
