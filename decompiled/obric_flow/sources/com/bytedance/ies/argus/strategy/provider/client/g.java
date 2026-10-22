package com.bytedance.ies.argus.strategy.provider.client;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0000\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0014\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/g;", "Lfj/a;", "", "", "c", "Ljava/util/List;", "getWhiteParentDomainList", "()Ljava/util/List;", "whiteParentDomainList", "d", "getWhiteWholeDomainList", "whiteWholeDomainList", "e", "getWhiteUrlRegList", "whiteUrlRegList", "f", "getExcludeWhiteUrlRegList", "excludeWhiteUrlRegList", "g", "redirectBlackProtocol", "h", "redirectBlackUrlReg", "i", "a", "blackUrlReg", "j", "Ljava/lang/String;", "()Ljava/lang/String;", "riskInfoPage", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class g extends fj.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("white_parent_domain")
    private final List<String> f5163c;

    @SerializedName("white_whole_domain")
    private final List<String> d;

    @SerializedName("white_url_reg")
    private final List<String> e;

    @SerializedName("exclude_white_url_reg")
    private final List<String> f;

    @SerializedName("redirect_black_protocol")
    private final List<String> g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("redirect_black_url_reg")
    private final List<String> f5164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SerializedName("black_url_reg")
    private final List<String> f5165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SerializedName("risk_info_page")
    private final String f5166j;

    public g() {
        this.f5163c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.f5164h = null;
        this.f5165i = null;
        this.f5166j = null;
    }

    public final String h() {
        return this.f5166j;
    }
}
