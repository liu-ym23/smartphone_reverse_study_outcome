package r71;

import com.bytedance.android.live.room.api.messagewindow.list.RecordAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends g {
    public static final /* synthetic */ int b = 0;
    public final Object a;

    public static final class a {
        public a() {
        }

        public static c a(RecordAction r0, Object r1, v61.a r2, int r3) {
            int r4 = c.b;
            Intrinsics.checkNotNullParameter(r0, "action");
            Intrinsics.checkNotNullParameter(r1, "id");
            return new c(r0, r1);
        }
    }

    static {
        new a();
    }

    public c(RecordAction r1, Object r2) {
        super(r1);
        this.a = r2;
    }
}
