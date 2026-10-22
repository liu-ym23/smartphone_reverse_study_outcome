package com.larus.uaigc.music.template.kmp;

import android.widget.FrameLayout;
import com.larus.bmhome.actionbar.model.d0;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderBinding;
import com.larus.uaigc.music.template.MusicTemplateModel;
import com.larus.uaigc.music.template.MusicTemplateRepository;
import com.larus.uaigc.music.template.w;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import cq8.o0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.kmp.KmpMusicTemplateSelectorWidget$requestTemplateList$1", f = "KmpMusicTemplateSelectorWidget.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
public final class KmpMusicTemplateSelectorWidget$requestTemplateList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $scope;
    int label;
    final /* synthetic */ KmpMusicTemplateSelectorWidget this$0;

    public KmpMusicTemplateSelectorWidget$requestTemplateList$1(KmpMusicTemplateSelectorWidget r1, CoroutineScope r2, Continuation<? super KmpMusicTemplateSelectorWidget$requestTemplateList$1> r3) {
        this.this$0 = r1;
        this.$scope = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new KmpMusicTemplateSelectorWidget$requestTemplateList$1(this.this$0, this.$scope, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [android.view.ViewGroup, com.larus.uaigc.music.template.kmp.KmpMusicTemplateSelectorWidget] */
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        final MusicTemplateModel r6 = (MusicTemplateModel) r5;
        FrameLayout r3 = null;
        if (r6 == null) goto L22;
        com.larus.bmhome.music.protocol.c r4 = r6.c;
        if (r4 == null) goto L22;
        List r7 = r4.c();
        if (r7 == null) goto L22;
        List r8 = CollectionsKt.filterNotNull(r7);
        if (r8 == null) goto L22;
        bq8.a r9 = (bq8.a) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L22;
        Image r10 = r9.getCover();
    L23:
        LarusItemActionbarImageTemplateCoverHolderBinding r11 = this.this$0.h;
        if (r11 == null) goto L32;
        if (r10 == null) goto L30;
        ImageObj r12 = r10.imageThumb;
        if (r12 == null) goto L30;
        String r13 = r12.url;
        if (r13 == null) goto L30;
    L31:
        w.a(r11, r13);
    L30:
        r13 = "";
    L32:
        o0 r14 = this.this$0.i;
        if (r14 == null) goto L41;
        d0 r15 = r14.f;
        if (r15 == null) goto L41;
        List r16 = r15.d;
        if (r16 == null) goto L41;
        com.larus.bmhome.actionbar.model.w r17 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L41;
        String r18 = r17.b;
    L42:
        if (r18 != null) goto L44;
    L47:
        if (r2 == true) goto L51;
        LarusItemActionbarImageTemplateCoverHolderBinding r19 = this.this$0.h;
        if (r19 == null) goto L54;
        w.b(r19, r18);
    L54:
        final KmpMusicTemplateSelectorWidget r20 = this.this$0;
        LarusItemActionbarImageTemplateCoverHolderBinding r21 = r20.h;
        if (r21 == null) goto L57;
        r3 = r21.a;
    L57:
        final CoroutineScope r22 = this.$scope;
        e1.d(r3, new f(r6, r20, r22));
        return Unit.INSTANCE;
    L51:
        ?? r23 = this.this$0;
        LarusItemActionbarImageTemplateCoverHolderBinding r24 = r23.h;
        if (r24 == null) goto L54;
        w.b(r24, r23.getResources().getString(2131906382));
        goto L54
    L44:
        if (r18.length() == 0) goto L47;
        r2 = false;
    L41:
        r18 = null;
    L22:
        r10 = null;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MusicTemplateRepository r25 = MusicTemplateRepository.a;
        this.label = 1;
        r5 = r25.b(true, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
