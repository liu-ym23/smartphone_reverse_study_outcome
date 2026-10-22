package com.larus.camera.impl.ui.viewmodel;

import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/camera/impl/ui/viewmodel/MultiCaptureScene;", "", "scene", "", "<init>", "(Ljava/lang/String;II)V", "getScene", "()I", SuggestPromptErrorType.ERROR_TYPE_DEFAULT, "MAIN_BOT", "OTHER_BOT", "ALL_BOT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultiCaptureScene extends Enum<MultiCaptureScene> {
    public static final MultiCaptureScene ALL_BOT = null;
    public static final MultiCaptureScene DEFAULT = null;
    public static final MultiCaptureScene MAIN_BOT = null;
    public static final MultiCaptureScene OTHER_BOT = null;
    public static final /* synthetic */ MultiCaptureScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int scene;

    public static EnumEntries<MultiCaptureScene> getEntries() {
        return b;
    }

    static {
        MultiCaptureScene r0 = new MultiCaptureScene(SuggestPromptErrorType.ERROR_TYPE_DEFAULT, 0, 0);
        DEFAULT = r0;
        MultiCaptureScene r1 = new MultiCaptureScene("MAIN_BOT", 1, 1);
        MAIN_BOT = r1;
        MultiCaptureScene r3 = new MultiCaptureScene("OTHER_BOT", 2, 2);
        OTHER_BOT = r3;
        MultiCaptureScene r5 = new MultiCaptureScene("ALL_BOT", 3, 3);
        ALL_BOT = r5;
        MultiCaptureScene[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MultiCaptureScene[] values() {
        return (MultiCaptureScene[]) a.clone();
    }

    public final int getScene() {
        return this.scene;
    }

    public static MultiCaptureScene valueOf(String r1) {
        return (MultiCaptureScene) r27.a.a(MultiCaptureScene.class, r1);
    }

    public MultiCaptureScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.scene = r3;
    }
}
