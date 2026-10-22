package com.ss.android.lark.chat.message.menu.v2.emoji;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.ss.android.lark.chat.message.menu.v2.j0;
import com.ss.android.lark.chat.message.menu.v2.o0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.adapter.e;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.RecentUsedEmojiView;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u00016B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nJ\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0012J\u0010\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010\u0014J(\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0014J\b\u0010,\u001a\u00020\u001eH\u0002J\u0016\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\nH\u0002J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0002J\b\u00105\u001a\u00020\u0014H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/emoji/BuiltInTopEmojiView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "showColumn", "emojiHeightPx", "emojiContainerHeightPx", "emojiContainerWidthPx", "panelHorizontalPaddingPx", "likeInFront", BuildConfig.FLAVOR, "moreIconView", "Landroid/view/View;", "recentEmojiView", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/view/RecentUsedEmojiView;", "moreView", "Landroid/widget/FrameLayout;", "panelControl", "Lcom/ss/android/lark/chat/message/menu/v2/PanelControl;", "reactionClickListener", "Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;", "setEmojiSize", BuildConfig.FLAVOR, "emojiHeight", "emojiContainerHeight", "emojiContainerWidth", "panelHorizontalPadding", "setLikeInFront", "value", "setMoreIconView", "view", "onSizeChanged", SRStrategy.MEDIAINFO_KEY_WIDTH, "h", "oldw", "oldh", "initView", "setListener", "control", "computeReactionParams", "Lcom/ss/android/lark/newemoji/emoji_list/CreateItemParams;", "parentWidth", "prepareEmojiData", BuildConfig.FLAVOR, "Lcom/ss/android/lark/newemoji/emoji_list/EmojiItemData$Emoji;", "createDefaultMoreIconView", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BuiltInTopEmojiView extends LinearLayout {
    public final int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public View g;
    public RecentUsedEmojiView h;
    public FrameLayout i;
    public j0 j;
    public o0 k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BuiltInTopEmojiView a;

        public b(BuiltInTopEmojiView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Log.i("BuiltInTopEmojiView", "more view clicked, start switch panel");
            j0 r3 = this.a.j;
            if (r3 == null) goto L6;
            r3.a(PanelType.EMOJI);
            return;
        }
    }

    public static final class c implements e {
        public final /* synthetic */ BuiltInTopEmojiView a;

        public final void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "reactionKey");
            Intrinsics.checkNotNullParameter(r3, "skinedKey");
        }

        public c(BuiltInTopEmojiView r1) {
            this.a = r1;
        }

        public final void a(String r4, d r5) {
            Intrinsics.checkNotNullParameter(r4, "reactionKey");
            Intrinsics.checkNotNullParameter(r5, "param");
            o0 r0 = this.a.k;
            if (r0 == null) goto L5;
            r0.a(r4, 0);
        L5:
            j0 r6 = this.a.j;
            if (r6 == null) goto L8;
            i0.a(r6, false, null, 7);
        L8:
            int r7 = com.ss.android.lark.reaction.widget.panel.a.a;
            Intrinsics.checkNotNullParameter(r5, "extraParams");
            Statistics.sendEvent("public_reaction_panel_select_click", r5.toJson());
        }
    }

    static {
    }

    public final void a() {
        removeAllViews();
        int r1 = getWidth();
        int r11 = this.b;
        int r12 = this.c;
        int r13 = this.d;
        int r14 = this.e;
        int r10 = this.a;
        int r3 = r10 - 1;
        int r5 = ((r1 - (r13 * r10)) - (r14 * 2)) / r3;
        int r15 = r3 * (r13 + r5);
        int r2 = ((r1 - r15) - r13) - r14;
        ssb.a r9 = new ssb.a(r13, r12, r5, r11, r15, r14, r2, r10);
        setPadding(r14, 0, r2, 0);
        RecentUsedEmojiView r6 = null;
        RecentUsedEmojiView r4 = new RecentUsedEmojiView(getContext(), null, 6, 0);
        r4.setLayoutParams(new LinearLayout.LayoutParams(r15, r12));
        r4.setItemParams(r9);
        r4.setLines(1);
        this.h = r4;
        addView(r4);
        this.i = new FrameLayout(getContext());
        ViewGroup.LayoutParams r7 = new LinearLayout.LayoutParams(r13, r12);
        View r8 = this.i;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("moreView");
        r8 = null;
    L5:
        addView(r8, r7);
        AppCompatImageView r16 = this.g;
        if (r16 != null) goto L8;
        r16 = new AppCompatImageView(getContext());
        r16.setImageResource(2131255147);
        r16.setImageTintList(ContextCompat.getColorStateList(r16.getContext(), 2131102418));
        GradientDrawable r17 = new GradientDrawable();
        r17.setColor(ContextCompat.getColor(r16.getContext(), 2131099930));
        r17.setCornerRadius(UIHelper.dp2px(100.0f));
        r16.setBackground(r17);
        int r18 = UIHelper.dp2px(5.0f);
        r16.setPadding(r18, r18, r18, r18);
    L8:
        ViewParent r19 = r16.getParent();
        if ((r19 instanceof ViewGroup) == false) goto L11;
        ViewGroup r20 = (ViewGroup) r19;
    L12:
        if (r20 == null) goto L14;
        r20.removeView(r16);
    L14:
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(r11, r11);
        r21.gravity = 17;
        r16.setLayoutParams(r21);
        FrameLayout r22 = this.i;
        FrameLayout r23 = r22;
        if (r22 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("moreView");
        r23 = null;
    L17:
        r23.addView(r16);
        FrameLayout r24 = this.i;
        if (r24 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("moreView");
        r24 = null;
    L20:
        r24.setOnClickListener(new b(this));
        List r25 = CollectionsKt.toList(k2c.a.a().N(this.f));
        int r26 = b6b.a.a;
        List r27 = b6b.a.a(r25, n3.e);
        RecentUsedEmojiView r28 = this.h;
        if (r28 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("recentEmojiView");
    L24:
        r6.v(r27, false, new c(this));
        return;
    L23:
        r6 = r28;
        goto L24
    L11:
        r20 = null;
        goto L12
    }

    public BuiltInTopEmojiView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = 7;
        this.b = UIHelper.dp2px(30.0f);
        this.c = UIHelper.dp2px(40.0f);
        this.d = UIHelper.dp2px(42.0f);
        this.e = UIHelper.dp2px(16.0f);
        setOrientation(0);
    }

    public final void setLikeInFront(boolean r2) {
        if (this.f != r2) goto L5;
        return;
    L5:
        this.f = r2;
        if (getWidth() <= 0) goto L9;
        a();
        return;
    }

    public final void setMoreIconView(View r1) {
        this.g = r1;
        if (getWidth() <= 0) goto L6;
        a();
        return;
    }

    public BuiltInTopEmojiView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 7;
        this.b = UIHelper.dp2px(30.0f);
        this.c = UIHelper.dp2px(40.0f);
        this.d = UIHelper.dp2px(42.0f);
        this.e = UIHelper.dp2px(16.0f);
        setOrientation(0);
    }

    public BuiltInTopEmojiView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = 7;
        this.b = UIHelper.dp2px(30.0f);
        this.c = UIHelper.dp2px(40.0f);
        this.d = UIHelper.dp2px(42.0f);
        this.e = UIHelper.dp2px(16.0f);
        setOrientation(0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 <= 0) goto L7;
        if (r1 == r3) goto L8;
        Log.i("BuiltInTopEmojiView", "onSizeChanged, w: " + r1 + ", oldw: " + r3);
        a();
        return;
    L8:
        return;
    }
}
