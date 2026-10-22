package q29;

import android.view.View;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.uaigc.avatar.instruction.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zp9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements m {
    public final /* synthetic */ Function1<UserCreation, Unit> a;

    public final boolean e() {
        return true;
    }

    public final boolean g() {
        return true;
    }

    public c(p r1) {
        this.a = r1;
    }

    public final boolean b(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        return false;
    }

    public final void c(TabItemInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "tabItemInfo");
    }

    public final void d(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void i(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void f(UserCreationModel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "userCreationModel");
    }

    public final void h(UserCreationModel r1, l0 r2, View r3) {
        m.a.b(r1, r2);
    }

    public final boolean a(UserCreation r1, int r2, String r3, String r4, @DoSameQuickMenuType String r5) {
        Intrinsics.checkNotNullParameter(r1, "userCreation");
        this.a.invoke(r1);
        return true;
    }
}
