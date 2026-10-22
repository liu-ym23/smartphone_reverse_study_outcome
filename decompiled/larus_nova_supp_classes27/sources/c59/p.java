package c59;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.dynamic.dsl.DslActionTrackerEvent;
import com.larus.dora.impl.dynamic.dsl.DslActionType;
import com.larus.dora.impl.dynamic.dsl.DslActorFactory;
import com.larus.dora.impl.dynamic.dsl.DslBizCondition;
import com.larus.dora.impl.dynamic.dsl.DslIdentifierType;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.h.HResourceVersion;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.j0;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.minor.api.IMinorService;
import com.larus.utils.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p {
    public static final String b(t r9) {
        String r0 = null;
        if (r9 == null) goto L51;
        int r1 = n1.a;
        Application r2 = AppHost.a.getApplication();
        Map r3 = d0.a();
        Intrinsics.checkNotNullParameter(r2, "context");
        DslIdentifierType r4 = r9.getType();
        String r5 = r9.b();
        if (r5 != null) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L55;
        if (r4 != null) goto L11;
        int r6 = -1;
    L12:
        boolean r7 = false;
        if (r6 != 1) goto L15;
        if (r3 == null) goto L35;
        r0 = (String) r3.get(r9.b());
    L35:
        if (r0 != null) goto L37;
    L40:
        boolean r8 = true;
    L41:
        if (r8 == false) goto L57;
        g49.d.b("Dsl getString", "starling value is empty, key = " + r9);
        String r10 = n1.f(r2, r5);
        if (r10.length() <= 0) goto L46;
        r7 = true;
    L46:
        if (r7 == true) goto L58;
        String r11 = r9.a();
    L50:
        return r11;
    L58:
        return r10;
    L57:
        return r0;
    L37:
        if (r0.length() == 0) goto L40;
        r8 = false;
        goto L41
    L15:
        if (r6 == 2) goto L17;
        g49.d.b("Dsl getString", "unknown type");
        return null;
    L17:
        String r12 = n1.f(r2, r5);
        if (r12.length() <= 0) goto L20;
        boolean r13 = true;
    L21:
        if (r13 == true) goto L54;
        g49.d.b("Dsl getString", "string value is empty, key = " + r9);
        if (r3 == null) goto L26;
        r0 = (String) r3.get(r9.b());
    L26:
        if (r0 != null) goto L28;
    L29:
        r7 = true;
    L30:
        if (r7 == false) goto L56;
        r11 = r9.a();
        goto L50
    L56:
        return r0;
    L28:
        if (r0.length() != 0) goto L30;
    L54:
        return r12;
    L20:
        r13 = false;
        goto L21
    L11:
        r6 = n1.a.a[r4.ordinal()];
        goto L12
    L55:
        return null;
    L51:
        return null;
    }

    public static final void f(b r3) {
        if (r3 == null) goto L12;
        c r4 = r3.d();
        if (r4 == null) goto L13;
        DslActionTrackerEvent r0 = r4.a();
        if (r0 == null) goto L14;
        g49.d.d("DslActionTracker", "reportAction: event=" + r0);
        DoraBuryPointManager r1 = DoraBuryPointManager.a;
        String r2 = r0.getEventName().toLowerCase(Locale.ROOT);
        Map<String, Object> r5 = r4.b();
        if (r5 != null) goto L10;
        r5 = MapsKt.emptyMap();
    L10:
        r1.L(r2, r5);
        return;
    L14:
        return;
    L13:
        return;
    }

    public static final boolean a(b r3, Context r4, CoroutineScope r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "lifecycleScope");
        boolean r0 = false;
        if (r3 != null) goto L5;
        return false;
    L5:
        int r1 = DslActorFactory.a;
        Intrinsics.checkNotNullParameter(r3, "action");
        DslActionType r2 = r3.getType();
        if (r2 != null) goto L8;
        int r7 = -1;
    L10:
        if (r7 != 1) goto L12;
    L20:
        d r8 = new e(r3);
    L21:
        if (r8 == null) goto L23;
        r0 = r8.a(r4, r5);
    L23:
        f(r3);
        if (r0 == false) goto L28;
        b r9 = r3.c();
        if (r9 == null) goto L31;
        a(r9, r4, r5, r6);
    L31:
        return r0;
    L28:
        b r10 = r3.b();
        if (r10 == null) goto L31;
        a(r10, r4, r5, r6);
        goto L31
    L12:
        if (r7 == 2) goto L20;
        if (r7 != 3) goto L16;
        r8 = new f(r3);
        goto L21
    L16:
        if (r7 == 4) goto L18;
        r8 = null;
        goto L21
    L18:
        r8 = new com.larus.dora.impl.dynamic.dsl.a(r3);
        goto L21
    L8:
        r7 = DslActorFactory.a.a[r2.ordinal()];
        goto L10
    }

    public static final void d(SimpleDraweeView r10, u r11, Map<String, String> r12, Integer r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == null) goto L11;
        String r0 = r11.a();
        if (r0 == null) goto L11;
        Resources r1 = r10.getContext().getResources();
        if (r1 == null) goto L11;
        int r2 = r1.getIdentifier("larus_".concat(r0), "drawable", r10.getContext().getPackageName());
        if (r2 == 0) goto L11;
        GenericDraweeHierarchyBuilder r3 = GenericDraweeHierarchyBuilder.newInstance(r10.getContext().getResources());
        r3.setPlaceholderImage(r2);
        r3.setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        r10.setHierarchy(r3.build());
    L11:
        boolean r4 = v19.h.a;
        boolean r5 = v19.h.b(r10.getContext());
        if (r5 == false) goto L17;
        if (r11 == null) goto L21;
        b0 r6 = r11.b();
        if (r6 == null) goto L21;
        List<String> r7 = r6.a();
    L23:
        if (r5 == false) goto L37;
        List<String> r8 = r7;
        if (r8 != null) goto L27;
    L30:
        boolean r9 = true;
    L31:
        if (r9 == false) goto L37;
        if (r11 == null) goto L36;
        b0 r14 = r11.b();
        if (r14 == null) goto L36;
        r7 = r14.b();
    L36:
        r7 = null;
        goto L37
    L27:
        if (r8.isEmpty() == true) goto L30;
        r9 = false;
    L37:
        if (r7 == null) goto L41;
        List r15 = CollectionsKt.filterNotNull(r7);
        if (r15 == null) goto L41;
        String r16 = (String) CollectionsKt.firstOrNull(r15);
    L42:
        if (r12 == null) goto L54;
        Iterator<Map.Entry<String, String>> r17 = r12.entrySet().iterator();
    L44:
        String r18 = r16;
    L46:
        if (r17.hasNext() == false) goto L55;
        Map.Entry<String, String> r110 = r17.next();
        String r20 = r110.getKey();
        String r111 = r110.getValue();
        if (r18 != null) goto L49;
        r18 = null;
        goto L46
    L49:
        String r21 = "${" + r20 + '}';
        if (r111 != null) goto L52;
        r111 = "";
    L52:
        r16 = StringsKt.replace$default(r18, r21, r111, false, 4, null);
    L55:
        if (r18 == null) goto L68;
        int r112 = com.larus.dora.impl.util.t.a;
        int r113 = l59.a.a;
        Intrinsics.checkNotNullParameter(r18, "link");
        HResourceVersion r114 = HResourceVersion.DEVICE_LIST_PAGE_VERSION;
        if (StringsKt.contains$default(r18, r114.getKey(), false, 2, null) == false) goto L59;
        r18 = StringsKt.replace$default(r18, r114.getKey(), r114.getValue(), false, 4, null);
    L62:
        ImageLoaderKt.u(r10, com.larus.dora.impl.util.t.a(r13, r18), "dora_dynamic_img_biz");
        return;
    L59:
        HResourceVersion r115 = HResourceVersion.BIND_PAGE_VERSION;
        if (StringsKt.contains$default(r18, r115.getKey(), false, 2, null) == false) goto L62;
        r18 = StringsKt.replace$default(r18, r115.getKey(), r115.getValue(), false, 4, null);
        goto L62
    L68:
        return;
    L54:
        r18 = r16;
    L41:
        r16 = null;
    L21:
        r7 = null;
        goto L23
    L17:
        if (r11 == null) goto L21;
        b0 r22 = r11.b();
        if (r22 == null) goto L21;
        r7 = r22.b();
        goto L23
    }

    public static final boolean c(j r8, String r9, Integer r10, String r11, String r12) {
        boolean r0 = true;
        if (r8 != null) goto L5;
        return true;
    L5:
        g49.d.d("DslCondition", "isConditionMet: bizConditions=" + r8.a() + ", supportAbilities=" + r8.c());
        List<DslBizCondition> r1 = r8.a();
        if (r1 == null) goto L122;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L122;
        DslBizCondition r4 = (DslBizCondition) r2.next();
        if (r4 == null) goto L107;
        DoraSetting.a.getClass();
        int r5 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new j0())).booleanValue() == true) goto L164;
        boolean r6 = true;
    L25:
        if (r4 != DslBizCondition.SUPPORT_INTERPRETATION) goto L39;
        if (r11 == null) goto L118;
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L34;
        DeviceService r13 = r7.device();
        if (r13 == null) goto L34;
        if (r13.m0("translate", r11) != true) goto L34;
        boolean r14 = true;
    L35:
        if (r14 == false) goto L118;
        if (r6 == false) goto L118;
    L34:
        r14 = false;
    L118:
        boolean r15 = false;
    L119:
        if (r15 == true) goto L9;
        g49.d.d("DslCondition", "isConditionMet false: bizConditions=" + r4 + ", productId: " + r10);
        return false;
    L39:
        if (r4 != DslBizCondition.SUPPORT_NOTIFICATION_BROADCAST) goto L58;
        if (o59.a.o(r10) == false) goto L43;
        r15 = k.a;
        goto L119
    L43:
        DoraSetting.a.getClass();
        if (DoraSetting.e().getNotificationSummary() == false) goto L118;
        if (r11 == null) goto L118;
        IDoraService r16 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r16 == null) goto L53;
        DeviceService r17 = r16.device();
        if (r17 == null) goto L53;
        if (r17.m0("startVUI", r11) != true) goto L53;
        boolean r18 = true;
    L54:
        if (r18 == false) goto L118;
        if (r6 == false) goto L118;
    L53:
        r18 = false;
        goto L54
    L58:
        if (r4 != DslBizCondition.SUPPORT_MEETING_MINUTES) goto L70;
        if (r9 != null) goto L61;
    L64:
        boolean r20 = true;
    L66:
        if (r20 == false) goto L68;
        boolean r21 = k.a;
        sk4.e r22 = o0.a;
        r15 = o0.d("meeting_minutes");
        goto L119
    L68:
        boolean r23 = k.a;
        Intrinsics.checkNotNullParameter(r9, "sn");
        sk4.e r24 = o0.a;
        r15 = o0.e(r9, "meeting_minutes");
        goto L119
    L61:
        if (r9.length() == 0) goto L64;
        r20 = false;
        goto L66
    L70:
        if (r4 != DslBizCondition.SUPPORT_QUICK_NOTES) goto L94;
        if (o59.a.o(r10) == false) goto L82;
        if (r9 != null) goto L75;
    L78:
        boolean r25 = true;
    L79:
        if (r25 == false) goto L81;
        boolean r26 = k.a;
        sk4.e r27 = o0.a;
        r15 = o0.d("quick_notes");
        goto L119
    L81:
        boolean r28 = k.a;
        Intrinsics.checkNotNullParameter(r9, "sn");
        sk4.e r30 = o0.a;
        r15 = o0.e(r9, "quick_notes");
        goto L119
    L75:
        if (r9.length() == 0) goto L78;
        r25 = false;
        goto L79
    L82:
        if (r11 == null) goto L118;
        IDoraService r31 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r31 == null) goto L90;
        DeviceService r32 = r31.device();
        if (r32 == null) goto L90;
        if (r32.m0("quick_notes", r11) != true) goto L90;
        boolean r33 = true;
    L91:
        if (r33 == false) goto L118;
    L90:
        r33 = false;
        goto L91
    L94:
        if (r4 != DslBizCondition.SUPPORT_WIFI_SETTINGS) goto L97;
        boolean r34 = k.a;
        sk4.e r35 = o0.a;
        r15 = o0.d("wifiSettings");
        goto L119
    L97:
        if (r4 != DslBizCondition.SUPPORT_OWEN_WAKEUP) goto L100;
        boolean r36 = k.a;
        boolean r37 = IMinorService.a.a();
    L117:
        r15 = !r37;
        goto L119
    L100:
        if (r4 != DslBizCondition.SUPPORT_QUICK_NOTE) goto L109;
        boolean r38 = k.a;
        IDoraService r40 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r40 == null) goto L118;
        DeviceService r41 = r40.device();
        if (r41 == null) goto L118;
        if (r41.q0(r11) != true) goto L118;
    L109:
        if (r4 != DslBizCondition.SUPPORT_CASE_VERSION) goto L118;
        boolean r42 = k.a;
        if (r12 != null) goto L113;
    L116:
        r37 = true;
        goto L117
    L113:
        if (r12.length() == 0) goto L116;
        r37 = false;
        goto L117
    L164:
        Boolean r43 = com.larus.dora.impl.util.l0.a;     // Catch: Throwable -> L20
        if (r43 == null) goto L18;
        boolean r44 = r43.booleanValue();     // Catch: Throwable -> L20
    L22:
        r6 = !r44;
        goto L25
    L18:
        r44 = com.larus.dora.impl.util.l0.a();     // Catch: Throwable -> L20
        com.larus.dora.impl.util.l0.a = Boolean.valueOf(r44);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        g49.d.c("MachineUtils", "no obvious zyt-related features were detected, and it was determined to be a native environment or a non-container environment.", th);
        r44 = false;
    L107:
        r15 = true;
    L122:
        List<String> r45 = r8.c();
        List<String> r110 = r45;
        if (r110 != null) goto L125;
    L128:
        boolean r111 = true;
    L129:
        if (r111 == true) goto L162;
        g49.d.d("DslCondition", "isAbilityMet: abilities=" + r45);
        if (r11 != null) goto L144;
        List<String> r46 = r45;
        if ((r46 instanceof Collection) == true) goto L136;
    L138:
        Iterator<T> r47 = r46.iterator();
    L140:
        if (r47.hasNext() == false) goto L162;
        String r112 = (String) r47.next();
        sk4.e r113 = o0.a;
        if (o0.c(r112) == true) goto L140;
    L161:
        r0 = false;
        goto L162
    L136:
        if (r46.isEmpty() == false) goto L138;
    L144:
        List<String> r48 = r45;
        if ((r48 instanceof Collection) == true) goto L147;
    L149:
        Iterator<T> r50 = r48.iterator();
    L151:
        if (r50.hasNext() == false) goto L162;
        String r114 = (String) r50.next();
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L159;
        DeviceService r51 = r3.device();
        if (r51 == null) goto L159;
        if (r51.m0(r114, r11) != true) goto L159;
        boolean r115 = true;
    L160:
        if (r115 == true) goto L151;
    L159:
        r115 = false;
        goto L160
    L147:
        if (r48.isEmpty() == false) goto L149;
    L162:
        g49.d.d("DslCondition", "isAbilityMet: " + r0 + ". abilities=" + r8 + " productId: " + r10);
        return r0;
    L125:
        if (r110.isEmpty() == true) goto L128;
        r111 = false;
        goto L129
    }

    public static /* synthetic */ void e(SimpleDraweeView r2, u r3, Map r4, Integer r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        d(r2, r3, r4, r5);
    }
}
