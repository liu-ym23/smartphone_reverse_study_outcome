package com.larus.uaigc.createpage.bussiness.remove;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.uaigc.impl.databinding.LarusFragmentImageRemoveBinding;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$doUpload$1$1", f = "ImageRemoveFragment.kt", i = {0}, l = {292, 300}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class ImageRemoveFragment$doUpload$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusFragmentImageRemoveBinding $this_run;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ImageRemoveFragment this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$doUpload$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$doUpload$1$1$1", f = "ImageRemoveFragment.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ImageRemoveFragment this$0;

        public AnonymousClass1(ImageRemoveFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            ImageRemoveFragment r5 = this.this$0;
            int r2 = ImageRemoveFragment.v;
            r5.ja0();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            if (DelayKt.delay(50, this) != r0) goto L11;
            return r0;
        }
    }

    public ImageRemoveFragment$doUpload$1$1(LarusFragmentImageRemoveBinding r1, ImageRemoveFragment r2, Continuation<? super ImageRemoveFragment$doUpload$1$1> r3) {
        this.$this_run = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ImageRemoveFragment$doUpload$1$1 r0 = new ImageRemoveFragment$doUpload$1$1(this.$this_run, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        LarusFragmentImageRemoveBinding r2 = (LarusFragmentImageRemoveBinding) this.L$2;
        ImageRemoveFragment r3 = (ImageRemoveFragment) this.L$1;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
        final ImageRemoveFragment r6 = r3;
    L16:
        File r13 = (File) r12;
        if (r13 != null) goto L20;
        r2.h.setImageBitmap(null);
        int r14 = ImageRemoveFragment.v;
        r6.ga0();
        t19.s r15 = t19.s.a;
        Context r4 = r6.getContext();
        r15.getClass();
        t19.s.s(r4, 2131908214);
        return Unit.INSTANCE;
    L20:
        String r7 = vqc.d.d(r6.getContext(), Uri.fromFile(r13));
        Intrinsics.checkNotNull(r7);
        Function1 r9 = new s(r6);
        Function1 r8 = new t(r6);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        int r16 = ImageRemoveFragment.v;
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L26;
        StringBuilder r17 = new StringBuilder();
        r17.append(UUID.randomUUID());
        r17.append('_');
        r17.append(System.currentTimeMillis());
        r6.h = r17.toString();
        Object r18 = BuildersKt.withContext(Dispatchers.getIO(), new ImageRemoveFragment$submitImageResourceAccess$2(r6, r7, r8, r9, null), this);
        if (r18 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        r18 = Unit.INSTANCE;
    L27:
        if (r18 != r0) goto L30;
        return r0;
    L26:
        t19.s r19 = t19.s.a;
        Context r10 = r6.getContext();
        r19.getClass();
        t19.s.s(r10, 2131908080);
        r6.ia0();
        r18 = Unit.INSTANCE;
        goto L27
    L10:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        BuildersKt.launch$default(r110, Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, null), 2, null);
        Bitmap r11 = this.$this_run.h.getViewBitmap();
        if (r11 == null) goto L30;
        ImageRemoveFragment r20 = this.this$0;
        LarusFragmentImageRemoveBinding r21 = this.$this_run;
        Context r22 = r20.getContext();
        this.L$0 = r110;
        this.L$1 = r20;
        this.L$2 = r21;
        this.label = 1;
        r12 = BitmapHelperKt.d(r22, r11, "ugc_original_image_edit_cache.jpeg", this);
        if (r12 != r0) goto L15;
        return r0;
    L15:
        r2 = r21;
        r6 = r20;
        goto L16
    }
}
