package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003JU\u0010\"\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogShowOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "actions", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAction;", "Lkotlin/collections/ArrayList;", "alignActionsX", BuildConfig.FLAVOR, "content", "id", "maskClosable", BuildConfig.FLAVOR, "title", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getActions", "()Ljava/util/ArrayList;", "getAlignActionsX", "()Ljava/lang/String;", "getContent", "getId", "getMaskClosable", "()Z", "getTitle", "alignActions", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAlignActions;", "getAlignActions", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAlignActions;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Internal$ConfirmDialogShowOptions implements NonProguard {
    private final ArrayList<IWidget$Internal$ConfirmDialogAction> actions;
    private final String alignActionsX;
    private final String content;
    private final String id;
    private final boolean maskClosable;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IWidget$Internal$ConfirmDialogShowOptions copy$default(IWidget$Internal$ConfirmDialogShowOptions r4, ArrayList r5, String r6, String r7, String r8, boolean r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.actions;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.alignActionsX;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.content;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.id;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.maskClosable;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.title;
    L20:
        ArrayList r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final ArrayList<IWidget$Internal$ConfirmDialogAction> component1() {
        return this.actions;
    }

    public final String component2() {
        return this.alignActionsX;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.id;
    }

    public final boolean component5() {
        return this.maskClosable;
    }

    public final String component6() {
        return this.title;
    }

    public final IWidget$Internal$ConfirmDialogShowOptions copy(ArrayList<IWidget$Internal$ConfirmDialogAction> r9, @JSONField(name = "alignActions") String r10, String r11, String r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "actions");
        Intrinsics.checkNotNullParameter(r10, "alignActionsX");
        Intrinsics.checkNotNullParameter(r11, "content");
        Intrinsics.checkNotNullParameter(r12, "id");
        Intrinsics.checkNotNullParameter(r14, "title");
        return new IWidget$Internal$ConfirmDialogShowOptions(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IWidget$Internal$ConfirmDialogShowOptions) == true) goto L8;
        return false;
    L8:
        IWidget$Internal$ConfirmDialogShowOptions r6 = (IWidget$Internal$ConfirmDialogShowOptions) r5;
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.alignActionsX, r6.alignActionsX) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L21;
        return false;
    L21:
        if (this.maskClosable == r6.maskClosable) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.actions.hashCode() * 31) + this.alignActionsX.hashCode()) * 31) + this.content.hashCode()) * 31) + this.id.hashCode()) * 31;
        if (this.maskClosable == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.title.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "ConfirmDialogShowOptions(actions=" + this.actions + ", alignActionsX=" + this.alignActionsX + ", content=" + this.content + ", id=" + this.id + ", maskClosable=" + this.maskClosable + ", title=" + this.title + ')';
    }

    public final IWidget$Internal$ConfirmDialogAlignActions getAlignActions() {
        IWidget$Internal$ConfirmDialogAlignActions.a r0 = IWidget$Internal$ConfirmDialogAlignActions.Companion;
        String r1 = this.alignActionsX;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "value");
        IWidget$Internal$ConfirmDialogAlignActions[] r2 = IWidget$Internal$ConfirmDialogAlignActions.values();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        IWidget$Internal$ConfirmDialogAlignActions r5 = r2[r4];
        if (Intrinsics.areEqual(r5.getValue(), r1) == true) goto L9;
        r4 = r4 + 1;
    L9:
        if (r5 == null) goto L12;
        return r5;
    L12:
        return IWidget$Internal$ConfirmDialogAlignActions.Horizontal;
    L8:
        r5 = null;
        goto L9
    }

    public final ArrayList<IWidget$Internal$ConfirmDialogAction> getActions() {
        return this.actions;
    }

    public final String getAlignActionsX() {
        return this.alignActionsX;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getMaskClosable() {
        return this.maskClosable;
    }

    public final String getTitle() {
        return this.title;
    }

    public IWidget$Internal$ConfirmDialogShowOptions(ArrayList<IWidget$Internal$ConfirmDialogAction> r2, @JSONField(name = "alignActions") String r3, String r4, String r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "actions");
        Intrinsics.checkNotNullParameter(r3, "alignActionsX");
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r7, "title");
        this.actions = r2;
        this.alignActionsX = r3;
        this.content = r4;
        this.id = r5;
        this.maskClosable = r6;
        this.title = r7;
    }

    public /* synthetic */ IWidget$Internal$ConfirmDialogShowOptions(ArrayList r8, String r9, String r10, String r11, boolean r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = "horizontal";
    L5:
        String r2 = r9;
        if ((r14 & 16) == 0) goto L8;
        boolean r5 = true;
    L9:
        this(r8, r2, r10, r11, r5, r13);
        return;
    L8:
        r5 = r12;
        goto L9
    }
}
