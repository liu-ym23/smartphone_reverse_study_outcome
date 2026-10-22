package com.bytedance.android.ec.base.api.ai.framework.model;

import android.view.View;
import com.bytedance.android.ec.core.event.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001+B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003JI\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u0006,"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem;", "", "key", "", "title", a.KEY_ORDER, "", "icon", "iconUrl", "line", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "extra", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getIcon", "()Ljava/lang/String;", "getIconUrl", "getKey", "getLine", "()I", "onClickListener", "Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem$OnClickListener;", "getOnClickListener", "()Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem$OnClickListener;", "setOnClickListener", "(Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem$OnClickListener;)V", "getOrder", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "OnClickListener", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class PanelItem {
    private Map<String, ? extends Object> extra;
    private final String icon;
    private final String iconUrl;
    private final String key;
    private final int line;
    private OnClickListener onClickListener;
    private final int order;
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem$OnClickListener;", "", "()V", "onClick", "", "view", "Landroid/view/View;", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
    public static abstract class OnClickListener {
        public OnClickListener() {
        }

        public abstract void onClick(View r1);
    }

    public static /* synthetic */ PanelItem copy$default(PanelItem r10, String r11, String r12, int r13, String r14, String r15, int r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.key;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.title;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.order;
    L11:
        int r0 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.icon;
    L14:
        String r1 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.iconUrl;
    L17:
        String r20 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.line;
    L20:
        String r21 = r11;
        return r10.copy(r21, r19, r0, r1, r20, r16);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.order;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final int component6() {
        return this.line;
    }

    public final PanelItem copy(String r10, String r11, int r12, String r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "title");
        return new PanelItem(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof PanelItem) == false) goto L18;
        PanelItem r11 = (PanelItem) r10;
        if (Intrinsics.areEqual(this.key, r11.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r11.title) == true) goto L10;
        return false;
    L10:
        if (this.order == r11.order) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r11.icon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.iconUrl, r11.iconUrl) == true) goto L16;
        return false;
    L16:
        if (this.line == r11.line) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.title;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (((r11 + r13) * 31) + this.order) * 31;
        String r15 = this.icon;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.iconUrl;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return ((r17 + r1) * 31) + this.line;
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "PanelItem(key=" + this.key + ", title=" + this.title + ", order=" + this.order + ", icon=" + this.icon + ", iconUrl=" + this.iconUrl + ", line=" + this.line + ")";
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getLine() {
        return this.line;
    }

    public final OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setExtra(Map<String, ? extends Object> r1) {
        this.extra = r1;
    }

    public final void setOnClickListener(OnClickListener r1) {
        this.onClickListener = r1;
    }

    public PanelItem(String r10, String r11, int r12, String r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "title");
        this.key = r10;
        this.title = r11;
        this.order = r12;
        this.icon = r13;
        this.iconUrl = r14;
        this.line = r15;
    }

    public /* synthetic */ PanelItem(String r10, String r11, int r12, String r13, String r14, int r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        String r19 = null;
    L11:
        if ((r16 & 32) == 0) goto L13;
        int r20 = 1;
    L14:
        this(r10, r11, r12, r18, r19, r20);
        return;
    L13:
        r20 = r15;
        goto L14
    L9:
        r19 = r14;
        goto L11
    L5:
        r18 = r13;
        goto L7
    }
}
