package com.ss.android.lark.image.uploader.entity;

import android.content.Context;
import com.ss.android.lark.image.uploader.upload.e;
import hlb.d;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageUploadTask {
    public final Context a;
    public final ArrayList<b> b;
    public final ArrayList<d> c;
    public flb.a d;
    public flb.b e;
    public dlb.a f;
    public e g;
    public boolean h;
    public final Lazy i;

    public final String toString() {
        return "ImageUploadTask_" + ((String) this.i.getValue());
    }

    public final Context getContext() {
        return this.a;
    }

    public ImageUploadTask(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.h = true;
        this.i = LazyKt.lazy(new ImageUploadTask$taskId$2(this));
    }
}
