package com.ss.android.lark.inline.ai;

import com.larksuite.arch.jack.JackViewModel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.logic.f;
import kotlin.Metadata;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/inline/ai/AbsInlineAIViewModel;", "Lcom/larksuite/arch/jack/JackViewModel;", "Lcom/ss/android/lark/inline/ai/logic/InlineAIState;", "<init>", "()V", "getCancelFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class AbsInlineAIViewModel extends JackViewModel<f> {
    public static final a Companion = null;
    public static final String ENABLE_SMOOTH_PRINT = "ccm.mobile.inline_ai_smooth_print_enable";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public abstract d1<Boolean> getCancelFlow();

    public AbsInlineAIViewModel() {
    }
}
