package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f5669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f5670c;
    public we.a d;
    public final Function1 e;
    public Boolean f;

    public b(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f5668a = new ArrayList();
        this.f5669b = new ArrayList();
        this.f5670c = new LinkedHashMap();
        this.e = LynxConfig$Builder$additionInit$1.f5666a;
    }
}
