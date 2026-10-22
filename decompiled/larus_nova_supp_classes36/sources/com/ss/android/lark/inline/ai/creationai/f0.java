package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.inline.ai.api.creationai.CreationAIPanel;
import com.ss.android.lark.inline.ai.api.creationai.FeedbackJSParams;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface f0 {
    void b(SubPanelInfo r1);

    void c(FeedbackJSParams r1);

    void d(SubPanelInfo r1);

    void destroy();

    void e();

    void f(Object r1);

    void g();

    void h(CreationAIPanel r1);

    void hide();

    StateFlowImpl isShowing();

    void onActivityResult();

    boolean onBackPressed();
}
