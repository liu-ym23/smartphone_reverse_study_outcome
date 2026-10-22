package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u0004:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/TalkStatus;", "Lcom/ss/android/lark/picker/config/condition/ChatterCondition;", "Lcom/ss/android/lark/picker/config/condition/BotCondition;", "Lcom/ss/android/lark/picker/config/condition/AICondition;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "TALKED", "UN_TALKED", "ALL", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "isNone", "", "inter", "other", "union", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum TalkStatus extends Enum<TalkStatus> implements ChatterCondition<TalkStatus>, BotCondition<TalkStatus>, AICondition<TalkStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TalkStatus[] $VALUES = null;
    public static final TalkStatus ALL = null;
    public static final TalkStatus NONE = null;
    public static final TalkStatus TALKED = null;
    public static final TalkStatus UN_TALKED = null;
    private final Condition.Key<TalkStatus> key;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/TalkStatus$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/TalkStatus;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Key implements Condition.Key<TalkStatus> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    private static final /* synthetic */ TalkStatus[] $values() {
        return new TalkStatus[]{NONE, TALKED, UN_TALKED, ALL};
    }

    public static EnumEntries<TalkStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        NONE = new TalkStatus("NONE", 0);
        TALKED = new TalkStatus("TALKED", 1);
        UN_TALKED = new TalkStatus("UN_TALKED", 2);
        ALL = new TalkStatus("ALL", 3);
        TalkStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static TalkStatus[] values() {
        return (TalkStatus[]) $VALUES.clone();
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        if (this != NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<TalkStatus> getKey() {
        return this.key;
    }

    public static TalkStatus valueOf(String r1) {
        return (TalkStatus) a.a(TalkStatus.class, r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r1) {
        return (E) ChatterCondition.DefaultImpls.get(this, r1);
    }

    public TalkStatus inter(TalkStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        TalkStatus[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() & r1];
    }

    public TalkStatus union(TalkStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        TalkStatus[] r0 = values();
        int r1 = ordinal();
        return r0[r3.ordinal() | r1];
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r1) {
        return inter((TalkStatus) r1);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r1) {
        return union((TalkStatus) r1);
    }

    private TalkStatus(String r1, int r2) {
        super(r1, r2);
        this.key = Key.INSTANCE;
    }
}
