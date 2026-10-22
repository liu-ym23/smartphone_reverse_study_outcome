package com.bytedance.forest.pollyfill;

import com.bytedance.forest.model.ForestBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements com.bytedance.forest.model.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f4509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.forest.utils.e f4510b;

    public f(File r5, com.bytedance.forest.utils.e r10) {
        this.f4509a = r5;
        this.f4510b = r10;
    }

    @Override // com.bytedance.forest.model.a
    public final InputStream a() {
        return new FileInputStream(this.f4509a);
    L4:
        e = move-exception;
        this.f4510b.g.a(6, ForestBuffer.TAG, true, e, "cdn_downloader_get_input_stream_error", new DownloadDepender$Companion$fetchCache$$inlined$apply$lambda$1$1(this, e));
        return null;
    }

    @Override // com.bytedance.forest.model.a
    public final boolean b() {
        return true;
    }
}
