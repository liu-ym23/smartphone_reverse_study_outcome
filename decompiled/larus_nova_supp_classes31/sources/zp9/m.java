package zp9;

import android.view.View;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.profile.api.bean.UserCreationModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface m {

    public static final class a {
        public static void b(UserCreationModel r1, l0 r2) {
            Intrinsics.checkNotNullParameter(r1, "userCreationModel");
            Intrinsics.checkNotNullParameter(r2, "menuItem");
        }

        public static /* synthetic */ boolean a(m r6, UserCreation r7, int r8, String r9, String r10) {
            return r6.a(r7, r8, r9, r10, null);
        }
    }

    boolean a(UserCreation r1, int r2, String r3, String r4, @DoSameQuickMenuType String r5);

    boolean b(UserCreation r1);

    void c(TabItemInfo r1);

    void d(UserCreation r1);

    boolean e();

    void f(UserCreationModel r1, int r2);

    boolean g();

    void h(UserCreationModel r1, l0 r2, View r3);

    void i(UserCreation r1);
}
