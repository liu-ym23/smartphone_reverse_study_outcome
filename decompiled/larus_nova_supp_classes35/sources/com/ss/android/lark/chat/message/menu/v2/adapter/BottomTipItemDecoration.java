package com.ss.android.lark.chat.message.menu.v2.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/adapter/BottomTipItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "itemCount", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;I)V", "tipLayout", "Landroid/text/Layout;", "topMargin", "leftDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "rightDrawable", "drawableWidth", "drawableHeight", "drawableHorizontalMargin", "getItemOffsets", BuildConfig.FLAVOR, "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "getTipLayout", "parentWidth", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomTipItemDecoration extends RecyclerView.ItemDecoration {
    public final Context a;
    public final int b;
    public Layout c;
    public final int d;
    public final Drawable e;
    public final Drawable f;
    public final int g;
    public final int h;
    public final int i;

    public static final class a {
    }

    static {
    }

    public final Layout h(int r5) {
        Layout r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = UIUtils.getColor(this.a, 2131106620);
        String r2 = UIUtils.getString(this.a, 2131891207);
        float r3 = UIUtils.sp2px(this.a, 14.0f);
        int r6 = (r5 - (this.g * 2)) - (this.i * 2);
        TextLayoutBuilder r4 = new TextLayoutBuilder();
        r4.h(r2);
        r4.i(r1);
        r4.j((int) r3);
        r4.c(Layout.Alignment.ALIGN_CENTER);
        r4.f(r6);
        Layout r7 = r4.a();
        this.c = r7;
        return r7;
    }

    public BottomTipItemDecoration(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.d = UIUtils.dp2px(r2, 32.0f);
        this.e = UIUtils.getDrawable(r2, 2131232038);
        this.f = UIUtils.getDrawable(r2, 2131232039);
        this.g = UIUtils.dp2px(r2, 40.0f);
        this.h = UIUtils.dp2px(r2, 1.0f);
        this.i = UIUtils.dp2px(r2, 20.0f);
    }

    public final void onDrawOver(Canvas r8, RecyclerView r9, RecyclerView.State r10) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r10, "state");
        View r0 = r9.getChildAt(r9.getChildCount() - 1);
        if (r0 != null) goto L6;
        super.onDrawOver(r8, r9, r10);
        return;
    L6:
        Layout r1 = h(r9.getMeasuredWidth());
        if (r1 != null) goto L10;
        super.onDrawOver(r8, r9, r10);
        return;
    L10:
        r8.save();
        r8.translate(0.0f, r0.getBottom() + this.d);
        int r11 = r9.getMeasuredWidth();
        int r12 = r1.getWidth();
        int r2 = r1.getHeight();
        int r13 = (r11 - r12) / 2;
        int r3 = this.h;
        int r4 = (r2 - r3) / 2;
        int r5 = r13 - this.i;
        int r6 = this.g;
        int r7 = r5 - r6;
        this.e.setBounds(r7, r4, r6 + r7, r3 + r4);
        this.e.draw(r8);
        int r14 = (r12 + r13) + this.i;
        this.f.setBounds(r14, r4, this.g + r14, this.h + r4);
        this.f.draw(r8);
        r8.translate(r13, 0.0f);
        r1.draw(r8);
        r8.restore();
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (r5.getChildAdapterPosition(r4) >= (this.b - 1)) goto L6;
        super.getItemOffsets(r3, r4, r5, r6);
        return;
    L6:
        Layout r0 = h(r5.getMeasuredWidth());
        if (r0 != null) goto L10;
        super.getItemOffsets(r3, r4, r5, r6);
        return;
    L10:
        r3.bottom = this.d + r0.getHeight();
    }
}
