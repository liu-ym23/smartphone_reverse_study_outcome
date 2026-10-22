package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.platform.model.SlashMentionConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy", f = "CreationMessageStrategy.kt", i = {0, 0, 0, 0, 0, 0}, l = {531}, m = "sendLocalSingleAttachment", n = {"config", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "localPath", "cvsId", "extra", "imagePreviewUrl"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class CreationMessageStrategy$sendLocalSingleAttachment$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationMessageStrategy this$0;

    public CreationMessageStrategy$sendLocalSingleAttachment$1(CreationMessageStrategy r1, Continuation<? super CreationMessageStrategy$sendLocalSingleAttachment$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreationMessageStrategy r3 = this.this$0;
        int r0 = CreationMessageStrategy.e;
        return r3.z(null, null, this);
    }
}
