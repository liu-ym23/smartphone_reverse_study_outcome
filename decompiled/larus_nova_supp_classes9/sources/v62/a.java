package v62;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.vip.e;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.interactivity.api.IExpressionService;
import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.interactivity.comment.input.LiveCommonInputDialog;
import com.bytedance.android.livesdk.interactivity.comment.input.framework.PanelType;
import i40.h;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements u62.c {
    public final PanelType a;
    public boolean b;
    public View c;
    public u62.b d;

    /* JADX INFO: renamed from: v62.a$a, reason: collision with other inner class name */
    public interface InterfaceC0287a {
        void a();

        void c(BaseEmoji r1, String r2);

        void dismissDialog();
    }

    @Override // u62.c
    public final void b() {
    }

    @Override // u62.c
    public final void c() {
    }

    @Override // u62.c
    public final void a() {
        u62.b r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = UtilityKotlinExtentionsKt.i(275);
        if (r0.d() == 0) goto L8;
        r1 = r0.d();
    L8:
        View r2 = this.c;
        if (r2 == null) goto L11;
        a1.k(r2, r1);
    L11:
        String r3 = "on panel switch to emoji, height: " + r1;
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r3, "msg");
        h.a(r3);
        e r4 = yt0.c.l();
        if (r4 == null) goto L15;
        r4.bn("emoji");
        return;
    }

    public a() {
        this.a = PanelType.EMOJI;
    }

    public final View d(LiveCommonInputDialog.j r10) {
        Intrinsics.checkNotNullParameter(r10, "panelBridge");
        this.d = r10;
        if (this.b == true) goto L22;
        if (k.f(IMiddleWareHostContext.class) != null) goto L8;
        Intrinsics.checkNotNullParameter("init emoji panel error IHostContext null", "msg");
        Intrinsics.checkNotNullParameter("init emoji panel error IHostContext null", "msg");
        h.a("init emoji panel error IHostContext null");
        goto L22
    L8:
        Context r3 = k.n(IMiddleWareHostContext.class).context();
        if (r3 != null) goto L11;
        Intrinsics.checkNotNullParameter("init emoji panel error context null", "msg");
        Intrinsics.checkNotNullParameter("init emoji panel error context null", "msg");
        h.a("init emoji panel error context null");
        goto L22
    L11:
        int r0 = UtilityKotlinExtentionsKt.i(275);
        IExpressionService r2 = (IExpressionService) k.n(IExpressionService.class);
        boolean r4 = r10.f();
        int r5 = s1.y();
        i r6 = new i();
        r6.a = true;
        Unit r7 = Unit.INSTANCE;
        View r8 = r2.createNewEmojiSelectPanel(r3, r4, r5, r6, new b(r10));
        this.c = r8;
        if ((r8 instanceof jf2.a) == true) goto L14;
        r8 = null;
    L14:
        jf2.a r9 = (jf2.a) r8;
        if (r9 == null) goto L17;
        r10.g(new c(r9));
    L17:
        ViewGroup.LayoutParams r11 = new ViewGroup.LayoutParams(-1, r0);
        View r13 = this.c;
        if (r13 == null) goto L20;
        r13.setLayoutParams(r11);
    L20:
        this.b = true;
        String r14 = "emoji panel init, opt: true, height: " + r0;
        Intrinsics.checkNotNullParameter(r14, "msg");
        Intrinsics.checkNotNullParameter(r14, "msg");
        h.a(r14);
    L22:
        return this.c;
    }
}
