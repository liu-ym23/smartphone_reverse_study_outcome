package com.obric.memorydata.memory.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.LocalBroadcastManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J5\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b\"Ja\u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020'0&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020'0&H\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b,J7\u0010-\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/2\u0018\u00100\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b01\u0012\u0004\u0012\u00020'0&H\u0000¢\u0006\u0002\b2J\u001d\u00103\u001a\u0002042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b5J5\u00106\u001a\u0002042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b7J.\u00108\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J.\u00109\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J0\u0010:\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010;\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\u001d\u0010<\u001a\u0002042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b=J\u0016\u0010>\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\u0010\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020\u001aH\u0002J \u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020C2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\bH\u0002J \u0010E\u001a\u00020'2\u0006\u0010@\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\bH\u0002J(\u0010F\u001a\u00020'2\u0006\u0010@\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0005H\u0002J\u0018\u0010H\u001a\u00020I2\u0006\u0010@\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002JH\u0010J\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00182\b\b\u0002\u0010D\u001a\u00020\b2\b\b\u0002\u0010L\u001a\u00020\u00182\b\b\u0002\u0010M\u001a\u00020\u00182\b\b\u0002\u0010N\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/memorydata/memory/utils/PinShortcutUtils;", "", "<init>", "()V", "TAG", "", "ACTION_SHORTCUT_PINNED", "PIN_REQUEST_TIMEOUT_MS", "", "ACTION_SHORTCUT_RESULT", "EXTRA_SHORTCUT_ID", "EXTRA_IS_ADDED", "EXTRA_REQUEST_GENERATION", "EXTRA_NOTIFY_UI", "EXTRA_RECONCILE_OFF", "EXTRA_PERSIST_USER_OPTOUT_IF_INACTIVE", "NO_REQUEST_GENERATION", "pendingRequests", "Lcom/obric/memorydata/memory/utils/PendingShortcutRequests;", "terminalCoordinator", "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalCoordinator;", "systemReceiver", "Landroid/content/BroadcastReceiver;", "addPinShortcut", "", "context", "Landroid/content/Context;", "shortcutId", "shortLabel", "iconResId", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "requestNewPinShortcut", "requestNewPinShortcut$memory_obricRelease", "requestNewPinShortcutResult", "Lcom/obric/memorydata/memory/utils/PinShortcutStartResult;", "onGenerationStarted", "Lkotlin/Function1;", "", "onGenerationAbandoned", "requestNewPinShortcutResult$memory_obricRelease", "queryPinRequestSupport", "Lcom/obric/memorydata/memory/utils/PinShortcutRequestSupport;", "queryPinRequestSupport$memory_obricRelease", "supersedePinShortcutRequests", "provenance", "Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "onGenerationsSuperseded", "", "supersedePinShortcutRequests$memory_obricRelease", "queryPinnedShortcutState", "Lcom/obric/memorydata/memory/utils/PinnedShortcutState;", "queryPinnedShortcutState$memory_obricRelease", "enablePinnedShortcut", "enablePinnedShortcut$memory_obricRelease", "enableShortcuts", "updatePinShortcutIfExists", "updateShortcut", "removePinShortcut", "queryPinnedResidual", "queryPinnedResidual$memory_obricRelease", "isShortcutExists", "ensureSystemReceiverRegistered", "appContext", "observeResumeForCancel", "activity", "Landroid/app/Activity;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "scheduleTimeout", "completeWithRequery", AILabCheckPermissionTask.KEY_SOURCE, "terminalOperations", "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalOperations;", "sendLocalResult", "isAdded", "notifyUi", "reconcileOff", "persistUserOptOutIfInactive", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f11550a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f11551b = null;
    private static final j c = null;
    private static PluginBroadcastReceiver d;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/utils/PinShortcutUtils$addPinShortcut$1", "Lcom/obric/memorydata/memory/utils/ShortcutAddOperations;", "shortcutExists", "", "updateExisting", "", "notifyExistingAdded", "requestNew", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11553b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ Intent e;

        a(Context r3, String r4, String r5, int r6, Intent r7) {
            this.f11552a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.f11553b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }

        @Override // com.obric.memorydata.memory.utils.r
        public boolean a() {
            return m.f11550a.d(this.f11552a, this.f11553b);
        }

        @Override // com.obric.memorydata.memory.utils.r
        public void b() {
            m.a(m.f11550a, this.f11552a, this.f11553b, this.c, this.d, this.e);
        }

        @Override // com.obric.memorydata.memory.utils.r
        public void c() {
            m.a(m.f11550a, this.f11552a, this.f11553b, true, 0, false, false, false, 120, null);
        }

        @Override // com.obric.memorydata.memory.utils.r
        public boolean d() {
            return m.f11550a.b(this.f11552a, this.f11553b, this.c, this.d, this.e);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"com/obric/memorydata/memory/utils/PinShortcutUtils$enablePinnedShortcut$1", "Lcom/obric/memorydata/memory/utils/EnablePinnedShortcutOperations;", "shortcut", "Landroidx/core/content/pm/ShortcutInfoCompat;", "getShortcut", "()Landroidx/core/content/pm/ShortcutInfoCompat;", "shortcut$delegate", "Lkotlin/Lazy;", "enable", "", BuildConfig.CHANNEL, "queryFinalState", "Lcom/obric/memorydata/memory/utils/PinnedShortcutState;", "onFailure", "error", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.memory.utils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11555b;
        private final Lazy c;

        b(Context r9, final String r10, final String r11, final int r12, final Intent r13) {
            final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
            this.f11554a = ZeusTransformUtils.wrapperContext(r3, "com.obric.memorydata.plugin");
            this.f11555b = r10;
            this.c = LazyKt.lazy(new $$Lambda$m$b$3aVYMoF61a5FpGd_ZZiI_mFVd38(r3, r10, r11, r12, r13));
        }

        private static final ShortcutInfoCompat a(Context r2, String r3, String r4, int r5, Intent r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return new ShortcutInfoCompat.Builder(r7, r3).setShortLabel((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).setIcon(IconCompat.createWithResource(r7, r5)).setIntent(r6).build();
        }

        private final ShortcutInfoCompat c() {
            return (ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(this.c.getValue(), ShortcutInfoCompat.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ ShortcutInfoCompat lambda$3aVYMoF61a5FpGd_ZZiI_mFVd38(Context r0, String r1, String r2, int r3, Intent r4) {
            return a(r0, r1, r2, r3, r4);
        }

        @Override // com.obric.memorydata.memory.utils.b
        public void a() {
            ShortcutManagerCompat.enableShortcuts(this.f11554a, CollectionsKt.listOf(c()));
        }

        @Override // com.obric.memorydata.memory.utils.b
        public void a(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            RunLog.INSTANCE.error("PinShortcutUtils", "enable pinned shortcut failed: " + this.f11555b, r4);
        }

        @Override // com.obric.memorydata.memory.utils.b
        public PinnedShortcutState b() {
            return m.f11550a.a(this.f11554a, this.f11555b);
        }

        @Override // com.obric.memorydata.memory.utils.b
        public void update() {
            ShortcutManagerCompat.updateShortcuts(this.f11554a, CollectionsKt.listOf(c()));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/utils/PinShortcutUtils$ensureSystemReceiverRegistered$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "ctx", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends PluginBroadcastReceiver {
        c() {
        }

        public void onReceive(Context r10, Intent r11) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "ctx");
            Intrinsics.checkNotNullParameter(r11, MemorySourceLinkType.INTENT);
            String r12 = r11.getStringExtra("extra_shortcut_id");
            if (r12 != null) goto L5;
            return;
        L5:
            long r1 = r11.getLongExtra("extra_request_generation", -1);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PinShortcutUtils", "system callback: shortcut pinned -> " + r12 + " generation=" + r1, false, 4, null);
            j r13 = m.a();
            m r3 = m.f11550a;
            Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r14, "getApplicationContext(...)");
            r13.a(r12, r1, m.a(r3, r14, r12));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/utils/PinShortcutUtils$terminalOperations$1", "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalOperations;", "queryExists", "", "publish", "", "event", "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalEvent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11557b;

        d(Context r3, String r4) {
            this.f11556a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.f11557b = r4;
        }

        @Override // com.obric.memorydata.memory.utils.l
        public void a(k r11) {
            Intrinsics.checkNotNullParameter(r11, "event");
            m.a(m.f11550a, this.f11556a, r11.a(), r11.c(), r11.b(), r11.d(), r11.e(), r11.f());
        }

        @Override // com.obric.memorydata.memory.utils.l
        public boolean a() {
            return m.f11550a.d(this.f11556a, this.f11557b);
        }
    }

    static {
        f11550a = new m();
        h r0 = new h(0, 0, 3, null);
        f11551b = r0;
        c = new j(r0);
    }

    private m() {
    }

    public static /* synthetic */ PinShortcutStartResult a(m r10, Context r11, String r12, String r13, int r14, Intent r15, Function1 r16, Function1 r17, int r18, Object r19) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Function1<? super Long, Unit> r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r16, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super Long, Unit> r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r17, Function1.class, "com.obric.memorydata.plugin");
        if ((r18 & 32) == 0) goto L5;
        r0 = $$Lambda$m$hq8KrEJAzx8z4hqPOd9q4TnzLtM.INSTANCE;
    L5:
        Function1<? super Long, Unit> r8 = r0;
        if ((r18 & 64) == 0) goto L8;
        Function1<? super Long, Unit> r9 = $$Lambda$m$MSJWOGd7eu8ymsHQw7aYuCqbr0A.INSTANCE;
    L10:
        return r10.a(r3, r12, r13, r14, r15, r8, r9);
    L8:
        r9 = r1;
        goto L10
    }

    public static final /* synthetic */ j a() {
        return c;
    }

    public static final /* synthetic */ l a(m r2, Context r3, String r4) {
        return r2.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final Unit a(long r0) {
        return Unit.INSTANCE;
    }

    private final void a(Activity r8, String r9, long r10) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, LifecycleOwner.class) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PinShortcutUtils", "Activity is not LifecycleOwner, cannot detect cancel", null, 4, null);
        return;
    L6:
        Lifecycle r11 = ((LifecycleOwner) ZeusTransformUtils.preCheckCast(r7, LifecycleOwner.class, "com.obric.memorydata.plugin")).getLifecycle();
        r11.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new PinShortcutUtils$observeResumeForCancel$1((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r7, ContextWrapper.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, r10, r11), LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }

    private final void a(Context r2, final String r3, final long r4) {
        final Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        new Handler(Looper.getMainLooper()).postDelayed(new $$Lambda$m$25PvRyl3To0PMy2xF5szg0nOUtg(r1, r3, r4), 30000);
    }

    private final void a(Context r8, String r9, long r10, String r12) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PinShortcutUtils", r12 + " check: " + r9 + " generation=" + r10, false, 4, null);
        c.b(r9, r10, e(r11, r9));
    }

    private final void a(Context r3, String r4, boolean r5, long r6, boolean r8, boolean r9, boolean r10) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intent r7 = new Intent("com.obric.memorydata.action.SHORTCUT_RESULT");
        r7.putExtra("extra_shortcut_id", r4);
        r7.putExtra("extra_is_added", r5);
        r7.putExtra("extra_request_generation", r6);
        r7.putExtra("extra_notify_ui", r8);
        r7.putExtra("extra_reconcile_off", r9);
        r7.putExtra("extra_persist_user_optout_if_inactive", r10);
        LocalBroadcastManager.getInstance(r2).sendBroadcast(r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PinShortcutUtils", "local result sent: id=" + r4 + ", generation=" + r6 + ", added=" + r5 + ", notifyUi=" + r8 + ", reconcileOff=" + r9 + ", persistUserOptOutIfInactive=" + r10, false, 4, null);
    }

    public static final /* synthetic */ void a(m r6, Context r7, String r8, long r9, String r11) {
        r6.a((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8, r9, r11);
    }

    public static final /* synthetic */ void a(m r10, Context r11, String r12, boolean r13, long r14, boolean r16, boolean r17, boolean r18) {
        r10.a((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"), r12, r13, r14, r16, r17, r18);
    }

    static /* synthetic */ void a(m r10, Context r11, String r12, boolean r13, long r14, boolean r16, boolean r17, boolean r18, int r19, Object r20) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if ((r19 & 8) == 0) goto L5;
        long r5 = -1;
    L7:
        if ((r19 & 16) == 0) goto L9;
        boolean r7 = true;
    L11:
        if ((r19 & 32) == 0) goto L13;
        boolean r8 = false;
    L15:
        if ((r19 & 64) == 0) goto L17;
        boolean r9 = false;
    L18:
        r10.a(r2, r12, r13, r5, r7, r8, r9);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public static final /* synthetic */ boolean a(m r6, Context r7, String r8, String r9, int r10, Intent r11) {
        return r6.f((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
    }

    private static final boolean a(String r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        RunLog.INSTANCE.error("PinShortcutUtils", "enableShortcuts failed: " + r3, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private static final Unit b(long r0) {
        return Unit.INSTANCE;
    }

    private final synchronized void b(Context r6) {
        monitor-enter(this);
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (d == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        c r0 = new c();     // Catch: Throwable -> L14
        IntentFilter r1 = new IntentFilter("com.obric.memorydata.action.SHORTCUT_PINNED");     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 33) goto L10;
        ZeusTransformUtils.registerReceiver(r7, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r0, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, 4, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L11:
        d = (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r0, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        ZeusTransformUtils.registerReceiver(r7, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r0, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static final void b(Context r6, String r7, long r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        f11550a.a(r1, r7, r8, LocationMonitorConst.TIMEOUT);
    }

    private static final boolean b(String r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        RunLog.INSTANCE.error("PinShortcutUtils", "updateShortcut failed: " + r3, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private static final boolean c(String r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        RunLog.INSTANCE.error("PinShortcutUtils", "removePinShortcut failed: " + r3, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private static final boolean d(String r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        RunLog.INSTANCE.error("PinShortcutUtils", "isShortcutExists failed: " + r3, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final l e(Context r2, String r3) {
        return (l) ZeusTransformUtils.preCheckCast(new d((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3), l.class, "com.obric.memorydata.plugin");
    }

    private static final boolean f(Context r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ShortcutManagerCompat.removeDynamicShortcuts(r9, CollectionsKt.listOf(r8));     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        if (r2 == null) goto L25;
        RunLog.INSTANCE.warn("PinShortcutUtils", "removeDynamicShortcuts failed: " + r8, r2);
    L25:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        ShortcutManagerCompat.removeLongLivedShortcuts(r9, CollectionsKt.listOf(r8));     // Catch: Throwable -> L12
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L17;
        RunLog.INSTANCE.warn("PinShortcutUtils", "removeLongLivedShortcuts failed: " + r8, r5);
    L17:
        ShortcutManagerCompat.disableShortcuts(r9, CollectionsKt.listOf(r8), null);
        PinnedShortcutState r10 = f11550a.a(r9, r8);
        if (r10 != PinnedShortcutState.DISABLED) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PinShortcutUtils", "pinned shortcut disabled but still owned by launcher: " + r8 + "; platform forbids app-side removal of pinned shortcuts", false, 4, null);
    L21:
        if (r10 == PinnedShortcutState.ACTIVE) goto L23;
        return true;
    L23:
        return false;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final boolean f(Context r8, final String r9, final String r10, final int r11, final Intent r12) {
        final Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Boolean r7 = (Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a(new $$Lambda$m$BHJY2A82JCO3s8YLyhtBKYE4gT4(r9), new $$Lambda$m$H1wAxe9YsgDesX2Y58CzBzxddsc(r2, r9, r10, r11, r12)), Boolean.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
        return false;
    L7:
        return r7.booleanValue();
    }

    private static final boolean g(Context r4, String r5) {
        List<ShortcutInfoCompat> r6 = ShortcutManagerCompat.getShortcuts((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), 6);
        Intrinsics.checkNotNullExpressionValue(r6, "getShortcuts(...)");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r8.next(), ShortcutInfoCompat.class, "com.obric.memorydata.plugin")).getId(), r5) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    private static final boolean g(Context r6, String r7, String r8, int r9, Intent r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (ShortcutManagerCompat.isRequestPinShortcutSupported(r11) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PinShortcutUtils", "enable shortcut not supported: " + r7, null, 4, null);
        return false;
    L6:
        ShortcutInfoCompat r12 = new ShortcutInfoCompat.Builder(r11, r7).setShortLabel((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).setIcon(IconCompat.createWithResource(r11, r9)).setIntent(r10).build();
        Intrinsics.checkNotNullExpressionValue(r12, "build(...)");
        ShortcutManagerCompat.updateShortcuts(r11, CollectionsKt.listOf(r12));
        ShortcutManagerCompat.enableShortcuts(r11, CollectionsKt.listOf(r12));
        return ShortcutManagerCompat.updateShortcuts(r11, CollectionsKt.listOf(r12));
    }

    private static final boolean h(Context r2, String r3, String r4, int r5, Intent r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        ShortcutInfoCompat r8 = new ShortcutInfoCompat.Builder(r7, r3).setShortLabel((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).setIcon(IconCompat.createWithResource(r7, r5)).setIntent(r6).build();
        Intrinsics.checkNotNullExpressionValue(r8, "build(...)");
        return ShortcutManagerCompat.updateShortcuts(r7, CollectionsKt.listOf(r8));
    }

    public static /* synthetic */ void lambda$25PvRyl3To0PMy2xF5szg0nOUtg(Context r0, String r1, long r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$BHJY2A82JCO3s8YLyhtBKYE4gT4(String r0, Exception r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ boolean lambda$H1wAxe9YsgDesX2Y58CzBzxddsc(Context r0, String r1, String r2, int r3, Intent r4) {
        return h(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$MSJWOGd7eu8ymsHQw7aYuCqbr0A(long r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$PJSk2GeFAwC-9eZyVUVEgWUcC0g, reason: not valid java name */
    public static /* synthetic */ boolean m994lambda$PJSk2GeFAwC9eZyVUVEgWUcC0g(String r0, Exception r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$STgW58JDJFRGmKv6vr7meu502sQ(String r0, Exception r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ boolean lambda$ToCPEVZiEA__LE6ONES4QfiBL4A(Context r0, String r1) {
        return f(r0, r1);
    }

    public static /* synthetic */ boolean lambda$TsOSCTpPmRNWmWGty8XPBgiLS4s(String r0, Exception r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ Unit lambda$hq8KrEJAzx8z4hqPOd9q4TnzLtM(long r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$kZ-KW8VN-8Z9-FP4GkISmZ4_EY4, reason: not valid java name */
    public static /* synthetic */ boolean m995lambda$kZKW8VN8Z9FP4GkISmZ4_EY4(Context r0, String r1) {
        return g(r0, r1);
    }

    public static /* synthetic */ boolean lambda$yMyVs4b0willvu5X9cqhCEM5vmo(Context r0, String r1, String r2, int r3, Intent r4) {
        return g(r0, r1, r2, r3, r4);
    }

    public final PinShortcutRequestSupport a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
    L8:
        th = move-exception;
        RunLog.INSTANCE.warn("PinShortcutUtils", "query pin shortcut support failed", th);
        return PinShortcutRequestSupport.UNKNOWN;
    L4:
        if (ShortcutManagerCompat.isRequestPinShortcutSupported(r2) == false) goto L6;
        PinShortcutRequestSupport r4 = PinShortcutRequestSupport.SUPPORTED;     // Catch: Throwable -> L8
    L11:
        return r4;
    L6:
        r4 = PinShortcutRequestSupport.UNSUPPORTED;     // Catch: Throwable -> L8
        goto L11
    }

    public final PinShortcutStartResult a(Context r18, String r19, String r20, int r21, Intent r22, Function1<? super Long, Unit> r23, Function1<? super Long, Unit> r24) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        Function1<? super Long, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r23, Function1.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r19, "shortcutId");
        Intrinsics.checkNotNullParameter(r20, "shortLabel");
        Intrinsics.checkNotNullParameter(r22, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r7, "onGenerationStarted");
        Intrinsics.checkNotNullParameter(r8, "onGenerationAbandoned");
        h r9 = f11551b;
        g r10 = r9.a(r19, r7);
        if (r10.b() == true) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PinShortcutUtils", "pin shortcut request already pending: " + r19, false, 4, null);
        return PinShortcutStartResult.ALREADY_PENDING;
    L30:
    L20:
        th = move-exception;
        f11551b.a(r19, r10.a(), false);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L24
        r8.invoke(Long.valueOf(r10.a()));     // Catch: Throwable -> L24
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        RunLog.INSTANCE.error("PinShortcutUtils", "addPinShortcut failed: " + r19, th);
        return PinShortcutStartResult.FAILED;
    L24:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L26
    L8:
        if (ShortcutManagerCompat.isRequestPinShortcutSupported(r5) == true) goto L11;
        r9.a(r19, r10.a(), false);     // Catch: Throwable -> L20
        r8.invoke(Long.valueOf(r10.a()));     // Catch: Throwable -> L20
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PinShortcutUtils", "pin shortcut not supported: " + r19, null, 4, null);     // Catch: Throwable -> L20
        return PinShortcutStartResult.FAILED;
    L11:
        ShortcutInfoCompat r2 = new ShortcutInfoCompat.Builder(r5, r19).setShortLabel((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).setIcon(IconCompat.createWithResource(r5, r21)).setIntent(r22).build();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r2, "build(...)");     // Catch: Throwable -> L20
        Intent r4 = new Intent("com.obric.memorydata.action.SHORTCUT_PINNED");     // Catch: Throwable -> L20
        r4.putExtra("extra_shortcut_id", r19);     // Catch: Throwable -> L20
        r4.putExtra("extra_request_generation", r10.a());     // Catch: Throwable -> L20
        r4.setPackage(r5.getPackageName());     // Catch: Throwable -> L20
        PendingIntent r6 = PendingIntent.getBroadcast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (int) r10.a(), r4, 201326592);     // Catch: Throwable -> L20
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r11, "getApplicationContext(...)");     // Catch: Throwable -> L20
        b(r11);     // Catch: Throwable -> L20
        if (r9.a(r19, r10.a(), ShortcutManagerCompat.requestPinShortcut(r5, r2, r6.getIntentSender())) == true) goto L15;
        r8.invoke(Long.valueOf(r10.a()));     // Catch: Throwable -> L20
        return PinShortcutStartResult.FAILED;
    L15:
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r12, "getApplicationContext(...)");     // Catch: Throwable -> L20
        a(r12, r19, r10.a());     // Catch: Throwable -> L20
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r5), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r1 == null) goto L31;
        f11550a.a(r1, r19, r10.a());     // Catch: Throwable -> L20
    L31:
        return PinShortcutStartResult.STARTED_NEW;
    }

    public final PinnedShortcutState a(Context r3, String r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "shortcutId");
        List<ShortcutInfoCompat> r5 = ShortcutManagerCompat.getShortcuts(r2, 4);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r5, "getShortcuts(...)");     // Catch: Throwable -> L18
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L18
    L5:
        if (r6.hasNext() == false) goto L9;
        Object r7 = r6.next();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(((ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r7, ShortcutInfoCompat.class, "com.obric.memorydata.plugin")).getId(), r4) == false) goto L5;
    L10:
        ShortcutInfoCompat r8 = (ShortcutInfoCompat) ZeusTransformUtils.preCheckCast(r7, ShortcutInfoCompat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r8 != null) goto L14;
        return PinnedShortcutState.ABSENT;
    L14:
        if (r8.isEnabled() == false) goto L27;
        return PinnedShortcutState.ACTIVE;
    L27:
        return PinnedShortcutState.DISABLED;
    L9:
        r7 = null;
    L18:
        th = move-exception;
        RunLog.INSTANCE.warn("PinShortcutUtils", "query pinned shortcut state failed: " + r4, th);
        return PinnedShortcutState.UNKNOWN;
    }

    public final void a(String r2, PinShortcutSupersedeProvenance r3, Function1<? super Set<Long>, Unit> r4) {
        Function1<? super Set<Long>, Unit> r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "shortcutId");
        Intrinsics.checkNotNullParameter(r3, "provenance");
        Intrinsics.checkNotNullParameter(r1, "onGenerationsSuperseded");
        f11551b.a(r2, r3, r1);
    }

    public final boolean a(Context r8, String r9, String r10, int r11, Intent r12) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r9, "shortcutId");
        Intrinsics.checkNotNullParameter(r10, "shortLabel");
        Intrinsics.checkNotNullParameter(r12, MemorySourceLinkType.INTENT);
        return s.a((r) ZeusTransformUtils.preCheckCast(new a(r2, r9, r10, r11, r12), r.class, "com.obric.memorydata.plugin"));
    }

    public final boolean b(Context r3, final String r4) {
        final Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "shortcutId");
        Boolean r5 = (Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a(new $$Lambda$m$STgW58JDJFRGmKv6vr7meu502sQ(r4), new $$Lambda$m$ToCPEVZiEA__LE6ONES4QfiBL4A(r2, r4)), Boolean.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.booleanValue();
    }

    public final boolean b(Context r11, String r12, String r13, int r14, Intent r15) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r12, "shortcutId");
        Intrinsics.checkNotNullParameter(r13, "shortLabel");
        Intrinsics.checkNotNullParameter(r15, MemorySourceLinkType.INTENT);
        if (a(this, r1, r12, r13, r14, r15, null, null, 96, null) == PinShortcutStartResult.FAILED) goto L5;
        return true;
    L5:
        return false;
    }

    public final PinnedShortcutState c(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "shortcutId");
        return a(r5, r4);
    }

    public final PinnedShortcutState c(Context r9, String r10, String r11, int r12, Intent r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r10, "shortcutId");
        Intrinsics.checkNotNullParameter(r11, "shortLabel");
        Intrinsics.checkNotNullParameter(r13, MemorySourceLinkType.INTENT);
        return s.a(a(r3, r10), (com.obric.memorydata.memory.utils.b) ZeusTransformUtils.preCheckCast(new b(r3, r10, r11, r12, r13), com.obric.memorydata.memory.utils.b.class, "com.obric.memorydata.plugin"));
    }

    public final void d(Context r7, final String r8, final String r9, final int r10, final Intent r11) {
        final Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r8, "shortcutId");
        Intrinsics.checkNotNullParameter(r9, "shortLabel");
        Intrinsics.checkNotNullParameter(r11, MemorySourceLinkType.INTENT);
        com.obric.memorydata.utils.y.a(new $$Lambda$m$PJSk2GeFAwC9eZyVUVEgWUcC0g(r8), new $$Lambda$m$yMyVs4b0willvu5X9cqhCEM5vmo(r1, r8, r9, r10, r11));
    }

    public final boolean d(Context r3, final String r4) {
        final Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "shortcutId");
        Boolean r5 = (Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a(new $$Lambda$m$TsOSCTpPmRNWmWGty8XPBgiLS4s(r4), new $$Lambda$m$kZKW8VN8Z9FP4GkISmZ4_EY4(r2, r4)), Boolean.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.booleanValue();
    }

    public final boolean e(Context r7, String r8, String r9, int r10, Intent r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r8, "shortcutId");
        Intrinsics.checkNotNullParameter(r9, "shortLabel");
        Intrinsics.checkNotNullParameter(r11, MemorySourceLinkType.INTENT);
        if (d(r1, r8) == true) goto L7;
        return false;
    L7:
        return f(r1, r8, r9, r10, r11);
    }
}
