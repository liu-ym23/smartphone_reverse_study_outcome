package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015JL\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;", "", "modeList", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchModeConfig;", "modelList", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "defaultSelectModeMap", "", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMemory;", "useModeModelList", "", "<init>", "(Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchModeConfig;Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;Ljava/util/Map;Ljava/lang/Boolean;)V", "getModeList", "()Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchModeConfig;", "getModelList", "()Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "getDefaultSelectModeMap", "()Ljava/util/Map;", "getUseModeModelList", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchModeConfig;Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DefaultReplyMenuConfigV2 {

    @SerializedName("default_select_mode_map")
    private final Map<String, DefaultReplySwitchMemory> defaultSelectModeMap;

    @SerializedName("mode_list")
    private final DefaultReplySwitchModeConfig modeList;

    @SerializedName("model_list")
    private final DefaultReplySwitchMenuConfig modelList;

    @SerializedName("use_mode_model_list")
    private final Boolean useModeModelList;

    public DefaultReplyMenuConfigV2() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplyMenuConfigV2 copy$default(DefaultReplyMenuConfigV2 r0, DefaultReplySwitchModeConfig r1, DefaultReplySwitchMenuConfig r2, Map r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.modeList;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.modelList;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.defaultSelectModeMap;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.useModeModelList;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final DefaultReplySwitchModeConfig component1() {
        return this.modeList;
    }

    public final DefaultReplySwitchMenuConfig component2() {
        return this.modelList;
    }

    public final Map<String, DefaultReplySwitchMemory> component3() {
        return this.defaultSelectModeMap;
    }

    public final Boolean component4() {
        return this.useModeModelList;
    }

    public final DefaultReplyMenuConfigV2 copy(DefaultReplySwitchModeConfig r2, DefaultReplySwitchMenuConfig r3, Map<String, DefaultReplySwitchMemory> r4, Boolean r5) {
        return new DefaultReplyMenuConfigV2(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultReplyMenuConfigV2) == true) goto L8;
        return false;
    L8:
        DefaultReplyMenuConfigV2 r6 = (DefaultReplyMenuConfigV2) r5;
        if (Intrinsics.areEqual(this.modeList, r6.modeList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.modelList, r6.modelList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultSelectModeMap, r6.defaultSelectModeMap) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.useModeModelList, r6.useModeModelList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        DefaultReplySwitchModeConfig r0 = this.modeList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        DefaultReplySwitchMenuConfig r4 = this.modelList;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, DefaultReplySwitchMemory> r7 = this.defaultSelectModeMap;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.useModeModelList;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DefaultReplyMenuConfigV2(modeList=" + this.modeList + ", modelList=" + this.modelList + ", defaultSelectModeMap=" + this.defaultSelectModeMap + ", useModeModelList=" + this.useModeModelList + ')';
    }

    public final Map<String, DefaultReplySwitchMemory> getDefaultSelectModeMap() {
        return this.defaultSelectModeMap;
    }

    public final DefaultReplySwitchModeConfig getModeList() {
        return this.modeList;
    }

    public final DefaultReplySwitchMenuConfig getModelList() {
        return this.modelList;
    }

    public final Boolean getUseModeModelList() {
        return this.useModeModelList;
    }

    public DefaultReplyMenuConfigV2(DefaultReplySwitchModeConfig r1, DefaultReplySwitchMenuConfig r2, Map<String, DefaultReplySwitchMemory> r3, Boolean r4) {
        this.modeList = r1;
        this.modelList = r2;
        this.defaultSelectModeMap = r3;
        this.useModeModelList = r4;
    }

    public /* synthetic */ DefaultReplyMenuConfigV2(DefaultReplySwitchModeConfig r2, DefaultReplySwitchMenuConfig r3, Map r4, Boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
