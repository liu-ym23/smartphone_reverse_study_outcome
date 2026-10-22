package l11;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.p;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import d11.f;
import d11.g;
import d11.h;
import d11.k;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k11.e;
import k11.i;
import k11.j;
import k11.l;
import k11.m;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements e, o {
    public final n a;
    public final BehaviorSubject<i> b;
    public final BehaviorSubject<j> c;
    public final BehaviorSubject<m> d;
    public final BehaviorSubject<j> e;
    public final BehaviorSubject<k11.b> f;
    public final BehaviorSubject<j> g;
    public final BehaviorSubject<k11.a> h;
    public final BehaviorSubject<j> i;
    public final BehaviorSubject<l> j;
    public final BehaviorSubject<j> k;
    public final com.bytedance.android.live.revlink.impl.global.c l;

    /* JADX INFO: renamed from: l11.a$a, reason: collision with other inner class name */
    public static final class C0264a extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ a a;

        public C0264a(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Je(int r2, i6 r3, ey.l r4) {
            Intrinsics.checkNotNullParameter(r3, "linkerMessage");
            BehaviorSubject<j> r5 = this.a.g;
            j.a r0 = j.l;
            if (r4 == null) goto L5;
            k11.o r6 = b.a(r4);
        L6:
            r0.getClass();
            r5.onNext(j.a.a(r3, r6));
            return;
        L5:
            r6 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Tg(int r4, i6 r5, ey.l r6) {
            Intrinsics.checkNotNullParameter(r5, "linkerMessage");
            Intrinsics.checkNotNullParameter(r5, "$this$typeExt");
            k11.o r2 = null;
            if (((int) r5.getType2()) != 5) goto L8;
            BehaviorSubject<j> r7 = this.a.e;
            j.a r0 = j.l;
            if (r6 == null) goto L7;
            r2 = b.a(r6);
        L7:
            r0.getClass();
            r7.onNext(j.a.a(r5, r2));
            return;
        L8:
            Intrinsics.checkNotNullParameter(r5, "$this$typeExt");
            if (((int) r5.getType2()) != 8) goto L16;
            BehaviorSubject<j> r8 = this.a.k;
            j.a r1 = j.l;
            if (r6 == null) goto L13;
            r2 = b.a(r6);
        L13:
            r1.getClass();
            r8.onNext(j.a.a(r5, r2));
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void ej(int r2, i6 r3, ey.l r4) {
            Intrinsics.checkNotNullParameter(r3, "linkerMessage");
            BehaviorSubject<j> r5 = this.a.c;
            j.a r0 = j.l;
            if (r4 == null) goto L5;
            k11.o r6 = b.a(r4);
        L6:
            r0.getClass();
            r5.onNext(j.a.a(r3, r6));
            return;
        L5:
            r6 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void jo(int r2, i6 r3, ey.l.b r4) {
            Intrinsics.checkNotNullParameter(r3, "linkerMessage");
            BehaviorSubject<j> r5 = this.a.i;
            j.a r0 = j.l;
            k11.o r6 = b.a(r4);
            r0.getClass();
            r5.onNext(j.a.a(r3, r6));
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void q9(d11.c r10, long r12, ey.l r13) {
            Intrinsics.checkNotNullParameter(r10, "params");
            HashMap r2 = new HashMap();
            BehaviorSubject<k11.b> r0 = this.a.f;
            k11.b.a r1 = k11.b.j;
            d11.i r14 = r10.a();
            if (r13 == null) goto L5;
            k11.o r15 = b.a(r13);
        L6:
            r1.getClass();
            r0.onNext(k11.b.a.a(r14, r2, r15, r12, 0, ""));
            return;
        L5:
            r15 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Cn(g r15, Throwable r16, long r17, ey.l r19) {
            Intrinsics.checkNotNullParameter(r15, "params");
            boolean r1 = r16 instanceof ApiServerException;
            if (r1 == false) goto L5;
            int r3 = ((ApiServerException) r16).getErrorCode();
        L6:
            k11.o r4 = null;
            if (r1 == false) goto L9;
            String r0 = ((ApiServerException) r16).getErrorMsg();
        L11:
            String r13 = r0;
        L13:
            m.a r2 = m.n;
            d11.l r6 = r15.a();
            Map r7 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            if (r19 == null) goto L16;
            r4 = b.a(r19);
        L16:
            r2.getClass();
            this.a.d.onNext(m.a.a(null, r6, r7, r4, r17, r3, r13));
            return;
        L9:
            if (r16 == null) goto L12;
            r0 = r16.getMessage();
            goto L11
        L12:
            r13 = null;
            goto L13
        L5:
            r3 = -1;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Jd(f r12, v r13, long r14, ey.l r15) {
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r13, "permitResult");
            HashMap r3 = new HashMap();
            BehaviorSubject<l> r0 = this.a.j;
            l.a r1 = l.m;
            k r2 = r12.a();
            if (r15 == null) goto L5;
            k11.o r16 = b.a(r15);
        L6:
            r1.getClass();
            r0.onNext(l.a.a(r13, r2, r3, r16, r14, 0, ""));
            return;
        L5:
            r16 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void O8(d11.b r12, com.bytedance.android.livesdk.link.model.f r13, long r14, ey.l r15) {
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r13, "applyResult");
            k11.a.C0258a r0 = k11.a.i;
            h r2 = r12.a();
            Map r3 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            if (r15 == null) goto L5;
            k11.o r16 = b.a(r15);
        L6:
            r0.getClass();
            k11.a r17 = k11.a.C0258a.a(r13, r2, r3, r16, r14, 0, "");
            this.a.h.onNext(r17);
            return;
        L5:
            r16 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Vc(d11.b r14, Throwable r15, long r16, ey.l.b r18) {
            Intrinsics.checkNotNullParameter(r14, "params");
            boolean r1 = r15 instanceof ApiServerException;
            if (r1 == false) goto L5;
            int r3 = ((ApiServerException) r15).getErrorCode();
        L6:
            if (r1 == false) goto L8;
            String r0 = ((ApiServerException) r15).getErrorMsg();
        L11:
            String r12 = r0;
            k11.a.i.getClass();
            this.a.h.onNext(k11.a.C0258a.a(null, r14.a(), com.bytedance.revenue.platform.api.core.d.a(new Pair[0]), b.a(r18), r16, r3, r12));
            return;
        L8:
            if (r15 == null) goto L10;
            r0 = r15.getMessage();
            goto L11
        L10:
            r0 = null;
            goto L11
        L5:
            r3 = -1;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void hl(d11.d r13, long r14, v4 r16, ey.l r17) {
            Intrinsics.checkNotNullParameter(r13, "params");
            Intrinsics.checkNotNullParameter(r16, "inviteResult");
            a r3 = this.a;
            BehaviorSubject<i> r12 = r3.b;
            i.a r4 = i.k;
            d11.j r5 = r13.a(a.a(r3));
            HashMap<String, String> r0 = r13.B;
            k11.o r6 = null;
            if (r0 != null) goto L6;
            r0 = null;
        L6:
            if (r17 == null) goto L8;
            r6 = b.a(r17);
        L8:
            r4.getClass();
            r12.onNext(i.a.a(r16, r5, r0, r6, r14, 0, ""));
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void nf(g r12, q5 r13, long r14, ey.l r16) {
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r13, "replyResult");
            BehaviorSubject<m> r10 = this.a.d;
            m.a r3 = m.n;
            d11.l r4 = r12.a();
            Map r5 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            if (r16 == null) goto L5;
            k11.o r1 = b.a(r16);
        L6:
            r3.getClass();
            r10.onNext(m.a.a(r13, r4, r5, r1, r14, 0, ""));
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void pp(f r14, Throwable r15, long r16, ey.l.b r18) {
            Intrinsics.checkNotNullParameter(r14, "params");
            boolean r1 = r15 instanceof ApiServerException;
            if (r1 == false) goto L5;
            int r3 = ((ApiServerException) r15).getErrorCode();
        L6:
            if (r1 == false) goto L8;
            String r0 = ((ApiServerException) r15).getErrorMsg();
        L11:
            String r12 = r0;
            l.m.getClass();
            this.a.j.onNext(l.a.a(null, r14.a(), com.bytedance.revenue.platform.api.core.d.a(new Pair[0]), b.a(r18), r16, r3, r12));
            return;
        L8:
            if (r15 == null) goto L10;
            r0 = r15.getMessage();
            goto L11
        L10:
            r0 = null;
            goto L11
        L5:
            r3 = -1;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void rp(d11.d r17, Throwable r18, long r19, ey.l.b r22) {
            Intrinsics.checkNotNullParameter(r17, "params");
            boolean r3 = r18 instanceof ApiServerException;
            if (r3 == false) goto L5;
            int r4 = ((ApiServerException) r18).getErrorCode();
        L7:
            if (r3 == false) goto L9;
            String r6 = ((ApiServerException) r18).getErrorMsg();
        L13:
            if (r17.d != 110) goto L16;
            if (r3 == false) goto L16;
            r6 = ((ApiServerException) r18).getPrompt();
        L16:
            String r15 = r6;
            i.a r2 = i.k;
            d11.j r8 = r17.a(a.a(this.a));
            HashMap<String, String> r1 = r17.B;
            if (r1 == null) goto L19;
            HashMap<String, String> r9 = r1;
        L20:
            r2.getClass();
            this.a.b.onNext(i.a.a(null, r8, r9, b.a(r22), r19, r4, r15));
            return;
        L19:
            r9 = null;
            goto L20
        L9:
            if (r18 == null) goto L11;
            r6 = r18.getMessage();
            goto L13
        L11:
            r6 = null;
            goto L13
        L5:
            r4 = -1;
            goto L7
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void wh(d11.c r14, Throwable r15, long r16, ey.l r18) {
            Intrinsics.checkNotNullParameter(r14, "params");
            boolean r1 = r15 instanceof ApiServerException;
            if (r1 == false) goto L5;
            int r3 = ((ApiServerException) r15).getErrorCode();
        L6:
            k11.o r4 = null;
            if (r1 == false) goto L9;
            String r0 = ((ApiServerException) r15).getErrorMsg();
        L11:
            String r12 = r0;
        L13:
            k11.b.a r2 = k11.b.j;
            d11.i r5 = r14.a();
            Map r6 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            if (r18 == null) goto L16;
            r4 = b.a(r18);
        L16:
            r2.getClass();
            this.a.f.onNext(k11.b.a.a(r5, r6, r4, r16, r3, r12));
            return;
        L9:
            if (r15 == null) goto L12;
            r0 = r15.getMessage();
            goto L11
        L12:
            r12 = null;
            goto L13
        L5:
            r3 = -1;
            goto L6
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // k11.e
    public final Observable<j> observeApplyLinkMessage() {
        return this.i;
    }

    @Override // k11.e
    public final Observable<k11.a> observeApplyResult() {
        return this.h;
    }

    @Override // k11.e
    public final Observable<j> observeCancelLinkMessage() {
        return this.g;
    }

    @Override // k11.e
    public final Observable<k11.b> observeCancelResult() {
        return this.f;
    }

    @Override // k11.e
    public final Observable<j> observeInviteLinkMessage() {
        return this.c;
    }

    @Override // k11.e
    public final Observable<i> observeInviteResult() {
        return this.b;
    }

    @Override // k11.e
    public final Observable<j> observePermitLinkMessage() {
        return this.k;
    }

    @Override // k11.e
    public final Observable<l> observePermitResult() {
        return this.j;
    }

    @Override // k11.e
    public final Observable<j> observeReplyLinkMessage() {
        return this.e;
    }

    @Override // k11.e
    public final Observable<m> observeReplyResult() {
        return this.d;
    }

    public a(com.bytedance.android.live.revlink.impl.global.c r4) {
        this.l = r4;
        if (r4 == null) goto L7;
        com.bytedance.android.live.revenuelink.connect.f r0 = r4.Z0();
        if (r0 == null) goto L7;
        n r1 = r0.linkOutManager();
    L8:
        this.a = r1;
        C0264a r2 = new C0264a(this);
        int r3 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.b = BehaviorSubject.create();
        this.c = BehaviorSubject.create();
        this.d = BehaviorSubject.create();
        this.e = BehaviorSubject.create();
        this.f = BehaviorSubject.create();
        this.g = BehaviorSubject.create();
        this.h = BehaviorSubject.create();
        this.i = BehaviorSubject.create();
        this.j = BehaviorSubject.create();
        this.k = BehaviorSubject.create();
        if (r4 == null) goto L13;
        com.bytedance.android.live.revenuelink.connect.f r5 = r4.Z0();
        if (r5 == null) goto L13;
        r5.addLinkOutListener(1, r2);
    L13:
        if (r4 == null) goto L18;
        com.bytedance.android.live.revenuelink.connect.f r6 = r4.Z0();
        if (r6 == null) goto L19;
        r6.addLinkOutListener(7, r2);
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public static final long a(a r2) {
        com.bytedance.android.live.revlink.impl.global.c r3 = r2.l;
        if (r3 == null) goto L11;
        com.bytedance.android.live.revenuelink.connect.f r4 = r3.Z0();
        if (r4 == null) goto L11;
        LiveData<ey.f> r5 = r4.connectState();
        if (r5 == null) goto L11;
        ey.f r6 = (ey.f) r5.getValue();
        if (r6 == null) goto L11;
        return r6.a;
    L11:
        return 0;
    }

    @Override // k11.e
    public final void apply(Map<String, String> r19, h r20, Map<String, String> r22) {
        Intrinsics.checkNotNullParameter(r20, "serverParams");
        int r5 = (int) r20.getScene();
        long r6 = r20.getRoomId();
        long r8 = r20.getToRoomId();
        int r10 = (int) r20.getApplyType();
        String r12 = r20.l();
        long r13 = r20.getChannelId();
        IRoom r15 = vh7.f.c(IRoom.class);
        r15.setIdStr(String.valueOf(r20.getToRoomId()));
        IBaseUser r2 = vh7.f.c(IBaseUser.class);
        Intrinsics.checkNotNullParameter(r20, "$this$revUserId");
        r15.setIdStr(r20.getToOpenId());
        com.bytedance.android.live.base.model.user.o.c(r2, r20.l());
        Unit r4 = Unit.INSTANCE;
        r15.setOwnerKt(r2);
        Intrinsics.checkNotNullParameter(r20, "$this$revUserId");
        String r14 = r20.getToOpenId();
        if (r22 == null) goto L9;
        String r1 = r22.get("index");
        if (r1 == null) goto L9;
        Integer r3 = StringsKt.toIntOrNull(r1);
        if (r3 == null) goto L9;
        int r16 = r3.intValue();
    L10:
        d11.b r0 = new d11.b(r5, r6, r8, r10, r12, r14, r13, r15, r16, r20.getClientAttachedInfo());
        n r7 = this.a;
        if (r7 == null) goto L17;
        if (r19 == null) goto L14;
        Map<String, String> r9 = MapsKt.toMap(r19);
    L15:
        r7.g(r0, r9);
        return;
    L14:
        r9 = null;
        goto L15
    L17:
        return;
    L9:
        r16 = 0;
        goto L10
    }

    @Override // k11.e
    public final void cancel(Map<String, String> r13, d11.i r14, Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r14, "serverParams");
        int r2 = (int) r14.getScene();
        long r3 = r14.getChannelId();
        long r5 = r14.getToRoomId();
        Intrinsics.checkNotNullParameter(r14, "$this$toRevUid");
        String r7 = r14.getToOpenId();
        String r8 = r14.l();
        int r9 = r14.getCancelType();
        String r10 = r14.getRequestSource();
        Map<String, String> r16 = null;
        if (r15 == null) goto L5;
        String r12 = r15.get("invitee_user_ids");
    L6:
        d11.c r0 = new d11.c(r2, r3, r5, r7, r8, r9, r10, r12);
        n r17 = this.a;
        if (r17 == null) goto L12;
        if (r13 == null) goto L10;
        r16 = MapsKt.toMap(r13);
    L10:
        r17.e(r0, r16);
        return;
    L12:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // k11.e
    public final void invite(Map<String, String> r40, d11.j r42, Map<String, String> r43) {
        Intrinsics.checkNotNullParameter(r42, "serverParams");
        int r6 = (int) r42.getScene();
        long r7 = r42.getRoomId();
        long r9 = r42.getToRoomId();
        int r12 = (int) r42.getInviteType();
        int r13 = CastIntegerProtector.parseInt(r42.getMatchType());
        Intrinsics.checkNotNullParameter(r42, "$this$toRevUid");
        String r14 = r42.getToOpenId();
        String r15 = r42.l();
        IRoom r16 = vh7.f.c(IRoom.class);
        r16.setIdStr(String.valueOf(r42.getToRoomId()));
        IBaseUser r4 = vh7.f.c(IBaseUser.class);
        Intrinsics.checkNotNullParameter(r42, "$this$toRevUid");
        r16.setIdStr(r42.getToOpenId());
        com.bytedance.android.live.base.model.user.o.c(r4, r42.l());
        Unit r3 = Unit.INSTANCE;
        r16.setOwnerKt(r4);
        int r17 = r42.getBizType();
        String r18 = r42.getTheme();
        int r5 = (int) r42.getDuration();
        String r19 = r42.getActivityName();
        long r8 = r42.p1();
        int r22 = r42.getInviteSource();
        Integer r23 = Integer.valueOf(r42.getMultiPkMode());
        int r10 = (int) r42.y5();
        Intrinsics.checkNotNullParameter(r42, "$this$inviteeUserIds");
        List r25 = StringsKt.split$default(r42.Q6(), new String[]{","}, false, 0, 6, null);
        String r26 = r42.getBattleConfigSetting();
        if (r43 == null) goto L5;
        String r27 = r43.get("panel_type");
    L6:
        String r28 = r42.getBattleAttachedInfo();
        com.bytedance.android.live.revlink.impl.global.c r20 = this.l;
        if (r20 == null) goto L11;
        w31.c r24 = r20.getPkLinkUtils();
        if (r24 == null) goto L11;
        int r29 = r24.d();
    L12:
        if (r43 == null) goto L18;
        String r30 = r43.get("inviter_index");
        if (r30 == null) goto L18;
        Integer r32 = StringsKt.toIntOrNull(r30);
        if (r32 == null) goto L18;
        int r33 = r32.intValue();
    L19:
        if (r43 == null) goto L25;
        String r34 = r43.get("stay_time");
        if (r34 == null) goto L25;
        Long r35 = StringsKt.toLongOrNull(r34);
        if (r35 == null) goto L25;
        long r36 = r35.longValue();
    L26:
        if (r43 == null) goto L29;
        String r37 = r43.get("request_id");
        if (r37 == null) goto L29;
    L30:
        String r38 = r37;
        String r39 = r42.getClientAttachedInfo();
        String r310 = r42.s();
        HashMap r44 = new HashMap();
        if (r43 == null) goto L33;
        r44.putAll(MapsKt.toMap(r43));
    L33:
        d11.d r0 = new d11.d(r6, r7, r9, r12, r13, r14, r15, r16, r17, r18, r5, r19, r8, r22, r23, r10, r25, r26, r27, r28, r29, r33, r36, r38, r39, r310, r44, new d11.m(Integer.valueOf((int) r42.j()), Integer.valueOf((int) r42.K()), Integer.valueOf((int) r42.x())), 67108864);
        n r2 = this.a;
        if (r2 == null) goto L40;
        if (r40 == null) goto L37;
        Map<String, String> r45 = MapsKt.toMap(r40);
    L38:
        r2.d(r0, r45);
        return;
    L37:
        r45 = null;
        goto L38
    L40:
        return;
    L29:
        r37 = "";
    L25:
        r36 = 0;
    L18:
        r33 = 0;
    L11:
        r29 = 0;
        goto L12
    L5:
        r27 = null;
        goto L6
    }

    @Override // k11.e
    public final void permit(Map<String, String> r12, k r13, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r13, "serverParams");
        int r2 = (int) r13.getScene();
        long r3 = r13.getChannelId();
        int r5 = (int) r13.Z3();
        long r6 = r13.getRoomId();
        Intrinsics.checkNotNullParameter(r13, "$this$applyRevUid");
        String r8 = r13.Z0();
        String r9 = r13.j7();
        Map<String, String> r15 = null;
        if (r14 == null) goto L5;
        String r10 = r14.get("apply_from_interact_id");
    L6:
        f r0 = new f(r2, r3, r5, r6, r8, r9, r10);
        n r16 = this.a;
        if (r16 == null) goto L12;
        if (r12 == null) goto L10;
        r15 = MapsKt.toMap(r12);
    L10:
        r16.k(r0, r15);
        return;
    L12:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // k11.e
    public final void reply(Map<String, String> r34, d11.l r35, Map<String, String> r36) {
        Intrinsics.checkNotNullParameter(r35, "serverParams");
        jy0.b.d("zjh", "reply: serverParams " + r35 + ", clientParams " + r36 + ", serverExtraParams " + r34);
        int r8 = (int) r35.getScene();     // Catch: Exception -> L63
        int r9 = r35.getBizType();     // Catch: Exception -> L63
        long r10 = r35.getChannelId();     // Catch: Exception -> L63
        long r12 = r35.getRoomId();     // Catch: Exception -> L63
        int r14 = (int) r35.getReplyStatus();     // Catch: Exception -> L63
        Intrinsics.checkNotNullParameter(r35, "$this$inviteRevUid");     // Catch: Exception -> L63
        String r15 = r35.V5();     // Catch: Exception -> L63
        String r16 = r35.N8();     // Catch: Exception -> L63
        Integer r18 = Integer.valueOf(r35.getMultiPkMode());     // Catch: Exception -> L63
        int r6 = (int) r35.getMatchType();     // Catch: Exception -> L63
        if (r36 == null) goto L10;
        String r5 = r36.get("invite_type");     // Catch: Exception -> L63
        if (r5 == null) goto L10;
        Integer r7 = StringsKt.toIntOrNull(r5);     // Catch: Exception -> L63
        if (r7 == null) goto L10;
        int r22 = r7.intValue();     // Catch: Exception -> L63
    L11:
        if (r36 == null) goto L18;
        String r13 = r36.get("invite_source");     // Catch: Exception -> L63
        if (r13 == null) goto L18;
        Integer r17 = StringsKt.toIntOrNull(r13);     // Catch: Exception -> L63
        if (r17 == null) goto L18;
        int r23 = r17.intValue();     // Catch: Exception -> L63
    L70:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L27
        if (r36 == null) goto L24;
        String r1 = r36.get("battle_config_setting");     // Catch: Throwable -> L27
        if (r1 == null) goto L24;
        IBattleConfigSetting r2 = (IBattleConfigSetting) l97.a.a.fromJson(r1, TypesJVMKt.getJavaType(Reflection.typeOf(IBattleConfigSetting.class)));     // Catch: Throwable -> L27
    L25:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r3) == false) goto L32;
        r3 = null;
    L32:
        p r24 = (p) r3;     // Catch: Exception -> L63
        if (r36 == null) goto L35;
        String r4 = r36.get("is_multi_reply");     // Catch: Exception -> L63
    L36:
        boolean r25 = Intrinsics.areEqual(r4, DataType.TRUE);     // Catch: Exception -> L63
        if (r36 == null) goto L43;
        String r19 = r36.get("request_source");     // Catch: Exception -> L63
        if (r19 == null) goto L43;
        String r27 = r19;
    L44:
        int r28 = r35.getSwitchPlayMode();     // Catch: Exception -> L63
        if (r36 == null) goto L51;
        String r20 = r36.get("battle_attached_info");     // Catch: Exception -> L63
        if (r20 == null) goto L51;
        String r32 = r20;
    L52:
        d11.a r26 = new d11.a(r6, r22, r23, r24, false, r25, false, r27, r28, null, null, r32, 1616);     // Catch: Exception -> L63
        String r29 = r35.getClientAttachedInfo();     // Catch: Exception -> L63
        String r210 = r35.s();     // Catch: Exception -> L63
        if (r36 == null) goto L55;
        String r211 = r36.get("battle_attached_info");     // Catch: Exception -> L63
    L56:
        g r30 = new g(r8, r9, r10, r12, r14, r15, r16, null, r18, r26, r29, r210, r211, new d11.m(Integer.valueOf((int) r35.j()), Integer.valueOf((int) r35.K()), Integer.valueOf((int) r35.x())), 128);     // Catch: Exception -> L63
        n r33 = this.a;     // Catch: Exception -> L63
        if (r33 == null) goto L74;
        if (r34 == null) goto L60;
        Map<String, String> r37 = MapsKt.toMap(r34);     // Catch: Exception -> L63
    L61:
        r33.h(r30, r37);     // Catch: Exception -> L63
        return;
    L60:
        r37 = null;
        goto L61
    L74:
        return;
    L55:
        r211 = null;
    L51:
        r32 = "";
    L43:
        r27 = "";
        goto L44
    L35:
        r4 = null;
    L24:
        r2 = null;
    L27:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Exception -> L63
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L63
    L18:
        r23 = 0;
    L10:
        r22 = 0;
    L63:
        e = move-exception;
        JSONObject r39 = new JSONObject();
        r39.put("message", e.getMessage());
        com.bytedance.android.live.revlink.impl.global.c r40 = this.l;
        if (r40 == null) goto L75;
        com.bytedance.android.live.revenuelink.f r42 = r40.getRevenueLinkTraceMonitor();
        if (r42 == null) goto L76;
        r42.b0("aio_reply_failed", LiveTracingMonitorKt.EventModule.PK, r39);
        return;
    L76:
        return;
    }
}
