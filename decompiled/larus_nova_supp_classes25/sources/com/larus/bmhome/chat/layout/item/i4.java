package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.view.ChatReplyHeaderView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i4 extends i implements st8.a {
    public Function0<Boolean> p;
    public float q;
    public float r;
    public final ChatReplyHeaderView s;
    public final CustomMarkdownTextView t;
    public int u;
    public TextView v;

    public final View l5() {
        return null;
    }

    public FrameLayout getContainer() {
        ViewParent r0 = getParent();
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r0 instanceof FrameLayout) == true) goto L8;
        return null;
    L8:
        return (FrameLayout) r0;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public Integer getImmerseBgColor() {
        return super.getImmerseBgColor();
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public boolean getUseSubscribedColor() {
        return super.getUseSubscribedColor();
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.u;
    }

    public float getClickX() {
        return this.q;
    }

    public float getClickY() {
        return this.r;
    }

    public Function0<Boolean> getDownListener() {
        return this.p;
    }

    public final ChatReplyHeaderView getReplyHeaderView() {
        return this.s;
    }

    public final CustomMarkdownTextView getTextView() {
        return this.t;
    }

    public i4(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9);
        ChatReplyHeaderView r0 = new ChatReplyHeaderView(r9, null, 6, 0);
        r0.setVisibility(8);
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.setMargins(i5.q(), i5.h(), i5.q(), 0);
        Unit r5 = Unit.INSTANCE;
        addView(r0, r10);
        this.s = r0;
        TextView r11 = new CustomMarkdownTextView(getContext(), null, 6, 0);
        r11.setMarkdownWidth(getMaxWidth());
        r11.setBottomLineWeight(i5.x0(v19.c.b(2130971253, null, 2131166876)));
        IFlowThemeConfigProvider r1 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r1 == null) goto L5;
        r11.setLineColor(Integer.valueOf(r1.a(1207959551, ThemeColorKey.MESSAGE_SEND_TEXT_UNDERLINE_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_TEXT_UNDERLINE)).intValue());
    L5:
        m(r11);
        r11.setLineSpacing(0.0f, 1.1f);
        int r2 = getResources().getDimensionPixelSize(2131167561);
        int r3 = getResources().getDimensionPixelSize(2131167561);
        int r4 = getResources().getDimensionPixelSize(2131167562);
        int r6 = getResources().getDimensionPixelSize(2131167562);
        FLogger.a.i("updatePaddingRelative", "view:CustomMarkdownTextView,source:,start:" + r2 + ",top:" + r4 + ",end:" + r3 + ",bottom:" + r6);
        r11.setPaddingRelative(r2, r4, r3, r6);
        FrameLayout r7 = new FrameLayout(getContext());
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        r8.gravity = 8388661;
        r7.addView(r11, r8);
        addView(r7, new LinearLayout.LayoutParams(-2, -2));
        this.t = r11;
        this.u = super.getBoxType();
    }

    public final void m(TextView r4) {
        if (getImmerseBgColor() == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        float r1 = we8.a.a(i5.o(), true);
    L9:
        r4.setTextSize(0, r1);
        return;
    L8:
        r1 = we8.a.a(i5.t(), false);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        setClickX(r2.getX());
        setClickY(r2.getY());
        return super.onTouchEvent(r2);
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r3) {
        super.setBoxType(r3);
        this.u = r3;
        if (r3 != 1) goto L8;
        CustomMarkdownTextView r4 = this.t;
        if (r4 == null) goto L9;
        r4.setTextColor(ContextCompat.getColor(getContext(), 2131103298));
        return;
    L9:
        return;
    }

    public void setClickX(float r1) {
        this.q = r1;
    }

    public void setClickY(float r1) {
        this.r = r1;
    }

    public void setDownListener(Function0<Boolean> r1) {
        this.p = r1;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setImmerseBgColor(Integer r1) {
        super.setImmerseBgColor(r1);
        CustomMarkdownTextView r2 = this.t;
        if (r2 == null) goto L6;
        m(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setUseSubscribedColor(boolean r2) {
        super.setUseSubscribedColor(r2);
        CustomMarkdownTextView r0 = this.t;
        if (r0 == null) goto L6;
        r0.setUseSubscribedColor(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r1, boolean r2) {
        super.l(r1, r2);
        CustomMarkdownTextView r3 = this.t;
        if (r3 == null) goto L5;
        r3.setMarkdownWidth(getMaxWidth());
    L5:
        CustomMarkdownTextView r4 = this.t;
        if (r4 == null) goto L8;
        r4.setMaxWidth(getMaxWidth());
    L8:
        CustomMarkdownTextView r5 = this.t;
        if (r5 == null) goto L12;
        r5.requestLayout();
        return;
    }
}
