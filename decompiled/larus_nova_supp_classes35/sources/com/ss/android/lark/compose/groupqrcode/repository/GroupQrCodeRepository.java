package com.ss.android.lark.compose.groupqrcode.repository;

import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.contact.v1.MGetChattersRequest;
import com.lark.kmp.pb.contact.v1.MGetChattersResponse;
import com.lark.kmp.pb.im.v1.GetChatQRCodeTokenRequest;
import com.lark.kmp.pb.im.v1.GetChatQRCodeTokenResponse;
import com.lark.kmp.rustclient.api.d;
import com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$;
import com.lark.kmp.rustclient.api.model.c;
import com.lark.kmp.rustclient.api.model.i;
import com.lark.kmp.rustclient.api.model.k;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import f8b.a;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupQrCodeRepository {
    public final d a;

    public GroupQrCodeRepository(d r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    public final Object a(String r11, Continuation<? super Result<Chatter>> r12) {
        if ((r12 instanceof GroupQrCodeRepository$fetchGroupOwner$1) == false) goto L7;
        GroupQrCodeRepository$fetchGroupOwner$1 r0 = (GroupQrCodeRepository$fetchGroupOwner$1) r12;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
    L22:
        Object r14 = Result.constructor-impl((Chatter) ((MGetChattersResponse) ((k) r13).b).getEntity().getChatters().get(r11));     // Catch: Throwable -> L14
    L25:
        Throwable r4 = Result.exceptionOrNull-impl(r14);
        if (r4 == null) goto L28;
        int r5 = a.a;
        a.a("GroupQrCodeRepository fetchGroupOwner error for ownerId: " + r11 + ", message: " + r4.getMessage());
    L28:
        return r14;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        MGetChattersRequest.a r6 = new MGetChattersRequest.a();
        List r15 = CollectionsKt.listOf(r11);
        Intrinsics.checkNotNullParameter(r15, "chatter_ids");
        com.lark.wire.internal.a.a(r15);
        r6.d = r15;
        r6.e = Boxing.boxBoolean(true);
        c r16 = new c(r6, MGetChattersResponse.ADAPTER, Command.MGET_CHATTERS, null, 120);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        RustOutputKt$errorAsException$.inlined.map.1 r17 = i.a(this.a.b(r16).a());     // Catch: Throwable -> L14
        r0.L$0 = r11;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        r13 = e.s(r17, r0);     // Catch: Throwable -> L14
        if (r13 != r2) goto L22;
        return r2;
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new GroupQrCodeRepository$fetchGroupOwner$1(this, r12);
        goto L8
    }

    public final Object b(String r11, int r12, boolean r13, Continuation<? super Result<GetChatQRCodeTokenResponse>> r14) {
        if ((r14 instanceof GroupQrCodeRepository$fetchQRCodeToken$1) == false) goto L7;
        GroupQrCodeRepository$fetchQRCodeToken$1 r0 = (GroupQrCodeRepository$fetchQRCodeToken$1) r14;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L21
    L19:
        Object r16 = Result.constructor-impl((GetChatQRCodeTokenResponse) ((k) r15).b);     // Catch: Throwable -> L21
    L23:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L26;
        int r18 = a.a;
        a.a("GroupQrCodeRepository fetchQRCodeToken error: " + r17.getMessage());
    L26:
        return r16;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        GetChatQRCodeTokenRequest.a r5 = new GetChatQRCodeTokenRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chat_id");
        r5.d = r11;
        r5.e = Boxing.boxInt(r12);
        r5.f = Boxing.boxBoolean(r13);
        c r19 = new c(r5, GetChatQRCodeTokenResponse.ADAPTER, Command.GET_CHAT_QRCODE_TOKEN, null, 120);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L21
        RustOutputKt$errorAsException$.inlined.map.1 r111 = i.a(this.a.b(r19).a());     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r15 = e.s(r111, r0);     // Catch: Throwable -> L21
        if (r15 != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new GroupQrCodeRepository$fetchQRCodeToken$1(this, r14);
        goto L8
    }
}
