package org.slf4j.helpers;

import java.io.Serializable;

/* JADX INFO: loaded from: classes8.dex */
abstract class NamedLoggerBase implements Serializable, org.slf4j.c {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    NamedLoggerBase() {
    }

    public String getName() {
        return this.name;
    }

    public Object readResolve() {
        return org.slf4j.d.a(getName());
    }
}
