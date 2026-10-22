package li0;

import android.view.View;
import com.bytedance.android.live.liveinteract.multiscene.f;
import com.bytedance.android.live.liveinteract.multiscene.j;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final boolean e() {
        return g(null);
    }

    public static final j a(com.bytedance.android.live.liveinteract.multiscene.a r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$blueTeamInfo");
        if (r8.getTeamInfos() == null) goto L29;
        List<j> r0 = r8.getTeamInfos();
        if (r0 == null) goto L10;
        if (r0.isEmpty() == true) goto L29;
    L10:
        if (r8.getFightType() != 1) goto L20;
        List<j> r9 = r8.getTeamInfos();
        Intrinsics.checkNotNull(r9);
        Iterator<j> r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L29;
        j r1 = r10.next();
        if (r1 == null) goto L13;
        if (r1.getTeamId() != 2) goto L13;
        return r1;
    L20:
        if (r8.getFightType() != 2) goto L29;
        List<j> r11 = r8.getTeamInfos();
        Intrinsics.checkNotNull(r11);
        Iterator<j> r12 = r11.iterator();
    L23:
        if (r12.hasNext() == false) goto L29;
        j r2 = r12.next();
        if (r2 == null) goto L23;
        if (r2.getTeamId() == je0.d.a0()) goto L23;
        return r2;
    L29:
        return null;
    }

    public static final int b(int r7) {
        com.bytedance.android.live.liveinteract.multiscene.a r0 = TeamFightContext.Companion.b();
        if (r0 == null) goto L7;
        List<j> r2 = r0.getTeamInfos();
        if (r2 == null) goto L7;
        int r3 = r2.size();
    L9:
        if (r3 >= 2) goto L12;
        return -1;
    L12:
        if (r0 == null) goto L27;
        List<j> r4 = r0.getTeamInfos();
        if (r4 == null) goto L27;
        j r5 = (j) ListProtector.get(r4, 0);
        if (r5 == null) goto L27;
        List<Long> r6 = r5.getPositionList();
        if (r6 == null) goto L27;
        if (r6.contains(Long.valueOf(r7)) != true) goto L27;
        List<j> r8 = r0.getTeamInfos();
        if (r8 == null) goto L42;
        j r9 = (j) ListProtector.get(r8, 0);
        if (r9 != null) goto L26;
        return -1;
    L26:
        return (int) r9.getTeamId();
    L42:
        return -1;
    L27:
        if (r0 == null) goto L44;
        List<j> r1 = r0.getTeamInfos();
        if (r1 == null) goto L45;
        j r10 = (j) ListProtector.get(r1, 1);
        if (r10 == null) goto L46;
        List<Long> r11 = r10.getPositionList();
        if (r11 != null) goto L35;
        return -1;
    L35:
        if (r11.contains(Long.valueOf(r7)) != true) goto L48;
        List<j> r12 = r0.getTeamInfos();
        if (r12 == null) goto L49;
        j r13 = (j) ListProtector.get(r12, 1);
        if (r13 != null) goto L41;
        return -1;
    L41:
        return (int) r13.getTeamId();
    L49:
        return -1;
    L48:
        return -1;
    L46:
        return -1;
    L45:
        return -1;
    L44:
        return -1;
    L7:
        r3 = 0;
        goto L9
    }

    public static final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        com.bytedance.android.live.liveinteract.multiscene.a r0 = TeamFightContext.Companion.b();
        if (r0 == null) goto L42;
        List<j> r1 = r0.getTeamInfos();
        if (r1 == null) goto L46;
        j r3 = (j) CollectionsKt.getOrNull(r1, 0);
        if (r3 == null) goto L43;
        List<f> r4 = r3.getPlayers();
        if (r4 == null) goto L47;
        Iterator<f> r6 = r4.iterator();
    L14:
        if (r6.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r6.next().getUserIdString(), r5) == false) goto L14;
        j r7 = (j) CollectionsKt.getOrNull(r1, 0);
        if (r7 != null) goto L20;
        return -1;
    L20:
        return (int) r7.getTeamId();
    L21:
        j r8 = (j) CollectionsKt.getOrNull(r1, 1);
        if (r8 == null) goto L44;
        List<f> r9 = r8.getPlayers();
        if (r9 == null) goto L48;
        Iterator<f> r10 = r9.iterator();
    L28:
        if (r10.hasNext() == false) goto L49;
        if (Intrinsics.areEqual(r10.next().getUserIdString(), r5) == false) goto L28;
        j r11 = (j) CollectionsKt.getOrNull(r1, 1);
        if (r11 != null) goto L34;
        return -1;
    L34:
        return (int) r11.getTeamId();
    L49:
        return -1;
    L48:
        return -1;
    L44:
        return -1;
    L47:
        return -1;
    L43:
        return -1;
    L46:
        return -1;
    L42:
        return -1;
    }

    public static final int d(int r2) {
        if (((r2 - 1) % 4) < 2) goto L7;
        return 2;
    L7:
        return 1;
    }

    public static final boolean f(com.bytedance.android.live.liveinteract.multiscene.a r1) {
        if (r1 != null) goto L4;
        r1 = TeamFightContext.Companion.b();
    L4:
        if (r1 != null) goto L6;
    L8:
        return false;
    L6:
        if (r1.getTeamBattleType() != 1) goto L8;
        return true;
    }

    public static final boolean g(com.bytedance.android.live.liveinteract.multiscene.a r1) {
        if (r1 != null) goto L4;
        r1 = TeamFightContext.Companion.b();
    L4:
        if (r1 != null) goto L6;
    L8:
        return false;
    L6:
        if (r1.getTeamBattleType() != 2) goto L8;
        return true;
    }

    public static final int h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$measureAndGetWidth");
        r2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r2.getMeasuredWidth();
    }

    public static final j i(com.bytedance.android.live.liveinteract.multiscene.a r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$redTeamInfo");
        if (r6.getTeamInfos() == null) goto L29;
        List<j> r0 = r6.getTeamInfos();
        if (r0 == null) goto L10;
        if (r0.isEmpty() != true) goto L10;
        return null;
    L10:
        if (r6.getFightType() != 1) goto L20;
        List<j> r7 = r6.getTeamInfos();
        Intrinsics.checkNotNull(r7);
        Iterator<j> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L45;
        j r1 = r8.next();
        if (r1 == null) goto L13;
        if (r1.getTeamId() != 1) goto L13;
        return r1;
    L45:
        return null;
    L20:
        if (r6.getFightType() != 2) goto L43;
        List<j> r9 = r6.getTeamInfos();
        Intrinsics.checkNotNull(r9);
        Iterator<j> r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L46;
        j r2 = r10.next();
        if (r2 == null) goto L23;
        if (r2.getTeamId() != je0.d.a0()) goto L23;
        return r2;
    L46:
        return null;
    L43:
        return null;
    L29:
        return null;
    }
}
