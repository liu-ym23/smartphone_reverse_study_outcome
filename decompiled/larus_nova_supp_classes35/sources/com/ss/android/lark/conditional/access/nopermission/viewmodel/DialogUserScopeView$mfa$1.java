package com.ss.android.lark.conditional.access.nopermission.viewmodel;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.viewmodel.DialogUserScopeView", f = "DialogUserScopeView.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {67, 85}, m = "mfa", n = {"context", "scope", "customParams", "mfaParams", "successToastResId", "mfaParams", "token", "successToastResId"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "I$0"})
public final class DialogUserScopeView$mfa$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DialogUserScopeView this$0;

    public DialogUserScopeView$mfa$1(DialogUserScopeView r1, Continuation<? super DialogUserScopeView$mfa$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.b(null, null, null, null, 0, this);
    }
}
