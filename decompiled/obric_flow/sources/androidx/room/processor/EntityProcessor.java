package androidx.room.processor;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.vo.ForeignKeyAction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/room/processor/EntityProcessor;", "Landroidx/room/processor/EntityOrViewProcessor;", "process", "Landroidx/room/vo/Entity;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface EntityProcessor extends EntityOrViewProcessor {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\f¨\u0006\u0012"}, d2 = {"Landroidx/room/processor/EntityProcessor$Companion;", "", "()V", "createIndexName", "", "columnNames", "", "tableName", "extractForeignKeys", "Landroidx/room/processor/ForeignKeyInput;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "Landroidx/room/Entity;", "extractIndices", "Landroidx/room/processor/IndexInput;", "extractTableName", "element", "Landroidx/room/compiler/processing/XTypeElement;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final String createIndexName(List<String> r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "columnNames");
            Intrinsics.checkNotNullParameter(r11, "tableName");
            return androidx.constraintlayout.motion.widget.a.p("index_", r11, "_", CollectionsKt.q(r10, "_", null, null, 0, null, null, 62));
        }

        public final List<ForeignKeyInput> extractForeignKeys(XAnnotationBox<Entity> r13) {
            Intrinsics.checkNotNullParameter(r13, "annotation");
            XAnnotationBox<Entity>[] r12 = r13.getAsAnnotationBoxArray("foreignKeys");
            ArrayList r14 = new ArrayList();
            int r5 = r12.length;
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L11;
            XAnnotationBox<Entity> r11 = r12[r10];
            ForeignKey r15 = (ForeignKey) r11.getValue();
            XType r16 = r11.getAsType("entity");
            if (r16 == null) goto L7;
            List r17 = ArraysKt.asList(r15.parentColumns());
            List r18 = ArraysKt.asList(r15.childColumns());
            ForeignKeyAction.Companion r19 = ForeignKeyAction.Companion;
            ForeignKeyInput r20 = new ForeignKeyInput(r16, r17, r18, r19.fromAnnotationValue(Integer.valueOf(r15.onDelete())), r19.fromAnnotationValue(Integer.valueOf(r15.onUpdate())), r15.deferred());
        L8:
            if (r20 == null) goto L10;
            r14.add(r20);
        L10:
            r10 = r10 + 1;
            goto L3
        L7:
            r20 = null;
            goto L8
        L11:
            return r14;
        }

        public final List<IndexInput> extractIndices(XAnnotationBox<Entity> r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "annotation");
            Intrinsics.checkNotNullParameter(r11, "tableName");
            XAnnotationBox<Entity>[] r12 = r10.getAsAnnotationBoxArray("indices");
            ArrayList r13 = new ArrayList(r12.length);
            int r5 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r5) goto L8;
            Index r15 = (Index) r12[r14].getValue();
            String r16 = r15.name();
            List<String> r17 = ArraysKt.asList(r15.value());
            List r18 = ArraysKt.asList(r15.orders());
            if (Intrinsics.areEqual(r16, "") == false) goto L7;
            r16 = $$INSTANCE.createIndexName(r17, r11);
        L7:
            r13.add(new IndexInput(r16, r15.unique(), r17, r18));
            r14 = r14 + 1;
            goto L3
        L8:
            return r13;
        }

        public final String extractTableName(XTypeElement r5, Entity r10) {
            Intrinsics.checkNotNullParameter(r5, "element");
            Intrinsics.checkNotNullParameter(r10, "annotation");
            if (Intrinsics.areEqual(r10.tableName(), "") == false) goto L6;
            return r5.getName();
        L6:
            return r10.tableName();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // androidx.room.processor.EntityOrViewProcessor
    androidx.room.vo.Entity process();
}
