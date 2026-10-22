package com.larus.camera.impl.starter;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.viewmodel.m0;
import com.larus.camera.impl.ui.viewmodel.t;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0001H\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u0010\u0016J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0005H\u0002J(\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010*\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020\rH\u0002J \u0010-\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J*\u00100\u001a\u00020\r2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0082@¢\u0006\u0002\u00107J\u0012\u00108\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\tH\u0016J\b\u0010<\u001a\u00020\rH\u0002J\u0010\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020?H\u0002J\u0012\u0010@\u001a\u00020\r2\b\u0010A\u001a\u0004\u0018\u00010\u001fH\u0002R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/camera/impl/starter/CameraStarter;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "notifyAllStarterViewModels", "", "outputContext", "Lcom/larus/camera/api/params/CameraOutputContext;", "notifyAllStarterViewModelsForseti", "", "fm", "Landroidx/fragment/app/FragmentManager;", "notifyResultOwnerViewModel", "", "notifyAllStarterViewModelsSendCompleted", "notifySendCompletedInFragment", "fragment", "notifyResultViewModels", "notifyViewModelInFragment", "getExistingViewModel", "T", "Landroidx/lifecycle/ViewModel;", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModel;", "ability", "Lcom/larus/camera/impl/ui/viewmodel/CameraViewModelAbility;", "getAbility", "()Lcom/larus/camera/impl/ui/viewmodel/CameraViewModelAbility;", "ability$delegate", "Lkotlin/Lazy;", "cameraLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "maybeOpenMainBotOnResult", "notifiedCount", "forsetiFragment", "Ljava/lang/ref/WeakReference;", "resultOwnerFragment", "startCamera", "activity", "Landroidx/fragment/app/FragmentActivity;", "forsetiFragmentNode", "resultOwnerFragmentNode", "resultCamera", "supportMark", "supportCrop", "resultCameraWithParam", "inputParam", "Lcom/larus/camera/api/params/InputParam;", "eduImageIdentifyCheck", "context", "Landroid/content/Context;", "imagePath", "", "albumUri", "Landroid/net/Uri;", "(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "shouldHandleClosePage", "handleClosePageIfNeeded", "result", "Landroidx/activity/result/ActivityResult;", "isVideoGenerateResult", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraStarter extends Fragment {
    public static final Companion h = null;
    public final Lazy d;
    public ActivityResultLauncher<Intent> e;
    public WeakReference<Fragment> f;
    public WeakReference<Fragment> g;

    public static final class Companion {
        public Companion() {
        }

        public static void a(final FragmentActivity r3, final Function0 r4) {
            if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) > 0) goto L5;
            FLogger.a.i("CameraStarter", "open on resume wait observer");
            r3.getLifecycle().addObserver(new CameraStarter$Companion$openOnResume$1(r3, r4));
            return;
        L5:
            r4.invoke();
        }

        public static boolean b(final FragmentActivity r4, final InputParam r5, final CameraOutputContext r6) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            Intrinsics.checkNotNullParameter(r5, "inputParam");
            Intrinsics.checkNotNullParameter(r6, "outputContext");
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
            FLogger r3 = FLogger.a;     // Catch: Throwable -> L9
            StringBuilder r7 = new StringBuilder("resultWithParam: inputParam=");     // Catch: Throwable -> L9
            r7.append(r5);     // Catch: Throwable -> L9
            r7.append(", outputCount=");     // Catch: Throwable -> L9
            List<OutputParam> r1 = r6.getOutputParamList();     // Catch: Throwable -> L9
            if (r1 == null) goto L6;
            Integer r8 = Integer.valueOf(r1.size());     // Catch: Throwable -> L9
        L7:
            r7.append(r8);     // Catch: Throwable -> L9
            r3.i("CameraStarter", r7.toString());     // Catch: Throwable -> L9
            t r9 = t.a;     // Catch: Throwable -> L9
            t.h();     // Catch: Throwable -> L9
            a(r4, new k(r4, r5, r6));     // Catch: Throwable -> L9
            Object r10 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L9
        L11:
            Throwable r11 = Result.exceptionOrNull-impl(r10);
            if (r11 == null) goto L16;
            FLogger.a.e("CameraStarter", "resultWithParam failed:" + r11);
            r10 = Boolean.FALSE;
        L16:
            return ((Boolean) r10).booleanValue();
        L6:
            r8 = null;
        L9:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }
    }

    static {
        h = new Companion();
    }

    public CameraStarter() {
        this.d = LazyKt.lazy(new e(this));
        this.e = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new f(this));
    }

    public final void onDestroy() {
        super.onDestroy();
        this.e = null;
        this.f = null;
        this.g = null;
        ((m0) this.d.getValue()).t0();
        if (ObricChatSPIServiceDelegate.b.d() == false) goto L6;
        t r0 = t.a;
        t.h();
        return;
    }

    public static int U90(Fragment r5) {
        ViewModel r0 = new ViewModelProvider(r5, new CameraStarter$getExistingViewModel$viewModelProvider$1()).get(StarterViewModel.class);     // Catch: Exception -> L5 IllegalStateException -> L7
    L9:
        StarterViewModel r1 = (StarterViewModel) r0;
        if (r1 == null) goto L12;
        r1.publishSendCompleted$impl_mainlandRelease();
        int r2 = 1;
    L13:
        Iterator r6 = r5.getChildFragmentManager().getFragments().iterator();
    L15:
        if (r6.hasNext() == false) goto L17;
        Fragment r3 = (Fragment) r6.next();
        Intrinsics.checkNotNull(r3);
        r2 = r2 + U90(r3);
        goto L15
    L17:
        return r2;
    L12:
        r2 = 0;
        goto L13
    L7:
        FLogger.a.d("CameraStarter", "ViewModel StarterViewModel not found in fragment ".concat(r5.getClass().getSimpleName()));
    L8:
        r0 = null;
    L5:
        e = move-exception;
        FLogger.a.d("CameraStarter", "Failed to get existing ViewModel: " + e.getMessage());
        goto L8
    }

    public final int S90(CameraOutputContext r6) {
        FragmentActivity r1 = getActivity();
        int r2 = 0;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r1.isFinishing() == false) goto L8;
    L18:
        return r2;
    L8:
        if (r1.isDestroyed() == true) goto L18;
        Iterator r3 = r1.getSupportFragmentManager().getFragments().iterator();     // Catch: Exception -> L16
    L12:
        if (r3.hasNext() == false) goto L14;
        Fragment r4 = (Fragment) r3.next();     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L16
        r2 = r2 + V90(r4, r6);     // Catch: Exception -> L16
        goto L12
    L14:
        FLogger.a.i("CameraStarter", "Notified " + r2 + " StarterViewModel instances");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        FLogger.a.e("CameraStarter", "notifyAllStarterViewModels failed:" + e);
        com.larus.platform.service.g.a.ensureNotReachHere(e, "notifyAllStarterViewModels failed");
        goto L18
    }

    public final int T90(CameraOutputContext r6) {
        WeakReference<Fragment> r0 = this.g;
        if (r0 == null) goto L5;
        Fragment r1 = r0.get();
    L6:
        if (r1 == null) goto L12;
        int r2 = V90(r1, r6);
        FLogger r3 = FLogger.a;
        r3.i("CameraStarter", "Notified " + r2 + " owner StarterViewModel instances: " + r1.getClass().getSimpleName());
        if (r2 <= 0) goto L10;
        return r2;
    L10:
        r3.e("CameraStarter", "result owner StarterViewModel missing, fallback notify all");
    L12:
        return S90(r6);
    L5:
        r1 = null;
        goto L6
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        ((m0) this.d.getValue()).v(new h(), new i(), new j(), null);
    }

    public static int V90(Fragment r8, CameraOutputContext r9) {
        int r5 = 0;
        ViewModel r3 = new ViewModelProvider(r8, new CameraStarter$getExistingViewModel$viewModelProvider$1()).get(StarterViewModel.class);     // Catch: Exception -> L5 IllegalStateException -> L7
    L9:
        StarterViewModel r4 = (StarterViewModel) r3;     // Catch: IllegalStateException -> L18
        if (r4 == null) goto L12;
        r4.getResultLiveEvent().setValue(r9);     // Catch: IllegalStateException -> L18
        r5 = 1;
        FLogger.a.i("CameraStarter", "Notified existing StarterViewModel in fragment: ".concat(r8.getClass().getSimpleName()));     // Catch: IllegalStateException -> L18
    L13:
        Iterator r1 = r8.getChildFragmentManager().getFragments().iterator();     // Catch: IllegalStateException -> L18
    L14:
        if (r1.hasNext() == false) goto L20;
        Fragment r2 = (Fragment) r1.next();     // Catch: IllegalStateException -> L18
        Intrinsics.checkNotNull(r2);     // Catch: IllegalStateException -> L18
        r5 = r5 + V90(r2, r9);
    L20:
        return r5;
    L12:
        FLogger.a.d("CameraStarter", "No existing StarterViewModel in fragment ".concat(r8.getClass().getSimpleName()));     // Catch: IllegalStateException -> L18
        goto L13
    L18:
        e = move-exception;
        FLogger.a.e("CameraStarter", "Fragment state error, skip viewModel notify: ".concat(r8.getClass().getSimpleName()), e);
        com.larus.platform.service.g.a.ensureNotReachHere(e, "notifyViewModelInFragment error");
    L7:
        FLogger.a.d("CameraStarter", "ViewModel StarterViewModel not found in fragment ".concat(r8.getClass().getSimpleName()));     // Catch: IllegalStateException -> L18
    L8:
        r3 = null;
    L5:
        e = move-exception;
        FLogger.a.d("CameraStarter", "Failed to get existing ViewModel: " + e.getMessage());     // Catch: IllegalStateException -> L18
        goto L8
    }
}
