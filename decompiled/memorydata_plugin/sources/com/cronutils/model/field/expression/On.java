package com.cronutils.model.field.expression;

import androidx.exifinterface.media.ExifInterface;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.field.value.SpecialCharFieldValue;
import com.cronutils.utils.a;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class On extends FieldExpression {
    private static final int DEFAULT_NTH_VALUE = -1;
    private static final long serialVersionUID = 8746471281123327324L;
    private final IntegerFieldValue nth;
    private final SpecialCharFieldValue specialChar;
    private final IntegerFieldValue time;

    /* JADX INFO: renamed from: com.cronutils.model.field.expression.On$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3420a = null;

        static {
            int[] r0 = new int[SpecialChar.values().length];
            f3420a = r0;
            r0[SpecialChar.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f3420a[SpecialChar.HASH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f3420a[SpecialChar.W.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f3420a[SpecialChar.L.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f3420a[SpecialChar.QUESTION_MARK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public On(IntegerFieldValue r3) {
        this(r3, new SpecialCharFieldValue(SpecialChar.NONE));
    }

    public On(IntegerFieldValue r3, SpecialCharFieldValue r4) {
        this(r3, r4, new IntegerFieldValue(-1));
        a.a(!r4.getValue().equals(SpecialChar.HASH), "value missing for a#b cron expression");
    }

    public On(IntegerFieldValue r2, SpecialCharFieldValue r3, IntegerFieldValue r4) {
        a.a(r2, "time must not be null");
        a.a(r3, "special char must not null");
        a.a(r4, "nth value must not be null");
        this.time = r2;
        this.specialChar = r3;
        this.nth = r4;
    }

    public On(SpecialCharFieldValue r3) {
        this(new IntegerFieldValue(-1), r3);
    }

    private String getNthStringRepresentation() {
        if (isDefault(getNth()) == false) goto L6;
        return "";
    L6:
        return String.format("-%s", new Object[]{getNth()});
    }

    private boolean isDefault(IntegerFieldValue r1) {
        if (r1.getValue().intValue() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(com.cronutils.model.field.expression.a.a r3) {
        return ((com.cronutils.model.field.expression.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.cronutils.model.field.expression.a.a.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        int r0 = AnonymousClass1.f3420a[this.specialChar.getValue().ordinal()];
        if (r0 == 1) goto L29;
        if (r0 == 2) goto L27;
        if (r0 == 3) goto L22;
        if (r0 == 4) goto L17;
        if (r0 != 5) goto L13;
        return "?";
    L13:
        return this.specialChar.toString();
    L17:
        if (isDefault(getTime()) == false) goto L20;
        return i.u + getNthStringRepresentation();
    L20:
        return String.format("%sL", new Object[]{getTime()});
    L22:
        if (isDefault(getTime()) == false) goto L25;
        return ExifInterface.LONGITUDE_WEST;
    L25:
        return String.format("%sW", new Object[]{getTime()});
    L27:
        return String.format("%s#%s", new Object[]{getTime(), getNth()});
    L29:
        return getTime().toString();
    }

    public IntegerFieldValue getNth() {
        return this.nth;
    }

    public SpecialCharFieldValue getSpecialChar() {
        return this.specialChar;
    }

    public IntegerFieldValue getTime() {
        return this.time;
    }
}
