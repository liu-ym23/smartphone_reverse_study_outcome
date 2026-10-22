package com.ss.android.lark.officewebview.quality.hang;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officewebview/quality/hang/HangDetectStrategy;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "UNKNOWN", "RENDER_PROCESS_CLIENT", "JS_PING", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HangDetectStrategy extends Enum<HangDetectStrategy> {
    public static final HangDetectStrategy JS_PING = null;
    public static final HangDetectStrategy RENDER_PROCESS_CLIENT = null;
    public static final HangDetectStrategy UNKNOWN = null;
    public static final /* synthetic */ HangDetectStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<HangDetectStrategy> getEntries() {
        return b;
    }

    static {
        HangDetectStrategy r0 = new HangDetectStrategy("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        HangDetectStrategy r1 = new HangDetectStrategy("RENDER_PROCESS_CLIENT", 1, 1);
        RENDER_PROCESS_CLIENT = r1;
        HangDetectStrategy r2 = new HangDetectStrategy("JS_PING", 2, 2);
        JS_PING = r2;
        HangDetectStrategy[] r5 = {r0, r1, r2};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static HangDetectStrategy[] values() {
        return (HangDetectStrategy[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static HangDetectStrategy valueOf(String r1) {
        return (HangDetectStrategy) a.a(HangDetectStrategy.class, r1);
    }

    public HangDetectStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
