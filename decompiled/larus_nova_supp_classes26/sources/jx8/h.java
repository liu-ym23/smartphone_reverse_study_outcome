package jx8;

import com.larus.camera.impl.FlowCameraImpl;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Runnable {
    public /* synthetic */ h() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ex8.b r0 = FlowCameraImpl.c;
        i3.a.g(TriggerLoginScene.TRIGGER_LOGIN_CLICK_INPUT);
    }
}
