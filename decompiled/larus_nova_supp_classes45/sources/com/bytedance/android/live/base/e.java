package com.bytedance.android.live.base;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/base/e;", "", "", "waitDuration", "I", "getWaitDuration", "()I", "setWaitDuration", "(I)V", "countDown", "getCountDown", "setCountDown", "style", "getStyle", "setStyle", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "", "entryList", "Ljava/util/List;", "getEntryList", "()Ljava/util/List;", "setEntryList", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/base/e$a;", "frequencyConfig", "Lcom/bytedance/android/live/base/e$a;", "getFrequencyConfig", "()Lcom/bytedance/android/live/base/e$a;", "setFrequencyConfig", "(Lcom/bytedance/android/live/base/e$a;)V", "<init>", "()V", "a", "b", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("count_down")
    private int countDown;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("support_entrance")
    private List<String> entryList;

    @SerializedName("frequency_config")
    private a frequencyConfig;

    @SerializedName("style")
    private int style;

    @SerializedName("wait_duration")
    private int waitDuration;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/e$a;", "", "", "useFreq", "Z", "getUseFreq", "()Z", "setUseFreq", "(Z)V", "slideOut", "getSlideOut", "setSlideOut", "", "negativeFeedbackFreq", "J", "getNegativeFeedbackFreq", "()J", "setNegativeFeedbackFreq", "(J)V", "continuousNegativeFeedbackFreq", "getContinuousNegativeFeedbackFreq", "setContinuousNegativeFeedbackFreq", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("continuous_negative_feedback_freq")
        private long continuousNegativeFeedbackFreq;

        @SerializedName("negative_feedback_freq")
        private long negativeFeedbackFreq;

        @SerializedName("use_slide_out")
        private boolean slideOut;

        @SerializedName("use_freq")
        private boolean useFreq;

        public a() {
        }
    }

    public static final class b {
    }

    static {
    }

    public e() {
        this.waitDuration = 5000;
        this.countDown = 10000;
        this.style = 1;
    }
}
