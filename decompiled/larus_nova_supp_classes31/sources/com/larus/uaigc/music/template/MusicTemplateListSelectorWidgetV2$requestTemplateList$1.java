package com.larus.uaigc.music.template;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.larus.bmhome.actionbar.model.d0;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderBinding;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
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
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateListSelectorWidgetV2$requestTemplateList$1", f = "MusicTemplateListSelectorWidgetV2.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
final class MusicTemplateListSelectorWidgetV2$requestTemplateList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MusicTemplateListSelectorWidgetV2 this$0;

    public MusicTemplateListSelectorWidgetV2$requestTemplateList$1(MusicTemplateListSelectorWidgetV2 r1, Continuation<? super MusicTemplateListSelectorWidgetV2$requestTemplateList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MusicTemplateListSelectorWidgetV2$requestTemplateList$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [android.view.ViewGroup, com.larus.uaigc.music.template.MusicTemplateListSelectorWidgetV2] */
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        final MusicTemplateModel r6 = (MusicTemplateModel) r5;
        FrameLayout r2 = null;
        if (r6 == null) goto L22;
        com.larus.bmhome.music.protocol.c r3 = r6.c;
        if (r3 == null) goto L22;
        List r4 = r3.c();
        if (r4 == null) goto L22;
        List r7 = CollectionsKt.filterNotNull(r4);
        if (r7 == null) goto L22;
        bq8.a r8 = (bq8.a) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L22;
        Image r9 = r8.getCover();
    L23:
        LarusItemActionbarImageTemplateCoverHolderBinding r10 = this.this$0.j;
        if (r10 == null) goto L32;
        if (r9 == null) goto L30;
        ImageObj r11 = r9.imageThumb;
        if (r11 == null) goto L30;
        String r12 = r11.url;
        if (r12 == null) goto L30;
    L31:
        w.a(r10, r12);
    L30:
        r12 = "";
    L32:
        d0 r13 = MusicTemplateListSelectorWidgetV2.o6(this.this$0);
        if (r13 == null) goto L48;
        List r14 = r13.d;
        if (r14 == null) goto L48;
        com.larus.bmhome.actionbar.model.w r15 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L48;
        ?? r16 = this.this$0;
        String r17 = r15.b;
        if (r17 == null) goto L48;
        if (TextUtils.isEmpty(r17) == true) goto L45;
        LarusItemActionbarImageTemplateCoverHolderBinding r18 = r16.j;
        if (r18 == null) goto L48;
        w.b(r18, r17);
        goto L48
    L45:
        LarusItemActionbarImageTemplateCoverHolderBinding r19 = r16.j;
        if (r19 == null) goto L48;
        w.b(r19, r16.getResources().getString(2131906382));
    L48:
        final MusicTemplateListSelectorWidgetV2 r20 = this.this$0;
        LarusItemActionbarImageTemplateCoverHolderBinding r21 = r20.j;
        if (r21 == null) goto L51;
        r2 = r21.a;
    L51:
        e1.d(r2, new u(r6, r20));
        return Unit.INSTANCE;
    L22:
        r9 = null;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MusicTemplateRepository r22 = MusicTemplateRepository.a;
        this.label = 1;
        r5 = r22.b(true, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
