package com.bytedance.forest.chain.fetchers;

import android.net.Uri;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ForestBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements com.bytedance.forest.model.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewlyBuiltinFetcher f4299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.geckox.d f4300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f4301c;

    public l(NewlyBuiltinFetcher r5, com.bytedance.geckox.d r10, Uri r11) {
        this.f4299a = r5;
        this.f4300b = r10;
        this.f4301c = r11;
    }

    @Override // com.bytedance.forest.model.a
    public final InputStream a() {
        Uri r5 = this.f4301c;
        String r10 = r5.getScheme();     // Catch: Exception -> L13
        if (r10 == null) goto L20;
        int r11 = r10.hashCode();     // Catch: Exception -> L13
        if (r11 == 3143036) goto L16;
        if (r11 != 93121264) goto L20;
        if (r10.equals("asset") == false) goto L20;
        return Forest.Companion.getApp().getAssets().open(StringsKt.A(r5.getPath(), "/"));
    L16:
        if (r10.equals("file") == false) goto L20;
        return new FileInputStream(new File(r5.getPath()));
    L20:
        throw new IOException(r5.toString() + " is neither file nor asset");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        this.f4299a.getContext$forest_release().g.a(6, ForestBuffer.TAG, true, e, "buildin_get_input_stream_error", new NewlyBuiltinFetcher$fetchAsync$$inlined$apply$lambda$1$1(this, e));
        return null;
    }

    @Override // com.bytedance.forest.model.a
    public final boolean b() {
        return true;
    }
}
