package com.larus.community.impl.viewholder;

import android.net.Uri;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.viewholder.CreationAvatarEntranceViewHolder$initView$1", f = "CreationAvatarEntranceViewHolder.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
final class CreationAvatarEntranceViewHolder$initView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationAvatarEntranceViewHolder this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationAvatarEntranceViewHolder a;

        public a(CreationAvatarEntranceViewHolder r1) {
            this.a = r1;
        }

        public final Object emit(Object r8, Continuation r9) {
            int r10 = ((Number) r8).intValue();
            if (r10 == 0) goto L19;
            Uri r0 = null;
            String r1 = null;
            r0 = null;
            if (r10 != 1) goto L7;
            e1.o(this.a.c);
            SimpleDraweeView r2 = this.a.a;
            ICreationPageService r11 = (ICreationPageService) ServiceManager.get().getService(ICreationPageService.class);
            if (r11 == null) goto L18;
            String r12 = r11.g();
            if (r12 == null) goto L18;
            r0 = UriProtector.parse(r12);
        L18:
            final CreationAvatarEntranceViewHolder r13 = this.a;
            ImageLoaderKt.x(r2, r0, "community_creation_photo", null, new c(r13), 4);
            e1.d(this.a.a, new d());
        L24:
            return Unit.INSTANCE;
        L7:
            if (r10 != 2) goto L24;
            e1.o(this.a.c);
            SimpleDraweeView r14 = this.a.a;
            ICreationPageService r15 = (ICreationPageService) ServiceManager.get().getService(ICreationPageService.class);
            if (r15 == null) goto L12;
            r1 = r15.d();
        L12:
            final CreationAvatarEntranceViewHolder r16 = this.a;
            ImageLoaderKt.y(r14, r1, "community_creation_photo", new e(r16), 4);
            final CreationAvatarEntranceViewHolder r17 = this.a;
            e1.d(r17.a, new f(r17));
            goto L24
        L19:
            this.a.a.setImageResource(2131242961);
            e1.o(this.a.b);
            e1.x(this.a.c);
            View r18 = this.a.d;
            if (r18 == null) goto L22;
            e1.o(r18);
        L22:
            final CreationAvatarEntranceViewHolder r20 = this.a;
            e1.d(r20.a, new com.larus.community.impl.viewholder.a(r20));
            final CreationAvatarEntranceViewHolder r21 = this.a;
            e1.d(r21.c, new b(r21));
            goto L24
        }
    }

    public CreationAvatarEntranceViewHolder$initView$1(CreationAvatarEntranceViewHolder r1, Continuation<? super CreationAvatarEntranceViewHolder$initView$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationAvatarEntranceViewHolder$initView$1(this.this$0, r3);
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
    L14:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationAvatarEntranceViewHolder r6 = this.this$0;
        z0<Integer> r2 = r6.e;
        if (r2 == null) goto L16;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L14;
        return r0;
    L16:
        return Unit.INSTANCE;
    }
}
