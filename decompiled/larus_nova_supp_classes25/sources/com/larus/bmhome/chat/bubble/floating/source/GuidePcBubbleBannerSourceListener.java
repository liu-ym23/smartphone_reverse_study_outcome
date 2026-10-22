package com.larus.bmhome.chat.bubble.floating.source;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pc8.c;
import sc8.b;
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/source/GuidePcBubbleBannerSourceListener;", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "<init>", "()V", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", "onShow", "", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", "onClick", "pcGuideParams", "Lorg/json/JSONObject;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class GuidePcBubbleBannerSourceListener implements BubbleBannerSourceListener {
    public final String a;

    public static final class a {
    }

    static {
    }

    public GuidePcBubbleBannerSourceListener() {
        this.a = "pc_guide";
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String c() {
        return this.a;
    }

    public static JSONObject a(b r6) {
        c r0 = r6.l;
        Object r1 = null;
        if (r0 == null) goto L27;
        String r2 = r0.b;
        if (r2 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r2)) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L29;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r4 = Result.constructor-impl(new JSONObject(r2));     // Catch: Throwable -> L14
    L16:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L20;
        FLogger.a.w("GuidePcBubbleBannerSourceListener", "parse pc guide tracking failed, promptId=" + r6.b, r5);
    L20:
        if (Result.isFailure-impl(r4) == true) goto L24;
        r1 = r4;
    L24:
        return (JSONObject) r1;
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L29:
        return null;
    L27:
        return null;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String b(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return null;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void e(b r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        JSONObject r6 = a(r9);
        if (r6 != null) goto L5;
        return;
    L5:
        x1.f(null, null, null, null, null, r6, 95);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void g(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void i(b r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        JSONObject r6 = a(r9);
        if (r6 != null) goto L5;
        return;
    L5:
        x1.e(null, null, null, null, null, r6, 95);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void d(b r1, BubbleBannerDismissReason r2) {
        BubbleBannerSourceListener.a.b(r1, r2);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void h(b r1, sc8.a r2) {
        BubbleBannerSourceListener.a.a(r1, r2);
    }
}
