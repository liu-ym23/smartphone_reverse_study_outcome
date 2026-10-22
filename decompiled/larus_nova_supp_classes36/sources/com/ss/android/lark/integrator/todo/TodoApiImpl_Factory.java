package com.ss.android.lark.integrator.todo;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TodoApiImpl_Factory implements Factory<TodoApiImpl> {

    public static final class a {
        public static final TodoApiImpl_Factory a = null;

        static {
            a = new TodoApiImpl_Factory();
        }
    }

    public TodoApiImpl_Factory() {
    }

    public static TodoApiImpl newInstance() {
        return new TodoApiImpl();
    }

    public TodoApiImpl get() {
        return newInstance();
    }

    public static TodoApiImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m957get() {
        return get();
    }
}
