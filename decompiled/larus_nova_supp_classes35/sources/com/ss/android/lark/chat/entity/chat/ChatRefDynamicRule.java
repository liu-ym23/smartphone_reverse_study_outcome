package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001%B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003JK\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule;", "Ljava/io/Serializable;", "id", BuildConfig.FLAVOR, "ruleType", "Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule$RuleType;", "refId", "refName", "employeeTypes", "Ljava/util/LinkedList;", "allowAllEmployeeType", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule$RuleType;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Z)V", "getId", "()Ljava/lang/String;", "getRuleType", "()Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule$RuleType;", "getRefId", "getRefName", "getEmployeeTypes", "()Ljava/util/LinkedList;", "getAllowAllEmployeeType", "()Z", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "RuleType", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRefDynamicRule implements Serializable {
    private final boolean allowAllEmployeeType;
    private final LinkedList<String> employeeTypes;
    private final String id;
    private final String refId;
    private final String refName;
    private final RuleType ruleType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule$RuleType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEPARTMENT", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RuleType extends Enum<RuleType> {
        public static final a Companion = null;
        public static final RuleType DEPARTMENT = null;
        public static final RuleType UNKNOWN = null;
        public static final /* synthetic */ RuleType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RuleType> getEntries() {
            return b;
        }

        static {
            RuleType r0 = new RuleType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            RuleType r1 = new RuleType("DEPARTMENT", 1, 1);
            DEPARTMENT = r1;
            RuleType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static RuleType[] values() {
            return (RuleType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RuleType valueOf(String r1) {
            return (RuleType) r27.a.a(RuleType.class, r1);
        }

        public RuleType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatRefDynamicRule copy$default(ChatRefDynamicRule r4, String r5, RuleType r6, String r7, String r8, LinkedList r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.ruleType;
    L8:
        RuleType r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.refId;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.refName;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.employeeTypes;
    L17:
        LinkedList r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.allowAllEmployeeType;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final RuleType component2() {
        return this.ruleType;
    }

    public final String component3() {
        return this.refId;
    }

    public final String component4() {
        return this.refName;
    }

    public final LinkedList<String> component5() {
        return this.employeeTypes;
    }

    public final boolean component6() {
        return this.allowAllEmployeeType;
    }

    public final ChatRefDynamicRule copy(String r9, RuleType r10, String r11, String r12, LinkedList<String> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r9, "id");
        Intrinsics.checkNotNullParameter(r10, "ruleType");
        Intrinsics.checkNotNullParameter(r11, "refId");
        Intrinsics.checkNotNullParameter(r12, "refName");
        Intrinsics.checkNotNullParameter(r13, "employeeTypes");
        return new ChatRefDynamicRule(r9, r10, r11, r12, r13, r14);
    }

    public int hashCode() {
        int r0 = ((((((((this.id.hashCode() * 31) + this.ruleType.hashCode()) * 31) + this.refId.hashCode()) * 31) + this.refName.hashCode()) * 31) + this.employeeTypes.hashCode()) * 31;
        if (this.allowAllEmployeeType == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "ChatRefDynamicRule(id='" + this.id + "', ruleType=" + this.ruleType + ", refId='" + this.refId + "', refName='" + this.refName + "', employeeTypes=" + this.employeeTypes + ", allowAllEmployeeType=" + this.allowAllEmployeeType + ')';
    }

    public final boolean getAllowAllEmployeeType() {
        return this.allowAllEmployeeType;
    }

    public final LinkedList<String> getEmployeeTypes() {
        return this.employeeTypes;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final String getRefName() {
        return this.refName;
    }

    public final RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(ChatRefDynamicRule.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chat.ChatRefDynamicRule");
        ChatRefDynamicRule r6 = (ChatRefDynamicRule) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L16;
        return false;
    L16:
        if (this.ruleType == r6.ruleType) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.refId, r6.refId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.refName, r6.refName) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.employeeTypes, r6.employeeTypes) == true) goto L28;
        return false;
    L28:
        if (this.allowAllEmployeeType == r6.allowAllEmployeeType) goto L30;
        return false;
    L30:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public ChatRefDynamicRule(String r2, RuleType r3, String r4, String r5, LinkedList<String> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "ruleType");
        Intrinsics.checkNotNullParameter(r4, "refId");
        Intrinsics.checkNotNullParameter(r5, "refName");
        Intrinsics.checkNotNullParameter(r6, "employeeTypes");
        this.id = r2;
        this.ruleType = r3;
        this.refId = r4;
        this.refName = r5;
        this.employeeTypes = r6;
        this.allowAllEmployeeType = r7;
    }
}
