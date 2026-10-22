package com.larus.common.venue.impl.venue.viewmodel;

import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z09.a;
import z09.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/larus/common/venue/impl/venue/viewmodel/TransparentViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/common/venue/impl/venue/viewmodel/TransparentState;", "<init>", "()V", "setHasShowMenu", "", "hasShowMenu", "", "setHasShowIme", "hasShowIme", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransparentViewModel extends ComponentViewModel<TransparentState> {
    public static /* synthetic */ TransparentState No(boolean r0, TransparentState r1) {
        return setHasShowIme$lambda$1(r0, r1);
    }

    public static /* synthetic */ TransparentState Oo(boolean r0, TransparentState r1) {
        return setHasShowMenu$lambda$0(r0, r1);
    }

    public TransparentViewModel() {
    }

    public final void setHasShowIme(final boolean r2) {
        setState(new b(r2));
    }

    public final void setHasShowMenu(final boolean r2) {
        setState(new a(r2));
    }

    private static final TransparentState setHasShowIme$lambda$1(boolean r3, TransparentState r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$setState");
        return TransparentState.copy$default(r4, false, r3, 1, null);
    }

    private static final TransparentState setHasShowMenu$lambda$0(boolean r3, TransparentState r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$setState");
        return TransparentState.copy$default(r4, r3, false, 2, null);
    }
}
