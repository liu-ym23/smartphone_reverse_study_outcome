package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.EmojiProperty;
import com.ss.android.lark.feed.app.entity.TextProperty;
import com.ss.android.lark.feed.app.entity.TextWithEmojiProperty;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u000bJ8\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0007J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J0\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u0016H\u0014R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedDigestTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDigestMessage", BuildConfig.FLAVOR, "Lcom/ss/android/lark/feed/app/entity/DigestElement;", "prefix", BuildConfig.FLAVOR, "suffix", "emojiCallback", "Lcom/larksuite/framework/callback/IGetDataCallback;", BuildConfig.FLAVOR, "setDigest", BuildConfig.FLAVOR, "digest", "emojiSizeDp", "createCallback", "buildText", BuildConfig.FLAVOR, "digestMessage", "emojiLoadAction", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedDigestTextView extends AppCompatTextView {
    public static final int e = 0;
    public List<? extends DigestElement> a;
    public String b;
    public String c;
    public FeedDigestTextView$setDigest$spannableString$1$1 d;

    public static final class a {
    }

    static {
        e = (int) zz7.b.h(UIHelper.getContext(), 14);
        UIHelper.dp2px(5.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        this.d = null;
    }

    public FeedDigestTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super/*android.widget.TextView*/.onDraw(r2);
    }

    public FeedDigestTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public FeedDigestTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CharSequence x(List<? extends DigestElement> r11, IGetDataCallback<Boolean> r12, int r13) {
        SpannableStringBuilder r7 = new SpannableStringBuilder();
        String r0 = this.b;
        if (r0 == null) goto L5;
        r7.append(r0);
    L5:
        List<? extends DigestElement> r1 = r11;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r7.append(BuildConfig.FLAVOR);
    L31:
        String r14 = this.c;
        if (r14 == null) goto L35;
        r7.append(r14);
    L35:
        if (r7.length() <= 150) goto L38;
        CharSequence r15 = r7.subSequence(0, 150);
        Intrinsics.checkNotNull(r15);
        return r15;
    L38:
        return r7;
    L14:
        Iterator<? extends DigestElement> r16 = r11.iterator();
        int r9 = 0;
    L16:
        if (r16.hasNext() == false) goto L31;
        DigestElement r3 = r16.next();
        if ((r3 instanceof TextProperty) == true) goto L19;
        if ((r3 instanceof EmojiProperty) == true) goto L22;
        if ((r3 instanceof TextWithEmojiProperty) == false) goto L30;
        r7.append(((TextWithEmojiProperty) r3).component1());
        EmojiHandler.a(UIHelper.getContext(), r7, zz7.b.g(getContext(), r13), 2, e, 0, -1);
        goto L16
    L30:
        throw new NoWhenBranchMatchedException();
    L22:
        EmojiProperty r4 = (EmojiProperty) r3;
        String r5 = r4.component1();
        String r6 = r4.component2();
        if (r9 > 100) goto L25;
        sdb.a.a(getContext(), r7, r5, r6, r12, zz7.b.g(getContext(), r13));
    L25:
        r9 = r9 + 1;
        goto L16
    L19:
        r7.append(((TextProperty) r3).getContent());
        goto L16
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }
}
