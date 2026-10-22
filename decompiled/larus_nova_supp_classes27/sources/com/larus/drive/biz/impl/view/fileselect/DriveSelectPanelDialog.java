package com.larus.drive.biz.impl.view.fileselect;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.databinding.LarusItemDriveSelectActionBinding;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o79.e;
import o79.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0004$%&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0014\u0010\u001d\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010\u001e\u001a\u00020\u0010H\u0002J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010 \u001a\u00020!H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectPanelDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusDialogDriveSelectPanelBinding;", "actionAdapter", "Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectPanelDialog$ActionAdapter;", "actionRule", "Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectPanelActionRule;", "selectedFiles", "", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "lastActions", "Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectPanelDialog$ActionItem;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onDestroyView", "updateSelectedFiles", "refreshActions", "buildDefaultActions", "context", "Landroid/content/Context;", "getSelectModeHost", "Lcom/larus/drive/biz/impl/view/fileselect/IDrivePageSelectMode;", "Companion", "ActionItem", "ActionAdapter", "ActionViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSelectPanelDialog extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public final a d;
    public final o79.c e;
    public List<DriveFileItem> f;
    public List<b> g;

    public static final class a extends RecyclerView.Adapter<c> {
        public final Function1<DriveSelectActionType, Unit> a;
        public final List<b> b;

        public final int getItemCount() {
            return ((ArrayList) this.b).size();
        }

        public a(e r2) {
            Intrinsics.checkNotNullParameter(r2, "onActionClick");
            this.a = r2;
            this.b = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            final c r5 = (c) r3;
            Intrinsics.checkNotNullParameter(r5, "holder");
            final b r6 = (b) ListProtector.get(this.b, r4);
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "item");
            r5.a.b.setImageResource(r6.b);
            r5.a.c.setText(r6.c);
            e1.d(r5.a.a, new f(r5, r6));
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            View r6 = LayoutInflater.from(r4.getContext()).inflate(2131562562, r4, false);
            int r7 = 2131370324;
            ImageView r0 = (ImageView) ViewBindings.findChildViewById(r6, 2131370324);
            if (r0 == null) goto L10;
            LinearLayout r8 = (LinearLayout) r6;
            TextView r2 = (TextView) ViewBindings.findChildViewById(r6, 2131370326);
            if (r2 != null) goto L7;
            r7 = 2131370326;
            goto L10
        L7:
            return new c(new LarusItemDriveSelectActionBinding(r8, r0, r2), this.a);
        L10:
            throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
        }
    }

    public static final class b {
        public final DriveSelectActionType a;
        public final int b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ActionItem(type=" + this.a + ", iconRes=" + this.b + ", text=" + this.c + ')';
        }

        public final DriveSelectActionType getType() {
            return this.a;
        }

        public b(DriveSelectActionType r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r4, "text");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final LarusItemDriveSelectActionBinding a;
        public final Function1<DriveSelectActionType, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(LarusItemDriveSelectActionBinding r2, Function1<? super DriveSelectActionType, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            Intrinsics.checkNotNullParameter(r3, "onActionClick");
            super(r2.a);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [o79.e] */
    public DriveSelectPanelDialog() {
        this.d = new a(new e(this));
        this.e = new o79.c();
        this.f = CollectionsKt.emptyList();
        this.g = CollectionsKt.emptyList();
    }

    public final void S90() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        o79.c r1 = this.e;
        List<DriveFileItem> r2 = this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "selectedFiles");
        if (r2.isEmpty() == false) goto L9;
        List r3 = CollectionsKt.emptyList();
    L35:
        Set r4 = CollectionsKt.toSet(r3);
        List r5 = CollectionsKt.listOf(new b[]{new b(DriveSelectActionType.ASK_AI, 2131241276, StringsKt.replace$default(r0.getString(2131905325), "%s", r0.getString(2131894309), false, 4, null)), new b(DriveSelectActionType.SHARE, 2131241281, r0.getString(2131905331)), new b(DriveSelectActionType.DOWNLOAD, 2131241278, r0.getString(2131905327)), new b(DriveSelectActionType.RENAME, 2131241280, r0.getString(2131905329)), new b(DriveSelectActionType.MOVE, 2131241279, r0.getString(2131905328)), new b(DriveSelectActionType.DELETE, 2131241277, r0.getString(2131905326))});
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L37:
        if (r7.hasNext() == false) goto L42;
        Object r8 = r7.next();
        if (r4.contains(((b) r8).getType()) == false) goto L37;
        r6.add(r8);
        goto L37
    L42:
        if (Intrinsics.areEqual(r6, this.g) == false) goto L44;
        return;
    L44:
        this.g = r6;
        a r9 = this.d;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "newItems");
        int r10 = ((ArrayList) r9.b).size();
        ((ArrayList) r9.b).clear();
        ((ArrayList) r9.b).addAll(r6);
        if (r10 != ((ArrayList) r9.b).size()) goto L47;
        r9.notifyItemRangeChanged(0, ((ArrayList) r9.b).size());
        return;
    L47:
        r9.notifyDataSetChanged();
        return;
    L9:
        if (r2.size() < 2) goto L11;
        r3 = CollectionsKt.listOf(DriveSelectActionType.DELETE);
        goto L35
    L11:
        DriveFileItem r11 = (DriveFileItem) CollectionsKt.first(r2);
        List r12 = CollectionsKt.createListBuilder();
        if (UploadFilePolicy.e(r11.d(false)) == true) goto L14;
    L22:
        boolean r13 = false;
    L23:
        if (r13 == false) goto L25;
        r12.add(DriveSelectActionType.ASK_AI);
    L25:
        r12.add(DriveSelectActionType.SHARE);
        if (r11.j == DriveFileType.FOLDER) goto L29;
        r12.add(DriveSelectActionType.DOWNLOAD);
    L29:
        if (r11.g() == true) goto L31;
    L34:
        r12.add(DriveSelectActionType.DELETE);
        r3 = CollectionsKt.build(r12);
        goto L35
    L31:
        if (r1.c.contains(r11.j) == true) goto L33;
        r12.add(DriveSelectActionType.RENAME);
    L33:
        r12.add(DriveSelectActionType.MOVE);
        goto L34
    L14:
        if (r1.b.contains(r11.j) == true) goto L22;
        if (r11.j != DriveFileType.IMAGE) goto L20;
        if (r11.e() > ((Number) r1.d.getValue()).longValue()) goto L22;
    L20:
        if (r11.b() == true) goto L22;
        r13 = true;
        goto L23
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        r0.setCanceledOnTouchOutside(false);
    L5:
        Dialog r1 = getDialog();
        if (r1 == null) goto L11;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L12;
        r2.setBackgroundDrawable(new ColorDrawable(0));
        r2.setDimAmount(0.0f);
        r2.clearFlags(2);
        r2.addFlags(32);
        r2.setLayout(-1, -2);
        r2.setGravity(80);
        return;
    L12:
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 != null) goto L13;
        setCancelable(false);
        return;
    L13:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L15;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnKeyListener(new o79.d(this));
        return r3;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562066, r4, false);
        int r7 = 2131370327;
        if (ViewBindings.findChildViewById(r6, 2131370327) == null) goto L9;
        r7 = 2131370328;
        RecyclerView r8 = ViewBindings.findChildViewById(r6, 2131370328);
        if (r8 == null) goto L9;
        ConstraintLayout r9 = r6;
        r8.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        r8.setItemAnimator(null);
        r8.setAdapter(this.d);
        S90();
        return r9;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
