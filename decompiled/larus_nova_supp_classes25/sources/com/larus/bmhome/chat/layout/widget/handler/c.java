package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ivy.ivykit.api.plugin.IvyPluginService;
import com.larus.bmhome.chat.layout.holder.helper.w0;
import com.larus.bmhome.chat.layout.item.LynxBox;
import com.larus.bmhome.utils.t2;
import com.larus.crossplatform.card.impl.LynxRenderDataRepo;
import com.larus.im.bean.message.Message;
import com.larus.ivykit.plugin.TemplateInfo;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.commonmark.node.HtmlBlock;
import org.json.JSONObject;
import va8.a0;
import va8.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements pw8.b {
    public final Message a;
    public final ComponentFeature b;
    public final Integer c;
    public final com.ivy.ivykit.api.plugin.d d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.widget.handler.c$c, reason: collision with other inner class name */
    public static final class C0064c implements Function0<a0> {
        public final /* synthetic */ AttachReceiver a;

        public C0064c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(a0.class));
        }
    }

    public static final class d implements Function0<y> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class e implements pw8.a {
        public final /* synthetic */ uvc.b a;
        public final /* synthetic */ c b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ Boolean d;

        public final void a(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "parent");
        }

        public final void b(int r8, ViewGroup r9) {
            Intrinsics.checkNotNullParameter(r9, "currentViewGroup");
            View r10 = r9.getChildAt(r8);
            HtmlBlock r11 = this.a;
            LynxBox r1 = null;
            if ((r11 instanceof HtmlBlock) == false) goto L5;
            HtmlBlock r0 = r11;
        L6:
            if (r0 == null) goto L63;
            c r2 = this.b;
            Context r3 = this.c;
            Boolean r4 = this.d;
            if ((r10 instanceof LynxBox) == false) goto L10;
            r1 = (LynxBox) r10;
        L10:
            if (r1 == null) goto L64;
            int r12 = t2.a;
            String r13 = t2.a(r2.a.getMessageId(), r11.h);
            if (r13 == null) goto L65;
            y r14 = (y) r2.g.getValue();
            if (r14 == null) goto L18;
            w0 r15 = r14.bn(r2.a, r2.b);
            if (r15 == null) goto L18;
            r1.w(r15);
        L18:
            String r16 = r2.a.getMessageId();
            boolean r5 = true;
            if (r16 != null) goto L21;
        L24:
            boolean r17 = true;
        L25:
            if (r17 == true) goto L61;
            JSONObject r18 = z.b(r13);
            if (r18 == null) goto L61;
            String r19 = r18.optString("data_url");
            String r20 = r18.optString("data");
            Intrinsics.checkNotNull(r19);
            if (r19.length() <= 0) goto L32;
            boolean r6 = true;
        L33:
            if (r6 == false) goto L43;
            Message r21 = r2.a;
            if (r21 == null) goto L38;
            String r22 = r21.getMessageId();
            if (r22 == null) goto L38;
        L39:
            CoroutineScope r7 = LynxRenderDataRepo.a;
            Intrinsics.checkNotNullParameter(r22, "key");
            if (LynxRenderDataRepo.b.b(r22) == true) goto L42;
            r1.q(LynxBox.LynxShowState.LOADING);
            LynxRenderDataRepo.b(r19, r22, new com.larus.bmhome.chat.layout.widget.handler.b(r22, r2, r1));
        L52:
            ViewGroup.LayoutParams r23 = r1.getLayoutParams();
            if (r23 == null) goto L60;
            ConstraintLayout.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
            r24.setMarginStart(0);
            r24.setMarginEnd(0);
            r1.setLayoutParams(r24);
            int r25 = r3.getResources().getDimensionPixelSize(2131167562);
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L57;
            int r26 = r3.getResources().getDimensionPixelSize(2131167562);
        L58:
            FLogger.a.i("updatePaddingRelative", "view:" + LynxBox.class.getSimpleName() + ",source:,start:0,top:" + r25 + ",end:0,bottom:" + r26);
            r1.setPaddingRelative(0, r25, 0, r26);
            goto L61
        L57:
            r26 = 0;
            goto L58
        L60:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L42:
            LynxRenderDataRepo.c(r22, new com.larus.bmhome.chat.layout.widget.handler.a(r22, r2, r1, r19));
        L38:
            r22 = "";
            goto L39
        L43:
            Intrinsics.checkNotNull(r20);
            if (r20.length() > 0) goto L47;
            r5 = false;
        L47:
            if (r5 == false) goto L52;
            if (Intrinsics.areEqual(r1.getTemplateInfo().getTemplateId(), "9") == false) goto L51;
            c.d(r2);
        L51:
            r2.e(r1, r20);
            goto L52
        L32:
            r6 = false;
        L61:
            Unit r27 = Unit.INSTANCE;
            return;
        L21:
            if (r16.length() == 0) goto L24;
            r17 = false;
            goto L25
        L65:
            return;
        L64:
            return;
        L63:
            return;
        L5:
            r0 = null;
            goto L6
        }

        public e(uvc.b r1, c r2, Context r3, Boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final int priority() {
        return 11;
    }

    public static final void d(c r3) {
        r3.getClass();
        JSONObject r0 = new JSONObject();
        a0 r1 = (a0) r3.f.getValue();
        if (r1 == null) goto L5;
        String r2 = r1.getBotId();
    L6:
        r0.put("bot_id", r2);
        r0.put("message_id", r3.a.getMessageId());
        String r4 = r3.a.getConversationId();
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r0.put("conversation_id", r4);
        r0.put("map_type", "multiple");
        com.larus.platform.service.o.a.reportEvent("map_card_show", r0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean c(uvc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        if ((r2 instanceof HtmlBlock) == false) goto L11;
        int r0 = vh8.a.a;
        HtmlBlock r3 = (HtmlBlock) r2;
        if (vh8.a.b(r3.h) == false) goto L11;
        int r1 = t2.a;
        if (Intrinsics.areEqual(t2.b(r3.h), "lynx") == false) goto L11;
        if (IvyPluginService.a.hasInit() == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final void e(LynxBox r9, String r10) {
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        com.ivy.ivykit.api.plugin.d r1 = this.d;
        HashMap r3 = new HashMap();
        r3.put("template_id", r9.getTemplateInfo().getTemplateId());
        a0 r4 = (a0) this.f.getValue();
        String r5 = null;
        if (r4 == null) goto L11;
        String r6 = r4.getBotId();
    L12:
        r3.put("bot_id", r6);
        r3.put("message_id", this.a.getMessageId());
        r3.put("conversation_id", this.a.getConversationId());
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.b = r3;
        com.ivy.ivykit.api.plugin.d r2 = this.d;
        HashMap r7 = new HashMap();
        r7.put("templateId", r9.getTemplateInfo().getTemplateId());
        a0 r8 = (a0) this.f.getValue();
        if (r8 == null) goto L15;
        String r11 = r8.getBotId();
    L16:
        r7.put("botId", r11);
        r7.put("messageId", this.a.getMessageId());
        r7.put("conversationId", this.a.getConversationId());
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r2.c = r7;
        String r12 = this.a.getMessageId();
        if (r12 != null) goto L19;
        r12 = "";
    L19:
        r9.z(r12, r10, this.d);
        va8.p r13 = (va8.p) this.e.getValue();
        if (r13 == null) goto L34;
        List r14 = r13.getCurrentList();
        if (r14 == null) goto L34;
        Iterator r15 = r14.iterator();
    L25:
        if (r15.hasNext() == false) goto L32;
        Object r16 = r15.next();
        if (((Message) r16).getContentType() != 50) goto L29;
        boolean r17 = true;
    L30:
        if (r17 == false) goto L25;
    L33:
        Message r18 = (Message) r16;
    L35:
        if (r18 == null) goto L38;
        r5 = r18.getMessageId();
    L38:
        if (Intrinsics.areEqual(r5, this.a.getMessageId()) == false) goto L48;
        va8.p r19 = (va8.p) this.e.getValue();
        if (r19 == null) goto L49;
        r19.n2();
        return;
    L49:
        return;
    L48:
        return;
    L29:
        r17 = false;
        goto L30
    L32:
        r16 = null;
    L34:
        r18 = null;
        goto L35
    L15:
        r11 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public final void f(LynxBox r4, String r5) {
        JSONObject r6 = z.b(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        a0 r1 = (a0) this.f.getValue();
        if (r1 == null) goto L8;
        String r2 = r1.getBotId();
    L9:
        r0.put("bot_id", r2);
        r0.put("message_id", this.a.getMessageId());
        r0.put("conversation_id", this.a.getConversationId());
        r0.put("card_type", r6.optString("ala_src"));
        r0.put("template_id", r4.getTemplateInfo().getTemplateId());
        com.larus.platform.service.o.a.reportEvent("card_show", r0);
        return;
    L8:
        r2 = null;
        goto L9
    }

    public c(Message r2, ComponentFeature r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "componentFeature");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new com.ivy.ivykit.api.plugin.d();
        this.e = LazyKt.lazy(new b(r3));
        this.f = LazyKt.lazy(new C0064c(r3));
        this.g = LazyKt.lazy(new d(r3));
    }

    public final pw8.a a(Context r8, int r9, uvc.b r10, Boolean r11, lw8.h r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, "node");
        if ((r10 instanceof HtmlBlock) == false) goto L5;
        HtmlBlock r13 = (HtmlBlock) r10;
    L6:
        if (r13 == null) goto L26;
        int r14 = t2.a;
        String r15 = t2.a(this.a.getMessageId(), ((HtmlBlock) r10).h);
        if (r15 == null) goto L26;
        TemplateInfo r2 = (TemplateInfo) GsonProtectorUtils.fromJson(new Gson(), r15, TemplateInfo.class);
        if (r2 != null) goto L12;
        return null;
    L12:
        String r16 = this.a.getMessageId();
        if (r16 != null) goto L15;
    L18:
        boolean r17 = true;
    L19:
        if (r17 == false) goto L21;
        return null;
    L21:
        JSONObject r18 = z.b(r15);
        if (r18 != null) goto L25;
        return null;
    L25:
        return new com.larus.bmhome.chat.layout.widget.handler.d(r8, r2, this, r18.optString("data_url"), r18.optString("data"), r11);
    L15:
        if (r16.length() == 0) goto L18;
        r17 = false;
    L26:
        return null;
    L5:
        r13 = null;
        goto L6
    }

    public final pw8.a b(Context r1, int r2, int r3, ViewGroup r4, uvc.b r5, Boolean r6, lw8.h r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "currentViewGroup");
        Intrinsics.checkNotNullParameter(r5, "node");
        return new e(r5, this, r1, r6);
    }
}
