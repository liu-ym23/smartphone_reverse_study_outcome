package org.bouncycastle.math.field;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
class GenericPolynomialExtensionField implements PolynomialExtensionField {
    protected final Polynomial minimalPolynomial;
    protected final FiniteField subfield;

    GenericPolynomialExtensionField(FiniteField r3, Polynomial r4) {
        FiniteField r5 = (FiniteField) ZeusTransformUtils.wrapperContextForParams(r3, FiniteField.class, "com.obric.memorydata.plugin");
        Polynomial r6 = (Polynomial) ZeusTransformUtils.wrapperContextForParams(r4, Polynomial.class, "com.obric.memorydata.plugin");
        this.subfield = r5;
        this.minimalPolynomial = r6;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GenericPolynomialExtensionField.class) == true) goto L8;
        return false;
    L8:
        GenericPolynomialExtensionField r6 = (GenericPolynomialExtensionField) ZeusTransformUtils.preCheckCast(r5, GenericPolynomialExtensionField.class, "com.obric.memorydata.plugin");
        if (this.subfield.equals(r6.subfield) == false) goto L14;
        if (this.minimalPolynomial.equals(r6.minimalPolynomial) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public BigInteger getCharacteristic() {
        return this.subfield.getCharacteristic();
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public int getDimension() {
        return this.subfield.getDimension() * this.minimalPolynomial.getDegree();
    }

    @Override // org.bouncycastle.math.field.PolynomialExtensionField
    public Polynomial getMinimalPolynomial() {
        return this.minimalPolynomial;
    }

    public int hashCode() {
        int r0 = this.subfield.hashCode();
        return Integers.rotateLeft(this.minimalPolynomial.hashCode(), 16) ^ r0;
    }
}
