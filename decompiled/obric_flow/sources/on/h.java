package on;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.event.LynxEvent$LynxEventType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends c {
    public final g g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f20786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f20787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f20788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JavaOnlyMap f20789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap f20790l;

    public h(int r5, String r10, g r11, g r12, g r13) {
        super(r5, r10, LynxEvent$LynxEventType.f10839a);
        this.g = r11;
        this.f20786h = r12;
        this.f20787i = r13;
    }

    public h(String r5, JavaOnlyMap r10) {
        super(-1, r5, LynxEvent$LynxEventType.f10839a);
        this.f20788j = true;
        this.f20789k = r10;
    }
}
