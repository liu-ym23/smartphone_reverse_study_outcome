package com.obric.assistant.component;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ ica.a a;
    public final /* synthetic */ ObricCameraAutoSendComponent b;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.w("ObricCameraAutoSend", "send failed requestId=" + this.a.a + ", error=" + r4);
        this.a.a();
        this.b.n = null;
    }

    public final void onSuccess(Object r3) {
        Intrinsics.checkNotNullParameter((List) r3, WindowEvent.Params.RESULT);
        FLogger.a.i("ObricCameraAutoSend", "send success requestId=" + this.a.a);
        this.a.a();
        this.b.n = null;
    }

    public f(ica.a r1, ObricCameraAutoSendComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
