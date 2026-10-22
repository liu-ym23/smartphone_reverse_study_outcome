package q92;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.c0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.d0;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.MultiActionAndPriorityMessageBuffer;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.MultiQueueWaitMessageBufferV2;
import com.bytedance.android.livesdk.interactivity.service.model.e;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenInfo;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import da2.c;
import ec2.p;
import ec2.t1;
import kotlin.jvm.internal.Intrinsics;
import r52.g4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static n42.a c(IRoom r5) {
        n42.a r0 = new n42.a();
        r0.a = (int) w2.a(14.0f);
        r0.b = Typeface.DEFAULT_BOLD;
        r0.d = new Rect(8, PublicScreenABHelper.h().itemVerticalPaddingDp, 8, PublicScreenABHelper.h().itemVerticalPaddingDp);
        r0.c = (int) s1.b(24.0f);
        r0.m = MessageSceneType.PUBLIC_SCREEN;
        r0.j = ColorProtector.parseColor("#FE2C55");
        r0.i = s1.f(13.0f);
        r0.k = s1.f(24.0f);
        r0.l = 2131249526;
        a(r0, r5);
        return r0;
    }

    public static void a(n42.a r8, IRoom r9) {
        if (r9 == null) goto L24;
        int r0 = e.a;
        if (e.a.a().messageBackground == false) goto L25;
        RoomPublicScreenInfo r10 = gb2.b.b(r9);
        if (r10 == null) goto L26;
        String r1 = r10.backgroundColor;
        if (r1 != null) goto L20;
    L13:
        String r11 = r10.longPressColor;
        if (r1 == null) goto L27;
        r8.f = true;     // Catch: Exception -> L17
        r8.h = Integer.valueOf(Color.parseColor(r11));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        r8.f = false;
        ALogger.e("TextMessageTracer", "parse pressed bg color " + r11 + " failed", e);
        return;
    L27:
        return;
    L20:
        r8.e = true;     // Catch: Exception -> L11
        r8.g = Integer.valueOf(Color.parseColor(r1));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        r8.e = false;
        ALogger.e("TextMessageTracer", "parse bg color " + r1 + " failed", e);
        goto L13
    L26:
        return;
    L25:
        return;
    }

    public static a b(boolean r6, IRoom r7) {
        a r0 = new a();
        boolean r1 = !r6;
        r0.b = r1;
        boolean r2 = true;
        if (r7 == null) goto L5;
        r0.a = !r7.isStar();
    L5:
        r0.d = r6;
        r0.c = r6;
        r0.e = r1;
        r0.f = r1;
        r0.g = r1;
        if (r6 == false) goto L8;
        int r3 = 2;
    L9:
        r0.h = r3;
        r0.j = r1;
        n42.a r4 = new n42.a();
        r4.a = (int) w2.a(14.0f);
        r4.b = Typeface.DEFAULT_BOLD;
        r4.c = s1.f(21.0f);
        r4.d = new Rect(8, 3, 8, 3);
        r4.m = MessageSceneType.PUBLIC_SCREEN;
        r4.j = ColorProtector.parseColor("#FE2C55");
        r4.i = s1.f(13.0f);
        r4.k = s1.f(24.0f);
        r4.l = 2131249526;
        a(r4, r7);
        r0.l = r4;
        r0.k = c(r7);
        if (r7 == null) goto L12;
        r0.i = r6;
    L12:
        if (r7 == null) goto L21;
        if (r7.isVsRoom() == false) goto L16;
        int r5 = ((Integer) t1.a.getValue()).intValue();
    L19:
        r0.n = r5;
        goto L21
    L16:
        if (r6 == false) goto L18;
        r5 = ((Integer) g4.a.getValue()).intValue();
        goto L19
    L18:
        r5 = ((Integer) p.a.getValue()).intValue();
    L21:
        if (r7 != null) goto L23;
        boolean r8 = false;
    L24:
        r0.p = r8;
        r0.q = r6;
        int r9 = da2.a.a;
        if (r7 != null) goto L27;
        boolean r10 = false;
    L28:
        r0.s = new da2.b(new c(r10, r6, r0));
        Intrinsics.checkNotNullParameter(r0, "config");
        r0.t = new da2.b(new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.b(r0));
        Intrinsics.checkNotNullParameter(r0, "config");
        r0.u = new da2.b(new xa2.a(r0));
        if (PublicScreenABHelper.g(r6).enablePersonalizedChannel == true) goto L31;
        if (r6 == false) goto L40;
        d0 r11 = (d0) PublicScreenABHelper.v.getValue();
    L42:
        if (r11.heatStrategyEnable == false) goto L49;
        if (r7 == null) goto L49;
        IRoomAuthStatus r13 = r7.getRoomAuthStatus();
        if (r13 == null) goto L49;
        if (r13.isPublicScreenMessageHeatStrategyEnable() != true) goto L49;
    L50:
        if (r2 == false) goto L60;
        if (r6 == false) goto L54;
        d0 r14 = (d0) PublicScreenABHelper.v.getValue();
    L55:
        if (r6 == false) goto L57;
        c0 r15 = (c0) PublicScreenABHelper.y.getValue();
    L58:
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a r16 = new MultiActionAndPriorityMessageBuffer(r14, r15, r6, r7);
    L67:
        r0.w = r16;
        r0.v = new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c(r7, PublicScreenABHelper.d(r6), r6);
        return r0;
    L57:
        r15 = (c0) PublicScreenABHelper.x.getValue();
        goto L58
    L54:
        r14 = (d0) PublicScreenABHelper.w.getValue();
        goto L55
    L60:
        if (r6 == false) goto L62;
        int r17 = ((Number) PublicScreenABHelper.c.getValue()).intValue();
    L63:
        if (r6 == false) goto L65;
        int r18 = ((Number) PublicScreenABHelper.d.getValue()).intValue();
    L66:
        r16 = new MultiQueueWaitMessageBufferV2(r17, r18, r7, r6);
        goto L67
    L65:
        r18 = ((Number) PublicScreenABHelper.b.getValue()).intValue();
        goto L66
    L62:
        r17 = ((Number) PublicScreenABHelper.a.getValue()).intValue();
    L49:
        r2 = false;
        goto L50
    L40:
        r11 = (d0) PublicScreenABHelper.w.getValue();
        goto L42
    L31:
        if (r6 == false) goto L33;
        int r19 = ((Number) PublicScreenABHelper.c.getValue()).intValue();
    L34:
        if (r6 == false) goto L36;
        int r20 = ((Number) PublicScreenABHelper.d.getValue()).intValue();
    L37:
        r16 = new MultiQueueWaitMessageBufferV2(r19, r20, r7, r6);
        goto L67
    L36:
        r20 = ((Number) PublicScreenABHelper.b.getValue()).intValue();
        goto L37
    L33:
        r19 = ((Number) PublicScreenABHelper.a.getValue()).intValue();
        goto L34
    L27:
        r10 = r7.isMediaRoom();
        goto L28
    L23:
        r8 = r7.isMediaRoom();
        goto L24
    L8:
        r3 = 1;
        goto L9
    }
}
