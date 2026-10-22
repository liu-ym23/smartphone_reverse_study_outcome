package com.larksuite.component.ui.avatar;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/ui/avatar/ImageKeyType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IMAGE", "UNKOWN", "Companion", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ImageKeyType extends Enum<ImageKeyType> {
    public static final a Companion = null;
    public static final ImageKeyType IMAGE = null;
    public static final ImageKeyType UNKOWN = null;
    public static final /* synthetic */ ImageKeyType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ImageKeyType> getEntries() {
        return b;
    }

    static {
        ImageKeyType r0 = new ImageKeyType("IMAGE", 0, 1);
        IMAGE = r0;
        ImageKeyType r1 = new ImageKeyType("UNKOWN", 1, 0);
        UNKOWN = r1;
        ImageKeyType[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
        Companion = new a();
    }

    public static ImageKeyType[] values() {
        return (ImageKeyType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ImageKeyType valueOf(int r6) {
        Companion.getClass();
        ImageKeyType[] r0 = values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        ImageKeyType r4 = r0[r3];
        if (r4.getValue() != r6) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L15;
        r3 = r3 + 1;
        goto L3
    L15:
        return r4;
    L7:
        r5 = false;
        goto L8
    L11:
        return null;
    }

    public static ImageKeyType valueOf(String r1) {
        return (ImageKeyType) r27.a.a(ImageKeyType.class, r1);
    }

    public ImageKeyType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
