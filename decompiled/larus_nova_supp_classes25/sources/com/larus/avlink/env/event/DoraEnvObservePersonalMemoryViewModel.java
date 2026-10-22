package com.larus.avlink.env.event;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.avlink.env.event.api.DoraEnvObservePersonalMemoryApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.FlowDoraSubBizType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u001bJ\u0015\u0010$\u001a\u00020\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\rH\u0002J \u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0002J\u0006\u0010(\u001a\u00020\u001bJ\u001e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0010J\u0016\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010/\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020 R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000bR\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000b¨\u00060"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_entries", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/avlink/env/event/api/UserProfileEntry;", "entries", "Landroidx/lifecycle/LiveData;", "getEntries", "()Landroidx/lifecycle/LiveData;", "productId", "", "Ljava/lang/Integer;", "_error", "", "error", "getError", "_saveSuccess", "", "saveSuccess", "getSaveSuccess", "_deleteSuccess", "deleteSuccess", "getDeleteSuccess", "resetSaveSuccess", "", "resetDeleteSuccess", "_isLoadDataLoading", "isLoadDataLoading", "_addResultCode", "", "addResultCode", "getAddResultCode", "resetAddResultCode", "setProductId", "(Ljava/lang/Integer;)V", "getDoraSubBiz", "sanitizeEntries", "loadData", "addMemory", "content", "maxEntries", "clientReqId", "updateMemory", "entryId", "deleteMemory", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObservePersonalMemoryViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<Long> _addResultCode;
    private final MutableLiveData<Boolean> _deleteSuccess;
    private final MutableLiveData<List<n98.e>> _entries;
    private final MutableLiveData<String> _error;
    private final MutableLiveData<Boolean> _isLoadDataLoading;
    private final MutableLiveData<Boolean> _saveSuccess;
    private final LiveData<Long> addResultCode;
    private final LiveData<Boolean> deleteSuccess;
    private final LiveData<List<n98.e>> entries;
    private final LiveData<String> error;
    private final LiveData<Boolean> isLoadDataLoading;
    private Integer productId;
    private final LiveData<Boolean> saveSuccess;

    /* JADX INFO: renamed from: com.larus.avlink.env.event.DoraEnvObservePersonalMemoryViewModel$addMemory$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.event.DoraEnvObservePersonalMemoryViewModel$addMemory$1", f = "DoraEnvObservePersonalMemoryViewModel.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $clientReqId;
        final /* synthetic */ String $content;
        final /* synthetic */ long $maxEntries;
        int label;
        final /* synthetic */ DoraEnvObservePersonalMemoryViewModel this$0;

        public AnonymousClass1(DoraEnvObservePersonalMemoryViewModel r1, String r2, String r3, long r4, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$content = r2;
            this.$clientReqId = r3;
            this.$maxEntries = r4;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$content, this.$clientReqId, this.$maxEntries, r9);
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
            List<n98.e> r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L11:
            dm9.a.b r10 = (dm9.a) r9;
            if ((r10 instanceof dm9.a.b) == false) goto L18;
            MutableLiveData r3 = DoraEnvObservePersonalMemoryViewModel.access$get_entries$p(this.this$0);
            DoraEnvObservePersonalMemoryViewModel r4 = this.this$0;
            dm9.a.b r11 = r10;
            n98.f r5 = (n98.f) r11.a.getData();
            if (r5 == null) goto L16;
            r2 = r5.a();
        L16:
            r3.setValue(DoraEnvObservePersonalMemoryViewModel.access$sanitizeEntries(r4, r2));
            DoraEnvObservePersonalMemoryViewModel.access$get_addResultCode$p(this.this$0).setValue(Boxing.boxLong(r11.a.getCode()));
            DoraEnvObservePersonalMemoryViewModel.access$get_saveSuccess$p(this.this$0).setValue(Boxing.boxBoolean(true));
        L21:
            return Unit.INSTANCE;
        L18:
            if ((r10 instanceof dm9.a.a) == false) goto L21;
            DoraEnvObservePersonalMemoryViewModel.access$get_saveSuccess$p(this.this$0).setValue(Boxing.boxBoolean(false));
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            n98.a r12 = new n98.a(Boxing.boxInt(DoraEnvObservePersonalMemoryViewModel.access$getDoraSubBiz(this.this$0)), this.$content, this.$clientReqId, Boxing.boxLong(this.$maxEntries));
            DoraEnvObservePersonalMemoryApi.a r6 = DoraEnvObservePersonalMemoryApi.a;
            DoraEnvObservePersonalMemoryViewModel$addMemory$1$result$1 r7 = new DoraEnvObservePersonalMemoryViewModel$addMemory$1$result$1(r12, null);
            this.label = 1;
            r6.getClass();
            r9 = DoraEnvObservePersonalMemoryApi.a.a(r7, this);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.event.DoraEnvObservePersonalMemoryViewModel$deleteMemory$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.event.DoraEnvObservePersonalMemoryViewModel$deleteMemory$1", f = "DoraEnvObservePersonalMemoryViewModel.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $entryId;
        int label;
        final /* synthetic */ DoraEnvObservePersonalMemoryViewModel this$0;

        public C01111(DoraEnvObservePersonalMemoryViewModel r1, long r2, Continuation<? super C01111> r4) {
            this.this$0 = r1;
            this.$entryId = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01111(this.this$0, this.$entryId, r5);
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
            List<n98.e> r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            dm9.a.b r8 = (dm9.a) r7;
            if ((r8 instanceof dm9.a.b) == false) goto L18;
            MutableLiveData r3 = DoraEnvObservePersonalMemoryViewModel.access$get_entries$p(this.this$0);
            DoraEnvObservePersonalMemoryViewModel r4 = this.this$0;
            n98.f r9 = (n98.f) r8.a.getData();
            if (r9 == null) goto L16;
            r2 = r9.a();
        L16:
            r3.setValue(DoraEnvObservePersonalMemoryViewModel.access$sanitizeEntries(r4, r2));
            DoraEnvObservePersonalMemoryViewModel.access$get_deleteSuccess$p(this.this$0).setValue(Boxing.boxBoolean(true));
        L21:
            return Unit.INSTANCE;
        L18:
            if ((r8 instanceof dm9.a.a) == false) goto L21;
            DoraEnvObservePersonalMemoryViewModel.access$get_deleteSuccess$p(this.this$0).setValue(Boxing.boxBoolean(false));
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            n98.b r10 = new n98.b(Boxing.boxInt(DoraEnvObservePersonalMemoryViewModel.access$getDoraSubBiz(this.this$0)), Boxing.boxLong(this.$entryId));
            DoraEnvObservePersonalMemoryApi.a r5 = DoraEnvObservePersonalMemoryApi.a;
            DoraEnvObservePersonalMemoryViewModel$deleteMemory$1$result$1 r6 = new DoraEnvObservePersonalMemoryViewModel$deleteMemory$1$result$1(r10, null);
            this.label = 1;
            r5.getClass();
            r7 = DoraEnvObservePersonalMemoryApi.a.a(r6, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.event.DoraEnvObservePersonalMemoryViewModel$loadData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.event.DoraEnvObservePersonalMemoryViewModel$loadData$1", f = "DoraEnvObservePersonalMemoryViewModel.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraEnvObservePersonalMemoryViewModel this$0;

        public C01121(DoraEnvObservePersonalMemoryViewModel r1, Continuation<? super C01121> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01121(this.this$0, r3);
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
            List<n98.e> r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            dm9.a.b r7 = (dm9.a) r6;
            if ((r7 instanceof dm9.a.b) == false) goto L18;
            MutableLiveData r3 = DoraEnvObservePersonalMemoryViewModel.access$get_entries$p(this.this$0);
            DoraEnvObservePersonalMemoryViewModel r4 = this.this$0;
            n98.f r8 = (n98.f) r7.a.getData();
            if (r8 == null) goto L16;
            r2 = r8.a();
        L16:
            r3.setValue(DoraEnvObservePersonalMemoryViewModel.access$sanitizeEntries(r4, r2));
        L25:
            DoraEnvObservePersonalMemoryViewModel.access$get_isLoadDataLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L18:
            if ((r7 instanceof dm9.a.a) == false) goto L25;
            MutableLiveData r5 = DoraEnvObservePersonalMemoryViewModel.access$get_error$p(this.this$0);
            Throwable r9 = ((dm9.a.a) r7).c;
            if (r9 == null) goto L23;
            String r10 = r9.getMessage();
            if (r10 == null) goto L23;
        L24:
            r5.setValue(r10);
        L23:
            r10 = "Failed to load data";
            goto L24
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            DoraEnvObservePersonalMemoryViewModel.access$get_isLoadDataLoading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            DoraEnvObservePersonalMemoryViewModel.access$get_error$p(this.this$0).setValue(null);
            DoraEnvObservePersonalMemoryViewModel.access$get_entries$p(this.this$0).setValue(CollectionsKt.emptyList());
            n98.c r11 = new n98.c(Boxing.boxInt(DoraEnvObservePersonalMemoryViewModel.access$getDoraSubBiz(this.this$0)));
            DoraEnvObservePersonalMemoryApi.a r12 = DoraEnvObservePersonalMemoryApi.a;
            DoraEnvObservePersonalMemoryViewModel$loadData$1$result$1 r13 = new DoraEnvObservePersonalMemoryViewModel$loadData$1$result$1(r11, null);
            this.label = 1;
            r12.getClass();
            r6 = DoraEnvObservePersonalMemoryApi.a.a(r13, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.event.DoraEnvObservePersonalMemoryViewModel$updateMemory$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.event.DoraEnvObservePersonalMemoryViewModel$updateMemory$1", f = "DoraEnvObservePersonalMemoryViewModel.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ long $entryId;
        int label;
        final /* synthetic */ DoraEnvObservePersonalMemoryViewModel this$0;

        public C01131(DoraEnvObservePersonalMemoryViewModel r1, long r2, String r4, Continuation<? super C01131> r5) {
            this.this$0 = r1;
            this.$entryId = r2;
            this.$content = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01131(this.this$0, this.$entryId, this.$content, r8);
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
            List<n98.e> r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            dm9.a.b r8 = (dm9.a) r7;
            if ((r8 instanceof dm9.a.b) == false) goto L18;
            MutableLiveData r3 = DoraEnvObservePersonalMemoryViewModel.access$get_entries$p(this.this$0);
            DoraEnvObservePersonalMemoryViewModel r4 = this.this$0;
            n98.f r9 = (n98.f) r8.a.getData();
            if (r9 == null) goto L16;
            r2 = r9.a();
        L16:
            r3.setValue(DoraEnvObservePersonalMemoryViewModel.access$sanitizeEntries(r4, r2));
            DoraEnvObservePersonalMemoryViewModel.access$get_saveSuccess$p(this.this$0).setValue(Boxing.boxBoolean(true));
        L21:
            return Unit.INSTANCE;
        L18:
            if ((r8 instanceof dm9.a.a) == false) goto L21;
            DoraEnvObservePersonalMemoryViewModel.access$get_saveSuccess$p(this.this$0).setValue(Boxing.boxBoolean(false));
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            n98.d r10 = new n98.d(Boxing.boxInt(DoraEnvObservePersonalMemoryViewModel.access$getDoraSubBiz(this.this$0)), Boxing.boxLong(this.$entryId), this.$content);
            DoraEnvObservePersonalMemoryApi.a r5 = DoraEnvObservePersonalMemoryApi.a;
            DoraEnvObservePersonalMemoryViewModel$updateMemory$1$result$1 r6 = new DoraEnvObservePersonalMemoryViewModel$updateMemory$1$result$1(r10, null);
            this.label = 1;
            r5.getClass();
            r7 = DoraEnvObservePersonalMemoryApi.a.a(r6, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    private final int getDoraSubBiz() {
        FlowDoraSubBizType.a r0 = FlowDoraSubBizType.Companion;
        Integer r1 = this.productId;
        r0.getClass();
        return FlowDoraSubBizType.a.b(r1);
    }

    public final void resetAddResultCode() {
        this._addResultCode.setValue(null);
    }

    public final void resetDeleteSuccess() {
        this._deleteSuccess.setValue(null);
    }

    public final void resetSaveSuccess() {
        this._saveSuccess.setValue(null);
    }

    public DoraEnvObservePersonalMemoryViewModel() {
        MutableLiveData<List<n98.e>> r0 = new MutableLiveData();
        this._entries = r0;
        this.entries = r0;
        MutableLiveData<String> r1 = new MutableLiveData();
        this._error = r1;
        this.error = r1;
        MutableLiveData<Boolean> r2 = new MutableLiveData();
        this._saveSuccess = r2;
        this.saveSuccess = r2;
        MutableLiveData<Boolean> r3 = new MutableLiveData();
        this._deleteSuccess = r3;
        this.deleteSuccess = r3;
        MutableLiveData<Boolean> r4 = new MutableLiveData();
        this._isLoadDataLoading = r4;
        this.isLoadDataLoading = r4;
        MutableLiveData<Long> r5 = new MutableLiveData();
        this._addResultCode = r5;
        this.addResultCode = r5;
    }

    public final void loadData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01121(this, null), 3, null);
    }

    public final LiveData<Long> getAddResultCode() {
        return this.addResultCode;
    }

    public final LiveData<Boolean> getDeleteSuccess() {
        return this.deleteSuccess;
    }

    public final LiveData<List<n98.e>> getEntries() {
        return this.entries;
    }

    public final LiveData<String> getError() {
        return this.error;
    }

    public final LiveData<Boolean> getSaveSuccess() {
        return this.saveSuccess;
    }

    public final LiveData<Boolean> isLoadDataLoading() {
        return this.isLoadDataLoading;
    }

    public static final /* synthetic */ int access$getDoraSubBiz(DoraEnvObservePersonalMemoryViewModel r0) {
        return r0.getDoraSubBiz();
    }

    public static final /* synthetic */ MutableLiveData access$get_addResultCode$p(DoraEnvObservePersonalMemoryViewModel r0) {
        return r0._addResultCode;
    }

    public static final /* synthetic */ MutableLiveData access$get_deleteSuccess$p(DoraEnvObservePersonalMemoryViewModel r0) {
        return r0._deleteSuccess;
    }

    public static final /* synthetic */ MutableLiveData access$get_entries$p(DoraEnvObservePersonalMemoryViewModel r0) {
        return r0._entries;
    }

    public static final /* synthetic */ MutableLiveData access$get_error$p(DoraEnvObservePersonalMemoryViewModel r0) {
        return r0._error;
    }

    public static final /* synthetic */ MutableLiveData access$get_isLoadDataLoading$p(DoraEnvObservePersonalMemoryViewModel r0) {
        return r0._isLoadDataLoading;
    }

    public static final /* synthetic */ MutableLiveData access$get_saveSuccess$p(DoraEnvObservePersonalMemoryViewModel r0) {
        return r0._saveSuccess;
    }

    private final List<n98.e> sanitizeEntries(List<n98.e> r1) {
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        return CollectionsKt.filterNotNull(r1);
    }

    public final void deleteMemory(long r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01111(this, r7, null), 3, null);
    }

    public final void setProductId(Integer r1) {
        this.productId = r1;
    }

    public static final /* synthetic */ List access$sanitizeEntries(DoraEnvObservePersonalMemoryViewModel r0, List r1) {
        return r0.sanitizeEntries(r1);
    }

    public final void updateMemory(long r11, String r13) {
        Intrinsics.checkNotNullParameter(r13, "content");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01131(this, r11, r13, null), 3, null);
    }

    public final void addMemory(String r12, long r13, String r15) {
        Intrinsics.checkNotNullParameter(r12, "content");
        Intrinsics.checkNotNullParameter(r15, "clientReqId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r12, r15, r13, null), 3, null);
    }
}
