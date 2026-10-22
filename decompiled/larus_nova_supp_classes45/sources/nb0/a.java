package nb0;

import com.bytedance.android.live.ktv.common.karaokestation.model.d;
import com.bytedance.android.live.ktv.common.karaokestation.model.x;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.model.z;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a implements b {
    public a() {
    }

    @Override // nb0.b
    public final String c() {
        return null;
    }

    @Override // nb0.b
    public final t61 e() {
        return null;
    }

    @Override // nb0.b
    public final String h() {
        return null;
    }

    @Override // nb0.b
    public final x getRoomInfo() {
        return new x(0);
    }

    @Override // nb0.b
    public final Map<String, y> f(d r5) {
        Intrinsics.checkNotNullParameter(r5, "firstLevelTabData");
        Map<String, y> r6 = r5.a;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r6);
        Iterator<Map.Entry<String, y>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        y r1 = r7.next().getValue();
        if (r1.a() == false) goto L4;
        r0.remove(r1.c);
        ArrayList<y> r2 = r1.a;
        if (r2 == null) goto L4;
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L4;
        y r4 = (y) r3.next();
        r0.put(r4.c, r4);
        goto L11
    L13:
        return r0;
    }

    @Override // nb0.b
    public final void postSyncSongListData(y r2) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
    }

    @Override // nb0.b
    public final void postSyncTabListData(d r2) {
        Intrinsics.checkNotNullParameter(r2, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r2, "firstLevelTabData");
    }

    @Override // nb0.b
    public final void updateMusicPanelState(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
    }

    @Override // nb0.b
    public final void a(d r12, List<o0> r13) {
        Intrinsics.checkNotNullParameter(r12, "firstLevelTabData");
        if (r13 == null) goto L25;
        Iterator<T> r14 = r13.iterator();
        int r1 = 0;
    L6:
        if (r14.hasNext() == false) goto L33;
        Object r2 = r14.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        o0 r4 = (o0) r2;
        if (r4.f() == false) goto L24;
        y r5 = r12.a.get(r4.c());
        if (r5 == null) goto L24;
        ArrayList<y> r6 = new ArrayList();
        List<o0> r7 = r4.d();
        if (r7 == null) goto L23;
        Iterator<T> r8 = r7.iterator();
        int r9 = 0;
    L18:
        if (r8.hasNext() == false) goto L23;
        Object r11 = r8.next();
        int r15 = r9 + 1;
        if (r9 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        y r16 = new y(r12.d, r9, 48127);
        y r17 = z.update(r16, (o0) r11);
        r17.b = r5;
        r6.add(r17);
        r9 = r15;
    L23:
        r5.a = r6;
    L24:
        r1 = r3;
        goto L6
    L33:
        return;
    }

    @Override // nb0.b
    public final void b(boolean r1, Throwable r2, y r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
    }

    @Override // nb0.b
    public final void d(boolean r1, Throwable r2, d r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r3, "firstLevelTabData");
    }
}
