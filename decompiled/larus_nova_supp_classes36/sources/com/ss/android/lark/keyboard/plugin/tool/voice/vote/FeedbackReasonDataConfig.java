package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "myai_feedback_config")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/FeedbackReasonDataConfig;", "Ljava/io/Serializable;", "<init>", "()V", "dislikeReasons", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/FeedbackReasonDataConfig$DislikeReason;", "Lkotlin/collections/ArrayList;", "getDislikeReasons", "()Ljava/util/ArrayList;", "setDislikeReasons", "(Ljava/util/ArrayList;)V", "DislikeReason", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FeedbackReasonDataConfig implements Serializable {

    @SerializedName("dislike_reasons")
    private ArrayList<DislikeReason> dislikeReasons;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR:\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/FeedbackReasonDataConfig$DislikeReason;", "Ljava/io/Serializable;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getName", "()Ljava/util/HashMap;", "setName", "(Ljava/util/HashMap;)V", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DislikeReason implements Serializable {

        @SerializedName("id")
        private String id;

        @SerializedName("name")
        private HashMap<String, String> name;

        public DislikeReason() {
            this.id = "";
            this.name = new HashMap();
        }

        public final String getId() {
            return this.id;
        }

        public final HashMap<String, String> getName() {
            return this.name;
        }

        public final void setId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.id = r2;
        }

        public final void setName(HashMap<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.name = r2;
        }
    }

    public FeedbackReasonDataConfig() {
        this.dislikeReasons = new ArrayList();
    }

    public final ArrayList<DislikeReason> getDislikeReasons() {
        return this.dislikeReasons;
    }

    public final void setDislikeReasons(ArrayList<DislikeReason> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dislikeReasons = r2;
    }
}
