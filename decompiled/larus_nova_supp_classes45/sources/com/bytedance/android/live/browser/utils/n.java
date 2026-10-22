package com.bytedance.android.live.browser.utils;

import android.view.View;
import com.bytedance.android.live.core.setting.r0;
import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(CallContext r2) {
        if (((Boolean) r0.a.getValue()).booleanValue() == false) goto L9;
        if (r2 == null) goto L10;
        View r3 = r2.d;
        if (r3 == null) goto L11;
        r3.setTag(2131378193, null);
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void a(View r4, ylc.e r5, MessageHub r6) {
        r0 r0 = r0.a;
        if (((Boolean) r0.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (r6 == null) goto L22;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L52;
        Object r1 = r4.getTag(2131378197);
        if ((r1 instanceof LinkedHashSet) == true) goto L11;
        r1 = null;
    L11:
        LinkedHashSet r2 = (LinkedHashSet) r1;
        if (r2 == null) goto L20;
        Iterator r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L20;
        Pair r7 = (Pair) r3.next();
        IPreviewSyncDataType r8 = (IPreviewSyncDataType) r7.getFirst();
        OnWRDSDataUpdateListener r9 = (OnWRDSDataUpdateListener) r7.getSecond();
        if (r8 == null) goto L15;
        if (r9 == null) goto L15;
        r6.removeWRDSListener(r8, r9);
    L20:
        r4.setTag(2131378197, null);
        return;
    L52:
        return;
    L22:
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L54;
        Object r11 = r4.getTag(2131378196);
        if ((r11 instanceof LinkedHashSet) == true) goto L26;
        r11 = null;
    L26:
        LinkedHashSet r12 = (LinkedHashSet) r11;
        if (r12 == null) goto L35;
        Iterator r13 = r12.iterator();
    L30:
        if (r13.hasNext() == false) goto L35;
        ylc.c r14 = (ylc.c) r13.next();
        if (r14 == null) goto L30;
        if (r5 == null) goto L30;
        Intrinsics.checkNotNullParameter(r14, "listener");
        r5.i(r14);
    L35:
        r4.setTag(2131378196, null);
        return;
    }

    public static void c(CallContext r3, Object r4, vlc.l r5) {
        if (((Boolean) r0.a.getValue()).booleanValue() == false) goto L15;
        if (r3 == null) goto L16;
        View r6 = r3.d;
        if (r6 == null) goto L17;
        Object r1 = r6.getTag(2131378193);
        if ((r1 instanceof LinkedHashSet) == true) goto L10;
        r1 = null;
    L10:
        LinkedHashSet r2 = (LinkedHashSet) r1;
        if (r2 != null) goto L13;
        r2 = new LinkedHashSet();
        r6.setTag(2131378193, r2);
    L13:
        r2.add(new Pair(r4, r5));
        return;
    L17:
        return;
    L16:
        return;
    }

    public static void d(View r5, DataCenter r6, MessageHub r7) {
        if (((Boolean) r0.a.getValue()).booleanValue() == false) goto L51;
        Object r1 = r5.getTag(2131378193);
        if ((r1 instanceof LinkedHashSet) == true) goto L7;
        r1 = null;
    L7:
        LinkedHashSet r2 = (LinkedHashSet) r1;
        if (r7 == null) goto L22;
        if (r2 == null) goto L34;
        Iterator r8 = r2.iterator();
    L12:
        if (r8.hasNext() == false) goto L34;
        Pair r3 = (Pair) r8.next();
        Object r4 = r3.getFirst();
        vlc.l r9 = (vlc.l) r3.getSecond();
        if (r9 == null) goto L12;
        if ((r4 instanceof String) == true) goto L18;
        if ((r4 instanceof Integer) == false) goto L12;
        r7.removeMessageListener(((Number) r4).intValue(), r9);
        goto L12
    L18:
        r7.removeMessageListener((String) r4, r9);
    L34:
        r5.setTag(2131378193, null);
        return;
    L22:
        if (r6 == null) goto L24;
        vlc.d r11 = (vlc.d) r6.get("data_message_manager", null);
    L25:
        if (r11 == null) goto L34;
        if (r2 == null) goto L34;
        Iterator r12 = r2.iterator();
    L29:
        if (r12.hasNext() == false) goto L34;
        vlc.l r13 = (vlc.l) ((Pair) r12.next()).getSecond();
        if (r13 == null) goto L29;
        r11.removeMessageListener(r13);
        goto L29
    L24:
        r11 = null;
        goto L25
    }
}
