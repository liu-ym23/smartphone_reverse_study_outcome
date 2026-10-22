package com.larus.bmhome.video.fragment;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.save_share.VideoGenerateSaver;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.service.ICreationMetadataService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$download$1", f = "AiGenVideoDetailFragment.kt", i = {}, l = {662}, m = "invokeSuspend", n = {}, s = {})
public final class AiGenVideoDetailFragment$download$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ nr9.g $videoContent;
    int label;
    final /* synthetic */ AiGenVideoDetailFragment this$0;

    public AiGenVideoDetailFragment$download$1(AiGenVideoDetailFragment r1, nr9.g r2, Continuation<? super AiGenVideoDetailFragment$download$1> r3) {
        this.this$0 = r1;
        this.$videoContent = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AiGenVideoDetailFragment$download$1(this.this$0, this.$videoContent, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
        Object r3 = r18;
    L14:
        final UserCreationFromIM r4 = (UserCreationFromIM) r3;
        AiGenVideoDetailFragment r5 = this.this$0;
        VideoGenerateSaver r6 = r5.T;
        Context r7 = r5.getContext();
        nr9.g r8 = this.$videoContent;
        AiGenVideoDetailFragment r9 = this.this$0;
        c4 r10 = r9.f;
        LifecycleCoroutineScope r11 = LifecycleOwnerKt.getLifecycleScope(r9.getViewLifecycleOwner());
        AiGenVideoDetailFragment r12 = this.this$0;
        boolean r13 = r12.h;
        JSONObject r14 = r12.f.m;
        Map r15 = ICreationMetadataService.a.s(r4, null);
        final AiGenVideoDetailFragment r16 = this.this$0;
        com.larus.bmhome.video.save_share.a.C0044a.a(r6, r7, r8, r10, "detail_click", r11, false, r13, r14, r15, null, true, new i(r16, r4), 544);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        qs8.a r17 = this.this$0.s;
        if (r17 == null) goto L11;
        r17.I4(true);
    L11:
        AiGenVideoDetailFragment r19 = this.this$0;
        int r20 = AiGenVideoDetailFragment.U;
        String r21 = r19.la0();
        this.label = 1;
        r3 = r19.ka0(r21, this);
        if (r3 != r1) goto L14;
        return r1;
    }
}
