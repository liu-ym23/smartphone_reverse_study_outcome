package qha;

import android.content.Context;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r extends e {
    public final t1a.b d;
    public final Context e;
    public final String f;

    @Override // qha.e
    public final String k() {
        return "obric_video_perception";
    }

    @Override // qha.e
    public final long p() {
        return 596623375;
    }

    @Override // qha.e
    public final int q() {
        return 2131911933;
    }

    @Override // qha.e
    public final int r() {
        return 2131244371;
    }

    @Override // qha.e
    public final int m() {
        return ActionBarExecutionType.INSTRUCTION.getValue();
    }

    @Override // qha.e
    public final aq8.e n() {
        return new aq8.e(null, null, null, null, null, false, null, null, null, null, 1023);
    }

    @Override // qha.e
    public final com.larus.bmhome.actionbar.model.r o() {
        return new com.larus.bmhome.actionbar.model.r(22, null, new h1(getContext().getString(2131912316), this.f, getContext().getString(2131912390), null, null, 1016), null, null, null, null, null, 4090);
    }

    @Override // qha.e
    public Context getContext() {
        return this.e;
    }

    @Override // qha.e
    public final String l() {
        return this.f;
    }

    public r(t1a.b r2, Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "address");
        super(r2, r3, r4);
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }
}
