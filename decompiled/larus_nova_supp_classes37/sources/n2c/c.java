package n2c;

import android.os.Bundle;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.reaction.widget.detailwindow.pager.ReactionListFragment;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements a {
    public List<ReactionDetailViewModel> a;
    public final String b;
    public final boolean c;

    public final List<o2c.a> a() {
        ArrayList r0 = new ArrayList();
        Iterator<ReactionDetailViewModel> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ReactionDetailViewModel r2 = r1.next();
        String r3 = r2.getReactionKey();
        boolean r4 = this.c;
        int r5 = ReactionListFragment.n;
        r0.add(new o2c.a(ReactionListFragment.S90(r2, r4, UIHelper.dp2px(56.0f)), r3, r2.getTotalCount()));
        goto L4
    L6:
        return r0;
    }

    public c(Bundle r2) {
        if (r2 == null) goto L6;
        this.a = (List) r2.getSerializable("reaction_info_list");
        this.b = r2.getString("reaction_opened_type");
        this.c = r2.getBoolean("key_need_loading");
        return;
    }
}
