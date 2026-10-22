package uv1;

import com.bytedance.android.livesdk.feed.g;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements g {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    @Override // com.bytedance.android.livesdk.feed.g
    public final String sR() {
        String r0 = this.b;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final String url() {
        String r0 = this.a;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final Map SR() {
        return Collections.emptyMap();
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final int I9() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final int f8() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final long hC() {
        return this.c;
    }

    public b(String r1, String r2, long r3, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = 10;
        this.e = r5;
    }
}
