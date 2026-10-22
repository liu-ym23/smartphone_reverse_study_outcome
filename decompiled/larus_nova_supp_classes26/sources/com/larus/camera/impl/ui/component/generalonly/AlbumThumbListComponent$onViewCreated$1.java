package com.larus.camera.impl.ui.component.generalonly;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.impl.ui.component.generalonly.adapter.AlbumThumbListAdapter;
import com.larus.camera.impl.ui.component.generalonly.adapter.HorizontalItemDecoration;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.ui.viewmodel.ChangeState;
import com.larus.camera.impl.ui.viewmodel.n0;
import com.larus.camera.impl.utils.album.AlbumThumbListManager;
import com.larus.camera.impl.utils.album.FastPhotoPickerInCameraManager;
import com.larus.camera.impl.widget.SwipeVerticalView;
import com.larus.platform.model.album.FastSendFromShowType;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.generalonly.AlbumThumbListComponent$onViewCreated$1", f = "AlbumThumbListComponent.kt", i = {}, l = {111, 121}, m = "invokeSuspend", n = {}, s = {})
public final class AlbumThumbListComponent$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    int label;
    final /* synthetic */ AlbumThumbListComponent this$0;

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.generalonly.AlbumThumbListComponent$onViewCreated$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "changeState", "Lcom/larus/camera/impl/ui/viewmodel/MutableIntState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.generalonly.AlbumThumbListComponent$onViewCreated$1$2", f = "AlbumThumbListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AlbumThumbListComponent this$0;

        public AnonymousClass2(AlbumThumbListComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(n0 r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((n0) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r6);
            int r7 = ((n0) this.L$0).a;
            if (r7 != ChangeState.SHOW.getState()) goto L14;
            AlbumThumbListComponent r8 = this.this$0;
            if (r8.t == true) goto L21;
            r8.t = true;
            CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) r8.e.getValue()).a();
            if (r0 == null) goto L21;
            CameraCaptureViewModel.showCameraItemMobOnCapture$default(r0, "album_thumbnail", null, 2, null);
            r8.q((View) r8.n.getValue(), 0, ((Number) r8.s.getValue()).intValue(), null);
        L21:
            return Unit.INSTANCE;
        L14:
            if (r7 != ChangeState.HIDE.getState()) goto L19;
            AlbumThumbListComponent r9 = this.this$0;
            if (r9.t == false) goto L21;
            r9.t = false;
            r9.q((View) r9.n.getValue(), ((Number) r9.s.getValue()).intValue(), 0, new g(r9));
            goto L21
        L19:
            ChangeState.DEFAULT.getState();
            goto L21
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.generalonly.AlbumThumbListComponent$onViewCreated$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.generalonly.AlbumThumbListComponent$onViewCreated$1$3", f = "AlbumThumbListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AlbumThumbListComponent this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.generalonly.AlbumThumbListComponent$onViewCreated$1$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.camera.impl.ui.component.generalonly.AlbumThumbListComponent$onViewCreated$1$3$1", f = "AlbumThumbListComponent.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AlbumThumbListComponent this$0;

            public AnonymousClass1(AlbumThumbListComponent r1, Continuation<? super AnonymousClass1> r2) {
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
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L15:
                List<? extends Uri> r6 = (List) r5;
                AlbumThumbListAdapter r2 = (AlbumThumbListAdapter) this.this$0.q.getValue();
                r2.getClass();
                Intrinsics.checkNotNullParameter(r6, "imageUris");
                r2.b = r6;
                r2.notifyDataSetChanged();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                FastPhotoPickerInCameraManager r7 = FastPhotoPickerInCameraManager.a;
                kq9.o r8 = FastPhotoPickerInCameraManager.a().c;
                if (r8 == null) goto L11;
                int r9 = r8.c;
            L12:
                AlbumThumbListManager r3 = AlbumThumbListManager.a;
                AlbumThumbListComponent r4 = this.this$0;
                int r10 = AlbumThumbListComponent.u;
                Context r11 = r4.getContext();
                this.label = 1;
                r5 = AlbumThumbListManager.a(r11, r9, null, null, this);
                if (r5 != r0) goto L15;
                return r0;
            L11:
                r9 = 0;
                goto L12
            }
        }

        public AnonymousClass3(AlbumThumbListComponent r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public final Object invoke(long r1, Continuation<? super Unit> r3) {
            return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
            return invoke(((Number) r3).longValue(), (Continuation) r4);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r7);
            AlbumThumbListComponent r8 = this.this$0;
            int r0 = AlbumThumbListComponent.u;
            if (r8.i().getCurrentState() != Lifecycle.State.RESUMED) goto L7;
            BuildersKt.launch$default(this.this$0.k(), Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, null), 2, null);
        L7:
            FLogger.a.i("AlbumThumbListComponent", "onLatestPhotoChanged lifeState=" + this.this$0.i().getCurrentState());
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a extends com.larus.camera.impl.widget.q {
        public final /* synthetic */ AlbumThumbListComponent a;
        public final /* synthetic */ CameraCaptureViewModel b;

        @Override // com.larus.camera.impl.widget.q, com.larus.camera.impl.widget.p
        public final void b() {
            AlbumThumbListComponent r0 = this.a;
            if (r0.t == false) goto L6;
            r0.t = false;
            r0.q((View) r0.n.getValue(), ((Number) r0.s.getValue()).intValue(), 0, new g(r0));
        L6:
            this.b.clickCameraButtonOnCapturePage("album_handle_icon", "drag_close_album");
        }

        public a(AlbumThumbListComponent r1, CameraCaptureViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public AlbumThumbListComponent$onViewCreated$1(CameraCaptureViewModel r1, AlbumThumbListComponent r2, String r3, Continuation<? super AlbumThumbListComponent$onViewCreated$1> r4) {
        this.$viewModel = r1;
        this.this$0 = r2;
        this.$conversationId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AlbumThumbListComponent$onViewCreated$1(this.$viewModel, this.this$0, this.$conversationId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L28:
        List<? extends Uri> r11 = (List) r10;
        if ((!r11.isEmpty()) == false) goto L53;
        AlbumThumbListAdapter r2 = (AlbumThumbListAdapter) this.this$0.q.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "imageUris");
        r2.b = r11;
        r2.notifyDataSetChanged();
        FastPhotoPickerInCameraManager r3 = FastPhotoPickerInCameraManager.a;
        kq9.o r4 = FastPhotoPickerInCameraManager.a().c;
        if (r4 != null) goto L33;
    L35:
        boolean r5 = false;
    L36:
        if (r5 == false) goto L38;
        FLogger.a.i("AlbumThumbListComponent", "onViewCreated show every cold launch");
        AlbumThumbListComponent.p(this.this$0, true);
    L49:
        Lazy r6 = com.larus.camera.impl.utils.album.d.a;
        JSONObject r7 = new JSONObject();
        r7.put("album_size", r11.size());
        Intrinsics.checkNotNullParameter(r7, "extraAttributes");
        com.larus.camera.impl.utils.album.d.c r8 = (com.larus.camera.impl.utils.album.d.c) com.larus.camera.impl.utils.album.d.a.getValue();
        com.larus.camera.impl.utils.album.d.a r9 = (com.larus.camera.impl.utils.album.d.a) com.larus.camera.impl.utils.album.d.b.getValue();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "event");
        Intrinsics.checkNotNullParameter(r7, "extraAttributes");
        r8.a.a(r9, r7);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.$viewModel.getTryChangeAlbumThumbListState(), new AnonymousClass2(this.this$0, null)), this.this$0.k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.$viewModel.getOnLatestPhotoChanged(), new AnonymousClass3(this.this$0, null)), this.this$0.k());
        ((SwipeVerticalView) this.this$0.o.getValue()).setOnSwipeListener(new a(this.this$0, this.$viewModel));
        this.this$0.o();
        return Unit.INSTANCE;
    L38:
        kq9.o r12 = FastPhotoPickerInCameraManager.a().c;
        if (r12 != null) goto L41;
    L43:
        boolean r13 = false;
    L44:
        if (r13 == true) goto L46;
        FLogger.a.i("AlbumThumbListComponent", "onViewCreated hide unmatched conditions");
        AlbumThumbListComponent.p(this.this$0, false);
        return Unit.INSTANCE;
    L46:
        if (FastPhotoPickerInCameraManager.c == true) goto L48;
        FLogger.a.i("AlbumThumbListComponent", "onViewCreated show first cold launch");
        FastPhotoPickerInCameraManager.c = true;
        AlbumThumbListComponent.p(this.this$0, true);
        goto L49
    L48:
        FLogger.a.i("AlbumThumbListComponent", "onViewCreated hide first cold launch");
        AlbumThumbListComponent.p(this.this$0, false);
        goto L49
    L41:
        if (r12.b != FastSendFromShowType.FIRST_COLD_LAUNCH.getType()) goto L43;
        r13 = true;
        goto L44
    L33:
        if (r4.b != FastSendFromShowType.EVERY_COLD_LAUNCH.getType()) goto L35;
        r5 = true;
        goto L36
    L53:
        FLogger.a.i("AlbumThumbListComponent", "onViewCreated imageUris is empty");
        AlbumThumbListComponent.p(this.this$0, false);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L18:
        if (((Boolean) r10).booleanValue() == true) goto L21;
        FLogger.a.i("AlbumThumbListComponent", "onViewCreated hide all album thumb list");
        AlbumThumbListComponent r14 = this.this$0;
        int r15 = AlbumThumbListComponent.u;
        r14.l();
        return Unit.INSTANCE;
    L21:
        ((com.larus.camera.impl.utils.album.d.c) com.larus.camera.impl.utils.album.d.a.getValue()).c((com.larus.camera.impl.utils.album.d.a) com.larus.camera.impl.utils.album.d.b.getValue());
        AlbumThumbListComponent r16 = this.this$0;
        int r17 = AlbumThumbListComponent.u;
        ((RecyclerView) r16.p.getValue()).setLayoutManager(new LinearLayoutManager(this.this$0.getContext(), 0, false));
        ((RecyclerView) this.this$0.p.getValue()).addItemDecoration(new HorizontalItemDecoration(((Number) this.this$0.r.getValue()).intValue(), 0, 0));
        ((RecyclerView) this.this$0.p.getValue()).setAdapter((AlbumThumbListAdapter) this.this$0.q.getValue());
        AlbumThumbListManager r18 = AlbumThumbListManager.a;
        Context r19 = this.this$0.getContext();
        FastPhotoPickerInCameraManager r20 = FastPhotoPickerInCameraManager.a;
        kq9.o r21 = FastPhotoPickerInCameraManager.a().c;
        if (r21 == null) goto L24;
        int r22 = r21.c;
    L25:
        Function2 r23 = new k();
        Function1 r24 = new l();
        this.label = 2;
        r10 = AlbumThumbListManager.a(r19, r22, r23, r24, this);
        if (r10 != r0) goto L28;
        return r0;
    L24:
        r22 = 0;
        goto L25
    L10:
        ResultKt.throwOnFailure(r10);
        ICameraEventExt r110 = this.$viewModel.getCameraData().getEventExt();
        if (r110 == null) goto L13;
        String r111 = r110.getClickFrom();
    L14:
        FastPhotoPickerInCameraManager r25 = FastPhotoPickerInCameraManager.a;
        AlbumThumbListComponent r26 = this.this$0;
        int r27 = AlbumThumbListComponent.u;
        Context r28 = r26.getContext();
        String r29 = this.$conversationId;
        this.label = 1;
        r10 = r25.b(r28, r29, r111, this);
        if (r10 != r0) goto L18;
        return r0;
    L13:
        r111 = null;
        goto L14
    }
}
