package a3;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.domain.AppletDomainPolicyManager;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.applet.webview.FileChooserResultFragment;
import com.bytedance.ai.applet.webview.PermissionResultFragment;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import d3.a0;
import f2.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import z2.j;
import z2.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements z2.d {
    public static final C0000a f = null;
    public static final String g = null;
    public final Function0<a0> a;
    public final com.bytedance.ai.applet.domain.c b;
    public final com.bytedance.ai.applet.webview.a c;
    public final com.bytedance.ai.applet.webview.b d;
    public final Keva e;

    /* JADX INFO: renamed from: a3.a$a, reason: collision with other inner class name */
    public static final class C0000a {
        public C0000a() {
        }
    }

    static {
        f = new C0000a();
        g = "(function() {\n  if (window.__aisdk_vconsole_injected__) { return; }\n  window.__aisdk_vconsole_injected__ = true;\n  var s = document.createElement('script');\n  s.src = 'https://unpkg.com/vconsole@latest/dist/vconsole.min.js';\n  s.onload = function() {\n    try { if (window.VConsole) { new window.VConsole(); } } catch (e) {}\n  };\n  (document.head || document.documentElement).appendChild(s);\n})();";
    }

    public static boolean j() {
        h2.a r0 = f2.b.c;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.l == false) goto L8;
    L9:
        return true;
    L8:
        if (r0.k == true) goto L9;
        return false;
    }

    @Override // z2.d
    public final boolean b() {
        a0 r0 = (a0) this.a.invoke();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.getContainerType() == ContainerType.PAGE) goto L8;
        return true;
    L8:
        Long r10 = r0.getTraceId();
        if (r10 == null) goto L26;
        long r11 = r10.longValue();
        String r1 = r0.getAppletId();
        if (r1 != null) goto L13;
        return true;
    L13:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r12 = AppletAppManagerService.a(r1);
        if (r12 == null) goto L27;
        AppletAppActivity r13 = r12.d;
        if (r13 == null) goto L28;
        Long r14 = r13.C1();
        if (r14 != null) goto L22;
    L24:
        return false;
    L22:
        if (r14.longValue() != r11) goto L24;
        return true;
    L28:
        return true;
    L27:
        return true;
    L26:
        return true;
    }

    @Override // z2.d
    public final boolean c() {
        a0 r0 = (a0) this.a.invoke();
        if (r0 == null) goto L24;
        String r1 = r0.getAppletId();
        if (r1 == null) goto L24;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r10 = AppletAppManagerService.b(r1);
        if (r10 != null) goto L10;
        return false;
    L10:
        Object r11 = r10.h().d().f();
        if (Result.isFailure-impl(r11) == false) goto L13;
        r11 = null;
    L13:
        List r12 = (List) r11;
        if (r12 != null) goto L17;
        return false;
    L17:
        if (r12.size() <= 1) goto L19;
        return false;
    L19:
        AppletAppActivity r13 = ((AppletApplication) r10).d;
        if (r13 != null) goto L22;
        return false;
    L22:
        r13.onBackPressed();
        return true;
    L24:
        return false;
    }

    @Override // z2.d
    public final a0 getContainerContext() {
        return (a0) this.a.invoke();
    }

    @Override // z2.d
    public final boolean a() {
        if (j() == true) goto L6;
        return false;
    L6:
        return this.e.getBoolean("bypass_domain_verify", false);
    }

    @Override // z2.d
    public final Map<String, String> d() {
        if (j() == false) goto L5;
        String r10 = "";
        String r0 = this.e.getString("test_headers", "");
        if (r0 == null) goto L10;
        r10 = r0;
    L10:
        String r1 = StringsKt.trim(r10).toString();
        if (r1.length() != 0) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == true) goto L16;
        f.getClass();
        String r12 = StringsKt.trim(r1).toString();
        if (StringsKt.startsWith$default(r12, "{", false, 2, null) == true) goto L61;
    L31:
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = StringsKt.split$default(r12, new char[]{'\n', ';'}, false, 0, 6, null).iterator();
    L33:
        if (r14.hasNext() == false) goto L60;
        String r15 = StringsKt.trim((String) r14.next()).toString();
        if (r15.length() != 0) goto L37;
        boolean r16 = true;
    L38:
        if (r16 == true) goto L33;
        int r17 = r15.length();
        int r18 = 0;
    L40:
        if (r18 >= r17) goto L51;
        char r19 = r15.charAt(r18);
        if (r19 != ':') goto L44;
    L47:
        boolean r20 = true;
    L48:
        if (r20 == true) goto L52;
        r18 = r18 + 1;
    L52:
        if (r18 <= 0) goto L33;
        String r21 = StringsKt.trim(r15.substring(0, r18)).toString();
        String r22 = StringsKt.trim(r15.substring(r18 + 1)).toString();
        if (r21.length() <= 0) goto L56;
        boolean r23 = true;
    L57:
        if (r23 == false) goto L33;
        r13.put(r21, r22);
        goto L33
    L56:
        r23 = false;
        goto L57
    L44:
        if (r19 == '=') goto L47;
        r20 = false;
        goto L48
    L51:
        r18 = -1;
        goto L52
    L37:
        r16 = false;
        goto L38
    L60:
        return r13;
    L61:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L29
        JSONObject r25 = new JSONObject(r12);     // Catch: Throwable -> L29
        LinkedHashMap r26 = new LinkedHashMap();     // Catch: Throwable -> L29
        Iterator<String> r27 = r25.keys();     // Catch: Throwable -> L29
    L21:
        if (r27.hasNext() == false) goto L79;
        String r28 = r27.next();     // Catch: Throwable -> L29
        Intrinsics.checkNotNull(r28);     // Catch: Throwable -> L29
        String r29 = StringsKt.trim(r28).toString();     // Catch: Throwable -> L29
        if (r29.length() <= 0) goto L25;
        boolean r30 = true;
    L26:
        if (r30 == false) goto L21;
        r26.put(r29, r25.optString(r28));     // Catch: Throwable -> L29
        goto L21
    L25:
        r30 = false;
        goto L26
    L79:
        return r26;
    L29:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        goto L31
    L16:
        return MapsKt.emptyMap();
    L13:
        r11 = false;
        goto L14
    L5:
        return MapsKt.emptyMap();
    }

    @Override // z2.d
    public final String e() {
        if (j() == true) goto L6;
        return null;
    L6:
        if (this.e.getBoolean("enable_vconsole", false) == true) goto L9;
        return null;
    L9:
        return g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends a0> r10) {
        Intrinsics.checkNotNullParameter(r10, "containerContextProvider");
        this.a = r10;
        this.b = new com.bytedance.ai.applet.domain.c();
        this.c = new com.bytedance.ai.applet.webview.a();
        this.d = new com.bytedance.ai.applet.webview.b();
        this.e = Keva.getRepo("embed_webview_debug");
    }

    @Override // z2.d
    public final Set<String> f(String r10) {
        this.b.getClass();
        AppletDomainPolicyManager.a.getClass();
        com.bytedance.ai.applet.domain.f r11 = AppletDomainPolicyManager.i(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.b;
    }

    @Override // z2.d
    public final Boolean g(String r10) {
        this.b.getClass();
        if (com.bytedance.ai.settings.b.q.a().booleanValue() == false) goto L10;
        AppletDomainPolicyManager.a.getClass();
        com.bytedance.ai.applet.domain.f r11 = AppletDomainPolicyManager.i(r10);
        if (r11 != null) goto L11;
        return null;
    L11:
        return Boolean.valueOf(r11.a);
    L10:
        return Boolean.FALSE;
    }

    @Override // z2.d
    public final void i(s r11, final j r12) {
        Intrinsics.checkNotNullParameter(r11, "request");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(r11, "request");
        Intrinsics.checkNotNullParameter(r12, "callback");
        FragmentActivity r0 = k.b();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L7:
        if (r1 != null) goto L9;
    L95:
        com.bytedance.ai.applet.base.log.a.b("WebViewFileChooser", "no valid FragmentActivity", null);
        r12.a(CollectionsKt.emptyList());
        return;
    L9:
        if (r1.isFinishing() == true) goto L95;
        if (r1.isDestroyed() == true) goto L95;
        boolean r10 = true;
        if (r11.b == false) goto L63;
        List<String> r13 = r11.a;
        if ((r13 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r14 = r13.iterator();
    L22:
        if (r14.hasNext() == false) goto L26;
        if (StringsKt.startsWith$default((String) r14.next(), "video/", false, 2, null) == false) goto L22;
    L27:
        long r15 = System.currentTimeMillis();
        ContentValues r16 = new ContentValues();
        if (r10 == false) goto L30;
        r16.put("_display_name", "VID_" + r15 + ".mp4");
        r16.put("mime_type", "video/mp4");
    L31:
        if (r10 == false) goto L33;
        Uri r17 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    L101:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L36
        Object r19 = Result.constructor-impl(com.bytedance.ai.applet.webview.a.b(r1.getContentResolver(), r17, r16));     // Catch: Throwable -> L36
    L38:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L42;
        com.bytedance.ai.applet.base.log.b r21 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WebViewFileChooser", "createMediaUri failed: " + r20, null);
    L42:
        if (Result.isFailure-impl(r19) == false) goto L44;
        r19 = null;
    L44:
        Uri r110 = (Uri) r19;
        if (r110 != null) goto L47;
        com.bytedance.ai.applet.base.log.a.b("WebViewFileChooser", "failed to create capture URI", null);
        r12.a(CollectionsKt.emptyList());
        return;
    L47:
        if (r10 == false) goto L49;
        String r22 = "android.media.action.VIDEO_CAPTURE";
    L50:
        Intent r23 = new Intent(r22);
        r23.putExtra("output", r110);
        r23.setClipData(ClipData.newRawUri("", r110));
        r23.addFlags(3);
        int r24 = FileChooserResultFragment.i;     // Catch: Throwable -> L53
        FileChooserResultFragment.a.a(r1, r23, r110, new e(r12));     // Catch: Throwable -> L53
        Object r25 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L114;
        com.bytedance.ai.applet.base.log.b r27 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WebViewFileChooser", "capture launch failed: " + r26, null);
        Result.constructor-impl(Integer.valueOf(com.bytedance.ai.applet.webview.a.a(r1.getContentResolver(), r110)));     // Catch: Throwable -> L60
    L62:
        r12.a(CollectionsKt.emptyList());
        return;
    L60:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L114:
        return;
    L53:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L49:
        r22 = "android.media.action.IMAGE_CAPTURE";
    L36:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L33:
        r17 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        goto L101
    L30:
        r16.put("_display_name", "IMG_" + r15 + ".jpg");
        r16.put("mime_type", "image/jpeg");
    L26:
        r10 = false;
        goto L27
    L18:
        if (r13.isEmpty() == false) goto L20;
    L63:
        List<String> r31 = r11.a;
        ArrayList r32 = new ArrayList();
        Iterator<T> r33 = r31.iterator();
    L65:
        if (r33.hasNext() == false) goto L78;
        String r34 = StringsKt.trim((String) r33.next()).toString();
        if (r34.length() != 0) goto L69;
        boolean r35 = true;
    L70:
        if (r35 == false) goto L73;
        r34 = null;
    L76:
        if (r34 == null) goto L65;
        r32.add(r34);
        goto L65
    L73:
        if (StringsKt.contains$default(r34, '/', false, 2, null) == true) goto L76;
        r34 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.removePrefix(r34, ".").toLowerCase(Locale.ROOT));
        goto L76
    L69:
        r35 = false;
        goto L70
    L78:
        List r36 = CollectionsKt.distinct(r32);
        Intent r37 = new Intent("android.intent.action.GET_CONTENT");
        r37.addCategory("android.intent.category.OPENABLE");
        if (r36.isEmpty() == false) goto L82;
        r37.setType("*/*");
    L86:
        if (r11.c == false) goto L103;
        r37.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    L103:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L90
        int r112 = FileChooserResultFragment.i;     // Catch: Throwable -> L90
        FileChooserResultFragment.a.a(r1, r37, null, new d(r12));     // Catch: Throwable -> L90
        Object r113 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L90
    L92:
        Throwable r114 = Result.exceptionOrNull-impl(r113);
        if (r114 == null) goto L116;
        com.bytedance.ai.applet.base.log.b r38 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WebViewFileChooser", "picker launch failed: " + r114, null);
        r12.a(CollectionsKt.emptyList());
        return;
    L116:
        return;
    L90:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L92
    L82:
        if (r36.size() != 1) goto L84;
        r37.setType((String) ListProtector.get(r36, 0));
        goto L86
    L84:
        r37.setType("*/*");
        Intrinsics.checkNotNull(r37.putExtra("android.intent.extra.MIME_TYPES", (String[]) r36.toArray(new String[0])));
        goto L86
    L5:
        r1 = null;
        goto L7
    }

    @Override // z2.d
    public final void h(List r11, final z2.e r12, final z2.f r13) {
        Intrinsics.checkNotNullParameter(r11, "resources");
        Intrinsics.checkNotNullParameter(r12, "grant");
        Intrinsics.checkNotNullParameter(r13, "deny");
        final com.bytedance.ai.applet.webview.b r10 = this.d;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "resources");
        Intrinsics.checkNotNullParameter(r12, "grant");
        Intrinsics.checkNotNullParameter(r13, "deny");
        FragmentActivity r0 = k.b();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L7:
        if (r1 != null) goto L9;
    L44:
        com.bytedance.ai.applet.base.log.a.b("WebViewPermissionRequest", "no valid FragmentActivity, deny", null);
        r13.invoke();
        return;
    L9:
        if (r1.isFinishing() == true) goto L44;
        if (r1.isDestroyed() == true) goto L44;
        final ArrayList r14 = new ArrayList();
        Iterator r15 = r11.iterator();
    L15:
        if (r15.hasNext() == false) goto L20;
        Object r16 = r15.next();
        if (r10.a.containsKey((String) r16) == false) goto L15;
        r14.add(r16);
        goto L15
    L20:
        if (r14.isEmpty() == false) goto L22;
        com.bytedance.ai.applet.base.log.b r17 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WebViewPermissionRequest", "no supported resources in: " + r11, null);
        r13.invoke();
        return;
    L22:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r14.iterator();
    L24:
        if (r19.hasNext() == false) goto L28;
        String r20 = r10.a.get((String) r19.next());
        if (r20 == null) goto L24;
        r18.add(r20);
        goto L24
    L28:
        List r110 = CollectionsKt.distinct(r18);
        ArrayList r21 = new ArrayList();
        Iterator r111 = r110.iterator();
    L29:
        boolean r22 = false;
        if (r111.hasNext() == false) goto L37;
        Object r23 = r111.next();
        if (ContextCompat.checkSelfPermission(r1, (String) r23) == 0) goto L34;
        r22 = true;
    L34:
        if (r22 == false) goto L29;
        r21.add(r23);
        goto L29
    L37:
        if (r21.isEmpty() == false) goto L39;
        r12.invoke(r14);
        return;
    L39:
        int r112 = PermissionResultFragment.h;
        String[] r113 = (String[]) r21.toArray(new String[0]);
        final FragmentActivity r24 = r1;
        Function1<? super int[], Unit> r25 = new f(r12, r14, r13, r10, r24);
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r113, "permissions");
        Intrinsics.checkNotNullParameter(r25, "callback");
        PermissionResultFragment r114 = new PermissionResultFragment();
        r114.d = r25;
        r114.e = r113;
        FragmentTransaction r115 = r1.getSupportFragmentManager().beginTransaction();
        String r116 = "PermissionResultFragment-" + System.identityHashCode(r114);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r115, r114, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r116, 0) == true) goto L43;
        r115 = r115.add(r114, r116);
    L43:
        r115.commitAllowingStateLoss();
        return;
    L5:
        r1 = null;
        goto L7
    }
}
