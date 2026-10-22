package q21;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.revlink.impl.multianchor.ui.TeamPkMatchView;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final Long a;
    public final List<TeamPkMatchView.b> b;
    public final List<TeamPkMatchView.b> c;

    public final boolean b() {
        if (((ArrayList) this.b).size() != 1) goto L10;
        TeamPkMatchView.b r0 = (TeamPkMatchView.b) ListProtector.get(this.b, 0);
        if (r0 == null) goto L10;
        if (r0.h != true) goto L10;
        return false;
    L10:
        if (((ArrayList) this.c).size() != 1) goto L16;
        TeamPkMatchView.b r1 = (TeamPkMatchView.b) ListProtector.get(this.c, 0);
        if (r1 == null) goto L16;
        if (r1.h != true) goto L16;
        return false;
    L16:
        return true;
    }

    public static void a(List r4) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = r4.size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (((TeamPkMatchView.b) ListProtector.get(r4, r2)).h == true) goto L12;
        r2 = r2 + 1;
    L12:
        if (r2 == 0) goto L17;
        Collections.swap(r4, 0, r2);
        return;
    L17:
        return;
    L11:
        r2 = 0;
        goto L12
    }

    public static boolean e(Long r5) {
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L9:
        return !r6;
    L5:
        if (r5.longValue() == 0) goto L7;
        r6 = true;
        goto L9
    }

    public static boolean d(List r2, String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(iz.a.a((IBaseUser) r4.next()), r3) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public static Pair f(List r7, Map r8) {
        HashMap r0 = new HashMap();
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L20;
        p r1 = (p) r9.next();
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L4;
        String r3 = iz.a.a(r2);
        if (r3 == null) goto L4;
        Long r4 = (Long) r8.get(r3);
        if (r4 == null) goto L4;
        long r5 = r4.longValue();
        if (r5 == 0) goto L4;
        ArrayList r6 = (ArrayList) r0.get(Long.valueOf(r5));
        if (r6 != null) goto L18;
        r6 = new ArrayList();
        r0.put(Long.valueOf(r5), r6);
    L18:
        r6.add(r1);
        goto L4
    L20:
        if (r0.entrySet().size() != 1) goto L24;
        return TuplesKt.to(ListProtector.get(CollectionsKt.toList(r0.values()), 0), CollectionsKt.emptyList());
    L24:
        if (r0.entrySet().size() != 2) goto L28;
        return TuplesKt.to(ListProtector.get(CollectionsKt.toList(r0.values()), 0), ListProtector.get(CollectionsKt.toList(r0.values()), 1));
    L28:
        return TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public final void g(List<? extends IBaseUser> r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "inviteeList");
        Iterator r0 = CollectionsKt.plus(this.b, this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        TeamPkMatchView.b r1 = (TeamPkMatchView.b) r0.next();
        r1.d = d(r4, iz.a.a(r1.g));
        o0.a.getClass();
        if (o0.a.b(r5) == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        r1.e = r2;
        goto L4
    L8:
        if (Intrinsics.areEqual(r5, iz.a.a(r1.g)) == false) goto L10;
        r2 = true;
        goto L11
    }

    public static List c(List r17, List r18, String r19) {
        String r0 = iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b());
        ArrayList r1 = new ArrayList();
        Iterator r2 = r17.iterator();
    L4:
        if (r2.hasNext() == false) goto L29;
        p r3 = (p) r2.next();
        IBaseUser r12 = r3.getUser();
        if (r12 == null) goto L4;
        int r4 = r12.getGender();
        if (r4 != 1) goto L11;
        TeamPkMatchView.Gender r5 = TeamPkMatchView.Gender.MALE;
    L15:
        TeamPkMatchView.Gender r7 = r5;
        py.k r6 = r12.getAvatarThumbKt();
        if (r6 != null) goto L18;
        r6 = qy.a.c();
    L18:
        py.k r8 = r6;
        String r9 = r12.getNickName();
        if (r9 != null) goto L21;
        r9 = "";
    L21:
        String r10 = r9;
        int r13 = r3.getRoleType();
        boolean r14 = d(r18, iz.a.a(r12));
        o0.a.getClass();
        if (o0.a.b(r19) == false) goto L27;
        if (Intrinsics.areEqual(r19, iz.a.a(r12)) == false) goto L27;
        boolean r15 = true;
    L28:
        boolean r16 = r15;
        r1.add(new TeamPkMatchView.b(r8, r10, r7, r13, r14, r16, r3.getStatus(), r12, Intrinsics.areEqual(iz.a.a(r12), r0)));
    L27:
        r15 = false;
        goto L28
    L11:
        if (r4 == 2) goto L13;
        r5 = TeamPkMatchView.Gender.UNKNOWN;
        goto L15
    L13:
        r5 = TeamPkMatchView.Gender.FEMALE;
        goto L15
    L29:
        return r1;
    }

    public h(List<? extends p> r9, Map<String, Long> r10, List<? extends IBaseUser> r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "users");
        Intrinsics.checkNotNullParameter(r10, "userIdToTeamId");
        Intrinsics.checkNotNullParameter(r12, "inviteeList");
        this.b = new ArrayList();
        this.c = new ArrayList();
        Pair r14 = f(r9, r10);
        List r0 = (List) r14.component1();
        List r15 = (List) r14.component2();
        String r1 = iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b());
        Iterator r2 = r15.iterator();
    L3:
        Long r6 = null;
        if (r2.hasNext() == false) goto L12;
        IBaseUser r3 = ((p) r2.next()).getUser();
        if (r3 == null) goto L8;
        String r4 = r3.getIdString();
    L10:
        if (Intrinsics.areEqual(r4, r1) == false) goto L3;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        r0 = r15;
        r15 = r0;
    L15:
        Pair r16 = TuplesKt.to(c(r0, r12, r13), c(r15, r12, r13));
        List r17 = (List) r16.component1();
        List r18 = (List) r16.component2();
        a(r17);
        a(r18);
        ((ArrayList) this.b).clear();
        List r7 = r17;
        ((ArrayList) this.b).addAll(r7);
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(r18);
        if ((!r7.isEmpty()) == false) goto L18;
        r6 = r10.get(iz.a.a(((TeamPkMatchView.b) ListProtector.get(r17, 0)).g));
    L18:
        this.a = r6;
        return;
    L8:
        r4 = null;
        goto L10
    L12:
        r5 = false;
        goto L13
    }

    public final void update(List<? extends p> r7, Map<String, Long> r8, List<? extends IBaseUser> r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "anchorList");
        Intrinsics.checkNotNullParameter(r8, "userIdToTeamId");
        Intrinsics.checkNotNullParameter(r9, "inviteeList");
        Pair r12 = f(r7, r8);
        List r0 = (List) r12.component1();
        List r13 = (List) r12.component2();
        boolean r2 = false;
        Long r3 = null;
        String r4 = null;
        if ((!r0.isEmpty()) == false) goto L9;
        IBaseUser r1 = ((p) ListProtector.get(r0, 0)).getUser();
        if (r1 == null) goto L7;
        String r5 = iz.a.a(r1);
    L8:
        Long r6 = r8.get(r5);
    L11:
        if ((!r13.isEmpty()) == false) goto L16;
        IBaseUser r14 = ((p) ListProtector.get(r13, 0)).getUser();
        if (r14 == null) goto L15;
        r4 = iz.a.a(r14);
    L15:
        r3 = r8.get(r4);
    L16:
        Long r15 = this.a;
        if (e(r15) == false) goto L20;
    L27:
        if (r2 == false) goto L29;
        r0 = r13;
        r13 = r0;
    L29:
        Pair r16 = TuplesKt.to(c(r0, r9, r10), c(r13, r9, r10));
        List r17 = (List) r16.component1();
        List r18 = (List) r16.component2();
        ((ArrayList) this.b).clear();
        ((ArrayList) this.b).addAll(r17);
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(r18);
        return;
    L20:
        if (e(r6) == true) goto L22;
    L24:
        if (r6 == null) goto L26;
        r2 = !Intrinsics.areEqual(r15, r6);
        goto L27
    L26:
        r2 = Intrinsics.areEqual(r15, r3);
        goto L27
    L22:
        if (e(r3) == false) goto L24;
    L7:
        r5 = null;
        goto L8
    L9:
        r6 = null;
        goto L11
    }
}
