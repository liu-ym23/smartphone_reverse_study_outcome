package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;

/* JADX INFO: loaded from: classes7.dex */
public class XmlComplexContentImpl extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SchemaTypeImpl _schemaType;

    static {
    }

    public XmlComplexContentImpl(SchemaType r3) {
        this._schemaType = (SchemaTypeImpl) ZeusTransformUtils.preCheckCast((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), SchemaTypeImpl.class, "com.obric.memorydata.plugin");
        initComplexType(true, true);
    }

    private void commonSetterHelper(QName r6, QNameSet r7, int r8, BiConsumer<XmlObjectBase, Integer> r9) {
        BiConsumer r10 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r9, BiConsumer.class, "com.obric.memorydata.plugin");
        TypeStore r5 = get_store();
        if (r7 != null) goto L5;
        int r0 = r5.count_elements(r6);
    L6:
        if (r0 <= r8) goto L12;
        int r2 = r0 - 1;
        if (r7 != null) goto L10;
        r5.remove_element(r6, r2);
    L11:
        r0 = r0 - 1;
        goto L6
    L10:
        r5.remove_element(r7, r2);
        goto L11
    L12:
        int r3 = 0;
    L13:
        if (r3 >= r8) goto L20;
        if (r3 < r0) goto L16;
        TypeStoreUser r4 = r5.add_element_user(r6);
    L19:
        r10.accept((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin"), Integer.valueOf(r3));
        r3 = r3 + 1;
        goto L13
    L16:
        if (r7 != null) goto L18;
        r4 = r5.find_element_user(r6, r3);
        goto L19
    L18:
        r4 = r5.find_element_user(r7, r3);
        goto L19
    L20:
        return;
    L5:
        r0 = r5.count_elements(r7);
        goto L6
    }

    private <T> void commonSetterHelper(QName r3, QNameSet r4, T[] r5, BiConsumer<XmlObjectBase, Integer> r6) {
        BiConsumer<XmlObjectBase, Integer> r7 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r6, BiConsumer.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        int r8 = 0;
    L6:
        commonSetterHelper(r3, r4, r8, r7);
        return;
    L5:
        r8 = r5.length;
        goto L6
    }

    private <T> void commonSetterHelper2(QName r7, QNameSet r8, T[] r9, BiConsumer<XmlObjectBase, T> r10) {
        BiConsumer r11 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r10, BiConsumer.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r9 != null) goto L5;
        int r2 = 0;
    L6:
        TypeStore r6 = get_store();
        if (r8 != null) goto L9;
        int r3 = r6.count_elements(r7);
    L10:
        if (r3 <= r2) goto L16;
        int r4 = r3 - 1;
        if (r8 != null) goto L14;
        r6.remove_element(r7, r4);
    L15:
        r3 = r3 - 1;
        goto L10
    L14:
        r6.remove_element(r8, r4);
    L16:
        if (r0 >= r2) goto L23;
        if (r0 < r3) goto L19;
        TypeStoreUser r5 = r6.add_element_user(r7);
    L22:
        r11.accept((XmlObjectBase) ZeusTransformUtils.preCheckCast(r5, XmlObjectBase.class, "com.obric.memorydata.plugin"), r9[r0]);
        r0 = r0 + 1;
        goto L16
    L19:
        if (r8 != null) goto L21;
        r5 = r6.find_element_user(r7, r0);
        goto L22
    L21:
        r5 = r6.find_element_user(r8, r0);
        goto L22
    L23:
        return;
    L9:
        r3 = r6.count_elements(r8);
        goto L10
    L5:
        r2 = r9.length;
        goto L6
    }

    static /* synthetic */ void lambda$arraySetterHelper$0(SimpleValue[] r0, XmlObjectBase r1, Integer r2) {
        r0[r2.intValue()] = r1;
    }

    static /* synthetic */ void lambda$arraySetterHelper$1(SimpleValue[] r0, XmlObjectBase r1, Integer r2) {
        r0[r2.intValue()] = r1;
    }

    static /* synthetic */ void lambda$arraySetterHelper$10(float[] r0, XmlObjectBase r1, Integer r2) {
        r1.setFloatValue(r0[r2.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$11(double[] r2, XmlObjectBase r3, Integer r4) {
        r3.setDoubleValue(r2[r4.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$12(byte[] r0, XmlObjectBase r1, Integer r2) {
        r1.setByteValue(r0[r2.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$13(short[] r0, XmlObjectBase r1, Integer r2) {
        r1.setShortValue(r0[r2.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$14(int[] r0, XmlObjectBase r1, Integer r2) {
        r1.setIntValue(r0[r2.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$15(long[] r2, XmlObjectBase r3, Integer r4) {
        r3.setLongValue(r2[r4.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$2(boolean[] r0, XmlObjectBase r1, Integer r2) {
        r1.setBooleanValue(r0[r2.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$3(float[] r0, XmlObjectBase r1, Integer r2) {
        r1.setFloatValue(r0[r2.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$4(double[] r2, XmlObjectBase r3, Integer r4) {
        r3.setDoubleValue(r2[r4.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$5(byte[] r0, XmlObjectBase r1, Integer r2) {
        r1.setByteValue(r0[r2.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$6(short[] r0, XmlObjectBase r1, Integer r2) {
        r1.setShortValue(r0[r2.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$7(int[] r0, XmlObjectBase r1, Integer r2) {
        r1.setIntValue(r0[r2.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$8(long[] r2, XmlObjectBase r3, Integer r4) {
        r3.setLongValue(r2[r4.intValue()]);
    }

    static /* synthetic */ void lambda$arraySetterHelper$9(boolean[] r0, XmlObjectBase r1, Integer r2) {
        r1.setBooleanValue(r0[r2.intValue()]);
    }

    public void arraySetterHelper(final byte[] r3, QName r4) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, null, r0, new $$Lambda$XmlComplexContentImpl$ajDOWVIF5AwVyVmc8IGIZvEK35s(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final byte[] r3, QName r4, QNameSet r5) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, r5, r0, new $$Lambda$XmlComplexContentImpl$xKMn4kjOU3VwxxktPu3OQRnMvY(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final double[] r3, QName r4) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, null, r0, new $$Lambda$XmlComplexContentImpl$WDc69Eme_6jNLoSMOgldRRyLwc(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final double[] r3, QName r4, QNameSet r5) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, r5, r0, new $$Lambda$XmlComplexContentImpl$Uw2pEbSXPvq0GCtsPVzL3jg0H4(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final float[] r3, QName r4) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, null, r0, new $$Lambda$XmlComplexContentImpl$09TnMmXrhvrvMYTJhYHYBlXIHi4(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final float[] r3, QName r4, QNameSet r5) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, r5, r0, new $$Lambda$XmlComplexContentImpl$1EoUOucXnIGnI76DCNHmg8sA3M(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final int[] r3, QName r4) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, null, r0, new $$Lambda$XmlComplexContentImpl$L2Gz7bqfojq5WOPliWNsGYhjmnY(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final int[] r3, QName r4, QNameSet r5) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, r5, r0, new $$Lambda$XmlComplexContentImpl$SdwYFlQRUGuz0WqTDhfG6ofgbg(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final long[] r3, QName r4) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, null, r0, new $$Lambda$XmlComplexContentImpl$fQtzppM6UsV8xhY75o7n0fAIEvc(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final long[] r3, QName r4, QNameSet r5) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, r5, r0, new $$Lambda$XmlComplexContentImpl$72VqumuRyXVKKyX76lqgasnEKcc(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(String[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$msamclPIidmw3aArtuAXXQfxZnE.INSTANCE);
    }

    public void arraySetterHelper(String[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$msamclPIidmw3aArtuAXXQfxZnE.INSTANCE);
    }

    public void arraySetterHelper(BigDecimal[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$1YCfsPI69jv1pkfajbduHn6qY0M.INSTANCE);
    }

    public void arraySetterHelper(BigDecimal[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$1YCfsPI69jv1pkfajbduHn6qY0M.INSTANCE);
    }

    public void arraySetterHelper(BigInteger[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$kfWOOSkmLq7tc2jqVher6PDkFoM.INSTANCE);
    }

    public void arraySetterHelper(BigInteger[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$kfWOOSkmLq7tc2jqVher6PDkFoM.INSTANCE);
    }

    public void arraySetterHelper(Calendar[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$3ATnOO4gWcv2SjNIYV0pOaptx8.INSTANCE);
    }

    public void arraySetterHelper(Calendar[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$3ATnOO4gWcv2SjNIYV0pOaptx8.INSTANCE);
    }

    public void arraySetterHelper(Date[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$INPtykGhsrhxZnZHWK8msqz5Z0.INSTANCE);
    }

    public void arraySetterHelper(Date[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$INPtykGhsrhxZnZHWK8msqz5Z0.INSTANCE);
    }

    public void arraySetterHelper(List<?>[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$R8v87yQI_M3aJTlTP97DpfO7sAs.INSTANCE);
    }

    public void arraySetterHelper(List<?>[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$R8v87yQI_M3aJTlTP97DpfO7sAs.INSTANCE);
    }

    public void arraySetterHelper(QName[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$kOp69BSPyq_owHJ4glC7hzZPiWY.INSTANCE);
    }

    public void arraySetterHelper(QName[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$kOp69BSPyq_owHJ4glC7hzZPiWY.INSTANCE);
    }

    public void arraySetterHelper(GDate[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$brdmH9Oo_8iKR13Vv4VnXh3mcOA.INSTANCE);
    }

    public void arraySetterHelper(GDate[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$brdmH9Oo_8iKR13Vv4VnXh3mcOA.INSTANCE);
    }

    public void arraySetterHelper(GDuration[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$kMUH74KQcswESRvHd0RfN5uZMQ.INSTANCE);
    }

    public void arraySetterHelper(GDuration[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$kMUH74KQcswESRvHd0RfN5uZMQ.INSTANCE);
    }

    public void arraySetterHelper(StringEnumAbstractBase[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$onRKkzO3sG852oV8TQJWYD_uD4.INSTANCE);
    }

    public void arraySetterHelper(StringEnumAbstractBase[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$onRKkzO3sG852oV8TQJWYD_uD4.INSTANCE);
    }

    public void arraySetterHelper(XmlObject[] r2, QName r3) {
        arraySetterHelper(r2, r3, null);
    }

    public void arraySetterHelper(XmlObject[] r9, QName r10, QNameSet r11) {
        TypeStore r0 = get_store();
        int r1 = 0;
        if (r9 != null) goto L5;
    L94:
        if (r11 != null) goto L96;
        int r8 = r0.count_elements(r10);
    L97:
        if (r8 <= 0) goto L102;
        if (r11 != null) goto L100;
        r0.remove_element(r10, 0);
    L101:
        r8 = r8 - 1;
        goto L97
    L100:
        r0.remove_element(r11, 0);
        goto L101
    L102:
        return;
    L96:
        r8 = r0.count_elements(r11);
        goto L97
    L5:
        if (r9.length == 0) goto L94;
        if (r11 != null) goto L9;
        int r2 = r0.count_elements(r10);
    L10:
        int r3 = 0;
    L12:
        if (r3 >= r9.length) goto L36;
        if (r9[r3].isImmutable() == true) goto L25;
        XmlCursor r4 = r9[r3].newCursor();
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        if (r4 != null) goto L107;
    L34:
        throw th;
    L107:
        r4.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);
        goto L34
    L18:
        if (r4.toParent() == false) goto L23;
        if (r4.getObject() != this) goto L23;
        if (r4 == null) goto L36;
        r4.close();
    L23:
        if (r4 == null) goto L25;
        r4.close();
    L25:
        r3 = r3 + 1;
    L36:
        if (r3 >= r9.length) goto L74;
        if (r11 != null) goto L39;
        TypeStoreUser r5 = r0.find_element_user(r10, 0);
    L41:
        if (r5 != r9[r3]) goto L74;
    L42:
        if (r1 >= r3) goto L47;
        if (r11 != null) goto L45;
        TypeStoreUser r6 = r0.insert_element_user(r10, r1);
    L46:
        ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).set(r9[r1]);
        r1 = r1 + 1;
        goto L42
    L45:
        r6 = r0.insert_element_user(r11, r10, r1);
        goto L46
    L47:
        int r7 = r1 + 1;
        r1 = r3 + 1;
    L49:
        if (r1 >= r9.length) goto L73;
        if (r9[r1].isImmutable() == false) goto L53;
        XmlCursor r12 = null;
    L54:
        if (r12 != null) goto L56;
    L66:
        if (r12 == null) goto L68;
        r12.close();
    L68:
        if (r11 != null) goto L70;
        TypeStoreUser r13 = r0.insert_element_user(r10, r7);
    L71:
        ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r13, XmlObjectBase.class, "com.obric.memorydata.plugin")).set(r9[r1]);
    L72:
        r1 = r1 + 1;
        r7 = r7 + 1;
        goto L49
    L70:
        r13 = r0.insert_element_user(r11, r10, r7);
        goto L71
    L56:
        if (r12.toParent() == false) goto L66;
        if (r12.getObject() != this) goto L66;
        r12.close();
        if (r11 != null) goto L62;
        TypeStoreUser r14 = r0.find_element_user(r10, r7);
    L64:
        if (r14 == r9[r1]) goto L72;
    L62:
        r14 = r0.find_element_user(r11, r7);
        goto L64
    L53:
        r12 = r9[r1].newCursor();
    L73:
        int r15 = r0.count_elements(r10);
        r3 = r1;
    L75:
        int r16 = r3;
    L77:
        if (r16 >= r9.length) goto L80;
        ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r0.add_element_user(r10), XmlObjectBase.class, "com.obric.memorydata.plugin")).set(r9[r16]);
        r16 = r16 + 1;
    L80:
        if (r15 <= ((r3 - r1) + r7)) goto L86;
        int r17 = r15 - 1;
        if (r11 != null) goto L84;
        r0.remove_element(r10, r17);
    L85:
        r15 = r15 - 1;
        goto L80
    L84:
        r0.remove_element(r11, r17);
    L86:
        if (r1 >= r3) goto L93;
        if (r7 < r15) goto L89;
        TypeStoreUser r18 = r0.add_element_user(r10);
    L92:
        ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r18, XmlObjectBase.class, "com.obric.memorydata.plugin")).set(r9[r1]);
        r1 = r1 + 1;
        r7 = r7 + 1;
        goto L86
    L89:
        if (r11 != null) goto L91;
        r18 = r0.find_element_user(r10, r7);
        goto L92
    L91:
        r18 = r0.find_element_user(r11, r7);
        goto L92
    L93:
        return;
    L39:
        r5 = r0.find_element_user(r11, 0);
    L74:
        r15 = r2;
        r7 = 0;
        goto L75
    L9:
        r2 = r0.count_elements(r11);
        goto L10
    }

    public void arraySetterHelper(final short[] r3, QName r4) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, null, r0, new $$Lambda$XmlComplexContentImpl$SBcP7pH7BDAb0UOUi6kRKOkLII(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final short[] r3, QName r4, QNameSet r5) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, r5, r0, new $$Lambda$XmlComplexContentImpl$t2Vedh1P1nX2Jkh6W3kYwGys(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final boolean[] r3, QName r4) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, null, r0, new $$Lambda$XmlComplexContentImpl$22xVDRWvW19Vjat83hH1q2vIB8(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(final boolean[] r3, QName r4, QNameSet r5) {
        if (r3 != null) goto L4;
        int r0 = 0;
    L5:
        commonSetterHelper(r4, r5, r0, new $$Lambda$XmlComplexContentImpl$u31YcVrP0rLx9fsEGOsEtnrhTso(r3));
        return;
    L4:
        r0 = r3.length;
        goto L5
    }

    public void arraySetterHelper(byte[][] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$WPTGynAKDNXBojHkb98Ln0jopE.INSTANCE);
    }

    public void arraySetterHelper(byte[][] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$WPTGynAKDNXBojHkb98Ln0jopE.INSTANCE);
    }

    public SimpleValue[] arraySetterHelper(int r3, QName r4) {
        final SimpleValue[] r5 = new SimpleValue[r3];
        commonSetterHelper(r4, null, r5, new $$Lambda$XmlComplexContentImpl$fBJtvy9EZ07Sh6FA6STsf0ZjWOA(r5));
        return r5;
    }

    public SimpleValue[] arraySetterHelper(int r2, QName r3, QNameSet r4) {
        final SimpleValue[] r5 = new SimpleValue[r2];
        commonSetterHelper(r3, r4, r5, new $$Lambda$XmlComplexContentImpl$PcKstq5X69ASxs4v7yyonK1i0Q(r5));
        return r5;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r2) {
        NamespaceManager r1 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r2, NamespaceManager.class, "com.obric.memorydata.plugin");
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        if (this._schemaType.equals(r4.schemaType()) == true) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_attribute_text(QName r1) {
        return super.get_default_attribute_text(r1);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_element_text(QName r1) {
        SchemaProperty r0 = schemaType().getElementProperty(r1);
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_elementflags(QName r4) {
        SchemaProperty r3 = schemaType().getElementProperty(r4);
        int r5 = 0;
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (r3.hasDefault() != 1) goto L8;
        return -1;
    L8:
        if (r3.hasFixed() != 1) goto L10;
        return -1;
    L10:
        if (r3.hasNillable() != 1) goto L13;
        return -1;
    L13:
        if (r3.hasDefault() != 0) goto L15;
        int r0 = 0;
    L17:
        if (r3.hasFixed() != 0) goto L19;
        int r2 = 0;
    L20:
        int r1 = r0 | r2;
        if (r3.hasNillable() == 0) goto L25;
        r5 = 1;
    L25:
        return r1 | r5;
    L19:
        r2 = 4;
        goto L20
    L15:
        r0 = 2;
        goto L17
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean is_child_element_order_sensitive() {
        return schemaType().isOrderSensitive();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreVisitor new_visitor() {
        return new SchemaTypeVisitorImpl(this._schemaType.getContentModel());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public final void set_String(String r3) {
        if (this._schemaType.getContentType() != 4) goto L5;
    L9:
        super.set_String(r3);
        return;
    L5:
        if (this._schemaType.isNoType() == true) goto L9;
        throw new IllegalArgumentException("Type does not allow for textual content: " + this._schemaType);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r1) {
    }

    public void unionArraySetterHelper(Object[] r3, QName r4) {
        commonSetterHelper2(r4, null, r3, $$Lambda$WIVeyxsC31FcMjXnm1YlzvROqQ.INSTANCE);
    }

    public void unionArraySetterHelper(Object[] r2, QName r3, QNameSet r4) {
        commonSetterHelper2(r3, r4, r2, $$Lambda$WIVeyxsC31FcMjXnm1YlzvROqQ.INSTANCE);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void update_from_complex_content() {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        throw new IllegalStateException("Complex types cannot be used as hash keys");
    }
}
