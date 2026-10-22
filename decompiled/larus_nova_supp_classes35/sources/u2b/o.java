package u2b;

import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.image.entity.Image;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o {
    public static Sticker a(StickerContent r3) {
        Sticker r0 = new Sticker();
        r0.setStickerId(r3.getStickerId());
        r0.setStickerSetId(r3.getStickerSetId());
        r0.setHasPaid(r3.isPaid());
        r0.setDesc(r3.getDescription());
        r0.setMode(Sticker.Mode.STICKER);
        ImageSet r1 = new ImageSet();
        Image r2 = new Image();
        r2.setKey(r3.getKey());
        r1.setOrigin(r2);
        r0.setImageSet(r1);
        return r0;
    }
}
