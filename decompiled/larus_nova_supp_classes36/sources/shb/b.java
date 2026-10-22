package shb;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zsb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    static {
    }

    public static boolean b(Notice r12) {
        if (r12.shouldNotify == true) goto L5;
        return false;
    L5:
        AppLifecycle r2 = AppLifecycle.a.a;
        if (r2.h() == true) goto L8;
        return true;
    L8:
        Boolean r4 = null;
        qza.a r6 = (qza.a) LarkContext.spiByDwarf(qza.a.class);     // Catch: Throwable -> L11
    L13:
        if (r6 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r6 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        boolean r9 = FeatureGatingModule.getFeatureGatingService().isEnable("feidou.push.online_display_optimize");
        if (r7 == true) goto L29;
        if (r8 == false) goto L28;
        if (r9 == false) goto L29;
    L28:
        boolean r10 = false;
    L30:
        thb.a.b("NotificationShowUtil", "[Flow Push notify] host page strategy, isSideBarVisible: " + r7 + ", isFlowNativeBotChatVisible: " + r8 + ", isOnlineDisplayOptimizeEnabled: " + r9 + ", shouldBlock: " + r10);
        if (r10 == false) goto L33;
        return false;
    L33:
        FragmentActivity r3 = r2.f();
        if (r3 != null) goto L36;
    L68:
        return true;
    L36:
        if ((r3 instanceof d) == false) goto L40;
        boolean r13 = ((d) r3).Cy(r12);
        thb.a.b("NotificationShowUtil", "[Flow Push notify] IPushNotifyStrategy logic, isShouldShow: " + r13);
        return r13;
    L40:
        if ((r3 instanceof FragmentActivity) == false) goto L42;
        FragmentActivity r5 = r3;
    L43:
        if (r5 == null) goto L56;
        List r11 = r5.getSupportFragmentManager().getFragments();
        if ((r11 instanceof Collection) == true) goto L48;
    L50:
        Iterator r14 = r11.iterator();
    L52:
        if (r14.hasNext() == false) goto L56;
        Fragment r15 = (Fragment) r14.next();
        Intrinsics.checkNotNull(r15);
        if (a(r15, r12) == false) goto L52;
        boolean r16 = true;
    L69:
        qza.a r17 = (qza.a) LarkContext.spiByDwarf(qza.a.class);     // Catch: Throwable -> L59
    L61:
        if (r17 == null) goto L63;
        r4 = Boolean.valueOf(r17.Q());
    L63:
        if (r16 == false) goto L65;
    L66:
        thb.a.b("NotificationShowUtil", "[Flow Push notify] hasTargetChatFragment: " + r16 + ", isFeedFragmentVisible:" + r4);
        return false;
    L65:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L68;
    L59:
        th = move-exception;
        Log.e("NotificationShowUtil", "spiByDwarf(IOfficeSDKNotificationApi) failed", th);
        r17 = null;
        goto L61
    L48:
        if (r11.isEmpty() == false) goto L50;
    L56:
        r16 = false;
        goto L69
    L42:
        r5 = null;
    L29:
        r10 = true;
        goto L30
    L20:
        if (r6.m() != true) goto L22;
        r8 = true;
        goto L23
    L15:
        if (r6.n() != true) goto L17;
        r7 = true;
    L11:
        th = move-exception;
        Log.e("NotificationShowUtil", "spiByDwarf(IOfficeSDKNotificationApi) failed", th);
        r6 = null;
        goto L13
    }

    public static boolean a(Fragment r2, Notice r3) {
        if ((r2 instanceof d) == true) goto L5;
        List r4 = r2.getChildFragmentManager().getFragments();
        if ((r4 instanceof Collection) == true) goto L9;
    L11:
        Iterator r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        Fragment r0 = (Fragment) r5.next();
        Intrinsics.checkNotNull(r0);
        if (a(r0, r3) == false) goto L13;
        return true;
    L17:
        return false;
    L9:
        if (r4.isEmpty() == false) goto L11;
    L5:
        return !((d) r2).Cy(r3);
    }
}
