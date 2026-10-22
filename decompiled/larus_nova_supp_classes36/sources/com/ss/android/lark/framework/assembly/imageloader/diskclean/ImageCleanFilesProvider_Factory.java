package com.ss.android.lark.framework.assembly.imageloader.diskclean;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageCleanFilesProvider_Factory implements Factory<gjb.a> {

    public static final class a {
        public static final ImageCleanFilesProvider_Factory a = null;

        static {
            a = new ImageCleanFilesProvider_Factory();
        }
    }

    public ImageCleanFilesProvider_Factory() {
    }

    public static gjb.a newInstance() {
        return new gjb.a();
    }

    public gjb.a get() {
        return newInstance();
    }

    public static ImageCleanFilesProvider_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m662get() {
        return get();
    }
}
