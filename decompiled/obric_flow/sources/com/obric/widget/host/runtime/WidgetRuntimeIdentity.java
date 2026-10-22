package com.obric.widget.host.runtime;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeIdentity;", "", "hostId", "", "<init>", "(Ljava/lang/String;)V", "getHostId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRuntimeIdentity {
    public static final Companion Companion = null;
    private final String hostId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeIdentity$Companion;", "", "<init>", "()V", "normalize", "Lcom/obric/widget/host/runtime/WidgetRuntimeIdentity;", "hostId", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetRuntimeClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetRuntimeClient.kt\ncom/obric/widget/host/runtime/WidgetRuntimeIdentity$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,732:1\n1#2:733\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final WidgetRuntimeIdentity normalize(String r5) {
            Intrinsics.checkNotNullParameter(r5, "hostId");
            if (StringsKt.isBlank(r5) == false) goto L6;
            r5 = "launcher";
        L6:
            return new WidgetRuntimeIdentity(r5);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetRuntimeIdentity(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        this.hostId = r5;
    }

    public static /* synthetic */ WidgetRuntimeIdentity copy$default(WidgetRuntimeIdentity r5, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.hostId;
    L6:
        return r5.copy(r10);
    }

    public final String component1() {
        return this.hostId;
    }

    public final WidgetRuntimeIdentity copy(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        return new WidgetRuntimeIdentity(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetRuntimeIdentity) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.hostId, ((WidgetRuntimeIdentity) r5).hostId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String getHostId() {
        return this.hostId;
    }

    public int hashCode() {
        return this.hostId.hashCode();
    }

    public String toString() {
        return j0.k("WidgetRuntimeIdentity(hostId=", this.hostId, ")");
    }
}
