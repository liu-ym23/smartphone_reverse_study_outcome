package c0c;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a extends c implements ComponentLifecycleAware {
    public final m b;

    @Override // c0c.c, com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.b;
    }

    public final void onComponentCreate() {
        s.a(this);
    }

    public final void onComponentDestroy() {
        s.b(this);
    }

    public a(m r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        super(r2);
        this.b = r2;
    }
}
