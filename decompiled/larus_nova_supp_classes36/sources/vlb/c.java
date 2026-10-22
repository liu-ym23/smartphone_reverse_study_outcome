package vlb;

import android.content.Intent;
import com.ss.android.lark.inline.ai.api.creationai.CreationAIPanel;
import com.ss.android.lark.inline.ai.api.creationai.FeedbackJSParams;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface c {
    void a();

    void b(SubPanelInfo r1);

    void c(FeedbackJSParams r1);

    void d(SubPanelInfo r1);

    void destroy();

    void e();

    void f(Object r1);

    void g();

    void h(CreationAIPanel r1);

    i1<Boolean> isShowing();

    void onActivityResult(int r1, int r2, Intent r3);

    boolean onBackPressed();
}
