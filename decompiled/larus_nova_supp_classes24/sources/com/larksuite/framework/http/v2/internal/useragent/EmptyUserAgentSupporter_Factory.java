package com.larksuite.framework.http.v2.internal.useragent;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class EmptyUserAgentSupporter_Factory implements Factory<e28.a> {

    public static final class a {
        public static final EmptyUserAgentSupporter_Factory a = null;

        static {
            a = new EmptyUserAgentSupporter_Factory();
        }
    }

    public EmptyUserAgentSupporter_Factory() {
    }

    public static e28.a newInstance() {
        return new e28.a();
    }

    public e28.a get() {
        return newInstance();
    }

    public static EmptyUserAgentSupporter_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m325get() {
        return get();
    }
}
