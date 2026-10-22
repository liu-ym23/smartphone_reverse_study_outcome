package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0006\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/h;", "", "<init>", "()V", "", "", "a", "[Ljava/lang/String;", "b", "()[Ljava/lang/String;", "setWhiteList", "([Ljava/lang/String;)V", "whiteList", "", "", "Ljava/util/List;", "()Ljava/util/List;", "setForceDegradeCodeList", "(Ljava/util/List;)V", "forceDegradeCodeList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("white_list")
    private String[] f5207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("degrade_verify_code_list")
    private List<Integer> f5208b;

    public h() {
        this.f5208b = CollectionsKt.emptyList();
    }

    public final List a() {
        return this.f5208b;
    }

    public final String[] b() {
        return this.f5207a;
    }
}
