package com.larus.uaigc.instruction;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.o0;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.MultiAttachmentSelectorWidget$handleClickOpen$1$1", f = "MultiAttachmentSelectorWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MultiAttachmentSelectorWidget$handleClickOpen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $clickPos;
    final /* synthetic */ ResourceItemBean $clickResourceItemBean;
    final /* synthetic */ Fragment $currentFragment;
    int label;
    final /* synthetic */ MultiAttachmentSelectorWidget this$0;

    public MultiAttachmentSelectorWidget$handleClickOpen$1$1(Fragment r1, ResourceItemBean r2, MultiAttachmentSelectorWidget r3, int r4, Continuation<? super MultiAttachmentSelectorWidget$handleClickOpen$1$1> r5) {
        this.$currentFragment = r1;
        this.$clickResourceItemBean = r2;
        this.this$0 = r3;
        this.$clickPos = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MultiAttachmentSelectorWidget$handleClickOpen$1$1(this.$currentFragment, this.$clickResourceItemBean, this.this$0, this.$clickPos, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r34) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L85;
        ResultKt.throwOnFailure(r34);
        IAIChatService.Companion r1 = IAIChatService.a;
        FragmentActivity r2 = this.$currentFragment.getActivity();
        if (r2 == null) goto L83;
        FragmentManager r3 = r2.getSupportFragmentManager();
        if (r3 == null) goto L83;
        mt8.b r4 = this.$clickResourceItemBean.getVideo();
        String r5 = null;
        if (r4 == null) goto L12;
        String r14 = r4.g;
    L13:
        mt8.b r6 = this.$clickResourceItemBean.getVideo();
        if (r6 == null) goto L16;
        String r7 = r6.f;
    L17:
        mt8.b r8 = this.$clickResourceItemBean.getVideo();
        if (r8 == null) goto L20;
        String r9 = r8.h;
    L21:
        mt8.b r10 = this.$clickResourceItemBean.getVideo();
        if (r10 != null) goto L24;
        String r11 = null;
    L29:
        mt8.b r12 = this.$clickResourceItemBean.getVideo();
        if (r12 == null) goto L32;
        Double r13 = Boxing.boxDouble(r12.b);
    L33:
        mt8.b r15 = this.$clickResourceItemBean.getVideo();
        if (r15 == null) goto L36;
        String r16 = r15.e;
    L37:
        mt8.b r17 = this.$clickResourceItemBean.getVideo();
        if (r17 == null) goto L55;
        Image r18 = r17.a;
        if (r18 == null) goto L55;
        ImageObj r19 = r18.imageThumb;
        if (r19 == null) goto L44;
        String r20 = r19.url;
    L46:
        if (o0.d(r20) == false) goto L50;
        ImageObj r21 = r18.imageThumb;
        if (r21 == null) goto L53;
        String r22 = r21.url;
    L54:
        String r110 = r22;
    L56:
        mt8.b r23 = this.$clickResourceItemBean.getVideo();
        if (r23 == null) goto L61;
        Image r24 = r23.a;
        if (r24 == null) goto L61;
        String r111 = r24.localResPath;
    L62:
        mt8.b r25 = this.$clickResourceItemBean.getVideo();
        int r26 = 0;
        if (r25 == null) goto L65;
        int r27 = r25.c;
    L66:
        mt8.b r28 = this.$clickResourceItemBean.getVideo();
        if (r28 == null) goto L69;
        r26 = r28.d;
    L69:
        nr9.g r29 = new nr9.g(r7, r9, r11, null, r13, null, new nr9.f(null, r110, r111, Boxing.boxInt(r26), Boxing.boxInt(r27), null, 33), r16, r14, null, 552);
        ys8.a r30 = this.this$0.j;
        if (r30 == null) goto L72;
        String r210 = r30.k();
    L73:
        mt8.b r31 = this.$clickResourceItemBean.getVideo();
        if (r31 == null) goto L77;
        r5 = r31.e;
    L77:
        if (o0.d(r5) == false) goto L79;
        String r32 = "1";
    L80:
        r1.K7(r3, r29, new c4(null, null, r210, null, null, "click_addition_video", r32, null, Boxing.boxInt(this.$clickPos), null, null, null, null, null, 16027));
        return Unit.INSTANCE;
    L79:
        r32 = "0";
        goto L80
    L72:
        r210 = null;
        goto L73
    L65:
        r27 = 0;
    L61:
        r111 = null;
    L53:
        r22 = null;
        goto L54
    L50:
        ImageObj r33 = r18.imageOri;
        if (r33 == null) goto L53;
        r22 = r33.url;
        goto L54
    L44:
        r20 = null;
    L55:
        r110 = null;
        goto L56
    L36:
        r16 = null;
        goto L37
    L32:
        r13 = null;
        goto L33
    L24:
        if (o0.d(r10.e) == false) goto L26;
        String r35 = r10.e;
    L27:
        r11 = r35;
        goto L29
    L26:
        r35 = r10.i;
        goto L27
    L20:
        r9 = null;
        goto L21
    L16:
        r7 = null;
        goto L17
    L12:
        r14 = null;
    L83:
        return Unit.INSTANCE;
    L85:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
