package com.ss.android.lark.officesdk.integrator.mock;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.ai.translate.service.ITranslateService;
import java.util.Map;
import oua.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(ITranslateService.class)
public class TranslateServiceMock implements ITranslateService {
    private static final String TAG = "OfficeSdkMock";

    public TranslateServiceMock() {
    }

    public Dialog showHyperTranslateDialog(Context r1, String r2, String r3, String r4, String r5, String r6, String r7, ITranslateService.HyperTranslateScene r8, b r9) {
        return null;
    }

    public void showHyperTranslateDialog(Context r1, String r2, ITranslateService.HyperTranslateScene r3, b r4) {
    }

    public Dialog showTranslateFeedbackDialog(Context r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, ITranslateService.TranslateFeedbackScene r9, b r10) {
        return null;
    }

    public Dialog showTranslateFeedbackDialog(Context r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, ITranslateService.TranslateFeedbackScene r9, b r10, Map<String, String> r11) {
        return null;
    }
}
