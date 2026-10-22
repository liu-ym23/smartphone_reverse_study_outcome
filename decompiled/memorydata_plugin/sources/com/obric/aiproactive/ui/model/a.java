package com.obric.aiproactive.ui.model;

import com.obric.aiproactive.api.AiProactiveCardStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/ui/model/AiProactiveActionCommandWriter;", "", "markCurrentActionExecuted", "", "recommendationId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markActionExecuted", "actionIndex", "", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "(JILcom/obric/aiproactive/api/AiProactiveCardStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {
    Object a(long r1, int r3, AiProactiveCardStatus r4, Continuation<? super Unit> r5);

    Object a(long r1, Continuation<? super Unit> r3);
}
