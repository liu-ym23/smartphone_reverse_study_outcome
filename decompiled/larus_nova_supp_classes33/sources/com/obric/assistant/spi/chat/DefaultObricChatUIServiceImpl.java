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
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.z0;
import ot8.a;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016JG\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J8\u0010$\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#H\u0016J2\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u000201H\u0016J \u00102\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u0010\u001f\u001a\u00020 2\u0006\u00105\u001a\u000206H\u0016J&\u00107\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020 0\u0011H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\u0018\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020%H\u0016J\u0085\u0001\u0010B\u001a\u00020%2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u000f2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%\u0018\u00010H2\u0006\u0010I\u001a\u00020@2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020%0K2\u0006\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010@2\u001e\u0010N\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0OH\u0016¢\u0006\u0002\u0010PJ\u001c\u0010Q\u001a\u00020%2\b\u0010R\u001a\u0004\u0018\u00010\u00072\b\u0010S\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010T\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010UH\u0016J\u0010\u0010V\u001a\u00020@2\u0006\u0010W\u001a\u00020\u000fH\u0016J\b\u0010X\u001a\u00020@H\u0016J\u0012\u0010Y\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010Z\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010[H\u0016J\u0010\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010UH\u0016J\b\u0010]\u001a\u00020\u0005H\u0016J\u0010\u0010^\u001a\u00020%2\u0006\u0010_\u001a\u00020\u0005H\u0016J\u0010\u0010`\u001a\u00020%2\u0006\u0010_\u001a\u00020\u0005H\u0016J\u0017\u0010a\u001a\u0004\u0018\u00010@2\u0006\u0010b\u001a\u00020@H\u0016¢\u0006\u0002\u0010cJ(\u0010d\u001a\u00020%2\u0006\u0010W\u001a\u00020\u000f2\u0006\u0010e\u001a\u0002012\u0006\u0010f\u001a\u00020@2\u0006\u0010g\u001a\u00020\u0005H\u0016J\b\u0010h\u001a\u00020\u0005H\u0016J\"\u0010i\u001a\u00020@2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010j\u001a\u00020\u00052\b\u0010k\u001a\u0004\u0018\u00010lH\u0016J\u001a\u0010m\u001a\u00020%2\b\b\u0001\u0010n\u001a\u00020@2\u0006\u0010o\u001a\u00020\u0005H\u0016J\u001a\u0010p\u001a\u00020%2\b\u0010C\u001a\u0004\u0018\u00010\u00072\u0006\u0010o\u001a\u00020\u0005H\u0016J\"\u0010q\u001a\u00020@2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010r\u001a\u00020@H\u0016J\u0010\u0010s\u001a\u00020%2\u0006\u0010t\u001a\u00020uH\u0016J\b\u0010v\u001a\u00020\u0005H\u0016J\b\u0010w\u001a\u00020\u0005H\u0016J\u0018\u0010x\u001a\u00020@2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010y\u001a\u00020@H\u0016J\b\u0010z\u001a\u00020@H\u0016J\n\u0010{\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010|\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020\u000fH\u0016J \u0010~\u001a\u00020@2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010y\u001a\u00020@2\u0006\u0010\u007f\u001a\u00020@H\u0016J$\u0010\u0080\u0001\u001a\u00020%2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020@2\u0007\u0010\u0083\u0001\u001a\u00020\u000fH\u0016J\u001b\u0010\u0084\u0001\u001a\u00020@2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020@H\u0016J\u001b\u0010\u0086\u0001\u001a\u00020@2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020@H\u0016J\t\u0010\u0087\u0001\u001a\u00020\u0005H\u0016¨\u0006\u0088\u0001"}, d2 = {"Lcom/obric/assistant/spi/chat/DefaultObricChatUIServiceImpl;", "Lcom/obric/assistant/spi/chat/IObricChatUIService;", "<init>", "()V", "isInputViewMeetScreenBottom", "", "view", "Landroid/view/View;", "(Landroid/view/View;)Ljava/lang/Boolean;", "isShowRealtimeCallNotification", "isActionBarFilterEnable", "context", "Landroid/content/Context;", "getObricActionBarWhiteItems", "", "", "reorderObricActionBarItems", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "items", "isPromptCellShowEnable", "checkIsShowActionBar", "chatCanShow", "isImeShow", "show", "canShow", "isCurrentListNotEmptyOrIsRemote", "isContinuousTalk", "inVoiceMixInput", "(ZLjava/lang/Boolean;ZZZZZ)Z", "addUserAsrFeedbackItem", "message", "Lcom/larus/im/bean/message/Message;", "menuItems", "", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "modifyMenuItem", "", "data", "chatBot", "Lcom/larus/im/bean/bot/BotModel;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "handleMenuItemClick", "fragment", "Landroidx/fragment/app/Fragment;", "item", "callAsrId", "chatKey", "", "showDislikeDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "extraBundle", "Landroid/os/Bundle;", "showTipOffDialog", "tipOffDialogParams", "", "msgList", "shouldAttachToInputOnlyContainer", "isPreventScrollToLatest", "shouldKeepAnchorTopForOffscreenReply", "anchorView", "listHeight", "", "preventScrollToLatestAWhile", "onFullScreenEditTextClick", "root", "Landroid/view/ViewGroup;", "isModifying", "inputTextContent", "onClickSend", "Lkotlin/Function1;", "imeHeight", "onFold", "Lkotlin/Function0;", "forceDarkMode", "backgroundColor", "onUpdateInputText", "Lkotlin/Function3;", "(Landroid/view/ViewGroup;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function0;ZLjava/lang/Integer;Lkotlin/jvm/functions/Function3;)V", "tryAdjustVoiceInputViewLocation", "inputView1", "inputView2", "getTitleBarIconStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getMessageHeight", "messageId", "getAllMessagesHeightInLocked", "providerObricAudioVisualizer", "getTitleBarDoraSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getTtsEnabledStateFlow", "isBuiltInMode", "onBuildInTtsEnable", "enable", "onBluetoothTtsEnable", "obricBluetoothIcon", "type", "(I)Ljava/lang/Integer;", "setMessageHeight", "time", "height", "isKeyguardTipsMessage", "shouldSafeBottom", "calculateNavigationPadding", "navBarShow", "rootInsets", "Landroidx/core/view/WindowInsetsCompat;", "ensureToolbarBottomSafeInset", "toolbarLayoutId", "ignoreThreeButtonNavigationInset", "ensureDocBottomPadding", "resolveGestureSafeBottom", "navigationPadding", "handleFastScrollButtonInit", "button", "Landroid/widget/FrameLayout;", "isObricInputLengthFilterEnable", "shouldRestrictAiGenActionToMusicInstruction", "getImeActualPadding", "originPadding", "getObricInputMaxLength", "getObricPasteExceedLimitToastText", "clipObricInputText", "text", "getImeNewBottom", "newBottom", "updateWindowInputBottomMargin", "chatRoot", "bottomPadding", "source", "setChatRootBottomPadding", "navigationBarHeight", "getFinalBottomPadding", "cacheBottomLeftInputAction", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricChatUIServiceImpl implements IObricChatUIService {
    public DefaultObricChatUIServiceImpl() {
    }

    public final String A(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        return r2;
    }

    public final boolean B() {
        return false;
    }

    public final void C(String r1, long r2, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
    }

    public final z0<Boolean> D() {
        return null;
    }

    public final int E(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        return 0;
    }

    public final boolean F() {
        return true;
    }

    public final Integer G(int r1) {
        return null;
    }

    public final int H(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return r3;
    }

    public final boolean I(Context r2, Message r3, List<a> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "menuItems");
        return false;
    }

    public final int J() {
        return 0;
    }

    public final void K(boolean r1) {
    }

    public final void L(ChatConstraintLayout r1) {
    }

    public final void M(Context r1, Message r2, BotModel r3, e r4, List<a> r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "chatBot");
        Intrinsics.checkNotNullParameter(r5, "menuItems");
    }

    public final boolean N(FragmentManager r2, Message r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "extraBundle");
        return false;
    }

    public final MutableSharedFlow<Long> O() {
        return null;
    }

    public final boolean a(FragmentManager r2, TipOffDialogParams r3, List r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "tipOffDialogParams");
        Intrinsics.checkNotNullParameter(r4, "msgList");
        return false;
    }

    public final int b(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "chatRoot");
        return r3;
    }

    public final void c(View r1, View r2) {
    }

    public final boolean d() {
        return false;
    }

    public final z0<Integer> e() {
        return null;
    }

    public final Boolean f(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return null;
    }

    public final void g() {
    }

    public final int h() {
        return 0;
    }

    public final int i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        return 0;
    }

    public final int j(Context r1, WindowInsetsCompat r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return 0;
    }

    public final List<com.larus.bmhome.actionbar.model.z0> l(List<com.larus.bmhome.actionbar.model.z0> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        return r2;
    }

    public final boolean m() {
        return false;
    }

    public final boolean n() {
        return true;
    }

    public final int o(Context r1, boolean r2, WindowInsetsCompat r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return 0;
    }

    public final boolean p() {
        return false;
    }

    public final boolean q(boolean r1, Boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        return false;
    }

    public final boolean r() {
        return false;
    }

    public final boolean s(FragmentActivity r1) {
        return false;
    }

    public final String t() {
        return null;
    }

    public final void u(boolean r1) {
    }

    public final View v(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    public final boolean w() {
        return false;
    }

    public final boolean x(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "anchorView");
        return false;
    }

    public final void y() {
    }

    public final void z(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
    }

    public final Set P(FragmentActivity r1) {
        return SetsKt.emptySet();
    }

    public final boolean k(Fragment r1, a r2, Message r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r1, "fragment");
        Intrinsics.checkNotNullParameter(r2, "item");
        return false;
    }
}
