package androidx.room.processor;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.ext.Xelement_extKt;
import androidx.room.preconditions.Checks;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.vo.Entity;
import androidx.room.vo.Field;
import androidx.room.vo.Fields;
import androidx.room.vo.HasFieldsKt;
import androidx.room.vo.Pojo;
import androidx.room.vo.ShortcutEntity;
import androidx.room.vo.ShortcutQueryParameter;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ.\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u0013\"\b\b\u0000\u0010\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002JP\u0010 \u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0!2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u00192\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%JD\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010*\u001a\u00020&2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%H\u0002J\u0006\u0010+\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005J\u001c\u0010/\u001a\u0002002\u0006\u0010.\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u001c\u00101\u001a\u0002002\u0006\u0010.\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ!\u00102\u001a\u0004\u0018\u00010&2\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020(06H\u0082\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u00067"}, d2 = {"Landroidx/room/processor/ShortcutMethodProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "delegate", "Landroidx/room/processor/MethodProcessorDelegate;", "getExecutableElement", "()Landroidx/room/compiler/processing/XMethodElement;", "extractAnnotation", "Landroidx/room/compiler/processing/XAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "klass", "Lkotlin/reflect/KClass;", "errorMsg", "", "extractEntities", "", "Landroidx/room/vo/ShortcutEntity;", LynxResourceModule.PARAMS_KEY, "", "Landroidx/room/vo/ShortcutQueryParameter;", "extractParams", "Lkotlin/Pair;", "targetEntityType", "missingParamError", "onValidatePartialEntity", "Lkotlin/Function2;", "Landroidx/room/vo/Entity;", "Landroidx/room/vo/Pojo;", "", "extractPartialEntities", "targetEntity", "extractReturnType", "findDeleteOrUpdateMethodBinder", "Landroidx/room/solver/shortcut/binder/DeleteOrUpdateMethodBinder;", "returnType", "findInsertMethodBinder", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", "findUpsertMethodBinder", "processEntity", "element", "Landroidx/room/compiler/processing/XTypeElement;", "onInvalid", "Lkotlin/Function0;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShortcutMethodProcessor {
    private final XType containing;
    private final Context context;
    private final MethodProcessorDelegate delegate;
    private final XMethodElement executableElement;

    public ShortcutMethodProcessor(Context r5, XType r10, XMethodElement r11) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "executableElement");
        this.containing = r10;
        this.executableElement = r11;
        Context r12 = Context.fork$default(r5, r11, null, 2, null);
        this.context = r12;
        this.delegate = MethodProcessorDelegate.Companion.createFor(r12, r10, r11);
    }

    private final Map<String, ShortcutEntity> extractEntities(List<ShortcutQueryParameter> r10) {
        ArrayList r5 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        ShortcutQueryParameter r12 = (ShortcutQueryParameter) r11.next();
        XType r13 = r12.getPojoType();
        Pair r14 = null;
        if (r13 == null) goto L8;
        XTypeElement r15 = r13.getTypeElement();
    L10:
        if (r15 != null) goto L13;
        this.context.getLogger().e(r12.getElement(), ProcessorErrors.INSTANCE.getCANNOT_FIND_ENTITY_FOR_SHORTCUT_QUERY_PARAMETER(), new Object[0]);
    L16:
        if (r14 == null) goto L4;
        r5.add(r14);
        goto L4
    L13:
        if (Xelement_extKt.isEntityElement(r15) == false) goto L15;
        Entity r16 = EntityProcessorKt.EntityProcessor$default(this.context, r15, null, 4, null).process();
        String r17 = r12.getName();
        Intrinsics.checkNotNull(r16);
        r14 = TuplesKt.to(r17, new ShortcutEntity(r16, null));
        goto L16
    L15:
        this.context.getLogger().e(r12.getElement(), ProcessorErrors.INSTANCE.getCANNOT_FIND_ENTITY_FOR_SHORTCUT_QUERY_PARAMETER(), new Object[0]);
        goto L16
    L8:
        r15 = null;
        goto L10
    L19:
        return MapsKt.toMap(r5);
    }

    private final Map<String, ShortcutEntity> extractPartialEntities(Entity r17, List<ShortcutQueryParameter> r18, Function2<? super Entity, ? super Pojo, Unit> r19) {
        LinkedHashMap r5 = new LinkedHashMap(androidx.constraintlayout.motion.widget.a.e(r18, 16));
        Iterator<T> r10 = r18.iterator();
    L4:
        if (r10.hasNext() == false) goto L30;
        ShortcutQueryParameter r11 = (ShortcutQueryParameter) r10.next();
        String r12 = r11.getName();
        XType r13 = r17.getType();
        XType r14 = r11.getPojoType();
        Intrinsics.checkNotNull(r14);
        boolean r15 = r13.isSameType(r14);
        Pojo r16 = null;
        if (r15 == false) goto L8;
        ShortcutEntity r20 = new ShortcutEntity(r17, null);
    L29:
        r5.put(r12, r20);
        goto L4
    L8:
        XTypeElement r110 = r11.getPojoType().getTypeElement();
        if (r110 != null) goto L11;
        this.context.getLogger().e(r17.getElement(), ProcessorErrors.INSTANCE.shortcutMethodArgumentMustBeAClass(r11.getPojoType().getTypeName()), new Object[0]);
    L28:
        r20 = new ShortcutEntity(r17, r16);
        goto L29
    L11:
        r16 = PojoProcessor.Companion.createFor$default(PojoProcessor.Companion, this.context, r110, FieldProcessor.BindingScope.BIND_TO_STMT, null, null, 16, null).process();
        Fields r21 = r16.getFields();
        ArrayList r22 = new ArrayList();
        Iterator<Field> r23 = r21.iterator();
    L13:
        if (r23.hasNext() == false) goto L17;
        Field r24 = r23.next();
        if (HasFieldsKt.findFieldByColumnName(r17, r24.getColumnName()) != null) goto L13;
        r22.add(r24);
        goto L13
    L17:
        Iterator r25 = r22.iterator();
    L19:
        if (r25.hasNext() == false) goto L22;
        Field r26 = (Field) r25.next();
        this.context.getLogger().e(r26.getElement(), ProcessorErrors.INSTANCE.cannotFindAsEntityField(XTypeNameKt.toJavaPoet(r17.getTypeName()).toString()), new Object[0]);
        goto L19
    L22:
        if (r16.getRelations().isEmpty() == true) goto L25;
        this.context.getLogger().e(r16.getElement(), ProcessorErrors.INSTANCE.getINVALID_RELATION_IN_PARTIAL_ENTITY(), new Object[0]);
    L25:
        if (r16.getFields().isEmpty() == false) goto L27;
        this.context.getLogger().e(this.executableElement, ProcessorErrors.INSTANCE.noColumnsInPartialEntity(XTypeNameKt.toJavaPoet(r16.getTypeName()).toString()), new Object[0]);
    L27:
        r19.mo2invoke(r17, r16);
        goto L28
    L30:
        return r5;
    }

    private final Entity processEntity(XTypeElement r5, Function0<Unit> r10) {
        if (Xelement_extKt.isEntityElement(r5) == true) goto L7;
        r10.invoke();
        return null;
    L7:
        return EntityProcessorKt.EntityProcessor$default(this.context, r5, null, 4, null).process();
    }

    public final <T extends Annotation> XAnnotationBox<T> extractAnnotation(KClass<T> r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        Intrinsics.checkNotNullParameter(r10, "errorMsg");
        XAnnotationBox<T> r11 = this.executableElement.getAnnotation(r5);
        Checks r12 = this.context.getChecker();
        if (r11 == null) goto L5;
        boolean r13 = true;
    L6:
        r12.check(r13, this.executableElement, r10, new Object[0]);
        return r11;
    L5:
        r13 = false;
        goto L6
    }

    public final Pair<Map<String, ShortcutEntity>, List<ShortcutQueryParameter>> extractParams(XType r10, String r11, Function2<? super Entity, ? super Pojo, Unit> r12) {
        Intrinsics.checkNotNullParameter(r11, "missingParamError");
        Intrinsics.checkNotNullParameter(r12, "onValidatePartialEntity");
        List<XVariableElement> r5 = this.delegate.extractParams();
        ArrayList r13 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r14 = r5.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(new ShortcutParameterProcessor(this.context, this.containing, (XVariableElement) r14.next()).process());
        goto L4
    L6:
        this.context.getChecker().check(!r13.isEmpty(), this.executableElement, r11, new Object[0]);
        Entity r15 = null;
        if (r10 != null) goto L9;
    L18:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r13.iterator();
    L20:
        if (r17.hasNext() == false) goto L24;
        Object r18 = r17.next();
        if (((ShortcutQueryParameter) r18).getPojoType() == null) goto L20;
        r16.add(r18);
        goto L20
    L24:
        if (r15 == null) goto L26;
        Map<String, ShortcutEntity> r19 = extractPartialEntities(r15, r16, r12);
    L28:
        return new Pair(r19, r13);
    L26:
        r19 = extractEntities(r16);
        goto L28
    L9:
        if (r10.isTypeOf(Reflection.getOrCreateKotlinClass(Object.class)) == true) goto L18;
        XTypeElement r20 = r10.getTypeElement();
        if (r20 != null) goto L14;
        this.context.getLogger().e(this.executableElement, ProcessorErrors.INSTANCE.getINVALID_TARGET_ENTITY_IN_SHORTCUT_METHOD(), new Object[0]);
        goto L18
    L14:
        if (Xelement_extKt.isEntityElement(r20) == false) goto L16;
        r15 = EntityProcessorKt.EntityProcessor$default(this.context, r20, null, 4, null).process();
        goto L18
    L16:
        this.context.getLogger().e(this.executableElement, ProcessorErrors.INSTANCE.getINVALID_TARGET_ENTITY_IN_SHORTCUT_METHOD(), new Object[0]);
        return TuplesKt.to(MapsKt.emptyMap(), CollectionsKt.emptyList());
    }

    public final XType extractReturnType() {
        XType r5 = this.delegate.extractReturnType();
        this.context.getChecker().check(!MethodProcessorDelegateKt.isSuspendAndReturnsDeferredType(this.delegate), this.executableElement, ProcessorErrors.INSTANCE.suspendReturnsDeferredType(r5.getRawType().getTypeName().toString()), new Object[0]);
        return r5;
    }

    public final DeleteOrUpdateMethodBinder findDeleteOrUpdateMethodBinder(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        return this.delegate.findDeleteOrUpdateMethodBinder(r5);
    }

    public final InsertOrUpsertMethodBinder findInsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return this.delegate.findInsertMethodBinder(r5, r10);
    }

    public final InsertOrUpsertMethodBinder findUpsertMethodBinder(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return this.delegate.findUpsertMethodBinder(r5, r10);
    }

    public final XType getContaining() {
        return this.containing;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XMethodElement getExecutableElement() {
        return this.executableElement;
    }
}
