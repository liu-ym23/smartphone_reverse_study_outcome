package com.bytedance.ai.ex.widget.donate;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.StockEntity;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/ex/widget/donate/EntityType;", "", "value", "", "type", "Ljava/lang/Class;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Class;I)V", "getValue", "()Ljava/lang/String;", "getType", "()Ljava/lang/Class;", "getCode", "()I", "STOCK", "Companion", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum EntityType extends Enum<EntityType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ EntityType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final EntityType STOCK = null;
    private final int code;
    private final Class<? extends AppEntity> type;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/ex/widget/donate/EntityType$Companion;", "", "<init>", "()V", "fromValue", "Lcom/bytedance/ai/ex/widget/donate/EntityType;", "value", "", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nEntityType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityType.kt\ncom/bytedance/ai/ex/widget/donate/EntityType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,17:1\n1#2:18\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final EntityType fromValue(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            EntityType[] r10 = EntityType.values();
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L8;
            EntityType r13 = r10[r12];
            if (Intrinsics.areEqual(r13.getValue(), r5) == true) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return r13;
        L8:
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ EntityType[] $values() {
        return new EntityType[]{STOCK};
    }

    static {
        STOCK = new EntityType("STOCK", 0, "stock", StockEntity.class, 1101);
        EntityType[] r5 = $values();
        $VALUES = r5;
        $ENTRIES = EnumEntriesKt.enumEntries(r5);
        Companion = new Companion(null);
    }

    private EntityType(String r5, int r10, String r11, Class r12, int r13) {
        super(r5, r10);
        this.value = r11;
        this.type = r12;
        this.code = r13;
    }

    public static EnumEntries<EntityType> getEntries() {
        return $ENTRIES;
    }

    public static EntityType valueOf(String r5) {
        return (EntityType) Enum.valueOf(EntityType.class, r5);
    }

    public static EntityType[] values() {
        return (EntityType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final Class<? extends AppEntity> getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }
}
