package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes3.dex */
class TypeCheckerProcedureCallbacksImpl implements TypeCheckingProcedureCallbacks {
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[3];
        switch(r10) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L4;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L9;
            case 8: goto L6;
            case 9: goto L5;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L4;
        };
    L4:
        r11[0] = "a";
    L11:
        r11[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch(r10) {
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L14;
            default: goto L13;
        };
    L13:
        r11[2] = "assertEqualTypes";
    L19:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
    L14:
        r11[2] = "noCorrespondingSupertype";
        goto L19
    L15:
        r11[2] = "capture";
        goto L19
    L16:
        r11[2] = "assertSubtype";
        goto L19
    L17:
        r11[2] = "assertEqualTypeConstructors";
        goto L19
    L5:
        r11[0] = "typeProjection";
        goto L11
    L6:
        r11[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L11
    L7:
        r11[0] = "supertype";
        goto L11
    L8:
        r11[0] = "subtype";
        goto L11
    L9:
        r11[0] = "typeCheckingProcedure";
        goto L11
    L10:
        r11[0] = "b";
        goto L11
    }

    TypeCheckerProcedureCallbacksImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks
    public boolean assertEqualTypeConstructors(TypeConstructor r10, TypeConstructor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return r10.equals(r11);
    }
}
