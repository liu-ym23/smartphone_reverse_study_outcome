package oc;

import com.bytedance.forest.utils.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20546c;

    public /* synthetic */ a(String r5, int r10, int r11) {
        this.f20546c = r11;
        super(r5, r10);
    }

    @Override // com.bytedance.forest.utils.m, android.util.LruCache
    public final int sizeOf(Object r5, Object r10) {
        switch(this.f20546c) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        String r11 = (String) r5;
        if (r10 != null) goto L9;
        Intrinsics.checkNotNull(null, "null cannot be cast to non-null type com.bytedance.ies.bullet.preloadv2.cache.PreloadItem");
        throw null;
    L9:
        throw new ClassCastException();
    L10:
        String r12 = (String) r5;
        if (r10 != null) goto L15;
        Intrinsics.checkNotNull(null, "null cannot be cast to non-null type com.bytedance.ies.bullet.preloadv2.cache.PreloadItem");
        throw null;
    L15:
        throw new ClassCastException();
    }
}
