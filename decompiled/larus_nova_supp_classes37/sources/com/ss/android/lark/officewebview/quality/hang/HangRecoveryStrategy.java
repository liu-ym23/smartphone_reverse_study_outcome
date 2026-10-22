package com.ss.android.lark.officewebview.quality.hang;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officewebview/quality/hang/HangRecoveryStrategy;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "TERMINATE_RENDER_PROCESS", "KILL_SANDBOX_PROCESS", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HangRecoveryStrategy extends Enum<HangRecoveryStrategy> {
    public static final HangRecoveryStrategy KILL_SANDBOX_PROCESS = null;
    public static final HangRecoveryStrategy TERMINATE_RENDER_PROCESS = null;
    public static final /* synthetic */ HangRecoveryStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<HangRecoveryStrategy> getEntries() {
        return b;
    }

    static {
        HangRecoveryStrategy r0 = new HangRecoveryStrategy("TERMINATE_RENDER_PROCESS", 0, 1);
        TERMINATE_RENDER_PROCESS = r0;
        HangRecoveryStrategy r1 = new HangRecoveryStrategy("KILL_SANDBOX_PROCESS", 1, 2);
        KILL_SANDBOX_PROCESS = r1;
        HangRecoveryStrategy[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static HangRecoveryStrategy[] values() {
        return (HangRecoveryStrategy[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static HangRecoveryStrategy valueOf(String r1) {
        return (HangRecoveryStrategy) a.a(HangRecoveryStrategy.class, r1);
    }

    public HangRecoveryStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
