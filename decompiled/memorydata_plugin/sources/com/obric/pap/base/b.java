package com.obric.pap.base;

import android.content.Context;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/pap/base/PythonRes;", "", "()V", "TAG", "", "checkBuiltinPackages", "", "ctx", "Landroid/content/Context;", "home", "Ljava/io/File;", "additionalAssetHash", "logger", "Lcom/obric/pap/base/HostLogger;", "checkWheelUnpacked", "sitePath", "wheelName", "clearFlag", "normalizePackageName", ActivityLifecycle.NAME, "PythonBase_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14920a = null;

    static {
        f14920a = new b();
    }

    private b() {
    }

    private final String a(String r7) {
        String r0 = r7.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r0, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return StringsKt.replace$default(r0, '-', '_', false, 4, null);
    }

    private final void a(File r11, String r12) {
        String r0 = a(StringsKt.substringBefore$default(r12, "-", null, 2, null));
        String[] r3 = r11.list();
        boolean r5 = false;
        if (r3 == null) goto L8;
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r3.length), Collection.class, "com.obric.memorydata.plugin");
        int r7 = r3.length;
        int r8 = 0;
    L5:
        if (r8 >= r7) goto L7;
        r6.add(a(r3[r8]));
        r8 = r8 + 1;
        goto L5
    L7:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    L9:
        if (r10 != null) goto L11;
        r10 = CollectionsKt.emptyList();
    L11:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L14;
    L16:
        Iterator r14 = r13.iterator();
    L18:
        if (r14.hasNext() == false) goto L30;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4, r0) == false) goto L22;
    L27:
        boolean r9 = true;
    L28:
        if (r9 == false) goto L18;
        r5 = true;
        goto L30
    L22:
        if (StringsKt.startsWith$default(r4, r0 + '_', false, 2, null) == true) goto L27;
        if (StringsKt.startsWith$default(r4, r0 + '.', false, 2, null) == true) goto L27;
        r9 = false;
    L30:
        if (r5 == false) goto L33;
        return;
    L33:
        throw new IllegalStateException("builtin wheel " + r12 + " was not unpacked under " + r11.getAbsolutePath());
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L8:
        r10 = null;
        goto L9
    }

    public final void a(Context r20, File r21, String r22, a r23) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r23, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r21, "home");
        Intrinsics.checkNotNullParameter(r22, "additionalAssetHash");
        int[] r5 = PythonHost.f14917a.getVersion();
        File r6 = new File(r21, "python/version");
        File r7 = new File(r21, "python/lib");
        int r10 = 0;
        boolean r11 = true;
        File r8 = new File(r7, new StringBuilder().append("python").append(r5[0]).append('.').append(r5[1]).append("/site-packages").toString());
        String r1 = "e16e4902-ee22-4916-b2ad-fcd12265a3a0\n" + r22 + '\n';
        if (com.obric.pap.base.a.a.f14918a.a(r6, r7, r1) == true) goto L7;
        if (r4 == null) goto L53;
        r4.logI("PythonRes", "builtin packages already up to date");
        return;
    L53:
        return;
    L7:
        if (r4 == null) goto L9;
        r4.logI("PythonRes", "refresh builtin packages under " + r7.getAbsolutePath());
    L9:
        r6.delete();
        com.obric.pap.base.a.a.f14918a.a(r7);
        if (r4 != null) goto L47;
    L12:
        com.obric.pap.base.a.a.f14918a.a(r2, "pap/packages/python3.13.zip", r21, (Function1) ZeusTransformUtils.preCheckCast(PythonRes$checkBuiltinPackages$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L39
        String[] r0 = r2.getAssets().list("pap/packages");     // Catch: Exception -> L39
        if (r0 == null) goto L26;
        int r9 = r0.length;     // Catch: Exception -> L39
    L15:
        if (r10 >= r9) goto L26;
        String r12 = r0[r10];     // Catch: Exception -> L39
        Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);     // Catch: Exception -> L39
        if (StringsKt.endsWith(r12, "whl", r11) == false) goto L24;
        if (r4 == null) goto L21;
        r4.logI("PythonRes", "unpack builtin wheel " + r12);     // Catch: Exception -> L39
    L21:
        com.obric.pap.base.a.a.f14918a.a(r2, "pap/packages/" + r12, r8, (Function1) ZeusTransformUtils.preCheckCast(PythonRes$checkBuiltinPackages$2$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L39
        f14920a.a(r8, r12);     // Catch: Exception -> L39
        if (r4 == null) goto L24;
        r4.logI("PythonRes", "builtin wheel " + r12 + " unpacked");     // Catch: Exception -> L39
    L24:
        r10 = r10 + 1;     // Catch: Exception -> L39
        r11 = true;
    L26:
        if (r4 == null) goto L32;
        StringBuilder r3 = new StringBuilder().append("builtin packages: ");     // Catch: Exception -> L39
        File[] r13 = r8.listFiles();     // Catch: Exception -> L39
        if (r13 == null) goto L30;
        String r14 = ArraysKt.joinToString$default(r13, (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);     // Catch: Exception -> L39
    L31:
        r4.logI("PythonRes", r3.append(r14).toString());     // Catch: Exception -> L39
        goto L32
    L30:
        r14 = null;
    L32:
        File r15 = r6.getParentFile();     // Catch: Exception -> L39
        if (r15 == null) goto L35;
        r15.mkdirs();     // Catch: Exception -> L39
    L35:
        FilesKt.writeText$default(r6, r1, null, 2, null);     // Catch: Exception -> L39
        if (r4 == null) goto L54;
        r4.logI("PythonRes", "builtin packages ready");     // Catch: Exception -> L39
        return;
    L39:
        e = move-exception;
        com.obric.pap.base.a.a.f14918a.a(r7);
        if (r4 == null) goto L46;
        StringBuilder r16 = new StringBuilder().append("refresh builtin packages failed: ");
        String r17 = e.getMessage();
        if (r17 != null) goto L45;
        r17 = e.getClass().getSimpleName();
    L45:
        r4.logE("PythonRes", r16.append(r17).toString());
    L46:
        throw e;
    L54:
        return;
    L47:
        r4.logI("PythonRes", "unpack builtin python archive python3.13.zip");     // Catch: Exception -> L39
        goto L12
    }

    public final void a(File r3, a r4) {
        a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "home");
        File r5 = new File(r3, "python/version");
        if (r5.exists() == true) goto L8;
        if (r2 == null) goto L14;
        r2.logI("PythonRes", "builtin packages flag already cleared");
        return;
    L14:
        return;
    L8:
        if (r5.delete() == false) goto L11;
        if (r2 == null) goto L15;
        r2.logI("PythonRes", "builtin packages flag cleared");
        return;
    L15:
        return;
    L11:
        if (r2 == null) goto L17;
        r2.logW("PythonRes", "failed to clear builtin packages flag at " + r5.getAbsolutePath());
        return;
    }
}
