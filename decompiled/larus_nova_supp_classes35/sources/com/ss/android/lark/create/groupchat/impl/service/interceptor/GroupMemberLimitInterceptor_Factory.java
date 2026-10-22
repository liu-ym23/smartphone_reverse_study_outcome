package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupMemberLimitInterceptor_Factory implements Factory<GroupMemberLimitInterceptor> {

    public static final class a {
        public static final GroupMemberLimitInterceptor_Factory a = null;

        static {
            a = new GroupMemberLimitInterceptor_Factory();
        }
    }

    public GroupMemberLimitInterceptor_Factory() {
    }

    public static GroupMemberLimitInterceptor newInstance() {
        return new GroupMemberLimitInterceptor();
    }

    public GroupMemberLimitInterceptor get() {
        return newInstance();
    }

    public static GroupMemberLimitInterceptor_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1124get() {
        return get();
    }
}
