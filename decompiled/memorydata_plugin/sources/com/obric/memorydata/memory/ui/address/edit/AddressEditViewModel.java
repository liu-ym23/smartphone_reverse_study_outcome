package com.obric.memorydata.memory.ui.address.edit;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.obric.memory.model.AddressInputRequest;
import com.bytedance.obric.memory.model.AddressInputResponse;
import com.bytedance.obric.memory.model.PoiItem;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.memorydata.awareness.api.LocationSnapshot;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.cl;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0003J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\tJ\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\u001bJ\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0012J\u0006\u0010+\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressEditViewModel;", "Landroidx/lifecycle/ViewModel;", "addressType", "", "<init>", "(Ljava/lang/String;)V", "_searchAddressList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "searchAddressList", "Lkotlinx/coroutines/flow/StateFlow;", "getSearchAddressList", "()Lkotlinx/coroutines/flow/StateFlow;", "_addressList", "addressList", "getAddressList", "_isInSearchMode", "", "isInSearchMode", "_canShowEmptyView", "canShowEmptyView", "getCanShowEmptyView", "currentGps", "Lkotlin/Pair;", "", "asyncRequestLocation", "", "clearSearchAddress", "isInSearching", "searchJob", "Lkotlinx/coroutines/Job;", "latestWaitProcessQuery", "searchAddress", ChatMessage.TYPE_QUERY, "buildSearchJob", "selectSearchAddress", MemoryKeyInfoEntity.KEY_ADDRESS, "selectAddress", "deleteAddress", "refreshAddressList", "updateSearchState", "enable", "isEditingAllowed", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AddressEditViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "AddressEditViewModel";
    private final ae<List<AddressInfo>> _addressList;
    private final ae<Boolean> _canShowEmptyView;
    private final ae<Boolean> _isInSearchMode;
    private final ae<List<AddressInfo>> _searchAddressList;
    private final ar<List<AddressInfo>> addressList;
    private final String addressType;
    private final ar<Boolean> canShowEmptyView;
    private volatile Pair<Double, Double> currentGps;
    private final ar<Boolean> isInSearchMode;
    private boolean isInSearching;
    private String latestWaitProcessQuery;
    private final ar<List<AddressInfo>> searchAddressList;
    private bx searchJob;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressEditViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditViewModel$buildSearchJob$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditViewModel$buildSearchJob$1", f = "AddressEditViewModel.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;
        final /* synthetic */ AddressEditViewModel this$0;

        AnonymousClass1(String r3, AddressEditViewModel r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$query = r3;
            this.this$0 = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$query, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r21) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L13;
            if (r2 != 1) goto L12;
            ResultKt.throwOnFailure(r21);     // Catch: Throwable -> L7 Exception -> L9
        L28:
            RunLog.INSTANCE.debug(AddressEditViewModel.TAG, "开始搜索地址");     // Catch: Throwable -> L7 Exception -> L9
            AddressEditViewModel.access$setInSearching$p(this.this$0, true);     // Catch: Throwable -> L7 Exception -> L9
            boolean r1 = com.obric.memorydata.b.a.f8796a.a();     // Catch: Throwable -> L7 Exception -> L9
            if (r1 == false) goto L31;
            Pair r7 = AddressEditViewModel.access$getCurrentGps$p(this.this$0);     // Catch: Throwable -> L7 Exception -> L9
        L32:
            if (r1 == true) goto L34;
            AddressEditViewModel.access$setCurrentGps$p(this.this$0, null);     // Catch: Throwable -> L7 Exception -> L9
        L34:
            AddressInputRequest r3 = new AddressInputRequest();     // Catch: Throwable -> L7 Exception -> L9
            r3.keyword = this.$query;     // Catch: Throwable -> L7 Exception -> L9
            r3.num = 1;     // Catch: Throwable -> L7 Exception -> L9
            r3.size = 10;     // Catch: Throwable -> L7 Exception -> L9
            if (r7 == null) goto L37;
            r3.longitude = String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r7.getFirst(), Number.class, "com.obric.memorydata.plugin")).doubleValue());     // Catch: Throwable -> L7 Exception -> L9
            r3.latitude = String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r7.getSecond(), Number.class, "com.obric.memorydata.plugin")).doubleValue());     // Catch: Throwable -> L7 Exception -> L9
        L37:
            AddressInputResponse r4 = com.bytedance.obric.memory.a.a.a(r3);     // Catch: Throwable -> L7 Exception -> L9
            if (r4.code == 0) goto L45;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AddressEditViewModel.TAG, "地址搜索请求失败，错误码=" + r4.code + "，信息=" + r4.msg, null, 4, null);     // Catch: Throwable -> L7 Exception -> L9
            AddressEditViewModel.access$get_searchAddressList$p(this.this$0).b(CollectionsKt.emptyList());     // Catch: Throwable -> L7 Exception -> L9
            AddressEditViewModel.access$get_canShowEmptyView$p(this.this$0).b(Boxing.boxBoolean(true));     // Catch: Throwable -> L7 Exception -> L9
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7 Exception -> L9
            AddressEditViewModel.access$setInSearching$p(this.this$0, false);
            if (AddressEditViewModel.access$getLatestWaitProcessQuery$p(this.this$0) == null) goto L43;
            AddressEditViewModel r6 = this.this$0;
            String r8 = AddressEditViewModel.access$getLatestWaitProcessQuery$p(r6);
            Intrinsics.checkNotNull(r8);
            r6.searchAddress(r8);
        L43:
            return r5;
        L45:
            if (r4.count != 0) goto L51;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AddressEditViewModel.TAG, "地址搜索结果为空", null, 4, null);     // Catch: Throwable -> L7 Exception -> L9
            AddressEditViewModel.access$get_searchAddressList$p(this.this$0).b(CollectionsKt.emptyList());     // Catch: Throwable -> L7 Exception -> L9
            AddressEditViewModel.access$get_canShowEmptyView$p(this.this$0).b(Boxing.boxBoolean(true));     // Catch: Throwable -> L7 Exception -> L9
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L7 Exception -> L9
            AddressEditViewModel.access$setInSearching$p(this.this$0, false);
            if (AddressEditViewModel.access$getLatestWaitProcessQuery$p(this.this$0) == null) goto L50;
            AddressEditViewModel r10 = this.this$0;
            String r11 = AddressEditViewModel.access$getLatestWaitProcessQuery$p(r10);
            Intrinsics.checkNotNull(r11);
            r10.searchAddress(r11);
        L50:
            return r9;
        L51:
            ae r12 = AddressEditViewModel.access$get_searchAddressList$p(this.this$0);     // Catch: Throwable -> L7 Exception -> L9
            List<PoiItem> r13 = r4.data;     // Catch: Throwable -> L7 Exception -> L9
            if (r13 == null) goto L58;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9
            Iterator r16 = r14.iterator();     // Catch: Throwable -> L7 Exception -> L9
        L55:
            if (r16.hasNext() == false) goto L57;
            PoiItem r17 = (PoiItem) ZeusTransformUtils.preCheckCast(r16.next(), PoiItem.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9
            String r18 = r17.adms.province.name + r17.adms.city.name + r17.adms.district.name + r17.adms.town.name;     // Catch: Throwable -> L7 Exception -> L9
            String r19 = r17.name;     // Catch: Throwable -> L7 Exception -> L9
            Intrinsics.checkNotNullExpressionValue(r19, ActivityLifecycle.NAME);     // Catch: Throwable -> L7 Exception -> L9
            r15.add(new AddressInfo(r19, r18, r17.longitude, r17.latitude, false, false, 32, null));     // Catch: Throwable -> L7 Exception -> L9
            goto L55
        L57:
            List r20 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9
        L59:
            r12.b(r20);     // Catch: Throwable -> L7 Exception -> L9
            AddressEditViewModel.access$setInSearching$p(this.this$0, false);
            if (AddressEditViewModel.access$getLatestWaitProcessQuery$p(this.this$0) == null) goto L68;
        L62:
            AddressEditViewModel r22 = this.this$0;
            String r23 = AddressEditViewModel.access$getLatestWaitProcessQuery$p(r22);
            Intrinsics.checkNotNull(r23);
            r22.searchAddress(r23);
        L68:
            return Unit.INSTANCE;
        L58:
            r20 = CollectionsKt.emptyList();     // Catch: Throwable -> L7 Exception -> L9
            goto L59
        L31:
            r7 = null;
            goto L32
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r21);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.$query, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L17;
            boolean r24 = true;
        L18:
            if (r24 == false) goto L25;
            AddressEditViewModel.access$get_searchAddressList$p(this.this$0).b(CollectionsKt.emptyList());     // Catch: Throwable -> L7 Exception -> L9
            Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L7 Exception -> L9
            AddressEditViewModel.access$setInSearching$p(this.this$0, false);
            if (AddressEditViewModel.access$getLatestWaitProcessQuery$p(this.this$0) == null) goto L23;
            AddressEditViewModel r26 = this.this$0;
            String r27 = AddressEditViewModel.access$getLatestWaitProcessQuery$p(r26);
            Intrinsics.checkNotNull(r27);
            r26.searchAddress(r27);
        L23:
            return r25;
        L25:
            Continuation r28 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 Exception -> L9
            this.label = 1;     // Catch: Throwable -> L7 Exception -> L9
            if (au.a(200, r28) != r0) goto L28;
            return r0;
        L17:
            r24 = false;
        L7:
            th = move-exception;
            AddressEditViewModel.access$setInSearching$p(this.this$0, false);
            if (AddressEditViewModel.access$getLatestWaitProcessQuery$p(this.this$0) == null) goto L72;
            AddressEditViewModel r29 = this.this$0;
            String r30 = AddressEditViewModel.access$getLatestWaitProcessQuery$p(r29);
            Intrinsics.checkNotNull(r30);
            r29.searchAddress(r30);
        L72:
            throw th;
        L9:
            e = move-exception;
            Log.e(AddressEditViewModel.TAG, "地址搜索失败：" + e.getMessage());     // Catch: Throwable -> L7
            AddressEditViewModel.access$get_searchAddressList$p(this.this$0).b(CollectionsKt.emptyList());     // Catch: Throwable -> L7
            AddressEditViewModel.access$setInSearching$p(this.this$0, false);
            if (AddressEditViewModel.access$getLatestWaitProcessQuery$p(this.this$0) == null) goto L68;
            goto L62
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditViewModel$refreshAddressList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditViewModel$refreshAddressList$1", f = "AddressEditViewModel.kt", i = {}, l = {248, 251}, m = "invokeSuspend", n = {}, s = {})
    static final class C11141 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddressEditViewModel this$0;

        C11141(AddressEditViewModel r3, Continuation<? super C11141> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11141(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11141) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11141.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            List r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
            ae r2 = AddressEditViewModel.access$get_addressList$p(this.this$0);
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (r2.emit(r9, r3) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new AddressEditViewModel$refreshAddressList$1$addresses$1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r8 = i.a(r10, r4, r5);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditViewModel$selectAddress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditViewModel$selectAddress$1", f = "AddressEditViewModel.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    static final class C11151 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ AddressInfo $address;
        int label;
        final /* synthetic */ AddressEditViewModel this$0;

        C11151(AddressEditViewModel r3, AddressInfo r4, Continuation<? super C11151> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$address = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11151(this.this$0, this.$address, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11151) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11151.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r19);
        L24:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r19);
            if (this.this$0.isEditingAllowed() == false) goto L11;
            List<AddressInfo> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Iterator r4 = ((List) ZeusTransformUtils.preCheckCast(AddressEditViewModel.access$get_addressList$p(this.this$0).c(), List.class, "com.obric.memorydata.plugin")).iterator();
        L14:
            if (r4.hasNext() == false) goto L20;
            AddressInfo r7 = (AddressInfo) ZeusTransformUtils.preCheckCast(r4.next(), AddressInfo.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(r7, this.$address) == false) goto L18;
            boolean r14 = true;
        L19:
            r3.add(AddressInfo.copy$default(r7, null, null, 0.0d, 0.0d, r14, false, 47, null));
            goto L14
        L18:
            r14 = false;
            goto L19
        L20:
            AddressManager.INSTANCE.updateUserSetAddress(r3, AddressEditViewModel.access$getAddressType$p(this.this$0));
            ae r5 = AddressEditViewModel.access$get_addressList$p(this.this$0);
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r5.emit(r3, r6) != r1) goto L24;
            return r1;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditViewModel$selectSearchAddress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditViewModel$selectSearchAddress$1", f = "AddressEditViewModel.kt", i = {}, l = {204, 205}, m = "invokeSuspend", n = {}, s = {})
    static final class C11161 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ AddressInfo $address;
        int label;
        final /* synthetic */ AddressEditViewModel this$0;

        C11161(AddressEditViewModel r3, AddressInfo r4, Continuation<? super C11161> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$address = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11161(this.this$0, this.$address, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11161) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11161.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r22) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r22);
        L35:
            this.this$0.clearSearchAddress();
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r22);
        L32:
            ae r3 = AddressEditViewModel.access$get_isInSearchMode$p(this.this$0);
            Boolean r4 = Boxing.boxBoolean(false);
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (r3.emit(r4, r5) != r1) goto L35;
            return r1;
        L10:
            ResultKt.throwOnFailure(r22);
            if (this.this$0.isEditingAllowed() == false) goto L13;
            List<AddressInfo> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Iterator r7 = ((List) ZeusTransformUtils.preCheckCast(AddressEditViewModel.access$get_addressList$p(this.this$0).c(), List.class, "com.obric.memorydata.plugin")).iterator();
            boolean r8 = false;
        L16:
            if (r7.hasNext() == false) goto L27;
            AddressInfo r10 = (AddressInfo) ZeusTransformUtils.preCheckCast(r7.next(), AddressInfo.class, "com.obric.memorydata.plugin");
            if (Math.abs(r10.getLongitude() - this.$address.getLongitude()) > 1.0E-4d) goto L26;
            if (Math.abs(r10.getLatitude() - this.$address.getLatitude()) > 1.0E-4d) goto L26;
            if (Intrinsics.areEqual(r10.getName(), this.$address.getName()) == false) goto L26;
            if (Intrinsics.areEqual(r10.getDetail(), this.$address.getDetail()) == false) goto L26;
            r6.add(AddressInfo.copy$default(r10, null, null, 0.0d, 0.0d, true, false, 47, null));
            r8 = true;
        L26:
            Boxing.boxBoolean(r6.add(AddressInfo.copy$default(r10, null, null, 0.0d, 0.0d, false, false, 47, null)));
            goto L16
        L27:
            if (r8 == true) goto L29;
            r6.add(AddressInfo.copy$default(this.$address, null, null, 0.0d, 0.0d, true, false, 47, null));
        L29:
            AddressManager.INSTANCE.updateUserSetAddress(r6, AddressEditViewModel.access$getAddressType$p(this.this$0));
            ae r9 = AddressEditViewModel.access$get_addressList$p(this.this$0);
            Continuation<? super Unit> r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r9.emit(r6, r11) != r1) goto L32;
            return r1;
        L13:
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new a(null);
    }

    public AddressEditViewModel(String r4) {
        Intrinsics.checkNotNullParameter(r4, "addressType");
        this.addressType = r4;
        ae<List<AddressInfo>> r0 = at.a(CollectionsKt.emptyList());
        this._searchAddressList = r0;
        this.searchAddressList = (ar) ZeusTransformUtils.preCheckCast(r0, ar.class, "com.obric.memorydata.plugin");
        ae<List<AddressInfo>> r5 = at.a(AddressManager.INSTANCE.getAddressList(r4));
        this._addressList = r5;
        this.addressList = (ar) ZeusTransformUtils.preCheckCast(r5, ar.class, "com.obric.memorydata.plugin");
        ae<Boolean> r1 = at.a(false);
        this._isInSearchMode = r1;
        this.isInSearchMode = (ar) ZeusTransformUtils.preCheckCast(r1, ar.class, "com.obric.memorydata.plugin");
        ae<Boolean> r6 = at.a(false);
        this._canShowEmptyView = r6;
        this.canShowEmptyView = (ar) ZeusTransformUtils.preCheckCast(r6, ar.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String access$getAddressType$p(AddressEditViewModel r0) {
        return r0.addressType;
    }

    public static final /* synthetic */ Pair access$getCurrentGps$p(AddressEditViewModel r0) {
        return r0.currentGps;
    }

    public static final /* synthetic */ String access$getLatestWaitProcessQuery$p(AddressEditViewModel r0) {
        return r0.latestWaitProcessQuery;
    }

    public static final /* synthetic */ ae access$get_addressList$p(AddressEditViewModel r0) {
        return r0._addressList;
    }

    public static final /* synthetic */ ae access$get_canShowEmptyView$p(AddressEditViewModel r0) {
        return r0._canShowEmptyView;
    }

    public static final /* synthetic */ ae access$get_isInSearchMode$p(AddressEditViewModel r0) {
        return r0._isInSearchMode;
    }

    public static final /* synthetic */ ae access$get_searchAddressList$p(AddressEditViewModel r0) {
        return r0._searchAddressList;
    }

    public static final /* synthetic */ void access$setCurrentGps$p(AddressEditViewModel r0, Pair r1) {
        r0.currentGps = r1;
    }

    public static final /* synthetic */ void access$setInSearching$p(AddressEditViewModel r0, boolean r1) {
        r0.isInSearching = r1;
    }

    private static final void asyncRequestLocation$lambda$0(AddressEditViewModel r8) {
        Pair<Double, Double> r1 = null;
        if (com.obric.memorydata.b.a.f8796a.a() == true) goto L6;
        r8.currentGps = null;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "未授予精确位置权限，跳过获取地址搜索位置", false, 4, null);
        return;
    L6:
        cl r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLocationDao().queryLastRecord();
        if (r0 != null) goto L9;
    L15:
        int r4 = 0;
    L17:
        if (r4 >= 3) goto L33;
        if (com.obric.memorydata.b.a.f8796a.a() == false) goto L20;
        List<Double> r5 = LocationSnapshot.INSTANCE.getLocation(ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS);
        if (r5 != null) goto L26;
        r4 = r4 + 1;
        goto L17
    L26:
        if (com.obric.memorydata.b.a.f8796a.a() == false) goto L28;
        r1 = new Pair(r5.get(0), r5.get(1));
    L28:
        r8.currentGps = r1;
        return;
    L20:
        r8.currentGps = null;
        return;
    L33:
        return;
    L9:
        if ((System.currentTimeMillis() - r0.c()) > ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L15;
        if (com.obric.memorydata.b.a.f8796a.a() == false) goto L13;
        r1 = new Pair(Double.valueOf(r0.d()), Double.valueOf(r0.e()));
    L13:
        r8.currentGps = r1;
    }

    private final bx buildSearchJob(String r9) {
        return i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9, this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public static /* synthetic */ void lambda$3cHqY2RwvKr4uYMQPXYR7oSTmx8(AddressEditViewModel r0) {
        asyncRequestLocation$lambda$0(r0);
    }

    public final void asyncRequestLocation() {
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$AddressEditViewModel$3cHqY2RwvKr4uYMQPXYR7oSTmx8(this));
    }

    public final void clearSearchAddress() {
        this._searchAddressList.b(CollectionsKt.emptyList());
        this._canShowEmptyView.b(false);
    }

    public final void deleteAddress(AddressInfo r18) {
        Intrinsics.checkNotNullParameter(r18, MemoryKeyInfoEntity.KEY_ADDRESS);
        if (isEditingAllowed() == true) goto L5;
        return;
    L5:
        List<AddressInfo> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((List) ZeusTransformUtils.preCheckCast(this._addressList.c(), List.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        AddressInfo r6 = (AddressInfo) ZeusTransformUtils.preCheckCast(r3.next(), AddressInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r6, r18) == true) goto L7;
        r2.add(AddressInfo.copy$default(r6, null, null, 0.0d, 0.0d, false, false, 63, null));
        goto L7
    L12:
        this._addressList.b(AddressManager.INSTANCE.sureOnlyOneAddressSelect(r2));
        AddressManager.INSTANCE.updateUserSetAddress((List) ZeusTransformUtils.preCheckCast(this._addressList.c(), List.class, "com.obric.memorydata.plugin"), this.addressType);
    }

    public final ar<List<AddressInfo>> getAddressList() {
        return this.addressList;
    }

    public final ar<Boolean> getCanShowEmptyView() {
        return this.canShowEmptyView;
    }

    public final ar<List<AddressInfo>> getSearchAddressList() {
        return this.searchAddressList;
    }

    public final boolean isEditingAllowed() {
        if (com.obric.memorydata.address.a.f8427a.a() == false) goto L12;
        AddressInfo r3 = AddressManager.INSTANCE.getAutoLearnAddress(this.addressType);
        if (r3 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L12;
        return false;
    L7:
        if (com.obric.memorydata.memory.api.model.a.a(r3) != true) goto L9;
        r4 = true;
    L12:
        return true;
    }

    public final ar<Boolean> isInSearchMode() {
        return this.isInSearchMode;
    }

    public final void refreshAddressList() {
        i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11141(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void searchAddress(String r4) {
        Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_QUERY);
        RunLog.INSTANCE.debug(TAG, "收到地址搜索请求");
        if (this.isInSearching == false) goto L6;
        this.latestWaitProcessQuery = r4;
        return;
    L6:
        this.latestWaitProcessQuery = null;
        bx r1 = this.searchJob;
        if (r1 == null) goto L9;
        bx.a.a(r1, null, 1, null);
    L9:
        this.searchJob = buildSearchJob(r4);
    }

    public final void selectAddress(AddressInfo r9) {
        Intrinsics.checkNotNullParameter(r9, MemoryKeyInfoEntity.KEY_ADDRESS);
        RunLog.INSTANCE.debug(TAG, "选中常用地址");
        i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11151(this, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void selectSearchAddress(AddressInfo r9) {
        Intrinsics.checkNotNullParameter(r9, MemoryKeyInfoEntity.KEY_ADDRESS);
        RunLog.INSTANCE.debug(TAG, "选中地址搜索结果");
        i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11161(this, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void updateSearchState(boolean r1) {
        this._isInSearchMode.b(Boolean.valueOf(r1));
    }
}
