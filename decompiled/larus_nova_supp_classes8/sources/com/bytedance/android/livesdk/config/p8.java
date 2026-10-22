package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/p8;", "", "", "dialogContentTemplate", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setDialogContentTemplate", "(Ljava/lang/String;)V", "followDouyinToastContentTemplate", "b", "setFollowDouyinToastContentTemplate", "followHostFailedToastContentTemplate", "c", "setFollowHostFailedToastContentTemplate", "xtSyncFollowSuccessToast", "d", "setXtSyncFollowSuccessToast", "xtSyncUnFollowDialogContent", "e", "setXtSyncUnFollowDialogContent", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p8 {

    @SerializedName("dialog_content_template")
    private String dialogContentTemplate;

    @SerializedName("saas_sync_follow_success")
    private String followDouyinToastContentTemplate;

    @SerializedName("saas_sync_follow_failed")
    private String followHostFailedToastContentTemplate;

    @SerializedName("xt_sync_follow_success_toast")
    private String xtSyncFollowSuccessToast;

    @SerializedName("xt_sync_unfollow_dialog_content")
    private String xtSyncUnFollowDialogContent;

    public p8() {
        this.dialogContentTemplate = "该主播在抖音和{host}同时活跃，你可以授权我们使用你在{host}所登录账号，在{host}关注TA，以帮助你更便利的与TA互动。";
        this.followDouyinToastContentTemplate = "抖音账号{userName}关注主播抖音账号成功。";
        this.followHostFailedToastContentTemplate = "因未将跟{host}同步关注关系，未能为你在{host}关注该主播。";
        this.xtSyncFollowSuccessToast = "已关注该主播的{host}和抖音账号";
        this.xtSyncUnFollowDialogContent = "确认不再关注主播的{host}和抖音账号？";
    }

    public final String a() {
        return this.dialogContentTemplate;
    }

    public final String b() {
        return this.followDouyinToastContentTemplate;
    }

    public final String c() {
        return this.followHostFailedToastContentTemplate;
    }

    public final String d() {
        return this.xtSyncFollowSuccessToast;
    }

    public final String e() {
        return this.xtSyncUnFollowDialogContent;
    }
}
