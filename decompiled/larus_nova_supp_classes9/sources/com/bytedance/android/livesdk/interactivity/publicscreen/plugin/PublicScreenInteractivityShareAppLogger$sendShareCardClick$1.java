package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import com.bytedance.android.live.base.model.data.m;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 4, 3})
final class PublicScreenInteractivityShareAppLogger$sendShareCardClick$1 extends Lambda implements Function1<HashMap<String, String>, Unit> {
    final /* synthetic */ m1 $message;

    public PublicScreenInteractivityShareAppLogger$sendShareCardClick$1(m1 r1) {
        this.$message = r1;
        super(1);
    }

    public final void invoke(HashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        Map<? extends String, ? extends String> r0 = this.$message.getTrackingParams();
        if (r0 == null) goto L5;
        r4.putAll(r0);
    L5:
        m r1 = this.$message.getItemStyle();
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L9;
        String r3 = r1.itemId;
        if (r3 == null) goto L9;
    L10:
        r4.put("card_id", r3);
        m r5 = this.$message.getItemStyle();
        if (r5 == null) goto L14;
        String r6 = r5.name;
        if (r6 == null) goto L14;
    L15:
        r4.put("item_name", r6);
        m r7 = this.$message.getItemStyle();
        if (r7 == null) goto L21;
        String r8 = r7.itemType;
        if (r8 == null) goto L21;
        r2 = r8;
    L21:
        r4.put("content", r2);
        IInteractivityInjectService r9 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r9 == null) goto L25;
        r9.checkThenDoInjectMiniAppParams(this.$message, r4);
        return;
    L25:
        return;
    L14:
        r6 = BuildConfig.FLAVOR;
    L9:
        r3 = BuildConfig.FLAVOR;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((HashMap) r1);
        return Unit.INSTANCE;
    }
}
