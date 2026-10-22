package com.larus.bmhome.video.fragment;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.u1;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.databinding.LarusAiGenVideoDetailFragmentLayoutBinding;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.save_share.VideoGenerateSaver;
import com.larus.bmhome.video.view.AiGenVideoPlayControlView;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.g2;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.e0;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import tx9.a4;
import tx9.e2;
import tx9.o0;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 y2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002yzB°\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012G\b\u0002\u0010\u0010\u001aA\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018¢\u0006\u0004\b\u0019\u0010\u001aB\t\b\u0016¢\u0006\u0004\b\u0019\u0010\u001bJ\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020!H\u0016J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010%2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u001c\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010HH\u0096@¢\u0006\u0002\u0010IJ$\u0010J\u001a\f0KR\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020A2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010N\u001a\u00020\u0013H\u0002J\b\u0010O\u001a\u00020\tH\u0002J\u0010\u0010P\u001a\u0004\u0018\u00010QH\u0082@¢\u0006\u0002\u0010IJ\u001a\u0010R\u001a\u0004\u0018\u00010:2\b\u00101\u001a\u0004\u0018\u00010\u000bH\u0082@¢\u0006\u0002\u0010SJ\b\u0010T\u001a\u00020\u0013H\u0002J\b\u0010U\u001a\u00020\tH\u0016J\b\u0010V\u001a\u00020\u0013H\u0002J\u0018\u0010W\u001a\u00020\u00132\u0006\u0010X\u001a\u00020/2\u0006\u0010Y\u001a\u00020\u000bH\u0002J\u0012\u0010Z\u001a\u00020\u00132\b\u0010[\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010\\\u001a\u00020\u00132\u0006\u0010X\u001a\u00020/H\u0002J\u0016\u0010]\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010_J\u0018\u0010`\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u000bH\u0082@¢\u0006\u0002\u0010SJ\b\u0010a\u001a\u00020\u0013H\u0002J\b\u0010b\u001a\u00020\u0013H\u0016J\u000e\u0010c\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010IJ$\u0010d\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010\u000b2\b\u0010Y\u001a\u0004\u0018\u00010\u000b2\u0006\u0010e\u001a\u00020\tH\u0002J\u0012\u0010f\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010\u000bH\u0002J\u000e\u0010g\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010IJ\b\u0010h\u001a\u00020\u000bH\u0002J\b\u0010i\u001a\u00020\u000bH\u0002J\b\u0010j\u001a\u00020\u0013H\u0016J\b\u0010k\u001a\u00020\u0013H\u0002J\u0012\u0010\"\u001a\u00020\u00132\b\u0010l\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010m\u001a\u00020\u000bH\u0002J\u0012\u0010n\u001a\u00020\u00132\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010o\u001a\u00020\u0013H\u0016J\b\u0010p\u001a\u00020/H\u0002J\b\u0010q\u001a\u00020\u000bH\u0002J\u0010\u0010r\u001a\u00020\u00132\u0006\u0010s\u001a\u00020tH\u0016J\b\u0010u\u001a\u00020\u0013H\u0016J\u0010\u0010v\u001a\u00020\u00132\u0006\u0010w\u001a\u00020/H\u0016J\b\u0010x\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000RM\u0010\u0010\u001aA\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u000e\u00107\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Lcom/larus/bmhome/video/fragment/AiGenVideoDetailFragment;", "Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment;", "Lcom/larus/bmhome/databinding/LarusAiGenVideoDetailFragmentLayoutBinding;", "Lcom/larus/platform/api/creation/ICreationListener;", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "isMixed", "", "creationTaskId", "", "canPublish", "isBlockContent", "isReadonlyForwardDetail", "showVideoExtendFunction", "toVideoExtendBlk", "Lkotlin/Function4;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onResult", "onVideoExtendShownBlk", "Lkotlin/Function0;", "<init>", "(Lcom/larus/platform/model/video/VideoPlayData;Lcom/larus/bmhome/utils/VideoDetailEventParams;ZLjava/lang/String;ZZZZLkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;)V", "()V", "showEditPanel", "editPanelType", "Lcom/larus/common_ui/fragment/helper/EditPanelType;", "tag", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "download", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "titleBar", "Landroid/view/ViewGroup;", "privacyContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "publishContainer", "bottomToolsContainer", "creationContainerView", "Lcom/larus/bmhome/view/CreationOperateContainerView;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "latestCreationPrivateStatus", "", "rootContainer", "messageId", "getMessageId", "()Ljava/lang/String;", "currentCreationType", "getCurrentCreationType", "()I", "currentCreationButtonStatus", "currentCreationId", "creationStatus", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "hasRepotQuit", "fragmentCreateTime", "", "videoGenerateSaver", "Lcom/larus/bmhome/video/save_share/VideoGenerateSaver;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "getMetaDataMap", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initViews", "Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment$InitViewsResult;", "onViewCreated", "view", "innerInitView", "isByPublisher", "getPublisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "getLatestUserCreationFromIM", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initButtonClickListener", "isVideoMute", "publishCreation", "updateCurrentCreationButtonStatus", "status", "creationId", "openPrivacyDialog", "containerView", "refreshButtonStatus", "setCreationPrivacy", "private", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestCreationId", "deleteCreation", "onResume", "addCreation", "reportPicAddCreation", "success", "reportPicClickAddCreation", "getSubType", "getItemName", "getCurrentStatus", "onDestroyView", "initIconListeners", "videoContent", "getKey", "onCreate", "onDestroy", "getCurrentButtonStatus", "getCurrentCreationId", "onPublishSuccess", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "onQuitClick", "onDoCreationAction", "action", "onSelected", "Companion", "UserCreationPrivateStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiGenVideoDetailFragment extends BaseVideoDetailFragment<LarusAiGenVideoDetailFragmentLayoutBinding> implements zp9.r {
    public static final /* synthetic */ int U = 0;
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final Function4<nr9.g, String, String, Function1<? super Boolean, Unit>, Unit> D;
    public final Function0<Unit> E;
    public CommonDownLoadLayout F;
    public ConstraintLayout G;
    public ConstraintLayout H;
    public ViewGroup I;
    public ConstraintLayout J;
    public CreationOperateContainerView K;
    public final CoroutineScope L;
    public int M;
    public ConstraintLayout N;
    public int O;
    public String P;
    public UserCreationFromIM Q;
    public boolean R;
    public long S;
    public final VideoGenerateSaver T;
    public final boolean x;
    public final String y;
    public final boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/video/fragment/AiGenVideoDetailFragment$UserCreationPrivateStatus;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UserCreationPrivateStatus {
        public static final a Companion = null;
        public static final int PRIVATE = 2;
        public static final int PUBLIC = 1;
        public static final int UNKNOWN = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$onCreate$1", f = "AiGenVideoDetailFragment.kt", i = {}, l = {716, 718, 725}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ AiGenVideoDetailFragment this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$onCreate$1$1", f = "AiGenVideoDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AiGenVideoDetailFragment this$0;

            public C00431(AiGenVideoDetailFragment r1, Continuation<? super C00431> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00431(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L35;
                ResultKt.throwOnFailure(r5);
                AiGenVideoDetailFragment r6 = this.this$0;
                int r0 = AiGenVideoDetailFragment.U;
                int r1 = 0;
                if (r6.la0().length() != 0) goto L7;
                boolean r2 = true;
            L8:
                if (r2 == true) goto L24;
                UserCreationFromIM r3 = r6.Q;
                if (r3 != null) goto L13;
                r1 = 1;
                goto L24
            L13:
                Integer r4 = r3.getPrivateStatus();
                if (r4 != null) goto L17;
            L19:
                if (r4 == null) goto L24;
                if (r4.intValue() != 2) goto L24;
                r1 = 2;
                goto L24
            L17:
                if (r4.intValue() != 1) goto L19;
                r1 = 3;
            L24:
                UserCreationFromIM r7 = this.this$0.Q;
                if (r7 == null) goto L28;
                String r8 = r7.getCreationId();
                if (r8 == null) goto L28;
            L29:
                r6.O = r1;
                r6.M = r1;
                r6.P = r8;
                CreationOperateContainerView r9 = r6.K;
                if (r9 == null) goto L32;
                r9.setByPublisher(r6.oa0());
            L32:
                r6.pa0(r6.O);
                return Unit.INSTANCE;
            L28:
                r8 = "";
                goto L29
            L7:
                r2 = false;
                goto L8
            L35:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(AiGenVideoDetailFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            u1 r2 = (u1) this.L$0;
            ResultKt.throwOnFailure(r7);
        L44:
            PublisherCreation r8 = (PublisherCreation) r7;
            r2.getClass();
            if (r8 != null) goto L47;
            FLogger.a.e("PublishHelper", "preCreateIfAbsent is null");
        L49:
            return Unit.INSTANCE;
        L47:
            e0.a.g1(r8);
            goto L49
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r7);
        L34:
            AiGenVideoDetailFragment r9 = this.this$0;
            if (r9.x == false) goto L49;
            if (r9.oa0() == false) goto L49;
            if (this.this$0.A == true) goto L49;
            u1 r10 = new u1();
            AiGenVideoDetailFragment r3 = this.this$0;
            this.L$0 = r10;
            this.label = 3;
            Object r4 = r3.ma0(this);
            if (r4 != r0) goto L43;
            return r0;
        L43:
            r2 = r10;
            r7 = r4;
            goto L44
        L11:
            ResultKt.throwOnFailure(r7);
        L24:
            String r11 = (String) r7;
            if (r11 != null) goto L27;
        L26:
            r11 = "";
        L27:
            AiGenVideoDetailFragment r5 = this.this$0;
            Map r12 = DataConverterKt.d(r11);
            AiGenVideoDetailFragment r6 = this.this$0;
            int r13 = AiGenVideoDetailFragment.U;
            if (r6.x == false) goto L30;
            String r14 = String.valueOf(r6.y);
        L31:
            r5.Q = (UserCreationFromIM) ((LinkedHashMap) r12).get(r14);
            MainCoroutineDispatcher r15 = Dispatchers.getMain();
            C00431 r16 = new C00431(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r15, r16, this) != r0) goto L34;
            return r0;
        L30:
            r14 = TriggerSendLoading.NO_LOADING;
            goto L31
        L12:
            ResultKt.throwOnFailure(r7);
            AiGenVideoDetailFragment r17 = this.this$0;
            int r18 = AiGenVideoDetailFragment.U;
            if (r17.la0().length() != 0) goto L15;
            boolean r19 = true;
        L16:
            if (r19 == true) goto L18;
            IChatRepoService r20 = RepoDispatcherDelegate.b.e();
            if (r20 == null) goto L26;
            String r21 = this.this$0.la0();
            this.label = 1;
            r7 = r20.w1(r21, this);
            if (r7 != r0) goto L24;
            return r0;
        L18:
            return Unit.INSTANCE;
        L15:
            r19 = false;
            goto L16
        }
    }

    static {
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final String tag() {
        return "AiGenVideoDetailFragment";
    }

    public AiGenVideoDetailFragment() {
        VideoDetailPagerFragment r1 = null;
        this(r1, new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383));
        VideoDetailPagerFragment r0 = getParentFragment();     // Catch: IllegalStateException -> L15
        if ((r0 instanceof VideoDetailPagerFragment) == false) goto L6;
        r1 = r0;     // Catch: IllegalStateException -> L15
    L6:
        if (r1 == null) goto L20;
        r1.dismiss();     // Catch: Exception -> L9
    L22:
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: IllegalStateException -> L15
        Throwable r2 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L15
        if (r2 == null) goto L21;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L15
        return;
    L21:
        return;
    L20:
        return;
    L15:
        FLogger.a.e("AiGenVideoDetailFragment", "fallback by dismiss failed");
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void Oh() {
        if (this.R == false) goto L5;
        return;
    L5:
        this.R = true;
        nr9.g r0 = this.e;
        Long r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.a;
    L9:
        c4 r3 = this.f;
        String r4 = r3.b;
        String r5 = r3.a;
        String r6 = r3.c;
        if (this.S <= 0) goto L12;
        r1 = Long.valueOf(SystemClock.elapsedRealtime() - this.S);
    L12:
        a4.i(r2, r4, r5, r6, TriggerSendLoading.NO_LOADING, r1, 192);
        this.S = -1;
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final boolean dc() {
        return z2.a.getCreationExtendVideoConfig().b();
    }

    public final int ha0() {
        UserCreationFromIM r0 = this.Q;
        if (r0 == null) goto L7;
        Integer r1 = r0.getCreationType();
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 7;
    }

    public final String ia0() {
        int r0 = this.O;
        if (r0 != 1) goto L5;
        return "-1";
    L5:
        if (r0 != 2) goto L7;
        return TriggerSendLoading.NO_LOADING;
    L7:
        if (r0 == 3) goto L9;
        return "";
    L9:
        return "1";
    }

    public final String ja0() {
        int r0 = this.O;
        if (r0 != 1) goto L5;
        return "go_public";
    L5:
        if (r0 != 2) goto L7;
        return "go_public";
    L7:
        if (r0 == 3) goto L9;
        return "";
    L9:
        return "already_public";
    }

    public final String la0() {
        String r0 = this.f.b;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final boolean oa0() {
        boolean r0 = z2.a.getCreationPublishConfig().b();
        FLogger.a.i("AiGenVideoDetailFragment", "isByPublisher enableEnterPublisher:" + r0);
        return r0;
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void onDestroy() {
        e0.a.c1(this);
        super.onDestroy();
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final EditPanelType SQ() {
        if (dc() == false) goto L7;
        return EditPanelType.VIDEO;
    L7:
        return EditPanelType.NONE;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        CoroutineScopeKt.cancel$default(this.L, null, 1, null);
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void onResume() {
        super.onResume();
        ConstraintLayout r0 = this.N;
        if (r0 == null) goto L6;
        r0.postDelayed(new d(this), 500);
        return;
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void u() {
        this.t = "slide";
        if (this.C == false) goto L6;
        this.E.invoke();
        return;
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final ShareScene da0() {
        return ShareScene.VIDEO_VIEWER;
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void FU(int r8) {
        if (r8 != 6) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AiGenVideoDetailFragment$onDoCreationAction$1(this, null), 2, null);
        return;
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void W90(nr9.g r8) {
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AiGenVideoDetailFragment$download$1(this, r8, null), 3, null);
    }

    public final void X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final Object X90(Continuation<? super Map<String, String>> r5) {
        if ((r5 instanceof AiGenVideoDetailFragment$getMetaDataMap$1) == false) goto L7;
        AiGenVideoDetailFragment$getMetaDataMap$1 r0 = (AiGenVideoDetailFragment$getMetaDataMap$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        ICreationMetadataService.Companion r4 = ICreationMetadataService.a;
        return r4.s((UserCreationFromIM) r6, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        String r7 = la0();
        r0.label = 1;
        r6 = ka0(r7, r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new AiGenVideoDetailFragment$getMetaDataMap$1(this, r5);
        goto L8
    }

    public final void bZ(UserCreation r4) {
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        String r0 = r4.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0, this.P) == false) goto L9;
        FLogger.a.d("AiGenVideoDetailFragment", "onPublishSuccess, creationId: " + r4.a);
        pa0(3);
        return;
    }

    public final Object ma0(Continuation<? super PublisherCreation> r38) {
        if ((r38 instanceof AiGenVideoDetailFragment$getPublisherCreation$1) == false) goto L7;
        AiGenVideoDetailFragment$getPublisherCreation$1 r2 = (AiGenVideoDetailFragment$getPublisherCreation$1) r38;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L17:
        UserCreationFromIM r6 = (UserCreationFromIM) r1;
        String r7 = null;
        if (r6 == null) goto L20;
        PublisherCreation r8 = zp9.x.a(r6);
    L21:
        if (r8 != null) goto L23;
        r8 = new PublisherCreation(this.P, null, null, null, null, null, null, null, null, false, null, null, null, null, 16382, null);
    L23:
        PublisherCreation r20 = r8;
        nr9.g r9 = this.e;
        if (r9 == null) goto L28;
        nr9.f r10 = r9.g;
        if (r10 == null) goto L28;
        r7 = r10.b;
    L28:
        String r26 = r7;
        return PublisherCreation.copy$default(r20, null, Boxing.boxInt(ha0()), Boxing.boxInt(ha0()), la0(), null, r26, null, Boxing.boxInt(0), this.y, false, null, null, null, null, 15953, null);
    L20:
        r8 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        String r11 = la0();
        r2.label = 1;
        r1 = ka0(r11, r2);
        if (r1 != r4) goto L17;
        return r4;
    L7:
        r2 = new AiGenVideoDetailFragment$getPublisherCreation$1(this, r38);
        goto L8
    }

    public final Object na0(Continuation<? super String> r5) {
        if ((r5 instanceof AiGenVideoDetailFragment$getSubType$1) == false) goto L7;
        AiGenVideoDetailFragment$getSubType$1 r0 = (AiGenVideoDetailFragment$getSubType$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        PublisherCreation r7 = (PublisherCreation) r6;
        if (r7 == null) goto L22;
        Integer r8 = r7.getCreationType();
        if (r8 == null) goto L22;
        int r9 = r8.intValue();
    L24:
        return zp9.y.a(r9);
    L22:
        r9 = ha0();
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        r0.label = 1;
        r6 = ma0(r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new AiGenVideoDetailFragment$getSubType$1(this, r5);
        goto L8
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        e0.a.e1(this);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, null), 3, null);
        this.M = this.O;
    }

    public final void pa0(int r4) {
        if (this.z == true) goto L5;
    L10:
        ConstraintLayout r0 = this.K;
        if (r0 == null) goto L13;
        e1.o(r0);
    L13:
        int r1 = 0;
        if (com.larus.bmhome.utils.u.h() == true) goto L16;
    L18:
        boolean r2 = false;
    L19:
        CreationOperateContainerView r3 = this.K;
        if (r3 == null) goto L24;
        if (r2 == false) goto L23;
        r1 = r4;
    L23:
        r3.r1(r1);
    L24:
        this.O = r4;
        return;
    L16:
        if (AccountService.a.isLogin().booleanValue() == false) goto L18;
        r2 = true;
        goto L19
    L5:
        if (z2.a.getCreationPublishConfig().b() == false) goto L10;
        ConstraintLayout r5 = this.K;
        if (r5 == null) goto L13;
        e1.x(r5);
        goto L13
    }

    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public /* synthetic */ AiGenVideoDetailFragment(nr9.g r12, c4 r13) {
        this(r12, r13, false, null, true, false, false, false, new b(), new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object ea0(AiGenVideoDetailFragment r45, Continuation r46) {
        r45.getClass();
        if ((r46 instanceof AiGenVideoDetailFragment$addCreation$1) == false) goto L7;
        AiGenVideoDetailFragment$addCreation$1 r2 = (AiGenVideoDetailFragment$addCreation$1) r46;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        String r7 = "recommend_from";
        Continuation r6 = "";
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L16;
        int r5 = r2.I$0;
        zp9.a r8 = (zp9.a) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r6 = "";
        r7 = "recommend_from";
        String r23 = "template_rec_req_id";
        Continuation r13 = null;
        boolean r12 = true;
    L58:
        boolean r10 = false;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AiGenVideoDetailFragment$reportPicAddCreation$1(r45.la0(), false, r6, r13), 3, null);
        zp9.a r9 = r8;
    L80:
        if (r9 != null) goto L82;
    L84:
        if (r10 == false) goto L90;
        if (r9 == null) goto L89;
        UserCreation r14 = r9.b;
        if (r14 == null) goto L89;
        Continuation r27 = r14.a;
    L91:
        String r15 = r45.f.h;
        String r29 = r45.la0();
        String r30 = zp9.y.b(r45.ha0());
        if (r5 != 2) goto L94;
        String r16 = TriggerSendLoading.NO_LOADING;
    L95:
        String r32 = r16;
        JSONObject r17 = r45.f.m;
        if (r17 == null) goto L98;
        Object r18 = r17.opt(r7);
    L99:
        String r33 = String.valueOf(r18);
        JSONObject r19 = r45.f.m;
        if (r19 == null) goto L102;
        Object r20 = r19.opt("from_template_id");
    L103:
        String r34 = String.valueOf(r20);
        JSONObject r21 = r45.f.m;
        if (r21 == null) goto L106;
        Object r22 = r21.opt("template_rec_extra");
    L107:
        String r36 = String.valueOf(r22);
        JSONObject r0 = r45.f.m;
        if (r0 == null) goto L110;
        Object r24 = r0.opt(r23);
    L111:
        e2.a.b(new o0("video_detail", "chat", r27, r15, r29, r30, "-1", r32, r33, r34, String.valueOf(r24), r36, null, null, null, null, null, null, 516097), r13, 3);
        return Unit.INSTANCE;
    L110:
        r24 = r13;
        goto L111
    L106:
        r22 = r13;
        goto L107
    L102:
        r20 = r13;
        goto L103
    L98:
        r18 = r13;
        goto L99
    L94:
        r16 = "1";
    L89:
        r27 = r13;
        goto L91
    L90:
        r27 = r6;
        goto L91
    L82:
        if (r9.a != r12) goto L84;
        r10 = true;
        goto L84
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r25 = r2.I$1;
        int r26 = r2.I$0;
        ResultKt.throwOnFailure(r1);
        r23 = "template_rec_req_id";
        r13 = null;
        r12 = true;
        int r28 = r25;
        r5 = r26;
    L47:
        r9 = (zp9.a) r1;
        if (r9 != null) goto L50;
    L52:
        boolean r110 = false;
    L53:
        if (r110 == true) goto L59;
        MainCoroutineDispatcher r31 = Dispatchers.getMain();
        AiGenVideoDetailFragment$addCreation$3 r35 = new AiGenVideoDetailFragment$addCreation$3(r45, r9, r13);
        r2.L$0 = r9;
        r2.I$0 = r5;
        r2.label = 4;
        if (BuildersKt.withContext(r31, r35, r2) == r11) goto L117;
        r8 = r9;
        goto L58
    L117:
        return r11;
    L59:
        r10 = false;
        String r37 = r45.la0();
        if (r9 == null) goto L64;
        UserCreation r38 = r9.b;
        if (r38 == null) goto L64;
        Continuation r39 = r38.a;
    L65:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AiGenVideoDetailFragment$reportPicAddCreation$1(r37, r12, r39, r13), 3, null);
        t19.s r40 = t19.s.a;
        Context r41 = r45.getContext();
        Context r42 = r45.getContext();
        if (r42 == null) goto L71;
        Resources r43 = r42.getResources();
        if (r43 == null) goto L71;
        String r44 = r43.getString(2131900634);
        String r47 = r44;
        if (r44 == null) goto L71;
    L72:
        r40.getClass();
        t19.s.p(r41, r47);
        r45.M = r28;
        if (r9 == null) goto L78;
        UserCreation r48 = r9.b;
        if (r48 == null) goto L78;
        String r49 = r48.a;
        String r50 = r49;
        if (r49 == null) goto L78;
    L79:
        r45.P = r50;
    L78:
        r50 = r6;
    L71:
        r47 = r6;
    L64:
        r39 = r13;
        goto L65
    L50:
        if (r9.a != r12) goto L52;
        r110 = true;
        goto L53
    L18:
        int r51 = r2.I$1;
        int r52 = r2.I$0;
        ResultKt.throwOnFailure(r1);
        int r53 = r51;
        int r54 = r52;
    L39:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AiGenVideoDetailFragment$reportPicClickAddCreation$1(r45.la0(), r45, null), 3, null);
        e0 r55 = e0.a;
        String r56 = r45.la0();
        int r57 = r45.ha0();
        String r58 = r45.y;
        if (r45.A == false) goto L42;
        int r111 = 4;
    L43:
        r2.I$0 = r54;
        r2.I$1 = r53;
        r2.label = 3;
        int r112 = r54;
        r23 = "template_rec_req_id";
        r13 = null;
        r12 = true;
        Object r59 = g2.a.a(r56, r57, TriggerSendLoading.NO_LOADING, r112, r58, r111, r2, 64);
        if (r59 == r11) goto L116;
        r28 = r53;
        r1 = r59;
        r5 = r112;
        goto L47
    L116:
        return r11;
    L42:
        r111 = 1;
        goto L43
    L19:
        u1 r60 = (u1) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L26:
        PublisherCreation r61 = (PublisherCreation) r1;
        JSONObject r62 = r45.f.m;
        if (r62 == null) goto L29;
        Object r63 = r62.opt("recommend_from");
    L30:
        String r64 = String.valueOf(r63);
        JSONObject r65 = r45.f.m;
        if (r65 == null) goto L33;
        Object r66 = r65.opt("template_rec_req_id");
    L34:
        PublisherTrackParams r67 = new PublisherTrackParams("video_detail", r64, String.valueOf(r66));
        r60.getClass();
        u1.a(r61, r67);
        FLogger.a.i("AiGenVideoDetailFragment", "gotoPublisher");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AiGenVideoDetailFragment$reportPicClickAddCreation$1(r45.la0(), r45, null), 3, null);
        return Unit.INSTANCE;
    L33:
        r66 = null;
        goto L34
    L29:
        r63 = null;
        goto L30
    L20:
        ResultKt.throwOnFailure(r1);
        if (r45.oa0() == false) goto L35;
        u1 r68 = new u1();
        r2.L$0 = r68;
        r2.label = 1;
        Object r69 = r45.ma0(r2);
        if (r69 == r11) goto L114;
        r60 = r68;
        r1 = r69;
        goto L26
    L114:
        return r11;
    L35:
        MainCoroutineDispatcher r70 = Dispatchers.getMain();
        AiGenVideoDetailFragment$addCreation$2 r71 = new AiGenVideoDetailFragment$addCreation$2(r45, 3, null);
        r2.I$0 = 1;
        r2.I$1 = 3;
        r2.label = 2;
        if (BuildersKt.withContext(r70, r71, r2) == r11) goto L115;
        r53 = 3;
        r54 = 1;
        goto L39
    L115:
        return r11;
    L7:
        r2 = new AiGenVideoDetailFragment$addCreation$1(r45, r46);
        goto L8
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final BaseVideoDetailFragment<LarusAiGenVideoDetailFragmentLayoutBinding>.b Y90(LayoutInflater r13, ViewGroup r14) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r15 = r13.inflate(2131561806, r14, false);
        int r16 = 2131363806;
        if (((ImageView) ViewBindings.findChildViewById(r15, 2131363806)) == null) goto L23;
        r16 = 2131364161;
        if (((ImageView) ViewBindings.findChildViewById(r15, 2131364161)) == null) goto L23;
        r16 = 2131364437;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r15, 2131364437);
        if (r3 == null) goto L23;
        r16 = 2131368277;
        CreationOperateContainerView r4 = (CreationOperateContainerView) ViewBindings.findChildViewById(r15, 2131368277);
        if (r4 == null) goto L23;
        r16 = 2131370188;
        CommonDownLoadLayout r5 = ViewBindings.findChildViewById(r15, 2131370188);
        if (r5 == null) goto L23;
        r16 = 2131384472;
        RelativeLayout r0 = (RelativeLayout) ViewBindings.findChildViewById(r15, 2131384472);
        if (r0 == null) goto L23;
        r16 = 2131388807;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r15, 2131388807);
        if (r7 == null) goto L23;
        r16 = 2131392346;
        AiGenVideoPlayControlView r10 = (AiGenVideoPlayControlView) ViewBindings.findChildViewById(r15, 2131392346);
        if (r10 == null) goto L23;
        r16 = 2131392404;
        VideoPlayView r11 = ViewBindings.findChildViewById(r15, 2131392404);
        if (r11 == null) goto L23;
        ConstraintLayout r17 = r15;
        LarusAiGenVideoDetailFragmentLayoutBinding r18 = new LarusAiGenVideoDetailFragmentLayoutBinding(r17, r3, r4, r5, r0, r7, r10, r11);
        this.N = r17;
        return new BaseVideoDetailFragment.b(r18, r11, r0, r10);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }

    public final Object ka0(String r6, Continuation<? super UserCreationFromIM> r7) {
        if ((r7 instanceof AiGenVideoDetailFragment$getLatestUserCreationFromIM$1) == false) goto L7;
        AiGenVideoDetailFragment$getLatestUserCreationFromIM$1 r0 = (AiGenVideoDetailFragment$getLatestUserCreationFromIM$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = "";
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L30:
        String r9 = (String) r8;
        if (r9 == null) goto L34;
        r4 = r9;
    L34:
        Map r10 = DataConverterKt.d(r4);
        if (this.x == false) goto L37;
        String r11 = String.valueOf(this.y);
    L39:
        return ((LinkedHashMap) r10).get(r11);
    L37:
        r11 = TriggerSendLoading.NO_LOADING;
        goto L39
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r6 != null) goto L17;
    L20:
        boolean r12 = true;
    L21:
        if (r12 == false) goto L24;
        return null;
    L24:
        IChatRepoService r13 = RepoDispatcherDelegate.b.e();
        if (r6 != null) goto L27;
        r6 = "";
    L27:
        r0.label = 1;
        r8 = r13.w1(r6, r0);
        if (r8 != r2) goto L30;
        return r2;
    L17:
        if (r6.length() == 0) goto L20;
        r12 = false;
    L7:
        r0 = new AiGenVideoDetailFragment$getLatestUserCreationFromIM$1(this, r7);
        goto L8
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super.onViewCreated(r13, r14);
        ConstraintLayout r15 = this.G;
        if (r15 == null) goto L5;
        r15.setBackgroundResource(R.color.transparent);
    L5:
        ConstraintLayout r16 = this.N;
        ViewGroup r17 = null;
        if (r16 == null) goto L8;
        ConstraintLayout r18 = (ConstraintLayout) r16.findViewById(2131383028);
    L9:
        this.H = r18;
        ConstraintLayout r19 = this.N;
        if (r19 == null) goto L12;
        r17 = (ViewGroup) r19.findViewById(2131383424);
    L12:
        this.I = r17;
        ConstraintLayout r110 = this.J;
        if (r110 == null) goto L15;
        i0.a.getClass();
        int r5 = i0.e() + i5.h();
        int r6 = r110.getPaddingStart();
        int r7 = r110.getPaddingTop();
        int r8 = r110.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r110.getClass().getSimpleName() + ",source:,start:" + r6 + ",top:" + r7 + ",end:" + r8 + ",bottom:" + r5);
        r110.setPaddingRelative(r6, r7, r8, r5);
    L15:
        ConstraintLayout r111 = this.J;
        if (r111 == null) goto L18;
        e1.x(r111);
    L18:
        CommonDownLoadLayout r112 = this.F;
        if (r112 == null) goto L21;
        r112.setLayoutEnable(true);
    L21:
        VideoPlayView r113 = this.q;
        if (r113 == null) goto L24;
        i0.a.getClass();
        int r9 = ((((i0.e() + i5.h()) + i5.c0()) + i5.h()) - i0.g()) / 2;
        int r10 = r113.getPaddingStart();
        int r11 = r113.getPaddingTop();
        int r12 = r113.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r113.getClass().getSimpleName() + ",source:,start:" + r10 + ",top:" + r11 + ",end:" + r12 + ",bottom:" + r9);
        r113.setPaddingRelative(r10, r11, r12, r9);
    L24:
        ConstraintLayout r114 = this.G;
        if (r114 == null) goto L27;
        i0.a.getClass();
        int r20 = i0.g();
        int r21 = r114.getPaddingStart();
        int r22 = r114.getPaddingEnd();
        int r23 = r114.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r114.getClass().getSimpleName() + ",source:,start:" + r21 + ",top:" + r20 + ",end:" + r22 + ",bottom:" + r23);
        r114.setPaddingRelative(r21, r20, r22, r23);
    L27:
        e1.d(this.H, new e(this));
        e1.d(this.I, new f(this));
        VideoPlayView r115 = this.q;
        if (r115 == null) goto L30;
        r115.setOnLongClickListener(new g(this));
    L30:
        pa0(this.O);
        nr9.g r116 = this.e;
        if (r116 == null) goto L35;
        CommonDownLoadLayout r117 = this.F;
        if (r117 == null) goto L35;
        r117.S5(LifecycleOwnerKt.getLifecycleScope(this), new com.larus.bmhome.bigimg.download.d.c(r116));
    L35:
        CommonDownLoadLayout r118 = this.F;
        if (r118 == null) goto L39;
        e1.d(r118, new com.larus.bmhome.video.fragment.a(this));
        return;
    L39:
        return;
    L8:
        r18 = null;
        goto L9
    }

    public static final Object fa0(AiGenVideoDetailFragment r5, String r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof AiGenVideoDetailFragment$getLatestCreationId$1) == false) goto L7;
        AiGenVideoDetailFragment$getLatestCreationId$1 r0 = (AiGenVideoDetailFragment$getLatestCreationId$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L30:
        String r9 = (String) r8;
    L32:
        if (r9 != null) goto L34;
        r9 = "";
    L34:
        Map r10 = DataConverterKt.d(r9);
        if (r5.x == false) goto L37;
        String r11 = String.valueOf(r5.y);
    L38:
        UserCreationFromIM r12 = (UserCreationFromIM) ((LinkedHashMap) r10).get(r11);
        if (r12 == null) goto L44;
        String r4 = r12.getCreationId();
        if (r4 == null) goto L44;
        return r4;
    L44:
        return "";
    L37:
        r11 = TriggerSendLoading.NO_LOADING;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r6 != null) goto L17;
    L20:
        boolean r13 = true;
    L21:
        if (r13 == true) goto L44;
        IChatRepoService r14 = RepoDispatcherDelegate.b.e();
        if (r14 == null) goto L31;
        if (r6 != null) goto L27;
        r6 = "";
    L27:
        r0.label = 1;
        r8 = r14.w1(r6, r0);
        if (r8 != r2) goto L30;
        return r2;
    L31:
        r9 = null;
        goto L32
    L17:
        if (r6.length() == 0) goto L20;
        r13 = false;
    L7:
        r0 = new AiGenVideoDetailFragment$getLatestCreationId$1(r5, r7);
        goto L8
    }

    public static final Object ga0(AiGenVideoDetailFragment r36, boolean r37, Continuation r38) {
        boolean r1 = r37;
        r36.getClass();
        if ((r38 instanceof AiGenVideoDetailFragment$setCreationPrivacy$1) == false) goto L7;
        AiGenVideoDetailFragment$setCreationPrivacy$1 r3 = (AiGenVideoDetailFragment$setCreationPrivacy$1) r38;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r3.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        int r6 = r3.I$0;
        ResultKt.throwOnFailure(r2);
    L104:
        r36.M = r6;
    L106:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r2);
        goto L106
    L14:
        r6 = r3.I$2;
        int r7 = r3.I$1;
        int r8 = r3.I$0;
        ResultKt.throwOnFailure(r2);
    L76:
        Pair r9 = (Pair) r2;
        if (r9 == null) goto L79;
        Boolean r10 = (Boolean) r9.getFirst();
    L81:
        if (Intrinsics.areEqual(r10, Boxing.boxBoolean(true)) == true) goto L86;
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AiGenVideoDetailFragment$setCreationPrivacy$3 r12 = new AiGenVideoDetailFragment$setCreationPrivacy$3(r36, r8, null);
        r3.label = 5;
        if (BuildersKt.withContext(r11, r12, r3) != r5) goto L106;
        return r5;
    L86:
        if (r7 != 2) goto L92;
        Context r13 = r36.getContext();
        if (r13 == null) goto L97;
        Resources r14 = r13.getResources();
        if (r14 == null) goto L97;
        String r15 = r14.getString(2131900633);
    L98:
        t19.s r16 = t19.s.a;
        Context r17 = r36.getContext();
        if (r15 != null) goto L101;
        r15 = "";
    L101:
        r16.getClass();
        t19.s.p(r17, r15);
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        AiGenVideoDetailFragment$setCreationPrivacy$4 r19 = new AiGenVideoDetailFragment$setCreationPrivacy$4(r7, r36, null);
        r3.I$0 = r6;
        r3.label = 6;
        if (BuildersKt.withContext(r18, r19, r3) != r5) goto L104;
        return r5;
    L97:
        r15 = null;
        goto L98
    L92:
        Context r20 = r36.getContext();
        if (r20 == null) goto L97;
        Resources r21 = r20.getResources();
        if (r21 == null) goto L97;
        r15 = r21.getString(2131900634);
        goto L98
    L79:
        r10 = null;
        goto L81
    L15:
        int r22 = r3.I$2;
        r7 = r3.I$1;
        int r110 = r3.I$0;
        String r111 = (String) r3.L$9;
        String r112 = (String) r3.L$8;
        String r113 = (String) r3.L$7;
        String r114 = (String) r3.L$6;
        String r115 = (String) r3.L$5;
        String r23 = (String) r3.L$4;
        String r24 = (String) r3.L$3;
        String r25 = (String) r3.L$2;
        String r26 = (String) r3.L$1;
        String r27 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r116 = r27;
        String r28 = r26;
        String r29 = r23;
        String r210 = r24;
        String r211 = r25;
        r8 = r110;
        String r212 = r111;
        String r213 = r112;
        String r214 = r113;
        String r215 = r114;
        String r216 = r115;
        r6 = r22;
    L73:
        e2.a.b(new o0("video_detail", "chat", r116, r28, r212, r211, r210, r29, r216, r215, r213, r214, null, (String) r2, null, null, null, null, 499713), null, 3);
        e0 r30 = e0.a;
        String r31 = r36.P;
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.L$6 = null;
        r3.L$7 = null;
        r3.L$8 = null;
        r3.L$9 = null;
        r3.I$0 = r8;
        r3.I$1 = r7;
        r3.I$2 = r6;
        r3.label = 4;
        r2 = r30.h(r31, r7, r3);
        if (r2 != r5) goto L76;
        return r5;
    L16:
        int r32 = r3.I$2;
        r7 = r3.I$1;
        int r33 = r3.I$0;
        boolean r34 = r3.Z$0;
        ResultKt.throwOnFailure(r2);
        int r35 = r33;
        int r39 = r32;
        r1 = r34;
    L46:
        String r40 = r36.P;
        String r41 = r36.y;
        String r42 = zp9.y.b(r36.ha0());
        String r117 = TriggerSendLoading.NO_LOADING;
        if (r1 == false) goto L49;
        String r118 = "1";
    L50:
        if (r1 == true) goto L53;
        r117 = "1";
    L53:
        JSONObject r43 = r36.f.m;
        if (r43 == null) goto L56;
        Object r44 = r43.opt("recommend_from");
    L57:
        String r119 = String.valueOf(r44);
        JSONObject r45 = r36.f.m;
        if (r45 == null) goto L60;
        Object r46 = r45.opt("from_template_id");
    L61:
        String r47 = String.valueOf(r46);
        JSONObject r120 = r36.f.m;
        if (r120 == null) goto L64;
        Object r121 = r120.opt("template_rec_extra");
    L65:
        String r122 = String.valueOf(r121);
        JSONObject r123 = r36.f.m;
        if (r123 == null) goto L68;
        Object r124 = r123.opt("template_rec_req_id");
    L69:
        String r125 = String.valueOf(r124);
        String r126 = r36.la0();
        r3.L$0 = r40;
        r3.L$1 = r41;
        r3.L$2 = r42;
        r3.L$3 = r118;
        r3.L$4 = r117;
        r3.L$5 = r119;
        r3.L$6 = r47;
        r3.L$7 = r122;
        r3.L$8 = r125;
        r3.L$9 = r126;
        r3.I$0 = r35;
        r3.I$1 = r7;
        r3.I$2 = r39;
        r3.label = 3;
        Object r48 = r36.na0(r3);
        if (r48 == r5) goto L110;
        r215 = r47;
        r116 = r40;
        r28 = r41;
        r211 = r42;
        r212 = r126;
        r214 = r122;
        r213 = r125;
        r29 = r117;
        r210 = r118;
        r216 = r119;
        r8 = r35;
        r2 = r48;
        r6 = r39;
        goto L73
    L110:
        return r5;
    L68:
        r124 = null;
        goto L69
    L64:
        r121 = null;
        goto L65
    L60:
        r46 = null;
        goto L61
    L56:
        r44 = null;
        goto L57
    L49:
        r118 = TriggerSendLoading.NO_LOADING;
        goto L50
    L17:
        u1 r49 = (u1) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L25:
        PublisherCreation r50 = (PublisherCreation) r2;
        JSONObject r51 = r36.f.m;
        if (r51 == null) goto L28;
        Object r52 = r51.opt("recommend_from");
    L29:
        String r53 = String.valueOf(r52);
        JSONObject r54 = r36.f.m;
        if (r54 == null) goto L32;
        Object r55 = r54.opt("template_rec_req_id");
    L33:
        PublisherTrackParams r56 = new PublisherTrackParams("video_detail", r53, String.valueOf(r55));
        r49.getClass();
        u1.a(r50, r56);
        FLogger.a.i("AiGenVideoDetailFragment", "gotoPublisher");
        String r57 = r36.la0();
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AiGenVideoDetailFragment$reportPicClickAddCreation$1(r57, r36, null), 3, null);
        return Unit.INSTANCE;
    L32:
        r55 = null;
        goto L33
    L28:
        r52 = null;
        goto L29
    L18:
        ResultKt.throwOnFailure(r2);
        if (r1 == false) goto L21;
    L34:
        if (r1 == false) goto L36;
        r35 = 3;
    L37:
        if (r1 == false) goto L39;
        r7 = 2;
    L40:
        if (r1 == false) goto L42;
        r39 = 2;
    L43:
        MainCoroutineDispatcher r58 = Dispatchers.getMain();
        AiGenVideoDetailFragment$setCreationPrivacy$2 r59 = new AiGenVideoDetailFragment$setCreationPrivacy$2(r36, r39, null);
        r3.Z$0 = r1;
        r3.I$0 = r35;
        r3.I$1 = r7;
        r3.I$2 = r39;
        r3.label = 2;
        if (BuildersKt.withContext(r58, r59, r3) != r5) goto L46;
        return r5;
    L42:
        r39 = 3;
        goto L43
    L39:
        r7 = 1;
        goto L40
    L36:
        r35 = 2;
        goto L37
    L21:
        if (r36.oa0() == false) goto L34;
        r49 = new u1();
        r3.L$0 = r49;
        r3.label = 1;
        r2 = r36.ma0(r3);
        if (r2 != r5) goto L25;
        return r5;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r3 = new AiGenVideoDetailFragment$setCreationPrivacy$1(r36, r38);
        goto L8
    }

    @Override // com.larus.bmhome.video.fragment.BaseVideoDetailFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = super.onCreateView(r2, r3, r4);
        LarusAiGenVideoDetailFragmentLayoutBinding r6 = (LarusAiGenVideoDetailFragmentLayoutBinding) this.p;
        ConstraintLayout r7 = null;
        if (r6 == null) goto L5;
        CommonDownLoadLayout r0 = r6.d;
    L6:
        this.F = r0;
        if (r6 == null) goto L9;
        ConstraintLayout r1 = r6.e;
    L10:
        this.G = r1;
        if (r6 == null) goto L13;
        CreationOperateContainerView r8 = r6.c;
    L14:
        this.K = r8;
        if (r6 == null) goto L17;
        r7 = r6.b;
    L17:
        this.J = r7;
        this.S = SystemClock.elapsedRealtime();
        return r5;
    L13:
        r8 = null;
        goto L14
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public final void i20(UserCreation r1, long r2, long r4, String r6) {
        zp9.r.a.a(r1, r6);
    }

    public AiGenVideoDetailFragment(nr9.g r10, c4 r11, boolean r12, String r13, boolean r14, boolean r15, boolean r16, boolean r17, Function4<? super nr9.g, ? super String, ? super String, ? super Function1<? super Boolean, Unit>, Unit> r18, Function0<Unit> r19) {
        Intrinsics.checkNotNullParameter(r11, "eventParam");
        Intrinsics.checkNotNullParameter(r18, "toVideoExtendBlk");
        Intrinsics.checkNotNullParameter(r19, "onVideoExtendShownBlk");
        z2 r0 = z2.a;
        super(r10, r11, r0.j1(), r0.Q3(), 16);
        this.x = r12;
        this.y = r13;
        this.z = r14;
        this.A = r15;
        this.B = r16;
        this.C = r17;
        this.D = r18;
        this.E = r19;
        this.L = CoroutineScopeKt.MainScope();
        this.M = 2;
        this.P = "";
        this.S = -1;
        this.T = VideoGenerateSaver.a;
    }
}
