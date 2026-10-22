package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.voicecall.impl.continue_talk.ChatContinuousTalkLayout;
import com.larus.voicecall.impl.ui.VoiceCallVideoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusLayoutContinuousBottomContainerBinding implements ViewBinding {
    public final FrameLayout a;
    public final VoiceCallVideoView b;
    public final FrameLayout c;
    public final ChatContinuousTalkLayout d;
    public final LinearLayout e;
    public final View f;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutContinuousBottomContainerBinding a(View r9) {
        int r0 = 2131365088;
        VoiceCallVideoView r4 = (VoiceCallVideoView) ViewBindings.findChildViewById(r9, 2131365088);
        if (r4 == null) goto L13;
        FrameLayout r5 = (FrameLayout) r9;
        r0 = 2131367909;
        ChatContinuousTalkLayout r6 = (ChatContinuousTalkLayout) ViewBindings.findChildViewById(r9, 2131367909);
        if (r6 == null) goto L13;
        r0 = 2131372830;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r9, 2131372830);
        if (r7 == null) goto L13;
        r0 = 2131383832;
        View r8 = ViewBindings.findChildViewById(r9, 2131383832);
        if (r8 == null) goto L13;
        return new LarusLayoutContinuousBottomContainerBinding(r5, r4, r5, r6, r7, r8);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }

    public LarusLayoutContinuousBottomContainerBinding(FrameLayout r1, VoiceCallVideoView r2, FrameLayout r3, ChatContinuousTalkLayout r4, LinearLayout r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
