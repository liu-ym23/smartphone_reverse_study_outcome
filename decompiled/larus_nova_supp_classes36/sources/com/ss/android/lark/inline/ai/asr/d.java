package com.ss.android.lark.inline.ai.asr;

import android.view.ViewTreeObserver;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ c a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Log.i("InlineAIAsrView", "onPreDraw");
        int r0 = zlb.a.d;
        zlb.a.C0355a.d(ScenarioType.VoiceInput);
        this.a.c.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    public d(c r1) {
        this.a = r1;
    }
}
