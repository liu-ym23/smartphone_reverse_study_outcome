package androidx.room.compiler.processing.ksp.synthetic;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XEquality;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.ksp.KspMemberContainer;
import androidx.room.compiler.processing.ksp.KspType;
import com.squareup.javapoet.e;
import il.d;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0013\"\b\b\u0000\u0010\u0010*\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001fR%\u0010&\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010!0 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010#\u001a\u0004\b-\u0010\tR\u0016\u00102\u001a\u0004\u0018\u00010/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00106\u001a\u0004\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u000bR\u0016\u0010:\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u000bR\u0016\u0010>\u001a\u0004\u0018\u00010;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006B"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticFileMemberContainer;", "Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "Landroidx/room/compiler/processing/XEquality;", "", "binaryName", "<init>", "(Ljava/lang/String;)V", "Landroidx/room/compiler/codegen/XClassName;", "asClassName", "()Landroidx/room/compiler/codegen/XClassName;", "kindName", "()Ljava/lang/String;", "", "validate", "()Z", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "", "Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "hasAnnotation", "(Lkotlin/reflect/KClass;)Z", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "Ljava/lang/String;", "", "", "equalityItems$delegate", "Lkotlin/Lazy;", "getEqualityItems", "()[Ljava/lang/Object;", "equalityItems", "Lcom/squareup/javapoet/e;", "className$delegate", "getClassName", "()Lcom/squareup/javapoet/e;", "className", "xClassName$delegate", "getXClassName", "xClassName", "Landroidx/room/compiler/processing/ksp/KspType;", "getType", "()Landroidx/room/compiler/processing/ksp/KspType;", "type", "Lil/d;", "getDeclaration", "()Lil/d;", "declaration", "getFallbackLocationText", "fallbackLocationText", "getDocComment", "docComment", "Landroidx/room/compiler/processing/XElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XElement;", "enclosingElement", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticFileMemberContainer;", "closestMemberContainer", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspSyntheticFileMemberContainer implements KspMemberContainer, XEquality {
    private final String binaryName;
    private final Lazy className$delegate;
    private final Lazy equalityItems$delegate;
    private final Lazy xClassName$delegate;

    public KspSyntheticFileMemberContainer(String r5) {
        Intrinsics.checkNotNullParameter(r5, "binaryName");
        this.binaryName = r5;
        this.equalityItems$delegate = LazyKt.lazy(new KspSyntheticFileMemberContainer$equalityItems$2(this));
        this.className$delegate = LazyKt.lazy(new KspSyntheticFileMemberContainer$className$2(this));
        this.xClassName$delegate = LazyKt.lazy(new KspSyntheticFileMemberContainer$xClassName$2(this));
    }

    public static final /* synthetic */ String access$getBinaryName$p(KspSyntheticFileMemberContainer r5) {
        return r5.binaryName;
    }

    public static final /* synthetic */ XClassName access$getXClassName(KspSyntheticFileMemberContainer r5) {
        return r5.getXClassName();
    }

    private final XClassName getXClassName() {
        return (XClassName) this.xClassName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XMemberContainer
    public XClassName asClassName() {
        return getXClassName();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public List<XAnnotation> getAllAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.compiler.processing.XMemberContainer
    public e getClassName() {
        return (e) this.className$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public KspSyntheticFileMemberContainer getClosestMemberContainer() {
        return this;
    }

    @Override // androidx.room.compiler.processing.ksp.KspMemberContainer
    public d getDeclaration() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getDocComment() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public XElement getEnclosingElement() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XEquality
    public Object[] getEqualityItems() {
        return (Object[]) this.equalityItems$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getFallbackLocationText() {
        return this.binaryName;
    }

    @Override // androidx.room.compiler.processing.ksp.KspMemberContainer, androidx.room.compiler.processing.XMemberContainer
    public KspType getType() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotation(KClass<? extends Annotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return false;
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotationWithPackage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pkg");
        return false;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String kindName() {
        return "synthethic top level file";
    }

    @Override // androidx.room.compiler.processing.XElement
    public boolean validate() {
        return true;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getClosestMemberContainer() {
        return getClosestMemberContainer();
    }

    @Override // androidx.room.compiler.processing.XMemberContainer
    public /* bridge */ /* synthetic */ XType getType() {
        return getType();
    }
}
