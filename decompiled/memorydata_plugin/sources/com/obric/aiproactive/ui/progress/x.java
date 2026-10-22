package com.obric.aiproactive.ui.progress;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/ui/progress/MobileUsePlayerProviderContract;", "", "<init>", "()V", "URI", "Landroid/net/Uri;", "getURI", "()Landroid/net/Uri;", "METHOD", "", "SOURCE_FROM", "KEY_SOURCE_FROM", "KEY_OPEN_PLAYER_PENDING_INTENT", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f6852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f6853b = null;

    static {
        f6852a = new x();
        Uri r0 = Uri.parse("content://com.obric.assistantaiagent.OAutoStateProvider");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(...)");
        f6853b = r0;
    }

    private x() {
    }

    public final Uri a() {
        return f6853b;
    }
}
