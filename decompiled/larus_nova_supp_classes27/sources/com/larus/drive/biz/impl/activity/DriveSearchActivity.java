package com.larus.drive.biz.impl.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.databinding.LarusPageDriveSearchBinding;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.biz.impl.utils.f;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.sdk.api.DrivePickerScene;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.larus.platform.exp.i;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import t19.s;
import w79.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/drive/biz/impl/activity/DriveSearchActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusPageDriveSearchBinding;", "pickerCallback", "com/larus/drive/biz/impl/activity/DriveSearchActivity$pickerCallback$2$1", "getPickerCallback", "()Lcom/larus/drive/biz/impl/activity/DriveSearchActivity$pickerCallback$2$1;", "pickerCallback$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupActivityTransition", "getItemEnable", "", "itemType", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSearchActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int i = 0;
    public LarusPageDriveSearchBinding g;
    public final Lazy h;

    public static final class a {
        public static void a(Context r1) {
            if (r1 != null) goto L4;
            return;
        L4:
            SmartRouter.buildRoute(r1, "//flow/drive_search").d();
        }
    }

    public static final class b implements c {
        public final /* synthetic */ DriveSearchActivity a;

        @Override // w79.c
        public final void onSelectMoreClick() {
        }

        @Override // w79.c
        public final void onCanceled() {
            this.a.finish();
        }

        public b(DriveSearchActivity r1) {
            this.a = r1;
        }

        @Override // w79.c
        public final void a(DriveFileItem r2) {
            Intrinsics.checkNotNullParameter(r2, "file");
        }

        @Override // w79.c
        public final void b(DriveFileItem r2) {
            Intrinsics.checkNotNullParameter(r2, "file");
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // w79.c
        public final boolean c(DriveFileItem r13) {
            Intrinsics.checkNotNullParameter(r13, "file");
            FLogger r0 = FLogger.a;
            r0.i("DriveSearchActivity", "File clicked: " + r13.a + " (token: " + r13.b + ')');
            if (DriveSearchActivity.N1(this.a, r13.d) == true) goto L6;
            r0.i("DriveSearchActivity", "This type: " + r13.d + " is not support search");
            return true;
        L6:
            if (r13.j != DriveFileType.FOLDER) goto L9;
            int r1 = DriveFolderActivity.g;
            DriveFolderActivity.a.a(this.a, r13.b, r13.c, r13.a, null);
            return true;
        L9:
            if (i.a.a() == true) goto L11;
            DriveSdkService r2 = DriveSdkService.a;
            FlowCommonAppCompatActivity r6 = this.a;
            LifecycleCoroutineScope r8 = LifecycleOwnerKt.getLifecycleScope(r6);
            PreviewFromPage r9 = PreviewFromPage.PICKER;
            WeakReference r3 = (WeakReference) CollectionsKt.firstOrNull(f.a);
            if (r3 == null) goto L16;
            AbsDriveListViewModel r10 = (AbsDriveListViewModel) r3.get();
        L17:
            r2.m(new z79.b(r6, r13, r8, r9, r10, 64), null);
            return true;
        L16:
            r10 = null;
            goto L17
        L11:
            if (IDriveSdkServiceV2.a.b(this.a, r13, PreviewFromPage.PICKER.getValue()) == true) goto L22;
            r0.i("DriveSearchActivity", "open drive file preview failed, token=" + r13.b + ", type=" + r13.d);
            s r14 = s.a;
            FlowCommonAppCompatActivity r4 = this.a;
            r14.getClass();
            s.b(r4, 2131899914, false);
            return true;
        L22:
            return true;
        }

        @Override // w79.c
        public final void d(List<DriveFileItem> r2) {
            Intrinsics.checkNotNullParameter(r2, "fileList");
        }

        @Override // w79.c
        public final w79.a e(DriveFileItem r4) {
            Intrinsics.checkNotNullParameter(r4, "file");
            return new w79.a(true, DriveSearchActivity.N1(this.a, r4.d), 2);
        }

        @Override // w79.c
        public final void onChanged(List<DriveFileItem> r2) {
            Intrinsics.checkNotNullParameter(r2, "fileList");
        }
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DriveSearchActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public DriveSearchActivity() {
        this.h = LazyKt.lazy(new j79.i(this));
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DriveSearchActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r7);
        ConstraintLayout r8 = getLayoutInflater().inflate(2131563042, null, false);
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r8, 2131377369);
        if (r1 == null) goto L23;
        ConstraintLayout r9 = r8;
        this.g = new LarusPageDriveSearchBinding(r9, r1);
        setContentView(r9);
        if (Build.VERSION.SDK_INT < 34) goto L15;
        overrideActivityTransition(0, 2130772399, 0);
        overrideActivityTransition(1, 0, 2130772399);
    L16:
        LarusPageDriveSearchBinding r10 = this.g;
        if (r10 == null) goto L26;
        FrameLayout r3 = r10.b;
        if (r3 == null) goto L27;
        DriveSdkService.a.A(DrivePickerScene.FINDER, this, r3, (b) this.h.getValue(), CollectionsKt.emptyList());
        return;
    L27:
        return;
    L26:
        return;
    L15:
        overridePendingTransition(2130772399, 2130772399);
        goto L16
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(2131377369)));
    }

    public static final boolean N1(DriveSearchActivity r3, int r4) {
        r3.getClass();
        if (DriveSdkService.a.U().contains(Integer.valueOf(r4)) == false) goto L6;
        return true;
    L6:
        if (i.a.a() == true) goto L8;
    L10:
        return false;
    L8:
        if (SetsKt.setOf(new Integer[]{8, 11}).contains(Integer.valueOf(r4)) == false) goto L10;
        return true;
    }
}
