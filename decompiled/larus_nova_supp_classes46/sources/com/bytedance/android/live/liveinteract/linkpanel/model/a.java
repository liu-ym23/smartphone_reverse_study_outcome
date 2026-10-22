package com.bytedance.android.live.liveinteract.linkpanel.model;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/model/a;", "", "", "Lcom/bytedance/android/live/liveinteract/linkpanel/model/ActiveUser;", "user", "Ljava/util/List;", "b", "()Ljava/util/List;", "setUser", "(Ljava/util/List;)V", "", "notice", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setNotice", "(Ljava/lang/String;)V", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements h {

    @SerializedName("notice")
    protected String notice;

    @SerializedName("user")
    protected List<ActiveUser> user;

    public a() {
    }

    public a(g r5) {
        this.user = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.user.add(new ActiveUser(r5));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.notice = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }

    public final String a() {
        return this.notice;
    }

    public final List<ActiveUser> b() {
        return this.user;
    }
}
