package com.facebook.imagepipeline.core;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.common.references.HasBitmap;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes2.dex */
public class CloseableReferenceFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CloseableReference.LeakHandler f8057a;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.core.CloseableReferenceFactory$1, reason: invalid class name */
    class AnonymousClass1 implements CloseableReference.LeakHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoOpCloseableReferenceLeakTracker f8058a;

        public AnonymousClass1(NoOpCloseableReferenceLeakTracker r5) {
            this.f8058a = r5;
        }

        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public final void a() {
            this.f8058a.getClass();
        }

        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public final void b() {
            this.f8058a.getClass();
        }
    }

    public CloseableReferenceFactory(NoOpCloseableReferenceLeakTracker r5) {
        this.f8057a = new AnonymousClass1(r5);
    }

    public final DefaultCloseableReference a(CloseableImage r5) {
        CloseableReference.LeakHandler r10 = this.f8057a;
        if (r5 != null) goto L5;
        return null;
    L5:
        ResourceReleaser r11 = CloseableReference.e;
        AnonymousClass1 r12 = (AnonymousClass1) r10;
        r12.f8058a.getClass();
        boolean r13 = r5 instanceof HasBitmap;
        return new DefaultCloseableReference(r5, r11, r12, null);
    }
}
