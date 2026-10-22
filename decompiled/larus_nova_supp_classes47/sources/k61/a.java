package k61;

import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public boolean a;
    public n61.a b;
    public final LivePerfBizType c;
    public final LivePerfBizLevel d;

    /* JADX INFO: renamed from: k61.a$a, reason: collision with other inner class name */
    public static final class C0261a {
    }

    static {
    }

    public final String toString() {
        return "BasicPerfInfo(type=" + this.c.name() + ", level=" + this.d.getLevel() + ')';
    }

    public final LivePerfBizType getType() {
        return this.c;
    }

    public a(LivePerfBizType r2, LivePerfBizLevel r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "level");
        this.c = r2;
        this.d = r3;
    }
}
