package com.larus.collection.impl.view;

import com.larus.collection.impl.bean.CollectionListScene;
import com.larus.profile.api.bean.LandingTab;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B+\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/collection/impl/view/RevisitListTab;", "", "scene", "", "landingTab", "Lcom/larus/profile/api/bean/LandingTab;", "trackTabName", "", "isLikeTab", "", "<init>", "(Ljava/lang/String;IILcom/larus/profile/api/bean/LandingTab;Ljava/lang/String;Z)V", "getScene", "()I", "getLandingTab", "()Lcom/larus/profile/api/bean/LandingTab;", "getTrackTabName", "()Ljava/lang/String;", "()Z", "Collection", "Like", "LikeWithHistory", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RevisitListTab extends Enum<RevisitListTab> {
    public static final RevisitListTab Collection = null;
    public static final RevisitListTab Like = null;
    public static final RevisitListTab LikeWithHistory = null;
    public static final /* synthetic */ RevisitListTab[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean isLikeTab;
    private final LandingTab landingTab;
    private final int scene;
    private final String trackTabName;

    public static EnumEntries<RevisitListTab> getEntries() {
        return b;
    }

    static {
        RevisitListTab r7 = new RevisitListTab("Collection", 0, 1, LandingTab.MY_COLLECT, "collection", false);
        Collection = r7;
        LandingTab r16 = LandingTab.MY_LIKE;
        RevisitListTab r0 = new RevisitListTab("Like", 1, 2, r16, "like", true);
        Like = r0;
        RevisitListTab r1 = new RevisitListTab("LikeWithHistory", 2, 3, r16, "like", true);
        LikeWithHistory = r1;
        RevisitListTab[] r2 = {r7, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static RevisitListTab[] values() {
        return (RevisitListTab[]) a.clone();
    }

    public final LandingTab getLandingTab() {
        return this.landingTab;
    }

    public final int getScene() {
        return this.scene;
    }

    public final String getTrackTabName() {
        return this.trackTabName;
    }

    public final boolean isLikeTab() {
        return this.isLikeTab;
    }

    public static RevisitListTab valueOf(String r1) {
        return (RevisitListTab) r27.a.a(RevisitListTab.class, r1);
    }

    public RevisitListTab(@CollectionListScene String r1, int r2, int r3, LandingTab r4, String r5, boolean r6) {
        super(r1, r2);
        this.scene = r3;
        this.landingTab = r4;
        this.trackTabName = r5;
        this.isLikeTab = r6;
    }
}
