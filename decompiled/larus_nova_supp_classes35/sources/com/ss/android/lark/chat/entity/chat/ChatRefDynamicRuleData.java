package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR:\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRuleData;", "Ljava/io/Serializable;", "chatRefDynamicRuleList", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/chat/entity/chat/ChatRefDynamicRule;", "employeeTypeInfos", "Ljava/util/LinkedHashMap;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chat/RuleSelectOpt;", "Lkotlin/collections/LinkedHashMap;", "<init>", "(Ljava/util/LinkedList;Ljava/util/LinkedHashMap;)V", "getChatRefDynamicRuleList", "()Ljava/util/LinkedList;", "setChatRefDynamicRuleList", "(Ljava/util/LinkedList;)V", "getEmployeeTypeInfos", "()Ljava/util/LinkedHashMap;", "setEmployeeTypeInfos", "(Ljava/util/LinkedHashMap;)V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "component1", "component2", "copy", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRefDynamicRuleData implements Serializable {
    private LinkedList<ChatRefDynamicRule> chatRefDynamicRuleList;
    private LinkedHashMap<String, RuleSelectOpt> employeeTypeInfos;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatRefDynamicRuleData copy$default(ChatRefDynamicRuleData r0, LinkedList r1, LinkedHashMap r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.chatRefDynamicRuleList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.employeeTypeInfos;
    L9:
        return r0.copy(r1, r2);
    }

    public final LinkedList<ChatRefDynamicRule> component1() {
        return this.chatRefDynamicRuleList;
    }

    public final LinkedHashMap<String, RuleSelectOpt> component2() {
        return this.employeeTypeInfos;
    }

    public final ChatRefDynamicRuleData copy(LinkedList<ChatRefDynamicRule> r2, LinkedHashMap<String, RuleSelectOpt> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatRefDynamicRuleList");
        return new ChatRefDynamicRuleData(r2, r3);
    }

    public int hashCode() {
        int r0 = this.chatRefDynamicRuleList.hashCode() * 31;
        LinkedHashMap<String, RuleSelectOpt> r1 = this.employeeTypeInfos;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "ChatRefDynamicRuleData(chatRefDynamicRuleList=" + this.chatRefDynamicRuleList + ", employeeTypeInfos=" + this.employeeTypeInfos + ')';
    }

    public final LinkedList<ChatRefDynamicRule> getChatRefDynamicRuleList() {
        return this.chatRefDynamicRuleList;
    }

    public final LinkedHashMap<String, RuleSelectOpt> getEmployeeTypeInfos() {
        return this.employeeTypeInfos;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(ChatRefDynamicRuleData.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chat.ChatRefDynamicRuleData");
        ChatRefDynamicRuleData r6 = (ChatRefDynamicRuleData) r5;
        if (Intrinsics.areEqual(this.chatRefDynamicRuleList, r6.chatRefDynamicRuleList) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.employeeTypeInfos, r6.employeeTypeInfos) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setChatRefDynamicRuleList(LinkedList<ChatRefDynamicRule> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chatRefDynamicRuleList = r2;
    }

    public final void setEmployeeTypeInfos(LinkedHashMap<String, RuleSelectOpt> r1) {
        this.employeeTypeInfos = r1;
    }

    public ChatRefDynamicRuleData(LinkedList<ChatRefDynamicRule> r2, LinkedHashMap<String, RuleSelectOpt> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatRefDynamicRuleList");
        this.chatRefDynamicRuleList = r2;
        this.employeeTypeInfos = r3;
    }
}
