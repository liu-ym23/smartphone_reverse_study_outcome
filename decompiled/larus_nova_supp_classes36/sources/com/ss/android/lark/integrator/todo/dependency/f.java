package com.ss.android.lark.integrator.todo.dependency;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.ss.android.lark.image.entity.Image;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements g7c.k {
    public f() {
    }

    public final Image a(ImageSet r2) {
        Intrinsics.checkNotNullParameter(r2, "pbImageSet");
        return new Image();
    }

    public final Observable b(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "photoPath");
        return Observable.error(new UnsupportedOperationException("uploadEncryptImageV2 is not supported in OfficeSDK Todo"));
    }
}
