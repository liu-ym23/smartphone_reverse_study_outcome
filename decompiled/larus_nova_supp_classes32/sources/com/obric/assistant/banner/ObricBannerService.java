package com.obric.assistant.banner;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.ui.progressbar.CustomUpdateCircleProgressBar;
import com.obric.assistant.impl.databinding.ObricUpdateBannerBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.assistant.t1;
import com.obric.assistant.view.ObricUpdateBannerPopupWindow;
import com.obric.assistant.view.a0;
import com.obric.assistant.view.b0;
import com.obric.assistant.view.h;
import com.obric.assistant.view.h0;
import com.obric.assistant.view.i;
import com.obric.assistant.view.j;
import com.obric.assistant.view.w;
import com.obric.assistant.view.y;
import com.obric.assistant.view.z;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricBannerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sba.c;
import sba.d;
import sba.e;
import sba.f;
import sba.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0012H\u0002J\u0012\u0010!\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010\"\u001a\u00020\u000f2\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010#\u001a\u00020\u00122\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010$\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J \u0010&\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000fH\u0016J*\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J(\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000fH\u0016J*\u0010.\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)2\b\b\u0001\u0010\u001c\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u000fH\u0002J(\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u000f2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0002J\u001e\u00104\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00192\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b06H\u0016J\u0018\u00107\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0016J(\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u000fH\u0016J\b\u0010<\u001a\u00020\u001bH\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000fH\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000fH\u0016J\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J \u0010A\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)H\u0002J6\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00170\u00162\b\b\u0001\u0010\u001c\u001a\u00020\u0012H\u0002J!\u0010\n\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000f2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010CJ\f\u0010D\u001a\u00020\u000f*\u00020)H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/assistant/banner/ObricBannerService;", "Lcom/obric/assistant/banner/IObricBannerService;", "<init>", "()V", "obricBannerRepo", "Lcom/bytedance/keva/Keva;", "getObricBannerRepo", "()Lcom/bytedance/keva/Keva;", "obricBannerRepo$delegate", "Lkotlin/Lazy;", "isShowing", NameKeys.UnloadStrategy_No_Strategy, "()Z", "updateBannerWindowsByHost", "Ljava/util/concurrent/ConcurrentHashMap;", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/view/ObricUpdateBannerPopupWindow;", "currentPopupBannerType", NameKeys.UnloadStrategy_No_Strategy, "Ljava/lang/Integer;", "suppressShowNextBannerCount", "currentBannersPriorityQueue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "currentBannersDataMap", "Lcom/obric/assistant/banner/bean/ObricBanner;", "registerBanner", NameKeys.UnloadStrategy_No_Strategy, "bannerType", "priority", LynxResourceModule.DATA_KEY, "getUpdateBannerKeyByConfig", "bannerShowType", "isNeedBannerShown", "getBannersKey", "getPriority", "forbiddenShowBanner", "getHighestPendingPriority", "canShowBanner", "hostId", "anchorView", "Landroid/view/View;", "showBanner", "context", "Landroid/app/Activity;", "banner", "onBannerDismissed", "reportUpdateBannerPipeline", "result", "reason", "extra", "Lorg/json/JSONObject;", "showCustomDialog", "showDialogAction", "Lkotlin/Function0;", "setBannerUserDismissed", "updateBannerPosition", "container", "width", "height", "dismissAllBanner", "dismissBannerByHost", "dismissBannerByType", "isBannerShowing", "resetBannerFrequencyControl", "showNextBanner", "removeItemByBannerKey", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "toBannerAnchorLog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBannerService implements IObricBannerService {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public final ConcurrentHashMap<String, ObricUpdateBannerPopupWindow> b;
    public Integer c;
    public int d;
    public final PriorityQueue<Pair<Integer, Integer>> e;
    public final ConcurrentHashMap<Integer, tba.b> f;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Comparable) ((Pair) r2).getSecond(), (Comparable) ((Pair) r1).getSecond());
        }
    }

    static {
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void c() {
        p(this.e, 2);
        this.f.remove(2);
        Integer r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() == 2) goto L8;
        return;
    L8:
        if (j.b() == false) goto L10;
        this.d++;
    L10:
        j.a();
        this.c = null;
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void g() {
        FLogger.a.i("ObricBannerService", "dismissAllBanner, updateHostCount=" + this.b.size());
        this.e.clear();
        this.f.clear();
        ConcurrentHashMap<String, ObricUpdateBannerPopupWindow> r0 = this.b;
        int r2 = 0;
        if (r0.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, ObricUpdateBannerPopupWindow>> r1 = r0.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        if (r1.next().getValue().f() == false) goto L7;
        r2 = r2 + 1;
    L11:
        this.d = r2 + (j.b() ? 1 : 0);
        Iterator<T> r3 = this.b.values().iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        ((ObricUpdateBannerPopupWindow) r3.next()).c();
        goto L13
    L15:
        this.b.clear();
        j.a();
        this.c = null;
    }

    public final Keva i() {
        return (Keva) this.a.getValue();
    }

    public final boolean m() {
        Collection<ObricUpdateBannerPopupWindow> r0 = this.b.values();
        if (r0.isEmpty() == true) goto L11;
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        if (((ObricUpdateBannerPopupWindow) r1.next()).f() == false) goto L7;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
    L15:
        return true;
    L14:
        if (j.b() == true) goto L15;
        return false;
    L11:
        r2 = false;
        goto L12
    }

    public ObricBannerService() {
        this.a = LazyKt.lazy(new sba.a());
        this.b = new ConcurrentHashMap();
        this.e = new PriorityQueue(10, new b());
        this.f = new ConcurrentHashMap();
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void a() {
        i().storeString(k(ObricBannerType.AVAILABLE.getValue()), "0");
        i().storeString(k(ObricBannerType.WIFI_DOWNLOADING.getValue()), "0");
        i().storeString(k(ObricBannerType.STATE_DOWNLOADED.getValue()), "0");
    }

    public static int j(@com.obric.assistant.banner.bean.ObricBannerType int r1) {
        Integer r2 = (Integer) ((LinkedHashMap) tba.b.h.getValue()).get(Integer.valueOf(r1));
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    }

    public static String k(int r1) {
        if (r1 != ObricBannerType.AVAILABLE.getValue()) goto L5;
    L14:
        String r2 = "user";
    L16:
        return "banner_is_shown_1_".concat(r2);
    L5:
        if (r1 == ObricBannerType.DOWNLOADING.getValue()) goto L14;
        if (r1 != ObricBannerType.WIFI_DOWNLOADING.getValue()) goto L11;
        r2 = "wifi_auto";
        goto L16
    L11:
        if (r1 != ObricBannerType.STATE_DOWNLOADED.getValue()) goto L13;
        r2 = "install";
        goto L16
    L13:
        r2 = "unknown";
        goto L16
    }

    public static String q(View r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.getClass().getSimpleName());
        r0.append('@');
        r0.append(Integer.toHexString(System.identityHashCode(r3)));
        r0.append("[shown=");
        r0.append(r3.isShown());
        r0.append(",attached=");
        r0.append(r3.isAttachedToWindow());
        r0.append(",bounds=");
        r0.append(r3.getLeft());
        r0.append(',');
        r0.append(r3.getTop());
        r0.append('-');
        r0.append(r3.getRight());
        r0.append(',');
        r0.append(r3.getBottom());
        r0.append(",root=");
        View r1 = r3.getRootView();
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r4 = Integer.valueOf(r1.getWidth());
    L6:
        r0.append(r4);
        r0.append('x');
        View r5 = r3.getRootView();
        if (r5 == null) goto L9;
        r2 = Integer.valueOf(r5.getHeight());
    L9:
        r0.append(r2);
        r0.append(']');
        return r0.toString();
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "hostId");
        FLogger.a.i("ObricBannerService", "dismissBannerByHost, hostId=" + r4 + ", hasWindow=" + this.b.containsKey(r4));
        ObricUpdateBannerPopupWindow r5 = this.b.remove(r4);
        if (r5 == null) goto L6;
        r5.c();
        return;
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final boolean e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "hostId");
        return n(r2, null);
    }

    public final boolean l(@com.obric.assistant.banner.bean.ObricBannerType int r11) {
        if (r11 != 1) goto L5;
        IObricUpdateService r12 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r12 == null) goto L15;
        ObricBannerType r13 = r12.getBannerType();
        if (r13 == null) goto L15;
        int r14 = r13.getValue();
    L16:
        long r3 = AppHost.a.getAppClock().currentTimeMillis() - CastLongProtector.parseLong(i().getString(k(r14), "0"));
        long r5 = t1.a.L0().getObricUpdateBannerShowInterval() * 1000;
        FLogger.a.i("ObricBannerService", "isBannerShown, CHECK_UPDATE, bannerShowType:" + r14 + ",  gap: " + r3 + ", timeLimit: " + r5);
        if (r3 <= r5) goto L21;
    L18:
        return true;
    L21:
        return false;
    L15:
        r14 = 0;
        goto L16
    L5:
        if (r11 != 2) goto L7;
        FLogger.a.i("ObricBannerService", "isNeedBannerShown, SET_DEFAULT_ASSISTANT skip frequency control");
        goto L18
    L7:
        if (i().contains("banner_is_shown_" + r11) == false) goto L18;
        return false;
    }

    public final boolean n(String r3, @com.obric.assistant.banner.bean.ObricBannerType Integer r4) {
        if (r4 != null) goto L6;
    L7:
        if (r4 != null) goto L17;
    L10:
        ObricUpdateBannerPopupWindow r5 = this.b.get(r3);
        if (r5 != null) goto L13;
    L15:
        return false;
    L13:
        if (r5.f() != true) goto L15;
        return true;
    L17:
        return j.b();
    L6:
        if (r4.intValue() == 1) goto L10;
        goto L7
    }

    public final void p(PriorityQueue r4, @com.obric.assistant.banner.bean.ObricBannerType int r5) {
        FLogger.a.i("ObricBannerService", "removeItemByBannerKey, " + r5 + ", current: " + this.e);
        Iterator r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((Number) ((Pair) r1).getFirst()).intValue() != r5) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        Pair r3 = (Pair) r1;
        if (r3 == null) goto L21;
        r4.remove(r3);
        return;
    L21:
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.obric.assistant.banner.IObricBannerService
    public final void b(View r18, int r19, int r20, String r21) {
        Intrinsics.checkNotNullParameter(r18, "container");
        Intrinsics.checkNotNullParameter(r21, "hostId");
        ObricUpdateBannerPopupWindow r10 = this.b.get(r21);
        if (r10 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        Unit r11 = null;
        if (r5 == false) goto L48;
        FLogger r6 = FLogger.a;
        r6.i("ObricBannerService", "updateBannerPosition, hostId=" + r21 + ", anchor=" + q(r18) + ", width=" + r19 + ", height=" + r20);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r18, "container");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L42
        PopupWindow r3 = r10.b;     // Catch: Throwable -> L42
        if (r3 != null) goto L14;
    L16:
        boolean r16 = false;
    L17:
        if (r16 == false) goto L36;
        StringBuilder r4 = new StringBuilder("updatePosition, hostId=");     // Catch: Throwable -> L42
        r4.append(r10.a);     // Catch: Throwable -> L42
        r4.append(", anchor=");     // Catch: Throwable -> L42
        r4.append(ObricUpdateBannerPopupWindow.j(r18));     // Catch: Throwable -> L42
        r4.append(", width=");     // Catch: Throwable -> L42
        r4.append(r19);     // Catch: Throwable -> L42
        r4.append(", height=");     // Catch: Throwable -> L42
        r4.append(r20);     // Catch: Throwable -> L42
        r4.append(", popupWidth=");     // Catch: Throwable -> L42
        PopupWindow r1 = r10.b;     // Catch: Throwable -> L42
        if (r1 == null) goto L21;
        Integer r7 = Integer.valueOf(r1.getWidth());     // Catch: Throwable -> L42
    L22:
        r4.append(r7);     // Catch: Throwable -> L42
        r4.append(", popupHeight=");     // Catch: Throwable -> L42
        PopupWindow r8 = r10.b;     // Catch: Throwable -> L42
        if (r8 == null) goto L25;
        Integer r9 = Integer.valueOf(r8.getHeight());     // Catch: Throwable -> L42
    L26:
        r4.append(r9);     // Catch: Throwable -> L42
        r6.i("ObricUpdateBannerPopupWindow", r4.toString());     // Catch: Throwable -> L42
        PopupWindow r13 = r10.b;     // Catch: Throwable -> L42
        if (r13 == null) goto L40;
        int r12 = r10.d;     // Catch: Throwable -> L42
        int r14 = -r10.e;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r13) == false) goto L32;
        r13.update(r18, r12, r14, r19, r20);     // Catch: Throwable -> L42
    L35:
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L42
        goto L40
    L32:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r13, r18, r12, r14, r19, r20) == true) goto L35;
        r13.update(r18, r12, r14, r19, r20);     // Catch: Throwable -> L42
    L40:
        Object r0 = Result.constructor-impl(r11);     // Catch: Throwable -> L42
    L44:
        Throwable r15 = Result.exceptionOrNull-impl(r0);
        if (r15 == null) goto L76;
        FLogger.a.e("ObricUpdateBannerPopupWindow", "updatePosition error, hostId=" + r10.a + ": " + r15.getMessage());
        return;
    L76:
        return;
    L25:
        r9 = null;
        goto L26
    L21:
        r7 = null;
        goto L22
    L36:
        StringBuilder r17 = new StringBuilder("updatePosition skipped, hostId=");     // Catch: Throwable -> L42
        r17.append(r10.a);     // Catch: Throwable -> L42
        r17.append(", isShowing=");     // Catch: Throwable -> L42
        PopupWindow r22 = r10.b;     // Catch: Throwable -> L42
        if (r22 == null) goto L39;
        r11 = Boolean.valueOf(r22.isShowing());     // Catch: Throwable -> L42
    L39:
        r17.append(r11);     // Catch: Throwable -> L42
        r17.append(", anchor=");     // Catch: Throwable -> L42
        r17.append(ObricUpdateBannerPopupWindow.j(r18));     // Catch: Throwable -> L42
        r6.i("ObricUpdateBannerPopupWindow", r17.toString());     // Catch: Throwable -> L42
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L42
        goto L40
    L14:
        if (r3.isShowing() != true) goto L16;
        r16 = true;
    L42:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L48:
        FLogger r24 = FLogger.a;
        StringBuilder r25 = new StringBuilder("updateBannerPosition skipped, hostId=");
        r25.append(r21);
        r25.append(", hasWindow=");
        if (r10 == null) goto L51;
        boolean r26 = true;
    L52:
        r25.append(r26);
        r25.append(", isShowing=");
        if (r10 == null) goto L55;
        r11 = Boolean.valueOf(r10.f());
    L55:
        r25.append(r11);
        r25.append(", anchor=");
        r25.append(q(r18));
        r24.i("ObricBannerService", r25.toString());
        if (j.b() == false) goto L77;
        Intrinsics.checkNotNullParameter(r18, "container");
        PopupWindow r27 = j.a;
        if (r27 != null) goto L60;
    L62:
        boolean r28 = false;
    L63:
        if (r28 == false) goto L78;
        PopupWindow r110 = j.a;
        if (r110 == null) goto L79;
        int r111 = j.c;
        int r112 = -j.d;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r110) == false) goto L70;
        r110.update(r18, r111, r112, r19, r20);
        return;
    L70:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r110, r18, r111, r112, r19, r20) == true) goto L81;
        r110.update(r18, r111, r112, r19, r20);
        return;
    L81:
        return;
    L79:
        return;
    L78:
        return;
    L60:
        if (r27.isShowing() != true) goto L62;
        r28 = true;
        goto L63
    L77:
        return;
    L51:
        r26 = false;
        goto L52
    L5:
        if (r10.f() != true) goto L7;
        r5 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v70, types: [sba.e] */
    /* JADX WARN: Type inference failed for: r14v19, types: [sba.f] */
    /* JADX WARN: Type inference failed for: r15v2, types: [sba.g] */
    /* JADX WARN: Type inference failed for: r1v7, types: [sba.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [sba.c] */
    @Override // com.obric.assistant.banner.IObricBannerService
    public final boolean f(final Activity r31, final View r32, final tba.b r33, final String r34) {
        Intrinsics.checkNotNullParameter(r31, "context");
        Intrinsics.checkNotNullParameter(r32, "anchorView");
        Intrinsics.checkNotNullParameter(r33, "banner");
        Intrinsics.checkNotNullParameter(r34, "hostId");
        FLogger r12 = FLogger.a;
        r12.i("ObricBannerService", "showBanner start, hostId=" + r34 + ", bannerType=" + r33.a + ", anchor=" + q(r32) + ", banner=" + r33);
        if (h(r34, r32, r33.a, r33) == true) goto L10;
        r12.i("ObricBannerService", "showBanner blocked, hostId=" + r34 + ", banner=" + r33);
        if (r33.a != 1) goto L9;
        JSONObject r0 = new JSONObject();
        r0.put("banner_is_show", n(r34, null));
        r0.put("global_banner_is_show", m());
        r0.put("banner_host_id", r34);
        Unit r1 = Unit.INSTANCE;
        IObricUpdateService r2 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r2 == null) goto L9;
        r2.a("blocked", "can_not_show_banner", r0);
    L9:
        return false;
    L10:
        int r3 = r33.a;
        if (r3 == 1) goto L36;
        if (r3 == 2) goto L14;
        return true;
    L14:
        PopupWindow r4 = j.a;
        String r13 = r33.b;
        String r14 = r33.c;
        ?? r5 = new e(r33);
        ?? r15 = new f(r33);
        ?? r16 = new g(this, r31, r32, r33, r34);
        Intrinsics.checkNotNullParameter(r31, "context");
        Intrinsics.checkNotNullParameter(r32, "anchorView");
        if (r31.isFinishing() == false) goto L17;
    L32:
        PopupWindow r17 = null;
    L33:
        if (r17 == null) goto L152;
        this.c = Integer.valueOf(r33.a);
        return true;
    L152:
        return true;
    L17:
        if (r31.isDestroyed() == true) goto L32;
        View r6 = LayoutInflater.from(r31).inflate(2131563929, null, false);
        r6.setClipToOutline(true);
        r6.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        Resources r7 = r31.getResources();
        j.b = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).widthPixels;
        Resources r8 = r31.getResources();
        j.c = (int) TypedValue.applyDimension(1, 0.0f, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()));
        Resources r9 = r31.getResources();
        j.d = (int) TypedValue.applyDimension(1, 24.0f, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()));
        Resources r10 = r31.getResources();
        j.e = (int) TypedValue.applyDimension(1, 112.0f, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()));
        PopupWindow r11 = new PopupWindow(r31);
        r11.setContentView(r6);
        r11.setWidth(j.b - (j.c * 2));
        r11.setHeight(j.e);
        r11.setOutsideTouchable(false);
        r11.setFocusable(false);
        r11.setClippingEnabled(true);
        r11.setBackgroundDrawable(new ColorDrawable(0));
        r11.setAnimationStyle(0);
        r11.update();
        j.a = r11;
        r11.setOnDismissListener(new com.obric.assistant.view.f(r16));
        if (r13 == null) goto L23;
        ((TextView) r6.findViewById(2131381157)).setText(r13);
    L23:
        if (r14 == null) goto L25;
        ((TextView) r6.findViewById(2131381151)).setText(r14);
    L25:
        ((TextView) r6.findViewById(2131381151)).setOnClickListener(new com.obric.assistant.view.g(r5, r6));
        r6.findViewById(2131381153).setOnClickListener(new h(r15));
        PopupWindow r18 = j.a;
        if (r18 == null) goto L31;
        int r19 = j.c;
        int r20 = -j.d;
        OverlaySource r21 = PopupWindowLancet.resolveSource(r32);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r18, r32, r21) == true) goto L31;
        r18.showAsDropDown(r32, r19, r20);
        PopupWindowLancet.trackAfterShow(r18, r21, r32);
    L31:
        r32.addOnAttachStateChangeListener(new i(r32));
        r17 = j.a;
        goto L33
    L36:
        ObricUpdateBannerPopupWindow r22 = this.b.get(r34);
        if (r22 == null) goto L39;
        r22.c();
    L39:
        ObricUpdateBannerPopupWindow r110 = new ObricUpdateBannerPopupWindow(r34);
        this.b.put(r34, r110);
        IObricUpdateService r23 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r23 == null) goto L42;
        r23.a("success", null, null);
    L42:
        Function1 r24 = new sba.b(r34, r33);
        ?? r25 = new c(r34, r33, this);
        ?? r26 = new d(this, r31, r32, r33, r34);
        Intrinsics.checkNotNullParameter(r31, "activity");
        Intrinsics.checkNotNullParameter(r32, "anchorView");
        if (r31.isFinishing() == false) goto L45;
    L148:
        r12.i("ObricUpdateBannerPopupWindow", "show skipped, hostId=" + r110.a + ", finishing=" + r31.isFinishing() + ", destroyed=" + r31.isDestroyed() + ", anchor=" + ObricUpdateBannerPopupWindow.j(r32));
        return true;
    L45:
        if (r31.isDestroyed() == true) goto L148;
        r110.c();
        ConstraintLayout r27 = LayoutInflater.from(r31).inflate(2131564053, null, false);
        ConstraintLayout r28 = ViewBindings.findChildViewById(r27, 2131373991);
        if (r28 == null) goto L145;
        TextView r29 = (TextView) ViewBindings.findChildViewById(r27, 2131381151);
        if (r29 == null) goto L144;
        ImageView r210 = (ImageView) ViewBindings.findChildViewById(r27, 2131381153);
        if (r210 == null) goto L143;
        ConstraintLayout r211 = ViewBindings.findChildViewById(r27, 2131381154);
        if (r211 != null) goto L56;
        int r111 = 2131381154;
    L147:
        throw new NullPointerException("Missing required view with ID: ".concat(r27.getResources().getResourceName(r111)));
    L56:
        if (((TextView) ViewBindings.findChildViewById(r27, 2131381155)) == null) goto L141;
        CustomUpdateCircleProgressBar r212 = (CustomUpdateCircleProgressBar) ViewBindings.findChildViewById(r27, 2131381156);
        if (r212 == null) goto L140;
        ProgressBar r213 = (ProgressBar) ViewBindings.findChildViewById(r27, 2131381203);
        if (r213 != null) goto L62;
        r111 = 2131381203;
        goto L147
    L62:
        if (((TextView) ViewBindings.findChildViewById(r27, 2131381269)) != null) goto L64;
        r111 = 2131381269;
        goto L147
    L64:
        if (((ImageView) ViewBindings.findChildViewById(r27, 2131381270)) == null) goto L137;
        TextView r214 = (TextView) ViewBindings.findChildViewById(r27, 2131381271);
        if (r214 == null) goto L136;
        TextView r215 = (TextView) ViewBindings.findChildViewById(r27, 2131381272);
        if (r215 == null) goto L135;
        ConstraintLayout r216 = ViewBindings.findChildViewById(r27, 2131381273);
        if (r216 == null) goto L134;
        ConstraintLayout r30 = r27;
        r110.g = new ObricUpdateBannerBinding(r30, r28, r29, r210, r211, r212, r213, r214, r215, r216);
        if (r30 == null) goto L75;
        r30.setClipToOutline(true);
        r30.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
    L75:
        if (r31.getResources().getConfiguration().orientation != 2) goto L77;
        boolean r35 = true;
    L78:
        if (r35 == true) goto L80;
        Resources r36 = r31.getResources();
        int r37 = WindowDisplayMetricsOverride.apply(r36, r36.getDisplayMetrics()).widthPixels;
    L84:
        r110.c = r37;
        Resources r38 = r31.getResources();
        r110.d = (int) TypedValue.applyDimension(1, 0.0f, WindowDisplayMetricsOverride.apply(r38, r38.getDisplayMetrics()));
        Resources r39 = r31.getResources();
        r110.e = (int) TypedValue.applyDimension(1, 24.0f, WindowDisplayMetricsOverride.apply(r39, r39.getDisplayMetrics()));
        Resources r40 = r31.getResources();
        r110.f = (int) TypedValue.applyDimension(1, 112.0f, WindowDisplayMetricsOverride.apply(r40, r40.getDisplayMetrics()));
        PopupWindow r41 = new PopupWindow(r31);
        ObricUpdateBannerBinding r42 = r110.g;
        if (r42 == null) goto L87;
        ConstraintLayout r43 = r42.a;
    L88:
        r41.setContentView(r43);
        r41.setWidth(r110.c - (r110.d * 2));
        r41.setHeight(r110.f);
        r41.setOutsideTouchable(false);
        r41.setFocusable(false);
        r41.setClippingEnabled(true);
        r41.setBackgroundDrawable(new ColorDrawable(0));
        r41.setAnimationStyle(0);
        r41.update();
        r110.b = r41;
        StringBuilder r44 = new StringBuilder("show prepare, hostId=");
        r44.append(r110.a);
        r44.append(", isLandscape=");
        r44.append(r35);
        r44.append(", displayWidth=");
        Resources r45 = r31.getResources();
        r44.append(WindowDisplayMetricsOverride.apply(r45, r45.getDisplayMetrics()).widthPixels);
        r44.append(", screenWidth=");
        r44.append(r110.c);
        r44.append(", marginPx=");
        r44.append(r110.d);
        r44.append(", marginPy=");
        r44.append(r110.e);
        r44.append(", heightInPx=");
        r44.append(r110.f);
        r44.append(", popupWidth=");
        PopupWindow r46 = r110.b;
        if (r46 == null) goto L91;
        Integer r47 = Integer.valueOf(r46.getWidth());
    L92:
        r44.append(r47);
        r44.append(", popupHeight=");
        PopupWindow r48 = r110.b;
        if (r48 == null) goto L95;
        Integer r49 = Integer.valueOf(r48.getHeight());
    L96:
        r44.append(r49);
        r44.append(", anchor=");
        r44.append(ObricUpdateBannerPopupWindow.j(r32));
        r12.i("ObricUpdateBannerPopupWindow", r44.toString());
        r110.h();
        ObricUpdateBannerBinding r50 = r110.g;
        if (r50 == null) goto L101;
        ConstraintLayout r51 = r50.b;
        if (r51 == null) goto L101;
        sba.b r52 = r24;
        r51.setOnClickListener(new w(r110, r52));
        sba.b r53 = r52;
    L102:
        ObricUpdateBannerBinding r54 = r110.g;
        if (r54 == null) goto L107;
        ConstraintLayout r55 = r54.e;
        if (r55 == null) goto L107;
        r55.setOnClickListener(new y(r110, r53));
    L107:
        ObricUpdateBannerBinding r56 = r110.g;
        if (r56 == null) goto L112;
        CustomUpdateCircleProgressBar r57 = r56.f;
        if (r57 == null) goto L112;
        r57.setOnClickListener(new z(r110, r53));
    L112:
        ObricUpdateBannerBinding r58 = r110.g;
        if (r58 == null) goto L117;
        ImageView r59 = r58.d;
        if (r59 == null) goto L117;
        r59.setOnClickListener(new a0(r110, r31, r25));
    L117:
        IObricUpdateService r60 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r60 == null) goto L120;
        r60.f(r110.j);
    L120:
        PopupWindow r61 = r110.b;
        if (r61 == null) goto L123;
        r61.setOnDismissListener(new b0(r110, r32, r26));
    L123:
        PopupWindow r62 = r110.b;
        if (r62 == null) goto L129;
        int r63 = r110.d;
        int r64 = -r110.e;
        OverlaySource r65 = PopupWindowLancet.resolveSource(r32);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r62, r32, r65) == true) goto L129;
        r62.showAsDropDown(r32, r63, r64);
        PopupWindowLancet.trackAfterShow(r62, r65, r32);
    L129:
        StringBuilder r66 = new StringBuilder("show done, hostId=");
        r66.append(r110.a);
        r66.append(", isShowing=");
        PopupWindow r67 = r110.b;
        if (r67 == null) goto L132;
        Boolean r112 = Boolean.valueOf(r67.isShowing());
    L133:
        r66.append(r112);
        r66.append(", anchor=");
        r66.append(ObricUpdateBannerPopupWindow.j(r32));
        r12.i("ObricUpdateBannerPopupWindow", r66.toString());
        r110.h = r32;
        h0 r68 = new h0(r110);
        r32.addOnAttachStateChangeListener(r68);
        r110.i = r68;
        return true;
    L132:
        r112 = null;
    L101:
        r53 = r24;
        goto L102
    L95:
        r49 = null;
        goto L96
    L91:
        r47 = null;
        goto L92
    L87:
        r43 = null;
        goto L88
    L80:
        View r69 = r32.getRootView();
        if (r69 == null) goto L83;
        r37 = r69.getWidth();
        goto L84
    L83:
        r37 = 0;
        goto L84
    L77:
        r35 = false;
        goto L78
    L134:
        r111 = 2131381273;
        goto L147
    L135:
        r111 = 2131381272;
        goto L147
    L136:
        r111 = 2131381271;
        goto L147
    L137:
        r111 = 2131381270;
        goto L147
    L140:
        r111 = 2131381156;
        goto L147
    L141:
        r111 = 2131381155;
        goto L147
    L143:
        r111 = 2131381153;
        goto L147
    L144:
        r111 = 2131381151;
        goto L147
    L145:
        r111 = 2131373991;
        goto L147
    }

    public final boolean h(String r11, View r12, int r13, tba.b r14) {
        boolean r3 = false;
        if (r13 >= 0) goto L7;
        FLogger.a.i("ObricBannerService", "canShowBanner false, hostId=" + r11 + ", bannerType=" + r13 + ", reason=tip_type_invalid");
        return false;
    L7:
        if (l(r13) == true) goto L10;
        FLogger.a.i("ObricBannerService", "canShowBanner false, hostId=" + r11 + ", bannerType=" + r13 + ", reason=frequency_control");
        return false;
    L10:
        Function0<Boolean> r4 = r14.g;
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L19;
        FLogger.a.i("ObricBannerService", "bannerType:" + r13 + ", canShowBanner:false, data.canShow false");
        return false;
    L19:
        int r6 = j(r13);
        PriorityQueue<Pair<Integer, Integer>> r7 = this.e;
        if ((r7 instanceof Collection) == true) goto L22;
    L24:
        Iterator<Pair<Integer, Integer>> r8 = r7.iterator();
    L26:
        if (r8.hasNext() == false) goto L33;
        if (((Number) r8.next().getFirst()).intValue() != r13) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L26;
        boolean r10 = true;
    L34:
        if (r10 == false) goto L36;
        this.f.put(Integer.valueOf(r13), r14);
    L37:
        FLogger r15 = FLogger.a;
        r15.i("ObricBannerService", "forbiddenShowBanner:" + r13 + ", can forbiddenShowBanner false");
        String r16 = null;
        if (n(r11, Integer.valueOf(r13)) == false) goto L44;
        StringBuilder r17 = new StringBuilder("canShowBanner false, hostId=");
        r17.append(r11);
        r17.append(", bannerType=");
        r17.append(r13);
        r17.append(", reason=same_host_showing, anchor=");
        if (r12 == null) goto L42;
        r16 = q(r12);
    L42:
        r17.append(r16);
        r17.append(", globalShowing=");
        r17.append(m());
        r15.i("ObricBannerService", r17.toString());
        return false;
    L44:
        int r18 = j(r13);
        PriorityQueue<Pair<Integer, Integer>> r0 = this.e;
        ArrayList r19 = new ArrayList();
        Iterator<Pair<Integer, Integer>> r1 = r0.iterator();
    L46:
        if (r1.hasNext() == false) goto L50;
        Pair<Integer, Integer> r20 = r1.next();
        if (l(((Number) r20.getFirst()).intValue()) == false) goto L46;
        r19.add(r20);
        goto L46
    L50:
        Iterator r2 = r19.iterator();
        if (r2.hasNext() == true) goto L53;
        Integer r21 = null;
    L59:
        if (r21 == null) goto L61;
        int r22 = r21.intValue();
    L62:
        if (r18 < r22) goto L64;
        r3 = true;
    L64:
        FLogger r110 = FLogger.a;
        StringBuilder r23 = new StringBuilder("canShowBanner ");
        r23.append(r3);
        r23.append(", hostId=");
        r23.append(r11);
        r23.append(", bannerType=");
        r23.append(r13);
        r23.append(", anchor=");
        if (r12 == null) goto L67;
        r16 = q(r12);
    L67:
        r23.append(r16);
        r23.append(", globalShowing=");
        r23.append(m());
        r110.i("ObricBannerService", r23.toString());
        return r3;
    L61:
        r22 = Integer.MIN_VALUE;
        goto L62
    L53:
        r21 = Integer.valueOf(((Number) ((Pair) r2.next()).getSecond()).intValue());
    L55:
        if (r2.hasNext() == false) goto L59;
        Integer r24 = Integer.valueOf(((Number) ((Pair) r2.next()).getSecond()).intValue());
        if (r21.compareTo(r24) >= 0) goto L55;
        r21 = r24;
        goto L55
    L36:
        FLogger r25 = FLogger.a;
        r25.i("ObricBannerService", "registerBanner, " + r13 + ", " + r6 + ", " + r14);
        this.e.offer(new Pair(Integer.valueOf(r13), Integer.valueOf(r6)));
        this.f.put(Integer.valueOf(r13), r14);
        StringBuilder r111 = new StringBuilder("registerBanner, currentBannersPriorityQueue: ");
        r111.append(this.e);
        r25.i("ObricBannerService", r111.toString());
        goto L37
    L30:
        r9 = false;
    L33:
        r10 = false;
        goto L34
    L22:
        if (r7.isEmpty() == false) goto L24;
    L13:
        if (((Boolean) r4.invoke()).booleanValue() == true) goto L15;
        r5 = true;
        goto L16
    }

    public final void o(Activity r6, View r7, @com.obric.assistant.banner.bean.ObricBannerType int r8, String r9) {
        FLogger r0 = FLogger.a;
        r0.i("ObricBannerService", "popupWindow dismissed, hostId=" + r9 + ", type=" + r8);
        if (r8 != 1) goto L5;
        this.b.remove(r9);
    L5:
        Integer r3 = this.c;
        if (r3 != null) goto L9;
    L11:
        p(this.e, r8);
        this.f.remove(Integer.valueOf(r8));
        int r10 = this.d;
        if (r10 <= 0) goto L15;
        this.d = r10 - 1;
        return;
    L15:
        r0.i("ObricBannerService", "showNextBanner, hostId=" + r9 + ", queue=" + this.e);
    L17:
        if ((!this.e.isEmpty()) == false) goto L28;
        Pair<Integer, Integer> r11 = this.e.peek();
        if (r11 == null) goto L28;
        tba.b r1 = this.f.get(r11.getFirst());
        if (r1 == null) goto L23;
        if (h(r9, r7, ((Number) r11.getFirst()).intValue(), r1) == true) goto L26;
        this.e.remove();
        this.f.remove(r11.getFirst());
        goto L17
    L26:
        f(r6, r7, r1, r9);
        return;
    L23:
        this.e.remove();
    L28:
        FLogger.a.i("ObricBannerService", "showNextBanner, no available to show, hostId=" + r9 + ", queue=" + this.e);
        return;
    L9:
        if (r3.intValue() != r8) goto L11;
        this.c = null;
        goto L11
    }
}
