package com.larus.bmhome.chat.detail.code;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/CodeRenderScene;", "", "<init>", "(Ljava/lang/String;I)V", "DeepSearch", "CodeArtifact", "Default", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CodeRenderScene extends Enum<CodeRenderScene> {
    public static final CodeRenderScene CodeArtifact = null;
    public static final CodeRenderScene DeepSearch = null;
    public static final CodeRenderScene Default = null;
    public static final /* synthetic */ CodeRenderScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CodeRenderScene> getEntries() {
        return b;
    }

    static {
        CodeRenderScene r0 = new CodeRenderScene("DeepSearch", 0);
        DeepSearch = r0;
        CodeRenderScene r1 = new CodeRenderScene("CodeArtifact", 1);
        CodeArtifact = r1;
        CodeRenderScene r3 = new CodeRenderScene("Default", 2);
        Default = r3;
        CodeRenderScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CodeRenderScene[] values() {
        return (CodeRenderScene[]) a.clone();
    }

    public static CodeRenderScene valueOf(String r1) {
        return (CodeRenderScene) r27.a.a(CodeRenderScene.class, r1);
    }

    public CodeRenderScene(String r1, int r2) {
        super(r1, r2);
    }
}
