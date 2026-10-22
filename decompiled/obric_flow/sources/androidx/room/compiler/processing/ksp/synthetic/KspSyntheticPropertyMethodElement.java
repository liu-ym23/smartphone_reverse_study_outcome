package androidx.room.compiler.processing.ksp.synthetic;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XAnnotated;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XEquality;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XHasModifiers;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeParameterElement;
import androidx.room.compiler.processing.ksp.KSDeclarationExtKt;
import androidx.room.compiler.processing.ksp.KspAnnotated;
import androidx.room.compiler.processing.ksp.KspFieldElement;
import androidx.room.compiler.processing.ksp.KspHasModifiers;
import androidx.room.compiler.processing.ksp.KspJvmTypeResolutionScope;
import androidx.room.compiler.processing.ksp.KspProcessingEnv;
import androidx.room.compiler.processing.ksp.KspType;
import androidx.room.compiler.processing.ksp.ResolverExtKt;
import com.squareup.javapoet.e;
import il.k;
import il.m;
import il.n;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003TUVB!\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u000eJ\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u000eJ\r\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u000eJ\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u000eJ\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u0015\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010 H\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u001d\u0010+\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u00102R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00103\u001a\u0004\b4\u00105R!\u0010;\u001a\u00020&8VX\u0096\u0084\u0002¢\u0006\u0012\n\u0004\b6\u00107\u0012\u0004\b9\u0010:\u001a\u0004\b8\u0010(R%\u0010@\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010 0<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u00107\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u00107\u001a\u0004\bC\u0010DR\u001b\u0010I\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u00107\u001a\u0004\bG\u0010HR'\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001b0J8VX\u0096\u0084\u0002¢\u0006\u0012\n\u0004\bK\u00107\u0012\u0004\bN\u0010:\u001a\u0004\bL\u0010MR\u0011\u0010Q\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\bP\u0010DR\u0016\u0010S\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010(\u0082\u0001\u0002WX¨\u0006Y"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "Landroidx/room/compiler/processing/XMethodElement;", "Landroidx/room/compiler/processing/XEquality;", "Landroidx/room/compiler/processing/XHasModifiers;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspFieldElement;", "field", "Lil/k;", "accessor", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspFieldElement;Lil/k;)V", "", "isAbstract", "()Z", "isFinal", "isPrivate", "isProtected", "isPublic", "isStatic", "isTransient", "isJavaDefault", "hasKotlinDefaultImpl", "isSuspendFunction", "isExtensionFunction", "isVarArgs", "validate", "Landroidx/room/compiler/processing/XType;", "other", "Landroidx/room/compiler/processing/XMethodType;", "asMemberOf", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/XMethodType;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/room/compiler/processing/XTypeElement;", "owner", "overrides", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XTypeElement;)Z", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "getEnv", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Landroidx/room/compiler/processing/ksp/KspFieldElement;", "getField", "()Landroidx/room/compiler/processing/ksp/KspFieldElement;", "Lil/k;", "getAccessor", "()Lil/k;", "jvmName$delegate", "Lkotlin/Lazy;", "getJvmName", "getJvmName$annotations", "()V", "jvmName", "", "equalityItems$delegate", "getEqualityItems", "()[Ljava/lang/Object;", "equalityItems", "Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer$delegate", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer", "executableType$delegate", "getExecutableType", "()Landroidx/room/compiler/processing/XMethodType;", "executableType", "", "thrownTypes$delegate", "getThrownTypes", "()Ljava/util/List;", "getThrownTypes$annotations", "thrownTypes", "getEnclosingElement", "enclosingElement", "getDocComment", "docComment", "Companion", "Getter", "Setter", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Getter;", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Setter;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspSyntheticPropertyMethodElement implements XMethodElement, XEquality, XHasModifiers {
    public static final Companion Companion = null;
    private final /* synthetic */ XHasModifiers $$delegate_0;
    private final k accessor;
    private final Lazy closestMemberContainer$delegate;
    private final KspProcessingEnv env;
    private final Lazy equalityItems$delegate;
    private final Lazy executableType$delegate;
    private final KspFieldElement field;
    private final Lazy jvmName$delegate;
    private final Lazy thrownTypes$delegate;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/k;", "accessor", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "create", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/k;)Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "Landroidx/room/compiler/processing/ksp/KspFieldElement;", "field", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspFieldElement;Lil/k;)Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final KspSyntheticPropertyMethodElement create(KspProcessingEnv r5, k r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "accessor");
            r10.i();
            if (KSDeclarationExtKt.findEnclosingMemberContainer(null, r5) == null) goto L7;
            r10.i();
            return create(r5, new KspFieldElement(r5, null), r10);
        L7:
            throw new IllegalStateException(("XProcessing does not currently support annotations on top level properties with KSP. Cannot process " + r10 + '.').toString());
        }

        private Companion() {
        }

        public final KspSyntheticPropertyMethodElement create(KspProcessingEnv r5, KspFieldElement r10, k r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "field");
            Intrinsics.checkNotNullParameter(r11, "accessor");
            throw new IllegalStateException(("Unsupported property accessor " + r11).toString());
        }
    }

    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0018J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ4\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u000b\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001bJ\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\"\u001a\u00020!2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001f\"\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\"\u0010#J4\u0010\"\u001a\u00020!2\"\u0010 \u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00150\u001f\"\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015H\u0096\u0001¢\u0006\u0004\b\"\u0010$J\u001e\u0010\"\u001a\u00020!2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0%H\u0096\u0001¢\u0006\u0004\b\"\u0010&J\u0018\u0010'\u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b'\u0010(J \u0010'\u001a\u00020!2\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015H\u0096\u0001¢\u0006\u0004\b'\u0010)J\u0018\u0010,\u001a\u00020!2\u0006\u0010+\u001a\u00020*H\u0096\u0001¢\u0006\u0004\b,\u0010-J$\u0010.\u001a\u00020!2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001f\"\u00020\u000fH\u0096\u0001¢\u0006\u0004\b.\u0010#J4\u0010.\u001a\u00020!2\"\u0010 \u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00150\u001f\"\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015H\u0096\u0001¢\u0006\u0004\b.\u0010$J\u001e\u0010.\u001a\u00020!2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0%H\u0096\u0001¢\u0006\u0004\b.\u0010&J\u0018\u0010/\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b/\u0010\u0012J.\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0001¢\u0006\u0004\b/\u0010\u0018J0\u00100\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0097\u0001¢\u0006\u0004\b0\u0010\u0018J\u000f\u00101\u001a\u00020*H\u0016¢\u0006\u0004\b1\u00102R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b4\u00105R\u001b\u00109\u001a\u00020*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00102R\u001b\u0010>\u001a\u00020:8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u0010=R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020?0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u000eR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020B0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u000e¨\u0006E"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Getter;", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspFieldElement;", "field", "Lil/m;", "accessor", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspFieldElement;Lil/m;)V", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "kindName", "()Ljava/lang/String;", "Lil/m;", "getAccessor", "()Lil/m;", "name$delegate", "Lkotlin/Lazy;", "getName", "name", "Landroidx/room/compiler/processing/XType;", "returnType$delegate", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "returnType", "Landroidx/room/compiler/processing/XTypeParameterElement;", "getTypeParameters", "typeParameters", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "getParameters", "parameters", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Getter extends KspSyntheticPropertyMethodElement implements XAnnotated {
        private final /* synthetic */ KspAnnotated $$delegate_0;
        private final m accessor;
        private final Lazy name$delegate;
        private final Lazy returnType$delegate;

        public Getter(KspProcessingEnv r5, final KspFieldElement r10, m r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "field");
            Intrinsics.checkNotNullParameter(r11, "accessor");
            super(r5, r10, r11, null);
            this.$$delegate_0 = KspAnnotated.Companion.create(r5, r11, KspAnnotated.UseSiteFilter.Companion.getNO_USE_SITE_OR_GETTER());
            this.name$delegate = LazyKt.lazy(new KspSyntheticPropertyMethodElement$Getter$name$2(r10));
            this.returnType$delegate = LazyKt.lazy(new KspSyntheticPropertyMethodElement$Getter$returnType$2(r10));
        }

        @Override // androidx.room.compiler.processing.ksp.synthetic.KspSyntheticPropertyMethodElement
        public /* bridge */ /* synthetic */ k getAccessor() {
            getAccessor();
            return null;
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public List<XAnnotation> getAllAnnotations() {
            return this.$$delegate_0.getAllAnnotations();
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public XAnnotation getAnnotation(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.getAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public List<XAnnotation> getAnnotations(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.getAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public Set<XAnnotation> getAnnotationsAnnotatedWith(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.getAnnotationsAnnotatedWith(r5);
        }

        @Override // androidx.room.compiler.processing.XElement
        public String getName() {
            return (String) this.name$delegate.getValue();
        }

        @Override // androidx.room.compiler.processing.XExecutableElement
        public List<XExecutableParameterElement> getParameters() {
            return CollectionsKt.emptyList();
        }

        @Override // androidx.room.compiler.processing.XMethodElement
        public XType getReturnType() {
            return (XType) this.returnType$delegate.getValue();
        }

        @Override // androidx.room.compiler.processing.XParameterizable
        public List<XTypeParameterElement> getTypeParameters() {
            return CollectionsKt.emptyList();
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAllAnnotations(Collection<e> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAllAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnnotation(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.hasAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnnotationWithPackage(String r5) {
            Intrinsics.checkNotNullParameter(r5, "pkg");
            return this.$$delegate_0.hasAnnotationWithPackage(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnyAnnotation(Collection<e> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAnyAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XElement
        public String kindName() {
            return "synthetic property getter";
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public XAnnotation requireAnnotation(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.requireAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        @Deprecated(message = "Use getAnnotation(not repeatable) or getAnnotations (repeatable)", replaceWith = @ReplaceWith(expression = "getAnnotation(annotation)", imports = {}))
        public <T extends Annotation> XAnnotationBox<T> toAnnotationBox(KClass<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.toAnnotationBox(r5);
        }

        @Override // androidx.room.compiler.processing.ksp.synthetic.KspSyntheticPropertyMethodElement
        public m getAccessor() {
            return null;
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public <T extends Annotation> XAnnotationBox<T> getAnnotation(KClass<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.getAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.getAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAllAnnotations(e... r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAllAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnnotation(KClass<? extends Annotation> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.hasAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnyAnnotation(e... r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAnyAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public <T extends Annotation> XAnnotationBox<T> requireAnnotation(KClass<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.requireAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAllAnnotations(KClass<? extends Annotation>... r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAllAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnyAnnotation(KClass<? extends Annotation>... r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAnyAnnotation(r5);
        }
    }

    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001FB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0018J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ4\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u000b\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001bJ\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\"\u001a\u00020!2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001f\"\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\"\u0010#J4\u0010\"\u001a\u00020!2\"\u0010 \u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00150\u001f\"\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015H\u0096\u0001¢\u0006\u0004\b\"\u0010$J\u001e\u0010\"\u001a\u00020!2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0%H\u0096\u0001¢\u0006\u0004\b\"\u0010&J\u0018\u0010'\u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b'\u0010(J \u0010'\u001a\u00020!2\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015H\u0096\u0001¢\u0006\u0004\b'\u0010)J\u0018\u0010,\u001a\u00020!2\u0006\u0010+\u001a\u00020*H\u0096\u0001¢\u0006\u0004\b,\u0010-J$\u0010.\u001a\u00020!2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001f\"\u00020\u000fH\u0096\u0001¢\u0006\u0004\b.\u0010#J4\u0010.\u001a\u00020!2\"\u0010 \u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00150\u001f\"\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015H\u0096\u0001¢\u0006\u0004\b.\u0010$J\u001e\u0010.\u001a\u00020!2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0%H\u0096\u0001¢\u0006\u0004\b.\u0010&J\u0018\u0010/\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b/\u0010\u0012J.\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0001¢\u0006\u0004\b/\u0010\u0018J0\u00100\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0097\u0001¢\u0006\u0004\b0\u0010\u0018J\u000f\u00101\u001a\u00020*H\u0016¢\u0006\u0004\b1\u00102R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b4\u00105R\u001b\u00109\u001a\u00020*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00102R\u001b\u0010>\u001a\u00020:8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u0010=R!\u0010B\u001a\b\u0012\u0004\u0012\u00020?0\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u00107\u001a\u0004\bA\u0010\u000eR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020C0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u000e¨\u0006G"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Setter;", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspFieldElement;", "field", "Lil/n;", "accessor", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspFieldElement;Lil/n;)V", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "kindName", "()Ljava/lang/String;", "Lil/n;", "getAccessor", "()Lil/n;", "name$delegate", "Lkotlin/Lazy;", "getName", "name", "Landroidx/room/compiler/processing/XType;", "returnType$delegate", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "returnType", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "parameters$delegate", "getParameters", "parameters", "Landroidx/room/compiler/processing/XTypeParameterElement;", "getTypeParameters", "typeParameters", "SyntheticExecutableParameterElement", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Setter extends KspSyntheticPropertyMethodElement implements XAnnotated {
        private final /* synthetic */ KspAnnotated $$delegate_0;
        private final n accessor;
        private final Lazy name$delegate;
        private final Lazy parameters$delegate;
        private final Lazy returnType$delegate;

        @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J4\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\t\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0019J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001a2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010 \u001a\u00020\u001f2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001d\"\u00020\rH\u0096\u0001¢\u0006\u0004\b \u0010!J4\u0010 \u001a\u00020\u001f2\"\u0010\u001e\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00130\u001d\"\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013H\u0096\u0001¢\u0006\u0004\b \u0010\"J\u001e\u0010 \u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0#H\u0096\u0001¢\u0006\u0004\b \u0010$J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b%\u0010&J \u0010%\u001a\u00020\u001f2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013H\u0096\u0001¢\u0006\u0004\b%\u0010'J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020(H\u0096\u0001¢\u0006\u0004\b*\u0010+J$\u0010,\u001a\u00020\u001f2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001d\"\u00020\rH\u0096\u0001¢\u0006\u0004\b,\u0010!J4\u0010,\u001a\u00020\u001f2\"\u0010\u001e\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00130\u001d\"\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013H\u0096\u0001¢\u0006\u0004\b,\u0010\"J\u001e\u0010,\u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0#H\u0096\u0001¢\u0006\u0004\b,\u0010$J\u0018\u0010-\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b-\u0010\u0010J.\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096\u0001¢\u0006\u0004\b-\u0010\u0016J0\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0097\u0001¢\u0006\u0004\b.\u0010\u0016J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020(H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u001fH\u0016¢\u0006\u0004\b6\u00107R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00108R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u00109\u001a\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010B\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u00105R\u001b\u0010F\u001a\u0002018VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u0010@\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bH\u0010@\u001a\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u00105R\u0014\u0010O\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u00107R\u0016\u0010Q\u001a\u0004\u0018\u00010(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u00105¨\u0006R"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Setter$SyntheticExecutableParameterElement;", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Setter;", "enclosingElement", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Setter;)V", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "Landroidx/room/compiler/processing/XType;", "other", "Landroidx/room/compiler/processing/ksp/KspType;", "asMemberOf", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/ksp/KspType;", "kindName", "()Ljava/lang/String;", "validate", "()Z", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Setter;", "getEnclosingElement", "()Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Setter;", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope$PropertySetterParameter;", "jvmTypeResolutionScope", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope$PropertySetterParameter;", "name$delegate", "Lkotlin/Lazy;", "getName", "name", "type$delegate", "getType", "()Landroidx/room/compiler/processing/ksp/KspType;", "type", "Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer$delegate", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer", "getFallbackLocationText", "fallbackLocationText", "getHasDefaultValue", "hasDefaultValue", "getDocComment", "docComment", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class SyntheticExecutableParameterElement implements XExecutableParameterElement, XAnnotated {
            private final /* synthetic */ KspAnnotated $$delegate_0;
            private final Lazy closestMemberContainer$delegate;
            private final Setter enclosingElement;
            private final KspProcessingEnv env;
            private final KspJvmTypeResolutionScope.PropertySetterParameter jvmTypeResolutionScope;
            private final Lazy name$delegate;
            private final Lazy type$delegate;

            public SyntheticExecutableParameterElement(KspProcessingEnv r5, Setter r10) {
                Intrinsics.checkNotNullParameter(r5, "env");
                Intrinsics.checkNotNullParameter(r10, "enclosingElement");
                this.env = r5;
                this.enclosingElement = r10;
                KspAnnotated.Companion r11 = KspAnnotated.Companion;
                r10.getField().getDeclaration();
                throw null;
            }

            public static final /* synthetic */ KspJvmTypeResolutionScope.PropertySetterParameter access$getJvmTypeResolutionScope$p(SyntheticExecutableParameterElement r5) {
                return r5.jvmTypeResolutionScope;
            }

            @Override // androidx.room.compiler.processing.XVariableElement
            public /* bridge */ /* synthetic */ XType asMemberOf(XType r5) {
                return asMemberOf(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public List<XAnnotation> getAllAnnotations() {
                return this.$$delegate_0.getAllAnnotations();
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public XAnnotation getAnnotation(e r5) {
                Intrinsics.checkNotNullParameter(r5, "annotationName");
                return this.$$delegate_0.getAnnotation(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public List<XAnnotation> getAnnotations(e r5) {
                Intrinsics.checkNotNullParameter(r5, "annotationName");
                return this.$$delegate_0.getAnnotations(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public Set<XAnnotation> getAnnotationsAnnotatedWith(e r5) {
                Intrinsics.checkNotNullParameter(r5, "annotationName");
                return this.$$delegate_0.getAnnotationsAnnotatedWith(r5);
            }

            @Override // androidx.room.compiler.processing.XElement
            public XMemberContainer getClosestMemberContainer() {
                return (XMemberContainer) this.closestMemberContainer$delegate.getValue();
            }

            @Override // androidx.room.compiler.processing.XElement
            public String getDocComment() {
                return null;
            }

            @Override // androidx.room.compiler.processing.XElement
            public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
                return getEnclosingElement();
            }

            @Override // androidx.room.compiler.processing.XElement
            public String getFallbackLocationText() {
                return getName() + " in " + getEnclosingElement().getFallbackLocationText();
            }

            @Override // androidx.room.compiler.processing.XExecutableParameterElement
            public boolean getHasDefaultValue() {
                return false;
            }

            @Override // androidx.room.compiler.processing.XElement
            public String getName() {
                return (String) this.name$delegate.getValue();
            }

            @Override // androidx.room.compiler.processing.XVariableElement
            public /* bridge */ /* synthetic */ XType getType() {
                return getType();
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public boolean hasAllAnnotations(Collection<e> r5) {
                Intrinsics.checkNotNullParameter(r5, "annotations");
                return this.$$delegate_0.hasAllAnnotations(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public boolean hasAnnotation(e r5) {
                Intrinsics.checkNotNullParameter(r5, "annotationName");
                return this.$$delegate_0.hasAnnotation(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public boolean hasAnnotationWithPackage(String r5) {
                Intrinsics.checkNotNullParameter(r5, "pkg");
                return this.$$delegate_0.hasAnnotationWithPackage(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public boolean hasAnyAnnotation(Collection<e> r5) {
                Intrinsics.checkNotNullParameter(r5, "annotations");
                return this.$$delegate_0.hasAnyAnnotation(r5);
            }

            @Override // androidx.room.compiler.processing.XElement
            public String kindName() {
                return "method parameter";
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public XAnnotation requireAnnotation(e r5) {
                Intrinsics.checkNotNullParameter(r5, "annotationName");
                return this.$$delegate_0.requireAnnotation(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            @Deprecated(message = "Use getAnnotation(not repeatable) or getAnnotations (repeatable)", replaceWith = @ReplaceWith(expression = "getAnnotation(annotation)", imports = {}))
            public <T extends Annotation> XAnnotationBox<T> toAnnotationBox(KClass<T> r5) {
                Intrinsics.checkNotNullParameter(r5, "annotation");
                return this.$$delegate_0.toAnnotationBox(r5);
            }

            @Override // androidx.room.compiler.processing.XElement
            public boolean validate() {
                return true;
            }

            @Override // androidx.room.compiler.processing.XVariableElement
            public KspType asMemberOf(XType r5) {
                Intrinsics.checkNotNullParameter(r5, "other");
                return getEnclosingElement().getField().asMemberOf(r5).withJvmTypeResolver(this.jvmTypeResolutionScope);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public <T extends Annotation> XAnnotationBox<T> getAnnotation(KClass<T> r5) {
                Intrinsics.checkNotNullParameter(r5, "annotation");
                return this.$$delegate_0.getAnnotation(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5) {
                Intrinsics.checkNotNullParameter(r5, "annotation");
                return this.$$delegate_0.getAnnotations(r5);
            }

            @Override // androidx.room.compiler.processing.XExecutableParameterElement, androidx.room.compiler.processing.XElement
            public /* bridge */ /* synthetic */ XExecutableElement getEnclosingElement() {
                return getEnclosingElement();
            }

            @Override // androidx.room.compiler.processing.XVariableElement
            public KspType getType() {
                return (KspType) this.type$delegate.getValue();
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public boolean hasAllAnnotations(e... r5) {
                Intrinsics.checkNotNullParameter(r5, "annotations");
                return this.$$delegate_0.hasAllAnnotations(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public boolean hasAnnotation(KClass<? extends Annotation> r5) {
                Intrinsics.checkNotNullParameter(r5, "annotation");
                return this.$$delegate_0.hasAnnotation(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public boolean hasAnyAnnotation(e... r5) {
                Intrinsics.checkNotNullParameter(r5, "annotations");
                return this.$$delegate_0.hasAnyAnnotation(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public <T extends Annotation> XAnnotationBox<T> requireAnnotation(KClass<T> r5) {
                Intrinsics.checkNotNullParameter(r5, "annotation");
                return this.$$delegate_0.requireAnnotation(r5);
            }

            @Override // androidx.room.compiler.processing.XExecutableParameterElement, androidx.room.compiler.processing.XElement
            public Setter getEnclosingElement() {
                return this.enclosingElement;
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public boolean hasAllAnnotations(KClass<? extends Annotation>... r5) {
                Intrinsics.checkNotNullParameter(r5, "annotations");
                return this.$$delegate_0.hasAllAnnotations(r5);
            }

            @Override // androidx.room.compiler.processing.XAnnotated
            public boolean hasAnyAnnotation(KClass<? extends Annotation>... r5) {
                Intrinsics.checkNotNullParameter(r5, "annotations");
                return this.$$delegate_0.hasAnyAnnotation(r5);
            }
        }

        public Setter(KspProcessingEnv r5, KspFieldElement r10, n r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "field");
            Intrinsics.checkNotNullParameter(r11, "accessor");
            super(r5, r10, r11, null);
            KspAnnotated.Companion r12 = KspAnnotated.Companion;
            r10.getDeclaration();
            throw null;
        }

        @Override // androidx.room.compiler.processing.ksp.synthetic.KspSyntheticPropertyMethodElement
        public /* bridge */ /* synthetic */ k getAccessor() {
            getAccessor();
            return null;
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public List<XAnnotation> getAllAnnotations() {
            return this.$$delegate_0.getAllAnnotations();
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public XAnnotation getAnnotation(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.getAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public List<XAnnotation> getAnnotations(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.getAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public Set<XAnnotation> getAnnotationsAnnotatedWith(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.getAnnotationsAnnotatedWith(r5);
        }

        @Override // androidx.room.compiler.processing.XElement
        public String getName() {
            return (String) this.name$delegate.getValue();
        }

        @Override // androidx.room.compiler.processing.XExecutableElement
        public List<XExecutableParameterElement> getParameters() {
            return (List) this.parameters$delegate.getValue();
        }

        @Override // androidx.room.compiler.processing.XMethodElement
        public XType getReturnType() {
            return (XType) this.returnType$delegate.getValue();
        }

        @Override // androidx.room.compiler.processing.XParameterizable
        public List<XTypeParameterElement> getTypeParameters() {
            return CollectionsKt.emptyList();
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAllAnnotations(Collection<e> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAllAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnnotation(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.hasAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnnotationWithPackage(String r5) {
            Intrinsics.checkNotNullParameter(r5, "pkg");
            return this.$$delegate_0.hasAnnotationWithPackage(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnyAnnotation(Collection<e> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAnyAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XElement
        public String kindName() {
            return "synthetic property getter";
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public XAnnotation requireAnnotation(e r5) {
            Intrinsics.checkNotNullParameter(r5, "annotationName");
            return this.$$delegate_0.requireAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        @Deprecated(message = "Use getAnnotation(not repeatable) or getAnnotations (repeatable)", replaceWith = @ReplaceWith(expression = "getAnnotation(annotation)", imports = {}))
        public <T extends Annotation> XAnnotationBox<T> toAnnotationBox(KClass<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.toAnnotationBox(r5);
        }

        @Override // androidx.room.compiler.processing.ksp.synthetic.KspSyntheticPropertyMethodElement
        public n getAccessor() {
            return null;
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public <T extends Annotation> XAnnotationBox<T> getAnnotation(KClass<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.getAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.getAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAllAnnotations(e... r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAllAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnnotation(KClass<? extends Annotation> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.hasAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnyAnnotation(e... r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAnyAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public <T extends Annotation> XAnnotationBox<T> requireAnnotation(KClass<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return this.$$delegate_0.requireAnnotation(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAllAnnotations(KClass<? extends Annotation>... r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAllAnnotations(r5);
        }

        @Override // androidx.room.compiler.processing.XAnnotated
        public boolean hasAnyAnnotation(KClass<? extends Annotation>... r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            return this.$$delegate_0.hasAnyAnnotation(r5);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KspSyntheticPropertyMethodElement(KspProcessingEnv r5, KspFieldElement r10, k r11, DefaultConstructorMarker r12) {
        this(r5, r10, r11);
    }

    public static /* synthetic */ void getJvmName$annotations() {
    }

    public static /* synthetic */ void getThrownTypes$annotations() {
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType asMemberOf(XType r5) {
        return asMemberOf(r5);
    }

    public boolean equals(Object r5) {
        return XEquality.Companion.equals(this, r5);
    }

    public k getAccessor() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public final XMemberContainer getClosestMemberContainer() {
        return (XMemberContainer) this.closestMemberContainer$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getDocComment() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    public final KspProcessingEnv getEnv() {
        return this.env;
    }

    @Override // androidx.room.compiler.processing.XEquality
    public Object[] getEqualityItems() {
        return (Object[]) this.equalityItems$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType getExecutableType() {
        return getExecutableType();
    }

    public final KspFieldElement getField() {
        return this.field;
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public String getJvmName() {
        return (String) this.jvmName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public List<XType> getThrownTypes() {
        return (List) this.thrownTypes$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public final boolean hasKotlinDefaultImpl() {
        return false;
    }

    public int hashCode() {
        return XEquality.Companion.hashCode(getEqualityItems());
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isAbstract() {
        return this.$$delegate_0.isAbstract();
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public final boolean isExtensionFunction() {
        return false;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isFinal() {
        return this.$$delegate_0.isFinal();
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public final boolean isJavaDefault() {
        return false;
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

    @Override // androidx.room.compiler.processing.XMethodElement
    public final boolean isSuspendFunction() {
        return false;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isTransient() {
        return this.$$delegate_0.isTransient();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public final boolean isVarArgs() {
        return false;
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public final boolean overrides(XMethodElement r5, XTypeElement r10) {
        Intrinsics.checkNotNullParameter(r5, "other");
        Intrinsics.checkNotNullParameter(r10, "owner");
        this.env.getResolver();
        return ResolverExtKt.overrides(null, this, r5);
    }

    public String toString() {
        return getJvmName();
    }

    @Override // androidx.room.compiler.processing.XElement
    public boolean validate() {
        return true;
    }

    private KspSyntheticPropertyMethodElement(KspProcessingEnv r5, KspFieldElement r10, k r11) {
        this.env = r5;
        this.field = r10;
        KspHasModifiers.Companion r12 = KspHasModifiers.Companion;
        r10.getDeclaration();
        this.$$delegate_0 = r12.createForSyntheticAccessor(null, r11);
        this.jvmName$delegate = LazyKt.lazy(new KspSyntheticPropertyMethodElement$jvmName$2(this));
        this.equalityItems$delegate = LazyKt.lazy(new KspSyntheticPropertyMethodElement$equalityItems$2(this));
        this.closestMemberContainer$delegate = LazyKt.lazy(new KspSyntheticPropertyMethodElement$closestMemberContainer$2(this));
        this.executableType$delegate = LazyKt.lazy(new KspSyntheticPropertyMethodElement$executableType$2(this));
        this.thrownTypes$delegate = LazyKt.lazy(new KspSyntheticPropertyMethodElement$thrownTypes$2(this));
    }

    @Override // androidx.room.compiler.processing.XMethodElement, androidx.room.compiler.processing.XExecutableElement
    public final XMethodType asMemberOf(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return KspSyntheticPropertyMethodType.Companion.create(this.env, this, r5);
    }

    @Override // androidx.room.compiler.processing.XExecutableElement, androidx.room.compiler.processing.XElement
    public final XMemberContainer getEnclosingElement() {
        return this.field.getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XMethodElement, androidx.room.compiler.processing.XExecutableElement
    public final XMethodType getExecutableType() {
        return (XMethodType) this.executableType$delegate.getValue();
    }
}
