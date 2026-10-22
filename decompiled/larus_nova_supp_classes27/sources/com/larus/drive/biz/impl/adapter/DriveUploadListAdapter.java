package com.larus.drive.biz.impl.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.drive.biz.api.model.DriveUploadStatus;
import com.larus.drive.biz.impl.databinding.LarusItemDriveUploadEntryBinding;
import com.larus.drive.biz.impl.viewmodel.DriveUploadListViewModel;
import com.larus.utils.e1;
import java.util.Arrays;
import java.util.Locale;
import k79.f;
import k79.g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001d\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0015J\f\u0010\u0016\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0017\u001a\u00020\u0012*\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/drive/biz/impl/adapter/DriveUploadListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/drive/biz/api/model/DriveUploadItem;", "Lcom/larus/drive/biz/impl/adapter/DriveUploadListAdapter$ViewHolder;", "viewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveUploadListViewModel;", "<init>", "(Lcom/larus/drive/biz/impl/viewmodel/DriveUploadListViewModel;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "toSizeString", "", "", "totalSize", "(JLjava/lang/Long;)Ljava/lang/String;", "toMBString", "toKBString", "Companion", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveUploadListAdapter extends ListAdapter<com.larus.drive.biz.api.model.a, ViewHolder> {
    public static final DriveUploadListAdapter$Companion$DIFF$1 b = null;
    public final DriveUploadListViewModel a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/drive/biz/impl/adapter/DriveUploadListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusItemDriveUploadEntryBinding;", "<init>", "(Lcom/larus/drive/biz/impl/databinding/LarusItemDriveUploadEntryBinding;)V", "getBinding", "()Lcom/larus/drive/biz/impl/databinding/LarusItemDriveUploadEntryBinding;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final LarusItemDriveUploadEntryBinding a;

        public ViewHolder(LarusItemDriveUploadEntryBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveUploadStatus.values().length];
            r0[DriveUploadStatus.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DriveUploadStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DriveUploadStatus.UNSTARTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DriveUploadStatus.FINISH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.drive.biz.impl.adapter.DriveUploadListAdapter$Companion$DIFF$1] */
    static {
        b = new DriveUploadListAdapter$Companion$DIFF$1();
    }

    public DriveUploadListAdapter(DriveUploadListViewModel r2) {
        super(b);
        this.a = r2;
    }

    public static String y2(long r3) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r3 / 1024.0f)}, 1));
    }

    public static String z2(long r3) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf((r3 / 1024.0f) / 1024.0f)}, 1));
    }

    public static String A2(long r4, Long r6) {
        String r0 = z2(r4);
        if (Intrinsics.areEqual(r0, "0.0") == false) goto L19;
        if (r6 != null) goto L6;
    L8:
        String r1 = y2(r4);
        if (Intrinsics.areEqual(r1, "0.0") == false) goto L17;
        if (r6 == null) goto L15;
        if (Intrinsics.areEqual(y2(r6.longValue()), "0.0") == false) goto L17;
    L15:
        return r4 + ".0B";
    L17:
        return r1 + "KB";
    L6:
        if (Intrinsics.areEqual(z2(r6.longValue()), "0.0") == true) goto L8;
    L19:
        return r0 + "MB";
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        ViewHolder r13 = (ViewHolder) r11;
        Intrinsics.checkNotNullParameter(r13, "holder");
        final com.larus.drive.biz.api.model.a r14 = (com.larus.drive.biz.api.model.a) getItem(r12);
        LarusItemDriveUploadEntryBinding r0 = r13.a;
        r0.c.setImageResource(r14.d.getIconResId());
        r0.b.setText(r14.c);
        ViewGroup.LayoutParams r1 = r0.b.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L6:
        if (r2 == null) goto L13;
        if (r14.f != DriveUploadStatus.FAILED) goto L10;
        int r3 = i5.h0();
    L11:
        r2.setMarginEnd(r3);
        r0.b.setLayoutParams(r2);
        goto L13
    L10:
        r3 = i5.h();
    L13:
        if (r14.f != DriveUploadStatus.FAILED) goto L15;
        e1.x(r0.f);
    L16:
        TextView r4 = r0.d;
        DriveUploadStatus r5 = r14.f;
        int[] r6 = b.a;
        int r7 = r6[r5.ordinal()];
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L20;
        int r8 = 2131103143;
    L22:
        r4.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r13).itemView.getContext(), r8));
        Long r9 = r14.h;
        String r10 = "0.0B";
        if (r9 == null) goto L26;
        String r15 = A2(r9.longValue(), null);
        if (r15 == null) goto L26;
    L27:
        int r16 = r6[r14.f.ordinal()];
        if (r16 == 1) goto L43;
        if (r16 != 2) goto L31;
        Integer r17 = r14.g;
        if (r17 == null) goto L41;
        int r18 = r17.intValue();
    L42:
        String r110 = r13.a.a.getContext().getString(r18) + ' ' + r15;
    L50:
        r4.setText(r110);
        e1.d(r0.e, new f(this, r14));
        e1.d(r0.f, new g(this, r14));
        return;
    L41:
        r18 = 2131905424;
        goto L42
    L31:
        if (r16 != 3) goto L33;
        r110 = r13.a.a.getContext().getString(2131905423) + ' ' + r15;
        goto L50
    L33:
        if (r16 != 4) goto L36;
        r110 = r13.a.a.getContext().getString(2131905428) + ' ' + r15;
        goto L50
    L36:
        throw new NoWhenBranchMatchedException();
    L43:
        StringBuilder r20 = new StringBuilder();
        r20.append(r13.a.a.getContext().getString(2131905429));
        r20.append(' ');
        Long r111 = r14.i;
        if (r111 == null) goto L49;
        String r112 = A2(r111.longValue(), r14.h);
        if (r112 == null) goto L49;
        r10 = r112;
    L49:
        r20.append(r10);
        r20.append('/');
        r20.append(r15);
        r110 = r20.toString();
    L26:
        r15 = "0.0B";
        goto L27
    L20:
        r8 = 2131102650;
        goto L22
    L21:
        r8 = 2131103203;
        goto L22
    L15:
        e1.o(r0.f);
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        ConstraintLayout r11 = LayoutInflater.from(r9.getContext()).inflate(2131562563, r9, false);
        int r12 = 2131377316;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131377316);
        if (r3 == null) goto L15;
        r12 = 2131377317;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r11, 2131377317);
        if (r4 == null) goto L15;
        r12 = 2131377318;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131377318);
        if (r5 == null) goto L15;
        r12 = 2131377319;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r11, 2131377319);
        if (r6 == null) goto L15;
        r12 = 2131377320;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r11, 2131377320);
        if (r7 == null) goto L15;
        return new ViewHolder(new LarusItemDriveUploadEntryBinding(r11, r3, r4, r5, r6, r7));
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
