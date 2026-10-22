package com.bytedance.ai.applet.permission;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletSettingHelper", f = "AppletSettingHelper.kt", i = {0}, l = {43}, m = "getSetting", n = {"session"}, s = {"L$0"})
public final class AppletSettingHelper$getSetting$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletSettingHelper this$0;

    public AppletSettingHelper$getSetting$1(AppletSettingHelper r1, Continuation<? super AppletSettingHelper$getSetting$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
