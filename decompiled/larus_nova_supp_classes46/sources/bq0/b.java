package bq0;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends a {
    public final BusinessToolType b;
    public final String c;
    public final int d;

    public b() {
        super(s1.B(2131920919));
        this.b = BusinessToolType.Coupon;
        this.c = s1.B(2131921068);
        this.d = 2131252360;
    }

    @Override // bq0.a
    public final int a() {
        return this.d;
    }

    @Override // bq0.a
    public final BusinessToolType b() {
        return this.b;
    }

    @Override // bq0.a
    public final String c() {
        return this.c;
    }
}
