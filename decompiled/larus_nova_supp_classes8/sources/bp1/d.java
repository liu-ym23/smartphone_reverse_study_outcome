package bp1;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class d {
    public static final /* synthetic */ int i = 0;
    public final String a;
    public final ImageModel b;
    public final String c;
    public final Object d;
    public final boolean e;
    public final int f;
    public final Integer g;
    public i h;

    public static final class a {
    }

    static {
    }

    public final String getType() {
        return this.a;
    }

    public d(String r2, String r3, boolean r4, Integer r5, i r6) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_TITLE);
        this.a = r2;
        this.b = null;
        this.c = r3;
        this.d = null;
        this.e = r4;
        this.f = 1;
        this.g = r5;
        this.h = r6;
    }
}
