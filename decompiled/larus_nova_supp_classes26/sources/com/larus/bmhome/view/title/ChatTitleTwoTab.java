package com.larus.bmhome.view.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.databinding.LarusWidgetChatTitleTwoTagBinding;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.ChatSubTitleStyle;
import com.larus.platform.api.g0;
import com.larus.platform.api.j;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lq9.q;
import v19.c;
import v19.i5;
import wt8.p;
import wt8.r;
import wt8.s;
import wt8.t;
import wt8.u;
import wt8.v;
import wt8.w;
import wt8.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010P\u001a\u00020Q2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010R\u001a\u00020QH\u0002J\b\u0010S\u001a\u00020QH\u0002J\u0010\u0010T\u001a\u00020Q2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020Q2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010X\u001a\u00020Q2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010Y\u001a\u00020Q2\u0006\u0010U\u001a\u00020VH\u0016J\u001c\u0010Z\u001a\u00020Q2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020Q0\\H\u0016J \u0010^\u001a\u00020Q2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020\u001fH\u0016J\"\u0010c\u001a\u00020Q2\u0006\u0010d\u001a\u00020`2\b\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020\u001fH\u0016J\u0010\u0010h\u001a\u00020Q2\u0006\u0010U\u001a\u00020VH\u0016JB\u0010c\u001a\u00020Q2\u0006\u0010d\u001a\u00020`2\b\u0010i\u001a\u0004\u0018\u00010`2\b\u0010j\u001a\u0004\u0018\u00010k2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010`2\b\b\u0002\u0010m\u001a\u00020\u001f2\b\b\u0002\u0010n\u001a\u00020`J\b\u0010o\u001a\u00020QH\u0002J\u0010\u0010q\u001a\u00020Q2\b\u0010p\u001a\u0004\u0018\u00010`J\u000e\u0010r\u001a\u00020Q2\u0006\u0010s\u001a\u00020tJ\u0010\u0010u\u001a\u00020Q2\u0006\u0010v\u001a\u00020`H\u0016J.\u0010w\u001a\u00020Q2\b\u0010x\u001a\u0004\u0018\u00010`2\u0006\u0010b\u001a\u00020\u001f2\b\b\u0001\u0010y\u001a\u00020\u000b2\b\u0010z\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010{\u001a\u00020Q2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010|\u001a\u00020Q2\u0006\u0010}\u001a\u00020\u000bH\u0016J\b\u0010~\u001a\u00020QH\u0016J\b\u0010\u007f\u001a\u00020QH\u0016J\u0011\u0010\u0080\u0001\u001a\u00020Q2\u0006\u0010U\u001a\u00020VH\u0016J\u0011\u0010\u0081\u0001\u001a\u00020Q2\u0006\u0010U\u001a\u00020VH\u0016J\u0012\u0010\u0082\u0001\u001a\u00020Q2\u0007\u0010\u0083\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010\u0084\u0001\u001a\u00020Q2\u0007\u0010\u0085\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020Q2\u0007\u0010\u0087\u0001\u001a\u00020\u001fH\u0016J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\t\u0010\u008a\u0001\u001a\u00020\u0001H\u0016J\u000b\u0010\u008b\u0001\u001a\u0004\u0018\u00010]H\u0016J\t\u0010\u008c\u0001\u001a\u00020]H\u0016J\u001e\u0010\u008d\u0001\u001a\u00020Q2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010]2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\t\u0010\u0091\u0001\u001a\u00020QH\u0016J\u0012\u0010\u0092\u0001\u001a\u00020Q2\u0007\u0010\u0093\u0001\u001a\u00020\u001fH\u0016J\u0011\u0010\u0094\u0001\u001a\u00020Q2\u0006\u0010U\u001a\u00020VH\u0016J\u0012\u0010\u0095\u0001\u001a\u00020Q2\u0007\u0010\u0087\u0001\u001a\u00020\u001fH\u0016R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010%\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010'\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R$\u0010+\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R$\u0010.\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R$\u00101\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b2\u0010 \"\u0004\b3\u0010\"R$\u00104\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R$\u00107\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010 \"\u0004\b9\u0010\"R$\u0010:\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R$\u0010=\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010 \"\u0004\b?\u0010\"R\u001a\u0010@\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R$\u0010C\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010 \"\u0004\bE\u0010\"R$\u0010F\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010 \"\u0004\bG\u0010\"R$\u0010H\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010 \"\u0004\bI\u0010\"R$\u0010J\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010 \"\u0004\bL\u0010\"R$\u0010M\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010 \"\u0004\bO\u0010\"R\u0010\u0010p\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lcom/larus/bmhome/view/title/ChatTitleTwoTab;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/platform/api/IChatTitle;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/bmhome/databinding/LarusWidgetChatTitleTwoTagBinding;", "binding", "getBinding", "()Lcom/larus/bmhome/databinding/LarusWidgetChatTitleTwoTagBinding;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "Lkotlin/Lazy;", "earphoneState", "Lcom/larus/platform/model/audio/EarphoneStateModel;", "getEarphoneState", "()Lcom/larus/platform/model/audio/EarphoneStateModel;", "setEarphoneState", "(Lcom/larus/platform/model/audio/EarphoneStateModel;)V", "isMainBot", "", "()Z", "setMainBot", "(Z)V", "isDotEnable", "setDotEnable", "isRealTimeCallVisible", "setRealTimeCallVisible", "isRealtimeCallVisibleHookShow", "setRealtimeCallVisibleHookShow", "isRedDotVisible", "setRedDotVisible", "backBtnEnabled", "getBackBtnEnabled", "setBackBtnEnabled", "addBotEnabled", "getAddBotEnabled", "setAddBotEnabled", "hasMore", "getHasMore", "setHasMore", "moreBtnEnabled", "getMoreBtnEnabled", "setMoreBtnEnabled", "hasAddBot", "getHasAddBot", "setHasAddBot", "ttsChecked", "getTtsChecked", "setTtsChecked", "ttsBanned", "getTtsBanned", "setTtsBanned", "ttsGrey", "getTtsGrey", "setTtsGrey", "audioBtnEnabled", "getAudioBtnEnabled", "setAudioBtnEnabled", "isTtsContinuousTalkVisible", "setTtsContinuousTalkVisible", "isTtsVisible", "setTtsVisible", "ttsContinuousTalkChecked", "getTtsContinuousTalkChecked", "setTtsContinuousTalkChecked", "ttsContinuousTalkEnabled", "getTtsContinuousTalkEnabled", "setTtsContinuousTalkEnabled", "init", "", "setupTtsButtonStatus", "setupTtsContinuousButtonStatus", "setOnMoreClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnAddBotClickListener", "setOnTtsCheckedListener", "setOnTtsContinuousTalkCheckedListener", "setOnTtsContinuousTalkLongClickListener", "longClickAction", "Lkotlin/Function1;", "Landroid/view/View;", "setAvatar", "iconUri", "", "iconUrl", "isAllow", "setTitle", "title", "tagConfig", "Lcom/larus/platform/api/ChatTitleTagConfig;", "isDefaultName", "setOnChatHistoryCheckedListener", "tag", "bindingChatFragment", "Lcom/larus/bmhome/databinding/LarusPageChatDoubleTabBinding;", "conversationId", "isFirstAutoLanding", "templateType", "setupTabLayout", "botId", "bindBotId", "addTabSelectListener", "tabSelectListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "setStatus", "status", "setCreatorName", "creatorName", "type", "subTitleClickListener", "setOnMainClickListener", "setBackIconRes", "iconResId", "forbidBack", "forbidRedDot", "setOnBackClickListener", "setRedDotViewClickListener", "setRedDotUnreadCount", "count", "setRedDotBGType", "bgType", "setRedDotViewVisible", "isVisible", "getAvatar", "Lcom/larus/bmhome/view/TitleAvatarImageView;", "getTitle", "getMoreView", "getTitleView", "onViewCreated", "view", "fragment", "Landroidx/fragment/app/Fragment;", "onDestroyedView", "setImmerse", "isImmerse", "setRealtimeCallBtnClickListener", "setBackIconVisible", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTitleTwoTab extends ConstraintLayout implements g0 {
    public static final /* synthetic */ int t = 0;
    public LarusWidgetChatTitleTwoTagBinding a;
    public final Lazy b;
    public q c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;

    public final void E6() {
    }

    public final boolean Ea() {
        return false;
    }

    public final void Fa(String r1, boolean r2, @ChatSubTitleStyle int r3, View.OnClickListener r4) {
    }

    public final void Ia(String r1, j r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "title");
    }

    public final void Na(Integer r1, CharSequence r2) {
    }

    public final void Qa() {
    }

    public final void Ua() {
    }

    public final void Wa() {
    }

    public View getBackIcon() {
        return null;
    }

    public View getMultitaskManagementIcon() {
        return null;
    }

    public View getRedDot() {
        return null;
    }

    public View getSelectDone() {
        return null;
    }

    public View getTitleText() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View getTitleView() {
        return this;
    }

    public View getTtsView() {
        return null;
    }

    public final void refresh() {
    }

    public void setImmerse(boolean r1) {
    }

    public void setIsLocalSubConvChange(boolean r1) {
    }

    public void setOnChatHistoryCheckedListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public void setParticipantNum(int r1) {
    }

    public void setRealTimeCallVisible(boolean r1) {
    }

    public void setRealtimeCallBtnClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public void setRealtimeCallVisibleHookShow(boolean r1) {
    }

    public void setSearchIcon(int r1) {
    }

    public void setSearchIconRedDotVisible(boolean r1) {
    }

    public void setSideNavIconVisible(boolean r1) {
    }

    public void setStatus(String r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
    }

    public void setTitleIcon(boolean r1) {
    }

    private final ChatParam getChatParam() {
        return (ChatParam) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getAvatar, reason: collision with other method in class */
    public TitleAvatarImageView m34getAvatar() {
        return new TitleAvatarImageView(getContext());
    }

    public final LarusWidgetChatTitleTwoTagBinding getBinding() {
        LarusWidgetChatTitleTwoTagBinding r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getTitle, reason: collision with other method in class */
    public ConstraintLayout m35getTitle() {
        return new ConstraintLayout(getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5() {
        if (getTtsBanned() == false) goto L6;
        int r0 = c.b(2130971884, getContext(), 2131242245);
    L16:
        getBinding().k.setImageResource(r0);
        return;
    L6:
        if (getTtsChecked() == false) goto L15;
        ChatParam r1 = getChatParam();
        boolean r2 = false;
        if (r1 != null) goto L10;
    L12:
        if (r2 == false) goto L14;
        r0 = c.b(2130971881, getContext(), 2131242236);
        goto L16
    L14:
        r0 = c.b(2130971878, getContext(), 2131242227);
        goto L16
    L10:
        if (r1.f != true) goto L12;
        r2 = true;
        goto L12
    L15:
        r0 = c.b(2130971875, getContext(), 2131242215);
        goto L16
    }

    public boolean getHasMore() {
        if (getBinding().h.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public View getMoreView() {
        return getBinding().h;
    }

    public final void va() {
        e1.o(getBinding().e);
    }

    public final boolean Da() {
        return this.d;
    }

    public final boolean Ja() {
        return this.e;
    }

    public boolean getAddBotEnabled() {
        return this.h;
    }

    public boolean getAudioBtnEnabled() {
        return this.n;
    }

    public boolean getBackBtnEnabled() {
        return this.g;
    }

    public q getEarphoneState() {
        return this.c;
    }

    public boolean getHasAddBot() {
        return this.j;
    }

    public boolean getMoreBtnEnabled() {
        return this.i;
    }

    public boolean getTtsBanned() {
        return this.l;
    }

    public boolean getTtsChecked() {
        return this.k;
    }

    public boolean getTtsContinuousTalkChecked() {
        return this.q;
    }

    public boolean getTtsContinuousTalkEnabled() {
        return this.r;
    }

    public boolean getTtsGrey() {
        return this.m;
    }

    public final boolean i() {
        return this.f;
    }

    public /* bridge */ /* synthetic */ View getAvatar() {
        return m34getAvatar();
    }

    public /* bridge */ /* synthetic */ View getTitle() {
        return m35getTitle();
    }

    public ChatTitleTwoTab(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.b = LazyKt.lazy(new p(this));
        this.c = new q(false, false);
        this.e = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.n = true;
        this.p = true;
        this.q = true;
        this.r = true;
        S5(r3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ChatParam R5(ChatTitleTwoTab r2) {
        ChatFragment r3 = e1.k(r2);
        if ((r3 instanceof ChatFragment) == false) goto L5;
        ChatFragment r4 = r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.m;
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAddBotEnabled(boolean r3) {
        if (r3 != this.h) goto L5;
        return;
    L5:
        this.h = r3;
        if (r3 == false) goto L8;
        getBinding().b.clearColorFilter();
        return;
    L8:
        getBinding().b.setColorFilter(ContextCompat.getColor(getContext(), 2131103682));
    }

    public void setAudioBtnEnabled(boolean r2) {
        this.n = r2;
        ImageView r0 = getBinding().k;
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r0.setAlpha(r3);
        return;
    L5:
        r3 = 0.3f;
        goto L6
    }

    public void setAvatarClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackBtnEnabled(boolean r3) {
        if (r3 != this.g) goto L5;
        return;
    L5:
        this.g = r3;
        if (r3 == false) goto L8;
        getBinding().e.clearColorFilter();
        return;
    L8:
        getBinding().e.setColorFilter(ContextCompat.getColor(getContext(), 2131103682));
    }

    public void setBackIconRes(int r2) {
        getBinding().e.setImageResource(r2);
    }

    public void setBackIconVisible(boolean r2) {
        if (r2 == false) goto L4;
        getBinding().e.setVisibility(0);
        return;
    L4:
        getBinding().e.setVisibility(4);
    }

    public void setCreateNewCvsClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public void setDotEnable(boolean r2) {
        this.e = r2;
        getBinding().f.setDotInvisible(!r2);
    }

    public void setEarphoneState(q r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setHasAddBot(boolean r5) {
        boolean r0 = this.j;
        if (r5 != r0) goto L5;
        return;
    L5:
        int r1 = 0;
        if (r0 == false) goto L16;
        if (r5 == true) goto L16;
        setClickable(false);
        AppCompatImageView r2 = getBinding().b;
        if (r2 == null) goto L15;
        AppCompatImageView r3 = getBinding().b;
        if (r3 == null) goto L13;
        Context r4 = r3.getContext();
    L14:
        r2.setImageResource(c.b(2130971658, r4, 2131240937));
        goto L15
    L13:
        r4 = null;
    L15:
        postDelayed(new s(this), 1000);
    L21:
        this.j = r5;
        return;
    L16:
        FrameLayout r6 = getBinding().c;
        if (r5 == true) goto L20;
        r1 = 8;
    L20:
        r6.setVisibility(r1);
        goto L21
    }

    public void setHasMore(boolean r3) {
        int r0 = 0;
        if (r3 == true) goto L5;
    L10:
        AppCompatImageView r1 = getBinding().h;
        if (r3 == true) goto L14;
        r0 = 8;
    L14:
        r1.setVisibility(r0);
        return;
    L5:
        if (getBinding().c.getVisibility() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        return;
    L7:
        r2 = false;
        goto L8
    }

    public void setMainBot(boolean r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMoreBtnEnabled(boolean r3) {
        if (r3 != this.i) goto L5;
        return;
    L5:
        this.i = r3;
        if (r3 == false) goto L8;
        getBinding().h.clearColorFilter();
        return;
    L8:
        getBinding().h.setColorFilter(ContextCompat.getColor(getContext(), 2131103682));
    }

    public void setOnAddBotClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        e1.c(getBinding().b, r2);
    }

    public void setOnBackClickListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().e, new wt8.q(r3));
    }

    public void setOnMainClickListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().g, new u(r3));
    }

    public void setOnMoreClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        e1.c(getBinding().h, r2);
    }

    public void setOnMultitaskClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public void setOnSearchClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public void setOnSideNavClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public void setOnTtsCheckedListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().k, new w(r3));
    }

    public void setOnTtsContinuousTalkCheckedListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().l, new t(r3));
    }

    public void setOnTtsContinuousTalkLongClickListener(final Function1<? super View, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "longClickAction");
        getBinding().l.setOnLongClickListener(new r(r3));
    }

    public void setOnTtsLongPressAction(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "longClickAction");
    }

    public void setRedDotBGType(int r2) {
        getBinding().f.setRedDotBG(r2);
    }

    public void setRedDotUnreadCount(int r2) {
        getBinding().f.z(r2);
    }

    public void setRedDotViewClickListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().f, new v(r3));
    }

    public void setRedDotViewVisible(boolean r2) {
        if (r2 == false) goto L4;
        getBinding().f.setVisibility(0);
        return;
    L4:
        getBinding().f.setVisibility(4);
    }

    public void setRedDotVisible(boolean r1) {
        this.f = r1;
    }

    public void setTtsBanned(boolean r1) {
        this.l = r1;
        T5();
    }

    public void setTtsChecked(boolean r1) {
        this.k = r1;
        T5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTtsContinuousTalkChecked(boolean r3) {
        if (r3 != this.q) goto L5;
        return;
    L5:
        this.q = r3;
        if (getTtsContinuousTalkChecked() == false) goto L16;
        ChatParam r4 = getChatParam();
        if (r4 == null) goto L12;
        boolean r0 = true;
        if (r4.f != true) goto L12;
    L13:
        if (r0 == false) goto L15;
        int r5 = c.b(2130971881, getContext(), 2131242236);
    L17:
        getBinding().l.setImageResource(r5);
        return;
    L15:
        r5 = c.b(2130971878, getContext(), 2131242227);
    L12:
        r0 = false;
        goto L13
    L16:
        r5 = c.b(2130971875, getContext(), 2131242215);
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTtsContinuousTalkEnabled(boolean r3) {
        if (r3 != this.r) goto L5;
        return;
    L5:
        this.r = r3;
        if (r3 == false) goto L8;
        getBinding().l.clearColorFilter();
        return;
    L8:
        getBinding().l.setColorFilter(ContextCompat.getColor(getContext(), 2131103682));
    }

    public void setTtsContinuousTalkVisible(boolean r2) {
        if (r2 != this.o) goto L5;
        return;
    L5:
        this.o = r2;
        ImageView r0 = getBinding().l;
        if (r2 == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    public void setTtsGrey(boolean r1) {
        this.m = r1;
    }

    public void setTtsVisible(boolean r2) {
        if (r2 != this.p) goto L5;
        return;
    L5:
        this.p = r2;
        ImageView r0 = getBinding().k;
        if (r2 == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    public ChatTitleTwoTab(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.b = LazyKt.lazy(new p(this));
        this.c = new q(false, false);
        this.e = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.n = true;
        this.p = true;
        this.q = true;
        this.r = true;
        S5(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Context r17, AttributeSet r18) {
        LayoutInflater.from(r17).inflate(2131563245, this);
        int r0 = 2131362230;
        AppCompatImageView r2 = ViewBindings.findChildViewById(this, 2131362230);
        if (r2 == null) goto L27;
        r0 = 2131362231;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362231);
        if (r3 == null) goto L27;
        r0 = 2131363623;
        RoundAvatarImageView r4 = (RoundAvatarImageView) ViewBindings.findChildViewById(this, 2131363623);
        if (r4 == null) goto L27;
        r0 = 2131363779;
        AppCompatImageView r5 = ViewBindings.findChildViewById(this, 2131363779);
        if (r5 == null) goto L27;
        r0 = 2131365608;
        RedDotTextView r6 = ViewBindings.findChildViewById(this, 2131365608);
        if (r6 == null) goto L27;
        r0 = 2131379429;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(this, 2131379429);
        if (r7 == null) goto L27;
        r0 = 2131380286;
        AppCompatImageView r8 = ViewBindings.findChildViewById(this, 2131380286);
        if (r8 == null) goto L27;
        r0 = 2131387992;
        TabLayout r9 = ViewBindings.findChildViewById(this, 2131387992);
        if (r9 == null) goto L27;
        r0 = 2131388843;
        ConstraintLayout r10 = ViewBindings.findChildViewById(this, 2131388843);
        if (r10 == null) goto L27;
        r0 = 2131389944;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(this, 2131389944);
        if (r11 == null) goto L27;
        r0 = 2131389948;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(this, 2131389948);
        if (r12 == null) goto L27;
        this.a = new LarusWidgetChatTitleTwoTagBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        setMinHeight(i5.k0());
        setBackgroundColor(ContextCompat.getColor(r17, c.b(2130970529, r17, 2131102529)));
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public ChatTitleTwoTab(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(new p(this));
        this.c = new q(false, false);
        this.e = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.n = true;
        this.p = true;
        this.q = true;
        this.r = true;
        S5(r2, r3);
    }

    public final void Sa(String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "iconUri");
        Intrinsics.checkNotNullParameter(r4, "iconUrl");
        if (r5 == true) goto L5;
        return;
    L5:
        getBinding().d.setVisibility(0);
        getBinding().j.setVisibility(8);
        ImageLoaderKt.y(getBinding().d, r4, "chat_title_two_tab", new x(), 4);
    }
}
