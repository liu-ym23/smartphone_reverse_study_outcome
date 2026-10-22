package com.larus.photopicker.v2.impl.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import op9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaPreviewListPagerAdapterV2;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "mediaItems", "", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "submitList", "", "items", "", "getItemCount", "", "createFragment", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaPreviewListPagerAdapterV2 extends FragmentStateAdapter {
    public final List<d> a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaType.values().length];
            r0[MediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public MediaPreviewListPagerAdapterV2(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.a = new ArrayList();
    }

    public final Fragment createFragment(int r4) {
        MediaType r0 = ((d) ListProtector.get(this.a, r4)).a.getType();
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = MediaPreviewImageFragment.k;
        MediaPreviewImageFragment r3 = new MediaPreviewImageFragment();
        Bundle r5 = new Bundle();
        r5.putInt("media_item_position", r4);
        r3.setArguments(r5);
        return r3;
    L5:
        if (r1 != 2) goto L8;
        int r6 = MediaPreviewVideoFragment.l;
        MediaPreviewVideoFragment r7 = new MediaPreviewVideoFragment();
        Bundle r8 = new Bundle();
        r8.putInt("media_item_position", r4);
        r7.setArguments(r8);
        return r7;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
