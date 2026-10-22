package d8;

import android.net.Uri;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.data.AIModel;
import com.obric.aikernel.res.metadata.data.e;
import com.obric.aikernel.runtime.utils.d;
import java.io.File;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8512a = null;

    static {
        f8512a = new a();
    }

    private a() {
    }

    private final void b(PrmContext r18, File r19) {
        File[] r10 = r19.listFiles();
        if (r10 == null) goto L12;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L18;
        File r13 = r10[r12];
        a r14 = f8512a;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L9
        String r16 = r13.getName();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r16, "it.name");     // Catch: Throwable -> L9
        List r17 = StringsKt.split$default(r16, new char[]{'@'}, false, 0, 6, null);     // Catch: Throwable -> L9
        String r20 = (String) r17.get(0);     // Catch: Throwable -> L9
        String r21 = (String) r17.get(1);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r13, "it");     // Catch: Throwable -> L9
        r14.c(r18, "model", r20, r21, r13);     // Catch: Throwable -> L9
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        r12 = r12 + 1;
    L9:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L11
    L18:
        return;
    }

    private final void c(PrmContext r10, String r11, String r12, String r13, File r14) {
        String r15 = null;
        if (Intrinsics.areEqual(r11, "lib") == false) goto L6;
        com.obric.aikernel.res.metadata.data.b r16 = new e(r12, r13, r10.getConfig());
    L9:
        if (r16 != null) goto L11;
        return;
    L11:
        if (r16.H() == true) goto L36;
        Uri r17 = r16.v();
        boolean r18 = true;
        if (r17 == null) goto L19;
        String r19 = r17.getPath();
        if (r19 == null) goto L19;
        Intrinsics.checkNotNullExpressionValue(r19, "path");
        String r20 = r14.getPath();
        Intrinsics.checkNotNullExpressionValue(r20, "root.path");
        if (StringsKt.contains$default(r19, r20, false, 2, null) != true) goto L19;
    L20:
        if (r18 == true) goto L37;
        d r21 = d.f5417a;
        StringBuilder r22 = new StringBuilder();
        r22.append("delete useless dir ");
        r22.append(r14.getPath());
        r22.append(", current use: ");
        Uri r23 = r16.v();
        if (r23 == null) goto L24;
        r15 = r23.getPath();
    L24:
        r22.append(r15);
        r21.i("DependenciesStorageChecker", r22.toString());
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L27
        Object r25 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r14)));     // Catch: Throwable -> L27
    L29:
        Throwable r26 = Result.m35exceptionOrNullimpl(r25);
        if (r26 == null) goto L38;
        d.f5417a.l("DependenciesStorageChecker", "checkTargetRes delete " + r14 + " failed " + r26);
        return;
    L38:
        return;
    L27:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L29
    L37:
        return;
    L19:
        r18 = false;
        goto L20
    L36:
        return;
    L6:
        if (Intrinsics.areEqual(r11, "model") == false) goto L8;
        r16 = new AIModel(r12, r13, r10.getConfig());
        goto L9
    L8:
        r16 = null;
        goto L9
    }

    private final void d(PrmContext r13, String r14, File r15) {
        File[] r12 = r15.listFiles();
        if (r12 == null) goto L17;
        int r16 = r12.length;
        int r10 = 0;
    L5:
        if (r10 >= r16) goto L25;
        File r11 = r12[r10];
        File[] r17 = r11.listFiles();
        if (r17 == null) goto L16;
        Intrinsics.checkNotNullExpressionValue(r17, "listFiles()");
        int r18 = r17.length;
        int r19 = 0;
    L9:
        if (r19 >= r18) goto L16;
        File r110 = r17[r19];
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L13
        a r21 = f8512a;     // Catch: Throwable -> L13
        String r22 = r11.getName();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r22, "nameRoot.name");     // Catch: Throwable -> L13
        String r111 = r110.getName();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r111, "versionRoot.name");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r110, "versionRoot");     // Catch: Throwable -> L13
        r21.c(r13, r14, r22, r111, r110);     // Catch: Throwable -> L13
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        r19 = r19 + 1;
    L13:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    L16:
        r10 = r10 + 1;
        goto L5
    L25:
        return;
    }

    public final void a(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        b(r10, new File(r10.getConfig().getContext().getFilesDir(), "models"));
        b(r10, new File("/data/fbe/aikernel/0/preset_model_decrypt"));
        d(r10, "lib", new File("/data/fbe/aikernel/0/prs/libs"));
        d(r10, "model", new File("/data/fbe/aikernel/0/prs/models"));
    }
}
