package com.bytedance.android.monitorV2.dataprocessor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nTypedDataDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypedDataDispatcher.kt\ncom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher$notifyAllEvents$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n1819#2:103\n1819#2,2:104\n1820#2:106\n*E\n*S KotlinDebug\n*F\n+ 1 TypedDataDispatcher.kt\ncom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher$notifyAllEvents$1\n*L\n93#1:103\n94#1,2:104\n93#1:106\n*E\n"})
final class TypedDataDispatcher$notifyAllEvents$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3531a;

    public TypedDataDispatcher$notifyAllEvents$1(b r5) {
        this.f3531a = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        b r5 = this.f3531a;
        r5.f3532a = false;
        Set r10 = r5.f3534c.entrySet();
        b r11 = this.f3531a;
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L15;
        Map.Entry r13 = (Map.Entry) r12.next();
        List r14 = (List) r13.getValue();
        if (r14 == null) goto L4;
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L4;
        Object r16 = r15.next();
        TypedDataDispatcher$DataType r17 = (TypedDataDispatcher$DataType) r13.getKey();
        if (r11.f3533b.containsKey(r17) == false) goto L14;
        Object r18 = r11.f3533b.get(r17);
        Intrinsics.checkNotNull(r18);
        ((a) r18).a(r16);
        goto L9
    L14:
        throw new UnsupportedOperationException("not found processor");
    L15:
        this.f3531a.f3534c.clear();
        return Unit.INSTANCE;
    }
}
