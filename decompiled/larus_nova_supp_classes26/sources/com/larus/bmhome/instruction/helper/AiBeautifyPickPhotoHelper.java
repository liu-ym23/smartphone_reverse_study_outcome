package com.larus.bmhome.instruction.helper;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AiBeautifyPickPhotoHelper implements f {
    public final Fragment a;
    public Function1<? super Uri, Unit> b;
    public Function1<? super List<? extends Uri>, Unit> c;
    public final MutableSharedFlow<g> d;
    public final a1 e;
    public final ActivityResultLauncher<String> f;
    public final ActivityResultLauncher<Intent> g;
    public final ActivityResultLauncher<String> h;
    public final ActivityResultLauncher<Intent> i;

    /* JADX INFO: renamed from: com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1", f = "AiBeautifyPickPhotoHelper.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AiBeautifyPickPhotoHelper this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1$1", f = "AiBeautifyPickPhotoHelper.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AiBeautifyPickPhotoHelper this$0;

            /* JADX INFO: renamed from: com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$1$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ AiBeautifyPickPhotoHelper a;

                public a(AiBeautifyPickPhotoHelper r1) {
                    this.a = r1;
                }

                public final Object emit(Object r3, Continuation r4) {
                    g r5 = (g) r3;
                    k2 r6 = k2.a;
                    if (r6.x() == false) goto L10;
                    AlbumSettingConfig.a r0 = new AlbumSettingConfig.a();
                    r0.d = r5.b;
                    r0.c = r5.a;
                    r0.y = true;
                    AlbumSettingConfig r1 = r0.a();
                    if (r5.a == false) goto L7;
                    ActivityResultLauncher<Intent> r7 = this.a.i;
                L8:
                    r6.h(this.a.a.getContext(), r7, r1);
                L17:
                    FLogger.a.i("AiBeautifyPickPhotoHelper", "PhotoPickerService.singlePick");
                    return Unit.INSTANCE;
                L7:
                    r7 = this.a.g;
                    goto L8
                L10:
                    if (r5.a == false) goto L14;
                    ActivityResultLauncher<String> r8 = this.a.h;
                    if (r8 == null) goto L17;
                    r8.launch("image/*");
                    goto L17
                L14:
                    ActivityResultLauncher<String> r9 = this.a.f;
                    if (r9 == null) goto L17;
                    r9.launch("image/*");
                    goto L17
                }
            }

            public C00191(AiBeautifyPickPhotoHelper r1, Continuation<? super C00191> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00191(this.this$0, r3);
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
                AiBeautifyPickPhotoHelper r6 = this.this$0;
                a1 r2 = r6.e;
                a r3 = new a(r6);
                this.label = 1;
                if (r2.collect(r3, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(AiBeautifyPickPhotoHelper r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            AiBeautifyPickPhotoHelper r8 = this.this$0;
            Fragment r2 = r8.a;
            Lifecycle.State r3 = Lifecycle.State.STARTED;
            C00191 r4 = new C00191(r8, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(r2, r3, r4, this) != r0) goto L12;
            return r0;
        }
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void onDestroy() {
        ActivityResultLauncher<String> r0 = this.f;
        if (r0 == null) goto L5;
        r0.unregister();
    L5:
        ActivityResultLauncher<Intent> r1 = this.g;
        if (r1 == null) goto L8;
        r1.unregister();
    L8:
        ActivityResultLauncher<String> r2 = this.h;
        if (r2 == null) goto L11;
        r2.unregister();
    L11:
        ActivityResultLauncher<Intent> r3 = this.i;
        if (r3 == null) goto L15;
        r3.unregister();
        return;
    }

    public AiBeautifyPickPhotoHelper(Fragment r9) {
        Intrinsics.checkNotNullParameter(r9, "fragment");
        this.a = r9;
        MutableSharedFlow<g> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.d = r0;
        this.e = kotlinx.coroutines.flow.e.a(r0);
        this.f = r9.registerForActivityResult(new ActivityResultContracts.GetContent(), new a(this));
        this.g = r9.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b(this));
        this.h = r9.registerForActivityResult(new ActivityResultContracts.GetMultipleContents(), new c(this));
        this.i = r9.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void b(Function1<? super Uri, Unit> r1) {
        this.b = r1;
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void c(Function1<? super List<? extends Uri>, Unit> r1) {
        this.c = r1;
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void a(FragmentActivity r8, final boolean r9, final int r10) {
        if (r8 != null) goto L4;
        r8 = this.a.getActivity();
    L4:
        FragmentActivity r1 = r8;
        if (r1 == null) goto L8;
        k2 r11 = k2.a;
        g3.a.a(null, r1, false, null, false, new e(this, r9, r10), 29);
        return;
    }
}
