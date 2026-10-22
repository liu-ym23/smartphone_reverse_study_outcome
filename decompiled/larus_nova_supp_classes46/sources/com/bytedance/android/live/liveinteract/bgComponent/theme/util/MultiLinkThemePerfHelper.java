package com.bytedance.android.live.liveinteract.bgComponent.theme.util;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.performance.d0;
import com.bytedance.android.live.ui.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkThemePerfHelper {
    public final Map<String, l> a;
    public Function1<? super Map<String, d0>, Unit> b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Function1<? super Map<String, d0>, Unit> r0 = this.b;
        if (r0 != null) goto L5;
        r0 = new MultiLinkThemePerfHelper$handleRadioThemePerfInit$1(this);
    L5:
        this.b = r0;
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L10;
        com.bytedance.android.live.liveinteract.plantform.performance.a r2 = r1.getMultiLinkPerfAbilityManager(true);
        if (r2 == null) goto L10;
        r2.b("multilink_radio_base_degrade", r0);
    L10:
        IInteractService r3 = (IInteractService) k.f(IInteractService.class);
        if (r3 == null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.performance.a r4 = r3.getMultiLinkPerfAbilityManager(true);
        if (r4 == null) goto L15;
        r4.b("multilink_dynamic_bg", r0);
    L15:
        Iterator r5 = ((LinkedHashMap) this.a).entrySet().iterator();
    L17:
        if (r5.hasNext() == false) goto L27;
        Map.Entry r6 = (Map.Entry) r5.next();
        String r7 = (String) r6.getKey();
        l r8 = (l) r6.getValue();
        if (r8 == null) goto L17;
        IInteractService r9 = (IInteractService) k.f(IInteractService.class);
        if (r9 == null) goto L25;
        com.bytedance.android.live.liveinteract.plantform.performance.a r10 = r9.getMultiLinkPerfAbilityManager(true);
        if (r10 == null) goto L25;
        boolean r11 = r10.a(r7);
    L26:
        r8.d(r11);
    L25:
        r11 = true;
        goto L26
    }

    public MultiLinkThemePerfHelper() {
        this.a = new LinkedHashMap();
    }
}
