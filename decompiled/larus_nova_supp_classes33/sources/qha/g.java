package qha;

import android.content.Context;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g extends e {
    public final t1a.b d;
    public final Context e;
    public final String f;

    @Override // qha.e
    public final String k() {
        return "obric_omni";
    }

    @Override // qha.e
    public final long p() {
        return 1360883263;
    }

    @Override // qha.e
    public final int q() {
        return 2131911893;
    }

    @Override // qha.e
    public final int r() {
        return 2131244356;
    }

    @Override // qha.e
    public final int m() {
        return ActionBarExecutionType.OBRIC_ACTION.getValue();
    }

    @Override // qha.e
    public Context getContext() {
        return this.e;
    }

    @Override // qha.e
    public final String l() {
        return this.f;
    }

    public g(t1a.b r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "vContext");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter("", "address");
        super(r3, r4, "");
        this.d = r3;
        this.e = r4;
        this.f = "";
    }
}
