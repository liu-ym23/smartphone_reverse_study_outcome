package com.larus.ugc.perf.impl.genimg;

import android.util.LruCache;
import com.google.gson.annotations.SerializedName;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import nq9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class OldUgcGenImgPerfMonitor implements com.larus.ugc.perf.impl.d, g {
    public final LruCache<String, Boolean> a;
    public final LruCache<String, Job> b;
    public String c;

    public static final class a {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b<\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010F\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010G\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010H\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010I\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100Jæ\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0011HÖ\u0001J\t\u0010R\u001a\u00020\bHÖ\u0001R(\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR(\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b+\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010(R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016X\u0097\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b2\u00100R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b3\u00100R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b4\u00100R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b6\u00100R\u0016\u00107\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010(¨\u0006S"}, d2 = {"Lcom/larus/ugc/perf/impl/genimg/OldUgcGenImgPerfMonitor$UgcCompatGenerateImageEvent;", "Lcom/larus/ugc/perf/impl/mob/UgcPerfEvent;", "messageReceiveFirstPackage", "", "messageReceiveFirstImageDuration", "messageReceiveContentEnd", "duration", "scene", "", "parentScene", "success", "errorCode", "traceId", "taskId", "taskType", "isMixedTask", "instructionType", "", "imageEditType", "expectCount", "realCount", "intentionType", "index", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getMessageReceiveFirstPackage$annotations", "()V", "getMessageReceiveFirstPackage", "()Ljava/lang/Long;", "setMessageReceiveFirstPackage", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMessageReceiveFirstImageDuration$annotations", "getMessageReceiveFirstImageDuration", "setMessageReceiveFirstImageDuration", "getMessageReceiveContentEnd$annotations", "getMessageReceiveContentEnd", "setMessageReceiveContentEnd", "getDuration", "getScene", "()Ljava/lang/String;", "getParentScene", "getSuccess", "getErrorCode", "getTraceId", "getTaskId", "getTaskType", "getInstructionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageEditType", "getExpectCount", "getRealCount", "getIntentionType", "getIndex", "mobKey", "getMobKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/ugc/perf/impl/genimg/OldUgcGenImgPerfMonitor$UgcCompatGenerateImageEvent;", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class b implements h1a.d {

        @SerializedName("duration")
        private final Long duration;

        @SerializedName("error_code")
        private final Long errorCode;

        @SerializedName("expect_count")
        private final Integer expectCount;

        @SerializedName("image_edit_type")
        private final Integer imageEditType;

        @SerializedName("index")
        private final Integer index;

        @SerializedName("instruction_type")
        private final Integer instructionType;

        @SerializedName("intention_type")
        private final String intentionType;

        @SerializedName("is_mixed_task")
        private final String isMixedTask;

        @SerializedName("message_receive_content_end")
        private Long messageReceiveContentEnd;

        @SerializedName("message_receive_first_image_duration")
        private Long messageReceiveFirstImageDuration;

        @SerializedName("message_receive_first_package")
        private Long messageReceiveFirstPackage;

        @SerializedName("parent_scene")
        private final String parentScene;

        @SerializedName("real_count")
        private final Integer realCount;

        @SerializedName("scene")
        private final String scene;

        @SerializedName("success")
        private final String success;

        @SerializedName("task_id")
        private final String taskId;

        @SerializedName("task_type")
        private final String taskType;

        @SerializedName("trace_id")
        private final String traceId;

        public b() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143);
        }

        @Override // h1a.d
        public final String a() {
            return "chat_generate_image";
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.messageReceiveFirstPackage, r6.messageReceiveFirstPackage) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.messageReceiveFirstImageDuration, r6.messageReceiveFirstImageDuration) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.messageReceiveContentEnd, r6.messageReceiveContentEnd) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.parentScene, r6.parentScene) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.success, r6.success) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.errorCode, r6.errorCode) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.traceId, r6.traceId) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.taskType, r6.taskType) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.isMixedTask, r6.isMixedTask) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.instructionType, r6.instructionType) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.imageEditType, r6.imageEditType) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.expectCount, r6.expectCount) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.realCount, r6.realCount) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.intentionType, r6.intentionType) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.index, r6.index) == true) goto L62;
            return false;
        L62:
            return true;
        }

        public final int hashCode() {
            Long r0 = this.messageReceiveFirstPackage;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.messageReceiveFirstImageDuration;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Long r7 = this.messageReceiveContentEnd;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Long r10 = this.duration;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.scene;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.parentScene;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.success;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            Long r22 = this.errorCode;
            if (r22 != null) goto L33;
            int r23 = 0;
        L34:
            int r24 = (r21 + r23) * 31;
            String r25 = this.traceId;
            if (r25 != null) goto L37;
            int r26 = 0;
        L38:
            int r27 = (r24 + r26) * 31;
            String r28 = this.taskId;
            if (r28 != null) goto L41;
            int r29 = 0;
        L42:
            int r30 = (r27 + r29) * 31;
            String r31 = this.taskType;
            if (r31 != null) goto L45;
            int r32 = 0;
        L46:
            int r33 = (r30 + r32) * 31;
            String r34 = this.isMixedTask;
            if (r34 != null) goto L49;
            int r35 = 0;
        L50:
            int r36 = (r33 + r35) * 31;
            Integer r37 = this.instructionType;
            if (r37 != null) goto L53;
            int r38 = 0;
        L54:
            int r39 = (r36 + r38) * 31;
            Integer r40 = this.imageEditType;
            if (r40 != null) goto L57;
            int r41 = 0;
        L58:
            int r42 = (r39 + r41) * 31;
            Integer r43 = this.expectCount;
            if (r43 != null) goto L61;
            int r44 = 0;
        L62:
            int r45 = (r42 + r44) * 31;
            Integer r46 = this.realCount;
            if (r46 != null) goto L65;
            int r47 = 0;
        L66:
            int r48 = (r45 + r47) * 31;
            String r49 = this.intentionType;
            if (r49 != null) goto L69;
            int r50 = 0;
        L70:
            int r51 = (r48 + r50) * 31;
            Integer r52 = this.index;
            if (r52 == null) goto L75;
            r1 = r52.hashCode();
        L75:
            return r51 + r1;
        L69:
            r50 = r49.hashCode();
            goto L70
        L65:
            r47 = r46.hashCode();
            goto L66
        L61:
            r44 = r43.hashCode();
            goto L62
        L57:
            r41 = r40.hashCode();
            goto L58
        L53:
            r38 = r37.hashCode();
            goto L54
        L49:
            r35 = r34.hashCode();
            goto L50
        L45:
            r32 = r31.hashCode();
            goto L46
        L41:
            r29 = r28.hashCode();
            goto L42
        L37:
            r26 = r25.hashCode();
            goto L38
        L33:
            r23 = r22.hashCode();
            goto L34
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
            return "UgcCompatGenerateImageEvent(messageReceiveFirstPackage=" + this.messageReceiveFirstPackage + ", messageReceiveFirstImageDuration=" + this.messageReceiveFirstImageDuration + ", messageReceiveContentEnd=" + this.messageReceiveContentEnd + ", duration=" + this.duration + ", scene=" + this.scene + ", parentScene=" + this.parentScene + ", success=" + this.success + ", errorCode=" + this.errorCode + ", traceId=" + this.traceId + ", taskId=" + this.taskId + ", taskType=" + this.taskType + ", isMixedTask=" + this.isMixedTask + ", instructionType=" + this.instructionType + ", imageEditType=" + this.imageEditType + ", expectCount=" + this.expectCount + ", realCount=" + this.realCount + ", intentionType=" + this.intentionType + ", index=" + this.index + ')';
        }

        public b(Long r20, Long r21, Long r22, Long r23, String r24, String r25, String r26, Long r27, String r28, String r29, String r30, String r31, Integer r32, Integer r33, Integer r34, Integer r35, String r36, Integer r37, int r38) {
            if ((r38 & 1) == 0) goto L5;
            Long r2 = null;
        L7:
            if ((r38 & 2) == 0) goto L9;
            Long r4 = null;
        L11:
            if ((r38 & 4) == 0) goto L13;
            Long r5 = null;
        L15:
            if ((r38 & 8) == 0) goto L17;
            Long r6 = null;
        L19:
            if ((r38 & 16) == 0) goto L21;
            String r7 = null;
        L23:
            if ((r38 & 32) == 0) goto L25;
            String r8 = null;
        L27:
            if ((r38 & 64) == 0) goto L29;
            String r9 = null;
        L31:
            if ((r38 & 128) == 0) goto L33;
            Long r10 = null;
        L35:
            if ((r38 & 256) == 0) goto L37;
            String r11 = null;
        L39:
            if ((r38 & 512) == 0) goto L41;
            String r12 = null;
        L43:
            if ((r38 & 1024) == 0) goto L45;
            String r13 = null;
        L47:
            if ((r38 & 2048) == 0) goto L49;
            String r14 = null;
        L51:
            if ((r38 & 4096) == 0) goto L53;
            Integer r15 = null;
        L55:
            if ((r38 & 8192) == 0) goto L57;
            Integer r3 = null;
        L58:
            Integer r210 = r3;
            if ((r38 & 16384) == 0) goto L61;
            Integer r16 = null;
        L63:
            if ((r38 & 32768) == 0) goto L65;
            Integer r17 = null;
        L67:
            if ((r38 & 65536) == 0) goto L69;
            String r18 = null;
        L71:
            if ((r38 & 131072) == 0) goto L73;
            Integer r1 = null;
        L74:
            this.messageReceiveFirstPackage = r2;
            this.messageReceiveFirstImageDuration = r4;
            this.messageReceiveContentEnd = r5;
            this.duration = r6;
            this.scene = r7;
            this.parentScene = r8;
            this.success = r9;
            this.errorCode = r10;
            this.traceId = r11;
            this.taskId = r12;
            this.taskType = r13;
            this.isMixedTask = r14;
            this.instructionType = r15;
            this.imageEditType = r210;
            this.expectCount = r16;
            this.realCount = r17;
            this.intentionType = r18;
            this.index = r1;
            return;
        L73:
            r1 = r37;
            goto L74
        L69:
            r18 = r36;
            goto L71
        L65:
            r17 = r35;
            goto L67
        L61:
            r16 = r34;
            goto L63
        L57:
            r3 = r33;
            goto L58
        L53:
            r15 = r32;
            goto L55
        L49:
            r14 = r31;
            goto L51
        L45:
            r13 = r30;
            goto L47
        L41:
            r12 = r29;
            goto L43
        L37:
            r11 = r28;
            goto L39
        L33:
            r10 = r27;
            goto L35
        L29:
            r9 = r26;
            goto L31
        L25:
            r8 = r25;
            goto L27
        L21:
            r7 = r24;
            goto L23
        L17:
            r6 = r23;
            goto L19
        L13:
            r5 = r22;
            goto L15
        L9:
            r4 = r21;
            goto L11
        L5:
            r2 = r20;
            goto L7
        }
    }

    static {
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void d(com.larus.ugc.perf.impl.e r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public OldUgcGenImgPerfMonitor() {
        this.a = new LruCache(5);
        this.b = new LruCache(1);
        this.c = "";
        com.larus.im.d.e().registerOnGlobalMessageObserver(new AnonymousClass1(this));
    }

    @Deprecated(message = "change to duration by multi-stage mob serials")
    public static void i(com.larus.ugc.perf.impl.e r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        HashMap<String, Object> r0 = r5.b;
        long r1 = System.currentTimeMillis();
        Long r6 = r5.c();
        if (r6 == null) goto L5;
        long r3 = r6.longValue();
    L6:
        r0.put("message_receive_first_package", Long.valueOf(r1 - r3));
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.larus.ugc.perf.impl.d
    public void a(com.larus.ugc.perf.impl.e r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        FLogger.a.i("OldUgcGenImgPerfMonitor", "onReceiveMsg:" + r4.b());
        j(r4, 0);
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void c(com.larus.ugc.perf.impl.e r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        FLogger.a.i("OldUgcGenImgPerfMonitor", "onFirstPackage:" + r4.b());
        i(r4);
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void h(com.larus.ugc.perf.impl.e r9) {
        Intrinsics.checkNotNullParameter(r9, "source");
        Intrinsics.checkNotNullParameter(r9, "source");
        FLogger.a.i("OldUgcGenImgPerfMonitor", "onReceiveLoadingMsg:" + r9.b());
        String r0 = r9.b();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.c = r0;
        String r1 = r9.b();
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.b.get(r1) == null) goto L10;
        return;
    L10:
        Job r10 = this.b.put(r1, BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new OldUgcGenImgPerfMonitor$onReceiveLoadingMsg$1$job$1(r9, this, r1, null), 3, null));
    }

    public static long k(Message r1, long r2) {
        if (r1 == null) goto L6;
        Map r3 = r1.getExt();
        if (r3 == null) goto L6;
        String r4 = (String) r3.get("ai_creation_res_code");
    L7:
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        if (r4.length() != 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        return r2;
    L15:
        Long r5 = StringsKt.toLongOrNull(r4);
        if (r5 != null) goto L18;
        return r2;
    L18:
        return r5.longValue();
    L12:
        r0 = false;
    L6:
        r4 = null;
        goto L7
    }

    @Override // nq9.g
    public void b(Message r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r13, "taskId");
        com.larus.ugc.perf.impl.e r0 = com.larus.ugc.perf.impl.d.a.a(r12);
        if (r0 != null) goto L5;
        return;
    L5:
        Object r1 = r0.b.get("is_report_image_loading_success" + r13);
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == false) goto L8;
        return;
    L8:
        r0.b.put("is_report_image_loading_success" + r13, r2);
        long r3 = System.currentTimeMillis();
        Object r14 = r0.b.get("loading_item_start" + r13);
        if ((r14 instanceof Long) == false) goto L11;
        Long r15 = (Long) r14;
    L12:
        if (r15 == null) goto L14;
        long r4 = r15.longValue();
    L15:
        long r8 = r3 - r4;
        String r16 = r12.getMessageId();
        if (r16 != null) goto L18;
        r16 = "";
    L18:
        h1a.e.b(l(this, r16, "1", r8, com.larus.bmhome.chat.bean.d.h(r12)), r0);
        return;
    L14:
        r4 = System.currentTimeMillis();
        goto L15
    L11:
        r15 = null;
        goto L12
    }

    @Override // nq9.g
    public void e(Message r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    @Override // nq9.g
    public void f(Message r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "message");
        Intrinsics.checkNotNullParameter(r8, "taskId");
        com.larus.ugc.perf.impl.e r9 = com.larus.ugc.perf.impl.d.a.a(r7);
        if (r9 != null) goto L5;
        return;
    L5:
        String r0 = r7.getMessageId();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        h1a.e.b(l(this, r0, "0", -1, com.larus.bmhome.chat.bean.d.h(r7)), r9);
    }

    @Override // nq9.g
    public void g(Message r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "taskId");
        com.larus.ugc.perf.impl.e r5 = com.larus.ugc.perf.impl.d.a.a(r3);
        if (r5 != null) goto L5;
        return;
    L5:
        r5.b.put("loading_item_start" + r4, Long.valueOf(System.currentTimeMillis()));
    }

    @Deprecated(message = "change to duration by multi-stage mob serials")
    public final void j(com.larus.ugc.perf.impl.e r37, long r38) {
        Object r4 = r37.b.get("is_send_message_content_end");
        Boolean r6 = Boolean.TRUE;
        if (Intrinsics.areEqual(r4, r6) == false) goto L5;
        return;
    L5:
        r37.b.put("is_send_message_content_end", r6);
        long r5 = System.currentTimeMillis();
        Long r7 = r37.d();
        if (r7 == null) goto L8;
        long r8 = r7.longValue();
    L9:
        long r9 = r5 - r8;
        if (r9 > 0) goto L12;
        return;
    L12:
        if (r9 > 180000) goto L78;
        Long r10 = r37.c();
        if (r10 == null) goto L17;
        long r11 = r10.longValue();
    L18:
        long r12 = System.currentTimeMillis() - r11;
        long r13 = k(r37.a, r38);
        Message r14 = r37.a;
        if (r14 == null) goto L21;
        int r15 = com.larus.bmhome.chat.bean.d.I(r14);
    L22:
        Message r16 = r37.a;
        if (r16 == null) goto L25;
        String r22 = tz9.a.a(r16);
    L26:
        Object r17 = r37.b.get("message_receive_first_package");
        if ((r17 instanceof Long) == false) goto L29;
        Long r18 = (Long) r17;
    L31:
        if (r38 != 0) goto L33;
        long r2 = r9;
    L34:
        Message r19 = r37.a;
        if (r19 == null) goto L37;
        Integer r29 = Integer.valueOf(com.larus.bmhome.chat.bean.d.h(r19));
    L38:
        Message r110 = r37.a;
        if (r110 == null) goto L41;
        Integer r30 = IAIChatControlTraceService.a.Wb(r110);
    L42:
        int r111 = r37.a();
        if (r13 != 0) goto L45;
        String r20 = "1";
    L46:
        String r23 = r20;
        Message r21 = r37.a;
        if (r21 != null) goto L49;
    L51:
        boolean r24 = false;
    L52:
        if (r24 == false) goto L54;
        String r25 = "image";
    L57:
        String r33 = r25;
    L59:
        h1a.e.a(new b(r18, Long.valueOf(r9), Long.valueOf(r12), Long.valueOf(r2), "gen_image/receive_last_package", r22, r23, Long.valueOf(r13), null, null, null, null, r29, r30, Integer.valueOf(r111), Integer.valueOf(r15), r33, null, 134912), r37);
        Message r3 = r37.a;
        if (r3 == null) goto L62;
        String r26 = r3.getMessageId();
    L63:
        if (r13 != 0) goto L65;
        boolean r112 = true;
    L66:
        h1a.b.a(r26, null, r112, Long.valueOf(r9), null);
        String r1 = r37.b();
        if (r1 == null) goto L72;
        this.a.put(r1, r6);
        Job r27 = this.b.get(r1);
        if (r27 == null) goto L71;
        Job.DefaultImpls.cancel$default(r27, null, 1, null);
    L71:
        Job r28 = this.b.remove(r1);
    L72:
        IFlowSdkDepend r31 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r31 == null) goto L77;
        r31.r0();
        e2.a.x();
        return;
    L77:
        return;
    L65:
        r112 = false;
        goto L66
    L62:
        r26 = null;
        goto L63
    L54:
        Message r32 = r37.a;
        if (r32 == null) goto L58;
        r25 = ap8.a.b(r32);
        goto L57
    L58:
        r33 = null;
        goto L59
    L49:
        if (com.larus.bmhome.chat.bean.d.a0(r21) != true) goto L51;
        r24 = true;
        goto L52
    L45:
        r20 = "0";
        goto L46
    L41:
        r30 = null;
        goto L42
    L37:
        r29 = null;
        goto L38
    L33:
        r2 = -1;
        goto L34
    L29:
        r18 = null;
        goto L31
    L25:
        r22 = null;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L78:
        return;
    L8:
        r8 = System.currentTimeMillis();
        goto L9
    }

    public static h1a.a l(OldUgcGenImgPerfMonitor r10, String r11, String r12, long r13, int r15) {
        r10.getClass();
        return new h1a.a("image_create/image_loading", null, r12, 0L, Long.valueOf(r13), r11, null, Integer.valueOf(r15), 66);
    }
}
