package com.obric.common.oea.foundation.animation.b;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "initialValue", "getInitialValue", "()Ljava/lang/Object;", "property", "", "getProperty", "()Ljava/lang/String;", "targetValue", "getTargetValue", "valueClass", "Lkotlin/reflect/KClass;", "getValueClass", "()Lkotlin/reflect/KClass;", "convertToAnimatedPropertyInfo", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "SpringAnimationCommand", "TweenAnimationCommand", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$TweenAnimationCommand;", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$SpringAnimationCommand;", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class a<T> {

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.b.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u001d\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\tHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u000bHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#H\u0016J^\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u00012\b\b\u0002\u0010\u0007\u001a\u00028\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$SpringAnimationCommand;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "property", "", "initialValue", "targetValue", "valueClass", "Lkotlin/reflect/KClass;", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/reflect/KClass;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)V", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInitialVelocity", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getProperty", "()Ljava/lang/String;", "getSpec", "()Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "getTargetValue", "getValueClass", "()Lkotlin/reflect/KClass;", "component1", "component2", "component3", "component4", "component5", "component6", "convertToAnimatedPropertyInfo", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/reflect/KClass;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$SpringAnimationCommand;", "equals", "", "other", "hashCode", "", "toString", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0371a<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f7676b;
        private final T c;
        private final KClass<T> d;
        private final com.obric.common.oea.foundation.animation.spec.a<T> e;
        private final Float f;

        public C0371a(String r3, T r4, T r5, KClass<T> r6, com.obric.common.oea.foundation.animation.spec.a<T> r7, Float r8) {
            KClass<T> r9 = (KClass) ZeusTransformUtils.wrapperContextForParams(r6, KClass.class, "com.obric.memorydata.plugin");
            com.obric.common.oea.foundation.animation.spec.a<T> r10 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "property");
            Intrinsics.checkNotNullParameter(r4, "initialValue");
            Intrinsics.checkNotNullParameter(r5, "targetValue");
            Intrinsics.checkNotNullParameter(r9, "valueClass");
            Intrinsics.checkNotNullParameter(r10, "spec");
            super(null);
            this.f7675a = r3;
            this.f7676b = r4;
            this.c = r5;
            this.d = r9;
            this.e = r10;
            this.f = r8;
        }

        @Override // com.obric.common.oea.foundation.animation.b.a
        public com.obric.common.oea.foundation.animation.a<T> a() {
            return new com.obric.common.oea.foundation.animation.a(b(), c(), d(), this.e, this.f, e(), 0.0f, 64, null);
        }

        public String b() {
            return this.f7675a;
        }

        public T c() {
            return this.f7676b;
        }

        public T d() {
            return this.c;
        }

        public KClass<T> e() {
            return this.d;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, C0371a.class) == false) goto L19;
            C0371a r4 = (C0371a) ZeusTransformUtils.preCheckCast(r3, C0371a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(b(), r4.b()) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(c(), r4.c()) == true) goto L11;
            return false;
        L11:
            if (Intrinsics.areEqual(d(), r4.d()) == true) goto L13;
            return false;
        L13:
            if (Intrinsics.areEqual(e(), r4.e()) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L17;
            return false;
        L17:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L29;
            return false;
        L29:
            return true;
        L19:
            return false;
        }

        public int hashCode() {
            String r0 = b();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            T r4 = c();
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = d();
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            KClass<T> r10 = e();
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            com.obric.common.oea.foundation.animation.spec.a<T> r13 = this.e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.f;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "SpringAnimationCommand(property=" + b() + ", initialValue=" + c() + ", targetValue=" + d() + ", valueClass=" + e() + ", spec=" + this.e + ", initialVelocity=" + this.f + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u001d\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\tHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u000bHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#H\u0016J^\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u00012\b\b\u0002\u0010\u0007\u001a\u00028\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$TweenAnimationCommand;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "property", "", "initialValue", "targetValue", "valueClass", "Lkotlin/reflect/KClass;", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/reflect/KClass;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)V", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInitialVelocity", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getProperty", "()Ljava/lang/String;", "getSpec", "()Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "getTargetValue", "getValueClass", "()Lkotlin/reflect/KClass;", "component1", "component2", "component3", "component4", "component5", "component6", "convertToAnimatedPropertyInfo", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/reflect/KClass;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$TweenAnimationCommand;", "equals", "", "other", "hashCode", "", "toString", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f7678b;
        private final T c;
        private final KClass<T> d;
        private final com.obric.common.oea.foundation.animation.spec.a<T> e;
        private final Float f;

        public b(String r3, T r4, T r5, KClass<T> r6, com.obric.common.oea.foundation.animation.spec.a<T> r7, Float r8) {
            KClass<T> r9 = (KClass) ZeusTransformUtils.wrapperContextForParams(r6, KClass.class, "com.obric.memorydata.plugin");
            com.obric.common.oea.foundation.animation.spec.a<T> r10 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "property");
            Intrinsics.checkNotNullParameter(r4, "initialValue");
            Intrinsics.checkNotNullParameter(r5, "targetValue");
            Intrinsics.checkNotNullParameter(r9, "valueClass");
            Intrinsics.checkNotNullParameter(r10, "spec");
            super(null);
            this.f7677a = r3;
            this.f7678b = r4;
            this.c = r5;
            this.d = r9;
            this.e = r10;
            this.f = r8;
        }

        @Override // com.obric.common.oea.foundation.animation.b.a
        public com.obric.common.oea.foundation.animation.a<T> a() {
            return new com.obric.common.oea.foundation.animation.a(b(), c(), d(), this.e, this.f, e(), 0.0f, 64, null);
        }

        public String b() {
            return this.f7677a;
        }

        public T c() {
            return this.f7678b;
        }

        public T d() {
            return this.c;
        }

        public KClass<T> e() {
            return this.d;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L19;
            b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(b(), r4.b()) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(c(), r4.c()) == true) goto L11;
            return false;
        L11:
            if (Intrinsics.areEqual(d(), r4.d()) == true) goto L13;
            return false;
        L13:
            if (Intrinsics.areEqual(e(), r4.e()) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L17;
            return false;
        L17:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L29;
            return false;
        L29:
            return true;
        L19:
            return false;
        }

        public int hashCode() {
            String r0 = b();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            T r4 = c();
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = d();
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            KClass<T> r10 = e();
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            com.obric.common.oea.foundation.animation.spec.a<T> r13 = this.e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.f;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "TweenAnimationCommand(property=" + b() + ", initialValue=" + c() + ", targetValue=" + d() + ", valueClass=" + e() + ", spec=" + this.e + ", initialVelocity=" + this.f + ")";
        }
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker r1) {
        this();
    }

    public abstract com.obric.common.oea.foundation.animation.a<T> a();
}
