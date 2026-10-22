package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.entity.message.CotStatus;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J%\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000eHÆ\u0003Jg\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000eHÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/ss/android/lark/chat/cot/CotViewModel;", "Ljava/io/Serializable;", "cotId", BuildConfig.FLAVOR, "blocks", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/cot/CotViewBlock;", "Lkotlin/collections/ArrayList;", "overallStatus", "Lcom/ss/android/lark/chat/entity/message/CotStatus;", "violated", BuildConfig.FLAVOR, "runStatusText", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Lcom/ss/android/lark/chat/entity/message/CotStatus;ZLjava/util/HashMap;)V", "getCotId", "()Ljava/lang/String;", "getBlocks", "()Ljava/util/ArrayList;", "getOverallStatus", "()Lcom/ss/android/lark/chat/entity/message/CotStatus;", "getViolated", "()Z", "getRunStatusText", "()Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotViewModel implements Serializable {
    private final ArrayList<CotViewBlock> blocks;
    private final String cotId;
    private final CotStatus overallStatus;
    private final HashMap<String, String> runStatusText;
    private final boolean violated;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CotViewModel copy$default(CotViewModel r3, String r4, ArrayList r5, CotStatus r6, boolean r7, HashMap r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.cotId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.blocks;
    L8:
        ArrayList r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.overallStatus;
    L11:
        CotStatus r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.violated;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.runStatusText;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.cotId;
    }

    public final ArrayList<CotViewBlock> component2() {
        return this.blocks;
    }

    public final CotStatus component3() {
        return this.overallStatus;
    }

    public final boolean component4() {
        return this.violated;
    }

    public final HashMap<String, String> component5() {
        return this.runStatusText;
    }

    public final CotViewModel copy(String r8, ArrayList<CotViewBlock> r9, CotStatus r10, boolean r11, HashMap<String, String> r12) {
        Intrinsics.checkNotNullParameter(r8, "cotId");
        Intrinsics.checkNotNullParameter(r9, "blocks");
        Intrinsics.checkNotNullParameter(r10, "overallStatus");
        Intrinsics.checkNotNullParameter(r12, "runStatusText");
        return new CotViewModel(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CotViewModel) == true) goto L8;
        return false;
    L8:
        CotViewModel r6 = (CotViewModel) r5;
        if (Intrinsics.areEqual(this.cotId, r6.cotId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blocks, r6.blocks) == true) goto L15;
        return false;
    L15:
        if (this.overallStatus == r6.overallStatus) goto L18;
        return false;
    L18:
        if (this.violated == r6.violated) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.runStatusText, r6.runStatusText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.cotId.hashCode() * 31) + this.blocks.hashCode()) * 31) + this.overallStatus.hashCode()) * 31;
        if (this.violated == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.runStatusText.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "CotViewModel(cotId=" + this.cotId + ", blocks=" + this.blocks + ", overallStatus=" + this.overallStatus + ", violated=" + this.violated + ", runStatusText=" + this.runStatusText + ')';
    }

    public final ArrayList<CotViewBlock> getBlocks() {
        return this.blocks;
    }

    public final String getCotId() {
        return this.cotId;
    }

    public final CotStatus getOverallStatus() {
        return this.overallStatus;
    }

    public final HashMap<String, String> getRunStatusText() {
        return this.runStatusText;
    }

    public final boolean getViolated() {
        return this.violated;
    }

    public CotViewModel(String r2, ArrayList<CotViewBlock> r3, CotStatus r4, boolean r5, HashMap<String, String> r6) {
        Intrinsics.checkNotNullParameter(r2, "cotId");
        Intrinsics.checkNotNullParameter(r3, "blocks");
        Intrinsics.checkNotNullParameter(r4, "overallStatus");
        Intrinsics.checkNotNullParameter(r6, "runStatusText");
        this.cotId = r2;
        this.blocks = r3;
        this.overallStatus = r4;
        this.violated = r5;
        this.runStatusText = r6;
    }

    public /* synthetic */ CotViewModel(String r7, ArrayList r8, CotStatus r9, boolean r10, HashMap r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r12 & 16) == 0) goto L9;
        r11 = new HashMap();
    L9:
        this(r7, r8, r9, r4, r11);
        return;
    L5:
        r4 = r10;
        goto L7
    }
}
