package com.facebook.imagepipeline.core;

import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePipelineExperiments {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultProducerFactoryMethod f8091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Supplier f8092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8093c;
    public final boolean d;
    public final int e;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Supplier f8094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f8095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f8096c;
        public final int d;

        public Builder() {
            this.f8094a = Suppliers.a();
            this.f8095b = true;
            this.f8096c = true;
            this.d = 20;
        }
    }

    public static class DefaultProducerFactoryMethod {
        public DefaultProducerFactoryMethod() {
        }
    }

    public ImagePipelineExperiments(Builder r5) {
        r5.getClass();
        this.f8091a = new DefaultProducerFactoryMethod();
        this.f8092b = r5.f8094a;
        this.f8093c = r5.f8095b;
        this.d = r5.f8096c;
        this.e = r5.d;
    }
}
