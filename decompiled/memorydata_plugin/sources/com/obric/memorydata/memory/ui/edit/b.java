package com.obric.memorydata.memory.ui.edit;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u008b\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0001\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012<\b\u0002\u0010\u000e\u001a6\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010#\u001a\u00020$J\u0017\u0010%\u001a\u0004\u0018\u00018\u00012\b\u0010&\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010'J\u001b\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0002\u0010+J\u0015\u0010\u001a\u001a\u0004\u0018\u00018\u00012\u0006\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u0015\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00018\u0001HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J=\u00103\u001a6\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fHÆ\u0003J¢\u0001\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u00012\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062<\b\u0002\u0010\u000e\u001a6\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u00108\u001a\u00020\u0006HÖ\u0001J\t\u00109\u001a\u00020$HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00018\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017RE\u0010\u000e\u001a6\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006:"}, d2 = {"Lcom/obric/memorydata/memory/ui/edit/MemoryEditItem;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "labelRes", "", "key", "Lkotlin/reflect/KMutableProperty1;", EventBody.KEY_VALUE, "editType", "necessary", "", "viewType", "validator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "memoryEntity", "Lcom/obric/memorydata/memory/ui/edit/ValidationResult;", "<init>", "(ILkotlin/reflect/KMutableProperty1;Ljava/lang/Object;IZILkotlin/jvm/functions/Function2;)V", "getLabelRes", "()I", "getKey", "()Lkotlin/reflect/KMutableProperty1;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getEditType", "getNecessary", "()Z", "getViewType", "getValidator", "()Lkotlin/jvm/functions/Function2;", "valueToText", "", "textToValue", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "(Ljava/lang/String;)Ljava/lang/Object;", "applyValue", "", "entity", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/lang/Object;)V", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILkotlin/reflect/KMutableProperty1;Ljava/lang/Object;IZILkotlin/jvm/functions/Function2;)Lcom/obric/memorydata/memory/ui/edit/MemoryEditItem;", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b<T extends MemoryEntity, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KMutableProperty1<T, V> f10893b;
    private final V c;
    private final int d;
    private final boolean e;
    private final int f;
    private final Function2<T, V, j> g;

    public b(int r3, KMutableProperty1<T, V> r4, V r5, int r6, boolean r7, int r8, Function2<? super T, ? super V, j> r9) {
        KMutableProperty1<T, V> r10 = (KMutableProperty1) ZeusTransformUtils.wrapperContextForParams(r4, KMutableProperty1.class, "com.obric.memorydata.plugin");
        Function2<T, V, j> r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "key");
        this.f10892a = r3;
        this.f10893b = r10;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r11;
    }

    public /* synthetic */ b(final int r8, KMutableProperty1 r9, Object r10, int r11, boolean r12, int r13, Function2 r14, int r15, DefaultConstructorMarker r16) {
        KMutableProperty1 r0 = (KMutableProperty1) ZeusTransformUtils.wrapperContextForParams(r9, KMutableProperty1.class, "com.obric.memorydata.plugin");
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r14, Function2.class, "com.obric.memorydata.plugin");
        if ((r15 & 4) == 0) goto L5;
        Object r2 = null;
    L6:
        int r4 = 1;
        if ((r15 & 8) == 0) goto L9;
        final int r3 = 1;
    L11:
        if ((r15 & 16) == 0) goto L13;
        final boolean r5 = true;
    L15:
        if ((r15 & 32) != 0) goto L19;
        r4 = r13;
    L19:
        if ((r15 & 64) == 0) goto L22;
        r1 = new $$Lambda$b$4Xcc7tRXLdDIiQtdCq4WGB0PrvA(r3, r8, r5);
    L22:
        this(r8, r0, r2, r3, r5, r4, r1);
        return;
    L13:
        r5 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L6
    }

    private static final j a(int r4, int r5, boolean r6, MemoryEntity r7, Object r8) {
        Intrinsics.checkNotNullParameter(r7, "<unused var>");
        if (r4 == 4) goto L5;
        if (r6 == false) goto L23;
        if (r8 != null) goto L14;
    L26:
        return j.f10912a.a(r5);
    L14:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L27;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L27;
    L18:
        r9 = false;
    L27:
        return new j(true, null, 2, null);
    L23:
        return new j(true, null, 2, null);
    L5:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L25;
        if (new Regex("[a-zA-Z0-9]+").matches((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L25;
        return new j(true, null, 2, null);
    L25:
        return j.f10912a.b(r5);
    }

    public static /* synthetic */ j lambda$4Xcc7tRXLdDIiQtdCq4WGB0PrvA(int r0, int r1, boolean r2, MemoryEntity r3, Object r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public final KMutableProperty1<T, V> a() {
        return this.f10893b;
    }

    public final void a(T r2, V r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Field r1 = c.a(r2.getClass(), this.f10893b.getName());
        if (r1 == null) goto L6;
        r1.set(r2, r3);
        return;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f10892a == r6.f10892a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10893b, r6.f10893b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.f10892a) * 31) + this.f10893b.hashCode()) * 31;
        V r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + Integer.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31;
        Function2<T, V, j> r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MemoryEditItem(labelRes=" + this.f10892a + ", key=" + this.f10893b + ", value=" + this.c + ", editType=" + this.d + ", necessary=" + this.e + ", viewType=" + this.f + ", validator=" + this.g + ')';
    }
}
