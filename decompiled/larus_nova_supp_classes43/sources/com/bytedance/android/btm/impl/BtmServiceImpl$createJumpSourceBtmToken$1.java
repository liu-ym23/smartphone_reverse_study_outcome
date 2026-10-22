package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.model.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmServiceImpl$createJumpSourceBtmToken$1 extends Lambda implements Function0<String> {
    final /* synthetic */ d $btmModel;

    public BtmServiceImpl$createJumpSourceBtmToken$1(d r1) {
        this.$btmModel = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m615invoke() {
        StringBuilder r0 = new StringBuilder("btm=");
        r0.append(this.$btmModel.a);
        r0.append(" bcm=");
        r0.append(this.$btmModel.c);
        r0.append("pageFinder=");
        int r1 = com.bytedance.android.btm.impl.util.c.a;
        r0.append(com.bytedance.android.btm.impl.util.c.b(this.$btmModel.b));
        return r0.toString();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m615invoke();
    }
}
