package com.larus.bmhome.taskskill;

import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.im.bean.message.AgentTaskParam;
import com.larus.im.bean.message.GeneralTaskParam;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001f\u0010\r\u001a\u0004\u0018\u00010\u000e*\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0012\u001a\u00020\bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/taskskill/PcLocalDispatcherMessageExtService;", "Lcom/larus/bmhome/chat/api/IMessageExtService;", "<init>", "()V", "setSendMessageExt", "", "map", "", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "explicitRuntimeType", "", "", "(Ljava/util/Map;)Ljava/lang/Integer;", "appendTargetAppId", "targetDeviceId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcLocalDispatcherMessageExtService implements IMessageExtService {

    public static final class a {
    }

    static {
    }

    public PcLocalDispatcherMessageExtService() {
    }

    public final String service() {
        return "";
    }

    public final void b(Map r1, IMessageExtService.a r2) {
        Intrinsics.checkNotNullParameter(r1, "map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Map<String, String> r13, wc9.e r14, IMessageExtService.a r15) {
        Intrinsics.checkNotNullParameter(r13, "map");
        Object r7 = null;
        if (r13.containsKey("task_skill_local_temp_agent_task_param_change") == true) goto L94;
        boolean r9 = false;
        if (Intrinsics.areEqual(r13.get("send_command"), "1") == false) goto L43;
        String r16 = (String) r13.get("target_device_id");
        if (r16 != null) goto L37;
    L39:
        boolean r17 = false;
    L40:
        if (r17 == false) goto L43;
        return;
    L37:
        if ((!StringsKt.isBlank(r16)) != true) goto L39;
        r17 = true;
    L43:
        if (l2.c() == true) goto L45;
        return;
    L45:
        bs8.a.C0004a r18 = bs8.a.h;
        if (r14 == null) goto L48;
        String r19 = r14.r;
    L49:
        r18.getClass();
        bs8.a r110 = bs8.a.C0004a.a(r19);
        if (r110 != null) goto L52;
        return;
    L52:
        if (r110.c() == true) goto L55;
        r110 = null;
    L55:
        if (r110 == null) goto L98;
        String r111 = l2.d(r110, null);
        if (r111 != null) goto L59;
        return;
    L59:
        if ((!StringsKt.isBlank(r111)) == true) goto L62;
        r111 = null;
    L62:
        if (r111 == null) goto L100;
        r13.putIfAbsent("task_skill_local_temp_runtime_type", "2");
        r13.putIfAbsent("send_command", "1");
        r13.putIfAbsent("target_device_id", r111);
        String r112 = (String) r13.get("target_device_id");
        if (r112 != null) goto L66;
    L74:
        String r113 = r110.d;
        if (r113 != null) goto L77;
    L82:
        String r114 = o.a.getDeviceId();
        if ((!StringsKt.isBlank(r114)) == false) goto L85;
        r7 = r114;
    L85:
        if (r7 == null) goto L87;
        String r115 = (String) r13.putIfAbsent("dispatch_controller_mobile_did", r7);
    L87:
        r13.putIfAbsent("dispatch_controller_mobile_platform", "android");
        FLogger r116 = FLogger.a;
        StringBuilder r117 = new StringBuilder("[setSendMessageExt] append pc-local dispatcher params, hasWorkspace=");
        String r118 = r110.d;
        if (r118 != null) goto L90;
    L91:
        r9 = true;
    L92:
        r117.append(!r9);
        r116.i("PcLocalDispatcherExt", r117.toString());
        return;
    L90:
        if (StringsKt.isBlank(r118) == false) goto L92;
    L77:
        if ((!StringsKt.isBlank(r113)) == true) goto L80;
        r113 = null;
    L80:
        if (r113 == null) goto L82;
        String r119 = (String) r13.putIfAbsent("task_workspace", r113);
        goto L82
    L66:
        if ((!StringsKt.isBlank(r112)) == true) goto L69;
        r112 = null;
    L69:
        if (r112 == null) goto L74;
        GetAllDevicesRepo r0 = GetAllDevicesRepo.a;
        Integer r120 = GetAllDevicesRepo.c(r112);
        if (r120 == null) goto L73;
        r13.put("target_app_id", r120.toString());
        goto L74
    L73:
        r13.remove("target_app_id");
        goto L74
    L100:
        return;
    L98:
        return;
    L48:
        r19 = null;
        goto L49
    L94:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L19
        String r122 = (String) r13.get("task_skill_local_temp_agent_task_param_change");     // Catch: Throwable -> L19
        if (r122 != null) goto L7;
    L16:
        Integer r123 = null;
    L17:
        Object r124 = Result.constructor-impl(r123);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r124) == true) goto L25;
        r7 = r124;
    L25:
        Integer r8 = (Integer) r7;
        if (r8 != null) goto L29;
    L30:
        r13.remove("send_command");
        r13.remove("target_device_id");
        r13.remove("target_app_id");
        r13.remove("task_workspace");
        r13.remove("dispatch_controller_mobile_did");
        r13.remove("dispatch_controller_mobile_platform");
        return;
    L29:
        if (r8.intValue() != 2) goto L30;
        return;
    L7:
        if ((!StringsKt.isBlank(r122)) == true) goto L10;
        r122 = null;
    L10:
        if (r122 == null) goto L16;
        zd9.h.a.getClass();     // Catch: Throwable -> L19
        GeneralTaskParam r125 = (GeneralTaskParam) zd9.h.a(r122, GeneralTaskParam.class);     // Catch: Throwable -> L19
        if (r125 == null) goto L16;
        AgentTaskParam r126 = r125.getAgentTaskParam();     // Catch: Throwable -> L19
        if (r126 == null) goto L16;
        r123 = r126.getRuntimeType();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r124 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
