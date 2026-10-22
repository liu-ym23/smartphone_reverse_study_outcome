package com.ss.android.lark.chat.cot.detail;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.biz.im.extension.panel.drag.DragPanel;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.cot.CotTracker;
import com.ss.android.lark.chat.cot.CotViewModel;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter$Companion$DIFF_CALLBACK$1;
import com.ss.android.lark.chat.cot.entry.CotEntryView;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.m0;
import com.ss.android.lark.widget.textview.ShineTextView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0001ABQ\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u0010H\u0002J\b\u00102\u001a\u00020\u0010H\u0002J\u0010\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020+H\u0002J\b\u00105\u001a\u00020\u0010H\u0002J\b\u00106\u001a\u00020\u0010H\u0002J\b\u00107\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\nH\u0002J\b\u0010:\u001a\u00020\u0010H\u0002J\b\u0010;\u001a\u00020\u0010H\u0002J\b\u0010<\u001a\u00020\u0010H\u0002J\u0010\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/CotDetailSheet;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "anchorView", "Landroid/view/View;", "messageId", BuildConfig.FLAVOR, "chatId", "cotViewModel", "Lcom/ss/android/lark/chat/cot/CotViewModel;", "cotFeatureGate", "Lcom/ss/android/lark/chat/cot/CotFeatureGate;", "botId", "onConfirmStop", "Lkotlin/Function0;", BuildConfig.FLAVOR, "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/cot/CotViewModel;Lcom/ss/android/lark/chat/cot/CotFeatureGate;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "isDisplayUpgradeEnabled", BuildConfig.FLAVOR, "viewModel", "Lcom/ss/android/lark/chat/cot/detail/CotDetailViewModel;", "expandStore", "Lcom/ss/android/lark/chat/cot/detail/CotDetailExpandStore;", "contentController", "Lcom/ss/android/lark/chat/cot/detail/CotDetailContentController;", "panel", "Lcom/ss/android/lark/biz/im/extension/panel/drag/DragPanel;", "stopConfirmDialog", "Lcom/larksuite/component/ui/dialog/LKUIDialog;", "stateJob", "Lkotlinx/coroutines/Job;", "pushJob", "scope", "Lkotlinx/coroutines/CoroutineScope;", "latestTitle", "pushListener", "Lcom/ss/android/lark/biz/im/api/IPushMessageListener;", "pushFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/chat/entity/message/CotContent;", "lastSubmittedState", "Lcom/ss/android/lark/chat/cot/detail/CotDetailUiState;", "released", "closeTracked", "resolveStepName", "item", "Lcom/ss/android/lark/chat/cot/detail/CotDetailItem;", "open", "observeData", ChameleonOpenTracker.Stage.RENDER, "state", "subscribePush", "fetchLatestAndSubmit", "unsubscribePush", "calculateTitle", "model", "showStopConfirmDialog", "sendStopCommand", "release", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "trackCloseIfNeeded", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotDetailSheet implements DefaultLifecycleObserver {
    public static final /* synthetic */ int v = 0;
    public final FragmentActivity a;
    public final View b;
    public final String c;
    public final String d;
    public final CotViewModel e;
    public final String f;
    public final Function0<Unit> g;
    public final r h;
    public final j i;
    public final c j;
    public DragPanel k;
    public LKUIDialog l;
    public Job m;
    public Job n;
    public final CoroutineScope o;
    public String p;
    public o q;
    public final MutableSharedFlow<CotContent> r;
    public q s;
    public boolean t;
    public boolean u;

    public static final class a {
        @JvmStatic
        public static void a(FragmentActivity r23, CotEntryView r24, String r25, String r26, CotViewModel r27, com.ss.android.lark.chat.cot.a r28, String r29, Function0 r30) {
            Intrinsics.checkNotNullParameter(r23, "activity");
            Intrinsics.checkNotNullParameter(r24, "anchorView");
            Intrinsics.checkNotNullParameter(r25, "messageId");
            Intrinsics.checkNotNullParameter(r26, "chatId");
            Intrinsics.checkNotNullParameter(r27, "cotViewModel");
            Intrinsics.checkNotNullParameter(r28, "cotFeatureGate");
            Intrinsics.checkNotNullParameter(r29, "botId");
            if (r23.isFinishing() == false) goto L5;
        L35:
            Log.w("CotDetailSheet", "activity not available, skip show");
            return;
        L5:
            if (r23.isDestroyed() == true) goto L35;
            Lazy r1 = CotTracker.a;
            String r2 = r27.getCotId();
            Intrinsics.checkNotNullParameter(r2, "cotId");
            Intrinsics.checkNotNullParameter(r25, "msgId");
            Intrinsics.checkNotNullParameter(r26, "chatId");
            CotTracker.b(r2, r25, r26, "expand");
            final CotDetailSheet r14 = new CotDetailSheet(r23, r24, r25, r26, r27, r28, r29, r30);
            if (m0.b(r23) == false) goto L10;
            int r0 = m0.a(r23);
        L11:
            com.ss.android.lark.biz.im.extension.panel.drag.g r5 = new com.ss.android.lark.biz.im.extension.panel.drag.g(new com.ss.android.lark.biz.im.extension.panel.drag.n(new com.ss.android.lark.biz.im.extension.panel.drag.h(0.9f)), new com.ss.android.lark.biz.im.extension.panel.drag.l(h18.d.a(r23, 10.0f), r0));
            m r3 = new m(r14);
            StringBuilder r4 = new StringBuilder("open detail sheet, messageId=");
            r4.append(r25);
            r4.append(", chatId=");
            r4.append(r26);
            r4.append(", cotId=");
            r4.append(r27.getCotId());
            r4.append(", status=");
            r4.append(r27.getOverallStatus());
            r4.append(", hasConfirmStop=");
            boolean r16 = true;
            if (r30 == null) goto L14;
            boolean r6 = true;
        L15:
            r4.append(r6);
            com.ss.android.lark.chat.cot.f.c("detail_stop_visibility", r4.toString());
            if (r30 != null) goto L18;
            Function0<Unit> r7 = null;
        L19:
            r14.j.k = r7;
            DragPanel r8 = new DragPanel(r23, r23, r3, r14.j, r5);
            r14.k = r8;
            l r9 = new l(r14);
            Intrinsics.checkNotNullParameter(r9, "listener");
            r8.n.add(r9);
            r23.getLifecycle().addObserver(r14);
            r14.p = r14.c(r27);
            com.ss.android.lark.chat.cot.f.c("detail_open_snapshot", "messageId=" + r25 + ", chatId=" + r26 + ", cotId=" + r27.getCotId() + ", blocks=" + r27.getBlocks().size() + ", status=" + r27.getOverallStatus());
            r r10 = r14.h;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r27, "viewModel");
            r10.b.setValue(r10.a(r27));
            r14.s = (q) r14.h.c.getValue();
            r14.m = BuildersKt.launch$default(r14.o, null, null, new CotDetailSheet$observeData$1(r14, null), 3, null);
            if (r25.length() != 0) goto L22;
            boolean r11 = true;
        L23:
            if (r11 == false) goto L25;
            Log.i("CotDetailSheet", "messageId is empty, live refresh disabled (snapshot only)");
        L27:
            if (r25.length() == 0) goto L30;
            r16 = false;
        L30:
            if (r16 == true) goto L33;
            ImSdkService.f().Fe(CollectionsKt.listOf(r25), new CotDetailSheet$fetchLatestAndSubmit$1(r14));
        L33:
            r8.g();
            return;
        L25:
            r14.n = BuildersKt.launch$default(r14.o, null, null, new CotDetailSheet$subscribePush$1(r14, null), 3, null);
            o r12 = new o(r14);
            r14.q = r12;
            ImSdkService.e().gc(r12);
            com.ss.android.lark.chat.cot.f.c("detail_subscribe", "cot live refresh subscribed, messageId=".concat(r25));
            goto L27
        L22:
            r11 = false;
            goto L23
        L18:
            r7 = new CotDetailSheet$open$stopClickListener$1(r14);
            goto L19
        L14:
            r6 = false;
            goto L15
        L10:
            r0 = 0;
            goto L11
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotDetailBlockType.values().length];
            r0[CotDetailBlockType.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CotDetailBlockType.TOOLCALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public CotDetailSheet() {
        throw null;
    }

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public final /* synthetic */ void onStop(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
    }

    public final void d() {
        if (this.t == false) goto L5;
        return;
    L5:
        this.t = true;
        if (this.u == true) goto L9;
        this.u = true;
        Lazy r1 = CotTracker.a;
        String r2 = this.e.getCotId();
        String r3 = this.c;
        String r4 = this.d;
        Intrinsics.checkNotNullParameter(r2, "cotId");
        Intrinsics.checkNotNullParameter(r3, "msgId");
        Intrinsics.checkNotNullParameter(r4, "chatId");
        CotTracker.b(r2, r3, r4, "collapse");
    L9:
        o r5 = this.q;
        if (r5 == null) goto L12;
        ImSdkService.e().O3(r5);
        com.ss.android.lark.chat.cot.f.c("detail_subscribe", "cot live refresh unsubscribed, messageId=" + this.c);
    L12:
        this.q = null;
        Job r6 = this.n;
        if (r6 == null) goto L15;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L15:
        this.n = null;
        CoroutineScopeKt.cancel$default(this.o, null, 1, null);
        LKUIDialog r7 = this.l;
        if (r7 == null) goto L18;
        a(r7);
    L18:
        this.l = null;
        c r8 = this.j;
        InvalidDecorationObserver r9 = r8.l;
        if (r9 == null) goto L23;
        CotDetailBlueprintAdapter r10 = r8.j;
        if (r10 == null) goto L23;
        r10.unregisterAdapterDataObserver(r9);
    L23:
        r8.l = null;
        RecyclerView r11 = r8.g;
        if (r11 == null) goto L32;
        CotStepExposureTracker r12 = r8.n;
        if (r12 == null) goto L28;
        r12.e = false;
        r12.b();
        r12.a.removeOnScrollListener(r12.i);
        r12.a.removeOnChildAttachStateChangeListener(r12.j);
        r12.d.clear();
    L28:
        CotDetailContentController$setupStepTracking$2 r13 = r8.o;
        if (r13 == null) goto L31;
        r11.removeOnItemTouchListener(r13);
    L31:
        r11.setAdapter(null);
    L32:
        RecyclerView r14 = r8.g;
        if (r14 == null) goto L44;
        ViewTreeObserver r15 = r14.getViewTreeObserver();
        if (r15 == null) goto L44;
        if (r15.isAlive() == true) goto L40;
        r15 = null;
    L40:
        if (r15 == null) goto L44;
        g r16 = r8.m;
        if (r16 == null) goto L44;
        r15.removeOnGlobalLayoutListener(r16);
    L44:
        r8.g = null;
        CotDetailBlueprintAdapter r17 = r8.j;
        if (r17 == null) goto L47;
        List r18 = CollectionsKt.emptyList();
        CotDetailBlueprintAdapter$Companion$DIFF_CALLBACK$1 r19 = CotDetailBlueprintAdapter.d;
        Intrinsics.checkNotNullParameter(r18, "list");
        r17.c.submitList(r18, null);
    L47:
        r8.j = null;
        ShineTextView r20 = r8.h;
        if (r20 == null) goto L50;
        r20.x();
    L50:
        r8.h = null;
        r8.i = null;
        r8.m = null;
        r8.n = null;
        r8.o = null;
        r8.p = null;
        r8.q = false;
        r8.s = null;
        r8.r = true;
        r8.k = null;
        r8.f = null;
        this.h.b.setValue(q.d);
        this.i.a.clear();
        this.s = null;
        this.a.getLifecycle().removeObserver(this);
        this.k = null;
    }

    public static void a(LKUIDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final String c(CotViewModel r4) {
        String r0 = com.ss.android.lark.chat.cot.h.c(r4);
        CharSequence r1 = null;
        if (r0 != null) goto L5;
    L9:
        CharSequence r2 = com.ss.android.lark.chat.cot.h.a(r4);
        if (r2 == null) goto L17;
        if ((!StringsKt.isBlank(r2)) == false) goto L14;
        r1 = r2;
    L14:
        if (r1 == null) goto L17;
        return r1.toString();
    L17:
        return com.ss.android.lark.chat.cot.h.b(r4, this.a);
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L9;
        return r0;
    }

    public final void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        DragPanel r3 = this.k;
        if (r3 == null) goto L5;
        r3.c();
    L5:
        d();
    }

    public static final String b(CotDetailSheet r2, k r3) {
        r2.getClass();
        int r4 = b.a[r3.b.ordinal()];
        if (r4 != 1) goto L5;
        return "Lark_IM_AgentCot_CalledToolTime_Text";
    L5:
        if (r4 != 2) goto L12;
        String r5 = r3.c;
        if (r5 == null) goto L12;
        if ((!StringsKt.isBlank(r5)) == false) goto L12;
        return r5;
    L12:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CotDetailSheet(FragmentActivity r7, CotEntryView r8, String r9, String r10, CotViewModel r11, com.ss.android.lark.chat.cot.a r12, String r13, Function0 r14) {
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r13;
        this.g = r14;
        if (r12.a.isEnable("lark.im.agent.cot_message") == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.h = new r(r3);
        j r1 = new j();
        this.i = r1;
        this.j = new c(r1, r12, r3, new CotDetailSheet$contentController$1(this), new CotDetailSheet$contentController$2(this));
        this.o = CoroutineScopeKt.MainScope();
        this.r = SharedFlowKt.MutableSharedFlow(1, 1, BufferOverflow.DROP_OLDEST);
        return;
    L5:
        if (r12.a.isEnable("lark.im.agent.cot_display_upgrade") == false) goto L7;
        r3 = true;
        goto L8
    }
}
