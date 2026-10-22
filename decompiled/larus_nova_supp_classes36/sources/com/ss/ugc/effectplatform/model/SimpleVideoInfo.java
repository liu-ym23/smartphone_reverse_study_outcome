package com.ss.ugc.effectplatform.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;", "", "cover_url_list", "", "", "id", "group_id", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class SimpleVideoInfo {
    public List<String> cover_url_list;
    public String group_id;
    public String id;

    public SimpleVideoInfo() {
        this(null, null, null, 7, null);
    }

    public String toString() {
        return "SimpleVideoInfo(cover_url_list=" + this.cover_url_list + ", id=" + this.id + ", group_id=" + this.group_id + ')';
    }

    public SimpleVideoInfo(List<String> r1, String r2, String r3) {
        this.cover_url_list = r1;
        this.id = r2;
        this.group_id = r3;
    }

    public /* synthetic */ SimpleVideoInfo(List r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
