package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\u0013\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0099\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\rHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001bR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u00065"}, d2 = {"Lcom/larus/settings/provider/MethodConfig;", "", "methodId", "", "className", "methodName", "methodSign", "machineCode", "isCaller", "", "unconditionalGuard", "enableDynamicHook", "guardType", "", "modifyArgs", "", "Lcom/larus/settings/provider/ModifyArg;", "returnType", "returnValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getMethodId", "()Ljava/lang/String;", "getClassName", "getMethodName", "getMethodSign", "getMachineCode", "()Z", "getUnconditionalGuard", "getEnableDynamicHook", "getGuardType", "()I", "getModifyArgs", "()Ljava/util/List;", "getReturnType", "getReturnValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class h3 {

    @SerializedName("class_name")
    private final String className;

    @SerializedName("enable_dynamic_hook")
    private final boolean enableDynamicHook;

    @SerializedName("guard_type")
    private final int guardType;

    @SerializedName("is_caller")
    private final boolean isCaller;

    @SerializedName("machine_code")
    private final String machineCode;

    @SerializedName("method_id")
    private final String methodId;

    @SerializedName("method_name")
    private final String methodName;

    @SerializedName("method_sign")
    private final String methodSign;

    @SerializedName("modify_args")
    private final List<i3> modifyArgs;

    @SerializedName("return_type")
    private final String returnType;

    @SerializedName("return_value")
    private final String returnValue;

    @SerializedName("unconditional_guard")
    private final boolean unconditionalGuard;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h3) == true) goto L8;
        return false;
    L8:
        h3 r6 = (h3) r5;
        if (Intrinsics.areEqual(this.methodId, r6.methodId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.className, r6.className) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.methodName, r6.methodName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.methodSign, r6.methodSign) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.machineCode, r6.machineCode) == true) goto L24;
        return false;
    L24:
        if (this.isCaller == r6.isCaller) goto L27;
        return false;
    L27:
        if (this.unconditionalGuard == r6.unconditionalGuard) goto L30;
        return false;
    L30:
        if (this.enableDynamicHook == r6.enableDynamicHook) goto L33;
        return false;
    L33:
        if (this.guardType == r6.guardType) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.modifyArgs, r6.modifyArgs) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.returnType, r6.returnType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.returnValue, r6.returnValue) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r0 = this.methodId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.className;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.methodName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.methodSign;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.machineCode;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        int r16 = 1231;
        if (this.isCaller == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.unconditionalGuard == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.enableDynamicHook == true) goto L34;
        r16 = 1237;
    L34:
        int r21 = (((r20 + r16) * 31) + this.guardType) * 31;
        List<i3> r22 = this.modifyArgs;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        String r25 = this.returnType;
        if (r25 != null) goto L41;
        int r26 = 0;
    L42:
        int r27 = (r24 + r26) * 31;
        String r28 = this.returnValue;
        if (r28 == null) goto L47;
        r1 = r28.hashCode();
    L47:
        return r27 + r1;
    L41:
        r26 = r25.hashCode();
        goto L42
    L37:
        r23 = r22.hashCode();
        goto L38
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = 1237;
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
        return "MethodConfig(methodId=" + this.methodId + ", className=" + this.className + ", methodName=" + this.methodName + ", methodSign=" + this.methodSign + ", machineCode=" + this.machineCode + ", isCaller=" + this.isCaller + ", unconditionalGuard=" + this.unconditionalGuard + ", enableDynamicHook=" + this.enableDynamicHook + ", guardType=" + this.guardType + ", modifyArgs=" + this.modifyArgs + ", returnType=" + this.returnType + ", returnValue=" + this.returnValue + ')';
    }

    public h3() {
        List<i3> r0 = CollectionsKt.emptyList();
        this.methodId = "-1";
        this.className = "";
        this.methodName = "";
        this.methodSign = "";
        this.machineCode = "";
        this.isCaller = false;
        this.unconditionalGuard = true;
        this.enableDynamicHook = true;
        this.guardType = 0;
        this.modifyArgs = r0;
        this.returnType = "null";
        this.returnValue = "";
    }
}
