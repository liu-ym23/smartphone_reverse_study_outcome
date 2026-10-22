package yca;

import com.skydoves.balloon.Balloon;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements d.a {
    public final /* synthetic */ Ref.ObjectRef<Balloon> a;

    @Override // yca.d.a
    public final void dismiss() {
        Balloon r0 = (Balloon) this.a.element;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public e(Ref.ObjectRef<Balloon> r1) {
        this.a = r1;
    }
}
