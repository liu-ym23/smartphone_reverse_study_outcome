package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/LikeEggImagePickerDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "Companion", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LikeEggImagePickerDialog extends DialogFragment {
    public static final /* synthetic */ int o = 0;
    public Function1<? super String, Unit> d;
    public Function0<Unit> e;
    public DataCenter f;
    public RecyclerView g;
    public View h;
    public View i;
    public ImagePickViewModel j;
    public ImageItemAdapter k;
    public LikeEggImagePickerDialog$initImageRecyclerView$4 l;
    public boolean m;
    public final CompositeDisposable n;

    public static final class Companion {
        public static void a(final Context r2, final Function1 r3, final Function0 r4, final DataCenter r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "clickAction");
            Intrinsics.checkNotNullParameter(r4, "cancelAction");
            ALogger.d("LikeEggImagePickerDialog", "start launch");
            TokenCert r0 = LikeEggHelper.a;
            LikeEggHelper.c(new LikeEggImagePickerDialog$Companion$launch$1(r2, r3, r4, r5), LikeEggImagePickerDialog$Companion$launch$2.INSTANCE);
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LikeEggImagePickerDialog a;

        public a(LikeEggImagePickerDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            LikeEggImagePickerDialog r4 = this.a;
            int r0 = LikeEggImagePickerDialog.o;
            r4.S90();
        }
    }

    static {
    }

    public final void S90() {
        View r0 = this.i;
        if (r0 == null) goto L6;
        TokenCert r1 = LikeEggHelper.a;
        a1.k(r0, LikeEggHelper.a(this.f));
    L6:
        if (PadConfigUtils.c() == false) goto L20;
        View r2 = this.i;
        if (r2 == null) goto L10;
        a1.o(r2, UtilityKotlinExtentionsKt.i(20));
    L10:
        View r3 = this.i;
        if (r3 == null) goto L13;
        a1.n(r3, UtilityKotlinExtentionsKt.i(20) - 2);
    L13:
        View r4 = this.i;
        if (r4 == null) goto L16;
        a1.l(r4, UtilityKotlinExtentionsKt.i(20));
    L16:
        View r5 = this.i;
        if (r5 == null) goto L21;
        a1.p(r5, UtilityKotlinExtentionsKt.i(375));
        return;
    L21:
        return;
    }

    public LikeEggImagePickerDialog() {
        this.n = new CompositeDisposable();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ImagePickViewModel r0 = this.j;
        if (r0 == null) goto L6;
        r0.tryFirstTimeLoad();
        return;
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L8;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L9;
        r4.setGravity(80);
        r4.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (PadConfigUtils.c() == false) goto L5;
        setStyle(1, 2131954706);
    L6:
        this.j = (ImagePickViewModel) ViewModelProviders.of(this).get(ImagePickViewModel.class);
        Activity r3 = ContextUtil.contextToActivity(getContext());
        if (r3 == null) goto L9;
        ContentResolver r4 = r3.getContentResolver();
    L10:
        if (r4 != null) goto L18;
        ALogger.e("LikeEggImagePickerDialog", "contentResolver is null");
        dismiss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L24;
        d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L24:
        return;
    L18:
        ImagePickViewModel r0 = this.j;
        if (r0 == null) goto L26;
        r0.setMContentResolver(r4);
        return;
    L26:
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        setStyle(1, 2131954705);
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        f.d().f();     // Catch: Throwable -> L5
        this.n.dispose();     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        ImagePickViewModel r0 = this.j;
        if (r0 == null) goto L10;
        ImageItemAdapter r1 = this.k;
        if (r1 == null) goto L7;
        ArrayList<String> r2 = r1.a;
    L8:
        r0.saveState(r3, r2);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        if (r2 == null) goto L8;
        ImagePickViewModel r0 = this.j;
        if (r0 == null) goto L9;
        r0.restoreState(r2);
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker.LikeEggImagePickerDialog$initImageRecyclerView$4] */
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        this.g = r4.findViewById(2131375049);
        this.h = r4.findViewById(2131366972);
        this.i = r4.findViewById(2131368976);
        View r6 = this.h;
        if (r6 == null) goto L5;
        r6.setOnClickListener(new c(this));
    L5:
        S90();
        ImageItemAdapter r7 = new ImageItemAdapter();
        Function2<Integer, String, Unit> r8 = new LikeEggImagePickerDialog$initImageRecyclerView$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r8, "action");
        r7.b = r8;
        Unit r9 = Unit.INSTANCE;
        this.k = r7;
        RecyclerView r10 = this.g;
        if (r10 == null) goto L8;
        r10.setLayoutManager(new GridLayoutManager(getContext(), 4));
    L8:
        RecyclerView r11 = this.g;
        if (r11 == null) goto L11;
        r11.setHasFixedSize(true);
    L11:
        RecyclerView r13 = this.g;
        if (r13 == null) goto L14;
        r13.addItemDecoration(new ImagePickerItemDecoration(UtilityKotlinExtentionsKt.i(2), UtilityKotlinExtentionsKt.i(2)));
    L14:
        ImageItemAdapter r14 = this.k;
        if (r14 == null) goto L24;
        r14.a.clear();
        ImagePickViewModel r0 = this.j;
        if (r0 == null) goto L21;
        List<String> r1 = r0.getInitImagePaths();
        if (r1 == null) goto L21;
        r14.a.addAll(r1);
    L21:
        RecyclerView r2 = this.g;
        if (r2 == null) goto L24;
        r2.setAdapter(r14);
    L24:
        LikeEggImagePickerDialog$initImageRecyclerView$4 r15 = this.l;
        if (r15 == null) goto L29;
        RecyclerView r3 = this.g;
        if (r3 == null) goto L29;
        r3.removeOnScrollListener(r15);
    L29:
        ?? r16 = new LikeEggImagePickerDialog$initImageRecyclerView$4(this);
        this.l = r16;
        RecyclerView r17 = this.g;
        if (r17 == null) goto L32;
        r17.addOnScrollListener(r16);
    L32:
        ImagePickViewModel r18 = this.j;
        if (r18 == null) goto L38;
        MutableLiveData<ArrayList<String>> r19 = r18.getMImagePathsBuffer();
        if (r19 == null) goto L38;
        r19.observe(this, new b(this));
    L38:
        if (PadConfigUtils.c() == false) goto L48;
        u r20 = r.u(this.f, null, 2);
        if (r20 == null) goto L48;
        n r21 = r20.w();
        if (r21 == null) goto L48;
        Observable r23 = r21.a();
        if (r23 == null) goto L48;
        Disposable r24 = r23.subscribe(new a(this));
        if (r24 == null) goto L48;
        RxUtilKt.c(r24, this.n);
    L48:
        int r25 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_vs_photo_album_show", new LinkedHashMap());
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        f.d().a();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.show(r2, r3);
        return;
    }

    public final void showNow(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        f.d().a();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.showNow(r2, r3);
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (PadConfigUtils.c() == false) goto L5;
        int r4 = 2131566826;
    L7:
        return r1.inflate(r4, r2);
    L5:
        r4 = 2131566825;
        goto L7
    }
}
