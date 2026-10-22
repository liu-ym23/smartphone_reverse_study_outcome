package com.bytedance.android.live.liveinteract.revenue.starwish.net;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/starwish/net/b;", "", "", "defaultTargetScore", "J", "b", "()J", "setDefaultTargetScore", "(J)V", "", "targetList", "Ljava/util/List;", "getTargetList", "()Ljava/util/List;", "setTargetList", "(Ljava/util/List;)V", "", "disableTargetScoreList", "Z", "getDisableTargetScoreList", "()Z", "setDisableTargetScoreList", "(Z)V", "anchorInvolved", "a", "setAnchorInvolved", "disableAnchorInvolved", "getDisableAnchorInvolved", "setDisableAnchorInvolved", "isOpened", "c", "setOpened", "", "dressId", "Ljava/lang/String;", "getDressId", "()Ljava/lang/String;", "setDressId", "(Ljava/lang/String;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b implements h {

    @SerializedName("anchor_involved")
    protected boolean anchorInvolved;

    @SerializedName("default_target_score")
    protected long defaultTargetScore;

    @SerializedName("disable_anchor_involved")
    protected boolean disableAnchorInvolved;

    @SerializedName("disable_target_score_list")
    protected boolean disableTargetScoreList;

    @SerializedName("dress_id")
    protected String dressId;

    @SerializedName("once_opened")
    protected boolean isOpened;

    @SerializedName("target_score_list")
    protected List<Long> targetList;

    public b() {
        this.defaultTargetScore = 100;
        this.targetList = new ArrayList();
        this.dressId = "";
    }

    public final boolean a() {
        return this.anchorInvolved;
    }

    public final long b() {
        return this.defaultTargetScore;
    }

    public final boolean c() {
        return this.isOpened;
    }

    public b(g r7) {
        this.targetList = new ArrayList();
        long r0 = r7.c();
        boolean r2 = false;
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L16;
        if (r3 != 9) goto L7;
        this.dressId = am3.h.c(r7);
        goto L3
    L7:
        switch(r3) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        this.isOpened = am3.h.a(r7);
        goto L3
    L10:
        this.disableAnchorInvolved = am3.h.a(r7);
        goto L3
    L11:
        this.anchorInvolved = am3.h.a(r7);
        goto L3
    L12:
        this.disableTargetScoreList = am3.h.a(r7);
        goto L3
    L13:
        this.targetList.add(Long.valueOf(r7.j()));
        goto L3
    L14:
        this.defaultTargetScore = r7.j();
        r2 = r2 | true;
        goto L3
    L8:
        am3.h.e(r7);
        goto L3
    L16:
        r7.d(r0);
        if ((r2 & true) == true) goto L20;
        this.defaultTargetScore = 100;
    L20:
        if (this.targetList.isEmpty() == false) goto L23;
        this.targetList = new ArrayList();
    L23:
        if (this.dressId != null) goto L45;
        this.dressId = "";
        return;
    }
}
