package com.ss.android.lark.framework.assembly.emoji_office;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.image.impl.preload.ImagePreloadManager;
import com.ss.android.lark.image.impl.preload.PreloadResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.light.image.h;
import java.util.Locale;
import xbc.a;
import yob.e;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(a.a.class)
public class EmojiModuleDependencyInitor implements a.a {
    public static final String FG_AT_PROCESS_V2 = "messener.richtext.at_tag_process_v2";
    private static final String LOG_TAG = "EmojiModuleDependencyInitor";

    public EmojiModuleDependencyInitor() {
    }

    public boolean isUseImageMemoryCache() {
        return true;
    }

    public String getCurrentTenantId() {
        b r0 = (b) LarkContext.spiByDwarf(b.class);
        if (r0 != null) goto L5;
        return "";
    L5:
        User r1 = r0.getForegroundUser();
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getTenantId();
    }

    public String getCurrentUserId() {
        b r0 = (b) LarkContext.spiByDwarf(b.class);
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.d();
    }

    public Locale getCachedLocale() {
        e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        return com.ss.android.lark.language.service.impl.a.b.a.getCacheLanguageSetting();
    }

    public Long getNtpTime() {
        return Long.valueOf(ImSdkProxy.b().a());
    }

    public boolean isUseAtProcessV2() {
        return FeatureGatingModule.getFeatureGatingService().isEnable(FG_AT_PROCESS_V2);
    }

    public Long getMessageCreateTimeById(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        Log.i(LOG_TAG, "message id is empty");
        return null;
    L6:
        Message r4 = ImSdkService.f().za(r3);
        if (r4 != null) goto L9;
        return null;
    L9:
        return Long.valueOf(r4.getCreateTime());
    }

    public h getPreloadBean(String r4) {
        PreloadResult r5 = ImagePreloadManager.getResult(r4);
        if (r5 != null) goto L5;
        return null;
    L5:
        return new h(r5.getState().getValue(), r5.getPreloadingDuration(), r5.getScene());
    }

    public boolean isMessageDelete(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        Log.i(LOG_TAG, "message id is empty");
        return false;
    L6:
        Message r5 = ImSdkService.f().za(r4);
        if (r5 != null) goto L9;
        Log.i(LOG_TAG, "message is not found");
        return true;
    L9:
        if (r5.isRecalled() == false) goto L11;
    L12:
        return true;
    L11:
        if (r5.isRemoved() == true) goto L12;
        return false;
    }

    public boolean isMessageNoTraceDelete(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        Log.i(LOG_TAG, "message id is empty");
        return false;
    L6:
        Message r4 = ImSdkService.f().za(r3);
        if (r4 != null) goto L9;
        Log.i(LOG_TAG, "message is not found");
        return true;
    L9:
        return r4.isNoTraceDelete();
    }

    public boolean isReportImageLoad(int r2, int r3) {
        return ((com.ss.android.lark.image.a) ApiUtils.getApi(com.ss.android.lark.image.a.class)).isReportImageLoad(r2, r3);
    }

    public void showPreviewDialogOnAuthorizationFailed(Context r11, ValidateResult r12, int r13) {
        AuthorizationServiceV2 r0 = owa.a.c();
        r0.b(r11, r12, Integer.valueOf(r13), null, null, 2131891417, r0.e(), false, null);
    }
}
