package com.ss.android.lark.compose.groupqrcode.repository;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.repository.GroupQrCodeRepository", f = "GroupQrCodeRepository.kt", i = {}, l = {41}, m = "fetchQRCodeToken-BWLJW6A", n = {}, s = {})
public final class GroupQrCodeRepository$fetchQRCodeToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GroupQrCodeRepository this$0;

    public GroupQrCodeRepository$fetchQRCodeToken$1(GroupQrCodeRepository r1, Continuation<? super GroupQrCodeRepository$fetchQRCodeToken$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r4 = this.this$0.b(null, 0, false, this);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Result.box-impl(r4);
    }
}
