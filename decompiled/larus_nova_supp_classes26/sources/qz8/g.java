package qz8;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/commercecredit/impl/entity/CreditInfoAndTasks;", "", "creditInfo", "Lcom/larus/commercecredit/impl/entity/CreditInfo;", "optionalTasks", "", "Lcom/larus/commercecredit/impl/entity/CreditTask;", "creditRuleLink", "Lcom/larus/commercecredit/impl/entity/CreditRuleLink;", "<init>", "(Lcom/larus/commercecredit/impl/entity/CreditInfo;Ljava/util/List;Lcom/larus/commercecredit/impl/entity/CreditRuleLink;)V", "getCreditInfo", "()Lcom/larus/commercecredit/impl/entity/CreditInfo;", "getOptionalTasks", "()Ljava/util/List;", "getCreditRuleLink", "()Lcom/larus/commercecredit/impl/entity/CreditRuleLink;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("credit_info")
    private final f creditInfo;

    @SerializedName("credit_rule_link")
    private final i creditRuleLink;

    @SerializedName("optional_tasks")
    private final List<j> optionalTasks;

    public g() {
        this(null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.creditInfo, r6.creditInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.optionalTasks, r6.optionalTasks) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creditRuleLink, r6.creditRuleLink) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        f r0 = this.creditInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<j> r4 = this.optionalTasks;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        i r7 = this.creditRuleLink;
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
        return "CreditInfoAndTasks(creditInfo=" + this.creditInfo + ", optionalTasks=" + this.optionalTasks + ", creditRuleLink=" + this.creditRuleLink + ')';
    }

    public final f a() {
        return this.creditInfo;
    }

    public final i b() {
        return this.creditRuleLink;
    }

    public final List<j> c() {
        return this.optionalTasks;
    }

    public g(f r1, List<j> r2, i r3) {
        this.creditInfo = r1;
        this.optionalTasks = r2;
        this.creditRuleLink = r3;
    }
}
