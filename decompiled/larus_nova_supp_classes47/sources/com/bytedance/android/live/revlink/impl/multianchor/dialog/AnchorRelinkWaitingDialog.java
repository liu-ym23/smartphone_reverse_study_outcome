package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.connect.MultiAnchorRelinkService;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.connect.n;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoInviteView;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import cy0.e;
import cy0.j;
import d11.o;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/AnchorRelinkWaitingDialog;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorRelinkWaitingDialog extends LinkCommonDialogFragment {
    public final i11.b e;
    public final CompositeDisposable f;
    public AnchorLinkInfoInviteView g;
    public AnchorLinkInfoInviteView h;
    public TextView i;
    public Animation j;
    public o k;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AnchorRelinkWaitingDialog a;

        public a(AnchorRelinkWaitingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            i6 r3 = (i6) r2;
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorRelinkWaitingDialog a;

        public b(AnchorRelinkWaitingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            o9 r3 = (o9) r2;
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorRelinkWaitingDialog a;

        public c(AnchorRelinkWaitingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public AnchorRelinkWaitingDialog() {
        this.e = com.bytedance.android.live.revlink.impl.global.b.e();
        this.f = new CompositeDisposable();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.f.dispose();
        Animation r0 = this.j;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Animation r5 = AnimationUtils.loadAnimation(getContext(), 2130772674);
        this.j = r5;
        if (r5 == null) goto L5;
        r5.setInterpolator(new LinearInterpolator());
    L5:
        ld.a r6 = ld.d.a();
        if (r6 == null) goto L14;
        NextLiveData r7 = r6.so();
        if (r7 == null) goto L14;
        Observable r8 = ld.c.a(r7);
        if (r8 == null) goto L14;
        Disposable r9 = r8.subscribe(new c(this));
        if (r9 == null) goto L14;
        RxUtilKt.c(r9, this.f);
    L14:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r10 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r10 == null) goto L17;
        MultiAnchorRelinkService r12 = r10.Fa();
    L18:
        if (r12 == null) goto L40;
        RelinkDataContext r13 = r12.b;
        if (r13 == null) goto L41;
        RxUtilKt.c(r13.getReceiveSwitchChannelReply().onEvent().subscribe(new a(this)), this.f);
        RxUtilKt.c(r13.getRelinkSwitchSuccess().onEvent().subscribe(new b(this)), this.f);
        n r14 = (n) r13.getRelinkState().getValue();
        if ((r14 instanceof n.b) == false) goto L42;
        o r15 = ((n.b) r14).a;
        this.k = r15;
        int r0 = o31.a.a;
        Intrinsics.checkNotNullParameter(r15, "inviteParams");
        LinkedHashMap r1 = new LinkedHashMap();
        d31.d r2 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r2 == null) goto L26;
        Map<String, String> r3 = r2.i();
    L27:
        r1.putAll(r3);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.d() == false) goto L30;
        String r16 = "pk_participate";
    L31:
        r1.put("source", r16);
        int r17 = r15.b;
        if (r17 != 20) goto L34;
        String r18 = "team_quit";
    L38:
        r1.put("disconnect_scene", r18);
        r1.put("relink_invitee_cnt", String.valueOf(r15.a.size()));
        mz0.n r19 = new mz0.n();
        Map<String, String> r20 = r19.a;
        Intrinsics.checkNotNullParameter(r20, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r20.putAll(r1);
        m r22 = new m();
        r22.b(LogCommon.ROOM);
        List<Object> r23 = r19.b;
        ArrayList r24 = (ArrayList) r23;
        r24.addAll(r22.a);
        e.a.getClass();
        j r25 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r26 = com.bytedance.android.scope.m.b(r25).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r26);
        ((i) ((f80.a) r26)).w3("livesdk_connection_relink_wait_tab_show", r19.a, r19.b);
        return;
    L34:
        if (r17 == 21) goto L36;
        r18 = "";
        goto L38
    L36:
        r18 = "relink";
        goto L38
    L30:
        r16 = "link_participate";
        goto L31
    L26:
        r3 = MapsKt.emptyMap();
        goto L27
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L17:
        r12 = null;
        goto L18
    }

    public final void S90(AnchorLinkInfoInviteView r8, p r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        IBaseUser r10 = r9.getUser();
        if (r10 != null) goto L7;
        return;
    L7:
        a1.x(r8.getIvAvatar(), r10.getAvatarThumbKt(), r8.getIvAvatar().getWidth(), r8.getIvAvatar().getHeight(), 2131250965);
        r8.getTvNickname().setText(r10.getNickName());
        if (r10.getGender() != 1) goto L11;
        r8.getIvGender().setImageResource(2131250688);
        r8.getIvGender().setVisibility(0);
    L15:
        if (r10.getFollowInfo() == null) goto L21;
        py.j r0 = r10.getFollowInfo();
        if (r0 == null) goto L21;
        if (r0.getFollowStatus() != 2) goto L21;
        r8.getTvLabelTop().setVisibility(0);
    L21:
        r8.getTvDistance().setVisibility(0);
        if (r10.getFollowInfo() == null) goto L28;
        TextView r1 = r8.getTvDistance();
        Object[] r2 = new Object[1];
        py.j r12 = r10.getFollowInfo();
        if (r12 == null) goto L26;
        long r3 = r12.getFollowerCount();
    L27:
        r2[0] = IESUIUtils.getDisplayCount(r3, "w");
        r1.setText(s1.C(2131914749, r2));
        goto L28
    L26:
        r3 = 0;
    L28:
        r8.setVisibility(0);
        r8.getAnimWave().startAnimation(this.j);
        r8.getAnimWave().setVisibility(0);
        return;
    L11:
        if (r10.getGender() != 2) goto L13;
        r8.getIvGender().setImageResource(2131250687);
        r8.getIvGender().setVisibility(0);
        goto L15
    L13:
        r8.getIvGender().setVisibility(8);
        goto L15
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        com.bytedance.android.live.revlink.impl.multianchor.service.a r7 = com.bytedance.android.live.revlink.impl.global.b.t();
        ArrayList r8 = null;
        if (r7 == null) goto L5;
        MultiAnchorRelinkService r9 = r7.Fa();
    L7:
        if (r9 == null) goto L21;
        List<String> r10 = r9.q(false);
        if (r10 == null) goto L21;
        ArrayList r1 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L12:
        if (r12.hasNext() == false) goto L19;
        String r2 = (String) r12.next();
        i11.b r3 = this.e;
        if (r3 == null) goto L16;
        p r4 = r3.getGuestInfo(r2, null);
    L17:
        if (r4 == null) goto L12;
        r1.add(r4);
        goto L12
    L16:
        r4 = null;
        goto L17
    L19:
        r8 = r1;
    L21:
        if (r8 != null) goto L23;
    L25:
        if (r8 != null) goto L27;
    L34:
        TextView r13 = this.i;
        if (r13 == null) goto L43;
        r13.setOnClickListener(x0.a(new AnonymousClass1(this)));
        return;
    L43:
        return;
    L27:
        if (r8.size() != 2) goto L34;
        S90(this.g, (p) ListProtector.get(r8, 0));
        S90(this.h, (p) ListProtector.get(r8, 1));
        AnchorLinkInfoInviteView r14 = this.g;
        if (r14 == null) goto L31;
        com.bytedance.android.live.core.utils.a1.m(r14, s1.f(40.0f));
    L31:
        AnchorLinkInfoInviteView r15 = this.h;
        if (r15 == null) goto L34;
        com.bytedance.android.live.core.utils.a1.n(r15, s1.f(40.0f));
        goto L34
    L23:
        if (r8.size() != 1) goto L25;
        S90(this.g, (p) ListProtector.get(r8, 0));
        goto L34
    L5:
        r9 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        View r4 = r1.inflate(2131565379, r2);
        this.g = (AnchorLinkInfoInviteView) r4.findViewById(2131377963);
        this.h = (AnchorLinkInfoInviteView) r4.findViewById(2131377964);
        this.i = (TextView) r4.findViewById(2131384215);
        return r4;
    }
}
