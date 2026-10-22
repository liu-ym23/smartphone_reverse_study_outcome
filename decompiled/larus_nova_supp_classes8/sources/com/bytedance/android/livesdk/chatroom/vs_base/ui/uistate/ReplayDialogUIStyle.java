package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/ui/uistate/ReplayDialogUIStyle;", "", "BottomStyle", "RightStyle", "RightBottomStyle", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayDialogUIStyle extends Enum<ReplayDialogUIStyle> {
    public static final ReplayDialogUIStyle BottomStyle = null;
    public static final ReplayDialogUIStyle RightBottomStyle = null;
    public static final ReplayDialogUIStyle RightStyle = null;
    public static final /* synthetic */ ReplayDialogUIStyle[] a = null;

    static {
        ReplayDialogUIStyle r1 = new ReplayDialogUIStyle("BottomStyle", 0);
        BottomStyle = r1;
        ReplayDialogUIStyle r2 = new ReplayDialogUIStyle("RightStyle", 1);
        RightStyle = r2;
        ReplayDialogUIStyle r3 = new ReplayDialogUIStyle("RightBottomStyle", 2);
        RightBottomStyle = r3;
        a = new ReplayDialogUIStyle[]{r1, r2, r3};
    }

    public static ReplayDialogUIStyle valueOf(String r1) {
        return (ReplayDialogUIStyle) r27.a.a(ReplayDialogUIStyle.class, r1);
    }

    public static ReplayDialogUIStyle[] values() {
        return (ReplayDialogUIStyle[]) a.clone();
    }

    public ReplayDialogUIStyle(String r1, int r2) {
        super(r1, r2);
    }
}
