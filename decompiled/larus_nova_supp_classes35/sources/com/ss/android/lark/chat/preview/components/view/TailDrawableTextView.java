package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0016\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fJ \u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nJ\u001c\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0014J\u0018\u0010-\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0002J \u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020%2\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u00064"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/TailDrawableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWidthMeasureSpec", "mHeightMeasureSpec", "mTailContent", BuildConfig.FLAVOR, "mTailDrawable", "Landroid/graphics/drawable/Drawable;", "mTailDrawablePaddingLeft", "mTailDrawablePaddingRight", "mEllipsizeFinal", BuildConfig.FLAVOR, "mImageLoaderListener", "Lcom/ss/android/lark/chat/preview/components/view/RemoteImageLoadListener;", "getMImageLoaderListener", "()Lcom/ss/android/lark/chat/preview/components/view/RemoteImageLoadListener;", "mImageLoaderListener$delegate", "Lkotlin/Lazy;", "setTailContent", BuildConfig.FLAVOR, "tailContent", "setTailDrawable", "drawable", "drawablePaddingLeft", "drawablePaddingRight", "setText", "text", BuildConfig.FLAVOR, IPortraitService.TYPE, "Landroid/widget/TextView$BufferType;", "bindDrawableCallback", "content", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "doMeasure", "calculateLastLineText", "lastLineStartIndex", "lastLineText", "tailWidth", BuildConfig.FLAVOR, "Companion", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TailDrawableTextView extends AppCompatTextView {
    public int a;
    public int b;
    public String c;
    public Drawable d;
    public int e;
    public int f;
    public boolean g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    private final d getMImageLoaderListener() {
        return (d) this.h.getValue();
    }

    public TailDrawableTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = BuildConfig.FLAVOR;
        this.h = LazyKt.lazy(new TailDrawableTextView$mImageLoaderListener$2(this));
    }

    public final void setTailContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tailContent");
        this.c = r2;
        this.g = false;
    }

    public TailDrawableTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = BuildConfig.FLAVOR;
        this.h = LazyKt.lazy(new TailDrawableTextView$mImageLoaderListener$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r13, int r14) {
        super.onMeasure(r13, r14);
        if (this.a == r13) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (TextUtils.isEmpty(this.c) == false) goto L11;
        return;
    L11:
        if (this.g == false) goto L14;
        if (r0 == false) goto L14;
        return;
    L14:
        this.a = r13;
        this.b = r14;
        int r1 = getLineCount();
        Layout r3 = getLayout();
        int r4 = getMaxLines();
        if (r4 == 0) goto L63;
        if (r1 >= r4) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(getText()) == true) goto L66;
        int r5 = r4 - 1;
        int r2 = r3.getLineEnd(r5);
        if (r2 >= getText().length()) goto L67;
        int r6 = r3.getLineStart(r5);
        int r7 = r2 - 1;
        if (r7 > 0) goto L26;
    L28:
        CharSequence r8 = getText().subSequence(r6, r2);
    L29:
        String r9 = this.c;
        float r10 = getPaint().measureText(r9);
        Drawable r11 = this.d;
        if (r11 == null) goto L34;
        Rect r12 = r11.getBounds();
        if (r12 == null) goto L34;
        int r15 = r12.width();
    L35:
        float r16 = r10 + ((r15 + this.f) + this.e);
        float r17 = getMeasuredWidth() - r16;
        Log.d("[URLPreview]TailTextView", "measureWidth is:" + getMeasuredWidth() + ", tailWidth is:" + r16 + ", widthAvailable:" + r17);
        int r18 = r8.length();
        int r19 = 0;
    L36:
        if (r19 >= r18) goto L41;
        float r20 = getLayout().getPrimaryHorizontal(r6 + r19);
        Log.d("[URLPreview]TailTextView", "index is:" + r19 + ", text is:" + r8.charAt(r19) + ", offset is:" + r20);
        if (r20 > r17) goto L51;
        r19 = r19 + 1;
    L51:
        int r21 = (r6 + r19) - 1;
        if (r21 <= 0) goto L54;
        r8 = getText().subSequence(0, r21);
    L55:
        Log.d("[URLPreview]TailTextView", "index is: " + r19 + ", mustShowText is: " + r8);
        SpannableStringBuilder r22 = new SpannableStringBuilder(r8);
        r22.append(r9);
        Drawable r110 = this.d;
        if (r110 == null) goto L58;
        r22.append("$", new com.ss.android.lark.chat.preview.components.view.a(getContext(), r110.getIntrinsicWidth(), r110.getIntrinsicHeight(), UIHelper.dp2px(4.0f), r110), 33);
    L58:
        setText(r22);
        this.g = true;
        measure(r13, r14);
        return;
    L54:
        Log.i("[URLPreview]TailTextView", "index is: " + r19 + ", text is: " + getText());
        goto L55
    L41:
        float r23 = getLayout().getPrimaryHorizontal((r8.length() + r6) - 1);
        if (r8.length() != 0) goto L44;
        boolean r24 = true;
    L45:
        if (r24 == false) goto L48;
        r19 = 0;
        goto L51
    L48:
        if ((r23 + getPaint().measureText(r8.subSequence(r8.length() - 1, r8.length()).toString())) <= r17) goto L50;
        r19 = r8.length();
        goto L51
    L50:
        r19 = r8.length() + 1;
        goto L51
    L44:
        r24 = false;
    L34:
        r15 = 0;
        goto L35
    L26:
        if (Intrinsics.areEqual("\n", String.valueOf(getText().charAt(r7))) == false) goto L28;
        r8 = getText().subSequence(r6, r7);
        goto L29
    L67:
        return;
    L66:
        return;
    L63:
        return;
    L5:
        if (this.b != r14) goto L7;
        r0 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r5, TextView.BufferType r6) {
        boolean r0 = false;
        this.g = false;
        if ((r5 instanceof Spannable) == false) goto L16;
        Spannable r1 = (Spannable) r5;
        com.ss.android.lark.chat.preview.components.view.a[] r2 = (com.ss.android.lark.chat.preview.components.view.a[]) r1.getSpans(0, r1.length(), com.ss.android.lark.chat.preview.components.view.a.class);
        if (r2 == null) goto L16;
        if (r2.length != 0) goto L11;
        r0 = true;
    L11:
        if ((!r0) == false) goto L16;
        Iterator r3 = ArrayIteratorKt.iterator(r2);
    L14:
        if (r3.hasNext() == false) goto L16;
        com.ss.android.lark.chat.preview.components.view.a r4 = (com.ss.android.lark.chat.preview.components.view.a) r3.next();
        d r7 = getMImageLoaderListener();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "listener");
        r4.l = r7;
    L16:
        super/*android.widget.TextView*/.setText(r5, r6);
    }

    public TailDrawableTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = BuildConfig.FLAVOR;
        this.h = LazyKt.lazy(new TailDrawableTextView$mImageLoaderListener$2(this));
    }
}
