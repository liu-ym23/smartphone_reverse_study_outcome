package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftWallPreRequestManager$prefetchHomeGiftImage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JsonObject $json;
    final /* synthetic */ GiftWallPreRequestManager this$0;

    public GiftWallPreRequestManager$prefetchHomeGiftImage$1(GiftWallPreRequestManager r1, JsonObject r2) {
        this.this$0 = r1;
        this.$json = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m229invoke() {
        Iterator r0 = this.$json.getAsJsonArray("lighted_items").iterator();
        int r2 = 0;
    L3:
        String r4 = null;
        boolean r6 = true;
        if (r0.hasNext() == false) goto L17;
        JsonElement r3 = (JsonElement) r0.next();
        if (r2 >= 12) goto L3;
        String r5 = GiftWallPreRequestManager.j(this.this$0, r3);
        if (r5 == null) goto L3;
        if (r5.length() > 0) goto L13;
        r6 = false;
    L13:
        if (r6 == false) goto L15;
        r4 = r5;
    L15:
        if (r4 == null) goto L3;
        r2 = r2 + 1;
        GiftWallPreRequestManager.k(this.this$0, r4);
        goto L3
    L17:
        Iterator r1 = this.$json.getAsJsonArray("unlighted_items").iterator();
    L19:
        if (r1.hasNext() == false) goto L33;
        JsonElement r7 = (JsonElement) r1.next();
        if (r2 >= 12) goto L19;
        String r8 = GiftWallPreRequestManager.j(this.this$0, r7);
        if (r8 == null) goto L19;
        if (r8.length() <= 0) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L19;
        r2 = r2 + 1;
        GiftWallPreRequestManager.k(this.this$0, r8);
        goto L19
    L27:
        r9 = false;
        goto L28
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m229invoke();
        return Unit.INSTANCE;
    }
}
