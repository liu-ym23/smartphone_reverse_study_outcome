package com.ss.android.lark.core.keyboard;

import android.content.Context;
import android.text.Annotation;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.d;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@ClaymoreImpl(d.class)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0016J.\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0016J.\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\rH\u0002J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010\u0012\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J$\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\u0007H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020#H\u0016J\f\u0010(\u001a\u00020\u0007*\u00020\u0007H\u0002¨\u0006*"}, d2 = {"Lcom/ss/android/lark/core/keyboard/KeyboardBaseModuleDependencyImpl;", "Lcom/ss/android/lark/KeyboardBaseModuleDependency;", "<init>", "()V", "isFeatureGatingEnable", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "isFeatureGatingCurrentEnable", "getDocFromContent", BuildConfig.FLAVOR, "content", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/keyboard/dtocompat/DocResult;", "getUrlInlineFromContent", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;", "getTempPreviewFromContent", "url", Keys.API_RETURN_KEY_APP_ID, BuildConfig.FLAVOR, IPortraitService.TYPE, "getTempPreview", "callbackWrapper", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "getCallbackWrapper", "getColorByThemeColor", BuildConfig.FLAVOR, "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "openUrl", "context", "Landroid/content/Context;", "scene", "decodeAndGetRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "span", "Landroid/text/Annotation;", "encodePbRichText", "richText", "trimUrl", "Companion", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardBaseModuleDependencyImpl implements d {
    public static final a Companion = null;
    private static final String TAG = "KeyboardBaseModuleDependencyImpl";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public KeyboardBaseModuleDependencyImpl() {
    }

    public void getDocFromContent(String r2, IGetDataCallback<Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    public void openUrl(Context r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
    }

    private final int getColorByThemeColor(ThemeColor r3) {
        if (r3 != null) goto L6;
        return 0;
    L6:
        return com.ss.android.lark.export.entity.preview.a.a(r3, UIHelper.getContext(), null);
    }

    private final String trimUrl(String r6) {
        int r1 = 0;
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r6;
    L8:
        int r2 = r6.length() - 1;
    L10:
        if (r1 >= r6.length()) goto L14;
        if (r6.charAt(r1) != ' ') goto L14;
        r1 = r1 + 1;
    L14:
        if (r2 < 0) goto L19;
        if (r6.charAt(r2) != '\n') goto L19;
        r2 = r2 - 1;
    L19:
        return r6.substring(r1, r2 + 1);
    L5:
        r0 = false;
        goto L6
    }

    public RichText decodeAndGetRichText(Annotation r4) {
        Intrinsics.checkNotNullParameter(r4, "span");
        ByteString.a r1 = ByteString.Companion;     // Catch: Exception -> L11
        String r5 = r4.getValue();     // Catch: Exception -> L11
        r1.getClass();     // Catch: Exception -> L11
        ByteString r6 = ByteString.a.a(r5);     // Catch: Exception -> L11
        if (r6 != null) goto L6;
        return null;
    L6:
        com.bytedance.lark.pb.basic.v1.RichText r7 = (com.bytedance.lark.pb.basic.v1.RichText) com.bytedance.lark.pb.basic.v1.RichText.ADAPTER.decode(r6);     // Catch: Exception -> L11
        if (r7 != null) goto L9;
        return null;
    L9:
        return g0.e(r7, null);
    L11:
        e = move-exception;
        Log.e(TAG, "decodeAndGetRichText: decode error: " + ExceptionsKt.stackTraceToString(e));
        return null;
    }

    public String encodePbRichText(RichText r3) {
        Intrinsics.checkNotNullParameter(r3, "richText");
        com.bytedance.lark.pb.basic.v1.RichText r4 = g0.d(r3);
        if (r4 != null) goto L11;
        return null;
    L11:
        byte[] r5 = r4.encode();     // Catch: Exception -> L8
        ByteString.a r0 = ByteString.Companion;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L8
        return ByteString.a.e(r0, r5).base64();
    L8:
        e = move-exception;
        Log.e(TAG, "encodePbRichText: encode error: " + ExceptionsKt.stackTraceToString(e));
        return BuildConfig.FLAVOR;
    }

    public boolean isFeatureGatingCurrentEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r2);
    }

    public boolean isFeatureGatingEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }

    public static final /* synthetic */ int access$getColorByThemeColor(KeyboardBaseModuleDependencyImpl r0, ThemeColor r1) {
        return r0.getColorByThemeColor(r1);
    }

    private final IGetDataCallback<UrlInlinePreviewEntity> getCallbackWrapper(final String r2, final IGetDataCallback<com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity> r3) {
        return new AnonymousClass1(r3, this, r2);
    }

    public void getUrlInlineFromContent(String r2, IGetDataCallback<com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity> r3) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "callback");
        String r4 = trimUrl(r2);
        IGetDataCallback<UrlInlinePreviewEntity> r5 = getCallbackWrapper(r4, r3);
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).getUrlInlineFromContent(r4, r5);
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.ss.android.lark.core.keyboard.KeyboardBaseModuleDependencyImpl$getTempPreview$1] */
    private final void getTempPreview(String r9, long r10, long r12, final IGetDataCallback<UrlInlinePreviewEntity> r14) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).chatPreviewApi().b(r9, r10, r12, new C04431(r14));
    }

    public void getTempPreviewFromContent(String r9, long r10, long r12, IGetDataCallback<com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity> r14) {
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r14, "callback");
        String r2 = trimUrl(r9);
        getTempPreview(r2, r10, r12, getCallbackWrapper(r2, r14));
    }
}
