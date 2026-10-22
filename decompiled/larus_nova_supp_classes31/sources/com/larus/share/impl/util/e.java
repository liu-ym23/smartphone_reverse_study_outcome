package com.larus.share.impl.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.i1;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.j1;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g1$a;
import com.larus.platform.api.g1$c;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.share.impl.panel.SharePanelServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t19.s;
import tx9.c2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final e a = null;
    public static final Set<String> b = null;

    public static final class a implements g1$c {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function1<Integer, Unit> d;

        @Override // com.larus.platform.api.g1$b
        public final void onGoSettingsDialogDismiss(boolean r1) {
        }

        @Override // com.larus.platform.api.g1$b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1$b
        public final void onSettingPageReturn() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Context r1, String r2, boolean r3, Function1<? super Integer, Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // com.larus.platform.api.g1$c
        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            if (r2 == false) goto L5;
            e.c(e.a, this.a, this.b, this.c, this.d);
            return;
        L5:
            Function1<Integer, Unit> r6 = this.d;
            if (r6 == null) goto L10;
            r6.invoke(2);
            return;
        }
    }

    public e() {
    }

    static {
        a = new e();
        b = SetsKt.setOf(new String[]{"forward", "message_forward", "merge_forward", "single_forward", "save_cloud"});
    }

    public static String e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("share_panel_config_single_row.json", "fileName");
        String r0 = "";
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r3.getAssets().open("share_panel_config_single_row.json")));     // Catch: Exception -> L17
    L23:
        String r4 = r1.readLine();     // Catch: Throwable -> L12
        if (r4 == null) goto L6;
        r0 = r0 + r4;     // Catch: Throwable -> L12
        goto L23
    L6:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L8:
        CloseableKt.closeFinally(r1, null);     // Catch: Exception -> L17
    L19:
        return r0;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Exception -> L17
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        FLogger.a.i("SharePanelUtil", e.toString());
        goto L19
    }

    public static List b(List r5, Boolean r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L16;
        jr9.a r1 = (jr9.a) r7.next();
        if (r1.a != null) goto L15;
        SharePanelServiceDelegate r2 = SharePanelServiceDelegate.b;
        String r3 = r1.b();
        if (r6 == null) goto L10;
        boolean r4 = r6.booleanValue();
    L11:
        jr9.b r8 = r2.e(r3, r4);
        if (r8 == null) goto L13;
        r1.a = r8;
        goto L15
    L13:
        FLogger.a.i("SharePanelUtil", "ui config empty for channelType: " + r1.b() + ", shareType: " + r1.c());
        goto L4
    L10:
        r4 = false;
    L15:
        r0.add(r1);
        goto L4
    L16:
        return r0;
    }

    public final void f(Context r10, String r11, boolean r12, Function1<? super Integer, Unit> r13) {
        if (Build.VERSION.SDK_INT > 29) goto L16;
        AppHost.Companion r0 = AppHost.a;
        if (ContextCompat.checkSelfPermission(r0.getApplication(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L16;
        FragmentActivity r1 = r0.a().getCurrentActivity();
        if ((r1 instanceof FragmentActivity) == false) goto L9;
        FragmentActivity r2 = r1;
    L10:
        FragmentActivity r3 = r2;
        if (r3 != null) goto L15;
        if (r13 == null) goto L18;
        r13.invoke(2);
        return;
    L18:
        return;
    L15:
        List r4 = CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE");
        i2 r5 = i2.b;
        a r6 = new a(r10, r11, r12, r13);
        JSONObject r7 = new JSONObject();
        r7.put("enter_method", "download");
        Unit r14 = Unit.INSTANCE;
        g1$a.b(r3, r4, r6, null, r7, 40);
        return;
    L9:
        r2 = null;
    L16:
        c(this, r10, r11, r12, r13);
    }

    public static void c(e r5, Context r6, String r7, boolean r8, Function1 r9) {
        r5.getClass();
        if (r6 == null) goto L5;
        Context r10 = r6.getApplicationContext();
    L49:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L23
        if (r10 == null) goto L20;
        if (r7 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L20;
        if (new PolarisFileWrapper(r7).exists() == false) goto L20;
        i1.f(r10, r7, r8);     // Catch: Throwable -> L23
        boolean r11 = true;
    L21:
        Object r12 = Result.constructor-impl(Boolean.valueOf(r11));     // Catch: Throwable -> L23
    L25:
        Object r4 = Boolean.FALSE;
        if (Result.isFailure-impl(r12) == true) goto L30;
        r4 = r12;
    L30:
        if (((Boolean) r4).booleanValue() == false) goto L41;
        if (r9 == null) goto L47;
        r9.invoke(1);
    L47:
        MediaScannerConnection.scanFile(r10, new String[]{r7}, new String[]{MimeTypeMap.getSingleton().getMimeTypeFromExtension(".mp4"), MimeTypeMap.getSingleton().getMimeTypeFromExtension(".jpeg")}, new com.larus.share.impl.util.a());     // Catch: Throwable -> L35
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L40;
        FLogger.a.i("SharePanelUtil", r14.toString());
    L40:
        s.a.getClass();
        s.o(r6, 2131908983, false);
        return;
    L35:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L41:
        Throwable r16 = Result.exceptionOrNull-impl(r12);
        if (r16 == null) goto L44;
        FLogger.a.i("SharePanelUtil", r16.toString());
    L44:
        if (r9 == null) goto L52;
        r9.invoke(2);
        return;
    L52:
        return;
    L11:
        if (r7.length() == 0) goto L14;
        r3 = false;
    L20:
        r11 = false;
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L5:
        r10 = null;
        goto L49
    }

    public static List d(e r5, List r6, boolean r7, BotModel r8, boolean r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r7 = false;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r8 = null;
    L9:
        if ((r10 & 4) == 0) goto L11;
        r9 = true;
    L11:
        r5.getClass();
        ArrayList r11 = new ArrayList();
        if (r6 == null) goto L47;
        Iterator r12 = r6.iterator();
    L15:
        if (r12.hasNext() == false) goto L47;
        jr9.a r13 = (jr9.a) r12.next();
        if (SharePanelServiceDelegate.b.a(r13.b()) == false) goto L15;
        String r2 = r13.b();
        if (Intrinsics.areEqual(r2, "collect") == false) goto L31;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L26;
        r3.getCollectService();
        if (j1.a.e() != true) goto L26;
        boolean r4 = true;
    L27:
        if (r4 == false) goto L42;
        if (r7 == false) goto L42;
    L43:
        boolean r14 = false;
    L44:
        if (r14 == true) goto L15;
        r11.add(r13);
    L42:
        r14 = true;
    L26:
        r4 = false;
        goto L27
    L31:
        if (Intrinsics.areEqual(r2, "export_file") == false) goto L43;
        z2 r15 = z2.a;
        if (r15.exportFileConfig().getEnableShareExportFile() == false) goto L42;
        if (r9 == false) goto L43;
        if (r15.exportFileConfig().getEnableMenuExportFile() == false) goto L42;
        if (r8 == null) goto L43;
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{-30, -10, -20}), r8.getBotStatus()) == false) goto L43;
    L47:
        return r11;
    }

    public static List a(List r16, String r17, String r18, int r19, String r20, int r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, JSONObject r30) {
        Intrinsics.checkNotNullParameter(r17, "aiCreationTaskId");
        Intrinsics.checkNotNullParameter(r18, "templateId");
        Intrinsics.checkNotNullParameter(r20, "messageId");
        ArrayList r7 = new ArrayList();
        Iterator r8 = r16.iterator();
    L4:
        if (r8.hasNext() == false) goto L78;
        jr9.a r9 = (jr9.a) r8.next();
        if (Intrinsics.areEqual(r9.b(), "save_image") == false) goto L8;
    L9:
        r9.b.put("ai_creation_task_id", r17);
        r9.b.put("template_id", r18);
        r9.b.put("has_original_image", String.valueOf(r19));
        r9.b.put("message_id", r20);
        r9.b.put("is_replica_gen", String.valueOf(r21));
        if (r24 == null) goto L12;
        r9.b.put("request_id", r24);
    L12:
        if (r23 == null) goto L14;
        r9.b.put("reply_id", r23);
    L14:
        if (r22 == null) goto L16;
        r9.b.put("creation_id", r22);
    L16:
        boolean r10 = false;
        if (r25 != null) goto L19;
    L27:
        if (r26 != null) goto L29;
    L37:
        Map<String, String> r13 = r9.b;
        if (r27 != null) goto L40;
    L43:
        boolean r14 = true;
    L45:
        if ((!r14) == false) goto L47;
        String r15 = r27;
    L48:
        if (r15 != null) goto L50;
        r15 = "0";
    L50:
        r13.put("is_general_agent", r15);
        Map<String, String> r110 = r9.b;
        if (r28 != null) goto L53;
        String r111 = "";
    L54:
        r110.put("chat_id", r111);
        if (r29 != null) goto L57;
    L64:
        Iterator<T> r11 = c2.a.iterator();
    L66:
        if (r11.hasNext() == false) goto L77;
        String r112 = (String) r11.next();
        if (r30 == null) goto L66;
        Object r113 = r30.opt(r112);
        if (r113 == null) goto L66;
        if ((!Intrinsics.areEqual(r113, JSONObject.NULL)) == true) goto L75;
        r113 = null;
    L75:
        if (r113 == null) goto L66;
        r9.b.put(r112, r113.toString());
    L77:
        r7.add(r9);
        goto L4
    L57:
        if (r29.length() <= 0) goto L59;
        r10 = true;
    L59:
        if (r10 == false) goto L61;
        String r12 = r29;
    L62:
        if (r12 == null) goto L64;
        r9.b.put("_mixed_richmedia_download_trace", r12);
        goto L64
    L61:
        r12 = null;
        goto L62
    L53:
        r111 = r28;
        goto L54
    L47:
        r15 = null;
        goto L48
    L40:
        if (r27.length() == 0) goto L43;
        r14 = false;
        goto L45
    L29:
        if (r26.length() <= 0) goto L31;
        boolean r114 = true;
    L32:
        if (r114 == false) goto L34;
        String r115 = r26;
    L35:
        if (r115 == null) goto L37;
        r9.b.put("rich_media_type", r115);
        goto L37
    L34:
        r115 = null;
        goto L35
    L31:
        r114 = false;
        goto L32
    L19:
        if (r25.length() <= 0) goto L21;
        boolean r116 = true;
    L22:
        if (r116 == false) goto L24;
        String r117 = r25;
    L25:
        if (r117 == null) goto L27;
        r9.b.put("doc_id", r117);
        goto L27
    L24:
        r117 = null;
        goto L25
    L21:
        r116 = false;
        goto L22
    L8:
        if (Intrinsics.areEqual(r9.b(), "save_video") == false) goto L77;
    L78:
        return r7;
    }
}
