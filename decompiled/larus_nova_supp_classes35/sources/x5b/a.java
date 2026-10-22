package x5b;

import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements e {
    public final Map<MessageActionType, Message.DisabledAction.Action> a;
    public final Map<MessageActionType, Message.DisabledAction.Behavior.DisplayMode> b;

    public a() {
        Message.DisabledAction.Action r0 = Message.DisabledAction.Action.ACTION_UNSPECIFIED;
        MessageActionType r1 = MessageActionType.REPLY;
        Message.DisabledAction.Action r2 = Message.DisabledAction.Action.REPLY;
        MessageActionType r3 = MessageActionType.FORWARD;
        Message.DisabledAction.Action r4 = Message.DisabledAction.Action.TRANSMIT;
        MessageActionType r5 = MessageActionType.COPY;
        Message.DisabledAction.Action r6 = Message.DisabledAction.Action.COPY;
        MessageActionType r7 = MessageActionType.ADD_STICKER;
        Message.DisabledAction.Action r8 = Message.DisabledAction.Action.ADD_STICKER;
        MessageActionType r9 = MessageActionType.TRANSLATE;
        Message.DisabledAction.Action r10 = Message.DisabledAction.Action.TRANSLATE;
        this.a = MapsKt.mapOf(new Pair[]{TuplesKt.to(MessageActionType.ADD_REACTION, Message.DisabledAction.Action.REACTION), TuplesKt.to(MessageActionType.DING, Message.DisabledAction.Action.SEND_URGENT), TuplesKt.to(MessageActionType.RECALL, Message.DisabledAction.Action.RECALL), TuplesKt.to(MessageActionType.REEDIT, Message.DisabledAction.Action.EDIT_MESSAGE), TuplesKt.to(r1, r2), TuplesKt.to(MessageActionType.ZONE_REPLY, r2), TuplesKt.to(r3, r4), TuplesKt.to(MessageActionType.FORWARD_REPLY_IN_THREAD, r4), TuplesKt.to(MessageActionType.REPLY_IN_THREAD, Message.DisabledAction.Action.REPLY_IN_THREAD), TuplesKt.to(MessageActionType.MULTI_SELECT, Message.DisabledAction.Action.MULTI_SELECT), TuplesKt.to(r5, r6), TuplesKt.to(MessageActionType.ZONE_COPY, r6), TuplesKt.to(MessageActionType.ADD_FLAG, Message.DisabledAction.Action.FLAG), TuplesKt.to(MessageActionType.ADD_TO_FAVORITE, Message.DisabledAction.Action.FAVORITE), TuplesKt.to(MessageActionType.PIN, Message.DisabledAction.Action.PIN), TuplesKt.to(MessageActionType.PIN_TO_TOP, Message.DisabledAction.Action.CLIP_TO_TOP), TuplesKt.to(MessageActionType.COPY_MESSAGE_LINK, Message.DisabledAction.Action.COPY_MESSAGE_LINK), TuplesKt.to(r7, r8), TuplesKt.to(MessageActionType.IMAGE_TO_STICKER, r8), TuplesKt.to(MessageActionType.ADD_TASK, Message.DisabledAction.Action.ADD_TASK), TuplesKt.to(r9, r10), TuplesKt.to(MessageActionType.DELETE, Message.DisabledAction.Action.DELETE), TuplesKt.to(MessageActionType.SHORTCUTS, Message.DisabledAction.Action.Widgets), TuplesKt.to(MessageActionType.EXPORT_MESSAGE_TO_DOC, Message.DisabledAction.Action.DERIVE), TuplesKt.to(MessageActionType.HYPER_TRANSLATE, r10), TuplesKt.to(MessageActionType.ZONE_HYPER_TRANSLATE, r10)});
        this.b = new LinkedHashMap();
    }

    public final String getTAG() {
        return e.a.a(this);
    }

    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.DISABLE_ACTION;
    }

    public final boolean a(MessageActionType r2, yya.a r3) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        Message.DisabledAction.Action r4 = this.a.get(r2);
        if (r4 != null) goto L5;
        return false;
    L5:
        com.ss.android.lark.chat.entity.message.Message r5 = r3.g();
        if (r5 == null) goto L17;
        Map<Integer, Message.DisabledAction.Behavior> r6 = r5.getDisabledAction();
        if (r6 == null) goto L19;
        Message.DisabledAction.Behavior r7 = r6.get(Integer.valueOf(r4.getValue()));
        if (r7 != null) goto L14;
        return false;
    L14:
        if (r7.display_mode != Message.DisabledAction.Behavior.DisplayMode.INVISIBLE) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    L17:
        return false;
    }

    public final boolean b(MessageActionType r4, yya.a r5) {
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter(r5, "actionContext");
        this.b.remove(r4);
        Message.DisabledAction.Action r0 = this.a.get(r4);
        if (r0 != null) goto L5;
        return false;
    L5:
        com.ss.android.lark.chat.entity.message.Message r6 = r5.g();
        if (r6 == null) goto L17;
        Map<Integer, Message.DisabledAction.Behavior> r7 = r6.getDisabledAction();
        if (r7 == null) goto L19;
        Message.DisabledAction.Behavior r8 = r7.get(Integer.valueOf(r0.getValue()));
        if (r8 != null) goto L13;
        return false;
    L13:
        this.b.put(r4, r8.display_mode);
        if (r8.display_mode != Message.DisabledAction.Behavior.DisplayMode.DISABLE) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    L17:
        return false;
    }

    public final boolean c(MessageActionType r2, yya.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        if (r4 == false) goto L6;
        return false;
    L6:
        if (((LinkedHashMap) this.b).get(r2) != Message.DisabledAction.Behavior.DisplayMode.DISABLE) goto L9;
        UDToast.show(r3.getContext(), 2131891408);
        return true;
    L9:
        return false;
    }
}
