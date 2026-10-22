package com.ss.android.lark.integrator.im.mock;

import dagger.internal.Factory;
import dnb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class StrangerActionUploaderSingleMock_Factory implements Factory<c> {

    public static final class a {
        public static final StrangerActionUploaderSingleMock_Factory a = null;

        static {
            a = new StrangerActionUploaderSingleMock_Factory();
        }
    }

    public StrangerActionUploaderSingleMock_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public c get() {
        return newInstance();
    }

    public static StrangerActionUploaderSingleMock_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m926get() {
        return get();
    }
}
