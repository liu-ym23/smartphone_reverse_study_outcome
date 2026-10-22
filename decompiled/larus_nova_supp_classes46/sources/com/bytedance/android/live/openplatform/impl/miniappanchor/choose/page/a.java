package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final List<AbstractC0141a> a;
    public int b;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0141a {
        public AbstractC0141a() {
        }

        public abstract void a(a r1);
    }

    public final void a() {
        List<AbstractC0141a> r0 = this.a;
        int r1 = this.b;
        this.b = r1 + 1;
        AbstractC0141a r2 = (AbstractC0141a) CollectionsKt.getOrNull(r0, r1);
        if (r2 == null) goto L6;
        r2.a(this);
        return;
    }

    public a() {
        this.a = new ArrayList();
    }
}
