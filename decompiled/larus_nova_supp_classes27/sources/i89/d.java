package i89;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.drive.preview.IDriveDownloadFilePlugin;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import t19.s;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements i {
    public final String a;
    public final String b;
    public final WeakReference<Fragment> c;
    public final String d;
    public final String e;
    public final String f;
    public final Set<String> g;
    public Function1<? super IDriveDownloadFilePlugin.a, Boolean> h;
    public boolean i;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IDriveDownloadFilePlugin.EDownloadResult.values().length];
            r0[IDriveDownloadFilePlugin.EDownloadResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[IDriveDownloadFilePlugin.EDownloadResult.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[IDriveDownloadFilePlugin.EDownloadResult.CANCELLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final void f() {
        Fragment r0 = this.c.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAdded() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L13;
        s.a.g(r0.requireContext(), 2131889802, false);
        return;
    }

    public final JSONObject a(boolean r4) {
        JSONObject r0 = new JSONObject();
        String r1 = this.f;
        if (r1 == null) goto L5;
        r0.put("file_type", r1);
    L5:
        if (r4 == false) goto L14;
        String r5 = this.b;
        if (r5 == null) goto L14;
        if ((!StringsKt.isBlank(r5)) == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L14;
        r0.put("message_id", r5);
    L14:
        return r0;
    }

    public final void b(String r17) {
        Intrinsics.checkNotNullParameter(r17, "buttonName");
        u0.d("bot_file_preview_right", r17, null, null, null, "preview", null, null, null, null, null, null, a(true), null, 12252);
    }

    public final void c(String r15) {
        Intrinsics.checkNotNullParameter(r15, "buttonName");
        if (this.g.add(r15) == true) goto L5;
        return;
    L5:
        JSONObject r11 = a(false);
        r11.put("button_name", r15);
        Unit r16 = Unit.INSTANCE;
        u0.e("bot_file_preview_right", null, null, null, "preview", null, null, null, null, null, r11, null, 3054);
    }

    public final boolean e(c r7) {
        Fragment r0 = this.c.get();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L34;
        FLogger.a.w("AiFilePreviewShare", "skip download, reason=fragment_unavailable");
        return false;
    L34:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        Function1<? super IDriveDownloadFilePlugin.a, Boolean> r3 = this.h;     // Catch: Throwable -> L20
        if (r3 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        Object r9 = Result.constructor-impl(Boolean.valueOf(r8));     // Catch: Throwable -> L20
    L22:
        Throwable r4 = Result.exceptionOrNull-impl(r9);
        if (r4 == null) goto L25;
        FLogger.a.e("AiFilePreviewShare", "request download failed, errorType=".concat(r4.getClass().getSimpleName()));
    L25:
        Boolean r5 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L29;
        r9 = r5;
    L29:
        if (((Boolean) r9).booleanValue() == false) goto L32;
        FLogger.a.i("AiFilePreviewShare", "request download, result=accepted");
        return true;
    L32:
        FLogger.a.w("AiFilePreviewShare", "request download, result=unavailable");
        return false;
    L15:
        if (((Boolean) r3.invoke(r7)).booleanValue() != true) goto L17;
        r8 = true;
    L20:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L5:
        if (r0.isAdded() != true) goto L7;
        r1 = true;
        goto L9
    }

    public final void d(String r12, boolean r13, String r14) {
        if (r13 == false) goto L5;
        String r15 = "1";
    L6:
        u0.f("bot_file_preview_right", r15, r14, r12, null, null, null, "preview", a(false), null, 624);
        return;
    L5:
        r15 = "0";
        goto L6
    }

    public d(Fragment r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "requestId");
        this.a = r3;
        this.b = r5;
        this.c = new WeakReference(r2);
        String r6 = "ai_file_preview_download:".concat(r3);
        this.d = r6;
        String r7 = "ai_file_preview_share_open_result:".concat(r3);
        this.e = r7;
        if (r4 == null) goto L16;
        String r8 = StringsKt.trim(r4).toString();
        if (r8 == null) goto L16;
        String r9 = StringsKt.removePrefix(r8, ".");
        if (r9 == null) goto L16;
        String r10 = r9.toLowerCase(Locale.ROOT);
        if (r10 == null) goto L16;
        if (r10.length() <= 0) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L16;
    L17:
        this.f = r10;
        this.g = new LinkedHashSet();
        r2.getParentFragmentManager().setFragmentResultListener(r6, r2, new i89.a(this));
        r2.getParentFragmentManager().setFragmentResultListener(r7, r2, new i89.b(this));
        return;
    L13:
        r0 = false;
    L16:
        r10 = null;
        goto L17
    }
}
