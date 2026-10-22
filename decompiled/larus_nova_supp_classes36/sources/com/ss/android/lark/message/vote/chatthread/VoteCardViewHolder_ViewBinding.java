package com.ss.android.lark.message.vote.chatthread;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class VoteCardViewHolder_ViewBinding implements Unbinder {
    public VoteCardViewHolder a;

    public final void unbind() {
        VoteCardViewHolder r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mTitleLayout = null;
        r0.mTitleTv = null;
        r0.mSelectTypeTv = null;
        r0.mOptionsRv = null;
        r0.mNumberOfParticipantsTv = null;
        r0.mActualParticipantNumberTv = null;
        r0.mActionBtn = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public VoteCardViewHolder_ViewBinding(VoteCardViewHolder r4, View r5) {
        this.a = r4;
        r4.mTitleLayout = Utils.findRequiredView(r5, 2131388881, "field 'mTitleLayout'");
        r4.mTitleTv = (TextView) Utils.findRequiredViewAsType(r5, 2131388920, "field 'mTitleTv'", TextView.class);
        r4.mSelectTypeTv = (TextView) Utils.findRequiredViewAsType(r5, 2131385821, "field 'mSelectTypeTv'", TextView.class);
        r4.mOptionsRv = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131381608, "field 'mOptionsRv'", RecyclerView.class);
        r4.mNumberOfParticipantsTv = (TextView) Utils.findRequiredViewAsType(r5, 2131381101, "field 'mNumberOfParticipantsTv'", TextView.class);
        r4.mActualParticipantNumberTv = (TextView) Utils.findRequiredViewAsType(r5, 2131362196, "field 'mActualParticipantNumberTv'", TextView.class);
        r4.mActionBtn = (TextView) Utils.findRequiredViewAsType(r5, 2131362061, "field 'mActionBtn'", TextView.class);
    }
}
