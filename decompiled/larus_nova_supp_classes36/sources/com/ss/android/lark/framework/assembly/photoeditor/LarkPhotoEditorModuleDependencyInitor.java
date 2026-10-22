package com.ss.android.lark.framework.assembly.photoeditor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.utils.DownloadAuthorizationEventType;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.framework.assembly.photoeditor.forward.PhotoEditorForward;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.watermark.userscope.c;
import com.ss.lark.android.encryption.CipherManager;
import java.util.Objects;
import q0c.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(b.class)
public class LarkPhotoEditorModuleDependencyInitor implements b {

    public class a implements b.a {
        public a() {
        }
    }

    public LarkPhotoEditorModuleDependencyInitor() {
    }

    public b.a getGuideDependency() {
        return new a();
    }

    public boolean isCipherStatusOn() {
        if (CipherManager.d() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isAuthorizationPassed(ValidateResult r2) {
        return owa.a.c().isAuthorizationPassed(r2);
    }

    public boolean isFeatureGatingEnable(String r3) {
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r3, false);
    }

    public String getWatermarkResource(String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return r3;
    L5:
        c r0 = (c) LarkContext.spiByDwarf(c.class);
        Objects.requireNonNull(r0);
        return r0.cd(r2, r3);
    }

    public void goImageForwardSelectPage(Context r1, String r2, int r3) {
        PhotoEditorForward.a(r1, r2, r3);
    }

    public void checkImageDownloadAuthorizationAndShowWarningOnFailed(String r12, String r13, String r14, Context r15, Integer r16, AuthorizationServiceV2.b r17) {
        owa.a.c().g(DownloadAuthorizationEventType.IMAGE_DOWNLOAD, r12, r12, r13, r14, null, null, r15, r16, r17);
    }
}
