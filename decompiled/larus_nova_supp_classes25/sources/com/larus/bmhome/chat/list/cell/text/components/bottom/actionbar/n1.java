package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.view.View;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n1 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ PlayStateEnum b;
    public final /* synthetic */ rs8.g c;
    public final /* synthetic */ AnswerActionComponent d;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r3) {
        this.a.removeOnAttachStateChangeListener(this);
        FLogger.a.d("TtsActionCreator", "update action when view reattach, state: " + this.b + ", action: " + this.c + '.');
        AnswerActionComponent r4 = this.d;
        rs8.h r0 = r4.x;
        if (r0 == null) goto L10;
        rs8.g r1 = this.c;
        com.larus.bmhome.chat.layout.item.i r5 = r4.d;
        if (r5 == null) goto L7;
        Boolean r6 = Boolean.valueOf(r5.getUseSubscribedColor());
    L8:
        r0.update(r1, r6);
        return;
    L7:
        r6 = null;
        goto L8
    }

    public n1(View r1, PlayStateEnum r2, rs8.g r3, AnswerActionComponent r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
