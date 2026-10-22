package com.bytedance.android.live.effect.sticker.ui.aigc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcKeywordItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "text", "", "setText", "getText", "", "isSelect", "setSelectStatus", "getSelectStatus", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getTextView", "()Landroid/widget/TextView;", "textView", "", "b", "I", "getPosition", "()I", "setPosition", "(I)V", "position", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AigcKeywordItemView extends ConstraintLayout {
    public final Lazy a;
    public int b;

    public AigcKeywordItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AigcKeywordItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final TextView getTextView() {
        return (TextView) this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getSelectStatus() {
        return isSelected();
    }

    public final String getText() {
        TextView r0 = getTextView();
        if (r0 == null) goto L8;
        CharSequence r1 = r0.getText();
        if (r1 == null) goto L8;
        String r2 = r1.toString();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final int getPosition() {
        return this.b;
    }

    public final void setPosition(int r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSelectStatus(boolean r3) {
        TextView r0 = getTextView();
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        int r1 = 2131107383;
    L7:
        r0.setTextColor(s1.h(r1));
        goto L8
    L6:
        r1 = 2131107384;
    L8:
        setSelected(r3);
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = getTextView();
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AigcKeywordItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new AigcKeywordItemView$textView$2(this));
        this.b = -1;
        ViewGroup.inflate(r2, 2131565836, this);
    }

    public /* synthetic */ AigcKeywordItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
