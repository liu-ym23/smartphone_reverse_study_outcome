package sf8;

import android.view.View;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.list.cell.deepsearch.DeepSearchCell;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements View.OnClickListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ DeepSearchCell b;

    public /* synthetic */ e(i r1, DeepSearchCell r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        i r5 = this.a;
        DeepSearchCell r0 = this.b;
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.e.J(r5.a, (ChatPageContext) lf8.a.c(r0, ChatPageContext.class));
    }
}
