package com.obric.memorydata.memory.ui.settings;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiproactive.api.ProactiveShortcutState;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.datatransport.api.DataTransportManagerApi;
import com.obric.memorydata.memory.databinding.ActivityMemorySettingsBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.memory.ui.address.setting.AddressSettingActivity;
import com.obric.memorydata.memory.ui.lab.AILabActivity;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.UserStateManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.IdentityController;
import com.obric.memorydata.ui.banner.OBannerTouchHost;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.memorydata.ui.custom.DeviceAdaptiveWebViewActivity;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.bb;
import com.obric.oui.banner.OBanner;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.LocalBroadcastManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.flow.ar;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t*\u0002\u0017\u001a\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\u0014\u0010%\u001a\u00020\u001d*\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0014J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u001dH\u0014J\b\u0010/\u001a\u00020\u001dH\u0014J\b\u00100\u001a\u00020\u001dH\u0002J\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\u000f\u00104\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0002\u00105J\u0017\u00106\u001a\u0004\u0018\u00010(2\u0006\u00107\u001a\u000208H\u0002¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u001dH\u0002J\u0016\u0010;\u001a\u00020\u001d2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002J\b\u0010?\u001a\u00020\u001dH\u0002J\b\u0010@\u001a\u00020\u001dH\u0002J\b\u0010A\u001a\u00020\rH\u0002J\u0010\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\rH\u0002J\b\u0010D\u001a\u00020\u001dH\u0002J\b\u0010E\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006G"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityMemorySettingsBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "systemHasContextAwarenessEntry", "", "aiLabEnabled", "screenMemoryShown", "voiceMemoryShown", "proactiveEntryVisible", "returnToProactiveSettings", "authSwitchListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "uxpSwitchListener", "pinShortcutResultReceiver", "com/obric/memorydata/memory/ui/settings/MemorySettingsActivity$pinShortcutResultReceiver$1", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsActivity$pinShortcutResultReceiver$1;", "aiProactiveEntryObserver", "com/obric/memorydata/memory/ui/settings/MemorySettingsActivity$aiProactiveEntryObserver$1", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsActivity$aiProactiveEntryObserver$1;", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onBackPressed", "updateReturnToProactiveSettings", "setPageSpacing", "Landroidx/viewpager2/widget/ViewPager2;", "pageMargin", "", "setupFloatingTitleBar", "initViews", "onResumeChecked", "refreshSettingsOnResume", "refreshBannerBackground", "onStop", "onDestroy", "showKeyguardSettingDialog", "openKeyguardSecuritySettingsPage", "observerState", "updateAiProactiveEntryVisibility", "queryAiProactiveAgentStatus", "()Ljava/lang/Integer;", "readAiProactiveAgentStatus", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)Ljava/lang/Integer;", "renderMemoryVisibility", "renderMemoryAppCardPositions", "items", "", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsAppItem;", "gotoLifeLogApp", "gotoInstallLifelogApp", "checkIconState", "changeIconState", "enable", "maybeRequestMemoryShortcutAutoGuide", "checkProactiveIconState", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemorySettingsActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private static final float OUI_BANNER_MATERIAL_EDGE_INSET_PX = 3.0f;
    private static final String TAG = "MemorySettingsActivity";
    private boolean aiLabEnabled;
    private final c aiProactiveEntryObserver;
    private final CompoundButton.OnCheckedChangeListener authSwitchListener;
    private ActivityMemorySettingsBinding binding;
    private final d pinShortcutResultReceiver;
    private boolean proactiveEntryVisible;
    private boolean returnToProactiveSettings;
    private boolean screenMemoryShown;
    private boolean systemHasContextAwarenessEntry;
    private final CompoundButton.OnCheckedChangeListener uxpSwitchListener;
    private final Lazy viewModel$delegate;
    private boolean voiceMemoryShown;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsActivity$Companion;", "", "<init>", "()V", "TAG", "", "OUI_BANNER_MATERIAL_EDGE_INSET_PX", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r4 = new Intent(r2, MemorySettingsActivity.class);
            if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L5;
            r4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r2, r4, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11406a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11407b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[GlobalMemoryBannerKind.values().length];
            r0[GlobalMemoryBannerKind.ASSISTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L31:
            r0[GlobalMemoryBannerKind.AUTO_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L43:
            r0[GlobalMemoryBannerKind.MEMORY_QA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L33:
            r0[GlobalMemoryBannerKind.KEY_MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L9:
            f11406a = r0;
            int[] r1 = new int[MemorySettingsAppEntry.values().length];
            r1[MemorySettingsAppEntry.PROACTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L35:
            r1[MemorySettingsAppEntry.LIFELOG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L12:
            f11407b = r1;
            int[] r2 = new int[MemorySettingsCardPosition.values().length];
            r2[MemorySettingsCardPosition.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L29:
            r2[MemorySettingsCardPosition.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L37:
            r2[MemorySettingsCardPosition.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L16:
            c = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/settings/MemorySettingsActivity$aiProactiveEntryObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemorySettingsActivity f11408a;

        c(MemorySettingsActivity r3, Handler r4) {
            this.f11408a = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            super(r4);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            super.onChange(r1);
            MemorySettingsActivity.access$updateAiProactiveEntryVisibility(this.f11408a);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/settings/MemorySettingsActivity$pinShortcutResultReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemorySettingsActivity f11409a;

        d(MemorySettingsActivity r3) {
            this.f11409a = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        }

        public void onReceive(Context r21, Intent r22) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r22, MemorySourceLinkType.INTENT);
            String r2 = r22.getStringExtra("extra_shortcut_id");
            boolean r4 = r22.getBooleanExtra("extra_is_added", false);
            boolean r1 = r22.getBooleanExtra("extra_notify_ui", true);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySettingsActivity.TAG, "pinShortcutResult: id=" + r2 + ", added=" + r4, false, 4, null);
            if (r1 == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r2, "memory_home_shortcut") == true) goto L8;
            return;
        L8:
            if (r4 == false) goto L13;
            ActivityMemorySettingsBinding r5 = MemorySettingsActivity.access$getBinding$p(this.f11409a);
            if (r5 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r5 = null;
        L12:
            OCardListItem.a((OCardListItem) ZeusTransformUtils.preCheckCast(r5.pinIcon, OCardListItem.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.f11409a.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_shortcut_enable, TypedValues.Custom.S_STRING, "memory_settings_shortcut_enable")), CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySettingsActivity.TAG, "add pinShortcut success", false, 4, null);
            kotlinx.coroutines.i.a(am.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemorySettingsActivity$pinShortcutResultReceiver$1$onReceive$1(this.f11409a, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L13:
            ActivityMemorySettingsBinding r6 = MemorySettingsActivity.access$getBinding$p(this.f11409a);
            if (r6 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r6 = null;
        L16:
            OCardListItem.a((OCardListItem) ZeusTransformUtils.preCheckCast(r6.pinIcon, OCardListItem.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.f11409a.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_shortcut_disable, TypedValues.Custom.S_STRING, "memory_settings_shortcut_disable")), CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySettingsActivity.TAG, "add pinShortcut cancelled", false, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$1", f = "MemorySettingsActivity.kt", i = {}, l = {TypedValues.PositionType.TYPE_PERCENT_HEIGHT}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsActivity this$0;

        AnonymousClass1(MemorySettingsActivity r3, Continuation<? super AnonymousClass1> r4) {
            MemorySettingsActivity r5 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        private static final boolean invokeSuspend$lambda$0(k r0) {
            return r0.b();
        }

        public static /* synthetic */ boolean lambda$9PepLhGFboQc1gIZW4diBynLoFw(k r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemorySettingsActivity.access$getViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$MemorySettingsActivity$observerState$1$9PepLhGFboQc1gIZW4diBynLoFw.INSTANCE);
            final MemorySettingsActivity r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C06151(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$2", f = "MemorySettingsActivity.kt", i = {}, l = {514}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsActivity this$0;

        AnonymousClass2(MemorySettingsActivity r3, Continuation<? super AnonymousClass2> r4) {
            MemorySettingsActivity r5 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        private static final boolean invokeSuspend$lambda$0(k r0) {
            return r0.g();
        }

        public static /* synthetic */ boolean lambda$5EUVZqnJRAo_6MCS30_rJ7mY1YM(k r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemorySettingsActivity.access$getViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$MemorySettingsActivity$observerState$2$5EUVZqnJRAo_6MCS30_rJ7mY1YM.INSTANCE);
            final MemorySettingsActivity r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$3", f = "MemorySettingsActivity.kt", i = {}, l = {520}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsActivity this$0;

        AnonymousClass3(MemorySettingsActivity r3, Continuation<? super AnonymousClass3> r4) {
            MemorySettingsActivity r5 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        private static final boolean invokeSuspend$lambda$0(k r0) {
            return r0.a();
        }

        public static /* synthetic */ boolean lambda$eqlbdYNrB32uaG15I9ToSpLeqkI(k r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemorySettingsActivity.access$getViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$MemorySettingsActivity$observerState$3$eqlbdYNrB32uaG15I9ToSpLeqkI.INSTANCE);
            final MemorySettingsActivity r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$4", f = "MemorySettingsActivity.kt", i = {}, l = {530}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsActivity this$0;

        AnonymousClass4(MemorySettingsActivity r3, Continuation<? super AnonymousClass4> r4) {
            MemorySettingsActivity r5 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<Boolean> r7 = l.f11479a.a().a();
            final MemorySettingsActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$5", f = "MemorySettingsActivity.kt", i = {}, l = {543}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$5$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/settings/MemoryMethodVisibility;", "screenMemoryShown", "", "voiceMemoryShown"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$5$1", f = "MemorySettingsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super h>, Object> {
            /* synthetic */ boolean Z$0;
            /* synthetic */ boolean Z$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
                super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.jvm.functions.Function3
            public /* synthetic */ Object invoke(Boolean r3, Boolean r4, Continuation<? super h> r5) {
                return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(boolean r2, boolean r3, Continuation<? super h> r4) {
                AnonymousClass1 r5 = new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
                r5.Z$0 = r2;
                r5.Z$1 = r3;
                return r5.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return new h(this.Z$0, this.Z$1);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass5(MemorySettingsActivity r3, Continuation<? super AnonymousClass5> r4) {
            MemorySettingsActivity r5 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass5) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.flow.i r8 = kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(l.f11479a.a().k(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(l.f11479a.a().l(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function3.class, "com.obric.memorydata.plugin"));
            final MemorySettingsActivity r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$6", f = "MemorySettingsActivity.kt", i = {}, l = {557}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsActivity this$0;

        AnonymousClass6(MemorySettingsActivity r3, Continuation<? super AnonymousClass6> r4) {
            MemorySettingsActivity r5 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        private static final boolean invokeSuspend$lambda$0(k r0) {
            return r0.d();
        }

        public static /* synthetic */ boolean lambda$PzCz_a5SoiveZ9kVn6audjgrTJ4(k r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass6) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass6.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemorySettingsActivity.access$getViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$MemorySettingsActivity$observerState$6$PzCz_a5SoiveZ9kVn6audjgrTJ4.INSTANCE);
            final MemorySettingsActivity r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$7", f = "MemorySettingsActivity.kt", i = {}, l = {567}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$7$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MemorySettingsActivity f11416a;

            AnonymousClass1(MemorySettingsActivity r3) {
                this.f11416a = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            }

            private static final void a(MemorySettingsActivity r1, View r2) {
                MemorySettingsActivity.access$gotoLifeLogApp((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemorySettingsActivity.class, "com.obric.memorydata.plugin"));
            }

            private static final Unit b(MemorySettingsActivity r2, View r3) {
                MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "it");
                MemorySettingsActivity.access$gotoInstallLifelogApp(r4);
                return Unit.INSTANCE;
            }

            public static /* synthetic */ void lambda$iPI54UzNFZYn9qu3x6k9ONc65xA(MemorySettingsActivity r0, View r1) {
                a(r0, r1);
            }

            /* JADX INFO: renamed from: lambda$m4-L4cvWZ06MD8VvXkj_axA4rl4, reason: not valid java name */
            public static /* synthetic */ Unit m980lambda$m4L4cvWZ06MD8VvXkj_axA4rl4(MemorySettingsActivity r0, View r1) {
                return b(r0, r1);
            }

            public final Object a(k r9, Continuation<? super Unit> r10) {
                Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
                ActivityMemorySettingsBinding r12 = MemorySettingsActivity.access$getBinding$p(this.f11416a);
                ActivityMemorySettingsBinding r1 = null;
                if (r12 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r12 = null;
            L5:
                View r2 = r12.lifelogApp.getCustomEndView();
                if (r9.e() == false) goto L20;
                if (r2 == null) goto L9;
                r2.setVisibility(8);
            L9:
                ActivityMemorySettingsBinding r13 = MemorySettingsActivity.access$getBinding$p(this.f11416a);
                if (r13 != null) goto L12;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r13 = null;
            L12:
                r13.lifelogApp.setDefaultTailIcon(0);
                ActivityMemorySettingsBinding r14 = MemorySettingsActivity.access$getBinding$p(this.f11416a);
                if (r14 != null) goto L15;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r14 = null;
            L15:
                r14.lifelogApp.f(true);
                ActivityMemorySettingsBinding r15 = MemorySettingsActivity.access$getBinding$p(this.f11416a);
                if (r15 != null) goto L18;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            L19:
                DeviceAdaptiveCardListItem r16 = r1.lifelogApp;
                final MemorySettingsActivity r8 = this.f11416a;
                r16.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$observerState$7$1$iPI54UzNFZYn9qu3x6k9ONc65xA(r8));
            L30:
                return Unit.INSTANCE;
            L18:
                r1 = r15;
                goto L19
            L20:
                if (r2 == null) goto L22;
                final MemorySettingsActivity r17 = this.f11416a;
                r2.setVisibility(0);
                bb.a(r2, 0, new $$Lambda$MemorySettingsActivity$observerState$7$1$m4L4cvWZ06MD8VvXkj_axA4rl4(r17), 1, null);
            L22:
                ActivityMemorySettingsBinding r18 = MemorySettingsActivity.access$getBinding$p(this.f11416a);
                if (r18 != null) goto L25;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r18 = null;
            L25:
                r18.lifelogApp.f(false);
                ActivityMemorySettingsBinding r19 = MemorySettingsActivity.access$getBinding$p(this.f11416a);
                if (r19 != null) goto L28;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r19 = null;
            L28:
                r19.lifelogApp.setOnContentClickListener(null);
                goto L30
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        AnonymousClass7(MemorySettingsActivity r3, Continuation<? super AnonymousClass7> r4) {
            MemorySettingsActivity r5 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        private static final boolean invokeSuspend$lambda$0(k r0) {
            return r0.e();
        }

        /* JADX INFO: renamed from: lambda$-Bops2f6yV-9kKPtk9oXaYMsjso, reason: not valid java name */
        public static /* synthetic */ boolean m979lambda$Bops2f6yV9kKPtk9oXaYMsjso(k r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass7) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass7.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemorySettingsActivity.access$getViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$MemorySettingsActivity$observerState$7$Bops2f6yV9kKPtk9oXaYMsjso.INSTANCE);
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$observerState$8", f = "MemorySettingsActivity.kt", i = {}, l = {590}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass8 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsActivity this$0;

        AnonymousClass8(MemorySettingsActivity r3, Continuation<? super AnonymousClass8> r4) {
            MemorySettingsActivity r5 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        private static final boolean invokeSuspend$lambda$0(k r0) {
            return r0.f();
        }

        public static /* synthetic */ boolean lambda$N6EZhXG0IbfQvPgOF1rmek69uvs(k r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass8(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass8) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass8.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemorySettingsActivity.access$getViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$MemorySettingsActivity$observerState$8$N6EZhXG0IbfQvPgOF1rmek69uvs.INSTANCE);
            final MemorySettingsActivity r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsActivity$setupFloatingTitleBar$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C12091 extends FunctionReferenceImpl implements Function0<Unit> {
        C12091(Object r8) {
            super(0, r8, MemorySettingsActivity.class, "onBackPressed", "onBackPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((MemorySettingsActivity) ZeusTransformUtils.preCheckCast(this.receiver, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
        }
    }

    static {
        Companion = new a(null);
    }

    public MemorySettingsActivity() {
        this.viewModel$delegate = LazyKt.lazy($$Lambda$MemorySettingsActivity$J7tChCpn21ZJRaRsEXScyqdqBqo.INSTANCE);
        this.screenMemoryShown = ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().k().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        this.voiceMemoryShown = ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().l().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        this.proactiveEntryVisible = true;
        this.authSwitchListener = new $$Lambda$MemorySettingsActivity$oPDbeLTWLRadFFDzWjtnrdrj1Iw(this);
        this.uxpSwitchListener = new $$Lambda$MemorySettingsActivity$nISvL1peKQmxAS8GHHYaBieMvHw(this);
        this.pinShortcutResultReceiver = new d(this);
        this.aiProactiveEntryObserver = new c(this, new Handler(Looper.getMainLooper()));
    }

    public static final /* synthetic */ CompoundButton.OnCheckedChangeListener access$getAuthSwitchListener$p(MemorySettingsActivity r2) {
        return ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).authSwitchListener;
    }

    public static final /* synthetic */ ActivityMemorySettingsBinding access$getBinding$p(MemorySettingsActivity r2) {
        return ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ CompoundButton.OnCheckedChangeListener access$getUxpSwitchListener$p(MemorySettingsActivity r2) {
        return ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).uxpSwitchListener;
    }

    public static final /* synthetic */ MemorySettingsViewModel access$getViewModel(MemorySettingsActivity r2) {
        return ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$gotoInstallLifelogApp(MemorySettingsActivity r2) {
        ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).gotoInstallLifelogApp();
    }

    public static final /* synthetic */ void access$gotoLifeLogApp(MemorySettingsActivity r2) {
        ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).gotoLifeLogApp();
    }

    public static final /* synthetic */ void access$renderMemoryVisibility(MemorySettingsActivity r2) {
        ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).renderMemoryVisibility();
    }

    public static final /* synthetic */ void access$setAiLabEnabled$p(MemorySettingsActivity r2, boolean r3) {
        ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).aiLabEnabled = r3;
    }

    public static final /* synthetic */ void access$setScreenMemoryShown$p(MemorySettingsActivity r2, boolean r3) {
        ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).screenMemoryShown = r3;
    }

    public static final /* synthetic */ void access$setVoiceMemoryShown$p(MemorySettingsActivity r2, boolean r3) {
        ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).voiceMemoryShown = r3;
    }

    public static final /* synthetic */ void access$updateAiProactiveEntryVisibility(MemorySettingsActivity r2) {
        ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).updateAiProactiveEntryVisibility();
    }

    private static final void authSwitchListener$lambda$1(MemorySettingsActivity r6, CompoundButton r7, boolean r8) {
        MemorySettingsActivity r9 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r6, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        if (r8 == true) goto L5;
    L15:
        r9.getViewModel().processIntent((j) ZeusTransformUtils.preCheckCast(new j.b(r8), j.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r7.isPressed() == false) goto L15;
        int r10 = IdentityController.f12979a.a((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"));
        if (r10 == 0) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "authSwitch: canAuthenticate fail, code=" + r10, false, 4, null);
        r9.showKeyguardSettingDialog();
        ActivityMemorySettingsBinding r11 = r9.binding;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L11:
        OSwitch r12 = r11.authSwitch.getEndSwitch();
        if (r12 == null) goto L17;
        r12.setChecked(false);
        return;
    }

    private final boolean changeIconState(boolean r4) {
        return l.f11479a.a().a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private final boolean checkIconState() {
        return com.obric.memorydata.memory.utils.m.f11550a.d((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "memory_home_shortcut");
    }

    private final boolean checkProactiveIconState() {
        if (l.f11479a.a().b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")) != ProactiveShortcutState.ACTIVE) goto L5;
        return true;
    L5:
        return false;
    }

    private final MemorySettingsViewModel getViewModel() {
        return (MemorySettingsViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), MemorySettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void gotoInstallLifelogApp() {
        Intent r1 = new Intent("com.obric.action.settings.RESTORE_SYSAPP");     // Catch: Exception -> L8
        r1.putExtra("package_name", "com.obric.lifelog");     // Catch: Exception -> L8
        if (r1.resolveActivity(getPackageManager()) == null) goto L6;
    L5:
        ZeusTransformUtils.startActivity(this, r1, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        return;
    L6:
        r1 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L8
        r1.setData(Uri.parse("market://search?q=AI自动日记&s=1"));     // Catch: Exception -> L8
        r1.setPackage(SmartMemorySettingsViewModel.STORE_PACKAGE_NAME);     // Catch: Exception -> L8
        r1.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "gotoInstallLifelogApp error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        e.printStackTrace();
    }

    private final void gotoLifeLogApp() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "gotoLifeLogApp", false, 4, null);
        com.obric.memorydata.sdk.d.a(new $$Lambda$MemorySettingsActivity$5Nr5KdU8NkXi_jHknEu2LHAwuo(this));
    }

    private static final Unit gotoLifeLogApp$lambda$35(MemorySettingsActivity r5) {
        MemorySettingsActivity r6 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r5, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.obric.lifelog", "com.obric.lifelog.ui.list.LifelogActivity"));
        r0.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        r0.addFlags(32768);
        ZeusTransformUtils.startActivity(r6, r0, "com.obric.memorydata.plugin");
        return Unit.INSTANCE;
    }

    private final void initViews() {
        refreshBannerBackground();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deviceModel: " + DeviceInfoState.INSTANCE.getDeviceModel(), false, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "buildModel: " + Build.MODEL, false, 4, null);
        String r0 = DeviceInfoState.INSTANCE.getDeviceModel();
        final boolean r1 = com.obric.memorydata.utils.b.a(r0);
        final boolean r3 = com.obric.memorydata.utils.b.b(r0);
        final boolean r2 = Intrinsics.areEqual(r0, "Genesis-R");
        OBanner r10 = new OBanner((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
        r10.setTranslationY(-3.0f);
        int r4 = 0;
        r10.setInfiniteSwitchEnabled(false);
        r10.a((com.obric.oui.banner.c) ZeusTransformUtils.preCheckCast(GlobalMemoryBannerViewHolder.Companion, com.obric.oui.banner.c.class, "com.obric.memorydata.plugin"));
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(f.f11469a.a(!r2), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L3:
        boolean r9 = true;
        if (r7.hasNext() == false) goto L46;
        GlobalMemoryBannerKind r8 = (GlobalMemoryBannerKind) ZeusTransformUtils.preCheckCast(r7.next(), GlobalMemoryBannerKind.class, "com.obric.memorydata.plugin");
        if (r8 == GlobalMemoryBannerKind.KEY_MEMORY) goto L8;
    L10:
        boolean r11 = false;
    L11:
        int r12 = b.f11406a[r8.ordinal()];
        if (r12 == 1) goto L41;
        if (r12 != 2) goto L15;
        if (r2 == false) goto L40;
        int r13 = R.drawable.banner_global_memory_2_gr;
        String r14 = "banner_global_memory_2_gr";
    L44:
        int r15 = ZeusTransformUtils.mapRes(r13, "drawable", r14);
    L45:
        r6.add(new e(r15, at.a(r8.getTitleRes()), at.a(r8.tipRes(r11))));
        goto L3
    L40:
        r13 = R.drawable.banner_global_memory_2;
        r14 = "banner_global_memory_2";
        goto L44
    L15:
        if (r12 != 3) goto L17;
        if (r2 == false) goto L37;
        r13 = R.drawable.banner_global_memory_4_gr;
        r14 = "banner_global_memory_4_gr";
        goto L44
    L37:
        r13 = R.drawable.banner_global_memory_4;
        r14 = "banner_global_memory_4";
        goto L44
    L17:
        if (r12 != 4) goto L34;
        String r16 = "banner_global_memory_3_n1_v2";
        if (r11 == false) goto L23;
        if (r3 == false) goto L23;
    L21:
        int r17 = R.drawable.banner_global_memory_3_n1_v2;
    L22:
        r15 = ZeusTransformUtils.mapRes(r17, "drawable", r16);
    L23:
        if (r11 == false) goto L26;
        if (r1 == false) goto L26;
        r13 = R.drawable.banner_global_memory_3_p_v2;
        r14 = "banner_global_memory_3_p_v2";
    L26:
        if (r11 == true) goto L21;
        r16 = "banner_global_memory_3_n1";
        if (r3 == false) goto L31;
    L30:
        r17 = R.drawable.banner_global_memory_3_n1;
        goto L22
    L31:
        if (r1 == false) goto L30;
        r13 = R.drawable.banner_global_memory_3_p;
        r14 = "banner_global_memory_3_p";
        goto L44
    L34:
        throw new NoWhenBranchMatchedException();
    L41:
        if (r2 == false) goto L43;
        r13 = R.drawable.banner_global_memory_1_gr;
        r14 = "banner_global_memory_1_gr";
        goto L44
    L43:
        r13 = R.drawable.banner_global_memory_1;
        r14 = "banner_global_memory_1";
        goto L44
    L8:
        if (com.obric.memorydata.utils.ar.b() == false) goto L10;
        r11 = true;
        goto L11
    L46:
        List<? extends com.obric.oui.banner.a> r18 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        r10.setData(r18);
        r10.b();
        ActivityMemorySettingsBinding r19 = this.binding;
        ActivityMemorySettingsBinding r110 = null;
        if (r19 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L49:
        r19.memoryBannerIndicator.a(r10.getViewPager2(), r18.size());
        ActivityMemorySettingsBinding r20 = this.binding;
        if (r20 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L52:
        OBannerTouchHost.a((OBannerTouchHost) ZeusTransformUtils.preCheckCast(r20.memorySettingsBannerInnerWrapper, OBannerTouchHost.class, "com.obric.memorydata.plugin"), r10, false, 2, null);
        ActivityMemorySettingsBinding r21 = this.binding;
        if (r21 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L55:
        r21.memoryData.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$OYCCEmBdfbBKsUHRKGKwScrU0(this));
        ActivityMemorySettingsBinding r22 = this.binding;
        if (r22 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L58:
        r22.pinIcon.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$x97cmYCaD__eRZ4B3TAEbAUUFew(this));
        ActivityMemorySettingsBinding r23 = this.binding;
        if (r23 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L61:
        r23.proactiveUi.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$Bu5VrAg1ZXdusI4hg2sLaS90JMY(this));
        ActivityMemorySettingsBinding r24 = this.binding;
        if (r24 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L64:
        r24.activeMemory.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$JYSDd7XOdFJDgZOo3yHlj9cRpT0(this));
        ActivityMemorySettingsBinding r25 = this.binding;
        if (r25 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L67:
        r25.smartMemory.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$tSzPUqHLwNdmd2txxCMuxNoqYo(this));
        ActivityMemorySettingsBinding r26 = this.binding;
        if (r26 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L70:
        r26.contextAwareness.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$qf597P4EbzecQzjs5FhGJkG1f8(this));
        ActivityMemorySettingsBinding r27 = this.binding;
        if (r27 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L73:
        r27.voice.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$ucXiBD6pFgsHqnIu_FolNeQin10(this, r1, r3, r2));
        ActivityMemorySettingsBinding r28 = this.binding;
        if (r28 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L76:
        OSwitch r29 = r28.authSwitch.getEndSwitch();
        if (r29 == null) goto L79;
        r29.setOnCheckedChangeListener(this.authSwitchListener);
    L79:
        ActivityMemorySettingsBinding r30 = this.binding;
        if (r30 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L82:
        r30.commonLocationManager.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$Hva3r5CsFXlP5C9f2W7mqXALI(this));
        ActivityMemorySettingsBinding r31 = this.binding;
        if (r31 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L85:
        OSwitch r32 = r31.uxpSwitch.getEndSwitch();
        if (r32 == null) goto L88;
        r32.setOnCheckedChangeListener(this.uxpSwitchListener);
    L88:
        ActivityMemorySettingsBinding r33 = this.binding;
        if (r33 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L91:
        r33.privacyPolicy.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$_7fdvaKN0CaDYvb7mmSBlC5KlA(this));
        ActivityMemorySettingsBinding r34 = this.binding;
        if (r34 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L94:
        r34.aiLab.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$6pBKMm5O5f6PA6qgspJtSXXl04(this));
        DataTransportManagerApi r35 = com.obric.memorydata.datatransport.api.c.a();
        if (r35 != null) goto L97;
    L99:
        r9 = false;
    L100:
        ActivityMemorySettingsBinding r36 = this.binding;
        if (r36 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r36 = null;
    L103:
        DeviceAdaptiveCardListItem r37 = r36.dataExport;
        if (r9 == false) goto L106;
        int r38 = 0;
    L107:
        r37.setVisibility(r38);
        if (r9 == false) goto L113;
        ActivityMemorySettingsBinding r39 = this.binding;
        if (r39 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r39 = null;
    L112:
        r39.dataExport.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$o7PQ4L2IM7UbJy40nRvygcuae_4(this));
    L113:
        ActivityMemorySettingsBinding r40 = this.binding;
        if (r40 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r40 = null;
    L116:
        DeviceAdaptiveCardListItem r41 = r40.memoryBuildDataPackage;
        if (AppContext.INSTANCE.isDebug() == true) goto L120;
        r4 = 8;
    L120:
        r41.setVisibility(r4);
        if (AppContext.INSTANCE.isDebug() == false) goto L132;
        ActivityMemorySettingsBinding r42 = this.binding;
        if (r42 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L126:
        r110.memoryBuildDataPackage.setOnContentClickListener(new $$Lambda$MemorySettingsActivity$ti2BSJy4RWBCvh2i28DR7mqGEMM(this));
        return;
    L125:
        r110 = r42;
        goto L126
    L132:
        return;
    L106:
        r38 = 8;
        goto L107
    L97:
        if (r35.isDataExportEntryEnabled() != true) goto L99;
        goto L99
    }

    private static final void initViews$lambda$11(MemorySettingsActivity r2, View r3) {
        final MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.settings.a.a(UserSettings.INSTANCE.hasAgreePrivacyAndLogin(), new $$Lambda$MemorySettingsActivity$jYBYh1tcQ0Wx58x7U53GZSsrZXM(r4), new $$Lambda$MemorySettingsActivity$5G0scokvxwcvwAWOJaRu06MbeVk(r4));
    }

    private static final Unit initViews$lambda$11$lambda$10(MemorySettingsActivity r3, Function1 r4) {
        MemorySettingsActivity r5 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "callback");
        UserStateManager.INSTANCE.requestAgreePrivacyAndLogin((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin"), r6);
        return Unit.INSTANCE;
    }

    private static final Unit initViews$lambda$11$lambda$9(MemorySettingsActivity r3) {
        MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        ZeusTransformUtils.startActivity(r4, l.f11479a.a().a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin");
        return Unit.INSTANCE;
    }

    private static final void initViews$lambda$12(MemorySettingsActivity r2, View r3) {
        MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        ActiveMemorySettingsActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
    }

    private static final void initViews$lambda$13(MemorySettingsActivity r2, View r3) {
        MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        SmartMemorySettingsActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
    }

    private static final void initViews$lambda$14(MemorySettingsActivity r2, View r3) {
        MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        ContextAwarenessSettingsActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
    }

    private static final void initViews$lambda$16(MemorySettingsActivity r8, boolean r9, boolean r10, boolean r11, View r12) {
        MemorySettingsActivity r13 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.utils.f r14 = com.obric.memorydata.memory.utils.f.f11537a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(r13, Context.class, "com.obric.memorydata.plugin");
        Intent r2 = new Intent();
        r2.setClassName("com.obric.recorder", "com.bytedanceos.recorder.settings.RecorderAlwaysOnSettingsActivity");
        Unit r3 = Unit.INSTANCE;
        boolean r15 = r14.a(r1, r2);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "click voice, result: " + r15, false, 4, null);
        if (r15 == false) goto L5;
        return;
    L5:
        if (com.obric.memorydata.utils.c.f13193a.a(AppInfo.Recorder.getPackageName()) == true) goto L15;
        com.obric.oui.toast.a.C0786a r4 = com.obric.oui.toast.a.f14807a;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(r13, Context.class, "com.obric.memorydata.plugin");
        String r6 = r13.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_voice_recorder_not_installed, TypedValues.Custom.S_STRING, "memory_settings_voice_recorder_not_installed"));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r4, r5, r6, 0, 4, null);
        if (r9 == true) goto L12;
        if (r10 == true) goto L12;
        if (r11 == true) goto L16;
        com.obric.memorydata.memory.utils.f.f11537a.a((Context) ZeusTransformUtils.preCheckCast(r13, Context.class, "com.obric.memorydata.plugin"), new Intent("com.obric.action.settings.RESTORE_SYSAPP"));
        return;
    L16:
        return;
    L12:
        com.obric.memorydata.utils.d.f13204a.b((Context) ZeusTransformUtils.preCheckCast(r13, Context.class, "com.obric.memorydata.plugin"), AppInfo.Recorder.getPackageName());
        return;
    }

    private static final void initViews$lambda$17(MemorySettingsActivity r2, View r3) {
        MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        AddressSettingActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
    }

    private static final void initViews$lambda$18(MemorySettingsActivity r8, View r9) {
        MemorySettingsActivity r10 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        String r11 = UserSettings.INSTANCE.getGlobalMemoryPrivacyUrl();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "privacyUrl: " + r11, false, 4, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "click privacy policy failed, url is empty", null, 4, null);
        return;
    L9:
        DeviceAdaptiveWebViewActivity.a r2 = DeviceAdaptiveWebViewActivity.Companion;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.memorydata.plugin");
        String r12 = r10.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_global_memory_privacy_policy, TypedValues.Custom.S_STRING, "memory_settings_global_memory_privacy_policy"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        r2.a(r0, r11, r12);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private static final void initViews$lambda$19(MemorySettingsActivity r2, View r3) {
        MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        AILabActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
    }

    private static final void initViews$lambda$20(MemorySettingsActivity r2, View r3) {
        MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        DataTransportManagerApi r5 = com.obric.memorydata.datatransport.api.c.a();
        if (r5 == null) goto L6;
        r5.startExportActivity((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
        return;
    }

    private static final void initViews$lambda$21(MemorySettingsActivity r2, View r3) {
        MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        DataTransportManagerApi r5 = com.obric.memorydata.datatransport.api.c.a();
        if (r5 == null) goto L6;
        r5.startMemoryBuildDataPackageActivity((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
        return;
    }

    private static final void initViews$lambda$7(MemorySettingsActivity r11, View r12) {
        MemorySettingsActivity r13 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r11, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        MemoryListActivity.a.a(MemoryListActivity.Companion, (Context) ZeusTransformUtils.preCheckCast(r13, Context.class, "com.obric.memorydata.plugin"), null, MemoryEventTracker.SourceType.SYSTEM_SETTINGS.getValue(), null, null, false, null, 122, null);
    }

    private static final void initViews$lambda$8(MemorySettingsActivity r1, View r2) {
        MemorySettingsActivity r3 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        if (r3.checkIconState() == true) goto L6;
        r3.changeIconState(true);
        return;
    }

    /* JADX INFO: renamed from: lambda$-tSzPUqHLwNdmd2txxCMuxNoqYo, reason: not valid java name */
    public static /* synthetic */ void m970lambda$tSzPUqHLwNdmd2txxCMuxNoqYo(MemorySettingsActivity r0, View r1) {
        initViews$lambda$13(r0, r1);
    }

    public static /* synthetic */ Unit lambda$5G0scokvxwcvwAWOJaRu06MbeVk(MemorySettingsActivity r0, Function1 r1) {
        return initViews$lambda$11$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$5Nr5KdU8NkXi_jHknEu2LHAw-uo, reason: not valid java name */
    public static /* synthetic */ Unit m971lambda$5Nr5KdU8NkXi_jHknEu2LHAwuo(MemorySettingsActivity r0) {
        return gotoLifeLogApp$lambda$35(r0);
    }

    /* JADX INFO: renamed from: lambda$6pBKMm5-O5f6PA6qgspJtSXXl04, reason: not valid java name */
    public static /* synthetic */ void m972lambda$6pBKMm5O5f6PA6qgspJtSXXl04(MemorySettingsActivity r0, View r1) {
        initViews$lambda$19(r0, r1);
    }

    public static /* synthetic */ void lambda$9tqeYSMMZUpIYytDHNJHgZ0EZtE(MemorySettingsActivity r0) {
        onResumeChecked$lambda$22(r0);
    }

    /* JADX INFO: renamed from: lambda$AdVK2HsO9ZNGC-AH0giOWoV9RiM, reason: not valid java name */
    public static /* synthetic */ void m973lambda$AdVK2HsO9ZNGCAH0giOWoV9RiM(MemorySettingsActivity r0) {
        r0.maybeRequestMemoryShortcutAutoGuide();
    }

    public static /* synthetic */ void lambda$Bu5VrAg1ZXdusI4hg2sLaS90JMY(MemorySettingsActivity r0, View r1) {
        initViews$lambda$11(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Hva3r5-Cs-FXlP5C9f2W7mqXALI, reason: not valid java name */
    public static /* synthetic */ void m974lambda$Hva3r5CsFXlP5C9f2W7mqXALI(MemorySettingsActivity r0, View r1) {
        initViews$lambda$17(r0, r1);
    }

    public static /* synthetic */ MemorySettingsViewModel lambda$J7tChCpn21ZJRaRsEXScyqdqBqo() {
        return viewModel_delegate$lambda$0();
    }

    public static /* synthetic */ void lambda$JYSDd7XOdFJDgZOo3yHlj9cRpT0(MemorySettingsActivity r0, View r1) {
        initViews$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$OY-CCEmBdfbBKsUHRKGKwScr-U0, reason: not valid java name */
    public static /* synthetic */ void m975lambda$OYCCEmBdfbBKsUHRKGKwScrU0(MemorySettingsActivity r0, View r1) {
        initViews$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$QjwiX0TgouBYvjzckyqME-pQAw8, reason: not valid java name */
    public static /* synthetic */ Unit m976lambda$QjwiX0TgouBYvjzckyqMEpQAw8(MemorySettingsActivity r0, DialogInterface r1, int r2) {
        return showKeyguardSettingDialog$lambda$25(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$RGpSSQ3eqrofxe9j2vLZAU05uzI(float r0, ViewPager2 r1, View r2, float r3) {
        setPageSpacing$lambda$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$S8yMyF3zILCLNbjC5JulKTTqOOE(DialogInterface r0, int r1) {
        return showKeyguardSettingDialog$lambda$24(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$_7fdvaKN0CaDYv-b7mmSBlC5KlA, reason: not valid java name */
    public static /* synthetic */ void m977lambda$_7fdvaKN0CaDYvb7mmSBlC5KlA(MemorySettingsActivity r0, View r1) {
        initViews$lambda$18(r0, r1);
    }

    public static /* synthetic */ Unit lambda$jYBYh1tcQ0Wx58x7U53GZSsrZXM(MemorySettingsActivity r0) {
        return initViews$lambda$11$lambda$9(r0);
    }

    public static /* synthetic */ void lambda$nISvL1peKQmxAS8GHHYaBieMvHw(MemorySettingsActivity r0, CompoundButton r1, boolean r2) {
        uxpSwitchListener$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$o7PQ4L2IM7UbJy40nRvygcuae_4(MemorySettingsActivity r0, View r1) {
        initViews$lambda$20(r0, r1);
    }

    public static /* synthetic */ void lambda$oPDbeLTWLRadFFDzWjtnrdrj1Iw(MemorySettingsActivity r0, CompoundButton r1, boolean r2) {
        authSwitchListener$lambda$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$qf597P4EbzecQzjs5-FhGJkG1f8, reason: not valid java name */
    public static /* synthetic */ void m978lambda$qf597P4EbzecQzjs5FhGJkG1f8(MemorySettingsActivity r0, View r1) {
        initViews$lambda$14(r0, r1);
    }

    public static /* synthetic */ void lambda$ti2BSJy4RWBCvh2i28DR7mqGEMM(MemorySettingsActivity r0, View r1) {
        initViews$lambda$21(r0, r1);
    }

    public static /* synthetic */ void lambda$ucXiBD6pFgsHqnIu_FolNeQin10(MemorySettingsActivity r0, boolean r1, boolean r2, boolean r3, View r4) {
        initViews$lambda$16(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$x97cmYCaD__eRZ4B3TAEbAUUFew(MemorySettingsActivity r0, View r1) {
        initViews$lambda$8(r0, r1);
    }

    private final void maybeRequestMemoryShortcutAutoGuide() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L19;
        l r0 = l.f11479a.a();
        if (r0.q() == false) goto L10;
        return;
    L10:
        if (checkIconState() == false) goto L13;
        return;
    L13:
        if (changeIconState(true) == false) goto L18;
        r0.r();
        return;
    L18:
        return;
    }

    private final void observerState() {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass8(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final void onResumeChecked$lambda$22(MemorySettingsActivity r2) {
        MemorySettingsActivity r3 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        if (r3.isFinishing() == false) goto L5;
        return;
    L5:
        if (r3.isDestroyed() == true) goto L9;
        r3.refreshSettingsOnResume();
        return;
    }

    private final void openKeyguardSecuritySettingsPage() {
        Intent r0 = new Intent("android.settings.BIOMETRIC_ENROLL");
        r0.putExtra("android.provider.extra.BIOMETRIC_AUTHENTICATORS_ALLOWED", 32768);
        ZeusTransformUtils.startActivity(this, r0, "com.obric.memorydata.plugin");
    }

    private final Integer queryAiProactiveAgentStatus() {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        MemorySettingsActivity r9 = (MemorySettingsActivity) ZeusTransformUtils.preCheckCast(this, MemorySettingsActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Cursor r3 = ZeusProviderTransform.query(r9.getContentResolver(), Uri.parse("content://com.obric.memorydata.memory.ailabprovider/ai_proactive_agent"), null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r3 == null) goto L14;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Integer r10 = r9.readAiProactiveAgentStatus((Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L17
    L15:
        Object r11 = Result.m1421constructorimpl(r10);     // Catch: Throwable -> L17
    L19:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r11);
        if (r5 == null) goto L23;
        RunLog.INSTANCE.warn(TAG, "queryAiProactiveAgentStatus failed", r5);
    L23:
        if (Result.m1427isFailureimpl(r11) == true) goto L27;
        r1 = r11;
    L27:
        return (Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L14:
        r10 = null;
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    private final Integer readAiProactiveAgentStatus(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r1.moveToFirst() == true) goto L5;
        return null;
    L5:
        int r3 = r1.getColumnIndex("status");
        if (r3 >= 0) goto L9;
        return null;
    L9:
        return Integer.valueOf(r1.getInt(r3));
    }

    private final void refreshBannerBackground() {
        ActivityMemorySettingsBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        FrameLayout r1 = r0.memoryBannerContainer;
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(0);
        r2.setColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_advanced_fill_list_item_card, TypedValues.Custom.S_COLOR, "oui_advanced_fill_list_item_card")));
        r2.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics())));
        r1.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r2, Drawable.class, "com.obric.memorydata.plugin"));
    }

    private final void refreshSettingsOnResume() {
        refreshBannerBackground();
        this.systemHasContextAwarenessEntry = com.obric.memorydata.utils.ar.c();
        renderMemoryVisibility();
        ActivityMemorySettingsBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OCardListItem r1 = (OCardListItem) ZeusTransformUtils.preCheckCast(r0.pinIcon, OCardListItem.class, "com.obric.memorydata.plugin");
        if (checkIconState() == false) goto L8;
        int r2 = R.string.memory_settings_shortcut_enable;
        String r5 = "memory_settings_shortcut_enable";
    L9:
        OCardListItem.a(r1, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r2, TypedValues.Custom.S_STRING, r5)), CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        updateAiProactiveEntryVisibility();
        getViewModel().refresh();
        l.f11479a.a().p();
        return;
    L8:
        r2 = R.string.memory_settings_shortcut_disable;
        r5 = "memory_settings_shortcut_disable";
        goto L9
    }

    private final void renderMemoryAppCardPositions(List<i> r9) {
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L27;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r10.next(), i.class, "com.obric.memorydata.plugin");
        int r2 = b.f11407b[r0.a().ordinal()];
        int r6 = 1;
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L13;
        ActivityMemorySettingsBinding r3 = this.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        DeviceAdaptiveCardListItem r4 = r3.lifelogApp;
    L18:
        Intrinsics.checkNotNull(r4);
        int r1 = b.c[r0.b().ordinal()];
        if (r1 == 1) goto L25;
        if (r1 == 2) goto L26;
        if (r1 != 3) goto L24;
        r6 = 3;
        goto L26
    L24:
        throw new NoWhenBranchMatchedException();
    L26:
        OCardListItem.a((OCardListItem) ZeusTransformUtils.preCheckCast(r4, OCardListItem.class, "com.obric.memorydata.plugin"), r6, false, 2, null);
        goto L4
    L25:
        r6 = 0;
        goto L26
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        ActivityMemorySettingsBinding r5 = this.binding;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        r4 = r5.proactiveUi;
        goto L18
    }

    private final void renderMemoryVisibility() {
        m r0 = n.a(this.systemHasContextAwarenessEntry, this.aiLabEnabled, this.screenMemoryShown, this.voiceMemoryShown, this.proactiveEntryVisible);
        ActivityMemorySettingsBinding r1 = this.binding;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        TextView r2 = r1.memoryAppTitle;
        int r5 = 8;
        if (r0.e() == false) goto L8;
        int r4 = 0;
    L9:
        r2.setVisibility(r4);
        ActivityMemorySettingsBinding r3 = this.binding;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L12:
        DeviceAdaptiveCardListItem r6 = r3.lifelogApp;
        if (r0.c() == false) goto L15;
        int r7 = 0;
    L16:
        r6.setVisibility(r7);
        ActivityMemorySettingsBinding r8 = this.binding;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L19:
        DeviceAdaptiveCardListItem r9 = r8.proactiveUi;
        if (r0.d() == false) goto L22;
        int r10 = 0;
    L23:
        r9.setVisibility(r10);
        ActivityMemorySettingsBinding r11 = this.binding;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L26:
        DeviceAdaptiveCardListItem r12 = r11.contextAwareness;
        if (r0.a() == false) goto L29;
        int r13 = 0;
    L30:
        r12.setVisibility(r13);
        ActivityMemorySettingsBinding r14 = this.binding;
        if (r14 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L33:
        DeviceAdaptiveCardListItem r15 = r14.voice;
        if (r0.b() == false) goto L36;
        r5 = 0;
    L36:
        r15.setVisibility(r5);
        renderMemoryAppCardPositions(r0.f());
        DeviceAdaptiveCardListItem[] r16 = new DeviceAdaptiveCardListItem[3];
        ActivityMemorySettingsBinding r17 = this.binding;
        if (r17 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L39:
        r16[0] = r17.smartMemory;
        ActivityMemorySettingsBinding r18 = this.binding;
        if (r18 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L42:
        DeviceAdaptiveCardListItem r19 = r18.contextAwareness;
        if (r0.a() == true) goto L46;
        r19 = null;
    L46:
        r16[1] = r19;
        ActivityMemorySettingsBinding r110 = this.binding;
        if (r110 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L49:
        DeviceAdaptiveCardListItem r111 = r110.voice;
        if (r0.b() == true) goto L53;
        r111 = null;
    L53:
        r16[2] = r111;
        List r112 = CollectionsKt.listOfNotNull(r16);
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r21 = 0;
    L55:
        if (r20.hasNext() == false) goto L64;
        Object r22 = r20.next();
        int r23 = r21 + 1;
        if (r21 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();
    L59:
        OCardListItem r24 = (OCardListItem) ZeusTransformUtils.preCheckCast((DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r22, DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin"), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r21 != CollectionsKt.getLastIndex(r112)) goto L62;
        int r25 = 3;
    L63:
        OCardListItem.a(r24, r25, false, 2, null);
        r21 = r23;
        goto L55
    L62:
        r25 = 2;
        goto L63
    L64:
        return;
    L29:
        r13 = 8;
        goto L30
    L22:
        r10 = 8;
        goto L23
    L15:
        r7 = 8;
        goto L16
    L8:
        r4 = 8;
        goto L9
    }

    private static final void setPageSpacing$lambda$3(float r1, ViewPager2 r2, View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "page");
        float r5 = r1 * r4;
        if (r2.getOrientation() != 0) goto L5;
        r3.setTranslationX(r5);
        return;
    L5:
        r3.setTranslationY(r5);
    }

    private final void setupFloatingTitleBar() {
        Integer r0 = com.obric.memorydata.ui.custom.a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarMemorySettingsBottomGap, "attr", "OFloatingTitleBarMemorySettingsBottomGap"));
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        ActivityMemorySettingsBinding r2 = this.binding;
        ActivityMemorySettingsBinding r3 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L9:
        OFloatingTitleBar r4 = r2.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r4, "viewTitle");
        ActivityMemorySettingsBinding r6 = this.binding;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L12:
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.memorySettingsContainer, View.class, "com.obric.memorydata.plugin");
        ActivityMemorySettingsBinding r8 = this.binding;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L15:
        setupTitleBarBackAction(r4, r7, r1, r8.cutOff);
        ActivityMemorySettingsBinding r5 = this.binding;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        OFloatingTitleBar r9 = r3.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r9, "viewTitle");
        com.obric.memorydata.ui.custom.a.a(r9, (Function0) ZeusTransformUtils.preCheckCast(new C12091(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L18:
        r3 = r5;
        goto L19
    L5:
        r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        goto L6
    }

    private final void showKeyguardSettingDialog() {
        com.obric.oui.dialog.v2.alert.a r8 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(true).a((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_auth_dialog_title, TypedValues.Custom.S_STRING, "memory_settings_auth_dialog_title")), CharSequence.class, "com.obric.memorydata.plugin"), false).a((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_auth_dialog_content, TypedValues.Custom.S_STRING, "memory_settings_auth_dialog_content")), CharSequence.class, "com.obric.memorydata.plugin")), false, 1, null).b(ZeusTransformUtils.mapRes(R.string.memory_settings_auth_dialog_button_cancel, TypedValues.Custom.S_STRING, "memory_settings_auth_dialog_button_cancel"), $$Lambda$MemorySettingsActivity$S8yMyF3zILCLNbjC5JulKTTqOOE.INSTANCE).a(ZeusTransformUtils.mapRes(R.string.memory_settings_auth_dialog_button_confirm, TypedValues.Custom.S_STRING, "memory_settings_auth_dialog_button_confirm"), new $$Lambda$MemorySettingsActivity$QjwiX0TgouBYvjzckyqMEpQAw8(this)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r8.setCanceledOnTouchOutside(true);
        r8.setCancelable(true);
        r8.show();
    }

    private static final Unit showKeyguardSettingDialog$lambda$24(DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin"), "dialog");
        return Unit.INSTANCE;
    }

    private static final Unit showKeyguardSettingDialog$lambda$25(MemorySettingsActivity r1, DialogInterface r2, int r3) {
        MemorySettingsActivity r4 = (MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemorySettingsActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin"), "dialog");
        r4.openKeyguardSecuritySettingsPage();
        return Unit.INSTANCE;
    }

    private final void updateAiProactiveEntryVisibility() {
        Integer r0 = queryAiProactiveAgentStatus();
        boolean r1 = checkProactiveIconState();
        ActivityMemorySettingsBinding r2 = this.binding;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L6:
        if (r2.proactiveUi.getVisibility() != 0) goto L8;
        boolean r3 = true;
    L9:
        com.obric.memorydata.memory.ui.settings.b r4 = com.obric.memorydata.memory.ui.settings.a.a(r0, r1, r3, false);
        this.proactiveEntryVisible = r4.a();
        if (r4.b() == false) goto L12;
        l.f11479a.a().e((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
    L12:
        renderMemoryVisibility();
        return;
    L8:
        r3 = false;
        goto L9
    }

    private final void updateReturnToProactiveSettings(Intent r3) {
        this.returnToProactiveSettings = r3.getBooleanExtra("com.obric.memorydata.extra.RETURN_TO_PROACTIVE_SETTINGS", false);
    }

    private static final void uxpSwitchListener$lambda$2(MemorySettingsActivity r1, CompoundButton r2, boolean r3) {
        ((MemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemorySettingsActivity.class, "com.obric.memorydata.plugin")).getViewModel().processIntent((j) ZeusTransformUtils.preCheckCast(new j.a(r3), j.class, "com.obric.memorydata.plugin"));
    }

    private static final MemorySettingsViewModel viewModel_delegate$lambda$0() {
        return new MemorySettingsViewModel();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.returnToProactiveSettings == false) goto L6;
        finishAffinity();
        return;
    L6:
        super.onBackPressed();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r9) {
        Intent r10 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r10, "getIntent(...)");
        updateReturnToProactiveSettings(r10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreateChecked", false, 4, null);
        prepareSystemBar();
        ActivityMemorySettingsBinding r11 = ActivityMemorySettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r11, "inflate(...)");
        this.binding = r11;
        ActivityMemorySettingsBinding r2 = null;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r11.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityMemorySettingsBinding r12 = this.binding;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L8:
        ONestedScrollView r13 = r12.memorySettingsContainer;
        Intrinsics.checkNotNullExpressionValue(r13, "memorySettingsContainer");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        LocalBroadcastManager.getInstance((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).registerReceiver((PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.pinShortcutResultReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), new IntentFilter("com.obric.memorydata.action.SHORTCUT_RESULT"));
        ZeusProviderTransform.registerContentObserver(getContentResolver(), Uri.parse("content://com.obric.memorydata.memory.ailabprovider/ai_proactive_agent"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(this.aiProactiveEntryObserver, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        setupFloatingTitleBar();
        ActivityMemorySettingsBinding r14 = this.binding;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L11:
        OFloatingTitleBar r15 = r14.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r15, "viewTitle");
        registerFloatingTitleBar(r15);
        initViews();
        this.systemHasContextAwarenessEntry = com.obric.memorydata.utils.ar.c();
        this.aiLabEnabled = ((k) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), k.class, "com.obric.memorydata.plugin")).f();
        renderMemoryVisibility();
        observerState();
        getViewModel().init();
        getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(getViewModel(), LifecycleObserver.class, "com.obric.memorydata.plugin"));
        ActivityMemorySettingsBinding r16 = this.binding;
        if (r16 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r2.getRoot().post(new $$Lambda$MemorySettingsActivity$AdVK2HsO9ZNGCAH0giOWoV9RiM(this));
        return;
    L14:
        r2 = r16;
        goto L15
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        ZeusTransformUtils.unregisterReceiver(LocalBroadcastManager.getInstance((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.pinShortcutResultReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        ZeusProviderTransform.unregisterContentObserver(getContentResolver(), (ContentObserver) ZeusTransformUtils.preCheckCast(this.aiProactiveEntryObserver, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity
    public void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        if (r1 != null) goto L5;
        return;
    L5:
        setIntent(r1);
        updateReturnToProactiveSettings(r1);
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onResumeChecked", false, 4, null);
        ActivityMemorySettingsBinding r0 = this.binding;
        ActivityMemorySettingsBinding r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        if (r0.viewTitle.isAttachedToWindow() == true) goto L13;
        ActivityMemorySettingsBinding r2 = this.binding;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r1.viewTitle.post(new $$Lambda$MemorySettingsActivity$9tqeYSMMZUpIYytDHNJHgZ0EZtE(this));
        return;
    L10:
        r1 = r2;
        goto L11
    L13:
        refreshSettingsOnResume();
    }

    @Override // com.obric.memorydata.memory.ui.BaseMemoryActivity, com.obric.memorydata.ui.BaseAuthActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onStop", false, 4, null);
        super.onStop();
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onStop: joinInUXP=" + ((k) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), k.class, "com.obric.memorydata.plugin")).b(), false, 4, null);
    }

    public final void setPageSpacing(final ViewPager2 r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        final float r0 = r2 * ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        r1.setPageTransformer(new $$Lambda$MemorySettingsActivity$RGpSSQ3eqrofxe9j2vLZAU05uzI(r0, r1));
    }
}
