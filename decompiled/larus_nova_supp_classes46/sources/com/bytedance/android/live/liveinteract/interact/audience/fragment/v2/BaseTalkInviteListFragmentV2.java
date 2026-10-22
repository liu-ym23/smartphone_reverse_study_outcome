package com.bytedance.android.live.liveinteract.interact.audience.fragment.v2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.list.FriendsInviteItemBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/v2/BaseTalkInviteListFragmentV2;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/BaseTalkInviteListContract$View;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseTalkInviteListFragmentV2 extends BaseTalkInviteListContract$View {
    public static final /* synthetic */ int s = 0;
    public RecyclerView g;
    public MultiTypeAdapter h;
    public TextView i;
    public LinearLayout j;
    public TextView k;
    public final IRoom l;
    public boolean m;
    public final boolean n;
    public boolean o;
    public final List<ILinkPlayerInfoBridge> p;
    public h q;
    public final Function1<String, Boolean> r;

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 100.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    public abstract com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> da0();

    public BaseTalkInviteListFragmentV2() {
        this.l = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        this.n = jc1.k.n(IMiddlewareUserService.class).user().c();
        this.o = true;
        this.p = new ArrayList();
        jc1.k.n(IMiddlewareUserService.class).user().n();
        this.r = new BaseTalkInviteListFragmentV2$userListFilterAction$1(this);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View
    public final void aa0(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        MultiTypeAdapter r3 = this.h;
        if (r3 == null) goto L5;
        List r4 = r3.a;
    L6:
        List r5 = r4;
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L18;
        h r7 = this.q;
        if (r7 == null) goto L19;
        r7.Wo();
        return;
    L19:
        return;
    L18:
        return;
    L9:
        if (r5.isEmpty() == true) goto L12;
        r6 = false;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View
    public final void ca0(a1 r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (getView() != null) goto L5;
        return;
    L5:
        List<ILinkPlayerInfoBridge> r5 = r4.getPlayerInfo();
        if (r5 != null) goto L8;
        r5 = CollectionsKt.emptyList();
    L8:
        MultiTypeAdapter r0 = this.h;
        if (r0 == null) goto L11;
        List r1 = r0.a;
    L12:
        List r2 = r1;
        boolean r3 = true;
        if (r2 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == false) goto L23;
        h r7 = this.q;
        if (r7 == null) goto L23;
        r7.zs();
    L23:
        List<ILinkPlayerInfoBridge> r8 = r5;
        if (r8 == null) goto L30;
        if (r8.isEmpty() == true) goto L30;
        r3 = false;
    L30:
        if (r3 == false) goto L40;
        LinearLayout r9 = this.j;
        if (r9 == null) goto L34;
        r9.setVisibility(0);
    L34:
        RecyclerView r10 = this.g;
        if (r10 == null) goto L37;
        r10.setVisibility(8);
    L37:
        TextView r11 = this.k;
        if (r11 == null) goto L50;
        r11.setText(s1.B(2131918065));
        return;
    L50:
        return;
    L40:
        LinearLayout r12 = this.j;
        if (r12 == null) goto L43;
        r12.setVisibility(8);
    L43:
        RecyclerView r13 = this.g;
        if (r13 == null) goto L46;
        r13.setVisibility(0);
    L46:
        ((ArrayList) this.p).clear();
        ((ArrayList) this.p).addAll(r8);
        MultiTypeAdapter r14 = this.h;
        if (r14 == null) goto L52;
        r14.notifyDataSetChanged();
        return;
    L52:
        return;
    L15:
        if (r2.isEmpty() == true) goto L18;
        r6 = false;
        goto L19
    L11:
        r1 = null;
        goto L12
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        IRoom r3 = this.l;
        if (r3 == null) goto L5;
        String r4 = r3.getOwnerUserIdString();
    L6:
        this.m = Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().n());
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View
    public final void ba0(IBaseUser r9, List<? extends e1> r10) {
        Intrinsics.checkNotNullParameter(r9, "user");
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        IRoom r2 = this.l;
        if (r2 != null) goto L8;
        return;
    L8:
        r1.element = r2;
        boolean r3 = tb1.d.a;
        List<? extends e1> r4 = r10;
        int r5 = 0;
        if (r4 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L22;
        final boolean r7 = ((e1) ListProtector.get(r10, 0)).getNeedPush();
        final String r11 = ((e1) ListProtector.get(r10, 0)).getAction();
        if (r11 != null) goto L19;
        r11 = "";
    L19:
        IMiddlewareHostSocial r8 = jc1.k.f(IMiddlewareHostSocial.class);
        if (r8 == null) goto L22;
        r8.inviteFriendByIM(r0, r9, new BaseTalkInviteListFragmentV2$onInviteFriendSuccess$1(this, r1, r7, r11));
    L22:
        Iterator<T> r12 = this.p.iterator();
        int r13 = -1;
        ILinkPlayerInfoBridge r14 = null;
    L24:
        if (r12.hasNext() == false) goto L36;
        Object r15 = r12.next();
        int r16 = r5 + 1;
        if (r5 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        ILinkPlayerInfoBridge r17 = (ILinkPlayerInfoBridge) r15;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L31;
        String r19 = r18.getIdString();
    L33:
        if (Intrinsics.areEqual(r19, r9.getIdString()) == false) goto L35;
        r13 = r5;
        r14 = r17;
    L35:
        r5 = r16;
        goto L24
    L31:
        r19 = null;
        goto L33
    L36:
        if (r14 != null) goto L38;
        return;
    L38:
        r14.setLastInvitedTimeMillis(p6.b());
        MultiTypeAdapter r20 = this.h;
        if (r20 == null) goto L45;
        r20.notifyItemChanged(r13);
        return;
    L45:
        return;
    L11:
        if (r4.isEmpty() == true) goto L14;
        r6 = false;
        goto L15
    }

    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        this.g = r4.findViewById(2131375614);
        this.j = (LinearLayout) r4.findViewById(2131375601);
        this.k = (TextView) r4.findViewById(2131375602);
        this.i = (TextView) r4.findViewById(2131375611);
        this.h = new MultiTypeAdapter();
        RecyclerView r6 = this.g;
        if (r6 == null) goto L5;
        r6.setLayoutManager(new LinearLayoutManager(r6.getContext()));
        r6.setAdapter(this.h);
    L5:
        MultiTypeAdapter r7 = this.h;
        if (r7 == null) goto L9;
        r7.A2(this.p);
        r7.z2(ILinkPlayerInfoBridge.class, new FriendsInviteItemBinder(this.o, new BaseTalkInviteListFragmentV2$onViewCreated$$inlined$apply$lambda$1(this)));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565514, r3, false);
    }
}
