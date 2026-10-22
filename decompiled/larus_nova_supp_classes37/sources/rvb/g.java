package rvb;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g extends MmBaseNetReconnectHelper {
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a g;
    public final MmRecordingSubtitleRepo h;
    public final String i;
    public final long j;
    public final long k;
    public long l;

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final void f() {
        h r0 = (h) CollectionsKt.lastOrNull(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d) this.h.l().b().getValue()).a);
        if (r0 == null) goto L5;
        long r1 = r0.a;
    L6:
        this.l = r1;
        lvb.a.e(this.i, "onNetworkLevelChanged, net unAvailable, localLatestSegId: " + this.l);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final long c() {
        return this.k;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final long d() {
        return this.j;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final String e() {
        return this.i;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final Object b(Continuation<? super Unit> r10) {
        String r1 = this.g.k();
        String r2 = this.g.o();
        boolean r0 = true;
        if (r1.length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L14;
        if (r2.length() > 0) goto L11;
        r0 = false;
    L11:
        if (r0 == false) goto L14;
        this.h.l().Q(r1, r2, Boxing.boxLong(Math.max(0, this.l - 1)), false, 10, SubtitleSource.NETWORK_RECONNECT, true);
    L14:
        return Unit.INSTANCE;
    L5:
        r11 = false;
        goto L6
    }

    public g(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a r3, MmRecordingSubtitleRepo r4) {
        Intrinsics.checkNotNullParameter(r3, "repoContainer");
        Intrinsics.checkNotNullParameter(r4, "subtitleRepo");
        super(r3.n().c, r4.d());
        this.g = r3;
        this.h = r4;
        this.i = "MmSubtitleNetReconnectFetcher";
        this.j = 1000;
        this.k = 500;
    }
}
