package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmUploadLocationResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowMetaInfo;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.StatusBarUtil;
import iub.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u00013B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\n*\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0!2\u0006\u0010\"\u001a\u00020\nH\u0086@¢\u0006\u0004\b#\u0010$J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u0016J&\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u0004\u0018\u00010.*\u00020\u0016H\u0002J\u0018\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0011H\u0002J\u0006\u00102\u001a\u00020\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowViewModel;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviViewModel;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowUIEvent;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "markedSpeakerMapCache", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;", "Lkotlin/collections/LinkedHashMap;", "defaultState", "buildEndWindowUrl", "entity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmRecordingEndWindowEntity;", "getTailRecordId", "dispatchEvent", "", "event", "fetchData", "metaInfo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowMetaInfo;", "fetchTitle", "meetingId", "updateTitle", "Lkotlin/Result;", "newTitle", "updateTitle-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveUploadLocationIdentity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/location/MmLocationIdentity;", "uploadLocation", "locationIdentity", "latitude", "", "longitude", "locationName", "getRecordingSource", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "updateMarkedSpeaker", "clusterId", MmEndWindowAvatar.TYPE_SPEAKER, "getLatestEntity", "Factory", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEndWindowViewModel extends MviViewModel<d, Object, c> {
    private final Lazy logDetail$delegate;
    private volatile LinkedHashMap<String, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c> markedSpeakerMapCache;
    private final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a mmUccApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;

        public Factory(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
            Intrinsics.checkNotNullParameter(r2, "mmUccApi");
            this.a = r2;
        }

        public final <T extends ViewModel> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "modelClass");
            if (r2.isAssignableFrom(MmEndWindowViewModel.class) == false) goto L7;
            return new MmEndWindowViewModel(this.a);
        L7:
            return (T) super.create(r2);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowViewModel$fetchTitle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowViewModel$fetchTitle$1", f = "MmEndWindowViewModel.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $meetingId;
        int label;
        final /* synthetic */ MmEndWindowViewModel this$0;

        public C02181(MmEndWindowViewModel r1, String r2, Continuation<? super C02181> r3) {
            this.this$0 = r1;
            this.$meetingId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02181(this.this$0, this.$meetingId, r4);
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
            ResultKt.throwOnFailure(r7);
            Object r8 = ((Result) r7).unbox-impl();
        L11:
            MmEndWindowViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r8) == false) goto L17;
            final String r3 = (String) r8;
            int r4 = bwb.b.a;
            bwb.b.f(MmUiLogScene.END_WINDOW, "fetchTitle", "success, title=" + r3, MmEndWindowViewModel.access$getLogDetail(r2));
            if (StringsKt.isBlank(r3) == true) goto L17;
            final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r5 = r2.getState().a;
            final MmEndWindowMetaInfo r6 = r5.d;
            r2.setState(new MmEndWindowViewModel$fetchTitle$1$1$1(r5, r6, r3));
        L17:
            MmEndWindowViewModel r9 = this.this$0;
            Throwable r10 = Result.exceptionOrNull-impl(r8);
            if (r10 == null) goto L21;
            int r11 = bwb.b.a;
            bwb.b.d(MmUiLogScene.END_WINDOW, "fetchTitle", "fail, " + r10, MmEndWindowViewModel.access$getLogDetail(r9));
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            MmRecordingNetHelper r12 = MmEndWindowViewModel.access$getMmUccApi$p(this.this$0).G();
            String r13 = this.$meetingId;
            this.label = 1;
            r8 = r12.p(r13, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowViewModel$uploadLocation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowViewModel$uploadLocation$1", f = "MmEndWindowViewModel.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $latitude;
        final /* synthetic */ String $locationIdentity;
        final /* synthetic */ String $locationName;
        final /* synthetic */ double $longitude;
        int label;
        final /* synthetic */ MmEndWindowViewModel this$0;

        public C02201(MmEndWindowViewModel r1, String r2, double r3, double r5, String r7, Continuation<? super C02201> r8) {
            this.this$0 = r1;
            this.$locationIdentity = r2;
            this.$latitude = r3;
            this.$longitude = r5;
            this.$locationName = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C02201(this.this$0, this.$locationIdentity, this.$latitude, this.$longitude, this.$locationName, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
            Object r15 = ((Result) r14).unbox-impl();
        L11:
            MmEndWindowViewModel r2 = this.this$0;
            final double r3 = this.$longitude;
            final double r5 = this.$latitude;
            final String r7 = this.$locationName;
            if (Result.isSuccess-impl(r15) == false) goto L14;
            MmUploadLocationResponse r4 = (MmUploadLocationResponse) r15;
            int r6 = bwb.b.a;
            bwb.b.f(MmUiLogScene.END_WINDOW, "uploadLocation", "onSuccess", MmEndWindowViewModel.access$getLogDetail(r2));
            final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r8 = r2.getState().a;
            r2.setState(new MmEndWindowViewModel$uploadLocation$1$1$1(r8, r3, r5, r7));
        L14:
            MmEndWindowViewModel r9 = this.this$0;
            Throwable r16 = Result.exceptionOrNull-impl(r15);
            if (r16 == null) goto L18;
            int r10 = bwb.b.a;
            bwb.b.d(MmUiLogScene.END_WINDOW, "uploadLocation", "onError: " + r16, MmEndWindowViewModel.access$getLogDetail(r9));
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            MmEndWindowViewModel r17 = this.this$0;
            MmRecordingSource r11 = MmEndWindowViewModel.access$getRecordingSource(r17, r17.getState().a);
            MmRecordingNetHelper r12 = MmEndWindowViewModel.access$getMmUccApi$p(this.this$0).G();
            String r13 = this.$locationIdentity;
            double r18 = this.$latitude;
            double r19 = this.$longitude;
            String r20 = this.$locationName;
            boolean r110 = this.this$0.getState().a.b;
            this.label = 1;
            r15 = r12.z(r13, r18, r19, r20, r11, r110, this);
            if (r15 != r0) goto L11;
            return r0;
        }
    }

    private final String getLogDetail() {
        return (String) this.logDetail$delegate.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public d defaultState() {
        return new d(0);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c getLatestEntity() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r0 = getState().a;
        if ((!this.markedSpeakerMapCache.isEmpty()) == false) goto L6;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r1 = r0.g;
        LinkedHashMap<String, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c> r2 = this.markedSpeakerMapCache;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "markedSpeakerMap");
        return com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c.a(r0, null, null, new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b(r2), 959);
    L6:
        return r0;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ l defaultState() {
        return defaultState();
    }

    public MmEndWindowViewModel(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        this.mmUccApi = r2;
        this.logDetail$delegate = LazyKt.lazy(new MmEndWindowViewModel$logDetail$2(this));
        this.markedSpeakerMapCache = new LinkedHashMap();
    }

    public static final /* synthetic */ String access$getLogDetail(MmEndWindowViewModel r0) {
        return r0.getLogDetail();
    }

    public static final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a access$getMmUccApi$p(MmEndWindowViewModel r0) {
        return r0.mmUccApi;
    }

    private final String buildEndWindowUrl(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r7) {
        LarkAppContext.Companion.getClass();
        Application r0 = LarkAppContext.access$getInstance$cp().getContext();
        String r1 = this.mmUccApi.J().d();
        MmRecordingSource r2 = getRecordingSource(r7);
        if (r2 != null) goto L5;
        r2 = MmRecordingSource.DOUBAO_PERSONAL;
    L5:
        x r3 = r2.getEndWindowWebConfig();
        StringBuilder r4 = new StringBuilder(r1 + "/webview/preload-service-page");
        StringBuilder r5 = new StringBuilder("?aid=");
        r5.append(OfficeSDKManager.getAppId());
        r4.append(r5.toString());
        if (r7.i == false) goto L8;
        r4.append("&scene=hardware");
    L9:
        r4.append("&user_id=" + this.mmUccApi.getCurrentUserId());
        StringBuilder r6 = new StringBuilder("&device_id=");
        IDeviceInfoProvider r8 = OfficeSDKManager.getDeviceInfoProvider();
        if (r8 == null) goto L12;
        String r9 = r8.getDeviceId();
    L13:
        r6.append(r9);
        r4.append(r6.toString());
        r4.append("&app_version=" + r3.c);
        r4.append("&app_name=" + OfficeSDKManager.getAppName());
        r4.append("&meetingId=" + r7.d.getMeetingId());
        r4.append("&recordId=" + getTailRecordId(r7));
        r4.append("&hardwareRecordUniqueId=" + r7.d.getHardwareRecordId());
        r4.append("&hasNotes=" + r7.d.getHasNotes());
        Integer r10 = r7.d.getSaveNotes();
        if (r10 == null) goto L16;
        r4.append("&saveNotes=" + r10.intValue());
    L16:
        StringBuilder r11 = new StringBuilder("&status_bar_height=");
        int r12 = xvb.a.a;
        yub.d r13 = yub.d.a;
        Activity r14 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r14 == null) goto L19;
        int r15 = StatusBarUtil.getStatusBarHeight(r14);
    L20:
        r11.append(r15);
        r4.append(r11.toString());
        r4.append("&app_brand=" + r3.b);
        if (r2 != MmRecordingSource.FEISHU_DOUBAO) goto L23;
        r4.append("&isDoubaoInLark=1");
    L23:
        int r16 = this.mmUccApi.y().envType();
        if (r16 != 2) goto L26;
    L29:
        String r17 = this.mmUccApi.getSettingsService().k.getAiSummaryMobileExtraQuery();
        if (TextUtils.isEmpty(r17) == true) goto L32;
        r4.append("&" + r17);
    L32:
        r4.append("&webviewEntry=" + StringsKt.removePrefix(r3.a, "/webview/"));
        if (NetworkUtils.e(r0) == true) goto L35;
        r4.append("&disableUpdate=1");
    L35:
        String r18 = r4.toString();
        int r19 = bwb.b.a;
        bwb.b.f(MmUiLogScene.END_WINDOW, "buildEndWindowUrl", "url=" + r18, getLogDetail());
        return r18;
    L26:
        if (r16 == 3) goto L29;
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L32;
    L19:
        r15 = StatusBarUtil.getStatusBarHeight(LarkContext.getApplication());
        goto L20
    L12:
        r9 = null;
        goto L13
    L8:
        r4.append("&scene=summaryShare");
        goto L9
    }

    private final void fetchData(MmEndWindowMetaInfo r4) {
        String r5 = r4.getMeetingId();
        if (StringsKt.isBlank(r5) == false) goto L6;
        int r6 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "fetchData", "meetingId is blank", getLogDetail());
        return;
    L6:
        fetchTitle(r5);
    }

    private final void fetchTitle(String r7) {
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02181(this, r7, null), 3, null);
    }

    private final MmRecordingSource getRecordingSource(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r5) {
        Iterator r0 = MmRecordingSource.getEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((MmRecordingSource) r1).getValue(), r5.h.getSource()) == false) goto L4;
    L10:
        return (MmRecordingSource) r1;
    L8:
        r1 = null;
        goto L10
    }

    private final String getTailRecordId(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r3) {
        if (r3.i == false) goto L5;
    L8:
        String r0 = r3.d.getHardwareRecordId();
        if (StringsKt.isBlank(r0) == false) goto L12;
        return r3.d.getMeetingId();
    L12:
        return r0;
    L5:
        if (r3.d.isHardwareRecord() == true) goto L8;
        return r3.d.getMeetingId();
    }

    public void dispatchEvent(final c r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.END_WINDOW, "dispatchEvent", String.valueOf(r5), getLogDetail());
        if ((r5 instanceof c.a) == false) goto L6;
        c.a r1 = (c.a) r5;
        this.markedSpeakerMapCache = new LinkedHashMap(r1.a.g.a);
        setState(new AnonymousClass1(r5, this));
        fetchData(r1.a.d);
        return;
    L6:
        if ((r5 instanceof c.C0054c) == false) goto L9;
        setState(AnonymousClass2.INSTANCE);
        return;
    L9:
        if ((r5 instanceof c.b) == false) goto L13;
        c.b r6 = (c.b) r5;
        updateMarkedSpeaker(r6.a, r6.b);
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.b resolveUploadLocationIdentity(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        getRecordingSource(r5);
        return com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.c.a(r5.b, r5.a, r5.d.getToken(), r5.a, "");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ void dispatchEvent(j r1) {
        dispatchEvent((c) r1);
    }

    public static final /* synthetic */ String access$buildEndWindowUrl(MmEndWindowViewModel r0, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r1) {
        return r0.buildEndWindowUrl(r1);
    }

    public static final /* synthetic */ MmRecordingSource access$getRecordingSource(MmEndWindowViewModel r0, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r1) {
        return r0.getRecordingSource(r1);
    }

    private final void updateMarkedSpeaker(String r5, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r6) {
        if (Intrinsics.areEqual(this.markedSpeakerMapCache.put(r5, r6), r6) == true) goto L6;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r0 = getState().a;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r1 = r0.g;
        final LinkedHashMap r2 = new LinkedHashMap(r1.a);
        r2.put(r5, r6);
        setState(new C02191(r0, r1, r2));
        return;
    }

    /* JADX INFO: renamed from: updateTitle-gIAlu-s, reason: not valid java name */
    public final Object m407updateTitlegIAlus(final String r5, Continuation<? super Result<String>> r6) {
        if ((r6 instanceof MmEndWindowViewModel$updateTitle$1) == false) goto L7;
        MmEndWindowViewModel$updateTitle$1 r0 = (MmEndWindowViewModel$updateTitle$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L22:
        if (Result.isSuccess-impl(r8) == false) goto L24;
        String r4 = (String) r8;
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r9 = getState().a;
        setState(new MmEndWindowViewModel$updateTitle$2$1(r9, r5));
    L24:
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        String r10 = getState().a.d.getMeetingId();
        if (StringsKt.isBlank(r10) == false) goto L18;
        Result.Companion r11 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new Exception("meetingId is blank")));
    L18:
        MmRecordingNetHelper r12 = this.mmUccApi.G();
        r0.L$0 = r5;
        r0.label = 1;
        r8 = r12.y(r10, r5, r0);
        if (r8 != r2) goto L22;
        return r2;
    L7:
        r0 = new MmEndWindowViewModel$updateTitle$1(this, r6);
        goto L8
    }

    public final void uploadLocation(String r14, double r15, double r17, String r19) {
        Intrinsics.checkNotNullParameter(r14, "locationIdentity");
        Intrinsics.checkNotNullParameter(r19, "locationName");
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.END_WINDOW, "uploadLocation", "name=" + r19, getLogDetail());
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02201(this, r14, r15, r17, r19, null), 3, null);
    }
}
