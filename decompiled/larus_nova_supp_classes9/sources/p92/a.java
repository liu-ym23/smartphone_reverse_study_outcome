package p92;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.g;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import h52.d;
import i52.b;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements g {
    public final ConcurrentHashMap<MessageModelType, Set<p>> a;

    public a() {
        this.a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.g
    public final void c(d r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Set<p> r0 = this.a.get(r3.d());
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((p) r1.next()).a(r3);
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.g
    public final void a(MessageModelType r2, b.C0236b r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Set<p> r4 = this.a.get(r2);
        if (r4 == null) goto L6;
        r4.remove(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.g
    public final void b(MessageModelType r4, b.C0236b r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Set<p> r0 = this.a.get(r4);
        if (r0 == null) goto L5;
        r0.add(r5);
        return;
    L5:
        Set<p> r6 = this.a.put(r4, SetsKt.mutableSetOf(new p[]{r5}));
    }
}
