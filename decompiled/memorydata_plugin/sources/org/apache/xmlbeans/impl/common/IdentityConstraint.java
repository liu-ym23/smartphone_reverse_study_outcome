package org.apache.xmlbeans.impl.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.stream.a;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlIDREF;
import org.apache.xmlbeans.XmlIDREFS;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.apache.xmlbeans.impl.xpath.XPathExecutionContext;

/* JADX INFO: loaded from: classes7.dex */
public class IdentityConstraint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ConstraintState _constraintStack;
    private ElementState _elementStack;
    private final Collection<XmlError> _errorListener;
    private boolean _invalid;
    private final boolean _trackIdrefs;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.common.IdentityConstraint$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public abstract class ConstraintState {
        ConstraintState _next;
        final /* synthetic */ IdentityConstraint this$0;

        ConstraintState(IdentityConstraint r2) {
            this.this$0 = r2;
            IdentityConstraint.access$200(r2, IdentityConstraint.access$100(r2));
            this._next = IdentityConstraint.access$100(r2);
            IdentityConstraint.access$102(r2, this);
        }

        abstract void attr(ValidatorListener.Event r1, QName r2, SchemaType r3, String r4);

        abstract void element(ValidatorListener.Event r1, SchemaType r2);

        abstract void endElement(ValidatorListener.Event r1);

        abstract void remove(ValidatorListener.Event r1);

        abstract void text(ValidatorListener.Event r1, SchemaType r2, String r3, boolean r4);
    }

    private static class ElementState {
        boolean _hasConstraints;
        ElementState _next;
        ConstraintState _savePoint;

        private ElementState() {
        }

        /* synthetic */ ElementState(AnonymousClass1 r1) {
            this();
        }
    }

    public class FieldState extends ConstraintState {
        XPathExecutionContext[] _contexts;
        boolean[] _needsValue;
        SelectorState _selector;
        XmlObjectList _value;
        final /* synthetic */ IdentityConstraint this$0;

        FieldState(IdentityConstraint r7, SelectorState r8, ValidatorListener.Event r9, SchemaType r10) {
            ValidatorListener.Event r11 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r9, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r12 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r10, SchemaType.class, "com.obric.memorydata.plugin");
            this.this$0 = r7;
            super(r7);
            this._selector = r8;
            SchemaIdentityConstraint r13 = r8._constraint;
            int r0 = r13.getFields().length;
            this._contexts = new XPathExecutionContext[r0];
            this._needsValue = new boolean[r0];
            this._value = new XmlObjectList(r0);
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            this._contexts[r2] = new XPathExecutionContext();
            this._contexts[r2].init((XPath) ZeusTransformUtils.preCheckCast(r13.getFieldPath(r2), XPath.class, "com.obric.memorydata.plugin"));
            if ((this._contexts[r2].start() & 1) == 0) goto L10;
            if (IdentityConstraint.hasSimpleContent(r12) == true) goto L9;
            IdentityConstraint.access$500(r7, r11, "Identity constraint field must have simple content");
            goto L10
        L9:
            this._needsValue[r2] = true;
        L10:
            r2 = r2 + 1;
            goto L3
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void attr(ValidatorListener.Event r5, QName r6, SchemaType r7, String r8) {
            ValidatorListener.Event r9 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r5, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r10 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r7, SchemaType.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L5;
            return;
        L5:
            int r0 = 0;
        L6:
            XPathExecutionContext[] r1 = this._contexts;
            if (r0 >= r1.length) goto L17;
            if (r1[r0].attr(r6) == false) goto L16;
            XmlObject r2 = IdentityConstraint.access$600(r10, r8);
            if (r2 == null) goto L12;
            if (this._value.set(r2, r0) == true) goto L16;
            IdentityConstraint.access$500(this.this$0, r9, "Multiple instances of field with xpath: '" + this._selector._constraint.getFields()[r0] + "' for a selector");
            goto L16
        L12:
            return;
        L16:
            r0 = r0 + 1;
            goto L6
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void element(ValidatorListener.Event r5, SchemaType r6) {
            ValidatorListener.Event r7 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r5, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r6, SchemaType.class, "com.obric.memorydata.plugin");
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r1 >= this._contexts.length) goto L9;
            if (this._needsValue[r1] == false) goto L8;
            IdentityConstraint.access$500(this.this$0, r7, "Identity constraint field must have simple content");
            this._needsValue[r1] = false;
        L8:
            r1 = r1 + 1;
        L9:
            XPathExecutionContext[] r2 = this._contexts;
            if (r0 >= r2.length) goto L18;
            if ((r2[r0].element(r7.getName()) & 1) == 0) goto L17;
            if (IdentityConstraint.hasSimpleContent(r8) == true) goto L16;
            IdentityConstraint.access$500(this.this$0, r7, "Identity constraint field must have simple content");
            goto L17
        L16:
            this._needsValue[r0] = true;
        L17:
            r0 = r0 + 1;
            goto L9
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void endElement(ValidatorListener.Event r3) {
            ValidatorListener.Event r4 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            int r0 = 0;
        L4:
            if (r0 >= this._needsValue.length) goto L6;
            this._contexts[r0].end();
            this._needsValue[r0] = false;
            r0 = r0 + 1;
            goto L4
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event r4) {
            ValidatorListener.Event r5 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r4, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            if (this._selector._constraint.getConstraintCategory() == 1) goto L5;
        L7:
            this._selector.addFields(this._value, r5);
            return;
        L5:
            if (this._value.unfilled() < 0) goto L7;
            IdentityConstraint.access$500(this.this$0, r5, "Key " + QNameHelper.pretty(this._selector._constraint.getName()) + " is missing field with xpath: '" + this._selector._constraint.getFields()[this._value.unfilled()] + "'");
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void text(ValidatorListener.Event r5, SchemaType r6, String r7, boolean r8) {
            ValidatorListener.Event r9 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r5, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r10 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r6, SchemaType.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L6;
            if (r8 == true) goto L6;
            return;
        L6:
            int r0 = 0;
        L8:
            if (r0 >= this._contexts.length) goto L24;
            if (this._needsValue[r0] == false) goto L23;
            if (r8 == true) goto L21;
            if (IdentityConstraint.hasSimpleContent(r10) == false) goto L21;
            XmlObject r1 = IdentityConstraint.access$600(IdentityConstraint.getSimpleType(r10), r7);
            if (r1 == null) goto L17;
            if (this._value.set(r1, r0) == true) goto L23;
            IdentityConstraint.access$500(this.this$0, r9, "Multiple instances of field with xpath: '" + this._selector._constraint.getFields()[r0] + "' for a selector");
            goto L23
        L17:
            return;
        L21:
            IdentityConstraint.access$500(this.this$0, r9, "Identity constraint field must have simple content");
            return;
        L23:
            r0 = r0 + 1;
            goto L8
        }
    }

    public class IdRefState extends ConstraintState {
        IdState _ids;
        List<XmlObjectList> _values;
        final /* synthetic */ IdentityConstraint this$0;

        IdRefState(IdentityConstraint r1, IdState r2) {
            this.this$0 = r1;
            super(r1);
            this._ids = r2;
            this._values = new ArrayList();
        }

        private void handleValue(ValidatorListener.Event r4, SchemaType r5, String r6) {
            ValidatorListener.Event r7 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r4, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L5;
            return;
        L5:
            if (r8 != null) goto L7;
            return;
        L7:
            if (r8.isNoType() == false) goto L10;
            return;
        L10:
            if (XmlIDREFS.type.isAssignableFrom(r8) == false) goto L19;
            XmlIDREFS r9 = (XmlIDREFS) ZeusTransformUtils.preCheckCast(IdentityConstraint.access$600(XmlIDREFS.type, r6), XmlIDREFS.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L14;
            return;
        L14:
            Iterator<? extends XmlAnySimpleType> r10 = r9.xgetListValue().iterator();
        L16:
            if (r10.hasNext() == false) goto L29;
            XmlAnySimpleType r11 = (XmlAnySimpleType) ZeusTransformUtils.preCheckCast(r10.next(), XmlAnySimpleType.class, "com.obric.memorydata.plugin");
            XmlObjectList r12 = new XmlObjectList(1);
            r12.set(r11, 0);
            this._values.add(r12);
            goto L16
        L29:
            return;
        L19:
            if (XmlIDREF.type.isAssignableFrom(r8) == false) goto L27;
            XmlObjectList r13 = new XmlObjectList(1);
            XmlIDREF r14 = (XmlIDREF) ZeusTransformUtils.preCheckCast(r8.newValue(r6), XmlIDREF.class, "com.obric.memorydata.plugin");
            if (r14 != null) goto L23;
            return;
        L23:
            r13.set(r14, 0);
            this._values.add(r13);
            return;
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void attr(ValidatorListener.Event r2, QName r3, SchemaType r4, String r5) {
            handleValue((ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r2, ValidatorListener.Event.class, "com.obric.memorydata.plugin"), (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin"), r5);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void element(ValidatorListener.Event r2, SchemaType r3) {
            ValidatorListener.Event r1 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r2, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r4 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void endElement(ValidatorListener.Event r2) {
            ValidatorListener.Event r1 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r2, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event r7) {
            ValidatorListener.Event r8 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r7, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            Iterator<XmlObjectList> r0 = this._values.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            XmlObjectList r2 = (XmlObjectList) ZeusTransformUtils.preCheckCast(r0.next(), XmlObjectList.class, "com.obric.memorydata.plugin");
            if (this._ids._values.contains(r2) == true) goto L4;
            IdentityConstraint.access$500(this.this$0, r8, "ID not found for IDRef value '" + r2 + "'");
            goto L4
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void text(ValidatorListener.Event r3, SchemaType r4, String r5, boolean r6) {
            ValidatorListener.Event r7 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
            if (r6 == false) goto L5;
            return;
        L5:
            handleValue(r7, r8, r5);
        }
    }

    public class IdState extends ConstraintState {
        Set<XmlObjectList> _values;
        final /* synthetic */ IdentityConstraint this$0;

        IdState(IdentityConstraint r1) {
            this.this$0 = r1;
            super(r1);
            this._values = new LinkedHashSet();
        }

        private void handleValue(ValidatorListener.Event r4, SchemaType r5, String r6) {
            ValidatorListener.Event r7 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r4, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L5;
            return;
        L5:
            if (r8 != null) goto L7;
            return;
        L7:
            if (r8.isNoType() == false) goto L10;
            return;
        L10:
            if (XmlID.type.isAssignableFrom(r8) == false) goto L20;
            XmlObjectList r9 = new XmlObjectList(1);
            XmlObject r1 = IdentityConstraint.access$600(XmlID.type, r6);
            if (r1 != null) goto L14;
            return;
        L14:
            r9.set(r1, 0);
            if (this._values.contains(r9) == false) goto L17;
            IdentityConstraint.access$300(this.this$0, r7, "cvc-id.2", new Object[]{r6});
            return;
        L17:
            this._values.add(r9);
            return;
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void attr(ValidatorListener.Event r2, QName r3, SchemaType r4, String r5) {
            handleValue((ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r2, ValidatorListener.Event.class, "com.obric.memorydata.plugin"), (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin"), r5);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void element(ValidatorListener.Event r2, SchemaType r3) {
            ValidatorListener.Event r1 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r2, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r4 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void endElement(ValidatorListener.Event r2) {
            ValidatorListener.Event r1 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r2, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event r2) {
            ValidatorListener.Event r1 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r2, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void text(ValidatorListener.Event r3, SchemaType r4, String r5, boolean r6) {
            ValidatorListener.Event r7 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
            if (r6 == false) goto L5;
            return;
        L5:
            handleValue(r7, r8, r5);
        }
    }

    public class KeyrefState extends SelectorState {
        private final Object CHILD_ADDED;
        private final Object CHILD_REMOVED;
        private final Object SELF_ADDED;
        Map<XmlObjectList, Object> _keyValues;
        final /* synthetic */ IdentityConstraint this$0;

        KeyrefState(IdentityConstraint r3, SchemaIdentityConstraint r4, ValidatorListener.Event r5, SchemaType r6) {
            SchemaIdentityConstraint r7 = (SchemaIdentityConstraint) ZeusTransformUtils.wrapperContextForParams(r4, SchemaIdentityConstraint.class, "com.obric.memorydata.plugin");
            ValidatorListener.Event r8 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r5, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r9 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r6, SchemaType.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r3, r7, r8, r9);
            this._keyValues = new HashMap();
            this.CHILD_ADDED = new Object();
            this.CHILD_REMOVED = new Object();
            this.SELF_ADDED = new Object();
        }

        private boolean hasKeyValue(XmlObjectList r2) {
            Object r3 = this._keyValues.get(r2);
            if (r3 != null) goto L5;
        L7:
            return false;
        L5:
            if (r3 == this.CHILD_REMOVED) goto L7;
            return true;
        }

        void addKeyValues(Set<XmlObjectList> r5, boolean r6) {
            Iterator r7 = ((Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r7.hasNext() == false) goto L21;
            XmlObjectList r0 = (XmlObjectList) ZeusTransformUtils.preCheckCast(r7.next(), XmlObjectList.class, "com.obric.memorydata.plugin");
            Object r2 = this._keyValues.get(r0);
            if (r2 == null) goto L7;
            if (r2 == this.CHILD_ADDED) goto L12;
            if (r2 != this.CHILD_REMOVED) goto L4;
            if (r6 == true) goto L4;
        L14:
            Map<XmlObjectList, Object> r3 = this._keyValues;
        L15:
            Object r4 = this.SELF_ADDED;
        L16:
            r3.put(r0, r4);
            goto L4
        L12:
            if (r6 == false) goto L14;
            r3 = this._keyValues;
            r4 = this.CHILD_REMOVED;
            goto L16
        L7:
            r3 = this._keyValues;
            if (r6 == false) goto L15;
            r4 = this.CHILD_ADDED;
            goto L16
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.SelectorState, org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event r7) {
            ValidatorListener.Event r8 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r7, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            ConstraintState r0 = this._next;
        L4:
            if (r0 == null) goto L13;
            if (r0 == IdentityConstraint.access$400(this.this$0)._savePoint) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, SelectorState.class) == false) goto L12;
            SelectorState r3 = (SelectorState) ZeusTransformUtils.preCheckCast(r0, SelectorState.class, "com.obric.memorydata.plugin");
            if (r3._constraint != this._constraint.getReferencedKey()) goto L12;
            addKeyValues(r3._values, false);
        L12:
            r0 = r0._next;
        L13:
            Iterator<XmlObjectList> r1 = this._values.iterator();
        L15:
            if (r1.hasNext() == false) goto L33;
            XmlObjectList r4 = (XmlObjectList) ZeusTransformUtils.preCheckCast(r1.next(), XmlObjectList.class, "com.obric.memorydata.plugin");
            if (r4.unfilled() >= 0) goto L15;
            if (hasKeyValue(r4) == true) goto L15;
            IdentityConstraint.access$300(this.this$0, r8, "cvc-identity-constraint.4.3", new Object[]{r4, QNameHelper.pretty(this._constraint.getName())});
            return;
        }
    }

    public class SelectorState extends ConstraintState {
        SchemaIdentityConstraint _constraint;
        XPathExecutionContext _context;
        Set<XmlObjectList> _values;
        final /* synthetic */ IdentityConstraint this$0;

        SelectorState(IdentityConstraint r3, SchemaIdentityConstraint r4, ValidatorListener.Event r5, SchemaType r6) {
            SchemaIdentityConstraint r7 = (SchemaIdentityConstraint) ZeusTransformUtils.wrapperContextForParams(r4, SchemaIdentityConstraint.class, "com.obric.memorydata.plugin");
            ValidatorListener.Event r8 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r5, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r9 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r6, SchemaType.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r3);
            this._values = new LinkedHashSet();
            this._constraint = r7;
            XPathExecutionContext r10 = new XPathExecutionContext();
            this._context = r10;
            r10.init((XPath) ZeusTransformUtils.preCheckCast(this._constraint.getSelectorPath(), XPath.class, "com.obric.memorydata.plugin"));
            if ((this._context.start() & 1) == 0) goto L6;
            createFieldState(r8, r9);
            return;
        }

        void addFields(XmlObjectList r6, ValidatorListener.Event r7) {
            ValidatorListener.Event r8 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r7, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            if (this._constraint.getConstraintCategory() != 2) goto L6;
        L4:
            this._values.add(r6);
            return;
        L6:
            if (this._values.contains(r6) == false) goto L4;
            if (this._constraint.getConstraintCategory() != 3) goto L10;
            IdentityConstraint.access$300(this.this$0, r8, "cvc-identity-constraint.4.1", new Object[]{r6, QNameHelper.pretty(this._constraint.getName())});
            return;
        L10:
            IdentityConstraint.access$300(this.this$0, r8, "cvc-identity-constraint.4.2.2", new Object[]{r6, QNameHelper.pretty(this._constraint.getName())});
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void attr(ValidatorListener.Event r1, QName r2, SchemaType r3, String r4) {
            ValidatorListener.Event r0 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r1, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        }

        void createFieldState(ValidatorListener.Event r3, SchemaType r4) {
            ValidatorListener.Event r5 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
            new FieldState(this.this$0, this, r5, r6);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void element(ValidatorListener.Event r3, SchemaType r4) {
            ValidatorListener.Event r5 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
            if ((this._context.element(r5.getName()) & 1) == 0) goto L6;
            createFieldState(r5, r6);
            return;
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void endElement(ValidatorListener.Event r3) {
            ValidatorListener.Event r4 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            this._context.end();
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event r5) {
            ValidatorListener.Event r6 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r5, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            ConstraintState r7 = this._next;
        L3:
            if (r7 == null) goto L10;
            if (ZeusTransformUtils.instanceOf(r7, KeyrefState.class) == false) goto L9;
            KeyrefState r0 = (KeyrefState) ZeusTransformUtils.preCheckCast(r7, KeyrefState.class, "com.obric.memorydata.plugin");
            if (r0._constraint.getReferencedKey() != this._constraint) goto L9;
            r0.addKeyValues(this._values, true);
        L9:
            r7 = r7._next;
            goto L3
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void text(ValidatorListener.Event r1, SchemaType r2, String r3, boolean r4) {
            ValidatorListener.Event r0 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r1, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
            SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r2, SchemaType.class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public IdentityConstraint(Collection<XmlError> r3, boolean r4) {
        this._errorListener = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this._trackIdrefs = r4;
    }

    static /* synthetic */ ConstraintState access$100(IdentityConstraint r0) {
        return r0._constraintStack;
    }

    static /* synthetic */ ConstraintState access$102(IdentityConstraint r0, ConstraintState r1) {
        r0._constraintStack = r1;
        return r1;
    }

    static /* synthetic */ void access$200(IdentityConstraint r0, ConstraintState r1) {
        r0.setSavePoint(r1);
    }

    static /* synthetic */ void access$300(IdentityConstraint r2, ValidatorListener.Event r3, String r4, Object[] r5) {
        r2.emitError((ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    static /* synthetic */ ElementState access$400(IdentityConstraint r0) {
        return r0._elementStack;
    }

    static /* synthetic */ void access$500(IdentityConstraint r2, ValidatorListener.Event r3, String r4) {
        r2.emitError((ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ XmlObject access$600(SchemaType r2, String r3) {
        return newValue((SchemaType) ZeusTransformUtils.wrapperContextForParams(r2, SchemaType.class, "com.obric.memorydata.plugin"), r3);
    }

    private void buildIdStates() {
        IdState r0 = new IdState(this);
        if (this._trackIdrefs == false) goto L6;
        new IdRefState(this, r0);
        return;
    }

    private void emitError(ValidatorListener.Event r3, String r4) {
        ValidatorListener.Event r5 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        this._invalid = true;
        Collection<XmlError> r2 = this._errorListener;
        if (r2 == null) goto L6;
        r2.add(errorForEvent(r4, 0, r5));
        return;
    }

    private void emitError(ValidatorListener.Event r3, String r4, Object[] r5) {
        ValidatorListener.Event r6 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        this._invalid = true;
        Collection<XmlError> r2 = this._errorListener;
        if (r2 == null) goto L6;
        r2.add(errorForEvent(r4, r5, 0, r6));
        return;
    }

    public static XmlError errorForEvent(String r6, int r7, ValidatorListener.Event r8) {
        ValidatorListener.Event r9 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r8, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        XmlCursor r0 = r9.getLocationAsCursor();
        if (r0 != null) goto L10;
        a r10 = r9.getLocation();
        if (r10 == null) goto L9;
        return XmlError.forLocation(r6, r7, r10.getSystemId(), r10.getLineNumber(), r10.getColumnNumber(), r10.getCharacterOffset());
    L9:
        return XmlError.forMessage(r6, r7);
    L10:
        return XmlError.forCursor(r6, r7, r0);
    }

    public static XmlError errorForEvent(String r7, Object[] r8, int r9, ValidatorListener.Event r10) {
        ValidatorListener.Event r11 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r10, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        XmlCursor r0 = r11.getLocationAsCursor();
        if (r0 != null) goto L10;
        a r12 = r11.getLocation();
        if (r12 == null) goto L9;
        return XmlError.forLocation(r7, r8, r9, r12.getSystemId(), r12.getLineNumber(), r12.getColumnNumber(), r12.getCharacterOffset());
    L9:
        return XmlError.forMessage(r7, r8, r9);
    L10:
        return XmlError.forCursor(r7, r8, r9, r0);
    }

    static SchemaType getSimpleType(SchemaType r2) {
        SchemaType r3 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r2, SchemaType.class, "com.obric.memorydata.plugin");
    L4:
        if (r3.isSimpleType() == true) goto L6;
        r3 = r3.getBaseType();
        goto L4
    L6:
        return r3;
    }

    static boolean hasSimpleContent(SchemaType r2) {
        SchemaType r3 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r2, SchemaType.class, "com.obric.memorydata.plugin");
        if (r3.isSimpleType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r3.getContentType() == 2) goto L8;
        return false;
    }

    private void newConstraintState(SchemaIdentityConstraint r3, ValidatorListener.Event r4, SchemaType r5) {
        SchemaIdentityConstraint r6 = (SchemaIdentityConstraint) ZeusTransformUtils.wrapperContextForParams(r3, SchemaIdentityConstraint.class, "com.obric.memorydata.plugin");
        ValidatorListener.Event r7 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r4, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        if (r6.getConstraintCategory() != 2) goto L5;
        new KeyrefState(this, r6, r7, r8);
        return;
    L5:
        new SelectorState(this, r6, r7, r8);
    }

    private void newState() {
        if (this._elementStack != null) goto L5;
        boolean r0 = true;
    L6:
        ElementState r1 = new ElementState(null);
        r1._next = this._elementStack;
        this._elementStack = r1;
        if (r0 == false) goto L10;
        buildIdStates();
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static XmlObject newValue(SchemaType r2, String r3) {
        return ((SchemaType) ZeusTransformUtils.wrapperContextForParams(r2, SchemaType.class, "com.obric.memorydata.plugin")).newValue(r3);
    L5:
        return null;
    }

    private void setSavePoint(ConstraintState r2) {
        if (this._elementStack._hasConstraints == true) goto L5;
        this._elementStack._savePoint = r2;
    L5:
        this._elementStack._hasConstraints = true;
    }

    public void attr(ValidatorListener.Event r3, QName r4, SchemaType r5, String r6) {
        ValidatorListener.Event r7 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        ConstraintState r2 = this._constraintStack;
    L3:
        if (r2 == null) goto L5;
        r2.attr(r7, r4, r8, r6);
        r2 = r2._next;
        goto L3
    }

    public void element(ValidatorListener.Event r3, SchemaType r4, SchemaIdentityConstraint[] r5) {
        ValidatorListener.Event r6 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        newState();
        ConstraintState r0 = this._constraintStack;
    L3:
        if (r0 == null) goto L5;
        r0.element(r6, r7);
        r0 = r0._next;
        goto L3
    L5:
        int r1 = 0;
    L6:
        if (r5 == null) goto L10;
        if (r1 >= r5.length) goto L14;
        newConstraintState(r5[r1], r6, r7);
        r1 = r1 + 1;
        goto L6
    L14:
        return;
    }

    public void endElement(ValidatorListener.Event r3) {
        ValidatorListener.Event r4 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        if (this._elementStack._hasConstraints == false) goto L10;
        ConstraintState r0 = this._constraintStack;
    L5:
        if (r0 == null) goto L9;
        if (r0 == this._elementStack._savePoint) goto L9;
        r0.remove(r4);
        r0 = r0._next;
    L9:
        this._constraintStack = this._elementStack._savePoint;
    L10:
        this._elementStack = this._elementStack._next;
        ConstraintState r2 = this._constraintStack;
    L11:
        if (r2 == null) goto L13;
        r2.endElement(r4);
        r2 = r2._next;
        goto L11
    }

    public boolean isValid() {
        return !this._invalid;
    }

    public void text(ValidatorListener.Event r3, SchemaType r4, String r5, boolean r6) {
        ValidatorListener.Event r7 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        ConstraintState r2 = this._constraintStack;
    L3:
        if (r2 == null) goto L5;
        r2.text(r7, r8, r5, r6);
        r2 = r2._next;
        goto L3
    }
}
