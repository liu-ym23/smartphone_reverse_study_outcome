package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.live.profit.dress.config.DressResource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class w<T extends DressResource> {

    public static final class a extends w<DressResource> {
        public final ResourceLoadErrorType a;
        public final String b;
        public final Throwable c;

        public a(String r2, ResourceLoadErrorType r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "dressId");
            Intrinsics.checkNotNullParameter(r3, "reason");
            this.a = r3;
            this.b = r4;
            this.c = null;
        }
    }

    public static final class b<T extends DressResource> extends w<T> {
        public b(String r2, DressResource r3) {
            Intrinsics.checkNotNullParameter(r2, "dressId");
            Intrinsics.checkNotNullParameter(r3, "resource");
        }
    }

    public static final class c<T extends DressResource> extends w<T> {
        public final DressResource a;

        public c(String r2, DressResource r3) {
            Intrinsics.checkNotNullParameter(r2, "dressId");
            Intrinsics.checkNotNullParameter(r3, "resource");
            this.a = r3;
        }
    }

    public w() {
    }
}
