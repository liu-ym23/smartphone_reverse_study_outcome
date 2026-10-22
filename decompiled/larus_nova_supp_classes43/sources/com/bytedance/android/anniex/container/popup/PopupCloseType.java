package com.bytedance.android.anniex.container.popup;

import com.bytedance.ies.bullet.service.base.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0005\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/PopupCloseType;", "", "", "enableFix", "", "getTag", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, "Ljava/lang/String;", "()Ljava/lang/String;", "SYSTEM_BACK", "PULL_DOWN", "CLICK_MASK", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract enum PopupCloseType extends Enum<PopupCloseType> {
    public static final PopupCloseType CLICK_MASK = null;
    public static final PopupCloseType PULL_DOWN = null;
    public static final PopupCloseType SYSTEM_BACK = null;
    public static final PopupCloseType UNKNOWN = null;
    public static final /* synthetic */ PopupCloseType[] a = null;
    private final String tag;

    public PopupCloseType() {
        throw null;
    }

    public static PopupCloseType valueOf(String r1) {
        return (PopupCloseType) r27.a.a(PopupCloseType.class, r1);
    }

    public static PopupCloseType[] values() {
        return (PopupCloseType[]) a.clone();
    }

    public abstract String getTag(boolean r1);

    static {
        final String r1 = "SYSTEM_BACK";
        final int r10 = 0;
        PopupCloseType r0 = new SYSTEM_BACK(r1, r10);
        SYSTEM_BACK = r0;
        final String r11 = "PULL_DOWN";
        final int r12 = 1;
        PopupCloseType r13 = new PULL_DOWN(r11, r12);
        PULL_DOWN = r13;
        final String r14 = "CLICK_MASK";
        final int r15 = 2;
        PopupCloseType r16 = new CLICK_MASK(r14, r15);
        CLICK_MASK = r16;
        final String r17 = "UNKNOWN";
        final int r18 = 3;
        PopupCloseType r19 = new UNKNOWN(r17, r18);
        UNKNOWN = r19;
        a = new PopupCloseType[]{r0, r13, r16, r19};
    }

    public final String getTag() {
        return this.tag;
    }

    public PopupCloseType(String r1, int r10, String r11, DefaultConstructorMarker r12) {
        super(r1, r10);
        this.tag = r11;
    }

    public static /* synthetic */ String getTag$default(PopupCloseType r0, boolean r1, int r10, Object r11) {
        if (r11 != null) goto L9;
        if ((r10 & 1) == 0) goto L7;
        r1 = h.r();
    L7:
        return r0.getTag(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTag");
    }
}
