package com.larus.bmhome.chat.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/api/SuggestPrompt;", "Ljava/io/Serializable;", "<init>", "()V", "sgStr", "", "", "getSgStr", "()Ljava/util/List;", "setSgStr", "(Ljava/util/List;)V", "bubble", "getBubble", "()Ljava/lang/String;", "setBubble", "(Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SuggestPrompt implements Serializable {

    @SerializedName("bubble")
    private String bubble;

    @SerializedName("suggest")
    private List<String> sgStr;

    public SuggestPrompt() {
    }

    public final String getBubble() {
        return this.bubble;
    }

    public final List<String> getSgStr() {
        return this.sgStr;
    }

    public final void setBubble(String r1) {
        this.bubble = r1;
    }

    public final void setSgStr(List<String> r1) {
        this.sgStr = r1;
    }
}
