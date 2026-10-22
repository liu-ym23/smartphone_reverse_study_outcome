package com.larus.bmhome.chat.tips;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.common_ui.popupwindow.AutoOffsetPopupWindow;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wa8.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0016J\u001e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cH\u0016J×\u0001\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001c2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012\u0018\u00010+2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001c2\b\u0010/\u001a\u0004\u0018\u00010\r2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020:H\u0016J\n\u0010;\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0012H\u0002J\b\u0010>\u001a\u00020\rH\u0002J\u0012\u0010?\u001a\u00020\u00072\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010@\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010A\u001a\u00020\u0012H\u0016J\u0012\u0010B\u001a\u0002032\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0002J\u0012\u0010C\u001a\u00020\r2\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0002J\u0012\u0010D\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010E\u001a\u00020\u00072\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0002J\u0012\u0010F\u001a\u00020\u00072\b\b\u0001\u0010\u0013\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/bmhome/chat/tips/GuideTipsService;", "Lcom/larus/bmhome/chat/tips/IGuideTipsService;", "<init>", "()V", "tipsRepo", "Lcom/bytedance/keva/Keva;", "coldLaunchActionBarHasShowTip", "", "isShowing", "disableShowTips", "currentPopupWindow", "Landroid/widget/PopupWindow;", "currentTipType", "", "currentTipsPriorityQueue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "registerTip", "", "tipType", "priority", "enableTips", "enable", "canShowTip", "showDialog", "tip", "Lcom/larus/bmhome/chat/tips/GuideTip;", "showDialogAction", "Lkotlin/Function0;", "showTip", "context", "Landroid/content/Context;", "anchorView", "Landroid/view/View;", "startMargin", "endMargin", "indicatorSpace", "windowGravity", "Lcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;", "shadowSpace", "popYOff", "onShow", "onDismiss", "Lkotlin/Function1;", "indicatorMarginLeft", "indicatorMarginRight", "onContentClick", "absoluteVerticalDistance", "isCloseCenter", "isRemoveDescMargin", "textColorString", "", "forceShow", "needIndicator", "descTvMaxWidth", "(Landroid/content/Context;Lcom/larus/bmhome/chat/tips/GuideTip;Landroid/view/View;IIILcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;IILkotlin/jvm/functions/Function0;Ljava/lang/Integer;ZZLjava/lang/String;ZZLjava/lang/Integer;)Z", "getGuideTipType", "data", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "getDebugGuideTipRepo", "getDebugColdLaunchActionBarHasShowTip", "resetConfig", "getCurrentPriority", "isGuideTipShown", "dismissTip", "clearMemoryGuideRedDot", "getGuideTipsKey", "getPriority", "setGuideTipsShown", "forbiddenShowActionBarTip", "isActionBarTip", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GuideTipsService implements IGuideTipsService {
    public static final /* synthetic */ int h = 0;
    public final Keva a;
    public boolean b;
    public boolean c;
    public boolean d;
    public PopupWindow e;
    public int f;
    public final PriorityQueue<Pair<Integer, Integer>> g;

    public static final class a implements com.larus.platform.api.b {
        public final /* synthetic */ GuideTipsService a;

        public a(GuideTipsService r1) {
            this.a = r1;
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a.c = false;
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a.c = false;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Comparable) ((Pair) r2).getSecond(), (Comparable) ((Pair) r1).getSecond());
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final void d() {
        if (this.f == 8) goto L15;
        return;
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        PopupWindow r2 = this.e;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);     // Catch: Throwable -> L11
        r2.dismiss();     // Catch: Throwable -> L11
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r3);     // Catch: Throwable -> L11
    L13:
        this.c = false;
        this.e = null;
        this.f = -1;
        return;
    L8:
        r3 = null;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public GuideTipsService() {
        this.a = Keva.getRepo("repo_tips_guide", 0);
        this.f = -1;
        this.g = new PriorityQueue(10, new c());
        AccountService.a.E(new a(this));
    }

    public static int i(@GuideTipType int r1) {
        Integer r2 = (Integer) ((LinkedHashMap) com.larus.bmhome.chat.tips.a.e.getValue()).get(Integer.valueOf(r1));
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final void b(@GuideTipType int r5) {
        if (r5 != 0) goto L5;
        com.larus.bmhome.instruction.c r1 = com.larus.bmhome.instruction.c.a;
        ((Keva) com.larus.bmhome.instruction.c.b.getValue()).storeBoolean("deep_think_action_bar_tip", true);
    L5:
        this.a.storeBoolean("guide_tips_is_shown_" + r5, true);
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean c(@GuideTipType int r9) {
        boolean r2 = false;
        if (r9 < 0) goto L67;
        if (r9 == 0) goto L67;
        if (this.d == false) goto L11;
        FLogger.a.i("GuideTipsService", "tipType:" + r9 + ", canShowTip:false, disableShowTips");
        return false;
    L11:
        if (r9 != 9999) goto L15;
        FLogger.a.d("GuideTipsService", "tipType:" + r9 + ", canShowTip:true, FORCE_SHOW type");
        return true;
    L15:
        if (f(r9) == false) goto L18;
        FLogger.a.d("GuideTipsService", "tipType:" + r9 + ", canShowTip:false, isGuideTipShown(tipType)");
        return false;
    L18:
        int r3 = i(r9);
        PriorityQueue<Pair<Integer, Integer>> r5 = this.g;
        if ((r5 instanceof Collection) == true) goto L21;
    L23:
        Iterator<Pair<Integer, Integer>> r6 = r5.iterator();
    L25:
        if (r6.hasNext() == false) goto L32;
        if (((Number) r6.next().getFirst()).intValue() != r9) goto L29;
        boolean r7 = true;
    L30:
        if (r7 == false) goto L25;
        boolean r8 = true;
    L33:
        if (r8 == true) goto L36;
        this.g.offer(new Pair(Integer.valueOf(r9), Integer.valueOf(r3)));
    L36:
        if (r9 == 0) goto L40;
        if (r9 == 1) goto L40;
        boolean r4 = false;
    L41:
        if (r4 == true) goto L43;
    L45:
        FLogger.a.d("GuideTipsService", "tipType:" + r9 + ", can forbiddenShowActionBarTip false");
        boolean r10 = false;
    L46:
        if (r10 == false) goto L50;
        FLogger.a.d("GuideTipsService", "tipType:" + r9 + ", canShowTip:false, forbiddenShowActionBarTip(tipType)");
        return false;
    L50:
        if (this.c == false) goto L52;
    L65:
        FLogger.a.d("GuideTipsService", "tipType:" + r9 + ", canShowTip:false, isShowing");
        return false;
    L52:
        if (jo8.b.a == true) goto L65;
        int r11 = i(r9);
        Iterator<Pair<Integer, Integer>> r12 = this.g.iterator();
    L56:
        if (r12.hasNext() == false) goto L60;
        Pair<Integer, Integer> r13 = r12.next();
        if (f(((Number) r13.getFirst()).intValue()) == true) goto L56;
        int r14 = ((Number) r13.getSecond()).intValue();
    L61:
        if (r11 < r14) goto L63;
        r2 = true;
    L63:
        FLogger.a.d("GuideTipsService", "tipType:" + r9 + ", canShowTip:" + r2 + ", result");
        return r2;
    L60:
        r14 = 0;
        goto L61
    L43:
        if (this.b == false) goto L45;
        FLogger.a.d("GuideTipsService", "tipType:" + r9 + ", can forbiddenShowActionBarTip true");
        r10 = true;
    L40:
        r4 = true;
        goto L41
    L29:
        r7 = false;
    L32:
        r8 = false;
        goto L33
    L21:
        if (r5.isEmpty() == false) goto L23;
    L67:
        FLogger.a.d("GuideTipsService", "tipType:" + r9 + ", canShowTip:false, tipType < 0");
        return false;
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final void e(boolean r1) {
        this.d = !r1;
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean f(@GuideTipType int r5) {
        if (r5 != 0) goto L10;
        com.larus.bmhome.instruction.c r1 = com.larus.bmhome.instruction.c.a;
        if (((Keva) com.larus.bmhome.instruction.c.b.getValue()).getBoolean("deep_think_action_bar_tip", false) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.a.contains("guide_tips_is_shown_" + r5) == true) goto L8;
        return false;
    L10:
        return this.a.contains("guide_tips_is_shown_" + r5);
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final int h(z0 r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        r r0 = r5.q;
        boolean r2 = false;
        if (r0 == null) goto L10;
        Integer r1 = r0.a;
        if (r1 == null) goto L10;
        if (r1.intValue() != 21) goto L10;
        r2 = true;
    L10:
        if (r2 == false) goto L13;
        return 1;
    L13:
        if (k1.c(r5) == false) goto L15;
        return 8;
    L15:
        return -1;
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean g(com.larus.bmhome.chat.tips.a r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "tip");
        Intrinsics.checkNotNullParameter(r4, "showDialogAction");
        if (c(r3.a) == true) goto L6;
        FLogger.a.d("GuideTipsService", "can not show tip: " + r3);
        return false;
    L6:
        r4.invoke();
        this.c = true;
        return true;
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean a(Context r30, com.larus.bmhome.chat.tips.a r31, View r32, int r33, int r34, int r35, AutoOffsetPopupWindow.WindowGravity r36, int r37, int r38, Function0<Unit> r39, Function1<? super Boolean, Unit> r40, int r41, int r42, Function0<Unit> r43, Integer r44, boolean r45, boolean r46, String r47, boolean r48, boolean r49, Integer r50) {
        Intrinsics.checkNotNullParameter(r30, "context");
        Intrinsics.checkNotNullParameter(r31, "tip");
        Intrinsics.checkNotNullParameter(r32, "anchorView");
        Intrinsics.checkNotNullParameter(r36, "windowGravity");
        Intrinsics.checkNotNullParameter(r47, "textColorString");
        boolean r28 = false;
        if (c(r31.a) == true) goto L7;
        if (r48 == true) goto L7;
        FLogger.a.d("GuideTipsService", "can not show tip: " + r31);
        return false;
    L7:
        int r2 = AutoOffsetPopupWindow.a;
        final PopupWindow r3 = AutoOffsetPopupWindow.a(r30, r32, r31.b, null, r31.c, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, null, r44, r45, r46, null, 0, r47, r49, r50, 7405576);
        this.e = r3;
        this.f = r31.a;
        long r4 = r31.d;
        if (r4 > 0) goto L12;
        r4 = z2.a.deepThinkActionBarTipDismissDuration();
    L12:
        if (r4 <= 0) goto L14;
        r32.postDelayed(new jo8.c(r3, this), r4);
    L14:
        b(r31.a);
        int r1 = r31.a;
        if (r1 == 0) goto L17;
        if (r1 == 1) goto L17;
    L18:
        if (r28 == false) goto L20;
        this.b = true;
    L20:
        this.c = true;
        return true;
    L17:
        r28 = true;
        goto L18
    }
}
