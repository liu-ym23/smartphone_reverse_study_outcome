package com.obric.memorydata.memory.ui.detail;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerPresentationPolicy;", "", "<init>", "()V", "PROGRESS_DELAY_MS", "", "resolve", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerPresentation;", "state", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerPresentationState;", "viewerBackgroundColor", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f10866a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10867a = null;

        static {
            int[] r0 = new int[ImageViewerPresentationState.values().length];
            r0[ImageViewerPresentationState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ImageViewerPresentationState.LOADING_WITH_PROGRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ImageViewerPresentationState.READY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ImageViewerPresentationState.EXITING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f10867a = r0;
        }
    }

    static {
        f10866a = new n();
    }

    private n() {
    }

    public final m a(ImageViewerPresentationState r24, int r25) {
        Intrinsics.checkNotNullParameter(r24, "state");
        int r0 = a.f10867a[r24.ordinal()];
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L12;
        return new m(r25, false, true, false, null, 16, null);
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return new m(r25, false, true, false, ImageViewerContentTransition.WINDOW_FADE_IN);
    L19:
        return new m(0, true, false, true, null, 16, null);
    L16:
        return new m(0, false, false, true, null, 16, null);
    }
}
