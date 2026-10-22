package com.bytedance.android.ec.core.gallery2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eR*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/IndexIndicator;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "", a.KEY_LUBAN_VALUE, "a", "I", "getCount", "()I", "setCount", "(I)V", "count", "b", "getCurrentPos", "setCurrentPos", "currentPos", "", "c", "Z", "getDisableUpdateVisibilityInternal", "()Z", "setDisableUpdateVisibilityInternal", "(Z)V", "disableUpdateVisibilityInternal", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IndexIndicator extends AppCompatTextView implements IIndicatorView {
    public int a;
    public int b;
    public boolean c;

    public IndexIndicator(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public IndexIndicator(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void onDataChanged(TransitionPagerAdapter<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "adapter");
    }

    public final void onTransitionChanged(int r1, float r10) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateUI() {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        setText(String.format(Locale.getDefault(), "%s/%s", Arrays.copyOf(new Object[]{Integer.valueOf(this.b + 1), Integer.valueOf(this.a)}, 2)));
    }

    public final int getCount() {
        return this.a;
    }

    public final int getCurrentPos() {
        return this.b;
    }

    public final boolean getDisableUpdateVisibilityInternal() {
        return this.c;
    }

    public final void onPageSelected(int r1) {
        setCurrentPos(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onTransitionBegin(int r10) {
        if (this.c == false) goto L5;
        return;
    L5:
        if (r10 != 0) goto L7;
    L8:
        setVisibility(8);
        return;
    L7:
        if (r10 == 3) goto L8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onTransitionEnd(int r10) {
        if (this.c == false) goto L5;
        return;
    L5:
        if (r10 != 0) goto L7;
    L8:
        setVisibility(0);
        return;
    L7:
        if (r10 == 1) goto L8;
    }

    public final void setCount(int r1) {
        this.a = r1;
        updateUI();
    }

    public final void setCurrentPos(int r1) {
        this.b = r1;
        updateUI();
    }

    public final void setDisableUpdateVisibilityInternal(boolean r1) {
        this.c = r1;
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
    public IndexIndicator(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        setTextSize(14.0f);
        setTextColor(-1);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        setPadding(vf4.a.b(5), 0, vf4.a.b(5), 0);
        r13.topMargin = vf4.a.b(36);
        r13.rightMargin = vf4.a.b(16);
        r13.gravity = 8388661;
        Unit r14 = Unit.INSTANCE;
        setLayoutParams(r13);
        setBackgroundResource(2131247884);
    }

    public /* synthetic */ IndexIndicator(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
