package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/ItemType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "Header", "SendTypeAction", "AsrLanguage", "IconWithTitle", "Divider", "SwitchAction", "value", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ItemType extends Enum<ItemType> {
    public static final ItemType AsrLanguage = null;
    public static final ItemType Divider = null;
    public static final ItemType Header = null;
    public static final ItemType IconWithTitle = null;
    public static final ItemType SendTypeAction = null;
    public static final ItemType SwitchAction = null;
    public static final /* synthetic */ ItemType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<ItemType> getEntries() {
        return b;
    }

    static {
        ItemType r0 = new ItemType("Header", 0, 0);
        Header = r0;
        ItemType r1 = new ItemType("SendTypeAction", 1, 1);
        SendTypeAction = r1;
        ItemType r3 = new ItemType("AsrLanguage", 2, 2);
        AsrLanguage = r3;
        ItemType r5 = new ItemType("IconWithTitle", 3, 3);
        IconWithTitle = r5;
        ItemType r7 = new ItemType("Divider", 4, 4);
        Divider = r7;
        ItemType r9 = new ItemType("SwitchAction", 5, 5);
        SwitchAction = r9;
        ItemType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ItemType[] values() {
        return (ItemType[]) a.clone();
    }

    public final int value() {
        return this.type;
    }

    public static ItemType valueOf(String r1) {
        return (ItemType) a.a(ItemType.class, r1);
    }

    public ItemType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
