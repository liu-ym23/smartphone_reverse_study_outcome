package com.bytedance.android.livesdk.dslservice.util;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements yt1.h {
    public final /* synthetic */ Context a;

    @Override // yt1.h
    public final String a() {
        return "scheme";
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.Scheme;
    }

    public h(Context r1) {
        this.a = r1;
    }

    @Override // yt1.h
    public final void b(Map r10, yt1.j r11) {
        if (r10 == null) goto L5;
        Object r0 = r10.get("scheme");
    L7:
        if ((r0 instanceof String) == true) goto L9;
        r0 = null;
    L9:
        String r1 = (String) r0;
        if (r1 == null) goto L29;
        Uri.Builder r2 = UriProtector.parse(r1).buildUpon();
        Iterator r12 = r10.entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L20;
        Map.Entry r3 = (Map.Entry) r12.next();
        if (StringsKt.startsWith$default((String) r3.getKey(), "scheme_extra_", false, 2, null) == false) goto L13;
        String r4 = StringsKt.replace$default((String) r3.getKey(), "scheme_extra_", "", false, 4, null);
        Object r5 = r3.getValue();
        if ((r5 instanceof String) == true) goto L19;
        r5 = null;
    L19:
        r2.appendQueryParameter(r4, (String) r5);
        goto L13
    L20:
        String r13 = r2.toString();
        IBaseLiveActionHandler r14 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r14 == null) goto L30;
        r14.handle(this.a, r13);
        return;
    L30:
        return;
    L29:
        return;
    L5:
        r0 = null;
        goto L7
    }
}
