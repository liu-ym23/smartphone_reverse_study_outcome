package com.ss.android.lark.newemoji.emoji_list.adapter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.flexbox.FlexboxLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.newemoji.emoji_list.adapter.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ssb.a;
import ssb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0014J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0007J&\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/newemoji/emoji_list/adapter/view/RecentUsedEmojiView;", "Lcom/google/android/flexbox/FlexboxLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "params", "Lcom/ss/android/lark/newemoji/emoji_list/CreateItemParams;", "lines", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setItemParams", "setLines", "bindData", "emojis", "", "Lcom/ss/android/lark/newemoji/emoji_list/EmojiItemData$Emoji;", "enableEmojiSkin", "", "listener", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/OnEmojiSelectListener;", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RecentUsedEmojiView extends FlexboxLayout {
    public a r;
    public int s;

    public RecentUsedEmojiView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecentUsedEmojiView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setItemParams(a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.r = r2;
    }

    public final void setLines(int r1) {
        this.s = r1;
    }

    public final void onMeasure(int r2, int r3) {
        int r0 = this.s;
        if (r0 >= 0) goto L5;
        super.onMeasure(r2, r3);
        return;
    L5:
        a r4 = this.r;
        if (r4 == null) goto L8;
        int r5 = r4.b;
    L9:
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(r5 * r0, 1073741824));
        return;
    L8:
        r5 = 0;
        goto L9
    }

    public RecentUsedEmojiView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setFlexDirection(0);
        setFlexWrap(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(List<b.c> r6, boolean r7, e r8) {
        Intrinsics.checkNotNullParameter(r6, "emojis");
        removeAllViews();
        a r0 = this.r;
        if (r0 == null) goto L11;
        int r1 = this.s;
        if (r1 >= 0) goto L7;
        int r2 = r6.size();
    L8:
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L13;
        SingleEmojiView r4 = new SingleEmojiView(getContext());
        r4.b(r0);
        addView(r4);
        r4.a((b.c) ListProtector.get(r6, r3), r7, r8);
        r3 = r3 + 1;
        goto L9
    L13:
        return;
    L7:
        r2 = Math.min(r0.h * r1, r6.size());
        goto L8
    }

    public /* synthetic */ RecentUsedEmojiView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
