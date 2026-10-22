package com.bytedance.android.live.emoji.viewholder;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class VSDanmuGifEmojiViewBinder$VSDanmuGifEmojiViewHolder extends RecyclerView.ViewHolder {

    public static final enum ImageLoadStatus extends Enum<ImageLoadStatus> {
        public static final ImageLoadStatus FIRST_TIME_ERROR = null;
        public static final ImageLoadStatus PROCESSING = null;
        public static final ImageLoadStatus RETRY_ERROR = null;
        public static final ImageLoadStatus SUCCESS = null;
        public static final /* synthetic */ ImageLoadStatus[] a = null;

        static {
            ImageLoadStatus r0 = new ImageLoadStatus("FIRST_TIME_ERROR", 0);
            FIRST_TIME_ERROR = r0;
            ImageLoadStatus r1 = new ImageLoadStatus("RETRY_ERROR", 1);
            RETRY_ERROR = r1;
            ImageLoadStatus r3 = new ImageLoadStatus("PROCESSING", 2);
            PROCESSING = r3;
            ImageLoadStatus r5 = new ImageLoadStatus("SUCCESS", 3);
            SUCCESS = r5;
            a = new ImageLoadStatus[]{r0, r1, r3, r5};
        }

        public static ImageLoadStatus[] values() {
            return (ImageLoadStatus[]) a.clone();
        }

        public static ImageLoadStatus valueOf(String r1) {
            return (ImageLoadStatus) r27.a.a(ImageLoadStatus.class, r1);
        }

        public ImageLoadStatus(String r1, int r2) {
            super(r1, r2);
        }
    }
}
