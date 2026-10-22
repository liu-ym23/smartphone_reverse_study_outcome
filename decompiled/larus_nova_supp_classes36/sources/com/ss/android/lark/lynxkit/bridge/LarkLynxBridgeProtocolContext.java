package com.ss.android.lark.lynxkit.bridge;

import android.content.Context;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolContext;", "", "context", "Landroid/content/Context;", "lynxView", "Lcom/lynx/tasm/LynxView;", "containerId", "", "builderHandle", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderHandle;", "containerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "<init>", "(Landroid/content/Context;Lcom/lynx/tasm/LynxView;Ljava/lang/String;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderHandle;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;)V", "getContext", "()Landroid/content/Context;", "getLynxView", "()Lcom/lynx/tasm/LynxView;", "getContainerId", "()Ljava/lang/String;", "getBuilderHandle", "()Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderHandle;", "getContainerContext", "()Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxBridgeProtocolContext {
    private final ILarkLynxBridgeProtocolBuilderHandle builderHandle;
    private final ILynxContainerContext containerContext;
    private final String containerId;
    private final Context context;
    private final LynxView lynxView;

    public static /* synthetic */ LarkLynxBridgeProtocolContext copy$default(LarkLynxBridgeProtocolContext r3, Context r4, LynxView r5, String r6, ILarkLynxBridgeProtocolBuilderHandle r7, ILynxContainerContext r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.context;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.lynxView;
    L8:
        LynxView r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.containerId;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.builderHandle;
    L14:
        ILarkLynxBridgeProtocolBuilderHandle r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.containerContext;
    L17:
        Context r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Context component1() {
        return this.context;
    }

    public final LynxView component2() {
        return this.lynxView;
    }

    public final String component3() {
        return this.containerId;
    }

    public final ILarkLynxBridgeProtocolBuilderHandle component4() {
        return this.builderHandle;
    }

    public final ILynxContainerContext component5() {
        return this.containerContext;
    }

    public final LarkLynxBridgeProtocolContext copy(Context r8, LynxView r9, String r10, ILarkLynxBridgeProtocolBuilderHandle r11, ILynxContainerContext r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "containerId");
        return new LarkLynxBridgeProtocolContext(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkLynxBridgeProtocolContext) == true) goto L8;
        return false;
    L8:
        LarkLynxBridgeProtocolContext r6 = (LarkLynxBridgeProtocolContext) r5;
        if (Intrinsics.areEqual(this.context, r6.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxView, r6.lynxView) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.containerId, r6.containerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.builderHandle, r6.builderHandle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.containerContext, r6.containerContext) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.context.hashCode() * 31) + this.lynxView.hashCode()) * 31) + this.containerId.hashCode()) * 31;
        ILarkLynxBridgeProtocolBuilderHandle r1 = this.builderHandle;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ILynxContainerContext r5 = this.containerContext;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkLynxBridgeProtocolContext(context=" + this.context + ", lynxView=" + this.lynxView + ", containerId=" + this.containerId + ", builderHandle=" + this.builderHandle + ", containerContext=" + this.containerContext + ')';
    }

    public final ILarkLynxBridgeProtocolBuilderHandle getBuilderHandle() {
        return this.builderHandle;
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

    public final LynxView getLynxView() {
        return this.lynxView;
    }

    public LarkLynxBridgeProtocolContext(Context r2, LynxView r3, String r4, ILarkLynxBridgeProtocolBuilderHandle r5, ILynxContainerContext r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r4, "containerId");
        this.context = r2;
        this.lynxView = r3;
        this.containerId = r4;
        this.builderHandle = r5;
        this.containerContext = r6;
    }

    public /* synthetic */ LarkLynxBridgeProtocolContext(Context r8, LynxView r9, String r10, ILarkLynxBridgeProtocolBuilderHandle r11, ILynxContainerContext r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        ILarkLynxBridgeProtocolBuilderHandle r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        ILynxContainerContext r6 = null;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
