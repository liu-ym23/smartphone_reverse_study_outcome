package com.bytedance.android.anniex.container.popup;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/PopupCloseType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public abstract enum PopupCloseType extends Enum<PopupCloseType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PopupCloseType f3163b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PopupCloseType f3164c = null;
    public static final PopupCloseType d = null;
    public static final /* synthetic */ PopupCloseType[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3165a;

    static {
        PopupCloseType r5 = new SYSTEM_BACK();
        f3163b = r5;
        PopupCloseType r10 = new PULL_DOWN();
        PopupCloseType r11 = new CLICK_MASK();
        f3164c = r11;
        PopupCloseType r12 = new UNKNOWN();
        d = r12;
        e = new PopupCloseType[]{r5, r10, r11, r12};
    }

    public PopupCloseType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f3165a = r11;
    }

    public static PopupCloseType valueOf(String r5) {
        return (PopupCloseType) Enum.valueOf(PopupCloseType.class, r5);
    }

    public static PopupCloseType[] values() {
        return (PopupCloseType[]) e.clone();
    }

    public abstract String a(boolean r5);
}
