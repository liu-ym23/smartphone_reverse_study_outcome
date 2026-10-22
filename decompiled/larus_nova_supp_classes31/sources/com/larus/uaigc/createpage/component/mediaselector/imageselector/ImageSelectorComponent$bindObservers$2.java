package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$bindObservers$2", f = "ImageSelectorComponent.kt", i = {}, l = {639}, m = "invokeSuspend", n = {}, s = {})
final class ImageSelectorComponent$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ImageSelectorComponent a;

        public a(ImageSelectorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            com.larus.bmhome.view.actionbar.edit.m r7 = (com.larus.bmhome.view.actionbar.edit.m) r5;
            UserCreation r8 = r7.a.j;
            if (r8 == null) goto L46;
            ImageSelectorComponent r0 = this.a;
            int r1 = r8.b;
            if (r1 != 5) goto L7;
        L12:
            Lazy<Long> r2 = ImageSelectorComponent.X;
            r0.X3().setEnableShowReselectIcon(true);
            CreationPublishExtra r3 = r8.p;
            boolean r4 = false;
            if (r3 == null) goto L15;
            boolean r9 = Intrinsics.areEqual(r3.b, Boolean.FALSE);
        L16:
            if (r9 == false) goto L26;
            UserCreationRefContent r10 = r8.o;
            if (r10 == null) goto L35;
            List<ImageInfo> r11 = r10.a();
            if (r11 == null) goto L35;
            ImageInfo r12 = (ImageInfo) CollectionsKt.getOrNull(r11, 0);
            if (r12 == null) goto L35;
            Image r13 = r12.h;
            if (r13 == null) goto L35;
            String r14 = r13.a;
        L36:
            if (r14 != null) goto L38;
            r14 = "";
        L38:
            CreationPublishExtra r15 = r8.p;
            if (r15 == null) goto L41;
            r4 = Intrinsics.areEqual(r15.b, Boxing.boxBoolean(false));
        L41:
            r0.S = r4;
            Uri r16 = r7.b;
            if (r16 == null) goto L44;
            r0.l4(String.valueOf(r16));
            goto L46
        L44:
            r0.p4(r14);
        L35:
            r14 = null;
            goto L36
        L26:
            UserCreationRefContent r17 = r8.o;
            if (r17 == null) goto L35;
            List<ImageInfo> r18 = r17.a();
            if (r18 == null) goto L35;
            ImageInfo r19 = (ImageInfo) CollectionsKt.getOrNull(r18, 0);
            if (r19 == null) goto L35;
            Image r20 = r19.c;
            if (r20 == null) goto L35;
            r14 = r20.a;
            goto L36
        L15:
            r9 = false;
            goto L16
        L7:
            if (r1 == 7) goto L12;
            if (r1 == 9) goto L12;
            if (r1 == 11) goto L12;
        L46:
            return Unit.INSTANCE;
        }
    }

    public ImageSelectorComponent$bindObservers$2(ImageSelectorComponent r1, Continuation<? super ImageSelectorComponent$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageSelectorComponent$bindObservers$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.d1 r6 = ((com.larus.bmhome.view.actionbar.edit.c) this.this$0.U.getValue()).getInstructionPhotoTemplatePrompt();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
