package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.BaseAction;
import com.ss.android.lark.export.entity.preview.Parameters;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/LarkCommandAction;", "Lcom/ss/android/lark/export/entity/preview/BaseAction;", "command", BuildConfig.FLAVOR, "parameters", "Lcom/ss/android/lark/export/entity/preview/Parameters;", "<init>", "(ILcom/ss/android/lark/export/entity/preview/Parameters;)V", "getCommand", "()I", "getParameters", "()Lcom/ss/android/lark/export/entity/preview/Parameters;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkCommandAction extends BaseAction {
    private final int command;
    private final Parameters parameters;

    public int hashCode() {
        int r0 = this.command * 31;
        Parameters r1 = this.parameters;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final int getCommand() {
        return this.command;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkCommandAction) == true) goto L8;
        return false;
    L8:
        LarkCommandAction r6 = (LarkCommandAction) r5;
        if (this.command == r6.command) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parameters, r6.parameters) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public LarkCommandAction(int r1, Parameters r2) {
        this.command = r1;
        this.parameters = r2;
    }
}
