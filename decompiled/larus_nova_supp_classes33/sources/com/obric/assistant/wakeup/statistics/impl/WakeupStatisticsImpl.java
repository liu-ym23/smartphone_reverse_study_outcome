package com.obric.assistant.wakeup.statistics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.session.lifecycle.f;
import com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0019\u001a\u00020\u00182\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\bH\u0016J$\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\bH\u0002R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/impl/WakeupStatisticsImpl;", "Lcom/obric/assistant/wakeup/statistics/api/IWakeupStatisticsAPI;", "<init>", "()V", "mWakeupDuration", "", "Landroid/util/Pair;", "", "", "mStartTime", "getMStartTime", "()J", "setMStartTime", "(J)V", "mEndTime", "getMEndTime", "setMEndTime", "mBundle", "Landroid/os/Bundle;", "sWorkHandler", "Landroid/os/Handler;", "mUploader", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "", "init", "uploader", "destroy", "setBundle", "bundle", "onEvent", "event", "end", "", "time", "clear", "setStartTime", "insertTimeTrace", "name", "save", "transferToCloud", "getLastTraceTime", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupStatisticsImpl implements IWakeupStatisticsAPI {
    public static final /* synthetic */ int g = 0;
    public final List<Pair<String, Long>> a;
    public long b;
    public long c;
    public Bundle d;
    public Handler e;
    public Function2<? super String, ? super JSONObject, Unit> f;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void destroy() {
        this.f = null;
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void clear() {
        ((ArrayList) this.a).clear();
    }

    public WakeupStatisticsImpl() {
        this.a = new ArrayList();
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void a(f r4) {
        Intrinsics.checkNotNullParameter(r4, "uploader");
        FLogger.a.i("WakeupDuration/S3", "init with uploader " + r4);
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("WakeupDuration/S3");
        ThreadMethodProxy.start(r0);
        this.e = new Handler(r0.getLooper());
        this.f = r4;
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void setBundle(Bundle r1) {
        this.d = r1;
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void setStartTime(long r1) {
        this.b = r1;
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void b(final String r7, final boolean r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (r8 == false) goto L8;
        if (((ArrayList) this.a).isEmpty() == false) goto L8;
        return;
    L8:
        if (r9 != 0) goto L11;
        r9 = System.currentTimeMillis();
    L11:
        final long r4 = r9;
        Handler r10 = this.e;
        if (r10 == null) goto L15;
        r10.post(new com.obric.assistant.wakeup.statistics.impl.a(r8, this, r7, r4));
        return;
    }
}
