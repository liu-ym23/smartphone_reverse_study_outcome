package h7;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.monitorV2.g;
import com.bytedance.ies.bullet.assembler.settings.BulletMixSwitch;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import jz2.d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BulletMixSwitch.ContainerType.values().length];
            r0[BulletMixSwitch.ContainerType.CARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BulletMixSwitch.ContainerType.POPUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BulletMixSwitch.ContainerType.FULLSCREEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public b() {
    }

    public static void a() {
        BulletMixSwitch r0 = BulletMixSwitch.INSTANCE;
        if (r0.getANNIEX_PAGE_ALLOW_LIST() == null) goto L6;
        ArrayList r1 = r0.getANNIEX_PAGE_ALLOW_LIST();
        Intrinsics.checkNotNull(r1);
        if (r1.isEmpty() == true) goto L6;
        return;
    L6:
        r0.setENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA(AnnieConfigSettingKeys.ENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA.a().booleanValue());
        List<String> r10 = AnnieConfigSettingKeys.ANNIEX_PAGE_ALLOW_LIST.a();
        ArrayList r11 = null;
        if ((r10 instanceof ArrayList) == false) goto L9;
        ArrayList r12 = (ArrayList) r10;
    L10:
        r0.setANNIEX_PAGE_ALLOW_LIST(r12);
        List<String> r13 = AnnieConfigSettingKeys.ANNIEX_PAGE_BLOCK_LIST.a();
        if ((r13 instanceof ArrayList) == false) goto L13;
        ArrayList r14 = (ArrayList) r13;
    L14:
        r0.setANNIEX_PAGE_BLOCK_LIST(r14);
        List<String> r15 = AnnieConfigSettingKeys.ANNIEX_CARD_ALLOW_LIST.a();
        if ((r15 instanceof ArrayList) == false) goto L17;
        ArrayList r16 = (ArrayList) r15;
    L18:
        r0.setANNIEX_CARD_ALLOW_LIST(r16);
        List<String> r17 = AnnieConfigSettingKeys.ANNIEX_CARD_BLOCK_LIST.a();
        if ((r17 instanceof ArrayList) == false) goto L21;
        ArrayList r18 = (ArrayList) r17;
    L22:
        r0.setANNIEX_CARD_BLOCK_LIST(r18);
        List<String> r19 = AnnieConfigSettingKeys.ANNIEX_CARD_BID_ALLOW_LIST.a();
        if ((r19 instanceof ArrayList) == false) goto L25;
        r11 = (ArrayList) r19;
    L25:
        r0.setANNIEX_CARD_BID_ALLOW_LIST(r11);
        return;
    L21:
        r18 = null;
        goto L22
    L17:
        r16 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    }

    public static void b(Context r10, Uri r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "scene");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L14
        boolean r14 = BulletSdk.a;     // Catch: Throwable -> L14
        if (BulletSdk.a == false) goto L6;
        return;
    L6:
        String r15 = UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L14
        if (r15 != null) goto L9;
        r15 = "unknown";
    L9:
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L14
        if (r10 == null) goto L12;
        BulletSdk.c(r10);     // Catch: Throwable -> L14
    L12:
        long r17 = System.currentTimeMillis() - r16;     // Catch: Throwable -> L14
        d.a r18 = new d.a("init_bullet_sdk");     // Catch: Throwable -> L14
        r18.b = "webcast_cn_container";     // Catch: Throwable -> L14
        r18.b(0);     // Catch: Throwable -> L14
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L14
        r19.put("scene", r12);     // Catch: Throwable -> L14
        r19.put(com.bytedance.android.ec.core.event.a.KEY_URL, r15);     // Catch: Throwable -> L14
        r18.d = r19;     // Catch: Throwable -> L14
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L14
        r20.put("cost", r17);     // Catch: Throwable -> L14
        r18.e = r20;     // Catch: Throwable -> L14
        r18.a = r15;     // Catch: Throwable -> L14
        d r21 = r18.a();     // Catch: Throwable -> L14
        g.e().getClass();     // Catch: Throwable -> L14
        g.c(r21);     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @JvmStatic
    public static final boolean c(Context r10, Uri r11, BulletMixSwitch.ContainerType r12) {
        Intrinsics.checkNotNullParameter(r11, "schemaUri");
        Intrinsics.checkNotNullParameter(r12, "type");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L45
        if (r10 == null) goto L6;
        String r14 = r10.getPackageName();     // Catch: Throwable -> L45
    L7:
        if (r14 != null) goto L10;
        r14 = "";
    L10:
        if (AnnieConfigSettingKeys.ANNIEX_WEBCAST_HOST_PACKAGENAME_BLOCKLIST.a().contains(r14) == false) goto L12;
        return false;
    L12:
        com.bytedance.android.anniex.assemble.a r15 = com.bytedance.android.anniex.assemble.a.a;     // Catch: Throwable -> L45
        AnnieXRuntime.a().getClass();     // Catch: Throwable -> L45
        String r16 = r11.toString();     // Catch: Throwable -> L45
        if (StringsKt.contains$default(r16, "://webcast_webview", false, 2, null) == false) goto L15;
    L18:
        boolean r17 = true;
    L19:
        if (r17 == true) goto L21;
        return false;
    L21:
        UriProtector.getQueryParameter(r11, "type");     // Catch: Throwable -> L45
        int r18 = a.a[r12.ordinal()];     // Catch: Throwable -> L45
        if (r18 == 1) goto L31;
        if (r18 != 2) goto L26;
        String r19 = com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP;
    L33:
        if (Intrinsics.areEqual(r19, "card") == false) goto L38;
        if (Intrinsics.areEqual(AnnieConfigSettingKeys.ANNIEX_CARD_ENABLE.a(), Boolean.FALSE) == false) goto L40;
        return false;
    L40:
        a();     // Catch: Throwable -> L45
        if (BulletMixSwitch.INSTANCE.enableMixLogic(r11, r12) == false) goto L43;
        return true;
    L43:
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L48:
        if (Result.exceptionOrNull-impl(r20) == null) goto L50;
        HybridLogger r21 = HybridLogger.a;
        HybridLogger.m("BulletMixSwitch", "isNewAnnie failure uri: " + r11, null, null, 12);
    L50:
        return false;
    L38:
        if (Intrinsics.areEqual(AnnieConfigSettingKeys.ANNIEX_PAGE_ENABLE.a(), Boolean.FALSE) == false) goto L40;
        return false;
    L26:
        if (r18 != 3) goto L29;
        r19 = "fullscreen";
        goto L33
    L29:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L45
    L31:
        r19 = "card";
        goto L33
    L15:
        if (StringsKt.contains$default(r16, "://webcast_lynxview", false, 2, null) == true) goto L18;
        r17 = false;
        goto L19
    L6:
        r14 = null;
    L45:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    }

    public static void d(String r10, boolean r11, String r12, Uri r13, Throwable r14) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r12, "errorMsg");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L15
        String r16 = UriProtector.getQueryParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L15
        if (r16 != null) goto L6;
        r16 = "unknown";
    L6:
        d.a r17 = new d.a("hybrid_container_create_failed");     // Catch: Throwable -> L15
        r17.b = "webcast_cn_container";     // Catch: Throwable -> L15
        r17.b(0);     // Catch: Throwable -> L15
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L15
        r18.put(com.bytedance.android.ec.core.event.a.KEY_URL, r16);     // Catch: Throwable -> L15
        r18.put("is_new_annie", r11);     // Catch: Throwable -> L15
        r18.put("scene", r10);     // Catch: Throwable -> L15
        r18.put("errorMsg", r12);     // Catch: Throwable -> L15
        r17.d = r18;     // Catch: Throwable -> L15
        r17.a = r16;     // Catch: Throwable -> L15
        d r19 = r17.a();     // Catch: Throwable -> L15
        g.e().getClass();     // Catch: Throwable -> L15
        g.c(r19);     // Catch: Throwable -> L15
        Method r20 = gz2.c.a;     // Catch: Throwable -> L15
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L15
        r21.put(com.bytedance.android.ec.core.event.a.KEY_URL, r16);     // Catch: Throwable -> L15
        r21.put("is_new_annie", r11);     // Catch: Throwable -> L15
        r21.put("scene", r10);     // Catch: Throwable -> L15
        r21.put("errorMsg", r12);     // Catch: Throwable -> L15
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L15
        gz2.c.f("hybrid_container_create_failed", r21);     // Catch: Throwable -> L15
        if (r14 == null) goto L12;
        int r111 = x8.a.a;     // Catch: Throwable -> L15
        x8.a.d("BulletMixSwitch", "============get hybrid" + r10 + " error: " + r14.getMessage(), false);     // Catch: Throwable -> L15
        StackTraceElement[] r112 = r14.getStackTrace();     // Catch: Throwable -> L15
        int r113 = r112.length;     // Catch: Throwable -> L15
        int r114 = 0;
    L9:
        if (r114 >= r113) goto L11;
        StackTraceElement r115 = r112[r114];     // Catch: Throwable -> L15
        int r116 = x8.a.a;     // Catch: Throwable -> L15
        x8.a.d("BulletMixSwitch", r115.toString(), false);     // Catch: Throwable -> L15
        r114 = r114 + 1;     // Catch: Throwable -> L15
        goto L9
    L11:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(r117);     // Catch: Throwable -> L15
        return;
    L12:
        r117 = null;
    L15:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
