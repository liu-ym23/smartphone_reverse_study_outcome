package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.R;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowFragment$createWebHelperListener$1;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.pb.entities.Cipher;
import com.ss.android.lark.pb.entities.Crypto;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmEndWindowWebHelper {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;
    public final CoroutineScope c;
    public final ViewGroup d;
    public final w e;
    public final Lazy f;
    public OfficeWebView g;
    public String h;
    public boolean i;
    public final int j;
    public String k;
    public final Lazy l;
    public final boolean m;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e n;

    public static final class a {
        public final String a;
        public final String b;
        public final ByteString c;
        public final int d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ImageViewerConfig(imageKey=" + this.a + ", fsUnit=" + this.b + ", crypto=" + this.c + ", width=" + this.d + ", height=" + this.e + ')';
        }

        public a(String r2, String r3, ByteString r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "imageKey");
            Intrinsics.checkNotNullParameter(r4, "crypto");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public final void e() {
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.WEB, "destroyWebViewOnly", null, f(), 4);
        OfficeWebView r1 = this.g;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ((ConcurrentHashMap) r1.getBridge().b.a).clear();
        r1.stopLoading();
        r1.getSettings().setJavaScriptEnabled(false);
        r1.clearHistory();
        r1.clearView();
        r1.removeAllViews();
        r1.destroy();
    L5:
        this.d.removeAllViews();
        this.g = null;
    }

    public final String f() {
        return (String) this.f.getValue();
    }

    public final void g() {
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "initWebView", "create new webView", f());
        OfficeWebView r1 = new OfficeWebView(this.d.getContext(), null, 6);
        r1.setHorizontalScrollBarEnabled(false);
        r1.setVerticalScrollBarEnabled(false);
        r1.getSettings().setJavaScriptEnabled(true);
        r1.getSettings().setSupportZoom(false);
        r1.setBackgroundColor(ContextCompat.getColor(r1.getContext(), R.color.transparent));
        r1.setOverScrollMode(2);
        r1.setLayerType(2, null);
        if (DevEnvUtil.isDebugMode(r1.getContext()) == false) goto L5;
        WebView.setWebContentsDebuggingEnabled(true);
    L5:
        r1.setWebViewClient(new com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.a(this, this.n));
        xwb.a r2 = r1.getBridge();
        r2.b("common.close", new l(this));
        r2.b("common.showToast", new o(this));
        r2.b("common.sendTrackEvent", new p(this));
        r2.b("common.openWeb", new q(this));
        r2.b("minutes.updateTitle", new r(this));
        r2.b("common.notifyLoadComplete", new s(this));
        r2.b("common.log", new t(this));
        if (this.m == false) goto L8;
        r2.b("minutes.getPictures", new u(this));
        r2.b("minutes.loadLocationChooser", new v(this));
    L8:
        r2.b("minutes.getAvatarInfo", new b(this));
        r2.b("common.getAvatarBase64", new c(this));
        r2.b("common.openProfile", new d(this));
        r2.b("minutes.getMinutesInfo", new e(this));
        r2.b("minutes.getDoubaoUserInfo", new f(this));
        r2.b("common.getDomain", new g(this));
        r2.b("common.getFG", new h(this));
        r2.b("common.getSettings", new i(this));
        r2.b("common.ready", new j(this));
        r2.b("common.networkProxy", new k(this));
        r2.b("minutes.changeSpeaker", new m(this));
        r2.b("minutes.showImageViewer", new n(this));
        this.d.removeAllViews();
        this.d.addView(r1, new ViewGroup.LayoutParams(-1, -1));
        this.g = r1;
    }

    public static Cipher b(JSONObject r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Cipher.Builder r0 = new Cipher.Builder();
        ByteString r1 = d(r2.optString("secret"));
        if (r1 == null) goto L8;
        r0.secret(r1);
    L8:
        ByteString r3 = d(r2.optString("nonce"));
        if (r3 == null) goto L11;
        r0.nonce(r3);
    L11:
        ByteString r4 = d(r2.optString("additionalData"));
        if (r4 == null) goto L15;
        r0.additional_data(r4);
    L15:
        return r0.m1181build();
    }

    public static ByteString d(String r3) {
        Object r0 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L23;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        ByteString.a r2 = ByteString.Companion;     // Catch: Throwable -> L12
        byte[] r4 = Base64.decode(r3, 0);     // Catch: Throwable -> L12
        byte[] r5 = Arrays.copyOf(r4, r4.length);     // Catch: Throwable -> L12
        r2.getClass();     // Catch: Throwable -> L12
        Object r6 = Result.constructor-impl(ByteString.a.c(r5));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == true) goto L19;
        r0 = r6;
    L19:
        return (ByteString) r0;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L23:
        return null;
    }

    public static Crypto.Type j(Object r2) {
        if ((r2 instanceof Number) == true) goto L24;
        Object r1 = null;
        if ((r2 instanceof String) == false) goto L21;
        Integer r0 = StringsKt.toIntOrNull((String) r2);
        if (r0 != null) goto L10;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl(Crypto.Type.valueOf((String) r2));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r4) == true) goto L25;
        r1 = r4;
    L25:
        return (Crypto.Type) r1;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L10:
        return Crypto.Type.fromValue(r0.intValue());
    L21:
        return null;
    L24:
        return Crypto.Type.fromValue(((Number) r2).intValue());
    }

    public final void i(String r7) {
        Intrinsics.checkNotNullParameter(r7, "url");
        if (TextUtils.isEmpty(r7) == false) goto L6;
        int r0 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "loadUrl", "url is empty or webView is null, url=" + r7, f());
        return;
    L6:
        this.k = r7;
        if (this.e.isDarkMode() == false) goto L9;
        String r1 = "dark";
    L10:
        String r2 = "theme=".concat(r1);
        if (StringsKt.contains$default(r7, "?", false, 2, null) == false) goto L13;
        StringBuilder r3 = new StringBuilder();
        r3.append(r7);
        char r8 = '&';
    L14:
        r3.append(r8);
        r3.append(r2);
        String r9 = r3.toString();
        int r4 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "loadUrl", "url=" + r9, f());
        OfficeWebView r5 = this.g;
        if (r5 == null) goto L18;
        r5.loadUrl(r9);
        return;
    L18:
        return;
    L13:
        r3 = new StringBuilder();
        r3.append(r7);
        r8 = '?';
        goto L14
    L9:
        r1 = "light";
        goto L10
    }

    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g> k(JSONArray r15) {
        if (r15 == null) goto L85;
        if (r15.length() == 0) goto L85;
        ArrayList r0 = new ArrayList();
        int r1 = r15.length();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L83;
        JSONObject r4 = r15.optJSONObject(r3);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g r5 = null;
        if (r4 == null) goto L82;
        String r6 = r4.optString("imageKey");
        if (StringsKt.isBlank(r6) == false) goto L15;
        r6 = r4.optString("image_key");
    L15:
        if (StringsKt.isBlank(r6) == false) goto L17;
        r6 = r4.optString("key");
    L17:
        Intrinsics.checkNotNull(r6);
        if ((!StringsKt.isBlank(r6)) == false) goto L20;
        String r9 = r6;
    L22:
        if (r9 != null) goto L24;
        a r7 = null;
    L57:
        String r8 = r4.optString("url");
        if (StringsKt.isBlank(r8) == false) goto L61;
        r8 = r4.optString("uri");
    L61:
        if (StringsKt.isBlank(r8) == false) goto L64;
        r8 = r4.optString("localUri");
    L64:
        if (StringsKt.isBlank(r8) == false) goto L66;
        r8 = r4.optString("local_uri");
    L66:
        String r10 = r4.optString("thumbUrl");
        if (StringsKt.isBlank(r10) == false) goto L70;
        r10 = r4.optString("thumb_url");
    L70:
        if (StringsKt.isBlank(r10) == false) goto L73;
        r10 = r4.optString("thumbUri");
    L73:
        if (StringsKt.isBlank(r10) == false) goto L75;
        r10 = r4.optString("thumb_uri");
    L75:
        Intrinsics.checkNotNull(r8);
        if (StringsKt.isBlank(r8) == false) goto L81;
        Intrinsics.checkNotNull(r10);
        if (StringsKt.isBlank(r10) == false) goto L81;
        if (r7 != null) goto L81;
        int r11 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "showImageViewer", "image uri is empty", f());
    L81:
        r5 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g(c(r8, r7), c(r10, r7));
        goto L82
    L24:
        String r12 = r4.optString("fsUnit");
        if (StringsKt.isBlank(r12) == false) goto L27;
        r12 = r4.optString("fs_unit");
    L27:
        Intrinsics.checkNotNull(r12);
        if ((!StringsKt.isBlank(r12)) == false) goto L30;
        String r13 = r12;
    L31:
        JSONObject r14 = r4.optJSONObject("crypto");
        if (r14 != null) goto L86;
        ByteString r16 = ByteString.EMPTY;
    L56:
        r7 = new a(r9, r13, r16, r4.optInt("width", 0), r4.optInt("height", 0));
        goto L57
    L86:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L47
        Crypto.Builder r18 = new Crypto.Builder();     // Catch: Throwable -> L47
        Crypto.Type r19 = j(r14.opt("type"));     // Catch: Throwable -> L47
        if (r19 == null) goto L38;
        r18.type(r19);     // Catch: Throwable -> L47
    L38:
        Cipher r20 = b(r14.optJSONObject("cipher"));     // Catch: Throwable -> L47
        if (r20 == null) goto L41;
        r18.cipher(r20);     // Catch: Throwable -> L47
    L41:
        byte[] r21 = r18.m1184build().encode();     // Catch: Throwable -> L47
        if (r21 == null) goto L44;
        ByteString r22 = ByteString.a.e(ByteString.Companion, r21);     // Catch: Throwable -> L47
    L45:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L47
    L49:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L52;
        int r110 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "showImageViewer", "parse crypto failed, error=" + r24.getMessage(), f());
    L52:
        ByteString r25 = ByteString.EMPTY;
        if (Result.isFailure-impl(r23) == false) goto L55;
        r23 = r25;
    L55:
        r16 = (ByteString) r23;
        goto L56
    L44:
        r22 = ByteString.EMPTY;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L30:
        r13 = null;
        goto L31
    L20:
        r9 = null;
    L82:
        r0.add(r5);
        r3 = r3 + 1;
        goto L7
    L83:
        return r0;
    L85:
        return CollectionsKt.emptyList();
    }

    public final void l(boolean r7) {
        BuildersKt.launch$default(this.c, null, null, new MmEndWindowWebHelper$updateTheme$1(this, r7, null), 3, null);
    }

    public static com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h c(String r12, a r13) {
        String r1 = null;
        if (r12 == null) goto L15;
        boolean r3 = true;
        if ((!StringsKt.isBlank(r12)) == false) goto L12;
        if (r13 == null) goto L8;
        String r2 = r13.a;
    L10:
        if (Intrinsics.areEqual(r12, r2) == true) goto L12;
    L13:
        if (r3 == false) goto L15;
        String r5 = r12;
    L17:
        if (r13 == null) goto L19;
        String r6 = r13.a;
    L20:
        if (r13 == null) goto L22;
        r1 = r13.b;
    L22:
        String r7 = r1;
        if (r13 == null) goto L26;
        ByteString r4 = r13.c;
        if (r4 == null) goto L26;
    L27:
        ByteString r8 = r4;
        if (r13 == null) goto L30;
        int r9 = r13.d;
    L31:
        if (r13 == null) goto L33;
        int r10 = r13.e;
    L34:
        if (r5 == null) goto L36;
        String r14 = "localOrUrl";
    L38:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h(r5, r6, r7, r8, r9, r10, r14);
    L36:
        r14 = "remoteConfig";
        goto L38
    L33:
        r10 = 0;
        goto L34
    L30:
        r9 = 0;
    L26:
        r4 = ByteString.EMPTY;
        goto L27
    L19:
        r6 = null;
        goto L20
    L8:
        r2 = null;
    L12:
        r3 = false;
    L15:
        r5 = null;
        goto L17
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0081 -> B:20:0x0085). Please report as a decompilation issue!!! */
    public static final Object a(MmEndWindowWebHelper r12, int r13, Continuation r14) {
        r12.getClass();
        if ((r14 instanceof MmEndWindowWebHelper$buildAvatarInfoArray$1) == false) goto L7;
        MmEndWindowWebHelper$buildAvatarInfoArray$1 r0 = (MmEndWindowWebHelper$buildAvatarInfoArray$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r4 = r0.J$0;
        r13 = r0.I$0;
        MmEndWindowAvatar r5 = (MmEndWindowAvatar) r0.L$3;
        Iterator r6 = (Iterator) r0.L$2;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c) r0.L$1;
        JSONArray r8 = (JSONArray) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L20:
        Bitmap r16 = (Bitmap) r15;
        if (r16 == null) goto L16;
        JSONObject r9 = new JSONObject();
        r9.put("type", r5.getType());
        r9.put("userId", r5.getUserId());
        r9.put("fakeNameId", r5.getFakeNameId());
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        r16.compress(Bitmap.CompressFormat.PNG, 100, r10);     // Catch: Throwable -> L26
        String r17 = Base64.encodeToString(r10.toByteArray(), 2);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r10, null);
        r9.put("avatarBase64", r17);
        r8.put(r9);
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L16:
        if (r6.hasNext() == false) goto L31;
        r5 = (MmEndWindowAvatar) r6.next();
        r0.L$0 = r8;
        r0.L$1 = r7;
        r0.L$2 = r6;
        r0.L$3 = r5;
        r0.I$0 = r13;
        r0.J$0 = r4;
        r0.label = 1;
        r15 = r12.h(r5, r13, r0);
        if (r15 != r2) goto L20;
        return r2;
    L31:
        int r18 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "getAvatarInfo", "cost=" + (System.currentTimeMillis() - r4) + "ms, avatarCount=" + r8.length() + ", sourceCount=" + r7.f.size(), r12.f());
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r4 = System.currentTimeMillis();
        JSONArray r19 = new JSONArray();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r11 = r12.e.i();
        r6 = r11.f.iterator();
        r8 = r19;
        r7 = r11;
    L7:
        r0 = new MmEndWindowWebHelper$buildAvatarInfoArray$1(r12, r14);
        goto L8
    }

    public final Object h(MmEndWindowAvatar r7, int r8, Continuation<? super Bitmap> r9) {
        if ((r9 instanceof MmEndWindowWebHelper$loadEndWindowAvatar$1) == false) goto L7;
        MmEndWindowWebHelper$loadEndWindowAvatar$1 r0 = (MmEndWindowWebHelper$loadEndWindowAvatar$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r7 = (MmEndWindowAvatar) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L42
    L38:
        Bitmap r11 = (Bitmap) r10;     // Catch: Throwable -> L42
    L40:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L42
    L44:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L48;
        int r5 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "getAvatarInfo", "load avatar failed, type=" + r7.getType() + ", userId=" + r7.getUserId() + ", error=" + r13, f());
    L48:
        if (Result.isFailure-impl(r12) == false) goto L51;
        return null;
    L51:
        return r12;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r7 = (MmEndWindowAvatar) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L42
    L29:
        r11 = (Bitmap) r10;     // Catch: Throwable -> L42
        goto L40
    L20:
        ResultKt.throwOnFailure(r10);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L42
        if (r7.getAvatarKey().length() <= 0) goto L24;
        boolean r15 = true;
    L25:
        if (r15 == false) goto L31;
        w r16 = this.e;     // Catch: Throwable -> L42
        String r6 = r7.getAvatarKey();     // Catch: Throwable -> L42
        String r17 = r7.getUserId();     // Catch: Throwable -> L42
        r0.L$0 = r7;     // Catch: Throwable -> L42
        r0.label = 1;     // Catch: Throwable -> L42
        r10 = r16.c(r6, r17, r8, r0);     // Catch: Throwable -> L42
        if (r10 != r2) goto L29;
        return r2;
    L31:
        if (r7.getAvatarUrl().length() > 0) goto L34;
        r4 = false;
    L34:
        if (r4 == false) goto L39;
        w r18 = this.e;     // Catch: Throwable -> L42
        String r19 = r7.getAvatarUrl();     // Catch: Throwable -> L42
        r0.L$0 = r7;     // Catch: Throwable -> L42
        r0.label = 2;     // Catch: Throwable -> L42
        r10 = r18.m(r19, r8, r0);     // Catch: Throwable -> L42
        if (r10 != r2) goto L38;
        return r2;
    L39:
        r11 = null;
        goto L40
    L24:
        r15 = false;
    L42:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new MmEndWindowWebHelper$loadEndWindowAvatar$1(this, r9);
        goto L8
    }

    public MmEndWindowWebHelper(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r9, String r10, LifecycleCoroutineScope r11, ViewGroup r12, MmEndWindowFragment$createWebHelperListener$1 r13) {
        Intrinsics.checkNotNullParameter(r9, "uccApi");
        Intrinsics.checkNotNullParameter(r10, "meetingId");
        Intrinsics.checkNotNullParameter(r11, "mainScope");
        Intrinsics.checkNotNullParameter(r12, "webViewContainer");
        Intrinsics.checkNotNullParameter(r13, "listener");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = LazyKt.lazy(new MmEndWindowWebHelper$logDetail$2(this));
        this.h = "";
        this.j = 96;
        this.k = "";
        this.l = LazyKt.lazy(MmEndWindowWebHelper$mapReadHelper$2.INSTANCE);
        this.m = true;
        this.n = new com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e(new com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e.b("end_window", 3, new MmEndWindowWebHelper$renderGoneHandler$1(this), new MmEndWindowWebHelper$renderGoneHandler$2(this), new MmEndWindowWebHelper$renderGoneHandler$3(this), new MmEndWindowWebHelper$renderGoneHandler$4(this), new MmEndWindowWebHelper$renderGoneHandler$5(this)));
        g();
    }
}
