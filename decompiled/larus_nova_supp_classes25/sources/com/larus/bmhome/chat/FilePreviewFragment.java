package com.larus.bmhome.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusFragmentFilePreviewBinding;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common_ui.view.FileExportType;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/FilePreviewFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusFragmentFilePreviewBinding;", "filePath", "", "botId", "exportId", "previousPage", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onCloseAction", "onShareAction", "autoLogEnterPage", "", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "parseFileType", "Lcom/larus/common_ui/view/FileExportType;", "fileName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FilePreviewFragment extends TraceFragment {
    public static final /* synthetic */ int j = 0;
    public LarusFragmentFilePreviewBinding e;
    public String f;
    public String g;
    public String h;
    public String i;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "exporting_file_preview";
    }

    public final void U90() {
        String r1 = this.f;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        FLogger.a.e("FilePreviewFragment", "onShareAction, filePath empty");
        return;
    L12:
        String r3 = this.f;
        String r4 = null;
        if (r3 == null) goto L15;
        r4 = StringsKt.substringAfterLast$default(r3, "/", null, 2, null);
    L15:
        String r16 = r4;
        ShareServiceDelegate r5 = ShareServiceDelegate.b;
        Context r6 = getContext();
        String r15 = this.f;
        IShareService.a.d(r5, r6, "more", "file", new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, r15, r16, null, null, r15, r16, null, null, null, false, false, null, null, false, false, null, false, null, null, 67102335), null, 48);
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public FilePreviewFragment() {
    }

    public static FileExportType V90(String r3) {
        String r4 = StringsKt.substringAfterLast$default(r3, ".", null, 2, null);
        FileExportType.Companion.getClass();
        Intrinsics.checkNotNullParameter(r4, "extension");
        switch(r4.hashCode()) {
            case 110834: goto L22;
            case 115312: goto L18;
            case 3088960: goto L14;
            case 3447940: goto L10;
            case 96948919: goto L6;
            default: goto L26;
        };
    L6:
        if (r4.equals("excel") == false) goto L26;
        return FileExportType.excel;
    L10:
        if (r4.equals("pptx") == false) goto L26;
        return FileExportType.pptx;
    L14:
        if (r4.equals("docx") == false) goto L26;
        return FileExportType.word;
    L18:
        if (r4.equals("txt") == false) goto L26;
        return FileExportType.txt;
    L22:
        if (r4.equals("pdf") == false) goto L26;
        return FileExportType.pdf;
    L26:
        return FileExportType.unknown;
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larus.trace.tracknode.a.a.a(this, r3);
        if (com.larus.utils.o0.d(this.i) == false) goto L6;
        r3.put("previous_page", this.i);
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        String r1 = null;
        if (r5 == null) goto L5;
        String r6 = r5.getString("arg_file_path", "");
    L6:
        this.f = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L9;
        String r8 = r7.getString("arg_bot_id", "");
    L10:
        this.g = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L13;
        String r10 = r9.getString("arg_export_id", "");
    L14:
        this.h = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L17;
        r1 = r11.getString("arg_previous_page", "");
    L17:
        this.i = r1;
        return;
    L13:
        r10 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        LarusFragmentFilePreviewBinding r7 = this.e;
        LarusFragmentFilePreviewBinding r0 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L5:
        com.larus.utils.e1.d(r7.b, new u2(this));
        String r8 = this.f;
        if (r8 == null) goto L8;
        String r9 = StringsKt.substringAfterLast$default(r8, "/", null, 2, null);
    L9:
        if (r9 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L18;
        FLogger.a.e("FilePreviewFragment", "fileName empty, filePath param: " + this.f);
        return;
    L18:
        final FileExportType r2 = V90(r9);
        LarusFragmentFilePreviewBinding r3 = this.e;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L21:
        com.larus.utils.e1.d(r3.c, new v2(this, r2));
        LarusFragmentFilePreviewBinding r4 = this.e;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L24:
        r4.e.setImageResource(r2.iconRes());
        LarusFragmentFilePreviewBinding r10 = this.e;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L27:
        r10.f.setText(r9);
        LarusFragmentFilePreviewBinding r11 = this.e;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L31:
        com.larus.utils.e1.d(r0.g, new w2(this, r2));
        return;
    L30:
        r0 = r11;
        goto L31
    L11:
        if (r9.length() == 0) goto L14;
        r1 = false;
        goto L15
    L8:
        r9 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562388, r10, false);
        int r13 = 2131364679;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r12, 2131364679);
        if (r2 == null) goto L21;
        r13 = 2131364832;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r12, 2131364832);
        if (r3 == null) goto L21;
        r13 = 2131369197;
        View r4 = ViewBindings.findChildViewById(r12, 2131369197);
        if (r4 == null) goto L21;
        r13 = 2131372392;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r12, 2131372392);
        if (r5 == null) goto L21;
        r13 = 2131372393;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r12, 2131372393);
        if (r6 == null) goto L21;
        r13 = 2131382888;
        RoundTextView r7 = ViewBindings.findChildViewById(r12, 2131382888);
        if (r7 == null) goto L21;
        r13 = 2131382889;
        if (ViewBindings.findChildViewById(r12, 2131382889) == null) goto L21;
        r13 = 2131388807;
        if (ViewBindings.findChildViewById(r12, 2131388807) == null) goto L21;
        FrameLayout r14 = (FrameLayout) r12;
        this.e = new LarusFragmentFilePreviewBinding(r14, r2, r3, r4, r5, r6, r7);
        Intrinsics.checkNotNull(r14);
        r14.setTag(2131377847, this);
        return r14;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
