package com.larus.camera.impl.ui.base;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.viewmodel.q0;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.utils.a0;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.chat.s0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\"\u001a\u00020!H\u0016J,\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\f2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!0(H\u0007J6\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0018\u0010'\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020!0(J\u0010\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020\fH\u0002J\b\u0010\u0004\u001a\u00020\u0005H\u0004J\u0006\u0010,\u001a\u00020!J\u0016\u0010-\u001a\u00020!2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\bJ\u000e\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\bJ\u000e\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u0011J?\u00107\u001a\u00020!2\u0006\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\b2%\b\u0002\u0010;\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020!\u0018\u00010(J\u0016\u0010?\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020CJ\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0EJ\u0006\u0010F\u001a\u00020GJ\u0015\u0010H\u001a\u00020!2\b\u0010I\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010JJ\u0006\u0010K\u001a\u00020!J\b\u0010L\u001a\u00020GH\u0016J\n\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0006\u0010O\u001a\u00020GJ\u0006\u0010P\u001a\u00020QJ\n\u0010R\u001a\u0004\u0018\u00010SH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u0006U"}, d2 = {"Lcom/larus/camera/impl/ui/base/BaseCameraViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "ability", "Lcom/larus/camera/impl/ui/viewmodel/ViewModelAbility;", "_onOrientationChanged", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_onPictureSelected", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lcom/larus/platform/model/album/AlbumSelectItem;", "_onDetectResultChanged", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "_onPhotoPickerPageSlideOffsetChanged", "_onLatestPhotoChanged", "", "onOrientationChanged", "Lkotlinx/coroutines/flow/StateFlow;", "getOnOrientationChanged", "()Lkotlinx/coroutines/flow/StateFlow;", "onPictureSelected", "Lkotlinx/coroutines/flow/SharedFlow;", "getOnPictureSelected", "()Lkotlinx/coroutines/flow/SharedFlow;", "onDetectResultChanged", "getOnDetectResultChanged", "onPhotoPickerPageSlideOffsetChanged", "getOnPhotoPickerPageSlideOffsetChanged", "onLatestPhotoChanged", "getOnLatestPhotoChanged", "bindAbility", "", "onInitialized", "interceptPickResultOversize", "context", "Landroid/content/Context;", "result", "onNext", "Lkotlin/Function1;", "resultList", "checkVideoMeta", "Lcom/larus/camera/impl/ui/base/BaseCameraViewModel$VideoMetaCheckResult;", "reopenCamera", "updatePicture", "item", "updateOrientation", "degree", "updateDetectResult", "detectResult", "updatePhotoPickerPageSlideOffset", "pageSlideOffset", "updateLatestPhotoChanged", "changedTimeMills", "tryAdaptBottomLine", "lineContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "bottomContentHeight", "onAdaptBottomAction", "Lkotlin/ParameterName;", "name", "adaptBottomOffset", "getBottomMargin", "container", "Landroid/view/View;", "getCameraData", "Lcom/larus/camera/impl/utils/CameraData;", "getCameraDataFlow", "Lkotlinx/coroutines/flow/Flow;", "enableResultDetect", "", "recordCameraTipsType", "type", "(Ljava/lang/Integer;)V", "autoRecordCameraTipsCount", "shouldSupportEdit", "getCurrentDisplayOutputParam", "Lcom/larus/camera/api/params/OutputParam;", "enableFocusFrameInGeneralMode", "requireFragment", "Landroidx/fragment/app/Fragment;", "invokeClickFrom", "", "VideoMetaCheckResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseCameraViewModel extends ViewModel {
    private final MutableSharedFlow<ix8.d> _onDetectResultChanged;
    private final MutableSharedFlow<Long> _onLatestPhotoChanged;
    private final z0<Integer> _onOrientationChanged;
    private final z0<Integer> _onPhotoPickerPageSlideOffsetChanged;
    private final MutableSharedFlow<List<AlbumSelectItem>> _onPictureSelected;
    private q0 ability;
    private final d1<ix8.d> onDetectResultChanged;
    private final d1<Long> onLatestPhotoChanged;
    private final i1<Integer> onOrientationChanged;
    private final i1<Integer> onPhotoPickerPageSlideOffsetChanged;
    private final d1<List<AlbumSelectItem>> onPictureSelected;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/impl/ui/base/BaseCameraViewModel$VideoMetaCheckResult;", "", "<init>", "(Ljava/lang/String;I)V", "PASS", "OVER_DURATION", "OVER_FORMAT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum VideoMetaCheckResult extends Enum<VideoMetaCheckResult> {
        public static final VideoMetaCheckResult OVER_DURATION = null;
        public static final VideoMetaCheckResult OVER_FORMAT = null;
        public static final VideoMetaCheckResult PASS = null;
        public static final /* synthetic */ VideoMetaCheckResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<VideoMetaCheckResult> getEntries() {
            return b;
        }

        static {
            VideoMetaCheckResult r0 = new VideoMetaCheckResult("PASS", 0);
            PASS = r0;
            VideoMetaCheckResult r1 = new VideoMetaCheckResult("OVER_DURATION", 1);
            OVER_DURATION = r1;
            VideoMetaCheckResult r3 = new VideoMetaCheckResult("OVER_FORMAT", 2);
            OVER_FORMAT = r3;
            VideoMetaCheckResult[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static VideoMetaCheckResult[] values() {
            return (VideoMetaCheckResult[]) a.clone();
        }

        public static VideoMetaCheckResult valueOf(String r1) {
            return (VideoMetaCheckResult) r27.a.a(VideoMetaCheckResult.class, r1);
        }

        public VideoMetaCheckResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ ConstraintLayout b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ int d;

        public a(FragmentActivity r1, ConstraintLayout r2, Function1 r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            Lazy r10 = a0.a;
            if (a0.c(this.a, this.b) == true) goto L7;
            Function1 r11 = this.c;
            if (r11 == null) goto L11;
            r11.invoke(0);
            return;
        L11:
            return;
        L7:
            int r12 = ((Number) a0.a.getValue()).intValue();
            ConstraintSet r13 = new ConstraintSet();
            r13.clone(this.b);
            r13.setGuidelineEnd(2131364481, this.d + r12);
            r13.applyTo(this.b);
            Function1 r14 = this.c;
            if (r14 == null) goto L13;
            r14.invoke(Integer.valueOf(r12));
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.base.BaseCameraViewModel$interceptPickResultOversize$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.base.BaseCameraViewModel$interceptPickResultOversize$2", f = "BaseCameraViewModel.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Function1<List<AlbumSelectItem>, Unit> $onNext;
        final /* synthetic */ List<AlbumSelectItem> $resultList;
        int label;
        final /* synthetic */ BaseCameraViewModel this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.base.BaseCameraViewModel$interceptPickResultOversize$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.camera.impl.ui.base.BaseCameraViewModel$interceptPickResultOversize$2$2", f = "BaseCameraViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00802 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ Function1<List<AlbumSelectItem>, Unit> $onNext;
            final /* synthetic */ Ref.ObjectRef<com.larus.camera.impl.utils.a.C0084a> $oversizedImageResult;
            final /* synthetic */ List<AlbumSelectItem> $validResults;
            final /* synthetic */ Ref.BooleanRef $videoOverDurationDetected;
            final /* synthetic */ Ref.BooleanRef $videoOverFormatDetected;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public C00802(Ref.ObjectRef<com.larus.camera.impl.utils.a.C0084a> r1, Ref.BooleanRef r2, Ref.BooleanRef r3, List<AlbumSelectItem> r4, Function1<? super List<AlbumSelectItem>, Unit> r5, Context r6, Continuation<? super C00802> r7) {
                this.$oversizedImageResult = r1;
                this.$videoOverDurationDetected = r2;
                this.$videoOverFormatDetected = r3;
                this.$validResults = r4;
                this.$onNext = r5;
                this.$context = r6;
                super(2, r7);
            }

            public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
                return new C00802(this.$oversizedImageResult, this.$videoOverDurationDetected, this.$videoOverFormatDetected, this.$validResults, this.$onNext, this.$context, r10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r11) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L19;
                ResultKt.throwOnFailure(r11);
                com.larus.camera.impl.utils.a.C0084a r12 = (com.larus.camera.impl.utils.a.C0084a) this.$oversizedImageResult.element;
                if (r12 == null) goto L8;
                Context r1 = this.$context;
                s r2 = s.a;
                Application r3 = AppHost.a.getApplication();
                StringBuilder r5 = new StringBuilder();
                long r8 = 1024;
                r5.append((r12.a / r8) / r8);
                r5.append("MB");
                String r13 = r1.getString(2131907896, new Object[]{r5.toString()});
                r2.getClass();
                s.t(r3, r13);
            L8:
                if (this.$videoOverDurationDetected.element == false) goto L11;
                s r14 = s.a;
                Application r4 = AppHost.a.getApplication();
                r14.getClass();
                s.s(r4, 2131910960);
            L11:
                if (this.$videoOverFormatDetected.element == false) goto L14;
                s r15 = s.a;
                Application r6 = AppHost.a.getApplication();
                r15.getClass();
                s.s(r6, 2131910958);
            L14:
                if ((!this.$validResults.isEmpty()) == false) goto L17;
                this.$onNext.invoke(this.$validResults);
            L17:
                return Unit.INSTANCE;
            L19:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.base.BaseCameraViewModel$interceptPickResultOversize$2$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[VideoMetaCheckResult.values().length];
                r0[VideoMetaCheckResult.PASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[VideoMetaCheckResult.OVER_DURATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[VideoMetaCheckResult.OVER_FORMAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(List<AlbumSelectItem> r1, BaseCameraViewModel r2, Function1<? super List<AlbumSelectItem>, Unit> r3, Context r4, Continuation<? super AnonymousClass2> r5) {
            this.$resultList = r1;
            this.this$0 = r2;
            this.$onNext = r3;
            this.$context = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass2(this.$resultList, this.this$0, this.$onNext, this.$context, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r17) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            boolean r3 = true;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r17);
        L91:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r17);
            ArrayList r8 = new ArrayList();
            Ref.ObjectRef r5 = new Ref.ObjectRef();
            Ref.BooleanRef r6 = new Ref.BooleanRef();
            Ref.BooleanRef r7 = new Ref.BooleanRef();
            Iterator<AlbumSelectItem> r4 = this.$resultList.iterator();
        L10:
            if (r4.hasNext() == false) goto L87;
            AlbumSelectItem r9 = r4.next();
            Uri r1 = r9.a;
            if (r1 == null) goto L10;
            BaseCameraViewModel r10 = this.this$0;
            ImFileUtil.a.getClass();
            if (ImFileUtil.y(r1) == false) goto L27;
            int r11 = a.a[BaseCameraViewModel.access$checkVideoMeta(r10, r9).ordinal()];
            if (r11 != r3) goto L18;
            Boxing.boxBoolean(r8.add(r9));
        L26:
            r4 = r4;
        L86:
            r4 = r4;
            r3 = true;
            goto L10
        L18:
            if (r11 != 2) goto L20;
            r6.element = r3;
            goto L26
        L20:
            if (r11 != 3) goto L23;
            r7.element = r3;
            goto L26
        L23:
            throw new NoWhenBranchMatchedException();
        L27:
            com.larus.camera.impl.utils.c.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "uri");
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L30
            Object r13 = Result.constructor-impl(com.larus.camera.impl.utils.c.a((ContentResolver) com.larus.camera.impl.utils.c.b.getValue(), r1));     // Catch: Throwable -> L30
        L32:
            Throwable r14 = Result.exceptionOrNull-impl(r13);
            if (r14 == null) goto L35;
            FLogger.a.e("AlbumImageChecker", "[check] openFileDescriptor failed, " + r14);
        L35:
            PolarisFileInputStreamWrapper r15 = null;
            if (Result.isFailure-impl(r13) == false) goto L38;
            r13 = null;
        L38:
            ParcelFileDescriptor r16 = (ParcelFileDescriptor) r13;
            if (r16 != null) goto L41;
            Object r18 = com.larus.camera.impl.utils.a.c.a;
            r4 = r4;
        L81:
            if ((r18 instanceof com.larus.camera.impl.utils.a.C0084a) == false) goto L84;
            r5.element = r18;
            goto L86
        L84:
            if ((r18 instanceof com.larus.camera.impl.utils.a.b) == false) goto L86;
            r8.add(r9);
            goto L86
        L41:
            long r19 = -1;
            PolarisFileInputStreamWrapper r110 = new PolarisFileInputStreamWrapper(r16.getFileDescriptor());     // Catch: Throwable -> L47
            r19 = r110.available();     // Catch: Throwable -> L45
            Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L45
        L49:
            Throwable r21 = Result.exceptionOrNull-impl(r20);
            if (r21 == null) goto L54;
            FLogger.a.e("AlbumImageChecker", "[fileSize] failed, " + r21);
        L54:
            if (r110 == null) goto L57;
            Intrinsics.checkNotNullParameter(r110, "<this>");
            r110.close();     // Catch: Throwable -> L92
        L57:
            s0 r22 = z2.a.getFlowMultiUploadConfig().m();
            long r111 = 20971520;
            if (r22 == null) goto L62;
            Long r23 = r22.d();
            if (r23 == null) goto L62;
            long r24 = r23.longValue();
        L64:
            if (r19 <= r24) goto L66;
        L69:
            boolean r25 = true;
        L70:
            if (r25 == false) goto L79;
            Intrinsics.checkNotNullParameter(r16, "<this>");
            r16.close();     // Catch: Throwable -> L93
        L73:
            s0 r26 = z2.a.getFlowMultiUploadConfig().m();
            if (r26 == null) goto L78;
            Long r27 = r26.d();
            if (r27 == null) goto L78;
            r111 = r27.longValue();
        L78:
            r18 = new com.larus.camera.impl.utils.a.C0084a(r111);
            goto L81
        L79:
            r18 = com.larus.camera.impl.utils.a.b.a;
            goto L81
        L66:
            if (r19 <= 0) goto L69;
            r25 = false;
        L62:
            r24 = 20971520;
        L45:
            th = th;
            r15 = r110;
        L48:
            Result.Companion r112 = Result.Companion;
            r20 = Result.constructor-impl(ResultKt.createFailure(th));
            r110 = r15;
        L47:
            th = th;
        L30:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L32
        L87:
            MainCoroutineDispatcher r28 = Dispatchers.getMain();
            C00802 r29 = new C00802(r5, r6, r7, r8, this.$onNext, this.$context, null);
            this.label = 1;
            if (BuildersKt.withContext(r28, r29, this) != r2) goto L91;
            return r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.base.BaseCameraViewModel$updateDetectResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.base.BaseCameraViewModel$updateDetectResult$1", f = "BaseCameraViewModel.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ix8.d $detectResult;
        int label;
        final /* synthetic */ BaseCameraViewModel this$0;

        public AnonymousClass1(BaseCameraViewModel r1, ix8.d r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$detectResult = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$detectResult, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow r5 = BaseCameraViewModel.access$get_onDetectResultChanged$p(this.this$0);
            ix8.d r2 = this.$detectResult;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.base.BaseCameraViewModel$updateLatestPhotoChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.base.BaseCameraViewModel$updateLatestPhotoChanged$1", f = "BaseCameraViewModel.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $changedTimeMills;
        int label;
        final /* synthetic */ BaseCameraViewModel this$0;

        public C02231(BaseCameraViewModel r1, long r2, Continuation<? super C02231> r4) {
            this.this$0 = r1;
            this.$changedTimeMills = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02231(this.this$0, this.$changedTimeMills, r5);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MutableSharedFlow r7 = BaseCameraViewModel.access$get_onLatestPhotoChanged$p(this.this$0);
            Long r2 = Boxing.boxLong(this.$changedTimeMills);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.base.BaseCameraViewModel$updateOrientation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.base.BaseCameraViewModel$updateOrientation$1", f = "BaseCameraViewModel.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $effectiveDegree;
        int label;
        final /* synthetic */ BaseCameraViewModel this$0;

        public C02241(BaseCameraViewModel r1, int r2, Continuation<? super C02241> r3) {
            this.this$0 = r1;
            this.$effectiveDegree = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02241(this.this$0, this.$effectiveDegree, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            z0 r5 = BaseCameraViewModel.access$get_onOrientationChanged$p(this.this$0);
            Integer r2 = Boxing.boxInt(this.$effectiveDegree);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.base.BaseCameraViewModel$updatePhotoPickerPageSlideOffset$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.base.BaseCameraViewModel$updatePhotoPickerPageSlideOffset$1", f = "BaseCameraViewModel.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageSlideOffset;
        int label;
        final /* synthetic */ BaseCameraViewModel this$0;

        public C02251(BaseCameraViewModel r1, int r2, Continuation<? super C02251> r3) {
            this.this$0 = r1;
            this.$pageSlideOffset = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02251(this.this$0, this.$pageSlideOffset, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            z0 r5 = BaseCameraViewModel.access$get_onPhotoPickerPageSlideOffsetChanged$p(this.this$0);
            Integer r2 = Boxing.boxInt(this.$pageSlideOffset);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.base.BaseCameraViewModel$updatePicture$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.base.BaseCameraViewModel$updatePicture$1", f = "BaseCameraViewModel.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<AlbumSelectItem> $item;
        int label;
        final /* synthetic */ BaseCameraViewModel this$0;

        public C02261(BaseCameraViewModel r1, List<AlbumSelectItem> r2, Continuation<? super C02261> r3) {
            this.this$0 = r1;
            this.$item = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02261(this.this$0, this.$item, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow r5 = BaseCameraViewModel.access$get_onPictureSelected$p(this.this$0);
            List<AlbumSelectItem> r2 = this.$item;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Unit yo(Function1 r0, List r1) {
        return interceptPickResultOversize$lambda$0(r0, r1);
    }

    public String invokeClickFrom() {
        return null;
    }

    public void onInitialized() {
    }

    public boolean shouldSupportEdit() {
        return false;
    }

    public final q0 ability() {
        q0 r0 = this.ability;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ability");
        return null;
    L6:
        return r0;
    }

    public final void autoRecordCameraTipsCount() {
        q0 r0 = this.ability;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ability");
        r0 = null;
    L5:
        r0.y();
    }

    public final boolean enableFocusFrameInGeneralMode() {
        q0 r0 = this.ability;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ability");
        r0 = null;
    L6:
        return r0.u();
    }

    public final boolean enableResultDetect() {
        q0 r0 = this.ability;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ability");
        r0 = null;
    L6:
        return r0.g0();
    }

    public final CameraData getCameraData() {
        q0 r0 = this.ability;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ability");
        r0 = null;
    L6:
        return r0.y0();
    }

    public final Flow<CameraData> getCameraDataFlow() {
        q0 r0 = this.ability;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ability");
        r0 = null;
    L6:
        return r0.E();
    }

    public OutputParam getCurrentDisplayOutputParam() {
        return new OutputParam();
    }

    public final Fragment requireFragment() {
        q0 r0 = this.ability;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ability");
        r0 = null;
    L6:
        return r0.h0();
    }

    public BaseCameraViewModel() {
        StateFlowImpl r2 = j1.a(0);
        this._onOrientationChanged = r2;
        MutableSharedFlow<List<AlbumSelectItem>> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._onPictureSelected = r4;
        MutableSharedFlow<ix8.d> r5 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this._onDetectResultChanged = r5;
        StateFlowImpl r1 = j1.a(0);
        this._onPhotoPickerPageSlideOffsetChanged = r1;
        MutableSharedFlow<Long> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null);
        this._onLatestPhotoChanged = r0;
        this.onOrientationChanged = kotlinx.coroutines.flow.e.b(r2);
        this.onPictureSelected = kotlinx.coroutines.flow.e.a(r4);
        this.onDetectResultChanged = kotlinx.coroutines.flow.e.a(r5);
        this.onPhotoPickerPageSlideOffsetChanged = kotlinx.coroutines.flow.e.b(r1);
        this.onLatestPhotoChanged = kotlinx.coroutines.flow.e.a(r0);
    }

    public final void reopenCamera() {
        ability().r();
    }

    public final d1<ix8.d> getOnDetectResultChanged() {
        return this.onDetectResultChanged;
    }

    public final d1<Long> getOnLatestPhotoChanged() {
        return this.onLatestPhotoChanged;
    }

    public final i1<Integer> getOnOrientationChanged() {
        return this.onOrientationChanged;
    }

    public final i1<Integer> getOnPhotoPickerPageSlideOffsetChanged() {
        return this.onPhotoPickerPageSlideOffsetChanged;
    }

    public final d1<List<AlbumSelectItem>> getOnPictureSelected() {
        return this.onPictureSelected;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_onDetectResultChanged$p(BaseCameraViewModel r0) {
        return r0._onDetectResultChanged;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_onLatestPhotoChanged$p(BaseCameraViewModel r0) {
        return r0._onLatestPhotoChanged;
    }

    public static final /* synthetic */ z0 access$get_onOrientationChanged$p(BaseCameraViewModel r0) {
        return r0._onOrientationChanged;
    }

    public static final /* synthetic */ z0 access$get_onPhotoPickerPageSlideOffsetChanged$p(BaseCameraViewModel r0) {
        return r0._onPhotoPickerPageSlideOffsetChanged;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_onPictureSelected$p(BaseCameraViewModel r0) {
        return r0._onPictureSelected;
    }

    private final VideoMetaCheckResult checkVideoMeta(AlbumSelectItem r22) {
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L59
        MediaMetadataRetriever r5 = new MediaMetadataRetriever();     // Catch: Throwable -> L59
        r5.setDataSource(AppHost.a.getApplication(), r22.a);     // Catch: Throwable -> L56
        Long r6 = Long.valueOf(r22.d);     // Catch: Throwable -> L56
        if (r6.longValue() <= 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r6 = null;
    L11:
        if (r6 != null) goto L16;
        String r8 = com_larus_camera_impl_ui_base_BaseCameraViewModel_android_media_MediaMetadataRetriever_extractMetadata(r5, 9);     // Catch: Throwable -> L56
        if (r8 == null) goto L15;
        r6 = Long.valueOf(Long.parseLong(r8));     // Catch: Throwable -> L56
        goto L16
    L15:
        Long r9 = null;
    L17:
        Integer r10 = Integer.valueOf(r22.b);     // Catch: Throwable -> L56
        if (r10.intValue() <= 0) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == true) goto L24;
        r10 = null;
    L24:
        if (r10 != null) goto L29;
        String r12 = com_larus_camera_impl_ui_base_BaseCameraViewModel_android_media_MediaMetadataRetriever_extractMetadata(r5, 18);     // Catch: Throwable -> L56
        if (r12 == null) goto L28;
        r10 = Integer.valueOf(Integer.parseInt(r12));     // Catch: Throwable -> L56
        goto L29
    L28:
        Integer r15 = null;
    L30:
        Integer r13 = Integer.valueOf(r22.c);     // Catch: Throwable -> L56
        if (r13.intValue() <= 0) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == true) goto L37;
        r13 = null;
    L37:
        if (r13 != null) goto L42;
        String r16 = com_larus_camera_impl_ui_base_BaseCameraViewModel_android_media_MediaMetadataRetriever_extractMetadata(r5, 19);     // Catch: Throwable -> L56
        if (r16 == null) goto L41;
        r13 = Integer.valueOf(Integer.parseInt(r16));     // Catch: Throwable -> L56
        goto L42
    L41:
        Integer r17 = null;
    L43:
        String r18 = r22.f;     // Catch: Throwable -> L56
        if (r18 != null) goto L46;
        r18 = com_larus_camera_impl_ui_base_BaseCameraViewModel_android_media_MediaMetadataRetriever_extractMetadata(r5, 12);     // Catch: Throwable -> L56
    L46:
        String r19 = r18;
        String r20 = com_larus_camera_impl_ui_base_BaseCameraViewModel_android_media_MediaMetadataRetriever_extractMetadata(r5, 20);     // Catch: Throwable -> L56
        if (r20 == null) goto L49;
        Integer r110 = Integer.valueOf(Integer.parseInt(r20));     // Catch: Throwable -> L56
    L50:
        long r21 = r22.e;     // Catch: Throwable -> L56
        ImFileUtil.a.getClass();     // Catch: Throwable -> L56
        float r0 = ImFileUtil.r(r5);     // Catch: Throwable -> L56
        String r23 = com_larus_camera_impl_ui_base_BaseCameraViewModel_android_media_MediaMetadataRetriever_extractMetadata(r5, 40);     // Catch: Throwable -> L56
        if (r23 == null) goto L53;
        String r111 = ImFileUtil.a(r23);     // Catch: Throwable -> L56
    L54:
        mr9.e r24 = new mr9.e(null, null, r9, Float.valueOf(r0), Long.valueOf(r21), r19, r111, r17, r15, r110, null, null, 15363);     // Catch: Throwable -> L56
        r5.release();     // Catch: Throwable -> L59
        Object r1 = Result.constructor-impl(r24);     // Catch: Throwable -> L59
    L61:
        Throwable r25 = Result.exceptionOrNull-impl(r1);
        if (r25 == null) goto L65;
        FLogger.a.e("BaseCameraViewModel", "[retrieveMetaInfo] " + r25);
    L65:
        if (Result.isFailure-impl(r1) == true) goto L68;
        r3 = r1;
    L68:
        mr9.e r26 = (mr9.e) r3;
        if (r26 == null) goto L71;
        ImFileUtil.a.getClass();
        if (ImFileUtil.z(r26, false) == true) goto L76;
        return VideoMetaCheckResult.PASS;
    L76:
        if (ImFileUtil.z(r26, true) == true) goto L79;
        return VideoMetaCheckResult.OVER_DURATION;
    L79:
        return VideoMetaCheckResult.OVER_FORMAT;
    L71:
        return VideoMetaCheckResult.PASS;
    L53:
        r111 = null;
        goto L54
    L49:
        r110 = null;
    L42:
        r17 = r13;
        goto L43
    L33:
        r14 = false;
    L29:
        r15 = r10;
        goto L30
    L20:
        r11 = false;
    L16:
        r9 = r6;
        goto L17
    L7:
        r7 = false;
    L56:
        th = move-exception;
        r5.release();     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    }

    public final void bindAbility(q0 r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.ability = r2;
    }

    public final void recordCameraTipsType(Integer r2) {
        q0 r0 = this.ability;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ability");
        r0 = null;
    L5:
        r0.O(r2);
    }

    public final void updateDetectResult(ix8.d r8) {
        Intrinsics.checkNotNullParameter(r8, "detectResult");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public final void updateLatestPhotoChanged(long r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02231(this, r7, null), 3, null);
    }

    public final void updateOrientation(int r8) {
        z2.a.w3();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02241(this, r8, null), 3, null);
    }

    public final void updatePhotoPickerPageSlideOffset(int r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02251(this, r7, null), 3, null);
    }

    public void updatePicture(List<AlbumSelectItem> r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02261(this, r8, null), 3, null);
    }

    public static final /* synthetic */ VideoMetaCheckResult access$checkVideoMeta(BaseCameraViewModel r0, AlbumSelectItem r1) {
        return r0.checkVideoMeta(r1);
    }

    private static String com_larus_camera_impl_ui_base_BaseCameraViewModel_android_media_MediaMetadataRetriever_extractMetadata(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static final Unit interceptPickResultOversize$lambda$0(Function1 r1, List r2) {
        Intrinsics.checkNotNullParameter(r2, "uris");
        AlbumSelectItem r3 = (AlbumSelectItem) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L6;
        r1.invoke(r3);
    L6:
        return Unit.INSTANCE;
    }

    public final int getBottomMargin(Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        int r4 = r2.getResources().getDimensionPixelSize(2131166616);
        Fragment r0 = ability().getCurrentFragment();
        if (r0 == null) goto L12;
        FragmentActivity r1 = r0.getActivity();
        if (r1 != null) goto L8;
        return r4;
    L8:
        if (a0.c(r1, r3) == true) goto L11;
        return r4;
    L11:
        return r4 + ((Number) a0.a.getValue()).intValue();
    L12:
        return r4;
    }

    public final void interceptPickResultOversize(Context r11, List<AlbumSelectItem> r12, Function1<? super List<AlbumSelectItem>, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "resultList");
        Intrinsics.checkNotNullParameter(r13, "onNext");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(r12, this, r13, r11, null), 2, null);
    }

    public final void tryAdaptBottomLine(ConstraintLayout r4, int r5, Function1<? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "lineContainer");
        Fragment r0 = ability().getCurrentFragment();
        if (r0 == null) goto L5;
        FragmentActivity r1 = r0.getActivity();
    L7:
        if (r1 != null) goto L12;
        if (r6 == null) goto L24;
        r6.invoke(0);
        return;
    L24:
        return;
    L12:
        if (r4.isLaidOut() == true) goto L14;
    L22:
        r4.addOnLayoutChangeListener(new a(r1, r4, r6, r5));
        return;
    L14:
        if (r4.isLayoutRequested() == true) goto L22;
        if (a0.c(r1, r4) == true) goto L19;
        if (r6 == null) goto L25;
        r6.invoke(0);
        return;
    L25:
        return;
    L19:
        int r2 = ((Number) a0.a.getValue()).intValue();
        ConstraintSet r3 = new ConstraintSet();
        r3.clone(r4);
        r3.setGuidelineEnd(2131364481, r5 + r2);
        r3.applyTo(r4);
        if (r6 == null) goto L27;
        r6.invoke(Integer.valueOf(r2));
        return;
    L27:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Deprecated(message = "Use interceptPickResultOversize that accepts a list")
    public final void interceptPickResultOversize(Context r2, AlbumSelectItem r3, final Function1<? super AlbumSelectItem, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "result");
        Intrinsics.checkNotNullParameter(r4, "onNext");
        interceptPickResultOversize(r2, CollectionsKt.listOf(r3), new g(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void tryAdaptBottomLine$default(BaseCameraViewModel r0, ConstraintLayout r1, int r2, Function1 r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = r1.getResources().getDimensionPixelSize(2131166616);
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        r0.tryAdaptBottomLine(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryAdaptBottomLine");
    }
}
