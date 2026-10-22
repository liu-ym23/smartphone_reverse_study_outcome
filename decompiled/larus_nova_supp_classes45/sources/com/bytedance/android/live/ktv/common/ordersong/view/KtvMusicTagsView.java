package com.bytedance.android.live.ktv.common.ordersong.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvMusicTagsView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMusicTagsView extends LinearLayout {
    public static final /* synthetic */ int a = 0;

    public KtvMusicTagsView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvMusicTagsView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(List<String> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "tags");
        if (r11.isEmpty() == false) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        int r2 = r11.size();
        if (getChildCount() <= r2) goto L12;
        int r13 = getChildCount() - r2;
        int r3 = 0;
    L9:
        if (r3 >= r13) goto L30;
        getChildAt((getChildCount() - r3) - 1).setVisibility(8);
        r3 = r3 + 1;
    L30:
        Iterator<T> r14 = r11.iterator();
        int r15 = 0;
    L32:
        if (r14.hasNext() == false) goto L41;
        Object r1 = r14.next();
        int r4 = r15 + 1;
        if (r15 >= 0) goto L36;
        CollectionsKt.throwIndexOverflow();
    L36:
        String r5 = (String) r1;
        View r16 = getChildAt(r15);
        if (r16 == null) goto L40;
        TextView r17 = (TextView) r16;
        r17.setVisibility(0);
        r17.setText(r5);
        r15 = r4;
        goto L32
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L41:
        return;
    L12:
        if (getChildCount() >= r2) goto L30;
        int r6 = s1.f(2.0f);
        int r7 = r2 - getChildCount();
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L30;
        if (getChildCount() != 0) goto L20;
        if (r8 != 0) goto L20;
        boolean r9 = false;
    L21:
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-2, -2);
        if (r9 == false) goto L24;
        int r19 = s1.f(3.0f);
    L25:
        r18.leftMargin = r19;
        TextView r21 = new TextView(getContext());
        r21.setGravity(17);
        r21.setBackground(s1.m(KtvOrderSongThemeManager.a(104)));
        KtvOrderSongThemeManager.d(r21, 105);
        r21.setPadding(r6, 0, r6, 0);
        if (r12 == false) goto L28;
        r21.setTextSize(2, 9.0f);
    L29:
        addView(r21, r18);
        r8 = r8 + 1;
        goto L14
    L28:
        r21.setTextSize(1, 9.0f);
        goto L29
    L24:
        r19 = 0;
    L20:
        r9 = true;
        goto L21
    }

    public KtvMusicTagsView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ KtvMusicTagsView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
