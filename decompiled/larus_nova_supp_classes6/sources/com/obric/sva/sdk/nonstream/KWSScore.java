package com.obric.sva.sdk.nonstream;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\b\u0010>\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u001a\u0010.\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u001a\u00101\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001a\u00104\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u0011\u00106\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b7\u0010\u001cR\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/obric/sva/sdk/nonstream/KWSScore;", "", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "kws_score0", "", "getKws_score0", "()D", "setKws_score0", "(D)V", "setKwsScoreStr", "", "str", "frames", "", "getFrames", "()I", "setFrames", "(I)V", "kws_result", "", "getKws_result", "()Z", "setKws_result", "(Z)V", "kws_threshold", "", "getKws_threshold", "()F", "setKws_threshold", "(F)V", "sid_threshold", "getSid_threshold", "setSid_threshold", "sid_error_msg", "getSid_error_msg", "setSid_error_msg", "sid_result", "getSid_result", "setSid_result", "sid_score", "getSid_score", "setSid_score", "env_status", "getEnv_status", "setEnv_status", "is_continue_wakeup", "set_continue_wakeup", "combineResult", "getCombineResult", "offsetTime", "", "getOffsetTime", "()J", "setOffsetTime", "(J)V", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class KWSScore {
    private int env_status;
    private int frames;
    private boolean is_continue_wakeup;
    private boolean kws_result;
    private double kws_score0;
    private float kws_threshold;
    private String name;
    private long offsetTime;
    private String sid_error_msg;
    private boolean sid_result;
    private double sid_score;
    private float sid_threshold;

    public final boolean getCombineResult() {
        LogUtils.d("KWSScore", "combineResult kws_result:" + this.kws_result + " sid_result:" + this.sid_result + " sWakeupSid:" + Global.sWakeupSid, new Object[0]);
        if (Global.sWakeupSid == false) goto L11;
        if (this.kws_result == true) goto L7;
        return false;
    L7:
        if (this.sid_result == false) goto L13;
        return true;
    L13:
        return false;
    L11:
        return this.kws_result;
    }

    public String toString() {
        return "name :" + this.name + " score:" + this.kws_score0 + " result : " + this.kws_result + " frame:" + this.frames + " threshold:" + this.kws_threshold + " sid_result:" + this.sid_result + " sid_score:" + this.sid_score + " sid_threshold:" + this.sid_threshold + " sid_error_msg:" + this.sid_error_msg + " offsetTime " + this.offsetTime;
    }

    public KWSScore() {
        this.name = "";
        this.sid_error_msg = "";
    }

    public final int getEnv_status() {
        return this.env_status;
    }

    public final int getFrames() {
        return this.frames;
    }

    public final boolean getKws_result() {
        return this.kws_result;
    }

    public final double getKws_score0() {
        return this.kws_score0;
    }

    public final float getKws_threshold() {
        return this.kws_threshold;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOffsetTime() {
        return this.offsetTime;
    }

    public final String getSid_error_msg() {
        return this.sid_error_msg;
    }

    public final boolean getSid_result() {
        return this.sid_result;
    }

    public final double getSid_score() {
        return this.sid_score;
    }

    public final float getSid_threshold() {
        return this.sid_threshold;
    }

    public final boolean is_continue_wakeup() {
        return this.is_continue_wakeup;
    }

    public final void setEnv_status(int r1) {
        this.env_status = r1;
    }

    public final void setFrames(int r1) {
        this.frames = r1;
    }

    public final void setKwsScoreStr(String r14) {
        Intrinsics.checkNotNullParameter(r14, "str");
        List r15 = StringsKt.split$default(StringsKt.replace$default(StringsKt.replace$default(r14, "[", "", false, 4, null), "]", "", false, 4, null), new String[]{","}, false, 0, 6, null);
        double r1 = 0.0d;
        if ((!r15.isEmpty()) == false) goto L7;
        Double r16 = StringsKt.toDoubleOrNull((String) ListProtector.get(r15, 0));
        if (r16 == null) goto L7;
        r1 = r16.doubleValue();
    L7:
        this.kws_score0 = r1;
    }

    public final void setKws_result(boolean r1) {
        this.kws_result = r1;
    }

    public final void setKws_score0(double r1) {
        this.kws_score0 = r1;
    }

    public final void setKws_threshold(float r1) {
        this.kws_threshold = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setOffsetTime(long r1) {
        this.offsetTime = r1;
    }

    public final void setSid_error_msg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sid_error_msg = r2;
    }

    public final void setSid_result(boolean r1) {
        this.sid_result = r1;
    }

    public final void setSid_score(double r1) {
        this.sid_score = r1;
    }

    public final void setSid_threshold(float r1) {
        this.sid_threshold = r1;
    }

    public final void set_continue_wakeup(boolean r1) {
        this.is_continue_wakeup = r1;
    }
}
