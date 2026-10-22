package com.obric.aiproactive.ui.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/util/ProactiveMarkdownLinkHandler;", "", "<init>", "()V", "TAG", "", "normalizeExternalUrl", "link", "openInExternalBrowser", "", "context", "Landroid/content/Context;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f6885a = null;

    static {
        f6885a = new i();
    }

    private i() {
    }

    public final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "link");
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return null;
    L7:
        if (StringsKt.startsWith(r2, "http://", true) == false) goto L10;
        return r2;
    L10:
        if (StringsKt.startsWith(r2, ReportConsts.HTTPS, true) == false) goto L13;
        return r2;
    L13:
        if (StringsKt.startsWith(r2, "www.", true) == true) goto L15;
        return r2;
    L15:
        return ReportConsts.HTTPS + r2;
    }

    public final void a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r5, "link");
        String r7 = a(r5);
        if (r7 != null) goto L13;
        return;
    L13:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        i r3 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Intent r8 = new Intent("android.intent.action.VIEW", Uri.parse(r7));     // Catch: Throwable -> L7
        r8.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);     // Catch: Throwable -> L7
        ZeusTransformUtils.startActivity(r6, r8, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Object r9 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L15;
        RunLog.INSTANCE.warn("ProactiveMarkdownLink", "open browser failed: " + r7, r10);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
