package com.ss.android.lark.chat.dlp;

import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageRestrictedActionInterceptor implements e {
    public final Lazy a;
    public final Map<MessageActionType, a> b;

    public MessageRestrictedActionInterceptor() {
        this.a = LazyKt.lazy(MessageRestrictedActionInterceptor$checkMessageActionTypes$2.INSTANCE);
        this.b = new LinkedHashMap();
    }

    public final String getTAG() {
        return e.a.a(this);
    }

    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.RESTRICTED_MESSAGE;
    }

    public final boolean a(MessageActionType r3, yya.a r4) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "actionContext");
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "actionContext");
        return false;
    }

    public final boolean b(MessageActionType r7, yya.a r8) {
        Intrinsics.checkNotNullParameter(r7, "actionType");
        Intrinsics.checkNotNullParameter(r8, "actionContext");
        if (((Map) this.a.getValue()).keySet().contains(r7) == true) goto L5;
        return false;
    L5:
        Message r0 = r8.g();
        if (r0 == null) goto L9;
        Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r1 = r0.getDisabledAction();
        if (r1 == null) goto L9;
    L10:
        Pair r2 = (Pair) ((Map) this.a.getValue()).get(r7);
        if (r2 != null) goto L13;
        r2 = TuplesKt.to(Integer.valueOf(com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.ACTION_UNSPECIFIED.getValue()), 0);
    L13:
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior r3 = r1.get(r2.getFirst());
        if (r3 == null) goto L17;
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode r4 = r3.display_mode;
        if (r4 == null) goto L17;
    L18:
        if (r3 == null) goto L22;
        Integer r5 = r3.code;
        if (r5 == null) goto L22;
        int r6 = r5.intValue();
    L24:
        if (r4 != com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode.DISABLE) goto L26;
    L46:
        Map<MessageActionType, a> r9 = this.b;
        if (r6 == 311150) goto L49;
    L51:
        a r10 = new a(BehaviorOnClickDisableAction.UNKNOWN);
    L52:
        r9.put(r7, r10);
        return true;
    L49:
        if (((Number) r2.getSecond()).intValue() == 0) goto L51;
        r10 = new d(((Number) r2.getSecond()).intValue());
        goto L52
    L26:
        if ((r8 instanceof y2b.a) == false) goto L28;
        y2b.a r11 = (y2b.a) r8;
    L30:
        if (r8.r() != PageType.MERGE_FORWARD) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L41;
        if (r11 != null) goto L36;
    L38:
        boolean r13 = false;
    L39:
        if (r13 == false) goto L41;
        boolean r14 = true;
    L42:
        if (r14 == true) goto L46;
        this.b.remove(r7);
        return false;
    L36:
        if (r11.a() != true) goto L38;
        r13 = true;
    L41:
        r14 = false;
        goto L42
    L32:
        r12 = false;
        goto L33
    L28:
        r11 = null;
    L22:
        r6 = -1;
    L17:
        r4 = com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode.MODE_UNSPECIFIED;
    L9:
        r1 = MapsKt.emptyMap();
        goto L10
    }

    public final boolean c(MessageActionType r2, yya.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        if (r4 == false) goto L5;
        return false;
    L5:
        a r5 = (a) ((LinkedHashMap) this.b).get(r2);
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.getType() == BehaviorOnClickDisableAction.SHOW_TOAST) goto L11;
        return true;
    L11:
        if ((r5 instanceof d) == false) goto L16;
        UDToast.show(r3.getContext(), ((d) r5).b);
        return true;
    L16:
        return true;
    }
}
