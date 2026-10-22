package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\rH\u0016R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/BaseTextContentList;", "T", "Ljava/io/Serializable;", "<init>", "()V", "paramDetails", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getParamDetails", "()Ljava/util/ArrayList;", "setParamDetails", "(Ljava/util/ArrayList;)V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class BaseTextContentList<T> implements Serializable {
    private String displayName;
    private ArrayList<T> paramDetails;

    public BaseTextContentList() {
        this.displayName = "";
    }

    public String toString() {
        ArrayList<T> r0 = getParamDetails();
        String r1 = "";
        if (r0 == null) goto L9;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        r1 = r1 + r2.next();
    L9:
        return "TextContentList(paramDetails=" + r1 + ", displayName=" + getDisplayName() + ')';
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ArrayList<T> getParamDetails() {
        return this.paramDetails;
    }

    public void setDisplayName(String r1) {
        this.displayName = r1;
    }

    public void setParamDetails(ArrayList<T> r1) {
        this.paramDetails = r1;
    }
}
