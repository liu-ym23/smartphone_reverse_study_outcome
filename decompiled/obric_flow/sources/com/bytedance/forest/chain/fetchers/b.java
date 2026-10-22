package com.bytedance.forest.chain.fetchers;

import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ForestBuffer;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.bytedance.forest.model.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BuiltinFetcher f4286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4287b;

    public b(BuiltinFetcher r5, String r10) {
        this.f4286a = r5;
        this.f4287b = r10;
    }

    @Override // com.bytedance.forest.model.a
    public final InputStream a() {
        return Forest.Companion.getApp().getAssets().open(this.f4287b);
    L4:
        e = move-exception;
        this.f4286a.getContext$forest_release().g.a(6, ForestBuffer.TAG, true, e, "buildin_get_input_stream_error", new BuiltinFetcher$fetchAsync$$inlined$apply$lambda$1$1(e));
        return null;
    }

    @Override // com.bytedance.forest.model.a
    public final boolean b() {
        return true;
    }
}
