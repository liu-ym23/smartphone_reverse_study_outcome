package r80;

import android.content.res.Configuration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements com.bytedance.android.live.core.log.c {
    public final /* synthetic */ Configuration a;
    public final /* synthetic */ float b;

    public i(Configuration r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "Samsung height " + this.a.screenHeightDp + " width: " + this.a.screenWidthDp + " ratio = " + this.b;
    }
}
