package com.lynx.debugrouter.base.usb;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/lynx/debugrouter/base/usb/TemplateFileSize;", NameKeys.UnloadStrategy_No_Strategy, "seqSize", NameKeys.UnloadStrategy_No_Strategy, "fileLen", "(II)V", "getFileLen", "()I", "setFileLen", "(I)V", "seqCount", "getSeqCount", "setSeqCount", "isError", NameKeys.UnloadStrategy_No_Strategy, "Companion", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateFileSize {
    public static final Companion Companion = null;
    public static final int ERROR_VALUE = -2;
    public static final int TIME_OUT = -3;
    private int fileLen;
    private int seqCount;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/lynx/debugrouter/base/usb/TemplateFileSize$Companion;", NameKeys.UnloadStrategy_No_Strategy, "()V", "ERROR_VALUE", NameKeys.UnloadStrategy_No_Strategy, "TIME_OUT", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final boolean isError() {
        if (this.seqCount > (-2)) goto L5;
    L8:
        return true;
    L5:
        if (this.fileLen <= (-2)) goto L8;
        return false;
    }

    public final int getFileLen() {
        return this.fileLen;
    }

    public final int getSeqCount() {
        return this.seqCount;
    }

    public final void setFileLen(int r1) {
        this.fileLen = r1;
    }

    public final void setSeqCount(int r1) {
        this.seqCount = r1;
    }

    public TemplateFileSize(int r1, int r2) {
        this.seqCount = r1;
        this.fileLen = r2;
    }
}
