package mo1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter.RoomStickerDecorationImageViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ RoomStickerDecorationImageViewHolder a;

    public final void fail(IHostFrescoHelper.BitmapDataSource r1) {
    }

    public a(RoomStickerDecorationImageViewHolder r1) {
        this.a = r1;
    }

    public final void onNewResultImpl(Bitmap r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ImageView r0 = this.a.a;
        if (r0 == null) goto L7;
        r0.setImageBitmap(r4.copy(Bitmap.Config.ARGB_8888, false));
    L7:
        ((RecyclerView.ViewHolder) this.a).itemView.setTag(2131389517, Integer.valueOf(r4.getHeight()));
    }
}
