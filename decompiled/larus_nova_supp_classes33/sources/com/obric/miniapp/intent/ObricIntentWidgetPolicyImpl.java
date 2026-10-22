package com.obric.miniapp.intent;

import com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy;
import com.obric.assistant.spi.miniapp.ObricIntentWidgetUpdateMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/miniapp/intent/ObricIntentWidgetPolicyImpl;", "Lcom/obric/assistant/spi/miniapp/IObricIntentWidgetPolicy;", "<init>", "()V", "resolve", "Lcom/obric/assistant/spi/miniapp/ObricIntentWidgetPolicy;", "renderData", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricIntentWidgetPolicyImpl implements IObricIntentWidgetPolicy {
    public static final rga.a a = null;

    public static final class a {
    }

    public ObricIntentWidgetPolicyImpl() {
    }

    static {
        a = new rga.a(0);
    }

    @Override // com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy
    public final rga.a resolve(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        JSONObject r3 = new JSONObject(r4);     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(r3.optString("applet_id"), "ability.intent.card") == true) goto L17;
        return a;
    L17:
        if (Intrinsics.areEqual(r3.optString("widget_id"), "appintent_alarm") == false) goto L19;
        ObricIntentWidgetUpdateMode r5 = ObricIntentWidgetUpdateMode.UPDATE_IN_PLACE;     // Catch: Throwable -> L22
    L20:
        Object r6 = Result.constructor-impl(new rga.a(r5, true, 134));     // Catch: Throwable -> L22
    L24:
        rga.a r0 = a;
        if (Result.isFailure-impl(r6) == false) goto L28;
        r6 = r0;
    L28:
        return (rga.a) r6;
    L19:
        r5 = ObricIntentWidgetUpdateMode.RECREATE;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L11:
        return a;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r1 = false;
        goto L9
    }
}
