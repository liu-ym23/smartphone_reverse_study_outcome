package com.ss.android.lark.contact.base.contact_focus;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.base.contact_focus.SpecialFocusModel", f = "SpecialFocusModel.kt", i = {0, 0, 0, 0, 0}, l = {66}, m = "loadPrivateDescriptionsInBatches", n = {"onBatchLoaded", "service", "batchIds", "index$iv", "index"}, s = {"L$0", "L$1", "L$3", "I$0", "I$1"})
final class SpecialFocusModel$loadPrivateDescriptionsInBatches$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public SpecialFocusModel$loadPrivateDescriptionsInBatches$1(a r1, Continuation<? super SpecialFocusModel$loadPrivateDescriptionsInBatches$1> r2) {
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        throw null;
    }
}
