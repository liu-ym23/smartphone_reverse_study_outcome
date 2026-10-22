package h7b;

import com.ss.android.lark.statistics.translate.TranslateHitPoint;
import com.ss.android.lark.translate.dialog.MoreTranslateActionDialog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import z5c.h2;
import z5c.k2;
import z5c.o;
import z5c.p3;
import z5c.q3;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements MoreTranslateActionDialog.c {
    public final /* synthetic */ i.a a;
    public final /* synthetic */ m2b.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.ss.android.lark.chat.base.view.vo.message.f d;
    public final /* synthetic */ String e;

    public final void a(int r9, MoreTranslateActionDialog.MoreActionType r10, fcc.c<?> r11) {
        if (r10 != MoreTranslateActionDialog.MoreActionType.HideTranslate) goto L22;
        this.a.b(r10);
        TranslateHitPoint r0 = TranslateHitPoint.a;
        o r12 = o.c;
        m2b.a r13 = this.b;
        String r14 = BuildConfig.FLAVOR;
        if (r13 != null) goto L7;
    L9:
        String r15 = BuildConfig.FLAVOR;
    L10:
        s5c.a r1 = r12.a(r15);
        int r16 = com.ss.android.lark.statistics.translate.a.a;
        s5c.a r2 = com.ss.android.lark.statistics.translate.a.a.a(this.b);
        s5c.a r3 = k2.c.a(this.c);
        q3 r17 = q3.c;
        com.ss.android.lark.chat.base.view.vo.message.f r18 = this.d;
        if (r18 == null) goto L16;
        String r19 = r18.b;
        if (r19 == null) goto L16;
        r14 = r19;
    L16:
        s5c.a r4 = r17.a(r14);
        s5c.a r5 = h2.c.a(this.e);
        com.ss.android.lark.chat.base.view.vo.message.f r20 = this.d;
        Intrinsics.checkNotNullParameter(r20, "translatableContentVO");
        s5c.a r110 = r.Q;
        if (com.ss.android.lark.statistics.translate.a.a.b(r20) != 1) goto L19;
        s5c.a r6 = r.S;
    L20:
        r0.b(r1, r2, r3, r4, r5, r6, p3.c);
        return;
    L19:
        r6 = r110;
        goto L20
    L7:
        if (r13.getChatId() == null) goto L9;
        r15 = this.b.getChatId();
        goto L10
    L22:
        if (r10 != MoreTranslateActionDialog.MoreActionType.SwitchLanguage) goto L27;
        if (r11 == null) goto L28;
        r11.j();
        return;
    L28:
        return;
    }

    public g(e9c.d.a r1, m2b.a r2, String r3, com.ss.android.lark.chat.base.view.vo.message.f r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
