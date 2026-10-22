package com.larus.bmhome.view.actionbar.edit.component;

import android.net.Uri;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.instruction.impl.databinding.LarusItemActionbarMultiReferenceImageBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.ReferenceImageUploadWidget$bindPickPictureResult$1", f = "ReferenceImageUploadWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ReferenceImageUploadWidget$bindPickPictureResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ReferenceImageUploadWidget this$0;

    public static final class a implements v1 {
        public final /* synthetic */ Ref.ObjectRef<String> a;
        public final /* synthetic */ ReferenceImageUploadWidget b;
        public final /* synthetic */ long c;
        public final /* synthetic */ FragmentActivity d;

        @Override // com.larus.bmhome.view.actionbar.edit.component.v1
        public final void b(ic8.n0 r5) {
            Intrinsics.checkNotNullParameter(r5, "processResult");
            FLogger.a.i("ReferenceImageUploadWidget", "onReferenceImageProcessResult");
            Ref.ObjectRef<String> r0 = this.a;
            ic8.m0 r6 = r5.a;
            if (r6 == null) goto L5;
            String r7 = r6.e;
        L6:
            r0.element = r7;
            if (r7 == null) goto L21;
            ReferenceImageUploadWidget r1 = this.b;
            LarusItemActionbarMultiReferenceImageBinding r2 = r1.f;
            if (r2 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r2 = null;
        L11:
            com.larus.utils.e1.o(r2.d);
            LarusItemActionbarMultiReferenceImageBinding r3 = r1.f;
            if (r3 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r3 = null;
        L14:
            com.larus.utils.e1.x(r3.c);
            LarusItemActionbarMultiReferenceImageBinding r4 = r1.f;
            if (r4 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r4 = null;
        L17:
            ImageLoaderKt.s(r4.h, Uri.fromFile(new PolarisFileWrapper(r7)), null);
            r1.V6();
            com.larus.bmhome.view.actionbar.edit.c r8 = r1.getViewModel();
            if (r8 == null) goto L22;
            r8.onInstructionReferenceImageUploadStatus(1);
            return;
        L22:
            return;
        L21:
            return;
        L5:
            r7 = null;
            goto L6
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.w1
        public final void a(final long r4, String r6) {
            Intrinsics.checkNotNullParameter(r6, "fileIdentifier");
            FLogger.a.i("ReferenceImageUploadWidget", "onReferenceImageUploadProgressUpdate progress is " + r4);
            final ReferenceImageUploadWidget r0 = this.b;
            r0.h = r6;
            com.larus.utils.t0.e(new f2(r0, r4));
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.w1
        public final void c(final String r9, String r10) {
            Intrinsics.checkNotNullParameter(r10, "fileIdentifier");
            FLogger.a.i("ReferenceImageUploadWidget", "onReferenceImageUploadFail");
            final FragmentActivity r4 = this.d;
            final ReferenceImageUploadWidget r5 = this.b;
            final long r6 = this.c;
            com.larus.utils.t0.e(new g2(r9, r4, r5, r6));
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.w1
        public final void d(mr9.l r26, String r27) {
            Intrinsics.checkNotNullParameter(r26, "uploadResult");
            Intrinsics.checkNotNullParameter(r27, "fileIdentifier");
            FLogger.a.i("ReferenceImageUploadWidget", "onReferenceImageUploadSuccess");
            ReferenceImageUploadWidget r2 = this.b;
            Integer r3 = null;
            r2.h = null;
            ReferenceImageUploadWidget.C6(r2, SystemClock.currentThreadTimeMillis() - this.c, true);
            com.larus.bmhome.view.actionbar.edit.c r4 = this.b.getViewModel();
            if (r4 == null) goto L5;
            r4.onInstructionReferenceImageUploadStatus(2);
        L5:
            String r7 = r26.a;
            if (r7 == null) goto L38;
            ReferenceImageUploadWidget r5 = this.b;
            Ref.ObjectRef<String> r6 = this.a;
            wa8.u r8 = ReferenceImageUploadWidget.o6(r5);
            if (r8 == null) goto L10;
            wa8.p r9 = r8.b;
        L11:
            if (r9 == null) goto L22;
            wa8.u r10 = ReferenceImageUploadWidget.o6(r5);
            if (r10 == null) goto L17;
            wa8.p r11 = r10.b;
            if (r11 == null) goto L17;
            r11.a = r7;
        L17:
            wa8.u r12 = ReferenceImageUploadWidget.o6(r5);
            if (r12 == null) goto L25;
            wa8.p r13 = r12.b;
            if (r13 == null) goto L25;
            r13.b = (String) r6.element;
        L25:
            com.larus.bmhome.view.actionbar.edit.c r14 = r5.getViewModel();
            if (r14 == null) goto L38;
            mr9.d r15 = r26.d;
            if (r15 == null) goto L30;
            Integer r16 = Integer.valueOf(r15.b);
        L31:
            mr9.d r1 = r26.d;
            if (r1 == null) goto L34;
            r3 = Integer.valueOf(r1.a);
        L34:
            Integer r17 = r3;
            String r18 = (String) r6.element;
            if (r18 != null) goto L37;
            r18 = "";
        L37:
            r14.onInstructionReferenceImageChanged(new AttachmentInfo(true, r7, r17, r16, r18, "", "album", null, null, null, null, null, null, null, null, null, null, 130944, null));
            goto L38
        L30:
            r16 = null;
            goto L31
        L22:
            wa8.u r19 = ReferenceImageUploadWidget.o6(r5);
            if (r19 == null) goto L25;
            r19.b = new wa8.p(r7, (String) r6.element);
            goto L25
        L10:
            r9 = null;
        L38:
            final ReferenceImageUploadWidget r20 = this.b;
            com.larus.utils.t0.e(new e2(r20));
        }

        public a(Ref.ObjectRef<String> r1, ReferenceImageUploadWidget r2, long r3, FragmentActivity r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }
    }

    public ReferenceImageUploadWidget$bindPickPictureResult$1(ReferenceImageUploadWidget r1, Uri r2, Continuation<? super ReferenceImageUploadWidget$bindPickPictureResult$1> r3) {
        this.this$0 = r1;
        this.$uri = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ReferenceImageUploadWidget$bindPickPictureResult$1(this.this$0, this.$uri, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r15);
        ReferenceImageUploadWidget r16 = this.this$0;
        int r0 = ReferenceImageUploadWidget.k;
        Fragment r17 = r16.getFragment();
        if (r17 == null) goto L14;
        FragmentActivity r5 = r17.getActivity();
        if (r5 == null) goto L14;
        Uri r18 = this.$uri;
        ReferenceImageUploadWidget r6 = this.this$0;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        r6.g = new a(new Ref.ObjectRef(), r6, SystemClock.currentThreadTimeMillis(), r5);     // Catch: Throwable -> L11
        Result.constructor-impl(BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ReferenceImageUploadWidget$tryReferenceImageUpload$1(r18, r6, null), 2, null));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
