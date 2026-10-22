package cw1;

import android.text.TextUtils;
import bw1.e;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends e {
    @Override // bw1.e
    public final String a(int r1) {
        return "";
    }

    @Override // bw1.e
    public final void c() {
    }

    @Override // bw1.e
    public final String d() {
        return "";
    }

    @Override // bw1.e
    public final String e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "backUrl");
        return r2;
    }

    @Override // bw1.e
    public final String f() {
        return b() + "-drawer_cover";
    }

    @Override // bw1.e
    public final long g() {
        return this.f.f();
    }

    @Override // bw1.e
    public final String b() {
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L8;
        ILiveOntologyInfoManager r1 = r0.getLiveOntologyRecord();
        if (r1 == null) goto L8;
        String r2 = r1.getEnterFromMerge();
        if (r2 == null) goto L8;
    L9:
        String r3 = this.f.j();
        String r4 = this.f.e();
        if (TextUtils.isEmpty(r3) == true) goto L13;
        return r3;
    L13:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        return r4;
    L16:
        if (this.a.contains(r2) == false) goto L20;
        return "drawer_follow";
    L20:
        if (TextUtils.equals(r2, "homepage_fresh") == false) goto L22;
        return "drawer_city";
    L22:
        return "drawer_hot";
    L8:
        r2 = "drawer_null";
        goto L9
    }

    public c(com.bytedance.android.livesdk.feed.feed.e r2, TabListModel r3) {
        Intrinsics.checkNotNullParameter(r2, "itemTab");
        Intrinsics.checkNotNullParameter(r3, "tabListModel");
        super(r2, r3);
    }
}
