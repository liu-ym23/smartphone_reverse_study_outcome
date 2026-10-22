package com.larksuite.component.card.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Size;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larksuite.component.card.utils.UniversalCardHostInfoManager;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0003\u0010\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/card/plugin/CardGetHostInfoPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "getHostInfo", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/CardGetHostInfoPlugin$CardGetHostInfoRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/CardGetHostInfoPlugin$CardGetHostInfoResponse;", "getActivity", "Landroid/app/Activity;", "event", "CardGetHostInfoRequest", "CardGetHostInfoResponse", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardGetHostInfoPlugin extends OPPlugin {
    public static final a Companion = null;
    private static final String TAG = "CardGetHostInfoPlugin";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larksuite/component/card/plugin/CardGetHostInfoPlugin$CardGetHostInfoRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardGetHostInfoRequest extends LKBaseRequestModel {
        public CardGetHostInfoRequest() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/plugin/CardGetHostInfoPlugin$CardGetHostInfoResponse;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "pageSize", "", "getPageSize", "()Ljava/lang/String;", "setPageSize", "(Ljava/lang/String;)V", "statusBarHeight", "", "getStatusBarHeight", "()I", "setStatusBarHeight", "(I)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardGetHostInfoResponse extends LKBaseResponseModel {
        private String pageSize;
        private int statusBarHeight;

        public CardGetHostInfoResponse() {
        }

        public final String getPageSize() {
            return this.pageSize;
        }

        public final int getStatusBarHeight() {
            return this.statusBarHeight;
        }

        public final void setPageSize(String r1) {
            this.pageSize = r1;
        }

        public final void setStatusBarHeight(int r1) {
            this.statusBarHeight = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CardGetHostInfoPlugin a;
        public final /* synthetic */ LKEvent b;
        public final /* synthetic */ j18.f<CardGetHostInfoResponse> c;

        public b(CardGetHostInfoPlugin r1, LKEvent r2, j18.f<CardGetHostInfoResponse> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            Context r0 = CardGetHostInfoPlugin.access$getActivity(this.a, this.b);
            if (r0 != null) goto L5;
            LarkAppContext.Companion.getClass();
            r0 = LarkAppContext.access$getInstance$cp().getContext();
        L5:
            Log.i(CardGetHostInfoPlugin.TAG, "current activity is ".concat(r0.getClass().getSimpleName()));
            UniversalCardHostInfoManager.f.getClass();
            Intrinsics.checkNotNullParameter(r0, "context");
            Size r2 = UniversalCardHostInfoManager.a.a(r0);
            Intrinsics.checkNotNullParameter(r0, "context");
            if ((r0.getResources().getConfiguration().screenLayout & 15) < 3) goto L8;
            UniversalCardHostInfoManager.PageSize r4 = UniversalCardHostInfoManager.PageSize.WIDE;
        L9:
            Intrinsics.checkNotNullParameter(r0, "context");
            Ref.IntRef r1 = new Ref.IntRef();
            Activity r5 = UIUtils.getActivityFromContext(r0);
            int r7 = 0;
            if (r5 == null) goto L45;
            View r9 = r5.getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L16;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r10 = ThreadMethodProxy.currentThread();
            if (r10 == com.larus.home.impl.utils.c.a) goto L16;
            com.larus.home.impl.utils.c.a(r10, "getDecorView");
        L16:
            WindowInsetsCompat r11 = ViewCompat.getRootWindowInsets(r9);
            if (r11 == null) goto L21;
            Insets r12 = r11.getInsets(WindowInsetsCompat.Type.statusBars());
            if (r12 == null) goto L21;
            float r13 = Math.abs(r12.top - r12.bottom);
            Resources r6 = r5.getResources();
            int r8 = Integer.valueOf((int) ((r13 / WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density) + 0.5f)).intValue();
        L22:
            r1.element = r8;
        L28:
            int r14 = com.larksuite.component.card.utils.h.a;
            Context r3 = UIUtils.getActivityFromContext(r0);
            if (r3 != null) goto L32;
            LarkAppContext.Companion.getClass();
            r3 = LarkAppContext.access$getInstance$cp().getContext();
        L32:
            if (com.larksuite.component.card.utils.h.a(r3) == false) goto L34;
        L36:
            UniversalCardHostInfoManager.HostInfo r15 = new UniversalCardHostInfoManager.HostInfo(r4, Integer.valueOf(r1.element), Integer.valueOf(r2.getWidth()), Integer.valueOf(r2.getHeight()));
            Log.i("UniversalCardHostWindowManager", "getHostInfo: pageSize=" + r15.getPageSize() + ", statusBarHeight=" + r15.getStatusBarHeight());
            CardGetHostInfoResponse r16 = new CardGetHostInfoResponse();
            UniversalCardHostInfoManager.PageSize r17 = r15.getPageSize();
            if (r17 == null) goto L39;
            String r19 = r17.getValue();
        L40:
            r16.setPageSize(r19);
            Integer r20 = r15.getStatusBarHeight();
            if (r20 == null) goto L43;
            r7 = r20.intValue();
        L43:
            r16.setStatusBarHeight(r7);
            this.c.callback(r16);
            return;
        L39:
            r19 = null;
            goto L40
        L34:
            if (r1.element != 0) goto L36;
            r1.element = 20;
        L21:
            r8 = 0;
            goto L22
        L45:
            LarkAppContext.Companion.getClass();     // Catch: Exception -> L25
            int r21 = RangesKt.coerceAtLeast(StatusBarUtil.getStatusBarHeight(LarkAppContext.access$getInstance$cp().getContext()), 0);     // Catch: Exception -> L25
            Resources r22 = LarkAppContext.access$getInstance$cp().getContext().getResources();     // Catch: Exception -> L25
            int r23 = Integer.valueOf((int) ((r21 / WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics()).density) + 0.5f)).intValue();     // Catch: Exception -> L25
        L27:
            r1.element = r23;
        L25:
            e = move-exception;
            Log.e("UniversalCardHostWindowManager", "getStatusBarHeight", e);
            r23 = 0;
            goto L27
        L8:
            r4 = UniversalCardHostInfoManager.PageSize.NORMAL;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public CardGetHostInfoPlugin() {
    }

    private final Activity getActivity(LKEvent r2) {
        Context r3 = r2.getContext();
        if ((r3 instanceof Activity) == false) goto L5;
        Activity r4 = (Activity) r3;
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return AppLifecycle.a.a.f();
    L5:
        r4 = null;
        goto L6
    }

    public static final /* synthetic */ Activity access$getActivity(CardGetHostInfoPlugin r0, LKEvent r1) {
        return r0.getActivity(r1);
    }

    @LKPluginFunction(async = true, eventName = {"universalCardGetHostInfo"})
    public final void getHostInfo(LKEvent r2, CardGetHostInfoRequest r3, j18.f<CardGetHostInfoResponse> r4) {
        Intrinsics.checkNotNullParameter(r2, "lkEvent");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "invokeCallback");
        Log.i(TAG, "universalCardGetHostInfo start");
        mz7.b.a(new b(this, r2, r4));
    }
}
