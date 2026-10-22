package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l extends mx.j implements View.OnClickListener {
    public final Function0<Unit> m;
    public final Context n;
    public final boolean o;

    public l(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(s1.B(2131919975), null, false, 6);
        this.n = r5;
        this.o = true;
        ((mx.j) this).l = this;
        this.m = UtilityKotlinExtentionsKt.y(new GiftEffectConfigurationItem$openDialog$1(this));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        this.m.invoke();
        Map r6 = MapsKt.emptyMap();
        List r0 = CollectionsKt.listOf(new Class[]{Room.class, am2.x.class, am2.o.class});
        com.bytedance.android.livesdk.log.g r1 = com.bytedance.android.livesdk.log.u.l();
        Object[] r2 = r0.toArray(new Class[0]);
        if (r2 == null) goto L7;
        r1.sendLog("livesdk_anchor_gift_effects_setting_click", r6, Arrays.copyOf(r2, r2.length));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
