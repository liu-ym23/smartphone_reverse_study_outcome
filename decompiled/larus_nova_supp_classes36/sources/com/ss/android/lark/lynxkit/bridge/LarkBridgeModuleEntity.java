package com.ss.android.lark.lynxkit.bridge;

import android.content.Context;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkBridgeModuleEntity;", "", "context", "Landroid/content/Context;", "lynxContainerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "bridgeDispatcherTag", "", "bridgeMethodGroupTag", "jsModuleTag", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getLynxContainerContext", "()Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "getBridgeDispatcherTag", "()Ljava/lang/String;", "getBridgeMethodGroupTag", "getJsModuleTag", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkBridgeModuleEntity {
    private final String bridgeDispatcherTag;
    private final String bridgeMethodGroupTag;
    private final Context context;
    private final String jsModuleTag;
    private final ILynxContainerContext lynxContainerContext;

    public static /* synthetic */ LarkBridgeModuleEntity copy$default(LarkBridgeModuleEntity r3, Context r4, ILynxContainerContext r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.context;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.lynxContainerContext;
    L8:
        ILynxContainerContext r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.bridgeDispatcherTag;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.bridgeMethodGroupTag;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.jsModuleTag;
    L17:
        Context r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Context component1() {
        return this.context;
    }

    public final ILynxContainerContext component2() {
        return this.lynxContainerContext;
    }

    public final String component3() {
        return this.bridgeDispatcherTag;
    }

    public final String component4() {
        return this.bridgeMethodGroupTag;
    }

    public final String component5() {
        return this.jsModuleTag;
    }

    public final LarkBridgeModuleEntity copy(Context r8, ILynxContainerContext r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        return new LarkBridgeModuleEntity(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkBridgeModuleEntity) == true) goto L8;
        return false;
    L8:
        LarkBridgeModuleEntity r6 = (LarkBridgeModuleEntity) r5;
        if (Intrinsics.areEqual(this.context, r6.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxContainerContext, r6.lynxContainerContext) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bridgeDispatcherTag, r6.bridgeDispatcherTag) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bridgeMethodGroupTag, r6.bridgeMethodGroupTag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.jsModuleTag, r6.jsModuleTag) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.context.hashCode() * 31;
        ILynxContainerContext r1 = this.lynxContainerContext;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.bridgeDispatcherTag;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.bridgeMethodGroupTag;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.jsModuleTag;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkBridgeModuleEntity(context=" + this.context + ", lynxContainerContext=" + this.lynxContainerContext + ", bridgeDispatcherTag=" + this.bridgeDispatcherTag + ", bridgeMethodGroupTag=" + this.bridgeMethodGroupTag + ", jsModuleTag=" + this.jsModuleTag + ')';
    }

    public final String getBridgeDispatcherTag() {
        return this.bridgeDispatcherTag;
    }

    public final String getBridgeMethodGroupTag() {
        return this.bridgeMethodGroupTag;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getJsModuleTag() {
        return this.jsModuleTag;
    }

    public final ILynxContainerContext getLynxContainerContext() {
        return this.lynxContainerContext;
    }

    public LarkBridgeModuleEntity(Context r2, ILynxContainerContext r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.lynxContainerContext = r3;
        this.bridgeDispatcherTag = r4;
        this.bridgeMethodGroupTag = r5;
        this.jsModuleTag = r6;
    }

    public /* synthetic */ LarkBridgeModuleEntity(Context r8, ILynxContainerContext r9, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        ILynxContainerContext r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        String r6 = null;
    L18:
        this(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
