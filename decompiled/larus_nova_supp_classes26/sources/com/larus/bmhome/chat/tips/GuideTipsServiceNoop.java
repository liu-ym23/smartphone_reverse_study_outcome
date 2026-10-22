package com.larus.bmhome.chat.tips;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.common_ui.popupwindow.AutoOffsetPopupWindow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J×\u0001\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a2\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020\u0005H\u0016¨\u00065"}, d2 = {"Lcom/larus/bmhome/chat/tips/GuideTipsServiceNoop;", "Lcom/larus/bmhome/chat/tips/IGuideTipsService;", "<init>", "()V", "enableTips", "", "enable", "", "canShowTip", "tipType", "", "showTip", "context", "Landroid/content/Context;", "tip", "Lcom/larus/bmhome/chat/tips/GuideTip;", "anchorView", "Landroid/view/View;", "startMargin", "endMargin", "indicatorSpace", "windowGravity", "Lcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;", "shadowSpace", "popYOff", "onShow", "Lkotlin/Function0;", "onDismiss", "Lkotlin/Function1;", "indicatorMarginLeft", "indicatorMarginRight", "onContentClick", "absoluteVerticalDistance", "isCloseCenter", "isRemoveDescMargin", "textColorString", "", "forceShow", "needIndicator", "descTvMaxWidth", "(Landroid/content/Context;Lcom/larus/bmhome/chat/tips/GuideTip;Landroid/view/View;IIILcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;IILkotlin/jvm/functions/Function0;Ljava/lang/Integer;ZZLjava/lang/String;ZZLjava/lang/Integer;)Z", "showDialog", "showDialogAction", "getGuideTipType", "data", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "setGuideTipsShown", "getDebugGuideTipRepo", "Lcom/bytedance/keva/Keva;", "getDebugColdLaunchActionBarHasShowTip", "isGuideTipShown", "dismissTip", "clearMemoryGuideRedDot", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GuideTipsServiceNoop implements IGuideTipsService {
    public GuideTipsServiceNoop() {
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean a(Context r3, a r4, View r5, int r6, int r7, int r8, AutoOffsetPopupWindow.WindowGravity r9, int r10, int r11, Function0<Unit> r12, Function1<? super Boolean, Unit> r13, int r14, int r15, Function0<Unit> r16, Integer r17, boolean r18, boolean r19, String r20, boolean r21, boolean r22, Integer r23) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "tip");
        Intrinsics.checkNotNullParameter(r5, "anchorView");
        Intrinsics.checkNotNullParameter(r9, "windowGravity");
        Intrinsics.checkNotNullParameter(r20, "textColorString");
        return false;
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final void b(int r1) {
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean c(int r1) {
        return false;
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final void d() {
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final void e(boolean r1) {
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean f(int r1) {
        return false;
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean g(a r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "tip");
        Intrinsics.checkNotNullParameter(r3, "showDialogAction");
        return false;
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final int h(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return 0;
    }
}
