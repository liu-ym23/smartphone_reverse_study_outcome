package zp9;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface r {

    public static final class a {
        public static void a(UserCreation r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "userCreation");
            Intrinsics.checkNotNullParameter(r2, "taskId");
        }
    }

    void X0(String r1);

    void bZ(UserCreation r1);

    void i20(UserCreation r1, long r2, long r4, String r6);

    void yE(UserCreation r1);
}
