package com.ss.android.lark.framework.assembly.imageloader.diskclean;

import dagger.internal.Factory;
import gjb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageManuDiskCleanTrigger_Factory implements Factory<b> {

    public static final class a {
        public static final ImageManuDiskCleanTrigger_Factory a = null;

        static {
            a = new ImageManuDiskCleanTrigger_Factory();
        }
    }

    public ImageManuDiskCleanTrigger_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static ImageManuDiskCleanTrigger_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m663get() {
        return get();
    }
}
