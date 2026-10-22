package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/BlockContent;", "Ljava/io/Serializable;", "textBlock", "Lcom/obric/aiagent/assistant/idl/bean/TextBlock;", "appletBlock", "Lcom/obric/aiagent/assistant/idl/bean/AppletBlock;", "<init>", "(Lcom/obric/aiagent/assistant/idl/bean/TextBlock;Lcom/obric/aiagent/assistant/idl/bean/AppletBlock;)V", "getTextBlock", "()Lcom/obric/aiagent/assistant/idl/bean/TextBlock;", "getAppletBlock", "()Lcom/obric/aiagent/assistant/idl/bean/AppletBlock;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class BlockContent implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("applet_block")
    private final AppletBlock appletBlock;

    @SerializedName("text_block")
    private final TextBlock textBlock;

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockContent() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BlockContent copy$default(BlockContent r0, TextBlock r1, AppletBlock r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.textBlock;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.appletBlock;
    L9:
        return r0.copy(r1, r2);
    }

    public final TextBlock component1() {
        return this.textBlock;
    }

    public final AppletBlock component2() {
        return this.appletBlock;
    }

    public final BlockContent copy(TextBlock r2, AppletBlock r3) {
        return new BlockContent(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BlockContent) == true) goto L8;
        return false;
    L8:
        BlockContent r6 = (BlockContent) r5;
        if (Intrinsics.areEqual(this.textBlock, r6.textBlock) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appletBlock, r6.appletBlock) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        TextBlock r0 = this.textBlock;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        AppletBlock r4 = this.appletBlock;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockContent(textBlock=" + this.textBlock + ", appletBlock=" + this.appletBlock + ')';
    }

    public final AppletBlock getAppletBlock() {
        return this.appletBlock;
    }

    public final TextBlock getTextBlock() {
        return this.textBlock;
    }

    public BlockContent(TextBlock r1, AppletBlock r2) {
        this.textBlock = r1;
        this.appletBlock = r2;
    }

    public /* synthetic */ BlockContent(TextBlock r2, AppletBlock r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
