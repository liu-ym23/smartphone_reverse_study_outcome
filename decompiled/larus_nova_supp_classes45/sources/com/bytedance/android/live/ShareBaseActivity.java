package com.bytedance.android.live;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.share.MatchShareViewModel;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScreenOrientation;
import com.bytedance.android.livesdk.config.yx0;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.vs.model.PublishParam;
import com.bytedance.android.livesdk.vs.model.SearchPanelParam;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class ShareBaseActivity extends AppCompatActivity {
    public LiveShareBaseFragment a;
    public MatchShareViewModel b;
    public AtomicBoolean c;
    public MatchShareParam d;

    public class a extends TypeToken<ShareParams> {
        public a() {
        }
    }

    public class b extends TypeToken<Episode> {
        public b() {
        }
    }

    public class c extends TypeToken<Room> {
        public c() {
        }
    }

    public class d extends TypeToken<SearchPanelParam> {
        public d() {
        }
    }

    public class e extends TypeToken<PublishParam> {
        public e() {
        }
    }

    public abstract MatchShareViewModel z1();

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        xs2.b.a().post(new h1(48));
        xs2.b.a().post(new h1(56));
        AtomicBoolean r0 = this.c;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.get() == false) goto L10;
        xs2.b.a().post(new HorizontalPlayEvent(1, 0, "source_landscape_match_share"));
        return;
    L10:
        xs2.b.a().post(new HorizontalPlayEvent(2, 0, "source_landscape_match_share"));
    }

    public void onStop() {
        super.onStop();
        xs2.b.a().post(new h1(47));
    }

    public ShareBaseActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration r6) {
        super.onConfigurationChanged(r6);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L20;
        int r2 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r6 == null) goto L8;
        Integer r3 = Integer.valueOf(r6.orientation);     // Catch: Throwable -> L17
    L9:
        if (r3 != null) goto L12;
    L14:
        if (r2 != 3) goto L20;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        goto L20
    L12:
        if (r3.intValue() == r2) goto L20;
    L8:
        r3 = null;
    L20:
        if (this.a != null) goto L22;
        return;
    L22:
        if (r6.orientation != 2) goto L24;
        this.b.getScreenOrientationChange().postValue(Integer.valueOf(ShareScreenOrientation.Landscape.getStatus()));
        return;
    L24:
        this.b.getScreenOrientationChange().postValue(Integer.valueOf(ShareScreenOrientation.Portrait.getStatus()));
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r3) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r3);
        t8.d(getWindow());
        if (this.d != null) goto L13;
        this.d = f.a;
    L13:
        xs2.b.a().post(new h1(47));
        xs2.b.a().post(new h1(32));
        this.b = z1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onRestoreInstanceState(Bundle r7) {
        super/*android.app.Activity*/.onRestoreInstanceState(r7);
        if (((Boolean) yx0.a.getValue()).booleanValue() == true) goto L24;
        MatchShareParam r2 = f.a;
        this.d = r2;
        if (r2 != null) goto L11;
        MatchShareParam r3 = new MatchShareParam();
        f.a = r3;
        this.d = r3;
    L11:
        MatchShareParam r4 = this.d;
        r4.a = r7.getString("KEY_SHARE_PARAM_ENTER_FROM");
        MatchShareParam r5 = this.d;
        r5.b = r7.getString("KEY_SHARE_PARAM_ORIGIN_COLLECT_ID");
        MatchShareParam r6 = this.d;
        r6.d = r7.getParcelableArrayList("KEY_SHARE_PARAM_TOTAL_COLLECTION");
        MatchShareParam r8 = this.d;
        r8.e = r7.getParcelable("KEY_SHARE_PARAM_VIDEO_PARAM");
        MatchShareParam r9 = this.d;
        r9.h = r7.getLong("KEY_SHARE_PARAM_RECORD_DURATION");
        MatchShareParam r11 = this.d;
        r11.c = r7.getString("KEY_SHARE_PARAM_FINAL_SHARE_COLLECTION_ID");
        MatchShareParam r12 = this.d;
        r12.k = r7.getInt("KEY_SHARE_PARAM_INDEX");
        MatchShareParam r13 = this.d;
        String r14 = r7.getString("KEY_CONTENT_TYPE", "");
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.m = r14;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        if (r7.getSerializable("KEY_SHARE_LOG_PARAM") == null) goto L15;
        MatchShareParam r15 = this.d;     // Catch: Exception -> L19
        HashMap r0 = (HashMap) r7.getSerializable("KEY_SHARE_LOG_PARAM");     // Catch: Exception -> L19
        r15.getClass();     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r0, "<set-?>");     // Catch: Exception -> L19
        r15.n = r0;     // Catch: Exception -> L19
    L15:
        Type r1 = new b().getType();     // Catch: Exception -> L19
        MatchShareParam r16 = this.d;     // Catch: Exception -> L19
        r16.g = (Episode) GsonHelper.get().fromJson(r7.getString("KEY_SHARE_PARAM_EPISODE"), r1);     // Catch: Exception -> L19
        Type r17 = new c().getType();     // Catch: Exception -> L19
        MatchShareParam r18 = this.d;     // Catch: Exception -> L19
        r18.f = (IRoom) GsonHelper.get().fromJson(r7.getString("KEY_SHARE_PARAM_ROOM"), r17);     // Catch: Exception -> L19
        Type r19 = new d().getType();     // Catch: Exception -> L19
        MatchShareParam r21 = this.d;     // Catch: Exception -> L19
        r21.j = (SearchPanelParam) GsonHelper.get().fromJson(r7.getString("KEY_SEARCH_PANEL_PARAM"), r19);     // Catch: Exception -> L19
        Type r22 = new e().getType();     // Catch: Exception -> L19
        if (GsonHelper.get().fromJson(r7.getString("KEY_SEARCH_PANEL_PARAM"), r22) == null) goto L27;
        MatchShareParam r23 = this.d;     // Catch: Exception -> L19
        PublishParam r24 = (PublishParam) GsonHelper.get().fromJson(r7.getString("KEY_SEARCH_PANEL_PARAM"), r22);     // Catch: Exception -> L19
        r23.getClass();     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r24, "<set-?>");     // Catch: Exception -> L19
        r23.l = r24;     // Catch: Exception -> L19
        return;
    L27:
        return;
    L24:
        Type r25 = new a().getType();     // Catch: Exception -> L6
        this.d = (MatchShareParam) GsonHelper.get().fromJson((String) com.bytedance.android.livesdk.sharedpref.b.v3.getValue(), r25);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        ALogger.e("ShareBaseActivity", e.getMessage());
        finish();
    }

    public final void onSaveInstanceState(Bundle r5) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(r5);
        if (((Boolean) yx0.a.getValue()).booleanValue() == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.v3;
        String r0 = GsonProtectorUtils.toJson(GsonHelper.get(), this.d);
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r0);
        return;
    L5:
        r5.putString("KEY_SHARE_PARAM_ENTER_FROM", this.d.a);
        r5.putString("KEY_SHARE_PARAM_ORIGIN_COLLECT_ID", this.d.b);
        r5.putParcelableArrayList("KEY_SHARE_PARAM_TOTAL_COLLECTION", (ArrayList) this.d.d);
        r5.putParcelable("KEY_SHARE_PARAM_VIDEO_PARAM", this.d.e);
        r5.putLong("KEY_SHARE_PARAM_RECORD_DURATION", this.d.h);
        r5.putString("KEY_SHARE_PARAM_FINAL_SHARE_COLLECTION_ID", this.d.c);
        r5.putString("KEY_CONTENT_TYPE", this.d.m);
        r5.putSerializable("KEY_SHARE_LOG_PARAM", this.d.n);
        if (s1.F() == false) goto L8;
        r5.putInt("KEY_SHARE_PARAM_INDEX", this.d.k);
    L14:
        r5.putString("KEY_SHARE_PARAM_EPISODE", GsonHelper.get().toJson(this.d.g, Episode.class));     // Catch: Exception -> L11
        r5.putString("KEY_SHARE_PARAM_ROOM", GsonHelper.get().toJson(this.d.f, Room.class));     // Catch: Exception -> L11
        r5.putString("KEY_SEARCH_PANEL_PARAM", GsonHelper.get().toJson(this.d.j, SearchPanelParam.class));     // Catch: Exception -> L11
        r5.putString("KEY_PUBLISH_PARAM", GsonHelper.get().toJson(this.d.l, PublishParam.class));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        r5.putInt("KEY_SHARE_PARAM_INDEX", 1);
        goto L14
    }

    public final void y1(Boolean r5, LiveShareBaseFragment r6) {
        if (this.d != null) goto L7;
        finish();
        return;
    L7:
        if (getSupportFragmentManager().findFragmentById(2131373275) == null) goto L9;
        return;
    L9:
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L14;
        r0.replace(2131373275, r6);
    L14:
        if (r5.booleanValue() == false) goto L16;
        r0.commitAllowingStateLoss();
        return;
    L16:
        r0.commit();
    }
}
