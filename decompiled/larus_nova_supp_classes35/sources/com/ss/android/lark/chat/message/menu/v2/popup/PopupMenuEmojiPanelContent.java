package com.ss.android.lark.chat.message.menu.v2.popup;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.message.menu.v2.DragPanelLayout;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.emoji.BuiltInEmojiPanelView;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.ss.android.lark.chat.message.menu.v2.l0;
import com.ss.android.lark.chat.message.menu.v2.o0;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001$\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020(H\u0002J*\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010-H\u0002R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006."}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuEmojiPanelContent;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "getPanelType", "()Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "shadowTarget", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "getShadowTarget", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "menuContext", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "getMenuContext", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "setMenuContext", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;)V", "onReactionClickListener", "Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;", "getOnReactionClickListener", "()Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;", "setOnReactionClickListener", "(Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;)V", "dragPanelLayout", "Lcom/ss/android/lark/chat/message/menu/v2/DragPanelLayout;", "startTransY", BuildConfig.FLAVOR, "panelDragLayoutChangeListener", "com/ss/android/lark/chat/message/menu/v2/popup/PopupMenuEmojiPanelContent$panelDragLayoutChangeListener$1", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuEmojiPanelContent$panelDragLayoutChangeListener$1;", "computeHalfTranslationY", "isFullExpanded", BuildConfig.FLAVOR, "startRestoreAnimator", BuildConfig.FLAVOR, "endTransY", "endAction", "Lkotlin/Function0;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuEmojiPanelContent extends FrameLayout implements IPopupMenuContent {
    public final PanelType a;
    public final IPopupMenuContent.ShadowTarget b;
    public d c;
    public o0 d;
    public final DragPanelLayout e;
    public float f;

    public static final class a implements com.ss.android.lark.newemoji.emoji_list.adapter.e {
        public final /* synthetic */ PopupMenuEmojiPanelContent a;

        public a(PopupMenuEmojiPanelContent r1) {
            this.a = r1;
        }

        public final void a(String r4, s5c.d r5) {
            Intrinsics.checkNotNullParameter(r4, "reactionKey");
            Intrinsics.checkNotNullParameter(r5, "param");
            o0 r0 = this.a.getOnReactionClickListener();
            if (r0 == null) goto L5;
            r0.a(r4, 2);
        L5:
            d r6 = this.a.getMenuContext();
            if (r6 == null) goto L10;
            com.ss.android.lark.chat.message.menu.v2.popup.a r7 = r6.a();
            if (r7 == null) goto L10;
            i0.a(r7, false, null, 7);
        L10:
            int r8 = com.ss.android.lark.reaction.widget.panel.a.a;
            Intrinsics.checkNotNullParameter(r5, "extraParams");
            Statistics.sendEvent("public_reaction_panel_select_click", r5.toJson());
        }

        public final void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "reactionKey");
            Intrinsics.checkNotNullParameter(r3, "skinedKey");
            k2c.a.a().Wc(r2, r3);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ PopupMenuEmojiPanelContent b;

        public b(DragPanelLayout r1, PopupMenuEmojiPanelContent r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DragPanelLayout r0 = this.b.e;     // Catch: Throwable -> L11
            DragPanelLayout r2 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");     // Catch: Throwable -> L11
            r0 = null;
        L5:
            r0.setTranslationY(PopupMenuEmojiPanelContent.a(this.b));     // Catch: Throwable -> L11
            DragPanelLayout r1 = this.b.e;     // Catch: Throwable -> L11
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");     // Catch: Throwable -> L11
        L9:
            r2.setInterceptChildMove(true);     // Catch: Throwable -> L11
            return;
        L8:
            r2 = r1;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public PopupMenuEmojiPanelContent(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PopupMenuEmojiPanelContent(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final d getMenuContext() {
        return this.c;
    }

    public final o0 getOnReactionClickListener() {
        return this.d;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public PanelType getPanelType() {
        return this.a;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public IPopupMenuContent.ShadowTarget getShadowTarget() {
        return this.b;
    }

    public static final float a(PopupMenuEmojiPanelContent r2) {
        DragPanelLayout r3 = r2.e;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");
        r3 = null;
    L5:
        float r4 = r3.getHeight();
        if (r4 > 0.0f) goto L9;
        return 0.0f;
    L9:
        return RangesKt.coerceAtLeast(r4 - (0.46f * r4), 0.0f);
    }

    public final void setMenuContext(d r1) {
        this.c = r1;
    }

    public final void setOnReactionClickListener(o0 r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v14, types: [android.view.View, android.widget.FrameLayout, com.ss.android.lark.chat.message.menu.v2.emoji.BuiltInEmojiPanelView, com.ss.android.lark.newemoji.emoji_list.EmojiListView] */
    public PopupMenuEmojiPanelContent(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.a = PanelType.EMOJI;
        this.b = IPopupMenuContent.ShadowTarget.NONE;
        l0 r10 = new PopupMenuEmojiPanelContent$panelDragLayoutChangeListener$1(this);
        Resources r11 = r7.getResources();
        boolean r0 = true;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, RangesKt.coerceAtLeast((int) (WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).heightPixels * 0.91f), 1));
        r1.gravity = 80;
        setLayoutParams(r1);
        LayoutInflater.from(r7).inflate(2131564243, this, true);
        DragPanelLayout r12 = (DragPanelLayout) findViewById(2131371539);
        this.e = r12;
        Message.Type r3 = null;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");
        DragPanelLayout r4 = null;
    L6:
        r4.setListener(r10);
        if (r12 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");
        r12 = null;
    L9:
        OneShotPreDrawListener.add(r12, new b(r12, this));
        FrameLayout r13 = (FrameLayout) findViewById(2131362512);
        ?? r14 = new BuiltInEmojiPanelView(r7);
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        int r2 = UIUtils.dp2px(r7, 28.0f);
        int r5 = UIUtils.dp2px(r7, 50.0f);
        int r6 = UIUtils.dp2px(r7, 40.0f);
        int r15 = UIUtils.dp2px(r7, 16.0f);
        r14.e = r2;
        r14.f = r5;
        r14.g = r6;
        r14.h = r15;
        if (r14.getWidth() <= 0) goto L12;
        r14.e();
    L12:
        r14.setOnEmojiSelectListener(new a(this));
        d r16 = this.c;
        if (r16 == null) goto L20;
        yya.a r17 = r16.a;
        if (r17 == null) goto L20;
        v5b.c r18 = r17.m();
        if (r18 == null) goto L20;
        r3 = r18.getType();
    L20:
        if (r3 == Message.Type.DOUBAO) goto L23;
        r0 = false;
    L23:
        r14.setLikeInFront(r0);
        r13.addView(r14);
        return;
    L5:
        r4 = r12;
        goto L6
    }

    public /* synthetic */ PopupMenuEmojiPanelContent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final void b(PopupMenuEmojiPanelContent r2, float r3, float r4, Function0 r5) {
        r2.getClass();
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{r3, r4});
        r6.setDuration(50);
        r6.setInterpolator(new AccelerateInterpolator());
        r6.addUpdateListener(new e(r2));
        r6.addListener(new f(r5));
        r6.start();
    }
}
