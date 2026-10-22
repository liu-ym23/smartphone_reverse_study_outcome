package bq0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a {
    public final String a;

    public abstract int a();

    public abstract BusinessToolType b();

    public abstract String c();

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "description");
        this.a = r2;
    }
}
