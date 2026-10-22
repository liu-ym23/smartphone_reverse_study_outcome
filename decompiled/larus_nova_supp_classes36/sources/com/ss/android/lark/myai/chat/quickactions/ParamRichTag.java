package com.ss.android.lark.myai.chat.quickactions;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/myai/chat/quickactions/ParamRichTag;", "Ljava/io/Serializable;", "<init>", "()V", "atInfo", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/myai/chat/quickactions/AtInfo;", "getAtInfo", "()Ljava/util/ArrayList;", "setAtInfo", "(Ljava/util/ArrayList;)V", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ParamRichTag implements Serializable {

    @SerializedName("at_info")
    private ArrayList<AtInfo> atInfo;

    public ParamRichTag() {
    }

    public final ArrayList<AtInfo> getAtInfo() {
        return this.atInfo;
    }

    public final void setAtInfo(ArrayList<AtInfo> r1) {
        this.atInfo = r1;
    }
}
