package sr9;

import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.platform.api.creation.TplType;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z implements e0 {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    @Override // sr9.e0
    public final void l0(CommonMenu r2) {
        Intrinsics.checkNotNullParameter(r2, TplType.MENU);
    }

    public final Object invoke(Object r2) {
        Intrinsics.checkNotNullParameter((ot8.a) r2, "item");
        return Unit.INSTANCE;
    }
}
