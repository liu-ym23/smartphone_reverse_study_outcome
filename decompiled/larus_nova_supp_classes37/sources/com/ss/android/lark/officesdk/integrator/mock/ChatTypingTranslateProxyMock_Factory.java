package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatTypingTranslateProxyMock_Factory implements Factory<c> {

    public static final class a {
        public static final ChatTypingTranslateProxyMock_Factory a = null;

        static {
            a = new ChatTypingTranslateProxyMock_Factory();
        }
    }

    public ChatTypingTranslateProxyMock_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m99get();
    }

    public static ChatTypingTranslateProxyMock_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m99get() {
        return newInstance();
    }
}
