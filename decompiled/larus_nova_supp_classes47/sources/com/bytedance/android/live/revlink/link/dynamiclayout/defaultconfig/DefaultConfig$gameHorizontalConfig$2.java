package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import t51.g;
import t51.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$gameHorizontalConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$gameHorizontalConfig$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initGameLinkHorizontalConfig", "initGameLinkHorizontalConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m953invoke() {
        DefaultConfig r0 = (DefaultConfig) ((CallableReference) this).receiver;
        int r1 = DefaultConfig.m;
        r0.getClass();
        g r2 = new g();
        LinkedHashMap r3 = new LinkedHashMap();
        Integer r4 = Integer.valueOf(DeviceType.NORMAL_MOBILE_H.ordinal());
        t51.a r5 = new t51.a();
        AdjustBase r6 = AdjustBase.CONTENT;
        r5.m(r6.ordinal());
        LayoutScale r7 = LayoutScale.ASPECT_FIT;
        r5.t(r7.ordinal());
        LayoutAlign r8 = LayoutAlign.CENTER;
        r5.n(r8.ordinal());
        r5.s();
        AudienceHeightFixMode r9 = AudienceHeightFixMode.OriginContainerHeight;
        r5.r(r9.ordinal());
        i r10 = new i();
        r10.j(0.0f);
        r10.m(0.0f);
        r10.k(1.0f);
        r10.i(1.0f);
        Unit r12 = Unit.INSTANCE;
        r5.v(r10);
        r3.put(r4, r5);
        Integer r13 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r14 = new t51.a();
        r14.m(r6.ordinal());
        r14.t(r7.ordinal());
        r14.n(r8.ordinal());
        r14.r(r9.ordinal());
        i r15 = new i();
        r15.j(0.0f);
        r15.m(0.0f);
        r15.k(1.0f);
        r15.i(1.0f);
        r14.v(r15);
        r3.put(r13, r14);
        r2.g(r3);
        return r2;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m953invoke();
    }
}
