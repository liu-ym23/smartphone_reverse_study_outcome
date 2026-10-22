package com.ss.android.lark.chat.preview.service;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UrlPreviewPush_Factory implements Factory<d> {

    public static final class a {
        public static final UrlPreviewPush_Factory a = null;

        static {
            a = new UrlPreviewPush_Factory();
        }
    }

    public UrlPreviewPush_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    public d get() {
        return newInstance();
    }

    public static UrlPreviewPush_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m673get() {
        return get();
    }
}
