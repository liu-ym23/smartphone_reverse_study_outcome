package com.ss.android.lark.integrator.im.impl.chat;

import dagger.internal.Factory;
import smb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeChatService_Factory implements Factory<e> {

    public static final class a {
        public static final OfficeChatService_Factory a = null;

        static {
            a = new OfficeChatService_Factory();
        }
    }

    public OfficeChatService_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m905get();
    }

    public static OfficeChatService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m905get() {
        return newInstance();
    }
}
