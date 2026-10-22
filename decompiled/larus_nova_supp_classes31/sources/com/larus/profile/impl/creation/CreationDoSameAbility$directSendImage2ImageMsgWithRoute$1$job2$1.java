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
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job2$1", f = "CreationDoSameAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UplinkFileEntity>, Object> {
    final /* synthetic */ String $fileLocalPath;
    int label;

    public CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job2$1(String r1, Continuation<? super CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job2$1> r2) {
        this.$fileLocalPath = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job2$1(this.$fileLocalPath, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UplinkFileEntity> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r40) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r40);
        if (com.larus.utils.o0.d(this.$fileLocalPath) == false) goto L13;
        Application r1 = AppHost.a.getApplication();
        String r3 = this.$fileLocalPath;
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        String r2 = vqc.d.d(r1, com.larus.utils.y0.j(r3));
        ImFileUtil r4 = ImFileUtil.a;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r2);
        r4.getClass();
        UplinkEntityContent r6 = new UplinkEntityContent(null, new Image(null, ImFileUtil.g(r5), null, new ImageObj(null, 0, 0, null, null, 31, null), null, r2, null, null, null, null, null, null, null, null, 16341, null), 1, null);
        return new UplinkFileEntity(Boxing.boxInt(UplinkEntityType.EntityTypeImage.getValue()), r6, null, null, Boxing.boxInt(FileReviewState.DEFAULT.getValue()), Boxing.boxInt(FileParseState.DEFAULT.getValue()), Boxing.boxInt(0), Boxing.boxInt(UpLinkState.PROCESSING.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r2)), null, null, null, 15116, null);
    L13:
        return null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
