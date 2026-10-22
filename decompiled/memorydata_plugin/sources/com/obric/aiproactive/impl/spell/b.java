package com.obric.aiproactive.impl.spell;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/impl/spell/SpellProactiveNotificationClient;", "", "<init>", "()V", "TAG", "", "URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "Landroid/net/Uri;", "METHOD_SUBMIT_QUERY", "notify", "", "context", "Landroid/content/Context;", InfoRequestQPSOptTraceLogger.REASON, "conditionJson", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f6518b = null;

    static {
        f6517a = new b();
        f6518b = Uri.parse("content://com.obric.agentskills.proactive");
    }

    private b() {
    }

    public final boolean a(Context r11, String r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r12, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r13, "conditionJson");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveNotify", "notify rejected empty reason or condition", null, 4, null);
        return false;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L25;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        b r10 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        ContentResolver r4 = r14.getContentResolver();     // Catch: Throwable -> L15
        Uri r5 = f6518b;     // Catch: Throwable -> L15
        Bundle r8 = new Bundle();     // Catch: Throwable -> L15
        boolean r15 = true;
        r8.putInt(LocationMonitorConst.API_VERSION, 1);     // Catch: Throwable -> L15
        r8.putString(InfoRequestQPSOptTraceLogger.REASON, r12);     // Catch: Throwable -> L15
        r8.putString("condition_json", r13);     // Catch: Throwable -> L15
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L15
        Bundle r17 = ZeusProviderTransform.call(r4, r5, "submit_query", null, r8, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        int r18 = -1;
        if (r17 == null) goto L10;
        r18 = r17.getInt("code", -1);     // Catch: Throwable -> L15
    L10:
        if (r18 == 0) goto L13;
        r15 = false;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveNotify", "notify reason=" + r12 + " accepted=" + r15 + " code=" + r18, false, 4, null);     // Catch: Throwable -> L15
        Object r19 = Result.m1421constructorimpl(Boolean.valueOf(r15));     // Catch: Throwable -> L15
    L17:
        Throwable r110 = Result.m1424exceptionOrNullimpl(r19);
        if (r110 == null) goto L21;
        RunLog.INSTANCE.error("SpellProactiveNotify", "notify failed reason=" + r12, r110);
    L21:
        if (Result.m1427isFailureimpl(r19) == false) goto L24;
        r19 = false;
    L24:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r19, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
