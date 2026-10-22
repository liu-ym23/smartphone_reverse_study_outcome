package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.d1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuData;", "", "itemList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItem;", "exposeConfig", "Lcom/larus/bmhome/actionbar/model/ExposedConfig;", "<init>", "(Ljava/util/List;Lcom/larus/bmhome/actionbar/model/ExposedConfig;)V", "getItemList", "()Ljava/util/List;", "getExposeConfig", "()Lcom/larus/bmhome/actionbar/model/ExposedConfig;", "setExposeConfig", "(Lcom/larus/bmhome/actionbar/model/ExposedConfig;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DefaultReplyMenuData {

    @SerializedName("expose_config")
    private d1 exposeConfig;

    @SerializedName("item_list")
    private final List<DefaultReplyMenuItem> itemList;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultReplyMenuData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplyMenuData copy$default(DefaultReplyMenuData r0, List r1, d1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.itemList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.exposeConfig;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<DefaultReplyMenuItem> component1() {
        return this.itemList;
    }

    public final d1 component2() {
        return this.exposeConfig;
    }

    public final DefaultReplyMenuData copy(List<DefaultReplyMenuItem> r2, d1 r3) {
        return new DefaultReplyMenuData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultReplyMenuData) == true) goto L8;
        return false;
    L8:
        DefaultReplyMenuData r6 = (DefaultReplyMenuData) r5;
        if (Intrinsics.areEqual(this.itemList, r6.itemList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exposeConfig, r6.exposeConfig) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<DefaultReplyMenuItem> r0 = this.itemList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        d1 r4 = this.exposeConfig;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DefaultReplyMenuData(itemList=" + this.itemList + ", exposeConfig=" + this.exposeConfig + ')';
    }

    public final d1 getExposeConfig() {
        return this.exposeConfig;
    }

    public final List<DefaultReplyMenuItem> getItemList() {
        return this.itemList;
    }

    public final void setExposeConfig(d1 r1) {
        this.exposeConfig = r1;
    }

    public DefaultReplyMenuData(List<DefaultReplyMenuItem> r1, d1 r2) {
        this.itemList = r1;
        this.exposeConfig = r2;
    }

    public /* synthetic */ DefaultReplyMenuData(List r2, d1 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
