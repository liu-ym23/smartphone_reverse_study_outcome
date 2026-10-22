package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.platform.model.SlashMentionConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy", f = "CreationMessageStrategy.kt", i = {0, 0, 0, 0, 0, 0}, l = {603, 606}, m = "handleLocalSingleAttachmentPrepared", n = {"config", "cvsId", "localPath", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "imageMsg", "textMsg"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class CreationMessageStrategy$handleLocalSingleAttachmentPrepared$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationMessageStrategy this$0;

    public CreationMessageStrategy$handleLocalSingleAttachmentPrepared$1(CreationMessageStrategy r1, Continuation<? super CreationMessageStrategy$handleLocalSingleAttachmentPrepared$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return CreationMessageStrategy.a(this.this$0, null, null, null, null, null, this);
    }
}
