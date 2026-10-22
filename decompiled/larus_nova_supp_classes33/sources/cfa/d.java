package cfa;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015Jn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\n\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u000b\u0010\u0015¨\u0006("}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenAdditionInputPanelActionParams;", "", "taskId", "", "sourceFrom", "referenceMsgId", "referenceMsgContent", "startWithAsr", "force", "", "isAppInnerCall", "isAutoOpen", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getTaskId", "()Ljava/lang/String;", "getSourceFrom", "getReferenceMsgId", "getReferenceMsgContent", "getStartWithAsr", "getForce", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "startWithAsrEnabled", "default", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/chat_page/OpenAdditionInputPanelActionParams;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("force")
    private final Boolean force;

    @SerializedName("is_app_inner_call")
    private final Boolean isAppInnerCall;

    @SerializedName("is_auto_open")
    private final Boolean isAutoOpen;

    @SerializedName("reference_msg_content")
    private final String referenceMsgContent;

    @SerializedName("reference_msg_id")
    private final String referenceMsgId;

    @SerializedName("source_from")
    private final String sourceFrom;

    @SerializedName("start_with_asr")
    private final String startWithAsr;

    @SerializedName("task_id")
    private final String taskId;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceFrom, r6.sourceFrom) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.referenceMsgId, r6.referenceMsgId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.referenceMsgContent, r6.referenceMsgContent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.startWithAsr, r6.startWithAsr) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.force, r6.force) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isAppInnerCall, r6.isAppInnerCall) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isAutoOpen, r6.isAutoOpen) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.sourceFrom;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.referenceMsgId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.referenceMsgContent;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.startWithAsr;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.force;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.isAppInnerCall;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.isAutoOpen;
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
        return "OpenAdditionInputPanelActionParams(taskId=" + this.taskId + ", sourceFrom=" + this.sourceFrom + ", referenceMsgId=" + this.referenceMsgId + ", referenceMsgContent=" + this.referenceMsgContent + ", startWithAsr=" + this.startWithAsr + ", force=" + this.force + ", isAppInnerCall=" + this.isAppInnerCall + ", isAutoOpen=" + this.isAutoOpen + ')';
    }

    public final Boolean a() {
        return this.force;
    }

    public final String b() {
        return this.referenceMsgContent;
    }

    public final String c() {
        return this.referenceMsgId;
    }

    public final String d() {
        return this.sourceFrom;
    }

    public final String e() {
        return this.taskId;
    }

    public final Boolean f() {
        return this.isAppInnerCall;
    }

    public final Boolean g() {
        return this.isAutoOpen;
    }

    public d(int r1) {
        this.taskId = null;
        this.sourceFrom = null;
        this.referenceMsgId = null;
        this.referenceMsgContent = null;
        this.startWithAsr = null;
        this.force = null;
        this.isAppInnerCall = null;
        this.isAutoOpen = null;
    }

    public static boolean h(d r2) {
        String r3 = r2.startWithAsr;
        if (r3 == null) goto L7;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L7;
        String r5 = r4.toLowerCase(Locale.ROOT);
    L8:
        if (r5 == null) goto L28;
        int r0 = r5.hashCode();
        if (r0 == 48) goto L25;
        if (r0 != 49) goto L14;
        String r1 = "1";
    L22:
        r5.equals(r1);
        goto L28
    L14:
        if (r0 != 3569038) goto L16;
        r1 = "true";
        goto L22
    L16:
        if (r0 != 97196323) goto L28;
        if (r5.equals("false") == false) goto L28;
    L27:
        return false;
    L25:
        if (r5.equals("0") == true) goto L27;
    L28:
        return true;
    L7:
        r5 = null;
        goto L8
    }
}
