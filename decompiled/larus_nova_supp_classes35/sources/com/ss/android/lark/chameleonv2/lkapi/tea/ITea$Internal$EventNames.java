package com.ss.android.lark.chameleonv2.lkapi.tea;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/tea/ITea$Internal$EventNames;", "Lcom/bytedance/ee/util/io/NonProguard;", "value", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getValue", "()Ljava/util/ArrayList;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITea$Internal$EventNames implements NonProguard {
    private final ArrayList<String> value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ITea$Internal$EventNames copy$default(ITea$Internal$EventNames r0, ArrayList r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        return r0.copy(r1);
    }

    public final ArrayList<String> component1() {
        return this.value;
    }

    public final ITea$Internal$EventNames copy(ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        return new ITea$Internal$EventNames(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ITea$Internal$EventNames) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.value, ((ITea$Internal$EventNames) r4).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "EventNames(value=" + this.value + ')';
    }

    public final ArrayList<String> getValue() {
        return this.value;
    }

    public ITea$Internal$EventNames(ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.value = r2;
    }
}
