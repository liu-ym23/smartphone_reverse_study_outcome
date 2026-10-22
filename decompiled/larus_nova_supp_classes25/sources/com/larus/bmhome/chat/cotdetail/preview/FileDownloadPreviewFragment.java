package com.larus.bmhome.chat.cotdetail.preview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.mainbot.impl.databinding.LarusFragmentFileDownloadPreviewBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me8.b;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/preview/FileDownloadPreviewFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFragmentFileDownloadPreviewBinding;", "fileData", "Lcom/larus/bmhome/chat/block/base/renderer/FileCardVMData;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FileDownloadPreviewFragment extends Fragment {
    public static final /* synthetic */ int f = 0;
    public LarusFragmentFileDownloadPreviewBinding d;
    public FileCardVMData e;

    public static final class a {
    }

    static {
    }

    public FileDownloadPreviewFragment() {
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        FileCardVMData r4 = (FileCardVMData) r3.getParcelable("arg_file_data");
    L6:
        this.e = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        LarusFragmentFileDownloadPreviewBinding r7 = this.d;
        LarusFragmentFileDownloadPreviewBinding r0 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L5:
        e1.d(r7.b, new me8.a(this));
        final FileCardVMData r8 = this.e;
        if (r8 != null) goto L9;
        FLogger.a.e("FileDownloadPreviewFragment", "fileData is null");
        return;
    L9:
        boolean r2 = h.a;
        if (h.b(r5.getContext()) == false) goto L12;
        String r9 = r8.d();
    L13:
        LarusFragmentFileDownloadPreviewBinding r3 = this.d;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L16:
        ImageLoaderKt.u(r3.d, r9, "test");
        LarusFragmentFileDownloadPreviewBinding r10 = this.d;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L19:
        r10.e.setText(r8.e());
        LarusFragmentFileDownloadPreviewBinding r11 = this.d;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L23:
        e1.d(r0.c, new b(this, r8));
        return;
    L22:
        r0 = r11;
        goto L23
    L12:
        r9 = r8.i();
        goto L13
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131562387, r8, false);
        int r11 = 2131364650;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r10, 2131364650);
        if (r2 == null) goto L13;
        r11 = 2131364621;
        RoundTextView r3 = ViewBindings.findChildViewById(r10, 2131364621);
        if (r3 == null) goto L13;
        r11 = 2131372392;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r10, 2131372392);
        if (r4 == null) goto L13;
        r11 = 2131372393;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131372393);
        if (r5 == null) goto L13;
        LarusFragmentFileDownloadPreviewBinding r12 = new LarusFragmentFileDownloadPreviewBinding(r10, r2, r3, r4, r5);
        this.d = r12;
        return r12.a;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
