package com.ss.android.lark.contact.customized.common.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "im_contact")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/contact/customized/common/model/ImContactSettingConfig;", BuildConfig.FLAVOR, "<init>", "()V", "fullSyncTtl", BuildConfig.FLAVOR, "getFullSyncTtl", "()J", "setFullSyncTtl", "(J)V", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImContactSettingConfig {

    @SerializedName("full_sync_ttl")
    private long fullSyncTtl;

    public static final class a {
    }

    static {
    }

    public ImContactSettingConfig() {
        this.fullSyncTtl = 259200000;
    }

    public final long a() {
        return this.fullSyncTtl;
    }
}
