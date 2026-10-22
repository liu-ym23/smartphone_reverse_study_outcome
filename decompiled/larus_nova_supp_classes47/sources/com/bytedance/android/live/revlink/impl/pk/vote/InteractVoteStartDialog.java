package com.bytedance.android.live.revlink.impl.pk.vote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.z0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteStartDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "BattleSelfDataType", "a", "b", "c", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractVoteStartDialog extends LiveDialogFragment {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> d;
    public final CompositeDisposable e;
    public List<? extends aa> f;
    public b g;
    public long h;
    public c i;
    public final boolean j;
    public final e k;
    public final d l;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteStartDialog$BattleSelfDataType;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "BattleSelfDataType_Custom", "BattleSelfDataType_Vote", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleSelfDataType extends Enum<BattleSelfDataType> {
        public static final BattleSelfDataType BattleSelfDataType_Custom = null;
        public static final BattleSelfDataType BattleSelfDataType_Vote = null;
        public static final /* synthetic */ BattleSelfDataType[] a = null;
        private int type;

        static {
            BattleSelfDataType r1 = new BattleSelfDataType("BattleSelfDataType_Custom", 0, 0);
            BattleSelfDataType_Custom = r1;
            BattleSelfDataType r2 = new BattleSelfDataType("BattleSelfDataType_Vote", 1, 1);
            BattleSelfDataType_Vote = r2;
            a = new BattleSelfDataType[]{r1, r2};
        }

        public static BattleSelfDataType valueOf(String r1) {
            return (BattleSelfDataType) r27.a.a(BattleSelfDataType.class, r1);
        }

        public static BattleSelfDataType[] values() {
            return (BattleSelfDataType[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int r1) {
            this.type = r1;
        }

        public BattleSelfDataType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final long a;
        public final String b;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L10;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r1 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public final String toString() {
            return "VoteSelectData(voteType=" + this.a + ", voteDes=" + this.b + ")";
        }

        public b() {
            this(0, "");
        }

        public b(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "voteDes");
            this.a = r2;
            this.b = r4;
        }
    }

    public interface c {
        void a(long r1, aa r3);
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ InteractVoteStartDialog a;

        public d(InteractVoteStartDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            int r4 = r3.getId();
            if (r4 != 2131390539) goto L10;
            InteractVoteStartDialog r5 = this.a;
            if (r5.j == false) goto L7;
            long r0 = 30;
        L8:
            r5.W90(r0);
            return;
        L7:
            r0 = 300;
            goto L8
        L10:
            if (r4 != 2131390540) goto L13;
            InteractVoteStartDialog r6 = this.a;
            int r1 = InteractVoteStartDialog.m;
            r6.W90(600);
            return;
        L13:
            if (r4 != 2131390541) goto L18;
            InteractVoteStartDialog r7 = this.a;
            int r2 = InteractVoteStartDialog.m;
            r7.W90(900);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ InteractVoteStartDialog a;

        public e(InteractVoteStartDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            PkBaseStateMachine.c r4 = (PkBaseStateMachine.c) r3;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = com.bytedance.android.live.revlink.impl.global.b.R();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isInVote() == true) goto L7;
            return;
        L7:
            if (r4.a() == true) goto L16;
            return;
        L16:
            this.a.dismiss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L21;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vote.InteractVoteStartDialog$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(InteractVoteStartDialog r8) {
            super(1, r8, InteractVoteStartDialog.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            InteractVoteStartDialog r0 = (InteractVoteStartDialog) ((CallableReference) this).receiver;
            r0.getClass();
            if (r2 != null) goto L6;
            return;
        L6:
            if ((r2 instanceof r0) == false) goto L16;
            r0.dismiss();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L17;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L17:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public InteractVoteStartDialog() {
        this.d = new LinkedHashMap();
        this.e = new CompositeDisposable();
        this.h = 300;
        k51.a r0 = k51.a.h;
        r0.getClass();
        this.j = ((Boolean) k51.a.d.getValue(r0, k51.a.a[2])).booleanValue();
        this.k = new e(this);
        this.l = new d(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.e.dispose();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r0 == null) goto L8;
        LiveData<PkBaseStateMachine.c> r1 = r0.getPkBaseState();
        if (r1 == null) goto L9;
        r1.removeObserver(this.k);
        return;
    L9:
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public static void U90(TextView r1) {
        if (r1 == null) goto L5;
        r1.setBackground(s1.m(2131253317));
        r1.setTextColor(s1.h(2131107690));
        return;
    }

    public static void V90(TextView r1) {
        if (r1 == null) goto L5;
        r1.setBackground(s1.m(2131253318));
        r1.setTextColor(ColorProtector.parseColor("#161823"));
        return;
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void W90(long r7) {
        if (r7 != 30) goto L6;
        U90((TextView) S90(2131390539));
        V90((TextView) S90(2131390540));
        V90((TextView) S90(2131390541));
    L15:
        if (r7 == 0) goto L18;
        this.h = r7;
        return;
    L18:
        return;
    L6:
        if (r7 != 300) goto L9;
        U90((TextView) S90(2131390539));
        V90((TextView) S90(2131390540));
        V90((TextView) S90(2131390541));
        goto L15
    L9:
        if (r7 != 600) goto L12;
        U90((TextView) S90(2131390540));
        V90((TextView) S90(2131390539));
        V90((TextView) S90(2131390541));
        goto L15
    L12:
        if (r7 != 900) goto L15;
        U90((TextView) S90(2131390541));
        V90((TextView) S90(2131390539));
        V90((TextView) S90(2131390540));
        goto L15
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setStyle(1, 2131954578);
        l r5 = (l) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), l.class);
        if (r5 == null) goto L10;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r6 = yz0.h.a.a(r5, com.bytedance.android.live.revenue.common.message.b.e, false, 6);
        if (r6 == null) goto L11;
        final AnonymousClass1 r0 = new AnonymousClass1(this);
        Disposable r7 = r6.subscribe(new f(r0));
        if (r7 == null) goto L12;
        RxUtilKt.c(r7, this.e);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static final void T90(InteractVoteStartDialog r4, String r5) {
        r4.getClass();
        HashMap r0 = new HashMap();
        String r2 = "";
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L5;
        String r1 = "2";
    L14:
        r0.put("anchor_connect_status", r1);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L17;
        String r3 = "pk_participate";
    L18:
        r0.put("source", r3);
        b r6 = r4.g;
        if (r6 == null) goto L24;
        String r7 = r6.b;
        if (r7 == null) goto L24;
        r2 = r7;
    L24:
        r0.put(FileUtils.PICTURE_THEME, r2);
        r0.put("time_set", String.valueOf(r4.h));
        int r8 = UserListInviteType.a;
        LinkCrossRoomDataHolder r9 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r9 == null) goto L27;
        int r10 = r9.f();
    L28:
        Long r12 = null;
        r0.put("invitee_list", UserListInviteType.a(r10, null));
        w31.c r13 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r13 == null) goto L31;
        r12 = Long.valueOf(r13.i());
    L31:
        r0.put("pk_id", String.valueOf(r12));
        r0.put("click_type", r5);
        n r14 = new n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r15.putAll(r0);
        m r16 = new m();
        LinkCrossRoomDataHolder.a r17 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r16);
        r16.b(LogCommon.ROOM);
        List<Object> r18 = r14.b;
        ArrayList r19 = (ArrayList) r18;
        r19.addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_vote_setting_panel_click", r14.a, r14.b);
        return;
    L27:
        r10 = 0;
        goto L28
    L17:
        r3 = "link_participate";
        goto L18
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r23 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r23 == null) goto L13;
        i11.b r24 = r23.getLinkUserCenter();
        if (r24 == null) goto L13;
        List<p> r25 = r24.getOnlineUserList();
        if (r25 == null) goto L13;
        r1 = String.valueOf(r25.size());
        if (r1 != null) goto L14;
    L13:
        r1 = "";
        goto L14
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        W90(l51.a.f());
        if (this.j == false) goto L5;
        ((TextView) S90(2131390539)).setText("30s");
    L5:
        ((TextView) S90(2131390539)).setOnClickListener(this.l);
        ((TextView) S90(2131390540)).setOnClickListener(this.l);
        ((TextView) S90(2131390541)).setOnClickListener(this.l);
        ((LinearLayout) S90(2131378852)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.vote.c(this));
        ((FrameLayout) S90(2131376031)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.vote.d(this));
        ((TextView) S90(2131391505)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.vote.e(this));
        ((TextView) S90(2131391341)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.vote.f(this));
        Observable<ExtraResponse<z0, Extra>> r4 = r31.b.a(r31.a.a).q(BattleSelfDataType.BattleSelfDataType_Vote.getType());
        if (r4 == null) goto L12;
        Observable r5 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r5 == null) goto L12;
        Disposable r6 = r5.subscribe(new com.bytedance.android.live.revlink.impl.pk.vote.a(this), com.bytedance.android.live.revlink.impl.pk.vote.b.a);
        if (r6 == null) goto L12;
        RxUtilKt.c(r6, this.e);
    L12:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r7 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r7 == null) goto L18;
        LiveData<PkBaseStateMachine.c> r8 = r7.getPkBaseState();
        if (r8 == null) goto L19;
        r8.observeForever(this.k);
        return;
    L19:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565559, r3, false);
    }
}
