package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.h2;
import com.bytedance.android.live.core.setting.i2;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p extends f {
    public boolean t;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new wo1.i(this.a);
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ p a;

        public b(p r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new wo1.h(this.a);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f
    public final void i() {
        super.i();
        vo1.i r0 = this.e;
        if (r0 == null) goto L5;
        r0.registerMethod("loadShortTouch", new a(this));
    L5:
        DataCenter r1 = this.r;
        String r2 = null;
        if (r1 == null) goto L8;
        IRoom r3 = (IRoom) r1.get("data_room", null);
    L9:
        if (r3 == null) goto L15;
        ShortTermIndicatorConfig r4 = r3.getShortTermIndicatorConfig();
        if (r4 == null) goto L15;
        Map r5 = r4.getBigCardDisplayStrategy();
        if (r5 == null) goto L15;
        ShortTermIndicatorConfig.BigCardDisplayStrategy r6 = (ShortTermIndicatorConfig.BigCardDisplayStrategy) r5.get(Integer.valueOf(this.q.type));
    L16:
        if (r6 == null) goto L18;
        Boolean r7 = r6.getAllowRepeatDisplay();
    L20:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L27;
        if (((Boolean) h2.a.getValue()).booleanValue() == false) goto L27;
        vo1.i r8 = this.e;
        if (r8 == null) goto L27;
        r8.registerMethod("live.loadShortTouchBigCard", new b(this));
    L27:
        if (((Boolean) i2.a.getValue()).booleanValue() == false) goto L33;
        j0.l().sendLog("livesdk_short_touch_jsb_registe", MapsKt.mapOf(TuplesKt.to("time_millisecond", String.valueOf(System.currentTimeMillis()))), new Object[]{Room.class, x.class});
        StringBuilder r9 = new StringBuilder("loadShortTouch ");
        com.bytedance.android.live.base.model.q r10 = this.q.shortTouchInfo;
        if (r10 == null) goto L31;
        r2 = r10.loadUrl;
    L31:
        r9.append(r2);
        r9.append(" time_millisecond = ");
        r9.append(System.currentTimeMillis());
        ALogger.i("DynamicCommonIconModel", r9.toString());
        return;
    L33:
        return;
    L18:
        r7 = null;
    L15:
        r6 = null;
        goto L16
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f
    public final CommonIconTemplate f(int r2) {
        if (this.g != null) goto L5;
        this.g = d();
    L5:
        if (r2 == 0) goto L7;
        return null;
    L7:
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f
    public final /* bridge */ /* synthetic */ IconTemplate getViewForState(Object r1) {
        return f(((Number) r1).intValue());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f
    public final void k(com.bytedance.android.live.base.model.n r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        super.k(r4);
        DataCenter r0 = this.r;
        Boolean r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.get("data_room", null);
    L6:
        if (r2 == null) goto L12;
        ShortTermIndicatorConfig r3 = r2.getShortTermIndicatorConfig();
        if (r3 == null) goto L12;
        Map r5 = r3.getBigCardDisplayStrategy();
        if (r5 == null) goto L12;
        ShortTermIndicatorConfig.BigCardDisplayStrategy r6 = (ShortTermIndicatorConfig.BigCardDisplayStrategy) r5.get(Integer.valueOf(r4.type));
    L13:
        if (r6 == null) goto L16;
        r1 = r6.getAllowRepeatDisplay();
    L16:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L18;
        return;
    L18:
        if (((Boolean) h2.a.getValue()).booleanValue() == false) goto L22;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.q = r4;
        return;
    L22:
        return;
    L12:
        r6 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public p(com.bytedance.android.live.base.model.n r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3, 1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f
    public final void g(int r2, String r3, String r4, f.d r5) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "fallbackUrl");
        Intrinsics.checkNotNullParameter(r5, "callback");
        super.g(r2, r3, r4, r5);
        if (((Boolean) i2.a.getValue()).booleanValue() == false) goto L10;
        j0.l().sendLog("livesdk_short_touch_start_load", MapsKt.mapOf(TuplesKt.to("time_millisecond", String.valueOf(System.currentTimeMillis()))), new Object[]{Room.class, x.class});
        StringBuilder r6 = new StringBuilder("loadShortTouch ");
        com.bytedance.android.live.base.model.q r7 = this.q.shortTouchInfo;
        if (r7 == null) goto L7;
        String r8 = r7.loadUrl;
    L8:
        r6.append(r8);
        r6.append(" time_millisecond = ");
        r6.append(System.currentTimeMillis());
        ALogger.i("DynamicCommonIconModel", r6.toString());
        return;
    L7:
        r8 = null;
        goto L8
    }
}
