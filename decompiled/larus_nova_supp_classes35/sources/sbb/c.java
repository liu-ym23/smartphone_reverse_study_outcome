package sbb;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.docs.url.MiaodaUrlRoute;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final c a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MiaodaUrlRoute.values().length];
            r0[MiaodaUrlRoute.PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MiaodaUrlRoute.App.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new c();
    }

    public c() {
    }

    public static boolean b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "url");
        if (d(r1, false) == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static obb.b e(String r13) {
        Intrinsics.checkNotNullParameter(r13, "url");
        Log.i("DOCS_ICON_DocMetaUtil", "parseUrlToDocsMetaInfo");
        sbb.a r0 = new sbb.a(new b(SettingManager.getInstance().getSettingConfig("domain_config", true)));
        String r1 = UriProtector.parse(r13).getPath();
        if (r1 != null) goto L6;
        r1 = BuildConfig.FLAVOR;
    L6:
        if (b(r13) == false) goto L25;
        ubb.a r14 = d(r13, true);
        if (r14 != null) goto L11;
        return null;
    L11:
        if (r14.b == MiaodaUrlRoute.App) goto L13;
    L15:
        int r2 = a.a[r14.b.ordinal()];
        if (r2 != 1) goto L18;
        int r3 = BubbleStyle.ColorType.SINGLE_URL_CARD;
    L24:
        return new obb.b(r3, r14.a, null, null, null, null, null, null, 384);
    L18:
        if (r2 != 2) goto L21;
        r3 = BubbleStyle.ColorType.SINGLE_URL_CARD_IN_THREAD_CHAT;
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();
    L13:
        if ((!idb.f.a().isEnable("ccm.workspace.miaoda_app_url_infer_disable")) == false) goto L15;
        return new obb.b(e.e.b, null, null, null, null, null, null, null, 384);
    L25:
        String r15 = r0.b(r1);
        return new obb.b(e.g(r15), r0.a(r1), null, null, null, null, null, null, 384);
    }

    public static obb.b a(String r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "token");
        return new obb.b(r12, r11, null, null, null, null, null, null, 384);
    }

    public static obb.b c(obb.b r19, String r20) {
        if (r20 != null) goto L32;
    L31:
        return null;
    L32:
    L29:
        e = move-exception;
        Log.e("DOCS_ICON_DocMetaUtil", "parseDocMetaInfo fail " + e.getMessage());
        goto L31
    L5:
        if (TextUtils.isEmpty(r20) == true) goto L31;
        JSONObject r7 = new JSONObject(r20);     // Catch: Exception -> L29
        if (r19 == null) goto L10;
        String r8 = r19.b;     // Catch: Exception -> L29
        if (r8 == null) goto L10;
    L11:
        String r11 = r7.optString("token", r8);     // Catch: Exception -> L29
        if (r7.has("obj_type") == false) goto L15;
        int r1 = r7.optInt("obj_type");     // Catch: Exception -> L29
    L14:
        int r10 = r1;
        String r12 = r7.optString("file_type");     // Catch: Exception -> L29
        int r2 = r7.optInt(IPortraitService.TYPE);     // Catch: Exception -> L29
        String r14 = r7.optString("key");     // Catch: Exception -> L29
        int r3 = r7.optInt(Keys.API_RETURN_KEY_VERSION);     // Catch: Exception -> L29
        if (r7.has("obj_sub_type") == true) goto L21;
    L23:
        if (r19 == null) goto L26;
        Long r0 = r19.i;     // Catch: Exception -> L29
    L25:
        Long r17 = r0;
    L27:
        Integer r4 = Integer.valueOf(r2);     // Catch: Exception -> L29
        obb.b r5 = new obb.b(r10, r11, r12, r4, r14, Integer.valueOf(r3), null, r17, 128);     // Catch: Exception -> L29
        Log.i("DOCS_ICON_DocMetaUtil", "parseDocMetaInfo success " + r5.getType() + ' ' + r4);     // Catch: Exception -> L29
        return r5;
    L26:
        r17 = null;
        goto L27
    L21:
        if (r7.isNull("obj_sub_type") == true) goto L23;
        r0 = Long.valueOf(r7.optLong("obj_sub_type"));     // Catch: Exception -> L29
        goto L25
    L15:
        if (r19 == null) goto L17;
        r1 = r19.getType();     // Catch: Exception -> L29
        goto L14
    L17:
        r1 = e.e.b;     // Catch: Exception -> L29
    L10:
        r8 = BuildConfig.FLAVOR;
        goto L11
    }

    public static ubb.a d(String r11, boolean r12) {
        ubb.b r0 = ubb.b.a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl((String[]) jcb.b.c().b("suite_main_domain").toArray(new String[0]));     // Catch: Throwable -> L5
    L7:
        String[] r4 = new String[0];
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = r4;
    L10:
        String[] r5 = (String[]) r3;
        Object r6 = null;
        JSONArray r7 = new JSONArray(SettingManager.getInstance().getSettingConfig("miaoda_domain", true));     // Catch: Throwable -> L28
        ArrayList r8 = new ArrayList(r7.length());     // Catch: Throwable -> L28
        int r9 = r7.length();     // Catch: Throwable -> L28
        int r10 = 0;
    L12:
        if (r10 >= r9) goto L26;
        Object r13 = r7.opt(r10);     // Catch: Throwable -> L28
        if ((r13 instanceof String) == false) goto L16;
        String r14 = (String) r13;     // Catch: Throwable -> L28
    L17:
        if (r14 == null) goto L25;
        String r15 = StringsKt.trim(r14).toString();     // Catch: Throwable -> L28
        if (r15.length() <= 0) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L25;
        r8.add(r15);     // Catch: Throwable -> L28
        goto L25
    L22:
        r16 = false;
    L25:
        r10 = r10 + 1;     // Catch: Throwable -> L28
        goto L12
    L16:
        r14 = null;
        goto L17
    L26:
        Object r17 = Result.constructor-impl((String[]) r8.toArray(new String[0]));     // Catch: Throwable -> L28
    L30:
        String[] r18 = new String[0];
        if (Result.isFailure-impl(r17) == false) goto L33;
        r17 = r18;
    L33:
        List r19 = ArraysKt.asList((String[]) ArraysKt.plus(r5, (String[]) r17));
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r19, "allowedDomains");
        URI r1 = new URI(r11);     // Catch: Throwable -> L63
        if (ubb.b.a(r1, r19, r12) == false) goto L86;
        String r110 = r1.getPath();     // Catch: Throwable -> L63
        if (r110 != null) goto L40;
        r110 = BuildConfig.FLAVOR;
    L40:
        List r111 = StringsKt.split$default(r110, new char[]{'/'}, false, 0, 6, null);     // Catch: Throwable -> L63
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L63
        Iterator r113 = r111.iterator();     // Catch: Throwable -> L63
    L42:
        if (r113.hasNext() == false) goto L50;
        Object r20 = r113.next();     // Catch: Throwable -> L63
        if (((String) r20).length() <= 0) goto L46;
        boolean r21 = true;
    L47:
        if (r21 == false) goto L42;
        r112.add(r20);     // Catch: Throwable -> L63
        goto L42
    L46:
        r21 = false;
        goto L47
    L50:
        if (r112.size() != 2) goto L87;
        String r114 = (String) ListProtector.get(r112, 1);     // Catch: Throwable -> L63
        String r115 = (String) ListProtector.get(r112, 0);     // Catch: Throwable -> L63
        if (Intrinsics.areEqual(r115, "page") == false) goto L56;
        MiaodaUrlRoute r116 = MiaodaUrlRoute.PAGE;     // Catch: Throwable -> L63
    L61:
        Object r117 = Result.constructor-impl(new ubb.a(r114, r116));     // Catch: Throwable -> L63
    L66:
        if (Result.isFailure-impl(r117) == true) goto L70;
        r6 = r117;
    L70:
        return (ubb.a) r6;
    L56:
        if (Intrinsics.areEqual(r115, "app") == true) goto L58;
        return null;
    L58:
        if (StringsKt.startsWith$default(r114, "app_", false, 2, null) == false) goto L89;
        r116 = MiaodaUrlRoute.App;     // Catch: Throwable -> L63
        goto L61
    L89:
        return null;
    L87:
        return null;
    L86:
        return null;
    L63:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r117 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
