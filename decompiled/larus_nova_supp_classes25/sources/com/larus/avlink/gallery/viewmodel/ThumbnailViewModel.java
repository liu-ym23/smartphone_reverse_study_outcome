package com.larus.avlink.gallery.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.thumbnail.ThumbnailManager;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\u0015J\u000e\u00104\u001a\u000201H\u0082@¢\u0006\u0002\u00105J\u0006\u00106\u001a\u000201J\u0006\u00107\u001a\u000201J\u000e\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\u0007J\u0014\u0010:\u001a\u0002012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\b\u0010;\u001a\u000201H\u0002J\b\u0010<\u001a\u000201H\u0002J\u0014\u0010=\u001a\u0002012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010>\u001a\u000201J\u0006\u0010?\u001a\u000201J\u0006\u0010@\u001a\u00020\u0011J\u000e\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u0011J\u0006\u0010C\u001a\u000201J\u0006\u0010D\u001a\u000201J\u0006\u0010E\u001a\u000201J\u0006\u0010F\u001a\u00020\u0015R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000bR\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000bR\u000e\u0010*\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000bR\u000e\u0010.\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/avlink/gallery/viewmodel/ThumbnailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_thumbnailList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/avlink/gallery/model/ThumbnailMetadata;", "thumbnailList", "Landroidx/lifecycle/LiveData;", "getThumbnailList", "()Landroidx/lifecycle/LiveData;", "_selectedItems", "", "selectedItems", "getSelectedItems", "_selectedCount", "", "selectedCount", "getSelectedCount", "_isAllSelected", "", "isAllSelected", "_isLoading", "isLoading", "_errorMessage", "", "errorMessage", "getErrorMessage", "_deleteCompleteEvent", "", "deleteCompleteEvent", "getDeleteCompleteEvent", "_syncCompleteEvent", "syncCompleteEvent", "getSyncCompleteEvent", "_imageCount", "imageCount", "getImageCount", "_videoCount", "videoCount", "getVideoCount", "lastLoadTime", "MIN_REFRESH_INTERVAL", "_isSelectionMode", "isSelectionMode", "isFirstLoad", "previousListSize", "loadThumbnailList", "", "refreshThumbnailList", "force", "refreshThumbnailListWithDelay", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectAll", "deselectAll", "toggleSelection", "item", "applySelection", "updateSelectedCount", "updateStats", "deleteSelected", "clearErrorMessage", "clearDeleteCompleteEvent", "getThumbnailCount", "onSyncComplete", "count", "clearSyncCompleteEvent", "enterSelectionMode", "exitSelectionMode", "disableGainThumbnail", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ThumbnailViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String TAG = "ThumbnailViewModel";
    private static final CopyOnWriteArrayList<d> dataChangeListeners = null;
    private final long MIN_REFRESH_INTERVAL;
    private final MutableLiveData<List<Long>> _deleteCompleteEvent;
    private final MutableLiveData<String> _errorMessage;
    private final MutableLiveData<Integer> _imageCount;
    private final MutableLiveData<Boolean> _isAllSelected;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<Boolean> _isSelectionMode;
    private final MutableLiveData<Integer> _selectedCount;
    private final MutableLiveData<Set<ThumbnailMetadata>> _selectedItems;
    private final MutableLiveData<Integer> _syncCompleteEvent;
    private final MutableLiveData<List<ThumbnailMetadata>> _thumbnailList;
    private final MutableLiveData<Integer> _videoCount;
    private final LiveData<List<Long>> deleteCompleteEvent;
    private final LiveData<String> errorMessage;
    private final LiveData<Integer> imageCount;
    private final LiveData<Boolean> isAllSelected;
    private boolean isFirstLoad;
    private final LiveData<Boolean> isLoading;
    private final LiveData<Boolean> isSelectionMode;
    private long lastLoadTime;
    private int previousListSize;
    private final LiveData<Integer> selectedCount;
    private final LiveData<Set<ThumbnailMetadata>> selectedItems;
    private final LiveData<Integer> syncCompleteEvent;
    private final LiveData<List<ThumbnailMetadata>> thumbnailList;
    private final LiveData<Integer> videoCount;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$2", f = "ThumbnailViewModel.kt", i = {}, l = {DoraCallStateCode.DOUBAO_START_LIVE_TUTOR}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ThumbnailViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ThumbnailViewModel a;

            public a(ThumbnailViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r4, Continuation r5) {
                int r6 = ((Number) r4).intValue();
                if (r6 <= 0) goto L9;
                FLogger.a.i(ThumbnailViewModel.TAG, "Thumbnail saved event received, refreshing data immediately, count=" + r6);
                Object r7 = ThumbnailViewModel.access$refreshThumbnailListWithDelay(this.a, r5);
                if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
                return r7;
            L10:
                return Unit.INSTANCE;
            L9:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(ThumbnailViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            MutableSharedFlow r6 = ThumbnailManager.i;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(e r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$deleteSelected$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$deleteSelected$1", f = "ThumbnailViewModel.kt", i = {0}, l = {358}, m = "invokeSuspend", n = {"imageUuids"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ThumbnailMetadata> $selectedItems;
        Object L$0;
        int label;
        final /* synthetic */ ThumbnailViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$deleteSelected$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$deleteSelected$1$1", f = "ThumbnailViewModel.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $currentSn;
            final /* synthetic */ List<Long> $imageUuids;
            int label;

            public C00171(List<Long> r1, String r2, Continuation<? super C00171> r3) {
                this.$imageUuids = r1;
                this.$currentSn = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00171(this.$imageUuids, this.$currentSn, r4);
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
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                ThumbnailManager r6 = ThumbnailManager.a;
                List<Long> r2 = this.$imageUuids;
                String r3 = this.$currentSn;
                this.label = 1;
                if (r6.j(r2, r3, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(List<ThumbnailMetadata> r1, ThumbnailViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$selectedItems = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$selectedItems, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            List r2 = (List) this.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L31 Exception -> L33
        L25:
            this.this$0.loadThumbnailList();     // Catch: Throwable -> L31 Exception -> L33
            this.this$0.deselectAll();     // Catch: Throwable -> L31 Exception -> L33
            ThumbnailViewModel.access$get_deleteCompleteEvent$p(this.this$0).setValue(r2);     // Catch: Throwable -> L31 Exception -> L33
            a r10 = ThumbnailViewModel.Companion;     // Catch: Throwable -> L31 Exception -> L33
            int r3 = this.$selectedItems.size();     // Catch: Throwable -> L31 Exception -> L33
            r10.getClass();     // Catch: Throwable -> L31 Exception -> L33
            Iterator r11 = ThumbnailViewModel.access$getDataChangeListeners$cp().iterator();     // Catch: Throwable -> L31 Exception -> L33
        L27:
            if (r11.hasNext() == false) goto L29;
            ((d) r11.next()).HZ(r3);     // Catch: Throwable -> L31 Exception -> L33
            goto L27
        L29:
            FLogger.a.i(ThumbnailViewModel.TAG, "Deleted " + this.$selectedItems.size() + " thumbnails");     // Catch: Throwable -> L31 Exception -> L33
        L35:
            ThumbnailViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r9);
            List<ThumbnailMetadata> r12 = this.$selectedItems;     // Catch: Throwable -> L31 Exception -> L33
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Throwable -> L31 Exception -> L33
            Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L31 Exception -> L33
        L13:
            if (r13.hasNext() == false) goto L15;
            r4.add(Boxing.boxLong(((ThumbnailMetadata) r13.next()).getImageUuid()));     // Catch: Throwable -> L31 Exception -> L33
            goto L13
        L15:
            IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L31 Exception -> L33
            if (r14 == null) goto L20;
            DeviceService r15 = r14.device();     // Catch: Throwable -> L31 Exception -> L33
            if (r15 == null) goto L20;
            String r16 = r15.m();     // Catch: Throwable -> L31 Exception -> L33
        L21:
            CoroutineDispatcher r5 = Dispatchers.getIO();     // Catch: Throwable -> L31 Exception -> L33
            C00171 r6 = new C00171(r4, r16, null);     // Catch: Throwable -> L31 Exception -> L33
            this.L$0 = r4;     // Catch: Throwable -> L31 Exception -> L33
            this.label = 1;     // Catch: Throwable -> L31 Exception -> L33
            if (BuildersKt.withContext(r5, r6, this) != r0) goto L24;
            return r0;
        L24:
            r2 = r4;
        L20:
            r16 = "";
        L31:
            th = move-exception;
            ThumbnailViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            throw th;
        L33:
            e = move-exception;
            ThumbnailViewModel.access$get_errorMessage$p(this.this$0).setValue("删除缩略图失败: " + e.getMessage());     // Catch: Throwable -> L31
            FLogger.a.e(ThumbnailViewModel.TAG, "Error deleting thumbnails: " + e.getMessage(), e);     // Catch: Throwable -> L31
            goto L35
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$loadThumbnailList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$loadThumbnailList$1", f = "ThumbnailViewModel.kt", i = {}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_LINK_CONNECTED}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ThumbnailViewModel this$0;

        public C01221(ThumbnailViewModel r1, Continuation<? super C01221> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01221(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = this.label;
            if (r4 == 0) goto L9;
            if (r4 != 1) goto L8;
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L17 Exception -> L19
        L13:
            List r12 = (List) r11;     // Catch: Throwable -> L17 Exception -> L19
            ThumbnailViewModel.access$get_thumbnailList$p(this.this$0).setValue(r12);     // Catch: Throwable -> L17 Exception -> L19
            ThumbnailViewModel.access$updateStats(this.this$0);     // Catch: Throwable -> L17 Exception -> L19
            ThumbnailViewModel.access$setLastLoadTime$p(this.this$0, System.currentTimeMillis());     // Catch: Throwable -> L17 Exception -> L19
            ThumbnailViewModel.Companion.getClass();     // Catch: Throwable -> L17 Exception -> L19
            Iterator r5 = ThumbnailViewModel.access$getDataChangeListeners$cp().iterator();     // Catch: Throwable -> L17 Exception -> L19
        L15:
            if (r5.hasNext() == false) goto L21;
            ((d) r5.next()).VO();     // Catch: Throwable -> L17 Exception -> L19
            goto L15
        L21:
            FLogger.a.i(ThumbnailViewModel.TAG, "Loaded " + r12.size() + " thumbnails (sorted by createTime descending)");     // Catch: Throwable -> L17 Exception -> L19
        L24:
            ThumbnailViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
            AlbumDataBaseHelper r13 = AlbumDataBaseHelper.a;     // Catch: Throwable -> L17 Exception -> L19
            this.label = 1;     // Catch: Throwable -> L17 Exception -> L19
            r11 = r13.n(this);     // Catch: Throwable -> L17 Exception -> L19
            if (r11 != r3) goto L13;
            return r3;
        L17:
            th = move-exception;
            ThumbnailViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            throw th;
        L19:
            e = move-exception;
            ThumbnailViewModel.access$get_errorMessage$p(this.this$0).setValue("加载缩略图失败: " + e.getMessage());     // Catch: Throwable -> L17
            FLogger.a.e(ThumbnailViewModel.TAG, "Error loading thumbnails: " + e.getMessage(), e);     // Catch: Throwable -> L17
            goto L24
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.ThumbnailViewModel$refreshThumbnailListWithDelay$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.ThumbnailViewModel", f = "ThumbnailViewModel.kt", i = {}, l = {228}, m = "refreshThumbnailListWithDelay", n = {}, s = {})
    public static final class C01231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ThumbnailViewModel this$0;

        public C01231(ThumbnailViewModel r1, Continuation<? super C01231> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ThumbnailViewModel.access$refreshThumbnailListWithDelay(this.this$0, this);
        }
    }

    public static /* synthetic */ Unit yo(ThumbnailViewModel r0, List r1) {
        return _init_$lambda$0(r0, r1);
    }

    public final boolean disableGainThumbnail() {
        if (b98.b.b(1) == false) goto L5;
        return true;
    L5:
        if (b98.b.b(4) == false) goto L7;
        return true;
    L7:
        if (b98.b.b(5) == false) goto L9;
        return true;
    L9:
        if (b98.b.b(7) == true) goto L16;
        return false;
    L16:
        return true;
    }

    static {
        Companion = new a();
        $stable = 8;
        dataChangeListeners = new CopyOnWriteArrayList();
    }

    private final void updateSelectedCount() {
        Set r0 = (Set) this._selectedItems.getValue();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        this._selectedCount.setValue(Integer.valueOf(r2));
        List r3 = (List) this._thumbnailList.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.size();
    L10:
        if (r4 <= 0) goto L13;
        if (r2 != r4) goto L13;
        r1 = true;
    L13:
        this._isAllSelected.setValue(Boolean.valueOf(r1));
        FLogger.a.d(TAG, "updateSelectedCount: selected=" + r2 + ", total=" + r4 + ", isAllSelected=" + r1);
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    private final void updateStats() {
        List r0 = (List) this._thumbnailList.getValue();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r1 = r0;
        boolean r2 = r1 instanceof Collection;
        int r3 = 0;
        if (r2 == true) goto L8;
    L10:
        Iterator r4 = r1.iterator();
        int r5 = 0;
    L12:
        if (r4.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((ThumbnailMetadata) r4.next()).getMediaType(), "image") == false) goto L12;
        r5 = r5 + 1;
        if (r5 >= 0) goto L12;
        CollectionsKt.throwCountOverflow();
    L18:
        if (r2 == true) goto L20;
    L22:
        Iterator r6 = r1.iterator();
    L24:
        if (r6.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(((ThumbnailMetadata) r6.next()).getMediaType(), "video") == false) goto L24;
        r3 = r3 + 1;
        if (r3 >= 0) goto L24;
        CollectionsKt.throwCountOverflow();
    L30:
        this._imageCount.setValue(Integer.valueOf(r5));
        this._videoCount.setValue(Integer.valueOf(r3));
        FLogger.a.d(TAG, "Stats: " + r5 + " images, " + r3 + " videos");
        return;
    L20:
        if (r1.isEmpty() == false) goto L22;
    L8:
        if (r1.isEmpty() == false) goto L10;
        r5 = 0;
        goto L18
    }

    public final void clearDeleteCompleteEvent() {
        this._deleteCompleteEvent.setValue(CollectionsKt.emptyList());
    }

    public final void clearErrorMessage() {
        this._errorMessage.setValue(null);
    }

    public final void clearSyncCompleteEvent() {
        this._syncCompleteEvent.setValue(null);
    }

    public final void deselectAll() {
        this._selectedItems.setValue(SetsKt.emptySet());
        this._isAllSelected.setValue(Boolean.FALSE);
        updateSelectedCount();
        FLogger r0 = FLogger.a;
        r0.i(TAG, "Deselected all thumbnails");
        if (Intrinsics.areEqual(this._isSelectionMode.getValue(), Boolean.TRUE) == false) goto L6;
        r0.i(TAG, "No selected items in selection mode, auto exit");
        exitSelectionMode();
        return;
    }

    public final void enterSelectionMode() {
        this._isSelectionMode.setValue(Boolean.TRUE);
        FLogger.a.i(TAG, "Enter selection mode");
    }

    public final void exitSelectionMode() {
        this._isSelectionMode.setValue(Boolean.FALSE);
        deselectAll();
        FLogger.a.i(TAG, "Exit selection mode");
    }

    /* JADX INFO: renamed from: getSelectedItems, reason: collision with other method in class */
    public final List<ThumbnailMetadata> m29getSelectedItems() {
        Set r0 = (Set) this._selectedItems.getValue();
        if (r0 == null) goto L7;
        List<ThumbnailMetadata> r1 = CollectionsKt.toList(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final int getThumbnailCount() {
        List r0 = (List) this._thumbnailList.getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final void loadThumbnailList() {
        this._isLoading.setValue(Boolean.TRUE);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01221(this, null), 3, null);
    }

    public final void selectAll() {
        List r0 = (List) this._thumbnailList.getValue();
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();
    L6:
        if (r0.isEmpty() == false) goto L9;
        FLogger.a.w(TAG, "No thumbnails to select");
        return;
    L9:
        Object r1 = this._isSelectionMode.getValue();
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r3) == true) goto L12;
        this._isSelectionMode.setValue(r3);
    L12:
        Set r2 = CollectionsKt.toSet(r0);
        this._selectedItems.setValue(r2);
        this._isAllSelected.setValue(r3);
        updateSelectedCount();
        FLogger.a.i(TAG, "Selected all " + r0.size() + " thumbnails, selectedSet: " + r2);
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [com.larus.avlink.gallery.viewmodel.e] */
    public ThumbnailViewModel() {
        MutableLiveData<List<ThumbnailMetadata>> r0 = new MutableLiveData();
        this._thumbnailList = r0;
        this.thumbnailList = r0;
        MutableLiveData<Set<ThumbnailMetadata>> r1 = new MutableLiveData();
        this._selectedItems = r1;
        this.selectedItems = r1;
        MutableLiveData<Integer> r2 = new MutableLiveData();
        this._selectedCount = r2;
        this.selectedCount = r2;
        MutableLiveData<Boolean> r3 = new MutableLiveData();
        this._isAllSelected = r3;
        this.isAllSelected = r3;
        MutableLiveData<Boolean> r4 = new MutableLiveData();
        this._isLoading = r4;
        this.isLoading = r4;
        MutableLiveData<String> r5 = new MutableLiveData();
        this._errorMessage = r5;
        this.errorMessage = r5;
        MutableLiveData<List<Long>> r6 = new MutableLiveData();
        this._deleteCompleteEvent = r6;
        this.deleteCompleteEvent = r6;
        MutableLiveData<Integer> r7 = new MutableLiveData();
        this._syncCompleteEvent = r7;
        this.syncCompleteEvent = r7;
        MutableLiveData<Integer> r8 = new MutableLiveData();
        this._imageCount = r8;
        this.imageCount = r8;
        MutableLiveData<Integer> r9 = new MutableLiveData();
        this._videoCount = r9;
        this.videoCount = r9;
        this.MIN_REFRESH_INTERVAL = 1000;
        MutableLiveData<Boolean> r10 = new MutableLiveData(Boolean.FALSE);
        this._isSelectionMode = r10;
        this.isSelectionMode = r10;
        this.isFirstLoad = true;
        loadThumbnailList();
        r0.observeForever(new b(new e(this)));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null);
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getDataChangeListeners$cp() {
        return dataChangeListeners;
    }

    public final LiveData<List<Long>> getDeleteCompleteEvent() {
        return this.deleteCompleteEvent;
    }

    public final LiveData<String> getErrorMessage() {
        return this.errorMessage;
    }

    public final LiveData<Integer> getImageCount() {
        return this.imageCount;
    }

    public final LiveData<Integer> getSelectedCount() {
        return this.selectedCount;
    }

    public final LiveData<Integer> getSyncCompleteEvent() {
        return this.syncCompleteEvent;
    }

    public final LiveData<List<ThumbnailMetadata>> getThumbnailList() {
        return this.thumbnailList;
    }

    public final LiveData<Integer> getVideoCount() {
        return this.videoCount;
    }

    public final LiveData<Boolean> isAllSelected() {
        return this.isAllSelected;
    }

    public final LiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public final LiveData<Boolean> isSelectionMode() {
        return this.isSelectionMode;
    }

    public final LiveData<Set<ThumbnailMetadata>> getSelectedItems() {
        return this.selectedItems;
    }

    public static final /* synthetic */ MutableLiveData access$get_deleteCompleteEvent$p(ThumbnailViewModel r0) {
        return r0._deleteCompleteEvent;
    }

    public static final /* synthetic */ MutableLiveData access$get_errorMessage$p(ThumbnailViewModel r0) {
        return r0._errorMessage;
    }

    public static final /* synthetic */ MutableLiveData access$get_isLoading$p(ThumbnailViewModel r0) {
        return r0._isLoading;
    }

    public static final /* synthetic */ MutableLiveData access$get_thumbnailList$p(ThumbnailViewModel r0) {
        return r0._thumbnailList;
    }

    public static final /* synthetic */ void access$updateStats(ThumbnailViewModel r0) {
        r0.updateStats();
    }

    private final Object refreshThumbnailListWithDelay(Continuation<? super Unit> r10) {
        if ((r10 instanceof C01231) == false) goto L7;
        C01231 r3 = (C01231) r10;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r11 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L15;
        if (r6 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L23 Exception -> L25
    L19:
        List r12 = (List) r11;     // Catch: Throwable -> L23 Exception -> L25
        this._thumbnailList.setValue(r12);     // Catch: Throwable -> L23 Exception -> L25
        updateStats();     // Catch: Throwable -> L23 Exception -> L25
        this.lastLoadTime = System.currentTimeMillis();     // Catch: Throwable -> L23 Exception -> L25
        Companion.getClass();     // Catch: Throwable -> L23 Exception -> L25
        Iterator r7 = access$getDataChangeListeners$cp().iterator();     // Catch: Throwable -> L23 Exception -> L25
    L21:
        if (r7.hasNext() == false) goto L27;
        ((d) r7.next()).VO();     // Catch: Throwable -> L23 Exception -> L25
        goto L21
    L27:
        FLogger.a.i(TAG, "Refreshed " + r12.size() + " thumbnails, sorted by createTime descending");     // Catch: Throwable -> L23 Exception -> L25
    L30:
        this._isLoading.setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        this._isLoading.setValue(Boxing.boxBoolean(true));
        AlbumDataBaseHelper r13 = AlbumDataBaseHelper.a;     // Catch: Throwable -> L23 Exception -> L25
        r3.label = 1;     // Catch: Throwable -> L23 Exception -> L25
        r11 = r13.n(r3);     // Catch: Throwable -> L23 Exception -> L25
        if (r11 != r5) goto L19;
        return r5;
    L25:
        e = move-exception;
        this._errorMessage.setValue("刷新缩略图失败: " + e.getMessage());     // Catch: Throwable -> L23
        FLogger.a.e(TAG, "Error refreshing thumbnails: " + e.getMessage(), e);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        this._isLoading.setValue(Boxing.boxBoolean(false));
        throw th;
    L7:
        r3 = new C01231(this, r10);
        goto L8
    }

    public final void applySelection(Set<ThumbnailMetadata> r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedItems");
        this._selectedItems.setValue(r2);
        updateSelectedCount();
    }

    public final void deleteSelected(List<ThumbnailMetadata> r9) {
        Intrinsics.checkNotNullParameter(r9, "selectedItems");
        this._isLoading.setValue(Boolean.TRUE);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r9, this, null), 3, null);
    }

    public final void onSyncComplete(int r4) {
        this._syncCompleteEvent.setValue(Integer.valueOf(r4));
        Companion.getClass();
        Iterator r0 = access$getDataChangeListeners$cp().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).cQ(r4);
        goto L4
    L6:
        FLogger.a.i(TAG, "Sync completed: " + r4 + " items");
    }

    public final void refreshThumbnailList(boolean r5) {
        long r0 = System.currentTimeMillis();
        if (r5 == false) goto L5;
    L8:
        loadThumbnailList();
        return;
    L5:
        if ((r0 - this.lastLoadTime) >= this.MIN_REFRESH_INTERVAL) goto L8;
        FLogger.a.d(TAG, "Refresh interval not reached, skipping load");
    }

    public final void toggleSelection(ThumbnailMetadata r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Set r0 = (Set) this._selectedItems.getValue();
        if (r0 == null) goto L6;
        Set r1 = CollectionsKt.toMutableSet(r0);
        if (r1 == null) goto L6;
    L8:
        if (r1.contains(r3) == false) goto L10;
        r1.remove(r3);
    L11:
        this._selectedItems.setValue(r1);
        updateSelectedCount();
        if (Intrinsics.areEqual(this._isSelectionMode.getValue(), Boolean.TRUE) == true) goto L14;
        return;
    L14:
        if (r1.isEmpty() == false) goto L18;
        FLogger.a.i(TAG, "No selected items in selection mode, auto exit");
        exitSelectionMode();
        return;
    L18:
        return;
    L10:
        r1.add(r3);
    L6:
        r1 = new LinkedHashSet();
        goto L8
    }

    private static final Unit _init_$lambda$0(ThumbnailViewModel r5, List r6) {
        if (r6 != null) goto L5;
    L18:
        if (r6 != null) goto L20;
    L25:
        return Unit.INSTANCE;
    L20:
        if (r6.isEmpty() == false) goto L25;
        if (r5.isFirstLoad == false) goto L25;
        r5.isFirstLoad = false;
        FLogger.a.i(TAG, "First load completed with empty list, isFirstLoad=false to prevent auto-select for new items");
        goto L25
    L5:
        if ((!r6.isEmpty()) == false) goto L18;
        if (r5.isFirstLoad == false) goto L10;
        r5.selectAll();
        r5.isFirstLoad = false;
        r5.previousListSize = r6.size();
        FLogger.a.i(TAG, "First load completed: select all items, count=" + r6.size());
        goto L25
    L10:
        if (r6.size() <= r5.previousListSize) goto L17;
        int r0 = r6.size() - r5.previousListSize;
        FLogger r2 = FLogger.a;
        r2.i(TAG, "New items detected: added " + r0 + " items, total size=" + r6.size());
        Set r1 = (Set) r5._selectedItems.getValue();
        if (r1 == null) goto L15;
        Set r3 = CollectionsKt.toMutableSet(r1);
        if (r3 == null) goto L15;
    L16:
        r5._selectedItems.setValue(r3);
        r5.updateSelectedCount();
        r2.i(TAG, "Selection state updated: kept " + r3.size() + " items selected, new items not selected");
        r5.previousListSize = r6.size();
    L15:
        r3 = new LinkedHashSet();
        goto L16
    L17:
        r5.previousListSize = r6.size();
        FLogger.a.d(TAG, "List size changed, but not a new item scenario, total size=" + r6.size());
        goto L25
    }

    public static final /* synthetic */ Object access$refreshThumbnailListWithDelay(ThumbnailViewModel r0, Continuation r1) {
        return r0.refreshThumbnailListWithDelay(r1);
    }

    public static final /* synthetic */ void access$setLastLoadTime$p(ThumbnailViewModel r0, long r1) {
        r0.lastLoadTime = r1;
    }

    public static /* synthetic */ void refreshThumbnailList$default(ThumbnailViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.refreshThumbnailList(r1);
    }
}
