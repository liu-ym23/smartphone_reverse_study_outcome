package com.larus.uaigc.template;

import android.os.Bundle;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateRecommendRelatedData;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateType;
import com.larus.utils.o0;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.template.ImageTemplateDetailFragment$requestTemplateRelatedList$1", f = "ImageTemplateDetailFragment.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
final class ImageTemplateDetailFragment$requestTemplateRelatedList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageTemplateDetailFragment this$0;

    public ImageTemplateDetailFragment$requestTemplateRelatedList$1(ImageTemplateDetailFragment r1, Continuation<? super ImageTemplateDetailFragment$requestTemplateRelatedList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageTemplateDetailFragment$requestTemplateRelatedList$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        List<TemplateInfo$TemplateInfo> r14 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L18:
        y r2 = (com.larus.network.http.a) r1;
        if ((r2 instanceof y) == false) goto L37;
        y r3 = r2;
        TemplateInfo$TemplateRecommendRelatedData r4 = (TemplateInfo$TemplateRecommendRelatedData) ((com.larus.network.http.a) r3).b;
        if (r4 == null) goto L25;
        List<TemplateInfo$TemplateInfo> r5 = r4.a;
        if (r5 == null) goto L25;
        r14 = CollectionsKt.filterNotNull(r5);
    L25:
        ImageAdapter r6 = this.this$0.e;
        if (r6 == null) goto L28;
        r6.y2(r14);
    L28:
        ImageTemplateDetailFragment r7 = this.this$0;
        r7.f++;
        TemplateInfo$TemplateRecommendRelatedData r8 = (TemplateInfo$TemplateRecommendRelatedData) ((com.larus.network.http.a) r3).b;
        if (r8 == null) goto L33;
        Boolean r9 = r8.d;
        if (r9 == null) goto L33;
        boolean r10 = r9.booleanValue();
    L34:
        r7.h = r10;
        ImageTemplateDetailFragment r11 = this.this$0;
        ImageAdapter r12 = r11.e;
        if (r12 == null) goto L39;
        r12.i = r11.h;
    L39:
        return Unit.INSTANCE;
    L33:
        r10 = false;
        goto L34
    L37:
        ImageTemplateDetailFragment r15 = this.this$0;
        r15.g.remove(Boxing.boxInt(r15.f));
        goto L39
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        JSONObject r16 = new JSONObject();
        ImageTemplateDetailFragment r18 = this.this$0;
        Bundle r19 = r18.getArguments();
        if (r19 == null) goto L11;
        Long r20 = Boxing.boxLong(r19.getLong("template_id"));
    L12:
        r16.put("template_id", r20);
        r16.put("template_type", TemplateInfo$TemplateType.AI_ARTIST);
        r16.put("offset", r18.f);
        r16.put("size", 20);
        if (o0.d(r18.j) == false) goto L15;
        r16.put("bot_id", r18.j);
    L15:
        Unit r21 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Social", TemplateInfo$TemplateRecommendRelatedData.class, "/alice/template/recommend_related", r16, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L18;
        return r13;
    L11:
        r20 = null;
        goto L12
    }
}
