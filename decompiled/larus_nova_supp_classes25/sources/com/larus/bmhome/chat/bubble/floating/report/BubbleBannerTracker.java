package com.larus.bmhome.chat.bubble.floating.report;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pc8.c;
import sc8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J$\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\f\u0010\u0016\u001a\u00020\u0015*\u00020\u000bH\u0002J\f\u0010\u0017\u001a\u00020\u0015*\u00020\u000bH\u0002J\u0016\u0010\u0018\u001a\u00020\t*\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/report/BubbleBannerTracker;", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "<init>", "()V", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", "onReceive", "", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", "onShow", "onClick", "onActionResult", "result", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerActionResult;", "reportPopupEvent", "eventName", "reportEvent", "extra", "Lorg/json/JSONObject;", "cardBaseParams", "baseParams", "merge", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BubbleBannerTracker implements BubbleBannerSourceListener {
    public static final Set<String> b = null;
    public final String a;

    public static final class a {
    }

    static {
        b = SetsKt.setOf(new String[]{"banner_card_send", "show_banner_card_guidance", "click_banner_card", "banner_card_action_result"});
    }

    public BubbleBannerTracker() {
        this.a = "*";
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String c() {
        return this.a;
    }

    public static JSONObject a(sc8.b r5) {
        c r0 = r5.l;
        if (r0 == null) goto L25;
        String r1 = r0.b;
        if (r1 == null) goto L25;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L25;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Object r3 = Result.constructor-impl(new JSONObject(r1));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L19;
        FLogger.a.w("BubbleBannerTracker", "parse diversion tracking failed, promptId=" + r5.b, r4);
    L19:
        JSONObject r6 = new JSONObject();
        if (Result.isFailure-impl(r3) == false) goto L23;
        r3 = r6;
    L23:
        return (JSONObject) r3;
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        return new JSONObject();
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String b(sc8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return null;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void e(sc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        j("popup_show", r3);
        f("show_banner_card_guidance", r3, null);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void g(sc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        f("banner_card_send", r3, null);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void i(sc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        j("popup_click", r3);
        f("click_banner_card", r3, null);
    }

    public static void j(String r7, sc8.b r8) {
        i.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "event");
        Iterator r0 = i.b(r8.a).iterator();
    L3:
        String r2 = null;
        if (r0.hasNext() == false) goto L25;
        BubbleBannerSourceListener r1 = (BubbleBannerSourceListener) r0.next();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        String r4 = r1.b(r8);     // Catch: Throwable -> L14
        if (r4 != null) goto L9;
    L11:
        r4 = null;
    L12:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L14
    L16:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L20;
        FLogger.a.w("BubbleBannerEventDispatcher", "resolve popup type failed, bannerSource=" + r8.a + ", promptId=" + r8.b, r6);
    L20:
        if (Result.isFailure-impl(r5) == false) goto L22;
        r5 = null;
    L22:
        String r9 = (String) r5;
        if (r9 == null) goto L3;
    L26:
        if (r9 != null) goto L35;
        String r10 = r8.a;
        if (r10 != null) goto L30;
    L32:
        if (r2 != null) goto L34;
        r9 = "unknown_bubble_banner";
        goto L35
    L34:
        r9 = r2;
        goto L35
    L30:
        if ((!StringsKt.isBlank(r10)) == false) goto L32;
        r2 = r10;
    L35:
        JSONObject r11 = new JSONObject();
        r11.put("popup_type", r9);
        Unit r12 = Unit.INSTANCE;
        f(r7, r8, r11);
        return;
    L9:
        if ((!StringsKt.isBlank(r4)) == false) goto L11;
    L14:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L25:
        r9 = null;
        goto L26
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void d(sc8.b r1, BubbleBannerDismissReason r2) {
        BubbleBannerSourceListener.a.b(r1, r2);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void h(sc8.b r4, sc8.a r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "result");
        JSONObject r0 = new JSONObject();
        Map<String, String> r6 = r5.a;
        if (r6 != null) goto L5;
    L13:
        Unit r7 = Unit.INSTANCE;
        f("banner_card_action_result", r4, r0);
        return;
    L5:
        if ((!r6.isEmpty()) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L13;
        Iterator<Map.Entry<String, String>> r8 = r6.entrySet().iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        Map.Entry<String, String> r1 = r8.next();
        r0.put(r1.getKey(), r1.getValue());
        goto L11
    }

    public static void f(String r4, sc8.b r5, JSONObject r6) {
        if (b.contains(r4) == false) goto L19;
        JSONObject r0 = new JSONObject();
        String r1 = r5.a;
        if (r1 != null) goto L7;
    L12:
        JSONObject r7 = a(r5);
        if (r7 == null) goto L20;
        Iterator<String> r2 = r7.keys();
    L17:
        if (r2.hasNext() == false) goto L20;
        String r3 = r2.next();
        r0.putOpt(r3, r7.opt(r3));
    L20:
        o r8 = o.a;
        if (r6 == null) goto L27;
        Iterator<String> r9 = r6.keys();
    L25:
        if (r9.hasNext() == false) goto L27;
        String r10 = r9.next();
        r0.putOpt(r10, r6.opt(r10));
    L27:
        Unit r11 = Unit.INSTANCE;
        r8.reportEvent(r4, r0);
        return;
    L7:
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        r0.put("banner_source", r1);
        goto L12
    L19:
        r0 = a(r5);
        goto L20
    }
}
