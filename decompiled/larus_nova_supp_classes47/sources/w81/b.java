package w81;

import com.bytedance.android.live.room.incentiveinfo.model.CarouselType;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ int e = 0;
    public boolean a;
    public final boolean b;
    public final CarouselType c;
    public final w81.a d;

    public static final class a {
        @JvmStatic
        public static b a(w81.a r2) {
            Intrinsics.checkNotNullParameter(r2, "dataInfo");
            return new b(CarouselType.ADD, r2);
        }

        @JvmStatic
        public static b b(w81.a r2) {
            Intrinsics.checkNotNullParameter(r2, "dataInfo");
            return new b(CarouselType.REMOVE, r2);
        }

        @JvmStatic
        public static b c(w81.a r2) {
            Intrinsics.checkNotNullParameter(r2, "dataInfo");
            return new b(CarouselType.UPDATE, r2);
        }
    }

    static {
    }

    public b(CarouselType r2, w81.a r3) {
        Intrinsics.checkNotNullParameter(r2, "operate");
        Intrinsics.checkNotNullParameter(r3, "dataInfo");
        this.c = r2;
        this.d = r3;
        this.a = true;
        this.b = true;
    }
}
