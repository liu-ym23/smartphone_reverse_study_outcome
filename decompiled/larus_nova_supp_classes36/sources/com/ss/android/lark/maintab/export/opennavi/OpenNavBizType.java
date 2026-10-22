package com.ss.android.lark.maintab.export.opennavi;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/maintab/export/opennavi/OpenNavBizType;", "", "priority", "", "<init>", "(Ljava/lang/String;II)V", "getPriority", "()I", "CCM", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum OpenNavBizType extends Enum<OpenNavBizType> {
    public static final OpenNavBizType CCM = null;
    public static final /* synthetic */ OpenNavBizType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int priority;

    public static EnumEntries<OpenNavBizType> getEntries() {
        return b;
    }

    static {
        OpenNavBizType r0 = new OpenNavBizType();
        CCM = r0;
        OpenNavBizType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public OpenNavBizType() {
        super("CCM", 0);
        this.priority = 10;
    }

    public static OpenNavBizType[] values() {
        return (OpenNavBizType[]) a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public static OpenNavBizType valueOf(String r1) {
        return (OpenNavBizType) a.a(OpenNavBizType.class, r1);
    }
}
