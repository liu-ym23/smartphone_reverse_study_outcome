package com.obric.assistant.component.clicktalk;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/obric/assistant/component/clicktalk/ChatClickTalkComponent$SvInfo;", "", "score", "", "text", "", "identity", "", "<init>", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Boolean;)V", "getScore", "()Ljava/lang/Float;", "setScore", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getIdentity", "()Ljava/lang/Boolean;", "setIdentity", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/obric/assistant/component/clicktalk/ChatClickTalkComponent$SvInfo;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatClickTalkComponent$c {
    public static final /* synthetic */ int a = 0;

    @SerializedName("is_identity")
    private Boolean identity;

    @SerializedName("sv_score")
    private Float score;

    @SerializedName("stable_text")
    private String text;

    public static final class a {
    }

    static {
    }

    public ChatClickTalkComponent$c() {
        Float r0 = Float.valueOf(0.0f);
        Boolean r1 = Boolean.FALSE;
        this.score = r0;
        this.text = "";
        this.identity = r1;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatClickTalkComponent$c) == true) goto L8;
        return false;
    L8:
        ChatClickTalkComponent$c r6 = (ChatClickTalkComponent$c) r5;
        if (Intrinsics.areEqual(this.score, r6.score) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.identity, r6.identity) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Float r0 = this.score;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.text;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.identity;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "SvInfo(score=" + this.score + ", text=" + this.text + ", identity=" + this.identity + ')';
    }

    public final Float a() {
        return this.score;
    }
}
