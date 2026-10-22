package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/IconWithTitleItemId;", "", "itemId", "", "<init>", "(Ljava/lang/String;II)V", "SubmitFeedback", "RollBackAudio", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum IconWithTitleItemId extends Enum<IconWithTitleItemId> {
    public static final IconWithTitleItemId RollBackAudio = null;
    public static final IconWithTitleItemId SubmitFeedback = null;
    public static final /* synthetic */ IconWithTitleItemId[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int itemId;

    public static EnumEntries<IconWithTitleItemId> getEntries() {
        return b;
    }

    static {
        IconWithTitleItemId r0 = new IconWithTitleItemId("SubmitFeedback", 0, 0);
        SubmitFeedback = r0;
        IconWithTitleItemId r1 = new IconWithTitleItemId("RollBackAudio", 1, 1);
        RollBackAudio = r1;
        IconWithTitleItemId[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static IconWithTitleItemId[] values() {
        return (IconWithTitleItemId[]) a.clone();
    }

    public static IconWithTitleItemId valueOf(String r1) {
        return (IconWithTitleItemId) a.a(IconWithTitleItemId.class, r1);
    }

    public IconWithTitleItemId(String r1, int r2, int r3) {
        super(r1, r2);
        this.itemId = r3;
    }
}
