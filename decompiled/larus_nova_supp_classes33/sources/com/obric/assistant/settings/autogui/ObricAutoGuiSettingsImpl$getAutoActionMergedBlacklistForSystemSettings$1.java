package com.obric.assistant.settings.autogui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl", f = "ObricAutoGuiSettingsImpl.kt", i = {0, 0}, l = {746}, m = "getAutoActionMergedBlacklistForSystemSettings", n = {"accountScope", "appScopeConfig"}, s = {"L$0", "L$1"})
public final class ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$1(ObricAutoGuiSettingsImpl r1, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
