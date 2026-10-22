package com.larus.dora.impl.device.settings.media;

import android.app.Application;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.larus.dora.impl.util.b0;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0011\u0018\u0000 T2\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020!J\u000e\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020!J\u000e\u00103\u001a\u00020.2\u0006\u00102\u001a\u00020!J\u000e\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020!J\u0006\u00106\u001a\u00020.J\u0006\u00107\u001a\u00020.J\u0010\u00108\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020!J\u0006\u00109\u001a\u00020.J\u0006\u0010:\u001a\u00020!J\u000e\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020!2\b\u0010?\u001a\u0004\u0018\u00010=J\u000e\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001dJ\u000e\u0010B\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020=J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001d0DJ\u0015\u0010E\u001a\u00020\u001d2\b\u0010F\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010GJ\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001d0DJ\u000e\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u001cJ\u0015\u0010K\u001a\u00020\u001c2\b\u0010J\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010LJ\u000e\u0010M\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u001cJ\u0017\u0010O\u001a\u00020\u001d2\b\u0010J\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010GJ\b\u0010P\u001a\u00020!H\u0002J\b\u0010Q\u001a\u00020!H\u0002J\b\u0010R\u001a\u00020!H\u0002J\b\u0010S\u001a\u00020.H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bj\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bj\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+¨\u0006U"}, d2 = {"Lcom/larus/dora/impl/device/settings/media/MediaSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_mediaAlbumConfig", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/media/MediaAlbumConfig;", "mediaAlbumConfig", "Lkotlinx/coroutines/flow/StateFlow;", "getMediaAlbumConfig", "()Lkotlinx/coroutines/flow/StateFlow;", "_mediaAlbumAction", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/settings/media/MediaAlbumAction;", "mediaAlbumAction", "Lkotlinx/coroutines/flow/SharedFlow;", "getMediaAlbumAction", "()Lkotlinx/coroutines/flow/SharedFlow;", "_mediaVideoRecordConfig", "Lcom/larus/dora/impl/device/settings/media/MediaVideoRecordConfig;", "mediaVideoRecordConfig", "getMediaVideoRecordConfig", "mDoraLinkCallback", "Lcom/larus/dora/api/IDoraLinkCallback;", "mDoraVisionListener", "Lcom/larus/dora/api/wrapper/FlowDoraVisionListener;", "videoResolutionMap", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "videoDurationMap", "recordLocationPendingEnable", "", "doraService", "Lcom/larus/dora/api/IDoraService;", "getDoraService", "()Lcom/larus/dora/api/IDoraService;", "doraService$delegate", "Lkotlin/Lazy;", "visionService", "Lcom/larus/dora/api/IDoraService$Vision;", "getVisionService", "()Lcom/larus/dora/api/IDoraService$Vision;", "visionService$delegate", "initData", "", "updateAutoSyncSwitch", "switch", "updateSaveToGallerySwitch", "enabled", "updateRecordLocationSwitch", "onRecordLocationPermissionResult", "granted", "onRecordLocationAlwaysAllowDialogCancel", "refreshRecordLocationState", "onLocalPermissionResult", "onLinkConnect", "isSupportVideoCfg", "syncVideoRecordCfg", "config", "Lcom/larus/dora/api/model/FlowDoraVideoRecordConfig;", "is3KVideoResolution", "cfg", "getVideoResolution", "qualityTxt", "getVideoQualityTxt", "getVideoQualityTxtList", "", "getVideoAspectRatioTxt", "ratio", "(Ljava/lang/Integer;)Ljava/lang/String;", "getVideoDurationTxtList", "getVideoDurationTxtByDur", "duration", "getVideoDurationSelectedIndex", "(Ljava/lang/Integer;)I", "getVideoDurationByIndex", "index", "getVideoDurationTxt", "needLocationPermission", "hasFineLocationPermission", "isLocationAlwaysAllowed", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "MediaSettingsViewModel";
    private MutableSharedFlow<com.larus.dora.impl.device.settings.media.a> _mediaAlbumAction;
    private z0<b> _mediaAlbumConfig;
    private z0<a0> _mediaVideoRecordConfig;
    private final Lazy doraService$delegate;
    private t39.n mDoraLinkCallback;
    private h49.g mDoraVisionListener;
    private final d1<com.larus.dora.impl.device.settings.media.a> mediaAlbumAction;
    private final i1<b> mediaAlbumConfig;
    private final i1<a0> mediaVideoRecordConfig;
    private boolean recordLocationPendingEnable;
    private final LinkedHashMap<Integer, String> videoDurationMap;
    private final LinkedHashMap<Integer, String> videoResolutionMap;
    private final Lazy visionService$delegate;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$initData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$initData$1", f = "MediaSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$initData$1$a */
        public static final class a implements t39.n {
            public final /* synthetic */ MediaSettingsViewModel a;

            public a(MediaSettingsViewModel r1) {
                this.a = r1;
            }

            public final void e(int r1, int r2, String r3, String r4) {
                Intrinsics.checkNotNullParameter(r3, "productName");
                if (r1 != 2) goto L6;
                this.a.onLinkConnect();
                return;
            }
        }

        public AnonymousClass1(MediaSettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L32;
            ResultKt.throwOnFailure(r10);
            sk4.e r11 = o0.a;
            boolean r1 = o0.c("mediaSync");
            IDoraService r12 = MediaSettingsViewModel.access$getDoraService(this.this$0);
            boolean r2 = true;
            if (r12 == null) goto L11;
            DeviceService r13 = r12.device();
            if (r13 == null) goto L11;
            if (r13.B() != true) goto L11;
            boolean r14 = true;
        L12:
            if (r14 == true) goto L14;
        L16:
            r2 = false;
        L17:
            b0.a.getClass();
            boolean r3 = b0.y();
            boolean r5 = MediaSettingsViewModel.access$isLocationAlwaysAllowed(this.this$0);
            boolean r4 = b0.x();
            g49.d.d(MediaSettingsViewModel.TAG, "initData isSup=" + r1 + " autoSync=" + r2 + " isSaveToGallery=" + r3 + " recordLocationRepoEnabled=" + r4 + " recordLocationEnabled=" + r4 + " locationAlwaysAllowed=" + r5);
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(new b.a(r1, r2, r3, r4, r5, System.currentTimeMillis()));
            MediaSettingsViewModel r15 = this.this$0;
            a r0 = new a(r15);
            IDoraService r6 = MediaSettingsViewModel.access$getDoraService(r15);
            if (r6 == null) goto L20;
            r6.G(r0);
        L20:
            MediaSettingsViewModel.access$setMDoraLinkCallback$p(r15, r0);
            final MediaSettingsViewModel r16 = this.this$0;
            h49.g r7 = new AnonymousClass3(r16);
            IDoraService.i r8 = MediaSettingsViewModel.access$getVisionService(r16);
            if (r8 == null) goto L23;
            r8.c(r7);
        L23:
            MediaSettingsViewModel.access$setMDoraVisionListener$p(r16, r7);
            IDoraService.i r17 = MediaSettingsViewModel.access$getVisionService(this.this$0);
            if (r17 == null) goto L26;
            FlowDoraVideoRecordConfig r18 = r17.b();
        L27:
            if (r18 == null) goto L30;
            MediaSettingsViewModel r9 = this.this$0;
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r9), Dispatchers.getMain(), null, new MediaSettingsViewModel$initData$1$5$1(r9, r18, null), 2, null);
        L30:
            return Unit.INSTANCE;
        L26:
            r18 = null;
            goto L27
        L14:
            if (MediaSettingsViewModel.access$needLocationPermission(this.this$0) == true) goto L16;
        L11:
            r14 = false;
            goto L12
        L32:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$onLinkConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$onLinkConnect$1", f = "MediaSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        public C02931(MediaSettingsViewModel r1, Continuation<? super C02931> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02931(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r2);
            IDoraService r3 = MediaSettingsViewModel.access$getDoraService(this.this$0);
            if (r3 == null) goto L9;
            DeviceService r4 = r3.device();
            if (r4 == null) goto L9;
            r4.M0();
        L9:
            this.this$0.initData();
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$onLocalPermissionResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$onLocalPermissionResult$1", f = "MediaSettingsViewModel.kt", i = {}, l = {341}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $granted;
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        public C02941(boolean r1, MediaSettingsViewModel r2, Continuation<? super C02941> r3) {
            this.$granted = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02941(this.$granted, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L30:
            IDoraService r13 = MediaSettingsViewModel.access$getDoraService(this.this$0);
            if (r13 == null) goto L36;
            DeviceService r14 = r13.device();
            if (r14 == null) goto L36;
            r14.M0();
        L36:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            g49.d.d(MediaSettingsViewModel.TAG, "location permission result: " + this.$granted);
            if ((MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue() instanceof b.C0053b) == false) goto L13;
            return Unit.INSTANCE;
        L13:
            if (this.$granted == false) goto L15;
            Object r15 = MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.media.MediaAlbumConfig.Config");
            b.a r3 = (b.a) r15;
            IDoraService r16 = MediaSettingsViewModel.access$getDoraService(this.this$0);
            if (r16 == null) goto L21;
            DeviceService r17 = r16.device();
            if (r17 == null) goto L21;
            Integer r18 = Boxing.boxInt(r17.H0(true));
        L22:
            if (r18 != null) goto L25;
        L27:
            MutableSharedFlow r110 = MediaSettingsViewModel.access$get_mediaAlbumAction$p(this.this$0);
            com.larus.dora.impl.device.settings.media.a.C0052a r2 = new com.larus.dora.impl.device.settings.media.a.C0052a();
            this.label = 1;
            if (r110.emit(r2, this) != r0) goto L30;
            return r0;
        L25:
            if (r18.intValue() != 0) goto L27;
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r3, true, false, false, false, 0, 61));
        L21:
            r18 = null;
            goto L22
        L15:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$onRecordLocationAlwaysAllowDialogCancel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$onRecordLocationAlwaysAllowDialogCancel$1", f = "MediaSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        public C02951(MediaSettingsViewModel r1, Continuation<? super C02951> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02951(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r9);
            g49.d.d(MediaSettingsViewModel.TAG, "record location always allow dialog cancel");
            MediaSettingsViewModel.access$setRecordLocationPendingEnable$p(this.this$0, false);
            Object r10 = MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue();
            if ((r10 instanceof b.a) == false) goto L7;
            b.a r11 = (b.a) r10;
        L8:
            b.a r0 = r11;
            if (r0 == null) goto L11;
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r0, false, false, false, MediaSettingsViewModel.access$isLocationAlwaysAllowed(this.this$0), System.currentTimeMillis(), 15));
            return Unit.INSTANCE;
        L11:
            return Unit.INSTANCE;
        L7:
            r11 = null;
            goto L8
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$onRecordLocationPermissionResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$onRecordLocationPermissionResult$1", f = "MediaSettingsViewModel.kt", i = {0, 0}, l = {259}, m = "invokeSuspend", n = {"currentConfig", "locationAlwaysAllowed"}, s = {"L$0", "Z$0"})
    public static final class C02961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $granted;
        Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        public C02961(boolean r1, MediaSettingsViewModel r2, Continuation<? super C02961> r3) {
            this.$granted = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02961(this.$granted, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            boolean r2 = this.Z$0;
            b.a r3 = (b.a) this.L$0;
            ResultKt.throwOnFailure(r12);
        L24:
            boolean r6 = r2;
            b.a r4 = r3;
        L26:
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r4, false, false, true, r6, System.currentTimeMillis(), 7));
        L29:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            g49.d.d(MediaSettingsViewModel.TAG, "onRecordLocationPermissionResult granted=" + this.$granted);
            Object r13 = MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue();
            if ((r13 instanceof b.a) == false) goto L11;
            b.a r14 = (b.a) r13;
        L12:
            b.a r5 = r14;
            if (r5 == null) goto L15;
            boolean r7 = MediaSettingsViewModel.access$isLocationAlwaysAllowed(this.this$0);
            boolean r15 = MediaSettingsViewModel.access$hasFineLocationPermission(this.this$0);
            g49.d.d(MediaSettingsViewModel.TAG, "onRecordLocationPermissionResult hasFine=" + r15 + " locationAlwaysAllowed=" + r7 + " pending=" + MediaSettingsViewModel.access$getRecordLocationPendingEnable$p(this.this$0));
            if (r15 == false) goto L27;
            MediaSettingsViewModel.access$setRecordLocationPendingEnable$p(this.this$0, false);
            b0.a.getClass();
            b0.N(true);
            if (r7 == true) goto L25;
            g49.d.d(MediaSettingsViewModel.TAG, "onRecordLocationPermissionResult fine granted but not always allowed, show dialog");
            MutableSharedFlow r16 = MediaSettingsViewModel.access$get_mediaAlbumAction$p(this.this$0);
            com.larus.dora.impl.device.settings.media.a.c r8 = new com.larus.dora.impl.device.settings.media.a.c(0);
            this.L$0 = r5;
            this.Z$0 = r7;
            this.label = 1;
            if (r16.emit(r8, this) != r0) goto L23;
            return r0;
        L23:
            r3 = r5;
            r2 = r7;
            goto L24
        L25:
            r4 = r5;
            r6 = r7;
            goto L26
        L27:
            g49.d.d(MediaSettingsViewModel.TAG, "onRecordLocationPermissionResult user denied fine location, cancel pending enable");
            MediaSettingsViewModel.access$setRecordLocationPendingEnable$p(this.this$0, false);
            b0.a.getClass();
            b0.N(false);
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r5, false, false, false, r7, System.currentTimeMillis(), 7));
            goto L29
        L15:
            return Unit.INSTANCE;
        L11:
            r14 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$refreshRecordLocationState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$refreshRecordLocationState$1", f = "MediaSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        public C02971(MediaSettingsViewModel r1, Continuation<? super C02971> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02971(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r9);
            Object r10 = MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue();
            if ((r10 instanceof b.a) == false) goto L7;
            b.a r11 = (b.a) r10;
        L8:
            b.a r0 = r11;
            if (r0 == null) goto L11;
            boolean r4 = MediaSettingsViewModel.access$isLocationAlwaysAllowed(this.this$0);
            b0.a.getClass();
            boolean r12 = b0.x();
            g49.d.d(MediaSettingsViewModel.TAG, "refreshRecordLocationState pending=" + MediaSettingsViewModel.access$getRecordLocationPendingEnable$p(this.this$0) + " repoEnabled=" + r12 + " locationAlwaysAllowed=" + r4);
            if (MediaSettingsViewModel.access$getRecordLocationPendingEnable$p(this.this$0) == false) goto L16;
            if (r4 == false) goto L16;
            MediaSettingsViewModel.access$setRecordLocationPendingEnable$p(this.this$0, false);
            b0.N(true);
            boolean r3 = true;
        L17:
            g49.d.d(MediaSettingsViewModel.TAG, "refreshRecordLocationState finalEnabled=" + r3);
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r0, false, false, r3, r4, System.currentTimeMillis(), 7));
            return Unit.INSTANCE;
        L16:
            r3 = r12;
            goto L17
        L11:
            return Unit.INSTANCE;
        L7:
            r11 = null;
            goto L8
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$syncVideoRecordCfg$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$syncVideoRecordCfg$1", f = "MediaSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowDoraVideoRecordConfig $config;
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$syncVideoRecordCfg$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$syncVideoRecordCfg$1$1", f = "MediaSettingsViewModel.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowDoraVideoRecordConfig $config;
            int label;
            final /* synthetic */ MediaSettingsViewModel this$0;

            public C00511(MediaSettingsViewModel r1, FlowDoraVideoRecordConfig r2, Continuation<? super C00511> r3) {
                this.this$0 = r1;
                this.$config = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00511(this.this$0, this.$config, r4);
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
                z0 r6 = MediaSettingsViewModel.access$get_mediaVideoRecordConfig$p(this.this$0);
                a0.a r2 = new a0.a(this.$config);
                this.label = 1;
                if (r6.emit(r2, this) != r0) goto L12;
                return r0;
            }
        }

        public C02981(MediaSettingsViewModel r1, FlowDoraVideoRecordConfig r2, Continuation<? super C02981> r3) {
            this.this$0 = r1;
            this.$config = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02981(this.this$0, this.$config, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L24;
            ResultKt.throwOnFailure(r8);
            IDoraService.i r9 = MediaSettingsViewModel.access$getVisionService(this.this$0);
            if (r9 == null) goto L7;
            Integer r10 = Boxing.boxInt(r9.d(this.$config));
        L8:
            StringBuilder r1 = new StringBuilder("syncVideoRecordCfg: ");
            r1.append(r10);
            r1.append(" (");
            if (r10 != null) goto L12;
        L14:
            boolean r2 = false;
        L15:
            r1.append(r2);
            r1.append("), config: ");
            r1.append(this.$config);
            r1.append(' ');
            g49.d.d(MediaSettingsViewModel.TAG, r1.toString());
            if (r10 == null) goto L22;
            if (r10.intValue() != 0) goto L22;
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getMain(), null, new C00511(this.this$0, this.$config, null), 2, null);
        L22:
            return Unit.INSTANCE;
        L12:
            if (r10.intValue() != 0) goto L14;
            r2 = true;
            goto L15
        L7:
            r10 = null;
            goto L8
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$updateAutoSyncSwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$updateAutoSyncSwitch$1", f = "MediaSettingsViewModel.kt", i = {0, 1, 1}, l = {140, 149}, m = "invokeSuspend", n = {"copyValue", "copyValue", "ret"}, s = {"L$0", "L$0", "L$1"})
    public static final class C02991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $switch;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        public C02991(MediaSettingsViewModel r1, boolean r2, Continuation<? super C02991> r3) {
            this.this$0 = r1;
            this.$switch = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02991(this.this$0, this.$switch, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r17) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            Integer r3 = (Integer) this.L$1;
            b.a r4 = (b.a) this.L$0;
            ResultKt.throwOnFailure(r17);
        L38:
            g49.d.d(MediaSettingsViewModel.TAG, "sync silent trans enable err: " + r3);
            b.a r5 = r4;
        L39:
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(r5);
            IDoraService r6 = MediaSettingsViewModel.access$getDoraService(this.this$0);
            if (r6 == null) goto L45;
            DeviceService r7 = r6.device();
            if (r7 == null) goto L45;
            r7.M0();
        L45:
            if ((MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue() instanceof b.a) == false) goto L49;
            Object r8 = MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.media.MediaAlbumConfig.Config");
            if (((b.a) r8).b == false) goto L49;
            String r9 = "1";
        L50:
            DoraSystemInfoManager r10 = DoraSystemInfoManager.a;
            DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("album_auto_sync_switch", r9)));
            return Unit.INSTANCE;
        L49:
            r9 = "0";
            goto L50
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            b.a r11 = (b.a) this.L$0;
            ResultKt.throwOnFailure(r17);
            b.a r12 = r11;
        L22:
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r12, false, false, false, false, System.currentTimeMillis(), 29));
            goto L45
        L10:
            ResultKt.throwOnFailure(r17);
            g49.d.d(MediaSettingsViewModel.TAG, "update auto sync switch");
            if ((MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue() instanceof b.C0053b) == true) goto L13;
            Object r13 = MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.media.MediaAlbumConfig.Config");
            b.a r14 = (b.a) r13;
            if (this.$switch == true) goto L17;
        L23:
            IDoraService r15 = MediaSettingsViewModel.access$getDoraService(this.this$0);
            if (r15 == null) goto L28;
            DeviceService r16 = r15.device();
            if (r16 == null) goto L28;
            Integer r18 = Boxing.boxInt(r16.H0(this.$switch));
        L29:
            if (r18 != null) goto L32;
        L34:
            MutableSharedFlow r20 = MediaSettingsViewModel.access$get_mediaAlbumAction$p(this.this$0);
            com.larus.dora.impl.device.settings.media.a.C0052a r21 = new com.larus.dora.impl.device.settings.media.a.C0052a();
            this.L$0 = r14;
            this.L$1 = r18;
            this.label = 2;
            if (r20.emit(r21, this) != r1) goto L37;
            return r1;
        L37:
            r3 = r18;
            r4 = r14;
            goto L38
        L32:
            if (r18.intValue() != 0) goto L34;
            r5 = b.a.a(r14, this.$switch, false, false, false, 0, 61);
        L28:
            r18 = null;
            goto L29
        L17:
            if (MediaSettingsViewModel.access$needLocationPermission(this.this$0) == false) goto L23;
            g49.d.d(MediaSettingsViewModel.TAG, "try open switch but no permission");
            MutableSharedFlow r22 = MediaSettingsViewModel.access$get_mediaAlbumAction$p(this.this$0);
            com.larus.dora.impl.device.settings.media.a.C0052a r23 = new com.larus.dora.impl.device.settings.media.a.C0052a();
            this.L$0 = r14;
            this.label = 1;
            if (r22.emit(r23, this) != r1) goto L21;
            return r1;
        L21:
            r12 = r14;
            goto L22
        L13:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$updateRecordLocationSwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$updateRecordLocationSwitch$1", f = "MediaSettingsViewModel.kt", i = {0, 1}, l = {205, 219}, m = "invokeSuspend", n = {"currentConfig", "currentConfig"}, s = {"L$0", "L$0"})
    public static final class C03001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        Object L$0;
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        public C03001(MediaSettingsViewModel r1, boolean r2, Continuation<? super C03001> r3) {
            this.this$0 = r1;
            this.$enabled = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03001(this.this$0, this.$enabled, r4);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            b.a r2 = (b.a) this.L$0;
            ResultKt.throwOnFailure(r14);
            b.a r5 = r2;
        L36:
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r5, false, false, true, false, System.currentTimeMillis(), 7));
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            b.a r3 = (b.a) this.L$0;
            ResultKt.throwOnFailure(r14);
            b.a r6 = r3;
        L28:
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r6, false, false, false, MediaSettingsViewModel.access$isLocationAlwaysAllowed(this.this$0), System.currentTimeMillis(), 7));
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r14);
            g49.d.d(MediaSettingsViewModel.TAG, "updateRecordLocationSwitch enabled=" + this.$enabled + " sdk=" + Build.VERSION.SDK_INT + " hasFine=" + MediaSettingsViewModel.access$hasFineLocationPermission(this.this$0) + " alwaysAllowed=" + MediaSettingsViewModel.access$isLocationAlwaysAllowed(this.this$0) + " pending=" + MediaSettingsViewModel.access$getRecordLocationPendingEnable$p(this.this$0));
            Object r15 = MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue();
            if ((r15 instanceof b.a) == false) goto L13;
            b.a r16 = (b.a) r15;
        L14:
            b.a r4 = r16;
            if (r4 != null) goto L19;
            return Unit.INSTANCE;
        L19:
            if (this.$enabled == true) goto L22;
            MediaSettingsViewModel.access$setRecordLocationPendingEnable$p(this.this$0, false);
            b0.a.getClass();
            b0.N(false);
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r4, false, false, false, MediaSettingsViewModel.access$isLocationAlwaysAllowed(this.this$0), System.currentTimeMillis(), 7));
            return Unit.INSTANCE;
        L22:
            MediaSettingsViewModel.access$setRecordLocationPendingEnable$p(this.this$0, true);
            if (MediaSettingsViewModel.access$hasFineLocationPermission(this.this$0) == true) goto L30;
            g49.d.d(MediaSettingsViewModel.TAG, "updateRecordLocationSwitch request permission: missing fine location");
            MutableSharedFlow r17 = MediaSettingsViewModel.access$get_mediaAlbumAction$p(this.this$0);
            com.larus.dora.impl.device.settings.media.a.b r7 = new com.larus.dora.impl.device.settings.media.a.b(0);
            this.L$0 = r4;
            this.label = 1;
            if (r17.emit(r7, this) != r0) goto L27;
            return r0;
        L27:
            r6 = r4;
            goto L28
        L30:
            MediaSettingsViewModel.access$setRecordLocationPendingEnable$p(this.this$0, false);
            b0.a.getClass();
            b0.N(true);
            if (MediaSettingsViewModel.access$isLocationAlwaysAllowed(this.this$0) == true) goto L38;
            g49.d.d(MediaSettingsViewModel.TAG, "updateRecordLocationSwitch show always-allow dialog: not always allowed");
            MutableSharedFlow r18 = MediaSettingsViewModel.access$get_mediaAlbumAction$p(this.this$0);
            com.larus.dora.impl.device.settings.media.a.c r8 = new com.larus.dora.impl.device.settings.media.a.c(0);
            this.L$0 = r4;
            this.label = 2;
            if (r18.emit(r8, this) != r0) goto L35;
            return r0;
        L35:
            r5 = r4;
            goto L36
        L38:
            g49.d.d(MediaSettingsViewModel.TAG, "updateRecordLocationSwitch enabled success");
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a(r4, false, false, true, true, System.currentTimeMillis(), 7));
            return Unit.INSTANCE;
        L13:
            r16 = null;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$updateSaveToGallerySwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$updateSaveToGallerySwitch$1", f = "MediaSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        int label;
        final /* synthetic */ MediaSettingsViewModel this$0;

        public C03011(boolean r1, MediaSettingsViewModel r2, Continuation<? super C03011> r3) {
            this.$enabled = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03011(this.$enabled, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r10);
            g49.d.d(MediaSettingsViewModel.TAG, "update save to gallery switch: " + this.$enabled);
            if ((MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue() instanceof b.C0053b) == true) goto L7;
            b0 r11 = b0.a;
            boolean r0 = this.$enabled;
            r11.getClass();
            b0.j().storeBoolean("dora_save_to_gallery_enabled_".concat(AccountService.a.getUserId()), r0);
            Object r12 = MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.media.MediaAlbumConfig.Config");
            MediaSettingsViewModel.access$get_mediaAlbumConfig$p(this.this$0).setValue(b.a.a((b.a) r12, false, this.$enabled, false, false, 0, 59));
            DoraSystemInfoManager r13 = DoraSystemInfoManager.a;
            if (this.$enabled == false) goto L11;
            String r14 = "1";
        L12:
            DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("allow_save_to_phone_album", r14)));
            return Unit.INSTANCE;
        L11:
            r14 = "0";
            goto L12
        L7:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ IDoraService.i Mo(MediaSettingsViewModel r0) {
        return visionService_delegate$lambda$1(r0);
    }

    public static /* synthetic */ IDoraService yo() {
        return doraService_delegate$lambda$0();
    }

    private static final IDoraService doraService_delegate$lambda$0() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    private final IDoraService getDoraService() {
        return (IDoraService) this.doraService$delegate.getValue();
    }

    private final IDoraService.i getVisionService() {
        return (IDoraService.i) this.visionService$delegate.getValue();
    }

    private final boolean hasFineLocationPermission() {
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean needLocationPermission() {
        if (Build.VERSION.SDK_INT < 33) goto L8;
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.NEARBY_WIFI_DEVICES") != 0) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.ACCESS_FINE_LOCATION") == 0) goto L10;
        return true;
    }

    public final List<String> getVideoDurationTxtList() {
        return CollectionsKt.toList(this.videoDurationMap.values());
    }

    public final List<String> getVideoQualityTxtList() {
        return CollectionsKt.toList(this.videoResolutionMap.values());
    }

    public MediaSettingsViewModel() {
        StateFlowImpl r0 = j1.a(b.C0053b.a);
        this._mediaAlbumConfig = r0;
        this.mediaAlbumConfig = r0;
        MutableSharedFlow<com.larus.dora.impl.device.settings.media.a> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._mediaAlbumAction = r1;
        this.mediaAlbumAction = r1;
        StateFlowImpl r2 = j1.a(new a0.a(new FlowDoraVideoRecordConfig(0)));
        this._mediaVideoRecordConfig = r2;
        this.mediaVideoRecordConfig = r2;
        this.videoResolutionMap = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(0, "1080P"), TuplesKt.to(1, "3K")});
        this.videoDurationMap = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(15, getVideoDurationTxt(15)), TuplesKt.to(30, getVideoDurationTxt(30)), TuplesKt.to(60, getVideoDurationTxt(60)), TuplesKt.to(120, getVideoDurationTxt(120)), TuplesKt.to(180, getVideoDurationTxt(180)), TuplesKt.to(600, getVideoDurationTxt(600))});
        this.doraService$delegate = LazyKt.lazy(new y());
        this.visionService$delegate = LazyKt.lazy(new z(this));
        initData();
    }

    private final boolean isLocationAlwaysAllowed() {
        if (hasFineLocationPermission() == true) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L8;
    L9:
        return true;
    L8:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) goto L9;
        return false;
    }

    public final void initData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final boolean isSupportVideoCfg() {
        IDoraService r0 = getDoraService();
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        if (r1.n0("videoCfg") != true) goto L9;
        return true;
    L9:
        return false;
    }

    public void onCleared() {
        super.onCleared();
        t39.n r0 = this.mDoraLinkCallback;
        if (r0 == null) goto L7;
        IDoraService r1 = getDoraService();
        if (r1 == null) goto L7;
        r1.q0(r0);
    L7:
        h49.g r2 = this.mDoraVisionListener;
        if (r2 == null) goto L13;
        IDoraService.i r3 = getVisionService();
        if (r3 == null) goto L14;
        r3.a(r2);
        return;
    L14:
        return;
    }

    public final void onLinkConnect() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02931(this, null), 2, null);
    }

    public final void onRecordLocationAlwaysAllowDialogCancel() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02951(this, null), 2, null);
    }

    public final void refreshRecordLocationState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02971(this, null), 2, null);
    }

    public final d1<com.larus.dora.impl.device.settings.media.a> getMediaAlbumAction() {
        return this.mediaAlbumAction;
    }

    public final i1<b> getMediaAlbumConfig() {
        return this.mediaAlbumConfig;
    }

    public final i1<a0> getMediaVideoRecordConfig() {
        return this.mediaVideoRecordConfig;
    }

    public static final /* synthetic */ IDoraService access$getDoraService(MediaSettingsViewModel r0) {
        return r0.getDoraService();
    }

    public static final /* synthetic */ boolean access$getRecordLocationPendingEnable$p(MediaSettingsViewModel r0) {
        return r0.recordLocationPendingEnable;
    }

    public static final /* synthetic */ IDoraService.i access$getVisionService(MediaSettingsViewModel r0) {
        return r0.getVisionService();
    }

    public static final /* synthetic */ MutableSharedFlow access$get_mediaAlbumAction$p(MediaSettingsViewModel r0) {
        return r0._mediaAlbumAction;
    }

    public static final /* synthetic */ z0 access$get_mediaAlbumConfig$p(MediaSettingsViewModel r0) {
        return r0._mediaAlbumConfig;
    }

    public static final /* synthetic */ z0 access$get_mediaVideoRecordConfig$p(MediaSettingsViewModel r0) {
        return r0._mediaVideoRecordConfig;
    }

    public static final /* synthetic */ boolean access$hasFineLocationPermission(MediaSettingsViewModel r0) {
        return r0.hasFineLocationPermission();
    }

    public static final /* synthetic */ boolean access$isLocationAlwaysAllowed(MediaSettingsViewModel r0) {
        return r0.isLocationAlwaysAllowed();
    }

    public static final /* synthetic */ boolean access$needLocationPermission(MediaSettingsViewModel r0) {
        return r0.needLocationPermission();
    }

    private final String getVideoDurationTxt(Integer r5) {
        int r0 = 0;
        if (r5 == null) goto L5;
        r0 = RangesKt.coerceAtLeast(r5.intValue(), 0);
    L5:
        Application r6 = AppHost.a.getApplication();
        String r1 = r6.getString(2131902687);
        String r7 = r6.getString(2131902686);
        int r2 = r0 / 60;
        int r3 = r0 % 60;
        if (r2 == 0) goto L12;
        if (r3 != 0) goto L11;
        return r2 + r7;
    L11:
        return r2 + r7 + r3 + r1;
    L12:
        return r0 + r1;
    }

    private static final IDoraService.i visionService_delegate$lambda$1(MediaSettingsViewModel r0) {
        IDoraService r1 = r0.getDoraService();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.V();
    }

    public final String getVideoAspectRatioTxt(Integer r3) {
        if (r3 == null) goto L4;
        int r4 = r3.intValue();
    L6:
        if (r4 != 0) goto L8;
        return "3:4";
    L8:
        if (r4 != 1) goto L10;
        return "9:16";
    L10:
        if (r4 != 2) goto L17;
        return "16:9";
    L17:
        return "3:4";
    L4:
        r4 = 0;
        goto L6
    }

    public final int getVideoDurationByIndex(int r3) {
        List r0 = CollectionsKt.toList(this.videoDurationMap.keySet());
        if (r3 >= 0) goto L5;
    L7:
        return 180;
    L5:
        if (r3 >= r0.size()) goto L7;
        return ((Number) ListProtector.get(r0, r3)).intValue();
    }

    public final int getVideoDurationSelectedIndex(Integer r2) {
        return CollectionsKt.indexOf(CollectionsKt.toList(this.videoDurationMap.keySet()), r2);
    }

    public final String getVideoDurationTxtByDur(int r2) {
        String r3 = this.videoDurationMap.get(Integer.valueOf(r2));
        if (r3 != null) goto L8;
        String r4 = this.videoDurationMap.get(180);
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4;
    L8:
        return r3;
    }

    public final String getVideoQualityTxt(FlowDoraVideoRecordConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "cfg");
        String r3 = this.videoResolutionMap.get(Integer.valueOf(r2.b));
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public final int getVideoResolution(String r4) {
        Intrinsics.checkNotNullParameter(r4, "qualityTxt");
        Iterator<T> r0 = this.videoResolutionMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((Map.Entry) r1).getValue(), r4) == false) goto L4;
    L9:
        Map.Entry r2 = (Map.Entry) r1;
        if (r2 == null) goto L14;
        Integer r5 = (Integer) r2.getKey();
        if (r5 == null) goto L14;
        return r5.intValue();
    L14:
        return 0;
    L8:
        r1 = null;
        goto L9
    }

    public final boolean is3KVideoResolution(FlowDoraVideoRecordConfig r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.b != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final void onLocalPermissionResult(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02941(r7, this, null), 2, null);
    }

    public final void onRecordLocationPermissionResult(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02961(r7, this, null), 2, null);
    }

    public final void syncVideoRecordCfg(FlowDoraVideoRecordConfig r8) {
        Intrinsics.checkNotNullParameter(r8, "config");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02981(this, r8, null), 2, null);
    }

    public final void updateAutoSyncSwitch(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02991(this, r7, null), 2, null);
    }

    public final void updateRecordLocationSwitch(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03001(this, r7, null), 2, null);
    }

    public final void updateSaveToGallerySwitch(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03011(r7, this, null), 2, null);
    }

    public static final /* synthetic */ void access$setMDoraLinkCallback$p(MediaSettingsViewModel r0, t39.n r1) {
        r0.mDoraLinkCallback = r1;
    }

    public static final /* synthetic */ void access$setMDoraVisionListener$p(MediaSettingsViewModel r0, h49.g r1) {
        r0.mDoraVisionListener = r1;
    }

    public static final /* synthetic */ void access$setRecordLocationPendingEnable$p(MediaSettingsViewModel r0, boolean r1) {
        r0.recordLocationPendingEnable = r1;
    }

    public static /* synthetic */ void onLocalPermissionResult$default(MediaSettingsViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.onLocalPermissionResult(r1);
    }
}
