package com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/setting/config/ReplayBarrageFilterKeywordSetting;", "Ljava/io/Serializable;", "", "mIsFilterKeywordOpen", "Z", "getMIsFilterKeywordOpen", "()Z", "setMIsFilterKeywordOpen", "(Z)V", "mHasClickedRedHot", "getMHasClickedRedHot", "setMHasClickedRedHot", "", "mFilterKeywordListJson", "Ljava/lang/String;", "getMFilterKeywordListJson", "()Ljava/lang/String;", "setMFilterKeywordListJson", "(Ljava/lang/String;)V", "", "mFilterKeywordLimit", "I", "getMFilterKeywordLimit", "()I", "setMFilterKeywordLimit", "(I)V", "<init>", "()V", "Companion", "a", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayBarrageFilterKeywordSetting implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("filter_keyword_limit")
    private int mFilterKeywordLimit;

    @SerializedName("filter_keyword_content")
    private String mFilterKeywordListJson;

    @SerializedName("has_show_red_hot")
    private boolean mHasClickedRedHot;

    @SerializedName("is_filter_keyword_open")
    private boolean mIsFilterKeywordOpen;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ReplayBarrageFilterKeywordSetting() {
        this.mFilterKeywordListJson = "";
    }

    public final int getMFilterKeywordLimit() {
        return this.mFilterKeywordLimit;
    }

    public final String getMFilterKeywordListJson() {
        return this.mFilterKeywordListJson;
    }

    public final boolean getMHasClickedRedHot() {
        return this.mHasClickedRedHot;
    }

    public final boolean getMIsFilterKeywordOpen() {
        return this.mIsFilterKeywordOpen;
    }

    public final void setMFilterKeywordLimit(int r1) {
        this.mFilterKeywordLimit = r1;
    }

    public final void setMFilterKeywordListJson(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mFilterKeywordListJson = r2;
    }

    public final void setMHasClickedRedHot(boolean r1) {
        this.mHasClickedRedHot = r1;
    }

    public final void setMIsFilterKeywordOpen(boolean r1) {
        this.mIsFilterKeywordOpen = r1;
    }
}
