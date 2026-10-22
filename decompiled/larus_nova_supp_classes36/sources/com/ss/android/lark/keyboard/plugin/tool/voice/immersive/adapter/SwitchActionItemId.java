package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/SwitchActionItemId;", "", "itemId", "", "<init>", "(Ljava/lang/String;II)V", "PolishVoiceInput", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum SwitchActionItemId extends Enum<SwitchActionItemId> {
    public static final SwitchActionItemId PolishVoiceInput = null;
    public static final /* synthetic */ SwitchActionItemId[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int itemId;

    public static EnumEntries<SwitchActionItemId> getEntries() {
        return b;
    }

    static {
        SwitchActionItemId r0 = new SwitchActionItemId();
        PolishVoiceInput = r0;
        SwitchActionItemId[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public SwitchActionItemId() {
        super("PolishVoiceInput", 0);
        this.itemId = 0;
    }

    public static SwitchActionItemId[] values() {
        return (SwitchActionItemId[]) a.clone();
    }

    public static SwitchActionItemId valueOf(String r1) {
        return (SwitchActionItemId) a.a(SwitchActionItemId.class, r1);
    }
}
