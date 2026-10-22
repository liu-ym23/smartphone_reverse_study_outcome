package androidx.room.compiler.codegen.kotlin;

import androidx.room.compiler.codegen.VisibilityModifier;
import com.squareup.kotlinpoet.KModifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toKotlinVisibilityModifier", "Lcom/squareup/kotlinpoet/KModifier;", "Landroidx/room/compiler/codegen/VisibilityModifier;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KotlinFunSpecKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[VisibilityModifier.values().length];
            r5[VisibilityModifier.PUBLIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[VisibilityModifier.PROTECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[VisibilityModifier.PRIVATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final KModifier toKotlinVisibilityModifier(VisibilityModifier r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L15;
        if (r10 != 3) goto L10;
        return KModifier.PRIVATE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return KModifier.PROTECTED;
    L13:
        return KModifier.PUBLIC;
    }
}
