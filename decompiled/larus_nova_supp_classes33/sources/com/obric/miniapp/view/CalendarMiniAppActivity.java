package com.obric.miniapp.view;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.obric.miniapp.calendar.compatibility.EventEntity;
import com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider$b;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/miniapp/view/CalendarMiniAppActivity;", "Lcom/obric/miniapp/view/MiniAppBaseActivity;", "<init>", "()V", "interceptIntent", "", "getAppletId", "", "isHideTitleBar", "", "isNavigationBarTransparent", "isStatusBarTransparent", "refreshLayout", "statusBarTransparent", "navigationBarTransparent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarMiniAppActivity extends MiniAppBaseActivity {

    public static final class a {
    }

    static {
    }

    @Override // com.obric.miniapp.view.MiniAppBaseActivity
    public final String P1() {
        return "com.flow.calendar";
    }

    @Override // com.obric.miniapp.view.MiniAppBaseActivity
    public final boolean R1() {
        return true;
    }

    @Override // com.obric.miniapp.view.MiniAppBaseActivity
    public final boolean S1() {
        return true;
    }

    @Override // com.obric.miniapp.view.MiniAppBaseActivity
    public final void W1(boolean r1, boolean r2) {
    }

    @Override // com.obric.miniapp.view.MiniAppBaseActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CalendarMiniAppActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.miniapp.view.MiniAppBaseActivity
    public final void Q1() {
        String r0 = getIntent().getAction();
        Object r3 = null;
        CalendarSearchRecentSuggestionsProvider$b r4 = null;
        String r5 = null;
        if (r0 == null) goto L45;
        if (r0.hashCode() != (-518724938)) goto L45;
        if (r0.equals("com.obric.miniapp.calendar.SUGGESTION_CLICKED") == false) goto L45;
        Bundle r1 = getIntent().getExtras();
        if (r1 == null) goto L40;
        JsonObject r6 = new JsonObject();
        Uri r7 = getIntent().getData();
        if (r7 == null) goto L14;
        String r8 = r7.getLastPathSegment();
    L15:
        if (r8 == null) goto L17;
        r6.addProperty("eventUuid", r8);
    L17:
        String r9 = r1.getString("user_query");
        if (r9 == null) goto L20;
        r6.addProperty("keyword", r9);
    L20:
        String r2 = r1.getString("intent_extra_data_key");
        if (r2 == null) goto L39;
        int r10 = CalendarSearchRecentSuggestionsProvider$b.c;
        List r11 = new Regex("/").split(r2, 0);
        if (r11.isEmpty() == true) goto L33;
        ListIterator r12 = r11.listIterator(r11.size());
    L26:
        if (r12.hasPrevious() == false) goto L33;
        if (((String) r12.previous()).length() != 0) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == true) goto L26;
        List r14 = CollectionsKt.take(r11, r12.nextIndex() + 1);
    L34:
        String[] r15 = (String[]) r14.toArray(new String[0]);
        if (r15.length != 2) goto L37;
        String r16 = r15[0];
        Intrinsics.checkNotNull(r16);
        long r17 = CastLongProtector.parseLong(r16);
        String r18 = r15[1];
        Intrinsics.checkNotNull(r18);
        r4 = new CalendarSearchRecentSuggestionsProvider$b(r17, CastLongProtector.parseLong(r18));
    L37:
        if (r4 == null) goto L39;
        r6.addProperty("dtstart", Long.valueOf(r4.a));
        r6.addProperty("dtend", Long.valueOf(r4.b));
        goto L39
    L30:
        r13 = false;
    L33:
        r14 = CollectionsKt.emptyList();
    L39:
        r5 = r6.toString();
        goto L40
    L14:
        r8 = null;
    L40:
        getIntent().putExtra("appletId", "com.flow.calendar");
        getIntent().putExtra("pageId", "event");
        getIntent().putExtra("launchFrom", "system_search");
        if (r5 == null) goto L43;
        getIntent().putExtra("pageData", r5);
    L43:
        getIntent().setAction("android.intent.action.VIEW");
        return;
    L45:
        if (Intrinsics.areEqual(getIntent().getData(), y0.j("com.flow.calendar")) == false) goto L72;
        String r19 = getIntent().getStringExtra("pageData");
        if (r19 == null) goto L73;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L50
        Object r21 = Result.constructor-impl(JsonParser.parseString(r19).getAsJsonObject());     // Catch: Throwable -> L50
    L53:
        if (Result.isFailure-impl(r21) == true) goto L56;
        r3 = r21;
    L56:
        JsonObject r22 = (JsonObject) r3;
        if (r22 == null) goto L74;
        JsonObject r23 = r22.getAsJsonObject("eventEntity");
        if (r23 == null) goto L75;
        String[] r24 = EventEntity.w0;
        EventEntity r25 = EventEntity.a.b(r23);
        if (r25 == null) goto L76;
        r22.add("eventEntity", com.obric.miniapp.calendar.compatibility.a.b(r25, this).a());
        getIntent().putExtra("pageData", r22.toString());
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L50:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L73:
        return;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.miniapp.view.MiniAppBaseActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(CalendarMiniAppActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map<Activity, Long> r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = r5.get(this);     // Catch: Throwable -> L45
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
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L42
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

    public CalendarMiniAppActivity() {
    }
}
