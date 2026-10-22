package com.ss.android.lark.newemoji.emoji_list.adapter.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.adapter.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import qsb.i;
import s5c.d;
import z5c.k0;
import z5c.n3;
import z5c.p3;
import z5c.r;
import z5c.r2;
import z5c.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/newemoji/emoji_list/adapter/view/SingleEmojiView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiIv", "Landroid/widget/ImageView;", "params", "Lcom/ss/android/lark/newemoji/emoji_list/CreateItemParams;", "initView", "", "bindData", "emojiViewData", "Lcom/ss/android/lark/newemoji/emoji_list/EmojiItemData$Emoji;", "emojiSkinTonesEnabled", "", "listener", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/OnEmojiSelectListener;", "Companion", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SingleEmojiView extends FrameLayout {
    public final ImageView a;
    public ssb.a b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0<String> a;
        public final /* synthetic */ Ref.ObjectRef<d> b;
        public final /* synthetic */ e c;

        public b(Function0<String> r1, Ref.ObjectRef<d> r2, e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = (String) this.a.invoke();
            d r0 = ((d) this.b.element).plus(k0.c.a(r4));
            e r1 = this.c;
            if (r1 == null) goto L6;
            r1.a(r4, r0);
            return;
        }
    }

    static {
    }

    public SingleEmojiView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new ImageView(getContext());
    }

    public final void b(ssb.a r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        this.b = r4;
        setLayoutParams(new FlexboxLayoutManager.LayoutParams(r4.a, r4.b));
        setBackgroundResource(2131238339);
        this.a.setId(2131371533);
        ImageView r0 = this.a;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, r4.d);
        r1.gravity = 17;
        r0.setLayoutParams(r1);
        this.a.setAdjustViewBounds(true);
        this.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(this.a);
    }

    public SingleEmojiView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.a = new ImageView(getContext());
    }

    public SingleEmojiView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        this.a = new ImageView(getContext());
    }

    public final void a(ssb.b.c r7, boolean r8, e r9) {
        Intrinsics.checkNotNullParameter(r7, "emojiViewData");
        final com.ss.android.lark.newemoji.larkemoji.a r0 = r7.b;
        ViewGroup.LayoutParams r1 = getLayoutParams();
        if (r0.getWidth() <= 45) goto L14;
        float r2 = r0.getWidth() * 1.0f;
        ssb.a r3 = this.b;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r3 = null;
    L7:
        int r4 = (int) ((r2 * r3.d) / r0.getHeight());
        ssb.a r5 = this.b;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r5 = null;
    L10:
        int r6 = r4 + r5.a;
        ssb.a r10 = this.b;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r10 = null;
    L13:
        int r11 = r6 - r10.d;
    L18:
        r1.width = r11;
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r1;
        ssb.a r13 = this.b;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r13 = null;
    L23:
        r12.setMarginEnd(r13.c);
    L24:
        setLayoutParams(r1);
        if (r7.c == false) goto L28;
        if (r8 == false) goto L28;
        final boolean r14 = true;
    L29:
        if (r14 == false) goto L31;
        Bitmap r15 = r0.d();
    L32:
        if (r15 == null) goto L34;
        this.a.setImageBitmap(r15);
        Function0<String> r16 = new SingleEmojiView$bindData$selectedEmojiKey$1(r14, r0);
        s5c.a r17 = r7.d;
        if (r17 == null) goto L42;
    L45:
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        d r19 = r17.plus(r.c).plus(p3.c).plus(w1.d);
        r18.element = r19;
        Integer r20 = r7.e;
        if (r20 == null) goto L48;
        r18.element = r19.plus(r2.c.a(r20.toString()));
    L48:
        setOnClickListener(new b(r16, r18, r9));
        return;
    L42:
        if ((!r7.c) == false) goto L44;
        r17 = n3.c;
        goto L45
    L44:
        r17 = n3.d;
        goto L45
    L34:
        if (i.a(r0.getWidth(), getContext()) <= 134) goto L36;
        int r21 = r0.getWidth();
    L37:
        this.a.setImageDrawable(new xsb.a(getContext(), i.a(r21, getContext()), i.a(r0.getHeight(), getContext())));
        Log.i("SingleEmojiView", "bitmap is null, emojiId is " + r0.getId() + ", skinedReactionKey is " + r0.f());
        setOnClickListener(null);
        return;
    L36:
        r21 = r0.getHeight();
        goto L37
    L31:
        r15 = r0.a();
    L28:
        r14 = false;
        goto L29
    L14:
        ssb.a r22 = this.b;
        if (r22 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r22 = null;
    L17:
        r11 = r22.a;
        goto L18
    }
}
