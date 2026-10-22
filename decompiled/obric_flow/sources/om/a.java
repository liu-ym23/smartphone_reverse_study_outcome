package om;

import com.bytedance.ies.xelement.input.h;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.utils.j;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import kn.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f20773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f20774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20775c;
    public final /* synthetic */ String d;

    public a(WeakReference r5, boolean r10, int r11, String r12) {
        this.f20773a = r5;
        this.f20774b = r10;
        this.f20775c = r11;
        this.d = r12;
    }

    @Override // com.lynx.react.bridge.Callback
    public final void invoke(Object... r5) {
        LynxEngineProxy r10 = (LynxEngineProxy) this.f20773a.get();
        if (r10 != null) goto L7;
        LynxLog.b(2, "LynxLepusModule", "triggerLepusBridgeAsync failed, LynxEngine has been released.");
        return;
    L7:
        if (r5.length > 0) goto L9;
        return;
    L9:
        if (this.f20774b == true) goto L13;
        ByteBuffer r11 = b.b(r5[0]);
        j.f(new h(r10, this.f20775c, this.d, r11));
        return;
    }
}
