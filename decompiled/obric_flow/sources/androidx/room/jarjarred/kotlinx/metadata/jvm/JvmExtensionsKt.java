package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmClass;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructor;
import androidx.room.jarjarred.kotlinx.metadata.KmFunction;
import androidx.room.jarjarred.kotlinx.metadata.KmPackage;
import androidx.room.jarjarred.kotlinx.metadata.KmProperty;
import androidx.room.jarjarred.kotlinx.metadata.KmType;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameter;
import androidx.room.jarjarred.kotlinx.metadata.jvm.impl.JvmExtensionNodesKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\",\u0010\u000e\u001a\u0004\u0018\u00010\b*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\",\u0010\u0015\u001a\u0004\u0018\u00010\u0010*\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\",\u0010\u0019\u001a\u0004\u0018\u00010\u0016*\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014\"(\u0010\u001b\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\t\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\"0\u0010%\u001a\u00060\u001fj\u0002` *\u00020\u00072\n\u0010\t\u001a\u00060\u001fj\u0002` 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\"0\u0010%\u001a\u00060\u001fj\u0002` *\u00020\u000f2\n\u0010\t\u001a\u00060\u001fj\u0002` 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\",\u0010)\u001a\u0004\u0018\u00010\b*\u00020&2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010\r\"\u001b\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b*\u0010\u0004\"\u001b\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020,8F¢\u0006\u0006\u001a\u0004\b*\u0010\u0004\",\u0010/\u001a\u0004\u0018\u00010\b*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\r\",\u0010/\u001a\u0004\u0018\u00010\b*\u00020,2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\r\",\u00102\u001a\u0004\u0018\u00010\u0016*\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014\",\u00106\u001a\u0004\u0018\u00010\u0016*\u0002032\b\u0010\t\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014\",\u00106\u001a\u0004\u0018\u00010\u0016*\u00020&2\b\u0010\t\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014\",\u00109\u001a\u0004\u0018\u00010\u0016*\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014\",\u0010<\u001a\u0004\u0018\u00010\u0016*\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014¨\u0006="}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "getAnnotations", "(Ljava/lang/Object;)Ljava/util/List;", "annotations", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameter;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClass;", "", "value", "getAnonymousObjectOriginName", "(Ljava/lang/Object;)Ljava/lang/String;", "setAnonymousObjectOriginName", "(Ljava/lang/Object;Ljava/lang/String;)V", "anonymousObjectOriginName", "Landroidx/room/jarjarred/kotlinx/metadata/KmProperty;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFieldSignature;", "getFieldSignature", "(Ljava/lang/Object;)Ljava/lang/Object;", "setFieldSignature", "(Ljava/lang/Object;Ljava/lang/Object;)V", "fieldSignature", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "getGetterSignature", "setGetterSignature", "getterSignature", "", "isRaw", "(Ljava/lang/Object;)Z", "setRaw", "(Ljava/lang/Object;Z)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "getJvmFlags", "(Ljava/lang/Object;)I", "setJvmFlags", "(Ljava/lang/Object;I)V", "jvmFlags", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunction;", "getLambdaClassOriginName", "setLambdaClassOriginName", "lambdaClassOriginName", "getLocalDelegatedProperties", "localDelegatedProperties", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackage;", "getModuleName", "setModuleName", "moduleName", "getSetterSignature", "setSetterSignature", "setterSignature", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructor;", "getSignature", "setSignature", "signature", "getSyntheticMethodForAnnotations", "setSyntheticMethodForAnnotations", "syntheticMethodForAnnotations", "getSyntheticMethodForDelegate", "setSyntheticMethodForDelegate", "syntheticMethodForDelegate", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class JvmExtensionsKt {
    public static final List<KmAnnotation> getAnnotations(KmTypeParameter r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getAnnotations();
    }

    public static final String getAnonymousObjectOriginName(KmClass r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getAnonymousObjectOriginName();
    }

    public static final JvmFieldSignature getFieldSignature(KmProperty r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getFieldSignature();
    }

    public static final JvmMethodSignature getGetterSignature(KmProperty r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getGetterSignature();
    }

    public static final int getJvmFlags(KmClass r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getJvmFlags();
    }

    public static final String getLambdaClassOriginName(KmFunction r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getLambdaClassOriginName();
    }

    public static final List<KmProperty> getLocalDelegatedProperties(KmClass r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getLocalDelegatedProperties();
    }

    public static final String getModuleName(KmClass r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getModuleName();
    }

    public static final JvmMethodSignature getSetterSignature(KmProperty r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getSetterSignature();
    }

    public static final JvmMethodSignature getSignature(KmFunction r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getSignature();
    }

    public static final JvmMethodSignature getSyntheticMethodForAnnotations(KmProperty r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getSyntheticMethodForAnnotations();
    }

    public static final JvmMethodSignature getSyntheticMethodForDelegate(KmProperty r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getSyntheticMethodForDelegate();
    }

    public static final boolean isRaw(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).isRaw();
    }

    public static final void setAnonymousObjectOriginName(KmClass r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setAnonymousObjectOriginName(r10);
    }

    public static final void setFieldSignature(KmProperty r5, JvmFieldSignature r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setFieldSignature(r10);
    }

    public static final void setGetterSignature(KmProperty r5, JvmMethodSignature r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setGetterSignature(r10);
    }

    public static final void setJvmFlags(KmClass r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setJvmFlags(r10);
    }

    public static final void setLambdaClassOriginName(KmFunction r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setLambdaClassOriginName(r10);
    }

    public static final void setModuleName(KmClass r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setModuleName(r10);
    }

    public static final void setRaw(KmType r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setRaw(r10);
    }

    public static final void setSetterSignature(KmProperty r5, JvmMethodSignature r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setSetterSignature(r10);
    }

    public static final void setSignature(KmFunction r5, JvmMethodSignature r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setSignature(r10);
    }

    public static final void setSyntheticMethodForAnnotations(KmProperty r5, JvmMethodSignature r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setSyntheticMethodForAnnotations(r10);
    }

    public static final void setSyntheticMethodForDelegate(KmProperty r5, JvmMethodSignature r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setSyntheticMethodForDelegate(r10);
    }

    public static final List<KmAnnotation> getAnnotations(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getAnnotations();
    }

    public static final int getJvmFlags(KmProperty r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getJvmFlags();
    }

    public static final List<KmProperty> getLocalDelegatedProperties(KmPackage r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getLocalDelegatedProperties();
    }

    public static final String getModuleName(KmPackage r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getModuleName();
    }

    public static final JvmMethodSignature getSignature(KmConstructor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JvmExtensionNodesKt.getJvm(r5).getSignature();
    }

    public static final void setJvmFlags(KmProperty r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setJvmFlags(r10);
    }

    public static final void setModuleName(KmPackage r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setModuleName(r10);
    }

    public static final void setSignature(KmConstructor r5, JvmMethodSignature r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JvmExtensionNodesKt.getJvm(r5).setSignature(r10);
    }
}
