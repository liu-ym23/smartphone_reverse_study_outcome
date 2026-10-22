package com.ss.android.lark.inline.ai.ui;

import android.content.Intent;
import com.ss.android.lark.inline.ai.api.ui.InlineAIPanel;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b {
    void b(List<PromptGroup> r1, String r2, boolean r3, Function0<Unit> r4);

    void c();

    void d(InlineAIPanel r1);

    void destroy();

    void hide();

    StateFlowImpl isShowing();

    void onActivityResult(int r1, int r2, Intent r3);

    boolean onBackPressed();
}
