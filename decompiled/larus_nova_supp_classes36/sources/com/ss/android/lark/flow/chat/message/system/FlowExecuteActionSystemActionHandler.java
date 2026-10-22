package com.ss.android.lark.flow.chat.message.system;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.basic.v1.SendLarkCommandPayloadRequest;
import com.bytedance.lark.pb.basic.v1.SendLarkCommandPayloadResponse;
import com.bytedance.lark.pb.im.v1.GetMessageActionPayloadRequest;
import com.bytedance.lark.pb.im.v1.GetMessageActionPayloadResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageAction;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.system_content.SystemContentHitPoint;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowExecuteActionSystemActionHandler implements f {
    public static final /* synthetic */ int d = 0;
    public final Fragment a;
    public final CoroutineScope b;
    public final Lazy c;

    public interface a {
        @SdkCall(4101)
        RucketJob<GetMessageActionPayloadResponse> executeRequestAction(GetMessageActionPayloadRequest r1);

        @SdkCall(1279)
        RucketJob<SendLarkCommandPayloadResponse> executeRequestActionNew(SendLarkCommandPayloadRequest r1);
    }

    public static final class b {
    }

    static {
    }

    public FlowExecuteActionSystemActionHandler(Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        this.a = r4;
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.c = LazyKt.lazy(FlowExecuteActionSystemActionHandler$service$2.INSTANCE);
        r4.getLifecycle().addObserver(new AnonymousClass1(this));
    }

    public final void x(ContentValue r24, com.ss.android.lark.biz.im.api.extension.message.system.a r25) {
        Intrinsics.checkNotNullParameter(r25, "actionContext");
        SystemContent r4 = r25.content();
        if (r24 != null) goto L6;
        Log.w("System_ActionHandler", "click action, type=" + r4.getType() + ", contentValue is null, method return");
        return;
    L6:
        boolean r5 = false;
        com.ss.android.lark.chat.export.entity.message.content.c r7 = null;
        if (r4.getVersion() != 0) goto L35;
        SystemMessageAction r3 = r24.getAction();
        if (r3 == null) goto L11;
        SystemMessageAction.ActType r9 = r3.getActType();
    L13:
        if (r3 == null) goto L27;
        if (r9 == null) goto L27;
        SystemMessageAction.ActType r6 = SystemMessageAction.ActType.INVITE_AT_CHATTERS;
        if (r9 != r6) goto L19;
    L21:
        if (r9 != r6) goto L23;
        ((o5c.b) SystemContentHitPoint.a.getValue()).sendEvent("mobile_at_group_invite_click", null);
    L26:
        BuildersKt.launch$default(this.b, null, null, new FlowExecuteActionSystemActionHandler$onActionClick$1(r25, r9, this, r4, null), 3, null);
        return;
    L23:
        Lazy r0 = SystemContentHitPoint.a;
        SystemMessageType r1 = r4.getType();
        Intrinsics.checkNotNullParameter(r1, "systemMessageType");
        if (r1 != SystemMessageType.USER_JOIN_CHAT_AUTO_MUTE) goto L26;
        ((o5c.b) SystemContentHitPoint.a.getValue()).sendEvent("big_group_muted_open_settings", null);
        goto L26
    L19:
        if (r9 == SystemMessageAction.ActType.URL) goto L21;
        Log.i("System_ActionHandler", "click action, type=" + r4.getType() + ", actionType=" + r9 + ", method return");
        return;
    L27:
        StringBuilder r2 = new StringBuilder("click action, type=");
        r2.append(r4.getType());
        r2.append(", action==null:");
        if (r3 != null) goto L30;
        boolean r8 = true;
    L31:
        r2.append(r8);
        r2.append(", actionType==null:");
        if (r9 != null) goto L34;
        r5 = true;
    L34:
        r2.append(r5);
        r2.append(", method return");
        Log.i("System_ActionHandler", r2.toString());
        return;
    L30:
        r8 = false;
        goto L31
    L11:
        r9 = null;
        goto L13
    L35:
        com.ss.android.lark.chat.export.entity.message.content.d r10 = (com.ss.android.lark.chat.export.entity.message.content.e) r4.getItemActions().get(Integer.valueOf(r24.getActionId()));
        if (r10 != null) goto L38;
        Log.e("System_ActionHandler", "click new action, type=" + r4.getType() + ", action is null, method return");
        return;
    L38:
        int r11 = r10.getType();
        if (r11 == 0) goto L58;
        if (r11 == 1) goto L51;
        if (r11 == 2) goto L45;
        Log.w("System_ActionHandler", "click new action, type=" + r4.getType() + ", unHandle action type: " + r10.getType());
        return;
    L45:
        if ((r10 instanceof com.ss.android.lark.chat.export.entity.message.content.c) == false) goto L47;
        r7 = (com.ss.android.lark.chat.export.entity.message.content.c) r10;
    L47:
        if (r7 == null) goto L77;
        FragmentActivity r12 = r25.context();
        Intrinsics.checkNotNullParameter(r25, "<this>");
        c(r12, r25.message().getChatId(), r7.c);
        return;
    L77:
        return;
    L51:
        if ((r10 instanceof com.ss.android.lark.chat.export.entity.message.content.d) == false) goto L53;
        com.ss.android.lark.chat.export.entity.message.content.d r13 = r10;
    L54:
        if (r13 == null) goto L78;
        BuildersKt.launch$default(this.b, null, null, new FlowExecuteActionSystemActionHandler$onActionClickNew$1(r13, this, r25, null), 3, null);
        return;
    L78:
        return;
    L53:
        r13 = null;
        goto L54
    L58:
        if ((r10 instanceof com.ss.android.lark.chat.export.entity.message.content.a) == false) goto L60;
        com.ss.android.lark.chat.export.entity.message.content.a r14 = (com.ss.android.lark.chat.export.entity.message.content.a) r10;
    L61:
        if (r14 == null) goto L79;
        String r15 = r14.c;
        if (r15.length() != 0) goto L66;
        r5 = true;
    L66:
        if (r5 == false) goto L68;
        r15 = r14.d;
    L68:
        ChameleonConfig r16 = new ChameleonConfig.Builder().bizName(ChameleonBizType.BIZ_CHAT.getType()).loadUrl(r15).openConfig(new OpenConfig(null, false, false, false, false, 0, false, false, false, null, null, 2047, null)).build();
        Chameleon r17 = Chameleon.a;
        Chameleon.b(r25.context(), r16, null);
        return;
    L79:
        return;
    L60:
        r14 = null;
        goto L61
    }

    public final void c(FragmentActivity r11, String r12, List r13) {
        List r0 = r13;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        Log.i("System_ActionHandler", "click action: invite mentioned chatters, chatters is empty, method return");
        return;
    L12:
        BuildersKt.launch$default(this.b, null, null, new FlowExecuteActionSystemActionHandler$inviteMentionedChatters$1(r11, this, r12, r13, null), 3, null);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
