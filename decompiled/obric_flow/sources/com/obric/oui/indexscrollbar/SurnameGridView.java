package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tr.l;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\bB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameGridView;", "Landroid/widget/GridView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Ltr/l;", "listener", "", "setOnPressChangeListener", "(Ltr/l;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SurnameGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13425b;

    public SurnameGridView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f13424a = -1;
        this.f13425b = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r10 = pointToPosition((int) r5.getX(), (int) r5.getY());
        int r11 = r5.getActionMasked();
        if (r11 != 0) goto L5;
        this.f13424a = r10;
    L15:
        if (this.f13425b == r10) goto L17;
        Intrinsics.checkNotNull(null);
        throw null;
    L17:
        return super.onTouchEvent(r5);
    L5:
        if (r11 != 1) goto L7;
    L9:
        r10 = -1;
        goto L15
    L7:
        if (r11 != 2) goto L9;
        int r12 = this.f13424a;
        if (r12 != r10) goto L9;
        r10 = r12;
        goto L15
    }

    public final void setOnPressChangeListener(l r5) {
    }
}
