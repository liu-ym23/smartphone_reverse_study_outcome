package com.obric.assistant.impl;

import android.content.Context;
import com.larus.bmhome.instruction.g;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.special_input.IObricSpecialInputService;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.util.r2;
import com.obric.assistant.utils.ObricShowArgServiceDelegate;
import com.obric.assistant.utils.l;
import com.obric.assistant.view.ObricSpecialInputWidget;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.b1;
import laa.j;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/impl/ObricSpecialInputServiceImpl;", "Lcom/obric/assistant/special_input/IObricSpecialInputService;", "<init>", "()V", "getObricVariantInputWidget", "Lcom/obric/assistant/view/ObricSpecialInputWidget;", "context", "Landroid/content/Context;", "getBuryPointState", "", "mapActionBarKey", "origin", "getComplexClarifyMessageExtra", "", "relatedTask", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "replayCallForMe", "", "closeSpecialInputBeforeMicOn", "isAssistantRequestFromAIKey", "", "isFeatureEnable", "featureKey", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSpecialInputServiceImpl implements IObricSpecialInputService {

    public static final class a {
    }

    static {
    }

    public ObricSpecialInputServiceImpl() {
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final String f() {
        return "";
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final void a() {
        ObricTaskStatusManager.a.getClass();
        Map r0 = MapsKt.toMutableMap(g(ObricTaskStatusManager.c()));
        r0.put("o_complex_call_for_me_directly", "1");
        String r1 = (String) r0.get("o_reference_msg_id");
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r3 = (String) r0.get("o_complex_clarify_content");
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        FLogger r4 = FLogger.a;
        r4.i("ObricSpecialInputServiceImpl", "replayCallForMe: messageId = " + r1 + ", clarifyContent.length = " + r2.length());
        boolean r6 = true;
        if (r1.length() != 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
    L22:
        r4.w("ObricSpecialInputServiceImpl", "replayCallForMe: messageId or clarifyContent is empty");
        return;
    L15:
        if (r2.length() == 0) goto L18;
        r6 = false;
    L18:
        if (r6 == true) goto L22;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricSpecialInputServiceImpl$replayCallForMe$1(r1, r2, r0, null), 3, null);
        return;
    L12:
        r5 = false;
        goto L13
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final boolean c() {
        Intrinsics.checkNotNullParameter("obric_feature_check_device_locked", "featureKey");
        return b.a().c("obric_feature_check_device_locked");
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final boolean isAssistantRequestFromAIKey() {
        return ObricShowArgServiceDelegate.b.isAssistantRequestFromAIKey();
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final void d() {
        t1a.b r0 = r2.a();
        Boolean r1 = null;
        if (r0 == null) goto L5;
        g r7 = (g) r0.getAbility(g.class);
    L6:
        if (r0 == null) goto L8;
        j r6 = (j) r0.getAbility(j.class);
    L9:
        if (r7 == null) goto L11;
        Boolean r4 = Boolean.valueOf(r7.z0());
    L12:
        if (r6 == null) goto L16;
        b1 r2 = r6.O4();
        if (r2 == null) goto L16;
        r1 = (Boolean) r2.getValue();
    L16:
        Boolean r5 = r1;
        FLogger.a.i("ObricSpecialInputServiceImpl", "instructionOpen = " + r4 + ", isObricSpecialInputOpen = " + r5);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1(r4, r5, r6, r7, null), 3, null);
        return;
    L11:
        r4 = null;
        goto L12
    L8:
        r6 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final Object b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ObricSpecialInputWidget(r2);
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final String e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        if (Intrinsics.areEqual(r2, "obric_phone_operation") == false) goto L6;
        return "obric_omni";
    L6:
        return r2;
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final Map<String, String> g(DMTaskState r6) {
        if (r6 == null) goto L4;
        Map r0 = r6.getExtra();
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("o_task_type", "complex_task");
        r1.put("o_task_state", "clarify_complex_task");
        r1.put("o_omni_intention", "task_reply");
        r1.put("o_omni_task_id", l.d(r6));
        if (r6 == null) goto L14;
        DMTaskInfo r7 = r6.getTaskInfo();
        if (r7 == null) goto L14;
        IMMessage r8 = r7.getMessage();
        if (r8 == null) goto L14;
        String r9 = r8.getMessageId();
        if (r9 == null) goto L14;
        r1.put("o_reference_msg_id", r9);
    L15:
        if (r0 == null) goto L19;
        String r10 = (String) r0.get("clarify_message_content");
        if (r10 == null) goto L19;
        r1.put("o_complex_clarify_content", r10);
    L19:
        return r1;
    L14:
        FLogger.a.e("ObricSpecialInputServiceImpl", "messageId is null");
        r1.put("o_reference_msg_id", "");
        goto L15
    L4:
        r0 = null;
        goto L5
    }
}
