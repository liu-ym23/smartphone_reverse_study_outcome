package com.ss.android.lark.chat.preview.service.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UrlPreviewService_Factory implements Factory<UrlPreviewService> {

    public static final class a {
        public static final UrlPreviewService_Factory a = null;

        static {
            a = new UrlPreviewService_Factory();
        }
    }

    public UrlPreviewService_Factory() {
    }

    public static UrlPreviewService newInstance() {
        return new UrlPreviewService();
    }

    public UrlPreviewService get() {
        return newInstance();
    }

    public static UrlPreviewService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m675get() {
        return get();
    }
}
