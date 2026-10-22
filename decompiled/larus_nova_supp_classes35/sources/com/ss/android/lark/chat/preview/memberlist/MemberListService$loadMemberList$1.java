package com.ss.android.lark.chat.preview.memberlist;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.memberlist.MemberListService", f = "MemberListService.kt", i = {}, l = {24}, m = "loadMemberList", n = {}, s = {})
public final class MemberListService$loadMemberList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemberListService this$0;

    public MemberListService$loadMemberList$1(MemberListService r1, Continuation<? super MemberListService$loadMemberList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.a(null, null, null, this);
    }
}
