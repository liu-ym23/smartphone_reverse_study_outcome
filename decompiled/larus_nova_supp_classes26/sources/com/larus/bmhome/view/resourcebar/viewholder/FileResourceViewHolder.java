package com.larus.bmhome.view.resourcebar.viewholder;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.chat.common.databinding.LarusFileResourceInspectFailedLayoutBinding;
import com.larus.chat.common.databinding.LarusFileResourceItemViewBinding;
import com.larus.im.bean.message.block.LocalFileType;
import com.larus.utils.e1;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/FileResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/viewholder/EntityResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "viewBinding", "Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;)V", "setContentBackground", "", "data", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "getSuccessBackgroundRes", "", "setContentInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileResourceViewHolder extends EntityResourceViewHolder {
    @Override // com.larus.bmhome.view.resourcebar.viewholder.EntityResourceViewHolder
    public final void Z3(ResourceItemBean r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        super.Z3(r4);
        ItemStatus r5 = r4.getStatus();
        if (r5 != ItemStatus.UPLINK_SUCCESS) goto L5;
    L8:
        ConstraintLayout r6 = this.b.e;
        if (this.a.getMode() != Mode.SHOW) goto L11;
        int r0 = v19.c.b(2130970784, this.b.e.getContext(), 2131239519);
    L12:
        r6.setBackgroundResource(r0);
        return;
    L11:
        r0 = v19.c.b(2130970785, this.b.e.getContext(), 2131239523);
        goto L12
    L5:
        if (r5 == ItemStatus.PARSE_FAILED) goto L8;
        if (r5 == ItemStatus.SUCCESS) goto L8;
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.EntityResourceViewHolder
    public final void a4(ResourceItemBean r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        super.a4(r9);
        e1.o(this.b.r);
        if (r9.getStatus() != ItemStatus.INSPECT_FAILED) goto L9;
        V3().b();
        LarusFileResourceInspectFailedLayoutBinding r10 = (LarusFileResourceInspectFailedLayoutBinding) V3().c;
        if (r10 == null) goto L39;
        AppCompatTextView r11 = r10.c;
        if (r11 == null) goto L40;
        r11.setText(2131905684);
        return;
    L40:
        return;
    L39:
        return;
    L9:
        this.b.l.setText(r9.getTitle());
        if (EntityResourceViewHolder.b4(r9) == true) goto L42;
        boolean r0 = Intrinsics.areEqual(r9.getExt().get("local_item_attachment"), "1");
        boolean r1 = Intrinsics.areEqual(r9.getExt().get("local_item_file_type"), String.valueOf(LocalFileType.LocalFileTypeDirectory.getValue()));
        AppCompatImageView r2 = this.b.m;
        boolean r3 = false;
        String r4 = null;
        if (r1 == false) goto L14;
        int r5 = 2131240268;
    L24:
        r2.setImageResource(r5);
        HashMap<String, String> r6 = FileMimeTypeUtils.a;
        String r7 = FileMimeTypeUtils.e(r9.getMimeType(), r9.getFileSuffixes()).getType();
        AppCompatTextView r8 = this.b.n;
        if (r1 == false) goto L31;
        Object r12 = r9.getExt().get("local_item_path");
        if ((r12 instanceof String) == false) goto L29;
        r4 = (String) r12;
    L29:
        r7 = r4;
    L37:
        r8.setText(r7);
        return;
    L31:
        if (Intrinsics.areEqual(r7, FileMimeTypeUtils.TextMineTypeAbbr.UNCLEAR.getType()) == false) goto L37;
        if (r9.getFileSuffixes().length() <= 0) goto L35;
        r3 = true;
    L35:
        if (r3 == false) goto L37;
        r7 = r9.getFileSuffixes().toUpperCase(Locale.ROOT);
        goto L37
    L14:
        if (r0 == false) goto L16;
        h19.b r13 = h19.b.a;
        String r14 = r9.getFileSuffixes();
        r13.getClass();
        r5 = h19.b.a(h19.b.d(r14));
        goto L24
    L16:
        HashMap<String, String> r15 = FileMimeTypeUtils.a;
        String r16 = r9.getMimeType();
        String r17 = r9.getFileSuffixes();
        Object r18 = r9.getExt().get("ext_is_bitable_app");
        if ((r18 instanceof Boolean) == false) goto L19;
        Boolean r19 = (Boolean) r18;
    L20:
        if (r19 == null) goto L22;
        boolean r20 = r19.booleanValue();
    L23:
        r5 = FileMimeTypeUtils.b(r16, r17, r20);
        goto L24
    L22:
        r20 = false;
        goto L23
    L19:
        r19 = null;
        goto L20
    }

    public FileResourceViewHolder(ResourceBarConfig r2, LarusFileResourceItemViewBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "viewBinding");
        super(r2, r3);
    }
}
