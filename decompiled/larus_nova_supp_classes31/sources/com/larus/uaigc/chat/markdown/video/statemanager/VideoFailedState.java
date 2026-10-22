package com.larus.uaigc.chat.markdown.video.statemanager;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.larus.common_ui.view.b0;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.impl.databinding.LarusLayoutVideoGenerateFailedBinding;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VideoFailedState implements ez9.c {
    public final ViewStub a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    @Override // ez9.c
    public final int getLevel() {
        return 4;
    }

    public VideoFailedState(ViewStub r2) {
        this.a = r2;
        this.b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new b(this));
    }

    @Override // ez9.c
    public final void g(ez9.c r3) {
        FLogger.a.i("VideoFailedState", "onLeave");
        ((b0) this.b.getValue()).a();
    }

    @Override // ez9.c
    public final void e(String r1, Message r2) {
        if (r1 != null) goto L5;
        if (r2 != null) goto L5;
        g(null);
    L5:
        ((b0) this.b.getValue()).b();
        LarusLayoutVideoGenerateFailedBinding r3 = (LarusLayoutVideoGenerateFailedBinding) ((b0) this.b.getValue()).c;
        if (r3 == null) goto L11;
        FrameLayout r4 = r3.a;
        if (r4 == null) goto L12;
        w0.e(r4, i5.r0());
        return;
    L12:
        return;
    }
}
