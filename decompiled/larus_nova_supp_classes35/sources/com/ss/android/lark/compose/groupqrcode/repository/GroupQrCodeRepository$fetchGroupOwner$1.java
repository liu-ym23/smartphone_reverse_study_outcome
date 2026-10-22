package com.ss.android.lark.compose.groupqrcode.repository;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.repository.GroupQrCodeRepository", f = "GroupQrCodeRepository.kt", i = {0}, l = {MediaContent.COMPRESS_PROGRESS_PROPORTION}, m = "fetchGroupOwner-gIAlu-s", n = {"ownerId"}, s = {"L$0"})
public final class GroupQrCodeRepository$fetchGroupOwner$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GroupQrCodeRepository this$0;

    public GroupQrCodeRepository$fetchGroupOwner$1(GroupQrCodeRepository r1, Continuation<? super GroupQrCodeRepository$fetchGroupOwner$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r3 = this.this$0.a(null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
