package wf0;

import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.live.datacontext.j;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements qz.a {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public c() {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
        if (r0 == null) goto L5;
        r0.getRendererCommon();
    L5:
        j r1 = m.i().getLiveStream();
        if (r1 == null) goto L8;
        com.bytedance.android.live.pushstream.d r2 = (com.bytedance.android.live.pushstream.d) r1.getValue();
    L9:
        new WeakReference(r2);
        return;
    L8:
        r2 = null;
        goto L9
    }
}
