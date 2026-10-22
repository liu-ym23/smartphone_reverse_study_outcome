package com.bytedance.android.ec.core.gallery2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.byted.cast.sink.api.CastInfo;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0004\u001a\u00020\u0003R:\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/TitleIndicator;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "", "update", "", "", a.KEY_LUBAN_VALUE, "a", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", "", "b", "I", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "currentPos", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TitleIndicator extends AppCompatTextView implements IIndicatorView {
    public List<String> a;
    public int b;

    public TitleIndicator(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public TitleIndicator(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void onDataChanged(TransitionPagerAdapter<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "adapter");
    }

    public final void onTransitionChanged(int r1, float r10) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void update() {
        List<String> r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        setVisibility(8);
        return;
    L11:
        setVisibility(0);
        List<String> r10 = this.a;
        if (r10 == null) goto L14;
        String r11 = (String) CollectionsKt.getOrNull(r10, this.b);
    L15:
        setText(r11);
        return;
    L14:
        r11 = null;
        goto L15
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final int getCurrentPos() {
        return this.b;
    }

    public final List<String> getData() {
        return this.a;
    }

    public final void onPageSelected(int r1) {
        setCurrentPos(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onTransitionBegin(int r10) {
        if (r10 != 0) goto L4;
    L5:
        setVisibility(8);
        return;
    L4:
        if (r10 == 3) goto L5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onTransitionEnd(int r10) {
        boolean r0 = true;
        if (r10 == 0) goto L5;
        if (r10 == 1) goto L5;
        return;
    L5:
        List<String> r11 = this.a;
        if (r11 != null) goto L8;
    L11:
        if (r0 == true) goto L15;
        setVisibility(0);
        return;
    L15:
        return;
    L8:
        if (r11.isEmpty() == true) goto L11;
        r0 = false;
        goto L11
    }

    public final void setCurrentPos(int r1) {
        this.b = r1;
        update();
    }

    public final void setData(List<String> r1) {
        this.a = r1;
        update();
    }

    public final void onAttach(int r10, TransitionPagerAdapter<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "adapter");
        IIndicatorView.DefaultImpls.onAttach(this, r10, r11);
    }

    public final void onDetach(int r10, TransitionPagerAdapter<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TitleIndicator(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        setTextSize(17.0f);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        setPadding(vf4.a.b(10), 0, vf4.a.b(10), 0);
        r13.bottomMargin = vf4.a.b(16);
        r13.leftMargin = vf4.a.b(60);
        r13.rightMargin = vf4.a.b(60);
        r13.gravity = 81;
        Unit r14 = Unit.INSTANCE;
        setLayoutParams(r13);
        setMaxHeight(vf4.a.b(Integer.valueOf(CastInfo.TYPE_DISCONNECT)));
        setEllipsize(TextUtils.TruncateAt.END);
        setTextColor(-1);
        setBackgroundResource(2131247884);
    }

    public /* synthetic */ TitleIndicator(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
