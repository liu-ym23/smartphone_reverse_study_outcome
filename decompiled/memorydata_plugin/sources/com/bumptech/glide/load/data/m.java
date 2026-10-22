package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class m extends b<InputStream> {
    public m(AssetManager r1, String r2) {
        super(r1, r2);
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.b
    public /* synthetic */ InputStream a(AssetManager r1, String r2) {
        return b(r1, r2);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(InputStream r1) {
        r1.close();
    }

    @Override // com.bumptech.glide.load.data.b
    public /* synthetic */ void a(InputStream r3) {
        a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"));
    }

    public InputStream b(AssetManager r1, String r2) {
        return r1.open(r2);
    }
}
