package com.obric.memorydata.datatransport.activity;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.obric.memorydata.datatransport.api.d;
import com.obric.memorydata.datatransport.utils.j;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1", f = "DataExportActivity.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
final class DataExportActivity$onCreate$5$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DataExportActivity this$0;

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1$1", f = "DataExportActivity.kt", i = {}, l = {187, 187, 187}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DataExportActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1$1$2", f = "DataExportActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ File $destFile;
            int label;
            final /* synthetic */ DataExportActivity this$0;

            AnonymousClass2(DataExportActivity r3, File r4, Continuation<? super AnonymousClass2> r5) {
                DataExportActivity r6 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataExportActivity.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r6;
                this.$destFile = r4;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$destFile, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r7) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r7);
                TextView r8 = DataExportActivity.access$getTvProgress$p(this.this$0);
                if (r8 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
                r8 = null;
            L7:
                r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_zip_test_done, TypedValues.Custom.S_STRING, "data_transport_data_export_zip_test_done"), new Object[]{this.$destFile.getAbsolutePath()}), CharSequence.class, "com.obric.memorydata.plugin"));
                Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_zip_test_done_toast, TypedValues.Custom.S_STRING, "data_transport_data_export_zip_test_done_toast")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1$1$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1$1$3", f = "DataExportActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ DataExportActivity this$0;

            AnonymousClass3(DataExportActivity r3, Exception r4, Continuation<? super AnonymousClass3> r5) {
                DataExportActivity r6 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataExportActivity.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r6;
                this.$e = r4;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, this.$e, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r5);
                TextView r6 = DataExportActivity.access$getTvProgress$p(this.this$0);
                if (r6 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
                r6 = null;
            L7:
                r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_zip_test_failed, TypedValues.Custom.S_STRING, "data_transport_data_export_zip_test_failed"), new Object[]{this.$e.getMessage()}), CharSequence.class, "com.obric.memorydata.plugin"));
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1$1$4, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$5$1$1$4", f = "DataExportActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DataExportActivity this$0;

            AnonymousClass4(DataExportActivity r3, Continuation<? super AnonymousClass4> r4) {
                DataExportActivity r5 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataExportActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r2);
                OButton r1 = DataExportActivity.access$getBtnTestZip$p(this.this$0);
                if (r1 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("btnTestZip");
                r1 = null;
            L7:
                r1.setEnabled(true);
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(DataExportActivity r3, Continuation<? super AnonymousClass1> r4) {
            DataExportActivity r5 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataExportActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        private static final Unit invokeSuspend$lambda$0(DataExportActivity r15, long r16, long r18) {
            DataExportActivity r1 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r15, DataExportActivity.class, "com.obric.memorydata.plugin");
            if (r18 <= 0) goto L5;
            int r0 = (int) ((((long) 100) * r16) / r18);
        L6:
            int r2 = r0;
            i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r1, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$5$1$1$1$1(r1, r2, r16, r18, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
            return Unit.INSTANCE;
        L5:
            r0 = 0;
            goto L6
        }

        public static /* synthetic */ Unit lambda$VU5tmxoF8bxzC1zck0AqteJq0zk(DataExportActivity r0, long r1, long r3) {
            return invokeSuspend$lambda$0(r0, r1, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L10;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L8;
            Throwable r13 = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);
            throw r13;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r14);
        L27:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r14);
            File r2 = d.f9726a.a();     // Catch: Throwable -> L19 Exception -> L21
            if (r2.exists() == true) goto L15;
            r2.mkdirs();     // Catch: Throwable -> L19 Exception -> L21
        L15:
            File r6 = new File(r2.getParentFile(), "test_zip_" + System.currentTimeMillis() + ".zip");     // Catch: Throwable -> L19 Exception -> L21
            j r7 = j.f9845a;     // Catch: Throwable -> L19 Exception -> L21
            final DataExportActivity r8 = this.this$0;     // Catch: Throwable -> L19 Exception -> L21
            r7.a(r2, r6, new $$Lambda$DataExportActivity$onCreate$5$1$1$VU5tmxoF8bxzC1zck0AqteJq0zk(r8));     // Catch: Throwable -> L19 Exception -> L21
            i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this.this$0, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r6, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);     // Catch: Throwable -> L19 Exception -> L21
            CoroutineContext r3 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r15 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (i.a(r3, r15, r4) != r0) goto L27;
            return r0;
        L21:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L19
            i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this.this$0, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, e, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);     // Catch: Throwable -> L19
            CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (i.a(r5, r16, r9) != r0) goto L27;
            return r0;
        L19:
            th = move-exception;
            CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r17 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = th;
            this.label = 3;
            if (i.a(r10, r17, r11) != r0) goto L32;
            return r0;
        L32:
            throw th;
        }
    }

    DataExportActivity$onCreate$5$1(DataExportActivity r3, Continuation<? super DataExportActivity$onCreate$5$1> r4) {
        DataExportActivity r5 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataExportActivity.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$5$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DataExportActivity$onCreate$5$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DataExportActivity$onCreate$5$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        OButton r9 = DataExportActivity.access$getBtnTestZip$p(this.this$0);
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("btnTestZip");
        r9 = null;
    L11:
        r9.setEnabled(false);
        TextView r10 = DataExportActivity.access$getTvProgress$p(this.this$0);
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
        r10 = null;
    L14:
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_zip_test_start, TypedValues.Custom.S_STRING, "data_transport_data_export_zip_test_start")), CharSequence.class, "com.obric.memorydata.plugin"));
        CoroutineContext r11 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (i.a(r11, r2, r3) != r0) goto L18;
        return r0;
    }
}
