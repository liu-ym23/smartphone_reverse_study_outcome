package com.larus.bmhome.view.resourcebar.bean;

import android.view.ViewGroup;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010BÕ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u008d\u0001\b\u0002\u0010\t\u001a\u0086\u0001\u0012\u0004\u0012\u00020\u0007\u00128\u00126\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bj\u0002`\u00120\njB\u0012\u0004\u0012\u00020\u0007\u00128\u00126\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bj\u0002`\u0012`\u0013\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u008e\u0001\u0010)\u001a\u0086\u0001\u0012\u0004\u0012\u00020\u0007\u00128\u00126\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bj\u0002`\u00120\njB\u0012\u0004\u0012\u00020\u0007\u00128\u00126\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bj\u0002`\u0012`\u0013HÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015HÆ\u0003J×\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u008d\u0001\b\u0002\u0010\t\u001a\u0086\u0001\u0012\u0004\u0012\u00020\u0007\u00128\u00126\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bj\u0002`\u00120\njB\u0012\u0004\u0012\u00020\u0007\u00128\u00126\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bj\u0002`\u0012`\u00132\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015HÆ\u0001J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\t\u0010/\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0096\u0001\u0010\t\u001a\u0086\u0001\u0012\u0004\u0012\u00020\u0007\u00128\u00126\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bj\u0002`\u00120\njB\u0012\u0004\u0012\u00020\u0007\u00128\u00126\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bj\u0002`\u0012`\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00061"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "Ljava/io/Serializable;", "mode", "Lcom/larus/bmhome/view/resourcebar/bean/Mode;", "showAddItem", "", "marginStart", "", "marginEnd", "customRender", "Ljava/util/HashMap;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "config", "Landroid/view/ViewGroup;", "parent", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/bean/CustomResourceViewHolderBuilder;", "Lkotlin/collections/HashMap;", "ext", "", "", "", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/Mode;ZIILjava/util/HashMap;Ljava/util/Map;)V", "getMode", "()Lcom/larus/bmhome/view/resourcebar/bean/Mode;", "getShowAddItem", "()Z", "getMarginStart", "()I", "getMarginEnd", "getCustomRender", "()Ljava/util/HashMap;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceBarConfig implements Serializable {
    public static final a Companion = null;
    public static final String EXT_KEY_MESSAGE = "key_message";
    private final HashMap<Integer, Function2<ResourceBarConfig, ViewGroup, BaseResourceViewHolder>> customRender;
    private final Map<String, Object> ext;
    private final int marginEnd;
    private final int marginStart;
    private final Mode mode;
    private final boolean showAddItem;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ResourceBarConfig() {
        this(null, false, 0, 0, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceBarConfig copy$default(ResourceBarConfig r4, Mode r5, boolean r6, int r7, int r8, HashMap r9, Map r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.mode;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.showAddItem;
    L8:
        boolean r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.marginStart;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.marginEnd;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.customRender;
    L17:
        HashMap r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.ext;
    L20:
        Mode r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Mode component1() {
        return this.mode;
    }

    public final boolean component2() {
        return this.showAddItem;
    }

    public final int component3() {
        return this.marginStart;
    }

    public final int component4() {
        return this.marginEnd;
    }

    public final HashMap<Integer, Function2<ResourceBarConfig, ViewGroup, BaseResourceViewHolder>> component5() {
        return this.customRender;
    }

    public final Map<String, Object> component6() {
        return this.ext;
    }

    public final ResourceBarConfig copy(Mode r9, boolean r10, int r11, int r12, HashMap<Integer, Function2<ResourceBarConfig, ViewGroup, BaseResourceViewHolder>> r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r9, "mode");
        Intrinsics.checkNotNullParameter(r13, "customRender");
        Intrinsics.checkNotNullParameter(r14, "ext");
        return new ResourceBarConfig(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceBarConfig) == true) goto L8;
        return false;
    L8:
        ResourceBarConfig r6 = (ResourceBarConfig) r5;
        if (this.mode == r6.mode) goto L12;
        return false;
    L12:
        if (this.showAddItem == r6.showAddItem) goto L15;
        return false;
    L15:
        if (this.marginStart == r6.marginStart) goto L18;
        return false;
    L18:
        if (this.marginEnd == r6.marginEnd) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.customRender, r6.customRender) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.mode.hashCode() * 31;
        if (this.showAddItem == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((((((r0 + r1) * 31) + this.marginStart) * 31) + this.marginEnd) * 31) + this.customRender.hashCode()) * 31) + this.ext.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "ResourceBarConfig(mode=" + this.mode + ", showAddItem=" + this.showAddItem + ", marginStart=" + this.marginStart + ", marginEnd=" + this.marginEnd + ", customRender=" + this.customRender + ", ext=" + this.ext + ')';
    }

    public final HashMap<Integer, Function2<ResourceBarConfig, ViewGroup, BaseResourceViewHolder>> getCustomRender() {
        return this.customRender;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final int getMarginEnd() {
        return this.marginEnd;
    }

    public final int getMarginStart() {
        return this.marginStart;
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final boolean getShowAddItem() {
        return this.showAddItem;
    }

    public ResourceBarConfig(Mode r2, boolean r3, int r4, int r5, HashMap<Integer, Function2<ResourceBarConfig, ViewGroup, BaseResourceViewHolder>> r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r6, "customRender");
        Intrinsics.checkNotNullParameter(r7, "ext");
        this.mode = r2;
        this.showAddItem = r3;
        this.marginStart = r4;
        this.marginEnd = r5;
        this.customRender = r6;
        this.ext = r7;
    }

    public /* synthetic */ ResourceBarConfig(Mode r5, boolean r6, int r7, int r8, HashMap r9, Map r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = Mode.SHOW;
    L6:
        if ((r11 & 2) == 0) goto L8;
        boolean r13 = true;
    L10:
        if ((r11 & 4) == 0) goto L12;
        r7 = i5.h();
    L12:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L15;
        r8 = i5.h();
    L15:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L18;
        r9 = new HashMap();
    L18:
        HashMap r2 = r9;
        if ((r11 & 32) == 0) goto L21;
        r10 = MapsKt.emptyMap();
    L21:
        Mode r14 = r5;
        boolean r15 = r13;
        this(r14, r15, r0, r1, r2, r10);
        return;
    L8:
        r13 = r6;
        goto L10
    }
}
