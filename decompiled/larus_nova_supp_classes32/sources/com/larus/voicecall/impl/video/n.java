package com.larus.voicecall.impl.video;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.keva.Keva;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n {
    public final Keva a;
    public final MutableLiveData<Boolean> b;
    public final MutableLiveData<VideoPreviewState> c;

    public static final class a {
    }

    static {
    }

    public n() {
        boolean r0 = z2.a.rememberCameraPositionEnable();
        Keva r1 = Keva.getRepo("RealtimeCallVideoViewModel");
        this.a = r1;
        boolean r3 = true;
        if (r0 == false) goto L5;
        r3 = r1.getBoolean("KEY_USE_BACK_CAMERA", true);
    L5:
        this.b = new MutableLiveData(Boolean.valueOf(r3));
        this.c = new MutableLiveData(VideoPreviewState.close);
    }

    public final void a(VideoPreviewState r5, String r6, Function1<? super VideoPreviewState, Boolean> r7) {
        VideoPreviewState r0 = (VideoPreviewState) this.c.getValue();
        FLogger.a.i("RealtimeCallVideoViewModel", "changeVideoPreviewState() called with: currentState=" + r0 + " newState = " + r5 + ", caller = " + r6 + ", predict = " + ((Boolean) r7.invoke(r0)).booleanValue() + ')');
        if (r0 != r5) goto L5;
        return;
    L5:
        if (((Boolean) r7.invoke(r0)).booleanValue() == false) goto L9;
        this.c.postValue(r5);
        return;
    }
}
