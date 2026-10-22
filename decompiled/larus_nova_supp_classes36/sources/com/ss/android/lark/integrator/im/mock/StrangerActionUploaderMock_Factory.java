package com.ss.android.lark.integrator.im.mock;

import dagger.internal.Factory;
import dnb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class StrangerActionUploaderMock_Factory implements Factory<b> {

    public static final class a {
        public static final StrangerActionUploaderMock_Factory a = null;

        static {
            a = new StrangerActionUploaderMock_Factory();
        }
    }

    public StrangerActionUploaderMock_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static StrangerActionUploaderMock_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m925get() {
        return get();
    }
}
