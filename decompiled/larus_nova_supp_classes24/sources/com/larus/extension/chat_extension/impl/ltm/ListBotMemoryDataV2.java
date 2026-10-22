package com.larus.extension.chat_extension.impl.ltm;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/ListBotMemoryDataV2;", "", "savedMemory", "", "Lcom/larus/extension/chat_extension/impl/ltm/BotMemoryItemV2;", "<init>", "(Ljava/util/List;)V", "getSavedMemory", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ListBotMemoryDataV2 {

    @SerializedName("saved_memory")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<BotMemoryItemV2> savedMemory;

    public ListBotMemoryDataV2() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListBotMemoryDataV2 copy$default(ListBotMemoryDataV2 r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.savedMemory;
    L6:
        return r0.copy(r1);
    }

    public final List<BotMemoryItemV2> component1() {
        return this.savedMemory;
    }

    public final ListBotMemoryDataV2 copy(List<BotMemoryItemV2> r2) {
        return new ListBotMemoryDataV2(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ListBotMemoryDataV2) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.savedMemory, ((ListBotMemoryDataV2) r4).savedMemory) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<BotMemoryItemV2> r0 = this.savedMemory;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ListBotMemoryDataV2(savedMemory=" + this.savedMemory + ')';
    }

    public final List<BotMemoryItemV2> getSavedMemory() {
        return this.savedMemory;
    }

    public ListBotMemoryDataV2(List<BotMemoryItemV2> r1) {
        this.savedMemory = r1;
    }

    public /* synthetic */ ListBotMemoryDataV2(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
