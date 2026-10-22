package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkBanSettingFragment;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/RevInteractDialogFragmentBaseContract$View;", "Li21/c;", "Lx31/d;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkBanSettingFragment extends RevInteractDialogFragmentBaseContract$View<i21.c> implements x31.d, View.OnClickListener {
    public static final /* synthetic */ int n = 0;
    public Map<Integer, View> g;
    public IBaseUser h;
    public IRoom i;
    public final LinkCrossRoomDataHolder j;
    public i6 k;
    public x31.e l;
    public IBattleLinkerInviteMessageExtra m;

    public static final class a {
        public static PkBanSettingFragment a(com.bytedance.android.live.revlink.impl.control.dialog.r r1, IRoom r2, x31.e r3, i6 r4) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r2, "room");
            Intrinsics.checkNotNullParameter(r3, "inviteCallback");
            PkBanSettingFragment r0 = new PkBanSettingFragment();
            r0.i = r2;
            r0.d = r1;
            r0.l = r3;
            r0.k = r4;
            if (r4 != null) goto L5;
        L18:
            return r0;
        L5:
            if (j6.a(r4) == null) goto L18;
            IBattleLinkerInviteMessageExtra r5 = j6.a(r4);
            r0.m = r5;
            IBaseUser r6 = null;
            if (r5 == null) goto L10;
            IRoom r7 = r5.getInviteRoom();
        L11:
            if (r7 == null) goto L18;
            IBattleLinkerInviteMessageExtra r8 = r0.m;
            if (r8 == null) goto L17;
            IRoom r9 = r8.getInviteRoom();
            if (r9 == null) goto L17;
            r6 = r9.getOwner();
        L17:
            r0.h = r6;
            goto L18
        L10:
            r7 = null;
            goto L11
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PkBanSettingFragment a;

        public b(PkBanSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            PkBanSettingFragment r3 = this.a;
            int r0 = PkBanSettingFragment.n;
            r3.d.v0();
            this.a.ea0(3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkBanSettingFragment a;

        public c(PkBanSettingFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            x31.e r4 = this.a.l;
            if (r4 == null) goto L5;
            r4.ec();
        L5:
            com.bytedance.android.live.revlink.impl.control.dialog.r r5 = this.a.d;
            if (r5 == null) goto L8;
            r5.v0();
        L8:
            ToastUtil.a(2131917824, 0);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PkBanSettingFragment a;

        public d(PkBanSettingFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            PkBanSettingFragment r4 = this.a;
            int r0 = PkBanSettingFragment.n;
            r4.d.v0();
            x31.e r5 = this.a.l;
            if (r5 == null) goto L5;
            r5.ec();
        L5:
            ToastUtil.a(2131917824, 0);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "obj");
            r3.printStackTrace();
            ToastUtil.a(2131917821, 0);
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "obj");
            r3.printStackTrace();
            ToastUtil.a(2131917821, 0);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ PkBanSettingFragment a;

        public g(PkBanSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            PkBanSettingFragment r3 = this.a;
            int r0 = PkBanSettingFragment.n;
            r3.d.v0();
            this.a.ea0(3);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        return 177.0f;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final View V90() {
        View r0 = new View(getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        r0.setOnClickListener(new b(this));
        return r0;
    }

    public final Map<String, String> da0() {
        LinkedHashMap r0 = new LinkedHashMap();
        IRoom r1 = this.d.getCurrentRoom();
        i6 r2 = this.k;
        if (r2 == null) goto L9;
        IBattleLinkerInviteMessageExtra r3 = j6.a(r2);
        if (r3 == null) goto L9;
        IBattleConfigSetting r4 = r3.getBattleConfigSetting();
        if (r4 == null) goto L9;
        String r5 = r4.getActivityId();
    L10:
        if (r5 != null) goto L12;
    L14:
        if (r1 == null) goto L16;
        r0.put("room_id", String.valueOf(r1.getId()));
        r0.put("anchor_id", String.valueOf(r1.getAnchorId()));
    L16:
        IBaseUser r6 = this.h;
        if (r6 == null) goto L19;
        r0.put("inviter_id", String.valueOf(iz.a.a(r6)));
    L19:
        IBattleLinkerInviteMessageExtra r7 = this.m;
        if (r7 == null) goto L22;
        aa r8 = r7.getVoteSetting();
    L24:
        if (r8 == null) goto L26;
        r0.put("invite_mode", "vote");
    L27:
        int r9 = UserListInviteType.a;
        LinkCrossRoomDataHolder r10 = this.j;
        if (r10 == null) goto L30;
        int r12 = r10.f();
    L31:
        r0.put("invitee_list", UserListInviteType.a(r12, null));
        return r0;
    L30:
        r12 = 0;
        goto L31
    L26:
        r0.put("invite_mode", "routine_pk");
        goto L27
    L22:
        r8 = null;
        goto L24
    L12:
        if (r2.a(r5) != true) goto L14;
        r0.put("flex_activity_id", r5);
    L9:
        r5 = null;
        goto L10
    }

    public PkBanSettingFragment() {
        this.g = new LinkedHashMap();
        this.j = com.bytedance.android.live.revlink.impl.global.b.j();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        String r1 = r0.getString(2131917819);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567411, null);
        if (r0 == null) goto L7;
        return (ViewGroup) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        x31.e r0 = this.l;
        if (r0 != null) goto L5;
    L7:
        ((LinkedHashMap) this.g).clear();
        return;
    L5:
        if (r0.UK() != true) goto L7;
        this.d.dismiss();
        goto L7
    }

    @Override // x31.d
    public final boolean d() {
        return ((BaseFragment) this).mStatusViewValid;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final int Y90(View r1) {
        return s1.f(50.0f);
    }

    public final View ba0(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void ca0(com.bytedance.android.livesdk.link.model.s1 r2) {
        if (r2 == null) goto L11;
        this.m = r2.getBattleExtra();
        IBattleLinkerInviteMessageExtra r3 = r2.getBattleExtra();
        if (r3 == null) goto L8;
        IRoom r4 = r3.getInviteRoom();
        if (r4 == null) goto L8;
        IBaseUser r5 = r4.getOwner();
    L9:
        this.h = r5;
        return;
    L8:
        r5 = null;
        goto L9
    }

    public final void ea0(int r5) {
        Map<String, String> r0 = da0();
        i6 r1 = this.k;
        if (r1 == null) goto L9;
        IBattleLinkerInviteMessageExtra r2 = j6.a(r1);
        if (r2 == null) goto L9;
        IBattleConfigSetting r3 = r2.getBattleConfigSetting();
        if (r3 == null) goto L9;
        String r4 = r3.getActivityId();
    L10:
        if (r4 != null) goto L12;
    L14:
        r0.put("panel_select", String.valueOf(r5));
        mz0.n r6 = new mz0.n();
        Map<String, String> r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        mz0.m r8 = new mz0.m();
        LinkCrossRoomDataHolder.a r9 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r8);
        List<Object> r10 = r6.b;
        ArrayList r12 = (ArrayList) r10;
        r12.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_pk_disturb_settings_panel_click", r6.a, r6.b);
        return;
    L12:
        if (r2.a(r4) != true) goto L14;
        r0.put("flex_activity_id", r4);
    L9:
        r4 = null;
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        String r0 = null;
        if (r9 == null) goto L5;
        Integer r10 = Integer.valueOf(r9.getId());
    L7:
        if (r10 != null) goto L10;
    L21:
        if (r10 != null) goto L24;
        return;
    L24:
        if (r10.intValue() != 2131390206) goto L45;
        ea0(2);
        IRoom r12 = this.i;
        if (r12 == null) goto L46;
        HashMap r7 = new HashMap();
        r7.put("invite_reject_temporary", Boolean.TRUE);
        IBaseUser r2 = this.h;
        if (r2 == null) goto L32;
        String r3 = iz.a.a(r2);
        if (r3 == null) goto L32;
        r7.put("rival_anchor_id", r3);
    L32:
        r31.a r4 = r31.b.a(r31.a.a);
        long r5 = r12.getId();
        IBaseUser r13 = r12.getOwner();
        if (r13 == null) goto L35;
        Intrinsics.checkNotNullParameter(r13, "$this$secUidExt");
        r0 = r13.getCastSecUid();
    L35:
        Observable<ExtraResponse<Object, Extra>> r14 = r4.N(r5, r0, 11, r7);
        if (r14 == null) goto L47;
        ObservableSubscribeProxy r15 = (ObservableSubscribeProxy) r14.as(T90());
        if (r15 == null) goto L48;
        r15.subscribe(new d(this), f.a);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L10:
        if (r10.intValue() != 2131390207) goto L21;
        ea0(1);
        IRoom r16 = this.i;
        if (r16 == null) goto L41;
        HashMap r8 = new HashMap();
        r8.put("auto_reject_curr_room", Boolean.TRUE);
        r31.a r6 = r31.b.a(r31.a.a);
        long r17 = r16.getId();
        IBaseUser r18 = r16.getOwner();
        if (r18 == null) goto L16;
        Intrinsics.checkNotNullParameter(r18, "$this$secUidExt");
        r0 = r18.getCastSecUid();
    L16:
        Observable<ExtraResponse<Object, Extra>> r19 = r6.N(r17, r0, 3, r8);
        if (r19 == null) goto L42;
        ObservableSubscribeProxy r20 = (ObservableSubscribeProxy) r19.as(T90());
        if (r20 == null) goto L43;
        r20.subscribe(new c(this), e.a);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L5:
        r10 = null;
        goto L7
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        TextView r5 = (TextView) ba0(2131390207);
        if (r5 == null) goto L5;
        r5.setOnClickListener(this);
    L5:
        TextView r6 = (TextView) ba0(2131390206);
        if (r6 == null) goto L8;
        r6.setOnClickListener(this);
    L8:
        i6 r7 = this.k;
        if (r7 == null) goto L13;
        e6 r8 = r7.getInvite();
        if (r8 == null) goto L13;
        String r9 = r8.getInviteRejectTemporaryText();
    L14:
        if (r9 != null) goto L16;
    L21:
        ((TextView) ba0(2131390273)).setOnClickListener(new g(this));
        mz0.n r10 = new mz0.n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Map<String, String> r1 = da0();
        Intrinsics.checkNotNullParameter(r1, "map");
        r12.putAll(r1);
        mz0.m r13 = new mz0.m();
        LinkCrossRoomDataHolder.a r0 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r13);
        List<Object> r2 = r10.b;
        ArrayList r14 = (ArrayList) r2;
        r14.addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((mz0.i) ((f80.a) r16)).w3("livesdk_pk_disturb_settings_panel_show", r10.a, r10.b);
        return;
    L16:
        if (r9.length() <= 0) goto L18;
        boolean r17 = true;
    L19:
        if (r17 != true) goto L21;
        ((TextView) ba0(2131390206)).setText(r9);
        goto L21
    L18:
        r17 = false;
    L13:
        r9 = null;
        goto L14
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565691, r3, false);
    }
}
