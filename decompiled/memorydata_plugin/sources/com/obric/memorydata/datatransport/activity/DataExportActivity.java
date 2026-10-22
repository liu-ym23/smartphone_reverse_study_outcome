package com.obric.memorydata.datatransport.activity;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.datatransport.api.DataTransportManagerApi;
import com.obric.memorydata.datatransport.manager.ExportFailureReason;
import com.obric.memorydata.datatransport.manager.ExportStatisticsSection;
import com.obric.memorydata.datatransport.manager.c;
import com.obric.memorydata.datatransport.manager.d;
import com.obric.memorydata.datatransport.manager.f;
import com.obric.memorydata.datatransport.manager.q;
import com.obric.memorydata.datatransport.manager.s;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.g;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.b;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0002J\u001e\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u000f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\b\u00101\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/memorydata/datatransport/activity/DataExportActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "btnExport", "Lcom/obric/oui/button/OButton;", "btnShare", "btnImport", "btnTestZip", "btnClean", "exportScrollView", "Landroid/widget/ScrollView;", "tvProgress", "Landroid/widget/TextView;", "exportStatisticsContainer", "Landroid/widget/LinearLayout;", "databaseStatisticsList", "attachmentStatisticsList", "tvExportStatisticsTitle", "tvExportWarnings", "viewTitle", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "currentUserId", "", "renderTaskState", "state", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState;", "setExportingUi", "exporting", "", "showExportOperationBusyToast", "renderProgressStatistics", "statistics", "Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "renderStatisticsRows", "container", "rows", "", "Lcom/obric/memorydata/datatransport/manager/ExportCategoryProgress;", "renderExportWarnings", "result", "Lcom/obric/memorydata/datatransport/manager/ExportResult;", "clearExportStatistics", "clearCurrentExportResult", "shareFile", "file", "Ljava/io/File;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataExportActivity extends BaseActivity {
    private LinearLayout attachmentStatisticsList;
    private OButton btnClean;
    private OButton btnExport;
    private OButton btnImport;
    private OButton btnShare;
    private OButton btnTestZip;
    private LinearLayout databaseStatisticsList;
    private ScrollView exportScrollView;
    private LinearLayout exportStatisticsContainer;
    private TextView tvExportStatisticsTitle;
    private TextView tvExportWarnings;
    private TextView tvProgress;
    private OFloatingTitleBar viewTitle;

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$1", f = "DataExportActivity.kt", i = {}, l = {96, 99}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DataExportActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$1$1", f = "DataExportActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C04691 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;

            C04691(Continuation<? super C04691> r3) {
                super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                return (Continuation) ZeusTransformUtils.preCheckCast(new C04691((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C04691) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C04691.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r1) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r1);
                c.f9761a.c();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onCreate$1$2", f = "DataExportActivity.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DataExportActivity this$0;

            AnonymousClass2(DataExportActivity r3, Continuation<? super AnonymousClass2> r4) {
                DataExportActivity r5 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataExportActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
                i r8 = k.b((i) ZeusTransformUtils.preCheckCast(c.f9761a.a(), i.class, "com.obric.memorydata.plugin"), 300);
                final DataExportActivity r4 = this.this$0;
                j r2 = (j) ZeusTransformUtils.preCheckCast(new C04701(r4), j.class, "com.obric.memorydata.plugin");
                Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r8.collect(r2, r3) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass1(DataExportActivity r3, Continuation<? super AnonymousClass1> r4) {
            DataExportActivity r5 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataExportActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
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
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
        L13:
            LifecycleOwner r9 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(this.this$0, LifecycleOwner.class, "com.obric.memorydata.plugin");
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r9, r2, r3, r4) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(new C04691(null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.i.a(r10, r5, r6) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.activity.DataExportActivity$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.datatransport.activity.DataExportActivity$onResume$1", f = "DataExportActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11041 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        C11041(Continuation<? super C11041> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11041((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11041) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11041.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r1);
            c.f9761a.c();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DataExportActivity() {
    }

    public static final /* synthetic */ void access$clearCurrentExportResult(DataExportActivity r2) {
        ((DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataExportActivity.class, "com.obric.memorydata.plugin")).clearCurrentExportResult();
    }

    public static final /* synthetic */ String access$currentUserId(DataExportActivity r2) {
        return ((DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataExportActivity.class, "com.obric.memorydata.plugin")).currentUserId();
    }

    public static final /* synthetic */ OButton access$getBtnClean$p(DataExportActivity r2) {
        return ((DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataExportActivity.class, "com.obric.memorydata.plugin")).btnClean;
    }

    public static final /* synthetic */ OButton access$getBtnImport$p(DataExportActivity r2) {
        return ((DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataExportActivity.class, "com.obric.memorydata.plugin")).btnImport;
    }

    public static final /* synthetic */ OButton access$getBtnTestZip$p(DataExportActivity r2) {
        return ((DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataExportActivity.class, "com.obric.memorydata.plugin")).btnTestZip;
    }

    public static final /* synthetic */ TextView access$getTvProgress$p(DataExportActivity r2) {
        return ((DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataExportActivity.class, "com.obric.memorydata.plugin")).tvProgress;
    }

    public static final /* synthetic */ void access$renderTaskState(DataExportActivity r2, f r3) {
        ((DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataExportActivity.class, "com.obric.memorydata.plugin")).renderTaskState(r3);
    }

    private final void clearCurrentExportResult() {
        OButton r0 = this.btnShare;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnShare");
        r0 = null;
    L5:
        r0.setVisibility(8);
        clearExportStatistics();
    }

    private final void clearExportStatistics() {
        LinearLayout r0 = this.databaseStatisticsList;
        TextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("databaseStatisticsList");
        r0 = null;
    L5:
        r0.removeAllViews();
        LinearLayout r2 = this.attachmentStatisticsList;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("attachmentStatisticsList");
        r2 = null;
    L8:
        r2.removeAllViews();
        LinearLayout r3 = this.exportStatisticsContainer;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("exportStatisticsContainer");
        r3 = null;
    L11:
        r3.setVisibility(8);
        TextView r4 = this.tvExportWarnings;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tvExportWarnings");
    L15:
        r1.setVisibility(8);
        return;
    L14:
        r1 = r4;
        goto L15
    }

    private final String currentUserId() {
        return AppContext.INSTANCE.getUserId();
    }

    public static /* synthetic */ void lambda$AZOVov8QPWUBTpI0JCn8KqMbn_w(DataExportActivity r0, View r1) {
        onCreate$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit lambda$AsbDcq0Wu6MmWRA2MGpwmywSFSk(DataExportActivity r0, DialogInterface r1, int r2) {
        return onCreate$lambda$5$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$ZE7rEIPLFDsysZJUhdrYF0tpLy8(DataExportActivity r0, View r1) {
        onCreate$lambda$3(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$b0Rt6OyWGpLqsNWzvTQWPqERX40(DataExportActivity r0, Map.Entry r1) {
        return renderStatisticsRows$lambda$9$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ void lambda$efkUghbpNU8T8pCp3twc8bnwxrg(DataExportActivity r0) {
        renderExportWarnings$lambda$10(r0);
    }

    public static /* synthetic */ void lambda$fM94JXLd6BPEAg1ZXtWpxd2wXTE(DataExportActivity r0, View r1) {
        onCreate$lambda$2(r0, r1);
    }

    public static /* synthetic */ void lambda$knCtSs2I6h4onRH4W6aWuY2wIDg(DataExportActivity r0, View r1) {
        onCreate$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$odbrZVaPMRmJ4-1c60jq9EXYzqA, reason: not valid java name */
    public static /* synthetic */ void m595lambda$odbrZVaPMRmJ41c60jq9EXYzqA(DataExportActivity r0, View r1) {
        onCreate$lambda$5(r0, r1);
    }

    private static final void onCreate$lambda$0(DataExportActivity r7, View r8) {
        DataExportActivity r9 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r7, DataExportActivity.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r9, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$2$1(r9, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    private static final void onCreate$lambda$1(DataExportActivity r9, View r10) {
        DataExportActivity r11 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r9, DataExportActivity.class, "com.obric.memorydata.plugin");
        f r12 = c.f9761a.a().c();
        if (ZeusTransformUtils.instanceOf(r12, f.e.class) == false) goto L5;
        f.e r13 = (f.e) ZeusTransformUtils.preCheckCast(r12, f.e.class, "com.obric.memorydata.plugin");
    L6:
        if (r13 == null) goto L10;
        s r1 = r13.b();
        if (r1 == null) goto L10;
        File r2 = r1.a();
    L11:
        if (r13 == null) goto L15;
        d r14 = r13.a();
        if (r14 == null) goto L15;
        String r15 = r14.b();
    L17:
        if (Intrinsics.areEqual(r15, r11.currentUserId()) == false) goto L28;
        boolean r16 = true;
        if (r2 != null) goto L21;
    L23:
        r16 = false;
    L24:
        if (r16 == false) goto L28;
        if (r2.length() <= 0) goto L28;
        r11.shareFile(r2);
        return;
    L21:
        if (r2.isFile() != true) goto L23;
    L28:
        r11.clearCurrentExportResult();
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r11, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$3$1(null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    L15:
        r15 = null;
    L10:
        r2 = null;
        goto L11
    L5:
        r13 = null;
        goto L6
    }

    private static final void onCreate$lambda$2(DataExportActivity r7, View r8) {
        DataExportActivity r9 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r7, DataExportActivity.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r9, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$4$1(r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final void onCreate$lambda$3(DataExportActivity r7, View r8) {
        DataExportActivity r9 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r7, DataExportActivity.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r9, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$5$1(r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final void onCreate$lambda$5(DataExportActivity r11, View r12) {
        final DataExportActivity r13 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r11, DataExportActivity.class, "com.obric.memorydata.plugin");
        if (c.f9761a.b() == false) goto L6;
        r13.showExportOperationBusyToast();
        return;
    L6:
        b r14 = b.a(new b((Context) ZeusTransformUtils.preCheckCast(r13, Context.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_clean_confirm_title, TypedValues.Custom.S_STRING, "data_transport_data_export_clean_confirm_title")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_clean_confirm_message, TypedValues.Custom.S_STRING, "data_transport_data_export_clean_confirm_message")), CharSequence.class, "com.obric.memorydata.plugin"));
        String r1 = r13.getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_clean_action, TypedValues.Custom.S_STRING, "data_transport_data_export_clean_action"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        b r5 = r14.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$DataExportActivity$AsbDcq0Wu6MmWRA2MGpwmywSFSk(r13));
        String r15 = r13.getString(ZeusTransformUtils.mapRes(R.string.data_transport_cancel, TypedValues.Custom.S_STRING, "data_transport_cancel"));
        Intrinsics.checkNotNullExpressionValue(r15, "getString(...)");
        b.b(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 4, null).h();
    }

    private static final Unit onCreate$lambda$5$lambda$4(DataExportActivity r7, DialogInterface r8, int r9) {
        DataExportActivity r10 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r7, DataExportActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.class, "com.obric.memorydata.plugin"), "<unused var>");
        if (c.f9761a.b() == false) goto L7;
        r10.showExportOperationBusyToast();
    L6:
        return Unit.INSTANCE;
    L7:
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r10, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new DataExportActivity$onCreate$6$1$1(r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L6
    }

    private final void renderExportWarnings(s r9) {
        TextView r0 = this.tvExportWarnings;
        ScrollView r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tvExportWarnings");
        r0 = null;
    L6:
        if (r9.e().isEmpty() == false) goto L8;
        int r3 = 8;
    L9:
        r0.setVisibility(r3);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9.e(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        TextView r1 = this.tvExportWarnings;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tvExportWarnings");
        r1 = null;
    L14:
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_export_partial_warning, TypedValues.Custom.S_STRING, "data_transport_export_partial_warning"), new Object[]{Integer.valueOf(r9.e().size())}), CharSequence.class, "com.obric.memorydata.plugin"));
    L15:
        ScrollView r10 = this.exportScrollView;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("exportScrollView");
    L19:
        r2.post(new $$Lambda$DataExportActivity$efkUghbpNU8T8pCp3twc8bnwxrg(this));
        return;
    L18:
        r2 = r10;
        goto L19
    L8:
        r3 = 0;
        goto L9
    }

    private static final void renderExportWarnings$lambda$10(DataExportActivity r4) {
        DataExportActivity r5 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r4, DataExportActivity.class, "com.obric.memorydata.plugin");
        int r0 = (int) (16 * ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        OButton r1 = r5.btnExport;
        ScrollView r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnExport");
        r1 = null;
    L5:
        int r3 = r1.getTop();
        OFloatingTitleBar r6 = r5.viewTitle;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewTitle");
        r6 = null;
    L8:
        int r7 = RangesKt.coerceAtLeast((r3 - r6.getHeight()) - r0, 0);
        ScrollView r8 = r5.exportScrollView;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("exportScrollView");
    L12:
        r2.smoothScrollTo(0, r7);
        return;
    L11:
        r2 = r8;
        goto L12
    }

    private final void renderProgressStatistics(q r4) {
        LinearLayout r0 = this.databaseStatisticsList;
        LinearLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("databaseStatisticsList");
        r0 = null;
    L5:
        renderStatisticsRows(r0, r4.a(ExportStatisticsSection.DATA_TABLE));
        LinearLayout r2 = this.attachmentStatisticsList;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("attachmentStatisticsList");
        r2 = null;
    L8:
        renderStatisticsRows(r2, r4.a(ExportStatisticsSection.ATTACHMENT));
        TextView r5 = this.tvExportWarnings;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tvExportWarnings");
        r5 = null;
    L11:
        r5.setVisibility(8);
        LinearLayout r3 = this.exportStatisticsContainer;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("exportStatisticsContainer");
    L15:
        r1.setVisibility(0);
        return;
    L14:
        r1 = r3;
        goto L15
    }

    private final void renderStatisticsRows(LinearLayout r18, List<com.obric.memorydata.datatransport.manager.k> r19) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        r18.removeAllViews();
        NumberFormat r4 = NumberFormat.getIntegerInstance();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L15;
        com.obric.memorydata.datatransport.manager.k r5 = (com.obric.memorydata.datatransport.manager.k) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.datatransport.manager.k.class, "com.obric.memorydata.plugin");
        int r9 = 0;
        View r6 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.item_export_statistics_row, "layout", "item_export_statistics_row"), (ViewGroup) ZeusTransformUtils.preCheckCast(r18, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        ((TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tvCategory, OaidModel.KEY_ID, "tvCategory")), TextView.class, "com.obric.memorydata.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(r5.a().getLabelRes()), CharSequence.class, "com.obric.memorydata.plugin"));
        ((TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tvScanned, OaidModel.KEY_ID, "tvScanned")), TextView.class, "com.obric.memorydata.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.format(r5.b()), CharSequence.class, "com.obric.memorydata.plugin"));
        ((TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tvSuccess, OaidModel.KEY_ID, "tvSuccess")), TextView.class, "com.obric.memorydata.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.format(r5.c()), CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tvFailure, OaidModel.KEY_ID, "tvFailure")), TextView.class, "com.obric.memorydata.plugin");
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.format(r5.d()), CharSequence.class, "com.obric.memorydata.plugin"));
        if (r5.d() <= 0) goto L11;
        TextView r10 = this.tvExportWarnings;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tvExportWarnings");
        r10 = null;
    L10:
        r7.setTextColor(r10.getCurrentTextColor());
    L11:
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tvFailureReasons, OaidModel.KEY_ID, "tvFailureReasons")), TextView.class, "com.obric.memorydata.plugin");
        if (r5.e().isEmpty() == false) goto L14;
        r9 = 8;
    L14:
        r8.setVisibility(r9);
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r5.e().entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, new $$Lambda$DataExportActivity$b0Rt6OyWGpLqsNWzvTQWPqERX40(this), 30, null), CharSequence.class, "com.obric.memorydata.plugin"));
        r18.addView(r6);
        goto L4
    }

    private static final CharSequence renderStatisticsRows$lambda$9$lambda$8$lambda$7(DataExportActivity r6, Map.Entry r7) {
        DataExportActivity r8 = (DataExportActivity) ZeusTransformUtils.wrapperContextForParams(r6, DataExportActivity.class, "com.obric.memorydata.plugin");
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r7, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<destruct>");
        ExportFailureReason r0 = (ExportFailureReason) ZeusTransformUtils.preCheckCast(r9.getKey(), ExportFailureReason.class, "com.obric.memorydata.plugin");
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r9.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
        String r10 = r8.getString(ZeusTransformUtils.mapRes(R.string.data_transport_export_failure_item, TypedValues.Custom.S_STRING, "data_transport_export_failure_item"), new Object[]{r8.getString(r0.getLabelRes()), Long.valueOf(r2)});
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final void renderTaskState(f r8) {
        OButton r3 = null;
        TextView r4 = null;
        OButton r5 = null;
        OButton r6 = null;
        OButton r7 = null;
        if (Intrinsics.areEqual(r8, f.b.f9769a) == false) goto L10;
        setExportingUi(false);
        TextView r9 = this.tvProgress;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
    L8:
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        clearCurrentExportResult();
        return;
    L7:
        r4 = r9;
        goto L8
    L10:
        if (ZeusTransformUtils.instanceOf(r8, f.d.class) == false) goto L21;
        setExportingUi(true);
        TextView r0 = this.tvProgress;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
        r0 = null;
    L14:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(((f.d) ZeusTransformUtils.preCheckCast(r8, f.d.class, "com.obric.memorydata.plugin")).a().d(), CharSequence.class, "com.obric.memorydata.plugin"));
        OButton r1 = this.btnShare;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("btnShare");
    L18:
        r5.setVisibility(8);
        d r10 = ((f.d) ZeusTransformUtils.preCheckCast(r8, f.d.class, "com.obric.memorydata.plugin")).a();
    L19:
        renderProgressStatistics(r10.k());
        return;
    L17:
        r5 = r1;
        goto L18
    L21:
        if (ZeusTransformUtils.instanceOf(r8, f.e.class) == false) goto L31;
        setExportingUi(false);
        TextView r2 = this.tvProgress;
        if (r2 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
        r2 = null;
    L25:
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(((f.e) ZeusTransformUtils.preCheckCast(r8, f.e.class, "com.obric.memorydata.plugin")).a().d(), CharSequence.class, "com.obric.memorydata.plugin"));
        OButton r11 = this.btnShare;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("btnShare");
    L29:
        r6.setVisibility(0);
        renderProgressStatistics(((f.e) ZeusTransformUtils.preCheckCast(r8, f.e.class, "com.obric.memorydata.plugin")).b().f());
        renderExportWarnings(((f.e) ZeusTransformUtils.preCheckCast(r8, f.e.class, "com.obric.memorydata.plugin")).b());
        return;
    L28:
        r6 = r11;
        goto L29
    L31:
        if (ZeusTransformUtils.instanceOf(r8, f.a.class) == false) goto L41;
        setExportingUi(false);
        TextView r12 = this.tvProgress;
        if (r12 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
        r12 = null;
    L35:
        r12.setText((CharSequence) ZeusTransformUtils.preCheckCast(((f.a) ZeusTransformUtils.preCheckCast(r8, f.a.class, "com.obric.memorydata.plugin")).b(), CharSequence.class, "com.obric.memorydata.plugin"));
        OButton r13 = this.btnShare;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("btnShare");
    L39:
        r7.setVisibility(8);
        r10 = ((f.a) ZeusTransformUtils.preCheckCast(r8, f.a.class, "com.obric.memorydata.plugin")).a();
        goto L19
    L38:
        r7 = r13;
        goto L39
    L41:
        if (ZeusTransformUtils.instanceOf(r8, f.c.class) == false) goto L52;
        setExportingUi(false);
        TextView r14 = this.tvProgress;
        if (r14 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
        r14 = null;
    L45:
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(((f.c) ZeusTransformUtils.preCheckCast(r8, f.c.class, "com.obric.memorydata.plugin")).b(), CharSequence.class, "com.obric.memorydata.plugin"));
        OButton r15 = this.btnShare;
        if (r15 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("btnShare");
    L49:
        r3.setVisibility(8);
        r10 = ((f.c) ZeusTransformUtils.preCheckCast(r8, f.c.class, "com.obric.memorydata.plugin")).a();
        goto L19
    L48:
        r3 = r15;
        goto L49
    L52:
        throw new NoWhenBranchMatchedException();
    }

    private final void setExportingUi(boolean r7) {
        OButton r0 = this.btnExport;
        TextView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnExport");
        r0 = null;
    L5:
        r0.setEnabled(!r7);
        OButton r1 = this.btnClean;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnClean");
        r1 = null;
    L8:
        r1.setEnabled(!r7);
        OButton r3 = this.btnImport;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("btnImport");
        r3 = null;
    L11:
        r3.setEnabled(!r7);
        OButton r4 = this.btnTestZip;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("btnTestZip");
        r4 = null;
    L14:
        r4.setEnabled(!r7);
        OButton r5 = this.btnExport;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("btnExport");
        r5 = null;
    L17:
        float r6 = 0.5f;
        if (r7 == false) goto L20;
        float r8 = 0.5f;
    L21:
        r5.setAlpha(r8);
        OButton r9 = this.btnClean;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("btnClean");
        r9 = null;
    L24:
        if (r7 == true) goto L27;
        r6 = 1.0f;
    L27:
        r9.setAlpha(r6);
        if (r7 == false) goto L35;
        TextView r10 = this.tvProgress;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
    L33:
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_starting, TypedValues.Custom.S_STRING, "data_transport_data_export_starting")), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L32:
        r2 = r10;
        goto L33
    L35:
        return;
    L20:
        r8 = 1.0f;
        goto L21
    }

    private final void shareFile(File r8) {
        Uri r3 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.fileprovider", r8, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Intent r4 = new Intent("android.intent.action.SEND");     // Catch: Exception -> L5
        r4.setType("application/octet-stream");     // Catch: Exception -> L5
        r4.putExtra("android.intent.extra.STREAM", (Parcelable) ZeusTransformUtils.preCheckCast(r3, Parcelable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L5
        r4.setClipData(ClipData.newRawUri((CharSequence) ZeusTransformUtils.preCheckCast(r8.getName(), CharSequence.class, "com.obric.memorydata.plugin"), r3));     // Catch: Exception -> L5
        r4.addFlags(1);     // Catch: Exception -> L5
        ZeusTransformUtils.startActivity(this, Intent.createChooser(r4, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_share_chooser, TypedValues.Custom.S_STRING, "data_transport_data_export_share_chooser")), CharSequence.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r7 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_share_failed, TypedValues.Custom.S_STRING, "data_transport_data_export_share_failed"), new Object[]{e.getMessage()});
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        com.obric.memorydata.utils.ba.a(r1, r7, 0);
    }

    private final void showExportOperationBusyToast() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r4 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_operation_busy, TypedValues.Custom.S_STRING, "data_transport_data_export_operation_busy"));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        com.obric.memorydata.utils.ba.a(r0, r4, 0);
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r21) {
        super.onCreate(r21);
        getWindow().addFlags(128);
        DataTransportManagerApi r1 = com.obric.memorydata.datatransport.api.c.a();
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        finish();
        return;
    L11:
        prepareSystemBar();
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_export_data, "layout", "activity_export_data"));
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(...)");
        this.viewTitle = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r3, OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.btnExport, OaidModel.KEY_ID, "btnExport"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(...)");
        this.btnExport = (OButton) ZeusTransformUtils.preCheckCast(r4, OButton.class, "com.obric.memorydata.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.btnShare, OaidModel.KEY_ID, "btnShare"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(...)");
        this.btnShare = (OButton) ZeusTransformUtils.preCheckCast(r5, OButton.class, "com.obric.memorydata.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.btnImport, OaidModel.KEY_ID, "btnImport"));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(...)");
        this.btnImport = (OButton) ZeusTransformUtils.preCheckCast(r6, OButton.class, "com.obric.memorydata.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.btnTestZip, OaidModel.KEY_ID, "btnTestZip"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(...)");
        this.btnTestZip = (OButton) ZeusTransformUtils.preCheckCast(r7, OButton.class, "com.obric.memorydata.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.btnClean, OaidModel.KEY_ID, "btnClean"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(...)");
        this.btnClean = (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.exportScrollView, OaidModel.KEY_ID, "exportScrollView"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(...)");
        ScrollView r10 = (ScrollView) ZeusTransformUtils.preCheckCast(r9, ScrollView.class, "com.obric.memorydata.plugin");
        this.exportScrollView = r10;
        OButton r13 = null;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("exportScrollView");
        r10 = null;
    L14:
        g.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.tvProgress, OaidModel.KEY_ID, "tvProgress"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(...)");
        this.tvProgress = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.exportStatisticsContainer, OaidModel.KEY_ID, "exportStatisticsContainer"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(...)");
        this.exportStatisticsContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.memorydata.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.databaseStatisticsList, OaidModel.KEY_ID, "databaseStatisticsList"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(...)");
        this.databaseStatisticsList = (LinearLayout) ZeusTransformUtils.preCheckCast(r14, LinearLayout.class, "com.obric.memorydata.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.attachmentStatisticsList, OaidModel.KEY_ID, "attachmentStatisticsList"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(...)");
        this.attachmentStatisticsList = (LinearLayout) ZeusTransformUtils.preCheckCast(r15, LinearLayout.class, "com.obric.memorydata.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.tvExportStatisticsTitle, OaidModel.KEY_ID, "tvExportStatisticsTitle"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(...)");
        this.tvExportStatisticsTitle = (TextView) ZeusTransformUtils.preCheckCast(r16, TextView.class, "com.obric.memorydata.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.tvExportWarnings, OaidModel.KEY_ID, "tvExportWarnings"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(...)");
        this.tvExportWarnings = (TextView) ZeusTransformUtils.preCheckCast(r17, TextView.class, "com.obric.memorydata.plugin");
        OFloatingTitleBar r18 = this.viewTitle;
        if (r18 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewTitle");
        r18 = null;
    L17:
        ScrollView r19 = this.exportScrollView;
        if (r19 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("exportScrollView");
        r19 = null;
    L20:
        setupTitleBarBackAction(r18, (View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.memorydata.plugin"), (int) (16 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density), findViewById(ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off")));
        if (EvaluationService.INSTANCE.isCqcEvaluationMode() == false) goto L23;
        Context r20 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r22 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_data_export_cqc_mode, TypedValues.Custom.S_STRING, "data_transport_data_export_cqc_mode"));
        Intrinsics.checkNotNullExpressionValue(r22, "getString(...)");
        com.obric.memorydata.utils.ba.a(r20, r22, 0);
    L23:
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        OButton r23 = this.btnExport;
        if (r23 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("btnExport");
        r23 = null;
    L26:
        r23.setOnClickListener(new $$Lambda$DataExportActivity$knCtSs2I6h4onRH4W6aWuY2wIDg(this));
        OButton r24 = this.btnShare;
        if (r24 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("btnShare");
        r24 = null;
    L29:
        r24.setOnClickListener(new $$Lambda$DataExportActivity$AZOVov8QPWUBTpI0JCn8KqMbn_w(this));
        OButton r25 = this.btnImport;
        if (r25 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("btnImport");
        r25 = null;
    L32:
        r25.setOnClickListener(new $$Lambda$DataExportActivity$fM94JXLd6BPEAg1ZXtWpxd2wXTE(this));
        OButton r26 = this.btnTestZip;
        if (r26 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("btnTestZip");
        r26 = null;
    L35:
        r26.setOnClickListener(new $$Lambda$DataExportActivity$ZE7rEIPLFDsysZJUhdrYF0tpLy8(this));
        OButton r27 = this.btnClean;
        if (r27 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("btnClean");
    L39:
        r13.setOnClickListener(new $$Lambda$DataExportActivity$odbrZVaPMRmJ41c60jq9EXYzqA(this));
        return;
    L38:
        r13 = r27;
        goto L39
    L5:
        if (r1.isDataExportEntryEnabled() != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(128);
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        renderTaskState(com.obric.memorydata.datatransport.manager.g.a((f) ZeusTransformUtils.preCheckCast(c.f9761a.a().c(), f.class, "com.obric.memorydata.plugin"), currentUserId()));
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11041(null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }
}
