package com.larus.bmhome.chat.tips;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.common_ui.popupwindow.AutoOffsetPopupWindow;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\u0013\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0001J\t\u0010\r\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\u0014\u001a\u00020\t2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0096\u0001JØ\u0001\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00192\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00192\b\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0002\u00104¨\u00065"}, d2 = {"Lcom/larus/bmhome/chat/tips/GuideTipsDelegate;", "Lcom/larus/bmhome/chat/tips/IGuideTipsService;", "<init>", "()V", "canShowTip", "", "tipType", "", "clearMemoryGuideRedDot", "", "dismissTip", "enableTips", "enable", "getDebugColdLaunchActionBarHasShowTip", "getDebugGuideTipRepo", "Lcom/bytedance/keva/Keva;", "getGuideTipType", "data", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "isGuideTipShown", "setGuideTipsShown", "showDialog", "tip", "Lcom/larus/bmhome/chat/tips/GuideTip;", "showDialogAction", "Lkotlin/Function0;", "showTip", "context", "Landroid/content/Context;", "anchorView", "Landroid/view/View;", "startMargin", "endMargin", "indicatorSpace", "windowGravity", "Lcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;", "shadowSpace", "popYOff", "onShow", "onDismiss", "Lkotlin/Function1;", "indicatorMarginLeft", "indicatorMarginRight", "onContentClick", "absoluteVerticalDistance", "isCloseCenter", "isRemoveDescMargin", "textColorString", "", "forceShow", "needIndicator", "descTvMaxWidth", "(Landroid/content/Context;Lcom/larus/bmhome/chat/tips/GuideTip;Landroid/view/View;IIILcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;IILkotlin/jvm/functions/Function0;Ljava/lang/Integer;ZZLjava/lang/String;ZZLjava/lang/Integer;)Z", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GuideTipsDelegate implements IGuideTipsService {
    public static final GuideTipsDelegate b = null;
    public final /* synthetic */ IGuideTipsService a;

    static {
        b = new GuideTipsDelegate();
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean a(Context r24, a r25, View r26, int r27, int r28, int r29, AutoOffsetPopupWindow.WindowGravity r30, int r31, int r32, Function0<Unit> r33, Function1<? super Boolean, Unit> r34, int r35, int r36, Function0<Unit> r37, Integer r38, boolean r39, boolean r40, String r41, boolean r42, boolean r43, Integer r44) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "tip");
        Intrinsics.checkNotNullParameter(r26, "anchorView");
        Intrinsics.checkNotNullParameter(r30, "windowGravity");
        Intrinsics.checkNotNullParameter(r41, "textColorString");
        return this.a.a(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44);
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final void b(@GuideTipType int r2) {
        this.a.b(1);
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean c(@GuideTipType int r2) {
        return this.a.c(r2);
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final void d() {
        this.a.d();
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final void e(boolean r2) {
        this.a.e(r2);
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean f(@GuideTipType int r2) {
        return this.a.f(8);
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final boolean g(a r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "tip");
        Intrinsics.checkNotNullParameter(r3, "showDialogAction");
        return this.a.g(r2, r3);
    }

    @Override // com.larus.bmhome.chat.tips.IGuideTipsService
    public final int h(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.a.h(r2);
    }

    private GuideTipsDelegate() {
        IGuideTipsService r0 = (IGuideTipsService) ServiceManager.get().getService(IGuideTipsService.class);
        if (r0 != null) goto L5;
        r0 = new GuideTipsServiceNoop();
    L5:
        this.a = r0;
    }
}
