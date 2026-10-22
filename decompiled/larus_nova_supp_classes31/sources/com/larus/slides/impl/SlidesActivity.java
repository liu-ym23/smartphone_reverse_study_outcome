package com.larus.slides.impl;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.l4;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.platform.api.g3;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.service.e2;
import com.larus.platform.service.k2;
import com.larus.platform.service.z2;
import com.larus.slides.impl.select.utils.ChameleonImageUtils;
import com.larus.slides.impl.viewmodel.SlidesDetailViewModel;
import com.larus.slides.sdk.api.ISlidesSdkProxyService;
import com.larus.slides.sdk.api.media.SelectedImageModel;
import com.larus.slides.sdk.api.media.ThumbType;
import com.larus.slides.sdk.api.orientation.FullscreenOption;
import com.larus.slides.sdk.api.orientation.OrientationMode;
import com.larus.slides.sdk.api.orientation.OrientationOption;
import com.larus.slides.sdk.api.orientation.SetFullscreenModel;
import com.larus.slides.sdk.api.orientation.SetOrientationModel;
import com.larus.slides.sdk.api.orientation.SlidesClickFrom;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 p2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001pB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\"\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\n\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u00103\u001a\u00020\u001e2\b\u00104\u001a\u0004\u0018\u000102H\u0016J\"\u00105\u001a\u00020\u001e2\b\u00104\u001a\u0004\u0018\u0001022\u000e\u00106\u001a\n\u0018\u000107j\u0004\u0018\u0001`8H\u0002J\u0012\u0010;\u001a\u00020\u001e2\b\u0010<\u001a\u0004\u0018\u00010:H\u0016J\u001c\u0010=\u001a\u00020\u001e2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u000100H\u0016J\b\u0010A\u001a\u00020\u001eH\u0014J\b\u0010C\u001a\u00020\u001eH\u0002J\u0012\u0010D\u001a\u00020\u001e2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010E\u001a\u00020FH\u0002J\u0012\u0010I\u001a\u00020\u001e2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020\u0014H\u0016J\b\u0010N\u001a\u000200H\u0016J\u0010\u0010P\u001a\u00020\u001e2\u0006\u0010Q\u001a\u000200H\u0016J\b\u0010V\u001a\u00020\u001eH\u0002J\b\u0010W\u001a\u00020\u001eH\u0002J\u0012\u0010X\u001a\u00020\u001e2\b\b\u0002\u0010Y\u001a\u00020HH\u0002J\b\u0010Z\u001a\u00020\u001eH\u0002J\n\u0010[\u001a\u0004\u0018\u00010SH\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010S2\u0006\u0010]\u001a\u00020\nH\u0002J\u0012\u0010^\u001a\u00020\u001e2\b\b\u0002\u0010Y\u001a\u00020HH\u0002J\b\u0010_\u001a\u00020\u0014H\u0002J\b\u0010d\u001a\u00020\u001eH\u0002J\b\u0010e\u001a\u00020\u001eH\u0002J\b\u0010f\u001a\u00020\u0010H\u0002J\b\u0010g\u001a\u00020\u0010H\u0002J\b\u0010h\u001a\u00020\u001eH\u0016J\b\u0010i\u001a\u00020\u001eH\u0016J\b\u0010j\u001a\u00020\u001eH\u0016J\u0006\u0010k\u001a\u00020\u001eJ\b\u0010l\u001a\u000200H\u0016J\n\u0010m\u001a\u0004\u0018\u00010nH\u0016J\b\u0010o\u001a\u00020\u001eH\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\"\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b%\u0010&R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010O\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/larus/slides/impl/SlidesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/larus/slides/sdk/api/media/ISelectMediaBridge;", "Lcom/larus/bmhome/chat/ITraceActivity;", "Lcom/larus/slides/sdk/api/media/ISelectMediaBottomPage;", "Lcom/larus/slides/sdk/api/ISupportChangeScreenConfigPage;", "Lcom/larus/slides/sdk/api/IGetTrackInfo;", "<init>", "()V", "rootView", "Landroid/view/View;", "slidesFragment", "Lcom/larus/slides/impl/SlidesFragment;", "viewModel", "Lcom/larus/slides/impl/viewmodel/SlidesDetailViewModel;", "isLandscapeMode", "", "orientationService", "Lcom/larus/slides/impl/utils/OrientationManager;", "orientationPendingDegree", "", "Ljava/lang/Integer;", "orientationDebounceJob", "Lkotlinx/coroutines/Job;", "photoInsertTouchOutsideView", "getPhotoInsertTouchOutsideView", "()Landroid/view/View;", "photoInsertTouchOutsideView$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "addTargetArtifactType", "lastSensorDegree", "foldableDeviceDetector", "LFoldableDeviceDetector;", "getFoldableDeviceDetector", "()LFoldableDeviceDetector;", "foldableDeviceDetector$delegate", "adapterSensorOrientationChanged", "initEvents", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "getImageCacheRootDir", "", "curAIGenerateImage", "Lcom/larus/slides/sdk/api/media/AIGenerateImage;", "setupAIGenerateImageCallback", "aiGenerateImage", "showAIGenerateImagePage", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "curSelectLocalImage", "Lcom/larus/slides/sdk/api/media/SelectLocalImage;", "setupSelectLocalImageCallback", "selectLocalImage", "onSelectLocalImageCallback", "thumbType", "Lcom/larus/slides/sdk/api/media/ThumbType;", "clickFrom", "onResume", "srcRequestedOrientation", "adapterContentViewToStatusBarInPresentationMode", "setFullscreenMode", "fullscreenModel", "Lcom/larus/slides/sdk/api/orientation/SetFullscreenModel;", "checkFullscreenOptionValid", "Lcom/larus/slides/sdk/api/orientation/FullscreenOption;", "setOrientationMode", "orientationModel", "Lcom/larus/slides/sdk/api/orientation/SetOrientationModel;", "toggleTitleBar", "states", "getOrientationMode", "curSlidesState", "setSlidesState", "state", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "enterLandscapeModeInternal", "exitLandscapeModeInternal", "enterFullscreenMode", "option", "exitFullscreenMode", "getWebViewInternal", "findWebViewRecursive", "parent", "ensureSystemBarsHidden", "currentSensorLandscapeOrientation", "photoInsertFragment", "Landroidx/fragment/app/Fragment;", "repo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "showPhotoPickerFragment", "addPhotoInsertFragment", "hidePhotoPickerFragment", "isPhotoPickerFragmentShow", "hideBottomPage", "onBackPressed", "finish", "onLoadFinishEventReported", "scene", "getTraceParams", "Lorg/json/JSONObject;", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesActivity extends AppCompatActivity implements bx9.c, l4, bx9.b, ax9.e, ax9.b {
    public static final /* synthetic */ int q = 0;
    public View a;
    public SlidesFragmentV2 b;
    public SlidesDetailViewModel c;
    public boolean d;
    public xw9.j e;
    public Integer f;
    public Job g;
    public final Lazy h;
    public Integer i;
    public final Lazy j;
    public bx9.a k;
    public bx9.d l;
    public Integer m;
    public String n;
    public SlidesPhotoInsertFragment o;
    public final ISettingRepoService p;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.SlidesActivity$onActivityResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.SlidesActivity$onActivityResult$1", f = "SlidesActivity.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $localPath;
        final /* synthetic */ ThumbType $thumbType;
        int label;
        final /* synthetic */ SlidesActivity this$0;

        public AnonymousClass1(ThumbType r1, SlidesActivity r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$thumbType = r1;
            this.this$0 = r2;
            this.$localPath = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$thumbType, this.this$0, this.$localPath, r5);
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
            ResultKt.throwOnFailure(r9);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            ChameleonImageUtils r10 = ChameleonImageUtils.a;
            ThumbType r2 = this.$thumbType;
            Long r3 = Boxing.boxLong(20971520);
            final SlidesActivity r4 = this.this$0;
            Function0 r5 = new k(r4);
            final String r6 = this.$localPath;
            Function1 r7 = new l(r4, r6);
            this.label = 1;
            r10.getClass();
            if (ChameleonImageUtils.b(r2, r3, r5, r7, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C1() {
        this.d = true;
        int r0 = getRequestedOrientation();
        xw9.j r1 = this.e;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.b;
    L7:
        if (r3 != 90) goto L10;
        r2 = 8;
    L10:
        FLogger.a.d("SlidesActivity", "enterLandscapeModeInternal, startRequestOrientation=" + r0 + ", endRequestOrientation=" + r2 + ", webView=" + getWebView());
        setRequestedOrientation(r2);
        if (xw9.h.a(this) == true) goto L15;
        View r4 = this.a;
        if (r4 == null) goto L15;
        r4.post(new h(this));
    L15:
        WebView r5 = getWebView();
        if (r5 == null) goto L19;
        JsonObject r6 = new JsonObject();
        r6.addProperty("type", "landscape");
        Unit r7 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r5, "javascript:window.flow.biz.orientation.onSwitch", r6);
        return;
    L19:
        return;
    L5:
        r3 = 0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1() {
        this.d = false;
        int r0 = getRequestedOrientation();
        Integer r1 = this.m;
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        FLogger.a.d("SlidesActivity", "exitLandscapeModeInternal, startRequestOrientation=" + r0 + ", endRequestOrientation=" + r2 + ", webView=" + getWebView());
        setRequestedOrientation(r2);
        WebView r3 = getWebView();
        if (r3 == null) goto L10;
        JsonObject r4 = new JsonObject();
        r4.addProperty("type", "portrait");
        Unit r5 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r3, "javascript:window.flow.biz.orientation.onSwitch", r4);
        return;
    L10:
        return;
    L5:
        r2 = 1;
        goto L6
    }

    public final String scene() {
        return "SLIDES_DETAIL_ACTIVITY";
    }

    public final boolean G1() {
        Fragment r0 = this.o;
        if (r0 != null) goto L5;
        r0 = getSupportFragmentManager().findFragmentByTag("slides_photo_insert_fragment");
    L5:
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.isAdded() == false) goto L22;
        getSupportFragmentManager().beginTransaction().remove(r0).commitAllowingStateLoss();
        View r1 = (View) this.h.getValue();
        if (r1 == null) goto L11;
        e1.o(r1);
    L11:
        this.o = null;
        bx9.d r2 = this.l;
        if (r2 == null) goto L20;
        Function0<Unit> r3 = r2.d;
        if (r3 == null) goto L21;
        r3.invoke();
        return true;
    L21:
        return true;
    L20:
        return true;
    L22:
        return false;
    }

    public final WebView getWebView() {
        View r0 = this.a;
        if (r0 == null) goto L8;
        ViewGroup r1 = (ViewGroup) r0.findViewById(2131367059);
        if (r1 == null) goto L8;
        return F1(r1);
    L8:
        return null;
    }

    public final void onBackPressed() {
        FLogger r0 = FLogger.a;
        r0.d("SlidesActivity", "onBackPressed called slidesState: " + this.n);
        SlidesFragmentV2 r1 = this.b;
        if (r1 == null) goto L35;
        Fragment r2 = ((OfficeBaseFragment) r1).f;
        boolean r3 = false;
        if (r2 == null) goto L13;
        t1a.b r4 = s1a.a.g(r2);
        if (r4 == null) goto L13;
        va8.g0 r5 = r4.o(Reflection.getOrCreateKotlinClass(va8.g0.class));
        if (r5 == null) goto L13;
        boolean r6 = true;
        if (r5.YC() != true) goto L13;
    L15:
        if (r6 == false) goto L24;
        Fragment r7 = ((OfficeBaseFragment) r1).f;
        if (r7 == null) goto L23;
        t1a.b r8 = s1a.a.g(r7);
        if (r8 == null) goto L23;
        va8.g0 r9 = r8.o(Reflection.getOrCreateKotlinClass(va8.g0.class));
        if (r9 == null) goto L23;
        r9.km("aippt_new_detail");
    L23:
        r0.d("SlidesFragment", "onBackPressed expand");
        return;
    L24:
        ISlidesSdkProxyService r10 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r10 == null) goto L29;
        vm9.d r11 = r10.c();
        if (r11 == null) goto L29;
        r3 = r11.onBackPressed(r1.I);
    L29:
        r0.d("SlidesFragment", "onBackPressed final finish backProcessed=" + r3);
        if (r3 == true) goto L37;
        FragmentActivity r12 = r1.getActivity();
        if (r12 == null) goto L38;
        r12.finish();
        return;
    L38:
        return;
    L37:
        return;
    L13:
        r6 = false;
        goto L15
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(SlidesActivity.class.getName()));
    L5:
        super.onDestroy();
        xw9.j r0 = this.e;
        if (r0 == null) goto L9;
        r0.a = new xw9.i();
        r0.c.disable();
        return;
    }

    @Override // ax9.b
    public final JSONObject t9() {
        SlidesFragmentV2 r0 = this.b;
        if ((r0 instanceof ax9.b) == false) goto L6;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.slides.sdk.api.IGetTrackInfo");
        return r0.t9();
    L6:
        return null;
    }

    public SlidesActivity() {
        this.h = LazyKt.lazy(new e(this));
        this.i = 0;
        this.j = LazyKt.lazy(new f(this));
        this.p = RepoDispatcherDelegate.b.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
    L29:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    L31:
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L87;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(SlidesActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L74
        if (r6 != null) goto L39;
    L42:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L74
        monitor-exit(r5);     // Catch: Throwable -> L74
    L71:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L84:
        return;
    L45:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L48;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L71
    L77:
        goto L84
    L48:
        if (isFinishing() == true) goto L51;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L71
        goto L77
    L51:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L54;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L71
        goto L77
    L54:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L57;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L71
        goto L77
    L57:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L60;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L71
        goto L77
    L60:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L62;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L71
        goto L77
    L62:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L71
        if (r1 == null) goto L77;
        r1.addFlags(268435456);     // Catch: Throwable -> L71
        r1.addFlags(2097152);     // Catch: Throwable -> L71
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L71
        startActivity(r1);     // Catch: Throwable -> L68
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L71
        goto L77
    L39:
        if ((r3 - r6.longValue()) >= 800) goto L42;
        monitor-exit(r5);     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;
    L87:
        return;
    L4:
        if (xw9.g.a() == true) goto L31;
        if (this.d == false) goto L31;
        Integer r4 = this.m;     // Catch: Exception -> L29
        if (r4 != null) goto L11;
    L12:
        Integer r7 = this.m;     // Catch: Exception -> L29
        if (r7 != null) goto L16;
    L17:
        Integer r8 = this.m;     // Catch: Exception -> L29
        if (r8 != null) goto L21;
    L22:
        Integer r9 = this.m;     // Catch: Exception -> L29
        if (r9 == null) goto L31;
        if (r9.intValue() != 12) goto L31;
    L27:
        D1();     // Catch: Exception -> L29
        goto L31
    L21:
        if (r8.intValue() == 7) goto L27;
    L16:
        if (r7.intValue() == 9) goto L27;
    L11:
        if (r4.intValue() == 1) goto L27;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ax9.e
    public final String ha() {
        if (getRequestedOrientation() == 9) goto L13;
        if (getRequestedOrientation() == 7) goto L13;
        if (getRequestedOrientation() == 12) goto L13;
        if (getRequestedOrientation() == 1) goto L13;
        return OrientationMode.LANDSCAPE.getMode();
    L13:
        return OrientationMode.PORTRAIT.getMode();
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        k2 r0 = k2.a;
        if (g3.a.d() == true) goto L5;
        G1();
    L5:
        final View r1 = findViewById(R.id.content);
        this.a = r1;
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.d == false) goto L10;
        int r2 = 0;
    L11:
        int r3 = r1.getPaddingStart();
        int r4 = r1.getPaddingTop();
        int r5 = r1.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:,start:" + r3 + ",top:" + r4 + ",end:" + r5 + ",bottom:" + r2);
        r1.setPaddingRelative(r3, r4, r5, r2);
        ViewCompat.setOnApplyWindowInsetsListener(r1, new d(r1, this));
        return;
    L10:
        r2 = com.larus.utils.u.b(this);
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1() {
        Fragment r0 = getSupportFragmentManager().findFragmentByTag("slides_photo_insert_fragment");
        if (r0 != null) goto L5;
    L6:
        SlidesPhotoInsertFragment r1 = new SlidesPhotoInsertFragment();
        r1.setArguments(getIntent().getExtras());
        this.o = r1;
        FragmentTransaction r2 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "slides_photo_insert_fragment", 2131386905) == true) goto L10;
        r2 = r2.add(2131386905, r1, "slides_photo_insert_fragment");
    L10:
        r2.commitAllowingStateLoss();
        View r3 = (View) this.h.getValue();
        if (r3 == null) goto L15;
        e1.x(r3);
        return;
    L15:
        return;
    L5:
        if (r0.isAdded() == false) goto L6;
    }

    @Override // bx9.b
    public final void f() {
        G1();
    }

    public static FullscreenOption A1(SetFullscreenModel r15) {
        FullscreenOption r0 = r15.getOption();
        if (r0 == null) goto L5;
    L8:
        Boolean r16 = r15.getEnable();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r16, r1) == false) goto L20;
        if (r0.getHideStatusBar() != null) goto L14;
        r0.setHideStatusBar(r1);
    L14:
        if (r0.getHideNavigationBar() != null) goto L17;
        r0.setHideNavigationBar(r1);
    L17:
        if (r0.getImmersive() != null) goto L28;
        r0.setImmersive(r1);
    L28:
        return r0;
    L20:
        if (r0.getHideStatusBar() != null) goto L23;
        r0.setHideStatusBar(Boolean.FALSE);
    L23:
        if (r0.getHideNavigationBar() != null) goto L26;
        r0.setHideNavigationBar(Boolean.FALSE);
    L26:
        if (r0.getImmersive() != null) goto L28;
        r0.setImmersive(Boolean.FALSE);
        goto L28
    L5:
        if (Intrinsics.areEqual(r15.getEnable(), Boolean.TRUE) == false) goto L7;
        r0 = new FullscreenOption(null, null, null, null, 15, null);
        goto L8
    L7:
        Boolean r11 = Boolean.FALSE;
        r0 = new FullscreenOption(r11, r11, r11, null, 8, null);
        goto L8
    }

    public static WebView F1(View r4) {
        if ((r4 instanceof WebView) == false) goto L7;
        return (WebView) r4;
    L7:
        if ((r4 instanceof ViewGroup) == true) goto L9;
        return null;
    L9:
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L15;
        View r3 = r5.getChildAt(r2);
        Intrinsics.checkNotNull(r3);
        WebView r6 = F1(r3);
        if (r6 != null) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return r6;
    L15:
        return null;
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(FullscreenOption r9) {
        Ref.IntRef r0 = new Ref.IntRef();
        View r1 = y1(getWindow());
        Boolean r2 = r9.getHideStatusBar();
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L6;
        r0.element = 1028;
    L6:
        if (Intrinsics.areEqual(r9.getHideNavigationBar(), r3) == false) goto L9;
        r0.element = (r0.element | 2) | 512;
    L9:
        if (Intrinsics.areEqual(r9.getImmersive(), r3) == false) goto L11;
        r0.element |= 4096;
    L11:
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        r1.setSystemUiVisibility(r0.element);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SlidesActivity$ensureSystemBarsHidden$1(r1, r0, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ax9.e
    public final void K60(SetOrientationModel r6) {
        if (r6 == null) goto L5;
        r6.setSrcOrientation(r6.getOrientation());
    L5:
        if (xw9.g.a() == false) goto L8;
        FLogger.a.w("SlidesActivity", "setOrientationMode: setting disable slides presentation mode");
        return;
    L8:
        if (r6 == null) goto L11;
        String r0 = r6.getOrientation();
        if (r0 == null) goto L11;
    L12:
        OrientationMode r1 = OrientationMode.LANDSCAPE;
        if (Intrinsics.areEqual(r0, r1.getMode()) == false) goto L23;
        Activity r2 = AppHost.a.a().getCurrentActivity();
        if ((r2 instanceof zp9.t) == false) goto L18;
        r2.finish();
    L18:
        if (G1() == false) goto L22;
        View r3 = this.a;
        if (r3 == null) goto L49;
        r3.post(new c(this));
    L49:
        SlidesFragmentV2 r4 = this.b;
        if ((r4 instanceof ax9.e) == false) goto L54;
        if (r4 == null) goto L55;
        r4.K60(r6);
        return;
    L55:
        return;
    L54:
        return;
    L22:
        C1();
        goto L49
    L23:
        xw9.j r5 = this.e;
        String r7 = null;
        if (r5 == null) goto L26;
        Integer r8 = Integer.valueOf(r5.b);
    L28:
        if (xw9.h.a(this) == true) goto L48;
        if (r6 == null) goto L33;
        OrientationOption r9 = r6.getOption();
        if (r9 == null) goto L33;
        String r10 = r9.getClickFrom();
    L35:
        if (Intrinsics.areEqual(r10, SlidesClickFrom.PRESENTATION.getClickFrom()) == false) goto L48;
        if (r8 != null) goto L39;
    L40:
        if (r8 == null) goto L48;
        if (r8.intValue() != 270) goto L48;
    L44:
        String r11 = r1.getMode();
        OrientationOption r12 = r6.getOption();
        if (r12 == null) goto L47;
        r7 = r12.getClickFrom();
    L47:
        SetOrientationModel r13 = new SetOrientationModel(r11, new OrientationOption(r7), r6.getSrcOrientation());
        C1();
        r6 = r13;
        goto L49
    L39:
        if (r8.intValue() == 90) goto L44;
    L33:
        r10 = null;
    L48:
        D1();
        goto L49
    L26:
        r8 = null;
    L11:
        r0 = OrientationMode.PORTRAIT.getMode();
        goto L12
    }

    @Override // ax9.e
    public final void d4(int r3) {
        if (xw9.g.a() == false) goto L6;
        FLogger.a.w("SlidesActivity", "toggleTitleBar: setting disable slides presentation mode");
        return;
    L6:
        boolean r4 = this.b instanceof ax9.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bx9.c
    public final void i0(bx9.a r58) {
        this.k = r58;
        com.larus.bmhome.actionbar.model.z0 r3 = (com.larus.bmhome.actionbar.model.z0) xw9.e.e.getValue();
        if (r3 == null) goto L50;
        IUgcAIGCService.Companion r4 = IUgcAIGCService.a;
        ResourceExt[] r2 = new ResourceExt[1];
        SelectedImageModel r6 = r58.a;
        if (r6 == null) goto L8;
        String r7 = r6.getUrl();
        if (r7 == null) goto L8;
    L9:
        int r1 = 0;
        r2[0] = new ResourceExt(null, r7, 1);
        List r39 = CollectionsKt.mutableListOf(r2);
        String r5 = getIntent().getStringExtra("conversation_id");
        if (r5 != null) goto L12;
        String r13 = "";
    L13:
        String r8 = getIntent().getStringExtra("bot_id");
        if (r8 != null) goto L16;
        String r14 = "";
    L17:
        ChatParam r53 = new ChatParam(r13, r14, "", "", "default", 224);
        String r9 = getIntent().getStringExtra("presentation_id");
        if (r9 != null) goto L20;
        String r20 = "";
    L21:
        String r10 = getIntent().getStringExtra("resource_id");
        if (r10 != null) goto L24;
        String r21 = "";
    L25:
        Integer r22 = Integer.valueOf(getIntent().getIntExtra("resource_type", -1));
        String r11 = getIntent().getStringExtra("artifact_meta_id");
        if (r11 != null) goto L28;
        String r23 = "";
    L29:
        Integer r24 = Integer.valueOf(getIntent().getIntExtra("artifact_type", -1));
        String r12 = getIntent().getStringExtra("aippt_task_id");
        if (r12 != null) goto L32;
        String r25 = "";
    L33:
        String r15 = getIntent().getStringExtra("message_id");
        if (r15 != null) goto L36;
        String r26 = "";
    L37:
        lr9.a r54 = new lr9.a(r20, r21, r22, r23, r24, r25, r26);
        StringBuilder r16 = new StringBuilder();
        SelectedImageModel r17 = r58.a;
        if (r17 == null) goto L42;
        Float r18 = r17.getWidth();
        if (r18 == null) goto L42;
        int r19 = (int) r18.floatValue();
    L43:
        r16.append(r19);
        r16.append(':');
        SelectedImageModel r0 = r58.a;
        if (r0 == null) goto L48;
        Float r27 = r0.getHeight();
        if (r27 == null) goto L48;
        r1 = (int) r27.floatValue();
    L48:
        r16.append(r1);
        String r40 = r16.toString();
        Bundle r28 = new Bundle();
        r28.putInt("max_select_image_count", 6);
        r4.W(new ny9.b(true, this, r3, r53, false, false, null, null, null, null, r39, null, null, null, null, null, null, null, null, false, false, null, null, r28, false, null, null, null, false, null, false, null, null, null, null, null, null, null, r54, r40, "slides", null, null, null, null, null, null, null, null, false, -8389648, 261695));
        return;
    L42:
        r19 = 0;
        goto L43
    L36:
        r26 = r15;
        goto L37
    L32:
        r25 = r12;
        goto L33
    L28:
        r23 = r11;
        goto L29
    L24:
        r21 = r10;
        goto L25
    L20:
        r20 = r9;
        goto L21
    L16:
        r14 = r8;
        goto L17
    L12:
        r13 = r5;
    L8:
        r7 = "";
        goto L9
    }

    @Override // ax9.e
    public final void iT(String r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (xw9.g.a() == false) goto L6;
        FLogger.a.w("SlidesActivity", "setSlidesState: setting disable slides presentation mode");
        return;
    L6:
        this.n = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ax9.e
    public final void jp(SetFullscreenModel r12) {
        if (xw9.g.a() == false) goto L6;
        FLogger.a.w("SlidesActivity", "setFullscreenMode: setting disable slides presentation mode");
        return;
    L6:
        if (r12 == null) goto L8;
        boolean r0 = Intrinsics.areEqual(r12.getEnable(), Boolean.TRUE);
    L9:
        if (r0 == false) goto L11;
        B1(A1(r12));
    L37:
        SlidesFragmentV2 r1 = this.b;
        if ((r1 instanceof ax9.e) == false) goto L42;
        if (r1 == null) goto L43;
        r1.jp(r12);
        return;
    L43:
        return;
    L42:
        return;
    L11:
        xw9.j r2 = this.e;
        String r3 = null;
        if (r2 == null) goto L14;
        Integer r4 = Integer.valueOf(r2.b);
    L16:
        if (xw9.h.a(this) == true) goto L36;
        if (r12 == null) goto L21;
        FullscreenOption r5 = r12.getOption();
        if (r5 == null) goto L21;
        String r6 = r5.getClickFrom();
    L23:
        if (Intrinsics.areEqual(r6, SlidesClickFrom.PRESENTATION.getClickFrom()) == false) goto L36;
        if (r4 != null) goto L27;
    L28:
        if (r4 == null) goto L36;
        if (r4.intValue() != 270) goto L36;
    L32:
        Boolean r7 = Boolean.TRUE;
        FullscreenOption r13 = r12.getOption();
        if (r13 == null) goto L35;
        r3 = r13.getClickFrom();
    L35:
        SetFullscreenModel r8 = new SetFullscreenModel(r7, new FullscreenOption(null, null, null, r3, 7, null));
        B1(A1(r8));
        r12 = r8;
        goto L37
    L27:
        if (r4.intValue() == 90) goto L32;
    L21:
        r6 = null;
    L36:
        View r9 = y1(getWindow());
        WindowInsetsControllerCompat r10 = WindowCompat.getInsetsController(getWindow(), r9);
        r10.show(WindowInsetsCompat.Type.systemBars());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SlidesActivity$exitFullscreenMode$1(r9, r10, null), 3, null);
        goto L37
    L14:
        r4 = null;
        goto L16
    L8:
        r0 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bx9.c
    public final void m1(bx9.d r34) {
        this.l = r34;
        if (this.p.k0() == true) goto L5;
        this.p.F();
        k2 r0 = k2.a;
        g3.a.a(null, this, false, null, false, new j(this), 29);
    L48:
        Intent r1 = getIntent();     // Catch: Exception -> L45
        if (r1 == null) goto L13;
        String r2 = r1.getStringExtra("presentation_id");     // Catch: Exception -> L45
        if (r2 == null) goto L13;
        String r23 = r2;
    L14:
        Intent r3 = getIntent();     // Catch: Exception -> L45
        if (r3 == null) goto L20;
        String r4 = r3.getStringExtra("resource_id");     // Catch: Exception -> L45
        if (r4 == null) goto L20;
        String r24 = r4;
    L21:
        Intent r5 = getIntent();     // Catch: Exception -> L45
        if (r5 == null) goto L24;
        Integer r25 = Integer.valueOf(r5.getIntExtra("resource_type", -1));     // Catch: Exception -> L45
    L25:
        Intent r6 = getIntent();     // Catch: Exception -> L45
        if (r6 == null) goto L31;
        String r7 = r6.getStringExtra("artifact_meta_id");     // Catch: Exception -> L45
        if (r7 == null) goto L31;
        String r26 = r7;
    L32:
        Intent r8 = getIntent();     // Catch: Exception -> L45
        if (r8 == null) goto L35;
        Integer r27 = Integer.valueOf(r8.getIntExtra("artifact_type", -1));     // Catch: Exception -> L45
    L36:
        Intent r9 = getIntent();     // Catch: Exception -> L45
        if (r9 == null) goto L42;
        String r10 = r9.getStringExtra("aippt_task_id");     // Catch: Exception -> L45
        if (r10 == null) goto L42;
        String r28 = r10;
    L43:
        tx9.c0.H(null, "aippt_tool_bar", null, null, null, "aippt_new_detail", null, null, null, null, null, null, null, 0, r23, r24, r25, r26, r27, r28, "aippt_new", null, null, 31473629);     // Catch: Exception -> L45
        return;
    L42:
        r28 = "";
        goto L43
    L35:
        r27 = null;
    L31:
        r26 = "";
        goto L32
    L24:
        r25 = null;
    L20:
        r24 = "";
    L13:
        r23 = "";
    L45:
        e = move-exception;
        FLogger.a.e("SlidesActivity", "call mobClickUploadEntrance error", e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        return;
    L5:
        z1();
        goto L48
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r11) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        com.larus.office.base.utils.c.a(r11, "SlidesActivity");
        v19.f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r11);
        FLogger r12 = FLogger.a;
        r12.i("SlidesActivity", "SlidesActivity.onCreate");
        this.c = (SlidesDetailViewModel) new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(SlidesDetailViewModel.class);
        boolean r3 = false;
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L13;
        boolean r1 = true;
    L14:
        v19.h.a = r1;
        com.larus.utils.u.e(this, true, r1);
        com.larus.utils.u.d(this);
        Window r2 = getWindow();
        if (r2 == null) goto L18;
        r2.setBackgroundDrawableResource(2131102529);
    L18:
        if (xw9.g.a() == false) goto L20;
        r12.w("SlidesActivity", "adapterContentViewToStatusBarInPresentationMode: setting disable slides presentation mode");
    L26:
        setContentView(2131561798);
        Intent r4 = getIntent();
        if (r4 == null) goto L29;
        Integer r5 = Integer.valueOf(r4.getIntExtra("artifact_type", -1));
    L30:
        if (r5 != null) goto L33;
    L37:
        SlidesFragmentV2 r6 = new SlidesFragmentV2();
        this.b = r6;
        Bundle r7 = getIntent().getExtras();
        if (r7 == null) goto L46;
        SlidesDetailViewModel r8 = this.c;
        if (r8 != null) goto L42;
    L44:
        boolean r9 = false;
    L45:
        r7.putBoolean("has_report_finish_event", r9);
        goto L46
    L42:
        if (r8.getHasReportLaunchResult() != true) goto L44;
        r9 = true;
    L46:
        r6.setArguments(r7);
        FragmentTransaction r10 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "aippt_new_detail", 2131373275) == true) goto L50;
        r10 = r10.replace(2131373275, r6, "aippt_new_detail");
    L50:
        r10.commitAllowingStateLoss();
        View r13 = (View) this.h.getValue();
        if (r13 == null) goto L53;
        e1.d(r13, new g(this));
    L53:
        G1();
        if (xw9.g.a() == false) goto L56;
        r12.w("SlidesActivity", "adapterSensorOrientationChanged: setting disable slides presentation mode");
        return;
    L56:
        FoldableDeviceDetector r14 = (FoldableDeviceDetector) this.j.getValue();
        r14.getClass();
        Point r15 = new Point();
        Object r16 = r14.a.getSystemService("window");
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r17 = (WindowManager) r16;
        if (Build.VERSION.SDK_INT < 30) goto L59;
        Rect r18 = r17.getCurrentWindowMetrics().getBounds();
        r15.x = r18.width();
        r15.y = r18.height();
    L62:
        int r19 = r15.x;
        int r20 = r15.y;
        int r21 = Math.max(r19, r20);
        if ((r21 / Math.min(r19, r20)) >= 1.2f) goto L65;
        boolean r22 = true;
    L66:
        List r23 = FoldableDeviceDetector.c;
        if ((r23 instanceof Collection) == true) goto L69;
    L71:
        Iterator r24 = r23.iterator();
    L73:
        if (r24.hasNext() == false) goto L83;
        Pair r25 = (Pair) r24.next();
        int r26 = ((Number) r25.component1()).intValue();
        int r27 = ((Number) r25.component2()).intValue();
        if (r19 != r26) goto L77;
        if (r20 != r27) goto L77;
    L79:
        boolean r28 = true;
    L81:
        if (r28 == false) goto L73;
        boolean r110 = true;
    L85:
        if (r21 <= 2000) goto L87;
        boolean r29 = true;
    L88:
        if (r29 == false) goto L91;
        if (r22 == false) goto L91;
        boolean r30 = true;
    L92:
        if (r22 == true) goto L95;
        if (r110 == true) goto L95;
        if (r30 == true) goto L95;
    L96:
        if (r3 == false) goto L99;
        FLogger.a.w("SlidesActivity", "adapterSensorOrientationChanged: foldableDeviceDetector hasSquareishScreen");
        return;
    L99:
        if (e2.a.isPad() == false) goto L101;
        FLogger.a.w("SlidesActivity", "adapterSensorOrientationChanged: setting disable slides presentation mode");
        this.e = new xw9.j(this, new com.larus.slides.impl.a(this));
        return;
    L101:
        this.m = Integer.valueOf(getRequestedOrientation());
        this.e = new xw9.j(this, new b(this));
        return;
    L95:
        r3 = true;
    L91:
        r30 = false;
        goto L92
    L87:
        r29 = false;
    L77:
        if (r19 != r27) goto L80;
        if (r20 == r26) goto L79;
    L80:
        r28 = false;
    L83:
        r110 = false;
        goto L85
    L69:
        if (r23.isEmpty() == false) goto L71;
    L65:
        r22 = false;
        goto L66
    L59:
        Display r111 = r17.getDefaultDisplay();
        if (r111 == null) goto L62;
        r111.getRealSize(r15);
        goto L62
    L33:
        if (r5.intValue() != (-1)) goto L37;
        Intent r31 = getIntent();
        if (r31 == null) goto L37;
        r31.putExtra("artifact_type", 9);
        goto L37
    L29:
        r5 = null;
        goto L30
    L20:
        int r32 = Build.VERSION.SDK_INT;
        if (r32 < 28) goto L24;
        WindowManager.LayoutParams r33 = getWindow().getAttributes();
        r33.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(r33);
    L24:
        if (r32 < 29) goto L26;
        getWindow().setStatusBarContrastEnforced(false);
        goto L26
    L13:
        r1 = false;
        goto L14
    }

    @Override // bx9.c
    public final void J0(ThumbType r8, String r9) {
        Integer r0 = r8.getWidth();
        int r1 = 0;
        if (r0 != null) goto L5;
    L16:
        Integer r2 = r8.getHeight();
        if (r2 != null) goto L19;
    L29:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SlidesActivity$onSelectLocalImageCallback$5(r8, this, r9, null), 3, null);
        return;
    L19:
        if (r2.intValue() > 0) goto L28;
        bx9.d r3 = this.l;
        if (r3 == null) goto L27;
        SelectedImageModel r4 = r3.a;
        if (r4 == null) goto L27;
        Float r5 = r4.getHeight();
        if (r5 == null) goto L27;
        r1 = (int) r5.floatValue();
    L27:
        r8.setHeight(Integer.valueOf(r1));
    L28:
        r2.intValue();
        goto L29
    L5:
        if (r0.intValue() > 0) goto L15;
        bx9.d r6 = this.l;
        if (r6 == null) goto L13;
        SelectedImageModel r7 = r6.a;
        if (r7 == null) goto L13;
        Float r10 = r7.getWidth();
        if (r10 == null) goto L13;
        int r11 = Integer.valueOf((int) r10.floatValue());
    L14:
        r8.setWidth(r11);
    L13:
        r11 = 0;
    L15:
        r0.intValue();
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityResult(int r32, int r33, Intent r34) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r32, r33, r34);
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("Router onActivityResult: requestCode -> ");
        r5.append(r32);
        r5.append(" , resultCode -> ");
        r5.append(r33);
        r5.append(" , data: ");
        String r6 = null;
        if (r34 == null) goto L5;
        Bundle r7 = r34.getExtras();
    L6:
        r5.append(r7);
        r4.i("SlidesActivity", r5.toString());
        int r8 = 0;
        if (r33 != 40002) goto L80;
        String r15 = UUID.randomUUID().toString();
        long r1 = 0;
        if (r34 == null) goto L12;
        r1 = r34.getLongExtra("image_file_size", 0);
    L12:
        if (r34 == null) goto L17;
        String r9 = r34.getStringExtra("image_local_path");
        if (r9 == null) goto L17;
        String r14 = r9;
    L18:
        if (r34 == null) goto L23;
        String r10 = r34.getStringExtra("image_file_name");
        if (r10 == null) goto L23;
        String r11 = r10;
    L24:
        if (r34 == null) goto L26;
        int r12 = r34.getIntExtra("image_width", 0);
    L27:
        if (r34 == null) goto L29;
        int r3 = r34.getIntExtra("image_height", 0);
    L30:
        if (r3 > 0) goto L40;
        bx9.a r13 = this.k;
        if (r13 == null) goto L39;
        SelectedImageModel r16 = r13.a;
        if (r16 == null) goto L39;
        Float r17 = r16.getHeight();
        if (r17 == null) goto L39;
        r3 = (int) r17.floatValue();
    L39:
        r3 = 0;
    L40:
        if (r12 <= 0) goto L42;
        r8 = r12;
    L49:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(new ThumbType("image/jpeg", r11, null, Long.valueOf(r1), Integer.valueOf(r3), Integer.valueOf(r8), "docsource://".concat(r14), r15, 4, null), this, r14, null), 3, null);
        bx9.a r2 = this.k;
        if (r2 == null) goto L54;
        Function0<Unit> r18 = r2.d;
        if (r18 == null) goto L54;
        r18.invoke();
    L54:
        Intent r19 = getIntent();
        if (r19 == null) goto L57;
        String r21 = r19.getStringExtra("presentation_id");
    L58:
        Intent r20 = getIntent();
        if (r20 == null) goto L61;
        String r22 = r20.getStringExtra("resource_id");
    L62:
        Intent r23 = getIntent();
        if (r23 == null) goto L65;
        Integer r24 = Integer.valueOf(r23.getIntExtra("resource_type", -1));
    L66:
        Intent r25 = getIntent();
        if (r25 == null) goto L69;
        String r26 = r25.getStringExtra("artifact_meta_id");
    L70:
        Intent r27 = getIntent();
        if (r27 == null) goto L73;
        Integer r28 = Integer.valueOf(r27.getIntExtra("artifact_type", -1));
    L74:
        Intent r29 = getIntent();
        if (r29 == null) goto L77;
        r6 = r29.getStringExtra("aippt_task_id");
    L77:
        tx9.c0.H(null, "aippt_generate_picture_confirm", null, null, null, "aippt_new_detail", null, null, null, null, null, null, null, 0, r21, r22, r24, r26, r28, r6, "aippt_new", null, null, 31473629);
        return;
    L73:
        r28 = null;
        goto L74
    L69:
        r26 = null;
        goto L70
    L65:
        r24 = null;
        goto L66
    L61:
        r22 = null;
        goto L62
    L57:
        r21 = null;
        goto L58
    L42:
        bx9.a r30 = this.k;
        if (r30 == null) goto L49;
        SelectedImageModel r31 = r30.a;
        if (r31 == null) goto L49;
        Float r35 = r31.getHeight();
        if (r35 == null) goto L49;
        r8 = (int) r35.floatValue();
        goto L49
    L29:
        r3 = 0;
        goto L30
    L26:
        r12 = 0;
    L23:
        r11 = "";
    L17:
        r14 = "";
        goto L18
    L80:
        if (r33 != 0) goto L93;
        if (r34 != null) goto L83;
    L85:
        boolean r36 = false;
    L86:
        if (r36 == false) goto L93;
        bx9.a r37 = this.k;
        if (r37 == null) goto L115;
        Function0<Unit> r38 = r37.d;
        if (r38 == null) goto L116;
        r38.invoke();
        return;
    L116:
        return;
    L115:
        return;
    L83:
        if (r34.getBooleanExtra("ai_creation", false) != true) goto L85;
        r36 = true;
    L93:
        if (r34 == null) goto L117;
        Bundle r39 = r34.getExtras();
        if (r39 == null) goto L118;
        Fragment r40 = getSupportFragmentManager().findFragmentByTag("aippt_new_detail");
        if (r40 == null) goto L101;
        FragmentManager r41 = r40.getChildFragmentManager();
        if (r41 == null) goto L101;
        String r42 = r41.findFragmentByTag("slides_detail_chat");
    L102:
        if (r42 != null) goto L104;
    L106:
        if (r8 != 0) goto L108;
        return;
    L108:
        if (r42.isDetached() == false) goto L110;
        return;
    L110:
        if ((r42 instanceof xe8.a) == false) goto L112;
        r6 = (xe8.a) r42;
    L112:
        if (r6 == null) goto L121;
        r6.Lc(r39, r32, r33);
        return;
    L121:
        return;
    L104:
        if (r42.isAdded() != true) goto L106;
        r8 = 1;
    L101:
        r42 = null;
        goto L102
    L118:
        return;
    L117:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
