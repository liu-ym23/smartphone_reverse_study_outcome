package com.bumptech.glide.load.resource.c;

import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a implements f<File, File> {
    public a() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public s<File> a2(File r1, int r2, int r3, e r4) {
        return new b(r1);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ s<File> a(File r3, int r4, int r5, e r6) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(File r1, e r2) {
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(File r3, e r4) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"), r4);
    }
}
