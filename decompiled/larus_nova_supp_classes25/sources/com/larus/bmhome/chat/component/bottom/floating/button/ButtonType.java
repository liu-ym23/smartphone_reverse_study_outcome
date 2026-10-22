package com.larus.bmhome.chat.component.bottom.floating.button;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/button/ButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "SHARE_LONG_IMAGE", "ADD_COLLECT_COPY", "ADD_COLLECT_LIKE", "LOOK_COLLECT", "LOOK_LIKE", "getLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract enum ButtonType extends Enum<ButtonType> {
    public static final ButtonType ADD_COLLECT_COPY = null;
    public static final ButtonType ADD_COLLECT_LIKE = null;
    public static final ButtonType LOOK_COLLECT = null;
    public static final ButtonType LOOK_LIKE = null;
    public static final ButtonType SHARE_LONG_IMAGE = null;
    public static final /* synthetic */ ButtonType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public ButtonType() {
        throw null;
    }

    public static EnumEntries<ButtonType> getEntries() {
        return b;
    }

    public abstract View getLayout(Context r1);

    static {
        final String r1 = "SHARE_LONG_IMAGE";
        final int r2 = 0;
        ButtonType r0 = new SHARE_LONG_IMAGE(r1, r2);
        SHARE_LONG_IMAGE = r0;
        final String r3 = "ADD_COLLECT_COPY";
        final int r4 = 1;
        ButtonType r5 = new ADD_COLLECT_COPY(r3, r4);
        ADD_COLLECT_COPY = r5;
        final String r6 = "ADD_COLLECT_LIKE";
        final int r7 = 2;
        ButtonType r8 = new ADD_COLLECT_LIKE(r6, r7);
        ADD_COLLECT_LIKE = r8;
        final String r9 = "LOOK_COLLECT";
        final int r10 = 3;
        ButtonType r11 = new LOOK_COLLECT(r9, r10);
        LOOK_COLLECT = r11;
        final String r12 = "LOOK_LIKE";
        final int r13 = 4;
        ButtonType r14 = new LOOK_LIKE(r12, r13);
        LOOK_LIKE = r14;
        ButtonType[] r15 = {r0, r5, r8, r11, r14};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static ButtonType[] values() {
        return (ButtonType[]) a.clone();
    }

    public static ButtonType valueOf(String r1) {
        return (ButtonType) r27.a.a(ButtonType.class, r1);
    }

    public ButtonType(String r1, int r2, DefaultConstructorMarker r3) {
        super(r1, r2);
    }
}
