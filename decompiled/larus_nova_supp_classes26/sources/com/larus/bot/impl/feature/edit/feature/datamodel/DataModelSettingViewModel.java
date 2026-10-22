package com.larus.bot.impl.feature.edit.feature.datamodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.kunminx.architecture.domain.message.MutableResult;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00170\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/datamodel/DataModelSettingViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/larus/bot/impl/repository/UgcBotRepo;", "modelSelect", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/im/bean/bot/ModelItem;", "getModelSelect", "()Landroidx/lifecycle/MutableLiveData;", "modelSelect$delegate", "Lkotlin/Lazy;", "modelUpdate", "Lcom/kunminx/architecture/domain/message/MutableResult;", "Lcom/larus/bmhome/bot/bean/ModelUpdateResult;", "getModelUpdate", "()Lcom/kunminx/architecture/domain/message/MutableResult;", "modelUpdate$delegate", "getDataModels", "Landroidx/lifecycle/LiveData;", "", "selectModel", "", "data", "updateModel", "oldBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "newModelItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataModelSettingViewModel extends AndroidViewModel {
    private final Lazy modelSelect$delegate;
    private final Lazy modelUpdate$delegate;
    private final UgcBotRepo repo;

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.datamodel.DataModelSettingViewModel$updateModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.datamodel.DataModelSettingViewModel$updateModel$1", f = "DataModelSettingViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ModelItem $newModelItem;
        final /* synthetic */ BotModel $oldBotInfo;
        Object L$0;
        int label;
        final /* synthetic */ DataModelSettingViewModel this$0;

        public AnonymousClass1(DataModelSettingViewModel r1, BotModel r2, ModelItem r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$oldBotInfo = r2;
            this.$newModelItem = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$oldBotInfo, this.$newModelItem, r5);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            MutableResult<ub8.g> r2 = (MutableResult) this.L$0;
            ResultKt.throwOnFailure(r9);
        L18:
            r2.postValue(r9);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            MutableResult<ub8.g> r10 = this.this$0.getModelUpdate();
            UgcBotRepo r3 = DataModelSettingViewModel.access$getRepo$p(this.this$0);
            BotModel r4 = this.$oldBotInfo;
            ModelItem r5 = this.$newModelItem;
            this.L$0 = r10;
            this.label = 1;
            r3.getClass();
            j r6 = new j(IntrinsicsKt.intercepted(this), 1);
            r6.C();
            com.larus.im.d.a().modifyBotModelType(r4, r5.getModelType(), new com.larus.bot.impl.repository.i(r6, r5));
            Object r7 = r6.B();
            if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            DebugProbesKt.probeCoroutineSuspended(this);
        L12:
            if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
            r7 = (ub8.g) r7;
        L15:
            if (r7 != r0) goto L17;
            return r0;
        L17:
            r2 = r10;
            r9 = r7;
            goto L18
        }
    }

    public static /* synthetic */ List Mo(c1 r0) {
        return getDataModels$lambda$2(r0);
    }

    public static /* synthetic */ MutableResult No() {
        return modelUpdate_delegate$lambda$1();
    }

    public static /* synthetic */ MutableLiveData yo() {
        return modelSelect_delegate$lambda$0();
    }

    private static final MutableLiveData modelSelect_delegate$lambda$0() {
        return new MutableLiveData();
    }

    private static final MutableResult modelUpdate_delegate$lambda$1() {
        return new MutableResult();
    }

    public final LiveData<List<ModelItem>> getDataModels() {
        return Transformations.distinctUntilChanged(Transformations.map(AuthModelDelegate.b.c(), new i()));
    }

    public final MutableLiveData<ModelItem> getModelSelect() {
        return (MutableLiveData) this.modelSelect$delegate.getValue();
    }

    public final MutableResult<ub8.g> getModelUpdate() {
        return (MutableResult) this.modelUpdate$delegate.getValue();
    }

    public DataModelSettingViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        Lazy<UgcBotRepo> r3 = UgcBotRepo.d;
        this.repo = UgcBotRepo.a.a();
        this.modelSelect$delegate = LazyKt.lazy(new g());
        this.modelUpdate$delegate = LazyKt.lazy(new h());
    }

    public static final /* synthetic */ UgcBotRepo access$getRepo$p(DataModelSettingViewModel r0) {
        return r0.repo;
    }

    private static final List getDataModels$lambda$2(c1 r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        e0 r2 = (e0) r1.d;
        if (r2 == null) goto L7;
        List r3 = r2.L();
        if (r3 == null) goto L7;
        List r4 = CollectionsKt.filterNotNull(r3);
    L8:
        if (r4 == null) goto L10;
        return r4;
    L10:
        return CollectionsKt.emptyList();
    L7:
        r4 = null;
        goto L8
    }

    public final void selectModel(ModelItem r2) {
        getModelSelect().setValue(r2);
    }

    public final void updateModel(BotModel r8, ModelItem r9) {
        Intrinsics.checkNotNullParameter(r9, "newModelItem");
        if (r8 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, r9, null), 3, null);
    }
}
