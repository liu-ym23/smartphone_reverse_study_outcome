package com.obric.assistant.settings.autogui;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl", f = "ObricAutoGuiSettingsImpl.kt", i = {0}, l = {498}, m = "fetchCloudAppPolicy", n = {"accountScope"}, s = {"L$0"})
public final class ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1(ObricAutoGuiSettingsImpl r1, Continuation<? super ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ObricAutoGuiSettingsImpl r3 = this.this$0;
        Set r0 = ObricAutoGuiSettingsImpl.i;
        return r3.o(null, this);
    }
}
