package x7a;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends q1 {
    public final /* synthetic */ LynxView a;

    @Override // com.lynx.tasm.q1
    public final void onLoadSuccess() {
        w6a.h.a.a.b(this.a);
        this.a.onEnterForeground();
    }

    public e(LynxView r1) {
        this.a = r1;
    }
}
