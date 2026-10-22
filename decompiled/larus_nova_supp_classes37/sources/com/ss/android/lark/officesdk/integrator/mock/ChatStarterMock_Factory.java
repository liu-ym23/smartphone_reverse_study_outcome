package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatStarterMock_Factory implements Factory<ytb.a> {

    public static final class a {
        public static final ChatStarterMock_Factory a = null;

        static {
            a = new ChatStarterMock_Factory();
        }
    }

    public ChatStarterMock_Factory() {
    }

    public static ytb.a newInstance() {
        return new ytb.a();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m97get();
    }

    public static ChatStarterMock_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public ytb.a m97get() {
        return newInstance();
    }
}
