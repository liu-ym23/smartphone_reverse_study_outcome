package com.obric.aiproactive.ui.ipc;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveUiSyncReceiver extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f6676a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncReceiver$Companion;", "", "<init>", "()V", "TAG", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6676a = new a(null);
    }

    public ProactiveUiSyncReceiver() {
    }

    public void onReceive(Context r13, Intent r14) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r14, MemorySourceLinkType.INTENT);
        String r15 = r14.getAction();
        if (r15 == null) goto L49;
        int r1 = r15.hashCode();
        boolean r3 = true;
        if (r1 == (-700031362)) goto L37;
        if (r1 == 1105099620) goto L23;
        if (r1 == 1312952329) goto L12;
        return;
    L12:
        if (r15.equals("com.obric.proactive.action.FEEDBACK_REPORT_RESULT") == false) goto L53;
        boolean r16 = r14.getBooleanExtra("success", false);
        boolean r17 = r14.getBooleanExtra("shouldToast", false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUiSyncReceiver", "Receive proactive feedback result success=" + r16 + " shouldToast=" + r17, false, 4, null);
        if (r17 == true) goto L17;
    L21:
        com.obric.aiproactive.ui.ipc.a.f6677a.a(r16, r17);
        return;
    L17:
        if (r16 == false) goto L19;
        int r2 = R.string.proactive_feedback_success;
        String r4 = "proactive_feedback_success";
    L20:
        Toast.makeText(r12, (CharSequence) ZeusTransformUtils.preCheckCast(r12.getString(ZeusTransformUtils.mapRes(r2, TypedValues.Custom.S_STRING, r4)), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        goto L21
    L19:
        r2 = R.string.proactive_feedback_failed;
        r4 = "proactive_feedback_failed";
        goto L20
    L53:
        return;
    L23:
        if (r15.equals("com.obric.proactive.action.RECOMMENDATION_ADOPTED") == false) goto L54;
        String r18 = r14.getStringExtra("recommendId");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L28;
    L31:
        if (r3 == false) goto L35;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r6 = null;
        int r7 = 4;
        Object r8 = null;
        String r9 = "ProactiveUiSyncReceiver";
        String r10 = "Ignore empty recommendId from proactive adopted sync broadcast";
    L33:
        IRunLog.a.a(r0, r9, r10, r6, r7, r8);
        return;
    L35:
        String r19 = r14.getStringExtra("feedbackAction");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUiSyncReceiver", "Receive proactive adopted sync recommendId=" + r18 + " action=" + r19, false, 4, null);
        com.obric.aiproactive.ui.ipc.a.f6677a.a(r12, r18, r19);
        return;
    L28:
        if (StringsKt.isBlank(r5) == true) goto L31;
        r3 = false;
        goto L31
    L54:
        return;
    L37:
        if (r15.equals("com.obric.proactive.action.RECOMMENDATION_DISMISSED") == false) goto L55;
        String r110 = r14.getStringExtra("recommendId");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L42;
    L45:
        if (r3 == false) goto L47;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r9 = "ProactiveUiSyncReceiver";
        r10 = "Ignore empty recommendId from proactive dismissed sync broadcast";
        goto L33
    L47:
        String r111 = r14.getStringExtra(InfoRequestQPSOptTraceLogger.REASON);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUiSyncReceiver", "Receive proactive dismissed sync recommendId=" + r110 + " reason=" + r111, false, 4, null);
        com.obric.aiproactive.ui.ipc.a.f6677a.b(r12, r110, r111);
        return;
    L42:
        if (StringsKt.isBlank(r11) == true) goto L45;
        r3 = false;
        goto L45
    L55:
        return;
    }
}
