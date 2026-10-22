package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.vo.Pojo;
import androidx.room.vo.ShortcutEntity;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import com.squareup.javapoet.z;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/room/writer/EntityUpsertionAdapterWriter;", "", "", "tableName", "Landroidx/room/vo/Pojo;", "pojo", "<init>", "(Ljava/lang/String;Landroidx/room/vo/Pojo;)V", "Landroidx/room/vo/ShortcutEntity;", "entity", "Landroidx/room/writer/TypeWriter;", "typeWriter", "dbParam", "Lcom/squareup/javapoet/i;", "createConcrete", "(Landroidx/room/vo/ShortcutEntity;Landroidx/room/writer/TypeWriter;Ljava/lang/String;)Lcom/squareup/javapoet/i;", "Ljava/lang/String;", "getTableName", "()Ljava/lang/String;", "Landroidx/room/vo/Pojo;", "getPojo", "()Landroidx/room/vo/Pojo;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityUpsertionAdapterWriter {
    public static final Companion Companion = null;
    private final Pojo pojo;
    private final String tableName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/writer/EntityUpsertionAdapterWriter$Companion;", "", "()V", "create", "Landroidx/room/writer/EntityUpsertionAdapterWriter;", "entity", "Landroidx/room/vo/ShortcutEntity;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final EntityUpsertionAdapterWriter create(ShortcutEntity r5) {
            Intrinsics.checkNotNullParameter(r5, "entity");
            return new EntityUpsertionAdapterWriter(r5.getTableName(), r5.getPojo(), null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ EntityUpsertionAdapterWriter(String r5, Pojo r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public final i createConcrete(ShortcutEntity r10, TypeWriter r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "entity");
        Intrinsics.checkNotNullParameter(r11, "typeWriter");
        Intrinsics.checkNotNullParameter(r12, "dbParam");
        v r13 = v.n(RoomTypeNames.INSTANCE.getUPSERTION_ADAPTER(), new x[]{XTypeNameKt.toJavaPoet(this.pojo.getTypeName())});
        z r5 = EntityInsertionAdapterWriter.Companion.create(r10, "").createAnonymous(r11, r12);
        z r14 = EntityUpdateAdapterWriter.Companion.create(r10, "").createAnonymous(r11, r12);
        int r15 = i.f14970c;
        g r16 = new g();
        String r17 = Javapoet_extKt.getT();
        String r18 = Javapoet_extKt.getL();
        String r19 = Javapoet_extKt.getL();
        r16.b(j0.q(a.y("new ", r17, "(", r18, ", "), r19, ")"), new Object[]{r13, r5, r14});
        return new i(r16);
    }

    public final Pojo getPojo() {
        return this.pojo;
    }

    public final String getTableName() {
        return this.tableName;
    }

    private EntityUpsertionAdapterWriter(String r5, Pojo r10) {
        this.tableName = r5;
        this.pojo = r10;
    }
}
