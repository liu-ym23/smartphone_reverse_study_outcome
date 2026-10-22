package com.larus.bmhome.chat.layout.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.ConversationCellIcon;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusLayoutCvsItemRightActionBinding;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.z2;
import com.larus.trace.RealtimeCallEntry;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tx9.c3;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002\"#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\u000f*\u00020\u001d2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/CvsItemRightAction;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/databinding/LarusLayoutCvsItemRightActionBinding;", "easeOutAnimator", "Landroid/animation/ObjectAnimator;", "setRedDotUnreadCount", "", "unreadCount", "applyRoundBadgeStyle", "setupRealtimeCallAction", "config", "Lcom/larus/audio/bean/ConversationCellIcon;", "param", "Lcom/larus/bmhome/chat/layout/widget/CvsItemRightAction$RightActonParams;", "setupRealtimeCallIcon", "resetRedDotAndShowRealtimeCallIcon", "switchVisibleIconWithAnim", "onNext", "Lkotlin/Function0;", "startEaseOutAnim", "Landroid/view/View;", "reset", "clickRectView", "setupOnRealtimeCallEnabled", "setup", "Companion", "RightActonParams", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CvsItemRightAction extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    public final LarusLayoutCvsItemRightActionBinding a;
    public ObjectAnimator b;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final int b;
        public final BotModel c;
        public final wc9.e d;
        public final Fragment e;
        public final View f;
        public final RecommendFrom g;
        public final String h;
        public final boolean i;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            BotModel r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            wc9.e r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((((r4 + r6) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            RecommendFrom r8 = this.g;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.h;
            if (r11 == null) goto L18;
            r2 = r11.hashCode();
        L18:
            int r12 = (r10 + r2) * 31;
            if (this.i == false) goto L21;
            int r13 = 1231;
        L23:
            return r12 + r13;
        L21:
            r13 = 1237;
            goto L23
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "RightActonParams(messageId=" + this.a + ", unreadCount=" + this.b + ", botModel=" + this.c + ", conversation=" + this.d + ", fragment=" + this.e + ", clickRectView=" + this.f + ", recommendFrom=" + this.g + ", botPosition=" + this.h + ", isRealtimeCallEnabled=" + this.i + ')';
        }

        public b(String r2, int r3, BotModel r4, wc9.e r5, Fragment r6, View r7, RecommendFrom r8, String r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r6, "fragment");
            Intrinsics.checkNotNullParameter(r7, "clickRectView");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public static final class c extends BaseControllerListener<Object> {
        public final /* synthetic */ b a;
        public final /* synthetic */ CvsItemRightAction b;
        public final /* synthetic */ ConversationCellIcon c;

        public final void onFailure(String r4, Throwable r5) {
            super.onFailure(r4, r5);
            FLogger.a.i("CvsItemRightAction", "[resetRedDotAndShowRealtimeCallIcon] onFailure, messageId:" + this.a.a);
            CvsItemRightAction r6 = this.b;
            ConversationCellIcon r7 = this.c;
            b r0 = this.a;
            int r1 = CvsItemRightAction.c;
            r6.getClass();
            r0.f.setClickable(true);
            com.larus.utils.e1.x(r0.f);
            com.larus.utils.e1.d(r0.f, new b0(r0, r7, r6));
        }

        public c(b r1, CvsItemRightAction r2, ConversationCellIcon r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
            super.onFinalImageSet(r3, r4, r5);
            FLogger.a.i("CvsItemRightAction", "[resetRedDotAndShowRealtimeCallIcon] onFinalImageSet, messageId:" + this.a.a);
            CvsItemRightAction r6 = this.b;
            ConversationCellIcon r7 = this.c;
            b r8 = this.a;
            int r0 = CvsItemRightAction.c;
            r6.getClass();
            r8.f.setClickable(true);
            com.larus.utils.e1.x(r8.f);
            com.larus.utils.e1.d(r8.f, new b0(r8, r7, r6));
        }
    }

    static {
    }

    public CvsItemRightAction(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CvsItemRightAction(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final void setRedDotUnreadCount(final int r4) {
        boolean r0 = false;
        if (r4 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L14;
        b(r4);
        if (this.a.d.getVisibility() != 0) goto L10;
        r0 = true;
    L10:
        if (r0 == false) goto L12;
        e(new x(r4, this));
        return;
    L12:
        FLogger.a.i("CvsItemRightAction", "[iconVisibilityChanged] show messageRedDot, unreadCount=" + r4);
        this.a.c.z(r4);
        return;
    L14:
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final void setupOnRealtimeCallEnabled(b r2) {
        int r0 = r2.b;
        if (r0 <= 0) goto L5;
        setRedDotUnreadCount(r0);
        return;
    L5:
        setupRealtimeCallIcon(r2);
    }

    private final void setupRealtimeCallIcon(final b r8) {
        wc9.e r0 = r8.d;
        if (r0 != null) goto L6;
        FLogger.a.e("CvsItemRightAction", "[setupRealtimeCallIcon] conversation is null");
        c(r8.f);
        return;
    L6:
        BotModel r2 = r8.c;
        boolean r3 = false;
        if (r2 != null) goto L10;
        FLogger.a.i("CvsItemRightAction", "[setupRealtimeCallIcon] botModel is null");
        this.a.c.z(0);
        return;
    L10:
        com.larus.audio.p0 r4 = AudioServiceDelegate.a.getAudioConfig();
        String r5 = r2.getBotId();
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        Integer r1 = r0.v;
        if (r1 == null) goto L16;
        int r6 = r1.intValue();
    L17:
        final ConversationCellIcon r7 = r4.q(r5, r6);
        final String r9 = "{msgId:" + r8.a + ", name:" + r8.d.c + ", botId:" + r8.c.getBotId() + '}';
        if (r7 == null) goto L25;
        FLogger r10 = FLogger.a;
        r10.i("CvsItemRightAction", "[setupRealtimeCallIcon] " + r9 + ", config=" + r7);
        if (this.a.c.getVisibility() != 0) goto L22;
        r3 = true;
    L22:
        if (r3 == false) goto L24;
        e(new y(r9, this, r7, r8));
        return;
    L24:
        r10.i("CvsItemRightAction", "[iconVisibilityChanged] show realtimeCallIcon, " + r9);
        d(r7, r8);
        return;
    L25:
        FLogger.a.i("CvsItemRightAction", "[setupRealtimeCallIcon] config is null, " + r9);
        c(r8.f);
        return;
    L16:
        r6 = 0;
        goto L17
    }

    public final void b(int r4) {
        if (z2.a.getChatNavigatorConfig().g != 1) goto L6;
        this.a.c.setForceCircleBadgeDiameter(Integer.valueOf(i5.C()));
        this.a.c.setTextSize(0, i5.h());
        FLogger.a.i("CvsItemRightAction", "[applyBadgeAppearanceIfNeeded] apply experimental badge style, unreadCount=" + r4);
        return;
    }

    public final void c(View r4) {
        LarusLayoutCvsItemRightActionBinding r0 = this.a;
        r0.d.setAlpha(1.0f);
        r0.c.setAlpha(1.0f);
        com.larus.utils.e1.o(r0.d);
        com.larus.utils.e1.o(r0.c);
        r4.setClickable(false);
        com.larus.utils.e1.o(r4);
    }

    public final void e(final Function0<Unit> r8) {
        if (this.a.c.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        RedDotTextView r1 = this.a.c;
    L15:
        if (r1 == null) goto L17;
        PathInterpolator r3 = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{0.0f});
        r2.setDuration(150);
        r2.setInterpolator(r3);
        r2.addListener(new CvsItemRightAction$startEaseOutAnim$1$1(r8));
        this.b = r2;
        r2.start();
        return;
    L17:
        r8.invoke();
        return;
    L9:
        if (this.a.d.getVisibility() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        r1 = this.a.d;
        goto L15
    L14:
        r1 = null;
        goto L15
    L11:
        r4 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public final void setup(final b r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        com.larus.utils.e1.o(this.a.d);
        com.larus.utils.e1.o(this.a.c);
        post(new z(r2, this));
    }

    public static void a(b r4, CvsItemRightAction r5) {
        StringBuilder r0 = new StringBuilder("{msgId:");
        r0.append(r4.a);
        r0.append(", name:");
        wc9.e r1 = r4.d;
        if (r1 == null) goto L5;
        String r2 = r1.c;
    L6:
        r0.append(r2);
        r0.append(", unreadCount:");
        r0.append(r4.b);
        r0.append(", isRealtimeCallEnabled:");
        r0.append(r4.i);
        r0.append('}');
        String r3 = r0.toString();
        FLogger.a.i("CvsItemRightAction", "[setup] " + r3);
        ObjectAnimator r6 = r5.b;
        if (r6 == null) goto L9;
        r6.cancel();
    L9:
        r5.c(r4.f);
        if (r4.i == false) goto L23;
        r5.setupOnRealtimeCallEnabled(r4);
        BotModel r7 = r4.c;
        if (r7 == null) goto L19;
        Integer r8 = r7.getBotType();
        if (r8 == null) goto L19;
        boolean r9 = true;
        if (r8.intValue() != 1) goto L19;
    L20:
        if (r9 == false) goto L22;
        c3.c(RealtimeCallEntry.LIST_MAIN_ICON);
        return;
    L22:
        c3.c(RealtimeCallEntry.LIST_UGC_BOTS_ICON);
        return;
    L19:
        r9 = false;
        goto L20
    L23:
        com.larus.utils.e1.o(r5.a.d);
        r5.b(r4.b);
        r5.a.c.z(r4.b);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void d(final ConversationCellIcon r4, final b r5) {
        this.a.c.z(0);
        SimpleDraweeView r0 = this.a.d;
        Intrinsics.checkNotNull(r0);
        com.larus.utils.e1.x(r0);
        ImageLoaderKt.v(r0, r4.getIconUrl(), "chat.list_right_action_icon", null, new a0(r5, this, r4));
    }

    public CvsItemRightAction(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131562799, this);
        int r5 = 2131374739;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(this, 2131374739);
        if (r6 == null) goto L11;
        r5 = 2131380006;
        RedDotTextView r7 = ViewBindings.findChildViewById(this, 2131380006);
        if (r7 == null) goto L11;
        r5 = 2131383807;
        SimpleDraweeView r0 = ViewBindings.findChildViewById(this, 2131383807);
        if (r0 == null) goto L11;
        this.a = new LarusLayoutCvsItemRightActionBinding(this, r6, r7, r0);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ CvsItemRightAction(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
