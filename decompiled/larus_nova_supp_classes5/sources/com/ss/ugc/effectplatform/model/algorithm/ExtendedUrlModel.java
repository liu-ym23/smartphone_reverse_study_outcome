package com.ss.ugc.effectplatform.model.algorithm;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import ilc.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B1\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "", "url_list", "", "", "uri", "zip_url_list", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getUrl_list", "()Ljava/util/List;", "setUrl_list", "(Ljava/util/List;)V", "getZip_url_list", "setZip_url_list", "getUrl", EffectConfiguration.KEY_TYPE, "Lcom/ss/ugc/effectplatform/model/algorithm/FetchModelType;", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class ExtendedUrlModel {
    private String uri;
    private List<String> url_list;
    private List<String> zip_url_list;

    public ExtendedUrlModel() {
        this(null, null, null, 7, null);
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrl_list() {
        return this.url_list;
    }

    public List<String> getZip_url_list() {
        return this.zip_url_list;
    }

    public final List<String> getUrl(FetchModelType r2) {
        int r3 = a.a[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L8;
        return getUrl_list();
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return getZip_url_list();
    }

    public void setUri(String r1) {
        this.uri = r1;
    }

    public void setUrl_list(List<String> r1) {
        this.url_list = r1;
    }

    public void setZip_url_list(List<String> r1) {
        this.zip_url_list = r1;
    }

    public ExtendedUrlModel(List<String> r1, String r2, List<String> r3) {
        this.url_list = r1;
        this.uri = r2;
        this.zip_url_list = r3;
    }

    public /* synthetic */ ExtendedUrlModel(List r1, String r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = new ArrayList();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = new ArrayList();
    L11:
        this(r1, r2, r3);
    }
}
