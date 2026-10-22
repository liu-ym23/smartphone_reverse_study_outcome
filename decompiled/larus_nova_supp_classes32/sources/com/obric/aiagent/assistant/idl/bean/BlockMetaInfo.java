package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/BlockMetaInfo;", "Ljava/io/Serializable;", "type", NameKeys.UnloadStrategy_No_Strategy, "info", NameKeys.UnloadStrategy_No_Strategy, "infoV2", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getRealInfo", "component1", "component2", "component3", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockMetaInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("tag_info")
    public final String info;

    @SerializedName("info")
    public final String infoV2;

    @SerializedName("type")
    public final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BlockMetaInfo() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ BlockMetaInfo copy$default(BlockMetaInfo r0, int r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.info;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.infoV2;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.info;
    }

    public final String component3() {
        return this.infoV2;
    }

    public final BlockMetaInfo copy(int r2, String r3, String r4) {
        return new BlockMetaInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BlockMetaInfo) == true) goto L8;
        return false;
    L8:
        BlockMetaInfo r6 = (BlockMetaInfo) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.info, r6.info) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.infoV2, r6.infoV2) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.type * 31;
        String r1 = this.info;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.infoV2;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockMetaInfo(type=" + this.type + ", info=" + this.info + ", infoV2=" + this.infoV2 + ')';
    }

    public final String getRealInfo() {
        String r0 = this.infoV2;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.info;
    }

    public BlockMetaInfo(int r1, String r2, String r3) {
        this.type = r1;
        this.info = r2;
        this.infoV2 = r3;
    }

    public /* synthetic */ BlockMetaInfo(int r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
