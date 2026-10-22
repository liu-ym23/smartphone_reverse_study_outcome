package com.obric.aivoice.sdk.data;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/aivoice/sdk/data/ModelStatus;", NameKeys.UnloadStrategy_No_Strategy, "index", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;II)V", "getIndex", "()I", "NOT_FOUND", "NEED_DOWNLOAD", "DOWNLOADING", "DOWNLOADED", "LOADED_IN_MEMORY", "INTERNAL_ERRROR", "DOWNLOAD_FAILED", "BINDER_NOT_READY", "Companion", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ModelStatus extends Enum<ModelStatus> {
    private static final /* synthetic */ ModelStatus[] $VALUES = null;
    public static final ModelStatus BINDER_NOT_READY = null;
    public static final Companion Companion = null;
    public static final ModelStatus DOWNLOADED = null;
    public static final ModelStatus DOWNLOADING = null;
    public static final ModelStatus DOWNLOAD_FAILED = null;
    public static final ModelStatus INTERNAL_ERRROR = null;
    public static final ModelStatus LOADED_IN_MEMORY = null;
    public static final ModelStatus NEED_DOWNLOAD = null;
    public static final ModelStatus NOT_FOUND = null;
    private final int index;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/obric/aivoice/sdk/data/ModelStatus$Companion;", NameKeys.UnloadStrategy_No_Strategy, "()V", "fromInt", "Lcom/obric/aivoice/sdk/data/ModelStatus;", "value", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/Integer;)Lcom/obric/aivoice/sdk/data/ModelStatus;", "isErrorStatus", NameKeys.UnloadStrategy_No_Strategy, "st", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ModelStatus fromInt(Integer r8) {
            ModelStatus[] r0 = ModelStatus.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L14;
            ModelStatus r4 = r0[r3];
            int r5 = r4.getIndex();
            if (r8 != null) goto L8;
        L10:
            boolean r6 = false;
        L11:
            if (r6 == true) goto L18;
            r3 = r3 + 1;
            goto L3
        L18:
            return r4;
        L8:
            if (r5 != r8.intValue()) goto L10;
            r6 = true;
            goto L11
        L14:
            return null;
        }

        public final boolean isErrorStatus(ModelStatus r2) {
            Intrinsics.checkNotNullParameter(r2, "st");
            if (r2 != ModelStatus.NEED_DOWNLOAD) goto L5;
        L11:
            return false;
        L5:
            if (r2 == ModelStatus.DOWNLOADING) goto L11;
            if (r2 == ModelStatus.DOWNLOADED) goto L11;
            if (r2 == ModelStatus.LOADED_IN_MEMORY) goto L11;
            return true;
        }
    }

    private static final /* synthetic */ ModelStatus[] $values() {
        return new ModelStatus[]{NOT_FOUND, NEED_DOWNLOAD, DOWNLOADING, DOWNLOADED, LOADED_IN_MEMORY, INTERNAL_ERRROR, DOWNLOAD_FAILED, BINDER_NOT_READY};
    }

    public static ModelStatus valueOf(String r1) {
        return (ModelStatus) a.a(ModelStatus.class, r1);
    }

    public static ModelStatus[] values() {
        return (ModelStatus[]) $VALUES.clone();
    }

    static {
        NOT_FOUND = new ModelStatus("NOT_FOUND", 0, 1);
        NEED_DOWNLOAD = new ModelStatus("NEED_DOWNLOAD", 1, 2);
        DOWNLOADING = new ModelStatus("DOWNLOADING", 2, 3);
        DOWNLOADED = new ModelStatus("DOWNLOADED", 3, 4);
        LOADED_IN_MEMORY = new ModelStatus("LOADED_IN_MEMORY", 4, 5);
        INTERNAL_ERRROR = new ModelStatus("INTERNAL_ERRROR", 5, 100);
        DOWNLOAD_FAILED = new ModelStatus("DOWNLOAD_FAILED", 6, 104);
        BINDER_NOT_READY = new ModelStatus("BINDER_NOT_READY", 7, 102);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final int getIndex() {
        return this.index;
    }

    private ModelStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.index = r3;
    }
}
