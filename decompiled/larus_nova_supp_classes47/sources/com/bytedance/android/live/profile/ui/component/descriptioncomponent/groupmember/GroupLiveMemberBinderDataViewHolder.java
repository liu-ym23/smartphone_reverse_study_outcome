package com.bytedance.android.live.profile.ui.component.descriptioncomponent.groupmember;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qt0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/groupmember/GroupLiveMemberBinderDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupLiveMemberBinderDataViewHolder extends RecyclerView.ViewHolder {
    public qt0.a a;
    public final RoundCornerImageView b;
    public final TextView c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GroupLiveMemberBinderDataViewHolder a;

        public a(GroupLiveMemberBinderDataViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            qt0.a r4 = this.a.a;
            b r0 = null;
            if (r4 == null) goto L5;
            String r1 = r4.a;
        L6:
            if (r4 == null) goto L8;
            r0 = r4.e;
        L8:
            if (r1 == null) goto L12;
            if (r0 == null) goto L13;
            r0.a(r1);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public GroupLiveMemberBinderDataViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        r2.setOnClickListener(new a(this));
        this.b = r2.findViewById(2131379844);
        this.c = (TextView) r2.findViewById(2131379848);
    }
}
