package com.bytedance.lynx.media;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wn.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/lynx/media/LynxAudioEngineView;", "Lcom/bytedance/lynx/media/AbsMediaEngineView;", "Lcom/bytedance/lynx/media/d;", "x-element-media_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxAudioEngineView extends AbsMediaEngineView<d> {
    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        TraceEvent.c("LynxAudioEngineView.createView");
        d r10 = new d(r5);
        LynxContext r11 = kk.a.i(r5);
        if (r11 == null) goto L9;
        h r12 = r11.D;
        this.f6805z = r12;
        if (r12 == null) goto L7;
        boolean r13 = true;
    L8:
        this.A = r13;
        goto L9
    L7:
        r13 = false;
    L9:
        this.f6791k = "x-audio-ng";
        TraceEvent.a(0, "LynxAudioEngineView.createView");
        return r10;
    }
}
