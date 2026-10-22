package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/k;", "", "<init>", "()V", "", "a", "Z", "()Z", "setEnableUploadLynxSignFailedFile", "(Z)V", "enableUploadLynxSignFailedFile", "", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "setUploadLynxVerifyCodeList", "(Ljava/util/List;)V", "uploadLynxVerifyCodeList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enable_upload_lynx_sign_failed_file")
    private boolean f5214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("upload_lynx_verify_code")
    private List<Integer> f5215b;

    public k() {
        this.f5215b = CollectionsKt.listOf(new Integer[]{-1, 104});
    }
}
