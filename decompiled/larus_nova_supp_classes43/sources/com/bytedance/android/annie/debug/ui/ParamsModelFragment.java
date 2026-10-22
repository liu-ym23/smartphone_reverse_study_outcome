package com.bytedance.android.annie.debug.ui;

import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/ParamsModelFragment;", "Lcom/bytedance/android/annie/debug/ui/AbsInfoDialogFragment;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class ParamsModelFragment extends AbsInfoDialogFragment {
    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final String T90() {
        return "ParamsModel";
    }

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final boolean U90() {
        return true;
    }

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final List<DialogItem> S90() {
        LinkedList r0 = new LinkedList();
        AnnieCard r1 = this.d;
        if (r1 == null) goto L32;
        CardParamVoNew r10 = r1.getMHybridParamVoNew();
        if (r10 == null) goto L32;
        LinkedList r11 = new LinkedList();
        List r12 = CollectionsKt.listOf(new String[]{"CREATOR", "parsing", "Companion"});
        Class<?> r13 = r10.getClass();
        String r14 = new Object().getClass().getName();
    L8:
        if (Intrinsics.areEqual(r13.getName(), r14) == true) goto L31;
        r11.add(new DialogItem(r13.getSimpleName(), null, null, 6));
        Field[] r15 = r13.getDeclaredFields();
        int r16 = r15.length;
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L30;
        Field r18 = r15[r17];
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L24
        r18.setAccessible(true);     // Catch: Throwable -> L24
        SerializedName r110 = r18.getAnnotation(SerializedName.class);     // Catch: Throwable -> L24
        if (r110 == null) goto L16;
        String r111 = r110.value();     // Catch: Throwable -> L24
        if (r111 == null) goto L16;
    L18:
        if (r12.contains(r111) == false) goto L20;
    L22:
        Object r112 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r113 = Result.exceptionOrNull-impl(r112);
        if (r113 == null) goto L29;
        r113.getMessage();
    L29:
        r17 = r17 + 1;
        goto L10
    L20:
        if (StringsKt.contains$default(r111, "$delegate", false, 2, null) == true) goto L22;
        r11.add(new DialogItem(r111, r18.get(r10).toString(), null, 4));     // Catch: Throwable -> L24
    L16:
        r111 = r18.getName();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L30:
        r13 = r13.getSuperclass();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
        goto L8
    L31:
        r0.addAll(r11);
    L32:
        return r0;
    }

    public ParamsModelFragment() {
    }
}
