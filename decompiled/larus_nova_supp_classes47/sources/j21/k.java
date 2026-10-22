package j21;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.p;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements com.bytedance.android.live.revlink.impl.multianchor.network.d, com.bytedance.android.live.revlink.impl.multianchor.network.b, com.bytedance.android.live.revlink.impl.multianchor.network.c, com.bytedance.android.live.revlink.impl.multianchor.network.a {
    public final com.bytedance.android.live.revlink.impl.multianchor.network.k a;
    public final com.bytedance.android.live.revlink.impl.multianchor.network.g b;
    public final com.bytedance.android.live.revlink.impl.multianchor.network.j c;
    public final com.bytedance.android.live.revlink.impl.multianchor.network.f d;
    public List<? extends p> e;
    public List<? extends p> f;
    public List<? extends IBaseUser> g;
    public String h;
    public Map<String, Long> i;
    public long j;
    public PlayMode k;
    public d l;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.c
    public final void onRequestChangeMultiTeamFailed() {
        d r0 = this.l;
        if (r0 == null) goto L6;
        r0.onRequestChangeMultiTeamFailed();
        return;
    }

    public k() {
        this.a = new com.bytedance.android.live.revlink.impl.multianchor.network.k();
        this.b = new com.bytedance.android.live.revlink.impl.multianchor.network.g();
        this.c = new com.bytedance.android.live.revlink.impl.multianchor.network.j();
        this.d = new com.bytedance.android.live.revlink.impl.multianchor.network.f();
        this.g = CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.c, com.bytedance.android.live.revlink.impl.multianchor.network.a
    public final void a(long r4) {
        if (r4 >= this.j) goto L5;
        return;
    L5:
        this.j = r4;
        i(PlayMode.PERSONAL_PK);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.d
    public final void b(List<? extends IBaseUser> r3) {
        this.g = r3;
        d r0 = this.l;
        if (r0 == null) goto L6;
        r0.onInviteeOrApplicantListChanged(r3, this.h);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.d
    public final void e(String r3) {
        this.h = r3;
        d r0 = this.l;
        if (r0 == null) goto L6;
        r0.onInviteeOrApplicantListChanged(this.g, r3);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.b
    public final void g(long r4) {
        if (r4 >= this.j) goto L5;
        return;
    L5:
        this.j = r4;
        i(PlayMode.PERSONAL_PK);
    }

    public final void i(PlayMode r13) {
        if (this.k == r13) goto L29;
        this.k = r13;
        if (r13 != PlayMode.PERSONAL_PK) goto L15;
        d r0 = this.l;
        if (r0 == null) goto L15;
        List<? extends p> r1 = this.e;
        if (r1 != null) goto L11;
        r1 = CollectionsKt.emptyList();
    L11:
        List<? extends p> r2 = this.f;
        if (r2 != null) goto L14;
        r2 = CollectionsKt.emptyList();
    L14:
        r0.onPersonalPageUpdate(r1, r2, this.g, this.h);
    L15:
        Map<String, Long> r10 = this.i;
        if (r13 != PlayMode.TEAM_PK) goto L52;
        if (r10 == null) goto L53;
        d r5 = this.l;
        if (r5 == null) goto L54;
        List<? extends p> r14 = this.e;
        if (r14 != null) goto L23;
        r14 = CollectionsKt.emptyList();
    L23:
        List<? extends p> r6 = r14;
        List<? extends p> r15 = this.f;
        if (r15 != null) goto L26;
        r15 = CollectionsKt.emptyList();
    L26:
        r5.onTeamPageUpdate(r6, r15, this.g, this.h, r10, true);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L29:
        if (r13 != PlayMode.PERSONAL_PK) goto L39;
        d r3 = this.l;
        if (r3 == null) goto L39;
        List<? extends p> r4 = this.e;
        if (r4 != null) goto L35;
        r4 = CollectionsKt.emptyList();
    L35:
        List<? extends p> r7 = this.f;
        if (r7 != null) goto L38;
        r7 = CollectionsKt.emptyList();
    L38:
        r3.onPersonalPageUpdate(r4, r7, this.g, this.h);
    L39:
        Map<String, Long> r12 = this.i;
        if (r13 != PlayMode.TEAM_PK) goto L55;
        if (r12 == null) goto L56;
        d r8 = this.l;
        if (r8 == null) goto L57;
        List<? extends p> r16 = this.e;
        if (r16 != null) goto L47;
        r16 = CollectionsKt.emptyList();
    L47:
        List<? extends p> r9 = r16;
        List<? extends p> r17 = this.f;
        if (r17 != null) goto L50;
        r17 = CollectionsKt.emptyList();
    L50:
        r8.onTeamPageUpdate(r9, r17, this.g, this.h, r12, false);
        return;
    L57:
        return;
    L56:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.d
    public final void onInitPageFailed(int r2) {
        d r0 = this.l;
        if (r0 == null) goto L6;
        r0.onInitPageFailed(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.c, com.bytedance.android.live.revlink.impl.multianchor.network.a
    public final void c(long r4, Map<String, Long> r6) {
        Intrinsics.checkNotNullParameter(r6, "userIdToTeamId");
        if (r4 >= this.j) goto L5;
        return;
    L5:
        this.j = r4;
        this.i = r6;
        i(PlayMode.TEAM_PK);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.b
    public final void d(long r4, Map<String, Long> r6) {
        Intrinsics.checkNotNullParameter(r6, "userIdToTeamId");
        if (r4 >= this.j) goto L5;
        return;
    L5:
        this.j = r4;
        this.i = r6;
        i(PlayMode.TEAM_PK);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.d
    public final void h(long r4, List<? extends p> r6, List<? extends p> r7, List<? extends IBaseUser> r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "anchorList");
        Intrinsics.checkNotNullParameter(r7, "waitingList");
        if (r4 >= this.j) goto L5;
        return;
    L5:
        this.j = r4;
        this.e = r6;
        this.f = r7;
        if (r8 != null) goto L8;
        r8 = CollectionsKt.emptyList();
    L8:
        this.g = r8;
        this.h = r9;
        i(PlayMode.PERSONAL_PK);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.network.d
    public final void f(long r4, List<? extends p> r6, List<? extends p> r7, List<? extends IBaseUser> r8, String r9, Map<String, Long> r10) {
        Intrinsics.checkNotNullParameter(r6, "anchorList");
        Intrinsics.checkNotNullParameter(r7, "waitingList");
        Intrinsics.checkNotNullParameter(r10, "userIdToTeamId");
        if (r4 >= this.j) goto L5;
        return;
    L5:
        this.j = r4;
        this.e = r6;
        this.f = r7;
        if (r8 != null) goto L8;
        r8 = CollectionsKt.emptyList();
    L8:
        this.g = r8;
        this.h = r9;
        this.i = r10;
        i(PlayMode.TEAM_PK);
    }
}
