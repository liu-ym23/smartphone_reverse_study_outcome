package com.ss.android.lark.compose.groupinfo;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lark.kmp.pb.basic.v1.LarkError;
import com.lark.kmp.rustclient.api.model.RustClientException;
import com.ss.android.lark.auditsdk.security.SecurityService;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.utils.ApiUtils;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.j;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AndroidGroupInfoPlatformService implements d {
    public final Context a;

    public AndroidGroupInfoPlatformService(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "appContext");
        this.a = r2;
    }

    @Override // com.ss.android.lark.compose.groupinfo.d
    public final boolean b(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_ERROR);
        String r1 = null;
        if ((r4 instanceof RustClientException) == false) goto L5;
        RustClientException r5 = (RustClientException) r4;
    L6:
        int r0 = 0;
        if (r5 == null) goto L19;
        LarkError r6 = r5.getRustError();
        if (r6 == null) goto L19;
        Integer r2 = r6.getCode();
        if (r2 == null) goto L14;
        r0 = r2.intValue();
    L14:
        ByteString r7 = r6.getExtra();
        if (r7 == null) goto L18;
        r1 = new String(r7.toByteArray(), Charsets.UTF_8);
    L18:
        return ((SecurityService) SecurityService.a.getValue()).a(r0, r1);
    L19:
        return false;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.ss.android.lark.compose.groupinfo.d
    public final Object c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        String r3 = UriProtector.parse(r2).getPath();     // Catch: Throwable -> L16
        if (r3 == null) goto L15;
        if (r3.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L15;
        return Result.constructor-impl(r3);
    L8:
        r1 = false;
    L15:
        throw new IllegalArgumentException("Avatar URI has no upload path");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.ss.android.lark.compose.groupinfo.d
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        ChatCoreModule.a().getAuditDependency().f(r2, r3);
    }

    @Override // com.ss.android.lark.compose.groupinfo.d
    public final Object d(String r6, Continuation<? super Result<String>> r7) {
        if ((r7 instanceof AndroidGroupInfoPlatformService$uploadAvatar$1) == false) goto L7;
        AndroidGroupInfoPlatformService$uploadAvatar$1 r0 = (AndroidGroupInfoPlatformService$uploadAvatar$1) r7;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r9 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L29:
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r6;
        r0.label = 1;
        final j r10 = new j(IntrinsicsKt.intercepted(r0), 1);
        r10.C();
        ((dkc.a) ApiUtils.getApi(dkc.a.class)).uploadGroupAvatar(this.a, r6, new AndroidGroupInfoPlatformService$uploadAvatar$2$1(r10));     // Catch: Exception -> L17
    L23:
        r8 = r10.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L26:
        if (r8 != r2) goto L29;
        return r2;
    L17:
        e = move-exception;
        if ((e instanceof CancellationException) == false) goto L21;
        throw e;
    L21:
        if (r10.isActive() == false) goto L23;
        Result.Companion r4 = Result.Companion;
        r10.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(e)))));
    L7:
        r0 = new AndroidGroupInfoPlatformService$uploadAvatar$1(this, r7);
        goto L8
    }
}
