package com.larus.voicecall.impl.component.picture;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.av_call.view.VoiceCallTopLayout;
import com.larus.camera.api.params.OutputParam;
import com.larus.common_ui.widget.roundlayout.CustomRoundImageView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.picture.RealtimePictureComponent$prepareForAni$2", f = "RealtimePictureComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimePictureComponent$prepareForAni$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OutputParam $outputParam;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RealtimePictureComponent this$0;

    public RealtimePictureComponent$prepareForAni$2(RealtimePictureComponent r1, OutputParam r2, Continuation<? super RealtimePictureComponent$prepareForAni$2> r3) {
        this.this$0 = r1;
        this.$outputParam = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        RealtimePictureComponent$prepareForAni$2 r0 = new RealtimePictureComponent$prepareForAni$2(this.this$0, this.$outputParam, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L59;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == true) goto L22;
        z2 r6 = z2.a;
        if (r6.enableAutoOpenSubtitle() == false) goto L22;
        if (RealtimeCallUtil.k() == false) goto L22;
        if (r6.realtimeCallUseTwoLineStyle() == false) goto L15;
        RealtimePictureComponent r7 = this.this$0;
        int r0 = RealtimePictureComponent.B;
        com.larus.voicecall.impl.component.subtitle.a r8 = r7.C3();
        if (r8 == null) goto L22;
        r8.nV(false, "click_btn");
        goto L22
    L15:
        m3a.a r9 = (m3a.a) this.this$0.q.getValue();
        if (r9 == null) goto L22;
        VoiceCallTopLayout r10 = r9.Fv();
        if (r10 == null) goto L22;
        CustomRoundImageView r11 = r10.getSubtitleButton();
        if (r11 == null) goto L22;
        Boxing.boxBoolean(r11.performClick());
    L22:
        RealtimePictureComponent r12 = this.this$0;
        int r1 = RealtimePictureComponent.B;
        g3a.a r13 = r12.p3();
        if (r13 == null) goto L27;
        View r14 = r13.Tt();
        if (r14 == null) goto L27;
        e1.x(r14);
    L27:
        g3a.a r15 = this.this$0.p3();
        if (r15 == null) goto L32;
        SimpleDraweeView r16 = r15.kj();
        if (r16 == null) goto L32;
        e1.x(r16);
    L32:
        g3a.a r17 = this.this$0.p3();
        if (r17 == null) goto L37;
        SimpleDraweeView r18 = r17.kj();
        if (r18 == null) goto L37;
        r18.setRotation(this.$outputParam.getImageParam().getRotation());
    L37:
        Bitmap r19 = this.$outputParam.getImageParam().getBitmap();
        if (r19 == null) goto L49;
        RealtimePictureComponent r2 = this.this$0;
        if (r19.isRecycled() == true) goto L47;
        g3a.a r3 = r2.p3();
        if (r3 == null) goto L46;
        SimpleDraweeView r20 = r3.kj();
        if (r20 == null) goto L46;
        r20.setImageBitmap(r19);
        Unit r21 = Unit.INSTANCE;
    L48:
        if (r21 == null) goto L49;
    L57:
        return Unit.INSTANCE;
    L46:
        r21 = null;
        goto L48
    L47:
        FLogger.a.e("RealtimePictureComponent", "bitmap recycled");
        r21 = Unit.INSTANCE;
    L49:
        OutputParam r22 = this.$outputParam;
        RealtimePictureComponent r23 = this.this$0;
        String r24 = r22.getPath();
        if (StringsKt.isBlank(r24) == true) goto L57;
        Uri r25 = Uri.fromFile(new PolarisFileWrapper(r24));
        g3a.a r26 = r23.p3();
        if (r26 == null) goto L57;
        SimpleDraweeView r27 = r26.kj();
        if (r27 == null) goto L57;
        ImageLoaderKt.s(r27, r25, null);
        goto L57
    L59:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
