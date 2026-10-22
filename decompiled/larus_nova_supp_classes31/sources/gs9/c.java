package gs9;

import com.larus.profile.api.bean.UserCreationModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final Function0<Unit> a;
    public final Function4<Integer, String, Boolean, List<UserCreationModel>, Unit> b;
    public final int c;
    public final String d;
    public final boolean e;
    public final String f;
    public final int g;
    public final boolean h;

    public c(Function0 r3, int r4, String r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "dismissCallback");
        Intrinsics.checkNotNullParameter("", "initCursor");
        Intrinsics.checkNotNullParameter(r5, "visitId");
        this.a = r3;
        this.b = null;
        this.c = r4;
        this.d = "";
        this.e = false;
        this.f = r5;
        this.g = r6;
        this.h = r7;
    }
}
