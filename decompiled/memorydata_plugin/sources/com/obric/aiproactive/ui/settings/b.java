package com.obric.aiproactive.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/settings/InitiativeLevelStore;", "Lcom/obric/aiproactive/ui/settings/InitiativeLevelRepository;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "read", "Lcom/obric/aiproactive/ui/settings/InitiativeLevel;", "userId", "", "write", "", "level", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f6857a;

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f6857a = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("proactive_ui", 0);
    }

    @Override // com.obric.aiproactive.ui.settings.a
    public InitiativeLevel a(String r4) {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f6857a.getString(h.a(r4), null));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r3) == true) goto L11;
        r1 = r3;
    L11:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        return InitiativeLevel.Companion.a(r5);
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.obric.aiproactive.ui.settings.a
    public void a(String r2, InitiativeLevel r3) {
        Intrinsics.checkNotNullParameter(r3, "level");
        this.f6857a.edit().putString(h.a(r2), r3.getStorageToken()).apply();
    }
}
