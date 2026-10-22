package com.obric.assistant.component;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class z4 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ a5 c;
    public final /* synthetic */ OrionChatSpeakerComponent d;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.getWidth() <= 0) goto L9;
        this.b.invoke();
        ViewTreeObserver r0 = this.a.getViewTreeObserver();
        if (r0 == null) goto L7;
        r0.removeOnGlobalLayoutListener(this);
    L7:
        this.a.removeOnAttachStateChangeListener(this.c);
        this.d.w = false;
        return;
    }

    public z4(AudioVisualizerOpt r1, y4 r2, a5 r3, OrionChatSpeakerComponent r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
