package com.bytedance.android.live.revlink.impl.pk.vote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteThemeSelectDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteThemeBinder$b;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractVoteThemeSelectDialog extends LiveDialogFragment implements InteractVoteThemeBinder.b {
    public Map<Integer, View> d;
    public List<? extends aa> e;
    public InteractVoteStartDialog.b f;
    public InteractVoteStartDialog.b g;
    public final ArrayList<InteractVoteThemeBinder.a> h;
    public InteractVoteThemeBinder.b i;
    public MultiTypeAdapter j;
    public final a k;

    public static final class a<T> implements Observer {
        public final /* synthetic */ InteractVoteThemeSelectDialog a;

        public a(InteractVoteThemeSelectDialog r1) {
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

    public InteractVoteThemeSelectDialog() {
        this.d = new LinkedHashMap();
        this.h = new ArrayList();
        this.k = new a(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
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

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954578);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vote.InteractVoteThemeBinder.b
    public final void s80(InteractVoteStartDialog.b r7) {
        Intrinsics.checkNotNullParameter(r7, "themeData");
        this.g = r7;
        ArrayList<InteractVoteThemeBinder.a> r8 = this.h;
        if (r8 == null) goto L14;
        Iterator<InteractVoteThemeBinder.a> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L14;
        InteractVoteThemeBinder.a r0 = r9.next();
        long r1 = r0.a;
        InteractVoteStartDialog.b r3 = this.g;
        if (r3 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        r0.c = r2;
        goto L6
    L10:
        if (r1 != r3.a) goto L12;
        r2 = true;
    L14:
        ArrayList<InteractVoteThemeBinder.a> r10 = this.h;
        if (r10 == null) goto L25;
        MultiTypeAdapter r4 = this.j;
        if (r4 == null) goto L19;
        r4.a = r10;
    L19:
        if (r4 == null) goto L26;
        r4.notifyDataSetChanged();
        return;
    L26:
        return;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        this.g = this.f;
        MultiTypeAdapter r12 = new MultiTypeAdapter();
        this.j = r12;
        r12.z2(InteractVoteThemeBinder.a.class, new InteractVoteThemeBinder());
        ((PkItemExposeRecyclerView) S90(2131385022)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((PkItemExposeRecyclerView) S90(2131385022)).setAdapter(this.j);
        this.h.clear();
        InteractVoteStartDialog.b r13 = this.f;
        if (r13 == null) goto L5;
        this.h.add(new InteractVoteThemeBinder.a(r13.a, r13.b, true, this));
    L5:
        List<? extends aa> r14 = this.e;
        if (r14 == null) goto L17;
        Iterator<T> r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L17;
        aa r16 = (aa) r15.next();
        long r0 = r16.getVoteType();
        InteractVoteStartDialog.b r2 = this.f;
        if (r2 == null) goto L14;
        if (r0 == r2.a) goto L9;
    L14:
        ArrayList<InteractVoteThemeBinder.a> r1 = this.h;
        if (r1 == null) goto L9;
        r1.add(new InteractVoteThemeBinder.a(r16.getVoteType(), r16.getVoteDes(), false, this));
    L17:
        ArrayList<InteractVoteThemeBinder.a> r17 = this.h;
        if (r17 == null) goto L24;
        MultiTypeAdapter r18 = this.j;
        if (r18 == null) goto L22;
        r18.a = r17;
    L22:
        if (r18 == null) goto L24;
        r18.notifyDataSetChanged();
    L24:
        ((TextView) S90(2131390381)).setOnClickListener(new h(this));
        ((FrameLayout) S90(2131376031)).setOnClickListener(new i(this));
        HashMap r19 = new HashMap();
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L27;
        String r110 = "2";
    L36:
        r19.put("anchor_connect_status", r110);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L39;
        String r111 = "pk_participate";
    L40:
        r19.put("source", r111);
        int r112 = UserListInviteType.a;
        LinkCrossRoomDataHolder r113 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r113 == null) goto L43;
        int r114 = r113.f();
    L44:
        r19.put("invitee_list", UserListInviteType.a(r114, null));
        n r115 = new n();
        Map<String, String> r3 = r115.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r19, "map");
        r3.putAll(r19);
        m r20 = new m();
        LinkCrossRoomDataHolder.a r4 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r20);
        r20.b(LogCommon.ROOM);
        List<Object> r5 = r115.b;
        ArrayList r6 = (ArrayList) r5;
        r6.addAll(r20.a);
        cy0.e.a.getClass();
        j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r23);
        ((mz0.i) ((f80.a) r23)).w3("livesdk_vote_theme_setting_panel_show", r115.a, r115.b);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r24 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r24 == null) goto L58;
        LiveData<PkBaseStateMachine.c> r25 = r24.getPkBaseState();
        if (r25 == null) goto L59;
        r25.observeForever(this.k);
        return;
    L59:
        return;
    L58:
        return;
    L43:
        r114 = 0;
        goto L44
    L39:
        r111 = "link_participate";
        goto L40
    L27:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r116 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r116 == null) goto L35;
        i11.b r117 = r116.getLinkUserCenter();
        if (r117 == null) goto L35;
        List<p> r118 = r117.getOnlineUserList();
        if (r118 == null) goto L35;
        r110 = String.valueOf(r118.size());
        if (r110 != null) goto L36;
    L35:
        r110 = "";
        goto L36
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565560, r3, false);
    }
}
