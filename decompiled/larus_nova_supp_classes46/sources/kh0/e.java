package kh0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements IFetchEffectListener {
    public final /* synthetic */ f a;

    public final void onStart(Effect r1) {
    }

    public e(f r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r8) {
        Effect r9 = (Effect) r8;
        if (r9 == null) goto L7;
        Sticker r0 = com.bytedance.android.live.effect.utils.b.a().convertStickerBean(r9);
        c.a r1 = this.a.d;
        if (r1 == null) goto L8;
        r1.a(r0);
    L8:
        Map<String, Sticker> r2 = c.a;
        f r3 = this.a;
        String r4 = r3.b;
        String r5 = r3.a;
        int r6 = com.bytedance.android.live.liveinteract.revenue.common.c.a;
        Intrinsics.checkNotNullParameter(r4, "panel");
        Intrinsics.checkNotNullParameter(r5, "name");
        ii0.b r7 = ii0.b.a;
        String r10 = null;
        if (r9 == null) goto L11;
        String r11 = r9.getName();
    L12:
        if (r9 == null) goto L14;
        String r12 = r9.getEffect_id();
    L15:
        if (r9 == null) goto L17;
        String r13 = r9.getId();
    L18:
        r7.n(r11, r12, r13, null);
        if (r9 == null) goto L21;
        MultiLinkEventModule r14 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.b(r9.getEffectId(), r9.getName(), 0, "");
    L21:
        StringBuilder r15 = new StringBuilder("#RevenueStickerDebug# [fetchEffect] panel: ");
        r15.append(r4);
        r15.append(", id: ");
        if (r9 == null) goto L24;
        String r16 = r9.getId();
    L25:
        r15.append(r16);
        r15.append(", name: ");
        r15.append(r5);
        r15.append("effect_id: ");
        if (r9 == null) goto L28;
        String r17 = r9.getEffect_id();
    L29:
        r15.append(r17);
        r15.append(",sdk_extra: ");
        if (r9 == null) goto L32;
        r10 = r9.getSdkExtra();
    L32:
        r15.append(r10);
        ALogger.i("InteractRevenueStickerManager", r15.toString());
        return;
    L28:
        r17 = null;
        goto L29
    L24:
        r16 = null;
        goto L25
    L17:
        r13 = null;
        goto L18
    L14:
        r12 = null;
        goto L15
    L11:
        r11 = null;
        goto L12
    L7:
        this.a.c(new Exception("贴纸下载失败。[panel=" + this.a.b + ", name=" + this.a.a + ']'));
        goto L8
    }

    public final void onFail(Effect r8, ExceptionResult r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        f r1 = this.a;
        Exception r2 = r9.getException();
        if (r2 != null) goto L5;
        r2 = new Exception("贴纸下载失败。[panel=" + this.a.b + ", name=" + this.a.a + ']');
    L5:
        r1.c(r2);
        Map<String, Sticker> r3 = c.a;
        f r4 = this.a;
        String r5 = r4.b;
        String r6 = r4.a;
        int r7 = com.bytedance.android.live.liveinteract.revenue.common.c.a;
        Intrinsics.checkNotNullParameter(r9, "e");
        Intrinsics.checkNotNullParameter(r5, "panel");
        Intrinsics.checkNotNullParameter(r6, "name");
        ii0.b r0 = ii0.b.a;
        String r10 = null;
        if (r8 == null) goto L8;
        String r11 = r8.getName();
    L9:
        if (r8 == null) goto L11;
        String r12 = r8.getEffect_id();
    L12:
        if (r8 == null) goto L14;
        String r13 = r8.getId();
    L15:
        r0.n(r11, r12, r13, r9);
        if (r9.getErrorCode() != 0) goto L18;
        int r14 = 1;
    L19:
        if (r8 == null) goto L21;
        MultiLinkEventModule r15 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.b(r8.getEffectId(), r8.getName(), r14, r9.getMsg());
    L21:
        StringBuilder r16 = new StringBuilder("#RevenueStickerDebug# [fetchEffect] panel: ");
        r16.append(r5);
        r16.append(", id: ");
        if (r8 == null) goto L24;
        String r17 = r8.getId();
    L25:
        r16.append(r17);
        r16.append(", name: ");
        r16.append(r6);
        r16.append("effect_id: ");
        if (r8 == null) goto L28;
        r10 = r8.getEffect_id();
    L28:
        r16.append(r10);
        r16.append(", extra: ");
        r16.append(r9);
        ALogger.e("InteractRevenueStickerManager", r16.toString());
        return;
    L24:
        r17 = null;
        goto L25
    L18:
        r14 = r9.getErrorCode();
        goto L19
    L14:
        r13 = null;
        goto L15
    L11:
        r12 = null;
        goto L12
    L8:
        r11 = null;
        goto L9
    }
}
