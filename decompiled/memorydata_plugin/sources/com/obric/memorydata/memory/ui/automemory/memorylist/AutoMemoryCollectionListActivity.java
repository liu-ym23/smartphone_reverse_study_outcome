package com.obric.memorydata.memory.ui.automemory.memorylist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.entity.y;
import com.obric.memorydata.datatransport.api.DataTransportManagerApi;
import com.obric.memorydata.memory.databinding.ActivityAutoMemoryCollectionListBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryDetailActivity;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsActivity;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.migration.sdk.z;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ba;
import com.obric.memorydata.utils.bb;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0014H\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\u0018\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000fH\u0002J\b\u0010/\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020\u001dH\u0014J\u0018\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0014H\u0002J\b\u00104\u001a\u00020\u001dH\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u001d2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u0019H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionListActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "viewModel", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionListViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityAutoMemoryCollectionListBinding;", "adapter", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailAdapter;", "systemBottomInset", "", "pendingRelocateItemId", "", "Ljava/lang/Long;", "shouldRefreshOnResume", "", "currentItemOperationPopover", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopover;", "normalTitle", "", "selectedItemCount", "isAllSelected", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "setupTitleBars", "showCollectionOperationMenu", "anchor", "Landroid/view/View;", "finishAfterCollectionDeleted", "setupRecyclerView", "setupBottomActionBar", "observeState", "updateRecyclerViewBottomPadding", "isSelectionMode", "relocateToPendingItemIfNeeded", "isPendingItemFullyVisible", "layoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "adapterPosition", "onBackPressed", "onResumeChecked", "applyTitleBarState", "selectionMode", "animate", "exitSelectionMode", "showFeedbackSheet", "item", "Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "exportAutoMemoryBuildPackage", "shareBuildMemoryPreview", Params.FILE_PATH, "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryCollectionListActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private static final String TAG = null;
    private com.obric.memorydata.memory.ui.automemory.memorylist.a adapter;
    private ActivityAutoMemoryCollectionListBinding binding;
    private WeakReference<com.obric.oui.popover.v2.a> currentItemOperationPopover;
    private boolean isAllSelected;
    private String normalTitle;
    private Long pendingRelocateItemId;
    private int selectedItemCount;
    private boolean shouldRefreshOnResume;
    private int systemBottomInset;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionListActivity$Companion;", "", "<init>", "()V", "TAG", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "collectionId", "", "title", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3, long r4, String r6) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r6, "title");
            Intent r5 = new Intent(r2, AutoMemoryCollectionListActivity.class);
            r5.putExtra("extra_collection_id", r4);
            r5.putExtra("extra_title", r6);
            if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L5;
            r5.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements kotlinx.coroutines.flow.i<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10686a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f10687a;

            public AnonymousClass1(j r3) {
                this.f10687a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, AutoMemoryCollectionListActivity$observeState$$inlined$map$1$2$1.class) == false) goto L7;
                AutoMemoryCollectionListActivity$observeState$$inlined$map$1$2$1 r0 = (AutoMemoryCollectionListActivity$observeState$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r8, AutoMemoryCollectionListActivity$observeState$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                j r5 = this.f10687a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Boolean r11 = Boxing.boxBoolean(((com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin")).d());
                r0.label = 1;
                if (r5.emit(r11, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new AutoMemoryCollectionListActivity$observeState$$inlined$map$1$2$1(this, r8);
                goto L8
            }
        }

        public b(kotlinx.coroutines.flow.i r3) {
            this.f10686a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super Boolean> r3, Continuation r4) {
            j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10686a.collect((j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<Pair<? extends Set<? extends Long>, ? extends Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10688a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f10689a;

            public AnonymousClass1(j r3) {
                this.f10689a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, AutoMemoryCollectionListActivity$observeState$$inlined$map$2$2$1.class) == false) goto L7;
                AutoMemoryCollectionListActivity$observeState$$inlined$map$2$2$1 r0 = (AutoMemoryCollectionListActivity$observeState$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r8, AutoMemoryCollectionListActivity$observeState$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                j r5 = this.f10689a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                com.obric.memorydata.memory.ui.automemory.memorylist.d r11 = (com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin");
                Pair r12 = TuplesKt.to(r11.e(), Boxing.boxBoolean(r11.f()));
                r0.label = 1;
                if (r5.emit(r12, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new AutoMemoryCollectionListActivity$observeState$$inlined$map$2$2$1(this, r8);
                goto L8
            }
        }

        public c(kotlinx.coroutines.flow.i r3) {
            this.f10688a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super Pair<? extends Set<? extends Long>, ? extends Boolean>> r3, Continuation r4) {
            j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10688a.collect((j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements kotlinx.coroutines.flow.i<Pair<? extends Boolean, ? extends Set<? extends Long>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10690a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$d$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f10691a;

            public AnonymousClass1(j r3) {
                this.f10691a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, AutoMemoryCollectionListActivity$observeState$$inlined$map$3$2$1.class) == false) goto L7;
                AutoMemoryCollectionListActivity$observeState$$inlined$map$3$2$1 r0 = (AutoMemoryCollectionListActivity$observeState$$inlined$map$3$2$1) ZeusTransformUtils.preCheckCast(r8, AutoMemoryCollectionListActivity$observeState$$inlined$map$3$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                j r5 = this.f10691a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                com.obric.memorydata.memory.ui.automemory.memorylist.d r11 = (com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin");
                Pair r12 = TuplesKt.to(Boxing.boxBoolean(r11.d()), r11.e());
                r0.label = 1;
                if (r5.emit(r12, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new AutoMemoryCollectionListActivity$observeState$$inlined$map$3$2$1(this, r8);
                goto L8
            }
        }

        public d(kotlinx.coroutines.flow.i r3) {
            this.f10690a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super Pair<? extends Boolean, ? extends Set<? extends Long>>> r3, Continuation r4) {
            j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10690a.collect((j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2", f = "AutoMemoryCollectionListActivity.kt", i = {}, l = {BDAbstractUpload.KeyIsRetryStatesOption}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ y $item;
        int label;
        final /* synthetic */ AutoMemoryCollectionListActivity this$0;

        AnonymousClass2(AutoMemoryCollectionListActivity r3, y r4, Continuation<? super AnonymousClass2> r5) {
            AutoMemoryCollectionListActivity r6 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$item = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$item, r5), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L15;
            if (r1 != 1) goto L14;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L19:
            z r14 = (z) ZeusTransformUtils.preCheckCast(r13, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            AutoMemoryCollectionListActivity.access$getViewModel(this.this$0).markBuildPackageExportFinished();
            if (this.this$0.isFinishing() == true) goto L36;
            if (this.this$0.isDestroyed() == true) goto L36;
            if (ZeusTransformUtils.instanceOf(r14, z.b.class) == false) goto L29;
            AutoMemoryCollectionListActivity r12 = this.this$0;
            String r15 = ((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r14, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(r15, "getAbsolutePath(...)");
            AutoMemoryCollectionListActivity.access$shareBuildMemoryPreview(r12, r15);
        L32:
            return Unit.INSTANCE;
        L29:
            if (ZeusTransformUtils.instanceOf(r14, z.a.class) == false) goto L34;
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin");
            String r16 = this.this$0.getString(ZeusTransformUtils.mapRes(R.string.memory_auto_memory_build_package_export_failed, TypedValues.Custom.S_STRING, "memory_auto_memory_build_package_export_failed"), new Object[]{((z.a) ZeusTransformUtils.preCheckCast(r14, z.a.class, "com.obric.memorydata.plugin")).a().b()});
            Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");
            ba.a(r2, r16, 0, 4, null);
            goto L32
        L34:
            throw new NoWhenBranchMatchedException();
        L36:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r13);
            CoroutineContext r17 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2$exportResult$1(this.$item, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            this.label = 1;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            r13 = kotlinx.coroutines.i.a(r17, r3, r10);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r13 != r0) goto L19;
            return r0;
        L7:
            th = move-exception;
            AutoMemoryCollectionListActivity.access$getViewModel(this.this$0).markBuildPackageExportFinished();
            throw th;
        L11:
            e = move-exception;
            throw e;     // Catch: Throwable -> L7
        L9:
            e = move-exception;
            RunLog.INSTANCE.error(AutoMemoryCollectionListActivity.access$getTAG$cp(), "exportAutoMemoryPreview failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
            if (this.this$0.isFinishing() == false) goto L40;
        L45:
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L7
            AutoMemoryCollectionListActivity.access$getViewModel(this.this$0).markBuildPackageExportFinished();
            return r18;
        L40:
            if (this.this$0.isDestroyed() == true) goto L45;
            Context r4 = (Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            AutoMemoryCollectionListActivity r5 = this.this$0;     // Catch: Throwable -> L7
            int r6 = ZeusTransformUtils.mapRes(R.string.memory_auto_memory_build_package_export_failed, TypedValues.Custom.S_STRING, "memory_auto_memory_build_package_export_failed");     // Catch: Throwable -> L7
            Object[] r7 = new Object[1];     // Catch: Throwable -> L7
            String r19 = e.getMessage();     // Catch: Throwable -> L7
            if (r19 != null) goto L44;
            r19 = "";
        L44:
            r7[0] = r19;     // Catch: Throwable -> L7
            String r110 = r5.getString(r6, r7);     // Catch: Throwable -> L7
            Intrinsics.checkNotNullExpressionValue(r110, "getString(...)");     // Catch: Throwable -> L7
            ba.a(r4, r110, 0, 4, null);     // Catch: Throwable -> L7
            goto L45
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$observeState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isSelectionMode", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$observeState$2", f = "AutoMemoryCollectionListActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11282 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ AutoMemoryCollectionListActivity this$0;

        C11282(AutoMemoryCollectionListActivity r3, Continuation<? super C11282> r4) {
            AutoMemoryCollectionListActivity r5 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            C11282 r0 = new C11282(this.this$0, r5);
            r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
            return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
            Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return ((C11282) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), C11282.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r3);
            boolean r4 = this.Z$0;
            AutoMemoryCollectionListActivity.access$applyTitleBarState(this.this$0, r4, true);
            ActivityAutoMemoryCollectionListBinding r0 = AutoMemoryCollectionListActivity.access$getBinding$p(this.this$0);
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r0 = null;
        L7:
            OBottomActionBarFloating r1 = r0.bottomActionBar;
            if (r4 == false) goto L10;
            int r2 = 0;
        L11:
            r1.setVisibility(r2);
            AutoMemoryCollectionListActivity.access$updateRecyclerViewBottomPadding(this.this$0, r4);
            return Unit.INSTANCE;
        L10:
            r2 = 8;
            goto L11
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$observeState$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", "", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$observeState$4", f = "AutoMemoryCollectionListActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<Pair<? extends Set<? extends Long>, ? extends Boolean>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AutoMemoryCollectionListActivity this$0;

        AnonymousClass4(AutoMemoryCollectionListActivity r3, Continuation<? super AnonymousClass4> r4) {
            AutoMemoryCollectionListActivity r5 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass4 r0 = new AnonymousClass4(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Pair<? extends Set<? extends Long>, ? extends Boolean> r3, Continuation<? super Unit> r4) {
            return invoke2((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Pair<? extends Set<Long>, Boolean> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r5);
            Pair r6 = (Pair) ZeusTransformUtils.preCheckCast(this.L$0, Pair.class, "com.obric.memorydata.plugin");
            Set r0 = (Set) ZeusTransformUtils.preCheckCast(r6.component1(), Set.class, "com.obric.memorydata.plugin");
            boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r6.component2(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            AutoMemoryCollectionListActivity.access$setSelectedItemCount$p(this.this$0, r0.size());
            AutoMemoryCollectionListActivity.access$setAllSelected$p(this.this$0, r7);
            ActivityAutoMemoryCollectionListBinding r8 = AutoMemoryCollectionListActivity.access$getBinding$p(this.this$0);
            if (r8 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r8 = null;
        L7:
            r8.memoryDelete.setEnabled(!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty());
            if (((com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(AutoMemoryCollectionListActivity.access$getViewModel(this.this$0).getState().c(), com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin")).d() == false) goto L11;
            AutoMemoryCollectionListActivity.access$applyTitleBarState(this.this$0, true, true);
        L11:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$observeState$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", "", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$observeState$6", f = "AutoMemoryCollectionListActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends Set<? extends Long>>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AutoMemoryCollectionListActivity this$0;

        AnonymousClass6(AutoMemoryCollectionListActivity r3, Continuation<? super AnonymousClass6> r4) {
            AutoMemoryCollectionListActivity r5 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass6 r0 = new AnonymousClass6(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Pair<? extends Boolean, ? extends Set<? extends Long>> r3, Continuation<? super Unit> r4) {
            return invoke2((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Pair<Boolean, ? extends Set<Long>> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass6) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass6.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r4);
            Pair r5 = (Pair) ZeusTransformUtils.preCheckCast(this.L$0, Pair.class, "com.obric.memorydata.plugin");
            boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(r5.component1(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            Set<Long> r6 = (Set) ZeusTransformUtils.preCheckCast(r5.component2(), Set.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.memory.ui.automemory.memorylist.a r3 = AutoMemoryCollectionListActivity.access$getAdapter$p(this.this$0);
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r3 = null;
        L7:
            r3.a(r0, r6);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$observeState$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$observeState$7", f = "AutoMemoryCollectionListActivity.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AutoMemoryCollectionListActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$observeState$7$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class AnonymousClass1<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AutoMemoryCollectionListActivity f10692a;

            AnonymousClass1(AutoMemoryCollectionListActivity r3) {
                this.f10692a = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
            }

            private static final Unit a(AutoMemoryCollectionListActivity r2) {
                AutoMemoryCollectionListActivity.access$relocateToPendingItemIfNeeded((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin"));
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: lambda$mu-6stiOCaLIu_XgYyn_SO9DHK0, reason: not valid java name */
            public static /* synthetic */ Unit m805lambda$mu6stiOCaLIu_XgYyn_SO9DHK0(AutoMemoryCollectionListActivity r0) {
                return a(r0);
            }

            public final Object a(com.obric.memorydata.memory.ui.automemory.memorylist.d r8, Continuation<? super Unit> r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                AutoMemoryCollectionListActivity.access$setNormalTitle$p(this.f10692a, r8.a());
                int r2 = 0;
                if (r8.d() == true) goto L5;
                AutoMemoryCollectionListActivity.access$applyTitleBarState(this.f10692a, false, true);
            L5:
                com.obric.memorydata.memory.ui.automemory.memorylist.a r11 = AutoMemoryCollectionListActivity.access$getAdapter$p(this.f10692a);
                ActivityAutoMemoryCollectionListBinding r3 = null;
                if (r11 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                r11 = null;
            L8:
                List<com.obric.memorydata.memory.ui.automemory.memorylist.b> r4 = r8.c();
                final AutoMemoryCollectionListActivity r5 = this.f10692a;
                r11.a(r4, new $$Lambda$AutoMemoryCollectionListActivity$observeState$7$1$mu6stiOCaLIu_XgYyn_SO9DHK0(r5));
                ActivityAutoMemoryCollectionListBinding r7 = AutoMemoryCollectionListActivity.access$getBinding$p(this.f10692a);
                if (r7 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            L12:
                LinearLayout r12 = r3.emptyView;
                if ((!((Collection) ZeusTransformUtils.preCheckCast(r8.c(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
                r2 = 8;
            L15:
                r12.setVisibility(r2);
                return Unit.INSTANCE;
            L11:
                r3 = r7;
                goto L12
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a((com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        AnonymousClass7(AutoMemoryCollectionListActivity r3, Continuation<? super AnonymousClass7> r4) {
            AutoMemoryCollectionListActivity r5 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass7) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass7.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            ar<com.obric.memorydata.memory.ui.automemory.memorylist.d> r7 = AutoMemoryCollectionListActivity.access$getViewModel(this.this$0).getState();
            j<? super com.obric.memorydata.memory.ui.automemory.memorylist.d> r2 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
        TAG = "AutoMemoryCollectionListActivity";
    }

    public AutoMemoryCollectionListActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionListActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(AutoMemoryCollectionListViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionListActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionListActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        this.normalTitle = "";
    }

    public static final /* synthetic */ void access$applyTitleBarState(AutoMemoryCollectionListActivity r2, boolean r3, boolean r4) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).applyTitleBarState(r3, r4);
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.automemory.memorylist.a access$getAdapter$p(AutoMemoryCollectionListActivity r2) {
        return ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).adapter;
    }

    public static final /* synthetic */ ActivityAutoMemoryCollectionListBinding access$getBinding$p(AutoMemoryCollectionListActivity r2) {
        return ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ AutoMemoryCollectionListViewModel access$getViewModel(AutoMemoryCollectionListActivity r2) {
        return ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$relocateToPendingItemIfNeeded(AutoMemoryCollectionListActivity r2) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).relocateToPendingItemIfNeeded();
    }

    public static final /* synthetic */ void access$setAllSelected$p(AutoMemoryCollectionListActivity r2, boolean r3) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).isAllSelected = r3;
    }

    public static final /* synthetic */ void access$setNormalTitle$p(AutoMemoryCollectionListActivity r2, String r3) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).normalTitle = r3;
    }

    public static final /* synthetic */ void access$setSelectedItemCount$p(AutoMemoryCollectionListActivity r2, int r3) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).selectedItemCount = r3;
    }

    public static final /* synthetic */ void access$shareBuildMemoryPreview(AutoMemoryCollectionListActivity r2, String r3) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).shareBuildMemoryPreview(r3);
    }

    public static final /* synthetic */ void access$updateRecyclerViewBottomPadding(AutoMemoryCollectionListActivity r2, boolean r3) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).updateRecyclerViewBottomPadding(r3);
    }

    private final void applyTitleBarState(final boolean r3, boolean r4) {
        ActivityAutoMemoryCollectionListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.normalTitleBar.a(r4, new $$Lambda$AutoMemoryCollectionListActivity$QotJsPMz1tDQTX5nyc3JLG7LviM(r3, this));
    }

    private static final Unit applyTitleBarState$lambda$30(final boolean r9, AutoMemoryCollectionListActivity r10, OFloatingTitleBar r11) {
        final AutoMemoryCollectionListActivity r12 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r10, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "$this$batchSet");
        r11.setStartTitle(null);
        r11.setStartSubtitle(null);
        if (r9 == false) goto L5;
        String r4 = r12.getString(ZeusTransformUtils.mapRes(R.string.memory_multi_select_selected_count, TypedValues.Custom.S_STRING, "memory_multi_select_selected_count"), new Object[]{Integer.valueOf(r12.selectedItemCount)});
    L6:
        r11.setCenterTitle(r4);
        r11.setCenterSubtitle(null);
        if (r9 == false) goto L9;
        int r5 = R.style.OFloatingTitleBar_Action_PrimaryLight_Text;
        String r6 = "OFloatingTitleBar_Action_PrimaryLight_Text";
    L10:
        r11.setEndButtonGroupStyle(ZeusTransformUtils.mapRes(r5, "style", r6));
        OFloatingTitleBar.a(r11, false, 1, null);
        OFloatingTitleBar.b(r11, false, 1, null);
        OFloatingTitleBar.d(r11, false, 1, null);
        OFloatingTitleBar.c(r11, false, 1, null);
        if (r9 == false) goto L13;
        int r2 = R.drawable.o_floating_title_bar_icon_close;
        String r3 = "o_floating_title_bar_icon_close";
    L14:
        OFloatingTitleBar.a(r11, ZeusTransformUtils.mapRes(r2, "drawable", r3), 0, new $$Lambda$AutoMemoryCollectionListActivity$qDzYrb541VXizu3WtYnzQlHR5YQ(r9, r12), 2, null);
        if (r9 == true) goto L17;
        OFloatingTitleBar.b(r11, ZeusTransformUtils.mapRes(R.drawable.ic_memory_detail_operation, "drawable", "ic_memory_detail_operation"), 0, new $$Lambda$AutoMemoryCollectionListActivity$XZ6tvK7H7mq8E1g7T8q3rZcUoYU(r12), 2, null);
    L23:
        return Unit.INSTANCE;
    L17:
        if (r12.isAllSelected == false) goto L19;
        int r13 = R.string.memory_list_all_unselected_text;
        String r0 = "memory_list_all_unselected_text";
    L20:
        String r1 = r12.getString(ZeusTransformUtils.mapRes(r13, TypedValues.Custom.S_STRING, r0));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        OFloatingTitleBar.a(r11, r1, 0, new $$Lambda$AutoMemoryCollectionListActivity$UY7AFWWzKaqo7ONVD1L7IH7gnpI(r12), 2, null);
        goto L23
    L19:
        r13 = R.string.memory_list_all_selected_text;
        r0 = "memory_list_all_selected_text";
        goto L20
    L13:
        r2 = R.drawable.o_floating_title_bar_icon_back;
        r3 = "o_floating_title_bar_icon_back";
        goto L14
    L9:
        r5 = R.style.OFloatingTitleBar_Action_Standard;
        r6 = "OFloatingTitleBar_Action_Standard";
        goto L10
    L5:
        r4 = r12.normalTitle;
        goto L6
    }

    private static final void applyTitleBarState$lambda$30$lambda$27(boolean r1, AutoMemoryCollectionListActivity r2, View r3) {
        AutoMemoryCollectionListActivity r4 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        if (r1 == false) goto L5;
        r4.exitSelectionMode();
        return;
    L5:
        r4.onBackPressed();
    }

    private static final void applyTitleBarState$lambda$30$lambda$28(AutoMemoryCollectionListActivity r1, View r2) {
        AutoMemoryCollectionListActivity r3 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r1, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        boolean r4 = r3.isAllSelected;
        AutoMemoryCollectionListViewModel r5 = r3.getViewModel();
        if (r4 == false) goto L5;
        r5.selectNone();
        return;
    L5:
        r5.selectAll();
    }

    private static final void applyTitleBarState$lambda$30$lambda$29(AutoMemoryCollectionListActivity r2, View r3) {
        AutoMemoryCollectionListActivity r4 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3);
        r4.showCollectionOperationMenu(r3);
    }

    private final void exitSelectionMode() {
        getViewModel().exitSelectionMode();
    }

    private final void exportAutoMemoryBuildPackage(y r13) {
        if (getViewModel().isBuildPackageExporting() == false) goto L6;
        ba.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.string.memory_auto_memory_build_package_export_running, TypedValues.Custom.S_STRING, "memory_auto_memory_build_package_export_running"), 0, 4, null);
        return;
    L6:
        DataTransportManagerApi r0 = com.obric.memorydata.datatransport.api.c.a();
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L15;
        ba.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.string.memory_auto_memory_build_package_export_unavailable, TypedValues.Custom.S_STRING, "memory_auto_memory_build_package_export_unavailable"), 0, 4, null);
        return;
    L15:
        getViewModel().markBuildPackageExportStarted(r13.a());
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        int r3 = ZeusTransformUtils.mapRes(R.string.memory_auto_memory_build_package_export_start, TypedValues.Custom.S_STRING, "memory_auto_memory_build_package_export_start");
        Object[] r6 = new Object[1];
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r7) == false) goto L18;
        r7 = String.valueOf(r13.a());
    L18:
        r6[0] = r7;
        String r4 = getString(r3, r6);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        ba.a(r2, r4, 0, 4, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r13, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L9:
        if (r0.isUTDataCollectEnabled() != true) goto L11;
        r1 = true;
        goto L12
    }

    private final void finishAfterCollectionDeleted() {
        boolean r0 = isTaskRoot();
        finish();
        if (r0 == false) goto L6;
        MemoryListActivity.a.a(MemoryListActivity.Companion, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, 2, null);
        return;
    }

    private final AutoMemoryCollectionListViewModel getViewModel() {
        return (AutoMemoryCollectionListViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), AutoMemoryCollectionListViewModel.class, "com.obric.memorydata.plugin");
    }

    private final boolean isPendingItemFullyVisible(LinearLayoutManager r7, int r8) {
        int r0 = r7.o();
        int r9 = r7.p();
        if (r0 == (-1)) goto L33;
        if (r9 != (-1)) goto L7;
        return false;
    L7:
        if (r0 > r8) goto L10;
        if (r8 > r9) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L13;
        return false;
    L13:
        ActivityAutoMemoryCollectionListBinding r11 = this.binding;
        ActivityAutoMemoryCollectionListBinding r1 = null;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L16:
        RecyclerView.v r12 = r11.rvMemoryList.findViewHolderForAdapterPosition(r8);
        if (r12 == null) goto L34;
        View r13 = r12.c;
        if (r13 == null) goto L38;
        int[] r4 = new int[2];
        ActivityAutoMemoryCollectionListBinding r5 = this.binding;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L24:
        r5.rvMemoryList.getLocationOnScreen(r4);
        int r6 = r4[1];
        ActivityAutoMemoryCollectionListBinding r14 = this.binding;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L28:
        int r15 = r1.rvMemoryList.getHeight() + r6;
        int[] r16 = new int[2];
        r13.getLocationOnScreen(r16);
        int r17 = r16[1];
        int r18 = r13.getHeight() + r17;
        if (r17 < r6) goto L35;
        if (r18 <= r15) goto L32;
        return false;
    L32:
        return true;
    L35:
        return false;
    L27:
        r1 = r14;
        goto L28
    L38:
        return false;
    L34:
        return false;
    L10:
        r10 = false;
        goto L11
    L33:
        return false;
    }

    /* JADX INFO: renamed from: lambda$4QQ3qrVcrPzouedn-YivKlWVa6E, reason: not valid java name */
    public static /* synthetic */ void m800lambda$4QQ3qrVcrPzouednYivKlWVa6E(AutoMemoryCollectionListActivity r0, LinearLayoutManager r1, int r2) {
        relocateToPendingItemIfNeeded$lambda$26(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$811s9SqbshHPRs8gWEL8mpmttpg(AutoMemoryCollectionListActivity r0, MemoryRuleEntity r1) {
        return showCollectionOperationMenu$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$9MLt8ORH87PHa765TSRpXI9u-Ts, reason: not valid java name */
    public static /* synthetic */ Unit m801lambda$9MLt8ORH87PHa765TSRpXI9uTs(AutoMemoryCollectionListActivity r0, y r1, View r2, int[] r3) {
        return setupRecyclerView$lambda$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$B73Gtf5p6E63L66K4j0brKxYOp0(MemoryRuleEntity r0, AutoMemoryCollectionListActivity r1) {
        return showCollectionOperationMenu$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit lambda$HFGiLheM2Br8FjkJ7sSvE8wkxzU(AutoMemoryCollectionListActivity r0, y r1) {
        return setupRecyclerView$lambda$14$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit lambda$LgkPkLNzuDcR0CaKph4ZujxOJFQ(AutoMemoryCollectionListActivity r0) {
        return showCollectionOperationMenu$lambda$5(r0);
    }

    public static /* synthetic */ Unit lambda$Pi9gtdtyq8yelNbyxJohAPjirAs(AutoMemoryCollectionListActivity r0, y r1) {
        return setupRecyclerView$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit lambda$QotJsPMz1tDQTX5nyc3JLG7LviM(boolean r0, AutoMemoryCollectionListActivity r1, OFloatingTitleBar r2) {
        return applyTitleBarState$lambda$30(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$UY7AFWWzKaqo7ONVD1L7IH7gnpI(AutoMemoryCollectionListActivity r0, View r1) {
        applyTitleBarState$lambda$30$lambda$28(r0, r1);
    }

    public static /* synthetic */ Unit lambda$Vpm6QWVElLcboDc0qkgALhueL_c(AutoMemoryCollectionListActivity r0) {
        return setupBottomActionBar$lambda$18$lambda$17(r0);
    }

    public static /* synthetic */ void lambda$XZ6tvK7H7mq8E1g7T8q3rZcUoYU(AutoMemoryCollectionListActivity r0, View r1) {
        applyTitleBarState$lambda$30$lambda$29(r0, r1);
    }

    public static /* synthetic */ Unit lambda$ZNdaJog_5nIjfEURqFw18P8mzlk(AutoMemoryCollectionListActivity r0, y r1) {
        return setupRecyclerView$lambda$14$lambda$13(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$fg101FP3a4jG-x6BnadRiyLYOdI, reason: not valid java name */
    public static /* synthetic */ void m802lambda$fg101FP3a4jGx6BnadRiyLYOdI(AutoMemoryCollectionListActivity r0, OBottomActionBarFloating r1) {
        updateRecyclerViewBottomPadding$lambda$23$lambda$22(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$gUHO80e36GcaTlOti9jo-ABia5s, reason: not valid java name */
    public static /* synthetic */ void m803lambda$gUHO80e36GcaTlOti9joABia5s(AutoMemoryCollectionListActivity r0, View r1) {
        setupBottomActionBar$lambda$18(r0, r1);
    }

    public static /* synthetic */ Unit lambda$gd8IpJTvDDQOmM2Lig7LrSSLQZg(AutoMemoryCollectionListActivity r0, y r1) {
        return setupRecyclerView$lambda$14$lambda$11(r0, r1);
    }

    public static /* synthetic */ Unit lambda$h8qfgwl3w6k5OYtQaOQg_wxPhUY(AutoMemoryCollectionListActivity r0, y r1) {
        return setupRecyclerView$lambda$14$lambda$13$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit lambda$iIcoYeEA00X3UKsNjvHdb991UY4(AutoMemoryCollectionListActivity r0) {
        return showCollectionOperationMenu$lambda$5$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$mJhW5y_aXRxmM6IHombD_QInYF4(AutoMemoryCollectionListActivity r0, View r1, WindowInsetsCompat r2) {
        return setupRecyclerView$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$qDzYrb541VXizu3WtYnzQlHR5YQ(boolean r0, AutoMemoryCollectionListActivity r1, View r2) {
        applyTitleBarState$lambda$30$lambda$27(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$sDF9bPYVRl-WFn-MjxUlnkPY8Hs, reason: not valid java name */
    public static /* synthetic */ Unit m804lambda$sDF9bPYVRlWFnMjxUlnkPY8Hs(AutoMemoryCollectionListActivity r0) {
        return showCollectionOperationMenu$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ Unit lambda$zbwWTt5mXzgooR6Urz6W5uvnEYQ(AutoMemoryCollectionListActivity r0, y r1) {
        return setupRecyclerView$lambda$14$lambda$7(r0, r1);
    }

    private final void observeState() {
        k.b(k.f(k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(getViewModel().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new C11282(this, null), Function2.class, "com.obric.memorydata.plugin")), (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"));
        k.b(k.f(k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(getViewModel().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin")), (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"));
        k.b(k.f(k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new d((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(getViewModel().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this, null), Function2.class, "com.obric.memorydata.plugin")), (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void relocateToPendingItemIfNeeded() {
        Long r1 = this.pendingRelocateItemId;
        if (r1 == null) goto L27;
        long r2 = r1.longValue();
        com.obric.memorydata.memory.ui.automemory.memorylist.a r3 = this.adapter;
        ActivityAutoMemoryCollectionListBinding r4 = null;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r3 = null;
    L7:
        Integer r5 = r3.a(r2);
        if (r5 == null) goto L25;
        final int r6 = r5.intValue();
        ActivityAutoMemoryCollectionListBinding r7 = this.binding;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L12:
        RecyclerView.h r8 = r7.rvMemoryList.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r8, LinearLayoutManager.class) == false) goto L15;
        final LinearLayoutManager r9 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r8, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L16:
        if (r9 != null) goto L19;
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.preCheckCast(this, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).pendingRelocateItemId = null;
        return;
    L19:
        ActivityAutoMemoryCollectionListBinding r0 = this.binding;
        if (r0 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L23:
        r4.rvMemoryList.post(new $$Lambda$AutoMemoryCollectionListActivity$4QQ3qrVcrPzouednYivKlWVa6E(this, r9, r6));
        return;
    L22:
        r4 = r0;
        goto L23
    L15:
        r9 = null;
        goto L16
    L25:
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.preCheckCast(this, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).pendingRelocateItemId = null;
        return;
    }

    private static final void relocateToPendingItemIfNeeded$lambda$26(AutoMemoryCollectionListActivity r5, LinearLayoutManager r6, int r7) {
        AutoMemoryCollectionListActivity r8 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r5, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        if (r8.isPendingItemFullyVisible(r6, r7) == false) goto L6;
        r8.pendingRelocateItemId = null;
        return;
    L6:
        r6.b(r7, ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_h_title_bar_window, "dimen", "oui_h_title_bar_window")));
        r8.pendingRelocateItemId = null;
    }

    private final void setupBottomActionBar() {
        ActivityAutoMemoryCollectionListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.memoryDelete.setOnClickListener(new $$Lambda$AutoMemoryCollectionListActivity$gUHO80e36GcaTlOti9joABia5s(this));
    }

    private static final void setupBottomActionBar$lambda$18(AutoMemoryCollectionListActivity r4, View r5) {
        final AutoMemoryCollectionListActivity r6 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r4, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        int r7 = ((com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(r6.getViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin")).e().size();
        if (r7 <= 1) goto L5;
        String r8 = r6.getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_multiple, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_multiple"), new Object[]{Integer.valueOf(r7)});
    L6:
        Intrinsics.checkNotNull(r8);
        e.a(r6, r8, null, new $$Lambda$AutoMemoryCollectionListActivity$Vpm6QWVElLcboDc0qkgALhueL_c(r6));
        return;
    L5:
        r8 = r6.getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_single, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_single"));
        goto L6
    }

    private static final Unit setupBottomActionBar$lambda$18$lambda$17(AutoMemoryCollectionListActivity r3) {
        AutoMemoryCollectionListActivity r4 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.automemory.memorylist.d r0 = (com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(r4.getViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin");
        r4.getViewModel().deleteItems(r0.e(), r0.f());
        r4.exitSelectionMode();
        return Unit.INSTANCE;
    }

    private final void setupRecyclerView() {
        this.adapter = new com.obric.memorydata.memory.ui.automemory.memorylist.a(new $$Lambda$AutoMemoryCollectionListActivity$Pi9gtdtyq8yelNbyxJohAPjirAs(this), new $$Lambda$AutoMemoryCollectionListActivity$9MLt8ORH87PHa765TSRpXI9uTs(this));
        ActivityAutoMemoryCollectionListBinding r0 = this.binding;
        ActivityAutoMemoryCollectionListBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r1 = r0.rvMemoryList;
        r1.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.memory.ui.automemory.memorylist.a r3 = this.adapter;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r3 = null;
    L8:
        r1.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r3, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        ActivityAutoMemoryCollectionListBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$AutoMemoryCollectionListActivity$mJhW5y_aXRxmM6IHombD_QInYF4(this));
        ActivityAutoMemoryCollectionListBinding r6 = this.binding;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(r2.getRoot(), View.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        r2 = r6;
        goto L15
    }

    private static final Unit setupRecyclerView$lambda$14(AutoMemoryCollectionListActivity r9, final y r10, View r11, int[] r12) {
        final AutoMemoryCollectionListActivity r13 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r9, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "anchor");
        if (((com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(r13.getViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin")).d() == false) goto L5;
        r13.getViewModel().toggleSelection(Long.valueOf(r10.a()));
    L36:
        return Unit.INSTANCE;
    L5:
        WeakReference<com.obric.oui.popover.v2.a> r0 = r13.currentItemOperationPopover;
        if (r0 == null) goto L11;
        com.obric.oui.popover.v2.a r1 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r0.get(), com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.dismiss();
    L11:
        if (ZeusTransformUtils.instanceOf(r11, OCardListItem.class) == false) goto L13;
        OCardListItem r2 = (OCardListItem) ZeusTransformUtils.preCheckCast(r11, OCardListItem.class, "com.obric.memorydata.plugin");
    L14:
        boolean r3 = true;
        if (r2 == null) goto L17;
        r2.setSelected(true);
    L17:
        Function0 r5 = new $$Lambda$AutoMemoryCollectionListActivity$zbwWTt5mXzgooR6Urz6W5uvnEYQ(r13, r10);
        if (AppContext.INSTANCE.isDebug() == false) goto L27;
        DataTransportManagerApi r4 = com.obric.memorydata.datatransport.api.c.a();
        if (r4 != null) goto L22;
    L24:
        boolean r6 = false;
    L25:
        if (r6 == false) goto L27;
    L28:
        if (r3 == false) goto L30;
        final y r7 = r10;
    L31:
        if (r7 == null) goto L33;
        Function0 r8 = new $$Lambda$AutoMemoryCollectionListActivity$HFGiLheM2Br8FjkJ7sSvE8wkxzU(r13, r7);
    L34:
        r13.currentItemOperationPopover = new WeakReference(e.a(r13, r11, r12, r5, r8, new $$Lambda$AutoMemoryCollectionListActivity$gd8IpJTvDDQOmM2Lig7LrSSLQZg(r13, r10), new $$Lambda$AutoMemoryCollectionListActivity$ZNdaJog_5nIjfEURqFw18P8mzlk(r13, r10)));
        goto L36
    L33:
        r8 = null;
        goto L34
    L30:
        r7 = null;
        goto L31
    L22:
        if (r4.isUTDataCollectEnabled() != true) goto L24;
        r6 = true;
    L27:
        r3 = false;
        goto L28
    L13:
        r2 = null;
        goto L14
    }

    private static final Unit setupRecyclerView$lambda$14$lambda$10$lambda$9(AutoMemoryCollectionListActivity r2, y r3) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).exportAutoMemoryBuildPackage(r3);
        return Unit.INSTANCE;
    }

    private static final Unit setupRecyclerView$lambda$14$lambda$11(AutoMemoryCollectionListActivity r2, y r3) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).showFeedbackSheet(r3);
        return Unit.INSTANCE;
    }

    private static final Unit setupRecyclerView$lambda$14$lambda$13(AutoMemoryCollectionListActivity r3, final y r4) {
        final AutoMemoryCollectionListActivity r5 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        String r0 = r5.getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_single, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_single"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        e.a(r5, r0, null, new $$Lambda$AutoMemoryCollectionListActivity$h8qfgwl3w6k5OYtQaOQg_wxPhUY(r5, r4));
        return Unit.INSTANCE;
    }

    private static final Unit setupRecyclerView$lambda$14$lambda$13$lambda$12(AutoMemoryCollectionListActivity r3, y r4) {
        AutoMemoryCollectionListViewModel.deleteItems$default(((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).getViewModel(), SetsKt.setOf(Long.valueOf(r4.a())), false, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit setupRecyclerView$lambda$14$lambda$7(AutoMemoryCollectionListActivity r2, y r3) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).getViewModel().enterSelectionMode(Long.valueOf(r3.a()));
        return Unit.INSTANCE;
    }

    private static final WindowInsetsCompat setupRecyclerView$lambda$16(AutoMemoryCollectionListActivity r2, View r3, WindowInsetsCompat r4) {
        AutoMemoryCollectionListActivity r5 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r4, "insets");
        r5.systemBottomInset = r4.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        r5.updateRecyclerViewBottomPadding(((com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(r5.getViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin")).d());
        return r4;
    }

    private static final Unit setupRecyclerView$lambda$6(AutoMemoryCollectionListActivity r11, y r12) {
        AutoMemoryCollectionListActivity r13 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r11, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "item");
        if (((com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(r13.getViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin")).d() == false) goto L5;
        r13.getViewModel().toggleSelection(Long.valueOf(r12.a()));
    L7:
        return Unit.INSTANCE;
    L5:
        MemoryEventTracker.f10515a.a((MemoryEventTracker.Params) ZeusTransformUtils.preCheckCast(new MemoryEventTracker.ClickCardItemParams(r12.f(), Integer.valueOf(EntityType.PROACTIVE_MEMORY), null, MemoryEventTracker.ReactionType.DETAIL.getValue(), MemoryEventTracker.SourceType.MEMORY_LIST.getValue(), 4, null), MemoryEventTracker.Params.class, "com.obric.memorydata.plugin"));
        r13.pendingRelocateItemId = Long.valueOf(r12.a());
        r13.shouldRefreshOnResume = true;
        AutoMemoryDetailActivity.a.a(AutoMemoryDetailActivity.Companion, (Context) ZeusTransformUtils.preCheckCast(r13, Context.class, "com.obric.memorydata.plugin"), r12.a(), false, 4, null);
        goto L7
    }

    private final void setupTitleBars() {
        String r0 = getIntent().getStringExtra("extra_title");
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r1) == false) goto L8;
        r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_auto_memory_list, TypedValues.Custom.S_STRING, "memory_auto_memory_list"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
    L8:
        this.normalTitle = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        ActivityAutoMemoryCollectionListBinding r2 = this.binding;
        ActivityAutoMemoryCollectionListBinding r3 = null;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L11:
        r2.normalTitleBar.setMaskBlurRadius(8.0f);
        ActivityAutoMemoryCollectionListBinding r4 = this.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        OFloatingTitleBar r5 = r4.normalTitleBar;
        Intrinsics.checkNotNullExpressionValue(r5, "normalTitleBar");
        ActivityAutoMemoryCollectionListBinding r6 = this.binding;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L17:
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.rvMemoryList, View.class, "com.obric.memorydata.plugin");
        int r8 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        ActivityAutoMemoryCollectionListBinding r9 = this.binding;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L20:
        setupTitleBarBackAction(r5, r7, r8, r9.cutOff);
        applyTitleBarState(false, false);
        ActivityAutoMemoryCollectionListBinding r10 = this.binding;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        OFloatingTitleBar r11 = r3.normalTitleBar;
        Intrinsics.checkNotNullExpressionValue(r11, "normalTitleBar");
        registerFloatingTitleBar(r11);
        return;
    L23:
        r3 = r10;
        goto L24
    }

    private final void shareBuildMemoryPreview(String r14) {
        List<String> r0 = g.f10706a.a(r14);
        if (r0 == null) goto L7;
        String r1 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(r0), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        File r3 = new File(r1);
    L9:
        if (r3 != null) goto L23;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r13 = getString(ZeusTransformUtils.mapRes(R.string.memory_auto_memory_build_package_share_failed, TypedValues.Custom.S_STRING, "memory_auto_memory_build_package_share_failed"), new Object[]{r14});
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        ba.a(r2, r13, 0, 4, null);
        return;
    L23:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L14
        AutoMemoryCollectionListActivity r10 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.preCheckCast(this, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Uri r4 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.fileprovider", r3, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Intent r11 = new Intent("android.intent.action.SEND");     // Catch: Throwable -> L14
        r11.setType("application/zip");     // Catch: Throwable -> L14
        r11.putExtra("android.intent.extra.STREAM", (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        r11.addFlags(1);     // Catch: Throwable -> L14
        ZeusTransformUtils.startActivity(r10, Intent.createChooser(r11, (CharSequence) ZeusTransformUtils.preCheckCast(r10.getString(ZeusTransformUtils.mapRes(R.string.memory_auto_memory_build_package_share_chooser, TypedValues.Custom.S_STRING, "memory_auto_memory_build_package_share_chooser")), CharSequence.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L25;
        RunLog.INSTANCE.error(TAG, "shareBuildMemoryPreview failed, path=" + r14, r6);
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        int r7 = ZeusTransformUtils.mapRes(R.string.memory_auto_memory_build_package_share_failed, TypedValues.Custom.S_STRING, "memory_auto_memory_build_package_share_failed");
        Object[] r8 = new Object[1];
        String r12 = r6.getMessage();
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        r8[0] = r12;
        String r16 = getString(r7, r8);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");
        ba.a(r15, r16, 0, 4, null);
        return;
    L25:
        return;
    L14:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r3 = null;
        goto L9
    }

    private final void showCollectionOperationMenu(View r14) {
        final MemoryRuleEntity r0 = ((com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin")).b();
        if (r0 != null) goto L5;
        return;
    L5:
        com.obric.memorydata.memory.ui.automemory.e.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), r14, r0.isPaused(), null, true, new $$Lambda$AutoMemoryCollectionListActivity$B73Gtf5p6E63L66K4j0brKxYOp0(r0, this), new $$Lambda$AutoMemoryCollectionListActivity$811s9SqbshHPRs8gWEL8mpmttpg(this, r0), new $$Lambda$AutoMemoryCollectionListActivity$LgkPkLNzuDcR0CaKph4ZujxOJFQ(this), null, 264, null);
    }

    private static final Unit showCollectionOperationMenu$lambda$1(MemoryRuleEntity r8, AutoMemoryCollectionListActivity r9) {
        AutoMemoryCollectionListActivity r10 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r9, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        boolean r11 = !r8.isPaused();
        r10.getViewModel().updateCollectionPausedState(r11);
        com.obric.oui.toast.a.C0786a r2 = com.obric.oui.toast.a.f14807a;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L5;
        int r12 = R.string.memory_auto_memory_stopped_toast;
        String r1 = "memory_auto_memory_stopped_toast";
    L6:
        String r4 = r10.getString(ZeusTransformUtils.mapRes(r12, TypedValues.Custom.S_STRING, r1));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r2, r3, r4, 0, 4, null);
        return Unit.INSTANCE;
    L5:
        r12 = R.string.memory_auto_memory_started_toast;
        r1 = "memory_auto_memory_started_toast";
        goto L6
    }

    private static final Unit showCollectionOperationMenu$lambda$2(AutoMemoryCollectionListActivity r3, MemoryRuleEntity r4) {
        AutoMemoryCollectionListActivity r5 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r3, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        r5.shouldRefreshOnResume = true;
        MemoryTaskSettingsActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin"), r4.getId());
        return Unit.INSTANCE;
    }

    private static final Unit showCollectionOperationMenu$lambda$5(AutoMemoryCollectionListActivity r7) {
        final AutoMemoryCollectionListActivity r8 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r7, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.automemory.e.a((Activity) ZeusTransformUtils.preCheckCast(r8, Activity.class, "com.obric.memorydata.plugin"), null, null, new $$Lambda$AutoMemoryCollectionListActivity$sDF9bPYVRlWFnMjxUlnkPY8Hs(r8), 6, null);
        return Unit.INSTANCE;
    }

    private static final Unit showCollectionOperationMenu$lambda$5$lambda$4(AutoMemoryCollectionListActivity r2) {
        final AutoMemoryCollectionListActivity r3 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        r3.getViewModel().deleteCollection(new $$Lambda$AutoMemoryCollectionListActivity$iIcoYeEA00X3UKsNjvHdb991UY4(r3));
        return Unit.INSTANCE;
    }

    private static final Unit showCollectionOperationMenu$lambda$5$lambda$4$lambda$3(AutoMemoryCollectionListActivity r2) {
        ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).finishAfterCollectionDeleted();
        return Unit.INSTANCE;
    }

    private final void showFeedbackSheet(y r4) {
        g.f10706a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void updateRecyclerViewBottomPadding(boolean r6) {
        ActivityAutoMemoryCollectionListBinding r1 = null;
        if (r6 == false) goto L16;
        ActivityAutoMemoryCollectionListBinding r7 = this.binding;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L7:
        final OBottomActionBarFloating r8 = r7.bottomActionBar;
        if (r8.getMeasuredHeight() == 0) goto L14;
        ActivityAutoMemoryCollectionListBinding r5 = this.binding;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        RecyclerView r9 = r1.rvMemoryList;
        Intrinsics.checkNotNullExpressionValue(r9, "rvMemoryList");
        bb.c((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), r8.getMeasuredHeight());
        return;
    L12:
        r1 = r5;
        goto L13
    L14:
        r8.post(new $$Lambda$AutoMemoryCollectionListActivity$fg101FP3a4jGx6BnadRiyLYOdI(this, r8));
        return;
    L16:
        ActivityAutoMemoryCollectionListBinding r10 = this.binding;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L20:
        RecyclerView r11 = r1.rvMemoryList;
        Intrinsics.checkNotNullExpressionValue(r11, "rvMemoryList");
        bb.c((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_h_title_bar_window, "dimen", "oui_h_title_bar_window")) + this.systemBottomInset) + MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
        return;
    L19:
        r1 = r10;
        goto L20
    }

    private static final void updateRecyclerViewBottomPadding$lambda$23$lambda$22(AutoMemoryCollectionListActivity r2, OBottomActionBarFloating r3) {
        ActivityAutoMemoryCollectionListBinding r4 = ((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin")).binding;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        RecyclerView r5 = r4.rvMemoryList;
        Intrinsics.checkNotNullExpressionValue(r5, "rvMemoryList");
        bb.c((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), r3.getMeasuredHeight());
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (((com.obric.memorydata.memory.ui.automemory.memorylist.d) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.memorylist.d.class, "com.obric.memorydata.plugin")).d() == false) goto L5;
        exitSelectionMode();
        return;
    L5:
        super.onBackPressed();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreateChecked ...", false, 4, null);
        prepareSystemBar();
        ActivityAutoMemoryCollectionListBinding r10 = ActivityAutoMemoryCollectionListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        this.binding = r10;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r10.getRoot(), View.class, "com.obric.memorydata.plugin"));
        setupTitleBars();
        setupRecyclerView();
        setupBottomActionBar();
        observeState();
        AutoMemoryCollectionListViewModel r11 = getViewModel();
        long r0 = getIntent().getLongExtra("extra_collection_id", -1);
        String r8 = getIntent().getStringExtra("extra_title");
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        r11.init(r0, r8);
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        if (this.shouldRefreshOnResume == false) goto L6;
        this.shouldRefreshOnResume = false;
        getViewModel().refresh();
        return;
    }
}
