package com.larksuite.component.card.cardcontainer;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larksuite.component.card.monitor.UniversalCardMonitorUtils;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.card.resources.e;
import com.larksuite.component.card.service.d;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.utils.LarkContext;
import idb.f;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UniversalCardLynxRender {
    public static final /* synthetic */ int g = 0;
    public ILarkLynxContainer a;
    public final com.larksuite.component.card.cardcontainer.a b;
    public final com.larksuite.component.card.cardcontainer.b c;
    public final Lazy d;
    public JsonObject e;
    public Integer f;

    public static final class a {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "CardInitData(initData=" + this.a + ", needUpdate=" + this.b + ')';
        }

        public a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "initData");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final Function1<CardData, CardData> a;
        public final Function1<CardContext, CardContext> b;
        public final Function1<CardConfig, CardConfig> c;
        public final Function0<Integer> d;

        public c(Function1 r2, Function1 r3) {
            this.a = null;
            this.b = r2;
            this.c = r3;
            this.d = null;
        }
    }

    static {
    }

    public UniversalCardLynxRender(final Lifecycle r2) {
        this.b = new com.larksuite.component.card.cardcontainer.a();
        this.c = new com.larksuite.component.card.cardcontainer.b();
        this.d = LazyKt.lazy(new UniversalCardLynxRender$cardServiceManager$2(r2, this));
    }

    public final void b(c r6) {
        Log.i("UniversalCardLynxRender", "reRender");
        if (this.a != null) goto L6;
        Log.e("UniversalCardLynxRender", "UniversalCardLynxRender is not init please try invoke create");
        return;
    L6:
        Object r1 = ((HashMap) this.b.getBizExtra()).get("card_share_data");
        if ((r1 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L9;
        com.larksuite.component.card.cardcontainer.c r2 = (com.larksuite.component.card.cardcontainer.c) r1;
    L10:
        if (r2 != null) goto L13;
        Log.e("UniversalCardLynxRender", "reRender shareData is null");
        return;
    L13:
        Object r0 = r2.b;
        Object r3 = r2.c;
        Object r4 = r2.d;
        Object r5 = r2.f;
        if (r6 == null) goto L27;
        Function1<CardData, CardData> r7 = r6.a;
        if (r7 == null) goto L18;
        r0 = r7.invoke(r0);
    L18:
        Function1<CardContext, CardContext> r8 = r6.b;
        if (r8 == null) goto L21;
        r3 = r8.invoke(r3);
    L21:
        Function1<CardConfig, CardConfig> r9 = r6.c;
        if (r9 == null) goto L24;
        r4 = r9.invoke(r4);
    L24:
        Function0<Integer> r10 = r6.d;
        if (r10 == null) goto L27;
        r5 = r10.invoke();
    L27:
        c((CardData) r0, (CardContext) r3, (CardConfig) r4, (Integer) r5);
        return;
    L9:
        r2 = null;
        goto L10
    }

    public final void c(CardData r19, CardContext r110, CardConfig r20, Integer r21) {
        Intrinsics.checkNotNullParameter(r19, "cardData");
        Intrinsics.checkNotNullParameter(r110, "cardContext");
        Intrinsics.checkNotNullParameter(r20, "cardConfig");
        if (this.a != null) goto L6;
        Log.e("UniversalCardLynxRender", "UniversalCardLynxRender is not init please try invoke create");
        return;
    L6:
        gz7.c r1 = (gz7.c) ((d) this.d.getValue()).getService(gz7.c.class);
        if (r1 == null) goto L9;
        r1.init();
    L9:
        Intrinsics.checkNotNullParameter(r19, "<this>");
        HashMap<String, AudioInfo> r2 = r19.getCardContent().getAttachment().getAudios();
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L17:
        if ((!r3) == true) goto L19;
    L23:
        ILarkLynxContainer r4 = this.a;
        if (r4 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r4 = null;
    L26:
        ILarkLynxContainer r14 = r4;
        this.f = r21;
        if (r21 == null) goto L29;
        r14.updateSize(View.MeasureSpec.makeMeasureSpec(r21.intValue(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    L29:
        HashMap r15 = new HashMap();
        com.larksuite.component.card.cardcontainer.c r6 = new com.larksuite.component.card.cardcontainer.c(r14.getLynxView().getContext(), r19, r110, r20, new cz7.a(), r21);
        r15.put("card_share_data", r6);
        com.larksuite.component.card.cardcontainer.a r5 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter("card_share_data", "key");
        Intrinsics.checkNotNullParameter(r6, "bizData");
        r5.a.put("card_share_data", r6);
        UniversalCardRuntimeJsLoader.b r7 = new UniversalCardRuntimeJsLoader().a();
        if (r7 == null) goto L34;
        String r8 = r7.a;
        if (r8 == null) goto L34;
        com.larksuite.component.card.cardcontainer.b r9 = this.c;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "templateJsVersion");
        r9.e = r8;
    L34:
        String r10 = ty7.a.a().getDebugUrl();
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == false) goto L51;
        if (r10 != null) goto L38;
    L41:
        boolean r11 = true;
    L42:
        if (r11 == true) goto L51;
        if (r14.hasRendered() == false) goto L49;
        a r12 = a(this, r19, r20, r110, true);
        Log.d("UniversalCardLynxRender", "has Rendered, updateData, needUpdate=" + r12.b);
        if (r12.b == false) goto L48;
        r14.updateData(r12.a, r15);
        return;
    L48:
        r14.updateShareData(r15);
        return;
    L49:
        Log.d("UniversalCardLynxRender", "first render");
        r14.render(r10, a(this, r19, r20, r110, false).a, r15);
        return;
    L38:
        if (r10.length() == 0) goto L41;
        r11 = false;
    L51:
        if (r14.hasRendered() == false) goto L56;
        Log.i("UniversalCardLynxRender", "has Rendered, updateData");
        a r13 = a(this, r19, r20, r110, true);
        if (r13.b == false) goto L55;
        r14.updateData(r13.a, r15);
        return;
    L55:
        r14.updateShareData(r15);
        return;
    L56:
        if (r7 == null) goto L61;
        Log.i("UniversalCardLynxRender", "before get init data2");
        a r16 = a(this, r19, r20, r110, false);
        if (r7.c == null) goto L60;
        Log.i("UniversalCardLynxRender", "render by bundle");
        r14.render(r7.c, r16.a, r15);
        return;
    L60:
        Log.e("UniversalCardLynxRender", "render error");
        return;
    L61:
        Log.e("UniversalCardLynxRender", "js info error");
        return;
    L19:
        if (f.a().isEnable("universalcard.audio.enable") == false) goto L23;
        e r17 = (e) ((d) this.d.getValue()).getService(e.class);
        if (r17 == null) goto L23;
        r17.g(r19);
        goto L23
    L12:
        if (r2.isEmpty() == true) goto L15;
        r3 = false;
        goto L17
    }

    public static a a(UniversalCardLynxRender r8, CardData r9, CardConfig r10, CardContext r11, boolean r12) {
        r8.getClass();
        TraceEvent.beginSection("UniversalCardLynxRender.getInitData");
        CardDataUtils.a.getClass();
        JsonObject r13 = CardDataUtils.j(r10, r11, r9, r12);
        long r1 = System.currentTimeMillis();
        if (r13.has("__lynx_timing_flag") == false) goto L5;
        JsonElement r3 = r13.remove("__lynx_timing_flag");
    L6:
        JsonElement r5 = r13.getAsJsonObject("context").remove("traceID");
        JsonObject r7 = r8.e;
        if (r7 == null) goto L9;
        r7.remove("__lynx_timing_flag");
        r7.getAsJsonObject("context").remove("traceID");
    L9:
        boolean r14 = Intrinsics.areEqual(r13, r8.e);
        if (r3 == null) goto L12;
        r13.add("__lynx_timing_flag", r3);
    L12:
        r13.getAsJsonObject("context").add("traceID", r5);
        r8.e = r13;
        Log.i("UniversalCardLynxRender", "compare json cost " + (System.currentTimeMillis() - r1));
        if (r14 == false) goto L15;
        Log.i("UniversalCardLynxRender", "isContentSame json same");
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        Log.i("UniversalCardLynxRender", "initData same");
        int r15 = UniversalCardMonitorUtils.a;
        UniversalCardMonitorUtils.b(true, r9.getUniversalCardID(), r11.getRenderTrace());
        a r16 = new a("", false);
    L19:
        TraceEvent.endSection("UniversalCardLynxRender.getInitData");
        return r16;
    L18:
        Log.i("UniversalCardLynxRender", "content not same");
        int r17 = UniversalCardMonitorUtils.a;
        UniversalCardMonitorUtils.b(false, r9.getUniversalCardID(), r11.getRenderTrace());
        r16 = new a(r13.toString(), true);
        goto L19
    L15:
        r2 = false;
        goto L16
    L5:
        r3 = null;
        goto L6
    }
}
