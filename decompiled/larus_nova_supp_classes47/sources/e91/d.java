package e91;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.n;
import yt1.o;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends a<AnchorTabLabel> {
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public n h;
    public k i;
    public q j;
    public long k;
    public o l;
    public boolean m;
    public final m91.c n;

    @Override // e91.a
    public final void c() {
        this.m = false;
        super.c();
    }

    @Override // e91.a, com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void b() {
        super.b();
        this.m = true;
        q r0 = this.j;
        if (r0 == null) goto L8;
        n r1 = this.h;
        if (r1 == null) goto L9;
        r1.a(r0, this.i);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void a(AnchorTabLabel r9) {
        Intrinsics.checkNotNullParameter(r9, Constants.Keys.DATA);
        this.k = System.currentTimeMillis();
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        q r2 = null;
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.q r3 = IRoomContextService.a.b(r1, this.n.getDataCenter(), 2);
        if (r3 == null) goto L9;
        j r4 = r3.E1();
        if (r4 == null) goto L9;
        n r5 = (n) r4.getValue();
    L10:
        this.h = r5;
        LiveDSLModel r6 = r9.getDslLabel();
        if (r6 == null) goto L13;
        o.e.getClass();
        o r7 = o.a.b(r6);
        this.j = r7.b;
        Unit r8 = Unit.INSTANCE;
    L14:
        this.l = r7;
        n r10 = this.h;
        boolean r12 = true;
        if (r10 == null) goto L26;
        if (r7 == null) goto L18;
        String r13 = r7.getType();
    L19:
        o r14 = this.l;
        if (r14 == null) goto L23;
        r2 = r14.b;
    L23:
        if (r10.b(r13, r2) != true) goto L26;
        r12 = false;
        goto L26
    L18:
        r13 = null;
    L26:
        String r15 = "render label, noCache:" + r12;
        if (v.a() == false) goto L29;
        ALogger.i("DslLabelController", r15);
    L29:
        Intrinsics.checkNotNullParameter(r9, Constants.Keys.DATA);
        ViewGroup r0 = this.b.getContainer();
        if (this.a == true) goto L49;
        if (r0 == null) goto L50;
        o r16 = this.l;
        if (r16 == null) goto L54;
        n r17 = this.h;
        if (r17 == null) goto L55;
        LiveDSLModel r18 = r9.getDslLabel();
        if (r18 == null) goto L51;
        String r19 = r18.getDslData();
        if (r19 != null) goto L43;
        r19 = "";
    L43:
        k r20 = r17.c(r16, r19, r0.getContext(), null, new c(this, r17, r0));
        this.i = r20;
        if (r20 == null) goto L52;
        View r22 = r20.getView();
        if (r22 == null) goto L53;
        a1.p(r0, this.g);
        a1.k(r0, this.f);
        r0.addView(r22);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L55:
        return;
    L54:
        return;
    L50:
        return;
    L49:
        return;
    L13:
        r7 = null;
    L9:
        r5 = null;
        goto L10
    }

    public d(m91.c r2, com.bytedance.android.live.room.navi.userinfo_p.presenter.h r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r3);
        this.n = r2;
        this.c = UtilityKotlinExtentionsKt.i(30);
        this.d = UtilityKotlinExtentionsKt.i(8);
        this.e = UtilityKotlinExtentionsKt.i(78);
        this.f = UtilityKotlinExtentionsKt.i(12);
        this.g = UtilityKotlinExtentionsKt.i(110);
        new CompositeDisposable();
    }
}
