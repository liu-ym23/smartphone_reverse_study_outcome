package com.obric.memorydata.database.util.file_utils;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/NodeType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TITLE", "TEXT", "PARAGRAPH", "TABLE", "TABLE_HEADER", "TABLE_ROW", "IMAGE", "VIRTUAL", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum NodeType extends Enum<NodeType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NodeType[] $VALUES = null;
    public static final NodeType IMAGE = null;
    public static final NodeType PARAGRAPH = null;
    public static final NodeType TABLE = null;
    public static final NodeType TABLE_HEADER = null;
    public static final NodeType TABLE_ROW = null;
    public static final NodeType TEXT = null;
    public static final NodeType TITLE = null;
    public static final NodeType VIRTUAL = null;
    private final String value;

    private static final /* synthetic */ NodeType[] $values() {
        return new NodeType[]{TITLE, TEXT, PARAGRAPH, TABLE, TABLE_HEADER, TABLE_ROW, IMAGE, VIRTUAL};
    }

    static {
        TITLE = new NodeType("TITLE", 0, "title");
        TEXT = new NodeType("TEXT", 1, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        PARAGRAPH = new NodeType("PARAGRAPH", 2, "paragraph");
        TABLE = new NodeType("TABLE", 3, "table");
        TABLE_HEADER = new NodeType("TABLE_HEADER", 4, "table_header");
        TABLE_ROW = new NodeType("TABLE_ROW", 5, "table_row");
        IMAGE = new NodeType("IMAGE", 6, "image");
        VIRTUAL = new NodeType("VIRTUAL", 7, "virtual");
        NodeType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private NodeType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<NodeType> getEntries() {
        return $ENTRIES;
    }

    public static NodeType valueOf(String r2) {
        return (NodeType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NodeType.class, r2), NodeType.class, "com.obric.memorydata.plugin");
    }

    public static NodeType[] values() {
        return (NodeType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NodeType[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
