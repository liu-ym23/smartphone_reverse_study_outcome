package o4a;

import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.base.AnimaXError;
import com.lynx.animax.util.LynxAnimaX;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import t4a.d;
import t4a.f;
import w4a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends BaseAbility implements f {
    public boolean h;
    public final WeakReference<LynxBaseUI> i;
    public final WeakReference<LynxContext> j;

    public class a extends com.lynx.tasm.event.a {
        @Override // com.lynx.tasm.event.a
        public final String c() {
            return "detail";
        }

        public a(int r1, String r2, Map r3) {
            super(r1, r2, r3);
        }
    }

    @Override // com.lynx.animax.ability.BaseAbility
    public final e f() {
        return LynxAnimaX.inst().getScope();
    }

    @Override // t4a.f
    public final void a(t4a.c r2) {
        if (this.h == false) goto L6;
        m(LynxTemplateRender.RENDER_PHASE_UPDATE, r2);
        return;
    }

    @Override // t4a.f
    public final void b(t4a.c r2) {
        m("cancel", r2);
    }

    @Override // t4a.f
    public final void c(t4a.c r2) {
        m("ready", r2);
    }

    @Override // t4a.f
    public final void d(t4a.c r2) {
        m("repeat", r2);
    }

    @Override // t4a.f
    public final void e(t4a.c r2) {
        m("compositionready", r2);
    }

    @Override // t4a.f
    public final void g(t4a.b r2) {
        m("fps", r2);
    }

    @Override // com.lynx.animax.ability.BaseAbility
    public final String h(String r3) {
        LynxContext r0 = this.j.get();
        if (r0 != null) goto L6;
        return r3;
    L6:
        return d7a.a.b(r0, r3, false);
    }

    @Override // t4a.f
    public final void i(t4a.a r3) {
        int r0 = r3.b();
        if (r0 != AnimaXError.VIDEO_PLAYER_ERROR.getErrorCode()) goto L5;
        return;
    L5:
        if (r0 == AnimaXError.VIDEO_PLAYER_ERROR_HAS_OCCURRED.getErrorCode()) goto L10;
        m("error", r3);
        p(r3, "error");
        return;
    }

    @Override // t4a.f
    public final void j(t4a.c r2) {
        m("start", r2);
    }

    @Override // t4a.f
    public final void k(t4a.a r2) {
        m("warning", r2);
        p(r2, LynxError.LEVEL_WARN);
    }

    @Override // t4a.f
    public final void l(t4a.c r2) {
        m("completion", r2);
    }

    @Override // t4a.f
    public final void n(d r2) {
        m("taplayers", r2);
    }

    @Override // t4a.f
    public final void o(t4a.c r2) {
        m("firstframe", r2);
    }

    public b(LynxBaseUI r2, LynxContext r3) {
        this.h = true;
        this.i = new WeakReference(r2);
        this.j = new WeakReference(r3);
        ((CopyOnWriteArrayList) this.a).add(this);
    }

    public final void m(String r4, t4a.c r5) {
        LynxBaseUI r0 = this.i.get();
        LynxContext r1 = this.j.get();
        if (r0 == null) goto L11;
        if (r1 == null) goto L12;
        EventEmitter r2 = r1.getEventEmitter();
        if (r2 != null) goto L9;
        return;
    L9:
        r2.sendCustomEvent(new a(r0.getSign(), r4, r5.a));
        return;
    L12:
        return;
    }

    public final void p(t4a.a r9, String r10) {
        LynxContext r0 = this.j.get();
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = r9.b();
        Object r11 = r9.a.get("msg");
        if ((r11 instanceof String) == false) goto L8;
        String r12 = (String) r11;
    L9:
        LynxError r7 = new LynxError(r2, r12, NameKeys.UnloadStrategy_No_Strategy, r10, -2);
        r7.setLogBoxOnly(true);
        r0.handleLynxError(r7);
        return;
    L8:
        r12 = null;
        goto L9
    }
}
