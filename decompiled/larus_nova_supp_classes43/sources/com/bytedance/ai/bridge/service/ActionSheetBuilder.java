package com.bytedance.ai.bridge.service;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/ai/bridge/service/ActionSheetBuilder;", "", "context", "Landroid/content/Context;", "title", "", "subtitle", "itemColor", "", "actions", "", "Lcom/bytedance/ai/bridge/service/ActionSheetBuilderAction;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getItemColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/ai/bridge/service/ActionSheetBuilder;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionSheetBuilder {
    private final List<ActionSheetBuilderAction> actions;
    private final Context context;
    private final Integer itemColor;
    private final String subtitle;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionSheetBuilder copy$default(ActionSheetBuilder r10, Context r11, String r12, String r13, Integer r14, List r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.context;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.title;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.subtitle;
    L11:
        String r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.itemColor;
    L14:
        Integer r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.actions;
    L17:
        Context r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
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

    public final Integer component4() {
        return this.itemColor;
    }

    public final List<ActionSheetBuilderAction> component5() {
        return this.actions;
    }

    public final ActionSheetBuilder copy(Context r10, String r11, String r12, Integer r13, List<ActionSheetBuilderAction> r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r14, "actions");
        return new ActionSheetBuilder(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ActionSheetBuilder) == true) goto L8;
        return false;
    L8:
        ActionSheetBuilder r11 = (ActionSheetBuilder) r10;
        if (Intrinsics.areEqual(this.context, r11.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r11.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitle, r11.subtitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.itemColor, r11.itemColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actions, r11.actions) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.context.hashCode() * 31;
        String r1 = this.title;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.subtitle;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.itemColor;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return ((r15 + r10) * 31) + this.actions.hashCode();
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionSheetBuilder(context=" + this.context + ", title=" + this.title + ", subtitle=" + this.subtitle + ", itemColor=" + this.itemColor + ", actions=" + this.actions + ')';
    }

    public final List<ActionSheetBuilderAction> getActions() {
        return this.actions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Integer getItemColor() {
        return this.itemColor;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public ActionSheetBuilder(Context r10, String r11, String r12, Integer r13, List<ActionSheetBuilderAction> r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r14, "actions");
        this.context = r10;
        this.title = r11;
        this.subtitle = r12;
        this.itemColor = r13;
        this.actions = r14;
    }

    public /* synthetic */ ActionSheetBuilder(Context r10, String r11, String r12, Integer r13, List r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        String r17 = null;
    L7:
        if ((r15 & 4) == 0) goto L9;
        String r18 = null;
    L11:
        if ((r15 & 8) == 0) goto L13;
        Integer r19 = null;
    L14:
        this(r10, r17, r18, r19, r14);
        return;
    L13:
        r19 = r13;
        goto L14
    L9:
        r18 = r12;
        goto L11
    L5:
        r17 = r11;
        goto L7
    }
}
