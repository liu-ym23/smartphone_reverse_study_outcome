package androidx.room.vo;

import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.processor.DatabaseViewProcessor;
import androidx.room.processor.EntityProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0007R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Landroidx/room/vo/Pojo;", "Landroidx/room/vo/HasFields;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "type", "Landroidx/room/compiler/processing/XType;", "fields", "", "Landroidx/room/vo/Field;", "embeddedFields", "Landroidx/room/vo/EmbeddedField;", "relations", "Landroidx/room/vo/Relation;", "constructor", "Landroidx/room/vo/Constructor;", "(Landroidx/room/compiler/processing/XTypeElement;Landroidx/room/compiler/processing/XType;Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/room/vo/Constructor;)V", "getConstructor", "()Landroidx/room/vo/Constructor;", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "getEmbeddedFields", "()Ljava/util/List;", "Landroidx/room/vo/Fields;", "getFields", "()Landroidx/room/vo/Fields;", "getRelations", "getType", "()Landroidx/room/compiler/processing/XType;", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "getTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "typeName$delegate", "Lkotlin/Lazy;", "accessedTableNames", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class Pojo implements HasFields {
    private final Constructor constructor;
    private final XTypeElement element;
    private final List<EmbeddedField> embeddedFields;
    private final Fields fields;
    private final List<Relation> relations;
    private final XType type;
    private final Lazy typeName$delegate;

    public Pojo(XTypeElement r5, XType r10, List<Field> r11, List<EmbeddedField> r12, List<Relation> r13, Constructor r14) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "fields");
        Intrinsics.checkNotNullParameter(r12, "embeddedFields");
        Intrinsics.checkNotNullParameter(r13, "relations");
        this.element = r5;
        this.type = r10;
        this.embeddedFields = r12;
        this.relations = r13;
        this.constructor = r14;
        this.typeName$delegate = LazyKt.lazy(new Pojo$typeName$2(this));
        this.fields = new Fields(r11);
    }

    public final List<String> accessedTableNames() {
        XAnnotationBox r5 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Entity.class));
        if (r5 != null) goto L21;
        XAnnotationBox r10 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.DatabaseView.class));
        if (r10 == null) goto L8;
        List r11 = CollectionsKt.listOf(DatabaseViewProcessor.Companion.extractViewName(this.element, (androidx.room.DatabaseView) r10.getValue()));
    L9:
        List<EmbeddedField> r12 = this.embeddedFields;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        CollectionsKt.a(r13, ((EmbeddedField) r14.next()).getPojo().accessedTableNames());
        goto L11
    L13:
        List r15 = CollectionsKt.plus(r11, r13);
        List<Relation> r16 = this.relations;
        ArrayList r17 = new ArrayList(CollectionsKt.h(r16));
        Iterator<T> r18 = r16.iterator();
    L15:
        if (r18.hasNext() == false) goto L18;
        r17.add(((Relation) r18.next()).getEntity().getTableName());
        goto L15
    L18:
        return CollectionsKt.plus(r15, r17);
    L8:
        r11 = CollectionsKt.emptyList();
        goto L9
    L21:
        return CollectionsKt.listOf(EntityProcessor.Companion.extractTableName(this.element, (androidx.room.Entity) r5.getValue()));
    }

    public final Constructor getConstructor() {
        return this.constructor;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    public final List<EmbeddedField> getEmbeddedFields() {
        return this.embeddedFields;
    }

    @Override // androidx.room.vo.HasFields
    public Fields getFields() {
        return this.fields;
    }

    public final List<Relation> getRelations() {
        return this.relations;
    }

    public final XType getType() {
        return this.type;
    }

    public final XTypeName getTypeName() {
        return (XTypeName) this.typeName$delegate.getValue();
    }

    public /* synthetic */ Pojo(XTypeElement r10, XType r11, List r12, List r13, List r14, Constructor r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 32) == 0) goto L5;
        r15 = null;
    L5:
        this(r10, r11, r12, r13, r14, r15);
    }
}
