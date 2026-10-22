package com.bytedance.android.live.revlink.impl.pk.vote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.ui.j;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class InteractVoteThemeBinder extends me.drakeet.multitype.b<a, InteractVoteThemeHolder> {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteThemeBinder$InteractVoteThemeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class InteractVoteThemeHolder extends RecyclerView.ViewHolder implements j {
        public long a;
        public String b;

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
        public final String G() {
            return String.valueOf(this.a);
        }

        public InteractVoteThemeHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.b = "";
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
        public final void N(String r4) {
            Intrinsics.checkNotNullParameter(r4, "panelType");
            HashMap r5 = new HashMap();
            if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L5;
            String r0 = "2";
        L14:
            r5.put("anchor_connect_status", r0);
            if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L17;
            String r1 = "pk_participate";
        L18:
            r5.put("source", r1);
            r5.put(FileUtils.PICTURE_THEME, this.b);
            int r2 = UserListInviteType.a;
            LinkCrossRoomDataHolder r3 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r3 == null) goto L21;
            int r6 = r3.f();
        L22:
            r5.put("invitee_list", UserListInviteType.a(r6, null));
            n r7 = new n();
            Map<String, String> r8 = r7.a;
            Intrinsics.checkNotNullParameter(r8, "map");
            Intrinsics.checkNotNullParameter(r5, "map");
            r8.putAll(r5);
            m r9 = new m();
            LinkCrossRoomDataHolder.a r10 = LinkCrossRoomDataHolder.c;
            com.bytedance.android.live.revlink.impl.a.b(r9);
            r9.b(LogCommon.ROOM);
            List<Object> r12 = r7.b;
            ArrayList r13 = (ArrayList) r12;
            r13.addAll(r9.a);
            cy0.e.a.getClass();
            cy0.j r14 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r15);
            ((mz0.i) ((f80.a) r15)).w3("livesdk_vote_theme_show", r7.a, r7.b);
            return;
        L21:
            r6 = 0;
            goto L22
        L17:
            r1 = "link_participate";
            goto L18
        L5:
            com.bytedance.android.live.revlink.impl.multianchor.service.d r16 = com.bytedance.android.live.revlink.impl.global.b.z();
            if (r16 == null) goto L13;
            i11.b r17 = r16.getLinkUserCenter();
            if (r17 == null) goto L13;
            List<p> r18 = r17.getOnlineUserList();
            if (r18 == null) goto L13;
            r0 = String.valueOf(r18.size());
            if (r0 != null) goto L14;
        L13:
            r0 = "";
            goto L14
        }
    }

    public static final class a {
        public final long a;
        public final String b;
        public boolean c;
        public final b d;

        public a() {
            this(0, null, false, null);
        }

        public a(long r1, String r3, boolean r4, b r5) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public interface b {
        void s80(InteractVoteStartDialog.b r1);
    }

    public InteractVoteThemeBinder() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        InteractVoteThemeHolder r6 = (InteractVoteThemeHolder) r4;
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        r6.a = r7.a;
        String r0 = r7.b;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r6.b = r0;
        TextView r2 = (TextView) ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131391578);
        String r3 = r7.b;
        if (r3 == null) goto L8;
        r1 = r3;
    L8:
        r2.setText(r1);
        ImageView r8 = (ImageView) ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131376591);
        if (r7.c == false) goto L11;
        int r9 = 0;
    L12:
        r8.setVisibility(r9);
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new g(r7));
        return;
    L11:
        r9 = 8;
        goto L12
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new InteractVoteThemeHolder(r4.inflate(2131566295, r5, false));
    }
}
