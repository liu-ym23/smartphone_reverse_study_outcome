package androidx.room.compiler.processing;

import androidx.room.compiler.codegen.XClassName;
import com.squareup.javapoet.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH&¢\u0006\u0004\b\u0013\u0010\nJ\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014H&¢\u0006\u0004\b\u001f\u0010\u0017J\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018H&¢\u0006\u0004\b \u0010\u001aJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018H\u0016¢\u0006\u0004\b!\u0010\u001aJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014H&¢\u0006\u0004\b\"\u0010\u0017J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014H&¢\u0006\u0004\b#\u0010\u0017J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014H&¢\u0006\u0004\b$\u0010\u0017J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0016¢\u0006\u0004\b%\u0010\u0017R\u001c\u0010+\u001a\u0004\u0018\u00010&8VX\u0097\u0004¢\u0006\f\u0012\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u0014\u0010/\u001a\u00020,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010.R\u0014\u00103\u001a\u00020&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010(R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020&0\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0017R\u0016\u00107\u001a\u0004\u0018\u00010&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010(R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020&0\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0017R\u0014\u0010=\u001a\u00020:8&X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010@\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010C\u001a\u0004\u0018\u00010\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010E\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010?R\u0014\u0010G\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010.ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006HÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XTypeElement;", "Landroidx/room/compiler/processing/XHasModifiers;", "Landroidx/room/compiler/processing/XParameterizable;", "Landroidx/room/compiler/processing/XElement;", "Landroidx/room/compiler/processing/XMemberContainer;", "Landroidx/room/compiler/codegen/XClassName;", "asClassName", "()Landroidx/room/compiler/codegen/XClassName;", "", "isNested", "()Z", "isInterface", "isFunctionalInterface", "isClass", "isDataClass", "isValueClass", "isExpect", "isAnnotationClass", "isKotlinObject", "isCompanionObject", "", "Landroidx/room/compiler/processing/XFieldElement;", "getDeclaredFields", "()Ljava/util/List;", "Lkotlin/sequences/Sequence;", "getAllFieldsIncludingPrivateSupers", "()Lkotlin/sequences/Sequence;", "Landroidx/room/compiler/processing/XConstructorElement;", "findPrimaryConstructor", "()Landroidx/room/compiler/processing/XConstructorElement;", "Landroidx/room/compiler/processing/XMethodElement;", "getDeclaredMethods", "getAllMethods", "getAllNonPrivateInstanceMethods", "getConstructors", "getSuperInterfaceElements", "getEnclosedTypeElements", "getEnclosedElements", "Landroidx/room/compiler/processing/XType;", "getSuperType", "()Landroidx/room/compiler/processing/XType;", "getSuperType$annotations", "()V", "superType", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName", "getPackageName", "packageName", "getType", "type", "getSuperTypes", "superTypes", "getSuperClass", "superClass", "getSuperInterfaces", "superInterfaces", "Lcom/squareup/javapoet/e;", "getClassName", "()Lcom/squareup/javapoet/e;", "className", "getEnclosingTypeElement", "()Landroidx/room/compiler/processing/XTypeElement;", "enclosingTypeElement", "getEnclosingElement", "()Landroidx/room/compiler/processing/XMemberContainer;", "enclosingElement", "getClosestMemberContainer", "closestMemberContainer", "getFallbackLocationText", "fallbackLocationText", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XTypeElement extends XHasModifiers, XParameterizable, XElement, XMemberContainer {
    @Deprecated(message = "Function name was misleading.", replaceWith = @ReplaceWith(expression = "superClass", imports = {}))
    static /* synthetic */ void getSuperType$annotations() {
    }

    @Override // androidx.room.compiler.processing.XMemberContainer
    XClassName asClassName();

    XConstructorElement findPrimaryConstructor();

    Sequence<XFieldElement> getAllFieldsIncludingPrivateSupers();

    Sequence<XMethodElement> getAllMethods();

    default Sequence<XMethodElement> getAllNonPrivateInstanceMethods() {
        return SequencesKt.filter(getAllMethods(), AnonymousClass1.INSTANCE);
    }

    @Override // androidx.room.compiler.processing.XMemberContainer
    e getClassName();

    @Override // androidx.room.compiler.processing.XElement
    default XTypeElement getClosestMemberContainer() {
        return this;
    }

    List<XConstructorElement> getConstructors();

    List<XFieldElement> getDeclaredFields();

    List<XMethodElement> getDeclaredMethods();

    default List<XElement> getEnclosedElements() {
        ArrayList r5 = new ArrayList();
        r5.addAll(getEnclosedTypeElements());
        r5.addAll(getDeclaredFields());
        r5.addAll(getConstructors());
        r5.addAll(getDeclaredMethods());
        return r5;
    }

    List<XTypeElement> getEnclosedTypeElements();

    @Override // androidx.room.compiler.processing.XElement
    XMemberContainer getEnclosingElement();

    XTypeElement getEnclosingTypeElement();

    @Override // androidx.room.compiler.processing.XElement
    default String getFallbackLocationText() {
        return getQualifiedName();
    }

    String getPackageName();

    String getQualifiedName();

    XType getSuperClass();

    List<XTypeElement> getSuperInterfaceElements();

    List<XType> getSuperInterfaces();

    default XType getSuperType() {
        return getSuperClass();
    }

    List<XType> getSuperTypes();

    @Override // androidx.room.compiler.processing.XMemberContainer
    XType getType();

    boolean isAnnotationClass();

    boolean isClass();

    boolean isCompanionObject();

    boolean isDataClass();

    boolean isExpect();

    boolean isFunctionalInterface();

    boolean isInterface();

    boolean isKotlinObject();

    boolean isNested();

    boolean isValueClass();

    @Override // androidx.room.compiler.processing.XElement
    /* bridge */ /* synthetic */ default XMemberContainer getClosestMemberContainer() {
        return getClosestMemberContainer();
    }
}
