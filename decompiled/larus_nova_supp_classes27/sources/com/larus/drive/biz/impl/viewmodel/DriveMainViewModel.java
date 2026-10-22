package com.larus.drive.biz.impl.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0007H\u0014R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/larus/drive/biz/impl/viewmodel/DriveMainViewModel;", "Lcom/larus/drive/biz/impl/viewmodel/AbsDrivePageViewModel;", "<init>", "()V", "uploadTasks", "Landroidx/lifecycle/LiveData;", "", "", "Lcom/larus/drive/biz/api/model/DriveUploadItem;", "getUploadTasks", "()Landroidx/lifecycle/LiveData;", "getTag", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMainViewModel extends AbsDrivePageViewModel {
    public static final a Companion = null;
    private static final String TAG = "DriveListViewModel";
    private final LiveData<Map<String, com.larus.drive.biz.api.model.a>> uploadTasks;

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.DriveMainViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.DriveMainViewModel$1", f = "DriveMainViewModel.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.L$0 = r2;
            return r0;
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
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r7);
        L16:
            if (r7 == null) goto L33;
            Lazy r8 = com.larus.drive.biz.impl.file.t.a;
            Map r9 = (Map) com.larus.drive.biz.impl.file.t.f().getValue();
            if (r9 == null) goto L23;
            Collection r10 = r9.values();
            if (r10 == null) goto L23;
            List r11 = CollectionsKt.toList(r10);
            if (r11 == null) goto L23;
        L24:
            Iterator r12 = r11.iterator();
        L26:
            if (r12.hasNext() == false) goto L33;
            com.larus.drive.biz.api.model.a r3 = (com.larus.drive.biz.api.model.a) r12.next();
            if (CoroutineScopeKt.isActive(r2) == false) goto L30;
            Lazy r4 = com.larus.drive.biz.impl.file.t.a;
            com.larus.drive.biz.impl.file.t.j(r3, true);
            goto L26
        L30:
            return Unit.INSTANCE;
        L23:
            r11 = CollectionsKt.emptyList();
        L33:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineScope r13 = (CoroutineScope) this.L$0;
            IOfficeSdkServiceV2 r5 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
            if (r5 == null) goto L11;
            IOfficeSdkServiceV2.a.b(r5, false, "drive_auto_resume_upload", 5);
            this.L$0 = r13;
            this.label = 1;
            Object r6 = IOfficeSdkServiceV2.a.a(r5, this);
            if (r6 != r0) goto L15;
            return r0;
        L15:
            r2 = r13;
            r7 = r6;
            goto L16
        L11:
            return Unit.INSTANCE;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(y r2) {
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

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Po(MediatorLiveData r0, Map r1) {
        return uploadTasks$lambda$1$lambda$0(r0, r1);
    }

    @Override // com.larus.drive.biz.impl.viewmodel.AbsDrivePageViewModel
    public String getTag() {
        return TAG;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.drive.biz.impl.viewmodel.y] */
    public DriveMainViewModel() {
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(com.larus.drive.biz.impl.file.t.f, new b(new y(r0)));
        this.uploadTasks = r0;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public final LiveData<Map<String, com.larus.drive.biz.api.model.a>> getUploadTasks() {
        return this.uploadTasks;
    }

    private static final Unit uploadTasks$lambda$1$lambda$0(MediatorLiveData r0, Map r1) {
        r0.setValue(r1);
        return Unit.INSTANCE;
    }
}
