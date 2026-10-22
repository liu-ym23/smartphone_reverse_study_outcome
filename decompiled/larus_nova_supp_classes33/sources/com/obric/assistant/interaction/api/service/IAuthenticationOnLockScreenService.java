package com.obric.assistant.interaction.api.service;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "", "start", "", WindowEvent.Params.REASON, "", "timeout", "Lkotlin/Function0;", "stop", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAuthenticationOnLockScreenService {
    void start(String r1, Function0<Unit> r2);

    void stop(String r1);
}
