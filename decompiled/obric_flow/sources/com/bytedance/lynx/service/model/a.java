package com.bytedance.lynx.service.model;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6832c;
    public String d;
    public final LynxServiceConfig$AdapterType e;

    public a(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f6830a = "";
        this.f6831b = "";
        this.f6832c = "";
        this.d = "";
        LynxServiceConfig$Builder$additionInit$1 r10 = LynxServiceConfig$Builder$additionInit$1.f6829a;
        this.e = LynxServiceConfig$AdapterType.f6827a;
    }
}
