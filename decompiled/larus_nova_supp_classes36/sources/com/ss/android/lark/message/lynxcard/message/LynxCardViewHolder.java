package com.ss.android.lark.message.lynxcard.message;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.component.card.cardcontainer.CardImpl;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.widget.EllipsizeFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LynxCardViewHolder extends RecyclerView.ViewHolder implements LifecycleObserver {
    public static final /* synthetic */ int n = 0;
    public View a;
    public long b;
    public GradientDrawable c;

    @BindView(9763)
    public LynxCardMessageContentLayout contentLayout;
    public boolean d;
    public long e;
    public String f;
    public View g;
    public TextView h;
    public AppCompatImageView i;
    public TextView j;
    public v5b.c<LynxCardContentVO> k;
    public p l;
    public final bz7.a m;

    @BindView(9764)
    public EllipsizeFrameLayout mEllipsizeLayout;

    @BindView(9765)
    public FrameLayout mFoldContainer;

    @BindView(10086)
    public LynxCardRoundLinearLayout mRootLayout;

    @BindView(9767)
    public TextView mShowMoreText;

    @BindView(9766)
    public View mShowMoreView;

    @BindView(9774)
    public ViewStub mTranslateStub;

    public final void U3() {
        this.d = false;
        EllipsizeFrameLayout r1 = this.mEllipsizeLayout;
        if (r1 == null) goto L5;
        r1.setEllipsizeListener(null);
        this.mEllipsizeLayout.setShouldEllipsizeListener(null);
        this.mEllipsizeLayout.setEnableEllipsize(false);
    L5:
        LynxCardRoundLinearLayout r0 = this.mRootLayout;
        if (r0 == null) goto L8;
        r0.setOnCardTapListener(null);
        this.mRootLayout.setOnCardTapObserver(null);
    L8:
        this.e = 0;
        this.f = null;
        View r2 = this.mShowMoreView;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        TextView r3 = this.mShowMoreText;
        if (r3 == null) goto L15;
        r3.setVisibility(8);
        this.mShowMoreText.setOnClickListener(null);
        this.mShowMoreText.setOnLongClickListener(null);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        LynxCardMessageContentLayout r0 = this.contentLayout;
        if (r0 == null) goto L5;
        r0.setOnSizeChangeListener(null);
    L5:
        U3();
    }

    public static LynxCardViewHolder V3(View r1) {
        Object r2 = r1.getTag(2131379270);
        if ((r2 instanceof LynxCardViewHolder) == true) goto L5;
        return null;
    L5:
        return (LynxCardViewHolder) r2;
    }

    public LynxCardViewHolder(View r6, CardImpl r7) {
        super(r6);
        ButterKnife.bind(this, r6);
        Context r8 = r6.getContext();
        int r0 = r8.getResources().getIdentifier("chat_post_bg_show_more", "drawable", r8.getPackageName());
        if (r0 == 0) goto L5;
        this.mShowMoreText.setBackgroundResource(r0);
    L6:
        this.mShowMoreText.setPadding(UIUtils.dp2px(r8, 15.0f), UIUtils.dp2px(r8, 2.0f), UIUtils.dp2px(r8, 15.0f), UIUtils.dp2px(r8, 6.0f));
        zz7.a.c(this.mShowMoreText, 14);
        this.m = r7;
        return;
    L5:
        TextView r1 = this.mShowMoreText;
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(0);
        r2.setColor(UIUtils.getColor(r8, 2131100548));
        r2.setCornerRadius(UIUtils.dp2px(r8, 50.0f));
        r1.setBackground(r2);
        goto L6
    }

    public final void T3(Context r1, boolean r2) {
        if (r2 == true) goto L4;
        View r3 = this.g;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
        UIUtils.hide(this.h);
        UIUtils.hide(this.i);
        return;
    L14:
        return;
    L4:
        if (this.g != null) goto L8;
        View r4 = dwa.j.d(r1).f(this.mTranslateStub);
        this.g = r4;
        this.h = (TextView) r4.findViewById(2131379278);
        this.i = this.g.findViewById(2131379279);
        TextView r5 = this.h;
        if (r5 == null) goto L8;
        zz7.a.c(r5, 12);
    L8:
        this.g.setVisibility(0);
        UIUtils.show(this.h);
        UIUtils.show(this.i);
    }
}
