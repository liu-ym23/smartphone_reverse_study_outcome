package com.bytedance.android.annie.business.latch;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements q26.j {
    public final q26.a a;

    public final String getBid() {
        return "Latch";
    }

    public j() {
        this.a = new q26.a(null, false);
    }

    public final Map<Class<?>, Object> getAllDependency() {
        return getServiceContext().getAllDependency();
    }

    public final q26.h getServiceContext() {
        return this.a;
    }

    public final <T> T a(Class<T> r1) {
        return (T) q26.j.a.a(this, r1);
    }

    public final <T extends q26.c> T getService(Class<T> r1) {
        return (T) q26.j.a.b(this, r1);
    }
}
