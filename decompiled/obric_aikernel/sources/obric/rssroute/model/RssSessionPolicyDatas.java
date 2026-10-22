package obric.rssroute.model;

/* JADX INFO: loaded from: classes3.dex */
public final class RssSessionPolicyDatas {
    public int featFlags;
    public RssSessionPolicyData[] policies;

    public RssSessionPolicyDatas() {
        this.policies = new RssSessionPolicyData[4];
        int r10 = 0;
    L3:
        if (r10 >= 4) goto L5;
        this.policies[r10] = new RssSessionPolicyData();
        r10 = r10 + 1;
        goto L3
    }

    public RssSessionPolicyDatas(int r10, RssSessionPolicyData[] r11) {
        this.featFlags = r10;
        if (r11 == null) goto L9;
        if (r11.length != 4) goto L9;
        this.policies = r11;
        return;
    L9:
        throw new IllegalArgumentException("policies must be an array of 4 elements");
    }
}
