package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBuiltInSerializerProtocol.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInSerializerProtocol.kt\norg/jetbrains/kotlin/serialization/deserialization/builtins/BuiltInSerializerProtocol\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {
    public static final BuiltInSerializerProtocol INSTANCE = null;

    static {
        INSTANCE = new BuiltInSerializerProtocol();
    }

    private BuiltInSerializerProtocol() {
        ExtensionRegistryLite r5 = ExtensionRegistryLite.newInstance();
        BuiltInsProtoBuf.registerAllExtensions(r5);
        super(r5, BuiltInsProtoBuf.packageFqName, BuiltInsProtoBuf.constructorAnnotation, BuiltInsProtoBuf.classAnnotation, BuiltInsProtoBuf.functionAnnotation, null, BuiltInsProtoBuf.propertyAnnotation, BuiltInsProtoBuf.propertyGetterAnnotation, BuiltInsProtoBuf.propertySetterAnnotation, null, null, null, BuiltInsProtoBuf.enumEntryAnnotation, BuiltInsProtoBuf.compileTimeValue, BuiltInsProtoBuf.parameterAnnotation, BuiltInsProtoBuf.typeAnnotation, BuiltInsProtoBuf.typeParameterAnnotation);
    }

    private final String shortName(FqName r5) {
        if (r5.isRoot() == false) goto L6;
        return "default-package";
    L6:
        return r5.shortName().asString();
    }

    public final String getBuiltInsFileName(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        return j0.q(new StringBuilder(), shortName(r5), ".kotlin_builtins");
    }

    public final String getBuiltInsFilePath(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        return StringsKt.E(r5.asString(), '.', '/') + '/' + getBuiltInsFileName(r5);
    }
}
