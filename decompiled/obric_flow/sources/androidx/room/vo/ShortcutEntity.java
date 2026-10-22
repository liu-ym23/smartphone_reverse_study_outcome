package androidx.room.vo;

import androidx.room.compiler.codegen.XTypeNameKt;
import com.squareup.javapoet.x;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÂ\u0003¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0017\u0010\u001a\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0010R\u001b\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u000bR\u0017\u0010+\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-¨\u0006."}, d2 = {"Landroidx/room/vo/ShortcutEntity;", "", "Landroidx/room/vo/Entity;", "entity", "Landroidx/room/vo/Pojo;", "partialEntity", "<init>", "(Landroidx/room/vo/Entity;Landroidx/room/vo/Pojo;)V", "component1", "()Landroidx/room/vo/Entity;", "component2", "()Landroidx/room/vo/Pojo;", "copy", "(Landroidx/room/vo/Entity;Landroidx/room/vo/Pojo;)Landroidx/room/vo/ShortcutEntity;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/room/vo/Entity;", "Landroidx/room/vo/Pojo;", "tableName", "Ljava/lang/String;", "getTableName", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "entityTypeName", "Lcom/squareup/javapoet/x;", "getEntityTypeName", "()Lcom/squareup/javapoet/x;", "Landroidx/room/vo/PrimaryKey;", "primaryKey$delegate", "Lkotlin/Lazy;", "getPrimaryKey", "()Landroidx/room/vo/PrimaryKey;", "primaryKey", "pojo", "getPojo", "isPartialEntity", "Z", "()Z", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShortcutEntity {
    private final Entity entity;
    private final x entityTypeName;
    private final boolean isPartialEntity;
    private final Pojo partialEntity;
    private final Pojo pojo;
    private final Lazy primaryKey$delegate;
    private final String tableName;

    public ShortcutEntity(Entity r5, Pojo r10) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        this.entity = r5;
        this.partialEntity = r10;
        this.tableName = r5.getTableName();
        this.entityTypeName = XTypeNameKt.toJavaPoet(r5.getTypeName());
        this.primaryKey$delegate = LazyKt.lazy(new ShortcutEntity$primaryKey$2(this));
        Pojo r11 = r5;
        if (r10 == null) goto L6;
        r11 = r10;
    L6:
        this.pojo = r11;
        if (r10 == null) goto L9;
        boolean r12 = true;
    L10:
        this.isPartialEntity = r12;
        return;
    L9:
        r12 = false;
        goto L10
    }

    public static final /* synthetic */ Entity access$getEntity$p(ShortcutEntity r5) {
        return r5.entity;
    }

    public static final /* synthetic */ Pojo access$getPartialEntity$p(ShortcutEntity r5) {
        return r5.partialEntity;
    }

    private final Entity component1() {
        return this.entity;
    }

    private final Pojo component2() {
        return this.partialEntity;
    }

    public static /* synthetic */ ShortcutEntity copy$default(ShortcutEntity r5, Entity r10, Pojo r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.entity;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.partialEntity;
    L9:
        return r5.copy(r10, r11);
    }

    public final ShortcutEntity copy(Entity r5, Pojo r10) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        return new ShortcutEntity(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShortcutEntity) == true) goto L8;
        return false;
    L8:
        ShortcutEntity r10 = (ShortcutEntity) r5;
        if (Intrinsics.areEqual(this.entity, r10.entity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.partialEntity, r10.partialEntity) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final x getEntityTypeName() {
        return this.entityTypeName;
    }

    public final Pojo getPojo() {
        return this.pojo;
    }

    public final PrimaryKey getPrimaryKey() {
        return (PrimaryKey) this.primaryKey$delegate.getValue();
    }

    public final String getTableName() {
        return this.tableName;
    }

    public int hashCode() {
        int r5 = this.entity.hashCode() * 31;
        Pojo r10 = this.partialEntity;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final boolean isPartialEntity() {
        return this.isPartialEntity;
    }

    public String toString() {
        return "ShortcutEntity(entity=" + this.entity + ", partialEntity=" + this.partialEntity + ")";
    }
}
