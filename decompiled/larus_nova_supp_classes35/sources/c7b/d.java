package c7b;

import android.view.View;
import com.ss.android.lark.chatbase.view.post.PostChatView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnLongClickListener {
    public final /* synthetic */ PostChatView a;

    public d(PostChatView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        View.OnLongClickListener r0 = this.a.j;
        if (r0 == null) goto L7;
        r0.onLongClick(r2);
        return true;
    L7:
        return true;
    }
}
