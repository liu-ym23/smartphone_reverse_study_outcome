package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "", "itemList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuItem;", "exposeConfig", "Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;", "<init>", "(Ljava/util/List;Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;)V", "getItemList", "()Ljava/util/List;", "getExposeConfig", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DefaultReplySwitchMenuConfig {

    @SerializedName("expose_config")
    private final DefaultReplyExposedConfig exposeConfig;

    @SerializedName("item_list")
    private final List<DefaultReplySwitchMenuItem> itemList;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultReplySwitchMenuConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplySwitchMenuConfig copy$default(DefaultReplySwitchMenuConfig r0, List r1, DefaultReplyExposedConfig r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.itemList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.exposeConfig;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<DefaultReplySwitchMenuItem> component1() {
        return this.itemList;
    }

    public final DefaultReplyExposedConfig component2() {
        return this.exposeConfig;
    }

    public final DefaultReplySwitchMenuConfig copy(List<DefaultReplySwitchMenuItem> r2, DefaultReplyExposedConfig r3) {
        return new DefaultReplySwitchMenuConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultReplySwitchMenuConfig) == true) goto L8;
        return false;
    L8:
        DefaultReplySwitchMenuConfig r6 = (DefaultReplySwitchMenuConfig) r5;
        if (Intrinsics.areEqual(this.itemList, r6.itemList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exposeConfig, r6.exposeConfig) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<DefaultReplySwitchMenuItem> r0 = this.itemList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        DefaultReplyExposedConfig r4 = this.exposeConfig;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DefaultReplySwitchMenuConfig(itemList=" + this.itemList + ", exposeConfig=" + this.exposeConfig + ')';
    }

    public final DefaultReplyExposedConfig getExposeConfig() {
        return this.exposeConfig;
    }

    public final List<DefaultReplySwitchMenuItem> getItemList() {
        return this.itemList;
    }

    public DefaultReplySwitchMenuConfig(List<DefaultReplySwitchMenuItem> r1, DefaultReplyExposedConfig r2) {
        this.itemList = r1;
        this.exposeConfig = r2;
    }

    public /* synthetic */ DefaultReplySwitchMenuConfig(List r2, DefaultReplyExposedConfig r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
