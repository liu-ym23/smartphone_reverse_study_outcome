package com.bytedance.android.live.broadcastgame.opengame.dialog;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.network.GameReportApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/dialog/OpenGameReportDialog;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "a", "InnerPageParams", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenGameReportDialog extends FragmentActivity {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> a;
    public int b;
    public Disposable c;
    public boolean d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public Function1<? super Integer, Unit> l;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/dialog/OpenGameReportDialog$InnerPageParams;", "Ljava/io/Serializable;", "", "component1", "component2", "path", "query", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getQuery", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InnerPageParams implements Serializable {
        public static final a Companion = null;
        public static final long serialVersionUID = 1;

        @SerializedName("path")
        private final String path;

        @SerializedName("query")
        private final String query;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public static /* synthetic */ InnerPageParams copy$default(InnerPageParams r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.path;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.query;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.path;
        }

        public final String component2() {
            return this.query;
        }

        public final InnerPageParams copy(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "path");
            Intrinsics.checkNotNullParameter(r3, "query");
            return new InnerPageParams(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof InnerPageParams) == false) goto L10;
            InnerPageParams r4 = (InnerPageParams) r3;
            if (Intrinsics.areEqual(this.path, r4.path) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.query, r4.query) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.path;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.query;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "InnerPageParams(path=" + this.path + ", query=" + this.query + ")";
        }

        public final String getPath() {
            return this.path;
        }

        public final String getQuery() {
            return this.query;
        }

        public InnerPageParams(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "path");
            Intrinsics.checkNotNullParameter(r3, "query");
            this.path = r2;
            this.query = r3;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ OpenGameReportDialog a;

        public c(OpenGameReportDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            final List<q.a> r8 = ((q) ((BaseResponse) ((Response) r7)).data).a();
            if (r8 == null) goto L6;
            UtilityKotlinExtentionsKt.s(0, false, false, new OpenGameReportDialog$requestData$1$$special$$inlined$let$lambda$1(r8, this), 7);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(OpenGameReportDialog.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void y1() {
        Lazy r0 = LiveOpenGameClient.d;
        GameReportApi r1 = (GameReportApi) LiveOpenGameClient.a.a().a(GameReportApi.class);
        if (((Number) this.j.getValue()).intValue() != PluginType.MINI_APP.getValue()) goto L5;
        String r2 = "micro_app";
    L6:
        this.c = r1.getReportReasonList(r2, ((Number) this.f.getValue()).longValue()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new c(this), d.a);
        return;
    L5:
        r2 = "mini_app";
        goto L6
    }

    public OpenGameReportDialog() {
        this.a = new LinkedHashMap();
        this.d = true;
        this.e = LazyKt.lazy(new OpenGameReportDialog$develop$2(this));
        this.f = LazyKt.lazy(new OpenGameReportDialog$roomId$2(this));
        this.g = LazyKt.lazy(new OpenGameReportDialog$isAnchor$2(this));
        this.h = LazyKt.lazy(new OpenGameReportDialog$appId$2(this));
        this.i = LazyKt.lazy(new OpenGameReportDialog$appName$2(this));
        this.j = LazyKt.lazy(new OpenGameReportDialog$pluginType$2(this));
        this.k = LazyKt.lazy(new OpenGameReportDialog$miniAppPagerParams$2(this));
    }

    public final void onDestroy() {
        super.onDestroy();
        Function1<? super Integer, Unit> r0 = this.l;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(Integer.valueOf(this.b));
    L5:
        this.l = null;
        Disposable r2 = this.c;
        if (r2 == null) goto L9;
        r2.dispose();
        return;
    }

    public final void onResume() {
        super.onResume();
        this.b = 0;
        if (this.d == true) goto L5;
        y1();
    L5:
        this.d = false;
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

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L17
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L17
    L8:
        super.onCreate(r6);
        setContentView(2131564133);
        getWindow().setGravity(80);
        getWindow().setLayout(-1, -2);
        overridePendingTransition(2130772626, 2130772636);
        int r1 = 0;
        if ((!StringsKt.isBlank((String) this.e.getValue())) == false) goto L11;
        ((TextView) _$_findCachedViewById(2131390479)).setText(s1.C(2131922174, new Object[]{(String) this.e.getValue()}));
    L11:
        View r7 = _$_findCachedViewById(2131390479);
        Boolean r0 = Boolean.valueOf(true ^ StringsKt.isBlank((String) this.e.getValue()));
        Intrinsics.checkNotNullParameter(r7, "$this$setVisible");
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == true) goto L15;
        r1 = 8;
    L15:
        r7.setVisibility(r1);
        y1();
        ((ScrollView) _$_findCachedViewById(2131384819)).setOnClickListener(b.a);
    }
}
