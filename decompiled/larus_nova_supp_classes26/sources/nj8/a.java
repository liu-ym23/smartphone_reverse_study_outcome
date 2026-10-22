package nj8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.codeartifact.viewmodel.CodeArtifactVMData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements mj8.d {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // mj8.d
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        b r0 = this.a;
        CodeArtifactVMData r1 = r0.a;
        if (r1 == null) goto L8;
        c r2 = r0.b;
        if (r2 == null) goto L9;
        r2.a(r3, r1);
        return;
    L9:
        return;
    }
}
