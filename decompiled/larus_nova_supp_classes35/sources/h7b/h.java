package h7b;

import com.ss.android.lark.statistics.translate.TranslateHitPoint;
import com.ss.android.lark.widget.dialog.SwitchTranslateDialog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import z5c.h2;
import z5c.k2;
import z5c.o;
import z5c.p3;
import z5c.q3;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements SwitchTranslateDialog.b {
    public final /* synthetic */ i.a a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ m2b.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ com.ss.android.lark.chat.base.view.vo.message.f e;
    public final /* synthetic */ String f;

    public final void a(fcc.c<?> r1) {
        if (r1 == null) goto L5;
        r1.j();
        return;
    }

    public final void onClick(int r12) {
        this.a.a((String) this.b.get(Integer.valueOf(r12)));
        TranslateHitPoint r2 = TranslateHitPoint.a;
        o r0 = o.c;
        m2b.a r1 = this.c;
        String r3 = BuildConfig.FLAVOR;
        if (r1 != null) goto L5;
    L7:
        String r4 = BuildConfig.FLAVOR;
    L8:
        s5c.a r5 = r0.a(r4);
        int r6 = com.ss.android.lark.statistics.translate.a.a;
        s5c.a r7 = com.ss.android.lark.statistics.translate.a.a.a(this.c);
        s5c.a r8 = k2.c.a(this.d);
        q3 r9 = q3.c;
        com.ss.android.lark.chat.base.view.vo.message.f r10 = this.e;
        if (r10 == null) goto L12;
        String r11 = r10.b;
        if (r11 == null) goto L12;
    L13:
        s5c.a r13 = r9.a(r11);
        s5c.a r14 = h2.c.a(this.f);
        s5c.a r15 = r.R;
        p3 r16 = p3.s;
        if (this.b.get(Integer.valueOf(r12)) == null) goto L16;
        r3 = (String) this.b.get(Integer.valueOf(r12));
    L16:
        r2.b(r5, r7, r8, r13, r14, r15, r16.a(r3));
        return;
    L12:
        r11 = BuildConfig.FLAVOR;
        goto L13
    L5:
        if (r1.getChatId() == null) goto L7;
        r4 = this.c.getChatId();
        goto L8
    }

    public h(e9c.d.a r1, Map r2, m2b.a r3, String r4, com.ss.android.lark.chat.base.view.vo.message.f r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
