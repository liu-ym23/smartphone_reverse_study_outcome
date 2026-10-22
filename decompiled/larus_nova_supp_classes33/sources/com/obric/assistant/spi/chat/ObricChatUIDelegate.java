package com.obric.assistant.spi.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.z0;
import ot8.a;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u0005H\u0096\u0001J#\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0001JH\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\u001b\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0005H\u0096\u0001J\u001b\u0010$\u001a\u00020 2\b\b\u0001\u0010%\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0005H\u0096\u0001J\t\u0010&\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u000fH\u0096\u0001J!\u0010-\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u001dH\u0096\u0001J\u001b\u00101\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u00103\u001a\u00020\u000fH\u0096\u0001J\u000b\u00104\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u0011\u00105\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0096\u0001J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u000109H\u0096\u0001J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000109H\u0096\u0001J\u0011\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020=H\u0096\u0001J\u0019\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\fH\u0096\u0001J3\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010\u001d2\u0006\u0010C\u001a\u000207H\u0096\u0001J\u0013\u0010D\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010E\u001a\u00020\u0005H\u0096\u0001J\u0018\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\"H\u0096\u0001¢\u0006\u0002\u0010GJ\t\u0010H\u001a\u00020\u0005H\u0096\u0001J\t\u0010I\u001a\u00020\u0005H\u0096\u0001J\t\u0010J\u001a\u00020\u0005H\u0096\u0001J\t\u0010K\u001a\u00020\u0005H\u0096\u0001J9\u0010L\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010Q2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J\u0018\u0010R\u001a\u0004\u0018\u00010\u000f2\u0006\u0010S\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0002\u0010TJ\u0011\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010W\u001a\u00020 2\u0006\u0010V\u001a\u00020\u0005H\u0096\u0001J\u0086\u0001\u0010X\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u001d2\u0014\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 \u0018\u00010]2\u0006\u0010^\u001a\u00020\u000f2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020 0`2\u0006\u0010a\u001a\u00020\u00052\b\u0010b\u001a\u0004\u0018\u00010\u000f2\u001e\u0010c\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0dH\u0096\u0001¢\u0006\u0002\u0010eJ\t\u0010f\u001a\u00020 H\u0096\u0001J\u0013\u0010g\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020j0i2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020j0iH\u0096\u0001J#\u0010l\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010m\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010n\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010o\u001a\u00020\u000fH\u0096\u0001J)\u0010p\u001a\u00020 2\u0006\u00100\u001a\u00020\u001d2\u0006\u0010q\u001a\u0002072\u0006\u0010r\u001a\u00020\u000f2\u0006\u0010s\u001a\u00020\u0005H\u0096\u0001J\t\u0010t\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010u\u001a\u00020\u00052\u0006\u0010v\u001a\u00020\"2\u0006\u0010w\u001a\u00020\u000fH\u0096\u0001J\t\u0010x\u001a\u00020\u0005H\u0096\u0001J\t\u0010y\u001a\u00020\u0005H\u0096\u0001J!\u0010z\u001a\u00020\u00052\u0006\u0010{\u001a\u00020|2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010}\u001a\u00020~H\u0096\u0001J*\u0010\u007f\u001a\u00020\u00052\u0006\u0010{\u001a\u00020|2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\t0iH\u0096\u0001J \u0010\u0083\u0001\u001a\u00020 2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\"2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\"H\u0096\u0001J#\u0010\u0086\u0001\u001a\u00020 2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u000f2\u0007\u0010\u0087\u0001\u001a\u00020\u001dH\u0096\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/obric/assistant/spi/chat/ObricChatUIDelegate;", "Lcom/obric/assistant/spi/chat/IObricChatUIService;", "<init>", "()V", "addUserAsrFeedbackItem", "", "context", "Landroid/content/Context;", "message", "Lcom/larus/im/bean/message/Message;", "menuItems", "", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "cacheBottomLeftInputAction", "calculateNavigationPadding", "", "navBarShow", "rootInsets", "Landroidx/core/view/WindowInsetsCompat;", "checkIsShowActionBar", "chatCanShow", "isImeShow", "show", "canShow", "isCurrentListNotEmptyOrIsRemote", "isContinuousTalk", "inVoiceMixInput", "(ZLjava/lang/Boolean;ZZZZZ)Z", "clipObricInputText", "", "text", "ensureDocBottomPadding", "", "root", "Landroid/view/View;", "ignoreThreeButtonNavigationInset", "ensureToolbarBottomSafeInset", "toolbarLayoutId", "getAllMessagesHeightInLocked", "getFinalBottomPadding", "chatRoot", "bottomPadding", "getImeActualPadding", "view", "originPadding", "getImeNewBottom", "newBottom", "getMessageHeight", "messageId", "getObricActionBarWhiteItems", "", "getObricInputMaxLength", "getObricPasteExceedLimitToastText", "getTitleBarDoraSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getTitleBarIconStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getTtsEnabledStateFlow", "handleFastScrollButtonInit", "button", "Landroid/widget/FrameLayout;", "handleMenuItemClick", "fragment", "Landroidx/fragment/app/Fragment;", "item", "callAsrId", "chatKey", "isActionBarFilterEnable", "isBuiltInMode", "isInputViewMeetScreenBottom", "(Landroid/view/View;)Ljava/lang/Boolean;", "isObricInputLengthFilterEnable", "isPreventScrollToLatest", "isPromptCellShowEnable", "isShowRealtimeCallNotification", "modifyMenuItem", "data", "chatBot", "Lcom/larus/im/bean/bot/BotModel;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "obricBluetoothIcon", "type", "(I)Ljava/lang/Integer;", "onBluetoothTtsEnable", "enable", "onBuildInTtsEnable", "onFullScreenEditTextClick", "Landroid/view/ViewGroup;", "isModifying", "inputTextContent", "onClickSend", "Lkotlin/Function1;", "imeHeight", "onFold", "Lkotlin/Function0;", "forceDarkMode", "backgroundColor", "onUpdateInputText", "Lkotlin/Function3;", "(Landroid/view/ViewGroup;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function0;ZLjava/lang/Integer;Lkotlin/jvm/functions/Function3;)V", "preventScrollToLatestAWhile", "providerObricAudioVisualizer", "reorderObricActionBarItems", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "items", "resolveGestureSafeBottom", "navigationPadding", "setChatRootBottomPadding", "navigationBarHeight", "setMessageHeight", "time", "height", "isKeyguardTipsMessage", "shouldAttachToInputOnlyContainer", "shouldKeepAnchorTopForOffscreenReply", "anchorView", "listHeight", "shouldRestrictAiGenActionToMusicInstruction", "shouldSafeBottom", "showDislikeDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "extraBundle", "Landroid/os/Bundle;", "showTipOffDialog", "tipOffDialogParams", "", "msgList", "tryAdjustVoiceInputViewLocation", "inputView1", "inputView2", "updateWindowInputBottomMargin", "source", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatUIDelegate implements IObricChatUIService {
    public static final ObricChatUIDelegate b = null;
    public final /* synthetic */ IObricChatUIService a;

    static {
        b = new ObricChatUIDelegate();
    }

    public final String A(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        return this.a.A(r2);
    }

    public final boolean B() {
        return this.a.B();
    }

    public final void C(String r8, long r9, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "messageId");
        this.a.C(r8, r9, r11, r12);
    }

    public final z0<Boolean> D() {
        return this.a.D();
    }

    public final int E(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return this.a.E(r2, r3);
    }

    public final boolean F() {
        return this.a.F();
    }

    public final Integer G(int r2) {
        return this.a.G(r2);
    }

    public final int H(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return this.a.H(r2, r3);
    }

    public final boolean I(Context r2, Message r3, List<a> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "menuItems");
        return this.a.I(r2, r3, r4);
    }

    public final int J() {
        return this.a.J();
    }

    public final void K(boolean r2) {
        this.a.K(r2);
    }

    public final void L(ChatConstraintLayout r2) {
        this.a.L(r2);
    }

    public final void M(Context r8, Message r9, BotModel r10, e r11, List<a> r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "chatBot");
        Intrinsics.checkNotNullParameter(r12, "menuItems");
        this.a.M(r8, r9, r10, r11, r12);
    }

    public final boolean N(FragmentManager r2, Message r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "extraBundle");
        return this.a.N(r2, r3, r4);
    }

    public final MutableSharedFlow<Long> O() {
        return this.a.O();
    }

    public final Set P(FragmentActivity r2) {
        return this.a.P(r2);
    }

    public final boolean a(FragmentManager r2, TipOffDialogParams r3, List r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "tipOffDialogParams");
        Intrinsics.checkNotNullParameter(r4, "msgList");
        return this.a.a(r2, r3, r4);
    }

    public final int b(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "chatRoot");
        return this.a.b(r2, r3);
    }

    public final void c(View r2, View r3) {
        this.a.c(r2, r3);
    }

    public final boolean d() {
        return this.a.d();
    }

    public final z0<Integer> e() {
        return this.a.e();
    }

    public final Boolean f(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return this.a.f(r2);
    }

    public final void g() {
        this.a.g();
    }

    public final int h() {
        return this.a.h();
    }

    public final int i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        return this.a.i(r2);
    }

    public final int j(Context r2, WindowInsetsCompat r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.j(r2, r3, r4);
    }

    public final boolean k(Fragment r9, a r10, Message r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter(r9, "fragment");
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "message");
        return this.a.k(r9, r10, r11, r12, r13);
    }

    public final List<com.larus.bmhome.actionbar.model.z0> l(List<com.larus.bmhome.actionbar.model.z0> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        return this.a.l(r2);
    }

    public final boolean m() {
        return this.a.m();
    }

    public final boolean n() {
        return this.a.n();
    }

    public final int o(Context r2, boolean r3, WindowInsetsCompat r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.o(r2, r3, r4);
    }

    public final boolean p() {
        return this.a.p();
    }

    public final boolean q(boolean r9, Boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        return this.a.q(r9, r10, r11, r12, r13, r14, r15);
    }

    public final boolean r() {
        return this.a.r();
    }

    public final boolean s(FragmentActivity r2) {
        return this.a.s(r2);
    }

    public final String t() {
        return this.a.t();
    }

    public final void u(boolean r2) {
        this.a.u(r2);
    }

    public final View v(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.v(r2);
    }

    public final boolean w() {
        return this.a.w();
    }

    public final boolean x(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorView");
        return this.a.x(r2, r3);
    }

    public final void y() {
        this.a.y();
    }

    public final void z(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        this.a.z(r2);
    }

    private ObricChatUIDelegate() {
        IObricChatUIService r0 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricChatUIServiceImpl();
    L5:
        this.a = r0;
    }
}
