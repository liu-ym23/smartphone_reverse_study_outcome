package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ AiAgentPSSelectedMsgView a;

    public e(AiAgentPSSelectedMsgView r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.a.n(null);
        return true;
    }
}
