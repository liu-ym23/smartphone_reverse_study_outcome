package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0010\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/settings/DoraObricOnboardingQueryTopics;", "", "topics", "", "", "answers", "pictures", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getTopics", "()Ljava/util/List;", "getAnswers", "getPictures", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricOnboardingQueryTopics {

    @SerializedName("query_answers")
    private final List<String> answers;

    @SerializedName("query_pictures")
    private final List<String> pictures;

    @SerializedName("query_topics")
    private final List<String> topics;

    public DoraObricOnboardingQueryTopics() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoraObricOnboardingQueryTopics copy$default(DoraObricOnboardingQueryTopics r0, List r1, List r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.topics;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.answers;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.pictures;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<String> component1() {
        return this.topics;
    }

    public final List<String> component2() {
        return this.answers;
    }

    public final List<String> component3() {
        return this.pictures;
    }

    public final DoraObricOnboardingQueryTopics copy(List<String> r2, List<String> r3, List<String> r4) {
        return new DoraObricOnboardingQueryTopics(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraObricOnboardingQueryTopics) == true) goto L8;
        return false;
    L8:
        DoraObricOnboardingQueryTopics r6 = (DoraObricOnboardingQueryTopics) r5;
        if (Intrinsics.areEqual(this.topics, r6.topics) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.answers, r6.answers) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pictures, r6.pictures) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.topics;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.answers;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.pictures;
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

    public String toString() {
        return "DoraObricOnboardingQueryTopics(topics=" + this.topics + ", answers=" + this.answers + ", pictures=" + this.pictures + ')';
    }

    public final List<String> getAnswers() {
        return this.answers;
    }

    public final List<String> getPictures() {
        return this.pictures;
    }

    public final List<String> getTopics() {
        return this.topics;
    }

    public DoraObricOnboardingQueryTopics(List<String> r1, List<String> r2, List<String> r3) {
        this.topics = r1;
        this.answers = r2;
        this.pictures = r3;
    }

    public /* synthetic */ DoraObricOnboardingQueryTopics(List r2, List r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
