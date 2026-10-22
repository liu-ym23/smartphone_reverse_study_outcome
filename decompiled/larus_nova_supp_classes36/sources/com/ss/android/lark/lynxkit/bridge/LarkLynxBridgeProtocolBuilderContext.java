package com.ss.android.lark.lynxkit.bridge;

import android.content.Context;
import com.lynx.tasm.LynxViewBuilder;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolBuilderContext;", "", "context", "Landroid/content/Context;", "lynxViewBuilder", "Lcom/lynx/tasm/LynxViewBuilder;", "containerId", "", "containerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "<init>", "(Landroid/content/Context;Lcom/lynx/tasm/LynxViewBuilder;Ljava/lang/String;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;)V", "getContext", "()Landroid/content/Context;", "getLynxViewBuilder", "()Lcom/lynx/tasm/LynxViewBuilder;", "getContainerId", "()Ljava/lang/String;", "getContainerContext", "()Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "component1", "component2", "component3", "component4", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxBridgeProtocolBuilderContext {
    private final ILynxContainerContext containerContext;
    private final String containerId;
    private final Context context;
    private final LynxViewBuilder lynxViewBuilder;

    public static /* synthetic */ LarkLynxBridgeProtocolBuilderContext copy$default(LarkLynxBridgeProtocolBuilderContext r0, Context r1, LynxViewBuilder r2, String r3, ILynxContainerContext r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.context;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.lynxViewBuilder;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.containerId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.containerContext;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Context component1() {
        return this.context;
    }

    public final LynxViewBuilder component2() {
        return this.lynxViewBuilder;
    }

    public final String component3() {
        return this.containerId;
    }

    public final ILynxContainerContext component4() {
        return this.containerContext;
    }

    public final LarkLynxBridgeProtocolBuilderContext copy(Context r2, LynxViewBuilder r3, String r4, ILynxContainerContext r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lynxViewBuilder");
        Intrinsics.checkNotNullParameter(r4, "containerId");
        return new LarkLynxBridgeProtocolBuilderContext(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkLynxBridgeProtocolBuilderContext) == true) goto L8;
        return false;
    L8:
        LarkLynxBridgeProtocolBuilderContext r6 = (LarkLynxBridgeProtocolBuilderContext) r5;
        if (Intrinsics.areEqual(this.context, r6.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxViewBuilder, r6.lynxViewBuilder) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.containerId, r6.containerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.containerContext, r6.containerContext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.context.hashCode() * 31) + this.lynxViewBuilder.hashCode()) * 31) + this.containerId.hashCode()) * 31;
        ILynxContainerContext r1 = this.containerContext;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "LarkLynxBridgeProtocolBuilderContext(context=" + this.context + ", lynxViewBuilder=" + this.lynxViewBuilder + ", containerId=" + this.containerId + ", containerContext=" + this.containerContext + ')';
    }

    public final ILynxContainerContext getContainerContext() {
        return this.containerContext;
    }

    public final String getContainerId() {
        return this.containerId;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LynxViewBuilder getLynxViewBuilder() {
        return this.lynxViewBuilder;
    }

    public LarkLynxBridgeProtocolBuilderContext(Context r2, LynxViewBuilder r3, String r4, ILynxContainerContext r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lynxViewBuilder");
        Intrinsics.checkNotNullParameter(r4, "containerId");
        this.context = r2;
        this.lynxViewBuilder = r3;
        this.containerId = r4;
        this.containerContext = r5;
    }

    public /* synthetic */ LarkLynxBridgeProtocolBuilderContext(Context r1, LynxViewBuilder r2, String r3, ILynxContainerContext r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }
}
