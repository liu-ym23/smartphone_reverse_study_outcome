package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmParticipantType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmSubtitleSpeakerType;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper$onGetDoubaoUserInfo$1", f = "MmEndWindowWebHelper.kt", i = {1}, l = {698, 715}, m = "invokeSuspend", n = {"userName"}, s = {"L$0"})
final class MmEndWindowWebHelper$onGetDoubaoUserInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ xwb.j $callback;
    final /* synthetic */ MmGetDoubaoUserInfoParam $param;
    Object L$0;
    int label;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$onGetDoubaoUserInfo$1(MmEndWindowWebHelper r1, MmGetDoubaoUserInfoParam r2, xwb.j r3, Continuation<? super MmEndWindowWebHelper$onGetDoubaoUserInfo$1> r4) {
        this.this$0 = r1;
        this.$param = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmEndWindowWebHelper$onGetDoubaoUserInfo$1(this.this$0, this.$param, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.label;
        boolean r9 = true;
        if (r5 == 0) goto L13;
        if (r5 == 1) goto L11;
        if (r5 != 2) goto L10;
        String r0 = (String) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L24
        String r3 = r0;
        Object r1 = r20;
    L44:
        String r2 = (String) r1;     // Catch: Exception -> L24
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L24
        r6.put("userId", this.$param.getUserId());     // Catch: Exception -> L24
        r6.put(AppbrandHostConstants.Schema_Meta.NAME, r3);     // Catch: Exception -> L24
        r6.put("avatarBase64", r2);     // Catch: Exception -> L24
        String r7 = r6.toString();     // Catch: Exception -> L24
        int r8 = bwb.b.a;     // Catch: Exception -> L24
        MmUiLogScene r10 = MmUiLogScene.WEB;     // Catch: Exception -> L24
        StringBuilder r11 = new StringBuilder("userId=");     // Catch: Exception -> L24
        r11.append(this.$param.getUserId());     // Catch: Exception -> L24
        r11.append(", hasAvatar=");     // Catch: Exception -> L24
        if (r2.length() > 0) goto L48;
        r9 = false;
    L48:
        r11.append(r9);     // Catch: Exception -> L24
        bwb.b.f(r10, "onGetDoubaoUserInfo", r11.toString(), this.this$0.f());     // Catch: Exception -> L24
        this.$callback.a(Status.SUCCESS, r7);     // Catch: Exception -> L24
    L52:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L24
        Object r12 = ((Result) r20).unbox-impl();     // Catch: Exception -> L24
    L17:
        String r13 = null;
        if (Result.isFailure-impl(r12) == false) goto L27;
        Throwable r14 = Result.exceptionOrNull-impl(r12);     // Catch: Exception -> L24
        if (r14 == null) goto L22;
        r13 = r14.getMessage();     // Catch: Exception -> L24
    L22:
        int r15 = bwb.b.a;     // Catch: Exception -> L24
        bwb.b.d(MmUiLogScene.WEB, "onGetDoubaoUserInfo", "exception=" + r13, this.this$0.f());     // Catch: Exception -> L24
        this.$callback.a(Status.FAILURE, "{\"error\":\"getUserInfo exception:" + r13 + ", userId:" + this.$param.getUserId() + "\"}");     // Catch: Exception -> L24
        return Unit.INSTANCE;
    L27:
        if (Result.isFailure-impl(r12) == false) goto L29;
        Object r16 = null;
    L30:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r17 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i) r16;     // Catch: Exception -> L24
        if (r17 == null) goto L33;
        String r18 = r17.g;     // Catch: Exception -> L24
    L35:
        if (Result.isFailure-impl(r12) == false) goto L37;
        r12 = null;
    L37:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r19 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i) r12;     // Catch: Exception -> L24
        if (r19 == null) goto L40;
        r3 = r19.f;     // Catch: Exception -> L24
    L41:
        CoroutineDispatcher r21 = Dispatchers.getIO();     // Catch: Exception -> L24
        MmEndWindowWebHelper$onGetDoubaoUserInfo$1$avatarBase64$1 r22 = new MmEndWindowWebHelper$onGetDoubaoUserInfo$1$avatarBase64$1(r18, this.this$0, this.$param, null);     // Catch: Exception -> L24
        this.L$0 = r3;     // Catch: Exception -> L24
        this.label = 2;     // Catch: Exception -> L24
        r1 = BuildersKt.withContext(r21, r22, this);     // Catch: Exception -> L24
        if (r1 != r4) goto L44;
        return r4;
    L40:
        r3 = null;
        goto L41
    L33:
        r18 = null;
        goto L35
    L29:
        r16 = r12;
        goto L30
    L13:
        ResultKt.throwOnFailure(r20);
        MmUserInfoHelper r23 = this.this$0.a.O();     // Catch: Exception -> L24
        String r110 = this.this$0.b;     // Catch: Exception -> L24
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r111 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i(this.$param.getUserId(), null, MmParticipantType.LARK_USER, MmSubtitleSpeakerType.VOICE_PRINT_SPEAKER, null, 114);     // Catch: Exception -> L24
        this.label = 1;     // Catch: Exception -> L24
        r12 = r23.c(r110, r111, this);     // Catch: Exception -> L24
        if (r12 != r4) goto L17;
        return r4;
    L24:
        e = move-exception;
        int r24 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "onGetDoubaoUserInfo", "error=" + e.getMessage(), this.this$0.f());
        this.$callback.a(Status.FAILURE, "{\"error\":\"" + e.getMessage() + "\"}");
        goto L52
    }
}
