package com.obric.assistant.interaction.api.window.animation;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimator;", "", "start", "", "onEnd", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", WindowEvent.WindowOpenPerfResult.CANCEL, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWindowAnimator {
    void cancel();

    void start(Function1<? super Boolean, Unit> r1);
}
