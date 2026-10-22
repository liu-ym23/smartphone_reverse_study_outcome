package com.ss.android.lark.flow.feed.component.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.feed.cardcomponent.preview.FeedDigestTextView;
import com.ss.android.lark.feed.cardcomponent.preview.FeedReactionView;
import com.ss.android.lark.feed.cardcomponent.preview.c;
import com.ss.android.lark.flow.feed.component.text_layer.FlowTextLayerView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.reaction.loader.ReactionLoaderManager;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020\u001bH\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/preview/FlowPreviewView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "feedActionViewList", "", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedReactionView;", "reactionDivider", "Landroidx/appcompat/widget/AppCompatImageView;", "reactionCountText", "Landroid/widget/TextView;", "digestComponent", "Lcom/ss/android/lark/feed/cardcomponent/preview/DigestComponent;", "flowTextLayerComponent", "Lcom/ss/android/lark/flow/feed/component/text_layer/FlowTextLayerComponent;", "emojiCallbackList", "Lcom/ss/android/lark/flow/feed/component/preview/FlowPreviewView$EmojiCallback;", "getEmojiCallbackList", "()Ljava/util/List;", "emojiCallbackList$delegate", "Lkotlin/Lazy;", "init", "", "bindPreview", "reactionParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedPreviewComponent$FeedReactionParams;", "digestParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/DigestComponent$DigestParams;", "flowParams", "Lcom/ss/android/lark/flow/feed/component/text_layer/FlowTextLayerComponent$FlowTextLayerParams;", "createReactionDivider", "createReactionCount", "bindFlowPreviewText", "params", "createReactionView", "hideReactionView", "bindDigestView", "onDetachedFromWindow", "Companion", "EmojiCallback", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowPreviewView extends LinearLayout {
    public final List<FeedReactionView> a;
    public AppCompatImageView b;
    public TextView c;
    public com.ss.android.lark.feed.cardcomponent.preview.a d;
    public com.ss.android.lark.flow.feed.component.text_layer.a e;
    public final Lazy f;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/preview/FlowPreviewView$EmojiCallback;", "Lcom/larksuite/framework/callback/UIGetDataCallback;", "", "callbackList", "", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", TabAppInfo.IMAGE_JSON_KEY, "", "<init>", "(Ljava/util/List;Landroidx/appcompat/widget/AppCompatImageView;Ljava/lang/String;)V", "onSuccessed", "", "data", "(Ljava/lang/Boolean;)V", "onErrored", "error", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class EmojiCallback extends UIGetDataCallback<Boolean> {
        private final List<EmojiCallback> callbackList;
        private final AppCompatImageView imageView;
        private final String key;

        public void onErrored(ErrorResult r1) {
            super.onErrored(r1);
            this.callbackList.remove(this);
        }

        public void onSuccessed(Boolean r3) {
            super.onSuccessed(r3);
            this.callbackList.remove(this);
            ReactionLoaderManager r4 = ReactionLoaderManager.b.a;
            ReactionLoaderManager.d(this.imageView, this.key, null);
        }

        public /* bridge */ /* synthetic */ void onSuccessed(Object r1) {
            onSuccessed((Boolean) r1);
        }

        public EmojiCallback(List<EmojiCallback> r2, AppCompatImageView r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "callbackList");
            Intrinsics.checkNotNullParameter(r3, "imageView");
            Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
            this.callbackList = r2;
            this.imageView = r3;
            this.key = r4;
            r2.add(this);
        }
    }

    public static final class a {
    }

    static {
    }

    private final List<EmojiCallback> getEmojiCallbackList() {
        return (List) this.f.getValue();
    }

    public final void b() {
        AppCompatImageView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        TextView r1 = this.c;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
    L9:
        if ((!this.a.isEmpty()) == false) goto L14;
        Iterator<T> r2 = this.a.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        ((FeedReactionView) r2.next()).setVisibility(8);
        goto L12
    L16:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getEmojiCallbackList().clear();
    }

    public FlowPreviewView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public FlowPreviewView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 0);
        this.a = new ArrayList();
        this.f = LazyKt.lazy(FlowPreviewView$emojiCallbackList$2.INSTANCE);
        setGravity(16);
        com.ss.android.lark.flow.feed.component.text_layer.a r0 = new com.ss.android.lark.flow.feed.component.text_layer.a(r3);
        this.e = r0;
        addView(r0.c(), r0.b());
        com.ss.android.lark.feed.cardcomponent.preview.a r1 = new com.ss.android.lark.feed.cardcomponent.preview.a(r3);
        this.d = r1;
        View r2 = r1.c();
        ViewGroup.MarginLayoutParams r5 = r1.b();
        setGravity(16);
        r5.setMarginEnd(UIUtils.dp2px(r3, 12.0f));
        Unit r6 = Unit.INSTANCE;
        addView(r2, r5);
    }

    public final void a(c r13, com.ss.android.lark.feed.cardcomponent.preview.a.b r14, com.ss.android.lark.flow.feed.component.text_layer.a.C0046a r15) {
        Intrinsics.checkNotNullParameter(r13, "reactionParams");
        Intrinsics.checkNotNullParameter(r14, "digestParams");
        if (r15 != null) goto L5;
    L13:
        getEmojiCallbackList().clear();
        if ((!r13.a.isEmpty()) == true) goto L16;
    L61:
        b();
    L63:
        if (r15 == null) goto L67;
        com.ss.android.lark.flow.feed.component.text_layer.a r0 = this.e;
        if (r0 == null) goto L67;
        Intrinsics.checkNotNullParameter(r15, "data");
        ((FlowTextLayerView) r0.c()).a(r15);
    L67:
        com.ss.android.lark.feed.cardcomponent.preview.a r16 = this.d;
        if (r16 == null) goto L76;
        Intrinsics.checkNotNullParameter(r14, "data");
        FeedDigestTextView r17 = r16.c();
        List r1 = r14.a;
        String r2 = r14.b;
        String r3 = r14.c;
        int r4 = r14.e;
        r17.b = r2;
        r17.c = r3;
        r17.a = r1;
        r17.d = new FeedDigestTextView.setDigest.spannableString.1.1(r17, r4);
        r17.setText(r17.x(r1, r17.d, r4));
        r16.c().setTextColor(UIUtils.getColor(r16.getContext(), r14.d));
        return;
    L76:
        return;
    L16:
        if (r13.c == true) goto L61;
        if (this.b != null) goto L21;
        AppCompatImageView r5 = new AppCompatImageView(getContext());
        r5.setImageResource(2131256454);
        this.b = r5;
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
        r6.gravity = 16;
        r6.rightMargin = UIHelper.dp2px(6.0f);
        r6.leftMargin = UIHelper.dp2px(2.0f);
        addView(this.b, 0, r6);
    L21:
        if (this.c != null) goto L23;
        TextView r7 = new TextView(getContext());
        r7.setGravity(17);
        r7.setTextSize(2, 11.0f);
        r7.setTextColor(UIUtils.getColor(r7.getContext(), 2131103457));
        this.c = r7;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, UIHelper.dp2px(18.0f));
        r8.gravity = 16;
        r8.rightMargin = UIHelper.dp2px(4.0f);
        addView(this.c, 0, r8);
    L23:
        float r9 = getMeasuredWidth();
        TextView r10 = this.c;
        if (r10 == null) goto L60;
        int r11 = RangesKt.coerceAtLeast((int) (((r9 - r10.getPaint().measureText("...")) / (UIHelper.dp2px(18.0f) + UIHelper.dp2px(4.0f))) - 1), 6);
        int r12 = r13.a.size();
        int r18 = r13.b;
        if (r18 <= 0) goto L28;
        int r19 = RangesKt.coerceAtMost(r18, r12);
    L29:
        int r20 = RangesKt.coerceAtMost(r19, r11);
        if (r12 <= r20) goto L34;
        TextView r21 = this.c;
        if (r21 == null) goto L37;
        r21.setVisibility(0);
        r21.setText("...");
    L37:
        if (r20 != r11) goto L41;
        AppCompatImageView r22 = this.b;
        if (r22 == null) goto L45;
        r22.setVisibility(8);
    L45:
        if (r20 < ((ArrayList) this.a).size()) goto L47;
        int r23 = ((ArrayList) this.a).size();
    L50:
        if (r23 >= r20) goto L52;
        View r24 = new FeedReactionView(getContext(), null, 0, r13.f, 6);
        r24.setShowBackground(r13.d);
        LinearLayout.LayoutParams r25 = new LinearLayout.LayoutParams(-2, -2);
        r25.gravity = 16;
        addView(r24, 0, r25);
        ListProtector.add(this.a, 0, r24);
        r23 = r23 + 1;
    L52:
        int r26 = 0;
    L53:
        if (r26 >= r20) goto L63;
        FeedReactionView r27 = (FeedReactionView) ListProtector.get(this.a, r26);
        Reaction r28 = (Reaction) ListProtector.get(r13.a, r26);
        r27.setVisibility(0);
        if (r13.e == false) goto L57;
        int r29 = r28.getCount();
    L58:
        r27.setReactionCount(r29);
        EmojiCallback r30 = new EmojiCallback(getEmojiCallbackList(), r27.getReactionIcon(), r28.getType());
        ReactionLoaderManager r31 = ReactionLoaderManager.b.a;
        ReactionLoaderManager.d(r27.getReactionIcon(), r28.getType(), r30);
        r26 = r26 + 1;
        goto L53
    L57:
        r29 = 0;
    L47:
        if (((ArrayList) this.a).size() <= r20) goto L52;
        removeView((FeedReactionView) ListProtector.remove(this.a, 0));
        goto L47
    L41:
        AppCompatImageView r32 = this.b;
        if (r32 == null) goto L45;
        r32.setVisibility(0);
        goto L45
    L34:
        TextView r33 = this.c;
        if (r33 == null) goto L37;
        r33.setVisibility(8);
        goto L37
    L28:
        r19 = r12;
        goto L29
    L60:
        throw new IllegalStateException("Required value was null.".toString());
    L5:
        if (r15.a == false) goto L7;
    L9:
        boolean r34 = false;
    L10:
        if (r34 == true) goto L13;
        b();
        goto L63
    L7:
        if (r15.b > 0) goto L9;
        r34 = true;
        goto L10
    }
}
