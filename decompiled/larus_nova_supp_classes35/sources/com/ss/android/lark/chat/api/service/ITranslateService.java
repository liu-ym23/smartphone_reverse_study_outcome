package com.ss.android.lark.chat.api.service;

import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.TranslateUrlPreviewContext;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import java.util.List;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface ITranslateService {

    public static final enum TranslateTriggerType extends Enum<TranslateTriggerType> {
        public static final TranslateTriggerType AUTO = null;
        public static final TranslateTriggerType MANUAL = null;
        public static final TranslateTriggerType SWITCH_LANGUAGE = null;
        public static final /* synthetic */ TranslateTriggerType[] a = null;

        static {
            TranslateTriggerType r0 = new TranslateTriggerType("MANUAL", 0);
            MANUAL = r0;
            TranslateTriggerType r1 = new TranslateTriggerType("AUTO", 1);
            AUTO = r1;
            TranslateTriggerType r3 = new TranslateTriggerType("SWITCH_LANGUAGE", 2);
            SWITCH_LANGUAGE = r3;
            a = new TranslateTriggerType[]{r0, r1, r3};
        }

        public static TranslateTriggerType[] values() {
            return (TranslateTriggerType[]) a.clone();
        }

        public static TranslateTriggerType valueOf(String r1) {
            return (TranslateTriggerType) a.a(TranslateTriggerType.class, r1);
        }

        public TranslateTriggerType(String r1, int r2) {
            super(r1, r2);
        }
    }

    void L4(String r1, IGetDataCallback<Boolean> r2);

    void W4(boolean r1, Map<String, TranslateUrlPreviewContext> r2, Map<String, Map<String, PreviewHangPoint>> r3, IGetDataCallback<Map<String, Map<String, PreviewHangPoint>>> r4);

    void cb(boolean r1, IGetDataCallback<Boolean> r2);

    void getTranslateLanguages(IGetDataCallback<TranslateLanguageSetting> r1);

    void jf(List<String> r1, TranslateTriggerType r2, String r3, List<MessageSource> r4, String r5, Map<String, Integer> r6, boolean r7, IGetDataCallback<fcb.a> r8);

    void s9(SyncDataStrategy r1, IGetDataCallback<TranslateLanguageSetting> r2);
}
