package com.ss.android.lark.officesdk.contact.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ContactOfficeImpl_Factory implements Factory<b> {

    public static final class a {
        public static final ContactOfficeImpl_Factory a = null;

        static {
            a = new ContactOfficeImpl_Factory();
        }
    }

    public ContactOfficeImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static ContactOfficeImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m28get() {
        return get();
    }
}
