package com.bytedance.android.btm.bridge;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.l;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class HybridSchemaHelper {
    public static final Map<View, String> a = null;

    static {
        a = Collections.synchronizedMap(new WeakHashMap());
    }

    public static String b(final View r10, final Uri r11) {
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        String r1 = null;
        r0.element = null;
        if (r10 == null) goto L22;
        String r12 = a.get(r10);
        r0.element = r12;
        if (r12 != null) goto L22;
        int r13 = l.a;
        if (BtmSDK.INSTANCE.getService().fixSourceTokenError() == false) goto L22;
        Object r14 = r10.getParent();
        if ((r14 instanceof View) == true) goto L11;
        r14 = null;
    L11:
        View r15 = (View) r14;
    L12:
        if (r15 == null) goto L22;
        String r16 = a.get(r15);
        r0.element = r16;
        if (r16 != null) goto L22;
        int r17 = l.a;
        if (BtmSDK.INSTANCE.getService().isHybridContainer(r15) == true) goto L22;
        Object r18 = r15.getParent();
        if ((r18 instanceof View) == true) goto L21;
        r18 = null;
    L21:
        r15 = (View) r18;
    L22:
        String r19 = (String) r0.element;
        if (r19 != null) goto L25;
    L28:
        boolean r20 = true;
    L29:
        if (r20 == false) goto L33;
        if (r11 == null) goto L32;
        r1 = UriProtector.getQueryParameter(r11, "source_btm_token");
    L32:
        r0.element = r1;
    L33:
        ALogger.g(ALogger.d, "SourceBtmToken:HybridSchemaHelper.tryGetSourceBtmToken", new HybridSchemaHelper$tryGetSourceBtmToken$2(r10, r0, r11));
        return (String) r0.element;
    L25:
        if (r19.length() == 0) goto L28;
        r20 = false;
        goto L29
    }

    public static void a(final View r10, final Uri r11, boolean r12) {
        if (r10 == null) goto L19;
        if (r11 == null) goto L24;
        final String r0 = UriProtector.getQueryParameter(r11, "source_btm_token");
        final String r1 = UriProtector.getQueryParameter(r11, "btm_pre_id");
        Map<View, String> r13 = a;
        if (r0 == null) goto L8;
        String r14 = r0;
    L9:
        r13.put(r10, r14);
        ALogger.g(ALogger.d, "SourceBtmToken:HybridSchemaHelper.register", new HybridSchemaHelper$register$1(r10, r0, r11, r1));
        if (r12 == true) goto L12;
        return;
    L12:
        if ((r10 instanceof HybridCard) == false) goto L21;
        View r15 = ((HybridCard) r10).getHybridView();
        if (r13.containsKey(r15) == true) goto L16;
        return;
    L16:
        if (r13.get(r15) != null) goto L23;
        r13.put(r15, r13.get(r10));
        return;
    L23:
        return;
    L21:
        return;
    L8:
        r14 = r1;
        goto L9
    L24:
        return;
    }
}
