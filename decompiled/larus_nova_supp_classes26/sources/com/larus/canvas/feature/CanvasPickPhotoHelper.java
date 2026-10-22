package com.larus.canvas.feature;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
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
public final class CanvasPickPhotoHelper implements com.larus.bmhome.instruction.helper.f {
    public final FragmentActivity a;
    public Function1<? super Uri, Unit> b;
    public Function1<? super List<? extends Uri>, Unit> c;
    public final MutableSharedFlow<Unit> d;
    public final a1 e;
    public final ActivityResultLauncher<String> f;
    public final ActivityResultLauncher<Intent> g;

    /* JADX INFO: renamed from: com.larus.canvas.feature.CanvasPickPhotoHelper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.CanvasPickPhotoHelper$1", f = "CanvasPickPhotoHelper.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CanvasPickPhotoHelper this$0;

        /* JADX INFO: renamed from: com.larus.canvas.feature.CanvasPickPhotoHelper$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CanvasPickPhotoHelper a;

            public a(CanvasPickPhotoHelper r1) {
                this.a = r1;
            }

            public final Object emit(Object r4, Continuation r5) {
                Unit r6 = (Unit) r4;
                k2 r7 = k2.a;
                if (r7.x() == false) goto L5;
                CanvasPickPhotoHelper r8 = this.a;
                FragmentActivity r0 = r8.a;
                ActivityResultLauncher<Intent> r9 = r8.g;
                AlbumSettingConfig.a r1 = new AlbumSettingConfig.a();
                r1.y = true;
                r7.h(r0, r9, r1.a());
            L8:
                FLogger.a.i("CanvasPickPhotoHelper", "PhotoPickerService.singlePick");
                return Unit.INSTANCE;
            L5:
                ActivityResultLauncher<String> r10 = this.a.f;
                if (r10 == null) goto L8;
                r10.launch("image/*");
                goto L8
            }
        }

        public AnonymousClass1(CanvasPickPhotoHelper r1, Continuation<? super AnonymousClass1> r2) {
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
            CanvasPickPhotoHelper r6 = this.this$0;
            a1 r2 = r6.e;
            a r3 = new a(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
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
        if (r1 == null) goto L9;
        r1.unregister();
        return;
    }

    public CanvasPickPhotoHelper(FragmentActivity r9) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        this.a = r9;
        MutableSharedFlow<Unit> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.d = r0;
        this.e = kotlinx.coroutines.flow.e.a(r0);
        this.f = r9.registerForActivityResult(new ActivityResultContracts.GetContent(), new b(this));
        this.g = r9.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
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
    public final void a(FragmentActivity r8, boolean r9, int r10) {
        if (r8 != null) goto L4;
        r8 = this.a;
    L4:
        FragmentActivity r1 = r8;
        k2 r11 = k2.a;
        g3.a.a(null, r1, false, null, false, new d(this), 29);
    }
}
