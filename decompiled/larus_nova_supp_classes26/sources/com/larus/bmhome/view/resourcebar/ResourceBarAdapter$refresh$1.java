package com.larus.bmhome.view.resourcebar;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/larus/bmhome/view/resourcebar/ResourceBarAdapter$refresh$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceBarAdapter$refresh$1 extends DiffUtil.Callback {
    public final /* synthetic */ ArrayList<ResourceItemBean> a;
    public final /* synthetic */ ArrayList<ResourceItemBean> b;
    public final /* synthetic */ ResourceBarAdapter c;

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    public final boolean areContentsTheSame(int r2, int r3) {
        return Intrinsics.areEqual(ListProtector.get(this.a, r2), ListProtector.get(this.b, r3));
    }

    public final boolean areItemsTheSame(int r10, int r11) {
        ResourceBarAdapter r0 = this.c;
        ResourceItemBean r1 = (ResourceItemBean) ListProtector.get(this.a, r10);
        ResourceItemBean r2 = (ResourceItemBean) ListProtector.get(this.b, r11);
        int r3 = this.a.size();
        int r4 = this.b.size();
        int r5 = ResourceBarAdapter.e;
        r0.getClass();
        if (r1.getResourceType() != r2.getResourceType()) goto L41;
        String r6 = r1.getKey();
        if ((!StringsKt.isBlank(r6)) == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L14;
        if (Intrinsics.areEqual(r6, r2.getKey()) == false) goto L14;
    L35:
        return true;
    L14:
        if (r1.getResourceType() == ResourceType.ADD) goto L35;
        String r7 = ResourceBarAdapter.y2(r1);
        if ((!StringsKt.isBlank(r7)) == false) goto L22;
        if (Intrinsics.areEqual(r7, ResourceBarAdapter.y2(r2)) == true) goto L35;
    L22:
        if (r0.a.getMode() != Mode.SHOW) goto L37;
        if (r3 != r4) goto L38;
        if (r10 != r11) goto L39;
        ResourceType r12 = r1.getResourceType();
        if (r12 != ResourceType.IMAGE) goto L28;
    L33:
        boolean r13 = true;
    L34:
        if (r13 == true) goto L35;
        return false;
    L28:
        if (r12 == ResourceType.AVATAR) goto L33;
        if (r12 == ResourceType.VIDEO) goto L33;
        r13 = false;
        goto L34
    L39:
        return false;
    L38:
        return false;
    L37:
        return false;
    L41:
        return false;
    }

    public final Object getChangePayload(int r2, int r3) {
        ResourceItemBean r4 = (ResourceItemBean) ListProtector.get(this.a, r2);
        ResourceItemBean r5 = (ResourceItemBean) ListProtector.get(this.b, r3);
        if (r4.equalsExcludeProgress(r5) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(r5.getUpLinkProgress());
    }

    public ResourceBarAdapter$refresh$1(ArrayList<ResourceItemBean> r1, ArrayList<ResourceItemBean> r2, ResourceBarAdapter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
