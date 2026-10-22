package com.obric.memory.datacollect.kotlin;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/ChatType;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "None", i.l, "Group", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final enum ChatType extends Enum<ChatType> {
    private static final /* synthetic */ ChatType[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("2")
    public static final ChatType Group = null;

    @SerializedName("0")
    public static final ChatType None = null;

    @SerializedName("1")
    public static final ChatType Private = null;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/ChatType$Companion;", "", "()V", "findByValue", "Lcom/obric/memory/datacollect/kotlin/ChatType;", "i", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final ChatType a(int r1) {
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L13;
            return null;
        L13:
            return ChatType.Group;
        L14:
            return ChatType.Private;
        L11:
            return ChatType.None;
        }
    }

    static {
        ChatType r1 = new ChatType("None", 0, 0);
        None = r1;
        ChatType r2 = new ChatType(i.l, 1, 1);
        Private = r2;
        ChatType r3 = new ChatType("Group", 2, 2);
        Group = r3;
        $VALUES = new ChatType[]{r1, r2, r3};
        Companion = new a(null);
    }

    private ChatType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    @JvmStatic
    public static final ChatType findByValue(int r1) {
        return Companion.a(r1);
    }

    public static ChatType valueOf(String r2) {
        return (ChatType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChatType.class, r2), ChatType.class, "com.obric.memorydata.plugin");
    }

    public static ChatType[] values() {
        return (ChatType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChatType[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
