package nv0;

import android.view.SurfaceView;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.config.m3;
import com.bytedance.android.livesdk.config.m9;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import uf2.h0;
import uf2.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends a implements h0.b, h0.e.a, p.c, p.a, p.b {
    public final d a;
    public final h0.e b;

    public b(SurfaceView r3, d r4, boolean r5) {
        this.a = r4;
        r3.getContext();
        r4.K0(r3);
        r4.d1();
        r4.L0(this);
        if (r5 == true) goto L5;
        r4.f0(((Boolean) m3.a.getValue()).booleanValue());
    L5:
        r4.m0(this, this, (p.a) WeakReferenceWrapper.wrap(this));
        r4.c();
        r4.d();
        if (r5 == true) goto L9;
        r4.U0(new uv0.a(LiveRequestSourceRole.Business, "CameraCapture3.<init>", null));
        r4.t1(((Boolean) m9.a.getValue()).booleanValue());
    L9:
        if (this.b != null) goto L11;
        ILiveWrappedLivePusher.Companion.getClass();
        this.b = ILiveWrappedLivePusher.a.b().newTextureFrameAvailableListener(this);
    L11:
        r4.S0(this.b);
    }
}
