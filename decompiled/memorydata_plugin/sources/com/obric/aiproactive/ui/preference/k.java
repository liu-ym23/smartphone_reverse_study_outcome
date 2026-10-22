package com.obric.aiproactive.ui.preference;

import android.content.Context;
import android.content.SharedPreferences;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rR\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "hasCompleted", "", "userId", "", "markCompleted", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f6777a;

    public k(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f6777a = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("proactive_ui", 0);
    }

    public static /* synthetic */ boolean a(k r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = AppContext.INSTANCE.getUserId();
    L6:
        return r0.a(r1);
    }

    public static /* synthetic */ void b(k r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = AppContext.INSTANCE.getUserId();
    L5:
        r0.b(r1);
    }

    public final boolean a(String r2) {
        return this.f6777a.getBoolean(l.a(r2), false);
    }

    public final void b(String r2) {
        this.f6777a.edit().putBoolean(l.a(r2), true).apply();
    }
}
