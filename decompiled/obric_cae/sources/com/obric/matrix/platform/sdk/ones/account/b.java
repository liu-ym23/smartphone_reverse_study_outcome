package com.obric.matrix.platform.sdk.ones.account;

import android.annotation.SuppressLint;
import android.app.Application;
import he.j;
import xd.f;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"PrivateApi"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f6110a = null;

    public static final class a extends j implements ge.a<Application> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6111a = null;

        static {
            f6111a = new a();
        }

        public a() {
            super(0);
        }

        @Override // ge.a
        public final Application f() {
            Object r8 = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            if (r8 == null) goto L7;
            return (Application) r8;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
    }

    static {
        f6110a = defpackage.c.R(a.f6111a);
    }
}
