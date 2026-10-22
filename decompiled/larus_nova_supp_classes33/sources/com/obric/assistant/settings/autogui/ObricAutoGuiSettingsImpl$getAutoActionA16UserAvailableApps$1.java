package com.obric.assistant.settings.autogui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {842}, m = "getAutoActionA16UserAvailableApps", n = {}, s = {})
public final class ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1(ObricAutoGuiSettingsImpl r1, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
