package erb;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.mention.base.MentionUtils;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtSelectableViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ com.ss.android.lark.mention.base.impl.atselector.bean.a a;
    public final /* synthetic */ AtSelectableViewHolder b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = MentionUtils.a;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r6 = this.a;
        if (r6.g != Chatter.ChatterType.BOT) goto L5;
        boolean r0 = true;
    L6:
        String r7 = r6.a;
        Context r1 = this.b.profileInfoCard.getContext();
        Intrinsics.checkNotNullParameter(r7, "id");
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r0 == false) goto L9;
        arb.a.b.Y(r1, r7);
        return;
    L9:
        com.ss.android.lark.profile.utils.a.a(r1, r7, 2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public g(com.ss.android.lark.mention.base.impl.atselector.bean.a r1, AtSelectableViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }
}
