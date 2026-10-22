package com.obric.memorydata.personalcontext;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/MonitorAppDataRemovedManager;", "", "<init>", "()V", "TAG", "", "ACTION_APP_DATA_CLEARED", "WHITE_LIST", "", "appDataClearedListener", "com/obric/memorydata/personalcontext/MonitorAppDataRemovedManager$appDataClearedListener$1", "Lcom/obric/memorydata/personalcontext/MonitorAppDataRemovedManager$appDataClearedListener$1;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "publishUninstallAppInfo", ObricMemoryConstants.KEY_PACKAGE_NAME, "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f12238a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f12239b = null;
    private static final a c = null;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/personalcontext/MonitorAppDataRemovedManager$appDataClearedListener$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends PluginBroadcastReceiver {
        a() {
        }

        public void onReceive(Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r9, MemorySourceLinkType.INTENT);
            RunLog.INSTANCE.debug("MonitorAppDataRemovedManager", "app data cleared " + r9);
            if (Intrinsics.areEqual(r9.getAction(), "android.intent.action.PACKAGE_DATA_CLEARED") == false) goto L17;
            Uri r7 = r9.getData();
            if (r7 == null) goto L7;
            String r10 = r7.getSchemeSpecificPart();
        L8:
            RunLog.INSTANCE.debug("MonitorAppDataRemovedManager", "app " + r10 + " data cleared");
            if (Intrinsics.areEqual(r10, AppContext.INSTANCE.getPackageName()) == false) goto L11;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MonitorAppDataRemovedManager", "memory data cleared, kill process", false, 4, null);
            Process.killProcess(Process.myPid());
            return;
        L11:
            if (r10 != null) goto L13;
            return;
        L13:
            if (o.b().contains(r10) == true) goto L38;
            al r1 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
            CoroutineContext r2 = null;
            CoroutineStart r3 = null;
            Object r11 = new MonitorAppDataRemovedManager$appDataClearedListener$1$onReceive$1(r10, null);
        L15:
            kotlinx.coroutines.i.a(r1, r2, r3, (Function2) ZeusTransformUtils.preCheckCast(r11, Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L38:
            return;
        L7:
            r10 = null;
            goto L8
        L17:
            if (Intrinsics.areEqual(r9.getAction(), "android.intent.action.PACKAGE_REMOVED") == true) goto L19;
            return;
        L19:
            if (r9.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L21;
            return;
        L21:
            Uri r12 = r9.getData();
            if (r12 != null) goto L24;
            return;
        L24:
            if (Intrinsics.areEqual(r12.getScheme(), "package") == true) goto L27;
            r12 = null;
        L27:
            if (r12 == null) goto L42;
            String r13 = r12.getSchemeSpecificPart();
            if (r13 != null) goto L31;
            return;
        L31:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L34;
            r13 = null;
        L34:
            if (r13 == null) goto L44;
            r1 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
            r2 = null;
            r3 = null;
            r11 = new MonitorAppDataRemovedManager$appDataClearedListener$1$onReceive$2(r13, null);
            goto L15
        L44:
            return;
        }
    }

    static {
        f12238a = new o();
        f12239b = SetsKt.setOf(new String[]{"com.android.contacts", "com.android.mms", "com.android.gallery3d", "com.obric.calendar", com.obric.memorydata.BuildConfig.LIBRARY_PACKAGE_NAME});
        c = new a();
    }

    private o() {
    }

    public static final /* synthetic */ void a(o r0, String r1) {
        r0.a(r1);
    }

    private final void a(String r1) {
        EntityManager.INSTANCE.deleteAll(r1);
        com.obric.memorydata.personalcontext.storage.e.f12343a.a(r1);
    }

    public static final /* synthetic */ Set b() {
        return f12239b;
    }

    public final void a() {
        RunLog.INSTANCE.debug("MonitorAppDataRemovedManager", "start register app data cleared listener");
        IntentFilter r4 = new IntentFilter("android.intent.action.PACKAGE_DATA_CLEARED");
        r4.addAction("android.intent.action.PACKAGE_REMOVED");
        r4.addDataScheme("package");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(c, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r4, 2, "com.obric.memorydata.plugin");
    }
}
