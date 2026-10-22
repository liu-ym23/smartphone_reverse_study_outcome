package com.ss.android.lark.contact.entity;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.entity.mobile.LeaderType;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DepartmentLeader implements Serializable {
    private Chatter leader;
    private long leaderId;
    private LeaderType leaderType;

    public DepartmentLeader() {
    }

    public Chatter getLeader() {
        return this.leader;
    }

    public long getLeaderId() {
        return this.leaderId;
    }

    public LeaderType getLeaderType() {
        return this.leaderType;
    }

    public void setLeader(Chatter r1) {
        this.leader = r1;
    }

    public void setLeaderId(long r1) {
        this.leaderId = r1;
    }

    public void setLeaderType(LeaderType r1) {
        this.leaderType = r1;
    }
}
