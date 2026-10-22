package f79;

import a49.d;
import android.content.SharedPreferences;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.dorag.widget.model.DoraWidgetEntryContent;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static DoraWidgetEntryContent b() {
        SharedPreferences r0 = AppHost.a.getApplication().getSharedPreferences(c(), 0);
        if (r0.contains("deviceName") == false) goto L56;
        String r1 = r0.getString("deviceName", "");
        if (r1 != null) goto L7;
        String r5 = "";
    L8:
        boolean r6 = r0.getBoolean("isConnected", false);
        boolean r7 = r0.getBoolean("isGlassCharging", false);
        boolean r8 = r0.getBoolean("isBoxCharging", false);
        int r9 = r0.getInt("glassBattery", -1);
        int r10 = r0.getInt("boxBattery", -1);
        String r2 = r0.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "");
        if (r2 != null) goto L11;
        String r11 = "";
    L12:
        String r3 = r0.getString("serialNumber", "");
        if (r3 != null) goto L15;
        String r12 = "";
    L16:
        int r13 = r0.getInt("productId", 16);
        long r14 = r0.getLong("date", -1);
        String r4 = r0.getString("latestDiaryId", "");
        if (r4 != null) goto L19;
        String r16 = "";
    L20:
        String r15 = r0.getString("latestDiaryDate", "");
        if (r15 != null) goto L23;
        String r17 = "";
    L24:
        long r18 = r0.getLong("latestDiaryCreateTime", 0);
        String r110 = r0.getString("latestDiaryTitle", "");
        if (r110 != null) goto L27;
        String r22 = "";
    L28:
        String r111 = r0.getString("latestDiaryContent", "");
        if (r111 != null) goto L31;
        String r23 = "";
    L32:
        String r112 = r0.getString("latestDiaryEmotion", "");
        if (r112 != null) goto L35;
        String r24 = "";
    L36:
        String r113 = r0.getString("latestDiaryEmotionUrl", "");
        if (r113 != null) goto L39;
        String r25 = "";
    L40:
        long r20 = r0.getLong("lastDiaryFetchTime", 0);
        String r114 = r0.getString("betaDate", "");
        if (r114 != null) goto L43;
        String r28 = "";
    L44:
        String r115 = r0.getString("betaTitle", "");
        if (r115 != null) goto L47;
        String r210 = "";
    L48:
        String r116 = r0.getString("betaText", "");
        if (r116 != null) goto L51;
        String r30 = "";
    L52:
        String r21 = r0.getString("betaImageUrl", "");
        if (r21 != null) goto L58;
        r21 = "";
    L58:
        return new DoraWidgetEntryContent(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r22, r23, r24, r25, r20, r28, r210, r30, r21);
    L51:
        r30 = r116;
        goto L52
    L47:
        r210 = r115;
        goto L48
    L43:
        r28 = r114;
        goto L44
    L39:
        r25 = r113;
        goto L40
    L35:
        r24 = r112;
        goto L36
    L31:
        r23 = r111;
        goto L32
    L27:
        r22 = r110;
        goto L28
    L23:
        r17 = r15;
        goto L24
    L19:
        r16 = r4;
        goto L20
    L15:
        r12 = r3;
        goto L16
    L11:
        r11 = r2;
        goto L12
    L7:
        r5 = r1;
        goto L8
    L56:
        return null;
    }

    public static String c() {
        return "SPF_DORA_WIDGET-".concat(AccountService.a.getUserId());
    }

    public static boolean a() {
        DoraWidgetEntryContent r0 = b();
        if (r0 != null) goto L5;
        r0 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L5:
        DoraWidgetEntryContent r1 = DoraWidgetEntryContent.copy$default(r0, null, false, false, false, 0, 0, null, null, 0, 0, "", "", 0, "", "", "", "", 0, "", "", "", "", 132095, null);
        if (Intrinsics.areEqual(r1, r0) == false) goto L10;
        e();
        return false;
    L10:
        return f(DoraWidgetEntryContent.copy$default(r1, null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, System.currentTimeMillis(), null, null, null, null, 4063231, null));
    }

    public static boolean e() {
        DoraWidgetEntryContent r0 = b();
        if (r0 != null) goto L6;
        r0 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L6:
        return f(DoraWidgetEntryContent.copy$default(r0, null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, System.currentTimeMillis(), null, null, null, null, 4063231, null));
    }

    public static boolean d(d r58) {
        Intrinsics.checkNotNullParameter(r58, "card");
        DoraWidgetEntryContent r0 = b();
        if (r0 != null) goto L5;
        r0 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L5:
        String r2 = r58.a();
        if (r2 != null) goto L8;
        String r52 = "";
    L9:
        String r3 = r58.d();
        if (r3 != null) goto L12;
        String r53 = "";
    L13:
        String r4 = r58.c();
        if (r4 != null) goto L16;
        String r54 = "";
    L17:
        String r1 = r58.b();
        if (r1 != null) goto L20;
        String r55 = "";
    L21:
        DoraWidgetEntryContent r5 = DoraWidgetEntryContent.copy$default(r0, null, false, false, false, 0, 0, null, null, 0, 0, null, "", 0, "", "", "", "", 0, r52, r53, r54, r55, 133119, null);
        if (Intrinsics.areEqual(r5, r0) == false) goto L26;
        e();
        return false;
    L26:
        return f(DoraWidgetEntryContent.copy$default(r5, null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, System.currentTimeMillis(), null, null, null, null, 4063231, null));
    L20:
        r55 = r1;
        goto L21
    L16:
        r54 = r4;
        goto L17
    L12:
        r53 = r3;
        goto L13
    L8:
        r52 = r2;
        goto L9
    }

    public static boolean f(DoraWidgetEntryContent r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        if (Intrinsics.areEqual(b(), r4) == false) goto L5;
        return false;
    L5:
        SharedPreferences.Editor r0 = AppHost.a.getApplication().getSharedPreferences(c(), 0).edit();
        r0.putString("deviceName", r4.getDeviceName());
        r0.putBoolean("isConnected", r4.isConnected());
        r0.putBoolean("isGlassCharging", r4.isGlassCharging());
        r0.putBoolean("isBoxCharging", r4.isBoxCharging());
        r0.putInt("glassBattery", r4.getGlassBattery());
        r0.putInt("boxBattery", r4.getBoxBattery());
        r0.putString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r4.getModel());
        r0.remove("sn");
        r0.putString("serialNumber", r4.getSerialNumber());
        r0.putInt("productId", r4.getProductId());
        r0.putLong("date", r4.getDate());
        r0.putString("latestDiaryId", r4.getLatestDiaryId());
        r0.putString("latestDiaryDate", r4.getLatestDiaryDate());
        r0.putLong("latestDiaryCreateTime", r4.getLatestDiaryCreateTime());
        r0.putString("latestDiaryTitle", r4.getLatestDiaryTitle());
        r0.putString("latestDiaryContent", r4.getLatestDiaryContent());
        r0.putString("latestDiaryEmotion", r4.getLatestDiaryEmotion());
        r0.putString("latestDiaryEmotionUrl", r4.getLatestDiaryEmotionUrl());
        r0.putLong("lastDiaryFetchTime", r4.getLastDiaryFetchTime());
        r0.putString("betaDate", r4.getBetaDate());
        r0.putString("betaTitle", r4.getBetaTitle());
        r0.putString("betaText", r4.getBetaText());
        r0.putString("betaImageUrl", r4.getBetaImageUrl());
        r0.apply();
        return true;
    }

    public static boolean g(String r44, String r45, long r46, String r48, String r410, String r50, String r51) {
        Intrinsics.checkNotNullParameter(r44, "id");
        Intrinsics.checkNotNullParameter(r45, "date");
        Intrinsics.checkNotNullParameter(r48, "title");
        Intrinsics.checkNotNullParameter(r410, "content");
        Intrinsics.checkNotNullParameter(r50, "emotion");
        Intrinsics.checkNotNullParameter(r51, "emotionUrl");
        DoraWidgetEntryContent r0 = b();
        if (r0 != null) goto L5;
        r0 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L5:
        DoraWidgetEntryContent r1 = r0;
        return f(DoraWidgetEntryContent.copy$default(r1, null, false, false, false, 0, 0, null, null, 0, 0, r44, r45, r46, r48, r410, r50, r51, System.currentTimeMillis(), null, null, null, null, 3933183, null));
    }
}
