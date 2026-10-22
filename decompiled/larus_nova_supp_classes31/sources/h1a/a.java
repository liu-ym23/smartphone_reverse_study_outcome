package h1a;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ixigua.lib.track.TrackParams;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJn\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\fHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/larus/ugc/perf/impl/mob/BaseUgcPerfEvent;", "Lcom/larus/ugc/perf/impl/mob/UgcPerfEvent;", "scene", "", "parentScene", "success", "errorCode", "", "duration", "traceId", "taskId", "instructionType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getScene", "()Ljava/lang/String;", "getParentScene", "getSuccess", "getErrorCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDuration", "getTraceId", "getTaskId", "getInstructionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "sendWith", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/ugc/perf/impl/mob/BaseUgcPerfEvent;", "equals", "", "other", "", "hashCode", "toString", "Companion", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a implements d {
    public static final Gson a = null;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("error_code")
    private final Long errorCode;

    @SerializedName("instruction_type")
    private final Integer instructionType;

    @SerializedName("parent_scene")
    private final String parentScene;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("success")
    private final String success;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("trace_id")
    private final String traceId;

    /* JADX INFO: renamed from: h1a.a$a, reason: collision with other inner class name */
    public static final class C0058a {
    }

    public a() {
        this(null, null, null, null, null, null, null, null, 255);
    }

    @Override // h1a.d
    public final String a() {
        return "ugc_core_segment_report";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentScene, r6.parentScene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.success, r6.success) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.errorCode, r6.errorCode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.traceId, r6.traceId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.instructionType, r6.instructionType) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.scene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.parentScene;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.success;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.errorCode;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.duration;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.traceId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.taskId;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.instructionType;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaseUgcPerfEvent(scene=" + this.scene + ", parentScene=" + this.parentScene + ", success=" + this.success + ", errorCode=" + this.errorCode + ", duration=" + this.duration + ", traceId=" + this.traceId + ", taskId=" + this.taskId + ", instructionType=" + this.instructionType + ')';
    }

    static {
        a = new Gson();
    }

    public final void b() {
        JSONObject r1 = new JSONObject(GsonProtectorUtils.toJson(a, this));
        TrackParams r0 = new TrackParams().merge(r1);
        by7.a r2 = new by7.a("ugc_core_segment_report");
        r2.a.merge(r0);
        r2.b();
    }

    public a(String r3, String r4, String r5, Long r6, Long r7, String r8, String r9, Integer r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r11 & 128) == 0) goto L26;
        r10 = null;
    L26:
        this.scene = r3;
        this.parentScene = r4;
        this.success = r5;
        this.errorCode = r6;
        this.duration = r7;
        this.traceId = r8;
        this.taskId = r9;
        this.instructionType = r10;
    }
}
