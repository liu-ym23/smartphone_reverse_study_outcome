package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingLocationRepo extends MviRepository {
    public static final /* synthetic */ int s = 0;
    public final MmRecordingRepo j;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a k;
    public final String l;
    public final Lazy m;
    public final Lazy n;
    public volatile boolean o;
    public volatile String p;
    public volatile String q;
    public final Lazy r;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final Object a() {
        return new d(0);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a m() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a) this.r.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.l;
    }

    public static final MmRecordingMapSaveHelper l(MmRecordingLocationRepo r0) {
        return (MmRecordingMapSaveHelper) r0.n.getValue();
    }

    public MmRecordingLocationRepo(MmRecordingRepo r2, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3) {
        Intrinsics.checkNotNullParameter(r2, "recordingRepo");
        Intrinsics.checkNotNullParameter(r3, "mmUccApi");
        this.j = r2;
        this.k = r3;
        this.l = "MmRecordingLocationRepo";
        this.m = LazyKt.lazy(new MmRecordingLocationRepo$locationHelper$2(this));
        this.n = LazyKt.lazy(new MmRecordingLocationRepo$mapHelper$2(this));
        this.p = "";
        this.q = "";
        this.r = LazyKt.lazy(new MmRecordingLocationRepo$opt$2(this));
    }
}
