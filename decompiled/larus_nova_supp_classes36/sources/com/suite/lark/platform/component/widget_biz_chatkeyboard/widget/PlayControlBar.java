package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.e;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.AudioSeekBar;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PlayControlBar extends LinearLayout implements com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a {
    public final CheckBox a;
    public final ProgressBar b;
    public final AudioSeekBar c;
    public final TextView d;
    public int e;
    public float f;
    public com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.InterfaceC0243a g;
    public a h;
    public boolean i;

    public interface a {
        void a();

        void b();

        void onPause();

        void onPlay();

        void onProgressChanged(int r1);
    }

    public final void c() {
        if (this.i == true) goto L6;
        LKUIToast.show(getContext(), 2131892385);
        return;
    L6:
        if (this.a.isChecked() == false) goto L8;
        pausePlay();
    L10:
        if (this.h != null) goto L12;
        return;
    L12:
        if (this.a.isChecked() == false) goto L14;
        this.h.onPlay();
        return;
    L14:
        this.h.onPause();
        return;
    L8:
        startPlay();
        goto L10
    }

    public String getDurationText() {
        return this.d.getText().toString();
    }

    public float getProgress() {
        return this.c.getProgress() * 0.1f;
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void pausePlay() {
        Log.d("PlayControlBar", "pausePlay");
        this.a.setChecked(false);
        this.c.setHovered(false);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void resumePlay() {
        Log.d("PlayControlBar", "resumePlay");
        this.a.setChecked(true);
        this.c.setHovered(true);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void startPlay() {
        Log.d("PlayControlBar", "startPlay");
        this.a.setChecked(true);
        this.c.setHovered(true);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void stopPlay() {
        Log.d("PlayControlBar", "stopPlay");
        this.a.setChecked(false);
        this.c.setHovered(false);
        setProgress(0.0f);
        post(new apc.a(this));
    }

    public a getDelegate() {
        return this.h;
    }

    public int getDuration() {
        return this.e;
    }

    public com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.InterfaceC0243a getListener() {
        return this.g;
    }

    public PlayControlBar(Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ void a(PlayControlBar r2) {
        r2.setDurationText(1.0f);
        Log.d("PlayControlBar", "stopPlay:" + r2.f);
    }

    private void setDurationText(float r2) {
        if (r2 >= 0.0f) goto L5;
    L7:
        String r3 = e.f(this.e);
    L8:
        this.d.setText(r3);
        return;
    L5:
        if (r2 >= 1.0f) goto L7;
        r3 = e.f((int) (this.e * this.f));
        goto L8
    }

    public void setDelegate(a r1) {
        this.h = r1;
    }

    public void setDuration(int r3) {
        Log.d("PlayControlBar", "setDuration:" + r3);
        this.e = r3;
        setDurationText(1.0f);
    }

    public void setDurationTvColor(int r2) {
        this.d.setTextColor(r2);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.a.setEnabled(r2);
        this.a.setClickable(r2);
        AudioSeekBar r0 = this.c;
        if (r2 == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r0.setEnabled(r3);
        return;
    L5:
        if (this.i == false) goto L7;
        r3 = true;
        goto L8
    }

    public void setListener(com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.InterfaceC0243a r1) {
        this.g = r1;
    }

    public void setLoadingDrawable(Drawable r3) {
        Rect r0 = this.b.getIndeterminateDrawable().getBounds();
        this.b.setIndeterminateDrawable(r3);
        this.b.getIndeterminateDrawable().setBounds(r0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        super.setOnClickListener(r2);
        this.c.setOnClickListener(r2);
        this.d.setOnClickListener(r2);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r2) {
        super.setOnLongClickListener(r2);
        this.a.setOnLongClickListener(r2);
        this.c.setOnLongClickListener(r2);
        this.d.setOnLongClickListener(r2);
    }

    public void setPlayBtnDrawable(Drawable r2) {
        this.a.setButtonDrawable(r2);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public void setProgress(float r3) {
        this.f = r3 / 1.0f;
        AudioSeekBar r4 = this.c;
        r4.setProgress((int) (r4.getMax() * this.f));
    }

    public void setProgressBarDrawable(Drawable r3) {
        Rect r0 = this.c.getProgressDrawable().getBounds();
        this.c.setProgressDrawable(r3);
        this.c.getProgressDrawable().setBounds(r0);
    }

    public void setResourceAvailable(boolean r2) {
        this.i = r2;
        AudioSeekBar r0 = this.c;
        if (r2 == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r0.setEnabled(r3);
        return;
    L5:
        if (isEnabled() == false) goto L7;
        r3 = true;
        goto L8
    }

    public void setThumbDrawable(Drawable r2) {
        r2.setBounds(this.c.getThumb().getBounds());
        this.c.setThumb(r2);
    }

    public PlayControlBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static /* synthetic */ void b(PlayControlBar r0, float r1) {
        r0.setDurationText(r1);
    }

    public PlayControlBar(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13, 0);
        this.f = 1.0f;
        this.i = true;
        setOrientation(0);
        setGravity(16);
        FrameLayout r2 = new FrameLayout(r11);
        addView(r2, xbc.b.c(-2, 8388627, 0, 1));
        CheckBox r14 = new CheckBox(r11);
        this.a = r14;
        r14.setId(2131382424);
        r14.setBackground(null);
        r14.setButtonDrawable(2131236124);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(xbc.b.e(20.0f), xbc.b.e(20.0f));
        r5.gravity = 17;
        r2.addView(r14, r5);
        ProgressBar r6 = new ProgressBar(r11);
        this.b = r6;
        r6.setId(2131379052);
        r6.setInterpolator(new AccelerateDecelerateInterpolator());
        r6.setIndeterminateDrawable(d.e(r11, 2131247274));
        r6.setVisibility(8);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(xbc.b.e(20.0f), xbc.b.e(20.0f));
        r8.gravity = 17;
        r2.addView(r6, r8);
        AudioSeekBar r3 = new AudioSeekBar(r11, null, 0, 2131953360);
        this.c = r3;
        r3.setId(2131382447);
        r3.setMax(AudioViewModel.ASR_SESSION_IDLE);
        r3.setBackground(null);
        r3.setPadding(UIUtils.dp2px(r11, 11.0f), 0, UIUtils.dp2px(r11, 8.0f), 0);
        r3.setProgressDrawable(UIUtils.getDrawable(r11, 2131247636));
        r3.setThumb(UIUtils.getDrawable(r11, 2131247639));
        r3.setThumbOffset(UIUtils.dp2px(r11, 5.0f));
        r3.setSplitTrack(false);
        LinearLayout.LayoutParams r0 = xbc.b.c(0, 16, 2, 2);
        r0.weight = 1.0f;
        addView(r3, r0);
        TextView r15 = new TextView(r11);
        this.d = r15;
        r15.setTextSize(12.0f);
        r15.setTextColor(UIUtils.getColor(r11, 2131102471));
        float r1 = -2;
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(xbc.b.e(r1), xbc.b.e(r1));
        r16.gravity = 16;
        addView(r15, r16);
        r3.setOnSeekBarChangeListener(new b(this));
        r14.setOnClickListener(new apc.b(this));
    }
}
