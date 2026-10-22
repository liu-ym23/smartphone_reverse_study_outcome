package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/ui/SelfDisciplineEndView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineEndView extends FrameLayout {
    public Map<Integer, View> a;

    public static final class a {
    }

    static {
    }

    public SelfDisciplineEndView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SelfDisciplineEndView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConstraintLayout r0 = a(2131367728);
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public static String b(long r5) {
        if (r5 != 0) goto L5;
        return "00";
    L5:
        long r0 = 9;
        if (1 > r5) goto L12;
        if (r0 < r5) goto L12;
        return "0" + r5;
    L12:
        return String.valueOf(r5);
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public SelfDisciplineEndView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131567444, this);
        ConstraintLayout r5 = a(2131367728);
        if (r5 == null) goto L6;
        r5.setVisibility(8);
        return;
    }

    public /* synthetic */ SelfDisciplineEndView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
