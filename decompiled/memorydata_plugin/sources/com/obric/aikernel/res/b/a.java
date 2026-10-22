package com.obric.aikernel.res.b;

import android.content.Context;
import android.net.Uri;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.data.d;
import com.obric.aikernel.res.metadata.data.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/aikernel/res/storage/DependenciesStorageChecker;", "", "()V", "AIKERNEL_AID", "", "TAG", "check", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "checkLegacyModelDir", "root", "Ljava/io/File;", "checkTargetRes", "type", ActivityLifecycle.NAME, "version", "checkTypedResDir", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6003a = null;

    static {
        f6003a = new a();
    }

    private a() {
    }

    private final void a(PrmContext r19, File r20) {
        File[] r2 = r20.listFiles();
        if (r2 == null) goto L12;
        int r3 = r2.length;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L18;
        File r11 = r2[r5];
        a r6 = f6003a;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        String r1 = r11.getName();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r1, "it.name");     // Catch: Throwable -> L9
        List r7 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'@'}, false, 0, 6, null);     // Catch: Throwable -> L9
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        String r10 = (String) ZeusTransformUtils.preCheckCast(r7.get(1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r11, "it");     // Catch: Throwable -> L9
        r6.a(r19, "model", r9, r10, r11);     // Catch: Throwable -> L9
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        r5 = r5 + 1;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    L18:
        return;
    }

    private final void a(PrmContext r13, String r14, File r15) {
        File[] r12 = r15.listFiles();
        if (r12 == null) goto L17;
        int r16 = r12.length;
        int r1 = 0;
    L5:
        if (r1 >= r16) goto L25;
        File r2 = r12[r1];
        File[] r3 = r2.listFiles();
        if (r3 == null) goto L16;
        Intrinsics.checkNotNullExpressionValue(r3, "listFiles()");
        int r4 = r3.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L16;
        File r11 = r3[r5];
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
        a r7 = f6003a;     // Catch: Throwable -> L13
        String r9 = r2.getName();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r9, "nameRoot.name");     // Catch: Throwable -> L13
        String r10 = r11.getName();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r10, "versionRoot.name");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r11, "versionRoot");     // Catch: Throwable -> L13
        r7.a(r13, r14, r9, r10, r11);     // Catch: Throwable -> L13
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        r5 = r5 + 1;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L16:
        r1 = r1 + 1;
        goto L5
    L25:
        return;
    }

    private final void a(PrmContext r4, String r5, String r6, String r7, File r8) {
        String r0 = null;
        if (Intrinsics.areEqual(r5, "lib") == false) goto L7;
        Object r3 = new i(r6, r7, r4.getConfig());
    L5:
        d r9 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
    L10:
        if (r9 != null) goto L12;
        return;
    L12:
        if (r9.d() == true) goto L37;
        Uri r10 = r9.i();
        boolean r11 = true;
        if (r10 == null) goto L20;
        String r12 = r10.getPath();
        if (r12 == null) goto L20;
        Intrinsics.checkNotNullExpressionValue(r12, "path");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        String r14 = r8.getPath();
        Intrinsics.checkNotNullExpressionValue(r14, "root.path");
        if (StringsKt.contains$default(r13, (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) != true) goto L20;
    L21:
        if (r11 == true) goto L38;
        com.obric.aikernel.runtime.utils.d r15 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r16 = new StringBuilder().append("delete useless dir ").append(r8.getPath()).append(", current use: ");
        Uri r17 = r9.i();
        if (r17 == null) goto L25;
        r0 = r17.getPath();
    L25:
        r15.b("DependenciesStorageChecker", r16.append(r0).toString());
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L28
        Object r19 = Result.m1421constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r8)));     // Catch: Throwable -> L28
    L30:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r19);
        if (r20 == null) goto L39;
        com.obric.aikernel.runtime.utils.d.f6216a.f("DependenciesStorageChecker", "checkTargetRes delete " + r8 + " failed " + r20);
        return;
    L39:
        return;
    L28:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L30
    L38:
        return;
    L20:
        r11 = false;
        goto L21
    L37:
        return;
    L7:
        if (Intrinsics.areEqual(r5, "model") == false) goto L9;
        r3 = new com.obric.aikernel.res.metadata.data.a(r6, r7, r4.getConfig());
        goto L5
    L9:
        r9 = null;
        goto L10
    }

    public final void a(PrmContext r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (Intrinsics.areEqual(r5.getConfig().getAppConfig().getAid(), "570851") == true) goto L6;
        com.obric.aikernel.runtime.utils.d.f6216a.a("DependenciesStorageChecker", "skip check for aid " + r5.getConfig().getAppConfig().getAid());
        return;
    L6:
        a(r5, new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "models"));
        a(r5, new File("/data/fbe/aikernel/0/preset_model_decrypt"));
        a(r5, "lib", new File("/data/fbe/aikernel/0/prs/libs"));
        a(r5, "model", new File("/data/fbe/aikernel/0/prs/models"));
    }
}
