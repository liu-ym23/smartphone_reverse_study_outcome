package com.ss.android.lark.compose.groupinfo;

import com.lark.kmp.pb.basic.v1.AvatarMeta;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.im.v1.UpdateChatRequest;
import com.lark.kmp.pb.im.v1.UpdateChatResponse;
import com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$;
import com.lark.kmp.rustclient.api.model.i;
import com.lark.kmp.rustclient.api.model.k;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupInfoRepository {
    public final com.lark.kmp.rustclient.api.d a;

    public GroupInfoRepository(com.lark.kmp.rustclient.api.d r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    public final Object a(String r13, String r14, Continuation<? super Result<UpdateChatResponse>> r15) {
        if ((r15 instanceof GroupInfoRepository$updateAvatar$1) == false) goto L7;
        GroupInfoRepository$updateAvatar$1 r0 = (GroupInfoRepository$updateAvatar$1) r15;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L21
    L19:
        Object r17 = Result.constructor-impl((UpdateChatResponse) ((k) r16).b);     // Catch: Throwable -> L21
    L23:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L26;
        int r19 = c.a;
        c.a("GroupInfoRepository updateAvatar failed: " + r18.getMessage());
    L26:
        return r17;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        AvatarMeta.a r110 = new AvatarMeta.a();
        AvatarMeta.Type r4 = AvatarMeta.Type.UPLOAD;
        Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
        r110.d = r4;
        AvatarMeta r5 = new AvatarMeta(r110, r110.c(), null);
        UpdateChatRequest.a r7 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r13, "chat_id");
        r7.d = r13;
        r7.s = r14;
        r7.y = r5;
        com.lark.kmp.rustclient.api.model.c r111 = new com.lark.kmp.rustclient.api.model.c(r7, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L21
        RustOutputKt$errorAsException$.inlined.map.1 r113 = i.a(this.a.b(r111).a());     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r16 = kotlinx.coroutines.flow.e.s(r113, r0);     // Catch: Throwable -> L21
        if (r16 != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new GroupInfoRepository$updateAvatar$1(this, r15);
        goto L8
    }

    public final Object b(String r11, String r12, Continuation<? super Result<UpdateChatResponse>> r13) {
        if ((r13 instanceof GroupInfoRepository$updateName$1) == false) goto L7;
        GroupInfoRepository$updateName$1 r0 = (GroupInfoRepository$updateName$1) r13;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L21
    L19:
        Object r15 = Result.constructor-impl((UpdateChatResponse) ((k) r14).b);     // Catch: Throwable -> L21
    L23:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L26;
        int r17 = c.a;
        c.a("GroupInfoRepository updateName failed: " + r16.getMessage());
    L26:
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        UpdateChatRequest.a r5 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chat_id");
        r5.d = r11;
        r5.e = r12;
        com.lark.kmp.rustclient.api.model.c r18 = new com.lark.kmp.rustclient.api.model.c(r5, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L21
        RustOutputKt$errorAsException$.inlined.map.1 r110 = i.a(this.a.b(r18).a());     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r14 = kotlinx.coroutines.flow.e.s(r110, r0);     // Catch: Throwable -> L21
        if (r14 != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new GroupInfoRepository$updateName$1(this, r13);
        goto L8
    }
}
