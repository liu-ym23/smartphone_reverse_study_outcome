package com.larus.photopicker.v2.impl;

import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1", f = "MediaGalleryFragment.kt", i = {}, l = {1004, 1006}, m = "invokeSuspend", n = {}, s = {})
final class MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $uriList;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MediaGalleryFragment this$0;

    public MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1(List<String> r1, MediaGalleryFragment r2, Continuation<? super MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1> r3) {
        this.$uriList = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1(this.$uriList, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Iterator r2 = (Iterator) this.L$1;
        MediaGalleryFragment r4 = (MediaGalleryFragment) this.L$0;
        ResultKt.throwOnFailure(r11);
        Iterator r12 = r2;
        MediaGalleryFragment r3 = r4;
    L11:
        MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1 r5 = this;
    L13:
        if (r12.hasNext() == false) goto L28;
        String r6 = (String) r12.next();
        int r7 = e0.a;
        e0.d("MediaGalleryFragment", "refreshMediaDataAndSelectNewItem: " + r6);
        if (r6 == null) goto L13;
        int r8 = MediaGalleryFragment.n;
        MediaGalleryLiveDataViewModel r9 = r3.Y90();
        r5.L$0 = r3;
        r5.L$1 = r12;
        r5.label = 1;
        Object r10 = r9.queryMediaItem(r6, r5);
        if (r10 != r0) goto L20;
        return r0;
    L20:
        MediaGalleryFragment r13 = r3;
        Iterator r14 = r12;
        r11 = r10;
        MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1 r15 = r5;
        MediaGalleryFragment r16 = r13;
    L21:
        mp9.c r17 = (mp9.c) r11;
        if (r17 == null) goto L26;
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1$1$1 r19 = new MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1$1$1(r16, r17, null);
        r15.L$0 = r16;
        r15.L$1 = r14;
        r15.label = 2;
        if (BuildersKt.withContext(r18, r19, r15) != r0) goto L26;
        return r0;
    L26:
        r12 = r14;
        r3 = r16;
        r5 = r15;
        goto L13
    L29:
        r12 = r14;
        r3 = r16;
        r5 = r15;
        goto L13
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r14 = (Iterator) this.L$1;
        r16 = (MediaGalleryFragment) this.L$0;
        ResultKt.throwOnFailure(r11);
        r15 = this;
        goto L21
    L10:
        ResultKt.throwOnFailure(r11);
        List<String> r110 = this.$uriList;
        r3 = this.this$0;
        r12 = r110.iterator();
        goto L11
    }
}
