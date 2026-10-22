package com.ss.android.lark.compose.groupinfo;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.GroupInfoViewModel", f = "GroupInfoViewModel.kt", i = {0, 2}, l = {77, 95, 101}, m = "updateGroupInfo-IoAF18A", n = {"chatName", "avatarKey"}, s = {"L$0", "L$0"})
public final class GroupInfoViewModel$updateGroupInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GroupInfoViewModel this$0;

    public GroupInfoViewModel$updateGroupInfo$1(GroupInfoViewModel r1, Continuation<? super GroupInfoViewModel$updateGroupInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r3 = GroupInfoViewModel.m927access$updateGroupInfoIoAF18A(this.this$0, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
