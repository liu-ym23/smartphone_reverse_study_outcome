package hs1;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T extends Widget> {
    public final String a;
    public final Class<T> b;
    public final Integer c;

    public /* synthetic */ c() {
        throw null;
    }

    public c(String r2, Class<T> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r3, "clazz");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
