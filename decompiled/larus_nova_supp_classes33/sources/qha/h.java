package qha;

import android.content.Context;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h extends e {
    public final t1a.b d;
    public final Context e;
    public final String f;

    @Override // qha.e
    public final String k() {
        return "obric_document_perception";
    }

    @Override // qha.e
    public final long p() {
        return 295367523;
    }

    @Override // qha.e
    public final int q() {
        return 2131911899;
    }

    @Override // qha.e
    public final int r() {
        return 2131244358;
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

    public h(t1a.b r2, Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "address");
        super(r2, r3, r4);
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }
}
