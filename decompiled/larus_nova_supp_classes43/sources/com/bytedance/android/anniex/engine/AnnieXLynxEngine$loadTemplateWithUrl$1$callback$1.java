package com.bytedance.android.anniex.engine;

import android.net.Uri;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.utils.g;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.postprocessor.ProcessedData;
import com.bytedance.forest.postprocessor.f;
import com.bytedance.ies.bullet.forest.p;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxLoadOption;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.s0;
import i36.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/bytedance/forest/model/Response;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXLynxEngine$loadTemplateWithUrl$1$callback$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ ra.a $annieXLynxModel;
    final /* synthetic */ LynxLoadMode $loadMode;
    final /* synthetic */ AnnieXLynxEngine this$0;

    public AnnieXLynxEngine$loadTemplateWithUrl$1$callback$1(ra.a r1, AnnieXLynxEngine r10, LynxLoadMode r11) {
        this.$annieXLynxModel = r1;
        this.this$0 = r10;
        this.$loadMode = r11;
        super(1);
    }

    public final void invoke(Response r19) {
        Intrinsics.checkNotNullParameter(r19, "response");
        if (r19.r == false) goto L38;
        Map<String, d> r10 = MonitorManager.a;
        MonitorManager.C(this.$annieXLynxModel.g);
        MonitorManager.u(this.$annieXLynxModel.g);
        g.e(this.this$0, this.$annieXLynxModel.g);
        this.this$0.getClass();
        if ((r19 instanceof f) == false) goto L11;
        f r11 = (f) r19;
        if (r11.F == false) goto L11;
        if (r11.q() == null) goto L11;
    L12:
        p r12 = new p(UriProtector.parse(this.$annieXLynxModel.a), r19);
        AnnieXLynxEngine r1 = this.this$0;
        r1.j = r12;
        a r13 = r1.i;
        String r14 = String.valueOf(((d1) r12).f);
        r13.getClass();
        Intrinsics.checkNotNullParameter("geckoId", "key");
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        r13.z(new b(r13, "geckoId", r14));
        a r15 = this.this$0.i;
        String r16 = ((d1) r12).u;
        r15.getClass();
        Intrinsics.checkNotNullParameter("channel", "key");
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        r15.z(new b(r15, "channel", r16));
        if (r11 == null) goto L22;
        this.this$0.i.y("internalTemplateBundle", ((d1) r12).n);
        String r17 = this.$annieXLynxModel.g;
        long r18 = ((d1) r12).f;
        ProcessedData r20 = r11.E;
        if (r20 == null) goto L17;
        int r21 = r20.getSize();
    L18:
        MonitorManager.v(r17, null, "internalTemplateBundle", r18, r21);
        AnnieXLynxEngine r22 = this.this$0;
        ra.a r23 = this.$annieXLynxModel;
        LynxLoadMode r24 = this.$loadMode;
        r22.getClass();
        String r25 = r23.a;
        AnnieXLynxEngine.c(r25);
        r22.a(r23, "internalTemplateBundle", r12);
        s0.a r26 = new s0.a();
        r26.a = r25;
        r26.c = (TemplateBundle) r11.q();
        r26.d = r23.h;
        r26.f = r24;
        r26.a(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        if (r22.e == true) goto L21;
        r26.a(LynxLoadOption.PROCESS_LAYOUT_WITHOUT_UI_FLUSH);
    L21:
        s0 r27 = r26.b();
        MonitorManager.x(r23.g);
        r22.loadTemplate(r27);
        MonitorManager.y(r23.g);
        return;
    L17:
        r21 = 0;
        goto L18
    L22:
        byte[] r28 = r12.b();
        this.this$0.i.y(r12.a(), ((d1) r12).n);
        MonitorManager.w(this.$annieXLynxModel.g, r12, null, 28);
        AnnieXLynxEngine r29 = this.this$0;
        ra.a r30 = this.$annieXLynxModel;
        LynxLoadMode r110 = this.$loadMode;
        r29.getClass();
        if (r28 != null) goto L26;
        r29.b(r30.c, r30.g, "byte array is null. url: " + r30.b);
        return;
    L26:
        if (((d1) r12).d != ResourceFrom.CDN) goto L28;
        String r31 = r30.a;
    L31:
        String r111 = r31;
        AnnieXLynxEngine.c(r30.a);
        com.bytedance.ies.bullet.secure.a r32 = (com.bytedance.ies.bullet.secure.a) r29.k.getValue();
        if (r32 == null) goto L34;
        Uri r33 = r30.b;
        int r34 = com.bytedance.ies.bullet.secure.a.b;
        r32.a(r12, "AnnieXLynxEngine", r33, r28, null);
    L34:
        r29.a(r30, r12.a(), r12);
        s0.a r35 = new s0.a();
        r35.a = r111;
        r35.b = r28;
        r35.d = r30.h;
        r35.f = r110;
        r35.a(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        if (r29.e == true) goto L37;
        r35.a(LynxLoadOption.PROCESS_LAYOUT_WITHOUT_UI_FLUSH);
    L37:
        s0 r36 = r35.b();
        MonitorManager.x(r30.g);
        r29.loadTemplate(r36);
        MonitorManager.y(r30.g);
        return;
    L28:
        r31 = ((d1) r12).b;
        if (r31 != null) goto L31;
        r31 = r30.a;
    L11:
        r11 = null;
        goto L12
    L38:
        String r37 = "Failed to load template. url: " + this.$annieXLynxModel.b + ", error message: " + r19.s;
        AnnieXLynxEngine r38 = this.this$0;
        ra.a r39 = this.$annieXLynxModel;
        r38.b(r39.c, r39.g, r37);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Response) r1);
        return Unit.INSTANCE;
    }
}
