package bt8;

import com.skydoves.balloon.Balloon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements com.larus.bmhome.view.actionbar.edit.component.b1 {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.component.b1
    public final void b(int r1, com.larus.bmhome.actionbar.model.w r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
    }

    @Override // com.larus.bmhome.view.actionbar.edit.component.b1
    public final void a(int r3, com.larus.bmhome.actionbar.model.w r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "selectedSpinnerItem");
        Balloon r0 = this.a.e;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        Long r6 = r4.a;
        if (r6 == null) goto L9;
        long r1 = r6.longValue();
        this.a.b.invoke(Integer.valueOf(r3), Long.valueOf(r1), Integer.valueOf(r5));
        return;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.component.b1
    public final boolean c(int r1, com.larus.bmhome.actionbar.model.w r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        return false;
    }
}
