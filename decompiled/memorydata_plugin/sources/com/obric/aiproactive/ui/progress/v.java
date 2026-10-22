package com.obric.aiproactive.ui.progress;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/progress/MobileUsePlayerProviderClient;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "resolve", "Lcom/obric/aiproactive/ui/progress/MobileUsePlayerTarget;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6851a;

    public v(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f6851a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    public final y a() {
        ContentProviderClient r3 = this.f6851a.getContentResolver().acquireUnstableContentProviderClient(x.f6852a.a());     // Catch: SecurityException -> L5
    L6:
        if (r3 != null) goto L23;
        return null;
    L23:
        Bundle r1 = r3.call("get_open_player_pending_intent", null, w.b());     // Catch: Throwable -> L10 Throwable -> L13
        r3.close();
    L14:
        if (r1 != null) goto L16;
        return null;
    L16:
        PendingIntent r2 = w.a(r1);
        if (r2 != null) goto L20;
        return null;
    L20:
        return new y(r2);
    L13:
        r3.close();
        r1 = null;
    L10:
        th = move-exception;
        r3.close();
        throw th;
    L5:
        r3 = null;
        goto L6
    }
}
