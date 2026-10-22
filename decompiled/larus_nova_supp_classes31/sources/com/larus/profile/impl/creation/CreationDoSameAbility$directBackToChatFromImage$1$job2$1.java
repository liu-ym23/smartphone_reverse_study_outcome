package com.larus.profile.impl.creation;

import android.app.Application;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/UplinkFileEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directBackToChatFromImage$1$job2$1", f = "CreationDoSameAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDoSameAbility$directBackToChatFromImage$1$job2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UplinkFileEntity>, Object> {
    final /* synthetic */ String $fileLocalPath;
    private /* synthetic */ Object L$0;
    int label;

    public CreationDoSameAbility$directBackToChatFromImage$1$job2$1(String r1, Continuation<? super CreationDoSameAbility$directBackToChatFromImage$1$job2$1> r2) {
        this.$fileLocalPath = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreationDoSameAbility$directBackToChatFromImage$1$job2$1 r0 = new CreationDoSameAbility$directBackToChatFromImage$1$job2$1(this.$fileLocalPath, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UplinkFileEntity> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r25);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        String r1 = this.$fileLocalPath;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        if (com.larus.utils.o0.d(r1) == false) goto L11;
        Application r4 = AppHost.a.getApplication();     // Catch: Throwable -> L14
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        String r2 = vqc.d.d(r4, com.larus.utils.y0.j(r1));     // Catch: Throwable -> L14
        ImFileUtil r5 = ImFileUtil.a;     // Catch: Throwable -> L14
        PolarisFileWrapper r6 = new PolarisFileWrapper(r2);     // Catch: Throwable -> L14
        r5.getClass();     // Catch: Throwable -> L14
        UplinkFileEntity r7 = new UplinkFileEntity(Boxing.boxInt(UplinkEntityType.EntityTypeImage.getValue()), new UplinkEntityContent(null, new Image(null, ImFileUtil.g(r6), null, new ImageObj(null, 0, 0, null, null, 31, null), null, r2, null, null, null, null, null, null, null, null, 16341, null), 1, null), null, null, Boxing.boxInt(FileReviewState.DEFAULT.getValue()), Boxing.boxInt(FileParseState.DEFAULT.getValue()), Boxing.boxInt(0), Boxing.boxInt(UpLinkState.PROCESSING.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r2)), null, null, null, 15116, null);     // Catch: Throwable -> L14
    L12:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L14
    L16:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L25;
        FLogger.a.e("CreationDoSameAbility", "get local file path error", r9);
        return null;
    L25:
        return r8;
    L11:
        r7 = null;
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
