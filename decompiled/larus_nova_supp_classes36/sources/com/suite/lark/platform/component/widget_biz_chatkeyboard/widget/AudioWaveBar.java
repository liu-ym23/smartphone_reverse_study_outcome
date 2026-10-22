package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AudioWaveBar extends LinearLayout {

    @BindView(7519)
    TextView mDurationTv;

    @BindView(8065)
    AudioWaveView mWaveView;

    public AudioWaveBar(Context r2) {
        this(r2, null);
    }

    public void setDurationText(String r2) {
        this.mDurationTv.setText(r2);
    }

    public void setProgress(int r2) {
        this.mWaveView.setProgress(r2);
    }

    public void setWaveBytes(byte[] r2) {
        this.mWaveView.setWaveformBytes(r2);
    }

    public AudioWaveBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AudioWaveBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(r1).inflate(2131558748, this, true);
        ButterKnife.bind(this);
    }
}
