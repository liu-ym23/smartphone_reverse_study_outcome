package obric.rssroute.model;

/* JADX INFO: loaded from: classes3.dex */
public final class RssSessionInferenceData {
    public int energyTendency;
    public String modelStage;
    public int refinedNpuPowerGear;
    public int sceneIndex;
    public int sessionId;
    public int targetNpuPowerGear;

    public RssSessionInferenceData() {
    }

    public RssSessionInferenceData(int r10, String r11, int r12, int r13, int r14, int r15) {
        this.sessionId = r10;
        this.modelStage = r11;
        this.energyTendency = r12;
        this.sceneIndex = r13;
        this.targetNpuPowerGear = r14;
        this.refinedNpuPowerGear = r15;
    }
}
