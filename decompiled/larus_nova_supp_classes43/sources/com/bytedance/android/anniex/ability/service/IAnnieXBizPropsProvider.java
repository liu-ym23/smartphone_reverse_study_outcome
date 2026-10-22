package com.bytedance.android.anniex.ability.service;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.base.service.e;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXBizPropsProvider;", "Lcom/bytedance/android/anniex/base/service/e;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class IAnnieXBizPropsProvider implements e {
    public IAnnieXBizPropsProvider() {
    }

    public void a(Map<String, Object> r10, KitType r11, String r12, Uri r13) {
        Intrinsics.checkNotNullParameter(r10, "originProps");
        Intrinsics.checkNotNullParameter(r11, "kitType");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r13, "uri");
    }

    public Map<String, Object> b(KitType r10, String r11, Uri r12) {
        Intrinsics.checkNotNullParameter(r10, "kitType");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, "uri");
        return null;
    }

    public Map<String, Object> c(String r1, KitType r10, Context r11) {
        Intrinsics.checkNotNullParameter(r1, "bid");
        Intrinsics.checkNotNullParameter(r10, "kitType");
        return null;
    }
}
