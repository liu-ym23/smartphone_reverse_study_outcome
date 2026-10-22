package com.bytedance.lynx.media;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.z;
import g8.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import wn.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lynx/media/LynxVideoEngineUI;", "Lcom/bytedance/lynx/media/AbsMediaEngineView;", "Lcom/bytedance/lynx/media/f;", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "", "requestFullScreen", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "exitFullScreen", "x-element-media_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxVideoEngineUI extends AbsMediaEngineView<f> {
    public final String H;

    public LynxVideoEngineUI(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.H = "LynxVideoEngineUI";
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        TraceEvent.c("LynxVideoEngineUI.createView");
        f r10 = new f(r5);
        r10.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
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
        this.f6791k = "x-video-engine";
        TraceEvent.a(0, "LynxVideoEngineUI.createView");
        return r10;
    }

    @f0
    public final void exitFullScreen(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        LynxLog.b(2, this.H, getSign() + " invoke exitFullScreen");
        f r11 = (f) this.mView;
        Intrinsics.checkNotNullParameter(r10, "callback");
        g r12 = new g(r10, 5);
        sf.a r13 = r11.getMediaView();
        if (r13 == null) goto L6;
        LynxLog.b(2, "LynxVideoEnginePlayableWrapperView", "invoke exitFullScreen");
        r13.h(r12);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onBorderRadiusUpdated(int r11) {
        int r5 = 0;
        super.onBorderRadiusUpdated(r11);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        com.lynx.tasm.behavior.ui.utils.g r10 = getLynxBackground();
        if (r10 == null) goto L18;
        com.lynx.tasm.behavior.ui.utils.d r13 = r10.n();
        if (r13 == null) goto L18;
        int r14 = ((f) this.mView).getPaddingLeft();
        int r15 = ((f) this.mView).getPaddingRight();
        int r16 = ((f) this.mView).getPaddingTop();
        int r17 = ((f) this.mView).getPaddingBottom();
        r13.a((((f) this.mView).getWidth() + r14) + r15, (((f) this.mView).getHeight() + r16) + r17);
        float[] r18 = r13.c();
        T r19 = 0;
        r19 = 0;
        if (r18 != null) goto L9;
    L17:
        r12.element = r19;
        goto L18
    L9:
        if (r18.length == 8) goto L12;
        r18 = null;
    L12:
        if (r18 == null) goto L17;
        float r20 = r14;
        float r21 = r16;
        float r22 = r15;
        float r23 = r17;
        float[] r24 = {r20, r21, r22, r21, r22, r23, r20, r23};
    L14:
        if (r5 >= 8) goto L16;
        r18[r5] = Math.max(0.0f, r18[r5] - r24[r5]);
        r5 = r5 + 1;
        goto L14
    L16:
        r19 = r18;
    L18:
        ((f) this.mView).setBorderRadius((float[]) r12.element);
    }

    @f0
    public final void requestFullScreen(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        LynxLog.b(2, this.H, getSign() + " invoke requestFullScreen");
        if (r5.hasKey("landscape") == false) goto L5;
        boolean r11 = r5.getBoolean("landscape");
    L6:
        f r12 = (f) this.mView;
        Intrinsics.checkNotNullParameter(r10, "callback");
        g r13 = new g(r10, 5);
        sf.a r14 = r12.getMediaView();
        if (r14 == null) goto L14;
        LynxLog.b(2, "LynxVideoEnginePlayableWrapperView", "invoke enterFullScreen");
        if (r11 == false) goto L12;
        r14.d(r13);
        return;
    L12:
        r14.f(r13);
        return;
    L14:
        return;
    L5:
        r11 = true;
        goto L6
    }
}
