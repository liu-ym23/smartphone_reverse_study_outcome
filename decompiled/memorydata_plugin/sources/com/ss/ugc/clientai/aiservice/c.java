package com.ss.ugc.clientai.aiservice;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/AIPredictInput;", "", "data", "(Ljava/lang/Object;)V", "get", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f15778a;

    public c(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.f15778a = r2;
    }

    public final <T> T a() {
        return (T) this.f15778a;
    }
}
