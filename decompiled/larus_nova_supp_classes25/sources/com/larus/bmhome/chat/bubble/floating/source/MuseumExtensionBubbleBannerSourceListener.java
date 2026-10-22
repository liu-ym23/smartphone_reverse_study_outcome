package com.larus.bmhome.chat.bubble.floating.source;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\u0010\u001a\u00020\u0005*\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/source/MuseumExtensionBubbleBannerSourceListener;", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "<init>", "()V", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", "onShow", "", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", "onDismiss", "reason", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerDismissReason;", "onClick", "toMuseumExtensionRawNotify", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MuseumExtensionBubbleBannerSourceListener implements BubbleBannerSourceListener {
    public final String a;

    public static final class a {
    }

    static {
    }

    public MuseumExtensionBubbleBannerSourceListener() {
        this.a = "museum_extend_pack";
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String c() {
        return this.a;
    }

    public static String a(b r6) {
        JSONObject r0 = new JSONObject();
        Map<String, String> r1 = r6.m;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.get("stage");
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0.put("stage", r3);
        Map<String, String> r5 = r6.m;
        if (r5 == null) goto L12;
        r2 = r5.get("museum");
    L12:
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        r0.put("museum", r2);
        JSONObject r7 = new JSONObject();
        r7.put("banner_source", "museum_extend_pack");
        r7.put("ext", r0.toString());
        String r8 = r6.h;
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r7.put("button_text", r8);
        r7.put("priority", r6.j);
        JSONObject r9 = new JSONObject();
        r9.put("auto_dismiss_seconds", r6.i);
        Unit r10 = Unit.INSTANCE;
        r7.put("policy", r9.toString());
        r7.put("conversation_id", r6.c);
        JSONObject r11 = new JSONObject();
        r11.put("scene", "museum_extension_banner");
        r11.put("title", r6.e);
        String r12 = r6.f;
        if (r12 != null) goto L20;
        r12 = "";
    L20:
        r11.put("content", r12);
        String r13 = r6.g;
        if (r13 == null) goto L24;
        r4 = r13;
    L24:
        r11.put("icon", r4);
        r11.put("data", r7.toString());
        return r11.toString();
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String b(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return null;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void e(b r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        String r0 = a(r7);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[banner][general][show] promptId=");
        r2.append(r7.b);
        r2.append(", conversationId=");
        r2.append(r7.c);
        r2.append(", queryMessageId=");
        r2.append(r7.d);
        r2.append(", stage=");
        Map<String, String> r3 = r7.m;
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.get("stage");
    L6:
        r2.append(r5);
        r2.append(", museum=");
        Map<String, String> r8 = r7.m;
        if (r8 == null) goto L9;
        r4 = r8.get("museum");
    L9:
        r2.append(r4);
        r2.append(", rawNotify=");
        r2.append(r0);
        r1.i("MuseumExtensionDebug", r2.toString());
        VoiceCallServiceDelegate.a.h(r0);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void g(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void i(b r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        String r0 = a(r7);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[banner][general][click] promptId=");
        r2.append(r7.b);
        r2.append(", stage=");
        Map<String, String> r3 = r7.m;
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.get("stage");
    L6:
        r2.append(r5);
        r2.append(", museum=");
        Map<String, String> r8 = r7.m;
        if (r8 == null) goto L9;
        r4 = r8.get("museum");
    L9:
        r2.append(r4);
        r2.append(", rawNotify=");
        r2.append(r0);
        r1.i("MuseumExtensionDebug", r2.toString());
        VoiceCallServiceDelegate.a.g(r0);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void d(b r5, BubbleBannerDismissReason r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "reason");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[banner][general][dismiss] promptId=");
        r1.append(r5.b);
        r1.append(", reason=");
        r1.append(r6);
        r1.append(", stage=");
        Map<String, String> r7 = r5.m;
        String r2 = null;
        if (r7 == null) goto L5;
        String r8 = r7.get("stage");
    L6:
        r1.append(r8);
        r1.append(", museum=");
        Map<String, String> r9 = r5.m;
        if (r9 == null) goto L9;
        r2 = r9.get("museum");
    L9:
        r1.append(r2);
        r0.i("MuseumExtensionDebug", r1.toString());
        return;
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void h(b r1, sc8.a r2) {
        BubbleBannerSourceListener.a.a(r1, r2);
    }
}
