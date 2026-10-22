package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.o;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.light.layout.e;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0003&'(B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020%H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/TopTipsDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/IUpdateHeightDecoration;", "mDependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/TopTipsDecoration$ITopTipsDependency;", "mTopOffset", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/TopTipsDecoration$ITopTipsDependency;I)V", "mTipsView", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/TopTipsDecoration$TopTipsView;", "getMTipsView", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/TopTipsDecoration$TopTipsView;", "setMTipsView", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/TopTipsDecoration$TopTipsView;)V", "extraHeight", BuildConfig.FLAVOR, "getItemOffsets", BuildConfig.FLAVOR, "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getTipsView", "Landroid/view/ViewGroup;", "tips", BuildConfig.FLAVOR, "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "updateHeight", "height", "isEnable", BuildConfig.FLAVOR, "Companion", "TopTipsView", "ITopTipsDependency", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopTipsDecoration extends RecyclerView.ItemDecoration implements z3b.a {
    public final b a;
    public final int b;
    public c c;
    public float d;

    public static final class a {
    }

    public interface b {
        boolean a();

        CharSequence b();
    }

    public static final class c {
        public final int a;
        public final Layout b;

        public static final class a {
        }

        static {
        }

        public final int a() {
            return ((UIHelper.dp2px(12.0f) + 0) + e.a(this.b)) + UIHelper.dp2px(12.0f);
        }

        public c(Context r3, int r4, CharSequence r5) {
            Intrinsics.checkNotNullParameter(r3, "mContext");
            Intrinsics.checkNotNullParameter(r5, "mTips");
            this.a = r4;
            int r6 = (r4 - UIHelper.dp2px(16.0f)) - UIHelper.dp2px(16.0f);
            TextLayoutBuilder r0 = new TextLayoutBuilder();
            r0.h(r5);
            r0.f(r6);
            r0.i(UIHelper.getColor(2131106620));
            r0.j(UIHelper.dp2px(14.0f));
            r0.f = false;
            r0.c(Layout.Alignment.ALIGN_CENTER);
            this.b = r0.a();
            TextPaint r7 = new TextPaint(1);
            Resources r8 = UIUtils.getResources(r3);
            r7.density = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density;
        }
    }

    static {
    }

    @Override // z3b.a
    public final boolean isEnable() {
        return this.a.a();
    }

    public TopTipsDecoration(o r2) {
        Intrinsics.checkNotNullParameter(r2, "mDependency");
        this.a = r2;
        this.b = 0;
    }

    @Override // z3b.a
    public final void c(float r1) {
        this.d = r1;
    }

    public final c h(ViewGroup r3, CharSequence r4) {
        c r0 = this.c;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        if (r0.a != r3.getMeasuredWidth()) goto L6;
    L7:
        c r5 = this.c;
        Intrinsics.checkNotNull(r5);
        return r5;
    L6:
        this.c = new c(r3.getContext(), r3.getMeasuredWidth(), r4);
        goto L7
    }

    public final void onDrawOver(Canvas r13, RecyclerView r14, RecyclerView.State r15) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        Intrinsics.checkNotNullParameter(r14, "parent");
        Intrinsics.checkNotNullParameter(r15, "state");
        super.onDrawOver(r13, r14, r15);
        if (this.a.a() == true) goto L5;
        return;
    L5:
        int r1 = r14.getChildCount();
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L30;
        View r4 = r14.getChildAt(r3);
        if (r14.getChildAdapterPosition(r4) != 0) goto L29;
        int r5 = (int) (r4.getTranslationY() + 0.5f);
        r13.save();
        Rect r6 = new Rect();
        int r7 = r14.getItemDecorationCount();
        int r8 = 0;
        int r9 = 0;
    L10:
        if (r8 >= r7) goto L15;
        RecyclerView.ItemDecoration r10 = r14.getItemDecorationAt(r8);
        if (Intrinsics.areEqual(r10, this) == true) goto L15;
        r6.set(0, 0, 0, 0);
        r10.getItemOffsets(r6, r4, r14, r15);
        r9 = r9 + r6.top;
        r8 = r8 + 1;
    L15:
        float r11 = r4.getTop();
        if ((r4.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        Intrinsics.checkNotNull(r4);
        ViewGroup.LayoutParams r12 = r4.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r12;
    L21:
        if (r16 == null) goto L23;
        int r17 = r16.topMargin;
    L24:
        r9 = r9 + r17;
        goto L25
    L23:
        r17 = 0;
        goto L24
    L20:
        r16 = null;
    L25:
        c r18 = h(r14, this.a.b());
        r13.translate(0.0f, (((r11 + r5) - r18.a()) - r9) - this.b);
        Intrinsics.checkNotNullParameter(r13, "canvas");
        r13.save();
        r13.translate((r18.a - e.b(r18.b)) >> 1, UIHelper.dp2px(12.0f));
        Layout r19 = r18.b;
        if (r19 == null) goto L28;
        r19.draw(r13);
    L28:
        r13.restore();
        r13.restore();
    L29:
        r3 = r3 + 1;
        goto L6
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (r5.getChildAdapterPosition(r4) == 0) goto L5;
    L7:
        r3.set(0, 0, 0, 0);
        return;
    L5:
        if (this.a.a() == false) goto L7;
        c r7 = h(r5, this.a.b());
        Log.d("TopTipsDecoration", "tipsViewHeight = " + r7.a());
        Log.d("TopTipsDecoration", "extraHeight = " + this.d);
        float r8 = ((float) r7.a()) + this.d;
        Log.d("TopTipsDecoration", "finalHeight = " + r8);
        r3.set(0, (int) r8, 0, 0);
    }
}
