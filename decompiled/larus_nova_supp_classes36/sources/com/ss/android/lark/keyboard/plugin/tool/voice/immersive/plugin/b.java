package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ VoiceFaceKBPlugin a;

    public b(VoiceFaceKBPlugin r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        VoiceFaceKBPlugin.H(this.a);
    }
}
