package com.larus.bmhome.chat.tips;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.common_ui.popupwindow.AutoOffsetPopupWindow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH&Jñ\u0001\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H&J\u0010\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020+H&J\u0012\u0010,\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH&J\n\u0010-\u001a\u0004\u0018\u00010.H&J\b\u0010/\u001a\u00020\u0005H&J\u0012\u00100\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH&J\u0012\u00101\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH&J\b\u00102\u001a\u00020\u0003H&¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/tips/IGuideTipsService;", "", "enableTips", "", "enable", "", "canShowTip", "tipType", "", "showTip", "context", "Landroid/content/Context;", "tip", "Lcom/larus/bmhome/chat/tips/GuideTip;", "anchorView", "Landroid/view/View;", "startMargin", "endMargin", "indicatorSpace", "windowGravity", "Lcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;", "shadowSpace", "popYOff", "onShow", "Lkotlin/Function0;", "onDismiss", "Lkotlin/Function1;", "indicatorMarginLeft", "indicatorMarginRight", "onContentClick", "absoluteVerticalDistance", "isCloseCenter", "isRemoveDescMargin", "textColorString", "", "forceShow", "needIndicator", "descTvMaxWidth", "(Landroid/content/Context;Lcom/larus/bmhome/chat/tips/GuideTip;Landroid/view/View;IIILcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;IILkotlin/jvm/functions/Function0;Ljava/lang/Integer;ZZLjava/lang/String;ZZLjava/lang/Integer;)Z", "showDialog", "showDialogAction", "getGuideTipType", "data", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "setGuideTipsShown", "getDebugGuideTipRepo", "Lcom/bytedance/keva/Keva;", "getDebugColdLaunchActionBarHasShowTip", "isGuideTipShown", "dismissTip", "clearMemoryGuideRedDot", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IGuideTipsService {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(GuideTipsDelegate r25, Context r26, com.larus.bmhome.chat.tips.a r27, View r28, int r29, int r30, int r31, AutoOffsetPopupWindow.WindowGravity r32, int r33, int r34, Function1 r35, String r36, boolean r37, Integer r38, int r39) {
            if ((r39 & 256) == 0) goto L5;
            int r12 = 0;
        L7:
            if ((r39 & 1024) == 0) goto L9;
            Function1 r14 = null;
        L11:
            if ((131072 & r39) == 0) goto L13;
            String r21 = "";
        L15:
            if ((262144 & r39) == 0) goto L17;
            boolean r22 = false;
        L19:
            if ((524288 & r39) == 0) goto L21;
            boolean r23 = true;
        L23:
            if ((r39 & 1048576) == 0) goto L25;
            Integer r24 = null;
        L27:
            return r25.a(r26, r27, r28, r29, r30, r31, r32, r33, r12, null, r14, 0, 0, null, null, false, false, r21, r22, r23, r24);
        L25:
            r24 = r38;
            goto L27
        L21:
            r23 = false;
            goto L23
        L17:
            r22 = r37;
            goto L19
        L13:
            r21 = r36;
            goto L15
        L9:
            r14 = r35;
            goto L11
        L5:
            r12 = r34;
            goto L7
        }
    }

    boolean a(Context r1, com.larus.bmhome.chat.tips.a r2, View r3, int r4, int r5, int r6, AutoOffsetPopupWindow.WindowGravity r7, int r8, int r9, Function0<Unit> r10, Function1<? super Boolean, Unit> r11, int r12, int r13, Function0<Unit> r14, Integer r15, boolean r16, boolean r17, String r18, boolean r19, boolean r20, Integer r21);

    void b(@GuideTipType int r1);

    boolean c(@GuideTipType int r1);

    void d();

    void e(boolean r1);

    boolean f(@GuideTipType int r1);

    boolean g(com.larus.bmhome.chat.tips.a r1, Function0<Unit> r2);

    int h(z0 r1);
}
