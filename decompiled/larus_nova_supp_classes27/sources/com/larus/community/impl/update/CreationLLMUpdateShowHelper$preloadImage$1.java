package com.larus.community.impl.update;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.IVideoController;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.settings.provider.creation.CreationUpdateDialogItemConfig;
import com.larus.settings.provider.creation.MediaConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hu9.s;
import java.util.Iterator;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.update.CreationLLMUpdateShowHelper$preloadImage$1", f = "CreationLLMUpdateShowHelper.kt", i = {1}, l = {54, 73}, m = "invokeSuspend", n = {"item"}, s = {"L$2"})
public final class CreationLLMUpdateShowHelper$preloadImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ CreationLLMUpdateShowHelper this$0;

    public CreationLLMUpdateShowHelper$preloadImage$1(CreationLLMUpdateShowHelper r1, Continuation<? super CreationLLMUpdateShowHelper$preloadImage$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationLLMUpdateShowHelper$preloadImage$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00f9 -> B:50:0x00fc). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r2 = (String) this.L$3;
        final CreationUpdateDialogItemConfig r3 = (CreationUpdateDialogItemConfig) this.L$2;
        Iterator r5 = (Iterator) this.L$1;
        CreationLLMUpdateShowHelper r6 = (CreationLLMUpdateShowHelper) this.L$0;
        ResultKt.throwOnFailure(r15);
        CreationLLMUpdateShowHelper$preloadImage$1 r16 = this;
    L50:
        m29.a.a("CreationLLMUpdateShowHelper", new k(r3));
    L19:
        if (r5.hasNext() == false) goto L59;
        r3 = (CreationUpdateDialogItemConfig) r5.next();
        long r7 = ((Keva) r6.a.getValue()).getLong(String.valueOf(r3.e()), -1);
        Long r9 = r3.i();
        if (r9 == null) goto L25;
        if (r7 == r9.longValue()) goto L19;
    L25:
        IActionBarService r8 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        Integer r10 = r3.e();
        boolean r11 = false;
        if (r10 == null) goto L28;
        int r12 = r10.intValue();
    L30:
        if (r8.e(r12) == null) goto L19;
        MediaConfig r13 = r3.g();
        if (r13 != null) goto L35;
    L37:
        if (r11 == true) goto L38;
        MediaConfig r4 = r3.g();
        if (r4 == null) goto L19;
        String r14 = r4.d();
        if (r14 == null) goto L19;
        FLogger.a.i("CreationLLMUpdateShowHelper", "execute preLoadVideoModel");
        IVideoController r17 = ps8.a.a.a(IAIChatUgcAIGCService.a.L(), "llm_dialog", 6);
        if (r17 == null) goto L19;
        r17.f(r14, new j(r14));
        goto L19
    L38:
        boolean r18 = v19.h.a;
        String r20 = null;
        if (v19.h.a(null) == false) goto L43;
        MediaConfig r21 = r3.g();
        if (r21 == null) goto L46;
        r20 = r21.a();
    L46:
        if (r20 == null) goto L19;
        r16.L$0 = r6;
        r16.L$1 = r5;
        r16.L$2 = r3;
        r16.L$3 = r20;
        r16.label = 2;
        if (ImageLoaderKt.A(r20, "CreationLLMUpdateShowHelper", null, null, null, r16, 60) != r0) goto L50;
        return r0;
    L43:
        MediaConfig r22 = r3.g();
        if (r22 == null) goto L46;
        r20 = r22.c();
        goto L46
    L35:
        if (r13.getType() != 0) goto L37;
        r11 = true;
        goto L37
    L28:
        r12 = 0;
    L59:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L13:
        List r110 = ((s) this.this$0.b.getValue()).a();
        if (r110 == null) goto L59;
        List r111 = CollectionsKt.filterNotNull(r110);
        if (r111 == null) goto L59;
        CreationLLMUpdateShowHelper r23 = this.this$0;
        r5 = r111.iterator();
        r6 = r23;
        r16 = this;
        goto L19
    L10:
        ResultKt.throwOnFailure(r15);
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L13;
        return r0;
    }
}
