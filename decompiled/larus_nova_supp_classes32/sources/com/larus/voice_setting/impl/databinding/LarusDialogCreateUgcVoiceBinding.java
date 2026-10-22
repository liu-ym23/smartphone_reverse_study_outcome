package com.larus.voice_setting.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.asr.view.ChatSpeaker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusDialogCreateUgcVoiceBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final View f;
    public final ChatSpeaker g;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDialogCreateUgcVoiceBinding a(LayoutInflater r9, ViewGroup r10) {
        ConstraintLayout r11 = r9.inflate(2131562053, r10, false);
        int r12 = 2131368215;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r11, 2131368215);
        if (r3 == null) goto L17;
        r12 = 2131368216;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131368216);
        if (r4 == null) goto L17;
        r12 = 2131368217;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131368217);
        if (r5 == null) goto L17;
        r12 = 2131368218;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131368218);
        if (r6 == null) goto L17;
        r12 = 2131368219;
        View r7 = ViewBindings.findChildViewById(r11, 2131368219);
        if (r7 == null) goto L17;
        r12 = 2131368220;
        ChatSpeaker r8 = ViewBindings.findChildViewById(r11, 2131368220);
        if (r8 == null) goto L17;
        return new LarusDialogCreateUgcVoiceBinding(r11, r3, r4, r5, r6, r7, r8);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public LarusDialogCreateUgcVoiceBinding(ConstraintLayout r1, AppCompatImageView r2, TextView r3, TextView r4, TextView r5, View r6, ChatSpeaker r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
