package com.larus.bmhome.view.item;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\r¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/view/item/ItemGroup;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "singleSelectOn", "view", "Lcom/larus/bmhome/view/item/ItemTextSelector;", "allSelectOff", "updateChildViewBackground", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemGroup extends LinearLayout {
    public final void c() {
        ArrayList r0 = new ArrayList();
        int r1 = getChildCount();
        int r3 = 0;
    L3:
        int r4 = 1;
        if (r3 >= r1) goto L14;
        View r5 = getChildAt(r3);
        if ((r5 instanceof ItemTextView) == false) goto L13;
        if (r5.getVisibility() == 0) goto L11;
        r4 = 0;
    L11:
        if (r4 == 0) goto L13;
        r0.add(r5);
    L13:
        r3 = r3 + 1;
        goto L3
    L14:
        int r2 = r0.size();
        if (r2 != 0) goto L18;
        e1.o(this);
        return;
    L18:
        int r6 = c.b(2130970710, getContext(), 2131239222);
        int r7 = c.b(2130970707, getContext(), 2131239212);
        int r8 = c.b(2130970709, getContext(), 2131239218);
        int r9 = c.b(2130970708, getContext(), 2131239215);
        if (r2 != 1) goto L21;
        ((ItemTextView) ListProtector.get(r0, 0)).setBackgroundResource(r6);
        return;
    L21:
        ((ItemTextView) CollectionsKt.first(r0)).setBackgroundResource(r7);
        int r10 = r2 - 1;
    L22:
        if (r4 >= r10) goto L24;
        ((ItemTextView) ListProtector.get(r0, r4)).setBackgroundResource(r8);
        r4 = r4 + 1;
        goto L22
    L24:
        ((ItemTextView) CollectionsKt.last(r0)).setBackgroundResource(r9);
    }

    public ItemGroup(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a(r2, null);
    }

    public final void b(ItemTextSelector r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Iterator r0 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        View r1 = (View) r0.next();
        r1.setSelected(Intrinsics.areEqual(r1, r4));
        goto L4
    }

    public ItemGroup(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        a(r2, r3);
    }

    public final void a(Context r4, AttributeSet r5) {
        setOrientation(1);
        TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{R.attr.background, R.attr.divider, R.attr.radius, R.attr.showDividers});
        setBackgroundResource(r6.getResourceId(0, c.b(2130970811, r4, 2131239625)));
        setShowDividers(r6.getInt(3, 2));
        setDividerDrawable(ContextCompat.getDrawable(r4, r6.getResourceId(1, c.b(2130970655, r4, 2131239005))));
        r6.recycle();
    }

    public ItemGroup(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        a(r2, r3);
    }
}
