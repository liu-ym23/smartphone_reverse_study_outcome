package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/SettingEditFragment;", "Lcom/bytedance/android/annie/debug/ui/AbsInfoDialogFragment;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class SettingEditFragment extends AbsInfoDialogFragment {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SettingEditFragment a;
        public final /* synthetic */ Ref.ObjectRef<y9.i<Object>> b;

        public a(SettingEditFragment r1, Ref.ObjectRef<y9.i<Object>> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            Context r11 = this.a.getContext();
            Intrinsics.checkNotNull(r11);
            SettingItemSetFragment r0 = new SettingItemSetFragment();
            r0.e = (y9.i) this.b.element;
            a8.c.b(r11, r0, "setting_item_edit");
        }
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r10) {
            return ComparisonsKt.compareValues(((DialogItem) r1).a, ((DialogItem) r10).a);
        }
    }

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final String T90() {
        return "setting配置";
    }

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final boolean U90() {
        return true;
    }

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final List<DialogItem> S90() {
        LinkedList r0 = new LinkedList();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Field[] r10 = AnnieConfigSettingKeys.class.getFields();     // Catch: Throwable -> L11
        int r11 = r10.length;     // Catch: Throwable -> L11
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L7;
        Field r13 = r10[r12];     // Catch: Throwable -> L11
        Ref.ObjectRef r14 = new Ref.ObjectRef();     // Catch: Throwable -> L11
        Object r15 = r13.get(null);     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.android.annie.service.setting.AnnieSettingKey<kotlin.Any>");     // Catch: Throwable -> L11
        y9.i r16 = (y9.i) r15;     // Catch: Throwable -> L11
        r14.element = r16;     // Catch: Throwable -> L11
        y9.i r17 = r16;     // Catch: Throwable -> L11
        y9.i r18 = r16;     // Catch: Throwable -> L11
        r0.add(new DialogItem(r16.a, r16.a().toString(), new a(this, r14)));     // Catch: Throwable -> L11
        r12 = r12 + 1;     // Catch: Throwable -> L11
        goto L4
    L7:
        if (r0.size() <= 1) goto L9;
        CollectionsKt.sortWith(r0, new b());     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        return r0;
    L11:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public SettingEditFragment() {
    }
}
