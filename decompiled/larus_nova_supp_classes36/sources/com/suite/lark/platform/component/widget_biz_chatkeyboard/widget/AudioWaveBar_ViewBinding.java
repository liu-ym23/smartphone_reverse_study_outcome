package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AudioWaveBar_ViewBinding implements Unbinder {
    public AudioWaveBar a;

    public final void unbind() {
        AudioWaveBar r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mWaveView = null;
        r0.mDurationTv = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public AudioWaveBar_ViewBinding(AudioWaveBar r4, View r5) {
        this.a = r4;
        r4.mWaveView = (AudioWaveView) Utils.findRequiredViewAsType(r5, 2131393024, "field 'mWaveView'", AudioWaveView.class);
        r4.mDurationTv = (TextView) Utils.findRequiredViewAsType(r5, 2131370401, "field 'mDurationTv'", TextView.class);
    }
}
