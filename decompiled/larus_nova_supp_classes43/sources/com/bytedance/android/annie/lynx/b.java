package com.bytedance.android.annie.lynx;

import android.content.Context;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.AnnieCard$getBaseLifecycle$1;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements com.bytedance.android.annie.card.e.b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.android.annie.card.e.b
    public final IHybridComponent a(Context r10, CardParamVoNew r11, AnnieCard$getBaseLifecycle$1 r12, com.bytedance.android.annie.param.a r13) {
        return new LynxComponent(r10, r11, r12, new a(r13), r13);
    }
}
