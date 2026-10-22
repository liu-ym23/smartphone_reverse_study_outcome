package androidx.room.compiler.codegen;

import androidx.room.compiler.codegen.java.JavaTypeSpec;
import androidx.room.compiler.codegen.kotlin.KotlinTypeSpec;
import androidx.room.compiler.processing.JavaPoetExtKt;
import androidx.room.compiler.processing.KotlinPoetExtKt;
import androidx.room.compiler.processing.XElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"addOriginatingElement", "Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "element", "Landroidx/room/compiler/processing/XElement;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XTypeSpecKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[CodeLanguage.values().length];
            r5[CodeLanguage.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[CodeLanguage.KOTLIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final XTypeSpec.Builder addOriginatingElement(XTypeSpec.Builder r5, XElement r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "element");
        CodeLanguage r11 = r5.getLanguage();
        int r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r12 == 1) goto L13;
        if (r12 == 2) goto L8;
    L15:
        return r5;
    L8:
        if ((r5 instanceof KotlinTypeSpec.Builder) == false) goto L11;
        KotlinPoetExtKt.addOriginatingElement(((KotlinTypeSpec.Builder) r5).getActual$room_compiler_processing(), r10);
        goto L15
    L11:
        throw new IllegalStateException("Check failed.");
    L13:
        if ((r5 instanceof JavaTypeSpec.Builder) == false) goto L17;
        JavaPoetExtKt.addOriginatingElement(((JavaTypeSpec.Builder) r5).getActual$room_compiler_processing(), r10);
        goto L15
    L17:
        throw new IllegalStateException("Check failed.");
    }
}
