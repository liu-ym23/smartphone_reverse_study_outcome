package com.larus.ui.arch.context.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/ui/arch/context/internal/VContextStore;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "getOrInit", "parent", "Companion", "component_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class VContextStore extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private b vContext;

    public static final class a {
        public a() {
        }

        public static VContextStore a(ViewModelStoreOwner r3) {
            Intrinsics.checkNotNullParameter(r3, "owner");
            ViewModelStore r4 = r3.getViewModelStore();
            ViewModel r1 = r4.get("VContextStore");
            if ((r1 instanceof VContextStore) == false) goto L5;
            VContextStore r2 = (VContextStore) r1;
        L6:
            if (r2 != null) goto L9;
            VContextStore r5 = new VContextStore();
            r4.put("VContextStore", r5);
            return r5;
        L9:
            return r2;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public VContextStore() {
    }

    public final b getOrInit(b r7) {
        s0 r0 = this.vContext;
        if (r0 != null) goto L18;
        r0 = new s0();
        if (x1a.a.b == true) goto L7;
        int r4 = y1a.a.a;
        y1a.a.a("ComponentArch", "get VContext from " + this + ", parentContext " + r7 + ", newInstance " + r0);
    L7:
        if (r7 == null) goto L18;
        Intrinsics.checkNotNullParameter(r7, "parent");
        if (Intrinsics.areEqual(r0.d, r7) == true) goto L18;
        s0 r5 = (s0) r7;
        r0.d = r5;
    L12:
        if (r5 == null) goto L18;
        if ((!Intrinsics.areEqual(r5, r0)) == false) goto L17;
        r5 = r5.d;
        goto L12
    L17:
        throw new IllegalStateException(("encounter circular scope attachment " + r0).toString());
    L18:
        this.vContext = r0;
        if (x1a.a.b == true) goto L21;
        int r6 = y1a.a.a;
        y1a.a.a("ComponentArch", "get VContext from " + this + ", parentContext " + r7 + " return " + r0);
    L21:
        return r0;
    }

    public static /* synthetic */ b getOrInit$default(VContextStore r0, b r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.getOrInit(r1);
    }
}
