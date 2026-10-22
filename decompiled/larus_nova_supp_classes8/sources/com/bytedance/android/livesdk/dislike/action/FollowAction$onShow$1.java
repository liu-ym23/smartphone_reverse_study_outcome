package com.bytedance.android.livesdk.dislike.action;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.dislike.ItemType;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class FollowAction$onShow$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function1 $reload;
    final /* synthetic */ FollowAction this$0;

    public FollowAction$onShow$1(FollowAction r1, Function1 r2) {
        this.this$0 = r1;
        this.$reload = r2;
        super(1);
    }

    public final void invoke(boolean r4) {
        if (r4 == false) goto L11;
        Pair[] r5 = new Pair[3];
        ItemType r0 = ItemType.UNFOLLOW;
        r5[0] = TuplesKt.to(LiveEndPageData.TAG_TITLE, r0.getDesc());
        r5[1] = TuplesKt.to("option_action", new FollowAction$onShow$1$reloadMap$1(this));
        Integer r1 = r0.getImgRes();
        if (r1 == null) goto L6;
        int r2 = r1.intValue();
    L7:
        r5[2] = TuplesKt.to("icon", s1.m(r2));
        HashMap r6 = MapsKt.hashMapOf(r5);
        Function1 r3 = this.$reload;
        if (r3 == null) goto L12;
        Unit r7 = (Unit) r3.invoke(r6);
        return;
    L12:
        return;
    L6:
        r2 = 2131253172;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
