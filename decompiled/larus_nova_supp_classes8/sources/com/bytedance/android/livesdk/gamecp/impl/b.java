package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements IGameCPDownloadView {
    public final com.bytedance.android.gamecp.base.core.service.depend.g a;

    public static final class a implements com.bytedance.android.gamecp.base.core.service.depend.g.a {
        public final /* synthetic */ IGameCPDownloadView.Callback a;

        public a(IGameCPDownloadView.Callback r1) {
            this.a = r1;
        }

        public final void a(int r2, JavaOnlyMap r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            this.a.callback(r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamecp.impl.b$b, reason: collision with other inner class name */
    public static final class C0356b implements com.bytedance.android.gamecp.base.core.service.depend.g.a {
        public final /* synthetic */ IGameCPDownloadView.Callback a;

        public C0356b(IGameCPDownloadView.Callback r1) {
            this.a = r1;
        }

        public final void a(int r2, JavaOnlyMap r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            this.a.callback(r2, r3);
        }
    }

    public static final class c implements com.bytedance.android.gamecp.base.core.service.depend.g.b {
        public final /* synthetic */ IGameCPDownloadView.DownloadStateListener a;

        public c(IGameCPDownloadView.DownloadStateListener r1) {
            this.a = r1;
        }

        public void onEvent(HashMap<String, Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.onEvent(r2);
        }
    }

    public final void destroy() {
        this.a.destroy();
    }

    public b(com.bytedance.android.gamecp.base.core.service.depend.g r2) {
        Intrinsics.checkNotNullParameter(r2, "downloadView");
        this.a = r2;
    }

    public final void setDownloadInfo(HashMap<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.setDownloadInfo(r2);
    }

    public final void setDownloadStateListener(IGameCPDownloadView.DownloadStateListener r3) {
        if (r3 != null) goto L5;
        this.a.b(null);
        return;
    L5:
        this.a.b(new c(r3));
    }

    public final void setDownloadText(HashMap<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.setDownloadText(r2);
    }

    public final void setDownloadUIStyle(HashMap<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.setDownloadUIStyle(r2);
    }

    public final void useCacheData(HashMap<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.useCacheData(r2);
    }

    public final View createView(Context r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lynxContext");
        return this.a.createView(r2, r3);
    }

    public final void getCurrentDownloadState(HashMap<String, Object> r3, IGameCPDownloadView.Callback r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r4 != null) goto L6;
        this.a.a(r3, null);
        return;
    L6:
        this.a.a(r3, new a(r4));
    }

    public final void performDownloadAction(HashMap<String, Object> r3, IGameCPDownloadView.Callback r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r4 != null) goto L6;
        this.a.d(r3, null);
        return;
    L6:
        this.a.d(r3, new C0356b(r4));
    }
}
