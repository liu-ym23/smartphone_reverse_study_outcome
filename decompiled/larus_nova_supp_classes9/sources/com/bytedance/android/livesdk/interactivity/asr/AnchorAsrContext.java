package com.bytedance.android.livesdk.interactivity.asr;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/asr/AnchorAsrContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Ll22/a;", "Ll22/c;", "anchorAsrManager", "Ll22/c;", "getAnchorAsrManager", "()Ll22/c;", "Ll22/e;", "userActionCollector", "Ll22/e;", "getUserActionCollector", "()Ll22/e;", BuildConfig.FLAVOR, "getHasCleared", "()Z", "hasCleared", "<init>", "(Ll22/c;Ll22/e;)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorAsrContext extends DataContext implements l22.a {
    private final l22.c anchorAsrManager;
    private final l22.e userActionCollector;

    public boolean getHasCleared() {
        return isCleared();
    }

    @Override // l22.a
    public l22.c getAnchorAsrManager() {
        return this.anchorAsrManager;
    }

    @Override // l22.a
    public l22.e getUserActionCollector() {
        return this.userActionCollector;
    }

    public AnchorAsrContext(l22.c r2, l22.e r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorAsrManager");
        Intrinsics.checkNotNullParameter(r3, "userActionCollector");
        this.anchorAsrManager = r2;
        this.userActionCollector = r3;
    }
}
