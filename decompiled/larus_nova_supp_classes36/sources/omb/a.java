package omb;

import android.content.Context;
import com.bytedance.lark.base.open.pkm.PkmBizType;
import com.bytedance.lark.base.open.pkm.PkmError;
import com.bytedance.lark.base.open.pkm.h;
import com.bytedance.lark.base.open.pkm.j;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final PkmBizType a = null;
    public static volatile j b;
    public static volatile boolean c;
    public static volatile String d;
    public static final Object e = null;

    /* JADX INFO: renamed from: omb.a$a, reason: collision with other inner class name */
    public static final class C0307a implements com.bytedance.lark.base.open.pkm.c {
        public C0307a() {
        }

        public final void onEvent(String r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r3, "event");
            Intrinsics.checkNotNullParameter(r4, "payload");
            Log.i("CardTemplatePkmManager", "applyJssdkUpdate event=" + r3 + " payload=" + r4);
        }
    }

    static {
        a = PkmBizType.JssdkMsgCard;
        e = new Object();
    }

    public static void a() {
        j r2 = b;     // Catch: PkmError -> L13
        if (r2 == null) goto L6;
        boolean r3 = r2.e(a);     // Catch: PkmError -> L13
    L7:
        Log.i("CardTemplatePkmManager", "checkAndApplyUpdate hasUpdate=" + r3);     // Catch: PkmError -> L13
        if (r3 == false) goto L18;
        j r1 = b;     // Catch: PkmError -> L13
        if (r1 == null) goto L19;
        r1.b(a, new C0307a());     // Catch: PkmError -> L13
        return;
    L19:
        return;
    L18:
        return;
    L6:
        r3 = false;
    L13:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "checkAndApplyUpdate failed: " + e);
    }

    public static j b(Context r2) {
        j r0 = b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        e(r2);
        j r3 = b;
        if (r3 != null) goto L8;
        Log.w("CardTemplatePkmManager", "ensureManager: pkmManager still null");
    L8:
        return r3;
    }

    public static void c(Context r9) {
        PolarisFileWrapper r5 = d(r9);     // Catch: PkmError -> L25
        FileUtils.b(r9, "msg_card_template.7z", r5.getAbsolutePath());     // Catch: PkmError -> L25
        Log.i("CardTemplatePkmManager", "extractBuiltinTemplateIfNeeded,start path=" + r5.getAbsolutePath());     // Catch: PkmError -> L25
        j r3 = b;     // Catch: PkmError -> L25
        boolean r6 = false;
        if (r3 == null) goto L6;
        boolean r4 = r3.c(a, r5.getAbsolutePath());     // Catch: PkmError -> L25
    L7:
        Log.i("CardTemplatePkmManager", "extractBuiltinTemplateIfNeeded: result=" + r4 + ", path=" + r5.getAbsolutePath());     // Catch: PkmError -> L25
        if (r4 == false) goto L42;
        String r10 = f(r9);     // Catch: PkmError -> L25
        if (r10 == null) goto L12;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r10);     // Catch: PkmError -> L25
    L13:
        if (r2 != null) goto L15;
    L17:
        Log.i("CardTemplatePkmManager", "extractBuiltinTemplateIfNeeded: installed templatePath=" + r10 + ", exists=" + r6);     // Catch: PkmError -> L25
        j r11 = b;     // Catch: PkmError -> L22
        if (r11 == null) goto L43;
        r11.d(a, new b());     // Catch: PkmError -> L22
    L44:
        return;
    L43:
        return;
    L22:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "getJssdkInstallationVersion failed: " + e);     // Catch: PkmError -> L25
        return;
    L15:
        if (r2.exists() != true) goto L17;
        r6 = true;
        goto L17
    L12:
        r2 = null;
        goto L13
    L42:
        return;
    L6:
        r4 = false;
    L25:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "extractBuiltinTemplateIfNeeded failed, msg=" + e.getMessage() + ", cause=" + e.getCause(), e);
        Iterator r1 = ArrayIteratorKt.iterator(e.getClass().getDeclaredFields());     // Catch: Exception -> L32
    L29:
        if (r1.hasNext() == false) goto L46;
        Field r7 = (Field) r1.next();     // Catch: Exception -> L32
        r7.setAccessible(true);     // Catch: Exception -> L32
        Log.e("CardTemplatePkmManager", "PkmError field: " + r7.getName() + " = " + r7.get(e));     // Catch: Exception -> L32
        goto L29
    L46:
        return;
    L32:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "Failed to inspect PkmError fields", e);
    }

    public static PolarisFileWrapper d(Context r3) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(new PolarisFileWrapper(r3.getFilesDir(), "lynx_message_card").getAbsolutePath(), "buildin_bundle");
        if (r0.exists() == true) goto L6;
        r0.mkdir();
    L6:
        if (r0.exists() == true) goto L8;
        r0.mkdirs();
    L8:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r0, "msg_card_template.7z");
        if (r4.exists() == false) goto L15;
    L14:
        return r4;
    L15:
        r4.createNewFile();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "create temp bundle zip file failed", e);
        goto L14
    }

    @JvmStatic
    public static final void e(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (c == false) goto L5;
        return;
    L5:
        Object r1 = e;
        monitor-enter(r1);
    L31:
        th = move-exception;
        throw th;
    L8:
        if (c == false) goto L11;
        monitor-exit(r1);
        return;
    L11:
        String r2 = com.ss.android.lark.message.card.b.a().getLoginUserId();     // Catch: Throwable -> L31
        if (r2 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L35;
        Log.w("CardTemplatePkmManager", "init: userId is empty, skip pkm init");     // Catch: Throwable -> L31
        monitor-exit(r1);
        return;
    L35:
        b = h.a(r2);     // Catch: Throwable -> L24 PkmError -> L26
        c = true;     // Catch: Throwable -> L24 PkmError -> L26
        c(r5);     // Catch: Throwable -> L24 PkmError -> L26
        a();     // Catch: Throwable -> L24 PkmError -> L26
    L28:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r1);
        return;
    L24:
        th = move-exception;
        Log.e("CardTemplatePkmManager", "init unexpected error", th);     // Catch: Throwable -> L31
    L26:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "init: buildPkmManager failed: " + e);     // Catch: Throwable -> L31
        goto L28
    L14:
        if (r2.length() == 0) goto L17;
        r4 = false;
        goto L18
    }

    @JvmStatic
    public static final String f(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        j r6 = b(r5);
        if (r6 != null) goto L5;
        return null;
    L5:
        String r1 = "template.js";
        if (StringsKt.startsWith$default("template.js", "local://open_card/", false, 2, null) == false) goto L9;
        r1 = "template.js".substring(18);
    L9:
        if (StringsKt.startsWith$default(r1, "/", false, 2, null) == false) goto L11;
        r1 = r1.substring(1);
        goto L9
    L11:
        Log.i("CardTemplatePkmManager", "path normalized = " + r1);
        return r6.f(r1, a);
    L14:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "installationPath failed. path=" + r1, e);
        return null;
    }
}
