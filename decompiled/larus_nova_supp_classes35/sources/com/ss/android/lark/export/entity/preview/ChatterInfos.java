package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ChatterInfos;", "Ljava/io/Serializable;", "chatterInfos", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getChatterInfos", "()Ljava/util/ArrayList;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterInfos implements Serializable {
    private final ArrayList<ChatterPreviewChatterInfo> chatterInfos;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatterInfos copy$default(ChatterInfos r0, ArrayList r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.chatterInfos;
    L6:
        return r0.copy(r1);
    }

    public final ArrayList<ChatterPreviewChatterInfo> component1() {
        return this.chatterInfos;
    }

    public final ChatterInfos copy(ArrayList<ChatterPreviewChatterInfo> r2) {
        return new ChatterInfos(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ChatterInfos) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.chatterInfos, ((ChatterInfos) r4).chatterInfos) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        ArrayList<ChatterPreviewChatterInfo> r0 = this.chatterInfos;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ChatterInfos(chatterInfos=" + this.chatterInfos + ')';
    }

    public final ArrayList<ChatterPreviewChatterInfo> getChatterInfos() {
        return this.chatterInfos;
    }

    public ChatterInfos(ArrayList<ChatterPreviewChatterInfo> r1) {
        this.chatterInfos = r1;
    }
}
