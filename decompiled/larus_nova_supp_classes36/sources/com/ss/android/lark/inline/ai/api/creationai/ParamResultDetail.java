package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B;\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/ParamResultDetail;", "Ljava/io/Serializable;", TabAppInfo.IMAGE_JSON_KEY, "", "name", "placeHolder", "content", "originContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getName", "setName", "getPlaceHolder", "setPlaceHolder", "getContent", "setContent", "getOriginContent", "setOriginContent", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ParamResultDetail implements Serializable {
    private String content;
    private String key;
    private String name;
    private String originContent;
    private String placeHolder;

    public String toString() {
        return "ParamResultDetail(key=" + this.key + ", name=" + this.name + ", content=" + this.content + ", originContent=" + this.originContent + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginContent() {
        return this.originContent;
    }

    public final String getPlaceHolder() {
        return this.placeHolder;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setKey(String r1) {
        this.key = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setOriginContent(String r1) {
        this.originContent = r1;
    }

    public final void setPlaceHolder(String r1) {
        this.placeHolder = r1;
    }

    public ParamResultDetail(String r1, String r2, String r3, String r4, String r5) {
        this.key = r1;
        this.name = r2;
        this.placeHolder = r3;
        this.content = r4;
        this.originContent = r5;
    }
}
