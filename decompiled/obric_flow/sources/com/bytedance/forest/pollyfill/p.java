package com.bytedance.forest.pollyfill;

import com.bytedance.forest.model.ForestBuffer;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements com.bytedance.forest.model.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f4532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f4533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f4534c;

    public p(q r5, d r10) {
        this.f4533b = r5;
        this.f4534c = r10;
    }

    @Override // com.bytedance.forest.model.a
    public final InputStream a() {
        if (this.f4532a == true) goto L6;
        this.f4532a = true;
        return this.f4534c.b();
    L6:
        com.bytedance.forest.utils.d.b(this.f4533b.f4537a.g, 6, ForestBuffer.TAG, "repeatedly calling provide input stream", true, null, null, 48);
        return null;
    }

    @Override // com.bytedance.forest.model.a
    public final boolean b() {
        return false;
    }
}
