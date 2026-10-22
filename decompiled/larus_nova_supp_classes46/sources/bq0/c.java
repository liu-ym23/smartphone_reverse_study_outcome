package bq0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends a {
    public final BusinessToolType b;
    public final int c;
    public final String d;
    public final String e;
    public final boolean f;

    @Override // bq0.a
    public final int a() {
        return this.c;
    }

    @Override // bq0.a
    public final BusinessToolType b() {
        return this.b;
    }

    @Override // bq0.a
    public final String c() {
        return this.d;
    }

    public c(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "description");
        Intrinsics.checkNotNullParameter(r4, "settingDesc");
        super(r3);
        this.d = r2;
        this.e = r4;
        this.f = r5;
        this.b = BusinessToolType.PrivateMsg;
        this.c = 2131252363;
    }
}
