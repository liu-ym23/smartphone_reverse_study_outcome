package com.ss.android.lark.flow.chat.page.starter;

import dagger.internal.Factory;
import tgb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadWindowStarter_Factory implements Factory<b> {

    public static final class a {
        public static final FlowThreadWindowStarter_Factory a = null;

        static {
            a = new FlowThreadWindowStarter_Factory();
        }
    }

    public FlowThreadWindowStarter_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m148get();
    }

    public static FlowThreadWindowStarter_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m148get() {
        return newInstance();
    }
}
