package com.obric.aiproactive.ui.settings;

import android.app.Activity;
import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.obric.aiproactive.api.IProactiveShortcutService;
import com.obric.aiproactive.api.ProactiveShortcutCompletion;
import com.obric.aiproactive.api.ProactiveShortcutRequestResult;
import com.obric.aiproactive.api.ProactiveShortcutState;
import com.obric.aiproactive.api.af;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011J\u001a\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u001cJ\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveShortcutCoordinator;", "", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;)V", "TAG", "", "service", "Lcom/obric/aiproactive/api/IProactiveShortcutService;", "getService", "()Lcom/obric/aiproactive/api/IProactiveShortcutService;", "service$delegate", "Lkotlin/Lazy;", "pendingRequest", "", "resultListener", "Lcom/obric/aiproactive/api/ProactiveShortcutResultListener;", "onStart", "", "refreshSwitchState", "onSwitchToggled", "activity", "Landroid/app/Activity;", "isChecked", "switchStateListener", "Lkotlin/Function1;", "setSwitchStateListener", "listener", "notifySwitchState", "active", "showFeedback", "stringRes", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LifecycleOwner f6864b;
    private final String c;
    private final Lazy d;
    private boolean e;
    private final af f;
    private Function1<? super Boolean, Unit> g;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6865a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6866b = null;

        static {
            int[] r0 = new int[ProactiveShortcutState.values().length];
            r0[ProactiveShortcutState.INACTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L35:
            r0[ProactiveShortcutState.ACTIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L47:
            r0[ProactiveShortcutState.RESTRICTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r0[ProactiveShortcutState.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L10:
            f6865a = r0;
            int[] r1 = new int[ProactiveShortcutRequestResult.values().length];
            r1[ProactiveShortcutRequestResult.STARTED_PIN_REQUEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L41:
            r1[ProactiveShortcutRequestResult.ALREADY_ACTIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L29:
            r1[ProactiveShortcutRequestResult.ENABLED_EXISTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L39:
            r1[ProactiveShortcutRequestResult.RESTRICTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L33:
            r1[ProactiveShortcutRequestResult.UNSUPPORTED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L43:
            r1[ProactiveShortcutRequestResult.FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L17:
            f6866b = r1;
        }
    }

    public i(Context r3, LifecycleOwner r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        this.f6863a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.f6864b = r6;
        this.c = "ProactiveShortcutCoord";
        this.d = LazyKt.lazy(new $$Lambda$i$rj0EVAk4fDiS2ZnzEOvwvvGJN_Q(this));
        this.f = new $$Lambda$i$KIs3dEO8xcZrztdtYB_NxjThh10(this);
    }

    public static final /* synthetic */ IProactiveShortcutService a(i r0) {
        return r0.c();
    }

    private final void a(int r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        i r6 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        com.obric.oui.toast.a.C0786a r1 = com.obric.oui.toast.a.f14807a;     // Catch: Throwable -> L4
        Context r2 = r6.f6863a;     // Catch: Throwable -> L4
        String r3 = r2.getString(r7);     // Catch: Throwable -> L4
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");     // Catch: Throwable -> L4
        com.obric.oui.toast.a.C0786a.a(r1, r2, r3, 0, 4, null);     // Catch: Throwable -> L4
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    private static final void a(i r2, ProactiveShortcutCompletion r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        boolean r0 = r2.e;
        r2.e = false;
        r2.b();
        if (r0 == true) goto L5;
        return;
    L5:
        if (r3 != ProactiveShortcutCompletion.NOT_PINNED) goto L9;
        r2.a(ZeusTransformUtils.mapRes(R.string.proactive_shortcut_not_added, TypedValues.Custom.S_STRING, "proactive_shortcut_not_added"));
        return;
    }

    public static final /* synthetic */ void a(i r0, boolean r1) {
        r0.e = r1;
    }

    private final void a(boolean r1) {
        Function1<? super Boolean, Unit> r0 = this.g;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r1));
        return;
    }

    public static final /* synthetic */ af b(i r0) {
        return r0.f;
    }

    private final IProactiveShortcutService c() {
        return (IProactiveShortcutService) ZeusTransformUtils.preCheckCast(this.d.getValue(), IProactiveShortcutService.class, "com.obric.memorydata.plugin");
    }

    private static final IProactiveShortcutService c(i r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl((IProactiveShortcutService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IProactiveShortcutService.class), IProactiveShortcutService.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r1) == false) goto L11;
        r1 = null;
    L11:
        return (IProactiveShortcutService) ZeusTransformUtils.preCheckCast(r1, IProactiveShortcutService.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ void lambda$KIs3dEO8xcZrztdtYB_NxjThh10(i r0, ProactiveShortcutCompletion r1) {
        a(r0, r1);
    }

    public static /* synthetic */ IProactiveShortcutService lambda$rj0EVAk4fDiS2ZnzEOvwvvGJN_Q(i r0) {
        return c(r0);
    }

    public final void a() {
        IProactiveShortcutService r0 = c();
        if (r0 == null) goto L5;
        r0.registerResultListener(this.f);
    L5:
        this.f6864b.getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new ProactiveShortcutCoordinator$onStart$1(this), LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }

    public final void a(Function1<? super Boolean, Unit> r3) {
        Function1<? super Boolean, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.g = r4;
    }

    public final boolean a(Activity r8, boolean r9) {
        Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "activity");
        if (r9 == true) goto L37;
        IProactiveShortcutService r11 = c();
        if (r11 == null) goto L8;
        ProactiveShortcutState r12 = r11.disableByUser(this.f6863a);
        if (r12 == null) goto L8;
    L9:
        int r13 = a.f6865a[r12.ordinal()];
        if (r13 != 1) goto L12;
        IProactiveShortcutService r14 = c();
        if (r14 != null) goto L26;
    L28:
        boolean r15 = false;
    L29:
        if (r15 == false) goto L32;
        a(ZeusTransformUtils.mapRes(R.string.proactive_shortcut_manual_removal_required, TypedValues.Custom.S_STRING, "proactive_shortcut_manual_removal_required"));
    L32:
        if (r12 != ProactiveShortcutState.INACTIVE) goto L35;
        return true;
    L35:
        return false;
    L26:
        if (r14.isResidualOnLauncher(this.f6863a) != true) goto L28;
        r15 = true;
        goto L29
    L12:
        if (r13 != 2) goto L14;
        a(ZeusTransformUtils.mapRes(R.string.proactive_shortcut_disable_failed, TypedValues.Custom.S_STRING, "proactive_shortcut_disable_failed"));
        a(true);
        goto L32
    L14:
        if (r13 != 3) goto L16;
        int r16 = ZeusTransformUtils.mapRes(R.string.proactive_shortcut_restricted, TypedValues.Custom.S_STRING, "proactive_shortcut_restricted");
    L21:
        a(r16);
        a(false);
        goto L32
    L16:
        if (r13 != 4) goto L19;
        r16 = ZeusTransformUtils.mapRes(R.string.proactive_shortcut_unavailable, TypedValues.Custom.S_STRING, "proactive_shortcut_unavailable");
        goto L21
    L19:
        throw new NoWhenBranchMatchedException();
    L8:
        r12 = ProactiveShortcutState.UNKNOWN;
        goto L9
    L37:
        if (this.e == false) goto L39;
        return false;
    L39:
        IProactiveShortcutService r17 = c();
        if (r17 != null) goto L63;
        i this = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");
        int r18 = ZeusTransformUtils.mapRes(R.string.proactive_shortcut_unavailable, TypedValues.Custom.S_STRING, "proactive_shortcut_unavailable");
    L42:
        this.a(r18);
        this.a(false);
        return false;
    L63:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L46
        i r0 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        Object r19 = Result.m1421constructorimpl(r17.requestPin(r10));     // Catch: Throwable -> L46
    L48:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r19);
        if (r20 == null) goto L51;
        RunLog.INSTANCE.warn(this.c, "requestPin failed", r20);
        r18 = ZeusTransformUtils.mapRes(R.string.proactive_shortcut_add_failed, TypedValues.Custom.S_STRING, "proactive_shortcut_add_failed");
        goto L42
    L51:
        switch(a.f6866b[((ProactiveShortcutRequestResult) ZeusTransformUtils.preCheckCast(r19, ProactiveShortcutRequestResult.class, "com.obric.memorydata.plugin")).ordinal()]) {
            case 1: goto L59;
            case 2: goto L58;
            case 3: goto L58;
            case 4: goto L56;
            case 5: goto L55;
            case 6: goto L54;
            default: goto L53;
        };
    L54:
        int r21 = ZeusTransformUtils.mapRes(R.string.proactive_shortcut_add_failed, TypedValues.Custom.S_STRING, "proactive_shortcut_add_failed");
    L57:
        a(r21);
        a(false);
    L61:
        return false;
    L55:
        r21 = ZeusTransformUtils.mapRes(R.string.proactive_shortcut_unsupported, TypedValues.Custom.S_STRING, "proactive_shortcut_unsupported");
        goto L57
    L56:
        r21 = ZeusTransformUtils.mapRes(R.string.proactive_shortcut_restricted, TypedValues.Custom.S_STRING, "proactive_shortcut_restricted");
        goto L57
    L58:
        a(true);
        return true;
    L59:
        this.e = true;
        b();
        goto L61
    L53:
        throw new NoWhenBranchMatchedException();
    L46:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L48
    }

    public final void b() {
        IProactiveShortcutService r0 = c();
        if (r0 == null) goto L6;
        ProactiveShortcutState r1 = r0.queryState(this.f6863a);
        if (r1 == null) goto L6;
    L8:
        if (r1 != ProactiveShortcutState.ACTIVE) goto L10;
        boolean r2 = true;
    L11:
        a(r2);
        return;
    L10:
        r2 = false;
    L6:
        r1 = ProactiveShortcutState.UNKNOWN;
        goto L8
    }
}
