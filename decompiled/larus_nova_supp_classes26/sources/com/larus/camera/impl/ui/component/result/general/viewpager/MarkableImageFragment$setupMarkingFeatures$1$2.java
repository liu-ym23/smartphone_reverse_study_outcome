package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.graphics.Bitmap;
import com.larus.bmhome.view.markableview.MarkableImageView;
import com.larus.camera.impl.databinding.LarusItemPreviewMarkableImageBinding;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2", f = "MarkableImageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MarkableImageFragment$setupMarkingFeatures$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MarkableImageView $this_apply;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MarkableImageFragment this$0;

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$1", f = "MarkableImageFragment.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MarkableImageView $this_apply;
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageFragment a;

            public a(MarkableImageFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r4, Continuation r5) {
                boolean r6 = ((Boolean) r4).booleanValue();
                FLogger.a.i(this.a.d, "[setupMarkingFeatures] isInDrawing collected: " + r6);
                this.a.T90().setInDrawingMode(r6);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(MarkableImageView r1, MarkableImageFragment r2, Continuation<? super AnonymousClass1> r3) {
            this.$this_apply = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$this_apply, this.this$0, r4);
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
            b1 r6 = this.$this_apply.o;
            if (r6 == null) goto L16;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L14;
            return r0;
        L16:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$10, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$10", f = "MarkableImageFragment.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$10$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageFragment a;

            public a(MarkableImageFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                Bitmap r5 = (Bitmap) r3;
                if (CameraResultViewModel.shouldUseUnifiedPreviewFramework$default(this.a.T90(), null, 1, null) == false) goto L5;
                r5 = this.a.S90();
            L5:
                if (r5 == null) goto L8;
                this.a.U90(r5);
            L8:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass10(MarkableImageFragment r1, Continuation<? super AnonymousClass10> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass10(this.this$0, r3);
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
            i1<Bitmap> r6 = this.this$0.T90().getCurrentBitmap();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$11, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$11", f = "MarkableImageFragment.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MarkableImageView $this_apply;
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$11$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageView a;

            public a(MarkableImageView r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                MarkableImageView r3 = this.a;
                r3.setRawBitmap((Bitmap) r1);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass11(MarkableImageFragment r1, MarkableImageView r2, Continuation<? super AnonymousClass11> r3) {
            this.this$0 = r1;
            this.$this_apply = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass11(this.this$0, this.$this_apply, r4);
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
            i1<Bitmap> r6 = this.this$0.T90().getRawBaseBitmap();
            a r2 = new a(this.$this_apply);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$2", f = "MarkableImageFragment.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MarkableImageView $this_apply;
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageFragment a;

            public a(MarkableImageFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r4, Continuation r5) {
                boolean r6 = ((Boolean) r4).booleanValue();
                FLogger.a.i(this.a.d, "[setupMarkingFeatures] redoEnabled collected: " + r6);
                this.a.T90().setRedoEnabled(r6);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(MarkableImageView r1, MarkableImageFragment r2, Continuation<? super AnonymousClass2> r3) {
            this.$this_apply = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$this_apply, this.this$0, r4);
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
            i1<Boolean> r6 = this.$this_apply.getRedoEnabled();
            if (r6 == null) goto L16;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L14;
            return r0;
        L16:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$3", f = "MarkableImageFragment.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MarkableImageView $this_apply;
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageFragment a;

            public a(MarkableImageFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r4, Continuation r5) {
                boolean r6 = ((Boolean) r4).booleanValue();
                FLogger.a.i(this.a.d, "[setupMarkingFeatures] undoEnabled collected: " + r6);
                this.a.T90().setUndoEnabled(r6);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(MarkableImageView r1, MarkableImageFragment r2, Continuation<? super AnonymousClass3> r3) {
            this.$this_apply = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.$this_apply, this.this$0, r4);
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
            i1<Boolean> r6 = this.$this_apply.getUndoEnabled();
            if (r6 == null) goto L16;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L14;
            return r0;
        L16:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$4", f = "MarkableImageFragment.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$4$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageFragment a;

            public a(MarkableImageFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                ((Boolean) r1).booleanValue();
                MarkableImageFragment r3 = this.a;
                LarusItemPreviewMarkableImageBinding r4 = r3.h;
                if (r4 == null) goto L8;
                MarkableImageView r5 = r4.b;
                if (r5 == null) goto L8;
                r5.setMarkEnabled(r3.T90().shouldEnableMark());
            L8:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass4(MarkableImageFragment r1, Continuation<? super AnonymousClass4> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass4(this.this$0, r3);
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
            i1<Boolean> r6 = this.this$0.T90().isInMarkSelectMode();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$5", f = "MarkableImageFragment.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$5$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageFragment a;

            public a(MarkableImageFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                com.larus.camera.impl.ui.component.result.general.n r3 = (com.larus.camera.impl.ui.component.result.general.n) r1;
                MarkableImageFragment r4 = this.a;
                LarusItemPreviewMarkableImageBinding r5 = r4.h;
                if (r5 == null) goto L8;
                MarkableImageView r6 = r5.b;
                if (r6 == null) goto L8;
                r6.setMarkEnabled(r4.T90().shouldEnableMark());
            L8:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass5(MarkableImageFragment r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass5(this.this$0, r3);
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
            i1<com.larus.camera.impl.ui.component.result.general.n> r6 = this.this$0.T90().getResultDetectionStatus();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$6", f = "MarkableImageFragment.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MarkableImageView $this_apply;
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$6$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageView a;

            public a(MarkableImageView r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                Unit r3 = (Unit) r1;
                this.a.clear();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass6(MarkableImageFragment r1, MarkableImageView r2, Continuation<? super AnonymousClass6> r3) {
            this.this$0 = r1;
            this.$this_apply = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass6(this.this$0, this.$this_apply, r4);
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
            d1<Unit> r6 = this.this$0.T90().getClearMarkSelectDrawing();
            a r2 = new a(this.$this_apply);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$7", f = "MarkableImageFragment.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MarkableImageView $this_apply;
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$7$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageView a;

            public a(MarkableImageView r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                ((Number) r1).longValue();
                this.a.r();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass7(MarkableImageFragment r1, MarkableImageView r2, Continuation<? super AnonymousClass7> r3) {
            this.this$0 = r1;
            this.$this_apply = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass7(this.this$0, this.$this_apply, r4);
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
            i1<Long> r6 = this.this$0.T90().getUndoPaint();
            a r2 = new a(this.$this_apply);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$8", f = "MarkableImageFragment.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MarkableImageView $this_apply;
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$8$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageView a;

            public a(MarkableImageView r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                ((Number) r1).longValue();
                this.a.p();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass8(MarkableImageFragment r1, MarkableImageView r2, Continuation<? super AnonymousClass8> r3) {
            this.this$0 = r1;
            this.$this_apply = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass8(this.this$0, this.$this_apply, r4);
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
            i1<Long> r6 = this.this$0.T90().getRedoPaint();
            a r2 = new a(this.$this_apply);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$9", f = "MarkableImageFragment.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MarkableImageView $this_apply;
        int label;
        final /* synthetic */ MarkableImageFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.viewpager.MarkableImageFragment$setupMarkingFeatures$1$2$9$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MarkableImageFragment a;
            public final /* synthetic */ MarkableImageView b;

            public a(MarkableImageFragment r1, MarkableImageView r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r2, Continuation r3) {
                boolean r4 = ((Boolean) r2).booleanValue();
                if (((Boolean) this.a.T90().getEnableUndo().getValue()).booleanValue() == false) goto L5;
                this.a.T90().setImageHasBeenMarked(true);
            L5:
                if (r4 == false) goto L8;
                this.b.clear();
            L8:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass9(MarkableImageFragment r1, MarkableImageView r2, Continuation<? super AnonymousClass9> r3) {
            this.this$0 = r1;
            this.$this_apply = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass9(this.this$0, this.$this_apply, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            i1<Boolean> r7 = this.this$0.T90().isImageCropped();
            a r2 = new a(this.this$0, this.$this_apply);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public MarkableImageFragment$setupMarkingFeatures$1$2(MarkableImageFragment r1, MarkableImageView r2, Continuation<? super MarkableImageFragment$setupMarkingFeatures$1$2> r3) {
        this.this$0 = r1;
        this.$this_apply = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MarkableImageFragment$setupMarkingFeatures$1$2 r0 = new MarkableImageFragment$setupMarkingFeatures$1$2(this.this$0, this.$this_apply, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        FLogger.a.i(this.this$0.d, "[setupMarkingFeatures] Starting to collect flows");
        BuildersKt.launch$default(r9, null, null, new AnonymousClass1(this.$this_apply, this.this$0, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass2(this.$this_apply, this.this$0, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass3(this.$this_apply, this.this$0, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass4(this.this$0, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass5(this.this$0, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass6(this.this$0, this.$this_apply, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass7(this.this$0, this.$this_apply, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass8(this.this$0, this.$this_apply, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass9(this.this$0, this.$this_apply, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass10(this.this$0, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass11(this.this$0, this.$this_apply, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
