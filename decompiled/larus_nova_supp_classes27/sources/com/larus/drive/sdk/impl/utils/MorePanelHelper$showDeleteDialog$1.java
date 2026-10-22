package com.larus.drive.sdk.impl.utils;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.MorePanelHelper$showDeleteDialog$1", f = "MorePanelHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MorePanelHelper$showDeleteDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ v79.e $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ DriveFileItem $file;
    final /* synthetic */ int $messageResId;
    final /* synthetic */ Fragment $toastOwnerFragment;
    int label;

    public static final class a implements u {
        public a() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
        }
    }

    public static final class b implements p0 {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ DriveFileItem d;
        public final /* synthetic */ v79.e e;

        public static final class a implements v79.a {
            public final /* synthetic */ long a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ DriveFileItem c;
            public final /* synthetic */ v79.e d;

            @Override // v79.a
            public final void onSuccess() {
                AtomicLong r0 = h79.b.a;
                long r1 = this.a;
                Context r2 = this.b;
                String r3 = r2.getString(2131899713);
                Intrinsics.checkNotNullParameter(r3, "text");
                if (h79.b.b != r1) goto L5;
                h79.b.b = 0;
            L5:
                t19.s r4 = t19.s.a;
                r4.a();
                String r5 = r3.toString();
                r4.getClass();
                t19.s.p(r2, r5);
                Unit r6 = Unit.INSTANCE;
                Lazy r7 = MorePanelHelper.a;
                s79.a r8 = ((e89.b) com.larus.drive.sdk.impl.service.t.h.getValue()).a();
                if (r8 == null) goto L8;
                r8.a(this.c.b);
            L8:
                v79.e r9 = this.d;
                if (r9 == null) goto L12;
                r9.a(this.c.b);
                return;
            }

            @Override // v79.a
            public final void a(Map<String, Integer> r7) {
                Intrinsics.checkNotNullParameter(r7, "failFileWithCode");
                Collection<Integer> r8 = r7.values();
                boolean r1 = false;
                if ((r8 instanceof Collection) == true) goto L5;
            L7:
                Iterator<T> r9 = r8.iterator();
            L9:
                if (r9.hasNext() == false) goto L13;
                if (CollectionsKt.listOf(new Integer[]{672020010, 672020011, 900004230}).contains(Integer.valueOf(((Number) r9.next()).intValue())) == false) goto L9;
                r1 = true;
            L13:
                Context r10 = this.b;
                if (r1 == false) goto L16;
                int r0 = 2131905388;
            L17:
                String r11 = r10.getString(r0);
                AtomicLong r2 = h79.b.a;
                h79.b.c(this.a, this.b, r11);
                return;
            L16:
                r0 = 2131899537;
                goto L17
            L5:
                if (r8.isEmpty() == false) goto L7;
                goto L7
            }

            public a(long r1, Context r3, DriveFileItem r4, v79.e r5) {
                this.a = r1;
                this.b = r3;
                this.c = r4;
                this.d = r5;
            }
        }

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            AtomicLong r0 = h79.b.a;
            long r4 = h79.b.b(this.a, this.b, this.c.getString(2131899715));
            Lazy r1 = MorePanelHelper.a;
            MorePanelHelper.c().m(CollectionsKt.listOf(this.d), new a(r4, this.c, this.d, this.e));
        }

        public b(FragmentActivity r1, Fragment r2, Context r3, DriveFileItem r4, v79.e r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public MorePanelHelper$showDeleteDialog$1(Context r1, int r2, FragmentActivity r3, Fragment r4, DriveFileItem r5, v79.e r6, Continuation<? super MorePanelHelper$showDeleteDialog$1> r7) {
        this.$context = r1;
        this.$messageResId = r2;
        this.$activity = r3;
        this.$toastOwnerFragment = r4;
        this.$file = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new MorePanelHelper$showDeleteDialog$1(this.$context, this.$messageResId, this.$activity, this.$toastOwnerFragment, this.$file, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        CommonDialog.a r11 = new CommonDialog.a();
        r11.i(this.$context.getString(2131899712));
        r11.g(this.$context.getString(this.$messageResId));
        r11.b = true;
        CommonDialog.a.e(r11, new a(), this.$context.getString(2131899534), 4);
        FragmentActivity r4 = this.$activity;
        Fragment r5 = this.$toastOwnerFragment;
        Context r1 = this.$context;
        CommonDialog.a.f(r11, new b(r4, r5, r1, this.$file, this.$callback), r1.getString(2131899533), false, 12);
        INVOKEVIRTUAL_com_larus_drive_sdk_impl_utils_MorePanelHelper$showDeleteDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r11.a(), this.$activity.getSupportFragmentManager(), "drive_delete_dialog");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static void INVOKEVIRTUAL_com_larus_drive_sdk_impl_utils_MorePanelHelper$showDeleteDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        CommonDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
