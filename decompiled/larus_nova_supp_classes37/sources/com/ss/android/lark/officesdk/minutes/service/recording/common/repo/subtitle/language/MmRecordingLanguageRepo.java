package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingLanguageRepo extends MviRepository<f, a, g> {
    public final MmRecordingSession j;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a k;
    public final Function0<Unit> l;
    public final String m;
    public final Lazy n;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final f a() {
        return new f(0);
    }

    public final a l() {
        return (a) this.n.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.m;
    }

    public /* synthetic */ MmRecordingLanguageRepo(MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3) {
        this(r2, r3, AnonymousClass1.INSTANCE);
    }

    public MmRecordingLanguageRepo(MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r3, "mmUccApi");
        Intrinsics.checkNotNullParameter(r4, "onManualSettingIntent");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = "MmRecordingLanguageRepo";
        this.n = LazyKt.lazy(new MmRecordingLanguageRepo$opt$2(this));
    }
}
