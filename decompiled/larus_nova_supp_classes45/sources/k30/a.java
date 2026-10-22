package k30;

import com.bytedance.android.live.browser.jsbridge.base.CreateFakeGiftViewResultModel;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.l;
import com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager;
import com.bytedance.android.scope.j;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import w20.i0;
import w20.o8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends i0<o8, CreateFakeGiftViewResultModel> {
    public final j a;

    public a(j r1) {
        this.a = r1;
    }

    public final void invoke(Object r11, CallContext r12) {
        o8 r13 = (o8) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        n01.a r14 = f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        String r1 = null;
        if (r14 == null) goto L5;
        boolean r15 = r14.Q0(null);
    L6:
        if (r15 == true) goto L60;
        Integer r2 = r13.e();
        long r3 = 0;
        if (r2 == null) goto L11;
        long r5 = r2.intValue();
    L12:
        l r16 = new l(r5);
        Integer r4 = r13.getType();
        if (r4 == null) goto L15;
        int r6 = r4.intValue();
    L16:
        r16.R = r6;
        List<String> r7 = r13.h();
        if (r7 == null) goto L19;
        int r8 = r7.size();
    L20:
        int r9 = 1;
        if (r8 < 2) goto L30;
        k r17 = (k) vh7.f.c(k.class);
        List<String> r18 = r13.h();
        if (r18 == null) goto L25;
        String r19 = (String) ListProtector.get(r18, 1);
    L26:
        Intrinsics.checkNotNull(r19);
        r17.setUrls(CollectionsKt.listOf(r19));
        Unit r21 = Unit.INSTANCE;
        r16.S = r17;
        k r22 = (k) vh7.f.c(k.class);
        List<String> r23 = r13.h();
        if (r23 == null) goto L29;
        r1 = (String) ListProtector.get(r23, 0);
    L29:
        Intrinsics.checkNotNull(r1);
        r22.setUrls(CollectionsKt.listOf(r1));
        r16.U = r22;
    L35:
        String r0 = r13.i();
        String r24 = "";
        if (r0 != null) goto L38;
        r0 = "";
    L38:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r16.V = r0;
        String r25 = r13.c();
        if (r25 != null) goto L41;
        r25 = "";
    L41:
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r16.W = r25;
        Integer r26 = r13.d();
        if (r26 == null) goto L44;
        long r27 = r26.intValue();
    L45:
        r16.X = r27;
        Integer r28 = r13.b();
        if (r28 == null) goto L48;
        r9 = r28.intValue();
    L48:
        r16.Y = r9;
        k r29 = (k) vh7.f.c(k.class);
        String r31 = r13.g();
        if (r31 != null) goto L51;
        r31 = "";
    L51:
        r29.setUrls(Collections.singletonList(r31));
        Unit r32 = Unit.INSTANCE;
        ((NormalGiftMessage) r16).o = r29;
        k r33 = (k) vh7.f.c(k.class);
        String r34 = r13.a();
        if (r34 == null) goto L55;
        r24 = r34;
    L55:
        r33.setUrls(Collections.singletonList(r24));
        r16.Z = r33;
        Integer r35 = r13.f();
        if (r35 == null) goto L58;
        r3 = r35.intValue();
    L58:
        r16.k0 = Long.valueOf(r3);
        r16.T = r13.j();
        GiftTrayMessageManager r110 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().g(r16);
        return;
    L44:
        r27 = 2000;
        goto L45
    L25:
        r19 = null;
        goto L26
    L30:
        if (r8 != 1) goto L35;
        k r36 = (k) vh7.f.c(k.class);
        List<String> r37 = r13.h();
        if (r37 == null) goto L34;
        r1 = (String) ListProtector.get(r37, 0);
    L34:
        Intrinsics.checkNotNull(r1);
        r36.setUrls(CollectionsKt.listOf(r1));
        Unit r38 = Unit.INSTANCE;
        r16.S = r36;
        goto L35
    L19:
        r8 = 0;
        goto L20
    L15:
        r6 = 0;
        goto L16
    L11:
        r5 = 0;
        goto L12
    L60:
        return;
    L5:
        r15 = false;
        goto L6
    }
}
