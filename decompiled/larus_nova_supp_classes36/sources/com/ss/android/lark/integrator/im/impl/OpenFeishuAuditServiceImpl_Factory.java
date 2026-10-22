package com.ss.android.lark.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OpenFeishuAuditServiceImpl_Factory implements Factory<h> {

    public static final class a {
        public static final OpenFeishuAuditServiceImpl_Factory a = null;

        static {
            a = new OpenFeishuAuditServiceImpl_Factory();
        }
    }

    public OpenFeishuAuditServiceImpl_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    public h get() {
        return newInstance();
    }

    public static OpenFeishuAuditServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m900get() {
        return get();
    }
}
