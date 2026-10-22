package com.ss.android.lark.flow.chat.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.threaddetail.view.StatisticKeyboardDetectorLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FragmentFlowReplyInThreadDetailBinding implements ViewBinding {
    public final StatisticKeyboardDetectorLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final MessageListAnimationContainer f;
    public final FrameLayout g;

    public final View getRoot() {
        return this.a;
    }

    public FragmentFlowReplyInThreadDetailBinding(StatisticKeyboardDetectorLayout r1, FrameLayout r2, FrameLayout r3, FrameLayout r4, FrameLayout r5, MessageListAnimationContainer r6, FrameLayout r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
