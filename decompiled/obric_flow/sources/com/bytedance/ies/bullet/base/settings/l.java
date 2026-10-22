package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/l;", "", "<init>", "()V", "", "a", "Z", "getEnableBuiltinSecLink", "()Z", "setEnableBuiltinSecLink", "(Z)V", "enableBuiltinSecLink", "b", "getEnableSecLink", "setEnableSecLink", "enableSecLink", "", "", "c", "Ljava/util/List;", "getDomainWhiteList", "()Ljava/util/List;", "setDomainWhiteList", "(Ljava/util/List;)V", "domainWhiteList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enable_builtin_sec_link")
    private boolean f5216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("enable_sec_link")
    private boolean f5217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("domain_white_list")
    private List<String> f5218c;

    public l() {
        this.f5217b = true;
        this.f5218c = CollectionsKt.emptyList();
    }
}
