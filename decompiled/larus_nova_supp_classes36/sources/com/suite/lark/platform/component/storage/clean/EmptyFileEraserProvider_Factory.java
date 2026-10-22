package com.suite.lark.platform.component.storage.clean;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EmptyFileEraserProvider_Factory implements Factory<g> {

    public static final class a {
        public static final EmptyFileEraserProvider_Factory a = null;

        static {
            a = new EmptyFileEraserProvider_Factory();
        }
    }

    public EmptyFileEraserProvider_Factory() {
    }

    public static g newInstance() {
        return new g();
    }

    public g get() {
        return newInstance();
    }

    public static EmptyFileEraserProvider_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1741get() {
        return get();
    }
}
