package com.larus.doc.impl;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.l4;
import com.larus.doc.impl.viewmodel.DocDetailViewModel;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014J\u0018\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0006\u0010\u001a\u001a\u00020\fJ\b\u0010\u001b\u001a\u00020\fH\u0014J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/doc/impl/DocActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/larus/bmhome/chat/ITraceActivity;", "<init>", "()V", "rootView", "Landroid/view/View;", "viewModel", "Lcom/larus/doc/impl/viewmodel/DocDetailViewModel;", "docFragment", "Lcom/larus/doc/impl/DocFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "replaceWithNewDocFragment", "docId", "", "resourceType", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onLoadFinishEventReported", "onResume", "onBackPressed", "scene", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocActivity extends AppCompatActivity implements l4 {
    public static final /* synthetic */ int d = 0;
    public View a;
    public DocDetailViewModel b;
    public DocFragmentV2 c;

    public static final class a {
    }

    static {
    }

    public final String scene() {
        return "DOC_DETAIL_ACTIVITY";
    }

    public final void onBackPressed() {
        DocFragmentV2 r0 = this.c;
        if (r0 == null) goto L6;
        r0.onBackPressed();
        return;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DocActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DocActivity.class.getName()));
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

    public final void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        FLogger.a.e("DocActivity", th.getMessage(), th);
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        final View r0 = findViewById(R.id.content);
        this.a = r0;
        if (r0 == null) goto L6;
        int r1 = com.larus.utils.u.b(this);
        int r2 = r0.getPaddingStart();
        int r3 = r0.getPaddingTop();
        int r4 = r0.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r0.getClass().getSimpleName() + ",source:,start:" + r2 + ",top:" + r3 + ",end:" + r4 + ",bottom:" + r1);
        r0.setPaddingRelative(r2, r3, r4, r1);
        ViewCompat.setOnApplyWindowInsetsListener(r0, new com.larus.doc.impl.a(r0, this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
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

    public DocActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        com.larus.office.base.utils.c.a(r8, "DocActivity");
        v19.f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r8);
        FLogger r9 = FLogger.a;
        r9.i("[DocTracer]", "DocActivity.onCreate");
        this.b = (DocDetailViewModel) new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(DocDetailViewModel.class);
        boolean r3 = false;
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L13;
        boolean r1 = true;
    L14:
        v19.h.a = r1;
        com.larus.utils.u.e(this, true, r1);
        com.larus.utils.u.d(this);
        Window r2 = getWindow();
        if (r2 == null) goto L17;
        r2.setBackgroundDrawableResource(2131102529);
    L17:
        setContentView(2131561787);
        Bundle r4 = getIntent().getExtras();
        Integer r5 = null;
        if (r4 == null) goto L20;
        String r6 = r4.getString("key_doc_id");
    L21:
        if (r4 == null) goto L23;
        r5 = Integer.valueOf(r4.getInt("resource_type", 0));
    L23:
        if (r6 != null) goto L25;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == false) goto L31;
        finish();
        r9.i("DocActivity", "Invalid docId: " + r6);
        return;
    L31:
        DocDetailViewModel r10 = this.b;
        if (r10 != null) goto L34;
    L36:
        r4.putBoolean("has_report_finish_event", r3);
        StringBuilder r11 = new StringBuilder("Doc resource type: ");
        r11.append(r5);
        r11.append(", Hit fusion config: ");
        z2 r12 = z2.a;
        r11.append(r12.getDocFusionConfig().a);
        r11.append(" forceUseFusionDoc=");
        r11.append(r12.forceOpenFusionDoc());
        r9.i("DocActivity", r11.toString());
        DocFragmentV2 r13 = new DocFragmentV2();
        this.c = r13;
        r13.setArguments(r4);
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "tag_doc_fragment", 2131373275) == true) goto L40;
        r0 = r0.replace(2131373275, r13, "tag_doc_fragment");
    L40:
        r0.commitAllowingStateLoss();
        return;
    L34:
        if (r10.getHasReportLoadEvent() != true) goto L36;
        r3 = true;
        goto L36
    L25:
        if (r6.length() == 0) goto L28;
        r7 = false;
        goto L29
    L20:
        r6 = null;
        goto L21
    L13:
        r1 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1(String r4, int r5) {
        Bundle r0 = getIntent().getExtras();
        if (r0 == null) goto L5;
        r0.putInt("resource_type", r5);
    L5:
        if (r0 == null) goto L7;
        r0.putString("key_doc_id", r4);
    L7:
        if (r0 == null) goto L9;
        String r6 = r0.getString("key_doc_enter_from");
    L10:
        boolean r7 = Intrinsics.areEqual(r6, "ai_space_create_blank_doc");
        DocFragmentV2 r8 = new DocFragmentV2();
        this.c = r8;
        r8.setArguments(r0);
        if (r7 == false) goto L13;
        m39.a.f = true;
    L13:
        FragmentTransaction r9 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "tag_doc_fragment", 2131373275) == true) goto L17;
        r9 = r9.replace(2131373275, r8, "tag_doc_fragment");
    L17:
        r9.commitAllowingStateLoss();
        return;
    L9:
        r6 = null;
        goto L10
    }

    public final void onActivityResult(int r6, int r7, Intent r8) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r6, r7, r8);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("Router onActivityResult: requestCode -> ");
        r1.append(r6);
        r1.append(" , resultCode -> ");
        r1.append(r7);
        r1.append(" , data: ");
        xe8.a r2 = null;
        if (r8 == null) goto L5;
        Bundle r3 = r8.getExtras();
    L6:
        r1.append(r3);
        r0.i("DocActivity", r1.toString());
        if (r8 == null) goto L26;
        Bundle r9 = r8.getExtras();
        if (r9 == null) goto L27;
        DocFragment r4 = getSupportFragmentManager().findFragmentByTag("tag_doc_fragment");
        if ((r4 instanceof DocFragment) == false) goto L28;
        Fragment r5 = r4.h;
        boolean r10 = false;
        if (r5 != null) goto L15;
    L17:
        if (r10 == true) goto L19;
        return;
    L19:
        if (r5.isDetached() == false) goto L21;
        return;
    L21:
        if ((r5 instanceof xe8.a) == false) goto L23;
        r2 = (xe8.a) r5;
    L23:
        if (r2 == null) goto L31;
        r2.Lc(r9, r6, r7);
        return;
    L31:
        return;
    L15:
        if (r5.isAdded() != true) goto L17;
        r10 = true;
        goto L17
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
