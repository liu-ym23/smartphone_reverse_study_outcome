package mc2;

import com.bytedance.android.livesdk.interactivity.zdanmaku.k;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a extends r22.a<k> {
    public final Deque<k> c;

    /* JADX INFO: renamed from: mc2.a$a, reason: collision with other inner class name */
    public static final class C0250a {
    }

    static {
    }

    @Override // r22.a
    public final k j() {
        return (k) ((LinkedList) this.c).pollFirst();
    }

    @Override // r22.a
    public final Queue<k> h() {
        return this.c;
    }

    public a(r22.b<k> r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.c = new LinkedList();
    }

    @Override // r22.a
    public final void e(k r3) {
        k r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "danmaku");
        if (((LinkedList) this.c).size() < 10) goto L5;
        ((LinkedList) this.c).removeFirst();
    L5:
        ((LinkedList) this.c).add(r4);
        k();
    }
}
