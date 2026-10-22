package com.bytedance.android.live.liveinteract.chatroom.chatroom.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.linkpanel.list.FriendsItemBinderHorizontal;
import com.bytedance.android.live.liveinteract.linkpanel.list.InviteMoreFriendItemBinder;
import com.bytedance.android.live.liveinteract.linkpanel.list.f;
import com.bytedance.android.live.liveinteract.linkpanel.list.l;
import com.bytedance.android.live.liveinteract.linkpanel.util.m;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.multilink.base.view.HorizontalRecyclerView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.facebook.drawee.backends.pipeline.Fresco;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class FriendsInviteListBinder extends me.drakeet.multitype.b<e, ViewHolder> {
    public final MultiTypeAdapter b;
    public boolean c;
    public final boolean d;
    public final IRoom e;
    public final boolean f;
    public final boolean g;
    public final Function1<ILinkPlayerInfoBridge, Unit> h;
    public final Function0<Unit> i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/list/FriendsInviteListBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final HorizontalRecyclerView a;
        public final ViewGroup b;
        public final HSImageView c;

        public ViewHolder(View r6) {
            Intrinsics.checkNotNullParameter(r6, "itemView");
            super(r6);
            this.a = r6.findViewById(2131384732);
            this.b = (ViewGroup) r6.findViewById(2131362402);
            HSImageView r7 = r6.findViewById(2131362401);
            if (r7 == null) goto L5;
            r7.setController(Fresco.newDraweeControllerBuilder().setUri((String) d.b.getValue(null, d.a[0])).setAutoPlayAnimations(true).build());
            Unit r0 = Unit.INSTANCE;
        L6:
            this.c = r7;
            return;
        L5:
            r7 = null;
            goto L6
        }
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        ViewHolder r10 = (ViewHolder) r8;
        e r11 = (e) r9;
        Intrinsics.checkNotNullParameter(r10, "viewHolder");
        Intrinsics.checkNotNullParameter(r11, "data");
        this.b.a = r11.a;
        boolean r12 = !r11.b.isEmpty();
        ViewGroup r1 = r10.b;
        if (r1 == null) goto L8;
        if (r12 == false) goto L6;
        int r3 = 0;
    L7:
        r1.setVisibility(r3);
        goto L8
    L6:
        r3 = 8;
    L8:
        ViewGroup r2 = r10.b;
        if (r2 == null) goto L11;
        r2.setOnClickListener(new c(r10));
    L11:
        if (r12 == false) goto L15;
        HSImageView r13 = r10.c;
        if (r13 == null) goto L15;
        r13.setController(Fresco.newDraweeControllerBuilder().setUri((String) d.b.getValue(null, d.a[0])).setAutoPlayAnimations(true).build());
    L15:
        if (r12 == true) goto L17;
        return;
    L17:
        if (this.c == true) goto L21;
        m.i(this.d, "", true, true, false, "AI_guest");
        this.c = true;
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        final ViewHolder r0 = new ViewHolder(r4.inflate(2131566336, r5, false));
        HorizontalRecyclerView r6 = r0.a;
        if (r6 == null) goto L5;
        r6.setLayoutManager(new LinearLayoutManager(r6.getContext(), 0, false));
        r6.setAdapter(this.b);
        r6.addOnChildAttachStateChangeListener(new FriendsInviteListBinder$onCreateViewHolder$$inlined$apply$lambda$1(this, r0));
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendsInviteListBinder(boolean r2, IRoom r3, boolean r4, boolean r5, Function1<? super ILinkPlayerInfoBridge, Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "onInvite");
        Intrinsics.checkNotNullParameter(r7, "showIMInvitePage");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        MultiTypeAdapter r8 = new MultiTypeAdapter();
        this.b = r8;
        r8.z2(l.class, new InviteMoreFriendItemBinder(new AnonymousClass1(this)));
        r8.z2(f.class, new FriendsItemBinderHorizontal(r2, r6));
    }
}
