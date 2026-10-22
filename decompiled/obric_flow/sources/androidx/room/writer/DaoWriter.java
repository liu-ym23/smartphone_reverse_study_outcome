package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.codegen.XTypeSpec;
import androidx.room.compiler.processing.MethodSpecHelper;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.String_extKt;
import androidx.room.processor.OnConflictProcessor;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.KotlinDefaultMethodDelegateBinder;
import androidx.room.solver.query.parameter.QueryParameterAdapter;
import androidx.room.solver.types.CustomTypeConverterWrapperKt;
import androidx.room.vo.Dao;
import androidx.room.vo.DeleteOrUpdateShortcutMethod;
import androidx.room.vo.InsertionMethod;
import androidx.room.vo.KotlinBoxedPrimitiveMethodDelegate;
import androidx.room.vo.KotlinDefaultMethodDelegate;
import androidx.room.vo.QueryMethod;
import androidx.room.vo.QueryParameter;
import androidx.room.vo.RawQueryMethod;
import androidx.room.vo.ReadQueryMethod;
import androidx.room.vo.ShortcutEntity;
import androidx.room.vo.TransactionMethod;
import androidx.room.vo.UpdateMethod;
import androidx.room.vo.UpsertionMethod;
import androidx.room.vo.WriteQueryMethod;
import com.bytedance.ai.event.MessageIndication;
import com.squareup.javapoet.b0;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.l;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.u;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import com.squareup.javapoet.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 d2\u00020\u0001:\u0006defghiB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J-\u0010'\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0002¢\u0006\u0004\b1\u0010\u001eJ7\u00109\u001a\u0002082\u0006\u0010\u0016\u001a\u0002022\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002060503H\u0002¢\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0002¢\u0006\u0004\b;\u0010\u001eJ\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0002¢\u0006\u0004\b<\u0010\u001eJO\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010\"\b\b\u0000\u0010>*\u00020=2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010@\u001a\u0002042\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u0002060AH\u0002¢\u0006\u0004\bD\u0010EJ7\u0010G\u001a\u0002082\u0006\u0010\u0016\u001a\u00020=2\u001e\u0010F\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002060503H\u0002¢\u0006\u0004\bG\u0010HJ\u0015\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0002¢\u0006\u0004\bI\u0010\u001eJ7\u0010L\u001a\u0002082\u0006\u0010\u0016\u001a\u00020J2\u001e\u0010K\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002080503H\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u001b\u001a\u0002082\u0006\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001b\u0010NJ\u0017\u0010O\u001a\u0002082\u0006\u0010\u0016\u001a\u00020)H\u0002¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020QH\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020TH\u0002¢\u0006\u0004\bU\u0010VJ\u001f\u0010\\\u001a\u00020[2\u0006\u0010X\u001a\u00020W2\u0006\u0010Z\u001a\u00020YH\u0002¢\u0006\u0004\b\\\u0010]R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010^\u001a\u0004\b_\u0010`R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010aR\u0014\u0010b\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010c¨\u0006j"}, d2 = {"Landroidx/room/writer/DaoWriter;", "Landroidx/room/writer/TypeWriter;", "Landroidx/room/vo/Dao;", "dao", "Landroidx/room/compiler/processing/XElement;", "dbElement", "Landroidx/room/compiler/codegen/CodeLanguage;", "codeLanguage", "<init>", "(Landroidx/room/vo/Dao;Landroidx/room/compiler/processing/XElement;Landroidx/room/compiler/codegen/CodeLanguage;)V", "Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "createTypeSpecBuilder", "()Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "Lcom/squareup/javapoet/t;", "createConverterListMethod", "()Lcom/squareup/javapoet/t;", "", "Landroidx/room/vo/WriteQueryMethod;", "preparedQueries", "Landroidx/room/writer/DaoWriter$PreparedStmtQuery;", "createPreparedQueries", "(Ljava/util/List;)Ljava/util/List;", "method", "Lcom/squareup/javapoet/m;", "preparedStmtField", "Landroidx/room/writer/QueryWriter;", "queryWriter", "createPreparedQueryMethodBody", "(Landroidx/room/vo/WriteQueryMethod;Lcom/squareup/javapoet/m;Landroidx/room/writer/QueryWriter;)Lcom/squareup/javapoet/t;", "createTransactionMethods", "()Ljava/util/List;", "Landroidx/room/vo/TransactionMethod;", "createTransactionMethodBody", "(Landroidx/room/vo/TransactionMethod;)Lcom/squareup/javapoet/t;", "Lcom/squareup/javapoet/u;", "dbParam", "shortcutMethods", "", "callSuper", "createConstructor", "(Lcom/squareup/javapoet/u;Ljava/util/List;Z)Lcom/squareup/javapoet/t;", "Landroidx/room/vo/ReadQueryMethod;", "createSelectMethod", "(Landroidx/room/vo/ReadQueryMethod;)Lcom/squareup/javapoet/t;", "Landroidx/room/vo/RawQueryMethod;", "createRawQueryMethod", "(Landroidx/room/vo/RawQueryMethod;)Lcom/squareup/javapoet/t;", "createPreparedQueryMethod", "(Landroidx/room/vo/WriteQueryMethod;)Lcom/squareup/javapoet/t;", "createInsertionMethods", "Landroidx/room/vo/InsertionMethod;", "", "", "Lkotlin/Pair;", "Lcom/squareup/javapoet/z;", "insertionAdapters", "Lcom/squareup/javapoet/i;", "createInsertionMethodBody", "(Landroidx/room/vo/InsertionMethod;Ljava/util/Map;)Lcom/squareup/javapoet/i;", "createDeletionMethods", "createUpdateMethods", "Landroidx/room/vo/DeleteOrUpdateShortcutMethod;", ExifInterface.GPS_DIRECTION_TRUE, "methods", "methodPrefix", "Lkotlin/Function2;", "Landroidx/room/vo/ShortcutEntity;", "implCallback", "createShortcutMethods", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "adapters", "createDeleteOrUpdateMethodBody", "(Landroidx/room/vo/DeleteOrUpdateShortcutMethod;Ljava/util/Map;)Lcom/squareup/javapoet/i;", "createUpsertMethods", "Landroidx/room/vo/UpsertionMethod;", "upsertionAdapters", "createUpsertionMethodBody", "(Landroidx/room/vo/UpsertionMethod;Ljava/util/Map;)Lcom/squareup/javapoet/i;", "(Landroidx/room/vo/WriteQueryMethod;)Lcom/squareup/javapoet/i;", "createQueryMethodBody", "(Landroidx/room/vo/ReadQueryMethod;)Lcom/squareup/javapoet/i;", "Landroidx/room/vo/KotlinDefaultMethodDelegate;", "createDefaultMethodDelegate", "(Landroidx/room/vo/KotlinDefaultMethodDelegate;)Lcom/squareup/javapoet/t;", "Landroidx/room/vo/KotlinBoxedPrimitiveMethodDelegate;", "createDelegatingMethod", "(Landroidx/room/vo/KotlinBoxedPrimitiveMethodDelegate;)Lcom/squareup/javapoet/t;", "Landroidx/room/compiler/processing/XMethodElement;", "elm", "Landroidx/room/compiler/processing/XType;", "owner", "Lcom/squareup/javapoet/s;", "overrideWithoutAnnotations", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XType;)Lcom/squareup/javapoet/s;", "Landroidx/room/vo/Dao;", "getDao", "()Landroidx/room/vo/Dao;", "Landroidx/room/compiler/processing/XElement;", "declaredDao", "Landroidx/room/compiler/processing/XType;", "Companion", "DeleteOrUpdateAdapterField", "InsertionMethodField", "PreparedStatementField", "PreparedStmtQuery", "UpsertionAdapterField", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DaoWriter extends TypeWriter {
    public static final Companion Companion = null;
    public static final String GET_LIST_OF_TYPE_CONVERTERS_METHOD = "getRequiredConverters";
    private static final m dbField = null;
    private final Dao dao;
    private final XElement dbElement;
    private final XType declaredDao;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/room/writer/DaoWriter$Companion;", "", "<init>", "()V", "Landroidx/room/vo/ShortcutEntity;", "shortcutEntity", "", "shortcutEntityFieldNamePart", "(Landroidx/room/vo/ShortcutEntity;)Ljava/lang/String;", "Lcom/squareup/javapoet/x;", "typeName", "typeNameToFieldName", "(Lcom/squareup/javapoet/x;)Ljava/lang/String;", "Lcom/squareup/javapoet/m;", "dbField", "Lcom/squareup/javapoet/m;", "getDbField", "()Lcom/squareup/javapoet/m;", "GET_LIST_OF_TYPE_CONVERTERS_METHOD", "Ljava/lang/String;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ String access$shortcutEntityFieldNamePart(Companion r5, ShortcutEntity r10) {
            return r5.shortcutEntityFieldNamePart(r10);
        }

        private final String shortcutEntityFieldNamePart(ShortcutEntity r5) {
            if (r5.isPartialEntity() == false) goto L6;
            return j0.D(typeNameToFieldName(XTypeNameKt.toJavaPoet(r5.getPojo().getTypeName())), "As", typeNameToFieldName(r5.getEntityTypeName()));
        L6:
            return typeNameToFieldName(r5.getEntityTypeName());
        }

        private final String typeNameToFieldName(x r5) {
            if ((r5 instanceof e) == false) goto L6;
            return ((e) r5).f14961y;
        L6:
            return String_extKt.stripNonJava(StringsKt.E(String.valueOf(r5), '.', '_'));
        }

        public final m getDbField() {
            return DaoWriter.access$getDbField$cp();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/room/writer/DaoWriter$DeleteOrUpdateAdapterField;", "Landroidx/room/writer/TypeWriter$SharedFieldSpec;", "Landroidx/room/vo/ShortcutEntity;", "shortcutEntity", "", "methodPrefix", "onConflictText", "<init>", "(Landroidx/room/vo/ShortcutEntity;Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/room/writer/TypeWriter;", "writer", "Lcom/squareup/javapoet/l;", "builder", "", MessageIndication.STATUS_PREPARE, "(Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/l;)V", "getUniqueKey", "()Ljava/lang/String;", "Landroidx/room/vo/ShortcutEntity;", "getShortcutEntity", "()Landroidx/room/vo/ShortcutEntity;", "Ljava/lang/String;", "getMethodPrefix", "getOnConflictText", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DeleteOrUpdateAdapterField extends TypeWriter.SharedFieldSpec {
        private final String methodPrefix;
        private final String onConflictText;
        private final ShortcutEntity shortcutEntity;

        public DeleteOrUpdateAdapterField(ShortcutEntity r5, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r5, "shortcutEntity");
            Intrinsics.checkNotNullParameter(r10, "methodPrefix");
            Intrinsics.checkNotNullParameter(r11, "onConflictText");
            super(j0.D(r10, "AdapterOf", Companion.access$shortcutEntityFieldNamePart(DaoWriter.Companion, r5)), v.n(RoomTypeNames.INSTANCE.getDELETE_OR_UPDATE_ADAPTER(), new x[]{XTypeNameKt.toJavaPoet(r5.getPojo().getTypeName())}));
            this.shortcutEntity = r5;
            this.methodPrefix = r10;
            this.onConflictText = r11;
        }

        public final String getMethodPrefix() {
            return this.methodPrefix;
        }

        public final String getOnConflictText() {
            return this.onConflictText;
        }

        public final ShortcutEntity getShortcutEntity() {
            return this.shortcutEntity;
        }

        @Override // androidx.room.writer.TypeWriter.SharedFieldSpec
        public String getUniqueKey() {
            return XTypeNameKt.toJavaPoet(this.shortcutEntity.getPojo().getTypeName()) + PreparedStmtQuery.NO_PARAM_FIELD + this.shortcutEntity.getEntityTypeName() + this.methodPrefix + this.onConflictText;
        }

        @Override // androidx.room.writer.TypeWriter.SharedFieldSpec
        public void prepare(TypeWriter r5, l r10) {
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r10, "builder");
            r10.b(new Modifier[]{Modifier.PRIVATE, Modifier.FINAL});
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Landroidx/room/writer/DaoWriter$InsertionMethodField;", "Landroidx/room/writer/TypeWriter$SharedFieldSpec;", "Landroidx/room/vo/ShortcutEntity;", "shortcutEntity", "", "onConflictText", "<init>", "(Landroidx/room/vo/ShortcutEntity;Ljava/lang/String;)V", "getUniqueKey", "()Ljava/lang/String;", "Landroidx/room/writer/TypeWriter;", "writer", "Lcom/squareup/javapoet/l;", "builder", "", MessageIndication.STATUS_PREPARE, "(Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/l;)V", "Landroidx/room/vo/ShortcutEntity;", "getShortcutEntity", "()Landroidx/room/vo/ShortcutEntity;", "Ljava/lang/String;", "getOnConflictText", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InsertionMethodField extends TypeWriter.SharedFieldSpec {
        private final String onConflictText;
        private final ShortcutEntity shortcutEntity;

        public InsertionMethodField(ShortcutEntity r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "shortcutEntity");
            Intrinsics.checkNotNullParameter(r10, "onConflictText");
            super(j0.C("insertionAdapterOf", Companion.access$shortcutEntityFieldNamePart(DaoWriter.Companion, r5)), v.n(RoomTypeNames.INSTANCE.getINSERTION_ADAPTER(), new x[]{XTypeNameKt.toJavaPoet(r5.getPojo().getTypeName())}));
            this.shortcutEntity = r5;
            this.onConflictText = r10;
        }

        public final String getOnConflictText() {
            return this.onConflictText;
        }

        public final ShortcutEntity getShortcutEntity() {
            return this.shortcutEntity;
        }

        @Override // androidx.room.writer.TypeWriter.SharedFieldSpec
        public String getUniqueKey() {
            return XTypeNameKt.toJavaPoet(this.shortcutEntity.getPojo().getTypeName()) + PreparedStmtQuery.NO_PARAM_FIELD + this.shortcutEntity.getEntityTypeName() + this.onConflictText;
        }

        @Override // androidx.room.writer.TypeWriter.SharedFieldSpec
        public void prepare(TypeWriter r5, l r10) {
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r10, "builder");
            r10.b(new Modifier[]{Modifier.FINAL, Modifier.PRIVATE});
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/room/writer/DaoWriter$PreparedStatementField;", "Landroidx/room/writer/TypeWriter$SharedFieldSpec;", "Landroidx/room/vo/QueryMethod;", "method", "<init>", "(Landroidx/room/vo/QueryMethod;)V", "Landroidx/room/writer/TypeWriter;", "writer", "Lcom/squareup/javapoet/l;", "builder", "", MessageIndication.STATUS_PREPARE, "(Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/l;)V", "", "getUniqueKey", "()Ljava/lang/String;", "Landroidx/room/vo/QueryMethod;", "getMethod", "()Landroidx/room/vo/QueryMethod;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PreparedStatementField extends TypeWriter.SharedFieldSpec {
        private final QueryMethod method;

        public PreparedStatementField(QueryMethod r5) {
            Intrinsics.checkNotNullParameter(r5, "method");
            super(j0.C("preparedStmtOf", String_extKt.capitalize(r5.getElement().getJvmName(), Locale.US)), RoomTypeNames.INSTANCE.getSHARED_SQLITE_STMT());
            this.method = r5;
        }

        public final QueryMethod getMethod() {
            return this.method;
        }

        @Override // androidx.room.writer.TypeWriter.SharedFieldSpec
        public String getUniqueKey() {
            return this.method.getQuery().getOriginal();
        }

        @Override // androidx.room.writer.TypeWriter.SharedFieldSpec
        public void prepare(TypeWriter r5, l r10) {
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r10, "builder");
            r10.b(new Modifier[]{Modifier.PRIVATE, Modifier.FINAL});
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ(\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ<\u0010\u000f\u001a\u00020\u00002 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R/\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000e¨\u0006\u001f"}, d2 = {"Landroidx/room/writer/DaoWriter$PreparedStmtQuery;", "", "", "", "Lkotlin/Pair;", "Lcom/squareup/javapoet/m;", "fields", "Lcom/squareup/javapoet/t;", "methodImpl", "<init>", "(Ljava/util/Map;Lcom/squareup/javapoet/t;)V", "component1", "()Ljava/util/Map;", "component2", "()Lcom/squareup/javapoet/t;", "copy", "(Ljava/util/Map;Lcom/squareup/javapoet/t;)Landroidx/room/writer/DaoWriter$PreparedStmtQuery;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getFields", "Lcom/squareup/javapoet/t;", "getMethodImpl", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PreparedStmtQuery {
        public static final Companion Companion = null;
        public static final String NO_PARAM_FIELD = "-";
        private final Map<String, Pair<m, Object>> fields;
        private final t methodImpl;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/writer/DaoWriter$PreparedStmtQuery$Companion;", "", "()V", "NO_PARAM_FIELD", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PreparedStmtQuery(Map<String, ? extends Pair<m, ? extends Object>> r5, t r10) {
            Intrinsics.checkNotNullParameter(r5, "fields");
            Intrinsics.checkNotNullParameter(r10, "methodImpl");
            this.fields = r5;
            this.methodImpl = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PreparedStmtQuery copy$default(PreparedStmtQuery r5, Map r10, t r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.fields;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.methodImpl;
        L9:
            return r5.copy(r10, r11);
        }

        public final Map<String, Pair<m, Object>> component1() {
            return this.fields;
        }

        public final t component2() {
            return this.methodImpl;
        }

        public final PreparedStmtQuery copy(Map<String, ? extends Pair<m, ? extends Object>> r5, t r10) {
            Intrinsics.checkNotNullParameter(r5, "fields");
            Intrinsics.checkNotNullParameter(r10, "methodImpl");
            return new PreparedStmtQuery(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PreparedStmtQuery) == true) goto L8;
            return false;
        L8:
            PreparedStmtQuery r10 = (PreparedStmtQuery) r5;
            if (Intrinsics.areEqual(this.fields, r10.fields) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.methodImpl, r10.methodImpl) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final Map<String, Pair<m, Object>> getFields() {
            return this.fields;
        }

        public final t getMethodImpl() {
            return this.methodImpl;
        }

        public int hashCode() {
            int r5 = this.fields.hashCode() * 31;
            return this.methodImpl.hashCode() + r5;
        }

        public String toString() {
            return "PreparedStmtQuery(fields=" + this.fields + ", methodImpl=" + this.methodImpl + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/room/writer/DaoWriter$UpsertionAdapterField;", "Landroidx/room/writer/TypeWriter$SharedFieldSpec;", "Landroidx/room/vo/ShortcutEntity;", "shortcutEntity", "<init>", "(Landroidx/room/vo/ShortcutEntity;)V", "", "getUniqueKey", "()Ljava/lang/String;", "Landroidx/room/writer/TypeWriter;", "writer", "Lcom/squareup/javapoet/l;", "builder", "", MessageIndication.STATUS_PREPARE, "(Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/l;)V", "Landroidx/room/vo/ShortcutEntity;", "getShortcutEntity", "()Landroidx/room/vo/ShortcutEntity;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class UpsertionAdapterField extends TypeWriter.SharedFieldSpec {
        private final ShortcutEntity shortcutEntity;

        public UpsertionAdapterField(ShortcutEntity r5) {
            Intrinsics.checkNotNullParameter(r5, "shortcutEntity");
            super(j0.C("upsertionAdapterOf", Companion.access$shortcutEntityFieldNamePart(DaoWriter.Companion, r5)), v.n(RoomTypeNames.INSTANCE.getUPSERTION_ADAPTER(), new x[]{XTypeNameKt.toJavaPoet(r5.getPojo().getTypeName())}));
            this.shortcutEntity = r5;
        }

        public final ShortcutEntity getShortcutEntity() {
            return this.shortcutEntity;
        }

        @Override // androidx.room.writer.TypeWriter.SharedFieldSpec
        public String getUniqueKey() {
            return XTypeNameKt.toJavaPoet(this.shortcutEntity.getPojo().getTypeName()) + PreparedStmtQuery.NO_PARAM_FIELD + this.shortcutEntity.getEntityTypeName();
        }

        @Override // androidx.room.writer.TypeWriter.SharedFieldSpec
        public void prepare(TypeWriter r5, l r10) {
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r10, "builder");
            r10.b(new Modifier[]{Modifier.PRIVATE, Modifier.FINAL});
        }
    }

    static {
        Companion = new Companion(null);
        dbField = m.a(RoomTypeNames.INSTANCE.getROOM_DB(), "__db", new Modifier[]{Modifier.PRIVATE, Modifier.FINAL}).c();
    }

    public DaoWriter(Dao r5, XElement r10, CodeLanguage r11) {
        Intrinsics.checkNotNullParameter(r5, "dao");
        Intrinsics.checkNotNullParameter(r10, "dbElement");
        Intrinsics.checkNotNullParameter(r11, "codeLanguage");
        super(r11);
        this.dao = r5;
        this.dbElement = r10;
        this.declaredDao = r5.getElement().getType();
    }

    public static final /* synthetic */ t access$createConstructor(DaoWriter r5, u r10, List r11, boolean r12) {
        return r5.createConstructor(r10, r11, r12);
    }

    public static final /* synthetic */ t access$createConverterListMethod(DaoWriter r5) {
        return r5.createConverterListMethod();
    }

    public static final /* synthetic */ t access$createDefaultMethodDelegate(DaoWriter r5, KotlinDefaultMethodDelegate r10) {
        return r5.createDefaultMethodDelegate(r10);
    }

    public static final /* synthetic */ t access$createDelegatingMethod(DaoWriter r5, KotlinBoxedPrimitiveMethodDelegate r10) {
        return r5.createDelegatingMethod(r10);
    }

    public static final /* synthetic */ t access$createPreparedQueryMethod(DaoWriter r5, WriteQueryMethod r10) {
        return r5.createPreparedQueryMethod(r10);
    }

    public static final /* synthetic */ t access$createRawQueryMethod(DaoWriter r5, RawQueryMethod r10) {
        return r5.createRawQueryMethod(r10);
    }

    public static final /* synthetic */ t access$createSelectMethod(DaoWriter r5, ReadQueryMethod r10) {
        return r5.createSelectMethod(r10);
    }

    public static final /* synthetic */ XElement access$getDbElement$p(DaoWriter r5) {
        return r5.dbElement;
    }

    public static final /* synthetic */ m access$getDbField$cp() {
        return dbField;
    }

    private final t createConstructor(u r5, List<PreparedStmtQuery> r10, boolean r11) {
        s r12 = t.a();
        r12.m(r5);
        r12.l(new Modifier[]{Modifier.PUBLIC});
        if (r11 == false) goto L5;
        r12.o(j0.k("super(", Javapoet_extKt.getN(), ")"), new Object[]{r5});
    L5:
        r12.o(a.p("this.", Javapoet_extKt.getN(), " = ", Javapoet_extKt.getN()), new Object[]{dbField, r5});
        Sequence r13 = SequencesKt.flattenSequenceOfIterable(SequencesKt.map(SequencesKt.filterNot(CollectionsKt.asSequence(r10), DaoWriter$createConstructor$1$1.INSTANCE), DaoWriter$createConstructor$1$2.INSTANCE));
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r15 = r13.iterator();
    L7:
        if (r15.hasNext() == false) goto L12;
        Object r16 = r15.next();
        String r17 = ((m) ((Pair) r16).getFirst()).f14992b;
        Object r18 = r14.get(r17);
        if (r18 != null) goto L11;
        r18 = new ArrayList();
        r14.put(r17, r18);
    L11:
        ((List) r18).add(r16);
        goto L7
    L12:
        ArrayList r19 = new ArrayList(r14.size());
        Iterator r20 = r14.entrySet().iterator();
    L14:
        if (r20.hasNext() == false) goto L16;
        r19.add((Pair) CollectionsKt.first((List) ((Map.Entry) r20.next()).getValue()));
        goto L14
    L16:
        Iterator r21 = r19.iterator();
    L18:
        if (r21.hasNext() == false) goto L21;
        Pair r22 = (Pair) r21.next();
        r12.o(a.p("this.", Javapoet_extKt.getN(), " = ", Javapoet_extKt.getL()), new Object[]{r22.getFirst(), r22.getSecond()});
        goto L18
    L21:
        return r12.r();
    }

    private final t createConverterListMethod() {
        s r5 = t.e(GET_LIST_OF_TYPE_CONVERTERS_METHOD);
        r5.l(new Modifier[]{Modifier.STATIC, Modifier.PUBLIC});
        r5.v(v.n(CommonTypeNames.INSTANCE.getLIST(), new x[]{v.n(e.n(Class.class), new x[]{b0.n()})}));
        Set<e> r11 = CustomTypeConverterWrapperKt.getRequiredTypeConverters(this);
        if (r11.isEmpty() == false) goto L5;
        r5.o(j0.k("return ", Javapoet_extKt.getT(), ".emptyList()"), new Object[]{e.n(Collections.class)});
    L7:
        return r5.r();
    L5:
        String r10 = CollectionsKt.q(r11, ",", null, null, 0, null, DaoWriter$createConverterListMethod$1$placeholders$1.INSTANCE, 30);
        e[] r12 = (e[]) ArraysKt.plus(new e[]{e.n(Arrays.class)}, r11);
        r5.o(j0.l("return ", Javapoet_extKt.getT(), ".asList(", r10, ")"), Arrays.copyOf(r12, r12.length));
        goto L7
    }

    private final t createDefaultMethodDelegate(KotlinDefaultMethodDelegate r10) {
        CodeGenScope r11 = new CodeGenScope(this);
        s r12 = overrideWithoutAnnotations(r10.getElement(), this.declaredDao);
        KotlinDefaultMethodDelegateBinder r5 = KotlinDefaultMethodDelegateBinder.INSTANCE;
        e r13 = XTypeNameKt.toJavaPoet(this.dao.getTypeName());
        e r14 = XTypeNameKt.toJavaPoet(this.dao.getImplTypeName());
        String r15 = r10.getElement().getJvmName();
        XType r16 = r10.getElement().getReturnType();
        List<XExecutableParameterElement> r17 = r10.getElement().getParameters();
        ArrayList r18 = new ArrayList(CollectionsKt.h(r17));
        Iterator<T> r19 = r17.iterator();
    L4:
        if (r19.hasNext() == false) goto L6;
        r18.add(((XExecutableParameterElement) r19.next()).getName());
        goto L4
    L6:
        r5.executeAndReturn(r13, r14, r15, r16, r18, r11);
        g r20 = r11.builder();
        r20.getClass();
        i r110 = new i(r20);
        r12.e.a(r110);
        return new t(r12);
    }

    private final t createDelegatingMethod(KotlinBoxedPrimitiveMethodDelegate r10) {
        s r11 = overrideWithoutAnnotations(r10.getElement(), this.declaredDao);
        List<XExecutableParameterElement> r5 = r10.getConcreteMethod().getParameters();
        ArrayList r12 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r13 = r5.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        XExecutableParameterElement r14 = (XExecutableParameterElement) r13.next();
        x r15 = r14.getType().getTypeName();
        if (r15.j() == false) goto L8;
        i r16 = i.d(String.valueOf(Javapoet_extKt.getL()), new Object[]{r15, r14.getName().toString()});
    L9:
        r12.add(r16);
        goto L4
    L8:
        r16 = i.d(a.p("(", Javapoet_extKt.getT(), ") ", Javapoet_extKt.getL()), new Object[]{r15.m(), r14.getName().toString()});
        goto L9
    L11:
        if (XTypeKt.isVoid(r10.getElement().getReturnType()) == false) goto L13;
        r11.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), "(", Javapoet_extKt.getL(), ")"), new Object[]{r10.getElement().getJvmName(), i.c("," + Javapoet_extKt.getW(), r12)});
    L14:
        r11.getClass();
        return new t(r11);
    L13:
        r11.o(j0.l("return ", Javapoet_extKt.getL(), "(", Javapoet_extKt.getL(), ")"), new Object[]{r10.getElement().getJvmName(), i.c("," + Javapoet_extKt.getW(), r12)});
        goto L14
    }

    private final i createDeleteOrUpdateMethodBody(DeleteOrUpdateShortcutMethod r5, Map<String, Pair<m, z>> r10) {
        if (r10.isEmpty() == false) goto L5;
    L9:
        int r11 = i.f14970c;
        return new i(new g());
    L5:
        if (r5.getMethodBinder() == null) goto L9;
        CodeGenScope r12 = new CodeGenScope(this);
        r5.getMethodBinder().convertAndReturn(r5.getParameters(), r10, dbField, r12);
        g r13 = r12.builder();
        r13.getClass();
        return new i(r13);
    }

    private final List<PreparedStmtQuery> createDeletionMethods() {
        return createShortcutMethods(this.dao.getDeletionMethods(), "deletion", new AnonymousClass1(this));
    }

    private final i createInsertionMethodBody(InsertionMethod r5, Map<String, Pair<m, z>> r10) {
        if (r10.isEmpty() == false) goto L5;
    L9:
        int r11 = i.f14970c;
        return new i(new g());
    L5:
        if (r5.getMethodBinder() == null) goto L9;
        CodeGenScope r12 = new CodeGenScope(this);
        r5.getMethodBinder().convertAndReturn(r5.getParameters(), r10, dbField, r12);
        g r13 = r12.builder();
        r13.getClass();
        return new i(r13);
    }

    private final List<PreparedStmtQuery> createInsertionMethods() {
        List<InsertionMethod> r5 = this.dao.getInsertionMethods();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        InsertionMethod r12 = (InsertionMethod) r11.next();
        String r13 = OnConflictProcessor.INSTANCE.onConflictText(r12.getOnConflict());
        Map<String, ShortcutEntity> r14 = r12.getEntities();
        LinkedHashMap r15 = new LinkedHashMap(MapsKt.mapCapacity(r14.size()));
        Iterator<T> r16 = r14.entrySet().iterator();
    L7:
        if (r16.hasNext() == false) goto L9;
        Map.Entry r17 = (Map.Entry) r16.next();
        r15.put(r17.getKey(), TuplesKt.to(getOrCreateField(new InsertionMethodField((ShortcutEntity) r17.getValue(), r13)), EntityInsertionAdapterWriter.Companion.create((ShortcutEntity) r17.getValue(), r13).createAnonymous(this, dbField.f14992b)));
        goto L7
    L9:
        s r18 = overrideWithoutAnnotations(r12.getElement(), this.declaredDao);
        r18.j(createInsertionMethodBody(r12, r15));
        r10.add(new PreparedStmtQuery(r15, new t(r18)));
        goto L4
    L10:
        return r10;
    }

    private final List<PreparedStmtQuery> createPreparedQueries(List<WriteQueryMethod> r10) {
        ArrayList r5 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        WriteQueryMethod r12 = (WriteQueryMethod) r11.next();
        m r13 = getOrCreateField(new PreparedStatementField(r12));
        QueryWriter r14 = new QueryWriter(r12);
        z r15 = new PreparedStatementWriter(r14).createAnonymous(this, dbField);
        t r16 = createPreparedQueryMethodBody(r12, r13, r14);
        r5.add(new PreparedStmtQuery(MapsKt.mapOf(TuplesKt.to(PreparedStmtQuery.NO_PARAM_FIELD, TuplesKt.to(r13, r15))), r16));
        goto L4
    L6:
        return r5;
    }

    private final t createPreparedQueryMethod(WriteQueryMethod r5) {
        s r10 = overrideWithoutAnnotations(r5.getElement(), this.declaredDao);
        r10.j(createPreparedQueryMethodBody(r5));
        return new t(r10);
    }

    private final t createPreparedQueryMethodBody(WriteQueryMethod r5, final m r10, final QueryWriter r11) {
        CodeGenScope r12 = new CodeGenScope(this);
        r5.getPreparedQueryResultBinder().executeAndReturn(new C01471(r11, r10), r10.f14992b, dbField, r12);
        s r13 = overrideWithoutAnnotations(r5.getElement(), this.declaredDao);
        g r14 = r12.builder();
        r14.getClass();
        i r15 = new i(r14);
        r13.e.a(r15);
        return new t(r13);
    }

    private final i createQueryMethodBody(ReadQueryMethod r10) {
        QueryWriter r5 = new QueryWriter(r10);
        CodeGenScope r11 = new CodeGenScope(this);
        String r12 = r11.getTmpVar("_sql");
        String r13 = r11.getTmpVar("_statement");
        r5.prepareReadAndBind(r12, r13, r11);
        r10.getQueryResultBinder().convertAndReturn(r13, true, dbField, r10.getInTransaction(), r11);
        g r14 = r11.builder();
        r14.getClass();
        return new i(r14);
    }

    private final t createRawQueryMethod(RawQueryMethod r13) {
        s r5 = overrideWithoutAnnotations(r13.getElement(), this.declaredDao);
        CodeGenScope r10 = new CodeGenScope(this);
        RawQueryMethod.RuntimeQueryParameter r12 = r13.getRuntimeQueryParam();
        if (r12 == null) goto L8;
        if (r12.isString() != true) goto L8;
        String r11 = r10.getTmpVar("_statement");
        String r14 = Javapoet_extKt.getT();
        String r15 = Javapoet_extKt.getL();
        String r16 = Javapoet_extKt.getT();
        String r17 = a.t(androidx.room.jarjarred.org.antlr.runtime.a.y(r14, " ", r15, " = ", r16), ".acquire(", Javapoet_extKt.getL(), ", 0)");
        RoomTypeNames r18 = RoomTypeNames.INSTANCE;
        r5.o(r17, new Object[]{r18.getROOM_SQL_QUERY(), r11, r18.getROOM_SQL_QUERY(), r12.getParamName()});
        String r19 = r11;
        boolean r20 = true;
    L15:
        if (r13.getReturnsValue() == false) goto L17;
        r13.getQueryResultBinder().convertAndReturn(r19, r20, dbField, r13.getInTransaction(), r10);
    L17:
        g r110 = r10.builder();
        r110.getClass();
        r5.e.a(new i(r110));
        return new t(r5);
    L8:
        if (r12 != null) goto L10;
    L13:
        String r111 = r10.getTmpVar("_statement");
        String r21 = Javapoet_extKt.getT();
        String r22 = Javapoet_extKt.getL();
        String r23 = Javapoet_extKt.getT();
        String r24 = a.t(androidx.room.jarjarred.org.antlr.runtime.a.y(r21, " ", r22, " = ", r23), ".acquire(", Javapoet_extKt.getL(), ", 0)");
        RoomTypeNames r25 = RoomTypeNames.INSTANCE;
        r5.o(r24, new Object[]{r25.getROOM_SQL_QUERY(), r111, r25.getROOM_SQL_QUERY(), "missing query parameter"});
        r19 = r111;
    L12:
        r20 = false;
        goto L15
    L10:
        if (r12.isSupportQuery() != true) goto L13;
        String r26 = r10.getTmpVar("_internalQuery");
        String r27 = Javapoet_extKt.getT();
        String r28 = Javapoet_extKt.getL();
        String r29 = Javapoet_extKt.getN();
        StringBuilder r30 = a.y("final ", r27, " ", r28, " = ");
        r30.append(r29);
        r5.o(r30.toString(), new Object[]{r12.getType(), r26, r12.getParamName()});
        r19 = r26;
        goto L12
    }

    private final t createSelectMethod(ReadQueryMethod r5) {
        s r10 = overrideWithoutAnnotations(r5.getElement(), this.declaredDao);
        r10.j(createQueryMethodBody(r5));
        return new t(r10);
    }

    private final <T extends DeleteOrUpdateShortcutMethod> List<PreparedStmtQuery> createShortcutMethods(List<? extends T> r10, String r11, Function2<? super T, ? super ShortcutEntity, z> r12) {
        ArrayList r5 = new ArrayList();
        Iterator<T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        DeleteOrUpdateShortcutMethod r14 = (DeleteOrUpdateShortcutMethod) r13.next();
        Map<String, ShortcutEntity> r15 = r14.getEntities();
        if (r15.isEmpty() == false) goto L9;
        PreparedStmtQuery r16 = null;
    L17:
        if (r16 == null) goto L4;
        r5.add(r16);
        goto L4
    L9:
        if ((r14 instanceof UpdateMethod) == false) goto L11;
        String r17 = OnConflictProcessor.INSTANCE.onConflictText(((UpdateMethod) r14).getOnConflictStrategy());
    L12:
        LinkedHashMap r18 = new LinkedHashMap(MapsKt.mapCapacity(r15.size()));
        Iterator<T> r19 = r15.entrySet().iterator();
    L14:
        if (r19.hasNext() == false) goto L16;
        Map.Entry r20 = (Map.Entry) r19.next();
        r18.put(r20.getKey(), TuplesKt.to(getOrCreateField(new DeleteOrUpdateAdapterField((ShortcutEntity) r20.getValue(), r11, r17)), r12.mo2invoke(r14, r20.getValue())));
        goto L14
    L16:
        s r21 = overrideWithoutAnnotations(r14.getElement(), this.declaredDao);
        r21.j(createDeleteOrUpdateMethodBody(r14, r18));
        r16 = new PreparedStmtQuery(r18, new t(r21));
        goto L17
    L11:
        r17 = "";
        goto L12
    L19:
        return r5;
    }

    private final t createTransactionMethodBody(TransactionMethod r10) {
        CodeGenScope r11 = new CodeGenScope(this);
        r10.getMethodBinder().executeAndReturn(r10.getReturnType(), r10.getParameterNames(), XTypeNameKt.toJavaPoet(this.dao.getTypeName()), XTypeNameKt.toJavaPoet(this.dao.getImplTypeName()), dbField, r11);
        s r12 = overrideWithoutAnnotations(r10.getElement(), this.declaredDao);
        g r13 = r11.builder();
        r13.getClass();
        i r5 = new i(r13);
        r12.e.a(r5);
        return new t(r12);
    }

    private final List<PreparedStmtQuery> createTransactionMethods() {
        List<TransactionMethod> r5 = this.dao.getTransactionMethods();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        TransactionMethod r12 = (TransactionMethod) r11.next();
        r10.add(new PreparedStmtQuery(MapsKt.emptyMap(), createTransactionMethodBody(r12)));
        goto L4
    L6:
        return r10;
    }

    private final List<PreparedStmtQuery> createUpdateMethods() {
        return createShortcutMethods(this.dao.getUpdateMethods(), "update", new C01501(this));
    }

    private final List<PreparedStmtQuery> createUpsertMethods() {
        List<UpsertionMethod> r5 = this.dao.getUpsertionMethods();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        UpsertionMethod r12 = (UpsertionMethod) r11.next();
        Map<String, ShortcutEntity> r13 = r12.getEntities();
        LinkedHashMap r14 = new LinkedHashMap(MapsKt.mapCapacity(r13.size()));
        Iterator<T> r15 = r13.entrySet().iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.put(r16.getKey(), TuplesKt.to(getOrCreateField(new UpsertionAdapterField((ShortcutEntity) r16.getValue())), EntityUpsertionAdapterWriter.Companion.create((ShortcutEntity) r16.getValue()).createConcrete((ShortcutEntity) r16.getValue(), this, dbField.f14992b)));
        goto L7
    L9:
        s r17 = overrideWithoutAnnotations(r12.getElement(), this.declaredDao);
        r17.j(createUpsertionMethodBody(r12, r14));
        r10.add(new PreparedStmtQuery(r14, new t(r17)));
        goto L4
    L10:
        return r10;
    }

    private final i createUpsertionMethodBody(UpsertionMethod r5, Map<String, Pair<m, i>> r10) {
        if (r10.isEmpty() == false) goto L5;
    L9:
        int r11 = i.f14970c;
        return new i(new g());
    L5:
        if (r5.getMethodBinder() == null) goto L9;
        CodeGenScope r12 = new CodeGenScope(this);
        r5.getMethodBinder().convertAndReturn(r5.getParameters(), r10, dbField, r12);
        g r13 = r12.builder();
        r13.getClass();
        return new i(r13);
    }

    private final s overrideWithoutAnnotations(XMethodElement r5, XType r10) {
        return MethodSpecHelper.overridingWithFinalParams(r5, r10);
    }

    @Override // androidx.room.writer.TypeWriter
    public XTypeSpec.Builder createTypeSpecBuilder() {
        XTypeSpec.Builder r5 = XTypeSpec.Companion.classBuilder(getCodeLanguage(), this.dao.getImplTypeName());
        List<QueryMethod> r10 = this.dao.getQueryMethods();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if ((r13 instanceof WriteQueryMethod) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r15 = r11.iterator();
    L10:
        if (r15.hasNext() == false) goto L29;
        Object r16 = r15.next();
        List<QueryParameter> r17 = ((WriteQueryMethod) r16).getParameters();
        boolean r18 = false;
        if (r17 != null) goto L14;
    L16:
        Iterator<T> r19 = r17.iterator();
    L18:
        if (r19.hasNext() == false) goto L25;
        QueryParameterAdapter r20 = ((QueryParameter) r19.next()).getQueryParamAdapter();
        if (r20 == null) goto L22;
        boolean r21 = r20.isMultiple();
    L23:
        if (r21 == false) goto L18;
        r18 = true;
        goto L25
    L22:
        r21 = true;
    L25:
        Boolean r22 = Boolean.valueOf(r18);
        Object r23 = r14.get(r22);
        if (r23 != null) goto L28;
        r23 = new ArrayList();
        r14.put(r22, r23);
    L28:
        ((List) r23).add(r16);
        goto L10
    L14:
        if (r17.isEmpty() == false) goto L16;
    L29:
        List<WriteQueryMethod> r24 = (List) r14.get(Boolean.FALSE);
        if (r24 != null) goto L32;
        r24 = CollectionsKt.emptyList();
    L32:
        final List r25 = (List) r14.get(Boolean.TRUE);
        if (r25 != null) goto L35;
        r25 = CollectionsKt.emptyList();
    L35:
        List r26 = CollectionsKt.createListBuilder();
        r26.addAll(createInsertionMethods());
        r26.addAll(createDeletionMethods());
        r26.addAll(createUpdateMethods());
        r26.addAll(createTransactionMethods());
        r26.addAll(createPreparedQueries(r24));
        r26.addAll(createUpsertMethods());
        final List r27 = CollectionsKt.build(r26);
        XTypeSpec.Builder.Companion.apply(r5, new C01481(this, r27, r25), C01492.INSTANCE);
        return r5;
    }

    public final Dao getDao() {
        return this.dao;
    }

    private final i createPreparedQueryMethodBody(final WriteQueryMethod r5) {
        CodeGenScope r10 = new CodeGenScope(this);
        r5.getPreparedQueryResultBinder().executeAndReturn(new AnonymousClass2(r5), null, dbField, r10);
        g r11 = r10.builder();
        r11.getClass();
        return new i(r11);
    }
}
