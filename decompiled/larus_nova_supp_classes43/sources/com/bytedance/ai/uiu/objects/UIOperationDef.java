package com.bytedance.ai.uiu.objects;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/uiu/objects/UIOperationDef;", "", a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLICK", "LONG_CLICK", "INPUT", "INPUT_GO", "SCROLL_BOTTOM", "SCROLL_NEXT", "SCROLL_PREVIOUS", "SCROLL_TOP", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UIOperationDef extends Enum<UIOperationDef> {
    public static final UIOperationDef CLICK = null;
    public static final UIOperationDef INPUT = null;
    public static final UIOperationDef INPUT_GO = null;
    public static final UIOperationDef LONG_CLICK = null;
    public static final UIOperationDef SCROLL_BOTTOM = null;
    public static final UIOperationDef SCROLL_NEXT = null;
    public static final UIOperationDef SCROLL_PREVIOUS = null;
    public static final UIOperationDef SCROLL_TOP = null;
    public static final /* synthetic */ UIOperationDef[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<UIOperationDef> getEntries() {
        return b;
    }

    static {
        UIOperationDef r0 = new UIOperationDef("CLICK", 0, "click");
        CLICK = r0;
        UIOperationDef r1 = new UIOperationDef("LONG_CLICK", 1, "longClick");
        LONG_CLICK = r1;
        UIOperationDef r10 = new UIOperationDef("INPUT", 2, "input");
        INPUT = r10;
        UIOperationDef r11 = new UIOperationDef("INPUT_GO", 3, "inputGo");
        INPUT_GO = r11;
        UIOperationDef r12 = new UIOperationDef("SCROLL_BOTTOM", 4, "scrollBottom");
        SCROLL_BOTTOM = r12;
        UIOperationDef r13 = new UIOperationDef("SCROLL_NEXT", 5, "scrollNext");
        SCROLL_NEXT = r13;
        UIOperationDef r14 = new UIOperationDef("SCROLL_PREVIOUS", 6, "scrollPrevious");
        SCROLL_PREVIOUS = r14;
        UIOperationDef r15 = new UIOperationDef("SCROLL_TOP", 7, "scrollTop");
        SCROLL_TOP = r15;
        UIOperationDef[] r16 = {r0, r1, r10, r11, r12, r13, r14, r15};
        a = r16;
        b = EnumEntriesKt.enumEntries(r16);
    }

    public static UIOperationDef[] values() {
        return (UIOperationDef[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static UIOperationDef valueOf(String r1) {
        return (UIOperationDef) r27.a.a(UIOperationDef.class, r1);
    }

    public UIOperationDef(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
