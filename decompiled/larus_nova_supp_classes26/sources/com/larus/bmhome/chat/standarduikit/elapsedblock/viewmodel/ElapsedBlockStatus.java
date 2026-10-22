package com.larus.bmhome.chat.standarduikit.elapsedblock.viewmodel;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/elapsedblock/viewmodel/ElapsedBlockStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Folded", "Expanded", "trackValue", "", "getTrackValue", "()Ljava/lang/String;", "toContainerStatus", "Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ElapsedBlockStatus extends Enum<ElapsedBlockStatus> {
    public static final ElapsedBlockStatus Expanded = null;
    public static final ElapsedBlockStatus Folded = null;
    public static final /* synthetic */ ElapsedBlockStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ElapsedBlockStatus.values().length];
            r0[ElapsedBlockStatus.Folded.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ElapsedBlockStatus.Expanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static EnumEntries<ElapsedBlockStatus> getEntries() {
        return b;
    }

    static {
        ElapsedBlockStatus r0 = new ElapsedBlockStatus("Folded", 0);
        Folded = r0;
        ElapsedBlockStatus r1 = new ElapsedBlockStatus("Expanded", 1);
        Expanded = r1;
        ElapsedBlockStatus[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ElapsedBlockStatus[] values() {
        return (ElapsedBlockStatus[]) a.clone();
    }

    public final String getTrackValue() {
        int r0 = a.a[ordinal()];
        if (r0 != 1) goto L5;
        return "folded";
    L5:
        if (r0 != 2) goto L8;
        return "expanded";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final DeepThinkFoldStatus toContainerStatus() {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L8;
        return DeepThinkFoldStatus.CompleteExpand;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return DeepThinkFoldStatus.CompleteFold;
    }

    public static ElapsedBlockStatus valueOf(String r1) {
        return (ElapsedBlockStatus) r27.a.a(ElapsedBlockStatus.class, r1);
    }

    public ElapsedBlockStatus(String r1, int r2) {
        super(r1, r2);
    }
}
