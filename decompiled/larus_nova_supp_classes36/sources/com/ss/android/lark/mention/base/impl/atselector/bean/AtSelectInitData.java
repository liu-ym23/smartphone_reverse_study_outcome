package com.ss.android.lark.mention.base.impl.atselector.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AtSelectInitData implements Serializable {
    private String appId;
    private String channelId;
    private ArrayList<String> chatIds;
    private ArrayList<String> chatterIds;
    private String configJson;
    private boolean enableAIKnowledge;
    private boolean enableDoubaoMention;
    private boolean enableMyAI;
    private boolean isUserCountVisible;
    private boolean mIsInterruptAtAll;

    public String getAppId() {
        return this.appId;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public ArrayList<String> getChatIds() {
        return this.chatIds;
    }

    public ArrayList<String> getChatterIds() {
        return this.chatterIds;
    }

    public String getConfigJson() {
        return this.configJson;
    }

    public boolean getIsInterruptAtAll() {
        return this.mIsInterruptAtAll;
    }

    public boolean isEnableAIKnowledge() {
        return this.enableAIKnowledge;
    }

    public boolean isEnableDoubaoMention() {
        return this.enableDoubaoMention;
    }

    public boolean isEnableMyAI() {
        return this.enableMyAI;
    }

    public boolean isUserCountVisible() {
        return this.isUserCountVisible;
    }

    public AtSelectInitData(String r3) {
        this.mIsInterruptAtAll = false;
        this.enableMyAI = true;
        this.enableDoubaoMention = true;
        this.isUserCountVisible = true;
        this.enableAIKnowledge = false;
        this.appId = "";
        this.channelId = r3;
    }

    public void setAppId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.appId = r1;
    }

    public void setConfigJson(String r1) {
        this.configJson = r1;
    }

    public void setEnableAIKnowledge(boolean r1) {
        this.enableAIKnowledge = r1;
    }

    public void setEnableDoubaoMention(boolean r1) {
        this.enableDoubaoMention = r1;
    }

    public void setEnableMyAI(boolean r1) {
        this.enableMyAI = r1;
    }

    public void setIsInterruptAtAll(boolean r1) {
        this.mIsInterruptAtAll = r1;
    }

    public void setUserCountVisible(boolean r1) {
        this.isUserCountVisible = r1;
    }

    public AtSelectInitData(ArrayList<String> r3, ArrayList<String> r4) {
        this.mIsInterruptAtAll = false;
        this.enableMyAI = true;
        this.enableDoubaoMention = true;
        this.isUserCountVisible = true;
        this.enableAIKnowledge = false;
        this.appId = "";
        this.chatterIds = r3;
        this.chatIds = r4;
    }
}
