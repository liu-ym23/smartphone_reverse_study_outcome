package cfa;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\b\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\t\u0010\u0011¨\u0006\""}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelActionParams;", "", "startWithAsr", "", "content", "sourceFrom", "force", "", "isAppInnerCall", "isAutoOpen", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getStartWithAsr", "()Ljava/lang/String;", "getContent", "getSourceFrom", "getForce", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "startWithAsrEnabled", "default", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelActionParams;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("content")
    private final String content;

    @SerializedName("force")
    private final Boolean force;

    @SerializedName("is_app_inner_call")
    private final Boolean isAppInnerCall;

    @SerializedName("is_auto_open")
    private final Boolean isAutoOpen;

    @SerializedName("source_from")
    private final String sourceFrom;

    @SerializedName("start_with_asr")
    private final String startWithAsr;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.startWithAsr, r6.startWithAsr) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceFrom, r6.sourceFrom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.force, r6.force) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isAppInnerCall, r6.isAppInnerCall) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isAutoOpen, r6.isAutoOpen) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.startWithAsr;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.sourceFrom;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.force;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.isAppInnerCall;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.isAutoOpen;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "OpenNewTaskPanelActionParams(startWithAsr=" + this.startWithAsr + ", content=" + this.content + ", sourceFrom=" + this.sourceFrom + ", force=" + this.force + ", isAppInnerCall=" + this.isAppInnerCall + ", isAutoOpen=" + this.isAutoOpen + ')';
    }

    public final String a() {
        return this.content;
    }

    public final Boolean b() {
        return this.force;
    }

    public final String c() {
        return this.sourceFrom;
    }

    public final Boolean d() {
        return this.isAppInnerCall;
    }

    public final Boolean e() {
        return this.isAutoOpen;
    }

    public f(int r1) {
        this.startWithAsr = null;
        this.content = null;
        this.sourceFrom = null;
        this.force = null;
        this.isAppInnerCall = null;
        this.isAutoOpen = null;
    }

    public static boolean f(f r3) {
        String r4 = r3.startWithAsr;
        if (r4 == null) goto L7;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 == null) goto L7;
        String r6 = r5.toLowerCase(Locale.ROOT);
    L9:
        if (r6 == null) goto L29;
        int r1 = r6.hashCode();
        if (r1 != 48) goto L13;
        String r2 = "0";
    L20:
        r6.equals(r2);
        return false;
    L13:
        if (r1 == 49) goto L25;
        if (r1 == 3569038) goto L22;
        if (r1 != 97196323) goto L32;
        r2 = "false";
        goto L20
    L32:
        return false;
    L22:
        if (r6.equals("true") == false) goto L33;
    L27:
        return true;
    L33:
        return false;
    L25:
        if (r6.equals("1") == true) goto L27;
        return false;
    L29:
        return false;
    L7:
        r6 = null;
        goto L9
    }
}
