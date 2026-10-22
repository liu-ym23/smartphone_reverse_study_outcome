package com.bytedance.android.live.revlink.impl.audience;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "Lcom/bytedance/revenue/platform/api/core/JSONObject;", "invoke"}, k = 3, mv = {1, 5, 1})
final class RevLinkAudienceMonitor$widgetLoadedButNotShown$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $currentSei;
    final /* synthetic */ JSONObject $extra;

    public RevLinkAudienceMonitor$widgetLoadedButNotShown$1(JSONObject r1, String r2) {
        this.$extra = r1;
        this.$currentSei = r2;
        super(1);
    }

    public final void invoke(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        int r4 = y50.b.a;
        y50.b.a.d(this.$extra, "current_sei", this.$currentSei);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
