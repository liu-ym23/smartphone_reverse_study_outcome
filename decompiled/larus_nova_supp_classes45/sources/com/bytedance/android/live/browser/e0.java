package com.bytedance.android.live.browser;

import android.net.Uri;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static d1 a(String r9, String r11, String r12) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        v26.l r2 = new v26.l();     // Catch: Throwable -> L8
        v26.a r3 = new v26.a(false);     // Catch: Throwable -> L8
        r3.a(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO}));     // Catch: Throwable -> L8
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r3, "<set-?>");     // Catch: Throwable -> L8
        r2.b = r3;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r11, "<set-?>");     // Catch: Throwable -> L8
        r2.h = r11;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r12, "<set-?>");     // Catch: Throwable -> L8
        r2.i = r12;     // Catch: Throwable -> L8
        String r13 = "";
        Uri r14 = UriProtector.parse(r9);     // Catch: Throwable -> L8
        List<String> r0 = r14.getPathSegments();     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        int r15 = r0.size();     // Catch: Throwable -> L8
        r13 = StringsKt.replace$default(r14.buildUpon().clearQuery().build().toString(), ((String) ListProtector.get(r0, r15 - 2)) + "/" + ((String) ListProtector.get(r0, r15 - 1)), r12, false, 4, null);     // Catch: Throwable -> L8
    L6:
        boolean r16 = OfflineResourceClient.a;     // Catch: Throwable -> L8
        return OfflineResourceClient.d(r13, r2);
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public static d1 b(String r16, String r17, String r18) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        v26.l r6 = new v26.l();     // Catch: Throwable -> L14
        v26.a r4 = new v26.a(false);     // Catch: Throwable -> L14
        r4.a(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO}));     // Catch: Throwable -> L14
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Throwable -> L14
        r6.b = r4;     // Catch: Throwable -> L14
        r6.g = true;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r17, "<set-?>");     // Catch: Throwable -> L14
        r6.h = r17;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r18, "<set-?>");     // Catch: Throwable -> L14
        r6.i = r18;     // Catch: Throwable -> L14
        String r1 = "";
        Uri r7 = UriProtector.parse(r16);     // Catch: Throwable -> L14
        List<String> r8 = r7.getPathSegments();     // Catch: Throwable -> L14
        if (r8 == null) goto L12;
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L14
        int r2 = r8.size() - 1;     // Catch: Throwable -> L14
    L6:
        if (r2 < 0) goto L11;
        if (Intrinsics.areEqual((String) ListProtector.get(r8, r2), r17) == true) goto L11;
        r9.add(ListProtector.get(r8, r2));     // Catch: Throwable -> L14
        r2 = r2 - 1;     // Catch: Throwable -> L14
    L11:
        CollectionsKt.reverse(r9);     // Catch: Throwable -> L14
        r1 = StringsKt.replace$default(r7.buildUpon().clearQuery().build().toString(), CollectionsKt.joinToString$default(r9, "/", null, null, 0, null, null, 62, null), r18, false, 4, null);     // Catch: Throwable -> L14
    L12:
        boolean r0 = OfflineResourceClient.a;     // Catch: Throwable -> L14
        return OfflineResourceClient.d(r1, r6);
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public static JSONObject c(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "pageUrl");
        Intrinsics.checkNotNullParameter(r4, "channel");
        Intrinsics.checkNotNullParameter(r5, "configName");
        JSONObject r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
        d1 r6 = a(r3, r4, r5);     // Catch: Throwable -> L23
        if (r6 == null) goto L22;
        String r7 = r6.b;     // Catch: Throwable -> L23
        if (r7 == null) goto L34;
        PolarisFileInputStreamWrapper r8 = new PolarisFileInputStreamWrapper(r7);     // Catch: Throwable -> L23
        Reader r2 = new InputStreamReader(r8, Charsets.UTF_8);     // Catch: Throwable -> L17
        if ((r2 instanceof BufferedReader) == false) goto L11;
        BufferedReader r9 = (BufferedReader) r2;     // Catch: Throwable -> L17
    L12:
        JSONObject r11 = new JSONObject(TextStreamsKt.readText(r9));     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L15
        return r11;
    L15:
        Throwable th = th;
        r0 = r11;
    L25:
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return r0;
    L11:
        r9 = new BufferedReader(r2, IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L34:
        return null;
    L22:
        return null;
    L23:
        th = move-exception;
        th = th;
        goto L25
    }

    public static JSONObject d(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "pageUrl");
        Intrinsics.checkNotNullParameter(r4, "channel");
        Intrinsics.checkNotNullParameter(r5, "configName");
        JSONObject r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
        d1 r6 = b(r3, r4, r5);     // Catch: Throwable -> L23
        if (r6 == null) goto L22;
        String r7 = r6.b;     // Catch: Throwable -> L23
        if (r7 == null) goto L34;
        PolarisFileInputStreamWrapper r8 = new PolarisFileInputStreamWrapper(r7);     // Catch: Throwable -> L23
        Reader r2 = new InputStreamReader(r8, Charsets.UTF_8);     // Catch: Throwable -> L17
        if ((r2 instanceof BufferedReader) == false) goto L11;
        BufferedReader r9 = (BufferedReader) r2;     // Catch: Throwable -> L17
    L12:
        JSONObject r11 = new JSONObject(TextStreamsKt.readText(r9));     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L15
        return r11;
    L15:
        Throwable th = th;
        r0 = r11;
    L25:
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return r0;
    L11:
        r9 = new BufferedReader(r2, IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L34:
        return null;
    L22:
        return null;
    L23:
        th = move-exception;
        th = th;
        goto L25
    }
}
