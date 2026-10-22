package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.processing.XAnnotated;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XConstructorElement;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XEnumEntry;
import androidx.room.compiler.processing.XEnumTypeElement;
import androidx.room.compiler.processing.XFieldElement;
import androidx.room.compiler.processing.XHasModifiers;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeParameterElement;
import androidx.room.compiler.processing.util.MemoizedSequence;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.google.devtools.ksp.symbol.ClassKind;
import com.google.devtools.ksp.symbol.Modifier;
import com.squareup.javapoet.e;
import il.c;
import il.d;
import il.g;
import il.l;
import il.s;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u009d\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0006\u009d\u0001\u009e\u0001\u009f\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u000eJ\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ0\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 \"\b\b\u0000\u0010\u001d*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096\u0001¢\u0006\u0004\b\u001a\u0010!J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\"\u0010#J4\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 0\u0014\"\b\b\u0000\u0010\u001d*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096\u0001¢\u0006\u0004\b\"\u0010$J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150%2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b&\u0010'J$\u0010*\u001a\u00020\f2\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180(\"\u00020\u0018H\u0096\u0001¢\u0006\u0004\b*\u0010+J4\u0010*\u001a\u00020\f2\"\u0010)\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001e0(\"\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001eH\u0096\u0001¢\u0006\u0004\b*\u0010,J\u001e\u0010*\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180-H\u0096\u0001¢\u0006\u0004\b*\u0010.J\u0018\u0010/\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b/\u00100J \u0010/\u001a\u00020\f2\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001eH\u0096\u0001¢\u0006\u0004\b/\u00101J\u0018\u00104\u001a\u00020\f2\u0006\u00103\u001a\u000202H\u0096\u0001¢\u0006\u0004\b4\u00105J$\u00106\u001a\u00020\f2\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180(\"\u00020\u0018H\u0096\u0001¢\u0006\u0004\b6\u0010+J4\u00106\u001a\u00020\f2\"\u0010)\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001e0(\"\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001eH\u0096\u0001¢\u0006\u0004\b6\u0010,J\u001e\u00106\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180-H\u0096\u0001¢\u0006\u0004\b6\u0010.J\u0018\u00107\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b7\u0010\u001bJ.\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\b\b\u0000\u0010\u001d*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096\u0001¢\u0006\u0004\b7\u0010!J0\u00108\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 \"\b\b\u0000\u0010\u001d*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0097\u0001¢\u0006\u0004\b8\u0010!J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u0015\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<H\u0016¢\u0006\u0004\b>\u0010?J\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\fH\u0016¢\u0006\u0004\bD\u0010\u000eJ\u000f\u0010E\u001a\u00020\fH\u0016¢\u0006\u0004\bE\u0010\u000eJ\u000f\u0010F\u001a\u00020\fH\u0016¢\u0006\u0004\bF\u0010\u000eJ\u000f\u0010G\u001a\u00020\fH\u0016¢\u0006\u0004\bG\u0010\u000eJ\u000f\u0010H\u001a\u00020\fH\u0016¢\u0006\u0004\bH\u0010\u000eJ\u000f\u0010I\u001a\u00020\fH\u0016¢\u0006\u0004\bI\u0010\u000eJ\u000f\u0010J\u001a\u00020\fH\u0016¢\u0006\u0004\bJ\u0010\u000eJ\u000f\u0010K\u001a\u00020\fH\u0016¢\u0006\u0004\bK\u0010\u000eJ\u000f\u0010L\u001a\u00020\fH\u0016¢\u0006\u0004\bL\u0010\u000eJ\u000f\u0010M\u001a\u00020\fH\u0016¢\u0006\u0004\bM\u0010\u000eJ\u000f\u0010N\u001a\u00020\fH\u0016¢\u0006\u0004\bN\u0010\u000eJ\u0015\u0010O\u001a\b\u0012\u0004\u0012\u00020A0\u0014H\u0016¢\u0006\u0004\bO\u0010\u0017J\u0011\u0010Q\u001a\u0004\u0018\u00010PH\u0016¢\u0006\u0004\bQ\u0010RJ\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020=0\u0014H\u0016¢\u0006\u0004\bS\u0010\u0017J\u0015\u0010T\u001a\b\u0012\u0004\u0012\u00020P0\u0014H\u0016¢\u0006\u0004\bT\u0010\u0017J\u0015\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016¢\u0006\u0004\bU\u0010\u0017J\u0015\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016¢\u0006\u0004\bV\u0010\u0017R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010W\u001a\u0004\bX\u0010YR\u001b\u0010^\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001b\u0010a\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b_\u0010[\u001a\u0004\b`\u0010]R\u001d\u0010e\u001a\u0004\u0018\u00010\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bb\u0010[\u001a\u0004\bc\u0010dR!\u0010i\u001a\b\u0012\u0004\u0012\u00020f0\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bg\u0010[\u001a\u0004\bh\u0010\u0017R\u001b\u0010l\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bj\u0010[\u001a\u0004\bk\u0010]R\u001b\u0010q\u001a\u00020m8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bn\u0010[\u001a\u0004\bo\u0010pR!\u0010u\u001a\b\u0012\u0004\u0012\u00020r0\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bs\u0010[\u001a\u0004\bt\u0010\u0017R\u001d\u0010y\u001a\u0004\u0018\u00010r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bv\u0010[\u001a\u0004\bw\u0010xR!\u0010}\u001a\b\u0012\u0004\u0012\u00020m0z8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b{\u0010[\u001a\u0004\b|\u0010\u0017R\u001d\u0010\u0081\u0001\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\r\n\u0004\b~\u0010[\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001e\u0010\u0084\u0001\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010[\u001a\u0005\b\u0083\u0001\u0010;R\u001d\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020=0@8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001d\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020A0@8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0086\u0001R%\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010\u00148BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010[\u001a\u0005\b\u008a\u0001\u0010\u0017R%\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010\u00148BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010[\u001a\u0005\b\u008d\u0001\u0010\u0017R$\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020=0\u00148BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008f\u0001\u0010[\u001a\u0005\b\u0090\u0001\u0010\u0017R$\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020=0\u00148BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010[\u001a\u0005\b\u0093\u0001\u0010\u0017R\u001a\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0095\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u009c\u0001\u001a\u00020\f*\u00030\u0099\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\u0082\u0001\u0006 \u0001¡\u0001¢\u0001¨\u0006£\u0001"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspTypeElement;", "Landroidx/room/compiler/processing/ksp/KspElement;", "Landroidx/room/compiler/processing/XTypeElement;", "Landroidx/room/compiler/processing/XHasModifiers;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/c;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/c;)V", "", "isAbstract", "()Z", "isPrivate", "isProtected", "isPublic", "isStatic", "isTransient", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "Landroidx/room/compiler/codegen/XClassName;", "asClassName", "()Landroidx/room/compiler/codegen/XClassName;", "Lkotlin/sequences/Sequence;", "Landroidx/room/compiler/processing/XMethodElement;", "getAllMethods", "()Lkotlin/sequences/Sequence;", "Landroidx/room/compiler/processing/util/MemoizedSequence;", "Landroidx/room/compiler/processing/XFieldElement;", "getAllFieldsIncludingPrivateSupers", "()Landroidx/room/compiler/processing/util/MemoizedSequence;", "isNested", "isInterface", "isKotlinObject", "isCompanionObject", "isAnnotationClass", "isClass", "isDataClass", "isValueClass", "isFunctionalInterface", "isExpect", "isFinal", "getDeclaredFields", "Landroidx/room/compiler/processing/XConstructorElement;", "findPrimaryConstructor", "()Landroidx/room/compiler/processing/XConstructorElement;", "getDeclaredMethods", "getConstructors", "getSuperInterfaceElements", "getEnclosedTypeElements", "Lil/c;", "getDeclaration", "()Lil/c;", "name$delegate", "Lkotlin/Lazy;", "getName", "()Ljava/lang/String;", "name", "packageName$delegate", "getPackageName", "packageName", "enclosingTypeElement$delegate", "getEnclosingTypeElement", "()Landroidx/room/compiler/processing/XTypeElement;", "enclosingTypeElement", "Landroidx/room/compiler/processing/XTypeParameterElement;", "typeParameters$delegate", "getTypeParameters", "typeParameters", "qualifiedName$delegate", "getQualifiedName", "qualifiedName", "Landroidx/room/compiler/processing/ksp/KspType;", "type$delegate", "getType", "()Landroidx/room/compiler/processing/ksp/KspType;", "type", "Landroidx/room/compiler/processing/XType;", "superTypes$delegate", "getSuperTypes", "superTypes", "superClass$delegate", "getSuperClass", "()Landroidx/room/compiler/processing/XType;", "superClass", "", "superInterfaces$delegate", "getSuperInterfaces", "superInterfaces", "className$delegate", "getClassName", "()Lcom/squareup/javapoet/e;", "className", "xClassName$delegate", "getXClassName", "xClassName", "allMethods", "Landroidx/room/compiler/processing/util/MemoizedSequence;", "allFieldsIncludingPrivateSupers", "Landroidx/room/compiler/processing/ksp/KspFieldElement;", "_declaredProperties$delegate", "get_declaredProperties", "_declaredProperties", "_declaredFields$delegate", "get_declaredFields", "_declaredFields", "syntheticGetterSetterMethods$delegate", "getSyntheticGetterSetterMethods", "syntheticGetterSetterMethods", "_declaredMethods$delegate", "get_declaredMethods", "_declaredMethods", "Landroidx/room/compiler/processing/XMemberContainer;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XMemberContainer;", "enclosingElement", "Lil/l;", "getHasBackingFieldFixed", "(Lil/l;)Z", "hasBackingFieldFixed", "Companion", "DefaultKspTypeElement", "KspEnumTypeElement", "Landroidx/room/compiler/processing/ksp/KspEnumEntry;", "Landroidx/room/compiler/processing/ksp/KspTypeElement$DefaultKspTypeElement;", "Landroidx/room/compiler/processing/ksp/KspTypeElement$KspEnumTypeElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspTypeElement extends KspElement implements XTypeElement, XHasModifiers, XAnnotated, KspMemberContainer {
    public static final Companion Companion = null;
    private final /* synthetic */ XHasModifiers $$delegate_0;
    private final /* synthetic */ KspAnnotated $$delegate_1;
    private final Lazy _declaredFields$delegate;
    private final Lazy _declaredMethods$delegate;
    private final Lazy _declaredProperties$delegate;
    private final MemoizedSequence<XFieldElement> allFieldsIncludingPrivateSupers;
    private final MemoizedSequence<XMethodElement> allMethods;
    private final Lazy className$delegate;
    private final c declaration;
    private final Lazy enclosingTypeElement$delegate;
    private final Lazy name$delegate;
    private final Lazy packageName$delegate;
    private final Lazy qualifiedName$delegate;
    private final Lazy superClass$delegate;
    private final Lazy superInterfaces$delegate;
    private final Lazy superTypes$delegate;
    private final Lazy syntheticGetterSetterMethods$delegate;
    private final Lazy type$delegate;
    private final Lazy typeParameters$delegate;
    private final Lazy xClassName$delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspTypeElement$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/c;", "ksClassDeclaration", "Landroidx/room/compiler/processing/ksp/KspTypeElement;", "create", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/c;)Landroidx/room/compiler/processing/ksp/KspTypeElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[ClassKind.values().length];
                r5[ClassKind.ENUM_CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final KspTypeElement create(KspProcessingEnv r5, c r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "ksClassDeclaration");
            ClassKind r11 = r10.b();
            if (WhenMappings.$EnumSwitchMapping$0[r11.ordinal()] != 1) goto L6;
            return new KspEnumTypeElement(r5, r10);
        L6:
            return new DefaultKspTypeElement(r5, r10);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspTypeElement$DefaultKspTypeElement;", "Landroidx/room/compiler/processing/ksp/KspTypeElement;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/c;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/c;)V", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultKspTypeElement extends KspTypeElement {
        public DefaultKspTypeElement(KspProcessingEnv r5, c r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "declaration");
            super(r5, r10, null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspTypeElement$KspEnumTypeElement;", "Landroidx/room/compiler/processing/ksp/KspTypeElement;", "Landroidx/room/compiler/processing/XEnumTypeElement;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/c;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/c;)V", "", "Landroidx/room/compiler/processing/XEnumEntry;", "entries$delegate", "Lkotlin/Lazy;", "getEntries", "()Ljava/util/Set;", "entries", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KspEnumTypeElement extends KspTypeElement implements XEnumTypeElement {
        private final Lazy entries$delegate;

        public KspEnumTypeElement(final KspProcessingEnv r5, final c r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "declaration");
            super(r5, r10, null);
            this.entries$delegate = LazyKt.lazy(new KspTypeElement$KspEnumTypeElement$entries$2(r10, r5, this));
        }

        @Override // androidx.room.compiler.processing.XEnumTypeElement
        public Set<XEnumEntry> getEntries() {
            return (Set) this.entries$delegate.getValue();
        }
    }

    /* JADX INFO: renamed from: androidx.room.compiler.processing.ksp.KspTypeElement$getConstructors$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lil/g;", ST.IMPLICIT_ARG_NAME, "Landroidx/room/compiler/processing/ksp/KspConstructorElement;", "invoke", "(Lil/g;)Landroidx/room/compiler/processing/ksp/KspConstructorElement;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass1 extends Lambda implements Function1<g, KspConstructorElement> {
        final /* synthetic */ KspTypeElement this$0;

        public AnonymousClass1(KspTypeElement r5) {
            this.this$0 = r5;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KspConstructorElement invoke(g r5) {
            j0.A(r5);
            return invoke2(null);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KspConstructorElement invoke2(g r5) {
            Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
            return new KspConstructorElement(this.this$0.getEnv$room_compiler_processing(), r5);
        }
    }

    /* JADX INFO: renamed from: androidx.room.compiler.processing.ksp.KspTypeElement$getEnclosedTypeElements$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000b\u0010\u0002\u001a\u00070\u0000¢\u0006\u0002\b\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lil/c;", "Lkotlin/internal/NoInfer;", ST.IMPLICIT_ARG_NAME, "Landroidx/room/compiler/processing/ksp/KspTypeElement;", "invoke", "(Lil/c;)Landroidx/room/compiler/processing/ksp/KspTypeElement;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class C01031 extends Lambda implements Function1<c, KspTypeElement> {
        final /* synthetic */ KspTypeElement this$0;

        public C01031(KspTypeElement r5) {
            this.this$0 = r5;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KspTypeElement invoke2(c r5) {
            Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
            return this.this$0.getEnv$room_compiler_processing().wrapClassDeclaration(r5);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KspTypeElement invoke(c r5) {
            j0.A(r5);
            return invoke2(null);
        }
    }

    /* JADX INFO: renamed from: androidx.room.compiler.processing.ksp.KspTypeElement$getSuperInterfaceElements$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lil/s;", ST.IMPLICIT_ARG_NAME, "Lil/d;", "invoke", "(Lil/s;)Lil/d;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class C01041 extends Lambda implements Function1<s, d> {
        public static final C01041 INSTANCE = null;

        static {
            INSTANCE = new C01041();
        }

        public C01041() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d invoke(s r5) {
            invoke2(r5);
            return null;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d invoke2(s r5) {
            Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
            r5.resolve();
            throw null;
        }
    }

    /* JADX INFO: renamed from: androidx.room.compiler.processing.ksp.KspTypeElement$getSuperInterfaceElements$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000b\u0010\u0002\u001a\u00070\u0000¢\u0006\u0002\b\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lil/c;", "Lkotlin/internal/NoInfer;", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Lil/c;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass2 extends Lambda implements Function1<c, Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(c r5) {
            j0.A(r5);
            return invoke2(null);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(c r5) {
            Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
            if (r5.b() != ClassKind.INTERFACE) goto L5;
            boolean r10 = true;
        L7:
            return Boolean.valueOf(r10);
        L5:
            r10 = false;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KspTypeElement(KspProcessingEnv r5, c r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static final /* synthetic */ boolean access$getHasBackingFieldFixed(KspTypeElement r5, l r10) {
        return r5.getHasBackingFieldFixed(r10);
    }

    public static final /* synthetic */ List access$getSyntheticGetterSetterMethods(KspTypeElement r5) {
        return r5.getSyntheticGetterSetterMethods();
    }

    public static final /* synthetic */ XClassName access$getXClassName(KspTypeElement r5) {
        return r5.getXClassName();
    }

    public static final /* synthetic */ List access$get_declaredProperties(KspTypeElement r5) {
        return r5.get_declaredProperties();
    }

    private final boolean getHasBackingFieldFixed(l r5) {
        if (r5.a() == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.getModifiers().contains(Modifier.LATEINIT) == true) goto L8;
        return false;
    }

    private final List<XMethodElement> getSyntheticGetterSetterMethods() {
        return (List) this.syntheticGetterSetterMethods$delegate.getValue();
    }

    private final XClassName getXClassName() {
        return (XClassName) this.xClassName$delegate.getValue();
    }

    private final List<KspFieldElement> get_declaredFields() {
        return (List) this._declaredFields$delegate.getValue();
    }

    private final List<XMethodElement> get_declaredMethods() {
        return (List) this._declaredMethods$delegate.getValue();
    }

    private final List<KspFieldElement> get_declaredProperties() {
        return (List) this._declaredProperties$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement, androidx.room.compiler.processing.XMemberContainer
    public XClassName asClassName() {
        return getXClassName();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public XConstructorElement findPrimaryConstructor() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public List<XAnnotation> getAllAnnotations() {
        return this.$$delegate_1.getAllAnnotations();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public /* bridge */ /* synthetic */ Sequence getAllFieldsIncludingPrivateSupers() {
        return getAllFieldsIncludingPrivateSupers();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public Sequence<XMethodElement> getAllMethods() {
        return this.allMethods;
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public XAnnotation getAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.getAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public List<XAnnotation> getAnnotations(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.getAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public Set<XAnnotation> getAnnotationsAnnotatedWith(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.getAnnotationsAnnotatedWith(r5);
    }

    @Override // androidx.room.compiler.processing.XTypeElement, androidx.room.compiler.processing.XMemberContainer
    public e getClassName() {
        return (e) this.className$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XConstructorElement> getConstructors() {
        getDeclaration();
        Intrinsics.checkNotNullParameter(null, "<this>");
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    }

    @Override // androidx.room.compiler.processing.ksp.KspElement
    public /* bridge */ /* synthetic */ il.a getDeclaration() {
        getDeclaration();
        return null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XFieldElement> getDeclaredFields() {
        return get_declaredFields();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XMethodElement> getDeclaredMethods() {
        return get_declaredMethods();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XTypeElement> getEnclosedTypeElements() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public XTypeElement getEnclosingTypeElement() {
        return (XTypeElement) this.enclosingTypeElement$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return (String) this.name$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public String getPackageName() {
        return (String) this.packageName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public String getQualifiedName() {
        return (String) this.qualifiedName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public XType getSuperClass() {
        return (XType) this.superClass$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XTypeElement> getSuperInterfaceElements() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<KspType> getSuperInterfaces() {
        return (List) this.superInterfaces$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public List<XType> getSuperTypes() {
        return (List) this.superTypes$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XTypeElement, androidx.room.compiler.processing.XMemberContainer
    public /* bridge */ /* synthetic */ XType getType() {
        return getType();
    }

    @Override // androidx.room.compiler.processing.XParameterizable
    public List<XTypeParameterElement> getTypeParameters() {
        return (List) this.typeParameters$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAllAnnotations(Collection<e> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAllAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.hasAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotationWithPackage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pkg");
        return this.$$delegate_1.hasAnnotationWithPackage(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnyAnnotation(Collection<e> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAnyAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isAbstract() {
        return this.$$delegate_0.isAbstract();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isAnnotationClass() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isClass() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isCompanionObject() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isDataClass() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isExpect() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isFinal() {
        if (isInterface() == false) goto L6;
        return false;
    L6:
        getDeclaration();
        com.google.devtools.ksp.a.b();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isFunctionalInterface() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isInterface() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isKotlinObject() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isNested() {
        getDeclaration();
        return KSDeclarationExtKt.findEnclosingMemberContainer(null, getEnv$room_compiler_processing()) instanceof XTypeElement;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPrivate() {
        return this.$$delegate_0.isPrivate();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isProtected() {
        return this.$$delegate_0.isProtected();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPublic() {
        return this.$$delegate_0.isPublic();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isStatic() {
        return this.$$delegate_0.isStatic();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isTransient() {
        return this.$$delegate_0.isTransient();
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public boolean isValueClass() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public XAnnotation requireAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.requireAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    @Deprecated(message = "Use getAnnotation(not repeatable) or getAnnotations (repeatable)", replaceWith = @ReplaceWith(expression = "getAnnotation(annotation)", imports = {}))
    public <T extends Annotation> XAnnotationBox<T> toAnnotationBox(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_1.toAnnotationBox(r5);
    }

    private KspTypeElement(final KspProcessingEnv r5, c r10) {
        super(r5, r10);
        this.$$delegate_0 = KspHasModifiers.Companion.create(r10);
        this.$$delegate_1 = KspAnnotated.Companion.create(r5, r10, KspAnnotated.UseSiteFilter.Companion.getNO_USE_SITE());
        this.name$delegate = LazyKt.lazy(new KspTypeElement$name$2(this));
        this.packageName$delegate = LazyKt.lazy(new KspTypeElement$packageName$2(this));
        this.enclosingTypeElement$delegate = LazyKt.lazy(new KspTypeElement$enclosingTypeElement$2(this, r5));
        this.typeParameters$delegate = LazyKt.lazy(new KspTypeElement$typeParameters$2(this, r5));
        this.qualifiedName$delegate = LazyKt.lazy(new KspTypeElement$qualifiedName$2(this));
        this.type$delegate = LazyKt.lazy(new KspTypeElement$type$2(r5, this));
        this.superTypes$delegate = LazyKt.lazy(new KspTypeElement$superTypes$2(this, r5));
        this.superClass$delegate = LazyKt.lazy(new KspTypeElement$superClass$2(this, r5));
        this.superInterfaces$delegate = LazyKt.lazy(new KspTypeElement$superInterfaces$2(this, r5));
        this.className$delegate = LazyKt.lazy(new KspTypeElement$className$2(this));
        this.xClassName$delegate = LazyKt.lazy(new KspTypeElement$xClassName$2(this, r5));
        this.allMethods = new MemoizedSequence(new KspTypeElement$allMethods$1(this));
        this.allFieldsIncludingPrivateSupers = new MemoizedSequence(new KspTypeElement$allFieldsIncludingPrivateSupers$1(this));
        this._declaredProperties$delegate = LazyKt.lazy(new KspTypeElement$_declaredProperties$2(this, r5));
        this._declaredFields$delegate = LazyKt.lazy(new KspTypeElement$_declaredFields$2(this));
        this.syntheticGetterSetterMethods$delegate = LazyKt.lazy(new KspTypeElement$syntheticGetterSetterMethods$2(this, r5));
        this._declaredMethods$delegate = LazyKt.lazy(new KspTypeElement$_declaredMethods$2(this, r5));
    }

    @Override // androidx.room.compiler.processing.XTypeElement
    public MemoizedSequence<XFieldElement> getAllFieldsIncludingPrivateSupers() {
        return this.allFieldsIncludingPrivateSupers;
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public <T extends Annotation> XAnnotationBox<T> getAnnotation(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_1.getAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_1.getAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.ksp.KspElement
    public /* bridge */ /* synthetic */ d getDeclaration() {
        getDeclaration();
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public XMemberContainer getEnclosingElement() {
        return getEnclosingTypeElement();
    }

    @Override // androidx.room.compiler.processing.XTypeElement, androidx.room.compiler.processing.XMemberContainer
    public KspType getType() {
        return (KspType) this.type$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAllAnnotations(e... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAllAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotation(KClass<? extends Annotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_1.hasAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnyAnnotation(e... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAnyAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public <T extends Annotation> XAnnotationBox<T> requireAnnotation(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_1.requireAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.ksp.KspElement
    public c getDeclaration() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAllAnnotations(KClass<? extends Annotation>... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAllAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnyAnnotation(KClass<? extends Annotation>... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAnyAnnotation(r5);
    }
}
