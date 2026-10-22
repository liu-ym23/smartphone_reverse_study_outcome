package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class h extends b<AssetFileDescriptor> {
    public h(AssetManager r1, String r2) {
        super(r1, r2);
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.b
    public /* synthetic */ AssetFileDescriptor a(AssetManager r1, String r2) {
        return b(r1, r2);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(AssetFileDescriptor r1) {
        r1.close();
    }

    @Override // com.bumptech.glide.load.data.b
    public /* synthetic */ void a(AssetFileDescriptor r3) {
        a2((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r3, AssetFileDescriptor.class, "com.obric.memorydata.plugin"));
    }

    public AssetFileDescriptor b(AssetManager r1, String r2) {
        return r1.openFd(r2);
    }
}
