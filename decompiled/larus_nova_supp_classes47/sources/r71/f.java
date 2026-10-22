package r71;

import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ int d = 0;
    public final int a;
    public final CardDataState b;
    public final CommonCardInitScene c;

    public static final class a {
        @JvmStatic
        public static f a(int r1, CardDataState r2, CommonCardInitScene r3) {
            Intrinsics.checkNotNullParameter(r2, "state");
            Intrinsics.checkNotNullParameter(r3, "initScene");
            return new f(r1, r2, r3);
        }
    }

    static {
    }

    public f(int r1, CardDataState r2, CommonCardInitScene r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
