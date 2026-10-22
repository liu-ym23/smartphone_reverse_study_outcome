package com.larus.dora.o.impl.memory;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.Gson;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.dora.o.impl.databinding.DoraOActivityMemoryEventDetailBinding;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/dora/o/impl/memory/ODoraMemoryEventDetailActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOActivityMemoryEventDetailBinding;", "menuPopover", "Lcom/obric/oui/popover/v2/OPopover;", "event", "Lcom/larus/dora/o/impl/memory/OMemoryEvent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupContentTopInset", "needAdaptStatusBarPadding", "", "getBackgroundResource", "", "setupTitleBar", "bindContent", "buildSubtitle", "", "isToday", "timeMs", "", "showMoreMenu", "anchor", "Landroid/view/View;", "confirmDelete", "deleteAndFinish", "onDestroy", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODoraMemoryEventDetailActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int j = 0;
    public DoraOActivityMemoryEventDetailBinding g;
    public com.obric.oui.popover.v2.c h;
    public n i;

    public static final class a {
    }

    static {
    }

    public final int C1() {
        return 2131101351;
    }

    public final boolean K1() {
        return false;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ODoraMemoryEventDetailActivity.class.getName()));
    L5:
        super.onDestroy();
        com.obric.oui.popover.v2.c r0 = this.h;
        if (r0 == null) goto L8;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L8:
        this.h = null;
        this.g = null;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ODoraMemoryEventDetailActivity.class.getName()));
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

    public ODoraMemoryEventDetailActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r18) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r18);
        u69.a.a(this);
        String r3 = null;
        ConstraintLayout r0 = getLayoutInflater().inflate(2131560140, null, false);
        int r2 = 2131379859;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r0, 2131379859);
        if (r8 == null) goto L94;
        r2 = 2131379860;
        ScrollView r9 = (ScrollView) ViewBindings.findChildViewById(r0, 2131379860);
        if (r9 == null) goto L94;
        r2 = 2131379861;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131379861);
        if (r10 == null) goto L94;
        r2 = 2131379862;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131379862);
        if (r11 == null) goto L94;
        r2 = 2131379863;
        OFloatingTitleBar r12 = ViewBindings.findChildViewById(r0, 2131379863);
        if (r12 == null) goto L94;
        ConstraintLayout r1 = r0;
        this.g = new DoraOActivityMemoryEventDetailBinding(r1, r8, r9, r10, r11, r12);
        setContentView(r1);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L24
        Object r5 = Result.constructor-impl((n) new Gson().fromJson(getIntent().getStringExtra("extra_event_json"), n.class));     // Catch: Throwable -> L24
    L26:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L30;
        FLogger.a.e("ODoraMemoryEventDetail", "parse event failed", r6);
    L30:
        if (Result.isFailure-impl(r5) == false) goto L32;
        r5 = null;
    L32:
        n r7 = (n) r5;
        this.i = r7;
        if (r7 != null) goto L35;
        finish();
        return;
    L35:
        DoraOActivityMemoryEventDetailBinding r13 = this.g;
        if (r13 == null) goto L40;
        OFloatingTitleBar r14 = r13.f;
        if (r14 == null) goto L40;
        OFloatingTitleBar.k(r14, new d(this), 2);
        r14.h(2131246369, -1, new e(this));
    L40:
        DoraOActivityMemoryEventDetailBinding r15 = this.g;
        if (r15 == null) goto L44;
        final ScrollView r16 = r15.c;
        r15.f.addOnLayoutChangeListener(new f(r16));
    L44:
        DoraOActivityMemoryEventDetailBinding r17 = this.g;
        if (r17 == null) goto L100;
        n r20 = this.i;
        if (r20 == null) goto L101;
        TextView r21 = r17.e;
        String r22 = r20.e();
        String r23 = "";
        if (r22 != null) goto L53;
        r22 = "";
    L53:
        r21.setText(r22);
        TextView r24 = r17.d;
        ArrayList r25 = new ArrayList();
        String r26 = r20.getType();
        if (r26 != null) goto L56;
    L63:
        Long r27 = r20.d();
        if (r27 == null) goto L66;
        long r110 = r27.longValue();
    L67:
        long r111 = 1000;
        long r112 = r110 * r111;
        if (r112 <= 0) goto L87;
        Calendar r28 = Calendar.getInstance();
        Calendar r30 = Calendar.getInstance();
        r30.setTimeInMillis(r112);
        if (r28.get(1) == r30.get(1)) goto L72;
    L74:
        boolean r31 = false;
    L75:
        if (r31 == false) goto L77;
        String r32 = getString(2131902906);
    L78:
        SimpleDateFormat r33 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Long r34 = r20.b();
        if (r34 == null) goto L81;
        long r113 = r34.longValue();
    L82:
        long r114 = r113 * r111;
        if (r114 <= r112) goto L85;
        String r35 = r33.format(Long.valueOf(r112)) + '-' + r33.format(Long.valueOf(r114));
    L86:
        r25.add(r32 + ' ' + r35);
        goto L87
    L85:
        r35 = r33.format(Long.valueOf(r112));
        goto L86
    L81:
        r113 = 0;
        goto L82
    L77:
        r32 = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(Long.valueOf(r112));
        goto L78
    L72:
        if (r28.get(6) != r30.get(6)) goto L74;
        r31 = true;
    L87:
        r24.setText(CollectionsKt.joinToString$default(r25, " · ", null, null, 0, null, null, 62, null));
        TextView r36 = r17.b;
        String r37 = r20.a();
        if (r37 == null) goto L91;
        r23 = r37;
    L91:
        r36.setText(r23);
        return;
    L66:
        r110 = 0;
        goto L67
    L56:
        if (r26.length() <= 0) goto L58;
        boolean r115 = true;
    L59:
        if (r115 == false) goto L61;
        r3 = r26;
    L61:
        if (r3 == null) goto L63;
        r25.add(r3);
        goto L63
    L58:
        r115 = false;
        goto L59
    L101:
        return;
    L100:
        return;
    L24:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L94:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    }
}
