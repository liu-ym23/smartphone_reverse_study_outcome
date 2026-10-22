package com.bytedance.ai.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements com.bytedance.ai.utils.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List f3059i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletWidgetContainer f3060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MotionEvent f3061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3062c;
    public String d;
    public e1.a e;
    public final Handler f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f3063h;

    static {
        f3059i = AISDKSettingConfigManager.INSTANCE.getCUSTOM_DOWNLOAD_PACKAGE_LIST().getValue();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.ai.widget.e] */
    public f(AppletWidgetContainer r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetContainer");
        this.f3060a = r5;
        this.f = new Handler(Looper.getMainLooper());
        this.f3063h = new e(this);
    }

    public final void a() {
        this.g = false;
        this.f.removeCallbacks(this.f3063h);
    }

    public final boolean b() {
        if (this.f3062c == true) goto L5;
        return false;
    L5:
        if (CollectionsKt.contains(f3059i, this.d) == false) goto L10;
        return true;
    L10:
        return false;
    }
}
