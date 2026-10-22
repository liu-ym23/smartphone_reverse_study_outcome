package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.BaseAction;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/SwitchStateAction;", "Lcom/ss/android/lark/export/entity/preview/BaseAction;", "nextStateId", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getNextStateId", "()Ljava/lang/String;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwitchStateAction extends BaseAction {
    private final String nextStateId;

    public int hashCode() {
        return this.nextStateId.hashCode();
    }

    public final String getNextStateId() {
        return this.nextStateId;
    }

    public SwitchStateAction(String r2) {
        Intrinsics.checkNotNullParameter(r2, "nextStateId");
        this.nextStateId = r2;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SwitchStateAction) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.nextStateId, ((SwitchStateAction) r4).nextStateId) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
