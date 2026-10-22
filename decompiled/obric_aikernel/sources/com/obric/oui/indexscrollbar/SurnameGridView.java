package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\r"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameGridView;", "Landroid/widget/GridView;", "Lcom/obric/oui/indexscrollbar/SurnameGridView$a;", "listener", "", "setOnPressChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SurnameGridView extends GridView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f6771c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6773h;

    public interface a {
        void a(int r10);
    }

    public SurnameGridView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f6772g = -1;
        this.f6773h = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        int r11 = pointToPosition((int) r10.getX(), (int) r10.getY());
        int r12 = r10.getActionMasked();
        if (r12 != 0) goto L5;
        this.f6772g = r11;
    L15:
        if (this.f6773h == r11) goto L18;
        a r13 = this.f6771c;
        Intrinsics.checkNotNull(r13);
        r13.a(r11);
        this.f6773h = r11;
    L18:
        return super.onTouchEvent(r10);
    L5:
        if (r12 != 1) goto L7;
    L9:
        r11 = -1;
        goto L15
    L7:
        if (r12 != 2) goto L9;
        int r14 = this.f6772g;
        if (r14 != r11) goto L9;
        r11 = r14;
        goto L15
    }

    public final void setOnPressChangeListener(a r10) {
        this.f6771c = r10;
    }
}
