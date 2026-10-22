package com.ss.android.lark.officesdk.di.core.deps;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/deps/JsEngineKind;", "", "<init>", "(Ljava/lang/String;I)V", "QUICKJS", "V8", "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum JsEngineKind extends Enum<JsEngineKind> {
    public static final JsEngineKind QUICKJS = null;
    public static final JsEngineKind V8 = null;
    public static final /* synthetic */ JsEngineKind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<JsEngineKind> getEntries() {
        return b;
    }

    static {
        JsEngineKind r0 = new JsEngineKind("QUICKJS", 0);
        QUICKJS = r0;
        JsEngineKind r1 = new JsEngineKind("V8", 1);
        V8 = r1;
        JsEngineKind[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static JsEngineKind[] values() {
        return (JsEngineKind[]) a.clone();
    }

    public static JsEngineKind valueOf(String r1) {
        return (JsEngineKind) a.a(JsEngineKind.class, r1);
    }

    public JsEngineKind(String r1, int r2) {
        super(r1, r2);
    }
}
