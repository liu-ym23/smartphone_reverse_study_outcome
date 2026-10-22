package sy1;

import android.os.Build;
import android.view.View;
import com.bytedance.android.live.browser.jsbridge.base.RevenueHybridHiddenResultModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import w20.m5;
import w20.pd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends m5<pd, RevenueHybridHiddenResultModel> {
    public static final ReadOnlyProperty a = null;
    public static final a b = null;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_GROUP_CONTAINER_JSB_SUPPORT_DEVICES", "getLIVE_GROUP_CONTAINER_JSB_SUPPORT_DEVICES()Ljava/util/List;", 0))};
        }

        public a() {
        }
    }

    static {
        b = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_container_jsb_support_devices", CollectionsKt.listOf("realme"), nn3.a.c, false);
        KProperty r10 = a.a[0];
        a = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
    }

    public b() {
    }

    public final void invoke(Object r10, CallContext r11) {
        pd r13 = (pd) r10;
        Intrinsics.checkNotNullParameter(r13, "param");
        Intrinsics.checkNotNullParameter(r11, "context");
        View r14 = r11.d;
        if (r14 == null) goto L47;
        View r15 = r14.getRootView();
        if (r15 == null) goto L50;
        a r0 = b;
        r0.getClass();
        boolean r3 = false;
        Iterator r1 = ((List) a.getValue(r0, a.a[0])).iterator();     // Catch: Throwable -> L31
    L9:
        Object r4 = null;
        if (r1.hasNext() == false) goto L29;
        Object r2 = r1.next();     // Catch: Throwable -> L31
        String r5 = (String) r2;     // Catch: Throwable -> L31
        String r6 = Build.MODEL;     // Catch: Throwable -> L31
        if (r6 == null) goto L28;
        if (StringsKt.contains$default(r6.toLowerCase(), r5, false, 2, null) == true) goto L24;
        String r7 = Build.MANUFACTURER;     // Catch: Throwable -> L31
        if (r7 == null) goto L23;
        if (StringsKt.startsWith$default(r7.toLowerCase(), r5, false, 2, null) == true) goto L24;
        boolean r8 = false;
    L25:
        if (r8 == false) goto L9;
        r4 = r2;
        goto L29
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L31
    L24:
        r8 = true;
        goto L25
    L28:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L31
    L29:
        if (r4 == null) goto L32;
        r3 = true;
    L32:
        if (r3 == false) goto L35;
        RevenueHybridHiddenResultModel r16 = new RevenueHybridHiddenResultModel();
        r16.a(RevenueHybridHiddenResultModel.Code.Failed);
        Unit r17 = Unit.INSTANCE;
        finishWithResult(r16);
        return;
    L35:
        if (Intrinsics.areEqual(r13.a(), Boolean.TRUE) == false) goto L37;
        UtilityKotlinExtentionsKt.t(r15);
        r15.setTranslationY(RangesKt.coerceAtLeast(s1.y(), s1.w()) * 2.0f);
        RxUtilKt.g(r15, true).subscribe(new c(r15));
        return;
    L37:
        r15.setTranslationY(0.0f);
        UtilityKotlinExtentionsKt.w(r15);
        return;
    L50:
        return;
    }
}
