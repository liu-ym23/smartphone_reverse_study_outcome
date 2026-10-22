package com.larus.dora.impl.guide.strategy;

import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static final /* synthetic */ int c = 0;
    public final boolean a;
    public final Lazy b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/guide/strategy/ServerStrategy$ShowBindGuideResponse;", "", "allowBindGuide", "", "<init>", "(Ljava/lang/Boolean;)V", "getAllowBindGuide", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/larus/dora/impl/guide/strategy/ServerStrategy$ShowBindGuideResponse;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("allow_bind_guide")
        private final Boolean allowBindGuide;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.allowBindGuide, ((b) r4).allowBindGuide) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Boolean r0 = this.allowBindGuide;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "ShowBindGuideResponse(allowBindGuide=" + this.allowBindGuide + ')';
        }

        public b() {
            this.allowBindGuide = null;
        }

        public final Boolean a() {
            return this.allowBindGuide;
        }
    }

    static {
    }

    public final Object a() {
        g49.d.d("ServerStrategy", "isConditionMet() start, usingA2dp=" + this.a);
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L5;
        g49.d.d("ServerStrategy", "main bot guide enabled");
        boolean r0 = true;
    L6:
        g49.d.d("ServerStrategy", "isConditionMet() end, result=" + r0);
        return Boxing.boxBoolean(r0);
    L5:
        g49.d.d("ServerStrategy", "main bot guide disabled");
        r0 = false;
        goto L6
    }

    public f() {
        this.a = true;
        this.b = LazyKt.lazy(new e());
    }
}
