package mf0;

import android.content.Context;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.setting.z1;
import com.bytedance.android.live.liveinteract.voicechat.interactacting.InteractActingContext;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.model.LiveInteractActingConfig;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if (r9 != null) goto L6;
        x8.a.d("InteractActingUtils", "context is null", false);
        return;
    L6:
        InteractActingContext.a r3 = InteractActingContext.Companion;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r10, "source");
        InteractActingContext r0 = r3.getContext();
        if (r0 == null) goto L11;
        m<String> r1 = r0.getOpenSource();
        if (r1 == null) goto L11;
        r1.setValue(r10);
    L11:
        LiveInteractActingConfig r11 = (LiveInteractActingConfig) z1.a.getValue();
        e r2 = b6.T;
        boolean r4 = true;
        String r8 = null;
        if (((Boolean) r2.getValue()).booleanValue() == false) goto L42;
        if (r11 == null) goto L15;
        Map r12 = r11.getInteractActingLaunchGuide();
    L16:
        if (r12 == null) goto L18;
        String r5 = (String) r12.get("url");
    L19:
        if (r12 == null) goto L21;
        r8 = (String) r12.get("schema");
    L21:
        if (r5 != null) goto L23;
    L26:
        boolean r13 = true;
    L27:
        if (r13 == true) goto L40;
        if (r8 != null) goto L30;
    L33:
        if (r4 == true) goto L40;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("type", "3");
        String r14 = y0.b(r8 + "&url=" + r5, r6);
        IBaseLiveActionHandler r7 = k.f(IBaseLiveActionHandler.class);
        if (r7 == null) goto L38;
        r7.handle(r9, r14);
    L38:
        f.d(r2, Boolean.FALSE);
        return;
    L30:
        if (r8.length() == 0) goto L33;
        r4 = false;
    L40:
        x8.a.d("InteractActingUtils", "互动演绎玩法开启引导面板url或schema为空", false);
        return;
    L23:
        if (r5.length() == 0) goto L26;
        r13 = false;
        goto L27
    L18:
        r5 = null;
        goto L19
    L15:
        r12 = null;
        goto L16
    L42:
        if (r11 == null) goto L44;
        Map r15 = r11.getInteractActingLaunch();
    L45:
        if (r15 == null) goto L47;
        String r16 = (String) r15.get("url");
    L48:
        if (r15 == null) goto L50;
        r8 = (String) r15.get("schema");
    L50:
        if (r16 != null) goto L52;
    L55:
        boolean r17 = true;
    L56:
        if (r17 == true) goto L68;
        if (r8 != null) goto L59;
    L62:
        if (r4 == true) goto L68;
        String r18 = r8 + "&url=" + r16;
        IBaseLiveActionHandler r19 = k.f(IBaseLiveActionHandler.class);
        if (r19 == null) goto L70;
        r19.handle(r9, r18);
        return;
    L70:
        return;
    L59:
        if (r8.length() == 0) goto L62;
        r4 = false;
    L68:
        x8.a.d("InteractActingUtils", "互动演绎玩法开启面板url或schema为空", false);
        return;
    L52:
        if (r16.length() == 0) goto L55;
        r17 = false;
        goto L56
    L47:
        r16 = null;
        goto L48
    L44:
        r15 = null;
        goto L45
    }
}
