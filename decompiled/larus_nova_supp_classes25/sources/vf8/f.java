package vf8;

import android.view.View;
import com.larus.bmhome.chat.api.b0$a;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.list.cell.loading.LoadingCell;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements View.OnClickListener {
    public final /* synthetic */ LoadingCell a;
    public final /* synthetic */ Message b;

    public /* synthetic */ f(LoadingCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        LoadingCell r11 = this.a;
        Message r0 = this.b;
        int r1 = LoadingCell.l;
        q0 r2 = lf8.a.b(r11);
        if (r2 == null) goto L7;
        ChatMessageList r3 = r2.B7();
        if (r3 == null) goto L7;
        b0$a.a(r3, false, 0, null, null, 0, 30);
    L7:
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.e.J(r0, (ChatPageContext) lf8.a.c(r11, ChatPageContext.class));
    }
}
