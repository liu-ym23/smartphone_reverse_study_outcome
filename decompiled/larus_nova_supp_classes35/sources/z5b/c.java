package z5b;

import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements e {
    public c() {
    }

    public final String getTAG() {
        return e.a.a(this);
    }

    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.ON_TIME_DELETE_MESSAGE;
    }

    public static boolean e(yya.a r0, int r1) {
        Message r2 = r0.g();
        if (r2 == null) goto L6;
        Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r3 = r2.getDisabledAction();
        if (r3 == null) goto L6;
    L7:
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior r4 = r3.get(Integer.valueOf(r1));
        if (r4 == null) goto L10;
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode r5 = r4.display_mode;
    L12:
        if (r5 != com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode.INVISIBLE) goto L14;
        return true;
    L14:
        return false;
    L10:
        r5 = null;
    L6:
        r3 = MapsKt.emptyMap();
        goto L7
    }

    public final boolean a(MessageActionType r3, yya.a r4) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "actionContext");
        if (r3 != MessageActionType.ADD_TASK) goto L8;
        if (e(r4, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.ADD_TASK.getValue()) == false) goto L8;
        return true;
    L8:
        if (r3 != MessageActionType.SHORTCUTS) goto L13;
        if (e(r4, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.Widgets.getValue()) == false) goto L13;
        return true;
    L13:
        if (r3 != MessageActionType.COPY_MESSAGE_LINK) goto L18;
        if (e(r4, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.COPY_MESSAGE_LINK.getValue()) == false) goto L18;
        return true;
    L18:
        if (r3 == MessageActionType.EXPORT_MESSAGE_TO_DOC) goto L20;
        return false;
    L20:
        if (e(r4, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.DERIVE.getValue()) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public final boolean b(MessageActionType r1, yya.a r2) {
        e.a.c(r1, r2);
        return false;
    }

    public final boolean c(MessageActionType r1, yya.a r2, boolean r3) {
        e.a.b(r1, r2);
        return false;
    }
}
