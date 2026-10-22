package com.obric.aivoice.sdk.data;

import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/obric/aivoice/sdk/data/LiteModelInfo;", NameKeys.UnloadStrategy_No_Strategy, EasyGoDbTable.Server.NAME, NameKeys.UnloadStrategy_No_Strategy, "type", "status", "Lcom/obric/aivoice/sdk/data/ModelStatus;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/aivoice/sdk/data/ModelStatus;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getStatus", "()Lcom/obric/aivoice/sdk/data/ModelStatus;", "setStatus", "(Lcom/obric/aivoice/sdk/data/ModelStatus;)V", "getType", "setType", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LiteModelInfo {
    private String name;
    private ModelStatus status;
    private String type;

    public final String getName() {
        return this.name;
    }

    public final ModelStatus getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setStatus(ModelStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.status = r2;
    }

    public final void setType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public LiteModelInfo(String r2, String r3, ModelStatus r4) {
        Intrinsics.checkNotNullParameter(r2, EasyGoDbTable.Server.NAME);
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "status");
        this.name = r2;
        this.type = r3;
        this.status = r4;
    }
}
