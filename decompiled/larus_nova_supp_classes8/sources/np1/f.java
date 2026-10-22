package np1;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements a {
    public final int b;
    public final PropertyOwner c;
    public final PropertyOwner<Boolean> d;
    public final PropertyOwner e;
    public final PropertyOwner<String> f;
    public final PropertyOwner g;
    public final PropertyOwner<Unit> h;
    public final PropertyOwner i;
    public final c j;
    public final boolean k;

    @Override // np1.a
    public final d<? extends a> a() {
        return null;
    }

    @Override // np1.a
    public final c c() {
        return this.j;
    }

    @Override // np1.a
    public int getType() {
        return this.b;
    }

    public /* synthetic */ f(c r7, String r8, Boolean r9) {
        this(r7, r8, false, "", r9);
    }

    public f(c r2, String r3, boolean r4, String r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "panelContext");
        Intrinsics.checkNotNullParameter(r3, "initTitle");
        this.j = r2;
        this.k = r4;
        this.b = 1;
        this.c = new PropertyOwner(r3);
        if (r6 == null) goto L5;
        boolean r7 = r6.booleanValue();
    L6:
        PropertyOwner<Boolean> r8 = new PropertyOwner(Boolean.valueOf(r7));
        this.d = r8;
        this.e = r8;
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        PropertyOwner<String> r9 = new PropertyOwner(r5);
        this.f = r9;
        this.g = r9;
        PropertyOwner<Unit> r10 = new PropertyOwner(Unit.INSTANCE);
        this.h = r10;
        this.i = r10;
        return;
    L5:
        r7 = false;
        goto L6
    }
}
