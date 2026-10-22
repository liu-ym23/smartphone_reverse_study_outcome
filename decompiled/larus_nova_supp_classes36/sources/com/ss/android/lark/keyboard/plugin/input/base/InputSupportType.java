package com.ss.android.lark.keyboard.plugin.input.base;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.event.c;
import com.ss.android.lark.keyboard.event.m;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/input/base/InputSupportType;", "Lcom/ss/android/lark/keyboard/event/ITransformable;", "", "<init>", "(Ljava/lang/String;I)V", "Text", "Post", "None", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum InputSupportType extends Enum<InputSupportType> implements m {
    public static final InputSupportType None = null;
    public static final InputSupportType Post = null;
    public static final InputSupportType Text = null;
    public static final /* synthetic */ InputSupportType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InputSupportType> getEntries() {
        return b;
    }

    static {
        InputSupportType r0 = new InputSupportType("Text", 0);
        Text = r0;
        InputSupportType r1 = new InputSupportType("Post", 1);
        Post = r1;
        InputSupportType r3 = new InputSupportType("None", 2);
        None = r3;
        InputSupportType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static InputSupportType[] values() {
        return (InputSupportType[]) a.clone();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public String getTag() {
        return c.a.a(this);
    }

    public static InputSupportType valueOf(String r1) {
        return (InputSupportType) a.a(InputSupportType.class, r1);
    }

    public InputSupportType(String r1, int r2) {
        super(r1, r2);
    }
}
