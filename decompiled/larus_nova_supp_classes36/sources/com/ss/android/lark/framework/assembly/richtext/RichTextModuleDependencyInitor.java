package com.ss.android.lark.framework.assembly.richtext;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.entity.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.a;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import xbc.d;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(d.a.class)
public class RichTextModuleDependencyInitor implements d.a {
    private static final String FEATURE_KEY_ENABLE_RICHTEXT_MARKDOWN_TAG = "lark.chat.richtext.markdown.tag";
    public static final String FEATURE_KEY_PARTIAL_REPLY = "im.messenger.part_reply";
    private static final a KV_STORAGE_DOMAIN = null;
    private static final String LOG_TAG = "RichText";
    private static final String PARAMS_CODE_BLOCK_V2_WORD_WRAP = "params_code_block_v2_word_wrap";
    private Boolean mIsEnableMarkDownTag;

    public RichTextModuleDependencyInitor() {
    }

    public boolean isTextSelectable() {
        return false;
    }

    public boolean isUseLightTextView() {
        return true;
    }

    static {
        KV_STORAGE_DOMAIN = new a("Common");
    }

    public boolean getCodeBlockWordWrapSetting() {
        return LarkKVStorage.q(KV_STORAGE_DOMAIN, false).getBoolean(PARAMS_CODE_BLOCK_V2_WORD_WRAP, false);
    }

    public String getUserId() {
        b r0 = (b) LarkContext.spiByDwarf(b.class);
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.d();
    }

    public boolean isEnableMarkDownTag() {
        if (this.mIsEnableMarkDownTag != null) goto L6;
        this.mIsEnableMarkDownTag = Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable(FEATURE_KEY_ENABLE_RICHTEXT_MARKDOWN_TAG));
        Log.i(LOG_TAG, "isEnableMarkDownTag:" + this.mIsEnableMarkDownTag);
    L6:
        return this.mIsEnableMarkDownTag.booleanValue();
    }

    public boolean isPartialReplyEnable() {
        boolean r0 = isFeatureGatingEnable(FEATURE_KEY_PARTIAL_REPLY);
        Log.i(LOG_TAG, "fg:im.messenger.part_reply is: " + r0);
        return r0;
    }

    public boolean isFeatureGatingEnable(String r2) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }

    public String readScrollProcessSetting(String r3) {
        return LarkKVStorage.q(KV_STORAGE_DOMAIN, false).getString(r3, null);
    }

    public void saveCodeBlockWordWrapSetting(boolean r3) {
        LarkKVStorage.q(KV_STORAGE_DOMAIN, false).putBoolean(PARAMS_CODE_BLOCK_V2_WORD_WRAP, r3);
    }

    public c findImageCache(ArrayList<com.ss.android.lark.image.entity.b> r3, String r4) {
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).findImageCache("post_message", r3, r4);
    }

    public void saveScrollProcessSetting(String r3, String r4) {
        LarkKVStorage.q(KV_STORAGE_DOMAIN, false).putString(r3, r4);
    }
}
