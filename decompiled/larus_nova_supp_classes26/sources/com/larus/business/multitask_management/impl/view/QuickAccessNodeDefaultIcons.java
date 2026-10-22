package com.larus.business.multitask_management.impl.view;

import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0016"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/QuickAccessNodeDefaultIcons;", "", "nodeType", "Lcom/larus/multitask_management/api/data/quick_access/NodeType;", "iconType", "Lcom/larus/common_ui/icon/CommonFileIconType;", "<init>", "(Ljava/lang/String;ILcom/larus/multitask_management/api/data/quick_access/NodeType;Lcom/larus/common_ui/icon/CommonFileIconType;)V", "getNodeType", "()Lcom/larus/multitask_management/api/data/quick_access/NodeType;", "DOC", "PPT", "SHEET", "FOLDER", "resId", "", "getResId", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickAccessNodeDefaultIcons extends Enum<QuickAccessNodeDefaultIcons> {
    public static final QuickAccessNodeDefaultIcons DOC = null;
    public static final QuickAccessNodeDefaultIcons FOLDER = null;
    public static final QuickAccessNodeDefaultIcons PPT = null;
    public static final QuickAccessNodeDefaultIcons SHEET = null;
    public static final /* synthetic */ QuickAccessNodeDefaultIcons[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final CommonFileIconType iconType;
    private final NodeType nodeType;

    public static EnumEntries<QuickAccessNodeDefaultIcons> getEntries() {
        return b;
    }

    static {
        QuickAccessNodeDefaultIcons r0 = new QuickAccessNodeDefaultIcons("DOC", 0, NodeType.DOCUMENT, CommonFileIconType.AI_DOC);
        DOC = r0;
        QuickAccessNodeDefaultIcons r1 = new QuickAccessNodeDefaultIcons("PPT", 1, NodeType.PPT, CommonFileIconType.AI_SLIDES);
        PPT = r1;
        QuickAccessNodeDefaultIcons r2 = new QuickAccessNodeDefaultIcons("SHEET", 2, NodeType.SHEET, CommonFileIconType.AI_SHEET);
        SHEET = r2;
        QuickAccessNodeDefaultIcons r3 = new QuickAccessNodeDefaultIcons("FOLDER", 3, NodeType.FOLDER, CommonFileIconType.FOLDER);
        FOLDER = r3;
        QuickAccessNodeDefaultIcons[] r5 = {r0, r1, r2, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static QuickAccessNodeDefaultIcons[] values() {
        return (QuickAccessNodeDefaultIcons[]) a.clone();
    }

    public final int getResId() {
        h19.b r0 = h19.b.a;
        CommonFileIconType r1 = this.iconType;
        r0.getClass();
        return h19.b.a(r1);
    }

    public final String getUri() {
        return "multitask_" + name().toLowerCase(Locale.ROOT);
    }

    public final NodeType getNodeType() {
        return this.nodeType;
    }

    public static QuickAccessNodeDefaultIcons valueOf(String r1) {
        return (QuickAccessNodeDefaultIcons) r27.a.a(QuickAccessNodeDefaultIcons.class, r1);
    }

    public QuickAccessNodeDefaultIcons(String r1, int r2, NodeType r3, CommonFileIconType r4) {
        super(r1, r2);
        this.nodeType = r3;
        this.iconType = r4;
    }
}
