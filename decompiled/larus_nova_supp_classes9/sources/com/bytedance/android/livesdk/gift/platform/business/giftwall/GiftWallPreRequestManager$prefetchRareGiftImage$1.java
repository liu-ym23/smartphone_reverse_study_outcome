package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadOnlyProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftWallPreRequestManager$prefetchRareGiftImage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JsonObject $json;
    final /* synthetic */ GiftWallPreRequestManager this$0;

    public GiftWallPreRequestManager$prefetchRareGiftImage$1(GiftWallPreRequestManager r1, JsonObject r2) {
        this.this$0 = r1;
        this.$json = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m230invoke() {
        Iterator r0 = this.$json.getAsJsonArray("rare_gifts").iterator();
    L4:
        if (r0.hasNext() == false) goto L27;
        JsonElement r1 = (JsonElement) r0.next();
        GiftWallPreRequestManager r2 = this.this$0;
        ReadOnlyProperty r3 = GiftWallPreRequestManager.l;
        r2.getClass();
        String r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L12
        JsonElement r6 = (JsonElement) CollectionsKt.firstOrNull(r1.getAsJsonObject().get("gift_item").getAsJsonObject().get("gift").getAsJsonObject().get("image").getAsJsonObject().get("url_list").getAsJsonArray());     // Catch: Throwable -> L12
        if (r6 == null) goto L9;
        String r7 = r6.getAsString();     // Catch: Throwable -> L12
    L10:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r8) == false) goto L17;
        r8 = null;
    L17:
        String r9 = (String) r8;
        if (r9 == null) goto L4;
        if (r9.length() <= 0) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L25;
        r4 = r9;
    L25:
        if (r4 == null) goto L4;
        GiftWallPreRequestManager.k(this.this$0, r4);
        goto L4
    L22:
        r10 = false;
        goto L23
    L9:
        r7 = null;
    L12:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m230invoke();
        return Unit.INSTANCE;
    }
}
