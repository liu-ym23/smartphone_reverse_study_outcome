package tgb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatForsetiBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.chat.chatwindow.chat.perload.c;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chatwindow.launcher.ChatLauncherV2;
import com.ss.android.lark.chatwindow.launcher.starter.BaseStarter;
import com.ss.android.lark.chatwindow.launcher.starter.StartKey;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.bottomsheet.BottomSheetLauncher;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.page.ChatFragment;
import com.ss.android.lark.flow.chat.page.FlowChatActivity;
import com.ss.android.lark.flow.chat.page.FlowChatWindowSelectMessagesActivity;
import com.ss.android.lark.flow.forward.ForwardTools;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import javax.inject.Inject;
import jdb.g;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@StartKey(RealLaunchData.ChatDirection.FLOW_CHAT)
public final class a extends BaseStarter {
    public final g a;
    public final d b;

    @Inject
    public UserSession c;

    public final void b(com.ss.android.lark.chatwindow.launcher.transform.d r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        Intrinsics.checkNotNullParameter(r7, "data");
        ChatBundleV2 r0 = r7.a;
        String r1 = r0.i.a;
        RxScheduledExecutor.justInIO(new com.ss.android.lark.flow.forward.a(r1, ForwardTools.RecentVisitTargetType.CHAT));
        PerfLog.start("prepare_chat_window", "");
        c r2 = c.a.a;
        r2.b(new u3b.b(r0));
        r2.b(new u3b.c(r0.getChatId(), r0.o()));
        r2.b(new f6b.b(r1, new f6b.d(r7.b, r0)));
    }

    @Inject
    public a(g r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "fgService");
        Intrinsics.checkNotNullParameter(r3, "dataPreloader");
        this.a = r2;
        this.b = r3;
    }

    public final boolean c(ChatLauncherV2.b r10, com.ss.android.lark.chatwindow.launcher.transform.d r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "result");
        ChatBundleV2 r12 = r11.a;
        String r1 = r12.i.a;
        Log.i("ChatLauncherV2", "route open chat " + r1);
        boolean r5 = false;
        if (OfficeSDKManager.isAvailable() == true) goto L6;
        Log.i("ChatLauncherV2", "route open chat " + r1 + ", office sdk not ready");
        return false;
    L6:
        Context r2 = r10.getContext();
        Bundle r3 = r12.F();
        UserSession r4 = this.c;
        UserSession r6 = null;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("userSession");
        r4 = null;
    L10:
        Lazy r7 = BottomSheetLauncher.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r3.getBoolean("key_bottom_sheet_container_start") == false) goto L18;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.inapppush.reply") == false) goto L18;
        BottomSheetLauncher.a r0 = new BottomSheetLauncher.a(r2);
        Intrinsics.checkNotNullParameter(FlowChatActivity.class, "targetClazz");
        r0.c = FlowChatActivity.class.getName();
        r0.d = r4;
        r0.b = r3;
        r0.a();
        r5 = true;
    L18:
        if (r5 == false) goto L21;
        PerfLog.end("prepare_chat_window", "");
        ChatCoreModule.a().getPerfEnterChatMonitor().l(true);
        return true;
    L21:
        Bundle r8 = r12.getExtraParams();
        if (r8 == null) goto L24;
        Serializable r9 = r8.getSerializable("key_forseti_bundle");
    L26:
        if ((r9 instanceof ChatForsetiBundle) == false) goto L28;
        ChatForsetiBundle r13 = (ChatForsetiBundle) r9;
    L29:
        if (r13 == null) goto L32;
        r13.isOpenChatFullScreenStyle();
    L32:
        if (TextUtils.isEmpty(((BaseBundle) r12).b.m) == true) goto L34;
        Intent r14 = new Intent(r10.getContext(), FlowChatWindowSelectMessagesActivity.class);
    L35:
        int r15 = ((BaseBundle) r12).a.a;
        if (r15 == (-1)) goto L38;
        r14.setFlags(r15);
    L38:
        r14.putExtras(r12.F());
        r14.putExtra("multi_task_transition", ((BaseBundle) r12).a.b);
        UserSession r16 = this.c;
        if (r16 == null) goto L41;
        r6 = r16;
    L42:
        PassportcConvention.g(r14, r6);
        r14.putExtra("use_chat_container", true);
        int r17 = ((BaseBundle) r12).a.b;
        r12.getExtraParams();
        if (((BaseBundle) r12).h.b == false) goto L48;
        gza.b r18 = OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r18 == null) goto L48;
        ChatFragment r19 = new ChatFragment();
        r19.setArguments(r14.getExtras());
        r18.O1(r12.getChatId(), r19);
    L51:
        PerfLog.end("prepare_chat_window", "");
        int r110 = FlowChatModule.d;
        FlowChatModule.a.a().a().getPerfEnterChatMonitor().l(true);
        return true;
    L48:
        if ((r10.getContext() instanceof Activity) == false) goto L50;
        r10.getContext().startActivity(r14);
        goto L51
    L50:
        r14.addFlags(268435456);
        r10.getContext().startActivity(r14);
        goto L51
    L41:
        Intrinsics.throwUninitializedPropertyAccessException("userSession");
        goto L42
    L34:
        r14 = new Intent(r10.getContext(), FlowChatActivity.class);
        goto L35
    L28:
        r13 = null;
        goto L29
    L24:
        r9 = null;
        goto L26
    }
}
