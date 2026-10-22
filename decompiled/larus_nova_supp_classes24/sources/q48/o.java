package q48;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.larus.apm.impl.NpthImpl;
import ec9.d0;
import kotlin.jvm.internal.Intrinsics;
import p48.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class o implements ICrashCallback {
    public final /* synthetic */ b a;

    public /* synthetic */ o(d0 r1) {
        this.a = r1;
    }

    public final void onCrash(CrashType r2, String r3, Thread r4) {
        b r5 = this.a;
        int r0 = NpthImpl.c;
        Intrinsics.checkNotNullParameter(r2, "type");
        r5.a(r3);
    }
}
