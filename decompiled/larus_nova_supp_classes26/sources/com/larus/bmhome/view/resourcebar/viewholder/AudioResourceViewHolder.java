package com.larus.bmhome.view.resourcebar.viewholder;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.chat.common.databinding.LarusFileResourceInspectFailedLayoutBinding;
import com.larus.chat.common.databinding.LarusFileResourceItemViewBinding;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.utils.e1;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/AudioResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/viewholder/EntityResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "viewBinding", "Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;)V", "setContentBackground", "", "data", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "getSuccessBackgroundRes", "", "setContentInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioResourceViewHolder extends EntityResourceViewHolder {
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
    public final void a4(ResourceItemBean r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        super.a4(r3);
        e1.o(this.b.r);
        if (r3.getStatus() != ItemStatus.INSPECT_FAILED) goto L9;
        V3().b();
        LarusFileResourceInspectFailedLayoutBinding r4 = (LarusFileResourceInspectFailedLayoutBinding) V3().c;
        if (r4 == null) goto L17;
        AppCompatTextView r5 = r4.c;
        if (r5 == null) goto L18;
        r5.setText(2131905684);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        this.b.l.setText(r3.getTitle());
        if (r3.getStatus() != ItemStatus.PARSE_FAILED) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r3.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == false) goto L14;
        int r0 = 2131242596;
    L15:
        this.b.m.setImageResource(r0);
        AppCompatTextView r1 = this.b.n;
        HashMap<String, String> r2 = FileMimeTypeUtils.a;
        r1.setText(FileMimeTypeUtils.a(r3.getFileSuffixes()).getType());
        return;
    L14:
        h19.b r6 = h19.b.a;
        CommonFileIconType r7 = CommonFileIconType.AUDIO;
        r6.getClass();
        r0 = h19.b.a(r7);
        goto L15
    }

    public AudioResourceViewHolder(ResourceBarConfig r2, LarusFileResourceItemViewBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "viewBinding");
        super(r2, r3);
    }
}
