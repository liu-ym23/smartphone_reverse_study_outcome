package com.larus.contextwindow.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q97.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowUsageServiceNoop;", "Lcom/larus/contextwindow/api/IContextWindowUsageService;", "<init>", "()V", "evaluate", "Lcom/larus/contextwindow/api/ContextWindowEntryDecision;", "input", "Lcom/larus/contextwindow/api/ContextWindowEvaluationInput;", "createUsageIndicatorDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "decision", "createSlashUsageDescription", "", "open", "", "request", "Lcom/larus/contextwindow/api/ContextWindowEntryRequest;", "prefetchedSnapshot", "Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "getRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowUsageServiceNoop implements IContextWindowUsageService {
    public ContextWindowUsageServiceNoop() {
    }

    public final Drawable a(Context r2, a$b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "decision");
        return null;
    }

    public final boolean b(Context r1, ContextWindowEntryRequest r2, ContextWindowSnapshot r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "request");
        return false;
    }

    public final a c() {
        return null;
    }

    public final String d(Context r2, a$b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "decision");
        return null;
    }

    public final a e(v29.a r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return new a.a(ContextWindowHiddenReason.SERVICE_UNAVAILABLE);
    }
}
