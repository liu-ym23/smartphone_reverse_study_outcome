package com.larus.bmhome.instruction;

import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationUserAvatar;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.TemplatePrefetchHelper$prefetchTemplateBitmapOnDestroy$1", f = "TemplatePrefetchHelper.kt", i = {}, l = {112, 128}, m = "invokeSuspend", n = {}, s = {})
public final class TemplatePrefetchHelper$prefetchTemplateBitmapOnDestroy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $instructionType;
    Object L$0;
    Object L$1;
    int label;

    public TemplatePrefetchHelper$prefetchTemplateBitmapOnDestroy$1(Integer r1, Continuation<? super TemplatePrefetchHelper$prefetchTemplateBitmapOnDestroy$1> r2) {
        this.$instructionType = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TemplatePrefetchHelper$prefetchTemplateBitmapOnDestroy$1(this.$instructionType, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00bb -> B:48:0x00be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0140 -> B:84:0x0143). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Iterator r2 = (Iterator) this.L$1;
        Integer r5 = (Integer) this.L$0;
        ResultKt.throwOnFailure(r15);
        TemplatePrefetchHelper$prefetchTemplateBitmapOnDestroy$1 r16 = this;
    L48:
        boolean r7 = w1.a;
        w1.c("prefetchToBitmapCache", "prefetchTemplateBitmapOnDestroy,instructionType" + r5);
    L34:
        if (r2.hasNext() == false) goto L86;
        UserCreationContent r8 = ((UserCreation) r2.next()).e;
        if (r8 == null) goto L44;
        UserCreationUserAvatar r9 = r8.c;
        if (r9 == null) goto L44;
        ImageInfo r10 = r9.a;
        if (r10 == null) goto L44;
        Image r11 = r10.b;
        if (r11 == null) goto L44;
        String r12 = r11.a;
    L45:
        r16.L$0 = r5;
        r16.L$1 = r2;
        r16.label = 2;
        if (ImageLoaderKt.A(r12, "getCreationListCacheData.prefetch", null, null, null, r16, 60) != r0) goto L48;
        return r0;
    L44:
        r12 = null;
    L86:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Iterator r3 = (Iterator) this.L$1;
        Integer r6 = (Integer) this.L$0;
        ResultKt.throwOnFailure(r15);
        TemplatePrefetchHelper$prefetchTemplateBitmapOnDestroy$1 r17 = this;
    L84:
        boolean r13 = w1.a;
        w1.c("prefetchToBitmapCache", "prefetchTemplateBitmapOnDestroy,instructionType" + r6);
    L59:
        if (r3.hasNext() == false) goto L86;
        UserCreationContent r14 = ((UserCreation) r3.next()).e;
        if (r14 == null) goto L72;
        UserCreationImage r18 = r14.a;
        if (r18 == null) goto L72;
        ImageInfo r19 = r18.a;
        if (r19 == null) goto L72;
        Image r20 = r19.b;
        if (r20 == null) goto L72;
        String r21 = r20.a;
        if (r21 == null) goto L72;
        String r22 = r21;
    L81:
        r17.L$0 = r6;
        r17.L$1 = r3;
        r17.label = 1;
        if (ImageLoaderKt.A(r22, "getCreationListCacheData.prefetch", null, null, null, r17, 60) != r0) goto L84;
        return r0;
    L72:
        if (r14 == null) goto L80;
        AiBeautifyUserContent r23 = r14.d;
        if (r23 == null) goto L80;
        ImageInfo r24 = r23.a;
        if (r24 == null) goto L80;
        Image r25 = r24.b;
        if (r25 == null) goto L80;
        r22 = r25.a;
    L80:
        r22 = null;
        goto L81
    L10:
        ResultKt.throwOnFailure(r15);
        Integer r110 = this.$instructionType;
        if (r110 != null) goto L14;
    L15:
        if (r110 != null) goto L18;
    L20:
        if (r110 == null) goto L86;
        if (r110.intValue() != 11) goto L86;
        com.larus.platform.service.e0 r111 = com.larus.platform.service.e0.a;
        CreationFeedCacheEntity r112 = com.larus.platform.api.g2.a.b("3");
        if (r112 == null) goto L86;
        zp9.c r113 = r112.getListData();
        if (r113 == null) goto L86;
        List r114 = r113.c();
        if (r114 == null) goto L86;
        List r115 = CollectionsKt.take(r114, 6);
        if (r115 == null) goto L86;
        r5 = this.$instructionType;
        r2 = r115.iterator();
        r16 = this;
        goto L34
    L18:
        if (r110.intValue() != 16) goto L20;
    L49:
        com.larus.platform.service.e0 r116 = com.larus.platform.service.e0.a;
        CreationFeedCacheEntity r117 = com.larus.platform.api.g2.a.b("2");
        if (r117 == null) goto L86;
        zp9.c r118 = r117.getListData();
        if (r118 == null) goto L86;
        List r119 = r118.c();
        if (r119 == null) goto L86;
        List r120 = CollectionsKt.take(r119, 6);
        if (r120 == null) goto L86;
        r6 = this.$instructionType;
        r3 = r120.iterator();
        r17 = this;
        goto L59
    L14:
        if (r110.intValue() == 4) goto L49;
        goto L15
    }
}
