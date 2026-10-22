package com.bytedance.android.annie.service.resource;

import com.bytedance.android.annie.api.card.IHybridComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements e {
    public b() {
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final int A1(String r1, boolean r10, String r11, String r12, IHybridComponent.HybridType r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "type");
        return -1;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final boolean D1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return false;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final boolean F0(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return false;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final void h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final boolean l(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return false;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final int m(String r1, JSONObject r10, String r11, String r12, String r13, IHybridComponent.HybridType r14, String r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r14, "type");
        Intrinsics.checkNotNullParameter(r15, "bizKey");
        return -1;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final h o0(String r10, RequestConfig r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "requestConfig");
        return null;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final String t1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return r10;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final h x(String r10, RequestConfig r11, Function1<? super i, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "requestConfig");
        Intrinsics.checkNotNullParameter(r12, "resolve");
        return null;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final d b1(String r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        return new d(0);
    }
}
