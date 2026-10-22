package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.event.ToolbarEvent;
import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.bytedance.android.livesdk.config.de0;
import com.facebook.drawee.interfaces.DraweeController;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g4<T> implements Consumer {
    public final /* synthetic */ c4 a;

    public g4(c4 r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        ToolbarEvent r11 = (ToolbarEvent) sh6.c.b((sh6.b) r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (a4.a[r11.a.ordinal()] != 1) goto L68;
        final c4 r2 = this.a;
        Object r12 = r11.b;
        Animatable r3 = null;
        if ((r12 instanceof ko0.e) == true) goto L10;
        r12 = null;
    L10:
        final ko0.e r13 = (ko0.e) r12;
        r2.getClass();
        if (r13 == null) goto L61;
        String r0 = r13.b;
        if (r0 != null) goto L15;
    L18:
        boolean r1 = true;
    L19:
        if (r1 == true) goto L69;
        int r4 = r13.a;
        if (r4 != 1) goto L47;
        AudienceMiniAppDataContext.Companion.getClass();
        ko0.d r5 = AudienceMiniAppDataContext.a.b();
        if (r5 != null) goto L26;
    L28:
        HSImageView r6 = r2.h;
        if (r6 == null) goto L62;
        ko0.d r7 = AudienceMiniAppDataContext.a.b();
        if (r7 == null) goto L33;
        r7.a = true;
    L33:
        jc1.k.n(IOpenPlatformAudienceService.class).reportSnowFlakeAnimShow();
        Function0<Unit> r8 = r13.c;
        Function0<Unit> r9 = new ToolbarOpenPlatformMiniAppBehavior$runSpreadFlowersAnim$$inlined$let$lambda$1(r2, r13);
        if (r6.getController() == null) goto L45;
        DraweeController r14 = r6.getController();
        if (r14 == null) goto L38;
        r3 = r14.getAnimatable();
    L38:
        if (r3 == null) goto L45;
        DraweeController r15 = r6.getController();
        if (r15 == null) goto L63;
        Animatable r16 = r15.getAnimatable();
        if (r16 == null) goto L64;
        c4.b(r2, r16, r8, r9);
        r16.start();
        return;
    L64:
        return;
    L63:
        return;
    L45:
        ALogger.i(r2.a, "spreadFlowers anim is not ready, reload");
        r2.a(ImageTag.SPREAD_FLOWERS, r6, r13.b, new ToolbarOpenPlatformMiniAppBehavior$runSpreadFlowersAnim$$inlined$let$lambda$2(r2, r13), r8, r9);
        return;
    L62:
        return;
    L26:
        if (r5.a != true) goto L28;
        return;
    L47:
        if (r4 != 2) goto L49;
    L52:
        Disposable r17 = r2.f;
        if (r17 == null) goto L55;
        r17.dispose();
    L55:
        Observable r18 = Observable.create(new ToolbarOpenPlatformMiniAppBehavior$runCardAnim$observable$1(r2, r13));
        int r19 = de0.a.getValue().q();
        if (r19 <= 0) goto L58;
        r18 = RxUtilKt.h(r18.timeout(r19, TimeUnit.MILLISECONDS));
    L58:
        r2.f = r18.subscribe(new d4(r2), new e4(r2, r13));
        return;
    L49:
        if (r4 == 3) goto L52;
        if (r4 == 4) goto L52;
        return;
    L69:
        return;
    L15:
        if (r0.length() == 0) goto L18;
        r1 = false;
        goto L19
    L61:
        return;
    }
}
