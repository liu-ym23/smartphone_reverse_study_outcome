package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.reaction.loader.ReactionLoaderManager;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J6\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020!H\u0002J\b\u00100\u001a\u00020!H\u0002J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020&H\u0002J\u0010\u00105\u001a\u00020!2\u0006\u00104\u001a\u00020(H\u0002J\u0018\u00106\u001a\u00020!2\u0006\u00104\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u00107\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00104\u001a\u00020&H\u0002J\b\u00109\u001a\u00020!H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u00104\u001a\u00020,H\u0002J\b\u0010;\u001a\u00020!H\u0002J\u0010\u0010<\u001a\u00020!2\u0006\u00104\u001a\u00020.H\u0002J\b\u0010=\u001a\u00020!H\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006@"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedPreviewView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "feedActionViewList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedReactionView;", "reactionDivider", "Landroidx/appcompat/widget/AppCompatImageView;", "reactionCountText", "Landroid/widget/TextView;", "markViewComponent", "Lcom/ss/android/lark/feed/cardcomponent/preview/MarkViewComponent;", "markTextComponent", "Lcom/ss/android/lark/feed/cardcomponent/preview/MarkTextComponent;", "digestComponent", "Lcom/ss/android/lark/feed/cardcomponent/preview/DigestComponent;", "aiSmartReplyComponent", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedAISmartReplyComponent;", "feedVCHardwareComponent", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedVCHardwareStatusComponent;", "emojiCallbackList", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedPreviewView$EmojiCallback;", "getEmojiCallbackList", "()Ljava/util/List;", "emojiCallbackList$delegate", "Lkotlin/Lazy;", "init", BuildConfig.FLAVOR, "bindPreview", "reactionParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedPreviewComponent$FeedReactionParams;", "markViewParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/MarkViewComponent$MarkViewParams;", "markTextParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/MarkTextComponent$MarkTextParams;", "digestParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/DigestComponent$DigestParams;", "aiSmartReplyParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedAISmartReplyComponent$FeedAISmartReplyParams;", "vcHardwareStatusParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedVCHardwareStatusComponent$FeedVCHardwareStatusParams;", "createReactionDivider", "createReactionCount", "createMarkView", "createMarkText", "bindMarkView", "params", "bindMarkText", "createReactionView", "bindDigestView", "processLastMessageMark", "createAISmartReplyView", "bindAISmartReplyView", "createVCHardwareView", "bindVCHardwareView", "onDetachedFromWindow", "Companion", "EmojiCallback", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedPreviewView extends LinearLayout {
    public MarkViewComponent a;
    public d b;
    public com.ss.android.lark.feed.cardcomponent.preview.a c;
    public b d;
    public FeedVCHardwareStatusComponent e;
    public final Lazy f;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedPreviewView$EmojiCallback;", "Lcom/larksuite/framework/callback/UIGetDataCallback;", BuildConfig.FLAVOR, "callbackList", BuildConfig.FLAVOR, "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "key", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;Landroidx/appcompat/widget/AppCompatImageView;Ljava/lang/String;)V", "onSuccessed", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "(Ljava/lang/Boolean;)V", "onErrored", Keys.API_RETURN_KEY_ERROR, "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
            Intrinsics.checkNotNullParameter(r4, "key");
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

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getEmojiCallbackList().clear();
    }

    public FeedPreviewView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public FeedPreviewView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 0);
        new ArrayList();
        this.f = LazyKt.lazy(FeedPreviewView$emojiCallbackList$2.INSTANCE);
        FeedVCHardwareStatusComponent r5 = new FeedVCHardwareStatusComponent(getContext());
        this.e = r5;
        FeedVCStatusIconView r6 = r5.c();
        FeedVCHardwareStatusComponent r0 = this.e;
        com.ss.android.lark.feed.cardcomponent.preview.a r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedVCHardwareComponent");
        r0 = null;
    L5:
        addView(r6, r0.b());
        b r7 = new b(getContext());
        this.d = r7;
        FeedAISmartReplyView r8 = r7.c();
        b r2 = this.d;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("aiSmartReplyComponent");
        r2 = null;
    L8:
        addView(r8, r2.b());
        MarkViewComponent r9 = new MarkViewComponent(getContext());
        this.a = r9;
        AppCompatImageView r10 = r9.c();
        MarkViewComponent r11 = this.a;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("markViewComponent");
        r11 = null;
    L11:
        addView(r10, r11.b());
        d r12 = new d(getContext());
        this.b = r12;
        TextView r13 = r12.c();
        d r14 = this.b;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("markTextComponent");
        r14 = null;
    L14:
        addView(r13, r14.b());
        com.ss.android.lark.feed.cardcomponent.preview.a r15 = new com.ss.android.lark.feed.cardcomponent.preview.a(r3);
        this.c = r15;
        View r16 = r15.c();
        com.ss.android.lark.feed.cardcomponent.preview.a r17 = this.c;
        if (r17 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("digestComponent");
    L18:
        addView(r16, r1.b());
        return;
    L17:
        r1 = r17;
        goto L18
    }
}
