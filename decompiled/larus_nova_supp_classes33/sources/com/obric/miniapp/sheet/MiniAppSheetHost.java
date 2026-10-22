package com.obric.miniapp.sheet;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.objects.PageInfo;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.miniapp.utils.c1;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.n;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00190\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00190\u001bJ\u0006\u0010\u001e\u001a\u00020\u0019J\u0010\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0003J\b\u0010!\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetHost;", "", "activity", "Landroid/app/Activity;", "appletRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "pageInfo", "Lcom/bytedance/ai/model/objects/PageInfo;", "config", "Lcom/obric/miniapp/sheet/MiniAppSheetHostConfig;", "<init>", "(Landroid/app/Activity;Lcom/bytedance/ai/model/AppletRuntime;Lcom/bytedance/ai/model/objects/PageInfo;Lcom/obric/miniapp/sheet/MiniAppSheetHostConfig;)V", "bodyContainer", "Landroid/widget/FrameLayout;", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "destroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pageVisible", "", "page", "Lcom/obric/miniapp/sheet/MiniAppLynxSheetPage;", "closeMethodImpl", "Lcom/obric/miniapp/sheet/MiniAppSheetCloseMethodImpl;", "show", "", "onSuccess", "Lkotlin/Function1;", "", "onFailure", "dismiss", "activityMatches", "targetActivity", "viewId", "updateBodyHeight", "heightPx", "", "handleDismiss", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppSheetHost {
    public static final Companion Companion = null;
    private final Activity activity;
    private final AppletRuntime appletRuntime;
    private final FrameLayout bodyContainer;
    private MiniAppSheetCloseMethodImpl closeMethodImpl;
    private final MiniAppSheetHostConfig config;
    private final AtomicBoolean destroyed;
    private MiniAppLynxSheetPage page;
    private final PageInfo pageInfo;
    private boolean pageVisible;
    private final OSheet sheet;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010¨\u0006\u0013"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetHost$Companion;", "", "<init>", "()V", "open", "", "activity", "Landroid/app/Activity;", "appletRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "pageInfo", "Lcom/bytedance/ai/model/objects/PageInfo;", "pageSettings", "Lcom/google/gson/JsonObject;", "sheetSettings", "onSuccess", "Lkotlin/Function1;", "", "onFailure", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void open(Activity r8, AppletRuntime r9, PageInfo r10, JsonObject r11, JsonObject r12, Function1<? super String, Unit> r13, Function1<? super String, Unit> r14) {
            Intrinsics.checkNotNullParameter(r8, "activity");
            Intrinsics.checkNotNullParameter(r9, "appletRuntime");
            Intrinsics.checkNotNullParameter(r10, "pageInfo");
            Intrinsics.checkNotNullParameter(r13, "onSuccess");
            Intrinsics.checkNotNullParameter(r14, "onFailure");
            if (Intrinsics.areEqual(n.b(r9.h, r10), RenderType.LYNX.getTypeName()) == true) goto L6;
            r14.invoke("openSheetPage only supports Lynx pages");
            return;
        L6:
            new MiniAppSheetHost(r8, r9, r10, MiniAppSheetHostConfig.Companion.from(r11, r12), null).show(r13, r14);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[MiniAppSheetHeightMode.values().length];
            r0[MiniAppSheetHeightMode.WRAP_CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ MiniAppSheetHost(Activity r1, AppletRuntime r2, PageInfo r3, MiniAppSheetHostConfig r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ void a(MiniAppSheetHost r0, DialogInterface r1) {
        show$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit b(MiniAppSheetHost r0, int r1) {
        return show$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit c(Function1 r0, MiniAppSheetHost r1, String r2) {
        return show$startCreatePageIfNeeded$lambda$6$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(AtomicBoolean r0, MiniAppSheetHost r1, AtomicBoolean r2, AtomicBoolean r3, MiniAppLynxSheetPage r4, Function1 r5, Integer r6) {
        return show$startCreatePageIfNeeded$lambda$6$lambda$4(r0, r1, r2, r3, r4, r5, r6);
    }

    private final void handleDismiss() {
        if (this.destroyed.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        FLogger.a.i("MiniAppSheetHost", "handleDismiss, page=" + this.pageInfo.getPageName());
        View r0 = this.bodyContainer.findFocus();
        if (r0 == null) goto L8;
        r0.clearFocus();
    L8:
        this.bodyContainer.clearFocus();
        MiniAppLynxSheetPage r1 = this.page;
        MiniAppSheetRegistry r2 = MiniAppSheetRegistry.INSTANCE;
        if (r1 == null) goto L11;
        String r3 = r1.getPageID();
    L12:
        r2.unregister(r3);
        MiniAppSheetCloseMethodImpl r4 = this.closeMethodImpl;
        if (r4 == null) goto L16;
        r4.restore();
    L16:
        if (this.pageVisible == false) goto L19;
        if (r1 == null) goto L19;
        r1.onHide();
    L19:
        if (r1 == null) goto L21;
        r1.onHostDestroy();
    L21:
        if (r1 == null) goto L23;
        r1.onDestroy();
    L23:
        this.page = null;
        this.closeMethodImpl = null;
        return;
    L11:
        r3 = null;
        goto L12
    }

    public final void dismiss() {
        if (this.destroyed.get() == false) goto L5;
        return;
    L5:
        FLogger.a.i("MiniAppSheetHost", "dismiss requested, page=" + this.pageInfo.getPageName());
        View r0 = this.bodyContainer.findFocus();
        if (r0 == null) goto L8;
        r0.clearFocus();
    L8:
        this.bodyContainer.clearFocus();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHost_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.sheet);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final String viewId() {
        MiniAppLynxSheetPage r0 = this.page;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPageID();
    }

    public static void INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHost_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(OSheet r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHost_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(OSheet r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    private final void updateBodyHeight(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        MiniAppSheetHeightMode r0 = this.config.getHeightMode();
        if (r0 != null) goto L7;
        int r1 = -1;
    L9:
        if (r1 != 1) goto L11;
        int r4 = RangesKt.coerceAtMost(r3, this.config.maxHeightPx(this.activity));
    L12:
        ViewGroup.LayoutParams r2 = this.bodyContainer.getLayoutParams();
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.height != r4) goto L18;
        return;
    L18:
        r2.height = r4;
        this.bodyContainer.setLayoutParams(r2);
        this.bodyContainer.requestLayout();
        return;
    L11:
        r4 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r3, this.config.minHeightPx(this.activity)), this.config.maxHeightPx(this.activity));
        goto L12
    L7:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L9
    }

    public final boolean activityMatches(Activity r2) {
        if (r2 != null) goto L4;
    L7:
        return true;
    L4:
        if (r2 == this.activity) goto L7;
        return false;
    }

    private static final void show$lambda$1(MiniAppSheetHost r0, DialogInterface r1) {
        r0.handleDismiss();
    }

    private static final Unit show$lambda$2(MiniAppSheetHost r1, int r2) {
        if (r1.config.shouldTrackContentHeight() == false) goto L6;
        r1.updateBodyHeight(r2);
    L6:
        return Unit.INSTANCE;
    }

    public final void show(final Function1<? super String, Unit> r19, final Function1<? super String, Unit> r20) {
        Intrinsics.checkNotNullParameter(r19, "onSuccess");
        Intrinsics.checkNotNullParameter(r20, "onFailure");
        this.config.applyTo(this.sheet, this.bodyContainer, this.activity);
        OSheet r0 = this.sheet;
        FrameLayout r1 = this.bodyContainer;
        r0.getClass();
        OSheetBase.DefaultImpls.j(r0, r1);
        this.sheet.setOnDismissListener(new h(this));
        final MiniAppLynxSheetPage r13 = new MiniAppLynxSheetPage(this.appletRuntime, this.pageInfo, this.bodyContainer, this.config.contentLayoutHeight(), new i(this));
        this.page = r13;
        MiniAppSheetCloseMethodImpl r2 = new MiniAppSheetCloseMethodImpl(this);
        r2.install();
        this.closeMethodImpl = r2;
        r13.warmUp();
        final AtomicBoolean r14 = new AtomicBoolean(false);
        final AtomicBoolean r15 = new AtomicBoolean(false);
        final AtomicBoolean r9 = new AtomicBoolean(false);
        final AtomicBoolean r8 = new AtomicBoolean(false);
        OSheet r3 = this.sheet;
        r3.t = new AnonymousClass3(this, r14, r13, r15, r9, r8, r19, r20);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHost_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.sheet);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L19;
        this.page = null;
        MiniAppSheetCloseMethodImpl r6 = this.closeMethodImpl;
        if (r6 == null) goto L12;
        r6.restore();
    L12:
        this.closeMethodImpl = null;
        r13.onHostDestroy();
        r13.onDestroy();
        Throwable r7 = Result.exceptionOrNull-impl(r5);
        if (r7 == null) goto L16;
        String r10 = r7.getMessage();
        if (r10 == null) goto L16;
    L17:
        r20.invoke(r10);
        return;
    L16:
        r10 = "show sheet failed";
        goto L17
    L19:
        this.config.applyWindowTo(this.sheet, this.activity);
        show$startCreatePageIfNeeded(this, r14, r13, r15, r9, r8, r19, r20);
        return;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    private static final Unit show$startCreatePageIfNeeded$lambda$6$lambda$5(Function1 r1, MiniAppSheetHost r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        r1.invoke(r3);
        r2.dismiss();
        return Unit.INSTANCE;
    }

    private MiniAppSheetHost(Activity r2, AppletRuntime r3, PageInfo r4, MiniAppSheetHostConfig r5) {
        this.activity = r2;
        this.appletRuntime = r3;
        this.pageInfo = r4;
        this.config = r5;
        FrameLayout r6 = new FrameLayout(r2);
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, r5.initialBodyHeight(r2)));
        this.bodyContainer = r6;
        this.sheet = c1.a(r2, 0);
        this.destroyed = new AtomicBoolean(false);
    }

    public static final /* synthetic */ void access$show$dispatchReadyIfNeeded(MiniAppSheetHost r0, AtomicBoolean r1, AtomicBoolean r2, AtomicBoolean r3, MiniAppLynxSheetPage r4, Function1 r5) {
        show$dispatchReadyIfNeeded(r0, r1, r2, r3, r4, r5);
    }

    private static final void show$dispatchReadyIfNeeded(MiniAppSheetHost r1, AtomicBoolean r2, AtomicBoolean r3, AtomicBoolean r4, MiniAppLynxSheetPage r5, Function1<? super String, Unit> r6) {
        if (r1.destroyed.get() == false) goto L5;
        return;
    L5:
        if (r2.get() == true) goto L7;
        return;
    L7:
        if (r3.get() == true) goto L10;
        return;
    L10:
        if (r4.compareAndSet(false, true) == true) goto L12;
        return;
    L12:
        r1.pageVisible = true;
        MiniAppSheetRegistry.INSTANCE.register(r1);
        r5.onShow();
        r6.invoke(r5.getPageID());
    }

    private static final Unit show$startCreatePageIfNeeded$lambda$6$lambda$4(AtomicBoolean r6, MiniAppSheetHost r7, AtomicBoolean r8, AtomicBoolean r9, MiniAppLynxSheetPage r10, Function1 r11, Integer r12) {
        r6.set(true);
        show$dispatchReadyIfNeeded(r7, r6, r8, r9, r10, r11);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$show$startCreatePageIfNeeded(MiniAppSheetHost r0, AtomicBoolean r1, MiniAppLynxSheetPage r2, AtomicBoolean r3, AtomicBoolean r4, AtomicBoolean r5, Function1 r6, Function1 r7) {
        show$startCreatePageIfNeeded(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    private static final void show$startCreatePageIfNeeded(final MiniAppSheetHost r12, AtomicBoolean r13, final MiniAppLynxSheetPage r14, final AtomicBoolean r15, final AtomicBoolean r16, final AtomicBoolean r17, final Function1<? super String, Unit> r18, final Function1<? super String, Unit> r19) {
        if (r12.destroyed.get() == false) goto L5;
        return;
    L5:
        if (r13.compareAndSet(false, true) == false) goto L22;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(r14.createPage(r12.pageInfo, r12.activity, new j(r15, r12, r16, r17, r14, r18), new k(r19, r12)));     // Catch: Throwable -> L9
    L11:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L21;
        String r3 = r2.getMessage();
        if (r3 != null) goto L16;
        r3 = "create sheet page failed";
    L16:
        r19.invoke(r3);
        r12.dismiss();
        return;
    L21:
        return;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
