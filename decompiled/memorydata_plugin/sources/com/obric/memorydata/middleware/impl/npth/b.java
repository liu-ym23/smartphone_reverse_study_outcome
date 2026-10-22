package com.obric.memorydata.middleware.impl.npth;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\"\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"MEMORY_APP_CRASH_EVENT", "", "MEMORY_APP_OOM_EVENT", "CRASH_EVENT_ID", "CRASH_TIME_MS", "REPORT_MODE", "REPLAY_TIME_MS", "REPLAY_DELAY_MS", "REPORT_MODE_REPLAY", "REPORT_MODE_DIRECT_FALLBACK", "SUPPORTED_CRASH_TEA_EVENTS", "", "middleware_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f11790a = null;

    static {
        f11790a = SetsKt.setOf(new String[]{"memory_app_crash", "memory_app_oom"});
    }

    public static final /* synthetic */ Set a() {
        return f11790a;
    }
}
