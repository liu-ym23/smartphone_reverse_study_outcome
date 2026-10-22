package com.bytedance.android.annie.card;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.ies.web.jsbridge2.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final Map<IHybridComponent.HybridType, b> a;

    public class a implements j9.a {
        public final /* synthetic */ com.bytedance.android.annie.param.a a;
        public final /* synthetic */ Context b;

        @Override // j9.a
        public final List<com.bytedance.android.annie.card.base.b> a() {
            int r1 = j9.c.a;
            Context r10 = this.b;
            Intrinsics.checkNotNullParameter(r10, "context");
            List r11 = CollectionsKt.mutableListOf(new com.bytedance.android.annie.card.base.b[]{new com.bytedance.android.annie.card.web.c(r10)});
            r11.addAll(((n9.b) Annie.getService$default(n9.b.class, null, 2, null)).a());
            return new ArrayList(r11);
        }

        @Override // j9.a
        public final List<u> b(View r10) {
            ArrayList r0 = new ArrayList();
            int r1 = j9.c.a;
            r0.addAll(j9.c.a(this.a.getBizKey()));
            Intrinsics.checkNotNullParameter(r10, "view");
            r0.addAll(((n9.b) Annie.getService$default(n9.b.class, null, 2, null)).b(r10));
            return r0;
        }

        public a(com.bytedance.android.annie.param.a r1, Context r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public interface b {
        IHybridComponent a(Context r1, CardParamVoNew r10, AnnieCard$getBaseLifecycle$1 r11, com.bytedance.android.annie.param.a r12);
    }

    public e() {
        HashMap r0 = new HashMap();
        this.a = r0;
        IHybridComponent.HybridType r1 = IHybridComponent.HybridType.H5;
        b r10 = new d(this);
        if (r0.containsKey(r1) == true) goto L7;
        r0.put(r1, r10);
        return;
    }
}
