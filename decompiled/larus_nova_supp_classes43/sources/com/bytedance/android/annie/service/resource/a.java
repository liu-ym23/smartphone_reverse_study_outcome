package com.bytedance.android.annie.service.resource;

import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements f {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.android.annie.service.resource.f
    public final List<String> r() {
        return ((f) Annie.getService$default(f.class, null, 2, null)).r();
    }

    @Override // com.bytedance.android.annie.service.resource.f
    public final String Z(String r10) {
        return ((f) Annie.getService$default(f.class, null, 2, null)).Z(r10);
    }

    @Override // com.bytedance.android.annie.service.resource.f
    public final WebResourceResponse j(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue() == true) goto L5;
        return null;
    L5:
        return ((f) Annie.getService$default(f.class, null, 2, null)).j(r10);
    }
}
