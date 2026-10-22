package com.larus.bmhome.chat.list.cell.generate_image;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.holder.image.a1;
import com.larus.bmhome.chat.view.share.ConversationShareMessageListAdapter;
import com.larus.im.bean.bot.BotModel;
import lf8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class GenerateImageScrollCell$a implements a1.b {
    public final /* synthetic */ GenerateImageScrollCell a;

    @Override // com.larus.bmhome.chat.layout.holder.image.a1.b
    public final BotModel a() {
        GenerateImageScrollCell r0 = this.a;
        int r1 = GenerateImageScrollCell.C;
        y r2 = r0.s();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.j0();
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.a1.b
    public final s b() {
        return new s(this.a);
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.a1.b
    public final ConversationShareMessageListAdapter c() {
        RecyclerView r0 = ((BaseMessageListCell) this.a).b;
        if (r0 == null) goto L5;
        RecyclerView.Adapter r1 = r0.getAdapter();
    L7:
        if ((r1 instanceof ConversationShareMessageListAdapter) == true) goto L9;
        return null;
    L9:
        return (ConversationShareMessageListAdapter) r1;
    L5:
        r1 = null;
        goto L7
    }

    public final q0 d() {
        return a.b(this.a);
    }

    public GenerateImageScrollCell$a(GenerateImageScrollCell r1) {
        this.a = r1;
    }
}
