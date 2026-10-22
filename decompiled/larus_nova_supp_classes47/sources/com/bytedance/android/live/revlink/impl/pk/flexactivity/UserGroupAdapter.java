package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.link.model.x9;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/UserGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/UserGroupAdapter$UserViewHolder;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "UserViewHolder", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UserGroupAdapter extends RecyclerView.Adapter<UserViewHolder> {
    public final LayoutInflater a;
    public final Context b;
    public List<? extends x9> c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/UserGroupAdapter$UserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class UserViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final VHeadView c;
        public final TextView d;

        public UserViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131392049);
            this.b = (TextView) r2.findViewById(2131392018);
            this.c = r2.findViewById(2131374267);
            this.d = (TextView) r2.findViewById(2131384199);
        }
    }

    public final int getItemCount() {
        List<? extends x9> r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final Context getContext() {
        return this.b;
    }

    public UserGroupAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        this.c = null;
        this.a = LayoutInflater.from(r2);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        UserViewHolder r7 = (UserViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        List<? extends x9> r0 = this.c;
        if (r0 == null) goto L32;
        x9 r8 = (x9) ListProtector.get(r0, r6);
        if (r8 == null) goto L33;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "registeredUser");
        TextView r1 = r7.a;
        IBattleUserInfo r2 = r8.getUser();
        List r3 = null;
        if (r2 == null) goto L11;
        k0 r4 = r2.getUserInfo();
        if (r4 == null) goto L11;
        String r9 = r4.getNickName();
    L12:
        r1.setText(r9);
        VHeadView r10 = r7.c;
        IBattleUserInfo r12 = r8.getUser();
        if (r12 == null) goto L17;
        k0 r13 = r12.getUserInfo();
        if (r13 == null) goto L17;
        k r14 = r13.getAvatarThumb();
    L18:
        a1.v(r10, r14, 2131250965);
        UtilityKotlinExtentionsKt.t(r7.d);
        IBattleUserInfo r15 = r8.getUser();
        if (r15 == null) goto L30;
        List r16 = r15.getTagList();
        if (r16 == null) goto L30;
        if (r16.size() <= 0) goto L25;
        boolean r17 = true;
    L26:
        if (r17 == false) goto L28;
        r3 = r16;
    L28:
        if (r3 == null) goto L30;
        r7.d.setText(((IBattleRivalTag) ListProtector.get(r3, 0)).getContent());
        UtilityKotlinExtentionsKt.w(r7.d);
        goto L30
    L25:
        r17 = false;
    L30:
        r7.b.setText(r8.getDesc());
        return;
    L17:
        r14 = null;
    L11:
        r9 = null;
        goto L12
    L33:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        return new UserViewHolder(this.a.inflate(2131566384, r3, false));
    }
}
