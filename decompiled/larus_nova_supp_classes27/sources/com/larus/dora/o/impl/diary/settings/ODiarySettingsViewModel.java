package com.larus.dora.o.impl.diary.settings;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.o.impl.diary.DoraODiaryRepo;
import com.larus.dora.o.impl.diary.t0;
import com.larus.dora.o.impl.diary.u0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/o/impl/diary/settings/ODiarySettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_photoEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "photoEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "getPhotoEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "_styleName", "", "styleName", "getStyleName", "loadPhotoEnabled", "", "setPhotoEnabled", "enabled", "refreshStyleName", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiarySettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "ODiarySettingsViewModel";
    private final z0<Boolean> _photoEnabled;
    private final z0<String> _styleName;
    private final i1<Boolean> photoEnabled;
    private final i1<String> styleName;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.settings.ODiarySettingsViewModel$refreshStyleName$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.settings.ODiarySettingsViewModel$refreshStyleName$1", f = "ODiarySettingsViewModel.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ODiarySettingsViewModel this$0;

        public AnonymousClass1(ODiarySettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            u0 r7 = (u0) r6;
            String r2 = null;
            if (r7 == null) goto L25;
            List<t0> r8 = r7.b();
            if (r8 == null) goto L25;
            List r9 = CollectionsKt.filterNotNull(r8);
            if (r9 == null) goto L25;
            Iterator r10 = r9.iterator();
        L19:
            if (r10.hasNext() == false) goto L23;
            Object r3 = r10.next();
            if (Intrinsics.areEqual(((t0) r3).f(), Boxing.boxBoolean(true)) == false) goto L19;
        L24:
            t0 r4 = (t0) r3;
        L26:
            if (r4 != null) goto L28;
            FLogger.a.i(ODiarySettingsViewModel.TAG, "refreshStyleName: no selected style");
        L28:
            z0 r11 = ODiarySettingsViewModel.access$get_styleName$p(this.this$0);
            if (r4 == null) goto L31;
            r2 = r4.d();
        L31:
            r11.setValue(r2);
            return Unit.INSTANCE;
        L23:
            r3 = null;
        L25:
            r4 = null;
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            DoraODiaryRepo r12 = DoraODiaryRepo.a;
            this.label = 1;
            r6 = r12.g(this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit yo(ODiarySettingsViewModel r0, boolean r1) {
        return loadPhotoEnabled$lambda$0(r0, r1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.dora.o.impl.diary.settings.f] */
    public final void loadPhotoEnabled() {
        IDoraAVLinkService r0 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r0 == null) goto L6;
        r0.W0(new f(this));
        return;
    }

    public ODiarySettingsViewModel() {
        StateFlowImpl r0 = j1.a(Boolean.FALSE);
        this._photoEnabled = r0;
        this.photoEnabled = r0;
        StateFlowImpl r1 = j1.a(null);
        this._styleName = r1;
        this.styleName = r1;
    }

    public final void refreshStyleName() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final i1<Boolean> getPhotoEnabled() {
        return this.photoEnabled;
    }

    public final i1<String> getStyleName() {
        return this.styleName;
    }

    public static final /* synthetic */ z0 access$get_styleName$p(ODiarySettingsViewModel r0) {
        return r0._styleName;
    }

    public final void setPhotoEnabled(boolean r3) {
        this._photoEnabled.setValue(Boolean.valueOf(r3));
        IDoraAVLinkService r0 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r0 == null) goto L6;
        r0.d1(r3);
        return;
    }

    private static final Unit loadPhotoEnabled$lambda$0(ODiarySettingsViewModel r0, boolean r1) {
        r0._photoEnabled.setValue(Boolean.valueOf(r1));
        return Unit.INSTANCE;
    }
}
