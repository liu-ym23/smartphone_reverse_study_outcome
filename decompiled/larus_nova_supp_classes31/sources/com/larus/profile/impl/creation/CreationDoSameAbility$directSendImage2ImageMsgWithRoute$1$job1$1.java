package com.larus.profile.impl.creation;

import android.app.Application;
import com.bytedance.mt.protector.impl.UriProtector;
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
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/UplinkFileEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job1$1", f = "CreationDoSameAbility.kt", i = {0, 0, 1, 1}, l = {2663, 2664}, m = "invokeSuspend", n = {"url", "explainJob", "url", "localPath"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UplinkFileEntity>, Object> {
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ UserCreation $userCreation;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job1$1(sq9.p r1, UserCreation r2, CreationDoSameAbility r3, Continuation<? super CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job1$1> r4) {
        this.$doSameInitParams = r1;
        this.$userCreation = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job1$1 r0 = new CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job1$1(this.$doSameInitParams, this.$userCreation, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UplinkFileEntity> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r47) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        String r3 = (String) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r47);
        Object r5 = r47;
        String r12 = r3;
    L20:
        com.larus.network.http.a r6 = (com.larus.network.http.a) r5;
        com.larus.uaigc.api.s r7 = (com.larus.uaigc.api.s) r6.b;
        if (r7 == null) goto L25;
        List<com.larus.uaigc.api.q> r8 = r7.a();
        if (r8 == null) goto L25;
        com.larus.uaigc.api.q r9 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r8);
    L26:
        if (r9 == null) goto L28;
        String r10 = r9.c();
    L30:
        if (com.larus.utils.o0.d(r10) == true) goto L32;
    L70:
        FLogger.a.e("CreationDoSameAbility", "explain resource fail");
        t19.s r11 = t19.s.a;
        Application r13 = AppHost.a.getApplication();
        r11.getClass();
        t19.s.b(r13, 2131908080, false);
        return null;
    L32:
        if (com.larus.utils.o0.d(r4) == false) goto L70;
        ImFileUtil r14 = ImFileUtil.a;
        if (r12 != null) goto L36;
        String r15 = "";
    L37:
        PolarisFileWrapper r16 = new PolarisFileWrapper(r15);
        r14.getClass();
        String r17 = ImFileUtil.g(r16);
        com.larus.uaigc.api.s r18 = (com.larus.uaigc.api.s) r6.b;
        if (r18 == null) goto L52;
        List<com.larus.uaigc.api.q> r19 = r18.a();
        if (r19 == null) goto L52;
        com.larus.uaigc.api.q r20 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L52;
        com.larus.uaigc.api.p r21 = r20.b();
        if (r21 == null) goto L52;
        com.larus.uaigc.api.n r22 = r21.a();
        if (r22 == null) goto L52;
        com.larus.uaigc.api.m r23 = r22.a();
        if (r23 == null) goto L52;
        Long r24 = r23.b();
        if (r24 == null) goto L52;
        long r110 = r24.longValue();
    L53:
        int r25 = (int) r110;
        com.larus.uaigc.api.s r26 = (com.larus.uaigc.api.s) r6.b;
        if (r26 == null) goto L68;
        List<com.larus.uaigc.api.q> r27 = r26.a();
        if (r27 == null) goto L68;
        com.larus.uaigc.api.q r28 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r27);
        if (r28 == null) goto L68;
        com.larus.uaigc.api.p r29 = r28.b();
        if (r29 == null) goto L68;
        com.larus.uaigc.api.n r30 = r29.a();
        if (r30 == null) goto L68;
        com.larus.uaigc.api.m r31 = r30.a();
        if (r31 == null) goto L68;
        Long r32 = r31.a();
        if (r32 == null) goto L68;
        long r111 = r32.longValue();
    L73:
        return new UplinkFileEntity(Boxing.boxInt(UplinkEntityType.EntityTypeImage.getValue()), new UplinkEntityContent(null, new Image(r10, r17, null, new ImageObj(r4, r25, (int) r111, null, null, 24, null), null, r12, null, null, null, null, null, null, null, null, 16340, null), 1, null), null, null, Boxing.boxInt(FileReviewState.ACCESS.getValue()), Boxing.boxInt(FileParseState.SUCCESS.getValue()), Boxing.boxInt(100), Boxing.boxInt(UpLinkState.SUCCESS.getValue()), null, false, UriProtector.parse(r4), null, null, null, 15116, null);
    L68:
        r111 = 0;
    L52:
        r110 = 0;
        goto L53
    L36:
        r15 = r12;
        goto L37
    L28:
        r10 = null;
    L25:
        r9 = null;
        goto L26
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Deferred r33 = (Deferred) this.L$1;
        String r34 = (String) this.L$0;
        ResultKt.throwOnFailure(r47);
        Deferred r35 = r33;
        Object r36 = r47;
    L16:
        String r37 = (String) r36;
        this.L$0 = r34;
        this.L$1 = r37;
        this.label = 2;
        r5 = r35.await(this);
        if (r5 != r1) goto L19;
        return r1;
    L19:
        r12 = r37;
        r4 = r34;
        goto L20
    L10:
        ResultKt.throwOnFailure(r47);
        CoroutineScope r38 = (CoroutineScope) this.L$0;
        if (Intrinsics.areEqual(this.$doSameInitParams.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L72;
        String r112 = this.$userCreation.e();
        Deferred r113 = BuildersKt.async$default(r38, null, null, new CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job1$1$saveJob$1(this.this$0, r112, null), 3, null);
        Deferred r39 = BuildersKt.async$default(r38, null, null, new CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job1$1$explainJob$1(r112, null), 3, null);
        this.L$0 = r112;
        this.L$1 = r39;
        this.label = 1;
        r36 = r113.await(this);
        if (r36 != r1) goto L15;
        return r1;
    L15:
        r35 = r39;
        r34 = r112;
        goto L16
    L72:
        return null;
    }
}
