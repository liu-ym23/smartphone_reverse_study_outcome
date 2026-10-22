package com.zte.miboard.cards.travel.data;

import android.text.TextUtils;
import c.m;

/* JADX INFO: loaded from: classes3.dex */
public class MatchData extends TravelData {
    private String matchModifiedTitle;
    private String matchTeamA;
    private String matchTeamB;

    public MatchData() {
    }

    public String getMatchModifiedTitle() {
        if (TextUtils.isEmpty(this.matchModifiedTitle) == false) goto L7;
        return "";
    L7:
        return this.matchModifiedTitle;
    }

    public String getMatchTeamA() {
        if (TextUtils.isEmpty(this.matchTeamA) == false) goto L7;
        return "";
    L7:
        return this.matchTeamA;
    }

    public String getMatchTeamB() {
        if (TextUtils.isEmpty(this.matchTeamB) == false) goto L7;
        return "";
    L7:
        return this.matchTeamB;
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public String getShowToString() {
        return ", matchModifiedTitle=" + this.matchModifiedTitle + ", matchTeamA=" + this.matchTeamA + ", matchTeamB=" + this.matchTeamB;
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public boolean isAvailable() {
        boolean r5 = super.isAvailable();
        if (r5 == false) goto L8;
        boolean r10 = TextUtils.isEmpty(this.matchModifiedTitle);
        boolean r11 = !r10;
        if (r10 == false) goto L7;
        m.l(TravelData.TAG, "isAvailable false matchModifiedTitle error, matchModifiedTitle=" + this.matchModifiedTitle + " this=" + this);
    L7:
        r5 = r11;
    L8:
        if (r5 == true) goto L10;
    L17:
        return r5;
    L10:
        if (TextUtils.isEmpty(this.matchTeamA) == false) goto L12;
    L14:
        r5 = false;
    L15:
        if (r5 == true) goto L17;
        m.l(TravelData.TAG, "isAvailable false matchTeam error, matchTeamA=" + this.matchTeamA + " matchTeamB=" + this.matchTeamB + " this=" + this);
        goto L17
    L12:
        if (TextUtils.isEmpty(this.matchTeamB) == true) goto L14;
        r5 = true;
        goto L15
    }
}
