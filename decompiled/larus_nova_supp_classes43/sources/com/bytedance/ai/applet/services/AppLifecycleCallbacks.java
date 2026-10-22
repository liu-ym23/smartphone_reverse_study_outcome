package com.bytedance.ai.applet.services;

import android.content.Context;
import com.bytedance.ai.applet.app.AppletApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/applet/services/AppLifecycleCallbacks;", "", "onAppAttached", "", "app", "Lcom/bytedance/ai/applet/app/AppletApplication;", "onAppCreated", "context", "Landroid/content/Context;", "onAppResumed", "onAppStopped", "onAppDestroyView", "onAppDestroyed", "onAppTaskForeground", "onAppTaskBackground", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppLifecycleCallbacks {

    public static final class a {
        public static void a(AppletApplication r1, Context r10) {
            Intrinsics.checkNotNullParameter(r1, "app");
            Intrinsics.checkNotNullParameter(r10, "context");
        }

        public static void b(AppletApplication r1, Context r10) {
            Intrinsics.checkNotNullParameter(r1, "app");
            Intrinsics.checkNotNullParameter(r10, "context");
        }
    }

    void onAppAttached(AppletApplication r1);

    void onAppCreated(AppletApplication r1, Context r10);

    void onAppDestroyView(AppletApplication r1, Context r10);

    void onAppDestroyed(AppletApplication r1);

    void onAppResumed(AppletApplication r1, Context r10);

    void onAppStopped(AppletApplication r1, Context r10);

    void onAppTaskBackground(AppletApplication r1, Context r10);

    void onAppTaskForeground(AppletApplication r1, Context r10);
}
