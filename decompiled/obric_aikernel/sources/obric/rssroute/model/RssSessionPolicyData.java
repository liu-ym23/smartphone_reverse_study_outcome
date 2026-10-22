package obric.rssroute.model;

/* JADX INFO: loaded from: classes3.dex */
public final class RssSessionPolicyData {
    public int affinity;
    public int fixFreq0;
    public int fixFreq6;
    public int latencyNice;
    public int nice;
    public int uclampMax;
    public int uclampMin;
    public int wakeupPrio;

    public RssSessionPolicyData() {
    }

    public RssSessionPolicyData(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        this.nice = r10;
        this.latencyNice = r11;
        this.uclampMin = r12;
        this.uclampMax = r13;
        this.affinity = r14;
        this.fixFreq0 = r15;
        this.fixFreq6 = r16;
        this.wakeupPrio = r17;
    }
}
