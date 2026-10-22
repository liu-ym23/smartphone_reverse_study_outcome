package com.zte.miboard.recommend.agent.data;

/* JADX INFO: loaded from: classes3.dex */
public class MatchData extends TravelData {
    private static final String MIGU_PACKAGENAME = "com.cmcc.cmvideo";
    public String matchModifiedTitle;
    public String matchTeamA;
    public String matchTeamB;

    public static class Builder extends TravelData.Builder<Builder> {
        String matchModifiedTitle;
        String matchTeamA;
        String matchTeamB;

        public Builder() {
        }

        @Override // com.zte.miboard.recommend.agent.data.TravelData.Builder
        public /* bridge */ /* synthetic */ TravelData build() {
            return build();
        }

        @Override // com.zte.miboard.recommend.agent.data.TravelData.Builder
        public Builder self() {
            return this;
        }

        public Builder setFatherMembers(String r10, String r11, String r12, String r13, String r14, String r15) {
            super.setMembers(r10, r11, r12, r13, r14, MatchData.MIGU_PACKAGENAME, r15);
            return this;
        }

        public Builder setmembers(String r5, String r10, String r11) {
            this.matchModifiedTitle = r5;
            this.matchTeamA = r10;
            this.matchTeamB = r11;
            return this;
        }

        @Override // com.zte.miboard.recommend.agent.data.TravelData.Builder
        public MatchData build() {
            return new MatchData(this);
        }

        @Override // com.zte.miboard.recommend.agent.data.TravelData.Builder
        public /* bridge */ /* synthetic */ TravelData.Builder self() {
            return self();
        }
    }

    public MatchData(Builder r5) {
        super(r5);
        this.matchModifiedTitle = r5.matchModifiedTitle;
        this.matchTeamA = r5.matchTeamA;
        this.matchTeamB = r5.matchTeamB;
    }
}
