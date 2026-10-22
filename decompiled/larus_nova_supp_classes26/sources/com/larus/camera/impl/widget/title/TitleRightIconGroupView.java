package com.larus.camera.impl.widget.title;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import ay8.e;
import ay8.f;
import ay8.g;
import ay8.h;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012J\b\u0010\u0013\u001a\u00020\fH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/camera/impl/widget/title/TitleRightIconGroupView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemSpacingPx", "setItemSpacing", "", "createAndAddIcon", "iconItem", "Lcom/larus/camera/impl/widget/title/TitleRightIcon;", "setIconList", "iconList", "", "updateItemSpacing", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleRightIconGroupView extends LinearLayout {
    public static final /* synthetic */ int b = 0;
    public int a;

    public TitleRightIconGroupView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TitleRightIconGroupView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        Iterator r0 = ViewGroupKt.getChildren(this).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L23;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r5 = (View) r3;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L12:
        if (r7 == null) goto L17;
        if (r2 != 0) goto L15;
        int r8 = 0;
    L16:
        r7.setMarginStart(r8);
    L22:
        r5.setLayoutParams(r7);
        r2 = r4;
        goto L4
    L15:
        r8 = this.a;
        goto L16
    L17:
        r7 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r2 != 0) goto L20;
        int r9 = 0;
    L21:
        r7.setMarginStart(r9);
        goto L22
    L20:
        r9 = this.a;
        goto L21
    L11:
        r7 = null;
        goto L12
    }

    public final void setIconList(List<e> r7) {
        Intrinsics.checkNotNullParameter(r7, "iconList");
        removeAllViews();
        Iterator<e> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        final e r0 = r8.next();
        TitleRightIconView r1 = new TitleRightIconView(getContext(), null, 6, 0);
        r1.setIcon(new f(r0));
        r1.setHint(new g(r0));
        r1.setContentDescription(r0.f);
        e1.d(r1, new h(r0));
        addView(r1);
        a();
        r0.c.invoke(r1);
        goto L4
    }

    public final void setItemSpacing(int r1) {
        this.a = r1;
        setShowDividers(0);
        a();
    }

    public TitleRightIconGroupView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(0);
        setDividerDrawable(new ColorDrawable(0));
        setDividerPadding(c7.b(4));
        setShowDividers(2);
        setGravity(8388613);
    }

    public /* synthetic */ TitleRightIconGroupView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
