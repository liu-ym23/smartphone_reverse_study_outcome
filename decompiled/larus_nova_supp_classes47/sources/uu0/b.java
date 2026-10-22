package uu0;

import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.profit.dress.config.h;
import com.bytedance.android.live.profit.dress.l;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b {
    public final Map<String, String> a;
    public final h b;

    public static final class a extends b {
        public final l c;
        public final Map<String, c5> d;
        public final String e;

        public a(h r2, l r3, Map<String, ? extends c5> r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "previewConfig");
            Intrinsics.checkNotNullParameter(r3, "dress");
            Intrinsics.checkNotNullParameter(r4, "pieceOverrides");
            super(r2);
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    /* JADX INFO: renamed from: uu0.b$b, reason: collision with other inner class name */
    public static final class C0330b extends b {
        public final gm2.h c;

        public C0330b(h r2, gm2.h r3) {
            Intrinsics.checkNotNullParameter(r2, "previewConfig");
            Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
            super(r2);
            this.c = r3;
        }
    }

    public b(h r1) {
        this.b = r1;
        this.a = new LinkedHashMap();
    }
}
