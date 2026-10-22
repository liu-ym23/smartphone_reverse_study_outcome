package androidx.viewpager2.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    private FragmentViewHolder(FrameLayout r1) {
        super(r1);
    }

    static FragmentViewHolder create(ViewGroup r3) {
        FrameLayout r0 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.setId(ViewCompat.generateViewId());
        r0.setSaveEnabled(false);
        return new FragmentViewHolder(r0);
    }

    FrameLayout getContainer() {
        return (FrameLayout) ZeusTransformUtils.preCheckCast(this.itemView, FrameLayout.class, "com.obric.memorydata.plugin");
    }
}
