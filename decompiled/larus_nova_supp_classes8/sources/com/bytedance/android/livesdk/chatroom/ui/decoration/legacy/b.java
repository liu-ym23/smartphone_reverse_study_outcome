package com.bytedance.android.livesdk.chatroom.ui.decoration.legacy;

import android.graphics.Bitmap;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ RoomDecorationListAdapter.e a;

    public final void fail(IHostFrescoHelper.BitmapDataSource r1) {
    }

    public b(RoomDecorationListAdapter.e r1) {
        this.a = r1;
    }

    public final void onNewResultImpl(Bitmap r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.a.a.setImageBitmap(r4.copy(Bitmap.Config.ARGB_8888, false));
        RoomDecorationListAdapter.e r0 = this.a;
        ((RecyclerView.ViewHolder) r0).itemView.setOnClickListener(r0.b);
        ((RecyclerView.ViewHolder) this.a).itemView.setTag(2131389517, Integer.valueOf(r4.getHeight()));
    }
}
