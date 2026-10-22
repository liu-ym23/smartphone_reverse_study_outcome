package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v2.view;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u000201B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J,\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0016J\u001c\u0010%\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0014\u0010&\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 H\u0002J\u0014\u0010'\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 H\u0002J\u0014\u0010(\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fR\u00020 H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\u0006\u0010/\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00062"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", BuildConfig.FLAVOR, "reverseLayout", BuildConfig.FLAVOR, "itemSize", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$ItemMinSize;", "<init>", "(Landroid/content/Context;IZLcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$ItemMinSize;)V", "getContext", "()Landroid/content/Context;", "mSettledListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$OnItemSettledListener;", "getMSettledListener", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$OnItemSettledListener;", "setMSettledListener", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/AutoCollapseLayoutManager$OnItemSettledListener;)V", "totalCount", "getTotalCount", "()I", "setTotalCount", "(I)V", "isAutoMeasureEnabled", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "onMeasure", BuildConfig.FLAVOR, "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "widthSpec", "heightSpec", "onLayoutChildren", "calculateSuiteChildrenSite", "calculateVerticalSite", "calculateHorizontalSite", "measureChildView", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "canScrollHorizontally", "canScrollVertically", "getVisibleCount", "OnItemSettledListener", "ItemMinSize", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoCollapseLayoutManager extends LinearLayoutManager {
    public final boolean canScrollHorizontally() {
        return false;
    }

    public final boolean canScrollVertically() {
        return false;
    }

    public final Context getContext() {
        return null;
    }

    public final boolean isAutoMeasureEnabled() {
        return false;
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final int[] p(View r4) {
        measureChildWithMargins(r4, 0, 0);
        return new int[]{getDecoratedMeasuredWidth(r4), getDecoratedMeasuredHeight(r4)};
    }

    public final void onLayoutChildren(RecyclerView.Recycler r14, RecyclerView.State r15) {
        Intrinsics.checkNotNullParameter(r14, "recycler");
        Intrinsics.checkNotNullParameter(r15, "state");
        if (getItemCount() > 0) goto L5;
        return;
    L5:
        if (r15.isPreLayout() == true) goto L42;
        detachAndScrapAttachedViews(r14);
        int r1 = 0;
        if (getOrientation() != 1) goto L22;
        View r5 = r14.getViewForPosition(getItemCount() - 1);
        int r16 = p(r5)[1];
        if (r16 > getHeight()) goto L43;
        int r4 = getItemCount() - 1;
        int r9 = 0;
    L13:
        if (r1 >= r4) goto L21;
        View r7 = r14.getViewForPosition(r1);
        Integer r6 = (Integer) r7.getTag(2131388137);
        if (r6 == null) goto L17;
        r7.getLayoutParams().height = r6.intValue();
    L17:
        int r8 = p(r7)[1];
        if (r8 > ((getHeight() - r16) - r9)) goto L20;
        addView(r7);
        int r12 = r9 + r8;
        layoutDecorated(r7, 0, r9, getWidth(), r12);
        r1 = r1 + 1;
        r9 = r12;
        goto L13
    L20:
        throw null;
    L21:
        addView(r5);
        layoutDecorated(r5, 0, r9, getWidth(), r9 + r16);
        return;
    L43:
        return;
    L22:
        View r10 = r14.getViewForPosition(getItemCount() - 1);
        int r17 = p(r10)[0];
        if (r17 > getWidth()) goto L44;
        int r0 = getItemCount() - 1;
        int r11 = 0;
        int r13 = 0;
    L26:
        if (r11 >= r0) goto L34;
        View r18 = r14.getViewForPosition(r11);
        Integer r19 = (Integer) r18.getTag(2131388137);
        if (r19 == null) goto L30;
        r18.getLayoutParams().width = r19.intValue();
    L30:
        int r20 = p(r18)[0];
        if (r20 > ((getWidth() - r17) - r13)) goto L33;
        addView(r18);
        int r110 = r13 + r20;
        layoutDecorated(r18, r13, 0, r110, getHeight());
        r11 = r11 + 1;
        r13 = r110;
        goto L26
    L33:
        throw null;
    L34:
        addView(r10);
        layoutDecorated(r10, r13, 0, r13 + r17, getHeight());
        return;
    L44:
        return;
    }

    public final void onMeasure(RecyclerView.Recycler r2, RecyclerView.State r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "recycler");
        Intrinsics.checkNotNullParameter(r3, "state");
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onMeasure(r2, r3, r4, r5);
    }
}
