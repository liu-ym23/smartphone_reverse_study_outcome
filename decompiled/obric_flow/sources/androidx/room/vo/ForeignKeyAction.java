package androidx.room.vo;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Landroidx/room/vo/ForeignKeyAction;", "", "annotationValue", "", "sqlName", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getAnnotationValue", "()I", "getSqlName", "()Ljava/lang/String;", "NO_ACTION", "RESTRICT", "SET_NULL", "SET_DEFAULT", "CASCADE", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ForeignKeyAction extends Enum<ForeignKeyAction> {
    private static final /* synthetic */ ForeignKeyAction[] $VALUES = null;
    public static final ForeignKeyAction CASCADE = null;
    public static final Companion Companion = null;
    public static final ForeignKeyAction NO_ACTION = null;
    public static final ForeignKeyAction RESTRICT = null;
    public static final ForeignKeyAction SET_DEFAULT = null;
    public static final ForeignKeyAction SET_NULL = null;
    private static final Lazy<Map<Integer, ForeignKeyAction>> mapping$delegate = null;
    private final int annotationValue;
    private final String sqlName;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rR'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Landroidx/room/vo/ForeignKeyAction$Companion;", "", "()V", "mapping", "", "", "Landroidx/room/vo/ForeignKeyAction;", "getMapping", "()Ljava/util/Map;", "mapping$delegate", "Lkotlin/Lazy;", "fromAnnotationValue", "value", "(Ljava/lang/Integer;)Landroidx/room/vo/ForeignKeyAction;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final Map<Integer, ForeignKeyAction> getMapping() {
            return (Map) ForeignKeyAction.access$getMapping$delegate$cp().getValue();
        }

        public final ForeignKeyAction fromAnnotationValue(Integer r5) {
            return getMapping().get(r5);
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ForeignKeyAction[] $values() {
        return new ForeignKeyAction[]{NO_ACTION, RESTRICT, SET_NULL, SET_DEFAULT, CASCADE};
    }

    static {
        NO_ACTION = new ForeignKeyAction("NO_ACTION", 0, 1, "NO ACTION");
        RESTRICT = new ForeignKeyAction("RESTRICT", 1, 2, "RESTRICT");
        SET_NULL = new ForeignKeyAction("SET_NULL", 2, 3, "SET NULL");
        SET_DEFAULT = new ForeignKeyAction("SET_DEFAULT", 3, 4, "SET DEFAULT");
        CASCADE = new ForeignKeyAction("CASCADE", 4, 5, "CASCADE");
        $VALUES = $values();
        Companion = new Companion(null);
        mapping$delegate = LazyKt.lazy(ForeignKeyAction$Companion$mapping$2.INSTANCE);
    }

    private ForeignKeyAction(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.annotationValue = r11;
        this.sqlName = r12;
    }

    public static final /* synthetic */ Lazy access$getMapping$delegate$cp() {
        return mapping$delegate;
    }

    public static ForeignKeyAction valueOf(String r5) {
        return (ForeignKeyAction) Enum.valueOf(ForeignKeyAction.class, r5);
    }

    public static ForeignKeyAction[] values() {
        return (ForeignKeyAction[]) $VALUES.clone();
    }

    public final int getAnnotationValue() {
        return this.annotationValue;
    }

    public final String getSqlName() {
        return this.sqlName;
    }
}
