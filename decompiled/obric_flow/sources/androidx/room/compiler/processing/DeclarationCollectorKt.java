package androidx.room.compiler.processing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\b*\u00020\u0002H\u0002¨\u0006\f"}, d2 = {"collectAllMethods", "Lkotlin/sequences/Sequence;", "Landroidx/room/compiler/processing/XMethodElement;", "xTypeElement", "Landroidx/room/compiler/processing/XTypeElement;", "collectFieldsIncludingPrivateSupers", "Landroidx/room/compiler/processing/XFieldElement;", "isAccessibleFrom", "", "packageName", "", "isStaticInterfaceMethod", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DeclarationCollectorKt {

    /* JADX INFO: renamed from: androidx.room.compiler.processing.DeclarationCollectorKt$collectAllMethods$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroidx/room/compiler/processing/XMethodElement;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.compiler.processing.DeclarationCollectorKt$collectAllMethods$1", f = "DeclarationCollector.kt", i = {0, 1}, l = {86, 104}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super XMethodElement>, Continuation<? super Unit>, Object> {
        final /* synthetic */ XTypeElement $xTypeElement;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass1(XTypeElement r5, Continuation<? super AnonymousClass1> r10) {
            this.$xTypeElement = r5;
            super(2, r10);
        }

        private static final void invokeSuspend$collectAllMethodsByName(XTypeElement r5, Set<XTypeElement> r10, Map<String, LinkedHashSet<XMethodElement>> r11, XTypeElement r12) {
            Iterator<T> r13 = r12.getSuperInterfaceElements().iterator();
        L4:
            if (r13.hasNext() == false) goto L8;
            XTypeElement r14 = (XTypeElement) r13.next();
            if (r10.add(r14) == false) goto L4;
            invokeSuspend$collectAllMethodsByName(r5, r10, r11, r14);
            goto L4
        L8:
            XType r15 = r12.getSuperClass();
            if (r15 == null) goto L14;
            XTypeElement r16 = r15.getTypeElement();
            if (r16 == null) goto L14;
            invokeSuspend$collectAllMethodsByName(r5, r10, r11, r16);
        L14:
            if (Intrinsics.areEqual(r12, r5) == false) goto L22;
            Iterator<T> r17 = r12.getDeclaredMethods().iterator();
        L17:
            if (r17.hasNext() == false) goto L41;
            XMethodElement r18 = (XMethodElement) r17.next();
            String r19 = r18.getName();
            LinkedHashSet<XMethodElement> r20 = r11.get(r19);
            if (r20 != null) goto L21;
            r20 = new LinkedHashSet();
            r11.put(r19, r20);
        L21:
            r20.add(r18);
            goto L17
        L41:
            return;
        L22:
            List<XMethodElement> r21 = r12.getDeclaredMethods();
            ArrayList r22 = new ArrayList();
            Iterator<T> r23 = r21.iterator();
        L24:
            if (r23.hasNext() == false) goto L28;
            Object r24 = r23.next();
            if (DeclarationCollectorKt.access$isAccessibleFrom((XMethodElement) r24, r5.getPackageName()) == false) goto L24;
            r22.add(r24);
            goto L24
        L28:
            ArrayList r25 = new ArrayList();
            Iterator r26 = r22.iterator();
        L30:
            if (r26.hasNext() == false) goto L34;
            Object r27 = r26.next();
            if (DeclarationCollectorKt.access$isStaticInterfaceMethod((XMethodElement) r27) == true) goto L30;
            r25.add(r27);
            goto L30
        L34:
            Iterator r28 = r25.iterator();
        L36:
            if (r28.hasNext() == false) goto L63;
            XMethodElement r29 = (XMethodElement) r28.next();
            String r30 = r29.getName();
            LinkedHashSet<XMethodElement> r31 = r11.get(r30);
            if (r31 != null) goto L40;
            r31 = new LinkedHashSet();
            r11.put(r30, r31);
        L40:
            r31.add(r29);
            goto L36
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass1 r11 = new AnonymousClass1(this.$xTypeElement, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(SequenceScope<? super XMethodElement> r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ea -> B:38:0x00f2). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L10;
            if (r10 == 1) goto L9;
            if (r10 != 2) goto L8;
            Iterator r11 = (Iterator) this.L$3;
            Iterator r12 = (Iterator) this.L$2;
            XTypeElement r14 = (XTypeElement) this.L$1;
            SequenceScope r15 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L39:
            if (r11.hasNext() == false) goto L43;
            XMethodElement r16 = (XMethodElement) r11.next();
            this.L$0 = r15;
            this.L$1 = r14;
            this.L$2 = r12;
            this.L$3 = r11;
            this.label = 2;
            if (r15.yield(r16, this) != r5) goto L39;
            return r5;
        L43:
            Iterator r17 = r12;
            XTypeElement r18 = r14;
            SequenceScope r19 = r15;
        L12:
            if (r17.hasNext() == false) goto L45;
            LinkedHashSet r110 = (LinkedHashSet) r17.next();
            if (r110.size() != 1) goto L18;
            Object r111 = CollectionsKt.single(r110);
            this.L$0 = r19;
            this.L$1 = r18;
            this.L$2 = r17;
            this.L$3 = null;
            this.label = 1;
            if (r19.yield(r111, this) != r5) goto L12;
            return r5;
        L18:
            List r112 = CollectionsKt.toList(r110);
            LinkedHashSet r20 = new LinkedHashSet();
            Iterator r21 = r112.iterator();
            int r22 = 0;
        L20:
            if (r21.hasNext() == false) goto L31;
            Object r23 = r21.next();
            int r113 = r22 + 1;
            if (r22 >= 0) goto L24;
            CollectionsKt.throwIndexOverflow();
        L24:
            XMethodElement r24 = (XMethodElement) r23;
            Iterator r25 = r112.subList(r113, r112.size()).iterator();
        L26:
            if (r25.hasNext() == false) goto L30;
            if (((XMethodElement) r25.next()).overrides(r24, r18) == false) goto L26;
            r20.add(r24);
        L30:
            r22 = r113;
            goto L20
        L31:
            ArrayList r26 = new ArrayList();
            Iterator r114 = r112.iterator();
        L33:
            if (r114.hasNext() == false) goto L37;
            Object r27 = r114.next();
            if (r20.contains((XMethodElement) r27) == true) goto L33;
            r26.add(r27);
            goto L33
        L37:
            r15 = r19;
            r14 = r18;
            r12 = r17;
            r11 = r26.iterator();
            goto L39
        L45:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r17 = (Iterator) this.L$2;
            r18 = (XTypeElement) this.L$1;
            r19 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            goto L12
        L10:
            ResultKt.throwOnFailure(r13);
            SequenceScope r115 = (SequenceScope) this.L$0;
            LinkedHashMap r28 = new LinkedHashMap();
            LinkedHashSet r29 = new LinkedHashSet();
            XTypeElement r30 = this.$xTypeElement;
            invokeSuspend$collectAllMethodsByName(r30, r29, r28, r30);
            Collection r31 = r28.values();
            r18 = this.$xTypeElement;
            r17 = r31.iterator();
            r19 = r115;
            goto L12
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super XMethodElement> r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.room.compiler.processing.DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroidx/room/compiler/processing/XFieldElement;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.compiler.processing.DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1", f = "DeclarationCollector.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00971 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super XFieldElement>, Continuation<? super Unit>, Object> {
        final /* synthetic */ XTypeElement $xTypeElement;
        private /* synthetic */ Object L$0;
        int label;

        public C00971(XTypeElement r5, Continuation<? super C00971> r10) {
            this.$xTypeElement = r5;
            super(2, r10);
        }

        public static final /* synthetic */ Object access$invokeSuspend$yieldAllFields(SequenceScope r5, Set r10, XTypeElement r11, Continuation r12) {
            return invokeSuspend$yieldAllFields(r5, r10, r11, r12);
        }

        private static final Object invokeSuspend$yieldAllFields(SequenceScope<? super XFieldElement> r10, Set<String> r11, XTypeElement r12, Continuation<? super Unit> r13) {
            if ((r13 instanceof DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1$yieldAllFields$1) == false) goto L7;
            DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1$yieldAllFields$1 r5 = (DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1$yieldAllFields$1) r13;
            int r14 = r5.label;
            if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
            r5.label = r14 - Integer.MIN_VALUE;
        L8:
            Object r15 = r5.result;
            Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r17 = r5.label;
            if (r17 == 0) goto L16;
            if (r17 == 1) goto L15;
            if (r17 != 2) goto L14;
            ResultKt.throwOnFailure(r15);
        L36:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            Iterator r18 = (Iterator) r5.L$3;
            XTypeElement r19 = (XTypeElement) r5.L$2;
            Set<String> r110 = (Set) r5.L$1;
            SequenceScope r20 = (SequenceScope) r5.L$0;
            ResultKt.throwOnFailure(r15);
            XTypeElement r111 = r19;
            SequenceScope r21 = r20;
        L24:
            if (r18.hasNext() == false) goto L28;
            XFieldElement r22 = (XFieldElement) r18.next();
            r5.L$0 = r21;
            r5.L$1 = r110;
            r5.L$2 = r111;
            r5.L$3 = r18;
            r5.label = 1;
            if (r21.yield(r22, r5) != r16) goto L24;
            return r16;
        L28:
            XType r23 = r111.getSuperClass();
            if (r23 == null) goto L36;
            XTypeElement r24 = r23.getTypeElement();
            if (r24 == null) goto L36;
            r5.L$0 = null;
            r5.L$1 = null;
            r5.L$2 = null;
            r5.L$3 = null;
            r5.label = 2;
            if (invokeSuspend$yieldAllFields(r21, r110, r24, r5) != r16) goto L36;
            return r16;
        L16:
            ResultKt.throwOnFailure(r15);
            List<XFieldElement> r112 = r12.getDeclaredFields();
            ArrayList r25 = new ArrayList();
            Iterator<T> r113 = r112.iterator();
        L18:
            if (r113.hasNext() == false) goto L22;
            Object r26 = r113.next();
            if (r11.add(((XFieldElement) r26).getName()) == false) goto L18;
            r25.add(r26);
            goto L18
        L22:
            r21 = r10;
            r18 = r25.iterator();
            r111 = r12;
            r110 = r11;
        L7:
            r5 = new DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1$yieldAllFields$1(r13);
            goto L8
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C00971 r11 = new C00971(this.$xTypeElement, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(SequenceScope<? super XFieldElement> r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            SequenceScope r12 = (SequenceScope) this.L$0;
            LinkedHashSet r13 = new LinkedHashSet();
            XTypeElement r14 = this.$xTypeElement;
            this.label = 1;
            if (invokeSuspend$yieldAllFields(r12, r13, r14, this) != r10) goto L12;
            return r10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super XFieldElement> r5, Continuation<? super Unit> r10) {
            return ((C00971) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static final /* synthetic */ boolean access$isAccessibleFrom(XMethodElement r5, String r10) {
        return isAccessibleFrom(r5, r10);
    }

    public static final /* synthetic */ boolean access$isStaticInterfaceMethod(XMethodElement r5) {
        return isStaticInterfaceMethod(r5);
    }

    public static final Sequence<XMethodElement> collectAllMethods(XTypeElement r5) {
        Intrinsics.checkNotNullParameter(r5, "xTypeElement");
        return SequencesKt.sequence(new AnonymousClass1(r5, null));
    }

    public static final Sequence<XFieldElement> collectFieldsIncludingPrivateSupers(XTypeElement r5) {
        Intrinsics.checkNotNullParameter(r5, "xTypeElement");
        return SequencesKt.sequence(new C00971(r5, null));
    }

    private static final boolean isAccessibleFrom(XMethodElement r5, String r10) {
        if (r5.isPublic() == false) goto L5;
        return true;
    L5:
        if (r5.isProtected() == false) goto L8;
        return true;
    L8:
        if (r5.isPrivate() == false) goto L12;
        return false;
    L12:
        return Intrinsics.areEqual(r10, r5.getClosestMemberContainer().getClassName().f14959w);
    }

    private static final boolean isStaticInterfaceMethod(XMethodElement r5) {
        if (r5.isStatic() == false) goto L12;
        XMemberContainer r10 = r5.getEnclosingElement();
        if ((r10 instanceof XTypeElement) == false) goto L7;
        XTypeElement r11 = (XTypeElement) r10;
    L8:
        if (r11 == null) goto L12;
        if (r11.isInterface() != true) goto L12;
        return true;
    L7:
        r11 = null;
    L12:
        return false;
    }
}
