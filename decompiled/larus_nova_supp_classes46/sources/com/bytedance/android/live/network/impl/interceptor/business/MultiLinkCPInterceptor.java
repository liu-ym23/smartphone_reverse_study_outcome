package com.bytedance.android.live.network.impl.interceptor.business;

import com.bytedance.android.livesdk.config.link.MultiLinkReqABParamConfig;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkCPInterceptor implements b {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public MultiLinkCPInterceptor() {
        this.a = LazyKt.lazy(MultiLinkCPInterceptor$multiLinkConfigEnable$2.INSTANCE);
        this.b = LazyKt.lazy(MultiLinkCPInterceptor$multiLinkConfigList$2.INSTANCE);
        this.c = LazyKt.lazy(MultiLinkCPInterceptor$apiList$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.business.b
    public final void a(final String r9, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r10, "paramMapInOut");
        Lazy r0 = LazyKt.lazy(new MultiLinkCPInterceptor$handleMultiLinkSettingParams$urlCut$2(r9));
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L30;
        if ((!((List) this.b.getValue()).isEmpty()) == false) goto L30;
        List r1 = (List) this.b.getValue();
        ArrayList r4 = new ArrayList();
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L25;
        Object r5 = r2.next();
        MultiLinkReqABParamConfig.a r6 = (MultiLinkReqABParamConfig.a) r5;
        if (r6.c() == true) goto L12;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == false) goto L8;
        r4.add(r5);
        goto L8
    L12:
        if ((!StringsKt.isBlank(r6.a())) == false) goto L22;
        if ((!StringsKt.isBlank(r6.d())) == false) goto L22;
        if ((!StringsKt.isBlank(r6.e())) == false) goto L22;
        Regex r8 = r6.b();
        if (r8 == null) goto L22;
        if (r8.containsMatchIn((CharSequence) r0.getValue()) != true) goto L22;
        r7 = true;
        goto L23
    L25:
        Iterator r3 = r4.iterator();
    L27:
        if (r3.hasNext() == false) goto L30;
        MultiLinkReqABParamConfig.a r11 = (MultiLinkReqABParamConfig.a) r3.next();
        r10.put(r11.d(), r11.e());
    L30:
        if ((!((List) this.c.getValue()).isEmpty()) == false) goto L37;
        Iterator r12 = ((List) this.c.getValue()).iterator();
    L33:
        if (r12.hasNext() == false) goto L37;
        if (StringsKt.contains$default(r9, (String) r12.next(), false, 2, null) == false) goto L33;
        r10.put("linkmic_enter_from_merge", g4.d());
        r10.put("linkmic_enter_method", g4.e());
        r10.put("linkmic_action_type", g4.c());
    L37:
        ILiveRoomService r13 = k.f(ILiveRoomService.class);
        if (r13 == null) goto L64;
        Room r14 = r13.getCurrentRoomFromRoomContext();
        if (r14 == null) goto L65;
        String r15 = r14.getRequestId();
        if (r15 != null) goto L44;
        return;
    L44:
        if ((true ^ ((List) this.c.getValue()).isEmpty()) == false) goto L67;
        Iterator r16 = ((List) this.c.getValue()).iterator();
    L47:
        if (r16.hasNext() == false) goto L68;
        if (StringsKt.contains$default(r9, (String) r16.next(), false, 2, null) == false) goto L47;
        r10.put("linkmic_request_id", r15);
        return;
    L68:
        return;
    L67:
        return;
    L65:
        return;
    }
}
