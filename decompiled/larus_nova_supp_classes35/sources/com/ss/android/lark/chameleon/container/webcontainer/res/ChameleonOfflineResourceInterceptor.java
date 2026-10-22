package com.ss.android.lark.chameleon.container.webcontainer.res;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.PreloadConfig;
import com.ss.android.lark.chameleon.api.ResInterceptConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.LanguageUtil;
import com.ss.android.lark.chameleon.utils.ChameleonDebugUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J4\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/ChameleonOfflineResourceInterceptor;", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/IWebResourceInterceptor;", "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "(Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;Lcom/ss/android/lark/chameleon/api/ChameleonConfig;)V", "debugOfflinePath", "Ljava/nio/file/Path;", "getDebugOfflinePath", "()Ljava/nio/file/Path;", "debugOfflinePath$delegate", "Lkotlin/Lazy;", "resRootPath", BuildConfig.FLAVOR, "getMime", "url", "getPathFromUrl", "getRootPath", "replaceHtml", "str", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "uri", "Landroid/net/Uri;", "requestMethod", "headers", BuildConfig.FLAVOR, "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonOfflineResourceInterceptor implements IWebResourceInterceptor {
    public static final Companion Companion = null;
    public static final String DOC_SOURCE_PREFIX = "docsource://";
    public static final String TAG = "CML_TAG_OfflineRes";
    private final ChameleonConfig chameleonConfig;
    private final Lazy debugOfflinePath$delegate;
    private String resRootPath;
    private final ChameleonWebView webView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/ChameleonOfflineResourceInterceptor$Companion;", BuildConfig.FLAVOR, "()V", "DOC_SOURCE_PREFIX", BuildConfig.FLAVOR, "TAG", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final Path getDebugOfflinePath() {
        return (Path) this.debugOfflinePath$delegate.getValue();
    }

    private final String getRootPath() {
        Path r0 = getDebugOfflinePath();
        if (r0 == null) goto L6;
        Log.i(TAG, "set debug local path, resRootPathDebug: " + r0.toAbsolutePath().toString());
        return r0.toAbsolutePath().toString();
    L6:
        String r1 = this.webView.getResource(true).getPath();
        if (r1 != null) goto L10;
        Log.w(TAG, "resRootPath is null");
        return null;
    L10:
        return r1;
    }

    public static final /* synthetic */ ChameleonConfig access$getChameleonConfig$p(ChameleonOfflineResourceInterceptor r0) {
        return r0.chameleonConfig;
    }

    private final Path getDebugOfflinePath(ChameleonConfig r8) {
        String r9 = r8.getBizName();
        if (Env.isDebug() == false) goto L37;
        boolean r3 = true;
        if (r9 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L37;
        ChameleonDebugUtils r5 = ChameleonDebugUtils.INSTANCE;
        if (r5.isOfflineResDisabled() == false) goto L17;
        Log.d(TAG, "getDebugOfflinePath: disabled, return null");
        return null;
    L17:
        String r6 = r5.getSpecificBizname();
        String r7 = BuildConfig.FLAVOR;
        if (r6 != null) goto L21;
        r6 = BuildConfig.FLAVOR;
    L21:
        if (Intrinsics.areEqual(r6, r9) == true) goto L24;
        Log.d(TAG, "getDebugOfflinePath: bizName not match, return null");
        return null;
    L24:
        String r10 = r5.getSpecificResPath();
        if (r10 == null) goto L28;
        r7 = r10;
    L28:
        Log.i(TAG, "Using localPath: " + r7 + ", for bizName: " + r6);
        PolarisFileWrapper r11 = new PolarisFileWrapper(r7);
        if (r11.exists() == true) goto L32;
        r3 = false;
    L32:
        if (r3 == true) goto L36;
        Log.d(TAG, "getDebugOfflinePath: file not exist, return null");
        return null;
    L36:
        return Paths.get(r11.getAbsolutePath(), new String[0]);
    L7:
        if (r9.length() == 0) goto L10;
        r4 = false;
    L37:
        Log.d(TAG, "getDebugOfflinePath: bizName is null or empty, return null");
        return null;
    }

    private final String getMime(String r5) {
        String r6 = UriProtector.parse(r5).getPath();
        if (r6 != null) goto L5;
    L23:
        return "text/html";
    L5:
        if (StringsKt.endsWith$default(r6, ".css", false, 2, null) == false) goto L8;
        return "text/css";
    L8:
        if (StringsKt.endsWith$default(r6, ".js", false, 2, null) == false) goto L11;
        return "application/x-javascript";
    L11:
        if (StringsKt.endsWith$default(r6, ".jpg", false, 2, null) == false) goto L13;
    L22:
        return "image/*";
    L13:
        if (StringsKt.endsWith$default(r6, ".gif", false, 2, null) == true) goto L22;
        if (StringsKt.endsWith$default(r6, ".png", false, 2, null) == true) goto L22;
        if (StringsKt.endsWith$default(r6, ".jpeg", false, 2, null) == true) goto L22;
        if (StringsKt.endsWith$default(r6, ".webp", false, 2, null) == true) goto L22;
        if (StringsKt.endsWith$default(r6, ".bmp", false, 2, null) == false) goto L23;
        goto L22
    }

    private final String getPathFromUrl(String r8) {
        ResInterceptConfig r0 = this.chameleonConfig.getResInterceptConfig();
        if (r0 == null) goto L11;
        String r1 = r0.getPathRewrites();
        if (r1 == null) goto L13;
        int r2 = StringsKt.indexOf$default(r8, r1, 0, false, 6, null);
        if (r2 != (-1)) goto L10;
        return r8;
    L10:
        return r8.substring(r2 + r1.length());
    L13:
        return r8;
    L11:
        return r8;
    }

    private final String replaceHtml(String r8) {
        ResInterceptConfig r0 = this.chameleonConfig.getResInterceptConfig();
        boolean r1 = false;
        if (r0 == null) goto L9;
        ArrayList<String> r2 = r0.getCommonTemplateVars();
        if (r2 == null) goto L9;
        if ((!r2.isEmpty()) != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L29;
        ResInterceptConfig r3 = this.chameleonConfig.getResInterceptConfig();
        if (r3 == null) goto L30;
        ArrayList<String> r4 = r3.getCommonTemplateVars();
        if (r4 == null) goto L31;
        Iterator<T> r5 = r4.iterator();
        String r6 = r8;
    L16:
        if (r5.hasNext() == false) goto L22;
        String r9 = (String) r5.next();
        String r7 = "{{" + r9 + "}}";
        if (TextUtils.equals(r9, "locale") == true) goto L19;
        Log.w(TAG, "replaceHtml it : " + r9);
        goto L16
    L19:
        Locale r10 = Env.getCacheLanguageSetting();
        String r11 = LanguageUtil.convertLan(r10.getCountry(), r10.getLanguage()).toString();
        Log.i(TAG, "replaceHtml it : " + r9 + ",  locale : " + r11);
        r6 = StringsKt.replace$default(r6, r7, r11, false, 4, null);
        goto L16
    L22:
        return r6;
    L31:
        return r8;
    L30:
        return r8;
    L29:
        return r8;
    }

    public ChameleonOfflineResourceInterceptor(ChameleonWebView r2, ChameleonConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "chameleonConfig");
        this.webView = r2;
        this.chameleonConfig = r3;
        this.debugOfflinePath$delegate = LazyKt.lazy(new ChameleonOfflineResourceInterceptor$debugOfflinePath$2(this));
    }

    public static final /* synthetic */ Path access$getDebugOfflinePath(ChameleonOfflineResourceInterceptor r0, ChameleonConfig r1) {
        return r0.getDebugOfflinePath(r1);
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.res.IWebResourceInterceptor
    public WebResourceResponse shouldInterceptRequest(Uri r18, String r19, Map<String, String> r20) {
        boolean r6 = true;
        if (this.chameleonConfig.getResInterceptConfig() != null) goto L15;
        if (r18 == null) goto L10;
        String r3 = r18.toString();
        if (r3 == null) goto L10;
        if (StringsKt.startsWith$default(r3, DOC_SOURCE_PREFIX, false, 2, null) != true) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        Log.w(TAG, "resInterceptConfig is null");
        return null;
    L14:
        Unit r5 = Unit.INSTANCE;
    L10:
        r4 = false;
    L15:
        if (r18 != null) goto L95;
    L94:
        return null;
    L95:
        String r7 = r18.toString();     // Catch: Throwable -> L92
        if (r7 == null) goto L94;
        Log.i(TAG, "shouldInterceptRequest url " + ChameleonContainerUtils.INSTANCE.safeUrlString(r7));     // Catch: Throwable -> L92
        boolean r2 = TextUtils.equals(r7, this.chameleonConfig.getLoadUrl());     // Catch: Throwable -> L92
        String r10 = BuildConfig.FLAVOR;
        if (r2 == true) goto L42;
        PreloadConfig r8 = this.chameleonConfig.getPreloadConfig();     // Catch: Throwable -> L92
        if (r8 == null) goto L25;
        String r9 = r8.getTemplateUrl();     // Catch: Throwable -> L92
    L27:
        if (TextUtils.equals(r7, r9) == true) goto L42;
        if (StringsKt.startsWith$default(r7, DOC_SOURCE_PREFIX, false, 2, null) == false) goto L34;
        String r11 = r7.substring(12);     // Catch: Throwable -> L92
        if (StringsKt.startsWith$default(new PolarisFileWrapper(r11).getCanonicalPath(), ChameleonResUtils.INSTANCE.getWebcontainerRootDir(), false, 2, null) == false) goto L41;
        PolarisFileWrapper r12 = new PolarisFileWrapper(r11);     // Catch: Throwable -> L92
    L52:
        StringBuilder r13 = new StringBuilder("local res path = ");     // Catch: Throwable -> L92
        if (r12 == null) goto L55;
        String r0 = r12.getPath();     // Catch: Throwable -> L92
    L56:
        r13.append(r0);     // Catch: Throwable -> L92
        Log.i(TAG, r13.toString());     // Catch: Throwable -> L92
        if (r12 != null) goto L59;
    L90:
        Log.i(TAG, r12 + " do not exists or is directory");     // Catch: Throwable -> L92
        return null;
    L59:
        if ((!r12.exists()) == true) goto L90;
        if (r12.isDirectory() == true) goto L64;
        r6 = false;
    L64:
        if (r6 == true) goto L90;
        ByteArrayInputStream r1 = new PolarisFileInputStreamWrapper(r12);     // Catch: Throwable -> L92
        if (TextUtils.equals(r7, this.chameleonConfig.getLoadUrl()) == true) goto L76;
        PreloadConfig r14 = this.chameleonConfig.getPreloadConfig();     // Catch: Throwable -> L92
        if (r14 == null) goto L71;
        String r15 = r14.getTemplateUrl();     // Catch: Throwable -> L92
    L73:
        if (TextUtils.equals(r7, r15) == true) goto L76;
        ByteArrayInputStream r16 = r1;
    L88:
        HashMap r17 = new HashMap();     // Catch: Throwable -> L92
        r17.put("Access-Control-Allow-Origin", "*");     // Catch: Throwable -> L92
        r17.put("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");     // Catch: Throwable -> L92
        r17.put("Access-Control-Allow-Credentials", "true");     // Catch: Throwable -> L92
        r17.put("Access-Control-Allow-Headers", "accept, authorization, Content-Type");     // Catch: Throwable -> L92
        r17.put("_lkCacheFrom", "local");     // Catch: Throwable -> L92
        WebResourceResponse r21 = new WebResourceResponse(getMime(r7), Charset.defaultCharset().name(), 200, "OK", r17, r16);     // Catch: Throwable -> L92
        Log.i(TAG, "SPOfflineResRes hit local res url $" + ChameleonContainerUtils.INSTANCE.safeUrlString(r7));     // Catch: Throwable -> L92
        return r21;
    L71:
        r15 = null;
    L76:
        String r22 = replaceHtml(ChameleonResUtils.INSTANCE.convertString(r1));     // Catch: Throwable -> L92
        ResInterceptConfig r23 = this.chameleonConfig.getResInterceptConfig();     // Catch: Throwable -> L92
        if (r23 == null) goto L87;
        Map<String, String> r24 = r23.getGetBizTemplateVars();     // Catch: Throwable -> L92
        if (r24 == null) goto L87;
        Set<Map.Entry<String, String>> r25 = r24.entrySet();     // Catch: Throwable -> L92
        if (r25 == null) goto L87;
        Iterator<T> r26 = r25.iterator();     // Catch: Throwable -> L92
        String r110 = r22;
    L84:
        if (r26.hasNext() == false) goto L86;
        Map.Entry r27 = (Map.Entry) r26.next();     // Catch: Throwable -> L92
        r110 = StringsKt.replace$default(r110, (String) r27.getKey(), (String) r27.getValue(), false, 4, null);     // Catch: Throwable -> L92
        goto L84
    L86:
        r22 = r110;
    L87:
        r16 = new ByteArrayInputStream(r22.getBytes(Charset.forName(Charset.defaultCharset().name())));     // Catch: Throwable -> L92
        goto L88
    L55:
        r0 = null;
    L41:
        r12 = null;
        goto L52
    L34:
        String r28 = UriProtector.parse(r7).getPath();     // Catch: Throwable -> L92
        if (r28 == null) goto L38;
        r10 = r28;
    L38:
        String r29 = getPathFromUrl(r10);     // Catch: Throwable -> L92
        if (StringsKt.startsWith$default(new PolarisFileWrapper(this.resRootPath, r29).getCanonicalPath(), ChameleonResUtils.INSTANCE.getWebcontainerRootDir(), false, 2, null) == false) goto L41;
        r12 = new PolarisFileWrapper(this.resRootPath, r29);     // Catch: Throwable -> L92
        goto L52
    L25:
        r9 = null;
    L42:
        String r30 = getRootPath();     // Catch: Throwable -> L92
        if (r30 != null) goto L45;
        return null;
    L45:
        this.resRootPath = r30;     // Catch: Throwable -> L92
        String r31 = this.resRootPath;     // Catch: Throwable -> L92
        ResInterceptConfig r32 = this.chameleonConfig.getResInterceptConfig();     // Catch: Throwable -> L92
        if (r32 == null) goto L51;
        String r33 = r32.getRootHtml();     // Catch: Throwable -> L92
        if (r33 == null) goto L51;
        r10 = r33;
    L51:
        r12 = new PolarisFileWrapper(r31, r10);     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        Log.e(TAG, "intercept error!", th);
        goto L94
    }
}
