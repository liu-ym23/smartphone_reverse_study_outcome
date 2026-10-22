package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.constraintlayout.motion.widget.a;
import cn.nubia.neopush.commons.Constant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ActionSheetBuilder;", "", "context", "Landroid/content/Context;", Constant.TITLE, "", "subtitle", "actions", "", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ActionSheetBuilderAction;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "getContext", "()Landroid/content/Context;", "getSubtitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ActionSheetBuilder {
    private final List<ActionSheetBuilderAction> actions;
    private final Context context;
    private final String subtitle;
    private final String title;

    public ActionSheetBuilder(Context r5, String r10, String r11, List<ActionSheetBuilderAction> r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r12, "actions");
        this.context = r5;
        this.title = r10;
        this.subtitle = r11;
        this.actions = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionSheetBuilder copy$default(ActionSheetBuilder r5, Context r10, String r11, String r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.context;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.title;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.subtitle;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.actions;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final Context component1() {
        return this.context;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final List<ActionSheetBuilderAction> component4() {
        return this.actions;
    }

    public final ActionSheetBuilder copy(Context r5, String r10, String r11, List<ActionSheetBuilderAction> r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r12, "actions");
        return new ActionSheetBuilder(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActionSheetBuilder) == true) goto L8;
        return false;
    L8:
        ActionSheetBuilder r10 = (ActionSheetBuilder) r5;
        if (Intrinsics.areEqual(this.context, r10.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitle, r10.subtitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actions, r10.actions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final List<ActionSheetBuilderAction> getActions() {
        return this.actions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int r5 = this.context.hashCode() * 31;
        String r10 = this.title;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.subtitle;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return this.actions.hashCode() + ((r13 + r11) * 31);
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ActionSheetBuilder(context=");
        r5.append(this.context);
        r5.append(", title=");
        r5.append(this.title);
        r5.append(", subtitle=");
        r5.append(this.subtitle);
        r5.append(", actions=");
        return a.v(r5, this.actions, ')');
    }

    public /* synthetic */ ActionSheetBuilder(Context r5, String r10, String r11, List r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r11 = null;
    L8:
        this(r5, r10, r11, r12);
    }
}
