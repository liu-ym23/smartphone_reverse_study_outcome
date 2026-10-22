package com.larus.bmhome.view.title;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.databinding.LarusChatTitleBinding;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.g0;
import com.larus.platform.service.n0;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lq9.q;
import v19.c;
import v19.i5;
import wt8.b;
import wt8.d;
import wt8.e;
import wt8.f;
import wt8.g;
import wt8.h;
import wt8.i;
import wt8.j;
import wt8.k;
import wt8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010L\u001a\u00020M2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010R\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010S\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J\u001c\u0010T\u001a\u00020M2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020M0VH\u0016J\u0010\u0010X\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J \u0010Y\u001a\u00020M2\u0006\u0010Z\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u0014H\u0016J\u0010\u0010]\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J\"\u0010^\u001a\u00020M2\u0006\u0010_\u001a\u00020\u000e2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020\u0014H\u0016J,\u0010c\u001a\u00020M2\b\u0010d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\\\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u000b2\b\u0010f\u001a\u0004\u0018\u00010PH\u0016J\u000e\u0010g\u001a\u00020M2\u0006\u0010h\u001a\u00020\u000bJ\u0010\u0010i\u001a\u00020M2\u0006\u0010j\u001a\u00020\u000eH\u0016J\u0010\u0010k\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010l\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010m\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010n\u001a\u00020M2\u0006\u0010o\u001a\u00020\u000bH\u0016J\u0010\u0010p\u001a\u00020M2\u0006\u0010q\u001a\u00020\u000bH\u0016J\u0010\u0010r\u001a\u00020M2\u0006\u0010s\u001a\u00020\u0014H\u0016J\b\u0010t\u001a\u00020uH\u0016J\b\u0010v\u001a\u00020\u0001H\u0016J\n\u0010w\u001a\u0004\u0018\u00010WH\u0016J\b\u0010x\u001a\u00020WH\u0016J\u001a\u0010y\u001a\u00020M2\b\u0010z\u001a\u0004\u0018\u00010W2\u0006\u0010{\u001a\u00020|H\u0016J\b\u0010}\u001a\u00020MH\u0016J\u0010\u0010~\u001a\u00020M2\u0006\u0010\u007f\u001a\u00020\u0014H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0016J\u0011\u0010\u0081\u0001\u001a\u00020M2\u0006\u0010s\u001a\u00020\u0014H\u0016J\u0014\u0010\u0082\u0001\u001a\u00020M2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u000bH\u0002J\u0014\u0010\u0084\u0001\u001a\u00020M2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u000bH\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010 \u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R$\u0010,\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001a\u0010/\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019R\u001a\u00101\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019R$\u00104\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u001a\u00106\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\u001a\u00108\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R\u001a\u0010:\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R$\u0010<\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R$\u0010?\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R$\u0010B\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0017\"\u0004\bD\u0010\u0019R$\u0010E\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0017\"\u0004\bF\u0010\u0019R$\u0010G\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0017\"\u0004\bH\u0010\u0019R$\u0010I\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0017\"\u0004\bK\u0010\u0019R\u001e\u0010\u0085\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0088\u00010\u0087\u00010\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0089\u0001"}, d2 = {"Lcom/larus/bmhome/view/title/ChatTitle;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/platform/api/IChatTitle;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "preIconTag", "", "value", "Lcom/larus/bmhome/databinding/LarusChatTitleBinding;", "binding", "getBinding", "()Lcom/larus/bmhome/databinding/LarusChatTitleBinding;", "", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "moreBtnEnabled", "getMoreBtnEnabled", "setMoreBtnEnabled", "hasAddBot", "getHasAddBot", "setHasAddBot", "ttsChecked", "getTtsChecked", "setTtsChecked", "earphoneState", "Lcom/larus/platform/model/audio/EarphoneStateModel;", "getEarphoneState", "()Lcom/larus/platform/model/audio/EarphoneStateModel;", "setEarphoneState", "(Lcom/larus/platform/model/audio/EarphoneStateModel;)V", "ttsBanned", "getTtsBanned", "setTtsBanned", "audioBtnEnabled", "getAudioBtnEnabled", "setAudioBtnEnabled", "isMainBot", "setMainBot", "ttsGrey", "getTtsGrey", "setTtsGrey", "isDotEnable", "setDotEnable", "isRealTimeCallVisible", "setRealTimeCallVisible", "isRealtimeCallVisibleHookShow", "setRealtimeCallVisibleHookShow", "isRedDotVisible", "setRedDotVisible", "backBtnEnabled", "getBackBtnEnabled", "setBackBtnEnabled", "ttsContinuousTalkEnabled", "getTtsContinuousTalkEnabled", "setTtsContinuousTalkEnabled", "addBotEnabled", "getAddBotEnabled", "setAddBotEnabled", "isTtsContinuousTalkVisible", "setTtsContinuousTalkVisible", "isTtsVisible", "setTtsVisible", "ttsContinuousTalkChecked", "getTtsContinuousTalkChecked", "setTtsContinuousTalkChecked", "init", "", "setOnMoreClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnAddBotClickListener", "setOnTtsCheckedListener", "setOnTtsContinuousTalkCheckedListener", "setOnTtsContinuousTalkLongClickListener", "longClickAction", "Lkotlin/Function1;", "Landroid/view/View;", "setOnChatHistoryCheckedListener", "setAvatar", "iconUri", "iconUrl", "isAllow", "setAvatarClickListener", "setTitle", "title", "tagConfig", "Lcom/larus/platform/api/ChatTitleTagConfig;", "isDefaultName", "setCreatorName", "creatorName", "type", "subTitleClickListener", "setReviewSubTitle", "disableTag", "setStatus", "status", "setOnMainClickListener", "setOnBackClickListener", "setRedDotViewClickListener", "setRedDotUnreadCount", "count", "setRedDotBGType", "bgType", "setRedDotViewVisible", "isVisible", "getAvatar", "Lcom/larus/bmhome/view/TitleAvatarImageView;", "getTitle", "getMoreView", "getTitleView", "onViewCreated", "view", "fragment", "Landroidx/fragment/app/Fragment;", "onDestroyedView", "setImmerse", "isImmerse", "setRealtimeCallBtnClickListener", "setBackIconVisible", "setTTSImageResource", "resId", "setTTSContinuousTalkImageResource", "avatarLoadController", "Lkotlin/Lazy;", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTitle extends ConstraintLayout implements g0 {
    public static final /* synthetic */ int t = 0;
    public String a;
    public LarusChatTitleBinding b;
    public boolean c;
    public boolean d;
    public boolean e;
    public q f;
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
    public final Lazy<BaseControllerListener<ImageInfo>> s;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ ChatTitle a;

        public a(ChatTitle r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [android.view.ViewGroup, com.larus.bmhome.view.title.ChatTitle] */
        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
            if (this.a.isAttachedToWindow() == false) goto L6;
            ?? r3 = this.a;
            r3.post(new l(r3));
            return;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [android.view.ViewGroup, com.larus.bmhome.view.title.ChatTitle] */
        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            if (this.a.isAttachedToWindow() == false) goto L6;
            ?? r4 = this.a;
            r4.post(new l(r4));
            return;
        }
    }

    public final void E6() {
    }

    public final boolean Ea() {
        return false;
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

    public void setBackIconRes(int r1) {
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

    public void setTitleIcon(boolean r1) {
    }

    public final void va() {
    }

    public final LarusChatTitleBinding getBinding() {
        LarusChatTitleBinding r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    /* JADX INFO: renamed from: getAvatar, reason: collision with other method in class */
    public TitleAvatarImageView m32getAvatar() {
        return getBinding().d;
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

    /* JADX INFO: renamed from: getTitle, reason: collision with other method in class */
    public ConstraintLayout m33getTitle() {
        return getBinding().m;
    }

    public final boolean Da() {
        return this.i;
    }

    public final boolean Ja() {
        return this.k;
    }

    public boolean getAddBotEnabled() {
        return this.o;
    }

    public boolean getAudioBtnEnabled() {
        return this.h;
    }

    public boolean getBackBtnEnabled() {
        return this.m;
    }

    public q getEarphoneState() {
        return this.f;
    }

    public boolean getHasAddBot() {
        return this.d;
    }

    public boolean getMoreBtnEnabled() {
        return this.c;
    }

    public boolean getTtsBanned() {
        return this.g;
    }

    public boolean getTtsChecked() {
        return this.e;
    }

    public boolean getTtsContinuousTalkChecked() {
        return this.r;
    }

    public boolean getTtsContinuousTalkEnabled() {
        return this.n;
    }

    public boolean getTtsGrey() {
        return this.j;
    }

    public final boolean i() {
        return this.l;
    }

    public /* bridge */ /* synthetic */ View getAvatar() {
        return m32getAvatar();
    }

    public /* bridge */ /* synthetic */ View getTitle() {
        return m33getTitle();
    }

    public ChatTitle(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.c = true;
        this.f = new q(false, false);
        this.h = true;
        this.k = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = LazyKt.lazy(new wt8.a(this));
        R5(r4, null);
    }

    private final void setTTSContinuousTalkImageResource(int r2) {
        if (z2.a.m3() == true) goto L6;
        e1.o(getBinding().o);
        return;
    L6:
        getBinding().o.setImageResource(r2);
        if (this.s.isInitialized() == true) goto L10;
        getBinding().o.setVisibility(0);
        return;
    }

    private final void setTTSImageResource(int r2) {
        if (z2.a.m3() == true) goto L6;
        e1.o(getBinding().n);
        return;
    L6:
        getBinding().n.setImageResource(r2);
        if (this.s.isInitialized() == true) goto L10;
        getBinding().n.setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAddBotEnabled(boolean r3) {
        if (r3 != this.o) goto L5;
        return;
    L5:
        this.o = r3;
        if (r3 == false) goto L8;
        getBinding().b.clearColorFilter();
        return;
    L8:
        getBinding().b.setColorFilter(ContextCompat.getColor(getContext(), 2131103682));
    }

    public void setAudioBtnEnabled(boolean r2) {
        this.h = r2;
        AppCompatImageView r0 = getBinding().n;
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r0.setAlpha(r3);
        return;
    L5:
        r3 = 0.3f;
        goto L6
    }

    public void setAvatarClickListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().d, new f(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackBtnEnabled(boolean r3) {
        if (r3 != this.m) goto L5;
        return;
    L5:
        this.m = r3;
        if (r3 == false) goto L8;
        getBinding().e.clearColorFilter();
        return;
    L8:
        getBinding().e.setColorFilter(ContextCompat.getColor(getContext(), 2131103682));
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
        this.k = r2;
        getBinding().f.setDotInvisible(!r2);
    }

    public void setEarphoneState(q r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setHasAddBot(boolean r5) {
        boolean r0 = this.d;
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
        postDelayed(new g(this), 1000);
    L21:
        this.d = r5;
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
        this.i = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMoreBtnEnabled(boolean r3) {
        if (r3 != this.c) goto L5;
        return;
    L5:
        this.c = r3;
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
        e1.d(getBinding().e, new j(r3));
    }

    public void setOnMainClickListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().g, new k(r3));
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
        e1.d(getBinding().n, new i(r3));
    }

    public void setOnTtsContinuousTalkCheckedListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().o, new e(r3));
    }

    public void setOnTtsContinuousTalkLongClickListener(final Function1<? super View, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "longClickAction");
        getBinding().o.setOnLongClickListener(new wt8.c(r3));
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
        e1.d(getBinding().f, new h(r3));
    }

    public void setRedDotViewVisible(boolean r2) {
        if (r2 == false) goto L4;
        getBinding().f.setVisibility(0);
        return;
    L4:
        getBinding().f.setVisibility(4);
    }

    public void setRedDotVisible(boolean r1) {
        this.l = r1;
    }

    public final void setReviewSubTitle(int r5) {
        TextView r0 = getBinding().j;
        if (r5 != (-50)) goto L5;
    L10:
        r0.setText(r0.getContext().getString(2131910375));
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), 2131102650));
    L11:
        Intrinsics.checkNotNull(r0);
        r0.setVisibility(0);
        return;
    L5:
        if (r5 == (-30)) goto L10;
        if (r5 != (-20)) goto L11;
        r0.setText(r0.getContext().getString(2131910790));
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), c.b(2130972081, r0.getContext(), 2131103143)));
        goto L11
    }

    public void setStatus(String r5) {
        Intrinsics.checkNotNullParameter(r5, "status");
        boolean r1 = true;
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        getBinding().j.setVisibility(8);
        getBinding().i.setVisibility(8);
        return;
    L10:
        if (getBinding().m.getVisibility() == 0) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L15;
        getBinding().j.setVisibility(0);
        getBinding().i.setVisibility(8);
        getBinding().j.setText(r5);
        return;
    L15:
        getBinding().j.setVisibility(8);
        getBinding().i.setVisibility(0);
        getBinding().i.setText(r5);
        return;
    L5:
        r0 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTtsBanned(boolean r3) {
        this.g = r3;
        if (r3 == false) goto L6;
        setTTSImageResource(c.b(2130971884, getContext(), 2131242245));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTtsChecked(boolean r3) {
        this.e = r3;
        if (r3 == false) goto L5;
        setTTSImageResource(c.b(2130971878, getContext(), 2131242227));
        return;
    L5:
        setTTSImageResource(c.b(2130971875, getContext(), 2131242215));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTtsContinuousTalkChecked(boolean r3) {
        if (this.r == r3) goto L9;
        this.r = r3;
        if (r3 == false) goto L7;
        setTTSContinuousTalkImageResource(c.b(2130971878, getContext(), 2131242227));
        return;
    L7:
        setTTSContinuousTalkImageResource(c.b(2130971875, getContext(), 2131242215));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTtsContinuousTalkEnabled(boolean r3) {
        if (r3 != this.n) goto L5;
        return;
    L5:
        this.n = r3;
        if (r3 == false) goto L8;
        getBinding().o.clearColorFilter();
        return;
    L8:
        getBinding().o.setColorFilter(ContextCompat.getColor(getContext(), 2131103682));
    }

    public void setTtsContinuousTalkVisible(boolean r2) {
        if (r2 != this.p) goto L5;
        return;
    L5:
        this.p = r2;
        AppCompatImageView r0 = getBinding().o;
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
        this.j = r1;
    }

    public void setTtsVisible(boolean r2) {
        if (this.q == r2) goto L10;
        this.q = r2;
        AppCompatImageView r0 = getBinding().n;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    public ChatTitle(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.c = true;
        this.f = new q(false, false);
        this.h = true;
        this.k = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = LazyKt.lazy(new wt8.a(this));
        R5(r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r20, AttributeSet r21) {
        LayoutInflater.from(r20).inflate(2131561894, this);
        int r0 = 2131362230;
        AppCompatImageView r2 = ViewBindings.findChildViewById(this, 2131362230);
        if (r2 == null) goto L33;
        r0 = 2131362231;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362231);
        if (r3 == null) goto L33;
        r0 = 2131363623;
        TitleAvatarImageView r4 = ViewBindings.findChildViewById(this, 2131363623);
        if (r4 == null) goto L33;
        r0 = 2131363779;
        AppCompatImageView r5 = ViewBindings.findChildViewById(this, 2131363779);
        if (r5 == null) goto L33;
        r0 = 2131365608;
        RedDotTextView r6 = ViewBindings.findChildViewById(this, 2131365608);
        if (r6 == null) goto L33;
        r0 = 2131379429;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(this, 2131379429);
        if (r7 == null) goto L33;
        r0 = 2131380286;
        AppCompatImageView r8 = ViewBindings.findChildViewById(this, 2131380286);
        if (r8 == null) goto L33;
        r0 = 2131387277;
        TextView r9 = (TextView) ViewBindings.findChildViewById(this, 2131387277);
        if (r9 == null) goto L33;
        r0 = 2131387625;
        TextView r10 = (TextView) ViewBindings.findChildViewById(this, 2131387625);
        if (r10 == null) goto L33;
        r0 = 2131388084;
        TextView r11 = (TextView) ViewBindings.findChildViewById(this, 2131388084);
        if (r11 == null) goto L33;
        r0 = 2131388772;
        TextView r12 = (TextView) ViewBindings.findChildViewById(this, 2131388772);
        if (r12 == null) goto L33;
        r0 = 2131388843;
        ConstraintLayout r13 = ViewBindings.findChildViewById(this, 2131388843);
        if (r13 == null) goto L33;
        r0 = 2131389944;
        AppCompatImageView r16 = ViewBindings.findChildViewById(this, 2131389944);
        if (r16 == null) goto L33;
        r0 = 2131389948;
        AppCompatImageView r17 = ViewBindings.findChildViewById(this, 2131389948);
        if (r17 == null) goto L33;
        this.b = new LarusChatTitleBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r16, r17);
        setMinHeight(i5.k0());
        setBackgroundColor(ContextCompat.getColor(r20, c.b(2130970529, r20, 2131102529)));
        return;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public ChatTitle(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.c = true;
        this.f = new q(false, false);
        this.h = true;
        this.k = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = LazyKt.lazy(new wt8.a(this));
        R5(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Ia(String r4, final com.larus.platform.api.j r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "title");
        getBinding().d.setVisibility(8);
        getBinding().m.setVisibility(0);
        z2.a.w3();
        if (r6 == false) goto L9;
        int r7 = j0.a;
        if (Intrinsics.areEqual(r4, j0.d(2131908104)) == false) goto L9;
        if (n0.a.b() == false) goto L9;
        r4 = j0.d(2131908160);
    L9:
        getBinding().l.setText(r4);
        String r8 = null;
        if (r5 == null) goto L12;
        String r9 = r5.a;
    L13:
        if (r9 != null) goto L15;
    L18:
        boolean r10 = true;
    L19:
        if (r10 == false) goto L21;
        getBinding().k.setVisibility(8);
    L25:
        post(new d(r5, this));
        return;
    L21:
        getBinding().k.setVisibility(0);
        TextView r11 = getBinding().k;
        if (r5 == null) goto L24;
        r8 = r5.a;
    L24:
        r11.setText(r8);
        goto L25
    L15:
        if (r9.length() == 0) goto L18;
        r10 = false;
        goto L19
    L12:
        r9 = null;
        goto L13
    }

    public final void Sa(String r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "iconUri");
        Intrinsics.checkNotNullParameter(r7, "iconUrl");
        if (r8 == true) goto L5;
        return;
    L5:
        boolean r0 = false;
        getBinding().d.setVisibility(0);
        getBinding().m.setVisibility(8);
        String r9 = UriProtector.parse(r7).getPath();
        if (r9 == null) goto L16;
        String r10 = StringsKt.substringBefore$default(r9, ".jpg", null, 2, null);
        if (r10 == null) goto L16;
        String r11 = StringsKt.substringBefore$default(r10, ".png", null, 2, null);
        if (r11 == null) goto L16;
        String r12 = StringsKt.substringBefore$default(r11, ".jpeg", null, 2, null);
        if (r12 == null) goto L16;
        String r13 = StringsKt.substringBefore$default(r12, ".webp", null, 2, null);
        if (r13 == null) goto L16;
    L17:
        FLogger.a.i("YCHYCH", "icon tag = " + r13 + " pre = " + this.a);
        if (r6.length() <= 0) goto L20;
        r0 = true;
    L20:
        if (r0 == true) goto L22;
    L24:
        this.a = r13;
        ImageLoaderKt.v(getBinding().d, r7, "chat.bot_avatar", null, new b(this));
        return;
    L22:
        if (Intrinsics.areEqual(this.a, r13) == false) goto L24;
        return;
    L16:
        r13 = "";
        goto L17
    }

    public final void Fa(String r3, boolean r4, int r5, View.OnClickListener r6) {
        TextView r7 = getBinding().j;
        r7.setText(r3);
        r7.setTextColor(ContextCompat.getColor(r7.getContext(), c.b(2130972081, r7.getContext(), 2131103143)));
        Intrinsics.checkNotNull(r7);
        if (o0.d(r3) == false) goto L5;
        int r8 = 0;
    L6:
        r7.setVisibility(r8);
        return;
    L5:
        r8 = 8;
        goto L6
    }
}
