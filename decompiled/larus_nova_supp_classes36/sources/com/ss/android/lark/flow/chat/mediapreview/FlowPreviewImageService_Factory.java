package com.ss.android.lark.flow.chat.mediapreview;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowPreviewImageService_Factory implements Factory<c> {

    public static final class a {
        public static final FlowPreviewImageService_Factory a = null;

        static {
            a = new FlowPreviewImageService_Factory();
        }
    }

    public FlowPreviewImageService_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public c get() {
        return newInstance();
    }

    public static FlowPreviewImageService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m46get() {
        return get();
    }
}
